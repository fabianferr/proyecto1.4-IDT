package com.google.android.gms.internal.ads;

import com.google.common.primitives.SignedBytes;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzym {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0094, code lost:
        if (r12 != 11) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0099, code lost:
        if (r12 != 11) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009e, code lost:
        if (r12 != 8) goto L_0x00a1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzyl zza(com.google.android.gms.internal.ads.zzee r12) {
        /*
            r0 = 16
            int r1 = r12.zzc(r0)
            int r0 = r12.zzc(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L_0x0018
            r0 = 24
            int r0 = r12.zzc(r0)
            r2 = 7
            goto L_0x0019
        L_0x0018:
            r2 = 4
        L_0x0019:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L_0x0021
            int r0 = r0 + 2
        L_0x0021:
            r8 = r0
            r0 = 2
            int r1 = r12.zzc(r0)
            r2 = 0
            r4 = 3
            if (r1 != r4) goto L_0x003d
            r1 = 0
        L_0x002c:
            int r5 = r12.zzc(r0)
            int r1 = r1 + r5
            boolean r5 = r12.zzl()
            if (r5 != 0) goto L_0x0039
            int r1 = r1 + r4
            goto L_0x003d
        L_0x0039:
            int r1 = r1 + 1
            int r1 = r1 << r0
            goto L_0x002c
        L_0x003d:
            r5 = r1
            r1 = 10
            int r1 = r12.zzc(r1)
            boolean r6 = r12.zzl()
            if (r6 == 0) goto L_0x0053
            int r6 = r12.zzc(r4)
            if (r6 <= 0) goto L_0x0053
            r12.zzj(r0)
        L_0x0053:
            boolean r6 = r12.zzl()
            r7 = 44100(0xac44, float:6.1797E-41)
            r9 = 48000(0xbb80, float:6.7262E-41)
            r10 = 1
            if (r10 == r6) goto L_0x0064
            r11 = 44100(0xac44, float:6.1797E-41)
            goto L_0x0067
        L_0x0064:
            r11 = 48000(0xbb80, float:6.7262E-41)
        L_0x0067:
            int r12 = r12.zzc(r3)
            if (r11 != r7) goto L_0x0077
            r6 = 13
            if (r12 != r6) goto L_0x0077
            int[] r12 = zzb
            r12 = r12[r6]
            r9 = r12
            goto L_0x00a7
        L_0x0077:
            if (r11 != r9) goto L_0x00a6
            r6 = 14
            if (r12 >= r6) goto L_0x00a6
            int[] r2 = zzb
            r2 = r2[r12]
            int r1 = r1 % 5
            r6 = 8
            if (r1 == r10) goto L_0x009c
            r7 = 11
            if (r1 == r0) goto L_0x0097
            if (r1 == r4) goto L_0x009c
            if (r1 == r3) goto L_0x0090
            goto L_0x00a1
        L_0x0090:
            if (r12 == r4) goto L_0x00a3
            if (r12 == r6) goto L_0x00a3
            if (r12 != r7) goto L_0x00a1
            goto L_0x00a3
        L_0x0097:
            if (r12 == r6) goto L_0x00a3
            if (r12 != r7) goto L_0x00a1
            goto L_0x00a3
        L_0x009c:
            if (r12 == r4) goto L_0x00a3
            if (r12 != r6) goto L_0x00a1
            goto L_0x00a3
        L_0x00a1:
            r9 = r2
            goto L_0x00a7
        L_0x00a3:
            int r2 = r2 + 1
            goto L_0x00a1
        L_0x00a6:
            r9 = 0
        L_0x00a7:
            com.google.android.gms.internal.ads.zzyl r12 = new com.google.android.gms.internal.ads.zzyl
            r6 = 2
            r10 = 0
            r4 = r12
            r7 = r11
            r4.<init>(r5, r6, r7, r8, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzym.zza(com.google.android.gms.internal.ads.zzee):com.google.android.gms.internal.ads.zzyl");
    }

    public static void zzb(int i, zzef zzef) {
        zzef.zzC(7);
        byte[] zzH = zzef.zzH();
        zzH[0] = -84;
        zzH[1] = SignedBytes.MAX_POWER_OF_TWO;
        zzH[2] = -1;
        zzH[3] = -1;
        zzH[4] = (byte) ((i >> 16) & 255);
        zzH[5] = (byte) ((i >> 8) & 255);
        zzH[6] = (byte) (i & 255);
    }
}
