package com.apm.insight.b;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.apm.insight.c;
import com.apm.insight.f;
import com.apm.insight.l.a;
import com.apm.insight.l.r;
import com.apm.insight.l.v;
import org.json.JSONObject;

public class d {
    /* access modifiers changed from: private */
    public static String a = null;
    private static long b = -1;
    private static boolean c = false;
    private static FileObserver d;
    private static ActivityManager.ProcessErrorStateInfo e;

    static String a(Context context, int i) {
        if (r.a(256)) {
            c = false;
            return "TEST_ANR_INFO";
        } else if (SystemClock.uptimeMillis() - b < 5000) {
            return null;
        } else {
            try {
                ActivityManager.ProcessErrorStateInfo a2 = a.a(context, i);
                if (a2 != null && Process.myPid() == a2.pid) {
                    ActivityManager.ProcessErrorStateInfo processErrorStateInfo = e;
                    if (processErrorStateInfo != null && a.a(processErrorStateInfo, a2)) {
                        return null;
                    }
                    e = a2;
                    a = null;
                    b = SystemClock.uptimeMillis();
                    c = false;
                    return a.a(a2);
                }
            } catch (Throwable unused) {
            }
            String str = a;
            if (str == null) {
                return null;
            }
            c = true;
            a = null;
            b = SystemClock.uptimeMillis();
            return str;
        }
    }

    public static JSONObject a(boolean z) {
        try {
            StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("thread_number", 1);
            jSONObject.put("mainStackFromTrace", v.a(stackTrace));
            return jSONObject;
        } catch (Throwable th) {
            c.a().a("NPTH_CATCH", th);
            return null;
        }
    }

    public static void a(final String str, final f fVar) {
        FileObserver fileObserver = d;
        if (fileObserver != null) {
            fileObserver.stopWatching();
        }
        AnonymousClass1 r0 = new FileObserver(136, str) {
            public void onEvent(int i, String str) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        String unused = d.a = fVar.a(str, str);
                    } catch (Throwable th) {
                        c.a().a("NPTH_CATCH", th);
                    }
                }
            }
        };
        d = r0;
        r0.startWatching();
    }

    public static boolean a() {
        return c;
    }

    public static void b() {
        e = null;
    }
}
