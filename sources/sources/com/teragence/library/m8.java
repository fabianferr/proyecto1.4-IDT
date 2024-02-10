package com.teragence.library;

public class m8 extends b8 {
    public static final Object e = new Object();
    public static final Object f = new Object();
    protected String b;
    protected String c;
    protected Object d;

    public m8(String str, String str2, Object obj) {
        this.b = str;
        this.c = str2;
        this.d = obj;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        r0 = r4.d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        r0 = r4.b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.teragence.library.m8
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            com.teragence.library.m8 r5 = (com.teragence.library.m8) r5
            java.lang.String r0 = r4.c
            java.lang.String r2 = r5.c
            boolean r0 = r0.equals(r2)
            r2 = 1
            if (r0 == 0) goto L_0x0037
            java.lang.String r0 = r4.b
            if (r0 != 0) goto L_0x001c
            java.lang.String r0 = r5.b
            if (r0 != 0) goto L_0x0037
            goto L_0x0024
        L_0x001c:
            java.lang.String r3 = r5.b
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0037
        L_0x0024:
            java.lang.Object r0 = r4.d
            if (r0 != 0) goto L_0x002d
            java.lang.Object r0 = r5.d
            if (r0 != 0) goto L_0x0037
            goto L_0x0035
        L_0x002d:
            java.lang.Object r3 = r5.d
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0037
        L_0x0035:
            r0 = 1
            goto L_0x0038
        L_0x0037:
            r0 = 0
        L_0x0038:
            if (r0 == 0) goto L_0x0041
            boolean r5 = r4.a((com.teragence.library.b8) r5)
            if (r5 == 0) goto L_0x0041
            r1 = 1
        L_0x0041:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.teragence.library.m8.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int hashCode = this.c.hashCode();
        String str = this.b;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        Object obj = this.d;
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }
}
