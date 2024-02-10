package androidx.media3.cast;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CastPlayer$$ExternalSyntheticLambda7 implements ListenerSet.Event {
    public final /* synthetic */ int f$0;

    public /* synthetic */ CastPlayer$$ExternalSyntheticLambda7(int i) {
        this.f$0 = i;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onRepeatModeChanged(this.f$0);
    }
}
