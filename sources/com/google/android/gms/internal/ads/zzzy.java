package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzzy {
    public final List zza;
    public final int zzb;
    public final float zzc;
    public final String zzd;

    private zzzy(List list, int i, int i2, int i3, float f, String str) {
        this.zza = list;
        this.zzb = i;
        this.zzc = f;
        this.zzd = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:175:0x036f A[Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0378 A[Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x038d A[Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }] */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x039c A[Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x011f A[Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0121 A[Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzzy zza(com.google.android.gms.internal.ads.zzef r39) throws com.google.android.gms.internal.ads.zzbu {
        /*
            r0 = r39
            r1 = 21
            r0.zzG(r1)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r1 = r39.zzk()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r2 = 3
            r1 = r1 & r2
            int r3 = r39.zzk()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r4 = r39.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x0018:
            r8 = 1
            if (r6 >= r3) goto L_0x0035
            r0.zzG(r8)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r8 = r39.zzo()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r9 = 0
        L_0x0023:
            if (r9 >= r8) goto L_0x0032
            int r10 = r39.zzo()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r11 = r10 + 4
            int r7 = r7 + r11
            r0.zzG(r10)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r9 = r9 + 1
            goto L_0x0023
        L_0x0032:
            int r6 = r6 + 1
            goto L_0x0018
        L_0x0035:
            r0.zzF(r4)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            byte[] r4 = new byte[r7]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r10 = 0
            r17 = r10
            r10 = 0
            r11 = 0
            r14 = -1
            r15 = -1
            r16 = 1065353216(0x3f800000, float:1.0)
        L_0x0043:
            if (r10 >= r3) goto L_0x03f1
            int r12 = r39.zzk()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r12 = r12 & 63
            int r13 = r39.zzo()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r6 = 0
        L_0x0050:
            if (r6 >= r13) goto L_0x03db
            int r9 = r39.zzo()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            byte[] r8 = com.google.android.gms.internal.ads.zzaaf.zza     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r2 = 4
            java.lang.System.arraycopy(r8, r5, r4, r11, r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r11 = r11 + 4
            byte[] r8 = r39.zzH()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r5 = r39.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            java.lang.System.arraycopy(r8, r5, r4, r11, r9)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r5 = 33
            if (r12 != r5) goto L_0x03b0
            if (r6 != 0) goto L_0x03b0
            int r5 = r11 + r9
            int r6 = r11 + 2
            com.google.android.gms.internal.ads.zzaah r8 = new com.google.android.gms.internal.ads.zzaah     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r8.<init>(r4, r6, r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r8.zze(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r5 = 3
            int r6 = r8.zza(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r8.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r5 = 2
            int r19 = r8.zza(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            boolean r20 = r8.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r14 = 5
            int r21 = r8.zza(r14)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r15 = 0
            r22 = 0
        L_0x0094:
            r14 = 32
            if (r15 >= r14) goto L_0x00a6
            boolean r14 = r8.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r14 == 0) goto L_0x00a3
            r14 = 1
            int r17 = r14 << r15
            r22 = r22 | r17
        L_0x00a3:
            int r15 = r15 + 1
            goto L_0x0094
        L_0x00a6:
            r14 = 6
            int[] r15 = new int[r14]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r2 = 0
        L_0x00aa:
            r5 = 8
            if (r2 >= r14) goto L_0x00b7
            int r5 = r8.zza(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r15[r2] = r5     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r2 = r2 + 1
            goto L_0x00aa
        L_0x00b7:
            int r24 = r8.zza(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r2 = 0
            r5 = 0
        L_0x00bd:
            if (r2 >= r6) goto L_0x00d2
            boolean r25 = r8.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r25 == 0) goto L_0x00c7
            int r5 = r5 + 89
        L_0x00c7:
            boolean r25 = r8.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r25 == 0) goto L_0x00cf
            int r5 = r5 + 8
        L_0x00cf:
            int r2 = r2 + 1
            goto L_0x00bd
        L_0x00d2:
            r8.zze(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r6 <= 0) goto L_0x00dd
            int r2 = 8 - r6
            int r2 = r2 + r2
            r8.zze(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
        L_0x00dd:
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r5 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r2 = 3
            if (r5 != r2) goto L_0x00eb
            r8.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r5 = 3
        L_0x00eb:
            int r2 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r25 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            boolean r26 = r8.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r26 == 0) goto L_0x012e
            int r26 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r27 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r28 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r29 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r14 = 1
            if (r5 == r14) goto L_0x0119
            r14 = 2
            if (r5 != r14) goto L_0x0114
            r31 = r3
            r3 = 1
            r5 = 2
            goto L_0x011c
        L_0x0114:
            r31 = r3
            r3 = 1
            r14 = 1
            goto L_0x011d
        L_0x0119:
            r31 = r3
            r3 = 1
        L_0x011c:
            r14 = 2
        L_0x011d:
            if (r5 != r3) goto L_0x0121
            r3 = 2
            goto L_0x0122
        L_0x0121:
            r3 = 1
        L_0x0122:
            int r26 = r26 + r27
            int r14 = r14 * r26
            int r2 = r2 - r14
            int r28 = r28 + r29
            int r3 = r3 * r28
            int r25 = r25 - r3
            goto L_0x0130
        L_0x012e:
            r31 = r3
        L_0x0130:
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r3 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            boolean r5 = r8.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r14 = 1
            if (r14 == r5) goto L_0x0143
            r5 = r6
            goto L_0x0144
        L_0x0143:
            r5 = 0
        L_0x0144:
            if (r5 > r6) goto L_0x0152
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r5 = r5 + 1
            goto L_0x0144
        L_0x0152:
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            boolean r5 = r8.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r5 == 0) goto L_0x01b6
            boolean r5 = r8.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r5 == 0) goto L_0x01b6
            r5 = 0
        L_0x0171:
            r6 = 4
            if (r5 >= r6) goto L_0x01b6
            r6 = 0
        L_0x0175:
            r14 = 6
            if (r6 >= r14) goto L_0x01ae
            boolean r26 = r8.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r26 != 0) goto L_0x0185
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r27 = r2
        L_0x0183:
            r2 = 3
            goto L_0x01a5
        L_0x0185:
            int r26 = r5 + r5
            r23 = 4
            int r26 = r26 + 4
            r27 = r2
            r14 = 1
            int r2 = r14 << r26
            r14 = 64
            int r2 = java.lang.Math.min(r14, r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r14 = 1
            if (r5 <= r14) goto L_0x019c
            r8.zzb()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
        L_0x019c:
            r14 = 0
        L_0x019d:
            if (r14 >= r2) goto L_0x0183
            r8.zzb()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r14 = r14 + 1
            goto L_0x019d
        L_0x01a5:
            if (r5 != r2) goto L_0x01a9
            r14 = 3
            goto L_0x01aa
        L_0x01a9:
            r14 = 1
        L_0x01aa:
            int r6 = r6 + r14
            r2 = r27
            goto L_0x0175
        L_0x01ae:
            r27 = r2
            r2 = 3
            int r5 = r5 + 1
            r2 = r27
            goto L_0x0171
        L_0x01b6:
            r27 = r2
            r2 = 3
            r5 = 2
            r8.zze(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            boolean r5 = r8.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r5 == 0) goto L_0x01d1
            r5 = 8
            r8.zze(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r8.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
        L_0x01d1:
            int r5 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r6 = 0
            int[] r14 = new int[r6]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int[] r2 = new int[r6]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r26 = r12
            r28 = r13
            r12 = -1
            r13 = -1
        L_0x01e0:
            if (r6 >= r5) goto L_0x02fe
            if (r6 == 0) goto L_0x02b2
            boolean r29 = r8.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r29 == 0) goto L_0x02b2
            r29 = r5
            int r5 = r12 + r13
            boolean r30 = r8.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r32 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r30 = r30 + r30
            r18 = 1
            int r30 = 1 - r30
            int r32 = r32 + 1
            int r30 = r30 * r32
            r32 = r1
            int r1 = r5 + 1
            r33 = r4
            boolean[] r4 = new boolean[r1]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r34 = r7
            r7 = 0
        L_0x020b:
            if (r7 > r5) goto L_0x0221
            boolean r35 = r8.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r35 != 0) goto L_0x021a
            boolean r35 = r8.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r4[r7] = r35     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            goto L_0x021e
        L_0x021a:
            r18 = 1
            r4[r7] = r18     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
        L_0x021e:
            int r7 = r7 + 1
            goto L_0x020b
        L_0x0221:
            int[] r7 = new int[r1]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int[] r1 = new int[r1]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r35 = r13 + -1
            r36 = 0
        L_0x0229:
            if (r35 < 0) goto L_0x0240
            r37 = r2[r35]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r37 = r37 + r30
            if (r37 >= 0) goto L_0x023d
            int r38 = r12 + r35
            boolean r38 = r4[r38]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r38 == 0) goto L_0x023d
            int r38 = r36 + 1
            r7[r36] = r37     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r36 = r38
        L_0x023d:
            int r35 = r35 + -1
            goto L_0x0229
        L_0x0240:
            if (r30 >= 0) goto L_0x024c
            boolean r35 = r4[r5]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r35 == 0) goto L_0x024c
            int r35 = r36 + 1
            r7[r36] = r30     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r36 = r35
        L_0x024c:
            r35 = r10
            r10 = r36
            r0 = 0
        L_0x0251:
            if (r0 >= r12) goto L_0x0266
            r36 = r14[r0]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r36 = r36 + r30
            if (r36 >= 0) goto L_0x0263
            boolean r37 = r4[r0]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r37 == 0) goto L_0x0263
            int r37 = r10 + 1
            r7[r10] = r36     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r10 = r37
        L_0x0263:
            int r0 = r0 + 1
            goto L_0x0251
        L_0x0266:
            int[] r0 = java.util.Arrays.copyOf(r7, r10)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r7 = r12 + -1
            r36 = 0
        L_0x026e:
            if (r7 < 0) goto L_0x0283
            r37 = r14[r7]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r37 = r37 + r30
            if (r37 <= 0) goto L_0x0280
            boolean r38 = r4[r7]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r38 == 0) goto L_0x0280
            int r38 = r36 + 1
            r1[r36] = r37     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r36 = r38
        L_0x0280:
            int r7 = r7 + -1
            goto L_0x026e
        L_0x0283:
            if (r30 <= 0) goto L_0x028f
            boolean r5 = r4[r5]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r5 == 0) goto L_0x028f
            int r5 = r36 + 1
            r1[r36] = r30     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r36 = r5
        L_0x028f:
            r5 = r36
            r7 = 0
        L_0x0292:
            if (r7 >= r13) goto L_0x02a9
            r14 = r2[r7]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r14 = r14 + r30
            if (r14 <= 0) goto L_0x02a6
            int r36 = r12 + r7
            boolean r36 = r4[r36]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r36 == 0) goto L_0x02a6
            int r36 = r5 + 1
            r1[r5] = r14     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r5 = r36
        L_0x02a6:
            int r7 = r7 + 1
            goto L_0x0292
        L_0x02a9:
            int[] r1 = java.util.Arrays.copyOf(r1, r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r14 = r0
            r2 = r1
            r13 = r5
            r12 = r10
            goto L_0x02ee
        L_0x02b2:
            r32 = r1
            r33 = r4
            r29 = r5
            r34 = r7
            r35 = r10
            int r0 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r1 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int[] r2 = new int[r0]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r4 = 0
        L_0x02c7:
            if (r4 >= r0) goto L_0x02d7
            int r5 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r7 = 1
            int r5 = r5 + r7
            r2[r4] = r5     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r8.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r4 = r4 + 1
            goto L_0x02c7
        L_0x02d7:
            int[] r4 = new int[r1]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r5 = 0
        L_0x02da:
            if (r5 >= r1) goto L_0x02ea
            int r7 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r10 = 1
            int r7 = r7 + r10
            r4[r5] = r7     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r8.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r5 = r5 + 1
            goto L_0x02da
        L_0x02ea:
            r12 = r0
            r13 = r1
            r14 = r2
            r2 = r4
        L_0x02ee:
            int r6 = r6 + 1
            r0 = r39
            r5 = r29
            r1 = r32
            r4 = r33
            r7 = r34
            r10 = r35
            goto L_0x01e0
        L_0x02fe:
            r32 = r1
            r33 = r4
            r34 = r7
            r35 = r10
            boolean r0 = r8.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r0 == 0) goto L_0x031c
            r0 = 0
        L_0x030d:
            int r1 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r0 >= r1) goto L_0x031c
            r1 = 5
            int r14 = r3 + 5
            r8.zze(r14)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r0 = r0 + 1
            goto L_0x030d
        L_0x031c:
            r0 = 2
            r8.zze(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            boolean r0 = r8.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r0 == 0) goto L_0x039f
            boolean r0 = r8.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r0 == 0) goto L_0x0367
            r0 = 8
            int r0 = r8.zza(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r1 = 255(0xff, float:3.57E-43)
            if (r0 != r1) goto L_0x0348
            r0 = 16
            int r1 = r8.zza(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            int r0 = r8.zza(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r1 == 0) goto L_0x0367
            if (r0 == 0) goto L_0x0367
            float r1 = (float) r1     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            float r0 = (float) r0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            float r1 = r1 / r0
            goto L_0x0369
        L_0x0348:
            r1 = 17
            if (r0 >= r1) goto L_0x0351
            float[] r1 = com.google.android.gms.internal.ads.zzaaf.zzb     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r1 = r1[r0]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            goto L_0x0369
        L_0x0351:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r1.<init>()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            java.lang.String r2 = "Unexpected aspect_ratio_idc value: "
            r1.append(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r1.append(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            java.lang.String r0 = "NalUnitUtil"
            java.lang.String r1 = r1.toString()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            com.google.android.gms.internal.ads.zzdw.zze(r0, r1)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
        L_0x0367:
            r1 = 1065353216(0x3f800000, float:1.0)
        L_0x0369:
            boolean r0 = r8.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r0 == 0) goto L_0x0372
            r8.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
        L_0x0372:
            boolean r0 = r8.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r0 == 0) goto L_0x0387
            r0 = 4
            r8.zze(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            boolean r0 = r8.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r0 == 0) goto L_0x0387
            r0 = 24
            r8.zze(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
        L_0x0387:
            boolean r0 = r8.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r0 == 0) goto L_0x0393
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
        L_0x0393:
            r8.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            boolean r0 = r8.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            if (r0 == 0) goto L_0x03a1
            int r25 = r25 + r25
            goto L_0x03a1
        L_0x039f:
            r1 = 1065353216(0x3f800000, float:1.0)
        L_0x03a1:
            r23 = r15
            java.lang.String r17 = com.google.android.gms.internal.ads.zzdf.zzb(r19, r20, r21, r22, r23, r24)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r16 = r1
            r15 = r25
            r14 = r27
            r0 = 0
            r6 = 0
            goto L_0x03bf
        L_0x03b0:
            r32 = r1
            r31 = r3
            r33 = r4
            r34 = r7
            r35 = r10
            r26 = r12
            r28 = r13
            r0 = 0
        L_0x03bf:
            int r11 = r11 + r9
            r1 = r39
            r1.zzG(r9)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r2 = 1
            int r6 = r6 + r2
            r0 = r1
            r12 = r26
            r13 = r28
            r3 = r31
            r1 = r32
            r4 = r33
            r7 = r34
            r10 = r35
            r2 = 3
            r5 = 0
            r8 = 1
            goto L_0x0050
        L_0x03db:
            r32 = r1
            r31 = r3
            r33 = r4
            r34 = r7
            r35 = r10
            r1 = r0
            r0 = 0
            int r10 = r35 + 1
            r0 = r1
            r1 = r32
            r2 = 3
            r5 = 0
            r8 = 1
            goto L_0x0043
        L_0x03f1:
            r32 = r1
            r33 = r4
            r34 = r7
            if (r34 != 0) goto L_0x03fe
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            goto L_0x0402
        L_0x03fe:
            java.util.List r0 = java.util.Collections.singletonList(r33)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
        L_0x0402:
            r12 = r0
            com.google.android.gms.internal.ads.zzzy r0 = new com.google.android.gms.internal.ads.zzzy     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            r1 = 1
            int r13 = r32 + 1
            r11 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x040d }
            return r0
        L_0x040d:
            r0 = move-exception
            java.lang.String r1 = "Error parsing HEVC config"
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zza(r1, r0)
            goto L_0x0416
        L_0x0415:
            throw r0
        L_0x0416:
            goto L_0x0415
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzy.zza(com.google.android.gms.internal.ads.zzef):com.google.android.gms.internal.ads.zzzy");
    }
}
