package androidx.media3.common;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SimpleBasePlayer$$ExternalSyntheticLambda43 implements Runnable {
    public final /* synthetic */ SimpleBasePlayer f$0;
    public final /* synthetic */ ListenableFuture f$1;

    public /* synthetic */ SimpleBasePlayer$$ExternalSyntheticLambda43(SimpleBasePlayer simpleBasePlayer, ListenableFuture listenableFuture) {
        this.f$0 = simpleBasePlayer;
        this.f$1 = listenableFuture;
    }

    public final void run() {
        this.f$0.m68lambda$updateStateForPendingOperation$61$androidxmedia3commonSimpleBasePlayer(this.f$1);
    }
}
