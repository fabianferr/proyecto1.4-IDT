package com.bytedance.sdk.openadsdk.utils;

import android.content.res.Configuration;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: SimUtils */
public class u {
    private static String a = null;
    private static String b = null;
    private static String c = null;
    private static volatile boolean d = true;

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(27:3|4|5|6|7|8|(1:(1:11)(1:12))(1:13)|14|(1:16)(1:17)|18|23|24|25|28|29|(3:33|34|35)|37|38|39|40|(1:45)(1:44)|46|(1:48)|49|(1:51)|52|(2:54|56)(1:58)) */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0053, code lost:
        if (r4.length() < 5) goto L_0x0055;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0059 */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0066 A[Catch:{ all -> 0x0034, all -> 0x008c }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0073 A[Catch:{ all -> 0x0034, all -> 0x008c }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x007a A[Catch:{ all -> 0x0034, all -> 0x008c }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0082 A[Catch:{ all -> 0x0034, all -> 0x008c }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x008a A[Catch:{ all -> 0x0034, all -> 0x008c }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void e() {
        /*
            android.content.Context r0 = com.bytedance.sdk.openadsdk.core.o.a()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 1
            d = r0
            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.o.a()     // Catch:{ all -> 0x008c }
            java.lang.String r2 = "phone"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch:{ all -> 0x008c }
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch:{ all -> 0x008c }
            r2 = 0
            int r3 = r1.getSimState()     // Catch:{ all -> 0x0034 }
            if (r3 == 0) goto L_0x0023
            if (r3 == r0) goto L_0x0020
            goto L_0x0025
        L_0x0020:
            d = r2     // Catch:{ all -> 0x0034 }
            goto L_0x0025
        L_0x0023:
            d = r2     // Catch:{ all -> 0x0034 }
        L_0x0025:
            java.lang.String r0 = "MCC"
            boolean r3 = d     // Catch:{ all -> 0x0034 }
            if (r3 == 0) goto L_0x002e
            java.lang.String r3 = "Have SIM card"
            goto L_0x0030
        L_0x002e:
            java.lang.String r3 = "No SIM card"
        L_0x0030:
            com.bytedance.sdk.component.utils.l.e(r0, r3)     // Catch:{ all -> 0x0034 }
            goto L_0x003e
        L_0x0034:
            r0 = move-exception
            java.lang.String r3 = "SimUtils"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x008c }
            com.bytedance.sdk.component.utils.l.e(r3, r0)     // Catch:{ all -> 0x008c }
        L_0x003e:
            r0 = 0
            java.lang.String r3 = r1.getSimOperatorName()     // Catch:{ all -> 0x0044 }
            goto L_0x0045
        L_0x0044:
            r3 = r0
        L_0x0045:
            java.lang.String r4 = r1.getNetworkOperator()     // Catch:{ all -> 0x004a }
            goto L_0x004c
        L_0x004a:
            r4 = r0
        L_0x004c:
            if (r4 == 0) goto L_0x0055
            int r5 = r4.length()     // Catch:{ all -> 0x008c }
            r6 = 5
            if (r5 >= r6) goto L_0x0059
        L_0x0055:
            java.lang.String r4 = r1.getSimOperator()     // Catch:{ all -> 0x0059 }
        L_0x0059:
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x008c }
            if (r1 != 0) goto L_0x0073
            int r1 = r4.length()     // Catch:{ all -> 0x008c }
            r5 = 4
            if (r1 <= r5) goto L_0x0073
            r0 = 3
            java.lang.String r1 = r4.substring(r2, r0)     // Catch:{ all -> 0x008c }
            java.lang.String r0 = r4.substring(r0)     // Catch:{ all -> 0x008c }
            r7 = r1
            r1 = r0
            r0 = r7
            goto L_0x0074
        L_0x0073:
            r1 = r0
        L_0x0074:
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x008c }
            if (r2 != 0) goto L_0x007c
            a = r3     // Catch:{ all -> 0x008c }
        L_0x007c:
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x008c }
            if (r2 != 0) goto L_0x0084
            b = r0     // Catch:{ all -> 0x008c }
        L_0x0084:
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x008c }
            if (r0 != 0) goto L_0x008c
            c = r1     // Catch:{ all -> 0x008c }
        L_0x008c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.u.e():void");
    }

    public static String a() {
        a.a();
        return a;
    }

    public static String b() {
        try {
            a.a();
            if (!d) {
                l.e("MCC", "getMCC".concat(d ? "Have SIM card" : "No SIM card, MCC returns null"));
                return null;
            }
            Configuration configuration = o.a().getResources().getConfiguration();
            String valueOf = configuration.mcc != 0 ? String.valueOf(configuration.mcc) : b;
            l.e("MCC", "config=" + configuration.mcc + ",sMCC=" + b);
            return valueOf;
        } catch (Throwable th) {
            l.e("SimUtils", th.getMessage());
            return null;
        }
    }

    public static String c() {
        a.a();
        return c;
    }

    /* compiled from: SimUtils */
    public static class a extends h {
        public static AtomicBoolean a = new AtomicBoolean(false);
        private static final AtomicLong b = new AtomicLong(0);

        public a(String str, int i) {
            super(str, i);
        }

        public static void a() {
            if (!a.get()) {
                long currentTimeMillis = System.currentTimeMillis();
                AtomicLong atomicLong = b;
                if (currentTimeMillis - atomicLong.get() >= 600000) {
                    atomicLong.set(currentTimeMillis);
                    aa.b(new a("UpdateSimStatusTask", 5));
                }
            }
        }

        public void run() {
            a.set(true);
            u.e();
            a.set(false);
        }
    }
}
