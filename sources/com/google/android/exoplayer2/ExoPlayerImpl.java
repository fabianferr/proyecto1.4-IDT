package com.google.android.exoplayer2;

import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerImplInternal;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.device.DeviceInfo;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

final class ExoPlayerImpl extends BasePlayer implements ExoPlayer {
    private static final String TAG = "ExoPlayerImpl";
    private final AnalyticsCollector analyticsCollector;
    private final Looper applicationLooper;
    private final CopyOnWriteArraySet<ExoPlayer.AudioOffloadListener> audioOffloadListeners;
    private Player.Commands availableCommands;
    private final BandwidthMeter bandwidthMeter;
    private final Clock clock;
    final TrackSelectorResult emptyTrackSelectorResult;
    private boolean foregroundMode;
    private final ExoPlayerImplInternal internalPlayer;
    private final ListenerSet<Player.EventListener> listeners;
    private int maskingPeriodIndex;
    private int maskingWindowIndex;
    private long maskingWindowPositionMs;
    private MediaMetadata mediaMetadata;
    private final MediaSourceFactory mediaSourceFactory;
    private final List<MediaSourceHolderSnapshot> mediaSourceHolderSnapshots;
    private boolean pauseAtEndOfMediaItems;
    private boolean pendingDiscontinuity;
    private int pendingDiscontinuityReason;
    private int pendingOperationAcks;
    private int pendingPlayWhenReadyChangeReason;
    private final Timeline.Period period;
    final Player.Commands permanentAvailableCommands;
    private PlaybackInfo playbackInfo;
    private final HandlerWrapper playbackInfoUpdateHandler;
    private final ExoPlayerImplInternal.PlaybackInfoUpdateListener playbackInfoUpdateListener;
    private MediaMetadata playlistMetadata;
    private final Renderer[] renderers;
    private int repeatMode;
    private final long seekBackIncrementMs;
    private final long seekForwardIncrementMs;
    private SeekParameters seekParameters;
    private boolean shuffleModeEnabled;
    private ShuffleOrder shuffleOrder;
    private final TrackSelector trackSelector;
    private final boolean useLazyPreparation;

    public void clearVideoSurface() {
    }

