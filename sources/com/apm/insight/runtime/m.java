package com.apm.insight.runtime;

import com.apm.insight.MonitorCrash;
import com.apm.insight.i;

public class m {
    private static MonitorCrash a = null;
    private static int b = -1;
    private static int c;

    public static MonitorCrash a() {
        if (a == null) {
            MonitorCrash initSDK = MonitorCrash.initSDK(i.g(), "239017", 1030838, "1.3.8.nourl-alpha.18", "com.apm.insight");
            a = initSDK;
            initSDK.config().setChannel("release");
        }
        return a;
    }

    public static void a(Throwable th, String str) {
        if (i.g() != null && b()) {
            a().reportCustomErr(str, "INNER", th);
        }
    }

    private static boolean b() {
        if (b == -1) {
            b = 5;
        }
        int i = c;
        if (i >= b) {
            return false;
        }
        c = i + 1;
        return true;
    }
}
