package com.wortise.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/wortise/ads/s5;", "", "Landroid/content/Context;", "context", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "a", "", "b", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: ProcessUtils.kt */
public final class s5 {
    public static final s5 a = new s5();

    private s5() {
    }

    public final ActivityManager.RunningAppProcessInfo a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("activity");
        T t = null;
        if (!(systemService instanceof ActivityManager)) {
            systemService = null;
        }
        ActivityManager activityManager = (ActivityManager) systemService;
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return null;
        }
        Iterator<T> it = runningAppProcesses.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (((ActivityManager.RunningAppProcessInfo) next).pid == Process.myPid()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                t = next;
                break;
            }
        }
        return (ActivityManager.RunningAppProcessInfo) t;
    }

    public final boolean b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ActivityManager.RunningAppProcessInfo a2 = a(context);
        return !(a2 != null && !c.a(a2, context));
    }
}
