package com.vungle.ads.internal;

import android.content.Context;
import com.vungle.ads.InitializationListener;
import kotlin.Lazy;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class VungleInitializer$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ VungleInitializer f$2;
    public final /* synthetic */ InitializationListener f$3;
    public final /* synthetic */ Lazy f$4;

    public /* synthetic */ VungleInitializer$$ExternalSyntheticLambda1(Context context, String str, VungleInitializer vungleInitializer, InitializationListener initializationListener, Lazy lazy) {
        this.f$0 = context;
        this.f$1 = str;
        this.f$2 = vungleInitializer;
        this.f$3 = initializationListener;
        this.f$4 = lazy;
    }

    public final void run() {
        VungleInitializer.m2285init$lambda3(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
