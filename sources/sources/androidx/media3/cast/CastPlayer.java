package androidx.media3.cast;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.BasePlayer;
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.FlagSet;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.json.JSONObject;

public final class CastPlayer extends BasePlayer {
    public static final DeviceInfo DEVICE_INFO = new DeviceInfo.Builder(1).build();
    private static final long[] EMPTY_TRACK_ID_ARRAY = new long[0];
    public static final float MAX_SPEED_SUPPORTED = 2.0f;
    public static final float MIN_SPEED_SUPPORTED = 0.5f;
    static final Player.Commands PERMANENT_AVAILABLE_COMMANDS = new Player.Commands.Builder().addAll(1, 2, 3, 4, 10, 15, 13, 16, 17, 18, 19, 31, 20, 30, 32).build();
    private static final long PROGRESS_REPORT_PERIOD_MS = 1000;
    private static final String TAG = "CastPlayer";
    private Player.Commands availableCommands;
    private final CastContext castContext;
    private CastTimeline currentTimeline;
    private Tracks currentTracks;
    /* access modifiers changed from: private */
    public int currentWindowIndex;
    /* access modifiers changed from: private */
    public long lastReportedPositionMs;
    /* access modifiers changed from: private */
    public final ListenerSet<Player.Listener> listeners;
    private final MediaItemConverter mediaItemConverter;
    private MediaMetadata mediaMetadata;
    private Player.PositionInfo pendingMediaItemRemovalPosition;
    private int pendingSeekCount;
    /* access modifiers changed from: private */
    public long pendingSeekPositionMs;
    /* access modifiers changed from: private */
    public int pendingSeekWindowIndex;
    private final Timeline.Period period;
    private final StateHolder<Boolean> playWhenReady;
    private final StateHolder<PlaybackParameters> playbackParameters;
    private int playbackState;
    /* access modifiers changed from: private */
    public RemoteMediaClient remoteMediaClient;
    private final StateHolder<Integer> repeatMode;
    private final long seekBackIncrementMs;
    private final long seekForwardIncrementMs;
    private final SeekResultCallback seekResultCallback;
    private SessionAvailabilityListener sessionAvailabilityListener;
    private final StatusListener statusListener;
    private final CastTimelineTracker timelineTracker;

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

    @Deprecated
    public void decreaseDeviceVolume() {
    }

    public void decreaseDeviceVolume(int i) {
    }

    public int getCurrentAdGroupIndex() {
        return -1;
    }

    public int getCurrentAdIndexInAdGroup() {
        return -1;
    }

    public int getDeviceVolume() {
        return 0;
    }

    public long getMaxSeekToPreviousPosition() {
        return C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    }

    public int getPlaybackSuppressionReason() {
        return 0;
    }

    public PlaybackException getPlayerError() {
        return null;
    }

    public boolean getShuffleModeEnabled() {
        return false;
    }

    public float getVolume() {
        return 1.0f;
    }

    @Deprecated
    public void increaseDeviceVolume() {
    }

    public void increaseDeviceVolume(int i) {
    }

    public boolean isDeviceMuted() {
        return false;
    }

    public boolean isLoading() {
        return false;
    }

    public boolean isPlayingAd() {
        return false;
    }

    public void prepare() {
    }

    @Deprecated
    public void setDeviceMuted(boolean z) {
    }

    public void setDeviceMuted(boolean z, int i) {
    }

    @Deprecated
    public void setDeviceVolume(int i) {
    }

    public void setDeviceVolume(int i, int i2) {
    }

    public void setPlaylistMetadata(MediaMetadata mediaMetadata2) {
    }

    public void setShuffleModeEnabled(boolean z) {
    }

    public void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
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

    static /* synthetic */ int access$1106(CastPlayer castPlayer) {
        int i = castPlayer.pendingSeekCount - 1;
        castPlayer.pendingSeekCount = i;
        return i;
    }

    static {
        MediaLibraryInfo.registerModule("media3.cast");
    }

    public CastPlayer(CastContext castContext2) {
        this(castContext2, new DefaultMediaItemConverter());
    }

    public CastPlayer(CastContext castContext2, MediaItemConverter mediaItemConverter2) {
        this(castContext2, mediaItemConverter2, 5000, 15000);
    }

