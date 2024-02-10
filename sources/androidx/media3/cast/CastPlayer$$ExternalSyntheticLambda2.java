package androidx.media3.cast;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CastPlayer$$ExternalSyntheticLambda2 implements ListenerSet.Event {
    public final /* synthetic */ boolean f$0;

    public /* synthetic */ CastPlayer$$ExternalSyntheticLambda2(boolean z) {
        this.f$0 = z;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onIsPlayingChanged(this.f$0);
    }
}
