package com.google.android.exoplayer2.transformer;

import android.util.SparseLongArray;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.Util;

final class TransformerMediaClock implements MediaClock {
    private long minTrackTimeUs;
    private final SparseLongArray trackTypeToTimeUs = new SparseLongArray();

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
    }

    public void updateTimeForTrackType(int i, long j) {
        long j2 = this.trackTypeToTimeUs.get(i, -9223372036854775807L);
        if (j2 == -9223372036854775807L || j > j2) {
            this.trackTypeToTimeUs.put(i, j);
            if (j2 == -9223372036854775807L || j2 == this.minTrackTimeUs) {
                this.minTrackTimeUs = Util.minValue(this.trackTypeToTimeUs);
            }
        }
    }

    public long getPositionUs() {
        return this.minTrackTimeUs;
    }

    public PlaybackParameters getPlaybackParameters() {
        return PlaybackParameters.DEFAULT;
    }
}
