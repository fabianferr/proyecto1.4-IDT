package androidx.media3.exoplayer;

import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda4 implements ListenerSet.Event {
    public final /* synthetic */ MediaMetadata f$0;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda4(MediaMetadata mediaMetadata) {
        this.f$0 = mediaMetadata;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onMediaMetadataChanged(this.f$0);
    }
}