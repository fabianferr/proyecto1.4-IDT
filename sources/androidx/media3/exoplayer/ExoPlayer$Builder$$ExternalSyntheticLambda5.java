package androidx.media3.exoplayer;

import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.MediaSource;
import com.google.common.base.Supplier;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExoPlayer$Builder$$ExternalSyntheticLambda5 implements Supplier {
    public final /* synthetic */ MediaSource.Factory f$0;

    public /* synthetic */ ExoPlayer$Builder$$ExternalSyntheticLambda5(MediaSource.Factory factory) {
        this.f$0 = factory;
    }

    public final Object get() {
        return ExoPlayer.Builder.lambda$setMediaSourceFactory$17(this.f$0);
    }
}
