package androidx.media3.exoplayer;

import androidx.media3.common.PlaybackParameters;

public interface MediaClock {
    PlaybackParameters getPlaybackParameters();

    long getPositionUs();

    void setPlaybackParameters(PlaybackParameters playbackParameters);
}
