package com.m2catalyst.m2sdk;

/* compiled from: GetIP */
public abstract class t1 extends Thread {
    public final w0 a;
    public final String b;
    public final boolean c;
    public final String d;

    public t1(w0 w0Var, String str, boolean z, String str2) {
        this.a = w0Var;
        this.b = str;
        this.c = z;
        if (str2 == null || str2.equals("km") || str2.equals("mi")) {
            this.d = str2;
            start();
            return;
        }
        throw new IllegalArgumentException("Distance must be null, mi or km");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x007c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00b3 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x0100 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r9 = this;
            java.lang.String r0 = "content-length"
            java.lang.String r1 = "ms)"
            java.lang.String r2 = "?"
            java.lang.String r3 = r9.b     // Catch:{ all -> 0x0132 }
            boolean r4 = r9.c     // Catch:{ all -> 0x0132 }
            if (r4 == 0) goto L_0x0055
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0132 }
            r4.<init>()     // Catch:{ all -> 0x0132 }
            r4.append(r3)     // Catch:{ all -> 0x0132 }
            boolean r3 = r3.contains(r2)     // Catch:{ all -> 0x0132 }
            java.lang.String r5 = "&"
            if (r3 == 0) goto L_0x001e
            r3 = r5
            goto L_0x001f
        L_0x001e:
            r3 = r2
        L_0x001f:
            r4.append(r3)     // Catch:{ all -> 0x0132 }
            java.lang.String r3 = "isp=true"
            r4.append(r3)     // Catch:{ all -> 0x0132 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0132 }
            java.lang.String r4 = r9.d     // Catch:{ all -> 0x0132 }
            java.lang.String r6 = "no"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0132 }
            if (r4 != 0) goto L_0x0055
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0132 }
            r4.<init>()     // Catch:{ all -> 0x0132 }
            r4.append(r3)     // Catch:{ all -> 0x0132 }
            boolean r3 = r3.contains(r2)     // Catch:{ all -> 0x0132 }
            if (r3 == 0) goto L_0x0044
            r2 = r5
        L_0x0044:
            r4.append(r2)     // Catch:{ all -> 0x0132 }
            java.lang.String r2 = "distance="
            r4.append(r2)     // Catch:{ all -> 0x0132 }
            java.lang.String r2 = r9.d     // Catch:{ all -> 0x0132 }
            r4.append(r2)     // Catch:{ all -> 0x0132 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0132 }
        L_0x0055:
            com.m2catalyst.m2sdk.w0 r2 = r9.a     // Catch:{ all -> 0x0132 }
            r2.a(r3)     // Catch:{ all -> 0x0132 }
            com.m2catalyst.m2sdk.w0 r2 = r9.a     // Catch:{ all -> 0x0132 }
            java.util.HashMap r2 = r2.b()     // Catch:{ all -> 0x0132 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x0132 }
            com.m2catalyst.m2sdk.w0 r4 = r9.a     // Catch:{ all -> 0x0132 }
            java.io.InputStreamReader r5 = r4.f     // Catch:{ all -> 0x0132 }
            if (r5 != 0) goto L_0x007e
            r5 = 0
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ all -> 0x007c }
            java.net.Socket r7 = r4.a     // Catch:{ all -> 0x0072 }
            java.io.InputStream r7 = r7.getInputStream()     // Catch:{ all -> 0x0072 }
            goto L_0x0073
        L_0x0072:
            r7 = r5
        L_0x0073:
            java.lang.String r8 = "utf-8"
            r6.<init>(r7, r8)     // Catch:{ all -> 0x007c }
            r4.f = r6     // Catch:{ all -> 0x007c }
            goto L_0x007e
        L_0x007c:
            r4.f = r5     // Catch:{ all -> 0x0132 }
        L_0x007e:
            java.io.InputStreamReader r4 = r4.f     // Catch:{ all -> 0x0132 }
            r3.<init>(r4)     // Catch:{ all -> 0x0132 }
            java.lang.Object r4 = r2.get(r0)     // Catch:{ all -> 0x0132 }
            java.lang.String r5 = " (took "
            java.lang.String r6 = "GetIP: "
            java.lang.String r7 = "processedString"
            if (r4 == 0) goto L_0x00e0
            java.lang.Object r0 = r2.get(r0)     // Catch:{ all -> 0x0132 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0132 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x0132 }
            char[] r0 = new char[r0]     // Catch:{ all -> 0x0132 }
            r3.read(r0)     // Catch:{ all -> 0x0132 }
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x0132 }
            r2.<init>(r0)     // Catch:{ all -> 0x0132 }
            r0 = r9
            com.m2catalyst.m2sdk.l6$a r0 = (com.m2catalyst.m2sdk.l6.a) r0     // Catch:{ all -> 0x0132 }
            com.m2catalyst.m2sdk.l6 r3 = com.m2catalyst.m2sdk.l6.this     // Catch:{ all -> 0x0132 }
            r3.i = r2     // Catch:{ all -> 0x0132 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x00b3 }
            r3.<init>(r2)     // Catch:{ all -> 0x00b3 }
            java.lang.String r2 = r3.getString(r7)     // Catch:{ all -> 0x00b3 }
        L_0x00b3:
            com.m2catalyst.m2sdk.l6 r3 = com.m2catalyst.m2sdk.l6.this     // Catch:{ all -> 0x0132 }
            com.m2catalyst.m2sdk.i2 r3 = r3.j     // Catch:{ all -> 0x0132 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0132 }
            r4.<init>(r6)     // Catch:{ all -> 0x0132 }
            r4.append(r2)     // Catch:{ all -> 0x0132 }
            r4.append(r5)     // Catch:{ all -> 0x0132 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0132 }
            long r7 = r0.e     // Catch:{ all -> 0x0132 }
            long r5 = r5 - r7
            r4.append(r5)     // Catch:{ all -> 0x0132 }
            r4.append(r1)     // Catch:{ all -> 0x0132 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0132 }
            r3.a(r4)     // Catch:{ all -> 0x0132 }
            com.m2catalyst.m2sdk.l6 r0 = com.m2catalyst.m2sdk.l6.this     // Catch:{ all -> 0x0132 }
            com.m2catalyst.m2sdk.j6$a r0 = (com.m2catalyst.m2sdk.j6.a) r0     // Catch:{ all -> 0x0132 }
            com.m2catalyst.m2sdk.j6$b r0 = r0.o     // Catch:{ all -> 0x0132 }
            r0.onIPInfoUpdate(r2)     // Catch:{ all -> 0x0132 }
            goto L_0x012c
        L_0x00e0:
            com.m2catalyst.m2sdk.w0 r0 = r9.a     // Catch:{ all -> 0x0132 }
            r0.c()     // Catch:{ all -> 0x0132 }
            com.m2catalyst.m2sdk.w0 r0 = r9.a     // Catch:{ all -> 0x0132 }
            java.lang.String r0 = r0.c()     // Catch:{ all -> 0x0132 }
            com.m2catalyst.m2sdk.w0 r2 = r9.a     // Catch:{ all -> 0x0132 }
            r2.c()     // Catch:{ all -> 0x0132 }
            r2 = r9
            com.m2catalyst.m2sdk.l6$a r2 = (com.m2catalyst.m2sdk.l6.a) r2     // Catch:{ all -> 0x0132 }
            com.m2catalyst.m2sdk.l6 r3 = com.m2catalyst.m2sdk.l6.this     // Catch:{ all -> 0x0132 }
            r3.i = r0     // Catch:{ all -> 0x0132 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x0100 }
            r3.<init>(r0)     // Catch:{ all -> 0x0100 }
            java.lang.String r0 = r3.getString(r7)     // Catch:{ all -> 0x0100 }
        L_0x0100:
            com.m2catalyst.m2sdk.l6 r3 = com.m2catalyst.m2sdk.l6.this     // Catch:{ all -> 0x0132 }
            com.m2catalyst.m2sdk.i2 r3 = r3.j     // Catch:{ all -> 0x0132 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0132 }
            r4.<init>(r6)     // Catch:{ all -> 0x0132 }
            r4.append(r0)     // Catch:{ all -> 0x0132 }
            r4.append(r5)     // Catch:{ all -> 0x0132 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0132 }
            long r7 = r2.e     // Catch:{ all -> 0x0132 }
            long r5 = r5 - r7
            r4.append(r5)     // Catch:{ all -> 0x0132 }
            r4.append(r1)     // Catch:{ all -> 0x0132 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0132 }
            r3.a(r4)     // Catch:{ all -> 0x0132 }
            com.m2catalyst.m2sdk.l6 r2 = com.m2catalyst.m2sdk.l6.this     // Catch:{ all -> 0x0132 }
            com.m2catalyst.m2sdk.j6$a r2 = (com.m2catalyst.m2sdk.j6.a) r2     // Catch:{ all -> 0x0132 }
            com.m2catalyst.m2sdk.j6$b r2 = r2.o     // Catch:{ all -> 0x0132 }
            r2.onIPInfoUpdate(r0)     // Catch:{ all -> 0x0132 }
        L_0x012c:
            com.m2catalyst.m2sdk.w0 r0 = r9.a     // Catch:{ all -> 0x0132 }
            r0.a()     // Catch:{ all -> 0x0132 }
            goto L_0x0168
        L_0x0132:
            r0 = move-exception
            com.m2catalyst.m2sdk.w0 r2 = r9.a     // Catch:{ all -> 0x0138 }
            r2.a()     // Catch:{ all -> 0x0138 }
        L_0x0138:
            java.lang.String r0 = r0.toString()
            r2 = r9
            com.m2catalyst.m2sdk.l6$a r2 = (com.m2catalyst.m2sdk.l6.a) r2
            com.m2catalyst.m2sdk.l6 r3 = com.m2catalyst.m2sdk.l6.this
            com.m2catalyst.m2sdk.i2 r3 = r3.j
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "GetIP: FAILED (took "
            r4.<init>(r5)
            long r5 = java.lang.System.currentTimeMillis()
            long r7 = r2.e
            long r5 = r5 - r7
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r3.a(r1)
            com.m2catalyst.m2sdk.l6 r1 = com.m2catalyst.m2sdk.l6.this
            r1.a()
            com.m2catalyst.m2sdk.l6 r1 = com.m2catalyst.m2sdk.l6.this
            r1.a(r0)
        L_0x0168:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.t1.run():void");
    }
}
