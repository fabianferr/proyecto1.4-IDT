package com.google.android.exoplayer2;

@Deprecated
public class DefaultControlDispatcher implements ControlDispatcher {
    private final long fastForwardIncrementMs;
    private final boolean rewindAndFastForwardIncrementsSet;
    private final long rewindIncrementMs;

    public DefaultControlDispatcher() {
        this.fastForwardIncrementMs = -9223372036854775807L;
        this.rewindIncrementMs = -9223372036854775807L;
        this.rewindAndFastForwardIncrementsSet = false;
    }

    public DefaultControlDispatcher(long j, long j2) {
        this.fastForwardIncrementMs = j;
        this.rewindIncrementMs = j2;
        this.rewindAndFastForwardIncrementsSet = true;
    }

    public boolean dispatchPrepare(Player player) {
        player.prepare();
        return true;
    }

    public boolean dispatchSetPlayWhenReady(Player player, boolean z) {
        player.setPlayWhenReady(z);
        return true;
    }

    public boolean dispatchSeekTo(Player player, int i, long j) {
        player.seekTo(i, j);
        return true;
    }

    public boolean dispatchPrevious(Player player) {
        player.seekToPrevious();
        return true;
    }

    public boolean dispatchNext(Player player) {
        player.seekToNext();
        return true;
    }

    public boolean dispatchRewind(Player player) {
        if (!this.rewindAndFastForwardIncrementsSet) {
            player.seekBack();
            return true;
        } else if (!isRewindEnabled() || !player.isCurrentWindowSeekable()) {
            return true;
        } else {
            seekToOffset(player, -this.rewindIncrementMs);
            return true;
        }
    }

    public boolean dispatchFastForward(Player player) {
        if (!this.rewindAndFastForwardIncrementsSet) {
            player.seekForward();
            return true;
        } else if (!isFastForwardEnabled() || !player.isCurrentWindowSeekable()) {
            return true;
        } else {
            seekToOffset(player, this.fastForwardIncrementMs);
            return true;
        }
    }

    public boolean dispatchSetRepeatMode(Player player, int i) {
        player.setRepeatMode(i);
        return true;
    }

    public boolean dispatchSetShuffleModeEnabled(Player player, boolean z) {
        player.setShuffleModeEnabled(z);
        return true;
    }

    public boolean dispatchStop(Player player, boolean z) {
        player.stop(z);
        return true;
    }

    public boolean dispatchSetPlaybackParameters(Player player, PlaybackParameters playbackParameters) {
        player.setPlaybackParameters(playbackParameters);
        return true;
    }

    public boolean isRewindEnabled() {
        return !this.rewindAndFastForwardIncrementsSet || this.rewindIncrementMs > 0;
    }

    public boolean isFastForwardEnabled() {
        return !this.rewindAndFastForwardIncrementsSet || this.fastForwardIncrementMs > 0;
    }

    public long getRewindIncrementMs(Player player) {
        return this.rewindAndFastForwardIncrementsSet ? this.rewindIncrementMs : player.getSeekBackIncrement();
    }

    public long getFastForwardIncrementMs(Player player) {
        if (this.rewindAndFastForwardIncrementsSet) {
            return this.fastForwardIncrementMs;
        }
        return player.getSeekForwardIncrement();
    }

    private static void seekToOffset(Player player, long j) {
        long currentPosition = player.getCurrentPosition() + j;
        long duration = player.getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        player.seekTo(Math.max(currentPosition, 0));
    }
}