    public void clearVideoSurface(Surface surface) {
    }

    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
    }

    public void clearVideoSurfaceView(SurfaceView surfaceView) {
    }

    public void clearVideoTextureView(TextureView textureView) {
    }

    public void decreaseDeviceVolume() {
    }

    public ExoPlayer.AudioComponent getAudioComponent() {
        return null;
    }

    public ExoPlayer.DeviceComponent getDeviceComponent() {
        return null;
    }

    public int getDeviceVolume() {
        return 0;
    }

    public int getMaxSeekToPreviousPosition() {
        return 3000;
    }

    public ExoPlayer.MetadataComponent getMetadataComponent() {
        return null;
    }

    public ExoPlayer.TextComponent getTextComponent() {
        return null;
    }

    public ExoPlayer.VideoComponent getVideoComponent() {
        return null;
    }

    public float getVolume() {
        return 1.0f;
    }

    public void increaseDeviceVolume() {
    }

    public boolean isDeviceMuted() {
        return false;
    }

    public void setDeviceMuted(boolean z) {
    }

    public void setDeviceVolume(int i) {
    }

    public void setVideoSurface(Surface surface) {
    }

    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
    }

    public void setVideoSurfaceView(SurfaceView surfaceView) {
    }

    public void setVideoTextureView(TextureView textureView) {
    }

    public void setVolume(float f) {
    }

    /* JADX WARNING: type inference failed for: r38v0, types: [com.google.android.exoplayer2.Player] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ExoPlayerImpl(com.google.android.exoplayer2.Renderer[] r20, com.google.android.exoplayer2.trackselection.TrackSelector r21, com.google.android.exoplayer2.source.MediaSourceFactory r22, com.google.android.exoplayer2.LoadControl r23, com.google.android.exoplayer2.upstream.BandwidthMeter r24, com.google.android.exoplayer2.analytics.AnalyticsCollector r25, boolean r26, com.google.android.exoplayer2.SeekParameters r27, long r28, long r30, com.google.android.exoplayer2.LivePlaybackSpeedControl r32, long r33, boolean r35, com.google.android.exoplayer2.util.Clock r36, android.os.Looper r37, com.google.android.exoplayer2.Player r38, com.google.android.exoplayer2.Player.Commands r39) {
        /*
            r19 = this;
            r0 = r19
            r2 = r20
            r6 = r24
            r9 = r25
            r15 = r36
            r14 = r37
            r19.<init>()
            int r1 = java.lang.System.identityHashCode(r19)
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
            java.lang.String r3 = com.google.android.exoplayer2.util.Util.DEVICE_DEBUG_INFO
            java.lang.String r4 = java.lang.String.valueOf(r1)
            int r4 = r4.length()
            int r4 = r4 + 30
            java.lang.String r5 = java.lang.String.valueOf(r3)
            int r5 = r5.length()
            int r4 = r4 + r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "Init "
            r5.append(r4)
            r5.append(r1)
            java.lang.String r1 = " [ExoPlayerLib/2.15.1] ["
            r5.append(r1)
            r5.append(r3)
            java.lang.String r1 = "]"
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            java.lang.String r3 = "ExoPlayerImpl"
            com.google.android.exoplayer2.util.Log.i(r3, r1)
            int r1 = r2.length
            r3 = 0
            if (r1 <= 0) goto L_0x0055
            r1 = 1
            goto L_0x0056
        L_0x0055:
            r1 = 0
        L_0x0056:
            com.google.android.exoplayer2.util.Assertions.checkState(r1)
            java.lang.Object r1 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r20)
            com.google.android.exoplayer2.Renderer[] r1 = (com.google.android.exoplayer2.Renderer[]) r1
            r0.renderers = r1
            java.lang.Object r1 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r21)
            com.google.android.exoplayer2.trackselection.TrackSelector r1 = (com.google.android.exoplayer2.trackselection.TrackSelector) r1
            r0.trackSelector = r1
            r1 = r22
            r0.mediaSourceFactory = r1
            r0.bandwidthMeter = r6
            r0.analyticsCollector = r9
            r1 = r26
            r0.useLazyPreparation = r1
            r10 = r27
            r0.seekParameters = r10
            r4 = r28
            r0.seekBackIncrementMs = r4
            r4 = r30
            r0.seekForwardIncrementMs = r4
            r12 = r35
            r0.pauseAtEndOfMediaItems = r12
            r0.applicationLooper = r14
            r0.clock = r15
            r0.repeatMode = r3
            if (r38 == 0) goto L_0x0090
            r1 = r38
            goto L_0x0091
        L_0x0090:
            r1 = r0
        L_0x0091:
            com.google.android.exoplayer2.util.ListenerSet r4 = new com.google.android.exoplayer2.util.ListenerSet
            com.google.android.exoplayer2.ExoPlayerImpl$$ExternalSyntheticLambda15 r5 = new com.google.android.exoplayer2.ExoPlayerImpl$$ExternalSyntheticLambda15
            r5.<init>(r1)
            r4.<init>(r14, r15, r5)
            r0.listeners = r4
            java.util.concurrent.CopyOnWriteArraySet r4 = new java.util.concurrent.CopyOnWriteArraySet
            r4.<init>()
            r0.audioOffloadListeners = r4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r0.mediaSourceHolderSnapshots = r4
            com.google.android.exoplayer2.source.ShuffleOrder$DefaultShuffleOrder r4 = new com.google.android.exoplayer2.source.ShuffleOrder$DefaultShuffleOrder
            r4.<init>(r3)
            r0.shuffleOrder = r4
            com.google.android.exoplayer2.trackselection.TrackSelectorResult r4 = new com.google.android.exoplayer2.trackselection.TrackSelectorResult
            int r3 = r2.length
            com.google.android.exoplayer2.RendererConfiguration[] r3 = new com.google.android.exoplayer2.RendererConfiguration[r3]
            int r5 = r2.length
            com.google.android.exoplayer2.trackselection.ExoTrackSelection[] r5 = new com.google.android.exoplayer2.trackselection.ExoTrackSelection[r5]
            r7 = 0
            r4.<init>(r3, r5, r7)
            r0.emptyTrackSelectorResult = r4
            com.google.android.exoplayer2.Timeline$Period r3 = new com.google.android.exoplayer2.Timeline$Period
            r3.<init>()
            r0.period = r3
            com.google.android.exoplayer2.Player$Commands$Builder r3 = new com.google.android.exoplayer2.Player$Commands$Builder
            r3.<init>()
            r5 = 10
            int[] r5 = new int[r5]
            r5 = {1, 2, 12, 13, 14, 15, 16, 17, 18, 19} // fill-array
            com.google.android.exoplayer2.Player$Commands$Builder r3 = r3.addAll((int[]) r5)
            r5 = r39
            com.google.android.exoplayer2.Player$Commands$Builder r3 = r3.addAll((com.google.android.exoplayer2.Player.Commands) r5)
            com.google.android.exoplayer2.Player$Commands r3 = r3.build()
            r0.permanentAvailableCommands = r3
            com.google.android.exoplayer2.Player$Commands$Builder r5 = new com.google.android.exoplayer2.Player$Commands$Builder
            r5.<init>()
            com.google.android.exoplayer2.Player$Commands$Builder r3 = r5.addAll((com.google.android.exoplayer2.Player.Commands) r3)
            r5 = 3
            com.google.android.exoplayer2.Player$Commands$Builder r3 = r3.add(r5)
            r5 = 9
            com.google.android.exoplayer2.Player$Commands$Builder r3 = r3.add(r5)
            com.google.android.exoplayer2.Player$Commands r3 = r3.build()
            r0.availableCommands = r3
            com.google.android.exoplayer2.MediaMetadata r3 = com.google.android.exoplayer2.MediaMetadata.EMPTY
            r0.mediaMetadata = r3
            com.google.android.exoplayer2.MediaMetadata r3 = com.google.android.exoplayer2.MediaMetadata.EMPTY
            r0.playlistMetadata = r3
            r3 = -1
            r0.maskingWindowIndex = r3
            com.google.android.exoplayer2.util.HandlerWrapper r3 = r15.createHandler(r14, r7)
            r0.playbackInfoUpdateHandler = r3
            com.google.android.exoplayer2.ExoPlayerImpl$$ExternalSyntheticLambda16 r13 = new com.google.android.exoplayer2.ExoPlayerImpl$$ExternalSyntheticLambda16
            r13.<init>(r0)
            r0.playbackInfoUpdateListener = r13
            com.google.android.exoplayer2.PlaybackInfo r3 = com.google.android.exoplayer2.PlaybackInfo.createDummy(r4)
            r0.playbackInfo = r3
            if (r9 == 0) goto L_0x012b
            r9.setPlayer(r1, r14)
            r0.addListener((com.google.android.exoplayer2.Player.Listener) r9)
            android.os.Handler r1 = new android.os.Handler
            r1.<init>(r14)
            r6.addEventListener(r1, r9)
        L_0x012b:
            com.google.android.exoplayer2.ExoPlayerImplInternal r11 = new com.google.android.exoplayer2.ExoPlayerImplInternal
            r1 = r11
            int r7 = r0.repeatMode
            boolean r8 = r0.shuffleModeEnabled
            r2 = r20
            r3 = r21
            r5 = r23
            r6 = r24
            r9 = r25
            r10 = r27
            r18 = r11
            r11 = r32
            r17 = r13
            r12 = r33
            r14 = r35
            r15 = r37
            r16 = r36
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17)
            r1 = r18
            r0.internalPlayer = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImpl.<init>(com.google.android.exoplayer2.Renderer[], com.google.android.exoplayer2.trackselection.TrackSelector, com.google.android.exoplayer2.source.MediaSourceFactory, com.google.android.exoplayer2.LoadControl, com.google.android.exoplayer2.upstream.BandwidthMeter, com.google.android.exoplayer2.analytics.AnalyticsCollector, boolean, com.google.android.exoplayer2.SeekParameters, long, long, com.google.android.exoplayer2.LivePlaybackSpeedControl, long, boolean, com.google.android.exoplayer2.util.Clock, android.os.Looper, com.google.android.exoplayer2.Player, com.google.android.exoplayer2.Player$Commands):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$2$com-google-android-exoplayer2-ExoPlayerImpl  reason: not valid java name */
    public /* synthetic */ void m2011lambda$new$2$comgoogleandroidexoplayer2ExoPlayerImpl(ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        this.playbackInfoUpdateHandler.post(new ExoPlayerImpl$$ExternalSyntheticLambda0(this, playbackInfoUpdate));
    }

    public void experimentalSetForegroundModeTimeoutMs(long j) {
        this.internalPlayer.experimentalSetForegroundModeTimeoutMs(j);
    }

    public void experimentalSetOffloadSchedulingEnabled(boolean z) {
        this.internalPlayer.experimentalSetOffloadSchedulingEnabled(z);
    }

    public boolean experimentalIsSleepingForOffload() {
        return this.playbackInfo.sleepingForOffload;
    }

    public Looper getPlaybackLooper() {
        return this.internalPlayer.getPlaybackLooper();
    }

    public Looper getApplicationLooper() {
        return this.applicationLooper;
    }

    public Clock getClock() {
        return this.clock;
    }

    public void addListener(Player.Listener listener) {
        addListener((Player.EventListener) listener);
    }

    public void addListener(Player.EventListener eventListener) {
        this.listeners.add(eventListener);
    }

    public void removeListener(Player.Listener listener) {
        removeListener((Player.EventListener) listener);
    }

    public void removeListener(Player.EventListener eventListener) {
        this.listeners.remove(eventListener);
    }

    public void addAudioOffloadListener(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        this.audioOffloadListeners.add(audioOffloadListener);
    }

    public void removeAudioOffloadListener(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        this.audioOffloadListeners.remove(audioOffloadListener);
    }

    public Player.Commands getAvailableCommands() {
        return this.availableCommands;
    }

    public int getPlaybackState() {
        return this.playbackInfo.playbackState;
    }

    public int getPlaybackSuppressionReason() {
        return this.playbackInfo.playbackSuppressionReason;
    }

    public ExoPlaybackException getPlayerError() {
        return this.playbackInfo.playbackError;
    }

    @Deprecated
    public void retry() {
        prepare();
    }

    public void prepare() {
        if (this.playbackInfo.playbackState == 1) {
            PlaybackInfo copyWithPlaybackError = this.playbackInfo.copyWithPlaybackError((ExoPlaybackException) null);
            PlaybackInfo copyWithPlaybackState = copyWithPlaybackError.copyWithPlaybackState(copyWithPlaybackError.timeline.isEmpty() ? 4 : 2);
            this.pendingOperationAcks++;
            this.internalPlayer.prepare();
            updatePlaybackInfo(copyWithPlaybackState, 1, 1, false, false, 5, -9223372036854775807L, -1);
        }
    }

    @Deprecated
    public void prepare(MediaSource mediaSource) {
        setMediaSource(mediaSource);
        prepare();
    }

    @Deprecated
    public void prepare(MediaSource mediaSource, boolean z, boolean z2) {
        setMediaSource(mediaSource, z);
        prepare();
    }

    public void setMediaItems(List<MediaItem> list, boolean z) {
        setMediaSources(createMediaSources(list), z);
    }

    public void setMediaItems(List<MediaItem> list, int i, long j) {
        setMediaSources(createMediaSources(list), i, j);
    }

    public void setMediaSource(MediaSource mediaSource) {
        setMediaSources(Collections.singletonList(mediaSource));
    }

    public void setMediaSource(MediaSource mediaSource, long j) {
        setMediaSources(Collections.singletonList(mediaSource), 0, j);
    }

    public void setMediaSource(MediaSource mediaSource, boolean z) {
        setMediaSources(Collections.singletonList(mediaSource), z);
    }

    public void setMediaSources(List<MediaSource> list) {
        setMediaSources(list, true);
    }

    public void setMediaSources(List<MediaSource> list, boolean z) {
        setMediaSourcesInternal(list, -1, -9223372036854775807L, z);
    }

    public void setMediaSources(List<MediaSource> list, int i, long j) {
        setMediaSourcesInternal(list, i, j, false);
    }

    public void addMediaItems(int i, List<MediaItem> list) {
        addMediaSources(Math.min(i, this.mediaSourceHolderSnapshots.size()), createMediaSources(list));
    }

    public void addMediaSource(MediaSource mediaSource) {
        addMediaSources(Collections.singletonList(mediaSource));
    }

    public void addMediaSource(int i, MediaSource mediaSource) {
        addMediaSources(i, Collections.singletonList(mediaSource));
    }

    public void addMediaSources(List<MediaSource> list) {
        addMediaSources(this.mediaSourceHolderSnapshots.size(), list);
    }

    public void addMediaSources(int i, List<MediaSource> list) {
        Assertions.checkArgument(i >= 0);
        Timeline currentTimeline = getCurrentTimeline();
        this.pendingOperationAcks++;
        List<MediaSourceList.MediaSourceHolder> addMediaSourceHolders = addMediaSourceHolders(i, list);
        Timeline createMaskingTimeline = createMaskingTimeline();
        PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, createMaskingTimeline, getPeriodPositionAfterTimelineChanged(currentTimeline, createMaskingTimeline));
        this.internalPlayer.addMediaSources(i, addMediaSourceHolders, this.shuffleOrder);
        updatePlaybackInfo(maskTimelineAndPosition, 0, 1, false, false, 5, -9223372036854775807L, -1);
    }

    public void removeMediaItems(int i, int i2) {
        PlaybackInfo removeMediaItemsInternal = removeMediaItemsInternal(i, Math.min(i2, this.mediaSourceHolderSnapshots.size()));
        updatePlaybackInfo(removeMediaItemsInternal, 0, 1, false, !removeMediaItemsInternal.periodId.periodUid.equals(this.playbackInfo.periodId.periodUid), 4, getCurrentPositionUsInternal(removeMediaItemsInternal), -1);
    }

    public void moveMediaItems(int i, int i2, int i3) {
        Assertions.checkArgument(i >= 0 && i <= i2 && i2 <= this.mediaSourceHolderSnapshots.size() && i3 >= 0);
        Timeline currentTimeline = getCurrentTimeline();
        this.pendingOperationAcks++;
        int min = Math.min(i3, this.mediaSourceHolderSnapshots.size() - (i2 - i));
        Util.moveItems(this.mediaSourceHolderSnapshots, i, i2, min);
        Timeline createMaskingTimeline = createMaskingTimeline();
        PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, createMaskingTimeline, getPeriodPositionAfterTimelineChanged(currentTimeline, createMaskingTimeline));
        this.internalPlayer.moveMediaSources(i, i2, min, this.shuffleOrder);
        updatePlaybackInfo(maskTimelineAndPosition, 0, 1, false, false, 5, -9223372036854775807L, -1);
    }

    public void setShuffleOrder(ShuffleOrder shuffleOrder2) {
        Timeline createMaskingTimeline = createMaskingTimeline();
        PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, createMaskingTimeline, getPeriodPositionOrMaskWindowPosition(createMaskingTimeline, getCurrentWindowIndex(), getCurrentPosition()));
        this.pendingOperationAcks++;
        this.shuffleOrder = shuffleOrder2;
        this.internalPlayer.setShuffleOrder(shuffleOrder2);
        updatePlaybackInfo(maskTimelineAndPosition, 0, 1, false, false, 5, -9223372036854775807L, -1);
    }

    public void setPlayWhenReady(boolean z) {
        setPlayWhenReady(z, 0, 1);
    }

    public void setPauseAtEndOfMediaItems(boolean z) {
        if (this.pauseAtEndOfMediaItems != z) {
            this.pauseAtEndOfMediaItems = z;
            this.internalPlayer.setPauseAtEndOfWindow(z);
        }
    }

    public boolean getPauseAtEndOfMediaItems() {
        return this.pauseAtEndOfMediaItems;
    }

    public void setPlayWhenReady(boolean z, int i, int i2) {
        if (this.playbackInfo.playWhenReady != z || this.playbackInfo.playbackSuppressionReason != i) {
            this.pendingOperationAcks++;
            PlaybackInfo copyWithPlayWhenReady = this.playbackInfo.copyWithPlayWhenReady(z, i);
            this.internalPlayer.setPlayWhenReady(z, i);
            updatePlaybackInfo(copyWithPlayWhenReady, 0, i2, false, false, 5, -9223372036854775807L, -1);
        }
    }

    public boolean getPlayWhenReady() {
        return this.playbackInfo.playWhenReady;
    }

    public void setRepeatMode(int i) {
        if (this.repeatMode != i) {
            this.repeatMode = i;
            this.internalPlayer.setRepeatMode(i);
            this.listeners.queueEvent(9, new ExoPlayerImpl$$ExternalSyntheticLambda12(i));
            updateAvailableCommands();
            this.listeners.flushEvents();
        }
    }

    public int getRepeatMode() {
        return this.repeatMode;
    }

    public void setShuffleModeEnabled(boolean z) {
        if (this.shuffleModeEnabled != z) {
            this.shuffleModeEnabled = z;
            this.internalPlayer.setShuffleModeEnabled(z);
            this.listeners.queueEvent(10, new ExoPlayerImpl$$ExternalSyntheticLambda17(z));
            updateAvailableCommands();
            this.listeners.flushEvents();
        }
    }

    public boolean getShuffleModeEnabled() {
        return this.shuffleModeEnabled;
    }

    public boolean isLoading() {
        return this.playbackInfo.isLoading;
    }

    public void seekTo(int i, long j) {
        int i2 = i;
        long j2 = j;
        Timeline timeline = this.playbackInfo.timeline;
        if (i2 < 0 || (!timeline.isEmpty() && i2 >= timeline.getWindowCount())) {
            throw new IllegalSeekPositionException(timeline, i, j2);
        }
        int i3 = 1;
        this.pendingOperationAcks++;
        if (isPlayingAd()) {
            Log.w(TAG, "seekTo ignored because an ad is playing");
            ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate = new ExoPlayerImplInternal.PlaybackInfoUpdate(this.playbackInfo);
            playbackInfoUpdate.incrementPendingOperationAcks(1);
            this.playbackInfoUpdateListener.onPlaybackInfoUpdate(playbackInfoUpdate);
            return;
        }
        if (getPlaybackState() != 1) {
            i3 = 2;
        }
        int currentWindowIndex = getCurrentWindowIndex();
        PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo.copyWithPlaybackState(i3), timeline, getPeriodPositionOrMaskWindowPosition(timeline, i, j2));
        this.internalPlayer.seekTo(timeline, i, C.msToUs(j));
        updatePlaybackInfo(maskTimelineAndPosition, 0, 1, true, true, 1, getCurrentPositionUsInternal(maskTimelineAndPosition), currentWindowIndex);
    }

    public long getSeekBackIncrement() {
        return this.seekBackIncrementMs;
    }

    public long getSeekForwardIncrement() {
        return this.seekForwardIncrementMs;
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        if (playbackParameters == null) {
            playbackParameters = PlaybackParameters.DEFAULT;
        }
        if (!this.playbackInfo.playbackParameters.equals(playbackParameters)) {
            PlaybackInfo copyWithPlaybackParameters = this.playbackInfo.copyWithPlaybackParameters(playbackParameters);
            this.pendingOperationAcks++;
            this.internalPlayer.setPlaybackParameters(playbackParameters);
            updatePlaybackInfo(copyWithPlaybackParameters, 0, 1, false, false, 5, -9223372036854775807L, -1);
        }
    }

    public PlaybackParameters getPlaybackParameters() {
        return this.playbackInfo.playbackParameters;
    }

    public void setSeekParameters(SeekParameters seekParameters2) {
        if (seekParameters2 == null) {
            seekParameters2 = SeekParameters.DEFAULT;
        }
        if (!this.seekParameters.equals(seekParameters2)) {
            this.seekParameters = seekParameters2;
            this.internalPlayer.setSeekParameters(seekParameters2);
        }
    }

    public SeekParameters getSeekParameters() {
        return this.seekParameters;
    }

    public void setForegroundMode(boolean z) {
        if (this.foregroundMode != z) {
            this.foregroundMode = z;
            if (!this.internalPlayer.setForegroundMode(z)) {
                stop(false, ExoPlaybackException.createForUnexpected(new ExoTimeoutException(2), 1003));
            }
        }
    }

    public void stop(boolean z) {
        stop(z, (ExoPlaybackException) null);
    }

    public void stop(boolean z, ExoPlaybackException exoPlaybackException) {
        PlaybackInfo playbackInfo2;
        if (z) {
            playbackInfo2 = removeMediaItemsInternal(0, this.mediaSourceHolderSnapshots.size()).copyWithPlaybackError((ExoPlaybackException) null);
        } else {
            PlaybackInfo playbackInfo3 = this.playbackInfo;
            playbackInfo2 = playbackInfo3.copyWithLoadingMediaPeriodId(playbackInfo3.periodId);
            playbackInfo2.bufferedPositionUs = playbackInfo2.positionUs;
            playbackInfo2.totalBufferedDurationUs = 0;
        }
        PlaybackInfo copyWithPlaybackState = playbackInfo2.copyWithPlaybackState(1);
        if (exoPlaybackException != null) {
            copyWithPlaybackState = copyWithPlaybackState.copyWithPlaybackError(exoPlaybackException);
        }
        PlaybackInfo playbackInfo4 = copyWithPlaybackState;
        this.pendingOperationAcks++;
        this.internalPlayer.stop();
        updatePlaybackInfo(playbackInfo4, 0, 1, false, playbackInfo4.timeline.isEmpty() && !this.playbackInfo.timeline.isEmpty(), 4, getCurrentPositionUsInternal(playbackInfo4), -1);
    }

    public void release() {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = Util.DEVICE_DEBUG_INFO;
        String registeredModules = ExoPlayerLibraryInfo.registeredModules();
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 36 + String.valueOf(str).length() + String.valueOf(registeredModules).length());
        sb.append("Release ");
        sb.append(hexString);
        sb.append(" [ExoPlayerLib/2.15.1] [");
        sb.append(str);
        sb.append("] [");
        sb.append(registeredModules);
        sb.append("]");
        Log.i(TAG, sb.toString());
        if (!this.internalPlayer.release()) {
            this.listeners.sendEvent(11, new ExoPlayerImpl$$ExternalSyntheticLambda10());
        }
        this.listeners.release();
        this.playbackInfoUpdateHandler.removeCallbacksAndMessages((Object) null);
        AnalyticsCollector analyticsCollector2 = this.analyticsCollector;
        if (analyticsCollector2 != null) {
            this.bandwidthMeter.removeEventListener(analyticsCollector2);
        }
        PlaybackInfo copyWithPlaybackState = this.playbackInfo.copyWithPlaybackState(1);
        this.playbackInfo = copyWithPlaybackState;
        PlaybackInfo copyWithLoadingMediaPeriodId = copyWithPlaybackState.copyWithLoadingMediaPeriodId(copyWithPlaybackState.periodId);
        this.playbackInfo = copyWithLoadingMediaPeriodId;
        copyWithLoadingMediaPeriodId.bufferedPositionUs = copyWithLoadingMediaPeriodId.positionUs;
        this.playbackInfo.totalBufferedDurationUs = 0;
    }

    public PlayerMessage createMessage(PlayerMessage.Target target) {
        return new PlayerMessage(this.internalPlayer, target, this.playbackInfo.timeline, getCurrentWindowIndex(), this.clock, this.internalPlayer.getPlaybackLooper());
    }

    public int getCurrentPeriodIndex() {
        if (this.playbackInfo.timeline.isEmpty()) {
            return this.maskingPeriodIndex;
        }
        return this.playbackInfo.timeline.getIndexOfPeriod(this.playbackInfo.periodId.periodUid);
    }

    public int getCurrentWindowIndex() {
        int currentWindowIndexInternal = getCurrentWindowIndexInternal();
        if (currentWindowIndexInternal == -1) {
            return 0;
        }
        return currentWindowIndexInternal;
    }

    public long getDuration() {
        if (!isPlayingAd()) {
            return getContentDuration();
        }
        MediaSource.MediaPeriodId mediaPeriodId = this.playbackInfo.periodId;
        this.playbackInfo.timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        return C.usToMs(this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup));
    }

    public long getCurrentPosition() {
        return C.usToMs(getCurrentPositionUsInternal(this.playbackInfo));
    }

    public long getBufferedPosition() {
        if (!isPlayingAd()) {
            return getContentBufferedPosition();
        }
        if (this.playbackInfo.loadingMediaPeriodId.equals(this.playbackInfo.periodId)) {
            return C.usToMs(this.playbackInfo.bufferedPositionUs);
        }
        return getDuration();
    }

    public long getTotalBufferedDuration() {
        return C.usToMs(this.playbackInfo.totalBufferedDurationUs);
    }

    public boolean isPlayingAd() {
        return this.playbackInfo.periodId.isAd();
    }

    public int getCurrentAdGroupIndex() {
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adGroupIndex;
        }
        return -1;
    }

    public int getCurrentAdIndexInAdGroup() {
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adIndexInAdGroup;
        }
        return -1;
    }

    public long getContentPosition() {
        if (!isPlayingAd()) {
            return getCurrentPosition();
        }
        this.playbackInfo.timeline.getPeriodByUid(this.playbackInfo.periodId.periodUid, this.period);
        if (this.playbackInfo.requestedContentPositionUs == -9223372036854775807L) {
            return this.playbackInfo.timeline.getWindow(getCurrentWindowIndex(), this.window).getDefaultPositionMs();
        }
        return this.period.getPositionInWindowMs() + C.usToMs(this.playbackInfo.requestedContentPositionUs);
    }

    public long getContentBufferedPosition() {
        if (this.playbackInfo.timeline.isEmpty()) {
            return this.maskingWindowPositionMs;
        }
        if (this.playbackInfo.loadingMediaPeriodId.windowSequenceNumber != this.playbackInfo.periodId.windowSequenceNumber) {
            return this.playbackInfo.timeline.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
        }
        long j = this.playbackInfo.bufferedPositionUs;
        if (this.playbackInfo.loadingMediaPeriodId.isAd()) {
            Timeline.Period periodByUid = this.playbackInfo.timeline.getPeriodByUid(this.playbackInfo.loadingMediaPeriodId.periodUid, this.period);
            long adGroupTimeUs = periodByUid.getAdGroupTimeUs(this.playbackInfo.loadingMediaPeriodId.adGroupIndex);
            j = adGroupTimeUs == Long.MIN_VALUE ? periodByUid.durationUs : adGroupTimeUs;
        }
        return C.usToMs(periodPositionUsToWindowPositionUs(this.playbackInfo.timeline, this.playbackInfo.loadingMediaPeriodId, j));
    }

    public int getRendererCount() {
        return this.renderers.length;
    }

    public int getRendererType(int i) {
        return this.renderers[i].getTrackType();
    }

    public TrackSelector getTrackSelector() {
        return this.trackSelector;
    }

    public TrackGroupArray getCurrentTrackGroups() {
        return this.playbackInfo.trackGroups;
    }

    public TrackSelectionArray getCurrentTrackSelections() {
        return new TrackSelectionArray(this.playbackInfo.trackSelectorResult.selections);
    }

    @Deprecated
    public List<Metadata> getCurrentStaticMetadata() {
        return this.playbackInfo.staticMetadata;
    }

    public MediaMetadata getMediaMetadata() {
        return this.mediaMetadata;
    }

    public void onMetadata(Metadata metadata) {
        MediaMetadata build = this.mediaMetadata.buildUpon().populateFromMetadata(metadata).build();
        if (!build.equals(this.mediaMetadata)) {
            this.mediaMetadata = build;
            this.listeners.sendEvent(15, new ExoPlayerImpl$$ExternalSyntheticLambda14(this));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onMetadata$6$com-google-android-exoplayer2-ExoPlayerImpl  reason: not valid java name */
    public /* synthetic */ void m2012lambda$onMetadata$6$comgoogleandroidexoplayer2ExoPlayerImpl(Player.EventListener eventListener) {
        eventListener.onMediaMetadataChanged(this.mediaMetadata);
    }

    public MediaMetadata getPlaylistMetadata() {
        return this.playlistMetadata;
    }

    public void setPlaylistMetadata(MediaMetadata mediaMetadata2) {
        Assertions.checkNotNull(mediaMetadata2);
        if (!mediaMetadata2.equals(this.playlistMetadata)) {
            this.playlistMetadata = mediaMetadata2;
            this.listeners.sendEvent(16, new ExoPlayerImpl$$ExternalSyntheticLambda11(this));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setPlaylistMetadata$7$com-google-android-exoplayer2-ExoPlayerImpl  reason: not valid java name */
    public /* synthetic */ void m2013lambda$setPlaylistMetadata$7$comgoogleandroidexoplayer2ExoPlayerImpl(Player.EventListener eventListener) {
        eventListener.onPlaylistMetadataChanged(this.playlistMetadata);
    }

    public Timeline getCurrentTimeline() {
        return this.playbackInfo.timeline;
    }

    public AudioAttributes getAudioAttributes() {
        return AudioAttributes.DEFAULT;
    }

    public VideoSize getVideoSize() {
        return VideoSize.UNKNOWN;
    }

    public ImmutableList<Cue> getCurrentCues() {
        return ImmutableList.of();
    }

    public DeviceInfo getDeviceInfo() {
        return DeviceInfo.UNKNOWN;
    }

    private int getCurrentWindowIndexInternal() {
        if (this.playbackInfo.timeline.isEmpty()) {
            return this.maskingWindowIndex;
        }
        return this.playbackInfo.timeline.getPeriodByUid(this.playbackInfo.periodId.periodUid, this.period).windowIndex;
    }

    private long getCurrentPositionUsInternal(PlaybackInfo playbackInfo2) {
        if (playbackInfo2.timeline.isEmpty()) {
            return C.msToUs(this.maskingWindowPositionMs);
        }
        if (playbackInfo2.periodId.isAd()) {
            return playbackInfo2.positionUs;
        }
        return periodPositionUsToWindowPositionUs(playbackInfo2.timeline, playbackInfo2.periodId, playbackInfo2.positionUs);
    }

    private List<MediaSource> createMediaSources(List<MediaItem> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(this.mediaSourceFactory.createMediaSource(list.get(i)));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: handlePlaybackInfo */
    public void m2010lambda$new$1$comgoogleandroidexoplayer2ExoPlayerImpl(ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        long j;
        boolean z;
        this.pendingOperationAcks -= playbackInfoUpdate.operationAcks;
        boolean z2 = true;
        if (playbackInfoUpdate.positionDiscontinuity) {
            this.pendingDiscontinuityReason = playbackInfoUpdate.discontinuityReason;
            this.pendingDiscontinuity = true;
        }
        if (playbackInfoUpdate.hasPlayWhenReadyChangeReason) {
            this.pendingPlayWhenReadyChangeReason = playbackInfoUpdate.playWhenReadyChangeReason;
        }
        if (this.pendingOperationAcks == 0) {
            Timeline timeline = playbackInfoUpdate.playbackInfo.timeline;
            if (!this.playbackInfo.timeline.isEmpty() && timeline.isEmpty()) {
                this.maskingWindowIndex = -1;
                this.maskingWindowPositionMs = 0;
                this.maskingPeriodIndex = 0;
            }
            if (!timeline.isEmpty()) {
                List<Timeline> childTimelines = ((PlaylistTimeline) timeline).getChildTimelines();
                Assertions.checkState(childTimelines.size() == this.mediaSourceHolderSnapshots.size());
                for (int i = 0; i < childTimelines.size(); i++) {
                    Timeline unused = this.mediaSourceHolderSnapshots.get(i).timeline = childTimelines.get(i);
                }
            }
            long j2 = -9223372036854775807L;
            if (this.pendingDiscontinuity) {
                if (playbackInfoUpdate.playbackInfo.periodId.equals(this.playbackInfo.periodId) && playbackInfoUpdate.playbackInfo.discontinuityStartPositionUs == this.playbackInfo.positionUs) {
                    z2 = false;
                }
                if (z2) {
                    if (timeline.isEmpty() || playbackInfoUpdate.playbackInfo.periodId.isAd()) {
                        j2 = playbackInfoUpdate.playbackInfo.discontinuityStartPositionUs;
                    } else {
                        j2 = periodPositionUsToWindowPositionUs(timeline, playbackInfoUpdate.playbackInfo.periodId, playbackInfoUpdate.playbackInfo.discontinuityStartPositionUs);
                    }
                }
                j = j2;
                z = z2;
            } else {
                j = -9223372036854775807L;
                z = false;
            }
            this.pendingDiscontinuity = false;
            updatePlaybackInfo(playbackInfoUpdate.playbackInfo, 1, this.pendingPlayWhenReadyChangeReason, false, z, this.pendingDiscontinuityReason, j, -1);
        }
    }

    private void updatePlaybackInfo(PlaybackInfo playbackInfo2, int i, int i2, boolean z, boolean z2, int i3, long j, int i4) {
        PlaybackInfo playbackInfo3 = playbackInfo2;
        int i5 = i3;
        PlaybackInfo playbackInfo4 = this.playbackInfo;
        this.playbackInfo = playbackInfo3;
        Pair<Boolean, Integer> evaluateMediaItemTransitionReason = evaluateMediaItemTransitionReason(playbackInfo2, playbackInfo4, z2, i3, !playbackInfo4.timeline.equals(playbackInfo3.timeline));
        boolean booleanValue = ((Boolean) evaluateMediaItemTransitionReason.first).booleanValue();
        int intValue = ((Integer) evaluateMediaItemTransitionReason.second).intValue();
        MediaMetadata mediaMetadata2 = this.mediaMetadata;
        MediaItem mediaItem = null;
        if (booleanValue) {
            if (!playbackInfo3.timeline.isEmpty()) {
                mediaItem = playbackInfo3.timeline.getWindow(playbackInfo3.timeline.getPeriodByUid(playbackInfo3.periodId.periodUid, this.period).windowIndex, this.window).mediaItem;
            }
            mediaMetadata2 = mediaItem != null ? mediaItem.mediaMetadata : MediaMetadata.EMPTY;
        }
        if (!playbackInfo4.staticMetadata.equals(playbackInfo3.staticMetadata)) {
            mediaMetadata2 = mediaMetadata2.buildUpon().populateFromMetadata(playbackInfo3.staticMetadata).build();
        }
        boolean z3 = !mediaMetadata2.equals(this.mediaMetadata);
        this.mediaMetadata = mediaMetadata2;
        if (!playbackInfo4.timeline.equals(playbackInfo3.timeline)) {
            int i6 = i;
            this.listeners.queueEvent(0, new ExoPlayerImpl$$ExternalSyntheticLambda18(playbackInfo2, i));
        }
        if (z2) {
            this.listeners.queueEvent(12, new ExoPlayerImpl$$ExternalSyntheticLambda1(i5, getPreviousPositionInfo(i5, playbackInfo4, i4), getPositionInfo(j)));
        }
        if (booleanValue) {
            this.listeners.queueEvent(1, new ExoPlayerImpl$$ExternalSyntheticLambda2(mediaItem, intValue));
        }
        if (playbackInfo4.playbackError != playbackInfo3.playbackError) {
            this.listeners.queueEvent(11, new ExoPlayerImpl$$ExternalSyntheticLambda3(playbackInfo2));
            if (playbackInfo3.playbackError != null) {
                this.listeners.queueEvent(11, new ExoPlayerImpl$$ExternalSyntheticLambda4(playbackInfo2));
            }
        }
        if (playbackInfo4.trackSelectorResult != playbackInfo3.trackSelectorResult) {
            this.trackSelector.onSelectionActivated(playbackInfo3.trackSelectorResult.info);
            this.listeners.queueEvent(2, new ExoPlayerImpl$$ExternalSyntheticLambda5(playbackInfo2, new TrackSelectionArray(playbackInfo3.trackSelectorResult.selections)));
        }
        if (!playbackInfo4.staticMetadata.equals(playbackInfo3.staticMetadata)) {
            this.listeners.queueEvent(3, new ExoPlayerImpl$$ExternalSyntheticLambda6(playbackInfo2));
        }
        if (z3) {
            this.listeners.queueEvent(15, new ExoPlayerImpl$$ExternalSyntheticLambda7(this.mediaMetadata));
        }
        if (playbackInfo4.isLoading != playbackInfo3.isLoading) {
            this.listeners.queueEvent(4, new ExoPlayerImpl$$ExternalSyntheticLambda8(playbackInfo2));
        }
        if (!(playbackInfo4.playbackState == playbackInfo3.playbackState && playbackInfo4.playWhenReady == playbackInfo3.playWhenReady)) {
            this.listeners.queueEvent(-1, new ExoPlayerImpl$$ExternalSyntheticLambda9(playbackInfo2));
        }
        if (playbackInfo4.playbackState != playbackInfo3.playbackState) {
            this.listeners.queueEvent(5, new ExoPlayerImpl$$ExternalSyntheticLambda19(playbackInfo2));
        }
        if (playbackInfo4.playWhenReady != playbackInfo3.playWhenReady) {
            this.listeners.queueEvent(6, new ExoPlayerImpl$$ExternalSyntheticLambda20(playbackInfo2, i2));
        }
        if (playbackInfo4.playbackSuppressionReason != playbackInfo3.playbackSuppressionReason) {
            this.listeners.queueEvent(7, new ExoPlayerImpl$$ExternalSyntheticLambda21(playbackInfo2));
        }
        if (isPlaying(playbackInfo4) != isPlaying(playbackInfo2)) {
            this.listeners.queueEvent(8, new ExoPlayerImpl$$ExternalSyntheticLambda22(playbackInfo2));
        }
        if (!playbackInfo4.playbackParameters.equals(playbackInfo3.playbackParameters)) {
            this.listeners.queueEvent(13, new ExoPlayerImpl$$ExternalSyntheticLambda23(playbackInfo2));
        }
        if (z) {
            this.listeners.queueEvent(-1, new ExoPlayerImpl$$ExternalSyntheticLambda24());
        }
        updateAvailableCommands();
        this.listeners.flushEvents();
        if (playbackInfo4.offloadSchedulingEnabled != playbackInfo3.offloadSchedulingEnabled) {
            Iterator<ExoPlayer.AudioOffloadListener> it = this.audioOffloadListeners.iterator();
            while (it.hasNext()) {
                it.next().onExperimentalOffloadSchedulingEnabledChanged(playbackInfo3.offloadSchedulingEnabled);
            }
        }
        if (playbackInfo4.sleepingForOffload != playbackInfo3.sleepingForOffload) {
            Iterator<ExoPlayer.AudioOffloadListener> it2 = this.audioOffloadListeners.iterator();
            while (it2.hasNext()) {
                it2.next().onExperimentalSleepingForOffloadChanged(playbackInfo3.sleepingForOffload);
            }
        }
    }

    static /* synthetic */ void lambda$updatePlaybackInfo$9(int i, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, Player.EventListener eventListener) {
        eventListener.onPositionDiscontinuity(i);
        eventListener.onPositionDiscontinuity(positionInfo, positionInfo2, i);
    }

    static /* synthetic */ void lambda$updatePlaybackInfo$16(PlaybackInfo playbackInfo2, Player.EventListener eventListener) {
        eventListener.onLoadingChanged(playbackInfo2.isLoading);
        eventListener.onIsLoadingChanged(playbackInfo2.isLoading);
    }

    private Player.PositionInfo getPreviousPositionInfo(int i, PlaybackInfo playbackInfo2, int i2) {
        int i3;
        Object obj;
        int i4;
        Object obj2;
        long j;
        long j2;
        PlaybackInfo playbackInfo3 = playbackInfo2;
        Timeline.Period period2 = new Timeline.Period();
        if (!playbackInfo3.timeline.isEmpty()) {
            Object obj3 = playbackInfo3.periodId.periodUid;
            playbackInfo3.timeline.getPeriodByUid(obj3, period2);
            int i5 = period2.windowIndex;
            obj = obj3;
            i3 = playbackInfo3.timeline.getIndexOfPeriod(obj3);
            obj2 = playbackInfo3.timeline.getWindow(i5, this.window).uid;
            i4 = i5;
        } else {
            i4 = i2;
            obj2 = null;
            obj = null;
            i3 = -1;
        }
        if (i == 0) {
            j = period2.positionInWindowUs + period2.durationUs;
            if (playbackInfo3.periodId.isAd()) {
                j = period2.getAdDurationUs(playbackInfo3.periodId.adGroupIndex, playbackInfo3.periodId.adIndexInAdGroup);
                j2 = getRequestedContentPositionUs(playbackInfo2);
                return new Player.PositionInfo(obj2, i4, obj, i3, C.usToMs(j), C.usToMs(j2), playbackInfo3.periodId.adGroupIndex, playbackInfo3.periodId.adIndexInAdGroup);
            } else if (playbackInfo3.periodId.nextAdGroupIndex != -1 && this.playbackInfo.periodId.isAd()) {
                j = getRequestedContentPositionUs(this.playbackInfo);
            }
        } else if (playbackInfo3.periodId.isAd()) {
            j = playbackInfo3.positionUs;
            j2 = getRequestedContentPositionUs(playbackInfo2);
            return new Player.PositionInfo(obj2, i4, obj, i3, C.usToMs(j), C.usToMs(j2), playbackInfo3.periodId.adGroupIndex, playbackInfo3.periodId.adIndexInAdGroup);
        } else {
            j = period2.positionInWindowUs + playbackInfo3.positionUs;
        }
        j2 = j;
        return new Player.PositionInfo(obj2, i4, obj, i3, C.usToMs(j), C.usToMs(j2), playbackInfo3.periodId.adGroupIndex, playbackInfo3.periodId.adIndexInAdGroup);
    }

    private Player.PositionInfo getPositionInfo(long j) {
        int i;
        Object obj;
        Object obj2;
        int currentWindowIndex = getCurrentWindowIndex();
        if (!this.playbackInfo.timeline.isEmpty()) {
            Object obj3 = this.playbackInfo.periodId.periodUid;
            this.playbackInfo.timeline.getPeriodByUid(obj3, this.period);
            i = this.playbackInfo.timeline.getIndexOfPeriod(obj3);
            obj2 = this.playbackInfo.timeline.getWindow(currentWindowIndex, this.window).uid;
            obj = obj3;
        } else {
            obj2 = null;
            obj = null;
            i = -1;
        }
        long usToMs = C.usToMs(j);
        return new Player.PositionInfo(obj2, currentWindowIndex, obj, i, usToMs, this.playbackInfo.periodId.isAd() ? C.usToMs(getRequestedContentPositionUs(this.playbackInfo)) : usToMs, this.playbackInfo.periodId.adGroupIndex, this.playbackInfo.periodId.adIndexInAdGroup);
    }

    private static long getRequestedContentPositionUs(PlaybackInfo playbackInfo2) {
        Timeline.Window window = new Timeline.Window();
        Timeline.Period period2 = new Timeline.Period();
        playbackInfo2.timeline.getPeriodByUid(playbackInfo2.periodId.periodUid, period2);
        if (playbackInfo2.requestedContentPositionUs == -9223372036854775807L) {
            return playbackInfo2.timeline.getWindow(period2.windowIndex, window).getDefaultPositionUs();
        }
        return period2.getPositionInWindowUs() + playbackInfo2.requestedContentPositionUs;
    }

    private Pair<Boolean, Integer> evaluateMediaItemTransitionReason(PlaybackInfo playbackInfo2, PlaybackInfo playbackInfo3, boolean z, int i, boolean z2) {
        Timeline timeline = playbackInfo3.timeline;
        Timeline timeline2 = playbackInfo2.timeline;
        if (timeline2.isEmpty() && timeline.isEmpty()) {
            return new Pair<>(false, -1);
        }
        int i2 = 3;
        if (timeline2.isEmpty() != timeline.isEmpty()) {
            return new Pair<>(true, 3);
        }
        if (!timeline.getWindow(timeline.getPeriodByUid(playbackInfo3.periodId.periodUid, this.period).windowIndex, this.window).uid.equals(timeline2.getWindow(timeline2.getPeriodByUid(playbackInfo2.periodId.periodUid, this.period).windowIndex, this.window).uid)) {
            if (z && i == 0) {
                i2 = 1;
            } else if (z && i == 1) {
                i2 = 2;
            } else if (!z2) {
                throw new IllegalStateException();
            }
            return new Pair<>(true, Integer.valueOf(i2));
        } else if (!z || i != 0 || playbackInfo3.periodId.windowSequenceNumber >= playbackInfo2.periodId.windowSequenceNumber) {
            return new Pair<>(false, -1);
        } else {
            return new Pair<>(true, 0);
        }
    }

    private void updateAvailableCommands() {
        Player.Commands commands = this.availableCommands;
        Player.Commands availableCommands2 = getAvailableCommands(this.permanentAvailableCommands);
        this.availableCommands = availableCommands2;
        if (!availableCommands2.equals(commands)) {
            this.listeners.queueEvent(14, new ExoPlayerImpl$$ExternalSyntheticLambda13(this));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$updateAvailableCommands$23$com-google-android-exoplayer2-ExoPlayerImpl  reason: not valid java name */
    public /* synthetic */ void m2014lambda$updateAvailableCommands$23$comgoogleandroidexoplayer2ExoPlayerImpl(Player.EventListener eventListener) {
        eventListener.onAvailableCommandsChanged(this.availableCommands);
    }

    private void setMediaSourcesInternal(List<MediaSource> list, int i, long j, boolean z) {
        int i2;
        long j2;
        int i3 = i;
        int currentWindowIndexInternal = getCurrentWindowIndexInternal();
        long currentPosition = getCurrentPosition();
        boolean z2 = true;
        this.pendingOperationAcks++;
        if (!this.mediaSourceHolderSnapshots.isEmpty()) {
            removeMediaSourceHolders(0, this.mediaSourceHolderSnapshots.size());
        }
        List<MediaSourceList.MediaSourceHolder> addMediaSourceHolders = addMediaSourceHolders(0, list);
        Timeline createMaskingTimeline = createMaskingTimeline();
        if (createMaskingTimeline.isEmpty() || i3 < createMaskingTimeline.getWindowCount()) {
            long j3 = j;
            if (z) {
                j2 = -9223372036854775807L;
                i2 = createMaskingTimeline.getFirstWindowIndex(this.shuffleModeEnabled);
            } else if (i3 == -1) {
                i2 = currentWindowIndexInternal;
                j2 = currentPosition;
            } else {
                i2 = i3;
                j2 = j3;
            }
            PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, createMaskingTimeline, getPeriodPositionOrMaskWindowPosition(createMaskingTimeline, i2, j2));
            int i4 = maskTimelineAndPosition.playbackState;
            if (!(i2 == -1 || maskTimelineAndPosition.playbackState == 1)) {
                i4 = (createMaskingTimeline.isEmpty() || i2 >= createMaskingTimeline.getWindowCount()) ? 4 : 2;
            }
            PlaybackInfo copyWithPlaybackState = maskTimelineAndPosition.copyWithPlaybackState(i4);
            this.internalPlayer.setMediaSources(addMediaSourceHolders, i2, C.msToUs(j2), this.shuffleOrder);
            if (this.playbackInfo.periodId.periodUid.equals(copyWithPlaybackState.periodId.periodUid) || this.playbackInfo.timeline.isEmpty()) {
                z2 = false;
            }
            updatePlaybackInfo(copyWithPlaybackState, 0, 1, false, z2, 4, getCurrentPositionUsInternal(copyWithPlaybackState), -1);
            return;
        }
        throw new IllegalSeekPositionException(createMaskingTimeline, i3, j);
    }

    private List<MediaSourceList.MediaSourceHolder> addMediaSourceHolders(int i, List<MediaSource> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            MediaSourceList.MediaSourceHolder mediaSourceHolder = new MediaSourceList.MediaSourceHolder(list.get(i2), this.useLazyPreparation);
            arrayList.add(mediaSourceHolder);
            this.mediaSourceHolderSnapshots.add(i2 + i, new MediaSourceHolderSnapshot(mediaSourceHolder.uid, mediaSourceHolder.mediaSource.getTimeline()));
        }
        this.shuffleOrder = this.shuffleOrder.cloneAndInsert(i, arrayList.size());
        return arrayList;
    }

    private PlaybackInfo removeMediaItemsInternal(int i, int i2) {
        boolean z = false;
        Assertions.checkArgument(i >= 0 && i2 >= i && i2 <= this.mediaSourceHolderSnapshots.size());
        int currentWindowIndex = getCurrentWindowIndex();
        Timeline currentTimeline = getCurrentTimeline();
        int size = this.mediaSourceHolderSnapshots.size();
        this.pendingOperationAcks++;
        removeMediaSourceHolders(i, i2);
        Timeline createMaskingTimeline = createMaskingTimeline();
        PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, createMaskingTimeline, getPeriodPositionAfterTimelineChanged(currentTimeline, createMaskingTimeline));
        if (maskTimelineAndPosition.playbackState != 1 && maskTimelineAndPosition.playbackState != 4 && i < i2 && i2 == size && currentWindowIndex >= maskTimelineAndPosition.timeline.getWindowCount()) {
            z = true;
        }
        if (z) {
            maskTimelineAndPosition = maskTimelineAndPosition.copyWithPlaybackState(4);
        }
        this.internalPlayer.removeMediaSources(i, i2, this.shuffleOrder);
        return maskTimelineAndPosition;
    }

    private void removeMediaSourceHolders(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            this.mediaSourceHolderSnapshots.remove(i3);
        }
        this.shuffleOrder = this.shuffleOrder.cloneAndRemove(i, i2);
    }

    private Timeline createMaskingTimeline() {
        return new PlaylistTimeline(this.mediaSourceHolderSnapshots, this.shuffleOrder);
    }

    private PlaybackInfo maskTimelineAndPosition(PlaybackInfo playbackInfo2, Timeline timeline, Pair<Object, Long> pair) {
        List list;
        long j;
        Timeline timeline2 = timeline;
        Pair<Object, Long> pair2 = pair;
        Assertions.checkArgument(timeline.isEmpty() || pair2 != null);
        Timeline timeline3 = playbackInfo2.timeline;
        PlaybackInfo copyWithTimeline = playbackInfo2.copyWithTimeline(timeline);
        if (timeline.isEmpty()) {
            MediaSource.MediaPeriodId dummyPeriodForEmptyTimeline = PlaybackInfo.getDummyPeriodForEmptyTimeline();
            long msToUs = C.msToUs(this.maskingWindowPositionMs);
            PlaybackInfo copyWithLoadingMediaPeriodId = copyWithTimeline.copyWithNewPosition(dummyPeriodForEmptyTimeline, msToUs, msToUs, msToUs, 0, TrackGroupArray.EMPTY, this.emptyTrackSelectorResult, ImmutableList.of()).copyWithLoadingMediaPeriodId(dummyPeriodForEmptyTimeline);
            copyWithLoadingMediaPeriodId.bufferedPositionUs = copyWithLoadingMediaPeriodId.positionUs;
            return copyWithLoadingMediaPeriodId;
        }
        Object obj = copyWithTimeline.periodId.periodUid;
        boolean z = !obj.equals(((Pair) Util.castNonNull(pair)).first);
        MediaSource.MediaPeriodId mediaPeriodId = z ? new MediaSource.MediaPeriodId(pair2.first) : copyWithTimeline.periodId;
        long longValue = ((Long) pair2.second).longValue();
        long msToUs2 = C.msToUs(getContentPosition());
        if (!timeline3.isEmpty()) {
            msToUs2 -= timeline3.getPeriodByUid(obj, this.period).getPositionInWindowUs();
        }
        if (z || longValue < msToUs2) {
            MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
            Assertions.checkState(!mediaPeriodId2.isAd());
            TrackGroupArray trackGroupArray = z ? TrackGroupArray.EMPTY : copyWithTimeline.trackGroups;
            MediaSource.MediaPeriodId mediaPeriodId3 = mediaPeriodId2;
            TrackSelectorResult trackSelectorResult = z ? this.emptyTrackSelectorResult : copyWithTimeline.trackSelectorResult;
            if (z) {
                list = ImmutableList.of();
            } else {
                list = copyWithTimeline.staticMetadata;
            }
            PlaybackInfo copyWithLoadingMediaPeriodId2 = copyWithTimeline.copyWithNewPosition(mediaPeriodId3, longValue, longValue, longValue, 0, trackGroupArray, trackSelectorResult, list).copyWithLoadingMediaPeriodId(mediaPeriodId3);
            copyWithLoadingMediaPeriodId2.bufferedPositionUs = longValue;
            return copyWithLoadingMediaPeriodId2;
        }
        if (longValue == msToUs2) {
            int indexOfPeriod = timeline2.getIndexOfPeriod(copyWithTimeline.loadingMediaPeriodId.periodUid);
            if (indexOfPeriod == -1 || timeline2.getPeriod(indexOfPeriod, this.period).windowIndex != timeline2.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex) {
                timeline2.getPeriodByUid(mediaPeriodId.periodUid, this.period);
                if (mediaPeriodId.isAd()) {
                    j = this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
                } else {
                    j = this.period.durationUs;
                }
                copyWithTimeline = copyWithTimeline.copyWithNewPosition(mediaPeriodId, copyWithTimeline.positionUs, copyWithTimeline.positionUs, copyWithTimeline.discontinuityStartPositionUs, j - copyWithTimeline.positionUs, copyWithTimeline.trackGroups, copyWithTimeline.trackSelectorResult, copyWithTimeline.staticMetadata).copyWithLoadingMediaPeriodId(mediaPeriodId);
                copyWithTimeline.bufferedPositionUs = j;
            }
        } else {
            MediaSource.MediaPeriodId mediaPeriodId4 = mediaPeriodId;
            Assertions.checkState(!mediaPeriodId4.isAd());
            long max = Math.max(0, copyWithTimeline.totalBufferedDurationUs - (longValue - msToUs2));
            long j2 = copyWithTimeline.bufferedPositionUs;
            if (copyWithTimeline.loadingMediaPeriodId.equals(copyWithTimeline.periodId)) {
                j2 = longValue + max;
            }
            copyWithTimeline = copyWithTimeline.copyWithNewPosition(mediaPeriodId4, longValue, longValue, longValue, max, copyWithTimeline.trackGroups, copyWithTimeline.trackSelectorResult, copyWithTimeline.staticMetadata);
            copyWithTimeline.bufferedPositionUs = j2;
        }
        return copyWithTimeline;
    }

    private Pair<Object, Long> getPeriodPositionAfterTimelineChanged(Timeline timeline, Timeline timeline2) {
        long contentPosition = getContentPosition();
        int i = -1;
        if (timeline.isEmpty() || timeline2.isEmpty()) {
            boolean z = !timeline.isEmpty() && timeline2.isEmpty();
            if (!z) {
                i = getCurrentWindowIndexInternal();
            }
            if (z) {
                contentPosition = -9223372036854775807L;
            }
            return getPeriodPositionOrMaskWindowPosition(timeline2, i, contentPosition);
        }
        Pair<Object, Long> periodPosition = timeline.getPeriodPosition(this.window, this.period, getCurrentWindowIndex(), C.msToUs(contentPosition));
        Object obj = ((Pair) Util.castNonNull(periodPosition)).first;
        if (timeline2.getIndexOfPeriod(obj) != -1) {
            return periodPosition;
        }
        Object resolveSubsequentPeriod = ExoPlayerImplInternal.resolveSubsequentPeriod(this.window, this.period, this.repeatMode, this.shuffleModeEnabled, obj, timeline, timeline2);
        if (resolveSubsequentPeriod == null) {
            return getPeriodPositionOrMaskWindowPosition(timeline2, -1, -9223372036854775807L);
        }
        timeline2.getPeriodByUid(resolveSubsequentPeriod, this.period);
        return getPeriodPositionOrMaskWindowPosition(timeline2, this.period.windowIndex, timeline2.getWindow(this.period.windowIndex, this.window).getDefaultPositionMs());
    }

    private Pair<Object, Long> getPeriodPositionOrMaskWindowPosition(Timeline timeline, int i, long j) {
        if (timeline.isEmpty()) {
            this.maskingWindowIndex = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.maskingWindowPositionMs = j;
            this.maskingPeriodIndex = 0;
            return null;
        }
        if (i == -1 || i >= timeline.getWindowCount()) {
            i = timeline.getFirstWindowIndex(this.shuffleModeEnabled);
            j = timeline.getWindow(i, this.window).getDefaultPositionMs();
        }
        return timeline.getPeriodPosition(this.window, this.period, i, C.msToUs(j));
    }

    private long periodPositionUsToWindowPositionUs(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j) {
        timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        return j + this.period.getPositionInWindowUs();
    }

    private static boolean isPlaying(PlaybackInfo playbackInfo2) {
        return playbackInfo2.playbackState == 3 && playbackInfo2.playWhenReady && playbackInfo2.playbackSuppressionReason == 0;
    }

    private static final class MediaSourceHolderSnapshot implements MediaSourceInfoHolder {
        /* access modifiers changed from: private */
        public Timeline timeline;
        private final Object uid;

        public MediaSourceHolderSnapshot(Object obj, Timeline timeline2) {
            this.uid = obj;
            this.timeline = timeline2;
        }

        public Object getUid() {
            return this.uid;
        }

        public Timeline getTimeline() {
            return this.timeline;
        }
    }
}
