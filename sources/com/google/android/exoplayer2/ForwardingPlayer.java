package com.google.android.exoplayer2;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.device.DeviceInfo;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.video.VideoSize;
import java.util.List;

public class ForwardingPlayer implements Player {
    private final Player player;

    public ForwardingPlayer(Player player2) {
        this.player = player2;
    }

    public Looper getApplicationLooper() {
        return this.player.getApplicationLooper();
    }

    @Deprecated
    public void addListener(Player.EventListener eventListener) {
        this.player.addListener((Player.EventListener) new ForwardingEventListener(eventListener));
    }

    public void addListener(Player.Listener listener) {
        this.player.addListener((Player.Listener) new ForwardingListener(this, listener));
    }

    @Deprecated
    public void removeListener(Player.EventListener eventListener) {
        this.player.removeListener((Player.EventListener) new ForwardingEventListener(eventListener));
    }

    public void removeListener(Player.Listener listener) {
        this.player.removeListener((Player.Listener) new ForwardingListener(this, listener));
    }

    public void setMediaItems(List<MediaItem> list) {
        this.player.setMediaItems(list);
    }

    public void setMediaItems(List<MediaItem> list, boolean z) {
        this.player.setMediaItems(list, z);
    }

    public void setMediaItems(List<MediaItem> list, int i, long j) {
        this.player.setMediaItems(list, i, j);
    }

    public void setMediaItem(MediaItem mediaItem) {
        this.player.setMediaItem(mediaItem);
    }

    public void setMediaItem(MediaItem mediaItem, long j) {
        this.player.setMediaItem(mediaItem, j);
    }

    public void setMediaItem(MediaItem mediaItem, boolean z) {
        this.player.setMediaItem(mediaItem, z);
    }

    public void addMediaItem(MediaItem mediaItem) {
        this.player.addMediaItem(mediaItem);
    }

    public void addMediaItem(int i, MediaItem mediaItem) {
        this.player.addMediaItem(i, mediaItem);
    }

    public void addMediaItems(List<MediaItem> list) {
        this.player.addMediaItems(list);
    }

    public void addMediaItems(int i, List<MediaItem> list) {
        this.player.addMediaItems(i, list);
    }

    public void moveMediaItem(int i, int i2) {
        this.player.moveMediaItem(i, i2);
    }

    public void moveMediaItems(int i, int i2, int i3) {
        this.player.moveMediaItems(i, i2, i3);
    }

    public void removeMediaItem(int i) {
        this.player.removeMediaItem(i);
    }

    public void removeMediaItems(int i, int i2) {
        this.player.removeMediaItems(i, i2);
    }

    public void clearMediaItems() {
        this.player.clearMediaItems();
    }

    public boolean isCommandAvailable(int i) {
        return this.player.isCommandAvailable(i);
    }

    public Player.Commands getAvailableCommands() {
        return this.player.getAvailableCommands();
    }

    public void prepare() {
        this.player.prepare();
    }

    public int getPlaybackState() {
        return this.player.getPlaybackState();
    }

    public int getPlaybackSuppressionReason() {
        return this.player.getPlaybackSuppressionReason();
    }

    public boolean isPlaying() {
        return this.player.isPlaying();
    }

    public PlaybackException getPlayerError() {
        return this.player.getPlayerError();
    }

    public void play() {
        this.player.play();
    }

    public void pause() {
        this.player.pause();
    }

    public void setPlayWhenReady(boolean z) {
        this.player.setPlayWhenReady(z);
    }

    public boolean getPlayWhenReady() {
        return this.player.getPlayWhenReady();
    }

    public void setRepeatMode(int i) {
        this.player.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.player.getRepeatMode();
    }

    public void setShuffleModeEnabled(boolean z) {
        this.player.setShuffleModeEnabled(z);
    }

    public boolean getShuffleModeEnabled() {
        return this.player.getShuffleModeEnabled();
    }

    public boolean isLoading() {
        return this.player.isLoading();
    }

    public void seekToDefaultPosition() {
        this.player.seekToDefaultPosition();
    }

    public void seekToDefaultPosition(int i) {
        this.player.seekToDefaultPosition(i);
    }

