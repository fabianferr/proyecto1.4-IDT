package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.sdk.component.g.f;
import com.bytedance.sdk.component.g.h;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TTNetworkUtils */
public class v {
    private static final Object a = new Object();
    /* access modifiers changed from: private */
    public static final Map<a, Object> b = new ConcurrentHashMap();
    private static AtomicBoolean c = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public static volatile int d = -1;
    private static volatile long e = 0;
    private static volatile int f = 60000;
    private static p g = null;
    /* access modifiers changed from: private */
    public static final AtomicBoolean h = new AtomicBoolean(false);

    /* compiled from: TTNetworkUtils */
    public interface a {
        void a(Context context, Intent intent, boolean z, int i);
    }

    public static int a(Context context, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (e + j <= elapsedRealtime) {
            return b(context);
        }
        if (d == -1) {
            return b(context);
        }
        if (elapsedRealtime - e >= ((long) f)) {
            b(context, (Intent) null, false, false);
        }
        return d;
    }

    /* access modifiers changed from: private */
    public static void b(Context context, Intent intent, boolean z, boolean z2) {
        if (!z && z2) {
            d = 0;
        } else if (h.compareAndSet(false, true)) {
            final boolean z3 = z2;
            final Context context2 = context;
            final boolean z4 = z;
            final Intent intent2 = intent;
            f.b((h) new h("getNetworkType") {
                public void run() {
                    int unused = v.d = z3 ? 0 : v.b(context2);
                    v.h.set(false);
                    if (z4) {
                        v.b(context2, intent2, v.d, z3);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void b(Context context, Intent intent, int i, boolean z) {
        Map<a, Object> map = b;
        if (map != null && map.size() > 0) {
            for (a next : map.keySet()) {
                if (next != null) {
                    next.a(context, intent, !z, i);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static int b(Context context) {
        d = c(context);
        e = SystemClock.elapsedRealtime();
        return d;
    }

    private static int c(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 0;
            }
            if (!activeNetworkInfo.isAvailable()) {
                return 0;
            }
            int type = activeNetworkInfo.getType();
            if (type == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return 3;
                    case 13:
                    case 18:
                    case 19:
                        p pVar = g;
                        if (pVar == null || !pVar.a(context, telephonyManager)) {
                            return 5;
                        }
                        return 6;
                    case 20:
                        return 6;
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        if (TextUtils.isEmpty(subtypeName) || (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000"))) {
                            return 1;
                        }
                        return 3;
                }
            } else if (type != 1) {
                return 1;
            } else {
                return 4;
            }
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static void a(a aVar, Context context) {
        if (aVar != null) {
            if (!c.get()) {
                try {
                    context.registerReceiver(new b(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    c.set(true);
                } catch (Throwable unused) {
                }
            }
            b.put(aVar, a);
        }
    }

    public static void a(a aVar) {
        if (aVar != null) {
            b.remove(aVar);
        }
    }

    /* compiled from: TTNetworkUtils */
    private static class b extends BroadcastReceiver {
        private b() {
        }

        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            if (v.b != null && v.b.size() > 0) {
                z = true;
            }
            v.b(context, intent, z, booleanExtra);
        }
    }
}
