package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzahe implements zzahc {
    private static final double[] zza = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private String zzb;
    private zzaap zzc;
    private final zzair zzd;
    private final zzef zze;
    private final zzahr zzf;
    private final boolean[] zzg;
    private final zzahd zzh;
    private long zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;
    private boolean zzq;

    public zzahe() {
        this((zzair) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x018f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzef r20) {
        /*
            r19 = this;
            r0 = r19
            com.google.android.gms.internal.ads.zzaap r1 = r0.zzc
            com.google.android.gms.internal.ads.zzdd.zzb(r1)
            int r1 = r20.zzc()
            int r2 = r20.zzd()
            byte[] r3 = r20.zzH()
            long r4 = r0.zzi
            int r6 = r20.zza()
            long r6 = (long) r6
            long r4 = r4 + r6
            r0.zzi = r4
            com.google.android.gms.internal.ads.zzaap r4 = r0.zzc
            int r5 = r20.zza()
            r6 = r20
            r4.zzq(r6, r5)
        L_0x0028:
            boolean[] r4 = r0.zzg
            int r4 = com.google.android.gms.internal.ads.zzaaf.zza(r3, r1, r2, r4)
            if (r4 != r2) goto L_0x0041
            boolean r4 = r0.zzk
            if (r4 != 0) goto L_0x0039
            com.google.android.gms.internal.ads.zzahd r4 = r0.zzh
            r4.zza(r3, r1, r2)
        L_0x0039:
            com.google.android.gms.internal.ads.zzahr r4 = r0.zzf
            if (r4 == 0) goto L_0x0040
            r4.zza(r3, r1, r2)
        L_0x0040:
            return
        L_0x0041:
            int r5 = r4 + 3
            byte[] r7 = r20.zzH()
            byte r7 = r7[r5]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r8 = r4 - r1
            boolean r9 = r0.zzk
            if (r9 != 0) goto L_0x0136
            if (r8 <= 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzahd r9 = r0.zzh
            r9.zza(r3, r1, r4)
        L_0x0058:
            if (r8 >= 0) goto L_0x005c
            int r9 = -r8
            goto L_0x005d
        L_0x005c:
            r9 = 0
        L_0x005d:
            com.google.android.gms.internal.ads.zzahd r12 = r0.zzh
            boolean r9 = r12.zzc(r7, r9)
            if (r9 == 0) goto L_0x0136
            com.google.android.gms.internal.ads.zzahd r9 = r0.zzh
            java.lang.String r12 = r0.zzb
            r12.getClass()
            byte[] r13 = r9.zzc
            int r14 = r9.zza
            byte[] r13 = java.util.Arrays.copyOf(r13, r14)
            r14 = 4
            byte r15 = r13[r14]
            r16 = 5
            byte r10 = r13[r16]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r14
            int r17 = r10 >> 4
            r15 = r15 | r17
            r10 = r10 & 15
            r11 = 8
            int r10 = r10 << r11
            r18 = 6
            byte r11 = r13[r18]
            r11 = r11 & 255(0xff, float:3.57E-43)
            r10 = r10 | r11
            r11 = 7
            byte r14 = r13[r11]
            r14 = r14 & 240(0xf0, float:3.36E-43)
            r11 = 4
            int r14 = r14 >> r11
            r11 = 2
            if (r14 == r11) goto L_0x00af
            r11 = 3
            if (r14 == r11) goto L_0x00a9
            r11 = 4
            if (r14 == r11) goto L_0x00a3
            r11 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00b6
        L_0x00a3:
            int r11 = r10 * 121
            float r11 = (float) r11
            int r14 = r15 * 100
            goto L_0x00b4
        L_0x00a9:
            int r11 = r10 * 16
            float r11 = (float) r11
            int r14 = r15 * 9
            goto L_0x00b4
        L_0x00af:
            int r11 = r10 * 4
            float r11 = (float) r11
            int r14 = r15 * 3
        L_0x00b4:
            float r14 = (float) r14
            float r11 = r11 / r14
        L_0x00b6:
            com.google.android.gms.internal.ads.zzad r14 = new com.google.android.gms.internal.ads.zzad
            r14.<init>()
            r14.zzH(r12)
            java.lang.String r12 = "video/mpeg2"
            r14.zzS(r12)
            r14.zzX(r15)
            r14.zzF(r10)
            r14.zzP(r11)
            java.util.List r10 = java.util.Collections.singletonList(r13)
            r14.zzI(r10)
            com.google.android.gms.internal.ads.zzaf r10 = r14.zzY()
            r11 = 7
            byte r11 = r13[r11]
            r11 = r11 & 15
            int r11 = r11 + -1
            r14 = 0
            if (r11 < 0) goto L_0x0115
            r12 = 8
            if (r11 >= r12) goto L_0x0115
            double[] r12 = zza
            r11 = r12[r11]
            int r9 = r9.zzb
            int r9 = r9 + 9
            byte r9 = r13[r9]
            r13 = r9 & 96
            int r13 = r13 >> 5
            r9 = r9 & 31
            if (r13 == r9) goto L_0x010b
            double r13 = (double) r13
            r15 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            java.lang.Double.isNaN(r13)
            double r13 = r13 + r15
            int r9 = r9 + 1
            r16 = r5
            double r5 = (double) r9
            java.lang.Double.isNaN(r5)
            double r13 = r13 / r5
            double r11 = r11 * r13
            goto L_0x010d
        L_0x010b:
            r16 = r5
        L_0x010d:
            r5 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r5 = r5 / r11
            long r14 = (long) r5
            goto L_0x0117
        L_0x0115:
            r16 = r5
        L_0x0117:
            java.lang.Long r5 = java.lang.Long.valueOf(r14)
            android.util.Pair r5 = android.util.Pair.create(r10, r5)
            com.google.android.gms.internal.ads.zzaap r6 = r0.zzc
            java.lang.Object r9 = r5.first
            com.google.android.gms.internal.ads.zzaf r9 = (com.google.android.gms.internal.ads.zzaf) r9
            r6.zzk(r9)
            java.lang.Object r5 = r5.second
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            r0.zzl = r5
            r5 = 1
            r0.zzk = r5
            goto L_0x0138
        L_0x0136:
            r16 = r5
        L_0x0138:
            com.google.android.gms.internal.ads.zzahr r5 = r0.zzf
            if (r5 == 0) goto L_0x0180
            if (r8 <= 0) goto L_0x0143
            r5.zza(r3, r1, r4)
            r1 = 0
            goto L_0x0144
        L_0x0143:
            int r1 = -r8
        L_0x0144:
            com.google.android.gms.internal.ads.zzahr r5 = r0.zzf
            boolean r1 = r5.zzd(r1)
            if (r1 == 0) goto L_0x016a
            com.google.android.gms.internal.ads.zzahr r1 = r0.zzf
            byte[] r5 = r1.zza
            int r1 = r1.zzb
            int r1 = com.google.android.gms.internal.ads.zzaaf.zzb(r5, r1)
            com.google.android.gms.internal.ads.zzef r5 = r0.zze
            int r6 = com.google.android.gms.internal.ads.zzen.zza
            com.google.android.gms.internal.ads.zzahr r6 = r0.zzf
            byte[] r6 = r6.zza
            r5.zzD(r6, r1)
            com.google.android.gms.internal.ads.zzair r1 = r0.zzd
            long r5 = r0.zzo
            com.google.android.gms.internal.ads.zzef r8 = r0.zze
            r1.zza(r5, r8)
        L_0x016a:
            r1 = 178(0xb2, float:2.5E-43)
            if (r7 != r1) goto L_0x0180
            byte[] r5 = r20.zzH()
            int r6 = r4 + 2
            byte r5 = r5[r6]
            r6 = 1
            if (r5 != r6) goto L_0x017e
            com.google.android.gms.internal.ads.zzahr r5 = r0.zzf
            r5.zzc(r1)
        L_0x017e:
            r7 = 178(0xb2, float:2.5E-43)
        L_0x0180:
            if (r7 == 0) goto L_0x018f
            r1 = 179(0xb3, float:2.51E-43)
            if (r7 != r1) goto L_0x0187
            goto L_0x018f
        L_0x0187:
            r1 = 184(0xb8, float:2.58E-43)
            if (r7 != r1) goto L_0x01ea
            r1 = 1
            r0.zzp = r1
            goto L_0x01ea
        L_0x018f:
            int r1 = r2 - r4
            boolean r4 = r0.zzq
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == 0) goto L_0x01b5
            boolean r4 = r0.zzk
            if (r4 == 0) goto L_0x01b5
            long r9 = r0.zzo
            int r4 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r4 == 0) goto L_0x01b5
            boolean r11 = r0.zzp
            long r12 = r0.zzi
            long r14 = r0.zzn
            com.google.android.gms.internal.ads.zzaap r8 = r0.zzc
            long r12 = r12 - r14
            int r4 = (int) r12
            int r12 = r4 - r1
            r14 = 0
            r13 = r1
            r8.zzs(r9, r11, r12, r13, r14)
        L_0x01b5:
            boolean r4 = r0.zzj
            if (r4 == 0) goto L_0x01c1
            boolean r4 = r0.zzq
            if (r4 == 0) goto L_0x01be
            goto L_0x01c1
        L_0x01be:
            r1 = 0
            r4 = 1
            goto L_0x01e3
        L_0x01c1:
            long r8 = r0.zzi
            long r10 = (long) r1
            long r8 = r8 - r10
            r0.zzn = r8
            long r8 = r0.zzm
            int r1 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x01ce
            goto L_0x01d9
        L_0x01ce:
            long r8 = r0.zzo
            int r1 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x01d8
            long r10 = r0.zzl
            long r8 = r8 + r10
            goto L_0x01d9
        L_0x01d8:
            r8 = r5
        L_0x01d9:
            r0.zzo = r8
            r1 = 0
            r0.zzp = r1
            r0.zzm = r5
            r4 = 1
            r0.zzj = r4
        L_0x01e3:
            if (r7 != 0) goto L_0x01e7
            r10 = 1
            goto L_0x01e8
        L_0x01e7:
            r10 = 0
        L_0x01e8:
            r0.zzq = r10
        L_0x01ea:
            r6 = r20
            r1 = r16
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahe.zza(com.google.android.gms.internal.ads.zzef):void");
    }

    public final void zzb(zzzl zzzl, zzaio zzaio) {
        zzaio.zzc();
        this.zzb = zzaio.zzb();
        this.zzc = zzzl.zzv(zzaio.zza(), 2);
        zzair zzair = this.zzd;
        if (zzair != null) {
            zzair.zzb(zzzl, zzaio);
        }
    }

    public final void zzc() {
    }

    public final void zzd(long j, int i) {
        this.zzm = j;
    }

    public final void zze() {
        zzaaf.zze(this.zzg);
        this.zzh.zzb();
        zzahr zzahr = this.zzf;
        if (zzahr != null) {
            zzahr.zzb();
        }
        this.zzi = 0;
        this.zzj = false;
        this.zzm = -9223372036854775807L;
        this.zzo = -9223372036854775807L;
    }

    zzahe(zzair zzair) {
        zzef zzef;
        this.zzd = zzair;
        this.zzg = new boolean[4];
        this.zzh = new zzahd(128);
        if (zzair != null) {
            this.zzf = new zzahr(178, 128);
            zzef = new zzef();
        } else {
            zzef = null;
            this.zzf = null;
        }
        this.zze = zzef;
        this.zzm = -9223372036854775807L;
        this.zzo = -9223372036854775807L;
    }
}
