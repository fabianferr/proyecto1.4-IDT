package androidx.media3.cast;

import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CastPlayer$$ExternalSyntheticLambda12 implements ListenerSet.Event {
    public final /* synthetic */ MediaItem f$0;

    public /* synthetic */ CastPlayer$$ExternalSyntheticLambda12(MediaItem mediaItem) {
        this.f$0 = mediaItem;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onMediaItemTransition(this.f$0, 2);
    }
}
