package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda24 implements ListenerSet.Event {
    public final /* synthetic */ PlaybackInfo f$0;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda24(PlaybackInfo playbackInfo) {
        this.f$0 = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onIsPlayingChanged(this.f$0.isPlaying());
    }
}