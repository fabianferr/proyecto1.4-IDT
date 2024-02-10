package com.m2catalyst.m2sdk;

import java.util.ArrayList;

/* compiled from: Speedtest */
public final class j6 {
    public r6 a = null;
    public k6 b = new k6();
    public o6 c = new o6();
    public int d = 0;
    public final Object e = new Object();
    public String f = "";
    public a g = null;

    /* compiled from: Speedtest */
    public class a extends l6 {
        public final /* synthetic */ b o;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(r6 r6Var, k6 k6Var, o6 o6Var, b bVar) {
            super(r6Var, k6Var, o6Var);
            this.o = bVar;
        }

        public final void a(String str) {
            synchronized (j6.this.e) {
                j6.this.d = 5;
            }
            this.o.onCriticalFailure(str);
        }
    }

    /* compiled from: Speedtest */
    public static abstract class b {
        public abstract void onCriticalFailure(String str);

        public abstract void onDownloadUpdate(double d, double d2);

        public abstract void onEnd();

        public abstract void onIPInfoUpdate(String str);

        public abstract void onPingJitterUpdate(double d, double d2, double d3);

        public abstract void onTestIDReceived(String str, String str2);

        public abstract void onUploadUpdate(double d, double d2);
    }

    public j6() {
        new ArrayList();
    }

    public static String a(j6 j6Var, o6 o6Var) {
        j6Var.getClass();
        if (o6Var != null) {
            String str = o6Var.b;
            String str2 = o6Var.d;
            if (str != null && !str.isEmpty() && str2 != null && !str2.isEmpty()) {
                if (!str.endsWith("/")) {
                    str = str.concat("/");
                }
                while (str2.startsWith("/")) {
                    str2 = str2.substring(1);
                }
                if (str.startsWith("//")) {
                    str = "https:".concat(str);
                }
                return str + str2;
            }
        }
        return null;
    }

    public final void a(k6 k6Var) {
        synchronized (this.e) {
            if (this.d == 0) {
                k6 b2 = k6Var.clone();
                this.b = b2;
                String str = b2.z;
                if (str != null && !str.isEmpty()) {
                    this.f = str;
                }
            } else {
                throw new IllegalStateException("Cannot change config at this moment");
            }
        }
    }

    public final void a(r6 r6Var) {
        synchronized (this.e) {
            if (this.d != 2) {
                this.a = r6Var;
                this.d = 3;
            } else {
                throw new IllegalStateException("Server selection is in progress");
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:7|8|9|(1:13)|14|15|16|17) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0037 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.m2catalyst.m2sdk.j6.b r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.e
            monitor-enter(r0)
            int r1 = r9.d     // Catch:{ all -> 0x0059 }
            r2 = 3
            if (r1 < r2) goto L_0x0051
            r2 = 4
            if (r1 == r2) goto L_0x0049
            r9.d = r2     // Catch:{ all -> 0x0059 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0037 }
            r1.<init>()     // Catch:{ all -> 0x0037 }
            java.lang.String r2 = r9.f     // Catch:{ all -> 0x0037 }
            if (r2 == 0) goto L_0x0023
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0037 }
            if (r2 != 0) goto L_0x0023
            java.lang.String r2 = "extra"
            java.lang.String r3 = r9.f     // Catch:{ all -> 0x0037 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0037 }
        L_0x0023:
            java.lang.String r2 = "server"
            com.m2catalyst.m2sdk.r6 r3 = r9.a     // Catch:{ all -> 0x0037 }
            r3.getClass()     // Catch:{ all -> 0x0037 }
            java.lang.String r3 = "Test Server"
            r1.put(r2, r3)     // Catch:{ all -> 0x0037 }
            com.m2catalyst.m2sdk.k6 r2 = r9.b     // Catch:{ all -> 0x0037 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0037 }
            r2.z = r1     // Catch:{ all -> 0x0037 }
        L_0x0037:
            com.m2catalyst.m2sdk.j6$a r1 = new com.m2catalyst.m2sdk.j6$a     // Catch:{ all -> 0x0059 }
            com.m2catalyst.m2sdk.r6 r5 = r9.a     // Catch:{ all -> 0x0059 }
            com.m2catalyst.m2sdk.k6 r6 = r9.b     // Catch:{ all -> 0x0059 }
            com.m2catalyst.m2sdk.o6 r7 = r9.c     // Catch:{ all -> 0x0059 }
            r3 = r1
            r4 = r9
            r8 = r10
            r3.<init>(r5, r6, r7, r8)     // Catch:{ all -> 0x0059 }
            r9.g = r1     // Catch:{ all -> 0x0059 }
            monitor-exit(r0)     // Catch:{ all -> 0x0059 }
            return
        L_0x0049:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = "Test already running"
            r10.<init>(r1)     // Catch:{ all -> 0x0059 }
            throw r10     // Catch:{ all -> 0x0059 }
        L_0x0051:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = "Server hasn't been selected yet"
            r10.<init>(r1)     // Catch:{ all -> 0x0059 }
            throw r10     // Catch:{ all -> 0x0059 }
        L_0x0059:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0059 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.j6.a(com.m2catalyst.m2sdk.j6$b):void");
    }

    public final void a() {
        synchronized (this.e) {
            int i = this.d;
            if (i != 2) {
                if (i == 4) {
                    this.g.a();
                }
                this.d = 5;
            } else {
                throw null;
            }
        }
    }
}
