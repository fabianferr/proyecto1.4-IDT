package androidx.media3.cast;

import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CastPlayer$$ExternalSyntheticLambda15 implements ListenerSet.Event {
    public final /* synthetic */ PlaybackParameters f$0;

    public /* synthetic */ CastPlayer$$ExternalSyntheticLambda15(PlaybackParameters playbackParameters) {
        this.f$0 = playbackParameters;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onPlaybackParametersChanged(this.f$0);
    }
}
