package androidx.media3.cast;

import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CastPlayer$$ExternalSyntheticLambda0 implements ListenerSet.Event {
    public final /* synthetic */ Timeline f$0;

    public /* synthetic */ CastPlayer$$ExternalSyntheticLambda0(Timeline timeline) {
        this.f$0 = timeline;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onTimelineChanged(this.f$0, 1);
    }
}
