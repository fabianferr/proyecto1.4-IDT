package com.applovin.impl.sdk;

import android.content.Context;
import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.d.e;

public class j {
    private static final a a = new a("Age Restricted User", d.l);
    private static final a b = new a("Has User Consent", d.k);
    private static final a c = new a("\"Do Not Sell\"", d.m);

    public static class a {
        /* access modifiers changed from: private */
        public final String a;
        private final d<Boolean> b;

        a(String str, d<Boolean> dVar) {
            this.a = str;
            this.b = dVar;
        }

        public Boolean a(Context context) {
            if (context != null) {
                return (Boolean) e.b(this.b, null, context);
            }
            if (u.a()) {
                u.i("AppLovinSdk", "Failed to get value for key: " + this.b);
            }
            return null;
        }

        public String a() {
            return this.a;
        }

        public String b(Context context) {
            Boolean a2 = a(context);
            return a2 != null ? a2.toString() : "No value set";
        }
    }

    public static a a() {
        return a;
    }

    public static String a(Context context) {
        return a(a, context) + a(b, context) + a(c, context);
    }

    private static String a(a aVar, Context context) {
        return "\n" + aVar.a + " - " + aVar.b(context);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.applovin.impl.sdk.d.d, java.lang.Object, com.applovin.impl.sdk.d.d<java.lang.Boolean>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.applovin.impl.sdk.d.d<java.lang.Boolean> r2, java.lang.Boolean r3, android.content.Context r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x001d
            boolean r3 = com.applovin.impl.sdk.u.a()
            if (r3 == 0) goto L_0x001c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Failed to update compliance value for key: "
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "AppLovinSdk"
            com.applovin.impl.sdk.u.i(r3, r2)
        L_0x001c:
            return r0
        L_0x001d:
            r1 = 0
            java.lang.Object r1 = com.applovin.impl.sdk.d.e.b(r2, r1, (android.content.Context) r4)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            com.applovin.impl.sdk.d.e.a(r2, r3, (android.content.Context) r4)
            r2 = 1
            if (r1 == 0) goto L_0x002e
            if (r1 == r3) goto L_0x002d
            r0 = 1
        L_0x002d:
            return r0
        L_0x002e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.j.a(com.applovin.impl.sdk.d.d, java.lang.Boolean, android.content.Context):boolean");
    }

    public static boolean a(boolean z, Context context) {
        return a(d.l, Boolean.valueOf(z), context);
    }

    public static a b() {
        return b;
    }

    public static boolean b(boolean z, Context context) {
        return a(d.k, Boolean.valueOf(z), context);
    }

    public static a c() {
        return c;
    }

    public static boolean c(boolean z, Context context) {
        return a(d.m, Boolean.valueOf(z), context);
    }
}