    public CastPlayer(CastContext castContext2, MediaItemConverter mediaItemConverter2, long j, long j2) {
        Assertions.checkArgument(j > 0 && j2 > 0);
        this.castContext = castContext2;
        this.mediaItemConverter = mediaItemConverter2;
        this.seekBackIncrementMs = j;
        this.seekForwardIncrementMs = j2;
        this.timelineTracker = new CastTimelineTracker(mediaItemConverter2);
        this.period = new Timeline.Period();
        RemoteMediaClient remoteMediaClient2 = null;
        StatusListener statusListener2 = new StatusListener();
        this.statusListener = statusListener2;
        this.seekResultCallback = new SeekResultCallback();
        this.listeners = new ListenerSet<>(Looper.getMainLooper(), Clock.DEFAULT, new CastPlayer$$ExternalSyntheticLambda8(this));
        this.playWhenReady = new StateHolder<>(false);
        this.repeatMode = new StateHolder<>(0);
        this.playbackParameters = new StateHolder<>(PlaybackParameters.DEFAULT);
        this.playbackState = 1;
        this.currentTimeline = CastTimeline.EMPTY_CAST_TIMELINE;
        this.mediaMetadata = MediaMetadata.EMPTY;
        this.currentTracks = Tracks.EMPTY;
        this.availableCommands = new Player.Commands.Builder().addAll(PERMANENT_AVAILABLE_COMMANDS).build();
        this.pendingSeekWindowIndex = -1;
        this.pendingSeekPositionMs = -9223372036854775807L;
        SessionManager sessionManager = castContext2.getSessionManager();
        sessionManager.addSessionManagerListener(statusListener2, CastSession.class);
        CastSession currentCastSession = sessionManager.getCurrentCastSession();
        setRemoteMediaClient(currentCastSession != null ? currentCastSession.getRemoteMediaClient() : remoteMediaClient2);
        updateInternalStateAndNotifyIfChanged();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$androidx-media3-cast-CastPlayer  reason: not valid java name */
    public /* synthetic */ void m52lambda$new$0$androidxmedia3castCastPlayer(Player.Listener listener, FlagSet flagSet) {
        listener.onEvents(this, new Player.Events(flagSet));
    }

    public MediaQueueItem getItem(int i) {
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null || this.currentTimeline.getIndexOfPeriod(Integer.valueOf(i)) == -1) {
            return null;
        }
        return mediaStatus.getItemById(i);
    }

    public boolean isCastSessionAvailable() {
        return this.remoteMediaClient != null;
    }

    public void setSessionAvailabilityListener(SessionAvailabilityListener sessionAvailabilityListener2) {
        this.sessionAvailabilityListener = sessionAvailabilityListener2;
    }

    public Looper getApplicationLooper() {
        return Looper.getMainLooper();
    }

