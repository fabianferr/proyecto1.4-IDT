package com.wortise.ads;

import android.content.Context;
import com.wortise.ads.device.Dimensions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/wortise/ads/e6;", "", "Landroid/content/Context;", "context", "Lcom/wortise/ads/d6;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: ScreenFactory.kt */
public final class e6 {
    public static final e6 a = new e6();

    private e6() {
    }

    public final d6 a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Dimensions a2 = o2.a.a(context);
        if (a2 == null) {
            return null;
        }
        return new d6(a2.a(), a2.c());
    }
}
