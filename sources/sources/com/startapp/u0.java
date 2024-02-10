package com.startapp;

import java.util.Arrays;

/* compiled from: Sta */
public abstract class u0 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    /* compiled from: Sta */
    public static class a {
        public int a;
        public byte[] b;
        public int c;
        public int d;
        public boolean e;
        public int f;
        public int g;

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", new Object[]{a.class.getSimpleName(), Arrays.toString(this.b), Integer.valueOf(this.f), Boolean.valueOf(this.e), Integer.valueOf(this.a), 0L, Integer.valueOf(this.g), Integer.valueOf(this.c), Integer.valueOf(this.d)});
        }
    }

    public u0(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3 > 0 && i4 > 0 ? (i3 / i2) * i2 : 0;
        this.d = i4;
    }

    public byte[] a(int i, a aVar) {
        byte[] bArr = aVar.b;
        if (bArr != null && bArr.length >= aVar.c + i) {
            return bArr;
        }
        if (bArr == null) {
            aVar.b = new byte[8192];
            aVar.c = 0;
            aVar.d = 0;
        } else {
            byte[] bArr2 = new byte[(bArr.length * 2)];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            aVar.b = bArr2;
        }
        return aVar.b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e A[LOOP:0: B:1:0x0003->B:12:0x001e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0021 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(byte[] r8) {
        /*
            r7 = this;
            int r0 = r8.length
            r1 = 0
            r2 = 0
        L_0x0003:
            if (r2 >= r0) goto L_0x0022
            byte r3 = r8[r2]
            r4 = 61
            r5 = 1
            if (r4 == r3) goto L_0x0021
            if (r3 < 0) goto L_0x001a
            byte[] r4 = com.startapp.q0.k
            int r6 = r4.length
            if (r3 >= r6) goto L_0x001a
            byte r3 = r4[r3]
            r4 = -1
            if (r3 == r4) goto L_0x001a
            r3 = 1
            goto L_0x001b
        L_0x001a:
            r3 = 0
        L_0x001b:
            if (r3 == 0) goto L_0x001e
            goto L_0x0021
        L_0x001e:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x0021:
            return r5
        L_0x0022:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.u0.a(byte[]):boolean");
    }
}
