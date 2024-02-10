package com.google.android.exoplayer2.source.ads;

import android.os.Handler;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ServerSideInsertedAdsMediaSource extends BaseMediaSource implements MediaSource.MediaSourceCaller, MediaSourceEventListener, DrmSessionEventListener {
    private AdPlaybackState adPlaybackState = AdPlaybackState.NONE;
    private Timeline contentTimeline;
    private final DrmSessionEventListener.EventDispatcher drmEventDispatcherWithoutId = createDrmEventDispatcher((MediaSource.MediaPeriodId) null);
    private SharedMediaPeriod lastUsedMediaPeriod;
    private final ListMultimap<Long, SharedMediaPeriod> mediaPeriods = ArrayListMultimap.create();
    private final MediaSource mediaSource;
    private final MediaSourceEventListener.EventDispatcher mediaSourceEventDispatcherWithoutId = createEventDispatcher((MediaSource.MediaPeriodId) null);
    private Handler playbackHandler;

    public /* synthetic */ void onDrmSessionAcquired(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        DrmSessionEventListener.CC.$default$onDrmSessionAcquired(this, i, mediaPeriodId);
    }

    public ServerSideInsertedAdsMediaSource(MediaSource mediaSource2) {
        this.mediaSource = mediaSource2;
    }

    public void setAdPlaybackState(AdPlaybackState adPlaybackState2) {
        Assertions.checkArgument(adPlaybackState2.adGroupCount >= this.adPlaybackState.adGroupCount);
        for (int i = adPlaybackState2.removedAdGroupCount; i < adPlaybackState2.adGroupCount; i++) {
            AdPlaybackState.AdGroup adGroup = adPlaybackState2.getAdGroup(i);
            Assertions.checkArgument(adGroup.isServerSideInserted);
            if (i < this.adPlaybackState.adGroupCount) {
                Assertions.checkArgument(ServerSideInsertedAdsUtil.getAdCountInGroup(adPlaybackState2, i) >= ServerSideInsertedAdsUtil.getAdCountInGroup(this.adPlaybackState, i));
            }
            if (adGroup.timeUs == Long.MIN_VALUE) {
                Assertions.checkArgument(ServerSideInsertedAdsUtil.getAdCountInGroup(adPlaybackState2, i) == 0);
            }
        }
        synchronized (this) {
            Handler handler = this.playbackHandler;
            if (handler == null) {
                this.adPlaybackState = adPlaybackState2;
            } else {
                handler.post(new ServerSideInsertedAdsMediaSource$$ExternalSyntheticLambda0(this, adPlaybackState2));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setAdPlaybackState$0$com-google-android-exoplayer2-source-ads-ServerSideInsertedAdsMediaSource  reason: not valid java name */
    public /* synthetic */ void m2071lambda$setAdPlaybackState$0$comgoogleandroidexoplayer2sourceadsServerSideInsertedAdsMediaSource(AdPlaybackState adPlaybackState2) {
        for (SharedMediaPeriod updateAdPlaybackState : this.mediaPeriods.values()) {
            updateAdPlaybackState.updateAdPlaybackState(adPlaybackState2);
        }
        SharedMediaPeriod sharedMediaPeriod = this.lastUsedMediaPeriod;
        if (sharedMediaPeriod != null) {
            sharedMediaPeriod.updateAdPlaybackState(adPlaybackState2);
        }
        this.adPlaybackState = adPlaybackState2;
        if (this.contentTimeline != null) {
            refreshSourceInfo(new ServerSideInsertedAdsTimeline(this.contentTimeline, adPlaybackState2));
        }
    }

    public MediaItem getMediaItem() {
        return this.mediaSource.getMediaItem();
    }

    /* access modifiers changed from: protected */
    public void prepareSourceInternal(TransferListener transferListener) {
        Handler createHandlerForCurrentLooper = Util.createHandlerForCurrentLooper();
        synchronized (this) {
            this.playbackHandler = createHandlerForCurrentLooper;
        }
        this.mediaSource.addEventListener(createHandlerForCurrentLooper, this);
        this.mediaSource.addDrmEventListener(createHandlerForCurrentLooper, this);
        this.mediaSource.prepareSource(this, transferListener);
    }

    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.mediaSource.maybeThrowSourceInfoRefreshError();
    }

    /* access modifiers changed from: protected */
    public void enableInternal() {
        this.mediaSource.enable(this);
    }

    /* access modifiers changed from: protected */
    public void disableInternal() {
        releaseLastUsedMediaPeriod();
        this.mediaSource.disable(this);
    }

    public void onSourceInfoRefreshed(MediaSource mediaSource2, Timeline timeline) {
        this.contentTimeline = timeline;
        if (!AdPlaybackState.NONE.equals(this.adPlaybackState)) {
            refreshSourceInfo(new ServerSideInsertedAdsTimeline(timeline, this.adPlaybackState));
        }
    }

    /* access modifiers changed from: protected */
    public void releaseSourceInternal() {
        releaseLastUsedMediaPeriod();
        this.contentTimeline = null;
        synchronized (this) {
            this.playbackHandler = null;
        }
        this.mediaSource.releaseSource(this);
        this.mediaSource.removeEventListener(this);
        this.mediaSource.removeDrmEventListener(this);
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        SharedMediaPeriod sharedMediaPeriod = this.lastUsedMediaPeriod;
        if (sharedMediaPeriod != null) {
            this.lastUsedMediaPeriod = null;
            this.mediaPeriods.put(Long.valueOf(mediaPeriodId.windowSequenceNumber), sharedMediaPeriod);
        } else {
            sharedMediaPeriod = (SharedMediaPeriod) Iterables.getLast(this.mediaPeriods.get(Long.valueOf(mediaPeriodId.windowSequenceNumber)), null);
            if (sharedMediaPeriod == null || !sharedMediaPeriod.canReuseMediaPeriod(mediaPeriodId, j)) {
                sharedMediaPeriod = new SharedMediaPeriod(this.mediaSource.createPeriod(new MediaSource.MediaPeriodId(mediaPeriodId.periodUid, mediaPeriodId.windowSequenceNumber), allocator, ServerSideInsertedAdsUtil.getStreamPositionUs(j, mediaPeriodId, this.adPlaybackState)), this.adPlaybackState);
                this.mediaPeriods.put(Long.valueOf(mediaPeriodId.windowSequenceNumber), sharedMediaPeriod);
            }
        }
        MediaPeriodImpl mediaPeriodImpl = new MediaPeriodImpl(sharedMediaPeriod, mediaPeriodId, createEventDispatcher(mediaPeriodId), createDrmEventDispatcher(mediaPeriodId));
        sharedMediaPeriod.add(mediaPeriodImpl);
        return mediaPeriodImpl;
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        MediaPeriodImpl mediaPeriodImpl = (MediaPeriodImpl) mediaPeriod;
        mediaPeriodImpl.sharedPeriod.remove(mediaPeriodImpl);
        if (mediaPeriodImpl.sharedPeriod.isUnused()) {
            this.mediaPeriods.remove(Long.valueOf(mediaPeriodImpl.mediaPeriodId.windowSequenceNumber), mediaPeriodImpl.sharedPeriod);
            if (this.mediaPeriods.isEmpty()) {
                this.lastUsedMediaPeriod = mediaPeriodImpl.sharedPeriod;
            } else {
                mediaPeriodImpl.sharedPeriod.release(this.mediaSource);
            }
        }
    }

    public void onDrmSessionAcquired(int i, MediaSource.MediaPeriodId mediaPeriodId, int i2) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, (MediaLoadData) null, true);
        if (mediaPeriodForEvent == null) {
            this.drmEventDispatcherWithoutId.drmSessionAcquired(i2);
        } else {
            mediaPeriodForEvent.drmEventDispatcher.drmSessionAcquired(i2);
        }
    }

    public void onDrmKeysLoaded(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, (MediaLoadData) null, false);
        if (mediaPeriodForEvent == null) {
            this.drmEventDispatcherWithoutId.drmKeysLoaded();
        } else {
            mediaPeriodForEvent.drmEventDispatcher.drmKeysLoaded();
        }
    }

    public void onDrmSessionManagerError(int i, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, (MediaLoadData) null, false);
        if (mediaPeriodForEvent == null) {
            this.drmEventDispatcherWithoutId.drmSessionManagerError(exc);
        } else {
            mediaPeriodForEvent.drmEventDispatcher.drmSessionManagerError(exc);
        }
    }

    public void onDrmKeysRestored(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, (MediaLoadData) null, false);
        if (mediaPeriodForEvent == null) {
            this.drmEventDispatcherWithoutId.drmKeysRestored();
        } else {
            mediaPeriodForEvent.drmEventDispatcher.drmKeysRestored();
        }
    }

    public void onDrmKeysRemoved(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, (MediaLoadData) null, false);
        if (mediaPeriodForEvent == null) {
            this.drmEventDispatcherWithoutId.drmKeysRemoved();
        } else {
            mediaPeriodForEvent.drmEventDispatcher.drmKeysRemoved();
        }
    }

    public void onDrmSessionReleased(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, (MediaLoadData) null, false);
        if (mediaPeriodForEvent == null) {
            this.drmEventDispatcherWithoutId.drmSessionReleased();
        } else {
            mediaPeriodForEvent.drmEventDispatcher.drmSessionReleased();
        }
    }

    public void onLoadStarted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, mediaLoadData, true);
        if (mediaPeriodForEvent == null) {
            this.mediaSourceEventDispatcherWithoutId.loadStarted(loadEventInfo, mediaLoadData);
            return;
        }
        mediaPeriodForEvent.sharedPeriod.onLoadStarted(loadEventInfo, mediaLoadData);
        mediaPeriodForEvent.mediaSourceEventDispatcher.loadStarted(loadEventInfo, correctMediaLoadData(mediaPeriodForEvent, mediaLoadData, this.adPlaybackState));
    }

    public void onLoadCompleted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, mediaLoadData, true);
        if (mediaPeriodForEvent == null) {
            this.mediaSourceEventDispatcherWithoutId.loadCompleted(loadEventInfo, mediaLoadData);
            return;
        }
        mediaPeriodForEvent.sharedPeriod.onLoadFinished(loadEventInfo);
        mediaPeriodForEvent.mediaSourceEventDispatcher.loadCompleted(loadEventInfo, correctMediaLoadData(mediaPeriodForEvent, mediaLoadData, this.adPlaybackState));
    }

    public void onLoadCanceled(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, mediaLoadData, true);
        if (mediaPeriodForEvent == null) {
            this.mediaSourceEventDispatcherWithoutId.loadCanceled(loadEventInfo, mediaLoadData);
            return;
        }
        mediaPeriodForEvent.sharedPeriod.onLoadFinished(loadEventInfo);
        mediaPeriodForEvent.mediaSourceEventDispatcher.loadCanceled(loadEventInfo, correctMediaLoadData(mediaPeriodForEvent, mediaLoadData, this.adPlaybackState));
    }

    public void onLoadError(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, mediaLoadData, true);
        if (mediaPeriodForEvent == null) {
            this.mediaSourceEventDispatcherWithoutId.loadError(loadEventInfo, mediaLoadData, iOException, z);
            return;
        }
        if (z) {
            mediaPeriodForEvent.sharedPeriod.onLoadFinished(loadEventInfo);
        }
        mediaPeriodForEvent.mediaSourceEventDispatcher.loadError(loadEventInfo, correctMediaLoadData(mediaPeriodForEvent, mediaLoadData, this.adPlaybackState), iOException, z);
    }

    public void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, mediaLoadData, false);
        if (mediaPeriodForEvent == null) {
            this.mediaSourceEventDispatcherWithoutId.upstreamDiscarded(mediaLoadData);
        } else {
            mediaPeriodForEvent.mediaSourceEventDispatcher.upstreamDiscarded(correctMediaLoadData(mediaPeriodForEvent, mediaLoadData, this.adPlaybackState));
        }
    }

    public void onDownstreamFormatChanged(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        MediaPeriodImpl mediaPeriodForEvent = getMediaPeriodForEvent(mediaPeriodId, mediaLoadData, false);
        if (mediaPeriodForEvent == null) {
            this.mediaSourceEventDispatcherWithoutId.downstreamFormatChanged(mediaLoadData);
            return;
        }
        mediaPeriodForEvent.sharedPeriod.onDownstreamFormatChanged(mediaPeriodForEvent, mediaLoadData);
        mediaPeriodForEvent.mediaSourceEventDispatcher.downstreamFormatChanged(correctMediaLoadData(mediaPeriodForEvent, mediaLoadData, this.adPlaybackState));
    }

    private void releaseLastUsedMediaPeriod() {
        SharedMediaPeriod sharedMediaPeriod = this.lastUsedMediaPeriod;
        if (sharedMediaPeriod != null) {
            sharedMediaPeriod.release(this.mediaSource);
            this.lastUsedMediaPeriod = null;
        }
    }

    private MediaPeriodImpl getMediaPeriodForEvent(MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData, boolean z) {
        if (mediaPeriodId == null) {
            return null;
        }
        List<SharedMediaPeriod> list = this.mediaPeriods.get(Long.valueOf(mediaPeriodId.windowSequenceNumber));
        if (list.isEmpty()) {
            return null;
        }
        if (z) {
            SharedMediaPeriod sharedMediaPeriod = (SharedMediaPeriod) Iterables.getLast(list);
            if (sharedMediaPeriod.loadingPeriod != null) {
                return sharedMediaPeriod.loadingPeriod;
            }
            return (MediaPeriodImpl) Iterables.getLast(sharedMediaPeriod.mediaPeriods);
        }
        for (int i = 0; i < list.size(); i++) {
            MediaPeriodImpl mediaPeriodForEvent = list.get(i).getMediaPeriodForEvent(mediaLoadData);
            if (mediaPeriodForEvent != null) {
                return mediaPeriodForEvent;
            }
        }
        return (MediaPeriodImpl) list.get(0).mediaPeriods.get(0);
    }

    /* access modifiers changed from: private */
    public static long getMediaPeriodEndPositionUs(MediaPeriodImpl mediaPeriodImpl, AdPlaybackState adPlaybackState2) {
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodImpl.mediaPeriodId;
        if (mediaPeriodId.isAd()) {
            AdPlaybackState.AdGroup adGroup = adPlaybackState2.getAdGroup(mediaPeriodId.adGroupIndex);
            if (adGroup.count == -1) {
                return 0;
            }
            return adGroup.durationsUs[mediaPeriodId.adIndexInAdGroup];
        } else if (mediaPeriodId.nextAdGroupIndex == -1) {
            return Long.MAX_VALUE;
        } else {
            AdPlaybackState.AdGroup adGroup2 = adPlaybackState2.getAdGroup(mediaPeriodId.nextAdGroupIndex);
            if (adGroup2.timeUs == Long.MIN_VALUE) {
                return Long.MAX_VALUE;
            }
            return adGroup2.timeUs;
        }
    }

    /* access modifiers changed from: private */
    public static MediaLoadData correctMediaLoadData(MediaPeriodImpl mediaPeriodImpl, MediaLoadData mediaLoadData, AdPlaybackState adPlaybackState2) {
        return new MediaLoadData(mediaLoadData.dataType, mediaLoadData.trackType, mediaLoadData.trackFormat, mediaLoadData.trackSelectionReason, mediaLoadData.trackSelectionData, correctMediaLoadDataPositionMs(mediaLoadData.mediaStartTimeMs, mediaPeriodImpl, adPlaybackState2), correctMediaLoadDataPositionMs(mediaLoadData.mediaEndTimeMs, mediaPeriodImpl, adPlaybackState2));
    }

    private static long correctMediaLoadDataPositionMs(long j, MediaPeriodImpl mediaPeriodImpl, AdPlaybackState adPlaybackState2) {
        long j2;
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long msToUs = C.msToUs(j);
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodImpl.mediaPeriodId;
        if (mediaPeriodId.isAd()) {
            j2 = ServerSideInsertedAdsUtil.getMediaPeriodPositionUsForAd(msToUs, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, adPlaybackState2);
        } else {
            j2 = ServerSideInsertedAdsUtil.getMediaPeriodPositionUsForContent(msToUs, -1, adPlaybackState2);
        }
        return C.usToMs(j2);
    }

    private static final class SharedMediaPeriod implements MediaPeriod.Callback {
        private final Map<Long, Pair<LoadEventInfo, MediaLoadData>> activeLoads = new HashMap();
        private final MediaPeriod actualMediaPeriod;
        private AdPlaybackState adPlaybackState;
        private boolean hasStartedPreparing;
        private boolean isPrepared;
        public MediaLoadData[] lastDownstreamFormatChangeData = new MediaLoadData[0];
        /* access modifiers changed from: private */
        public MediaPeriodImpl loadingPeriod;
        /* access modifiers changed from: private */
        public final List<MediaPeriodImpl> mediaPeriods = new ArrayList();
        public SampleStream[] sampleStreams = new SampleStream[0];
        public ExoTrackSelection[] trackSelections = new ExoTrackSelection[0];

        public SharedMediaPeriod(MediaPeriod mediaPeriod, AdPlaybackState adPlaybackState2) {
            this.actualMediaPeriod = mediaPeriod;
            this.adPlaybackState = adPlaybackState2;
        }

        public void updateAdPlaybackState(AdPlaybackState adPlaybackState2) {
            this.adPlaybackState = adPlaybackState2;
        }

        public void add(MediaPeriodImpl mediaPeriodImpl) {
            this.mediaPeriods.add(mediaPeriodImpl);
        }

        public void remove(MediaPeriodImpl mediaPeriodImpl) {
            if (mediaPeriodImpl.equals(this.loadingPeriod)) {
                this.loadingPeriod = null;
                this.activeLoads.clear();
            }
            this.mediaPeriods.remove(mediaPeriodImpl);
        }

        public boolean isUnused() {
            return this.mediaPeriods.isEmpty();
        }

        public void release(MediaSource mediaSource) {
            mediaSource.releasePeriod(this.actualMediaPeriod);
        }

        public boolean canReuseMediaPeriod(MediaSource.MediaPeriodId mediaPeriodId, long j) {
            MediaPeriodImpl mediaPeriodImpl = (MediaPeriodImpl) Iterables.getLast(this.mediaPeriods);
            return ServerSideInsertedAdsUtil.getStreamPositionUs(j, mediaPeriodId, this.adPlaybackState) == ServerSideInsertedAdsUtil.getStreamPositionUs(ServerSideInsertedAdsMediaSource.getMediaPeriodEndPositionUs(mediaPeriodImpl, this.adPlaybackState), mediaPeriodImpl.mediaPeriodId, this.adPlaybackState);
        }

        public MediaPeriodImpl getMediaPeriodForEvent(MediaLoadData mediaLoadData) {
            if (mediaLoadData == null || mediaLoadData.mediaStartTimeMs == -9223372036854775807L) {
                return null;
            }
            for (int i = 0; i < this.mediaPeriods.size(); i++) {
                MediaPeriodImpl mediaPeriodImpl = this.mediaPeriods.get(i);
                long mediaPeriodPositionUs = ServerSideInsertedAdsUtil.getMediaPeriodPositionUs(C.msToUs(mediaLoadData.mediaStartTimeMs), mediaPeriodImpl.mediaPeriodId, this.adPlaybackState);
                long access$200 = ServerSideInsertedAdsMediaSource.getMediaPeriodEndPositionUs(mediaPeriodImpl, this.adPlaybackState);
                if (mediaPeriodPositionUs >= 0 && mediaPeriodPositionUs < access$200) {
                    return mediaPeriodImpl;
                }
            }
            return null;
        }

        public void prepare(MediaPeriodImpl mediaPeriodImpl, long j) {
            mediaPeriodImpl.lastStartPositionUs = j;
            if (!this.hasStartedPreparing) {
                this.hasStartedPreparing = true;
                this.actualMediaPeriod.prepare(this, ServerSideInsertedAdsUtil.getStreamPositionUs(j, mediaPeriodImpl.mediaPeriodId, this.adPlaybackState));
            } else if (this.isPrepared) {
                ((MediaPeriod.Callback) Assertions.checkNotNull(mediaPeriodImpl.callback)).onPrepared(mediaPeriodImpl);
            }
        }

        public void maybeThrowPrepareError() throws IOException {
            this.actualMediaPeriod.maybeThrowPrepareError();
        }

        public TrackGroupArray getTrackGroups() {
            return this.actualMediaPeriod.getTrackGroups();
        }

        public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
            return this.actualMediaPeriod.getStreamKeys(list);
        }

        public boolean continueLoading(MediaPeriodImpl mediaPeriodImpl, long j) {
            MediaPeriodImpl mediaPeriodImpl2 = this.loadingPeriod;
            if (mediaPeriodImpl2 != null && !mediaPeriodImpl.equals(mediaPeriodImpl2)) {
                for (Pair next : this.activeLoads.values()) {
                    mediaPeriodImpl2.mediaSourceEventDispatcher.loadCompleted((LoadEventInfo) next.first, ServerSideInsertedAdsMediaSource.correctMediaLoadData(mediaPeriodImpl2, (MediaLoadData) next.second, this.adPlaybackState));
                    mediaPeriodImpl.mediaSourceEventDispatcher.loadStarted((LoadEventInfo) next.first, ServerSideInsertedAdsMediaSource.correctMediaLoadData(mediaPeriodImpl, (MediaLoadData) next.second, this.adPlaybackState));
                }
            }
            this.loadingPeriod = mediaPeriodImpl;
            return this.actualMediaPeriod.continueLoading(getStreamPositionUsWithNotYetStartedHandling(mediaPeriodImpl, j));
        }

        public boolean isLoading(MediaPeriodImpl mediaPeriodImpl) {
            return mediaPeriodImpl.equals(this.loadingPeriod) && this.actualMediaPeriod.isLoading();
        }

        public long getBufferedPositionUs(MediaPeriodImpl mediaPeriodImpl) {
            return getMediaPeriodPositionUsWithEndOfSourceHandling(mediaPeriodImpl, this.actualMediaPeriod.getBufferedPositionUs());
        }

        public long getNextLoadPositionUs(MediaPeriodImpl mediaPeriodImpl) {
            return getMediaPeriodPositionUsWithEndOfSourceHandling(mediaPeriodImpl, this.actualMediaPeriod.getNextLoadPositionUs());
        }

        public long seekToUs(MediaPeriodImpl mediaPeriodImpl, long j) {
            return ServerSideInsertedAdsUtil.getMediaPeriodPositionUs(this.actualMediaPeriod.seekToUs(ServerSideInsertedAdsUtil.getStreamPositionUs(j, mediaPeriodImpl.mediaPeriodId, this.adPlaybackState)), mediaPeriodImpl.mediaPeriodId, this.adPlaybackState);
        }

        public long getAdjustedSeekPositionUs(MediaPeriodImpl mediaPeriodImpl, long j, SeekParameters seekParameters) {
            return ServerSideInsertedAdsUtil.getMediaPeriodPositionUs(this.actualMediaPeriod.getAdjustedSeekPositionUs(ServerSideInsertedAdsUtil.getStreamPositionUs(j, mediaPeriodImpl.mediaPeriodId, this.adPlaybackState), seekParameters), mediaPeriodImpl.mediaPeriodId, this.adPlaybackState);
        }

        public void discardBuffer(MediaPeriodImpl mediaPeriodImpl, long j, boolean z) {
            this.actualMediaPeriod.discardBuffer(ServerSideInsertedAdsUtil.getStreamPositionUs(j, mediaPeriodImpl.mediaPeriodId, this.adPlaybackState), z);
        }

        public void reevaluateBuffer(MediaPeriodImpl mediaPeriodImpl, long j) {
            this.actualMediaPeriod.reevaluateBuffer(getStreamPositionUsWithNotYetStartedHandling(mediaPeriodImpl, j));
        }

        public long readDiscontinuity(MediaPeriodImpl mediaPeriodImpl) {
            if (!mediaPeriodImpl.equals(this.mediaPeriods.get(0))) {
                return -9223372036854775807L;
            }
            long readDiscontinuity = this.actualMediaPeriod.readDiscontinuity();
            if (readDiscontinuity == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return ServerSideInsertedAdsUtil.getMediaPeriodPositionUs(readDiscontinuity, mediaPeriodImpl.mediaPeriodId, this.adPlaybackState);
        }

        public long selectTracks(MediaPeriodImpl mediaPeriodImpl, ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
            SampleStream sampleStream;
            SampleStream[] sampleStreamArr2;
            MediaPeriodImpl mediaPeriodImpl2 = mediaPeriodImpl;
            ExoTrackSelection[] exoTrackSelectionArr2 = exoTrackSelectionArr;
            long j2 = j;
            mediaPeriodImpl2.lastStartPositionUs = j2;
            if (mediaPeriodImpl.equals(this.mediaPeriods.get(0))) {
                this.trackSelections = (ExoTrackSelection[]) Arrays.copyOf(exoTrackSelectionArr, exoTrackSelectionArr2.length);
                long streamPositionUs = ServerSideInsertedAdsUtil.getStreamPositionUs(j2, mediaPeriodImpl2.mediaPeriodId, this.adPlaybackState);
                SampleStream[] sampleStreamArr3 = this.sampleStreams;
                if (sampleStreamArr3.length == 0) {
                    sampleStreamArr2 = new SampleStream[exoTrackSelectionArr2.length];
                } else {
                    sampleStreamArr2 = (SampleStream[]) Arrays.copyOf(sampleStreamArr3, sampleStreamArr3.length);
                }
                SampleStream[] sampleStreamArr4 = sampleStreamArr2;
                long selectTracks = this.actualMediaPeriod.selectTracks(exoTrackSelectionArr, zArr, sampleStreamArr4, zArr2, streamPositionUs);
                this.sampleStreams = (SampleStream[]) Arrays.copyOf(sampleStreamArr4, sampleStreamArr4.length);
                this.lastDownstreamFormatChangeData = (MediaLoadData[]) Arrays.copyOf(this.lastDownstreamFormatChangeData, sampleStreamArr4.length);
                for (int i = 0; i < sampleStreamArr4.length; i++) {
                    if (sampleStreamArr4[i] == null) {
                        sampleStreamArr[i] = null;
                        this.lastDownstreamFormatChangeData[i] = null;
                    } else if (sampleStreamArr[i] == null || zArr2[i]) {
                        sampleStreamArr[i] = new SampleStreamImpl(mediaPeriodImpl, i);
                        this.lastDownstreamFormatChangeData[i] = null;
                    }
                }
                return ServerSideInsertedAdsUtil.getMediaPeriodPositionUs(selectTracks, mediaPeriodImpl2.mediaPeriodId, this.adPlaybackState);
            }
            for (int i2 = 0; i2 < exoTrackSelectionArr2.length; i2++) {
                ExoTrackSelection exoTrackSelection = exoTrackSelectionArr2[i2];
                boolean z = true;
                if (exoTrackSelection != null) {
                    if (zArr[i2] && sampleStreamArr[i2] != null) {
                        z = false;
                    }
                    zArr2[i2] = z;
                    if (z) {
                        if (Util.areEqual(this.trackSelections[i2], exoTrackSelection)) {
                            sampleStream = new SampleStreamImpl(mediaPeriodImpl, i2);
                        } else {
                            sampleStream = new EmptySampleStream();
                        }
                        sampleStreamArr[i2] = sampleStream;
                    }
                } else {
                    sampleStreamArr[i2] = null;
                    zArr2[i2] = true;
                }
            }
            return j2;
        }

        public int readData(MediaPeriodImpl mediaPeriodImpl, int i, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            int readData = ((SampleStream) Util.castNonNull(this.sampleStreams[i])).readData(formatHolder, decoderInputBuffer, i2 | 1 | 4);
            long mediaPeriodPositionUsWithEndOfSourceHandling = getMediaPeriodPositionUsWithEndOfSourceHandling(mediaPeriodImpl, decoderInputBuffer.timeUs);
            if ((readData == -4 && mediaPeriodPositionUsWithEndOfSourceHandling == Long.MIN_VALUE) || (readData == -3 && getBufferedPositionUs(mediaPeriodImpl) == Long.MIN_VALUE && !decoderInputBuffer.waitingForKeys)) {
                maybeNotifyDownstreamFormatChanged(mediaPeriodImpl, i);
                decoderInputBuffer.clear();
                decoderInputBuffer.addFlag(4);
                return -4;
            }
            if (readData == -4) {
                maybeNotifyDownstreamFormatChanged(mediaPeriodImpl, i);
                ((SampleStream) Util.castNonNull(this.sampleStreams[i])).readData(formatHolder, decoderInputBuffer, i2);
                decoderInputBuffer.timeUs = mediaPeriodPositionUsWithEndOfSourceHandling;
            }
            return readData;
        }

        public int skipData(MediaPeriodImpl mediaPeriodImpl, int i, long j) {
            return ((SampleStream) Util.castNonNull(this.sampleStreams[i])).skipData(ServerSideInsertedAdsUtil.getStreamPositionUs(j, mediaPeriodImpl.mediaPeriodId, this.adPlaybackState));
        }

        public boolean isReady(int i) {
            return ((SampleStream) Util.castNonNull(this.sampleStreams[i])).isReady();
        }

        public void maybeThrowError(int i) throws IOException {
            ((SampleStream) Util.castNonNull(this.sampleStreams[i])).maybeThrowError();
        }

        public void onDownstreamFormatChanged(MediaPeriodImpl mediaPeriodImpl, MediaLoadData mediaLoadData) {
            int findMatchingStreamIndex = findMatchingStreamIndex(mediaLoadData);
            if (findMatchingStreamIndex != -1) {
                this.lastDownstreamFormatChangeData[findMatchingStreamIndex] = mediaLoadData;
                mediaPeriodImpl.hasNotifiedDownstreamFormatChange[findMatchingStreamIndex] = true;
            }
        }

        public void onLoadStarted(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            this.activeLoads.put(Long.valueOf(loadEventInfo.loadTaskId), Pair.create(loadEventInfo, mediaLoadData));
        }

        public void onLoadFinished(LoadEventInfo loadEventInfo) {
            this.activeLoads.remove(Long.valueOf(loadEventInfo.loadTaskId));
        }

        public void onPrepared(MediaPeriod mediaPeriod) {
            this.isPrepared = true;
            for (int i = 0; i < this.mediaPeriods.size(); i++) {
                MediaPeriodImpl mediaPeriodImpl = this.mediaPeriods.get(i);
                if (mediaPeriodImpl.callback != null) {
                    mediaPeriodImpl.callback.onPrepared(mediaPeriodImpl);
                }
            }
        }

        public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
            MediaPeriodImpl mediaPeriodImpl = this.loadingPeriod;
            if (mediaPeriodImpl != null) {
                ((MediaPeriod.Callback) Assertions.checkNotNull(mediaPeriodImpl.callback)).onContinueLoadingRequested(this.loadingPeriod);
            }
        }

        private long getStreamPositionUsWithNotYetStartedHandling(MediaPeriodImpl mediaPeriodImpl, long j) {
            if (j < mediaPeriodImpl.lastStartPositionUs) {
                return ServerSideInsertedAdsUtil.getStreamPositionUs(mediaPeriodImpl.lastStartPositionUs, mediaPeriodImpl.mediaPeriodId, this.adPlaybackState) - (mediaPeriodImpl.lastStartPositionUs - j);
            }
            return ServerSideInsertedAdsUtil.getStreamPositionUs(j, mediaPeriodImpl.mediaPeriodId, this.adPlaybackState);
        }

        private long getMediaPeriodPositionUsWithEndOfSourceHandling(MediaPeriodImpl mediaPeriodImpl, long j) {
            if (j == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            long mediaPeriodPositionUs = ServerSideInsertedAdsUtil.getMediaPeriodPositionUs(j, mediaPeriodImpl.mediaPeriodId, this.adPlaybackState);
            if (mediaPeriodPositionUs >= ServerSideInsertedAdsMediaSource.getMediaPeriodEndPositionUs(mediaPeriodImpl, this.adPlaybackState)) {
                return Long.MIN_VALUE;
            }
            return mediaPeriodPositionUs;
        }

        private int findMatchingStreamIndex(MediaLoadData mediaLoadData) {
            if (mediaLoadData.trackFormat == null) {
                return -1;
            }
            int i = 0;
            loop0:
            while (true) {
                ExoTrackSelection[] exoTrackSelectionArr = this.trackSelections;
                if (i >= exoTrackSelectionArr.length) {
                    return -1;
                }
                ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i];
                if (exoTrackSelection != null) {
                    TrackGroup trackGroup = exoTrackSelection.getTrackGroup();
                    boolean z = mediaLoadData.trackType == 0 && trackGroup.equals(getTrackGroups().get(0));
                    for (int i2 = 0; i2 < trackGroup.length; i2++) {
                        Format format = trackGroup.getFormat(i2);
                        if (format.equals(mediaLoadData.trackFormat) || (z && format.id != null && format.id.equals(mediaLoadData.trackFormat.id))) {
                            return i;
                        }
                    }
                    continue;
                }
                i++;
            }
            return i;
        }

        private void maybeNotifyDownstreamFormatChanged(MediaPeriodImpl mediaPeriodImpl, int i) {
            if (!mediaPeriodImpl.hasNotifiedDownstreamFormatChange[i] && this.lastDownstreamFormatChangeData[i] != null) {
                mediaPeriodImpl.hasNotifiedDownstreamFormatChange[i] = true;
                mediaPeriodImpl.mediaSourceEventDispatcher.downstreamFormatChanged(ServerSideInsertedAdsMediaSource.correctMediaLoadData(mediaPeriodImpl, this.lastDownstreamFormatChangeData[i], this.adPlaybackState));
            }
        }
    }

    private static final class ServerSideInsertedAdsTimeline extends ForwardingTimeline {
        private final AdPlaybackState adPlaybackState;

        public ServerSideInsertedAdsTimeline(Timeline timeline, AdPlaybackState adPlaybackState2) {
            super(timeline);
            boolean z = false;
            Assertions.checkState(timeline.getPeriodCount() == 1);
            Assertions.checkState(timeline.getWindowCount() == 1 ? true : z);
            this.adPlaybackState = adPlaybackState2;
        }

        public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            super.getWindow(i, window, j);
            long mediaPeriodPositionUsForContent = ServerSideInsertedAdsUtil.getMediaPeriodPositionUsForContent(window.positionInFirstPeriodUs, -1, this.adPlaybackState);
            if (window.durationUs != -9223372036854775807L) {
                window.durationUs = ServerSideInsertedAdsUtil.getMediaPeriodPositionUsForContent(window.positionInFirstPeriodUs + window.durationUs, -1, this.adPlaybackState) - mediaPeriodPositionUsForContent;
            } else if (this.adPlaybackState.contentDurationUs != -9223372036854775807L) {
                window.durationUs = this.adPlaybackState.contentDurationUs - mediaPeriodPositionUsForContent;
            }
            window.positionInFirstPeriodUs = mediaPeriodPositionUsForContent;
            return window;
        }

        public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            long j;
            super.getPeriod(i, period, z);
            long j2 = period.durationUs;
            if (j2 == -9223372036854775807L) {
                j = this.adPlaybackState.contentDurationUs;
            } else {
                j = ServerSideInsertedAdsUtil.getMediaPeriodPositionUsForContent(j2, -1, this.adPlaybackState);
            }
            Timeline.Period period2 = period;
            period2.set(period.id, period.uid, period.windowIndex, j, -ServerSideInsertedAdsUtil.getMediaPeriodPositionUsForContent(-period.getPositionInWindowUs(), -1, this.adPlaybackState), this.adPlaybackState, period.isPlaceholder);
            return period;
        }
    }

    private static final class MediaPeriodImpl implements MediaPeriod {
        public MediaPeriod.Callback callback;
        public final DrmSessionEventListener.EventDispatcher drmEventDispatcher;
        public boolean[] hasNotifiedDownstreamFormatChange = new boolean[0];
        public long lastStartPositionUs;
        public final MediaSource.MediaPeriodId mediaPeriodId;
        public final MediaSourceEventListener.EventDispatcher mediaSourceEventDispatcher;
        public final SharedMediaPeriod sharedPeriod;

        public MediaPeriodImpl(SharedMediaPeriod sharedMediaPeriod, MediaSource.MediaPeriodId mediaPeriodId2, MediaSourceEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener.EventDispatcher eventDispatcher2) {
            this.sharedPeriod = sharedMediaPeriod;
            this.mediaPeriodId = mediaPeriodId2;
            this.mediaSourceEventDispatcher = eventDispatcher;
            this.drmEventDispatcher = eventDispatcher2;
        }

        public void prepare(MediaPeriod.Callback callback2, long j) {
            this.callback = callback2;
            this.sharedPeriod.prepare(this, j);
        }

        public void maybeThrowPrepareError() throws IOException {
            this.sharedPeriod.maybeThrowPrepareError();
        }

        public TrackGroupArray getTrackGroups() {
            return this.sharedPeriod.getTrackGroups();
        }

        public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
            return this.sharedPeriod.getStreamKeys(list);
        }

        public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
            if (this.hasNotifiedDownstreamFormatChange.length == 0) {
                this.hasNotifiedDownstreamFormatChange = new boolean[sampleStreamArr.length];
            }
            return this.sharedPeriod.selectTracks(this, exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j);
        }

        public void discardBuffer(long j, boolean z) {
            this.sharedPeriod.discardBuffer(this, j, z);
        }

        public long readDiscontinuity() {
            return this.sharedPeriod.readDiscontinuity(this);
        }

        public long seekToUs(long j) {
            return this.sharedPeriod.seekToUs(this, j);
        }

        public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
            return this.sharedPeriod.getAdjustedSeekPositionUs(this, j, seekParameters);
        }

        public long getBufferedPositionUs() {
            return this.sharedPeriod.getBufferedPositionUs(this);
        }

        public long getNextLoadPositionUs() {
            return this.sharedPeriod.getNextLoadPositionUs(this);
        }

        public boolean continueLoading(long j) {
            return this.sharedPeriod.continueLoading(this, j);
        }

        public boolean isLoading() {
            return this.sharedPeriod.isLoading(this);
        }

        public void reevaluateBuffer(long j) {
            this.sharedPeriod.reevaluateBuffer(this, j);
        }
    }

    private static final class SampleStreamImpl implements SampleStream {
        private final MediaPeriodImpl mediaPeriod;
        private final int streamIndex;

        public SampleStreamImpl(MediaPeriodImpl mediaPeriodImpl, int i) {
            this.mediaPeriod = mediaPeriodImpl;
            this.streamIndex = i;
        }

        public boolean isReady() {
            return this.mediaPeriod.sharedPeriod.isReady(this.streamIndex);
        }

        public void maybeThrowError() throws IOException {
            this.mediaPeriod.sharedPeriod.maybeThrowError(this.streamIndex);
        }

        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
            return this.mediaPeriod.sharedPeriod.readData(this.mediaPeriod, this.streamIndex, formatHolder, decoderInputBuffer, i);
        }

        public int skipData(long j) {
            return this.mediaPeriod.sharedPeriod.skipData(this.mediaPeriod, this.streamIndex, j);
        }
    }
}
