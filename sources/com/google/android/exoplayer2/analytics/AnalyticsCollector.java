package com.google.android.exoplayer2.analytics;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.device.DeviceInfo;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class AnalyticsCollector implements Player.Listener, AudioRendererEventListener, VideoRendererEventListener, MediaSourceEventListener, BandwidthMeter.EventListener, DrmSessionEventListener {
    private final Clock clock;
    private final SparseArray<AnalyticsListener.EventTime> eventTimes;
    private HandlerWrapper handler;
    private boolean isSeeking;
    private ListenerSet<AnalyticsListener> listeners;
    private final MediaPeriodQueueTracker mediaPeriodQueueTracker;
    private final Timeline.Period period;
    private Player player;
    private final Timeline.Window window = new Timeline.Window();

    static /* synthetic */ void lambda$new$0(AnalyticsListener analyticsListener, FlagSet flagSet) {
    }

    public /* synthetic */ void onAudioInputFormatChanged(Format format) {
        AudioRendererEventListener.CC.$default$onAudioInputFormatChanged(this, format);
    }

    public /* synthetic */ void onCues(List list) {
        Player.Listener.CC.$default$onCues(this, list);
    }

    public /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
        Player.Listener.CC.$default$onDeviceInfoChanged(this, deviceInfo);
    }

    public /* synthetic */ void onDeviceVolumeChanged(int i, boolean z) {
        Player.Listener.CC.$default$onDeviceVolumeChanged(this, i, z);
    }

    public /* synthetic */ void onDrmSessionAcquired(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        DrmSessionEventListener.CC.$default$onDrmSessionAcquired(this, i, mediaPeriodId);
    }

    public /* synthetic */ void onEvents(Player player2, Player.Events events) {
        Player.Listener.CC.$default$onEvents(this, player2, events);
    }

    public /* synthetic */ void onLoadingChanged(boolean z) {
        Player.EventListener.CC.$default$onLoadingChanged(this, z);
    }

    public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
        Player.Listener.CC.$default$onPlayerErrorChanged(this, playbackException);
    }

    public /* synthetic */ void onPositionDiscontinuity(int i) {
        Player.EventListener.CC.$default$onPositionDiscontinuity(this, i);
    }

    public /* synthetic */ void onRenderedFirstFrame() {
        Player.Listener.CC.$default$onRenderedFirstFrame(this);
    }

    public /* synthetic */ void onVideoInputFormatChanged(Format format) {
        VideoRendererEventListener.CC.$default$onVideoInputFormatChanged(this, format);
    }

    public /* synthetic */ void onVideoSizeChanged(int i, int i2, int i3, float f) {
        VideoListener.CC.$default$onVideoSizeChanged(this, i, i2, i3, f);
    }

    public AnalyticsCollector(Clock clock2) {
        this.clock = (Clock) Assertions.checkNotNull(clock2);
        this.listeners = new ListenerSet<>(Util.getCurrentOrMainLooper(), clock2, new AnalyticsCollector$$ExternalSyntheticLambda8());
        Timeline.Period period2 = new Timeline.Period();
        this.period = period2;
        this.mediaPeriodQueueTracker = new MediaPeriodQueueTracker(period2);
        this.eventTimes = new SparseArray<>();
    }

    public void addListener(AnalyticsListener analyticsListener) {
        Assertions.checkNotNull(analyticsListener);
        this.listeners.add(analyticsListener);
    }

    public void removeListener(AnalyticsListener analyticsListener) {
        this.listeners.remove(analyticsListener);
    }

    public void setPlayer(Player player2, Looper looper) {
        Assertions.checkState(this.player == null || this.mediaPeriodQueueTracker.mediaPeriodQueue.isEmpty());
        this.player = (Player) Assertions.checkNotNull(player2);
        this.handler = this.clock.createHandler(looper, (Handler.Callback) null);
        this.listeners = this.listeners.copy(looper, new AnalyticsCollector$$ExternalSyntheticLambda9(this, player2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setPlayer$1$com-google-android-exoplayer2-analytics-AnalyticsCollector  reason: not valid java name */
    public /* synthetic */ void m2022lambda$setPlayer$1$comgoogleandroidexoplayer2analyticsAnalyticsCollector(Player player2, AnalyticsListener analyticsListener, FlagSet flagSet) {
        analyticsListener.onEvents(player2, new AnalyticsListener.Events(flagSet, this.eventTimes));
    }

    public void release() {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        this.eventTimes.put(1036, generateCurrentPlayerMediaPeriodEventTime);
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 1036, new AnalyticsCollector$$ExternalSyntheticLambda31(generateCurrentPlayerMediaPeriodEventTime));
        ((HandlerWrapper) Assertions.checkStateNotNull(this.handler)).post(new AnalyticsCollector$$ExternalSyntheticLambda32(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$release$3$com-google-android-exoplayer2-analytics-AnalyticsCollector  reason: not valid java name */
    public /* synthetic */ void m2021lambda$release$3$comgoogleandroidexoplayer2analyticsAnalyticsCollector() {
        this.listeners.release();
    }

    public final void updateMediaPeriodQueueInfo(List<MediaSource.MediaPeriodId> list, MediaSource.MediaPeriodId mediaPeriodId) {
        this.mediaPeriodQueueTracker.onQueueUpdated(list, mediaPeriodId, (Player) Assertions.checkNotNull(this.player));
    }

    public final void notifySeekStarted() {
        if (!this.isSeeking) {
            AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
            this.isSeeking = true;
            sendEvent(generateCurrentPlayerMediaPeriodEventTime, -1, new AnalyticsCollector$$ExternalSyntheticLambda40(generateCurrentPlayerMediaPeriodEventTime));
        }
    }

    public final void onAudioEnabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1008, new AnalyticsCollector$$ExternalSyntheticLambda18(generateReadingMediaPeriodEventTime, decoderCounters));
    }

    static /* synthetic */ void lambda$onAudioEnabled$5(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioEnabled(eventTime, decoderCounters);
        analyticsListener.onDecoderEnabled(eventTime, 1, decoderCounters);
    }

    public final void onAudioDecoderInitialized(String str, long j, long j2) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1009, new AnalyticsCollector$$ExternalSyntheticLambda26(generateReadingMediaPeriodEventTime, str, j2, j));
    }

    static /* synthetic */ void lambda$onAudioDecoderInitialized$6(AnalyticsListener.EventTime eventTime, String str, long j, long j2, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioDecoderInitialized(eventTime, str, j);
        long j3 = j;
        analyticsListener.onAudioDecoderInitialized(eventTime, str, j2, j3);
        analyticsListener.onDecoderInitialized(eventTime, 1, str, j3);
    }

    public final void onAudioInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1010, new AnalyticsCollector$$ExternalSyntheticLambda15(generateReadingMediaPeriodEventTime, format, decoderReuseEvaluation));
    }

    static /* synthetic */ void lambda$onAudioInputFormatChanged$7(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioInputFormatChanged(eventTime, format);
        analyticsListener.onAudioInputFormatChanged(eventTime, format, decoderReuseEvaluation);
        analyticsListener.onDecoderInputFormatChanged(eventTime, 1, format);
    }

    public final void onAudioPositionAdvancing(long j) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1011, new AnalyticsCollector$$ExternalSyntheticLambda58(generateReadingMediaPeriodEventTime, j));
    }

    public final void onAudioUnderrun(int i, long j, long j2) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1012, new AnalyticsCollector$$ExternalSyntheticLambda54(generateReadingMediaPeriodEventTime, i, j, j2));
    }

    public final void onAudioDecoderReleased(String str) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1013, new AnalyticsCollector$$ExternalSyntheticLambda34(generateReadingMediaPeriodEventTime, str));
    }

    public final void onAudioDisabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(generatePlayingMediaPeriodEventTime, 1014, new AnalyticsCollector$$ExternalSyntheticLambda61(generatePlayingMediaPeriodEventTime, decoderCounters));
    }

    static /* synthetic */ void lambda$onAudioDisabled$11(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioDisabled(eventTime, decoderCounters);
        analyticsListener.onDecoderDisabled(eventTime, 1, decoderCounters);
    }

    public final void onSkipSilenceEnabledChanged(boolean z) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1017, new AnalyticsCollector$$ExternalSyntheticLambda22(generateReadingMediaPeriodEventTime, z));
    }

    public final void onAudioSinkError(Exception exc) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1018, new AnalyticsCollector$$ExternalSyntheticLambda43(generateReadingMediaPeriodEventTime, exc));
    }

    public final void onAudioCodecError(Exception exc) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1037, new AnalyticsCollector$$ExternalSyntheticLambda56(generateReadingMediaPeriodEventTime, exc));
    }

    public final void onAudioSessionIdChanged(int i) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1015, new AnalyticsCollector$$ExternalSyntheticLambda53(generateReadingMediaPeriodEventTime, i));
    }

    public final void onAudioAttributesChanged(AudioAttributes audioAttributes) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1016, new AnalyticsCollector$$ExternalSyntheticLambda41(generateReadingMediaPeriodEventTime, audioAttributes));
    }

    public final void onVolumeChanged(float f) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1019, new AnalyticsCollector$$ExternalSyntheticLambda39(generateReadingMediaPeriodEventTime, f));
    }

    public final void onVideoEnabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1020, new AnalyticsCollector$$ExternalSyntheticLambda47(generateReadingMediaPeriodEventTime, decoderCounters));
    }

    static /* synthetic */ void lambda$onVideoEnabled$18(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoEnabled(eventTime, decoderCounters);
        analyticsListener.onDecoderEnabled(eventTime, 2, decoderCounters);
    }

    public final void onVideoDecoderInitialized(String str, long j, long j2) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1021, new AnalyticsCollector$$ExternalSyntheticLambda60(generateReadingMediaPeriodEventTime, str, j2, j));
    }

    static /* synthetic */ void lambda$onVideoDecoderInitialized$19(AnalyticsListener.EventTime eventTime, String str, long j, long j2, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoDecoderInitialized(eventTime, str, j);
        long j3 = j;
        analyticsListener.onVideoDecoderInitialized(eventTime, str, j2, j3);
        analyticsListener.onDecoderInitialized(eventTime, 2, str, j3);
    }

    public final void onVideoInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1022, new AnalyticsCollector$$ExternalSyntheticLambda5(generateReadingMediaPeriodEventTime, format, decoderReuseEvaluation));
    }

    static /* synthetic */ void lambda$onVideoInputFormatChanged$20(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoInputFormatChanged(eventTime, format);
        analyticsListener.onVideoInputFormatChanged(eventTime, format, decoderReuseEvaluation);
        analyticsListener.onDecoderInputFormatChanged(eventTime, 2, format);
    }

    public final void onDroppedFrames(int i, long j) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(generatePlayingMediaPeriodEventTime, 1023, new AnalyticsCollector$$ExternalSyntheticLambda62(generatePlayingMediaPeriodEventTime, i, j));
    }

    public final void onVideoDecoderReleased(String str) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1024, new AnalyticsCollector$$ExternalSyntheticLambda2(generateReadingMediaPeriodEventTime, str));
    }

    public final void onVideoDisabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(generatePlayingMediaPeriodEventTime, 1025, new AnalyticsCollector$$ExternalSyntheticLambda29(generatePlayingMediaPeriodEventTime, decoderCounters));
    }

    static /* synthetic */ void lambda$onVideoDisabled$23(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoDisabled(eventTime, decoderCounters);
        analyticsListener.onDecoderDisabled(eventTime, 2, decoderCounters);
    }

    public final void onVideoSizeChanged(VideoSize videoSize) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1028, new AnalyticsCollector$$ExternalSyntheticLambda44(generateReadingMediaPeriodEventTime, videoSize));
    }

    static /* synthetic */ void lambda$onVideoSizeChanged$24(AnalyticsListener.EventTime eventTime, VideoSize videoSize, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoSizeChanged(eventTime, videoSize);
        analyticsListener.onVideoSizeChanged(eventTime, videoSize.width, videoSize.height, videoSize.unappliedRotationDegrees, videoSize.pixelWidthHeightRatio);
    }

    public final void onRenderedFirstFrame(Object obj, long j) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1027, new AnalyticsCollector$$ExternalSyntheticLambda6(generateReadingMediaPeriodEventTime, obj, j));
    }

    public final void onVideoFrameProcessingOffset(long j, int i) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(generatePlayingMediaPeriodEventTime, 1026, new AnalyticsCollector$$ExternalSyntheticLambda10(generatePlayingMediaPeriodEventTime, j, i));
    }

    public final void onVideoCodecError(Exception exc) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1038, new AnalyticsCollector$$ExternalSyntheticLambda36(generateReadingMediaPeriodEventTime, exc));
    }

    public void onSurfaceSizeChanged(int i, int i2) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1029, new AnalyticsCollector$$ExternalSyntheticLambda14(generateReadingMediaPeriodEventTime, i, i2));
    }

    public final void onLoadStarted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1000, new AnalyticsCollector$$ExternalSyntheticLambda20(generateMediaPeriodEventTime, loadEventInfo, mediaLoadData));
    }

    public final void onLoadCompleted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1001, new AnalyticsCollector$$ExternalSyntheticLambda30(generateMediaPeriodEventTime, loadEventInfo, mediaLoadData));
    }

    public final void onLoadCanceled(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1002, new AnalyticsCollector$$ExternalSyntheticLambda55(generateMediaPeriodEventTime, loadEventInfo, mediaLoadData));
    }

    public final void onLoadError(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1003, new AnalyticsCollector$$ExternalSyntheticLambda16(generateMediaPeriodEventTime, loadEventInfo, mediaLoadData, iOException, z));
    }

    public final void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1005, new AnalyticsCollector$$ExternalSyntheticLambda37(generateMediaPeriodEventTime, mediaLoadData));
    }

    public final void onDownstreamFormatChanged(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1004, new AnalyticsCollector$$ExternalSyntheticLambda52(generateMediaPeriodEventTime, mediaLoadData));
    }

    public final void onTimelineChanged(Timeline timeline, int i) {
        this.mediaPeriodQueueTracker.onTimelineChanged((Player) Assertions.checkNotNull(this.player));
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 0, new AnalyticsCollector$$ExternalSyntheticLambda4(generateCurrentPlayerMediaPeriodEventTime, i));
    }

    public final void onMediaItemTransition(MediaItem mediaItem, int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 1, new AnalyticsCollector$$ExternalSyntheticLambda21(generateCurrentPlayerMediaPeriodEventTime, mediaItem, i));
    }

    public final void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 2, new AnalyticsCollector$$ExternalSyntheticLambda59(generateCurrentPlayerMediaPeriodEventTime, trackGroupArray, trackSelectionArray));
    }

    @Deprecated
    public final void onStaticMetadataChanged(List<Metadata> list) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 3, new AnalyticsCollector$$ExternalSyntheticLambda19(generateCurrentPlayerMediaPeriodEventTime, list));
    }

    public final void onIsLoadingChanged(boolean z) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 4, new AnalyticsCollector$$ExternalSyntheticLambda45(generateCurrentPlayerMediaPeriodEventTime, z));
    }

    static /* synthetic */ void lambda$onIsLoadingChanged$39(AnalyticsListener.EventTime eventTime, boolean z, AnalyticsListener analyticsListener) {
        analyticsListener.onLoadingChanged(eventTime, z);
        analyticsListener.onIsLoadingChanged(eventTime, z);
    }

    public void onAvailableCommandsChanged(Player.Commands commands) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 14, new AnalyticsCollector$$ExternalSyntheticLambda49(generateCurrentPlayerMediaPeriodEventTime, commands));
    }

    public final void onPlayerStateChanged(boolean z, int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, -1, new AnalyticsCollector$$ExternalSyntheticLambda1(generateCurrentPlayerMediaPeriodEventTime, z, i));
    }

    public final void onPlaybackStateChanged(int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 5, new AnalyticsCollector$$ExternalSyntheticLambda50(generateCurrentPlayerMediaPeriodEventTime, i));
    }

    public final void onPlayWhenReadyChanged(boolean z, int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 6, new AnalyticsCollector$$ExternalSyntheticLambda63(generateCurrentPlayerMediaPeriodEventTime, z, i));
    }

    public final void onPlaybackSuppressionReasonChanged(int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 7, new AnalyticsCollector$$ExternalSyntheticLambda33(generateCurrentPlayerMediaPeriodEventTime, i));
    }

    public void onIsPlayingChanged(boolean z) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 8, new AnalyticsCollector$$ExternalSyntheticLambda57(generateCurrentPlayerMediaPeriodEventTime, z));
    }

    public final void onRepeatModeChanged(int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 9, new AnalyticsCollector$$ExternalSyntheticLambda64(generateCurrentPlayerMediaPeriodEventTime, i));
    }

    public final void onShuffleModeEnabledChanged(boolean z) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 10, new AnalyticsCollector$$ExternalSyntheticLambda17(generateCurrentPlayerMediaPeriodEventTime, z));
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPlayerError(com.google.android.exoplayer2.PlaybackException r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof com.google.android.exoplayer2.ExoPlaybackException
            if (r0 == 0) goto L_0x0017
            r0 = r3
            com.google.android.exoplayer2.ExoPlaybackException r0 = (com.google.android.exoplayer2.ExoPlaybackException) r0
            com.google.android.exoplayer2.source.MediaPeriodId r1 = r0.mediaPeriodId
            if (r1 == 0) goto L_0x0017
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = new com.google.android.exoplayer2.source.MediaSource$MediaPeriodId
            com.google.android.exoplayer2.source.MediaPeriodId r0 = r0.mediaPeriodId
            r1.<init>((com.google.android.exoplayer2.source.MediaPeriodId) r0)
            com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime r0 = r2.generateEventTime(r1)
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 != 0) goto L_0x001e
            com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime r0 = r2.generateCurrentPlayerMediaPeriodEventTime()
        L_0x001e:
            com.google.android.exoplayer2.analytics.AnalyticsCollector$$ExternalSyntheticLambda11 r1 = new com.google.android.exoplayer2.analytics.AnalyticsCollector$$ExternalSyntheticLambda11
            r1.<init>(r0, r3)
            r3 = 11
            r2.sendEvent(r0, r3, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.analytics.AnalyticsCollector.onPlayerError(com.google.android.exoplayer2.PlaybackException):void");
    }

    public final void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
        if (i == 1) {
            this.isSeeking = false;
        }
        this.mediaPeriodQueueTracker.onPositionDiscontinuity((Player) Assertions.checkNotNull(this.player));
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 12, new AnalyticsCollector$$ExternalSyntheticLambda42(generateCurrentPlayerMediaPeriodEventTime, i, positionInfo, positionInfo2));
    }

    static /* synthetic */ void lambda$onPositionDiscontinuity$49(AnalyticsListener.EventTime eventTime, int i, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, AnalyticsListener analyticsListener) {
        analyticsListener.onPositionDiscontinuity(eventTime, i);
        analyticsListener.onPositionDiscontinuity(eventTime, positionInfo, positionInfo2, i);
    }

    public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 13, new AnalyticsCollector$$ExternalSyntheticLambda35(generateCurrentPlayerMediaPeriodEventTime, playbackParameters));
    }

    public void onSeekBackIncrementChanged(long j) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 17, new AnalyticsCollector$$ExternalSyntheticLambda3(generateCurrentPlayerMediaPeriodEventTime, j));
    }

    public void onSeekForwardIncrementChanged(long j) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 18, new AnalyticsCollector$$ExternalSyntheticLambda23(generateCurrentPlayerMediaPeriodEventTime, j));
    }

    public void onMaxSeekToPreviousPositionChanged(int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 19, new AnalyticsCollector$$ExternalSyntheticLambda46(generateCurrentPlayerMediaPeriodEventTime, i));
    }

    public void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 15, new AnalyticsCollector$$ExternalSyntheticLambda28(generateCurrentPlayerMediaPeriodEventTime, mediaMetadata));
    }

    public void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 16, new AnalyticsCollector$$ExternalSyntheticLambda48(generateCurrentPlayerMediaPeriodEventTime, mediaMetadata));
    }

    public final void onMetadata(Metadata metadata) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 1007, new AnalyticsCollector$$ExternalSyntheticLambda12(generateCurrentPlayerMediaPeriodEventTime, metadata));
    }

    public final void onSeekProcessed() {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, -1, new AnalyticsCollector$$ExternalSyntheticLambda0(generateCurrentPlayerMediaPeriodEventTime));
    }

    public final void onBandwidthSample(int i, long j, long j2) {
        AnalyticsListener.EventTime generateLoadingMediaPeriodEventTime = generateLoadingMediaPeriodEventTime();
        sendEvent(generateLoadingMediaPeriodEventTime, 1006, new AnalyticsCollector$$ExternalSyntheticLambda38(generateLoadingMediaPeriodEventTime, i, j, j2));
    }

    public final void onDrmSessionAcquired(int i, MediaSource.MediaPeriodId mediaPeriodId, int i2) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1030, new AnalyticsCollector$$ExternalSyntheticLambda27(generateMediaPeriodEventTime, i2));
    }

    static /* synthetic */ void lambda$onDrmSessionAcquired$59(AnalyticsListener.EventTime eventTime, int i, AnalyticsListener analyticsListener) {
        analyticsListener.onDrmSessionAcquired(eventTime);
        analyticsListener.onDrmSessionAcquired(eventTime, i);
    }

    public final void onDrmKeysLoaded(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1031, new AnalyticsCollector$$ExternalSyntheticLambda13(generateMediaPeriodEventTime));
    }

    public final void onDrmSessionManagerError(int i, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1032, new AnalyticsCollector$$ExternalSyntheticLambda25(generateMediaPeriodEventTime, exc));
    }

    public final void onDrmKeysRestored(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1033, new AnalyticsCollector$$ExternalSyntheticLambda24(generateMediaPeriodEventTime));
    }

    public final void onDrmKeysRemoved(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1034, new AnalyticsCollector$$ExternalSyntheticLambda7(generateMediaPeriodEventTime));
    }

    public final void onDrmSessionReleased(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1035, new AnalyticsCollector$$ExternalSyntheticLambda51(generateMediaPeriodEventTime));
    }

    /* access modifiers changed from: protected */
    public final void sendEvent(AnalyticsListener.EventTime eventTime, int i, ListenerSet.Event<AnalyticsListener> event) {
        this.eventTimes.put(i, eventTime);
        this.listeners.sendEvent(i, event);
    }

    /* access modifiers changed from: protected */
    public final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getCurrentPlayerMediaPeriod());
    }

    /* access modifiers changed from: protected */
    @RequiresNonNull({"player"})
    public final AnalyticsListener.EventTime generateEventTime(Timeline timeline, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        long j;
        Timeline timeline2 = timeline;
        int i2 = i;
        MediaSource.MediaPeriodId mediaPeriodId2 = timeline.isEmpty() ? null : mediaPeriodId;
        long elapsedRealtime = this.clock.elapsedRealtime();
        boolean z = true;
        boolean z2 = timeline2.equals(this.player.getCurrentTimeline()) && i2 == this.player.getCurrentWindowIndex();
        long j2 = 0;
        if (mediaPeriodId2 != null && mediaPeriodId2.isAd()) {
            if (!(z2 && this.player.getCurrentAdGroupIndex() == mediaPeriodId2.adGroupIndex && this.player.getCurrentAdIndexInAdGroup() == mediaPeriodId2.adIndexInAdGroup)) {
                z = false;
            }
            if (z) {
                j2 = this.player.getCurrentPosition();
            }
        } else if (z2) {
            j = this.player.getContentPosition();
            return new AnalyticsListener.EventTime(elapsedRealtime, timeline, i, mediaPeriodId2, j, this.player.getCurrentTimeline(), this.player.getCurrentWindowIndex(), this.mediaPeriodQueueTracker.getCurrentPlayerMediaPeriod(), this.player.getCurrentPosition(), this.player.getTotalBufferedDuration());
        } else if (!timeline.isEmpty()) {
            j2 = timeline2.getWindow(i2, this.window).getDefaultPositionMs();
        }
        j = j2;
        return new AnalyticsListener.EventTime(elapsedRealtime, timeline, i, mediaPeriodId2, j, this.player.getCurrentTimeline(), this.player.getCurrentWindowIndex(), this.mediaPeriodQueueTracker.getCurrentPlayerMediaPeriod(), this.player.getCurrentPosition(), this.player.getTotalBufferedDuration());
    }

    private AnalyticsListener.EventTime generateEventTime(MediaSource.MediaPeriodId mediaPeriodId) {
        Timeline timeline;
        Assertions.checkNotNull(this.player);
        if (mediaPeriodId == null) {
            timeline = null;
        } else {
            timeline = this.mediaPeriodQueueTracker.getMediaPeriodIdTimeline(mediaPeriodId);
        }
        if (mediaPeriodId != null && timeline != null) {
            return generateEventTime(timeline, timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, mediaPeriodId);
        }
        int currentWindowIndex = this.player.getCurrentWindowIndex();
        Timeline currentTimeline = this.player.getCurrentTimeline();
        if (!(currentWindowIndex < currentTimeline.getWindowCount())) {
            currentTimeline = Timeline.EMPTY;
        }
        return generateEventTime(currentTimeline, currentWindowIndex, (MediaSource.MediaPeriodId) null);
    }

    private AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getPlayingMediaPeriod());
    }

    private AnalyticsListener.EventTime generateReadingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getReadingMediaPeriod());
    }

    private AnalyticsListener.EventTime generateLoadingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getLoadingMediaPeriod());
    }

    private AnalyticsListener.EventTime generateMediaPeriodEventTime(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.checkNotNull(this.player);
        boolean z = true;
        if (mediaPeriodId != null) {
            if (this.mediaPeriodQueueTracker.getMediaPeriodIdTimeline(mediaPeriodId) == null) {
                z = false;
            }
            if (z) {
                return generateEventTime(mediaPeriodId);
            }
            return generateEventTime(Timeline.EMPTY, i, mediaPeriodId);
        }
        Timeline currentTimeline = this.player.getCurrentTimeline();
        if (i >= currentTimeline.getWindowCount()) {
            z = false;
        }
        if (!z) {
            currentTimeline = Timeline.EMPTY;
        }
        return generateEventTime(currentTimeline, i, (MediaSource.MediaPeriodId) null);
    }

    private static final class MediaPeriodQueueTracker {
        private MediaSource.MediaPeriodId currentPlayerMediaPeriod;
        /* access modifiers changed from: private */
        public ImmutableList<MediaSource.MediaPeriodId> mediaPeriodQueue = ImmutableList.of();
        private ImmutableMap<MediaSource.MediaPeriodId, Timeline> mediaPeriodTimelines = ImmutableMap.of();
        private final Timeline.Period period;
        private MediaSource.MediaPeriodId playingMediaPeriod;
        private MediaSource.MediaPeriodId readingMediaPeriod;

        public MediaPeriodQueueTracker(Timeline.Period period2) {
            this.period = period2;
        }

        public MediaSource.MediaPeriodId getCurrentPlayerMediaPeriod() {
            return this.currentPlayerMediaPeriod;
        }

        public MediaSource.MediaPeriodId getPlayingMediaPeriod() {
            return this.playingMediaPeriod;
        }

        public MediaSource.MediaPeriodId getReadingMediaPeriod() {
            return this.readingMediaPeriod;
        }

        public MediaSource.MediaPeriodId getLoadingMediaPeriod() {
            if (this.mediaPeriodQueue.isEmpty()) {
                return null;
            }
            return (MediaSource.MediaPeriodId) Iterables.getLast(this.mediaPeriodQueue);
        }

        public Timeline getMediaPeriodIdTimeline(MediaSource.MediaPeriodId mediaPeriodId) {
            return this.mediaPeriodTimelines.get(mediaPeriodId);
        }

        public void onPositionDiscontinuity(Player player) {
            this.currentPlayerMediaPeriod = findCurrentPlayerMediaPeriodInQueue(player, this.mediaPeriodQueue, this.playingMediaPeriod, this.period);
        }

        public void onTimelineChanged(Player player) {
            this.currentPlayerMediaPeriod = findCurrentPlayerMediaPeriodInQueue(player, this.mediaPeriodQueue, this.playingMediaPeriod, this.period);
            updateMediaPeriodTimelines(player.getCurrentTimeline());
        }

        public void onQueueUpdated(List<MediaSource.MediaPeriodId> list, MediaSource.MediaPeriodId mediaPeriodId, Player player) {
            this.mediaPeriodQueue = ImmutableList.copyOf(list);
            if (!list.isEmpty()) {
                this.playingMediaPeriod = list.get(0);
                this.readingMediaPeriod = (MediaSource.MediaPeriodId) Assertions.checkNotNull(mediaPeriodId);
            }
            if (this.currentPlayerMediaPeriod == null) {
                this.currentPlayerMediaPeriod = findCurrentPlayerMediaPeriodInQueue(player, this.mediaPeriodQueue, this.playingMediaPeriod, this.period);
            }
            updateMediaPeriodTimelines(player.getCurrentTimeline());
        }

        private void updateMediaPeriodTimelines(Timeline timeline) {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            if (this.mediaPeriodQueue.isEmpty()) {
                addTimelineForMediaPeriodId(builder, this.playingMediaPeriod, timeline);
                if (!Objects.equal(this.readingMediaPeriod, this.playingMediaPeriod)) {
                    addTimelineForMediaPeriodId(builder, this.readingMediaPeriod, timeline);
                }
                if (!Objects.equal(this.currentPlayerMediaPeriod, this.playingMediaPeriod) && !Objects.equal(this.currentPlayerMediaPeriod, this.readingMediaPeriod)) {
                    addTimelineForMediaPeriodId(builder, this.currentPlayerMediaPeriod, timeline);
                }
            } else {
                for (int i = 0; i < this.mediaPeriodQueue.size(); i++) {
                    addTimelineForMediaPeriodId(builder, (MediaSource.MediaPeriodId) this.mediaPeriodQueue.get(i), timeline);
                }
                if (!this.mediaPeriodQueue.contains(this.currentPlayerMediaPeriod)) {
                    addTimelineForMediaPeriodId(builder, this.currentPlayerMediaPeriod, timeline);
                }
            }
            this.mediaPeriodTimelines = builder.build();
        }

        private void addTimelineForMediaPeriodId(ImmutableMap.Builder<MediaSource.MediaPeriodId, Timeline> builder, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            if (mediaPeriodId != null) {
                if (timeline.getIndexOfPeriod(mediaPeriodId.periodUid) != -1) {
                    builder.put(mediaPeriodId, timeline);
                    return;
                }
                Timeline timeline2 = this.mediaPeriodTimelines.get(mediaPeriodId);
                if (timeline2 != null) {
                    builder.put(mediaPeriodId, timeline2);
                }
            }
        }

        private static MediaSource.MediaPeriodId findCurrentPlayerMediaPeriodInQueue(Player player, ImmutableList<MediaSource.MediaPeriodId> immutableList, MediaSource.MediaPeriodId mediaPeriodId, Timeline.Period period2) {
            Timeline currentTimeline = player.getCurrentTimeline();
            int currentPeriodIndex = player.getCurrentPeriodIndex();
            Object uidOfPeriod = currentTimeline.isEmpty() ? null : currentTimeline.getUidOfPeriod(currentPeriodIndex);
            int adGroupIndexAfterPositionUs = (player.isPlayingAd() || currentTimeline.isEmpty()) ? -1 : currentTimeline.getPeriod(currentPeriodIndex, period2).getAdGroupIndexAfterPositionUs(C.msToUs(player.getCurrentPosition()) - period2.getPositionInWindowUs());
            for (int i = 0; i < immutableList.size(); i++) {
                MediaSource.MediaPeriodId mediaPeriodId2 = (MediaSource.MediaPeriodId) immutableList.get(i);
                if (isMatchingMediaPeriod(mediaPeriodId2, uidOfPeriod, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), adGroupIndexAfterPositionUs)) {
                    return mediaPeriodId2;
                }
            }
            if (immutableList.isEmpty() && mediaPeriodId != null) {
                if (isMatchingMediaPeriod(mediaPeriodId, uidOfPeriod, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), adGroupIndexAfterPositionUs)) {
                    return mediaPeriodId;
                }
            }
            return null;
        }

        private static boolean isMatchingMediaPeriod(MediaSource.MediaPeriodId mediaPeriodId, Object obj, boolean z, int i, int i2, int i3) {
            if (!mediaPeriodId.periodUid.equals(obj)) {
                return false;
            }
            if ((z && mediaPeriodId.adGroupIndex == i && mediaPeriodId.adIndexInAdGroup == i2) || (!z && mediaPeriodId.adGroupIndex == -1 && mediaPeriodId.nextAdGroupIndex == i3)) {
                return true;
            }
            return false;
        }
    }
}
