package com.cellrebel.sdk.utils;

import com.cellrebel.sdk.networking.beans.response.Settings;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ForegroundObserver$$ExternalSyntheticLambda2 implements Callable {
    public final /* synthetic */ ForegroundObserver f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Settings f$2;
    public final /* synthetic */ Storage f$3;
    public final /* synthetic */ long f$4;

    public /* synthetic */ ForegroundObserver$$ExternalSyntheticLambda2(ForegroundObserver foregroundObserver, boolean z, Settings settings, Storage storage, long j) {
        this.f$0 = foregroundObserver;
        this.f$1 = z;
        this.f$2 = settings;
        this.f$3 = storage;
        this.f$4 = j;
    }

    public final Object call() {
        return this.f$0.a(this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
