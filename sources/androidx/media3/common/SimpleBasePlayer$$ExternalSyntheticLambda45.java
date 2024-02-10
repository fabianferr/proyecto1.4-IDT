package androidx.media3.common;

import java.util.concurrent.Executor;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SimpleBasePlayer$$ExternalSyntheticLambda45 implements Executor {
    public final /* synthetic */ SimpleBasePlayer f$0;

    public /* synthetic */ SimpleBasePlayer$$ExternalSyntheticLambda45(SimpleBasePlayer simpleBasePlayer) {
        this.f$0 = simpleBasePlayer;
    }

    public final void execute(Runnable runnable) {
        this.f$0.postOrRunOnApplicationHandler(runnable);
    }
}
