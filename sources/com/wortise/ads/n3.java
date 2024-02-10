package com.wortise.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/wortise/ads/n3;", "", "Landroid/content/Context;", "context", "", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GoogleMediation.kt */
public final class n3 {
    public static final n3 a = new n3();
    private static final List<a0> b = CollectionsKt.listOf(a0.a);

    private n3() {
    }

    public final int a(Context context) {
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "context");
        List<a0> list = b;
        ArrayList arrayList = new ArrayList();
        for (a0 a2 : list) {
            try {
                a2.a(context);
                unit = Unit.INSTANCE;
            } catch (Throwable unused) {
                unit = null;
            }
            if (unit != null) {
                arrayList.add(unit);
            }
        }
        return arrayList.size();
    }
}
