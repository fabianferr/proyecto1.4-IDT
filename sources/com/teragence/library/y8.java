package com.teragence.library;

import java.io.PrintStream;

public class y8 extends Exception {
    protected Throwable b;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public y8(java.lang.String r4, com.teragence.library.x8 r5, java.lang.Throwable r6) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = ""
            if (r4 != 0) goto L_0x000b
            r4 = r1
            goto L_0x001c
        L_0x000b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            java.lang.String r4 = " "
            r2.append(r4)
            java.lang.String r4 = r2.toString()
        L_0x001c:
            r0.append(r4)
            if (r5 != 0) goto L_0x0023
            r4 = r1
            goto L_0x003a
        L_0x0023:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r2 = "(position:"
            r4.<init>(r2)
            java.lang.String r2 = r5.f()
            r4.append(r2)
            java.lang.String r2 = ") "
            r4.append(r2)
            java.lang.String r4 = r4.toString()
        L_0x003a:
            r0.append(r4)
            if (r6 != 0) goto L_0x0040
            goto L_0x004e
        L_0x0040:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r1 = "caused by: "
            r4.<init>(r1)
            r4.append(r6)
            java.lang.String r1 = r4.toString()
        L_0x004e:
            r0.append(r1)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            if (r5 == 0) goto L_0x0060
            r5.m()
            r5.b()
        L_0x0060:
            r3.b = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.teragence.library.y8.<init>(java.lang.String, com.teragence.library.x8, java.lang.Throwable):void");
    }

    public void printStackTrace() {
        if (this.b == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            PrintStream printStream = System.err;
            printStream.println(super.getMessage() + "; nested exception is:");
            this.b.printStackTrace();
        }
    }
}
