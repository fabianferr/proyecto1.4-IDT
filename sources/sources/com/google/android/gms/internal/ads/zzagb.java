package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzagb implements zzagi {
    private final zzagh zza;
    /* access modifiers changed from: private */
    public final long zzb;
    /* access modifiers changed from: private */
    public final long zzc;
    /* access modifiers changed from: private */
    public final zzagn zzd;
    private int zze;
    /* access modifiers changed from: private */
    public long zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;

    public zzagb(zzagn zzagn, long j, long j2, long j3, long j4, boolean z) {
        zzdd.zzd(j >= 0 && j2 > j);
        this.zzd = zzagn;
        this.zzb = j;
        this.zzc = j2;
        if (j3 == j2 - j || z) {
            this.zzf = j4;
            this.zze = 4;
        } else {
            this.zze = 0;
        }
        this.zza = new zzagh();
    }

    public final /* bridge */ /* synthetic */ zzaal zze() {
        if (this.zzf != 0) {
            return new zzaga(this, (zzafz) null);
        }
        return null;
    }

    public final void zzg(long j) {
        this.zzh = zzen.zzr(j, 0, -1 + this.zzf);
        this.zze = 2;
        this.zzi = this.zzb;
        this.zzj = this.zzc;
        this.zzk = 0;
        this.zzl = this.zzf;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00aa A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzd(com.google.android.gms.internal.ads.zzzj r25) throws java.io.IOException {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            int r2 = r0.zze
            r3 = 1
            r5 = 0
            r6 = -1
            if (r2 == 0) goto L_0x00eb
            if (r2 == r3) goto L_0x00fe
            r3 = 2
            r10 = 3
            if (r2 == r3) goto L_0x0015
            if (r2 == r10) goto L_0x00ae
            return r6
        L_0x0015:
            long r2 = r0.zzi
            long r11 = r0.zzj
            int r13 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r13 != 0) goto L_0x0020
        L_0x001d:
            r11 = r6
            goto L_0x00a6
        L_0x0020:
            long r2 = r25.zzf()
            com.google.android.gms.internal.ads.zzagh r13 = r0.zza
            boolean r11 = r13.zzc(r1, r11)
            if (r11 != 0) goto L_0x003c
            long r11 = r0.zzi
            int r13 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x0034
            goto L_0x00a6
        L_0x0034:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "No ogg page can be found."
            r1.<init>(r2)
            throw r1
        L_0x003c:
            com.google.android.gms.internal.ads.zzagh r11 = r0.zza
            r11.zzb(r1, r5)
            r25.zzj()
            long r11 = r0.zzh
            com.google.android.gms.internal.ads.zzagh r13 = r0.zza
            long r14 = r13.zzb
            long r11 = r11 - r14
            int r8 = r13.zzd
            int r9 = r13.zze
            int r8 = r8 + r9
            r16 = 0
            int r9 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r9 < 0) goto L_0x005e
            r18 = 72000(0x11940, double:3.55727E-319)
            int r9 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r9 >= 0) goto L_0x005e
            goto L_0x001d
        L_0x005e:
            int r9 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r9 >= 0) goto L_0x0067
            r0.zzj = r2
            r0.zzl = r14
            goto L_0x0071
        L_0x0067:
            long r2 = r25.zzf()
            long r4 = (long) r8
            long r2 = r2 + r4
            r0.zzi = r2
            r0.zzk = r14
        L_0x0071:
            long r2 = r0.zzj
            long r4 = r0.zzi
            long r14 = r2 - r4
            r18 = 100000(0x186a0, double:4.94066E-319)
            int r20 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r20 >= 0) goto L_0x0082
            r0.zzj = r4
            r11 = r4
            goto L_0x00a6
        L_0x0082:
            long r9 = (long) r8
            int r8 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r8 > 0) goto L_0x008a
            r16 = 2
            goto L_0x008c
        L_0x008a:
            r16 = 1
        L_0x008c:
            long r18 = r25.zzf()
            long r9 = r9 * r16
            long r18 = r18 - r9
            long r11 = r11 * r14
            long r8 = r0.zzl
            long r14 = r0.zzk
            long r8 = r8 - r14
            long r11 = r11 / r8
            long r18 = r18 + r11
            long r22 = r2 + r6
            r20 = r4
            long r11 = com.google.android.gms.internal.ads.zzen.zzr(r18, r20, r22)
        L_0x00a6:
            int r2 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x00ab
            return r11
        L_0x00ab:
            r2 = 3
            r0.zze = r2
        L_0x00ae:
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            r2.zzc(r1, r6)
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            r3 = 0
            r2.zzb(r1, r3)
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            long r3 = r2.zzb
            long r8 = r0.zzh
            int r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r5 <= 0) goto L_0x00d0
            r25.zzj()
            r1 = 4
            r0.zze = r1
            long r1 = r0.zzk
            r4 = 2
            long r1 = r1 + r4
            long r1 = -r1
            return r1
        L_0x00d0:
            r4 = 2
            int r3 = r2.zzd
            int r2 = r2.zze
            r8 = r1
            com.google.android.gms.internal.ads.zzyy r8 = (com.google.android.gms.internal.ads.zzyy) r8
            int r3 = r3 + r2
            r2 = 0
            r8.zzo(r3, r2)
            long r2 = r25.zzf()
            r0.zzi = r2
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            long r2 = r2.zzb
            r0.zzk = r2
            goto L_0x00ae
        L_0x00eb:
            long r4 = r25.zzf()
            r0.zzg = r4
            r0.zze = r3
            long r10 = r0.zzc
            r14 = -65307(0xffffffffffff00e5, double:NaN)
            long r10 = r10 + r14
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x00fe
            return r10
        L_0x00fe:
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            r2.zza()
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            boolean r2 = r2.zzc(r1, r6)
            if (r2 == 0) goto L_0x015d
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            r4 = 0
            r2.zzb(r1, r4)
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            int r5 = r2.zzd
            int r2 = r2.zze
            r8 = r1
            com.google.android.gms.internal.ads.zzyy r8 = (com.google.android.gms.internal.ads.zzyy) r8
            int r5 = r5 + r2
            r8.zzo(r5, r4)
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            long r4 = r2.zzb
        L_0x0122:
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            int r8 = r2.zza
            r9 = 4
            r8 = r8 & r9
            if (r8 == r9) goto L_0x0155
            boolean r2 = r2.zzc(r1, r6)
            if (r2 == 0) goto L_0x0155
            long r10 = r25.zzf()
            long r12 = r0.zzc
            int r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r2 >= 0) goto L_0x0155
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            boolean r2 = r2.zzb(r1, r3)
            if (r2 == 0) goto L_0x0155
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            int r8 = r2.zzd
            int r2 = r2.zze
            int r8 = r8 + r2
            boolean r2 = com.google.android.gms.internal.ads.zzzm.zze(r1, r8)
            if (r2 != 0) goto L_0x0150
            goto L_0x0155
        L_0x0150:
            com.google.android.gms.internal.ads.zzagh r2 = r0.zza
            long r4 = r2.zzb
            goto L_0x0122
        L_0x0155:
            r0.zzf = r4
            r1 = 4
            r0.zze = r1
            long r1 = r0.zzg
            return r1
        L_0x015d:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            goto L_0x0164
        L_0x0163:
            throw r1
        L_0x0164:
            goto L_0x0163
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagb.zzd(com.google.android.gms.internal.ads.zzzj):long");
    }
}
