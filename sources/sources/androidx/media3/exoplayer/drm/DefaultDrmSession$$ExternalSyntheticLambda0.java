package androidx.media3.exoplayer.drm;

import androidx.media3.common.util.Consumer;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultDrmSession$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ Exception f$0;

    public /* synthetic */ DefaultDrmSession$$ExternalSyntheticLambda0(Exception exc) {
        this.f$0 = exc;
    }

    public final void accept(Object obj) {
        ((DrmSessionEventListener.EventDispatcher) obj).drmSessionManagerError(this.f$0);
    }
}
