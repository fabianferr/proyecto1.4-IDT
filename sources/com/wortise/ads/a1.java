package com.wortise.ads;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/wortise/ads/a1;", "", "Landroid/content/Context;", "context", "Lcom/wortise/ads/z0;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: CapabilitiesFactory.kt */
public final class a1 {
    public static final a1 a = new a1();

    private a1() {
    }

    public final z0 a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        m2 m2Var = new m2(context);
        return new z0(m2Var.a(), m2Var.b(), m2Var.c());
    }
}
