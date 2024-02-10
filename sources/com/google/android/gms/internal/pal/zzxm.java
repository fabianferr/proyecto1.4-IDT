package com.google.android.gms.internal.pal;

/* compiled from: com.google.android.gms:play-services-pal@@20.0.1 */
final class zzxm extends zzxl {
    private static final int[] zzc = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private int zzd = 0;
    private final int[] zze = zzc;

    public zzxm(int i, byte[] bArr) {
        this.zza = bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x005d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(byte[] r17, int r18, int r19, boolean r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r19
            int r2 = r0.zzd
            r3 = 0
            r4 = 6
            if (r2 != r4) goto L_0x000b
            return r3
        L_0x000b:
            byte[] r5 = r0.zza
            int[] r6 = r0.zze
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x0012:
            r10 = 3
            r11 = 4
            r12 = 2
            r13 = 1
            if (r7 >= r1) goto L_0x00f5
            if (r2 != 0) goto L_0x0061
        L_0x001a:
            int r2 = r7 + 4
            if (r2 > r1) goto L_0x005b
            byte r8 = r17[r7]
            r8 = r8 & 255(0xff, float:3.57E-43)
            r8 = r6[r8]
            int r8 = r8 << 18
            int r14 = r7 + 1
            byte r14 = r17[r14]
            r14 = r14 & 255(0xff, float:3.57E-43)
            r14 = r6[r14]
            int r14 = r14 << 12
            r8 = r8 | r14
            int r14 = r7 + 2
            byte r14 = r17[r14]
            r14 = r14 & 255(0xff, float:3.57E-43)
            r14 = r6[r14]
            int r14 = r14 << r4
            r8 = r8 | r14
            int r14 = r7 + 3
            byte r14 = r17[r14]
            r14 = r14 & 255(0xff, float:3.57E-43)
            r14 = r6[r14]
            r8 = r8 | r14
            if (r8 < 0) goto L_0x005b
            int r7 = r9 + 2
            byte r14 = (byte) r8
            r5[r7] = r14
            int r7 = r9 + 1
            int r14 = r8 >> 8
            byte r14 = (byte) r14
            r5[r7] = r14
            int r7 = r8 >> 16
            byte r7 = (byte) r7
            r5[r9] = r7
            int r9 = r9 + 3
            r7 = r2
            goto L_0x001a
        L_0x005b:
            if (r7 < r1) goto L_0x0060
            r2 = 0
            goto L_0x00f5
        L_0x0060:
            r2 = 0
        L_0x0061:
            int r14 = r7 + 1
            byte r7 = r17[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            r7 = r6[r7]
            r15 = -1
            if (r2 == 0) goto L_0x00e7
            if (r2 == r13) goto L_0x00d9
            r13 = -2
            if (r2 == r12) goto L_0x00c2
            r12 = 5
            if (r2 == r10) goto L_0x008b
            if (r2 == r11) goto L_0x0081
            if (r2 == r12) goto L_0x007a
            goto L_0x00ef
        L_0x007a:
            if (r7 != r15) goto L_0x007e
            goto L_0x00ef
        L_0x007e:
            r0.zzd = r4
            return r3
        L_0x0081:
            if (r7 != r13) goto L_0x0084
            goto L_0x00de
        L_0x0084:
            if (r7 != r15) goto L_0x0088
            goto L_0x00ef
        L_0x0088:
            r0.zzd = r4
            return r3
        L_0x008b:
            if (r7 < 0) goto L_0x00a8
            int r2 = r8 << 6
            r8 = r2 | r7
            int r2 = r9 + 2
            byte r7 = (byte) r8
            r5[r2] = r7
            int r2 = r9 + 1
            int r7 = r8 >> 8
            byte r7 = (byte) r7
            r5[r2] = r7
            int r2 = r8 >> 16
            byte r2 = (byte) r2
            r5[r9] = r2
            int r9 = r9 + 3
            r7 = r14
            r2 = 0
            goto L_0x0012
        L_0x00a8:
            if (r7 != r13) goto L_0x00bc
            int r2 = r9 + 1
            int r7 = r8 >> 2
            byte r7 = (byte) r7
            r5[r2] = r7
            int r2 = r8 >> 10
            byte r2 = (byte) r2
            r5[r9] = r2
            int r9 = r9 + 2
            r7 = r14
            r2 = 5
            goto L_0x0012
        L_0x00bc:
            if (r7 != r15) goto L_0x00bf
            goto L_0x00ef
        L_0x00bf:
            r0.zzd = r4
            return r3
        L_0x00c2:
            if (r7 < 0) goto L_0x00c5
            goto L_0x00db
        L_0x00c5:
            if (r7 != r13) goto L_0x00d3
            int r2 = r9 + 1
            int r7 = r8 >> 4
            byte r7 = (byte) r7
            r5[r9] = r7
            r9 = r2
            r7 = r14
            r2 = 4
            goto L_0x0012
        L_0x00d3:
            if (r7 != r15) goto L_0x00d6
            goto L_0x00ef
        L_0x00d6:
            r0.zzd = r4
            return r3
        L_0x00d9:
            if (r7 < 0) goto L_0x00e1
        L_0x00db:
            int r8 = r8 << 6
            r8 = r8 | r7
        L_0x00de:
            int r2 = r2 + 1
            goto L_0x00ef
        L_0x00e1:
            if (r7 != r15) goto L_0x00e4
            goto L_0x00ef
        L_0x00e4:
            r0.zzd = r4
            return r3
        L_0x00e7:
            if (r7 < 0) goto L_0x00ed
            int r2 = r2 + 1
            r8 = r7
            goto L_0x00ef
        L_0x00ed:
            if (r7 != r15) goto L_0x00f2
        L_0x00ef:
            r7 = r14
            goto L_0x0012
        L_0x00f2:
            r0.zzd = r4
            return r3
        L_0x00f5:
            if (r2 == r13) goto L_0x011d
            if (r2 == r12) goto L_0x0110
            if (r2 == r10) goto L_0x0101
            if (r2 == r11) goto L_0x00fe
            goto L_0x0118
        L_0x00fe:
            r0.zzd = r4
            return r3
        L_0x0101:
            int r1 = r9 + 1
            int r3 = r8 >> 10
            byte r3 = (byte) r3
            r5[r9] = r3
            int r9 = r1 + 1
            int r3 = r8 >> 2
            byte r3 = (byte) r3
            r5[r1] = r3
            goto L_0x0118
        L_0x0110:
            int r1 = r9 + 1
            int r3 = r8 >> 4
            byte r3 = (byte) r3
            r5[r9] = r3
            r9 = r1
        L_0x0118:
            r0.zzd = r2
            r0.zzb = r9
            return r13
        L_0x011d:
            r0.zzd = r4
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzxm.zza(byte[], int, int, boolean):boolean");
    }
}
