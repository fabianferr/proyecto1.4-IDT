package com.m2catalyst.m2sdk;

/* compiled from: Telemetry */
public abstract class n6 extends Thread {
    public final w0 a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;

    public n6(w0 w0Var, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        if (!str2.equals("disabled")) {
            this.a = w0Var;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = str6;
            this.h = str7;
            this.i = str8;
            this.j = str9;
            start();
            return;
        }
        a((String) null);
        throw null;
    }

    public abstract void a(String str);

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x009b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r7 = this;
            java.lang.String r1 = r7.b     // Catch:{ all -> 0x00d6 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d6 }
            r6.<init>()     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = "ispinfo="
            r6.append(r0)     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = r7.d     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = com.m2catalyst.m2sdk.b7.a(r0)     // Catch:{ all -> 0x00d6 }
            r6.append(r0)     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = "&dl="
            r6.append(r0)     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = r7.f     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = com.m2catalyst.m2sdk.b7.a(r0)     // Catch:{ all -> 0x00d6 }
            r6.append(r0)     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = "&ul="
            r6.append(r0)     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = r7.g     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = com.m2catalyst.m2sdk.b7.a(r0)     // Catch:{ all -> 0x00d6 }
            r6.append(r0)     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = "&ping="
            r6.append(r0)     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = r7.h     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = com.m2catalyst.m2sdk.b7.a(r0)     // Catch:{ all -> 0x00d6 }
            r6.append(r0)     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = "&jitter="
            r6.append(r0)     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = r7.i     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = com.m2catalyst.m2sdk.b7.a(r0)     // Catch:{ all -> 0x00d6 }
            r6.append(r0)     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = r7.c     // Catch:{ all -> 0x00d6 }
            java.lang.String r2 = "full"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x00d6 }
            if (r0 == 0) goto L_0x0065
            java.lang.String r0 = "&log="
            r6.append(r0)     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = r7.j     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = com.m2catalyst.m2sdk.b7.a(r0)     // Catch:{ all -> 0x00d6 }
            r6.append(r0)     // Catch:{ all -> 0x00d6 }
        L_0x0065:
            java.lang.String r0 = "&extra="
            r6.append(r0)     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = r7.e     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = com.m2catalyst.m2sdk.b7.a(r0)     // Catch:{ all -> 0x00d6 }
            r6.append(r0)     // Catch:{ all -> 0x00d6 }
            com.m2catalyst.m2sdk.w0 r0 = r7.a     // Catch:{ all -> 0x00d6 }
            r2 = 0
            java.lang.String r3 = "application/x-www-form-urlencoded"
            int r4 = r6.length()     // Catch:{ all -> 0x00d6 }
            long r4 = (long) r4     // Catch:{ all -> 0x00d6 }
            r0.a(r1, r2, r3, r4)     // Catch:{ all -> 0x00d6 }
            com.m2catalyst.m2sdk.w0 r0 = r7.a     // Catch:{ all -> 0x00d6 }
            java.io.PrintStream r1 = r0.e     // Catch:{ all -> 0x00d6 }
            if (r1 != 0) goto L_0x009d
            r1 = 0
            java.io.PrintStream r2 = new java.io.PrintStream     // Catch:{ all -> 0x009b }
            java.net.Socket r3 = r0.a     // Catch:{ all -> 0x0090 }
            java.io.OutputStream r3 = r3.getOutputStream()     // Catch:{ all -> 0x0090 }
            goto L_0x0091
        L_0x0090:
            r3 = r1
        L_0x0091:
            java.lang.String r4 = "utf-8"
            r5 = 0
            r2.<init>(r3, r5, r4)     // Catch:{ all -> 0x009b }
            r0.e = r2     // Catch:{ all -> 0x009b }
            goto L_0x009d
        L_0x009b:
            r0.e = r1     // Catch:{ all -> 0x00d6 }
        L_0x009d:
            java.io.PrintStream r0 = r0.e     // Catch:{ all -> 0x00d6 }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x00d6 }
            r0.print(r1)     // Catch:{ all -> 0x00d6 }
            r0.flush()     // Catch:{ all -> 0x00d6 }
            com.m2catalyst.m2sdk.w0 r0 = r7.a     // Catch:{ all -> 0x00d6 }
            java.util.HashMap r0 = r0.b()     // Catch:{ all -> 0x00d6 }
            java.lang.String r1 = "transfer-encoding"
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x00d6 }
            if (r0 == 0) goto L_0x00c7
            java.lang.String r1 = "chunked"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ all -> 0x00d6 }
            if (r0 == 0) goto L_0x00c7
            com.m2catalyst.m2sdk.w0 r0 = r7.a     // Catch:{ all -> 0x00d6 }
            r0.c()     // Catch:{ all -> 0x00d6 }
        L_0x00c7:
            com.m2catalyst.m2sdk.w0 r0 = r7.a     // Catch:{ all -> 0x00d6 }
            java.lang.String r0 = r0.c()     // Catch:{ all -> 0x00d6 }
            r7.a(r0)     // Catch:{ all -> 0x00d6 }
            com.m2catalyst.m2sdk.w0 r0 = r7.a     // Catch:{ all -> 0x00d6 }
            r0.a()     // Catch:{ all -> 0x00d6 }
            goto L_0x00f3
        L_0x00d6:
            r0 = move-exception
            com.m2catalyst.m2sdk.w0 r1 = r7.a     // Catch:{ all -> 0x00dc }
            r1.a()     // Catch:{ all -> 0x00dc }
        L_0x00dc:
            java.lang.String r0 = r0.toString()
            java.io.PrintStream r1 = java.lang.System.err
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Telemetry error: "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.println(r0)
        L_0x00f3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.n6.run():void");
    }
}
