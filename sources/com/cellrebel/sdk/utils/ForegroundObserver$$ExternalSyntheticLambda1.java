package com.cellrebel.sdk.utils;

import com.cellrebel.sdk.networking.beans.response.Settings;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ForegroundObserver$$ExternalSyntheticLambda1 implements Callable {
    public final /* synthetic */ ForegroundObserver f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Settings f$2;

    public /* synthetic */ ForegroundObserver$$ExternalSyntheticLambda1(ForegroundObserver foregroundObserver, boolean z, Settings settings) {
        this.f$0 = foregroundObserver;
        this.f$1 = z;
        this.f$2 = settings;
    }

    public final Object call() {
        return this.f$0.a(this.f$1, this.f$2);
    }
}
