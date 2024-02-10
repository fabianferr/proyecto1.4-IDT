package com.umlaut.crowd.internal;

import android.app.ActivityManager;
import android.content.Context;
import java.util.List;

class z2 implements r3 {
    private final ActivityManager a;

    public z2(Context context) {
        this.a = (ActivityManager) context.getSystemService("activity");
    }

    private boolean e() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.a.getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() >= 2) {
            return true;
        }
        return false;
    }

    private v8 f() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = this.a;
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.importance == 100 && !m.a(next.processName)) {
                v8 v8Var = new v8();
                v8Var.a = next.processName;
                v8Var.b = next.uid;
                return v8Var;
            }
        }
        return null;
    }

    public boolean a() {
        return e();
    }

    public v8 b() {
        return f();
    }

    public c3 c() {
        return c3.Legacy;
    }

    public void d() {
    }
}
