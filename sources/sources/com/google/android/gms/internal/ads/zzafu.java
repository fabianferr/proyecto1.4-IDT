package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzafu {
    private static final int[] zza = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean zza(zzzj zzzj) throws IOException {
        return zzc(zzzj, true, false);
    }

    public static boolean zzb(zzzj zzzj, boolean z) throws IOException {
        return zzc(zzzj, false, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d4, code lost:
        r9 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean zzc(com.google.android.gms.internal.ads.zzzj r20, boolean r21, boolean r22) throws java.io.IOException {
        /*
            r0 = r20
            long r1 = r20.zzd()
            r3 = 4096(0x1000, double:2.0237E-320)
            r5 = -1
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0014
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r3 = r1
        L_0x0014:
            int r4 = (int) r3
            com.google.android.gms.internal.ads.zzef r3 = new com.google.android.gms.internal.ads.zzef
            r7 = 64
            r3.<init>((int) r7)
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x001f:
            r10 = 1
            if (r8 >= r4) goto L_0x0100
            r11 = 8
            r3.zzC(r11)
            byte[] r12 = r3.zzH()
            boolean r12 = r0.zzm(r12, r7, r11, r10)
            if (r12 != 0) goto L_0x0033
            goto L_0x0100
        L_0x0033:
            long r12 = r3.zzs()
            int r14 = r3.zze()
            r15 = 1
            int r17 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r17 != 0) goto L_0x0053
            byte[] r12 = r3.zzH()
            r0.zzh(r12, r11, r11)
            r12 = 16
            r3.zzE(r12)
            long r15 = r3.zzr()
            r10 = r15
            goto L_0x006c
        L_0x0053:
            r15 = 0
            int r17 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r17 != 0) goto L_0x0069
            long r15 = r20.zzd()
            int r17 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
            if (r17 == 0) goto L_0x0069
            long r12 = r20.zze()
            long r15 = r15 - r12
            r12 = 8
            long r12 = r12 + r15
        L_0x0069:
            r10 = r12
            r12 = 8
        L_0x006c:
            long r5 = (long) r12
            int r17 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r17 >= 0) goto L_0x0072
            return r7
        L_0x0072:
            int r8 = r8 + r12
            r12 = 1836019574(0x6d6f6f76, float:4.631354E27)
            if (r14 != r12) goto L_0x0088
            int r5 = (int) r10
            int r4 = r4 + r5
            r15 = -1
            int r5 = (r1 > r15 ? 1 : (r1 == r15 ? 0 : -1))
            if (r5 == 0) goto L_0x0086
            long r5 = (long) r4
            int r10 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r10 <= 0) goto L_0x0086
            int r4 = (int) r1
        L_0x0086:
            r5 = r15
            goto L_0x001f
        L_0x0088:
            r15 = -1
            r12 = 1836019558(0x6d6f6f66, float:4.6313494E27)
            if (r14 == r12) goto L_0x00fe
            r12 = 1836475768(0x6d766578, float:4.7659988E27)
            if (r14 != r12) goto L_0x0096
            goto L_0x00fe
        L_0x0096:
            r12 = r14
            long r13 = (long) r8
            long r13 = r13 + r10
            long r13 = r13 - r5
            r18 = r8
            long r7 = (long) r4
            int r19 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r19 < 0) goto L_0x00a2
            goto L_0x0100
        L_0x00a2:
            long r10 = r10 - r5
            int r5 = (int) r10
            int r8 = r18 + r5
            r6 = 1718909296(0x66747970, float:2.8862439E23)
            if (r12 != r6) goto L_0x00f5
            r6 = 8
            if (r5 >= r6) goto L_0x00b1
            r6 = 0
            return r6
        L_0x00b1:
            r6 = 0
            r3.zzC(r5)
            byte[] r7 = r3.zzH()
            r0.zzh(r7, r6, r5)
            int r5 = r5 >> 2
            r6 = 0
        L_0x00bf:
            if (r6 >= r5) goto L_0x00f0
            r7 = 1
            if (r6 != r7) goto L_0x00c9
            r7 = 4
            r3.zzG(r7)
            goto L_0x00ed
        L_0x00c9:
            int r7 = r3.zze()
            int r10 = r7 >>> 8
            r11 = 3368816(0x336770, float:4.720717E-39)
            if (r10 != r11) goto L_0x00d6
        L_0x00d4:
            r9 = 1
            goto L_0x00f0
        L_0x00d6:
            r10 = 1751476579(0x68656963, float:4.333464E24)
            if (r7 != r10) goto L_0x00de
            r7 = 1751476579(0x68656963, float:4.333464E24)
        L_0x00de:
            int[] r10 = zza
            r11 = 0
        L_0x00e1:
            r12 = 29
            if (r11 >= r12) goto L_0x00ed
            r12 = r10[r11]
            if (r12 != r7) goto L_0x00ea
            goto L_0x00d4
        L_0x00ea:
            int r11 = r11 + 1
            goto L_0x00e1
        L_0x00ed:
            int r6 = r6 + 1
            goto L_0x00bf
        L_0x00f0:
            if (r9 == 0) goto L_0x00f3
            goto L_0x00fa
        L_0x00f3:
            r5 = 0
            return r5
        L_0x00f5:
            if (r5 == 0) goto L_0x00fa
            r0.zzg(r5)
        L_0x00fa:
            r5 = r15
            r7 = 0
            goto L_0x001f
        L_0x00fe:
            r6 = 1
            goto L_0x0101
        L_0x0100:
            r6 = 0
        L_0x0101:
            if (r9 == 0) goto L_0x0109
            r0 = r21
            if (r0 != r6) goto L_0x0109
            r0 = 1
            return r0
        L_0x0109:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafu.zzc(com.google.android.gms.internal.ads.zzzj, boolean, boolean):boolean");
    }
}
