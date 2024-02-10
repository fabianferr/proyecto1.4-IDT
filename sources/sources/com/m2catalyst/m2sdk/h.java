package com.m2catalyst.m2sdk;

import android.telephony.TelephonyManager;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: CellInfoStrategy.kt */
public final class h extends Lambda implements Function0<String> {
    public final /* synthetic */ TelephonyManager a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(TelephonyManager telephonyManager) {
        super(0);
        this.a = telephonyManager;
    }

    public final Object invoke() {
        return this.a.getSimOperatorName();
    }
}
