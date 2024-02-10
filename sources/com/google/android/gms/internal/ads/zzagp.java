package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzagp extends zzagn {
    private zzago zza;
    private int zzb;
    private boolean zzc;
    private zzaau zzd;
    private zzaas zze;

    zzagp() {
    }

    /* access modifiers changed from: protected */
    public final long zza(zzef zzef) {
        int i;
        int i2 = 0;
        if ((zzef.zzH()[0] & 1) == 1) {
            return -1;
        }
        byte b = zzef.zzH()[0];
        zzago zzago = this.zza;
        zzdd.zzb(zzago);
        if (!zzago.zzd[(b >> 1) & (255 >>> (8 - zzago.zze))].zza) {
            i = zzago.zza.zze;
        } else {
            i = zzago.zza.zzf;
        }
        if (this.zzc) {
            i2 = (this.zzb + i) / 4;
        }
        long j = (long) i2;
        if (zzef.zzb() < zzef.zzd() + 4) {
            byte[] copyOf = Arrays.copyOf(zzef.zzH(), zzef.zzd() + 4);
            zzef.zzD(copyOf, copyOf.length);
        } else {
            zzef.zzE(zzef.zzd() + 4);
        }
        byte[] zzH = zzef.zzH();
        zzH[zzef.zzd() - 4] = (byte) ((int) (j & 255));
        zzH[zzef.zzd() - 3] = (byte) ((int) ((j >>> 8) & 255));
        zzH[zzef.zzd() - 2] = (byte) ((int) ((j >>> 16) & 255));
        zzH[zzef.zzd() - 1] = (byte) ((int) ((j >>> 24) & 255));
        this.zzc = true;
        this.zzb = i;
        return j;
    }

    /* access modifiers changed from: protected */
    public final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    /* access modifiers changed from: protected */
    public final void zzi(long j) {
        super.zzi(j);
        int i = 0;
        this.zzc = j != 0;
        zzaau zzaau = this.zzd;
        if (zzaau != null) {
            i = zzaau.zze;
        }
        this.zzb = i;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x03f8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x03fa  */
    @org.checkerframework.checker.nullness.qual.EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzc(com.google.android.gms.internal.ads.zzef r26, long r27, com.google.android.gms.internal.ads.zzagk r29) throws java.io.IOException {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r29
            com.google.android.gms.internal.ads.zzago r3 = r0.zza
            r4 = 0
            if (r3 == 0) goto L_0x0011
            com.google.android.gms.internal.ads.zzaf r1 = r2.zza
            r1.getClass()
            return r4
        L_0x0011:
            com.google.android.gms.internal.ads.zzaau r6 = r0.zzd
            r5 = 4
            r11 = 1
            if (r6 != 0) goto L_0x0084
            com.google.android.gms.internal.ads.zzaav.zzd(r11, r1, r4)
            int r13 = r26.zzh()
            int r14 = r26.zzk()
            int r15 = r26.zzh()
            int r6 = r26.zzg()
            if (r6 > 0) goto L_0x002f
            r16 = -1
            goto L_0x0031
        L_0x002f:
            r16 = r6
        L_0x0031:
            int r6 = r26.zzg()
            if (r6 > 0) goto L_0x003a
            r17 = -1
            goto L_0x003c
        L_0x003a:
            r17 = r6
        L_0x003c:
            int r6 = r26.zzg()
            if (r6 > 0) goto L_0x0045
            r18 = -1
            goto L_0x0047
        L_0x0045:
            r18 = r6
        L_0x0047:
            int r3 = r26.zzk()
            r6 = r3 & 15
            double r8 = (double) r6
            r11 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r8 = java.lang.Math.pow(r11, r8)
            int r6 = (int) r8
            r3 = r3 & 240(0xf0, float:3.36E-43)
            int r3 = r3 >> r5
            double r8 = (double) r3
            double r8 = java.lang.Math.pow(r11, r8)
            int r3 = (int) r8
            int r5 = r26.zzk()
            byte[] r8 = r26.zzH()
            int r1 = r26.zzd()
            byte[] r22 = java.util.Arrays.copyOf(r8, r1)
            com.google.android.gms.internal.ads.zzaau r1 = new com.google.android.gms.internal.ads.zzaau
            r8 = 1
            r5 = r5 & r8
            if (r8 == r5) goto L_0x0077
            r21 = 0
            goto L_0x0079
        L_0x0077:
            r21 = 1
        L_0x0079:
            r12 = r1
            r19 = r6
            r20 = r3
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0.zzd = r1
            goto L_0x008f
        L_0x0084:
            com.google.android.gms.internal.ads.zzaas r8 = r0.zze
            if (r8 != 0) goto L_0x0092
            r9 = 1
            com.google.android.gms.internal.ads.zzaas r1 = com.google.android.gms.internal.ads.zzaav.zzc(r1, r9, r9)
            r0.zze = r1
        L_0x008f:
            r7 = 0
            goto L_0x03f4
        L_0x0092:
            int r9 = r26.zzd()
            byte[] r9 = new byte[r9]
            byte[] r10 = r26.zzH()
            int r11 = r26.zzd()
            java.lang.System.arraycopy(r10, r4, r9, r4, r11)
            int r10 = r6.zza
            r11 = 5
            com.google.android.gms.internal.ads.zzaav.zzd(r11, r1, r4)
            int r12 = r26.zzk()
            r13 = 1
            int r12 = r12 + r13
            com.google.android.gms.internal.ads.zzaar r13 = new com.google.android.gms.internal.ads.zzaar
            byte[] r14 = r26.zzH()
            r13.<init>(r14)
            int r1 = r26.zzc()
            r14 = 8
            int r1 = r1 * 8
            r13.zzc(r1)
            r1 = 0
        L_0x00c4:
            r15 = 24
            r3 = 16
            if (r1 >= r12) goto L_0x01dc
            int r14 = r13.zzb(r15)
            r7 = 5653314(0x564342, float:7.92198E-39)
            if (r14 != r7) goto L_0x01c4
            int r3 = r13.zzb(r3)
            int r7 = r13.zzb(r15)
            long[] r14 = new long[r7]
            boolean r15 = r13.zzd()
            r18 = 0
            if (r15 != 0) goto L_0x0122
            boolean r15 = r13.zzd()
            r4 = 0
        L_0x00ea:
            if (r4 >= r7) goto L_0x011f
            if (r15 == 0) goto L_0x010a
            boolean r21 = r13.zzd()
            if (r21 == 0) goto L_0x0102
            int r21 = r13.zzb(r11)
            r22 = 1
            int r5 = r21 + 1
            r23 = r12
            long r11 = (long) r5
            r14[r4] = r11
            goto L_0x0108
        L_0x0102:
            r23 = r12
            r22 = 1
            r14[r4] = r18
        L_0x0108:
            r5 = 5
            goto L_0x0118
        L_0x010a:
            r23 = r12
            r5 = 5
            r22 = 1
            int r11 = r13.zzb(r5)
            int r11 = r11 + 1
            long r11 = (long) r11
            r14[r4] = r11
        L_0x0118:
            int r4 = r4 + 1
            r12 = r23
            r5 = 4
            r11 = 5
            goto L_0x00ea
        L_0x011f:
            r23 = r12
            goto L_0x015a
        L_0x0122:
            r23 = r12
            r5 = 5
            r22 = 1
            int r4 = r13.zzb(r5)
            int r4 = r4 + 1
            r5 = 0
        L_0x012e:
            if (r5 >= r7) goto L_0x015a
            int r11 = r7 - r5
            int r11 = com.google.android.gms.internal.ads.zzaav.zza(r11)
            int r11 = r13.zzb(r11)
            r12 = 0
        L_0x013b:
            if (r12 >= r11) goto L_0x014f
            if (r5 >= r7) goto L_0x014f
            r22 = r8
            r24 = r9
            long r8 = (long) r4
            r14[r5] = r8
            int r5 = r5 + 1
            int r12 = r12 + 1
            r8 = r22
            r9 = r24
            goto L_0x013b
        L_0x014f:
            r22 = r8
            r24 = r9
            int r4 = r4 + 1
            r8 = r22
            r9 = r24
            goto L_0x012e
        L_0x015a:
            r22 = r8
            r24 = r9
            r4 = 4
            int r5 = r13.zzb(r4)
            r8 = 2
            if (r5 > r8) goto L_0x01b0
            r9 = 1
            if (r5 == r9) goto L_0x016c
            if (r5 != r8) goto L_0x01a1
            r5 = 2
        L_0x016c:
            r8 = 32
            r13.zzc(r8)
            r13.zzc(r8)
            int r8 = r13.zzb(r4)
            int r8 = r8 + r9
            r13.zzc(r9)
            if (r5 != r9) goto L_0x0196
            if (r3 == 0) goto L_0x019a
            long r4 = (long) r7
            double r4 = (double) r4
            long r11 = (long) r3
            double r11 = (double) r11
            r14 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            java.lang.Double.isNaN(r11)
            double r14 = r14 / r11
            double r3 = java.lang.Math.pow(r4, r14)
            double r3 = java.lang.Math.floor(r3)
            long r3 = (long) r3
            r18 = r3
            goto L_0x019a
        L_0x0196:
            long r4 = (long) r7
            long r11 = (long) r3
            long r18 = r4 * r11
        L_0x019a:
            long r3 = (long) r8
            long r3 = r3 * r18
            int r4 = (int) r3
            r13.zzc(r4)
        L_0x01a1:
            int r1 = r1 + 1
            r8 = r22
            r12 = r23
            r9 = r24
            r4 = 0
            r5 = 4
            r11 = 5
            r14 = 8
            goto L_0x00c4
        L_0x01b0:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "lookup type greater than 2 not decodable: "
            r1.<init>(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x01c4:
            r2 = 0
            int r1 = r13.zza()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "expected code book to start with [0x56, 0x43, 0x42] at "
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x01dc:
            r22 = r8
            r24 = r9
            r1 = 6
            int r4 = r13.zzb(r1)
            r5 = 1
            int r4 = r4 + r5
            r5 = 0
        L_0x01e8:
            if (r5 >= r4) goto L_0x01fb
            int r7 = r13.zzb(r3)
            if (r7 != 0) goto L_0x01f3
            int r5 = r5 + 1
            goto L_0x01e8
        L_0x01f3:
            java.lang.String r1 = "placeholder of time domain transforms not zeroed out"
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x01fb:
            int r4 = r13.zzb(r1)
            r5 = 1
            int r4 = r4 + r5
            r7 = 0
        L_0x0202:
            r8 = 3
            if (r7 >= r4) goto L_0x02b9
            int r9 = r13.zzb(r3)
            if (r9 == 0) goto L_0x028d
            if (r9 != r5) goto L_0x0279
            r5 = 5
            int r9 = r13.zzb(r5)
            int[] r5 = new int[r9]
            r11 = 0
            r12 = -1
        L_0x0216:
            if (r11 >= r9) goto L_0x0227
            r14 = 4
            int r15 = r13.zzb(r14)
            r5[r11] = r15
            if (r15 <= r12) goto L_0x0222
            r12 = r15
        L_0x0222:
            int r11 = r11 + 1
            r15 = 24
            goto L_0x0216
        L_0x0227:
            int r12 = r12 + 1
            int[] r11 = new int[r12]
            r14 = 0
        L_0x022c:
            if (r14 >= r12) goto L_0x025b
            int r15 = r13.zzb(r8)
            r19 = 1
            int r15 = r15 + 1
            r11[r14] = r15
            r15 = 2
            int r23 = r13.zzb(r15)
            if (r23 <= 0) goto L_0x0245
            r15 = 8
            r13.zzc(r15)
            goto L_0x0247
        L_0x0245:
            r15 = 8
        L_0x0247:
            r8 = 0
        L_0x0248:
            int r1 = r19 << r23
            if (r8 >= r1) goto L_0x0256
            r13.zzc(r15)
            int r8 = r8 + 1
            r15 = 8
            r19 = 1
            goto L_0x0248
        L_0x0256:
            int r14 = r14 + 1
            r1 = 6
            r8 = 3
            goto L_0x022c
        L_0x025b:
            r1 = 2
            r13.zzc(r1)
            r1 = 4
            int r8 = r13.zzb(r1)
            r1 = 0
            r12 = 0
            r14 = 0
        L_0x0267:
            if (r1 >= r9) goto L_0x02b1
            r15 = r5[r1]
            r15 = r11[r15]
            int r12 = r12 + r15
        L_0x026e:
            if (r14 >= r12) goto L_0x0276
            r13.zzc(r8)
            int r14 = r14 + 1
            goto L_0x026e
        L_0x0276:
            int r1 = r1 + 1
            goto L_0x0267
        L_0x0279:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "floor type greater than 1 not decodable: "
            r1.<init>(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x028d:
            r1 = 8
            r13.zzc(r1)
            r13.zzc(r3)
            r13.zzc(r3)
            r5 = 6
            r13.zzc(r5)
            r13.zzc(r1)
            r5 = 4
            int r8 = r13.zzb(r5)
            r5 = 1
            int r8 = r8 + r5
            r5 = 0
        L_0x02a7:
            if (r5 >= r8) goto L_0x02b1
            r13.zzc(r1)
            int r5 = r5 + 1
            r1 = 8
            goto L_0x02a7
        L_0x02b1:
            int r7 = r7 + 1
            r1 = 6
            r5 = 1
            r15 = 24
            goto L_0x0202
        L_0x02b9:
            int r4 = r13.zzb(r1)
            r5 = 1
            int r4 = r4 + r5
            r7 = 0
        L_0x02c0:
            if (r7 >= r4) goto L_0x032c
            int r8 = r13.zzb(r3)
            r9 = 2
            if (r8 > r9) goto L_0x0324
            r8 = 24
            r13.zzc(r8)
            r13.zzc(r8)
            r13.zzc(r8)
            int r9 = r13.zzb(r1)
            int r9 = r9 + r5
            r1 = 8
            r13.zzc(r1)
            int[] r5 = new int[r9]
            r11 = 0
        L_0x02e1:
            if (r11 >= r9) goto L_0x0300
            r12 = 3
            int r14 = r13.zzb(r12)
            boolean r15 = r13.zzd()
            if (r15 == 0) goto L_0x02f4
            r15 = 5
            int r18 = r13.zzb(r15)
            goto L_0x02f7
        L_0x02f4:
            r15 = 5
            r18 = 0
        L_0x02f7:
            int r18 = r18 * 8
            int r18 = r18 + r14
            r5[r11] = r18
            int r11 = r11 + 1
            goto L_0x02e1
        L_0x0300:
            r12 = 3
            r15 = 5
            r11 = 0
        L_0x0303:
            if (r11 >= r9) goto L_0x031f
            r14 = 0
        L_0x0306:
            if (r14 >= r1) goto L_0x031a
            r18 = r5[r11]
            r19 = 1
            int r21 = r19 << r14
            r18 = r18 & r21
            if (r18 == 0) goto L_0x0315
            r13.zzc(r1)
        L_0x0315:
            int r14 = r14 + 1
            r1 = 8
            goto L_0x0306
        L_0x031a:
            int r11 = r11 + 1
            r1 = 8
            goto L_0x0303
        L_0x031f:
            int r7 = r7 + 1
            r1 = 6
            r5 = 1
            goto L_0x02c0
        L_0x0324:
            java.lang.String r1 = "residueType greater than 2 is not decodable"
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x032c:
            int r4 = r13.zzb(r1)
            r1 = 1
            int r4 = r4 + r1
            r1 = 0
        L_0x0333:
            if (r1 >= r4) goto L_0x03b5
            int r5 = r13.zzb(r3)
            if (r5 == 0) goto L_0x0351
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "mapping type other than 0 not supported: "
            r7.<init>(r8)
            r7.append(r5)
            java.lang.String r5 = "VorbisUtil"
            java.lang.String r7 = r7.toString()
            com.google.android.gms.internal.ads.zzdw.zzb(r5, r7)
            r5 = 2
            r9 = 4
            goto L_0x03aa
        L_0x0351:
            boolean r5 = r13.zzd()
            if (r5 == 0) goto L_0x035f
            r5 = 4
            int r7 = r13.zzb(r5)
            r5 = 1
            int r7 = r7 + r5
            goto L_0x0361
        L_0x035f:
            r5 = 1
            r7 = 1
        L_0x0361:
            boolean r8 = r13.zzd()
            if (r8 == 0) goto L_0x0384
            r8 = 8
            int r9 = r13.zzb(r8)
            int r9 = r9 + r5
            r5 = 0
        L_0x036f:
            if (r5 >= r9) goto L_0x0384
            int r8 = r10 + -1
            int r11 = com.google.android.gms.internal.ads.zzaav.zza(r8)
            r13.zzc(r11)
            int r8 = com.google.android.gms.internal.ads.zzaav.zza(r8)
            r13.zzc(r8)
            int r5 = r5 + 1
            goto L_0x036f
        L_0x0384:
            r5 = 2
            int r8 = r13.zzb(r5)
            if (r8 != 0) goto L_0x03ad
            r8 = 1
            if (r7 <= r8) goto L_0x0398
            r8 = 0
        L_0x038f:
            if (r8 >= r10) goto L_0x0398
            r9 = 4
            r13.zzc(r9)
            int r8 = r8 + 1
            goto L_0x038f
        L_0x0398:
            r9 = 4
            r8 = 0
        L_0x039a:
            if (r8 >= r7) goto L_0x03aa
            r11 = 8
            r13.zzc(r11)
            r13.zzc(r11)
            r13.zzc(r11)
            int r8 = r8 + 1
            goto L_0x039a
        L_0x03aa:
            int r1 = r1 + 1
            goto L_0x0333
        L_0x03ad:
            java.lang.String r1 = "to reserved bits must be zero after mapping coupling steps"
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x03b5:
            r1 = 6
            int r1 = r13.zzb(r1)
            r4 = 1
            int r1 = r1 + r4
            com.google.android.gms.internal.ads.zzaat[] r9 = new com.google.android.gms.internal.ads.zzaat[r1]
            r4 = 0
        L_0x03bf:
            if (r4 >= r1) goto L_0x03dd
            boolean r5 = r13.zzd()
            int r7 = r13.zzb(r3)
            int r8 = r13.zzb(r3)
            r10 = 8
            int r11 = r13.zzb(r10)
            com.google.android.gms.internal.ads.zzaat r12 = new com.google.android.gms.internal.ads.zzaat
            r12.<init>(r5, r7, r8, r11)
            r9[r4] = r12
            int r4 = r4 + 1
            goto L_0x03bf
        L_0x03dd:
            boolean r3 = r13.zzd()
            if (r3 == 0) goto L_0x0443
            com.google.android.gms.internal.ads.zzago r3 = new com.google.android.gms.internal.ads.zzago
            r4 = -1
            int r1 = r1 + r4
            int r10 = com.google.android.gms.internal.ads.zzaav.zza(r1)
            r5 = r3
            r7 = r22
            r8 = r24
            r5.<init>(r6, r7, r8, r9, r10)
            r7 = r3
        L_0x03f4:
            r0.zza = r7
            if (r7 != 0) goto L_0x03fa
            r1 = 1
            return r1
        L_0x03fa:
            com.google.android.gms.internal.ads.zzaau r1 = r7.zza
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            byte[] r4 = r1.zzg
            r3.add(r4)
            byte[] r4 = r7.zzc
            r3.add(r4)
            com.google.android.gms.internal.ads.zzaas r4 = r7.zzb
            java.lang.String[] r4 = r4.zzb
            com.google.android.gms.internal.ads.zzfvn r4 = com.google.android.gms.internal.ads.zzfvn.zzn(r4)
            com.google.android.gms.internal.ads.zzbq r4 = com.google.android.gms.internal.ads.zzaav.zzb(r4)
            com.google.android.gms.internal.ads.zzad r5 = new com.google.android.gms.internal.ads.zzad
            r5.<init>()
            java.lang.String r6 = "audio/vorbis"
            r5.zzS(r6)
            int r6 = r1.zzd
            r5.zzv(r6)
            int r6 = r1.zzc
            r5.zzO(r6)
            int r6 = r1.zza
            r5.zzw(r6)
            int r1 = r1.zzb
            r5.zzT(r1)
            r5.zzI(r3)
            r5.zzM(r4)
            com.google.android.gms.internal.ads.zzaf r1 = r5.zzY()
            r2.zza = r1
            r1 = 1
            return r1
        L_0x0443:
            java.lang.String r1 = "framing bit after modes not set as expected"
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            goto L_0x044c
        L_0x044b:
            throw r1
        L_0x044c:
            goto L_0x044b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagp.zzc(com.google.android.gms.internal.ads.zzef, long, com.google.android.gms.internal.ads.zzagk):boolean");
    }
}
