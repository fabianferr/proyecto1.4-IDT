package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzahh implements zzahc {
    private static final float[] zza = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    private final zzair zzb;
    private final zzef zzc;
    private final boolean[] zzd;
    private final zzahf zze;
    private final zzahr zzf;
    private zzahg zzg;
    private long zzh;
    private String zzi;
    private zzaap zzj;
    private boolean zzk;
    private long zzl;

    public zzahh() {
        this((zzair) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01ce A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzef r19) {
        /*
            r18 = this;
            r0 = r18
            com.google.android.gms.internal.ads.zzahg r1 = r0.zzg
            com.google.android.gms.internal.ads.zzdd.zzb(r1)
            com.google.android.gms.internal.ads.zzaap r1 = r0.zzj
            com.google.android.gms.internal.ads.zzdd.zzb(r1)
            int r1 = r19.zzc()
            int r2 = r19.zzd()
            byte[] r3 = r19.zzH()
            long r4 = r0.zzh
            int r6 = r19.zza()
            long r6 = (long) r6
            long r4 = r4 + r6
            r0.zzh = r4
            com.google.android.gms.internal.ads.zzaap r4 = r0.zzj
            int r5 = r19.zza()
            r6 = r19
            r4.zzq(r6, r5)
        L_0x002d:
            boolean[] r4 = r0.zzd
            int r4 = com.google.android.gms.internal.ads.zzaaf.zza(r3, r1, r2, r4)
            if (r4 != r2) goto L_0x0049
            boolean r4 = r0.zzk
            if (r4 != 0) goto L_0x003e
            com.google.android.gms.internal.ads.zzahf r4 = r0.zze
            r4.zza(r3, r1, r2)
        L_0x003e:
            com.google.android.gms.internal.ads.zzahg r4 = r0.zzg
            r4.zza(r3, r1, r2)
            com.google.android.gms.internal.ads.zzahr r4 = r0.zzf
            r4.zza(r3, r1, r2)
            return
        L_0x0049:
            int r5 = r4 + 3
            byte[] r7 = r19.zzH()
            byte r7 = r7[r5]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r8 = r4 - r1
            boolean r9 = r0.zzk
            if (r9 != 0) goto L_0x0181
            if (r8 <= 0) goto L_0x0060
            com.google.android.gms.internal.ads.zzahf r9 = r0.zze
            r9.zza(r3, r1, r4)
        L_0x0060:
            if (r8 >= 0) goto L_0x0064
            int r9 = -r8
            goto L_0x0065
        L_0x0064:
            r9 = 0
        L_0x0065:
            com.google.android.gms.internal.ads.zzahf r12 = r0.zze
            boolean r9 = r12.zzc(r7, r9)
            if (r9 == 0) goto L_0x0181
            com.google.android.gms.internal.ads.zzaap r9 = r0.zzj
            com.google.android.gms.internal.ads.zzahf r12 = r0.zze
            int r13 = r12.zzb
            java.lang.String r14 = r0.zzi
            r14.getClass()
            byte[] r15 = r12.zzc
            int r12 = r12.zza
            byte[] r12 = java.util.Arrays.copyOf(r15, r12)
            com.google.android.gms.internal.ads.zzee r15 = new com.google.android.gms.internal.ads.zzee
            int r10 = r12.length
            r15.<init>(r12, r10)
            r15.zzk(r13)
            r10 = 4
            r15.zzk(r10)
            r15.zzi()
            r13 = 8
            r15.zzj(r13)
            boolean r16 = r15.zzl()
            r11 = 3
            if (r16 == 0) goto L_0x00a2
            r15.zzj(r10)
            r15.zzj(r11)
        L_0x00a2:
            int r10 = r15.zzc(r10)
            r16 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r11 = "Invalid aspect ratio"
            java.lang.String r13 = "H263Reader"
            r17 = r5
            r5 = 15
            if (r10 != r5) goto L_0x00c7
            r5 = 8
            int r10 = r15.zzc(r5)
            int r5 = r15.zzc(r5)
            if (r5 != 0) goto L_0x00c2
            com.google.android.gms.internal.ads.zzdw.zze(r13, r11)
            goto L_0x00d4
        L_0x00c2:
            float r10 = (float) r10
            float r5 = (float) r5
            float r16 = r10 / r5
            goto L_0x00ce
        L_0x00c7:
            r5 = 7
            if (r10 >= r5) goto L_0x00d1
            float[] r5 = zza
            r16 = r5[r10]
        L_0x00ce:
            r5 = r16
            goto L_0x00d6
        L_0x00d1:
            com.google.android.gms.internal.ads.zzdw.zze(r13, r11)
        L_0x00d4:
            r5 = 1065353216(0x3f800000, float:1.0)
        L_0x00d6:
            boolean r10 = r15.zzl()
            r11 = 2
            if (r10 == 0) goto L_0x0110
            r15.zzj(r11)
            r10 = 1
            r15.zzj(r10)
            boolean r10 = r15.zzl()
            if (r10 == 0) goto L_0x0110
            r10 = 15
            r15.zzj(r10)
            r15.zzi()
            r15.zzj(r10)
            r15.zzi()
            r15.zzj(r10)
            r15.zzi()
            r11 = 3
            r15.zzj(r11)
            r11 = 11
            r15.zzj(r11)
            r15.zzi()
            r15.zzj(r10)
            r15.zzi()
        L_0x0110:
            r10 = 2
            int r10 = r15.zzc(r10)
            if (r10 == 0) goto L_0x011c
            java.lang.String r10 = "Unhandled video object layer shape"
            com.google.android.gms.internal.ads.zzdw.zze(r13, r10)
        L_0x011c:
            r15.zzi()
            r10 = 16
            int r10 = r15.zzc(r10)
            r15.zzi()
            boolean r11 = r15.zzl()
            if (r11 == 0) goto L_0x0143
            if (r10 != 0) goto L_0x0136
            java.lang.String r10 = "Invalid vop_increment_time_resolution"
            com.google.android.gms.internal.ads.zzdw.zze(r13, r10)
            goto L_0x0143
        L_0x0136:
            int r10 = r10 + -1
            r11 = 0
        L_0x0139:
            if (r10 <= 0) goto L_0x0140
            int r11 = r11 + 1
            int r10 = r10 >> 1
            goto L_0x0139
        L_0x0140:
            r15.zzj(r11)
        L_0x0143:
            r15.zzi()
            r10 = 13
            int r11 = r15.zzc(r10)
            r15.zzi()
            int r10 = r15.zzc(r10)
            r15.zzi()
            r15.zzi()
            com.google.android.gms.internal.ads.zzad r13 = new com.google.android.gms.internal.ads.zzad
            r13.<init>()
            r13.zzH(r14)
            java.lang.String r14 = "video/mp4v-es"
            r13.zzS(r14)
            r13.zzX(r11)
            r13.zzF(r10)
            r13.zzP(r5)
            java.util.List r5 = java.util.Collections.singletonList(r12)
            r13.zzI(r5)
            com.google.android.gms.internal.ads.zzaf r5 = r13.zzY()
            r9.zzk(r5)
            r5 = 1
            r0.zzk = r5
            goto L_0x0183
        L_0x0181:
            r17 = r5
        L_0x0183:
            com.google.android.gms.internal.ads.zzahg r5 = r0.zzg
            r5.zza(r3, r1, r4)
            com.google.android.gms.internal.ads.zzahr r5 = r0.zzf
            if (r8 <= 0) goto L_0x0191
            r5.zza(r3, r1, r4)
            r10 = 0
            goto L_0x0192
        L_0x0191:
            int r10 = -r8
        L_0x0192:
            com.google.android.gms.internal.ads.zzahr r1 = r0.zzf
            boolean r1 = r1.zzd(r10)
            if (r1 == 0) goto L_0x01b8
            com.google.android.gms.internal.ads.zzahr r1 = r0.zzf
            byte[] r5 = r1.zza
            int r1 = r1.zzb
            int r1 = com.google.android.gms.internal.ads.zzaaf.zzb(r5, r1)
            com.google.android.gms.internal.ads.zzef r5 = r0.zzc
            int r8 = com.google.android.gms.internal.ads.zzen.zza
            com.google.android.gms.internal.ads.zzahr r8 = r0.zzf
            byte[] r8 = r8.zza
            r5.zzD(r8, r1)
            com.google.android.gms.internal.ads.zzair r1 = r0.zzb
            long r8 = r0.zzl
            com.google.android.gms.internal.ads.zzef r5 = r0.zzc
            r1.zza(r8, r5)
        L_0x01b8:
            r1 = 178(0xb2, float:2.5E-43)
            if (r7 != r1) goto L_0x01ce
            byte[] r5 = r19.zzH()
            int r7 = r4 + 2
            byte r5 = r5[r7]
            r7 = 1
            if (r5 != r7) goto L_0x01cc
            com.google.android.gms.internal.ads.zzahr r5 = r0.zzf
            r5.zzc(r1)
        L_0x01cc:
            r7 = 178(0xb2, float:2.5E-43)
        L_0x01ce:
            int r1 = r2 - r4
            long r4 = r0.zzh
            com.google.android.gms.internal.ads.zzahg r8 = r0.zzg
            long r9 = (long) r1
            long r4 = r4 - r9
            boolean r9 = r0.zzk
            r8.zzb(r4, r1, r9)
            com.google.android.gms.internal.ads.zzahg r1 = r0.zzg
            long r4 = r0.zzl
            r1.zzc(r7, r4)
            r1 = r17
            goto L_0x002d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahh.zza(com.google.android.gms.internal.ads.zzef):void");
    }

    public final void zzb(zzzl zzzl, zzaio zzaio) {
        zzaio.zzc();
        this.zzi = zzaio.zzb();
        zzaap zzv = zzzl.zzv(zzaio.zza(), 2);
        this.zzj = zzv;
        this.zzg = new zzahg(zzv);
        this.zzb.zzb(zzzl, zzaio);
    }

    public final void zzc() {
    }

    public final void zzd(long j, int i) {
        if (j != -9223372036854775807L) {
            this.zzl = j;
        }
    }

    public final void zze() {
        zzaaf.zze(this.zzd);
        this.zze.zzb();
        zzahg zzahg = this.zzg;
        if (zzahg != null) {
            zzahg.zzd();
        }
        this.zzf.zzb();
        this.zzh = 0;
        this.zzl = -9223372036854775807L;
    }

    zzahh(zzair zzair) {
        this.zzb = zzair;
        this.zzd = new boolean[4];
        this.zze = new zzahf(128);
        this.zzl = -9223372036854775807L;
        this.zzf = new zzahr(178, 128);
        this.zzc = new zzef();
    }
}
