package androidx.media3.exoplayer.ima;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.ViewGroup;
import androidx.media3.common.AdOverlayInfo;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Bundleable;
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.ima.ImaUtil;
import androidx.media3.exoplayer.source.CompositeMediaSource;
import androidx.media3.exoplayer.source.ForwardingTimeline;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ads.ServerSideAdInsertionMediaSource;
import androidx.media3.exoplayer.source.ads.ServerSideAdInsertionUtil;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.extractor.metadata.emsg.EventMessage;
import androidx.media3.extractor.metadata.id3.TextInformationFrame;
import com.google.ads.interactivemedia.v3.api.Ad;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.AdPodInfo;
import com.google.ads.interactivemedia.v3.api.AdsLoader;
import com.google.ads.interactivemedia.v3.api.AdsManagerLoadedEvent;
import com.google.ads.interactivemedia.v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.api.CuePoint;
import com.google.ads.interactivemedia.v3.api.ImaSdkFactory;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.v3.api.StreamManager;
import com.google.ads.interactivemedia.v3.api.StreamRequest;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class ImaServerSideAdInsertionMediaSource extends CompositeMediaSource<Void> {
    private static final String TAG = "ImaSSAIMediaSource";
    /* access modifiers changed from: private */
    public AdPlaybackState adPlaybackState;
    /* access modifiers changed from: private */
    public final String adsId;
    private final AdsLoader adsLoader;
    private final AdErrorEvent.AdErrorListener applicationAdErrorListener;
    private final AdEvent.AdEventListener applicationAdEventListener;
    private final ComponentListener componentListener;
    private final MediaSource.Factory contentMediaSourceFactory;
    /* access modifiers changed from: private */
    public Timeline contentTimeline;
    /* access modifiers changed from: private */
    public final boolean isLiveStream;
    /* access modifiers changed from: private */
    public IOException loadError;
    private final int loadVideoTimeoutMs;
    private Loader loader;
    /* access modifiers changed from: private */
    public final Handler mainHandler;
    /* access modifiers changed from: private */
    public final MediaItem mediaItem;
    /* access modifiers changed from: private */
    public final Player player;
    private final com.google.ads.interactivemedia.v3.api.AdsLoader sdkAdsLoader;
    private ServerSideAdInsertionMediaSource serverSideAdInsertionMediaSource;
    /* access modifiers changed from: private */
    public StreamManager streamManager;
    /* access modifiers changed from: private */
    public final StreamPlayer streamPlayer;
    /* access modifiers changed from: private */
    public final StreamRequest streamRequest;

    public static final class Factory implements MediaSource.Factory {
        private final AdsLoader adsLoader;
        private final MediaSource.Factory contentMediaSourceFactory;

        public /* synthetic */ MediaSource.Factory setCmcdConfigurationFactory(CmcdConfiguration.Factory factory) {
            return MediaSource.Factory.CC.$default$setCmcdConfigurationFactory(this, factory);
        }

        public Factory(AdsLoader adsLoader2, MediaSource.Factory factory) {
            this.adsLoader = adsLoader2;
            this.contentMediaSourceFactory = factory;
        }

        public MediaSource.Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.contentMediaSourceFactory.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy);
            return this;
        }

        public MediaSource.Factory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.contentMediaSourceFactory.setDrmSessionManagerProvider(drmSessionManagerProvider);
            return this;
        }

        public int[] getSupportedTypes() {
            return this.contentMediaSourceFactory.getSupportedTypes();
        }

        public MediaSource createMediaSource(MediaItem mediaItem) {
            Assertions.checkNotNull(mediaItem.localConfiguration);
            Player player = (Player) Assertions.checkNotNull(this.adsLoader.player);
            StreamRequest createStreamRequest = ImaServerSideAdInsertionUriBuilder.createStreamRequest(((MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem.localConfiguration)).uri);
            StreamPlayer streamPlayer = new StreamPlayer(player, mediaItem, createStreamRequest);
            ImaSdkFactory instance = ImaSdkFactory.getInstance();
            com.google.ads.interactivemedia.v3.api.AdsLoader createAdsLoader = instance.createAdsLoader(this.adsLoader.context, this.adsLoader.configuration.imaSdkSettings, ImaServerSideAdInsertionMediaSource.createStreamDisplayContainer(instance, this.adsLoader.configuration, streamPlayer));
            AdsLoader adsLoader2 = this.adsLoader;
            ImaServerSideAdInsertionMediaSource imaServerSideAdInsertionMediaSource = new ImaServerSideAdInsertionMediaSource(player, mediaItem, createStreamRequest, adsLoader2, createAdsLoader, streamPlayer, this.contentMediaSourceFactory, adsLoader2.configuration.applicationAdEventListener, this.adsLoader.configuration.applicationAdErrorListener);
            this.adsLoader.addMediaSourceResources(imaServerSideAdInsertionMediaSource, streamPlayer, createAdsLoader);
            return imaServerSideAdInsertionMediaSource;
        }
    }

    public static final class AdsLoader {
        private final Map<String, AdPlaybackState> adPlaybackStateMap;
        /* access modifiers changed from: private */
        public final ImaUtil.ServerSideAdInsertionConfiguration configuration;
        /* access modifiers changed from: private */
        public final Context context;
        private final Map<String, MediaSourceResourceHolder> mediaSourceResources;
        /* access modifiers changed from: private */
        public Player player;

        public static final class Builder {
            private AdErrorEvent.AdErrorListener adErrorListener;
            private AdEvent.AdEventListener adEventListener;
            private final AdViewProvider adViewProvider;
            private ImmutableList<CompanionAdSlot> companionAdSlots = ImmutableList.of();
            private final Context context;
            private boolean focusSkipButtonWhenAvailable = true;
            private ImaSdkSettings imaSdkSettings;
            private State state = new State(ImmutableMap.of());

            public Builder(Context context2, AdViewProvider adViewProvider2) {
                this.context = context2;
                this.adViewProvider = adViewProvider2;
            }

            public Builder setImaSdkSettings(ImaSdkSettings imaSdkSettings2) {
                this.imaSdkSettings = imaSdkSettings2;
                return this;
            }

            public Builder setAdEventListener(AdEvent.AdEventListener adEventListener2) {
                this.adEventListener = adEventListener2;
                return this;
            }

            public Builder setAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener2) {
                this.adErrorListener = adErrorListener2;
                return this;
            }

            public Builder setCompanionAdSlots(Collection<CompanionAdSlot> collection) {
                this.companionAdSlots = ImmutableList.copyOf(collection);
                return this;
            }

            public Builder setAdsLoaderState(State state2) {
                this.state = state2;
                return this;
            }

            public Builder setFocusSkipButtonWhenAvailable(boolean z) {
                this.focusSkipButtonWhenAvailable = z;
                return this;
            }

            public AdsLoader build() {
                ImaSdkSettings imaSdkSettings2 = this.imaSdkSettings;
                if (imaSdkSettings2 == null) {
                    imaSdkSettings2 = ImaSdkFactory.getInstance().createImaSdkSettings();
                    imaSdkSettings2.setLanguage(Util.getSystemLanguageCodes()[0]);
                }
                ImaSdkSettings imaSdkSettings3 = imaSdkSettings2;
                return new AdsLoader(this.context, new ImaUtil.ServerSideAdInsertionConfiguration(this.adViewProvider, imaSdkSettings3, this.adEventListener, this.adErrorListener, this.companionAdSlots, this.focusSkipButtonWhenAvailable, imaSdkSettings3.isDebugMode()), this.state);
            }
        }

        public static class State implements Bundleable {
            public static final Bundleable.Creator<State> CREATOR = new ImaServerSideAdInsertionMediaSource$AdsLoader$State$$ExternalSyntheticLambda0();
            private static final String FIELD_AD_PLAYBACK_STATES = Util.intToStringMaxRadix(1);
            /* access modifiers changed from: private */
            public final ImmutableMap<String, AdPlaybackState> adPlaybackStates;

            State(ImmutableMap<String, AdPlaybackState> immutableMap) {
                this.adPlaybackStates = immutableMap;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof State)) {
                    return false;
                }
                return this.adPlaybackStates.equals(((State) obj).adPlaybackStates);
            }

            public int hashCode() {
                return this.adPlaybackStates.hashCode();
            }

            public Bundle toBundle() {
                Bundle bundle = new Bundle();
                Bundle bundle2 = new Bundle();
                UnmodifiableIterator<Map.Entry<String, AdPlaybackState>> it = this.adPlaybackStates.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry next = it.next();
                    bundle2.putBundle((String) next.getKey(), ((AdPlaybackState) next.getValue()).toBundle());
                }
                bundle.putBundle(FIELD_AD_PLAYBACK_STATES, bundle2);
                return bundle;
            }

            /* access modifiers changed from: private */
            public static State fromBundle(Bundle bundle) {
                ImmutableMap.Builder builder = new ImmutableMap.Builder();
                Bundle bundle2 = (Bundle) Assertions.checkNotNull(bundle.getBundle(FIELD_AD_PLAYBACK_STATES));
                for (String str : bundle2.keySet()) {
                    builder.put(str, AdPlaybackState.fromAdPlaybackState(str, AdPlaybackState.CREATOR.fromBundle((Bundle) Assertions.checkNotNull(bundle2.getBundle(str)))));
                }
                return new State(builder.buildOrThrow());
            }
        }

        private AdsLoader(Context context2, ImaUtil.ServerSideAdInsertionConfiguration serverSideAdInsertionConfiguration, State state) {
            this.context = context2.getApplicationContext();
            this.configuration = serverSideAdInsertionConfiguration;
            this.mediaSourceResources = new HashMap();
            this.adPlaybackStateMap = new HashMap();
            UnmodifiableIterator it = state.adPlaybackStates.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                this.adPlaybackStateMap.put((String) entry.getKey(), (AdPlaybackState) entry.getValue());
            }
        }

        public void setPlayer(Player player2) {
            this.player = player2;
        }

        public void focusSkipButton() {
            MediaSourceResourceHolder mediaSourceResourceHolder;
            Player player2 = this.player;
            if (player2 != null && player2.getPlaybackState() != 1 && this.player.getPlaybackState() != 4 && this.player.getMediaItemCount() > 0) {
                Object adsId = this.player.getCurrentTimeline().getPeriod(this.player.getCurrentPeriodIndex(), new Timeline.Period()).getAdsId();
                if ((adsId instanceof String) && (mediaSourceResourceHolder = this.mediaSourceResources.get(adsId)) != null && mediaSourceResourceHolder.imaServerSideAdInsertionMediaSource.streamManager != null) {
                    mediaSourceResourceHolder.imaServerSideAdInsertionMediaSource.streamManager.focus();
                }
            }
        }

        public State release() {
            for (MediaSourceResourceHolder next : this.mediaSourceResources.values()) {
                next.streamPlayer.release();
                next.adsLoader.release();
                next.imaServerSideAdInsertionMediaSource.setStreamManager((StreamManager) null);
            }
            State state = new State(ImmutableMap.copyOf(this.adPlaybackStateMap));
            this.adPlaybackStateMap.clear();
            this.mediaSourceResources.clear();
            this.player = null;
            return state;
        }

        /* access modifiers changed from: private */
        public void addMediaSourceResources(ImaServerSideAdInsertionMediaSource imaServerSideAdInsertionMediaSource, StreamPlayer streamPlayer, com.google.ads.interactivemedia.v3.api.AdsLoader adsLoader) {
            this.mediaSourceResources.put(imaServerSideAdInsertionMediaSource.adsId, new MediaSourceResourceHolder(imaServerSideAdInsertionMediaSource, streamPlayer, adsLoader));
        }

        /* access modifiers changed from: private */
        public AdPlaybackState getAdPlaybackState(String str) {
            AdPlaybackState adPlaybackState = this.adPlaybackStateMap.get(str);
            return adPlaybackState != null ? adPlaybackState : AdPlaybackState.NONE;
        }

        /* access modifiers changed from: private */
        public void setAdPlaybackState(String str, AdPlaybackState adPlaybackState) {
            this.adPlaybackStateMap.put(str, adPlaybackState);
        }

        private static final class MediaSourceResourceHolder {
            public final com.google.ads.interactivemedia.v3.api.AdsLoader adsLoader;
            public final ImaServerSideAdInsertionMediaSource imaServerSideAdInsertionMediaSource;
            public final StreamPlayer streamPlayer;

            private MediaSourceResourceHolder(ImaServerSideAdInsertionMediaSource imaServerSideAdInsertionMediaSource2, StreamPlayer streamPlayer2, com.google.ads.interactivemedia.v3.api.AdsLoader adsLoader2) {
                this.imaServerSideAdInsertionMediaSource = imaServerSideAdInsertionMediaSource2;
                this.streamPlayer = streamPlayer2;
                this.adsLoader = adsLoader2;
            }
        }
    }

    private ImaServerSideAdInsertionMediaSource(Player player2, MediaItem mediaItem2, StreamRequest streamRequest2, AdsLoader adsLoader2, com.google.ads.interactivemedia.v3.api.AdsLoader adsLoader3, StreamPlayer streamPlayer2, MediaSource.Factory factory, AdEvent.AdEventListener adEventListener, AdErrorEvent.AdErrorListener adErrorListener) {
        AdEvent.AdEventListener adEventListener2;
        this.player = player2;
        this.mediaItem = mediaItem2;
        this.streamRequest = streamRequest2;
        this.adsLoader = adsLoader2;
        this.sdkAdsLoader = adsLoader3;
        this.streamPlayer = streamPlayer2;
        this.contentMediaSourceFactory = factory;
        this.applicationAdEventListener = adEventListener;
        this.applicationAdErrorListener = adErrorListener;
        Assertions.checkArgument(player2.getApplicationLooper() == Looper.getMainLooper());
        this.mainHandler = new Handler(Looper.getMainLooper());
        Uri uri = ((MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem2.localConfiguration)).uri;
        boolean isLiveStream2 = ImaServerSideAdInsertionUriBuilder.isLiveStream(uri);
        this.isLiveStream = isLiveStream2;
        String adsId2 = ImaServerSideAdInsertionUriBuilder.getAdsId(uri);
        this.adsId = adsId2;
        this.loadVideoTimeoutMs = ImaServerSideAdInsertionUriBuilder.getLoadVideoTimeoutMs(uri);
        boolean equals = Objects.equals(ImaServerSideAdInsertionUriBuilder.createStreamRequest(uri).getFormat(), StreamRequest.StreamFormat.DASH);
        if (!isLiveStream2) {
            adEventListener2 = new VodAdEventListener();
        } else if (equals) {
            adEventListener2 = new MultiPeriodLiveAdEventListener();
        } else {
            adEventListener2 = new SinglePeriodLiveAdEventListener();
        }
        this.componentListener = new ComponentListener(adEventListener2);
        this.adPlaybackState = adsLoader2.getAdPlaybackState(adsId2);
    }

    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$prepareSourceInternal$0$androidx-media3-exoplayer-ima-ImaServerSideAdInsertionMediaSource  reason: not valid java name */
    public /* synthetic */ void m128lambda$prepareSourceInternal$0$androidxmedia3exoplayerimaImaServerSideAdInsertionMediaSource() {
        assertSingleInstanceInPlaylist((Player) Assertions.checkNotNull(this.player));
    }

    public void prepareSourceInternal(TransferListener transferListener) {
        this.mainHandler.post(new ImaServerSideAdInsertionMediaSource$$ExternalSyntheticLambda2(this));
        super.prepareSourceInternal(transferListener);
        if (this.loader == null) {
            Loader loader2 = new Loader("ImaServerSideAdInsertionMediaSource");
            this.player.addListener(this.componentListener);
            loader2.startLoading(new StreamManagerLoadable(this.sdkAdsLoader, this, this.streamRequest, this.streamPlayer, this.applicationAdErrorListener), new StreamManagerLoadableCallback(), 0);
            this.loader = loader2;
        }
    }

    /* access modifiers changed from: protected */
    public void onChildSourceInfoRefreshed(Void voidR, MediaSource mediaSource, final Timeline timeline) {
        refreshSourceInfo(new ForwardingTimeline(timeline) {
            public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
                timeline.getWindow(i, window, j);
                window.mediaItem = ImaServerSideAdInsertionMediaSource.this.mediaItem;
                return window;
            }
        });
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        return ((ServerSideAdInsertionMediaSource) Assertions.checkNotNull(this.serverSideAdInsertionMediaSource)).createPeriod(mediaPeriodId, allocator, j);
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((ServerSideAdInsertionMediaSource) Assertions.checkNotNull(this.serverSideAdInsertionMediaSource)).releasePeriod(mediaPeriod);
    }

    public void maybeThrowSourceInfoRefreshError() throws IOException {
        super.maybeThrowSourceInfoRefreshError();
        IOException iOException = this.loadError;
        if (iOException != null) {
            this.loadError = null;
            throw iOException;
        }
    }

    /* access modifiers changed from: protected */
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        Loader loader2 = this.loader;
        if (loader2 != null) {
            loader2.release();
            this.mainHandler.post(new ImaServerSideAdInsertionMediaSource$$ExternalSyntheticLambda0(this));
            this.loader = null;
        }
        this.contentTimeline = null;
        this.serverSideAdInsertionMediaSource = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$releaseSourceInternal$1$androidx-media3-exoplayer-ima-ImaServerSideAdInsertionMediaSource  reason: not valid java name */
    public /* synthetic */ void m129lambda$releaseSourceInternal$1$androidxmedia3exoplayerimaImaServerSideAdInsertionMediaSource() {
        this.player.removeListener(this.componentListener);
        setStreamManager((StreamManager) null);
    }

    /* access modifiers changed from: private */
    public void setStreamManager(StreamManager streamManager2) {
        StreamManager streamManager3 = this.streamManager;
        if (streamManager3 != streamManager2) {
            if (streamManager3 != null) {
                AdEvent.AdEventListener adEventListener = this.applicationAdEventListener;
                if (adEventListener != null) {
                    streamManager3.removeAdEventListener(adEventListener);
                }
                AdErrorEvent.AdErrorListener adErrorListener = this.applicationAdErrorListener;
                if (adErrorListener != null) {
                    this.streamManager.removeAdErrorListener(adErrorListener);
                }
                this.streamManager.removeAdEventListener(this.componentListener);
                this.streamManager.destroy();
            }
            this.streamManager = streamManager2;
            if (streamManager2 != null) {
                streamManager2.addAdEventListener(this.componentListener);
                AdEvent.AdEventListener adEventListener2 = this.applicationAdEventListener;
                if (adEventListener2 != null) {
                    streamManager2.addAdEventListener(adEventListener2);
                }
                AdErrorEvent.AdErrorListener adErrorListener2 = this.applicationAdErrorListener;
                if (adErrorListener2 != null) {
                    streamManager2.addAdErrorListener(adErrorListener2);
                }
                AdsRenderingSettings createAdsRenderingSettings = ImaSdkFactory.getInstance().createAdsRenderingSettings();
                createAdsRenderingSettings.setLoadVideoTimeout(this.loadVideoTimeoutMs);
                createAdsRenderingSettings.setFocusSkipButtonWhenAvailable(this.adsLoader.configuration.focusSkipButtonWhenAvailable);
                streamManager2.init(createAdsRenderingSettings);
            }
        }
    }

    /* access modifiers changed from: private */
    public void setAdPlaybackState(AdPlaybackState adPlaybackState2) {
        if (!adPlaybackState2.equals(this.adPlaybackState)) {
            this.adPlaybackState = adPlaybackState2;
            invalidateServerSideAdInsertionAdPlaybackState();
        }
    }

    /* access modifiers changed from: private */
    public void setContentTimeline(Timeline timeline) {
        if (!timeline.equals(this.contentTimeline)) {
            if (this.isLiveStream && Objects.equals(this.streamRequest.getFormat(), StreamRequest.StreamFormat.DASH)) {
                this.adPlaybackState = ImaUtil.maybeCorrectPreviouslyUnknownAdDurations(timeline, this.adPlaybackState);
            }
            this.contentTimeline = timeline;
            invalidateServerSideAdInsertionAdPlaybackState();
        }
    }

    private void invalidateServerSideAdInsertionAdPlaybackState() {
        Timeline timeline;
        ImmutableMap<Object, AdPlaybackState> immutableMap;
        if (!this.adPlaybackState.equals(AdPlaybackState.NONE) && (timeline = this.contentTimeline) != null && this.serverSideAdInsertionMediaSource != null) {
            Timeline timeline2 = (Timeline) Assertions.checkNotNull(timeline);
            if (Objects.equals(this.streamRequest.getFormat(), StreamRequest.StreamFormat.DASH)) {
                immutableMap = ImaUtil.splitAdPlaybackStateForPeriods(this.adPlaybackState, timeline2);
            } else {
                immutableMap = ImmutableMap.of(Assertions.checkNotNull(timeline2.getPeriod(timeline2.getWindow(0, new Timeline.Window()).firstPeriodIndex, new Timeline.Period(), true).uid), this.adPlaybackState);
            }
            this.streamPlayer.setAdPlaybackStates(this.adsId, immutableMap, timeline2);
            ((ServerSideAdInsertionMediaSource) Assertions.checkNotNull(this.serverSideAdInsertionMediaSource)).setAdPlaybackStates(immutableMap, timeline2);
            if (!this.isLiveStream) {
                this.adsLoader.setAdPlaybackState(this.adsId, this.adPlaybackState);
            }
        }
    }

    /* access modifiers changed from: private */
    public void setContentUri(Uri uri) {
        if (this.serverSideAdInsertionMediaSource == null) {
            ServerSideAdInsertionMediaSource serverSideAdInsertionMediaSource2 = new ServerSideAdInsertionMediaSource(this.contentMediaSourceFactory.createMediaSource(new MediaItem.Builder().setUri(uri).setDrmConfiguration(((MediaItem.LocalConfiguration) Assertions.checkNotNull(this.mediaItem.localConfiguration)).drmConfiguration).setLiveConfiguration(this.mediaItem.liveConfiguration).setCustomCacheKey(this.mediaItem.localConfiguration.customCacheKey).setStreamKeys(this.mediaItem.localConfiguration.streamKeys).build()), this.componentListener);
            this.serverSideAdInsertionMediaSource = serverSideAdInsertionMediaSource2;
            if (this.isLiveStream) {
                this.mainHandler.post(new ImaServerSideAdInsertionMediaSource$$ExternalSyntheticLambda1(this));
            }
            prepareChildSource(null, serverSideAdInsertionMediaSource2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setContentUri$2$androidx-media3-exoplayer-ima-ImaServerSideAdInsertionMediaSource  reason: not valid java name */
    public /* synthetic */ void m130lambda$setContentUri$2$androidxmedia3exoplayerimaImaServerSideAdInsertionMediaSource() {
        setAdPlaybackState(new AdPlaybackState(this.adsId, new long[0]).withLivePostrollPlaceholderAppended());
    }

    /* access modifiers changed from: private */
    public static AdPlaybackState setVodAdGroupPlaceholders(List<CuePoint> list, AdPlaybackState adPlaybackState2) {
        AdPlaybackState adPlaybackState3 = adPlaybackState2;
        for (int i = 0; i < list.size(); i++) {
            CuePoint cuePoint = list.get(i);
            adPlaybackState3 = ServerSideAdInsertionUtil.addAdGroupToAdPlaybackState(adPlaybackState3, Util.msToUs(ImaUtil.secToMsRounded(cuePoint.getStartTime())), 0, getAdDuration(cuePoint.getStartTime(), cuePoint.getEndTime()));
        }
        return adPlaybackState3;
    }

    private static long getAdDuration(double d, double d2) {
        return Util.msToUs(ImaUtil.secToMsRounded(d2 - d));
    }

    /* access modifiers changed from: private */
    public static AdPlaybackState setVodAdInPlaceholder(Ad ad, AdPlaybackState adPlaybackState2) {
        AdPodInfo adPodInfo = ad.getAdPodInfo();
        int podIndex = adPodInfo.getPodIndex() == -1 ? adPlaybackState2.adGroupCount - 1 : adPodInfo.getPodIndex();
        AdPlaybackState.AdGroup adGroup = adPlaybackState2.getAdGroup(podIndex);
        int adPosition = adPodInfo.getAdPosition() - 1;
        if (adGroup.count < adPodInfo.getTotalAds()) {
            return ImaUtil.expandAdGroupPlaceholder(podIndex, Util.msToUs(ImaUtil.secToMsRounded(adPodInfo.getMaxDuration())), adPosition, Util.msToUs(ImaUtil.secToMsRounded(ad.getDuration())), adPodInfo.getTotalAds(), adPlaybackState2);
        }
        return adPosition < adGroup.count + -1 ? ImaUtil.updateAdDurationInAdGroup(podIndex, adPosition, Util.msToUs(ImaUtil.secToMsRounded(ad.getDuration())), adPlaybackState2) : adPlaybackState2;
    }

    /* access modifiers changed from: private */
    public static AdPlaybackState skipAd(Ad ad, AdPlaybackState adPlaybackState2) {
        AdPodInfo adPodInfo = ad.getAdPodInfo();
        return adPlaybackState2.withSkippedAd(adPodInfo.getPodIndex(), adPodInfo.getAdPosition() - 1);
    }

    private final class ComponentListener implements AdEvent.AdEventListener, Player.Listener, ServerSideAdInsertionMediaSource.AdPlaybackStateUpdater {
        private final AdEvent.AdEventListener adEventListener;

        public /* synthetic */ void onAudioAttributesChanged(AudioAttributes audioAttributes) {
            Player.Listener.CC.$default$onAudioAttributesChanged(this, audioAttributes);
        }

        public /* synthetic */ void onAudioSessionIdChanged(int i) {
            Player.Listener.CC.$default$onAudioSessionIdChanged(this, i);
        }

        public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
            Player.Listener.CC.$default$onAvailableCommandsChanged(this, commands);
        }

        public /* synthetic */ void onCues(CueGroup cueGroup) {
            Player.Listener.CC.$default$onCues((Player.Listener) this, cueGroup);
        }

        public /* synthetic */ void onCues(List list) {
            Player.Listener.CC.$default$onCues((Player.Listener) this, list);
        }

        public /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
            Player.Listener.CC.$default$onDeviceInfoChanged(this, deviceInfo);
        }

        public /* synthetic */ void onDeviceVolumeChanged(int i, boolean z) {
            Player.Listener.CC.$default$onDeviceVolumeChanged(this, i, z);
        }

        public /* synthetic */ void onEvents(Player player, Player.Events events) {
            Player.Listener.CC.$default$onEvents(this, player, events);
        }

        public /* synthetic */ void onIsLoadingChanged(boolean z) {
            Player.Listener.CC.$default$onIsLoadingChanged(this, z);
        }

        public /* synthetic */ void onIsPlayingChanged(boolean z) {
            Player.Listener.CC.$default$onIsPlayingChanged(this, z);
        }

        public /* synthetic */ void onLoadingChanged(boolean z) {
            Player.Listener.CC.$default$onLoadingChanged(this, z);
        }

        public /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j) {
            Player.Listener.CC.$default$onMaxSeekToPreviousPositionChanged(this, j);
        }

        public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
            Player.Listener.CC.$default$onMediaItemTransition(this, mediaItem, i);
        }

        public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
            Player.Listener.CC.$default$onMediaMetadataChanged(this, mediaMetadata);
        }

        public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
            Player.Listener.CC.$default$onPlayWhenReadyChanged(this, z, i);
        }

        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            Player.Listener.CC.$default$onPlaybackParametersChanged(this, playbackParameters);
        }

        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            Player.Listener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
        }

        public /* synthetic */ void onPlayerError(PlaybackException playbackException) {
            Player.Listener.CC.$default$onPlayerError(this, playbackException);
        }

        public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
            Player.Listener.CC.$default$onPlayerErrorChanged(this, playbackException);
        }

        public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
            Player.Listener.CC.$default$onPlayerStateChanged(this, z, i);
        }

        public /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
            Player.Listener.CC.$default$onPlaylistMetadataChanged(this, mediaMetadata);
        }

        public /* synthetic */ void onPositionDiscontinuity(int i) {
            Player.Listener.CC.$default$onPositionDiscontinuity(this, i);
        }

        public /* synthetic */ void onRenderedFirstFrame() {
            Player.Listener.CC.$default$onRenderedFirstFrame(this);
        }

        public /* synthetic */ void onRepeatModeChanged(int i) {
            Player.Listener.CC.$default$onRepeatModeChanged(this, i);
        }

        public /* synthetic */ void onSeekBackIncrementChanged(long j) {
            Player.Listener.CC.$default$onSeekBackIncrementChanged(this, j);
        }

        public /* synthetic */ void onSeekForwardIncrementChanged(long j) {
            Player.Listener.CC.$default$onSeekForwardIncrementChanged(this, j);
        }

        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
            Player.Listener.CC.$default$onShuffleModeEnabledChanged(this, z);
        }

        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
            Player.Listener.CC.$default$onSkipSilenceEnabledChanged(this, z);
        }

        public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
            Player.Listener.CC.$default$onSurfaceSizeChanged(this, i, i2);
        }

        public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
            Player.Listener.CC.$default$onTimelineChanged(this, timeline, i);
        }

        public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
            Player.Listener.CC.$default$onTrackSelectionParametersChanged(this, trackSelectionParameters);
        }

        public /* synthetic */ void onTracksChanged(Tracks tracks) {
            Player.Listener.CC.$default$onTracksChanged(this, tracks);
        }

        public /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
            Player.Listener.CC.$default$onVideoSizeChanged(this, videoSize);
        }

        public ComponentListener(AdEvent.AdEventListener adEventListener2) {
            this.adEventListener = adEventListener2;
        }

        public void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
            Pair<Integer, Integer> pair;
            if (i == 0 || (ImaServerSideAdInsertionMediaSource.this.isLiveStream && i == 4)) {
                if (ImaServerSideAdInsertionMediaSource.this.mediaItem.equals(positionInfo.mediaItem) && !ImaServerSideAdInsertionMediaSource.this.mediaItem.equals(positionInfo2.mediaItem)) {
                    ImaServerSideAdInsertionMediaSource.this.streamPlayer.onContentCompleted();
                }
                if (ImaServerSideAdInsertionMediaSource.this.mediaItem.equals(positionInfo.mediaItem) && ImaServerSideAdInsertionMediaSource.this.mediaItem.equals(positionInfo2.mediaItem) && ImaServerSideAdInsertionMediaSource.this.adsId.equals(ImaServerSideAdInsertionMediaSource.this.player.getCurrentTimeline().getPeriodByUid(Assertions.checkNotNull(positionInfo2.periodUid), new Timeline.Period()).getAdsId()) && positionInfo.adGroupIndex != -1) {
                    int i2 = positionInfo.adGroupIndex;
                    int i3 = positionInfo.adIndexInAdGroup;
                    Timeline currentTimeline = ImaServerSideAdInsertionMediaSource.this.player.getCurrentTimeline();
                    Timeline.Window window = currentTimeline.getWindow(positionInfo.mediaItemIndex, new Timeline.Window());
                    if (window.lastPeriodIndex > window.firstPeriodIndex) {
                        if (i == 4) {
                            ImaServerSideAdInsertionMediaSource imaServerSideAdInsertionMediaSource = ImaServerSideAdInsertionMediaSource.this;
                            imaServerSideAdInsertionMediaSource.setAdPlaybackState(ImaUtil.handleAdPeriodRemovedFromTimeline(imaServerSideAdInsertionMediaSource.player.getCurrentPeriodIndex(), currentTimeline, ImaServerSideAdInsertionMediaSource.this.adPlaybackState));
                            return;
                        }
                        if (window.isLive()) {
                            pair = ImaUtil.getAdGroupAndIndexInLiveMultiPeriodTimeline(positionInfo.mediaItemIndex, positionInfo.periodIndex - window.firstPeriodIndex, currentTimeline, ImaServerSideAdInsertionMediaSource.this.adPlaybackState);
                        } else {
                            pair = ImaUtil.getAdGroupAndIndexInVodMultiPeriodTimeline(positionInfo.periodIndex - window.firstPeriodIndex, ImaServerSideAdInsertionMediaSource.this.adPlaybackState, (Timeline) Assertions.checkNotNull(ImaServerSideAdInsertionMediaSource.this.contentTimeline));
                        }
                        i2 = ((Integer) pair.first).intValue();
                        i3 = ((Integer) pair.second).intValue();
                    }
                    int i4 = ImaServerSideAdInsertionMediaSource.this.adPlaybackState.getAdGroup(i2).states[i3];
                    if (i4 == 1 || i4 == 0) {
                        AdPlaybackState withPlayedAd = ImaServerSideAdInsertionMediaSource.this.adPlaybackState.withPlayedAd(i2, i3);
                        AdPlaybackState.AdGroup adGroup = withPlayedAd.getAdGroup(i2);
                        if (ImaServerSideAdInsertionMediaSource.this.isLiveStream && positionInfo2.adGroupIndex == -1 && i3 < adGroup.states.length - 1) {
                            int i5 = i3 + 1;
                            if (adGroup.states[i5] == 1) {
                                Log.w(ImaServerSideAdInsertionMediaSource.TAG, "Detected late ad event. Regrouping trailing ads into separate ad group.");
                                withPlayedAd = ImaUtil.splitAdGroup(adGroup, i2, i5, withPlayedAd);
                            }
                        }
                        ImaServerSideAdInsertionMediaSource.this.setAdPlaybackState(withPlayedAd);
                    }
                }
            }
        }

        public void onMetadata(Metadata metadata) {
            if (ImaServerSideAdInsertionMediaSource.isCurrentAdPlaying(ImaServerSideAdInsertionMediaSource.this.player, ImaServerSideAdInsertionMediaSource.this.mediaItem, ImaServerSideAdInsertionMediaSource.this.adsId)) {
                for (int i = 0; i < metadata.length(); i++) {
                    Metadata.Entry entry = metadata.get(i);
                    if (entry instanceof TextInformationFrame) {
                        TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                        if ("TXXX".equals(textInformationFrame.id)) {
                            ImaServerSideAdInsertionMediaSource.this.streamPlayer.triggerUserTextReceived((String) textInformationFrame.values.get(0));
                        }
                    } else if (entry instanceof EventMessage) {
                        ImaServerSideAdInsertionMediaSource.this.streamPlayer.triggerUserTextReceived(new String(((EventMessage) entry).messageData));
                    }
                }
            }
        }

        public void onPlaybackStateChanged(int i) {
            if (i == 4 && ImaServerSideAdInsertionMediaSource.isCurrentAdPlaying(ImaServerSideAdInsertionMediaSource.this.player, ImaServerSideAdInsertionMediaSource.this.mediaItem, ImaServerSideAdInsertionMediaSource.this.adsId)) {
                ImaServerSideAdInsertionMediaSource.this.streamPlayer.onContentCompleted();
            }
        }

        public void onVolumeChanged(float f) {
            if (ImaServerSideAdInsertionMediaSource.isCurrentAdPlaying(ImaServerSideAdInsertionMediaSource.this.player, ImaServerSideAdInsertionMediaSource.this.mediaItem, ImaServerSideAdInsertionMediaSource.this.adsId)) {
                ImaServerSideAdInsertionMediaSource.this.streamPlayer.onContentVolumeChanged((int) Math.floor((double) (f * 100.0f)));
            }
        }

        public void onAdEvent(AdEvent adEvent) {
            this.adEventListener.onAdEvent(adEvent);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$onAdPlaybackStateUpdateRequested$0$androidx-media3-exoplayer-ima-ImaServerSideAdInsertionMediaSource$ComponentListener  reason: not valid java name */
        public /* synthetic */ void m131lambda$onAdPlaybackStateUpdateRequested$0$androidxmedia3exoplayerimaImaServerSideAdInsertionMediaSource$ComponentListener(Timeline timeline) {
            ImaServerSideAdInsertionMediaSource.this.setContentTimeline(timeline);
        }

        public boolean onAdPlaybackStateUpdateRequested(Timeline timeline) {
            ImaServerSideAdInsertionMediaSource.this.mainHandler.post(new ImaServerSideAdInsertionMediaSource$ComponentListener$$ExternalSyntheticLambda0(this, timeline));
            return !ImaServerSideAdInsertionMediaSource.this.isLiveStream || Objects.equals(ImaServerSideAdInsertionMediaSource.this.streamRequest.getFormat(), StreamRequest.StreamFormat.DASH);
        }
    }

    private final class StreamManagerLoadableCallback implements Loader.Callback<StreamManagerLoadable> {
        private StreamManagerLoadableCallback() {
        }

        public void onLoadCompleted(StreamManagerLoadable streamManagerLoadable, long j, long j2) {
            ImaServerSideAdInsertionMediaSource.this.setContentUri((Uri) Assertions.checkNotNull(streamManagerLoadable.getContentUri()));
        }

        public void onLoadCanceled(StreamManagerLoadable streamManagerLoadable, long j, long j2, boolean z) {
            Assertions.checkState(z);
        }

        public Loader.LoadErrorAction onLoadError(StreamManagerLoadable streamManagerLoadable, long j, long j2, IOException iOException, int i) {
            IOException unused = ImaServerSideAdInsertionMediaSource.this.loadError = iOException;
            return Loader.DONT_RETRY;
        }
    }

    private static class StreamManagerLoadable implements Loader.Loadable, AdsLoader.AdsLoadedListener, AdErrorEvent.AdErrorListener {
        private final AdErrorEvent.AdErrorListener adErrorListener;
        private final com.google.ads.interactivemedia.v3.api.AdsLoader adsLoader;
        private volatile boolean cancelled;
        private final ConditionVariable conditionVariable;
        private volatile Uri contentUri;
        private volatile boolean error;
        private volatile int errorCode;
        private volatile String errorMessage;
        private final ImaServerSideAdInsertionMediaSource imaServerSideAdInsertionMediaSource;
        private final StreamRequest request;
        private final StreamPlayer streamPlayer;

        private StreamManagerLoadable(com.google.ads.interactivemedia.v3.api.AdsLoader adsLoader2, ImaServerSideAdInsertionMediaSource imaServerSideAdInsertionMediaSource2, StreamRequest streamRequest, StreamPlayer streamPlayer2, AdErrorEvent.AdErrorListener adErrorListener2) {
            this.adsLoader = adsLoader2;
            this.imaServerSideAdInsertionMediaSource = imaServerSideAdInsertionMediaSource2;
            this.request = streamRequest;
            this.streamPlayer = streamPlayer2;
            this.adErrorListener = adErrorListener2;
            this.conditionVariable = new ConditionVariable();
            this.errorCode = -1;
        }

        public Uri getContentUri() {
            return this.contentUri;
        }

        public void load() throws IOException {
            try {
                this.streamPlayer.setStreamLoadListener(new ImaServerSideAdInsertionMediaSource$StreamManagerLoadable$$ExternalSyntheticLambda0(this));
                AdErrorEvent.AdErrorListener adErrorListener2 = this.adErrorListener;
                if (adErrorListener2 != null) {
                    this.adsLoader.addAdErrorListener(adErrorListener2);
                }
                this.adsLoader.addAdsLoadedListener(this);
                this.adsLoader.addAdErrorListener(this);
                this.adsLoader.requestStream(this.request);
                while (this.contentUri == null && !this.cancelled && !this.error) {
                    try {
                        this.conditionVariable.block();
                    } catch (InterruptedException unused) {
                    }
                }
                if (this.error) {
                    if (this.contentUri == null) {
                        throw new IOException(this.errorMessage + " [errorCode: " + this.errorCode + "]");
                    }
                }
            } finally {
                this.adsLoader.removeAdsLoadedListener(this);
                this.adsLoader.removeAdErrorListener(this);
                AdErrorEvent.AdErrorListener adErrorListener3 = this.adErrorListener;
                if (adErrorListener3 != null) {
                    this.adsLoader.removeAdErrorListener(adErrorListener3);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$load$0$androidx-media3-exoplayer-ima-ImaServerSideAdInsertionMediaSource$StreamManagerLoadable  reason: not valid java name */
        public /* synthetic */ void m132lambda$load$0$androidxmedia3exoplayerimaImaServerSideAdInsertionMediaSource$StreamManagerLoadable(String str, List list) {
            this.contentUri = Uri.parse(str);
            this.conditionVariable.open();
        }

        public void cancelLoad() {
            this.cancelled = true;
        }

        public void onAdsManagerLoaded(AdsManagerLoadedEvent adsManagerLoadedEvent) {
            StreamManager streamManager = adsManagerLoadedEvent.getStreamManager();
            if (streamManager == null) {
                this.error = true;
                this.errorMessage = "streamManager is null after ads manager has been loaded";
                this.conditionVariable.open();
                return;
            }
            this.imaServerSideAdInsertionMediaSource.setStreamManager(streamManager);
        }

        public void onAdError(AdErrorEvent adErrorEvent) {
            this.error = true;
            if (adErrorEvent.getError() != null) {
                String message = adErrorEvent.getError().getMessage();
                if (message != null) {
                    this.errorMessage = message.replace(10, ' ');
                }
                this.errorCode = adErrorEvent.getError().getErrorCodeNumber();
            }
            this.conditionVariable.open();
        }
    }

    private static final class StreamPlayer implements VideoStreamPlayer {
        private ImmutableMap<Object, AdPlaybackState> adPlaybackStates;
        private Object adsId;
        private final List<VideoStreamPlayer.VideoStreamPlayerCallback> callbacks;
        private Timeline contentTimeline;
        private final boolean isDashStream;
        private final MediaItem mediaItem;
        private final Timeline.Period period;
        private final Player player;
        private StreamLoadListener streamLoadListener;
        private final Timeline.Window window;

        public interface StreamLoadListener {
            void onLoadStream(String str, List<HashMap<String, String>> list);
        }

        public void onAdBreakEnded() {
        }

        public void onAdBreakStarted() {
        }

        public void onAdPeriodEnded() {
        }

        public void onAdPeriodStarted() {
        }

        public void pause() {
        }

        public void resume() {
        }

        public void seek(long j) {
        }

        public StreamPlayer(Player player2, MediaItem mediaItem2, StreamRequest streamRequest) {
            this.player = player2;
            this.mediaItem = mediaItem2;
            this.isDashStream = streamRequest.getFormat() == StreamRequest.StreamFormat.DASH;
            this.callbacks = new ArrayList(1);
            this.adPlaybackStates = ImmutableMap.of();
            this.window = new Timeline.Window();
            this.period = new Timeline.Period();
        }

        public void setAdPlaybackStates(Object obj, ImmutableMap<Object, AdPlaybackState> immutableMap, Timeline timeline) {
            this.adsId = obj;
            this.adPlaybackStates = immutableMap;
            this.contentTimeline = timeline;
        }

        public void setStreamLoadListener(StreamLoadListener streamLoadListener2) {
            this.streamLoadListener = (StreamLoadListener) Assertions.checkNotNull(streamLoadListener2);
        }

        public void onContentCompleted() {
            for (VideoStreamPlayer.VideoStreamPlayerCallback onContentComplete : this.callbacks) {
                onContentComplete.onContentComplete();
            }
        }

        public void onContentVolumeChanged(int i) {
            for (VideoStreamPlayer.VideoStreamPlayerCallback onVolumeChanged : this.callbacks) {
                onVolumeChanged.onVolumeChanged(i);
            }
        }

        public void release() {
            this.callbacks.clear();
            this.adsId = null;
            this.adPlaybackStates = ImmutableMap.of();
            this.contentTimeline = null;
            this.streamLoadListener = null;
        }

        public int getVolume() {
            return (int) Math.floor((double) (this.player.getVolume() * 100.0f));
        }

        public VideoProgressUpdate getContentProgress() {
            long j;
            long usToMs;
            long j2;
            long j3;
            if (!ImaServerSideAdInsertionMediaSource.isCurrentAdPlaying(this.player, this.mediaItem, this.adsId)) {
                return VideoProgressUpdate.VIDEO_TIME_NOT_READY;
            }
            if (this.adPlaybackStates.isEmpty()) {
                return new VideoProgressUpdate(0, -9223372036854775807L);
            }
            Timeline currentTimeline = this.player.getCurrentTimeline();
            int currentPeriodIndex = this.player.getCurrentPeriodIndex();
            currentTimeline.getPeriod(currentPeriodIndex, this.period, true);
            currentTimeline.getWindow(this.player.getCurrentMediaItemIndex(), this.window);
            if (!this.isDashStream || !this.window.isLive()) {
                Timeline.Period period2 = ((Timeline) Assertions.checkNotNull(this.contentTimeline)).getPeriod(currentPeriodIndex - this.window.firstPeriodIndex, new Timeline.Period(), true);
                long usToMs2 = Util.usToMs(ServerSideAdInsertionUtil.getStreamPositionUs(this.player, (AdPlaybackState) Assertions.checkNotNull(this.adPlaybackStates.get(period2.uid))));
                if (this.window.windowStartTimeMs != -9223372036854775807L) {
                    usToMs = this.window.windowStartTimeMs + this.period.getPositionInWindowMs();
                } else if (currentPeriodIndex > this.window.firstPeriodIndex) {
                    ((Timeline) Assertions.checkNotNull(this.contentTimeline)).getPeriod((currentPeriodIndex - this.window.firstPeriodIndex) - 1, period2, true);
                    usToMs = Util.usToMs(period2.positionInWindowUs + period2.durationUs);
                } else {
                    j = usToMs2;
                }
                j = usToMs + usToMs2;
            } else {
                if (this.player.isPlayingAd()) {
                    j3 = this.window.windowStartTimeMs + Util.usToMs(this.period.positionInWindowUs);
                    j2 = this.player.getCurrentPosition();
                } else {
                    j3 = this.window.windowStartTimeMs;
                    j2 = this.player.getContentPosition();
                }
                j = j3 + j2;
            }
            return new VideoProgressUpdate(j, ((Timeline) Assertions.checkNotNull(this.contentTimeline)).getWindow(0, this.window).getDurationMs());
        }

        public void loadUrl(String str, List<HashMap<String, String>> list) {
            StreamLoadListener streamLoadListener2 = this.streamLoadListener;
            if (streamLoadListener2 != null) {
                streamLoadListener2.onLoadStream(str, list);
            }
        }

        public void addCallback(VideoStreamPlayer.VideoStreamPlayerCallback videoStreamPlayerCallback) {
            this.callbacks.add(videoStreamPlayerCallback);
        }

        public void removeCallback(VideoStreamPlayer.VideoStreamPlayerCallback videoStreamPlayerCallback) {
            this.callbacks.remove(videoStreamPlayerCallback);
        }

        /* access modifiers changed from: private */
        public void triggerUserTextReceived(String str) {
            for (VideoStreamPlayer.VideoStreamPlayerCallback onUserTextReceived : this.callbacks) {
                onUserTextReceived.onUserTextReceived(str);
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean isCurrentAdPlaying(Player player2, MediaItem mediaItem2, Object obj) {
        if (player2.getPlaybackState() == 1) {
            return false;
        }
        Timeline.Period period = new Timeline.Period();
        player2.getCurrentTimeline().getPeriod(player2.getCurrentPeriodIndex(), period);
        if ((!period.isPlaceholder || !mediaItem2.equals(player2.getCurrentMediaItem())) && (obj == null || !obj.equals(period.getAdsId()))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static StreamDisplayContainer createStreamDisplayContainer(ImaSdkFactory imaSdkFactory, ImaUtil.ServerSideAdInsertionConfiguration serverSideAdInsertionConfiguration, StreamPlayer streamPlayer2) {
        StreamDisplayContainer createStreamDisplayContainer = ImaSdkFactory.createStreamDisplayContainer((ViewGroup) Assertions.checkNotNull(serverSideAdInsertionConfiguration.adViewProvider.getAdViewGroup()), streamPlayer2);
        createStreamDisplayContainer.setCompanionSlots(serverSideAdInsertionConfiguration.companionAdSlots);
        registerFriendlyObstructions(imaSdkFactory, createStreamDisplayContainer, serverSideAdInsertionConfiguration.adViewProvider);
        return createStreamDisplayContainer;
    }

    private static void registerFriendlyObstructions(ImaSdkFactory imaSdkFactory, StreamDisplayContainer streamDisplayContainer, AdViewProvider adViewProvider) {
        for (int i = 0; i < adViewProvider.getAdOverlayInfos().size(); i++) {
            AdOverlayInfo adOverlayInfo = adViewProvider.getAdOverlayInfos().get(i);
            streamDisplayContainer.registerFriendlyObstruction(imaSdkFactory.createFriendlyObstruction(adOverlayInfo.view, ImaUtil.getFriendlyObstructionPurpose(adOverlayInfo.purpose), adOverlayInfo.reasonDetail != null ? adOverlayInfo.reasonDetail : "Unknown reason"));
        }
    }

    private static void assertSingleInstanceInPlaylist(Player player2) {
        int i = 0;
        int i2 = 0;
        while (i < player2.getMediaItemCount()) {
            MediaItem mediaItemAt = player2.getMediaItemAt(i);
            if (mediaItemAt.localConfiguration == null || !C.SSAI_SCHEME.equals(mediaItemAt.localConfiguration.uri.getScheme()) || !"dai.google.com".equals(mediaItemAt.localConfiguration.uri.getAuthority()) || (i2 = i2 + 1) <= 1) {
                i++;
            } else {
                throw new IllegalStateException("Multiple IMA server side ad insertion sources not supported.");
            }
        }
    }

    private class VodAdEventListener implements AdEvent.AdEventListener {
        private VodAdEventListener() {
        }

        public void onAdEvent(AdEvent adEvent) {
            AdPlaybackState access$2300 = ImaServerSideAdInsertionMediaSource.this.adPlaybackState;
            int i = AnonymousClass2.$SwitchMap$com$google$ads$interactivemedia$v3$api$AdEvent$AdEventType[adEvent.getType().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    access$2300 = ImaServerSideAdInsertionMediaSource.setVodAdInPlaceholder(adEvent.getAd(), access$2300);
                } else if (i == 3) {
                    access$2300 = ImaServerSideAdInsertionMediaSource.skipAd(adEvent.getAd(), access$2300);
                }
            } else if (access$2300.equals(AdPlaybackState.NONE)) {
                access$2300 = ImaServerSideAdInsertionMediaSource.setVodAdGroupPlaceholders(((StreamManager) Assertions.checkNotNull(ImaServerSideAdInsertionMediaSource.this.streamManager)).getCuePoints(), new AdPlaybackState(ImaServerSideAdInsertionMediaSource.this.adsId, new long[0]));
            }
            ImaServerSideAdInsertionMediaSource.this.setAdPlaybackState(access$2300);
        }
    }

    /* renamed from: androidx.media3.exoplayer.ima.ImaServerSideAdInsertionMediaSource$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$ads$interactivemedia$v3$api$AdEvent$AdEventType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType[] r0 = com.google.ads.interactivemedia.v3.api.AdEvent.AdEventType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$ads$interactivemedia$v3$api$AdEvent$AdEventType = r0
                com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType r1 = com.google.ads.interactivemedia.v3.api.AdEvent.AdEventType.CUEPOINTS_CHANGED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$ads$interactivemedia$v3$api$AdEvent$AdEventType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType r1 = com.google.ads.interactivemedia.v3.api.AdEvent.AdEventType.LOADED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$ads$interactivemedia$v3$api$AdEvent$AdEventType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType r1 = com.google.ads.interactivemedia.v3.api.AdEvent.AdEventType.SKIPPED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ima.ImaServerSideAdInsertionMediaSource.AnonymousClass2.<clinit>():void");
        }
    }

    private class SinglePeriodLiveAdEventListener implements AdEvent.AdEventListener {
        private SinglePeriodLiveAdEventListener() {
        }

        public void onAdEvent(AdEvent adEvent) {
            long j;
            if (Objects.equals(adEvent.getType(), AdEvent.AdEventType.LOADED)) {
                AdPlaybackState access$2300 = ImaServerSideAdInsertionMediaSource.this.adPlaybackState;
                Timeline currentTimeline = ImaServerSideAdInsertionMediaSource.this.player.getCurrentTimeline();
                Timeline.Period period = new Timeline.Period();
                long j2 = currentTimeline.getPeriod(ImaServerSideAdInsertionMediaSource.this.player.getCurrentPeriodIndex(), period).positionInWindowUs;
                if (ImaServerSideAdInsertionMediaSource.this.player.isPlayingAd()) {
                    j = period.getAdGroupTimeUs(ImaServerSideAdInsertionMediaSource.this.player.getCurrentAdGroupIndex());
                } else {
                    j = Util.msToUs(ImaServerSideAdInsertionMediaSource.this.player.getContentPosition());
                }
                Ad ad = adEvent.getAd();
                AdPodInfo adPodInfo = ad.getAdPodInfo();
                long j3 = j - j2;
                long secToUsRounded = ImaUtil.secToUsRounded(ad.getDuration());
                int adPosition = adPodInfo.getAdPosition();
                long secToUsRounded2 = ImaUtil.secToUsRounded(adPodInfo.getMaxDuration());
                int totalAds = adPodInfo.getTotalAds();
                if (access$2300.equals(AdPlaybackState.NONE)) {
                    access$2300 = new AdPlaybackState(ImaServerSideAdInsertionMediaSource.this.adsId, new long[0]);
                }
                ImaServerSideAdInsertionMediaSource.this.setAdPlaybackState(ImaUtil.addLiveAdBreak(j3, secToUsRounded, adPosition, secToUsRounded2, totalAds, access$2300));
            }
        }
    }

    private class MultiPeriodLiveAdEventListener implements AdEvent.AdEventListener {
        private MultiPeriodLiveAdEventListener() {
        }

        public void onAdEvent(AdEvent adEvent) {
            long j;
            if (Objects.equals(adEvent.getType(), AdEvent.AdEventType.LOADED)) {
                AdPodInfo adPodInfo = adEvent.getAd().getAdPodInfo();
                Timeline currentTimeline = ImaServerSideAdInsertionMediaSource.this.player.getCurrentTimeline();
                Timeline.Window window = new Timeline.Window();
                Timeline.Period period = new Timeline.Period();
                long adGroupDurationUsForLiveAdPeriodIndex = ImaUtil.getAdGroupDurationUsForLiveAdPeriodIndex(currentTimeline, adPodInfo, ImaServerSideAdInsertionMediaSource.this.player.getCurrentPeriodIndex(), window, period);
                long windowStartTimeUs = ImaUtil.getWindowStartTimeUs(window.windowStartTimeMs, window.positionInFirstPeriodUs) + period.positionInWindowUs;
                if (period.durationUs != -9223372036854775807L) {
                    j = period.durationUs;
                } else {
                    j = ImaUtil.secToUsRounded(adEvent.getAd().getDuration());
                }
                ImaServerSideAdInsertionMediaSource.this.setAdPlaybackState(ImaUtil.addLiveAdBreak(windowStartTimeUs, j, adPodInfo.getAdPosition(), adGroupDurationUsForLiveAdPeriodIndex, adPodInfo.getTotalAds(), ImaServerSideAdInsertionMediaSource.this.adPlaybackState));
            }
        }
    }
}
