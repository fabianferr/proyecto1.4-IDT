package com.pgl.ssdk;

import android.content.Context;
import android.text.TextUtils;
import com.pgl.ssdk.ces.a;

public class y {
    static int a = 504;
    static String b = null;
    static String c = "";
    private static Context d;

    /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|(3:5|6|(5:8|13|14|15|17))|9|10|11|12|13|14|15|17) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0036 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a() {
        /*
            java.lang.String r0 = ""
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x004d }
            r1.<init>()     // Catch:{ all -> 0x004d }
            java.lang.String r2 = "os"
            java.lang.String r3 = "Android"
            r1.put(r2, r3)     // Catch:{ all -> 0x004d }
            java.lang.String r2 = "version"
            java.lang.String r3 = "1.0.0.1-rc.6"
            r1.put(r2, r3)     // Catch:{ all -> 0x004d }
            java.lang.String r2 = c     // Catch:{ all -> 0x004d }
            java.lang.String r3 = "token_id"
            if (r2 == 0) goto L_0x0029
            int r2 = r2.length()     // Catch:{ all -> 0x004d }
            if (r2 <= 0) goto L_0x0029
            java.lang.String r2 = c     // Catch:{ all -> 0x004d }
            r1.put(r3, r2)     // Catch:{ all -> 0x004d }
            goto L_0x0039
        L_0x0029:
            android.content.Context r2 = d     // Catch:{ all -> 0x0036 }
            r4 = 0
            r5 = 303(0x12f, float:4.25E-43)
            java.lang.Object r2 = com.pgl.ssdk.ces.a.meta(r5, r2, r4)     // Catch:{ all -> 0x0036 }
            r1.put(r3, r2)     // Catch:{ all -> 0x0036 }
            goto L_0x0039
        L_0x0036:
            r1.put(r3, r0)     // Catch:{ all -> 0x004d }
        L_0x0039:
            java.lang.String r2 = "code"
            int r3 = a     // Catch:{ all -> 0x004d }
            r1.put(r2, r3)     // Catch:{ all -> 0x004d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x004d }
            byte[] r1 = r1.getBytes()     // Catch:{ all -> 0x004d }
            r2 = 2
            java.lang.String r0 = android.util.Base64.encodeToString(r1, r2)     // Catch:{ all -> 0x004d }
        L_0x004d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.y.a():java.lang.String");
    }

    public static void a(Context context, String str, D d2) {
        if (d == null) {
            d = context;
        }
        int i = a;
        if (i != 102 && i != 202 && i != 200) {
            System.currentTimeMillis();
            b = str;
            a = 102;
            r b2 = u.a().b();
            if (b2 != null) {
                b2.post(new B(context, d2));
            }
        }
    }

    public static String b() {
        if (TextUtils.isEmpty(c)) {
            c = (String) a.meta(303, d, (Object) null);
        }
        return c;
    }

    public static void c() {
        if (d != null) {
            a = 102;
            u.a().b().post(new B(d, (D) null));
        }
    }
}
