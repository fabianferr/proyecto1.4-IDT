package com.wortise.ads;

import android.content.ComponentName;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u000b"}, d2 = {"Lcom/wortise/ads/n5;", "", "Landroid/content/Context;", "context", "", "className", "", "enabled", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: PackageManagerHelper.kt */
public final class n5 {
    public static final n5 a = new n5();

    private n5() {
    }

    public final boolean a(Context context, String str, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "className");
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, str), z ? 1 : 2, 1);
            WortiseLog.d$default("Component " + str + " enabled setting changed to " + z, (Throwable) null, 2, (Object) null);
            return true;
        } catch (Throwable th) {
            String message = th.getMessage();
            if (message == null) {
                message = "Caught an exception";
            }
            WortiseLog.e(message, th);
            return false;
        }
    }
}
