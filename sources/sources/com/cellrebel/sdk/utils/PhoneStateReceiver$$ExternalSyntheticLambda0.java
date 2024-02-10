package com.cellrebel.sdk.utils;

import android.content.Context;
import com.cellrebel.sdk.networking.beans.response.Settings;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PhoneStateReceiver$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ Settings f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ Context f$4;

    public /* synthetic */ PhoneStateReceiver$$ExternalSyntheticLambda0(Settings settings, boolean z, boolean z2, boolean z3, Context context) {
        this.f$0 = settings;
        this.f$1 = z;
        this.f$2 = z2;
        this.f$3 = z3;
        this.f$4 = context;
    }

    public final Object call() {
        return PhoneStateReceiver.a(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
