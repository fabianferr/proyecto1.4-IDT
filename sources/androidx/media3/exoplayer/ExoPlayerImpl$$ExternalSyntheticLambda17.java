package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda17 implements ListenerSet.Event {
    public final /* synthetic */ boolean f$0;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda17(boolean z) {
        this.f$0 = z;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onShuffleModeEnabledChanged(this.f$0);
    }
}
