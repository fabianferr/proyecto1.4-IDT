package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzayk {
    private int zza = 1000;
    private int[] zzb = new int[1000];
    private long[] zzc = new long[1000];
    private int[] zzd = new int[1000];
    private int[] zze = new int[1000];
    private long[] zzf = new long[1000];
    private zzavh[] zzg = new zzavh[1000];
    private zzasw[] zzh = new zzasw[1000];
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm = Long.MIN_VALUE;
    private long zzn = Long.MIN_VALUE;
    private boolean zzo = true;
    private boolean zzp = true;
    private zzasw zzq;

    public final int zza() {
        return this.zzj + this.zzi;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001f, code lost:
        return -3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int zzb(com.google.android.gms.internal.ads.zzasx r5, com.google.android.gms.internal.ads.zzaur r6, boolean r7, boolean r8, com.google.android.gms.internal.ads.zzasw r9, com.google.android.gms.internal.ads.zzayj r10) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.zzl()     // Catch:{ all -> 0x0091 }
            r1 = -5
            r2 = -3
            r3 = -4
            if (r0 != 0) goto L_0x0020
            if (r8 == 0) goto L_0x0012
            r5 = 4
            r6.zzc(r5)     // Catch:{ all -> 0x0091 }
            monitor-exit(r4)
            return r3
        L_0x0012:
            com.google.android.gms.internal.ads.zzasw r6 = r4.zzq     // Catch:{ all -> 0x0091 }
            if (r6 == 0) goto L_0x001e
            if (r7 != 0) goto L_0x001a
            if (r6 == r9) goto L_0x001e
        L_0x001a:
            r5.zza = r6     // Catch:{ all -> 0x0091 }
            monitor-exit(r4)
            return r1
        L_0x001e:
            monitor-exit(r4)
            return r2
        L_0x0020:
            if (r7 != 0) goto L_0x0087
            com.google.android.gms.internal.ads.zzasw[] r7 = r4.zzh     // Catch:{ all -> 0x0091 }
            int r8 = r4.zzk     // Catch:{ all -> 0x0091 }
            r7 = r7[r8]     // Catch:{ all -> 0x0091 }
            if (r7 == r9) goto L_0x002b
            goto L_0x0087
        L_0x002b:
            java.nio.ByteBuffer r5 = r6.zzb     // Catch:{ all -> 0x0091 }
            if (r5 == 0) goto L_0x0085
            long[] r5 = r4.zzf     // Catch:{ all -> 0x0091 }
            r0 = r5[r8]     // Catch:{ all -> 0x0091 }
            r6.zzc = r0     // Catch:{ all -> 0x0091 }
            int[] r5 = r4.zze     // Catch:{ all -> 0x0091 }
            r5 = r5[r8]     // Catch:{ all -> 0x0091 }
            r6.zzc(r5)     // Catch:{ all -> 0x0091 }
            int[] r5 = r4.zzd     // Catch:{ all -> 0x0091 }
            int r7 = r4.zzk     // Catch:{ all -> 0x0091 }
            r5 = r5[r7]     // Catch:{ all -> 0x0091 }
            r10.zza = r5     // Catch:{ all -> 0x0091 }
            long[] r5 = r4.zzc     // Catch:{ all -> 0x0091 }
            r8 = r5[r7]     // Catch:{ all -> 0x0091 }
            r10.zzb = r8     // Catch:{ all -> 0x0091 }
            com.google.android.gms.internal.ads.zzavh[] r5 = r4.zzg     // Catch:{ all -> 0x0091 }
            r5 = r5[r7]     // Catch:{ all -> 0x0091 }
            r10.zzd = r5     // Catch:{ all -> 0x0091 }
            long r7 = r4.zzm     // Catch:{ all -> 0x0091 }
            long r5 = r6.zzc     // Catch:{ all -> 0x0091 }
            long r5 = java.lang.Math.max(r7, r5)     // Catch:{ all -> 0x0091 }
            r4.zzm = r5     // Catch:{ all -> 0x0091 }
            int r5 = r4.zzi     // Catch:{ all -> 0x0091 }
            int r5 = r5 + -1
            r4.zzi = r5     // Catch:{ all -> 0x0091 }
            int r6 = r4.zzk     // Catch:{ all -> 0x0091 }
            int r6 = r6 + 1
            r4.zzk = r6     // Catch:{ all -> 0x0091 }
            int r7 = r4.zzj     // Catch:{ all -> 0x0091 }
            int r7 = r7 + 1
            r4.zzj = r7     // Catch:{ all -> 0x0091 }
            int r7 = r4.zza     // Catch:{ all -> 0x0091 }
            if (r6 != r7) goto L_0x0073
            r6 = 0
            r4.zzk = r6     // Catch:{ all -> 0x0091 }
        L_0x0073:
            if (r5 <= 0) goto L_0x007a
            long[] r5 = r4.zzc     // Catch:{ all -> 0x0091 }
            r6 = r5[r6]     // Catch:{ all -> 0x0091 }
            goto L_0x0081
        L_0x007a:
            long r5 = r10.zzb     // Catch:{ all -> 0x0091 }
            int r7 = r10.zza     // Catch:{ all -> 0x0091 }
            long r7 = (long) r7     // Catch:{ all -> 0x0091 }
            long r5 = r5 + r7
            r6 = r5
        L_0x0081:
            r10.zzc = r6     // Catch:{ all -> 0x0091 }
            monitor-exit(r4)
            return r3
        L_0x0085:
            monitor-exit(r4)
            return r2
        L_0x0087:
            com.google.android.gms.internal.ads.zzasw[] r6 = r4.zzh     // Catch:{ all -> 0x0091 }
            int r7 = r4.zzk     // Catch:{ all -> 0x0091 }
            r6 = r6[r7]     // Catch:{ all -> 0x0091 }
            r5.zza = r6     // Catch:{ all -> 0x0091 }
            monitor-exit(r4)
            return r1
        L_0x0091:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayk.zzb(com.google.android.gms.internal.ads.zzasx, com.google.android.gms.internal.ads.zzaur, boolean, boolean, com.google.android.gms.internal.ads.zzasw, com.google.android.gms.internal.ads.zzayj):int");
    }

    public final synchronized long zzc() {
        return Math.max(this.zzm, this.zzn);
    }

    public final synchronized long zzd() {
        if (!zzl()) {
            return -1;
        }
        int i = this.zzk;
        int i2 = this.zzi;
        int i3 = i + i2;
        int i4 = this.zza;
        int i5 = (i3 - 1) % i4;
        this.zzk = i3 % i4;
        this.zzj += i2;
        this.zzi = 0;
        return this.zzc[i5] + ((long) this.zzd[i5]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005d, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long zze(long r10, boolean r12) {
        /*
            r9 = this;
            monitor-enter(r9)
            boolean r0 = r9.zzl()     // Catch:{ all -> 0x005e }
            r1 = -1
            if (r0 == 0) goto L_0x005c
            long[] r0 = r9.zzf     // Catch:{ all -> 0x005e }
            int r3 = r9.zzk     // Catch:{ all -> 0x005e }
            r4 = r0[r3]     // Catch:{ all -> 0x005e }
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0014
            goto L_0x005c
        L_0x0014:
            long r4 = r9.zzn     // Catch:{ all -> 0x005e }
            r0 = 0
            r6 = -1
            int r7 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r7 <= 0) goto L_0x0021
            if (r12 == 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            monitor-exit(r9)
            return r1
        L_0x0021:
            r12 = -1
        L_0x0022:
            int r4 = r9.zzl     // Catch:{ all -> 0x005e }
            if (r3 == r4) goto L_0x0040
            long[] r4 = r9.zzf     // Catch:{ all -> 0x005e }
            r7 = r4[r3]     // Catch:{ all -> 0x005e }
            int r4 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r4 <= 0) goto L_0x002f
            goto L_0x0040
        L_0x002f:
            int[] r4 = r9.zze     // Catch:{ all -> 0x005e }
            r4 = r4[r3]     // Catch:{ all -> 0x005e }
            r5 = 1
            r4 = r4 & r5
            if (r5 != r4) goto L_0x0038
            r12 = r0
        L_0x0038:
            int r3 = r3 + 1
            int r4 = r9.zza     // Catch:{ all -> 0x005e }
            int r3 = r3 % r4
            int r0 = r0 + 1
            goto L_0x0022
        L_0x0040:
            if (r12 != r6) goto L_0x0044
            monitor-exit(r9)
            return r1
        L_0x0044:
            int r10 = r9.zzk     // Catch:{ all -> 0x005e }
            int r10 = r10 + r12
            int r11 = r9.zza     // Catch:{ all -> 0x005e }
            int r10 = r10 % r11
            r9.zzk = r10     // Catch:{ all -> 0x005e }
            int r11 = r9.zzj     // Catch:{ all -> 0x005e }
            int r11 = r11 + r12
            r9.zzj = r11     // Catch:{ all -> 0x005e }
            int r11 = r9.zzi     // Catch:{ all -> 0x005e }
            int r11 = r11 - r12
            r9.zzi = r11     // Catch:{ all -> 0x005e }
            long[] r11 = r9.zzc     // Catch:{ all -> 0x005e }
            r10 = r11[r10]     // Catch:{ all -> 0x005e }
            monitor-exit(r9)
            return r10
        L_0x005c:
            monitor-exit(r9)
            return r1
        L_0x005e:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x0062
        L_0x0061:
            throw r10
        L_0x0062:
            goto L_0x0061
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayk.zze(long, boolean):long");
    }

    public final synchronized zzasw zzf() {
        if (this.zzp) {
            return null;
        }
        return this.zzq;
    }

    public final void zzg() {
        this.zzj = 0;
        this.zzk = 0;
        this.zzl = 0;
        this.zzi = 0;
        this.zzo = true;
    }

    public final synchronized void zzh(long j, int i, long j2, int i2, zzavh zzavh) {
        if (this.zzo) {
            if ((i & 1) != 0) {
                this.zzo = false;
            } else {
                return;
            }
        }
        zzbac.zze(!this.zzp);
        zzi(j);
        long[] jArr = this.zzf;
        int i3 = this.zzl;
        jArr[i3] = j;
        long[] jArr2 = this.zzc;
        jArr2[i3] = j2;
        this.zzd[i3] = i2;
        this.zze[i3] = i;
        this.zzg[i3] = zzavh;
        this.zzh[i3] = this.zzq;
        this.zzb[i3] = 0;
        int i4 = this.zzi + 1;
        this.zzi = i4;
        int i5 = this.zza;
        if (i4 == i5) {
            int i6 = i5 + 1000;
            int[] iArr = new int[i6];
            long[] jArr3 = new long[i6];
            long[] jArr4 = new long[i6];
            int[] iArr2 = new int[i6];
            int[] iArr3 = new int[i6];
            zzavh[] zzavhArr = new zzavh[i6];
            zzasw[] zzaswArr = new zzasw[i6];
            int i7 = this.zzk;
            int i8 = i5 - i7;
            System.arraycopy(jArr2, i7, jArr3, 0, i8);
            System.arraycopy(this.zzf, this.zzk, jArr4, 0, i8);
            System.arraycopy(this.zze, this.zzk, iArr2, 0, i8);
            System.arraycopy(this.zzd, this.zzk, iArr3, 0, i8);
            System.arraycopy(this.zzg, this.zzk, zzavhArr, 0, i8);
            System.arraycopy(this.zzh, this.zzk, zzaswArr, 0, i8);
            System.arraycopy(this.zzb, this.zzk, iArr, 0, i8);
            int i9 = this.zzk;
            System.arraycopy(this.zzc, 0, jArr3, i8, i9);
            System.arraycopy(this.zzf, 0, jArr4, i8, i9);
            System.arraycopy(this.zze, 0, iArr2, i8, i9);
            System.arraycopy(this.zzd, 0, iArr3, i8, i9);
            System.arraycopy(this.zzg, 0, zzavhArr, i8, i9);
            System.arraycopy(this.zzh, 0, zzaswArr, i8, i9);
            System.arraycopy(this.zzb, 0, iArr, i8, i9);
            this.zzc = jArr3;
            this.zzf = jArr4;
            this.zze = iArr2;
            this.zzd = iArr3;
            this.zzg = zzavhArr;
            this.zzh = zzaswArr;
            this.zzb = iArr;
            this.zzk = 0;
            int i10 = this.zza;
            this.zzl = i10;
            this.zzi = i10;
            this.zza = i6;
            return;
        }
        int i11 = i3 + 1;
        this.zzl = i11;
        if (i11 == i5) {
            this.zzl = 0;
        }
    }

    public final synchronized void zzi(long j) {
        this.zzn = Math.max(this.zzn, j);
    }

    public final void zzj() {
        this.zzm = Long.MIN_VALUE;
        this.zzn = Long.MIN_VALUE;
    }

    public final synchronized boolean zzk(zzasw zzasw) {
        if (zzasw == null) {
            this.zzp = true;
            return false;
        }
        this.zzp = false;
        if (zzbar.zzo(zzasw, this.zzq)) {
            return false;
        }
        this.zzq = zzasw;
        return true;
    }

    public final synchronized boolean zzl() {
        return this.zzi != 0;
    }
}