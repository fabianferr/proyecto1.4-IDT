package io.monedata;

import android.content.Context;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lio/monedata/g1;", "", "Landroid/content/Context;", "context", "Lio/monedata/y0;", "a", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class g1 {
    public static final g1 a = new g1();

    private g1() {
    }

    public final y0 a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Build.VERSION.SDK_INT >= 23 ? new f1(context) : new e1(context);
    }
}
