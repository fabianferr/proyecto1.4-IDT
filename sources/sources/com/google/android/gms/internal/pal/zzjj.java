package com.google.android.gms.internal.pal;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-pal@@20.0.1 */
final class zzjj extends zzjc {
    static final zzjc zza = new zzjj((Object) null, new Object[0], 0);
    final transient Object[] zzb;
    @CheckForNull
    private final transient Object zzc;
    private final transient int zzd;

    private zzjj(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: short[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: short[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: short[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: short[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.pal.zzjj zzk(int r16, java.lang.Object[] r17, com.google.android.gms.internal.pal.zzjb r18) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            if (r0 != 0) goto L_0x000d
            com.google.android.gms.internal.pal.zzjc r0 = zza
            com.google.android.gms.internal.pal.zzjj r0 = (com.google.android.gms.internal.pal.zzjj) r0
            return r0
        L_0x000d:
            r3 = 0
            r4 = 0
            r5 = 1
            if (r0 != r5) goto L_0x0025
            r0 = r1[r4]
            r0.getClass()
            r2 = r1[r5]
            r2.getClass()
            com.google.android.gms.internal.pal.zziu.zza(r0, r2)
            com.google.android.gms.internal.pal.zzjj r0 = new com.google.android.gms.internal.pal.zzjj
            r0.<init>(r3, r1, r5)
            return r0
        L_0x0025:
            int r6 = r1.length
            int r6 = r6 >> r5
            java.lang.String r7 = "index"
            com.google.android.gms.internal.pal.zzip.zzb(r0, r6, r7)
            r6 = 2
            int r7 = java.lang.Math.max(r0, r6)
            r8 = 751619276(0x2ccccccc, float:5.8207657E-12)
            if (r7 >= r8) goto L_0x004e
            int r8 = r7 + -1
            int r8 = java.lang.Integer.highestOneBit(r8)
        L_0x003c:
            int r8 = r8 + r8
            double r9 = (double) r8
            r11 = 4604480259023595110(0x3fe6666666666666, double:0.7)
            java.lang.Double.isNaN(r9)
            double r9 = r9 * r11
            double r11 = (double) r7
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0052
            goto L_0x003c
        L_0x004e:
            r8 = 1073741824(0x40000000, float:2.0)
            if (r7 >= r8) goto L_0x01e2
        L_0x0052:
            if (r0 != r5) goto L_0x0065
            r7 = r1[r4]
            r7.getClass()
            r8 = r1[r5]
            r8.getClass()
            com.google.android.gms.internal.pal.zziu.zza(r7, r8)
        L_0x0061:
            r5 = 2
        L_0x0062:
            r7 = 1
            goto L_0x01b5
        L_0x0065:
            int r7 = r8 + -1
            r9 = 128(0x80, float:1.794E-43)
            r10 = 3
            r11 = -1
            if (r8 > r9) goto L_0x00db
            byte[] r8 = new byte[r8]
            java.util.Arrays.fill(r8, r11)
            r9 = 0
            r11 = 0
        L_0x0074:
            if (r9 >= r0) goto L_0x00c7
            int r12 = r9 + r9
            int r13 = r11 + r11
            r14 = r1[r12]
            r14.getClass()
            r12 = r12 ^ r5
            r12 = r1[r12]
            r12.getClass()
            com.google.android.gms.internal.pal.zziu.zza(r14, r12)
            int r15 = r14.hashCode()
            int r15 = com.google.android.gms.internal.pal.zziv.zza(r15)
        L_0x0090:
            r15 = r15 & r7
            byte r6 = r8[r15]
            r5 = 255(0xff, float:3.57E-43)
            r6 = r6 & r5
            if (r6 != r5) goto L_0x00a6
            byte r5 = (byte) r13
            r8[r15] = r5
            if (r11 >= r9) goto L_0x00a3
            r1[r13] = r14
            r5 = r13 ^ 1
            r1[r5] = r12
        L_0x00a3:
            int r11 = r11 + 1
            goto L_0x00bd
        L_0x00a6:
            r5 = r1[r6]
            boolean r5 = r14.equals(r5)
            if (r5 == 0) goto L_0x00c2
            r3 = r6 ^ 1
            com.google.android.gms.internal.pal.zzja r5 = new com.google.android.gms.internal.pal.zzja
            r6 = r1[r3]
            r6.getClass()
            r5.<init>(r14, r12, r6)
            r1[r3] = r12
            r3 = r5
        L_0x00bd:
            int r9 = r9 + 1
            r5 = 1
            r6 = 2
            goto L_0x0074
        L_0x00c2:
            int r15 = r15 + 1
            r5 = 1
            r6 = 2
            goto L_0x0090
        L_0x00c7:
            if (r11 != r0) goto L_0x00cb
            r3 = r8
            goto L_0x0061
        L_0x00cb:
            java.lang.Object[] r5 = new java.lang.Object[r10]
            r5[r4] = r8
            java.lang.Integer r6 = java.lang.Integer.valueOf(r11)
            r7 = 1
            r5[r7] = r6
            r6 = 2
            r5[r6] = r3
        L_0x00d9:
            r3 = r5
            goto L_0x0061
        L_0x00db:
            r5 = 32768(0x8000, float:4.5918E-41)
            if (r8 > r5) goto L_0x014c
            short[] r5 = new short[r8]
            java.util.Arrays.fill(r5, r11)
            r6 = 0
            r8 = 0
        L_0x00e7:
            if (r6 >= r0) goto L_0x0138
            int r9 = r6 + r6
            int r11 = r8 + r8
            r12 = r1[r9]
            r12.getClass()
            r13 = 1
            r9 = r9 ^ r13
            r9 = r1[r9]
            r9.getClass()
            com.google.android.gms.internal.pal.zziu.zza(r12, r9)
            int r13 = r12.hashCode()
            int r13 = com.google.android.gms.internal.pal.zziv.zza(r13)
        L_0x0104:
            r13 = r13 & r7
            short r14 = r5[r13]
            char r14 = (char) r14
            r15 = 65535(0xffff, float:9.1834E-41)
            if (r14 != r15) goto L_0x011b
            short r14 = (short) r11
            r5[r13] = r14
            if (r8 >= r6) goto L_0x0118
            r1[r11] = r12
            r11 = r11 ^ 1
            r1[r11] = r9
        L_0x0118:
            int r8 = r8 + 1
            goto L_0x0132
        L_0x011b:
            r15 = r1[r14]
            boolean r15 = r12.equals(r15)
            if (r15 == 0) goto L_0x0135
            r3 = r14 ^ 1
            com.google.android.gms.internal.pal.zzja r11 = new com.google.android.gms.internal.pal.zzja
            r13 = r1[r3]
            r13.getClass()
            r11.<init>(r12, r9, r13)
            r1[r3] = r9
            r3 = r11
        L_0x0132:
            int r6 = r6 + 1
            goto L_0x00e7
        L_0x0135:
            int r13 = r13 + 1
            goto L_0x0104
        L_0x0138:
            if (r8 != r0) goto L_0x013b
            goto L_0x01a4
        L_0x013b:
            java.lang.Object[] r6 = new java.lang.Object[r10]
            r6[r4] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
            r9 = 1
            r6[r9] = r5
            r5 = 2
            r6[r5] = r3
            r3 = r6
            goto L_0x0062
        L_0x014c:
            r9 = 1
            int[] r5 = new int[r8]
            java.util.Arrays.fill(r5, r11)
            r6 = 0
            r8 = 0
        L_0x0154:
            if (r6 >= r0) goto L_0x01a2
            int r12 = r6 + r6
            int r13 = r8 + r8
            r14 = r1[r12]
            r14.getClass()
            r12 = r12 ^ r9
            r9 = r1[r12]
            r9.getClass()
            com.google.android.gms.internal.pal.zziu.zza(r14, r9)
            int r12 = r14.hashCode()
            int r12 = com.google.android.gms.internal.pal.zziv.zza(r12)
        L_0x0170:
            r12 = r12 & r7
            r15 = r5[r12]
            if (r15 != r11) goto L_0x0182
            r5[r12] = r13
            if (r8 >= r6) goto L_0x017f
            r1[r13] = r14
            r12 = r13 ^ 1
            r1[r12] = r9
        L_0x017f:
            int r8 = r8 + 1
            goto L_0x0199
        L_0x0182:
            r11 = r1[r15]
            boolean r11 = r14.equals(r11)
            if (r11 == 0) goto L_0x019e
            r3 = r15 ^ 1
            com.google.android.gms.internal.pal.zzja r11 = new com.google.android.gms.internal.pal.zzja
            r12 = r1[r3]
            r12.getClass()
            r11.<init>(r14, r9, r12)
            r1[r3] = r9
            r3 = r11
        L_0x0199:
            int r6 = r6 + 1
            r9 = 1
            r11 = -1
            goto L_0x0154
        L_0x019e:
            int r12 = r12 + 1
            r11 = -1
            goto L_0x0170
        L_0x01a2:
            if (r8 != r0) goto L_0x01a6
        L_0x01a4:
            goto L_0x00d9
        L_0x01a6:
            java.lang.Object[] r6 = new java.lang.Object[r10]
            r6[r4] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
            r7 = 1
            r6[r7] = r5
            r5 = 2
            r6[r5] = r3
            r3 = r6
        L_0x01b5:
            boolean r6 = r3 instanceof java.lang.Object[]
            if (r6 == 0) goto L_0x01dc
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            r0 = r3[r5]
            com.google.android.gms.internal.pal.zzja r0 = (com.google.android.gms.internal.pal.zzja) r0
            if (r2 == 0) goto L_0x01d7
            r2.zzc = r0
            r0 = r3[r4]
            r2 = r3[r7]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            int r3 = r2 + r2
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r3)
            r3 = r0
            r0 = r2
            goto L_0x01dc
        L_0x01d7:
            java.lang.IllegalArgumentException r0 = r0.zza()
            throw r0
        L_0x01dc:
            com.google.android.gms.internal.pal.zzjj r2 = new com.google.android.gms.internal.pal.zzjj
            r2.<init>(r3, r1, r0)
            return r2
        L_0x01e2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "collection too large"
            r0.<init>(r1)
            goto L_0x01eb
        L_0x01ea:
            throw r0
        L_0x01eb:
            goto L_0x01ea
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzjj.zzk(int, java.lang.Object[], com.google.android.gms.internal.pal.zzjb):com.google.android.gms.internal.pal.zzjj");
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
            int r0 = com.google.android.gms.internal.pal.zziv.zza(r0)
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
            int r0 = com.google.android.gms.internal.pal.zziv.zza(r0)
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
            int r6 = com.google.android.gms.internal.pal.zziv.zza(r6)
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzjj.get(java.lang.Object):java.lang.Object");
    }

    public final int size() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final zziw zza() {
        return new zzji(this.zzb, 1, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final zzjd zzg() {
        return new zzjg(this, this.zzb, 0, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final zzjd zzh() {
        return new zzjh(this, new zzji(this.zzb, 0, this.zzd));
    }
}
