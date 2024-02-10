package com.wortise.ads;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/wortise/ads/a5;", "", "Landroid/content/Context;", "context", "Lcom/wortise/ads/z4;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: NetworkFactory.kt */
public final class a5 {
    public static final a5 a = new a5();

    private a5() {
    }

    public final z4 a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            g4 a2 = d5.a.a(context);
            return new z4(a2.a(), a2.c(), d7.a.a(context));
        } catch (Throwable unused) {
            return null;
        }
    }
}
