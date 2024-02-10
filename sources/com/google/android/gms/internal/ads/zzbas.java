package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbas {
    public final List zza;
    public final int zzb;
    public final float zzc;

    private zzbas(List list, int i, int i2, int i3, float f) {
        this.zza = list;
        this.zzb = i;
        this.zzc = f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e4 A[Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00e8 A[Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x011d A[Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x012d A[Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0169 A[Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x017a A[Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzbas zza(com.google.android.gms.internal.ads.zzbak r17) throws com.google.android.gms.internal.ads.zzasz {
        /*
            r0 = 4
            r1 = r17
            r1.zzw(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            int r0 = r17.zzg()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            r2 = 3
            r0 = r0 & r2
            r3 = 1
            int r6 = r0 + 1
            if (r6 == r2) goto L_0x01a9
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            r5.<init>()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            int r0 = r17.zzg()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            r0 = r0 & 31
            r4 = 0
            r7 = 0
        L_0x001e:
            if (r7 >= r0) goto L_0x002a
            byte[] r8 = zzb(r17)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            r5.add(r8)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            int r7 = r7 + 1
            goto L_0x001e
        L_0x002a:
            int r7 = r17.zzg()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            r8 = 0
        L_0x002f:
            if (r8 >= r7) goto L_0x003b
            byte[] r9 = zzb(r17)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            r5.add(r9)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            int r8 = r8 + 1
            goto L_0x002f
        L_0x003b:
            r1 = 1065353216(0x3f800000, float:1.0)
            if (r0 <= 0) goto L_0x019d
            java.lang.Object r0 = r5.get(r4)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            byte[] r0 = (byte[]) r0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            java.lang.Object r7 = r5.get(r4)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            byte[] r7 = (byte[]) r7     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            int r0 = r0.length     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            com.google.android.gms.internal.ads.zzbal r8 = new com.google.android.gms.internal.ads.zzbal     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            r8.<init>(r7, r6, r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            r0 = 8
            r8.zzd(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            int r7 = r8.zza(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            r9 = 16
            r8.zzd(r9)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            r10 = 100
            if (r7 == r10) goto L_0x008d
            r10 = 110(0x6e, float:1.54E-43)
            if (r7 == r10) goto L_0x008d
            r10 = 122(0x7a, float:1.71E-43)
            if (r7 == r10) goto L_0x008d
            r10 = 244(0xf4, float:3.42E-43)
            if (r7 == r10) goto L_0x008d
            r10 = 44
            if (r7 == r10) goto L_0x008d
            r10 = 83
            if (r7 == r10) goto L_0x008d
            r10 = 86
            if (r7 == r10) goto L_0x008d
            r10 = 118(0x76, float:1.65E-43)
            if (r7 == r10) goto L_0x008d
            r10 = 128(0x80, float:1.794E-43)
            if (r7 == r10) goto L_0x008d
            r10 = 138(0x8a, float:1.93E-43)
            if (r7 != r10) goto L_0x008b
            goto L_0x008d
        L_0x008b:
            r7 = 1
            goto L_0x00db
        L_0x008d:
            int r7 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            if (r7 != r2) goto L_0x0098
            r8.zze()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            r10 = 3
            goto L_0x0099
        L_0x0098:
            r10 = r7
        L_0x0099:
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            r8.zzd(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            boolean r11 = r8.zze()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            if (r11 == 0) goto L_0x00db
            if (r10 == r2) goto L_0x00ad
            r10 = 8
            goto L_0x00af
        L_0x00ad:
            r10 = 12
        L_0x00af:
            r11 = 0
        L_0x00b0:
            if (r11 >= r10) goto L_0x00db
            boolean r12 = r8.zze()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            if (r12 == 0) goto L_0x00d8
            r12 = 6
            if (r11 >= r12) goto L_0x00be
            r12 = 16
            goto L_0x00c0
        L_0x00be:
            r12 = 64
        L_0x00c0:
            r13 = 0
            r14 = 8
            r15 = 8
        L_0x00c5:
            if (r13 >= r12) goto L_0x00d8
            if (r14 == 0) goto L_0x00d2
            int r14 = r8.zzb()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            int r14 = r14 + r15
            int r14 = r14 + 256
            int r14 = r14 % 256
        L_0x00d2:
            if (r14 == 0) goto L_0x00d5
            r15 = r14
        L_0x00d5:
            int r13 = r13 + 1
            goto L_0x00c5
        L_0x00d8:
            int r11 = r11 + 1
            goto L_0x00b0
        L_0x00db:
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            int r10 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            if (r10 != 0) goto L_0x00e8
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            goto L_0x0103
        L_0x00e8:
            if (r10 != r3) goto L_0x0103
            r8.zze()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            r8.zzb()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            r8.zzb()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            int r10 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            long r10 = (long) r10     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
        L_0x00f8:
            long r12 = (long) r4     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            int r14 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r14 >= 0) goto L_0x0103
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            int r4 = r4 + 1
            goto L_0x00f8
        L_0x0103:
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            r8.zzd(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            int r4 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            int r4 = r4 + r3
            int r10 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            int r10 = r10 + r3
            boolean r11 = r8.zze()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            int r12 = 2 - r11
            int r10 = r10 * r12
            if (r11 != 0) goto L_0x0120
            r8.zzd(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
        L_0x0120:
            r8.zzd(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            int r4 = r4 * 16
            int r10 = r10 * 16
            boolean r11 = r8.zze()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            if (r11 == 0) goto L_0x0155
            int r11 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            int r13 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            int r14 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            int r15 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            if (r7 != 0) goto L_0x0140
            goto L_0x014d
        L_0x0140:
            r16 = 2
            if (r7 != r2) goto L_0x0146
            r2 = 1
            goto L_0x0147
        L_0x0146:
            r2 = 2
        L_0x0147:
            if (r7 != r3) goto L_0x014a
            r3 = 2
        L_0x014a:
            int r12 = r12 * r3
            r3 = r2
        L_0x014d:
            int r11 = r11 + r13
            int r11 = r11 * r3
            int r4 = r4 - r11
            int r14 = r14 + r15
            int r14 = r14 * r12
            int r10 = r10 - r14
        L_0x0155:
            boolean r2 = r8.zze()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            if (r2 == 0) goto L_0x0199
            boolean r2 = r8.zze()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            if (r2 == 0) goto L_0x0199
            int r0 = r8.zza(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            r2 = 255(0xff, float:3.57E-43)
            if (r0 != r2) goto L_0x017a
            int r0 = r8.zza(r9)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            int r2 = r8.zza(r9)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            if (r0 == 0) goto L_0x0199
            if (r2 == 0) goto L_0x0199
            float r0 = (float) r0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            float r1 = (float) r2     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            float r1 = r0 / r1
            goto L_0x0199
        L_0x017a:
            r2 = 17
            if (r0 >= r2) goto L_0x0183
            float[] r1 = com.google.android.gms.internal.ads.zzbai.zzb     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            r1 = r1[r0]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            goto L_0x0199
        L_0x0183:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            r2.<init>()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            java.lang.String r3 = "Unexpected aspect_ratio_idc value: "
            r2.append(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            r2.append(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            java.lang.String r0 = "NalUnitUtil"
            java.lang.String r2 = r2.toString()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            android.util.Log.w(r0, r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
        L_0x0199:
            r9 = r1
            r7 = r4
            r8 = r10
            goto L_0x01a2
        L_0x019d:
            r0 = -1
            r7 = -1
            r8 = -1
            r9 = 1065353216(0x3f800000, float:1.0)
        L_0x01a2:
            com.google.android.gms.internal.ads.zzbas r0 = new com.google.android.gms.internal.ads.zzbas     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            return r0
        L_0x01a9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            r0.<init>()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
            throw r0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01af }
        L_0x01af:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzasz r1 = new com.google.android.gms.internal.ads.zzasz
            java.lang.String r2 = "Error parsing AVC config"
            r1.<init>(r2, r0)
            goto L_0x01b9
        L_0x01b8:
            throw r1
        L_0x01b9:
            goto L_0x01b8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbas.zza(com.google.android.gms.internal.ads.zzbak):com.google.android.gms.internal.ads.zzbas");
    }

    private static byte[] zzb(zzbak zzbak) {
        int zzj = zzbak.zzj();
        int zzc2 = zzbak.zzc();
        zzbak.zzw(zzj);
        return zzbad.zzb(zzbak.zza, zzc2, zzj);
    }
}
