package com.wortise.ads;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/wortise/ads/r0;", "", "Landroid/content/Context;", "context", "Lcom/wortise/ads/q0;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: BatteryFactory.kt */
public final class r0 {
    public static final r0 a = new r0();

    private r0() {
    }

    public final q0 a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            u0 u0Var = new u0(context);
            return new q0(u0Var.a(), u0Var.b(), u0Var.d(), u0Var.c(), u0Var.e());
        } catch (Throwable unused) {
            return null;
        }
    }
}
