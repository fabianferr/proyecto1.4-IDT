package androidx.media3.common;

import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SimpleBasePlayer$$ExternalSyntheticLambda42 implements AsyncFunction {
    public final /* synthetic */ ListenableFuture f$0;

    public /* synthetic */ SimpleBasePlayer$$ExternalSyntheticLambda42(ListenableFuture listenableFuture) {
        this.f$0 = listenableFuture;
    }

    public final ListenableFuture apply(Object obj) {
        return SimpleBasePlayer.lambda$handleReplaceMediaItems$30(this.f$0, obj);
    }
}
