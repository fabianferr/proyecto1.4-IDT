package androidx.mediarouter.media;

import androidx.mediarouter.media.MediaRouter;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MediaRouter$PrepareTransferNotifier$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ MediaRouter.PrepareTransferNotifier f$0;

    public /* synthetic */ MediaRouter$PrepareTransferNotifier$$ExternalSyntheticLambda0(MediaRouter.PrepareTransferNotifier prepareTransferNotifier) {
        this.f$0 = prepareTransferNotifier;
    }

    public final void run() {
        this.f$0.finishTransfer();
    }
}