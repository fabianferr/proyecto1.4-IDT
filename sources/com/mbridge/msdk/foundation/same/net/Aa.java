package com.mbridge.msdk.foundation.same.net;

import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.u;

public class Aa {
    private static final String C_END = "_mv_end";
    private static final String C_START = "mv_channel_";
    private static String a = "";

    public static String b() {
        return null;
    }

    private static void b(String str) {
        String str2;
        Integer c;
        if (!TextUtils.isEmpty(str)) {
            try {
                str2 = u.b(str);
            } catch (Throwable th) {
                th.printStackTrace();
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2) && str2.startsWith(C_START) && str2.endsWith(C_END) && (c = c(str2)) != null) {
                a = String.valueOf(c);
            } else if (!MBridgeConstans.DEBUG) {
                a = "";
            } else {
                g();
                throw new RuntimeException("please don't update this value");
            }
        }
    }

    private static Integer c(String str) {
        Integer num;
        Throwable th;
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(C_START);
        int indexOf2 = str.indexOf(C_END);
        if (indexOf == -1 || indexOf2 == -1 || indexOf2 <= indexOf) {
            return null;
        }
        try {
            num = Integer.valueOf(str.substring(indexOf + 11, indexOf2));
            try {
                if (num.intValue() > 0) {
                    return num;
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                return num;
            }
        } catch (Throwable th3) {
            th = th3;
            num = null;
            th.printStackTrace();
            return num;
        }
    }

    public static String a() {
        return a;
    }

    private static void g() {
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                try {
                    Process.killProcess(Process.myPid());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }, 500);
    }
}
