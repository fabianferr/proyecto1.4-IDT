package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

public abstract class BasePlayer implements Player {
    protected final Timeline.Window window = new Timeline.Window();

    protected BasePlayer() {
    }

    public final void setMediaItem(MediaItem mediaItem) {
        setMediaItems(Collections.singletonList(mediaItem));
    }

    public final void setMediaItem(MediaItem mediaItem, long j) {
        setMediaItems(Collections.singletonList(mediaItem), 0, j);
    }

    public final void setMediaItem(MediaItem mediaItem, boolean z) {
        setMediaItems(Collections.singletonList(mediaItem), z);
    }

    public final void setMediaItems(List<MediaItem> list) {
        setMediaItems(list, true);
    }

    public final void addMediaItem(int i, MediaItem mediaItem) {
        addMediaItems(i, Collections.singletonList(mediaItem));
    }

    public final void addMediaItem(MediaItem mediaItem) {
        addMediaItems(Collections.singletonList(mediaItem));
    }

    public final void addMediaItems(List<MediaItem> list) {
        addMediaItems(Integer.MAX_VALUE, list);
    }

    public final void moveMediaItem(int i, int i2) {
        if (i != i2) {
            moveMediaItems(i, i + 1, i2);
        }
    }

    public final void removeMediaItem(int i) {
        removeMediaItems(i, i + 1);
    }

    public final void clearMediaItems() {
        removeMediaItems(0, Integer.MAX_VALUE);
    }

    public final boolean isCommandAvailable(int i) {
        return getAvailableCommands().contains(i);
    }

    public final void play() {
        setPlayWhenReady(true);
    }

    public final void pause() {
        setPlayWhenReady(false);
    }

    public final boolean isPlaying() {
        return getPlaybackState() == 3 && getPlayWhenReady() && getPlaybackSuppressionReason() == 0;
    }

    public final void seekToDefaultPosition() {
        seekToDefaultPosition(getCurrentWindowIndex());
    }

    public final void seekToDefaultPosition(int i) {
        seekTo(i, -9223372036854775807L);
    }

    public final void seekTo(long j) {
        seekTo(getCurrentWindowIndex(), j);
    }

    public final void seekBack() {
        seekToOffset(-getSeekBackIncrement());
    }

    public final void seekForward() {
        seekToOffset(getSeekForwardIncrement());
    }

    @Deprecated
    public final boolean hasPrevious() {
        return hasPreviousWindow();
    }

    public final boolean hasPreviousWindow() {
        return getPreviousWindowIndex() != -1;
    }

    @Deprecated
    public final void previous() {
        seekToPreviousWindow();
    }

    public final void seekToPreviousWindow() {
        int previousWindowIndex = getPreviousWindowIndex();
        if (previousWindowIndex != -1) {
            seekToDefaultPosition(previousWindowIndex);
        }
    }

    public final void seekToPrevious() {
        if (!getCurrentTimeline().isEmpty() && !isPlayingAd()) {
            boolean hasPreviousWindow = hasPreviousWindow();
            if (!isCurrentWindowLive() || isCurrentWindowSeekable()) {
                if (!hasPreviousWindow || getCurrentPosition() > ((long) getMaxSeekToPreviousPosition())) {
                    seekTo(0);
                } else {
                    seekToPreviousWindow();
                }
            } else if (hasPreviousWindow) {
                seekToPreviousWindow();
            }
        }
    }

    @Deprecated
    public final boolean hasNext() {
        return hasNextWindow();
    }

    public final boolean hasNextWindow() {
        return getNextWindowIndex() != -1;
    }

    @Deprecated
    public final void next() {
        seekToNextWindow();
    }

    public final void seekToNextWindow() {
        int nextWindowIndex = getNextWindowIndex();
        if (nextWindowIndex != -1) {
            seekToDefaultPosition(nextWindowIndex);
        }
    }

    public final void seekToNext() {
        if (!getCurrentTimeline().isEmpty() && !isPlayingAd()) {
            if (hasNextWindow()) {
                seekToNextWindow();
            } else if (isCurrentWindowLive() && isCurrentWindowDynamic()) {
                seekToDefaultPosition();
            }
        }
    }

    public final void setPlaybackSpeed(float f) {
        setPlaybackParameters(getPlaybackParameters().withSpeed(f));
    }

    public final void stop() {
        stop(false);
    }

    public final int getNextWindowIndex() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        return currentTimeline.getNextWindowIndex(getCurrentWindowIndex(), getRepeatModeForNavigation(), getShuffleModeEnabled());
    }

    public final int getPreviousWindowIndex() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        return currentTimeline.getPreviousWindowIndex(getCurrentWindowIndex(), getRepeatModeForNavigation(), getShuffleModeEnabled());
    }

    public final MediaItem getCurrentMediaItem() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        return currentTimeline.getWindow(getCurrentWindowIndex(), this.window).mediaItem;
    }

    public final int getMediaItemCount() {
        return getCurrentTimeline().getWindowCount();
    }

    public final MediaItem getMediaItemAt(int i) {
        return getCurrentTimeline().getWindow(i, this.window).mediaItem;
    }

    public final Object getCurrentManifest() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        return currentTimeline.getWindow(getCurrentWindowIndex(), this.window).manifest;
    }

    public final int getBufferedPercentage() {
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return Util.constrainValue((int) ((bufferedPosition * 100) / duration), 0, 100);
    }

    public final boolean isCurrentWindowDynamic() {
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentWindowIndex(), this.window).isDynamic;
    }

    public final boolean isCurrentWindowLive() {
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentWindowIndex(), this.window).isLive();
    }

    public final long getCurrentLiveOffset() {
        Timeline currentTimeline = getCurrentTimeline();
        if (!currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentWindowIndex(), this.window).windowStartTimeMs != -9223372036854775807L) {
            return (this.window.getCurrentUnixTimeMs() - this.window.windowStartTimeMs) - getContentPosition();
        }
        return -9223372036854775807L;
    }

    public final boolean isCurrentWindowSeekable() {
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentWindowIndex(), this.window).isSeekable;
    }

    public final long getContentDuration() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -9223372036854775807L;
        }
        return currentTimeline.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
    }

    /* access modifiers changed from: protected */
    public Player.Commands getAvailableCommands(Player.Commands commands) {
        boolean z = true;
        Player.Commands.Builder addIf = new Player.Commands.Builder().addAll(commands).addIf(3, !isPlayingAd()).addIf(4, isCurrentWindowSeekable() && !isPlayingAd()).addIf(5, hasPreviousWindow() && !isPlayingAd()).addIf(6, !getCurrentTimeline().isEmpty() && (hasPreviousWindow() || !isCurrentWindowLive() || isCurrentWindowSeekable()) && !isPlayingAd()).addIf(7, hasNextWindow() && !isPlayingAd()).addIf(8, !getCurrentTimeline().isEmpty() && (hasNextWindow() || (isCurrentWindowLive() && isCurrentWindowDynamic())) && !isPlayingAd()).addIf(9, !isPlayingAd()).addIf(10, isCurrentWindowSeekable() && !isPlayingAd());
        if (!isCurrentWindowSeekable() || isPlayingAd()) {
            z = false;
        }
        return addIf.addIf(11, z).build();
    }

    private int getRepeatModeForNavigation() {
        int repeatMode = getRepeatMode();
        if (repeatMode == 1) {
            return 0;
        }
        return repeatMode;
    }

    private void seekToOffset(long j) {
        long currentPosition = getCurrentPosition() + j;
        long duration = getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        seekTo(Math.max(currentPosition, 0));
    }
}