    public void seekTo(long j) {
        this.player.seekTo(j);
    }

    public void seekTo(int i, long j) {
        this.player.seekTo(i, j);
    }

    public long getSeekBackIncrement() {
        return this.player.getSeekBackIncrement();
    }

    public void seekBack() {
        this.player.seekBack();
    }

    public long getSeekForwardIncrement() {
        return this.player.getSeekForwardIncrement();
    }

    public void seekForward() {
        this.player.seekForward();
    }

    @Deprecated
    public boolean hasPrevious() {
        return this.player.hasPrevious();
    }

    public boolean hasPreviousWindow() {
        return this.player.hasPreviousWindow();
    }

    @Deprecated
    public void previous() {
        this.player.previous();
    }

    public void seekToPreviousWindow() {
        this.player.seekToPreviousWindow();
    }

    public void seekToPrevious() {
        this.player.seekToPrevious();
    }

    public int getMaxSeekToPreviousPosition() {
        return this.player.getMaxSeekToPreviousPosition();
    }

    @Deprecated
    public boolean hasNext() {
        return this.player.hasNext();
    }

    public boolean hasNextWindow() {
        return this.player.hasNextWindow();
    }

    @Deprecated
    public void next() {
        this.player.next();
    }

    public void seekToNextWindow() {
        this.player.seekToNextWindow();
    }

    public void seekToNext() {
        this.player.seekToNext();
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.player.setPlaybackParameters(playbackParameters);
    }

    public void setPlaybackSpeed(float f) {
        this.player.setPlaybackSpeed(f);
    }

    public PlaybackParameters getPlaybackParameters() {
        return this.player.getPlaybackParameters();
    }

    public void stop() {
        this.player.stop();
    }

    @Deprecated
    public void stop(boolean z) {
        this.player.stop(z);
    }

    public void release() {
        this.player.release();
    }

    public TrackGroupArray getCurrentTrackGroups() {
        return this.player.getCurrentTrackGroups();
    }

    public TrackSelectionArray getCurrentTrackSelections() {
        return this.player.getCurrentTrackSelections();
    }

    @Deprecated
    public List<Metadata> getCurrentStaticMetadata() {
        return this.player.getCurrentStaticMetadata();
    }

    public MediaMetadata getMediaMetadata() {
        return this.player.getMediaMetadata();
    }

    public MediaMetadata getPlaylistMetadata() {
        return this.player.getPlaylistMetadata();
    }

    public void setPlaylistMetadata(MediaMetadata mediaMetadata) {
        this.player.setPlaylistMetadata(mediaMetadata);
    }

    public Object getCurrentManifest() {
        return this.player.getCurrentManifest();
    }

    public Timeline getCurrentTimeline() {
        return this.player.getCurrentTimeline();
    }

    public int getCurrentPeriodIndex() {
        return this.player.getCurrentPeriodIndex();
    }

    public int getCurrentWindowIndex() {
        return this.player.getCurrentWindowIndex();
    }

    public int getNextWindowIndex() {
        return this.player.getNextWindowIndex();
    }

    public int getPreviousWindowIndex() {
        return this.player.getPreviousWindowIndex();
    }

    public MediaItem getCurrentMediaItem() {
        return this.player.getCurrentMediaItem();
    }

    public int getMediaItemCount() {
        return this.player.getMediaItemCount();
    }

    public MediaItem getMediaItemAt(int i) {
        return this.player.getMediaItemAt(i);
    }

    public long getDuration() {
        return this.player.getDuration();
    }

    public long getCurrentPosition() {
        return this.player.getCurrentPosition();
    }

    public long getBufferedPosition() {
        return this.player.getBufferedPosition();
    }

    public int getBufferedPercentage() {
        return this.player.getBufferedPercentage();
    }

    public long getTotalBufferedDuration() {
        return this.player.getTotalBufferedDuration();
    }

    public boolean isCurrentWindowDynamic() {
        return this.player.isCurrentWindowDynamic();
    }

    public boolean isCurrentWindowLive() {
        return this.player.isCurrentWindowLive();
    }

    public long getCurrentLiveOffset() {
        return this.player.getCurrentLiveOffset();
    }

