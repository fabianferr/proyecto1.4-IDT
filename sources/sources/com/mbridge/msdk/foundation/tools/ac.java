package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.mbridge.msdk.c.e;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: SameOptimizedController */
public final class ac {
    public volatile JSONObject a;
    private volatile ConcurrentHashMap<String, Boolean> b;
    private volatile ConcurrentHashMap<String, Integer> c;
    private volatile e d;
    private final Object e;
    private final Object f;
    private final Object g;
    private String h;

    /* compiled from: SameOptimizedController */
    private static final class a {
        /* access modifiers changed from: private */
        public static final ac a = new ac();
    }

    private ac() {
        this.e = new Object();
        this.f = new Object();
        this.g = new Object();
    }

    public static ac a() {
        return a.a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r4 = java.lang.Integer.valueOf(r6);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0039 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.lang.String r4, java.lang.String r5, int r6) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x004a }
            if (r0 != 0) goto L_0x0045
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x004a }
            if (r0 == 0) goto L_0x000d
            goto L_0x0045
        L_0x000d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004a }
            r0.<init>()     // Catch:{ Exception -> 0x004a }
            r0.append(r4)     // Catch:{ Exception -> 0x004a }
            java.lang.String r1 = "_"
            r0.append(r1)     // Catch:{ Exception -> 0x004a }
            r0.append(r5)     // Catch:{ Exception -> 0x004a }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x004a }
            java.util.concurrent.ConcurrentHashMap r1 = r3.d()     // Catch:{ Exception -> 0x004a }
            java.lang.Integer r2 = b((java.lang.String) r0, (java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer>) r1)     // Catch:{ Exception -> 0x004a }
            if (r2 == 0) goto L_0x0030
            int r4 = r2.intValue()     // Catch:{ Exception -> 0x004a }
            return r4
        L_0x0030:
            int r4 = r3.b(r4, r5, r6)     // Catch:{ Exception -> 0x0039 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x004a }
        L_0x003d:
            r1.put(r0, r4)     // Catch:{ Exception -> 0x004a }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x004a }
            return r4
        L_0x0045:
            int r4 = r3.a((java.lang.String) r5, (int) r6)     // Catch:{ Exception -> 0x004a }
            return r4
        L_0x004a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ac.a(java.lang.String, java.lang.String, int):int");
    }

    private int b(String str, String str2, int i) {
        if (b()) {
            return i;
        }
        try {
            String optString = this.a.optString(str, "");
            if (TextUtils.isEmpty(optString)) {
                return i;
            }
            String b2 = u.b(optString);
            if (TextUtils.isEmpty(b2)) {
                return i;
            }
            return new JSONObject(b2).optInt(str2, i);
        } catch (Exception unused) {
            return i;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r1 = java.lang.Integer.valueOf(r4);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.lang.String r3, int r4) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x002b }
            if (r0 == 0) goto L_0x0007
            return r4
        L_0x0007:
            java.util.concurrent.ConcurrentHashMap r0 = r2.d()     // Catch:{ Exception -> 0x002b }
            java.lang.Integer r1 = b((java.lang.String) r3, (java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer>) r0)     // Catch:{ Exception -> 0x002b }
            if (r1 == 0) goto L_0x0016
            int r3 = r1.intValue()     // Catch:{ Exception -> 0x002b }
            return r3
        L_0x0016:
            int r1 = r2.b((java.lang.String) r3, (int) r4)     // Catch:{ Exception -> 0x001f }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x001f }
            goto L_0x0023
        L_0x001f:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x002b }
        L_0x0023:
            r0.put(r3, r1)     // Catch:{ Exception -> 0x002b }
            int r3 = r1.intValue()     // Catch:{ Exception -> 0x002b }
            return r3
        L_0x002b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ac.a(java.lang.String, int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r1 = java.lang.Boolean.valueOf(r4);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r3, boolean r4) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x002b }
            if (r0 == 0) goto L_0x0007
            return r4
        L_0x0007:
            java.util.concurrent.ConcurrentHashMap r0 = r2.c()     // Catch:{ Exception -> 0x002b }
            java.lang.Boolean r1 = a((java.lang.String) r3, (java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean>) r0)     // Catch:{ Exception -> 0x002b }
            if (r1 == 0) goto L_0x0016
            boolean r3 = r1.booleanValue()     // Catch:{ Exception -> 0x002b }
            return r3
        L_0x0016:
            boolean r1 = r2.b((java.lang.String) r3, (boolean) r4)     // Catch:{ Exception -> 0x001f }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x001f }
            goto L_0x0023
        L_0x001f:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x002b }
        L_0x0023:
            r0.put(r3, r1)     // Catch:{ Exception -> 0x002b }
            boolean r3 = r1.booleanValue()     // Catch:{ Exception -> 0x002b }
            return r3
        L_0x002b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ac.a(java.lang.String, boolean):boolean");
    }

    private static Boolean a(String str, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        try {
            return concurrentHashMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Integer b(String str, ConcurrentHashMap<String, Integer> concurrentHashMap) {
        try {
            return concurrentHashMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean b(String str, boolean z) {
        if (b()) {
            return z;
        }
        try {
            return this.a.optInt(str, z ? 1 : 0) != 0;
        } catch (Exception unused) {
            return z;
        }
    }

    private int b(String str, int i) {
        if (b()) {
            return i;
        }
        try {
            return this.a.optInt(str, i);
        } catch (Exception unused) {
            return i;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        if ((r5.d.aG() == 1) != false) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.g
            monitor-enter(r0)
            com.mbridge.msdk.c.e r1 = r5.d     // Catch:{ all -> 0x0051 }
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0016
            com.mbridge.msdk.c.e r1 = r5.d     // Catch:{ all -> 0x0051 }
            int r1 = r1.aG()     // Catch:{ all -> 0x0051 }
            if (r1 != r3) goto L_0x0013
            r1 = 1
            goto L_0x0014
        L_0x0013:
            r1 = 0
        L_0x0014:
            if (r1 == 0) goto L_0x003a
        L_0x0016:
            java.lang.String r1 = r5.h     // Catch:{ Exception -> 0x0037 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0037 }
            if (r1 == 0) goto L_0x002a
            com.mbridge.msdk.foundation.a.a.a r1 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ Exception -> 0x0037 }
            java.lang.String r4 = "sdk_app_id"
            java.lang.String r1 = r1.b(r4)     // Catch:{ Exception -> 0x0037 }
            r5.h = r1     // Catch:{ Exception -> 0x0037 }
        L_0x002a:
            com.mbridge.msdk.c.f r1 = com.mbridge.msdk.c.f.a()     // Catch:{ Exception -> 0x0037 }
            java.lang.String r4 = r5.h     // Catch:{ Exception -> 0x0037 }
            com.mbridge.msdk.c.e r1 = r1.g(r4)     // Catch:{ Exception -> 0x0037 }
            r5.d = r1     // Catch:{ Exception -> 0x0037 }
            goto L_0x003a
        L_0x0037:
            r1 = 0
            r5.d = r1     // Catch:{ all -> 0x0051 }
        L_0x003a:
            com.mbridge.msdk.c.e r1 = r5.d     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x0046
            com.mbridge.msdk.c.e r1 = r5.d     // Catch:{ all -> 0x0051 }
            org.json.JSONObject r1 = r1.j()     // Catch:{ all -> 0x0051 }
            r5.a = r1     // Catch:{ all -> 0x0051 }
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            com.mbridge.msdk.c.e r0 = r5.d
            if (r0 == 0) goto L_0x004f
            org.json.JSONObject r0 = r5.a
            if (r0 != 0) goto L_0x0050
        L_0x004f:
            r2 = 1
        L_0x0050:
            return r2
        L_0x0051:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ac.b():boolean");
    }

    private ConcurrentHashMap<String, Boolean> c() {
        synchronized (this.e) {
            if (this.b == null) {
                this.b = new ConcurrentHashMap<>();
            }
        }
        return this.b;
    }

    private ConcurrentHashMap<String, Integer> d() {
        synchronized (this.f) {
            if (this.c == null) {
                this.c = new ConcurrentHashMap<>();
            }
        }
        return this.c;
    }
}
