package com.vungle.ads.internal;

import com.vungle.ads.InitializationListener;
import com.vungle.ads.VungleError;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class VungleInitializer$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ InitializationListener f$0;
    public final /* synthetic */ VungleError f$1;

    public /* synthetic */ VungleInitializer$$ExternalSyntheticLambda0(InitializationListener initializationListener, VungleError vungleError) {
        this.f$0 = initializationListener;
        this.f$1 = vungleError;
    }

    public final void run() {
        VungleInitializer.m2287onInitError$lambda11(this.f$0, this.f$1);
    }
}
