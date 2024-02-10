package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SimpleBasePlayer$$ExternalSyntheticLambda34 implements ListenerSet.Event {
    public final /* synthetic */ Tracks f$0;

    public /* synthetic */ SimpleBasePlayer$$ExternalSyntheticLambda34(Tracks tracks) {
        this.f$0 = tracks;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onTracksChanged(this.f$0);
    }
}