    public void addListener(Player.Listener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(Player.Listener listener) {
        this.listeners.remove(listener);
    }

    public void setMediaItems(List<MediaItem> list, boolean z) {
        long j;
        int currentMediaItemIndex = z ? 0 : getCurrentMediaItemIndex();
        if (z) {
            j = -9223372036854775807L;
        } else {
            j = getContentPosition();
        }
        setMediaItems(list, currentMediaItemIndex, j);
    }

    public void setMediaItems(List<MediaItem> list, int i, long j) {
        setMediaItemsInternal(list, i, j, ((Integer) this.repeatMode.value).intValue());
    }

    public void addMediaItems(int i, List<MediaItem> list) {
        int i2 = 0;
        Assertions.checkArgument(i >= 0);
        if (i < this.currentTimeline.getWindowCount()) {
            i2 = ((Integer) this.currentTimeline.getWindow(i, this.window).uid).intValue();
        }
        addMediaItemsInternal(list, i2);
    }

    public void moveMediaItems(int i, int i2, int i3) {
        Assertions.checkArgument(i >= 0 && i <= i2 && i3 >= 0);
        int windowCount = this.currentTimeline.getWindowCount();
        int min = Math.min(i2, windowCount);
        int i4 = min - i;
        int min2 = Math.min(i3, windowCount - i4);
        if (i < windowCount && i != min && i != min2) {
            int[] iArr = new int[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                iArr[i5] = ((Integer) this.currentTimeline.getWindow(i5 + i, this.window).uid).intValue();
            }
            moveMediaItemsInternal(iArr, i, min2);
        }
    }

    public void replaceMediaItems(int i, int i2, List<MediaItem> list) {
        Assertions.checkArgument(i >= 0 && i <= i2);
        int windowCount = this.currentTimeline.getWindowCount();
        if (i <= windowCount) {
            int min = Math.min(i2, windowCount);
            addMediaItems(min, list);
            removeMediaItems(i, min);
        }
    }

    public void removeMediaItems(int i, int i2) {
        Assertions.checkArgument(i >= 0 && i2 >= i);
        int windowCount = this.currentTimeline.getWindowCount();
        int min = Math.min(i2, windowCount);
        if (i < windowCount && i != min) {
            int i3 = min - i;
            int[] iArr = new int[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                iArr[i4] = ((Integer) this.currentTimeline.getWindow(i4 + i, this.window).uid).intValue();
            }
            removeMediaItemsInternal(iArr);
        }
    }

    public Player.Commands getAvailableCommands() {
        return this.availableCommands;
    }

    public int getPlaybackState() {
        return this.playbackState;
    }

    public void setPlayWhenReady(boolean z) {
        if (this.remoteMediaClient != null) {
            setPlayerStateAndNotifyIfChanged(z, 1, this.playbackState);
            this.listeners.flushEvents();
            PendingResult<RemoteMediaClient.MediaChannelResult> play = z ? this.remoteMediaClient.play() : this.remoteMediaClient.pause();
            this.playWhenReady.pendingResultCallback = new ResultCallback<RemoteMediaClient.MediaChannelResult>() {
                public void onResult(RemoteMediaClient.MediaChannelResult mediaChannelResult) {
                    if (CastPlayer.this.remoteMediaClient != null) {
                        CastPlayer.this.updatePlayerStateAndNotifyIfChanged(this);
                        CastPlayer.this.listeners.flushEvents();
                    }
                }
            };
            play.setResultCallback(this.playWhenReady.pendingResultCallback);
        }
    }

    public boolean getPlayWhenReady() {
        return ((Boolean) this.playWhenReady.value).booleanValue();
    }

    public void seekTo(int i, long j, int i2, boolean z) {
        Assertions.checkArgument(i >= 0);
        if (this.currentTimeline.isEmpty() || i < this.currentTimeline.getWindowCount()) {
            MediaStatus mediaStatus = getMediaStatus();
            if (j == -9223372036854775807L) {
                j = 0;
            }
            if (mediaStatus != null) {
                if (getCurrentMediaItemIndex() != i) {
                    this.remoteMediaClient.queueJumpToItem(((Integer) this.currentTimeline.getPeriod(i, this.period).uid).intValue(), j, (JSONObject) null).setResultCallback(this.seekResultCallback);
                } else {
                    this.remoteMediaClient.seek(j).setResultCallback(this.seekResultCallback);
                }
                Player.PositionInfo currentPositionInfo = getCurrentPositionInfo();
                this.pendingSeekCount++;
                this.pendingSeekWindowIndex = i;
                this.pendingSeekPositionMs = j;
                Player.PositionInfo currentPositionInfo2 = getCurrentPositionInfo();
                this.listeners.queueEvent(11, new CastPlayer$$ExternalSyntheticLambda11(currentPositionInfo, currentPositionInfo2));
                if (currentPositionInfo.mediaItemIndex != currentPositionInfo2.mediaItemIndex) {
                    this.listeners.queueEvent(1, new CastPlayer$$ExternalSyntheticLambda12(getCurrentTimeline().getWindow(i, this.window).mediaItem));
                    MediaMetadata mediaMetadata2 = this.mediaMetadata;
                    MediaMetadata mediaMetadataInternal = getMediaMetadataInternal();
                    this.mediaMetadata = mediaMetadataInternal;
                    if (!mediaMetadata2.equals(mediaMetadataInternal)) {
                        this.listeners.queueEvent(14, new CastPlayer$$ExternalSyntheticLambda13(this));
                    }
                }
                updateAvailableCommandsAndNotifyIfChanged();
            }
            this.listeners.flushEvents();
        }
    }

    static /* synthetic */ void lambda$seekTo$1(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, Player.Listener listener) {
        listener.onPositionDiscontinuity(1);
        listener.onPositionDiscontinuity(positionInfo, positionInfo2, 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$seekTo$3$androidx-media3-cast-CastPlayer  reason: not valid java name */
    public /* synthetic */ void m53lambda$seekTo$3$androidxmedia3castCastPlayer(Player.Listener listener) {
        listener.onMediaMetadataChanged(this.mediaMetadata);
    }

    public long getSeekBackIncrement() {
        return this.seekBackIncrementMs;
    }

    public long getSeekForwardIncrement() {
        return this.seekForwardIncrementMs;
    }

    public PlaybackParameters getPlaybackParameters() {
        return (PlaybackParameters) this.playbackParameters.value;
    }

    public void stop() {
        this.playbackState = 1;
        RemoteMediaClient remoteMediaClient2 = this.remoteMediaClient;
        if (remoteMediaClient2 != null) {
            remoteMediaClient2.stop();
        }
    }

    public void release() {
        SessionManager sessionManager = this.castContext.getSessionManager();
        sessionManager.removeSessionManagerListener(this.statusListener, CastSession.class);
        sessionManager.endCurrentSession(false);
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters2) {
        if (this.remoteMediaClient != null) {
            PlaybackParameters playbackParameters3 = new PlaybackParameters(Util.constrainValue(playbackParameters2.speed, 0.5f, 2.0f));
            setPlaybackParametersAndNotifyIfChanged(playbackParameters3);
            this.listeners.flushEvents();
            PendingResult<RemoteMediaClient.MediaChannelResult> playbackRate = this.remoteMediaClient.setPlaybackRate((double) playbackParameters3.speed, (JSONObject) null);
            this.playbackParameters.pendingResultCallback = new ResultCallback<RemoteMediaClient.MediaChannelResult>() {
                public void onResult(RemoteMediaClient.MediaChannelResult mediaChannelResult) {
                    if (CastPlayer.this.remoteMediaClient != null) {
                        CastPlayer.this.updatePlaybackRateAndNotifyIfChanged(this);
                        CastPlayer.this.listeners.flushEvents();
                    }
                }
            };
            playbackRate.setResultCallback(this.playbackParameters.pendingResultCallback);
        }
    }

    public void setRepeatMode(int i) {
        if (this.remoteMediaClient != null) {
            setRepeatModeAndNotifyIfChanged(i);
            this.listeners.flushEvents();
            PendingResult<RemoteMediaClient.MediaChannelResult> queueSetRepeatMode = this.remoteMediaClient.queueSetRepeatMode(getCastRepeatMode(i), (JSONObject) null);
            this.repeatMode.pendingResultCallback = new ResultCallback<RemoteMediaClient.MediaChannelResult>() {
                public void onResult(RemoteMediaClient.MediaChannelResult mediaChannelResult) {
                    if (CastPlayer.this.remoteMediaClient != null) {
                        CastPlayer.this.updateRepeatModeAndNotifyIfChanged(this);
                        CastPlayer.this.listeners.flushEvents();
                    }
                }
            };
            queueSetRepeatMode.setResultCallback(this.repeatMode.pendingResultCallback);
        }
    }

    public int getRepeatMode() {
        return ((Integer) this.repeatMode.value).intValue();
    }

    public Tracks getCurrentTracks() {
        return this.currentTracks;
    }

    public TrackSelectionParameters getTrackSelectionParameters() {
        return TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT;
    }

    public MediaMetadata getMediaMetadata() {
        return this.mediaMetadata;
    }

    public MediaMetadata getMediaMetadataInternal() {
        MediaItem currentMediaItem = getCurrentMediaItem();
        return currentMediaItem != null ? currentMediaItem.mediaMetadata : MediaMetadata.EMPTY;
    }

    public MediaMetadata getPlaylistMetadata() {
        return MediaMetadata.EMPTY;
    }

    public Timeline getCurrentTimeline() {
        return this.currentTimeline;
    }

    public int getCurrentPeriodIndex() {
        return getCurrentMediaItemIndex();
    }

    public int getCurrentMediaItemIndex() {
        int i = this.pendingSeekWindowIndex;
        return i != -1 ? i : this.currentWindowIndex;
    }

    public long getDuration() {
        return getContentDuration();
    }

    public long getCurrentPosition() {
        long j = this.pendingSeekPositionMs;
        if (j != -9223372036854775807L) {
            return j;
        }
        RemoteMediaClient remoteMediaClient2 = this.remoteMediaClient;
        if (remoteMediaClient2 != null) {
            return remoteMediaClient2.getApproximateStreamPosition();
        }
        return this.lastReportedPositionMs;
    }

    public long getBufferedPosition() {
        return getCurrentPosition();
    }

    public long getTotalBufferedDuration() {
        long bufferedPosition = getBufferedPosition();
        long currentPosition = getCurrentPosition();
        if (bufferedPosition == -9223372036854775807L || currentPosition == -9223372036854775807L) {
            return 0;
        }
        return bufferedPosition - currentPosition;
    }

    public long getContentPosition() {
        return getCurrentPosition();
    }

    public long getContentBufferedPosition() {
        return getBufferedPosition();
    }

    public AudioAttributes getAudioAttributes() {
        return AudioAttributes.DEFAULT;
    }

    public VideoSize getVideoSize() {
        return VideoSize.UNKNOWN;
    }

    public Size getSurfaceSize() {
        return Size.UNKNOWN;
    }

    public CueGroup getCurrentCues() {
        return CueGroup.EMPTY_TIME_ZERO;
    }

    public DeviceInfo getDeviceInfo() {
        return DEVICE_INFO;
    }

    /* access modifiers changed from: private */
    public void updateInternalStateAndNotifyIfChanged() {
        if (this.remoteMediaClient != null) {
            int i = this.currentWindowIndex;
            MediaMetadata mediaMetadata2 = this.mediaMetadata;
            Object obj = null;
            Object obj2 = !getCurrentTimeline().isEmpty() ? getCurrentTimeline().getPeriod(i, this.period, true).uid : null;
            updatePlayerStateAndNotifyIfChanged((ResultCallback<?>) null);
            updateRepeatModeAndNotifyIfChanged((ResultCallback<?>) null);
            updatePlaybackRateAndNotifyIfChanged((ResultCallback<?>) null);
            boolean updateTimelineAndNotifyIfChanged = updateTimelineAndNotifyIfChanged();
            Timeline currentTimeline2 = getCurrentTimeline();
            this.currentWindowIndex = fetchCurrentWindowIndex(this.remoteMediaClient, currentTimeline2);
            this.mediaMetadata = getMediaMetadataInternal();
            if (!currentTimeline2.isEmpty()) {
                obj = currentTimeline2.getPeriod(this.currentWindowIndex, this.period, true).uid;
            }
            if (!updateTimelineAndNotifyIfChanged && !Util.areEqual(obj2, obj) && this.pendingSeekCount == 0) {
                currentTimeline2.getPeriod(i, this.period, true);
                currentTimeline2.getWindow(i, this.window);
                long durationMs = this.window.getDurationMs();
                Player.PositionInfo positionInfo = new Player.PositionInfo(this.window.uid, this.period.windowIndex, this.window.mediaItem, this.period.uid, this.period.windowIndex, durationMs, durationMs, -1, -1);
                currentTimeline2.getPeriod(this.currentWindowIndex, this.period, true);
                currentTimeline2.getWindow(this.currentWindowIndex, this.window);
                this.listeners.queueEvent(11, new CastPlayer$$ExternalSyntheticLambda3(positionInfo, new Player.PositionInfo(this.window.uid, this.period.windowIndex, this.window.mediaItem, this.period.uid, this.period.windowIndex, this.window.getDefaultPositionMs(), this.window.getDefaultPositionMs(), -1, -1)));
                this.listeners.queueEvent(1, new CastPlayer$$ExternalSyntheticLambda4(this));
            }
            if (updateTracksAndSelectionsAndNotifyIfChanged()) {
                this.listeners.queueEvent(2, new CastPlayer$$ExternalSyntheticLambda5(this));
            }
            if (!mediaMetadata2.equals(this.mediaMetadata)) {
                this.listeners.queueEvent(14, new CastPlayer$$ExternalSyntheticLambda6(this));
            }
            updateAvailableCommandsAndNotifyIfChanged();
            this.listeners.flushEvents();
        }
    }

    static /* synthetic */ void lambda$updateInternalStateAndNotifyIfChanged$4(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, Player.Listener listener) {
        listener.onPositionDiscontinuity(0);
        listener.onPositionDiscontinuity(positionInfo, positionInfo2, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$updateInternalStateAndNotifyIfChanged$5$androidx-media3-cast-CastPlayer  reason: not valid java name */
    public /* synthetic */ void m55lambda$updateInternalStateAndNotifyIfChanged$5$androidxmedia3castCastPlayer(Player.Listener listener) {
        listener.onMediaItemTransition(getCurrentMediaItem(), 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$updateInternalStateAndNotifyIfChanged$6$androidx-media3-cast-CastPlayer  reason: not valid java name */
    public /* synthetic */ void m56lambda$updateInternalStateAndNotifyIfChanged$6$androidxmedia3castCastPlayer(Player.Listener listener) {
        listener.onTracksChanged(this.currentTracks);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$updateInternalStateAndNotifyIfChanged$7$androidx-media3-cast-CastPlayer  reason: not valid java name */
    public /* synthetic */ void m57lambda$updateInternalStateAndNotifyIfChanged$7$androidxmedia3castCastPlayer(Player.Listener listener) {
        listener.onMediaMetadataChanged(this.mediaMetadata);
    }

    /* access modifiers changed from: private */
    @RequiresNonNull({"remoteMediaClient"})
    public void updatePlayerStateAndNotifyIfChanged(ResultCallback<?> resultCallback) {
        boolean booleanValue = ((Boolean) this.playWhenReady.value).booleanValue();
        int i = 1;
        if (this.playWhenReady.acceptsUpdate(resultCallback)) {
            booleanValue = !this.remoteMediaClient.isPaused();
            this.playWhenReady.clearPendingResultCallback();
        }
        if (booleanValue != ((Boolean) this.playWhenReady.value).booleanValue()) {
            i = 4;
        }
        setPlayerStateAndNotifyIfChanged(booleanValue, i, fetchPlaybackState(this.remoteMediaClient));
    }

    /* access modifiers changed from: private */
    @RequiresNonNull({"remoteMediaClient"})
    public void updatePlaybackRateAndNotifyIfChanged(ResultCallback<?> resultCallback) {
        float f;
        if (this.playbackParameters.acceptsUpdate(resultCallback)) {
            MediaStatus mediaStatus = this.remoteMediaClient.getMediaStatus();
            if (mediaStatus != null) {
                f = (float) mediaStatus.getPlaybackRate();
            } else {
                f = PlaybackParameters.DEFAULT.speed;
            }
            if (f > 0.0f) {
                setPlaybackParametersAndNotifyIfChanged(new PlaybackParameters(f));
            }
            this.playbackParameters.clearPendingResultCallback();
        }
    }

    /* access modifiers changed from: private */
    @RequiresNonNull({"remoteMediaClient"})
    public void updateRepeatModeAndNotifyIfChanged(ResultCallback<?> resultCallback) {
        if (this.repeatMode.acceptsUpdate(resultCallback)) {
            setRepeatModeAndNotifyIfChanged(fetchRepeatMode(this.remoteMediaClient));
            this.repeatMode.clearPendingResultCallback();
        }
    }

    /* access modifiers changed from: private */
    public boolean updateTimelineAndNotifyIfChanged() {
        CastTimeline castTimeline = this.currentTimeline;
        int i = this.currentWindowIndex;
        boolean z = false;
        if (updateTimeline()) {
            this.listeners.queueEvent(0, new CastPlayer$$ExternalSyntheticLambda0(this.currentTimeline));
            Timeline currentTimeline2 = getCurrentTimeline();
            boolean z2 = !castTimeline.isEmpty() && currentTimeline2.getIndexOfPeriod(Util.castNonNull(castTimeline.getPeriod(i, this.period, true).uid)) == -1;
            if (z2) {
                Player.PositionInfo positionInfo = this.pendingMediaItemRemovalPosition;
                if (positionInfo != null) {
                    this.pendingMediaItemRemovalPosition = null;
                } else {
                    castTimeline.getPeriod(i, this.period, true);
                    castTimeline.getWindow(this.period.windowIndex, this.window);
                    positionInfo = new Player.PositionInfo(this.window.uid, this.period.windowIndex, this.window.mediaItem, this.period.uid, this.period.windowIndex, getCurrentPosition(), getContentPosition(), -1, -1);
                }
                this.listeners.queueEvent(11, new CastPlayer$$ExternalSyntheticLambda9(positionInfo, getCurrentPositionInfo()));
            }
            if (currentTimeline2.isEmpty() != castTimeline.isEmpty() || z2) {
                z = true;
            }
            if (z) {
                this.listeners.queueEvent(1, new CastPlayer$$ExternalSyntheticLambda10(this));
            }
            updateAvailableCommandsAndNotifyIfChanged();
        }
        return z;
    }

    static /* synthetic */ void lambda$updateTimelineAndNotifyIfChanged$9(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, Player.Listener listener) {
        listener.onPositionDiscontinuity(4);
        listener.onPositionDiscontinuity(positionInfo, positionInfo2, 4);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$updateTimelineAndNotifyIfChanged$10$androidx-media3-cast-CastPlayer  reason: not valid java name */
    public /* synthetic */ void m58lambda$updateTimelineAndNotifyIfChanged$10$androidxmedia3castCastPlayer(Player.Listener listener) {
        listener.onMediaItemTransition(getCurrentMediaItem(), 3);
    }

    private boolean updateTimeline() {
        CastTimeline castTimeline;
        CastTimeline castTimeline2 = this.currentTimeline;
        if (getMediaStatus() != null) {
            castTimeline = this.timelineTracker.getCastTimeline(this.remoteMediaClient);
        } else {
            castTimeline = CastTimeline.EMPTY_CAST_TIMELINE;
        }
        this.currentTimeline = castTimeline;
        boolean z = !castTimeline2.equals(castTimeline);
        if (z) {
            this.currentWindowIndex = fetchCurrentWindowIndex(this.remoteMediaClient, this.currentTimeline);
        }
        return z;
    }

    private boolean updateTracksAndSelectionsAndNotifyIfChanged() {
        if (this.remoteMediaClient == null) {
            return false;
        }
        MediaStatus mediaStatus = getMediaStatus();
        List<MediaTrack> list = null;
        MediaInfo mediaInfo = mediaStatus != null ? mediaStatus.getMediaInfo() : null;
        if (mediaInfo != null) {
            list = mediaInfo.getMediaTracks();
        }
        if (list == null || list.isEmpty()) {
            boolean z = !Tracks.EMPTY.equals(this.currentTracks);
            this.currentTracks = Tracks.EMPTY;
            return z;
        }
        long[] activeTrackIds = mediaStatus.getActiveTrackIds();
        if (activeTrackIds == null) {
            activeTrackIds = EMPTY_TRACK_ID_ARRAY;
        }
        Tracks.Group[] groupArr = new Tracks.Group[list.size()];
        for (int i = 0; i < list.size(); i++) {
            MediaTrack mediaTrack = list.get(i);
            groupArr[i] = new Tracks.Group(new TrackGroup(Integer.toString(i), CastUtils.mediaTrackToFormat(mediaTrack)), false, new int[]{4}, new boolean[]{isTrackActive(mediaTrack.getId(), activeTrackIds)});
        }
        Tracks tracks = new Tracks(ImmutableList.copyOf((E[]) groupArr));
        if (tracks.equals(this.currentTracks)) {
            return false;
        }
        this.currentTracks = tracks;
        return true;
    }

    private void updateAvailableCommandsAndNotifyIfChanged() {
        Player.Commands commands = this.availableCommands;
        Player.Commands availableCommands2 = Util.getAvailableCommands(this, PERMANENT_AVAILABLE_COMMANDS);
        this.availableCommands = availableCommands2;
        if (!availableCommands2.equals(commands)) {
            this.listeners.queueEvent(13, new CastPlayer$$ExternalSyntheticLambda14(this));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$updateAvailableCommandsAndNotifyIfChanged$11$androidx-media3-cast-CastPlayer  reason: not valid java name */
    public /* synthetic */ void m54lambda$updateAvailableCommandsAndNotifyIfChanged$11$androidxmedia3castCastPlayer(Player.Listener listener) {
        listener.onAvailableCommandsChanged(this.availableCommands);
    }

    private void setMediaItemsInternal(List<MediaItem> list, int i, long j, int i2) {
        if (this.remoteMediaClient != null && !list.isEmpty()) {
            if (j == -9223372036854775807L) {
                j = 0;
            }
            if (i == -1) {
                i = getCurrentMediaItemIndex();
                j = getCurrentPosition();
            }
            long j2 = j;
            if (!getCurrentTimeline().isEmpty()) {
                this.pendingMediaItemRemovalPosition = getCurrentPositionInfo();
            }
            MediaQueueItem[] mediaQueueItems = toMediaQueueItems(list);
            this.timelineTracker.onMediaItemsSet(list, mediaQueueItems);
            this.remoteMediaClient.queueLoad(mediaQueueItems, Math.min(i, list.size() - 1), getCastRepeatMode(i2), j2, (JSONObject) null);
        }
    }

    private void addMediaItemsInternal(List<MediaItem> list, int i) {
        if (this.remoteMediaClient != null && getMediaStatus() != null) {
            MediaQueueItem[] mediaQueueItems = toMediaQueueItems(list);
            this.timelineTracker.onMediaItemsAdded(list, mediaQueueItems);
            this.remoteMediaClient.queueInsertItems(mediaQueueItems, i, (JSONObject) null);
        }
    }

    private void moveMediaItemsInternal(int[] iArr, int i, int i2) {
        if (this.remoteMediaClient != null && getMediaStatus() != null) {
            if (i < i2) {
                i2 += iArr.length;
            }
            this.remoteMediaClient.queueReorderItems(iArr, i2 < this.currentTimeline.getWindowCount() ? ((Integer) this.currentTimeline.getWindow(i2, this.window).uid).intValue() : 0, (JSONObject) null);
        }
    }

    private PendingResult<RemoteMediaClient.MediaChannelResult> removeMediaItemsInternal(int[] iArr) {
        if (this.remoteMediaClient == null || getMediaStatus() == null) {
            return null;
        }
        Timeline currentTimeline2 = getCurrentTimeline();
        if (!currentTimeline2.isEmpty()) {
            Object castNonNull = Util.castNonNull(currentTimeline2.getPeriod(getCurrentPeriodIndex(), this.period, true).uid);
            int length = iArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (castNonNull.equals(Integer.valueOf(iArr[i]))) {
                    this.pendingMediaItemRemovalPosition = getCurrentPositionInfo();
                    break;
                } else {
                    i++;
                }
            }
        }
        return this.remoteMediaClient.queueRemoveItems(iArr, (JSONObject) null);
    }

    private Player.PositionInfo getCurrentPositionInfo() {
        Object obj;
        MediaItem mediaItem;
        Object obj2;
        Timeline currentTimeline2 = getCurrentTimeline();
        if (!currentTimeline2.isEmpty()) {
            Object obj3 = currentTimeline2.getPeriod(getCurrentPeriodIndex(), this.period, true).uid;
            obj2 = currentTimeline2.getWindow(this.period.windowIndex, this.window).uid;
            obj = obj3;
            mediaItem = this.window.mediaItem;
        } else {
            obj2 = null;
            mediaItem = null;
            obj = null;
        }
        return new Player.PositionInfo(obj2, getCurrentMediaItemIndex(), mediaItem, obj, getCurrentPeriodIndex(), getCurrentPosition(), getContentPosition(), -1, -1);
    }

    private void setRepeatModeAndNotifyIfChanged(int i) {
        if (((Integer) this.repeatMode.value).intValue() != i) {
            this.repeatMode.value = Integer.valueOf(i);
            this.listeners.queueEvent(8, new CastPlayer$$ExternalSyntheticLambda7(i));
            updateAvailableCommandsAndNotifyIfChanged();
        }
    }

    private void setPlaybackParametersAndNotifyIfChanged(PlaybackParameters playbackParameters2) {
        if (!((PlaybackParameters) this.playbackParameters.value).equals(playbackParameters2)) {
            this.playbackParameters.value = playbackParameters2;
            this.listeners.queueEvent(12, new CastPlayer$$ExternalSyntheticLambda15(playbackParameters2));
            updateAvailableCommandsAndNotifyIfChanged();
        }
    }

    private void setPlayerStateAndNotifyIfChanged(boolean z, int i, int i2) {
        boolean z2 = true;
        boolean z3 = this.playbackState == 3 && ((Boolean) this.playWhenReady.value).booleanValue();
        boolean z4 = ((Boolean) this.playWhenReady.value).booleanValue() != z;
        boolean z5 = this.playbackState != i2;
        if (z4 || z5) {
            this.playbackState = i2;
            this.playWhenReady.value = Boolean.valueOf(z);
            this.listeners.queueEvent(-1, new CastPlayer$$ExternalSyntheticLambda16(z, i2));
            if (z5) {
                this.listeners.queueEvent(4, new CastPlayer$$ExternalSyntheticLambda17(i2));
            }
            if (z4) {
                this.listeners.queueEvent(5, new CastPlayer$$ExternalSyntheticLambda1(z, i));
            }
            if (i2 != 3 || !z) {
                z2 = false;
            }
            if (z3 != z2) {
                this.listeners.queueEvent(7, new CastPlayer$$ExternalSyntheticLambda2(z2));
            }
        }
    }

    /* access modifiers changed from: private */
    public void setRemoteMediaClient(RemoteMediaClient remoteMediaClient2) {
        RemoteMediaClient remoteMediaClient3 = this.remoteMediaClient;
        if (remoteMediaClient3 != remoteMediaClient2) {
            if (remoteMediaClient3 != null) {
                remoteMediaClient3.unregisterCallback(this.statusListener);
                this.remoteMediaClient.removeProgressListener(this.statusListener);
            }
            this.remoteMediaClient = remoteMediaClient2;
            if (remoteMediaClient2 != null) {
                SessionAvailabilityListener sessionAvailabilityListener2 = this.sessionAvailabilityListener;
                if (sessionAvailabilityListener2 != null) {
                    sessionAvailabilityListener2.onCastSessionAvailable();
                }
                remoteMediaClient2.registerCallback(this.statusListener);
                remoteMediaClient2.addProgressListener(this.statusListener, 1000);
                updateInternalStateAndNotifyIfChanged();
                return;
            }
            updateTimelineAndNotifyIfChanged();
            SessionAvailabilityListener sessionAvailabilityListener3 = this.sessionAvailabilityListener;
            if (sessionAvailabilityListener3 != null) {
                sessionAvailabilityListener3.onCastSessionUnavailable();
            }
        }
    }

    private MediaStatus getMediaStatus() {
        RemoteMediaClient remoteMediaClient2 = this.remoteMediaClient;
        if (remoteMediaClient2 != null) {
            return remoteMediaClient2.getMediaStatus();
        }
        return null;
    }

    private static int fetchPlaybackState(RemoteMediaClient remoteMediaClient2) {
        int playerState = remoteMediaClient2.getPlayerState();
        if (playerState == 2 || playerState == 3) {
            return 3;
        }
        return (playerState == 4 || playerState == 5) ? 2 : 1;
    }

    private static int fetchRepeatMode(RemoteMediaClient remoteMediaClient2) {
        MediaStatus mediaStatus = remoteMediaClient2.getMediaStatus();
        int i = 0;
        if (mediaStatus == null) {
            return 0;
        }
        int queueRepeatMode = mediaStatus.getQueueRepeatMode();
        if (queueRepeatMode != 0) {
            i = 2;
            if (queueRepeatMode != 1) {
                if (queueRepeatMode == 2) {
                    return 1;
                }
                if (queueRepeatMode != 3) {
                    throw new IllegalStateException();
                }
            }
        }
        return i;
    }

    private static int fetchCurrentWindowIndex(RemoteMediaClient remoteMediaClient2, Timeline timeline) {
        if (remoteMediaClient2 == null) {
            return 0;
        }
        MediaQueueItem currentItem = remoteMediaClient2.getCurrentItem();
        int indexOfPeriod = currentItem != null ? timeline.getIndexOfPeriod(Integer.valueOf(currentItem.getItemId())) : -1;
        if (indexOfPeriod == -1) {
            return 0;
        }
        return indexOfPeriod;
    }

    private static boolean isTrackActive(long j, long[] jArr) {
        for (long j2 : jArr) {
            if (j2 == j) {
                return true;
            }
        }
        return false;
    }

    private static int getCastRepeatMode(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 1;
        }
        throw new IllegalArgumentException();
    }

    private MediaQueueItem[] toMediaQueueItems(List<MediaItem> list) {
        MediaQueueItem[] mediaQueueItemArr = new MediaQueueItem[list.size()];
        for (int i = 0; i < list.size(); i++) {
            mediaQueueItemArr[i] = this.mediaItemConverter.toMediaQueueItem(list.get(i));
        }
        return mediaQueueItemArr;
    }

    private final class StatusListener extends RemoteMediaClient.Callback implements SessionManagerListener<CastSession>, RemoteMediaClient.ProgressListener {
        public void onAdBreakStatusUpdated() {
        }

        public void onMetadataUpdated() {
        }

        public void onPreloadStatusUpdated() {
        }

        public void onSendingRemoteMediaRequest() {
        }

        public void onSessionEnding(CastSession castSession) {
        }

        public void onSessionResuming(CastSession castSession, String str) {
        }

        public void onSessionStarting(CastSession castSession) {
        }

        private StatusListener() {
        }

        public void onProgressUpdated(long j, long j2) {
            long unused = CastPlayer.this.lastReportedPositionMs = j;
        }

        public void onStatusUpdated() {
            CastPlayer.this.updateInternalStateAndNotifyIfChanged();
        }

        public void onQueueStatusUpdated() {
            boolean unused = CastPlayer.this.updateTimelineAndNotifyIfChanged();
            CastPlayer.this.listeners.flushEvents();
        }

        public void onSessionStarted(CastSession castSession, String str) {
            CastPlayer.this.setRemoteMediaClient(castSession.getRemoteMediaClient());
        }

        public void onSessionResumed(CastSession castSession, boolean z) {
            CastPlayer.this.setRemoteMediaClient(castSession.getRemoteMediaClient());
        }

        public void onSessionEnded(CastSession castSession, int i) {
            CastPlayer.this.setRemoteMediaClient((RemoteMediaClient) null);
        }

        public void onSessionSuspended(CastSession castSession, int i) {
            CastPlayer.this.setRemoteMediaClient((RemoteMediaClient) null);
        }

        public void onSessionResumeFailed(CastSession castSession, int i) {
            Log.e(CastPlayer.TAG, "Session resume failed. Error code " + i + ": " + CastUtils.getLogString(i));
        }

        public void onSessionStartFailed(CastSession castSession, int i) {
            Log.e(CastPlayer.TAG, "Session start failed. Error code " + i + ": " + CastUtils.getLogString(i));
        }
    }

    private final class SeekResultCallback implements ResultCallback<RemoteMediaClient.MediaChannelResult> {
        private SeekResultCallback() {
        }

        public void onResult(RemoteMediaClient.MediaChannelResult mediaChannelResult) {
            int statusCode = mediaChannelResult.getStatus().getStatusCode();
            if (!(statusCode == 0 || statusCode == 2103)) {
                Log.e(CastPlayer.TAG, "Seek failed. Error code " + statusCode + ": " + CastUtils.getLogString(statusCode));
            }
            if (CastPlayer.access$1106(CastPlayer.this) == 0) {
                CastPlayer castPlayer = CastPlayer.this;
                int unused = castPlayer.currentWindowIndex = castPlayer.pendingSeekWindowIndex;
                int unused2 = CastPlayer.this.pendingSeekWindowIndex = -1;
                long unused3 = CastPlayer.this.pendingSeekPositionMs = -9223372036854775807L;
            }
        }
    }

    private static final class StateHolder<T> {
        public ResultCallback<RemoteMediaClient.MediaChannelResult> pendingResultCallback;
        public T value;

        public StateHolder(T t) {
            this.value = t;
        }

        public void clearPendingResultCallback() {
            this.pendingResultCallback = null;
        }

        public boolean acceptsUpdate(ResultCallback<?> resultCallback) {
            return this.pendingResultCallback == resultCallback;
        }
    }
}
