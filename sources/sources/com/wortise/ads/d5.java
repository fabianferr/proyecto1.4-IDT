package com.wortise.ads;

import android.content.Context;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/wortise/ads/d5;", "", "Landroid/content/Context;", "context", "Lcom/wortise/ads/g4;", "a", "", "b", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: NetworkInfo.kt */
public final class d5 {
    public static final d5 a = new d5();

    private d5() {
    }

    public final g4 a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Build.VERSION.SDK_INT >= 23 ? new c5(context) : new b5(context);
    }

    public final boolean b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Boolean b = a(context).b();
        if (b == null) {
            return true;
        }
        return b.booleanValue();
    }
}
