package com.google.android.gms.internal.atv_ads_framework;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
final class zzal extends zzae {
    static final zzae zza = new zzal((Object) null, new Object[0], 0);
    final transient Object[] zzb;
    @CheckForNull
    private final transient Object zzc;
    private final transient int zzd;

    private zzal(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: short[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: short[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: short[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: short[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.atv_ads_framework.zzal zzf(int r17, java.lang.Object[] r18, com.google.android.gms.internal.atv_ads_framework.zzad r19) {
        /*
            r0 = r17
            r1 = r18
            if (r0 != 0) goto L_0x000b
            com.google.android.gms.internal.atv_ads_framework.zzae r0 = zza
            com.google.android.gms.internal.atv_ads_framework.zzal r0 = (com.google.android.gms.internal.atv_ads_framework.zzal) r0
            return r0
        L_0x000b:
            r2 = 0
            r3 = 0
            r4 = 1
            if (r0 != r4) goto L_0x0023
            r0 = r1[r3]
            r0.getClass()
            r3 = r1[r4]
            r3.getClass()
            com.google.android.gms.internal.atv_ads_framework.zzw.zza(r0, r3)
            com.google.android.gms.internal.atv_ads_framework.zzal r0 = new com.google.android.gms.internal.atv_ads_framework.zzal
            r0.<init>(r2, r1, r4)
            return r0
        L_0x0023:
            int r5 = r1.length
            int r5 = r5 >> r4
            java.lang.String r6 = "index"
            com.google.android.gms.internal.atv_ads_framework.zzn.zzb(r0, r5, r6)
            r5 = 2
            int r6 = java.lang.Math.max(r0, r5)
            r7 = 751619276(0x2ccccccc, float:5.8207657E-12)
            if (r6 >= r7) goto L_0x004c
            int r7 = r6 + -1
            int r7 = java.lang.Integer.highestOneBit(r7)
        L_0x003a:
            int r7 = r7 + r7
            double r8 = (double) r7
            r10 = 4604480259023595110(0x3fe6666666666666, double:0.7)
            java.lang.Double.isNaN(r8)
            double r8 = r8 * r10
            double r10 = (double) r6
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 >= 0) goto L_0x0050
            goto L_0x003a
        L_0x004c:
            r7 = 1073741824(0x40000000, float:2.0)
            if (r6 >= r7) goto L_0x01d3
        L_0x0050:
            if (r0 != r4) goto L_0x0061
            r6 = r1[r3]
            r6.getClass()
            r7 = r1[r4]
            r7.getClass()
            com.google.android.gms.internal.atv_ads_framework.zzw.zza(r6, r7)
            goto L_0x01a9
        L_0x0061:
            int r6 = r7 + -1
            r8 = 128(0x80, float:1.794E-43)
            r9 = 3
            r10 = -1
            if (r7 > r8) goto L_0x00d6
            byte[] r7 = new byte[r7]
            java.util.Arrays.fill(r7, r10)
            r8 = 0
            r10 = 0
        L_0x0070:
            if (r8 >= r0) goto L_0x00c1
            int r11 = r10 + r10
            int r12 = r8 + r8
            r13 = r1[r12]
            r13.getClass()
            r12 = r12 ^ r4
            r12 = r1[r12]
            r12.getClass()
            com.google.android.gms.internal.atv_ads_framework.zzw.zza(r13, r12)
            int r14 = r13.hashCode()
            int r14 = com.google.android.gms.internal.atv_ads_framework.zzx.zza(r14)
        L_0x008c:
            r14 = r14 & r6
            byte r15 = r7[r14]
            r5 = 255(0xff, float:3.57E-43)
            r15 = r15 & r5
            if (r15 != r5) goto L_0x00a2
            byte r5 = (byte) r11
            r7[r14] = r5
            if (r10 >= r8) goto L_0x009f
            r1[r11] = r13
            r5 = r11 ^ 1
            r1[r5] = r12
        L_0x009f:
            int r10 = r10 + 1
            goto L_0x00b9
        L_0x00a2:
            r5 = r1[r15]
            boolean r5 = r13.equals(r5)
            if (r5 == 0) goto L_0x00bd
            r2 = r15 ^ 1
            com.google.android.gms.internal.atv_ads_framework.zzac r5 = new com.google.android.gms.internal.atv_ads_framework.zzac
            r11 = r1[r2]
            r11.getClass()
            r5.<init>(r13, r12, r11)
            r1[r2] = r12
            r2 = r5
        L_0x00b9:
            int r8 = r8 + 1
            r5 = 2
            goto L_0x0070
        L_0x00bd:
            int r14 = r14 + 1
            r5 = 2
            goto L_0x008c
        L_0x00c1:
            if (r10 != r0) goto L_0x00c5
            r2 = r7
            goto L_0x00d3
        L_0x00c5:
            java.lang.Object[] r5 = new java.lang.Object[r9]
            r5[r3] = r7
            java.lang.Integer r6 = java.lang.Integer.valueOf(r10)
            r5[r4] = r6
            r6 = 2
            r5[r6] = r2
        L_0x00d2:
            r2 = r5
        L_0x00d3:
            r5 = 2
            goto L_0x01a9
        L_0x00d6:
            r5 = 32768(0x8000, float:4.5918E-41)
            if (r7 > r5) goto L_0x0143
            short[] r5 = new short[r7]
            java.util.Arrays.fill(r5, r10)
            r7 = 0
            r8 = 0
        L_0x00e2:
            if (r7 >= r0) goto L_0x0132
            int r10 = r8 + r8
            int r11 = r7 + r7
            r12 = r1[r11]
            r12.getClass()
            r11 = r11 ^ r4
            r11 = r1[r11]
            r11.getClass()
            com.google.android.gms.internal.atv_ads_framework.zzw.zza(r12, r11)
            int r13 = r12.hashCode()
            int r13 = com.google.android.gms.internal.atv_ads_framework.zzx.zza(r13)
        L_0x00fe:
            r13 = r13 & r6
            short r14 = r5[r13]
            char r14 = (char) r14
            r15 = 65535(0xffff, float:9.1834E-41)
            if (r14 != r15) goto L_0x0115
            short r14 = (short) r10
            r5[r13] = r14
            if (r8 >= r7) goto L_0x0112
            r1[r10] = r12
            r10 = r10 ^ 1
            r1[r10] = r11
        L_0x0112:
            int r8 = r8 + 1
            goto L_0x012c
        L_0x0115:
            r15 = r1[r14]
            boolean r15 = r12.equals(r15)
            if (r15 == 0) goto L_0x012f
            r2 = r14 ^ 1
            com.google.android.gms.internal.atv_ads_framework.zzac r10 = new com.google.android.gms.internal.atv_ads_framework.zzac
            r13 = r1[r2]
            r13.getClass()
            r10.<init>(r12, r11, r13)
            r1[r2] = r11
            r2 = r10
        L_0x012c:
            int r7 = r7 + 1
            goto L_0x00e2
        L_0x012f:
            int r13 = r13 + 1
            goto L_0x00fe
        L_0x0132:
            if (r8 != r0) goto L_0x0135
            goto L_0x0199
        L_0x0135:
            java.lang.Object[] r6 = new java.lang.Object[r9]
            r6[r3] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
            r6[r4] = r5
            r5 = 2
            r6[r5] = r2
            goto L_0x01a8
        L_0x0143:
            int[] r5 = new int[r7]
            java.util.Arrays.fill(r5, r10)
            r7 = 0
            r8 = 0
        L_0x014a:
            if (r7 >= r0) goto L_0x0197
            int r11 = r8 + r8
            int r12 = r7 + r7
            r13 = r1[r12]
            r13.getClass()
            r12 = r12 ^ r4
            r12 = r1[r12]
            r12.getClass()
            com.google.android.gms.internal.atv_ads_framework.zzw.zza(r13, r12)
            int r14 = r13.hashCode()
            int r14 = com.google.android.gms.internal.atv_ads_framework.zzx.zza(r14)
        L_0x0166:
            r14 = r14 & r6
            r15 = r5[r14]
            if (r15 != r10) goto L_0x0178
            r5[r14] = r11
            if (r8 >= r7) goto L_0x0175
            r1[r11] = r13
            r11 = r11 ^ 1
            r1[r11] = r12
        L_0x0175:
            int r8 = r8 + 1
            goto L_0x018f
        L_0x0178:
            r10 = r1[r15]
            boolean r10 = r13.equals(r10)
            if (r10 == 0) goto L_0x0193
            r2 = r15 ^ 1
            com.google.android.gms.internal.atv_ads_framework.zzac r10 = new com.google.android.gms.internal.atv_ads_framework.zzac
            r11 = r1[r2]
            r11.getClass()
            r10.<init>(r13, r12, r11)
            r1[r2] = r12
            r2 = r10
        L_0x018f:
            int r7 = r7 + 1
            r10 = -1
            goto L_0x014a
        L_0x0193:
            int r14 = r14 + 1
            r10 = -1
            goto L_0x0166
        L_0x0197:
            if (r8 != r0) goto L_0x019b
        L_0x0199:
            goto L_0x00d2
        L_0x019b:
            java.lang.Object[] r6 = new java.lang.Object[r9]
            r6[r3] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
            r6[r4] = r5
            r5 = 2
            r6[r5] = r2
        L_0x01a8:
            r2 = r6
        L_0x01a9:
            boolean r6 = r2 instanceof java.lang.Object[]
            if (r6 == 0) goto L_0x01cd
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            r0 = r2[r5]
            com.google.android.gms.internal.atv_ads_framework.zzac r0 = (com.google.android.gms.internal.atv_ads_framework.zzac) r0
            r5 = r19
            r5.zzc = r0
            r0 = r2[r3]
            r2 = r2[r4]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            int r3 = r2 + r2
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r3)
            r16 = r2
            r2 = r0
            r0 = r16
        L_0x01cd:
            com.google.android.gms.internal.atv_ads_framework.zzal r3 = new com.google.android.gms.internal.atv_ads_framework.zzal
            r3.<init>(r2, r1, r0)
            return r3
        L_0x01d3:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "collection too large"
            r0.<init>(r1)
            goto L_0x01dc
        L_0x01db:
            throw r0
        L_0x01dc:
            goto L_0x01db
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.atv_ads_framework.zzal.zzf(int, java.lang.Object[], com.google.android.gms.internal.atv_ads_framework.zzad):com.google.android.gms.internal.atv_ads_framework.zzal");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x009e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009f A[RETURN] */
    @javax.annotation.CheckForNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object get(@javax.annotation.CheckForNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.zzc
            java.lang.Object[] r1 = r9.zzb
            int r2 = r9.zzd
            r3 = 0
            if (r10 != 0) goto L_0x000c
        L_0x0009:
            r10 = r3
            goto L_0x009c
        L_0x000c:
            r4 = 1
            if (r2 != r4) goto L_0x0022
            r0 = 0
            r0 = r1[r0]
            r0.getClass()
            boolean r10 = r0.equals(r10)
            if (r10 == 0) goto L_0x0009
            r10 = r1[r4]
            r10.getClass()
            goto L_0x009c
        L_0x0022:
            if (r0 != 0) goto L_0x0025
            goto L_0x0009
        L_0x0025:
            boolean r2 = r0 instanceof byte[]
            r5 = -1
            if (r2 == 0) goto L_0x0051
            r2 = r0
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            int r6 = r0 + -1
            int r0 = r10.hashCode()
            int r0 = com.google.android.gms.internal.atv_ads_framework.zzx.zza(r0)
        L_0x0038:
            r0 = r0 & r6
            byte r5 = r2[r0]
            r7 = 255(0xff, float:3.57E-43)
            r5 = r5 & r7
            if (r5 != r7) goto L_0x0041
            goto L_0x0009
        L_0x0041:
            r7 = r1[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x004e
            r10 = r5 ^ 1
            r10 = r1[r10]
            goto L_0x009c
        L_0x004e:
            int r0 = r0 + 1
            goto L_0x0038
        L_0x0051:
            boolean r2 = r0 instanceof short[]
            if (r2 == 0) goto L_0x007d
            r2 = r0
            short[] r2 = (short[]) r2
            int r0 = r2.length
            int r6 = r0 + -1
            int r0 = r10.hashCode()
            int r0 = com.google.android.gms.internal.atv_ads_framework.zzx.zza(r0)
        L_0x0063:
            r0 = r0 & r6
            short r5 = r2[r0]
            char r5 = (char) r5
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r5 != r7) goto L_0x006d
            goto L_0x0009
        L_0x006d:
            r7 = r1[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x007a
            r10 = r5 ^ 1
            r10 = r1[r10]
            goto L_0x009c
        L_0x007a:
            int r0 = r0 + 1
            goto L_0x0063
        L_0x007d:
            int[] r0 = (int[]) r0
            int r2 = r0.length
            int r2 = r2 + r5
            int r6 = r10.hashCode()
            int r6 = com.google.android.gms.internal.atv_ads_framework.zzx.zza(r6)
        L_0x0089:
            r6 = r6 & r2
            r7 = r0[r6]
            if (r7 != r5) goto L_0x0090
            goto L_0x0009
        L_0x0090:
            r8 = r1[r7]
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto L_0x00a0
            r10 = r7 ^ 1
            r10 = r1[r10]
        L_0x009c:
            if (r10 != 0) goto L_0x009f
            return r3
        L_0x009f:
            return r10
        L_0x00a0:
            int r6 = r6 + 1
            goto L_0x0089
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.atv_ads_framework.zzal.get(java.lang.Object):java.lang.Object");
    }

    public final int size() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final zzy zza() {
        return new zzak(this.zzb, 1, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final zzaf zzc() {
        return new zzai(this, this.zzb, 0, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final zzaf zzd() {
        return new zzaj(this, new zzak(this.zzb, 0, this.zzd));
    }
}