    public boolean isCurrentWindowSeekable() {
        return this.player.isCurrentWindowSeekable();
    }

    public boolean isPlayingAd() {
        return this.player.isPlayingAd();
    }

    public int getCurrentAdGroupIndex() {
        return this.player.getCurrentAdGroupIndex();
    }

    public int getCurrentAdIndexInAdGroup() {
        return this.player.getCurrentAdIndexInAdGroup();
    }

    public long getContentDuration() {
        return this.player.getContentDuration();
    }

    public long getContentPosition() {
        return this.player.getContentPosition();
    }

    public long getContentBufferedPosition() {
        return this.player.getContentBufferedPosition();
    }

    public AudioAttributes getAudioAttributes() {
        return this.player.getAudioAttributes();
    }

    public void setVolume(float f) {
        this.player.setVolume(f);
    }

    public float getVolume() {
        return this.player.getVolume();
    }

    public VideoSize getVideoSize() {
        return this.player.getVideoSize();
    }

    public void clearVideoSurface() {
        this.player.clearVideoSurface();
    }

    public void clearVideoSurface(Surface surface) {
        this.player.clearVideoSurface(surface);
    }

    public void setVideoSurface(Surface surface) {
        this.player.setVideoSurface(surface);
    }

    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.player.setVideoSurfaceHolder(surfaceHolder);
    }

    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.player.clearVideoSurfaceHolder(surfaceHolder);
    }

    public void setVideoSurfaceView(SurfaceView surfaceView) {
        this.player.setVideoSurfaceView(surfaceView);
    }

    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        this.player.clearVideoSurfaceView(surfaceView);
    }

    public void setVideoTextureView(TextureView textureView) {
        this.player.setVideoTextureView(textureView);
    }

    public void clearVideoTextureView(TextureView textureView) {
        this.player.clearVideoTextureView(textureView);
    }

    public List<Cue> getCurrentCues() {
        return this.player.getCurrentCues();
    }

    public DeviceInfo getDeviceInfo() {
        return this.player.getDeviceInfo();
    }

    public int getDeviceVolume() {
        return this.player.getDeviceVolume();
    }

    public boolean isDeviceMuted() {
        return this.player.isDeviceMuted();
    }

    public void setDeviceVolume(int i) {
        this.player.setDeviceVolume(i);
    }

    public void increaseDeviceVolume() {
        this.player.increaseDeviceVolume();
    }

    public void decreaseDeviceVolume() {
        this.player.decreaseDeviceVolume();
    }

    public void setDeviceMuted(boolean z) {
        this.player.setDeviceMuted(z);
    }

    public Player getWrappedPlayer() {
        return this.player;
    }

    private static class ForwardingEventListener implements Player.EventListener {
        private final Player.EventListener eventListener;
        private final ForwardingPlayer forwardingPlayer;

        private ForwardingEventListener(ForwardingPlayer forwardingPlayer2, Player.EventListener eventListener2) {
            this.forwardingPlayer = forwardingPlayer2;
            this.eventListener = eventListener2;
        }

        public void onTimelineChanged(Timeline timeline, int i) {
            this.eventListener.onTimelineChanged(timeline, i);
        }

        public void onMediaItemTransition(MediaItem mediaItem, int i) {
            this.eventListener.onMediaItemTransition(mediaItem, i);
        }

        public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            this.eventListener.onTracksChanged(trackGroupArray, trackSelectionArray);
        }

        @Deprecated
        public void onStaticMetadataChanged(List<Metadata> list) {
            this.eventListener.onStaticMetadataChanged(list);
        }

        public void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
            this.eventListener.onMediaMetadataChanged(mediaMetadata);
        }

        public void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
            this.eventListener.onPlaylistMetadataChanged(mediaMetadata);
        }

        public void onIsLoadingChanged(boolean z) {
            this.eventListener.onIsLoadingChanged(z);
        }

        public void onLoadingChanged(boolean z) {
            this.eventListener.onIsLoadingChanged(z);
        }

        public void onAvailableCommandsChanged(Player.Commands commands) {
            this.eventListener.onAvailableCommandsChanged(commands);
        }

        public void onPlayerStateChanged(boolean z, int i) {
            this.eventListener.onPlayerStateChanged(z, i);
        }

        public void onPlaybackStateChanged(int i) {
            this.eventListener.onPlaybackStateChanged(i);
        }

        public void onPlayWhenReadyChanged(boolean z, int i) {
            this.eventListener.onPlayWhenReadyChanged(z, i);
        }

        public void onPlaybackSuppressionReasonChanged(int i) {
            this.eventListener.onPlaybackSuppressionReasonChanged(i);
        }

        public void onIsPlayingChanged(boolean z) {
            this.eventListener.onIsPlayingChanged(z);
        }

        public void onRepeatModeChanged(int i) {
            this.eventListener.onRepeatModeChanged(i);
        }

        public void onShuffleModeEnabledChanged(boolean z) {
            this.eventListener.onShuffleModeEnabledChanged(z);
        }

        public void onPlayerError(PlaybackException playbackException) {
            this.eventListener.onPlayerError(playbackException);
        }

        public void onPlayerErrorChanged(PlaybackException playbackException) {
            this.eventListener.onPlayerErrorChanged(playbackException);
        }

        public void onPositionDiscontinuity(int i) {
            this.eventListener.onPositionDiscontinuity(i);
        }

        public void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
            this.eventListener.onPositionDiscontinuity(positionInfo, positionInfo2, i);
        }

        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            this.eventListener.onPlaybackParametersChanged(playbackParameters);
        }

        public void onSeekBackIncrementChanged(long j) {
            this.eventListener.onSeekBackIncrementChanged(j);
        }

        public void onSeekForwardIncrementChanged(long j) {
            this.eventListener.onSeekForwardIncrementChanged(j);
        }

        public void onMaxSeekToPreviousPositionChanged(int i) {
            this.eventListener.onMaxSeekToPreviousPositionChanged(i);
        }

        public void onSeekProcessed() {
            this.eventListener.onSeekProcessed();
        }

        public void onEvents(Player player, Player.Events events) {
            this.eventListener.onEvents(this.forwardingPlayer, events);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForwardingEventListener)) {
                return false;
            }
            ForwardingEventListener forwardingEventListener = (ForwardingEventListener) obj;
            if (!this.forwardingPlayer.equals(forwardingEventListener.forwardingPlayer)) {
                return false;
            }
            return this.eventListener.equals(forwardingEventListener.eventListener);
        }

        public int hashCode() {
            return (this.forwardingPlayer.hashCode() * 31) + this.eventListener.hashCode();
        }
    }

    private static final class ForwardingListener extends ForwardingEventListener implements Player.Listener {
        private final Player.Listener listener;

        public ForwardingListener(ForwardingPlayer forwardingPlayer, Player.Listener listener2) {
            super(listener2);
            this.listener = listener2;
        }

        public void onVideoSizeChanged(VideoSize videoSize) {
            this.listener.onVideoSizeChanged(videoSize);
        }

        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            this.listener.onVideoSizeChanged(i, i2, i3, f);
        }

        public void onSurfaceSizeChanged(int i, int i2) {
            this.listener.onSurfaceSizeChanged(i, i2);
        }

        public void onRenderedFirstFrame() {
            this.listener.onRenderedFirstFrame();
        }

        public void onAudioSessionIdChanged(int i) {
            this.listener.onAudioSessionIdChanged(i);
        }

        public void onAudioAttributesChanged(AudioAttributes audioAttributes) {
            this.listener.onAudioAttributesChanged(audioAttributes);
        }

        public void onVolumeChanged(float f) {
            this.listener.onVolumeChanged(f);
        }

        public void onSkipSilenceEnabledChanged(boolean z) {
            this.listener.onSkipSilenceEnabledChanged(z);
        }

        public void onCues(List<Cue> list) {
            this.listener.onCues(list);
        }

        public void onMetadata(Metadata metadata) {
            this.listener.onMetadata(metadata);
        }

        public void onDeviceInfoChanged(DeviceInfo deviceInfo) {
            this.listener.onDeviceInfoChanged(deviceInfo);
        }

        public void onDeviceVolumeChanged(int i, boolean z) {
            this.listener.onDeviceVolumeChanged(i, z);
        }
    }
}
