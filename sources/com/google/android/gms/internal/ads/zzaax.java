package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaax implements zzzi {
    public static final zzzp zza = zzaaw.zza;
    private static final int[] zzb = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final int[] zzc;
    private static final byte[] zzd = zzen.zzaa("#!AMR\n");
    private static final byte[] zze = zzen.zzaa("#!AMR-WB\n");
    private static final int zzf;
    private final byte[] zzg;
    private boolean zzh;
    private long zzi;
    private int zzj;
    private int zzk;
    private boolean zzl;
    private int zzm;
    private int zzn;
    private long zzo;
    private zzzl zzp;
    private zzaap zzq;
    private zzaal zzr;
    private boolean zzs;

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        zzc = iArr;
        zzf = iArr[8];
    }

    public zzaax() {
        this(0);
    }

    public zzaax(int i) {
        this.zzg = new byte[1];
        this.zzm = -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003d A[Catch:{ EOFException -> 0x008b }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042 A[Catch:{ EOFException -> 0x008b }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0054  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"trackOutput"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zze(com.google.android.gms.internal.ads.zzzj r14) throws java.io.IOException {
        /*
            r13 = this;
            java.lang.String r0 = "Illegal AMR "
            java.lang.String r1 = "Invalid padding bits for frame header "
            int r2 = r13.zzk
            r3 = -1
            r4 = 1
            r5 = 0
            if (r2 != 0) goto L_0x008c
            r14.zzj()     // Catch:{ EOFException -> 0x008b }
            byte[] r2 = r13.zzg     // Catch:{ EOFException -> 0x008b }
            r6 = r14
            com.google.android.gms.internal.ads.zzyy r6 = (com.google.android.gms.internal.ads.zzyy) r6     // Catch:{ EOFException -> 0x008b }
            r6.zzm(r2, r5, r4, r5)     // Catch:{ EOFException -> 0x008b }
            byte[] r2 = r13.zzg     // Catch:{ EOFException -> 0x008b }
            byte r2 = r2[r5]     // Catch:{ EOFException -> 0x008b }
            r6 = r2 & 131(0x83, float:1.84E-43)
            r7 = 0
            if (r6 > 0) goto L_0x007a
            int r1 = r2 >> 3
            r1 = r1 & 15
            boolean r2 = r13.zzh     // Catch:{ EOFException -> 0x008b }
            if (r2 == 0) goto L_0x0030
            r6 = 10
            if (r1 < r6) goto L_0x003b
            r6 = 13
            if (r1 <= r6) goto L_0x0030
            goto L_0x003b
        L_0x0030:
            if (r2 != 0) goto L_0x005a
            r6 = 12
            if (r1 < r6) goto L_0x003b
            r6 = 14
            if (r1 > r6) goto L_0x003b
            goto L_0x005a
        L_0x003b:
            if (r2 == 0) goto L_0x0042
            int[] r0 = zzc     // Catch:{ EOFException -> 0x008b }
            r0 = r0[r1]     // Catch:{ EOFException -> 0x008b }
            goto L_0x0046
        L_0x0042:
            int[] r0 = zzb     // Catch:{ EOFException -> 0x008b }
            r0 = r0[r1]     // Catch:{ EOFException -> 0x008b }
        L_0x0046:
            r2 = r0
            r13.zzj = r2     // Catch:{ EOFException -> 0x008b }
            r13.zzk = r2
            int r0 = r13.zzm
            if (r0 != r3) goto L_0x0052
            r13.zzm = r2
            r0 = r2
        L_0x0052:
            if (r0 != r2) goto L_0x008c
            int r0 = r13.zzn
            int r0 = r0 + r4
            r13.zzn = r0
            goto L_0x008c
        L_0x005a:
            java.lang.String r14 = "WB"
            java.lang.String r5 = "NB"
            if (r4 == r2) goto L_0x0061
            r14 = r5
        L_0x0061:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x008b }
            r2.<init>(r0)     // Catch:{ EOFException -> 0x008b }
            r2.append(r14)     // Catch:{ EOFException -> 0x008b }
            java.lang.String r14 = " frame type "
            r2.append(r14)     // Catch:{ EOFException -> 0x008b }
            r2.append(r1)     // Catch:{ EOFException -> 0x008b }
            java.lang.String r14 = r2.toString()     // Catch:{ EOFException -> 0x008b }
            com.google.android.gms.internal.ads.zzbu r14 = com.google.android.gms.internal.ads.zzbu.zza(r14, r7)     // Catch:{ EOFException -> 0x008b }
            throw r14     // Catch:{ EOFException -> 0x008b }
        L_0x007a:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x008b }
            r14.<init>(r1)     // Catch:{ EOFException -> 0x008b }
            r14.append(r2)     // Catch:{ EOFException -> 0x008b }
            java.lang.String r14 = r14.toString()     // Catch:{ EOFException -> 0x008b }
            com.google.android.gms.internal.ads.zzbu r14 = com.google.android.gms.internal.ads.zzbu.zza(r14, r7)     // Catch:{ EOFException -> 0x008b }
            throw r14     // Catch:{ EOFException -> 0x008b }
        L_0x008b:
            return r3
        L_0x008c:
            com.google.android.gms.internal.ads.zzaap r0 = r13.zzq
            int r14 = com.google.android.gms.internal.ads.zzaan.zza(r0, r14, r2, r4)
            if (r14 != r3) goto L_0x0095
            return r3
        L_0x0095:
            int r0 = r13.zzk
            int r0 = r0 - r14
            r13.zzk = r0
            if (r0 <= 0) goto L_0x009d
            return r5
        L_0x009d:
            com.google.android.gms.internal.ads.zzaap r6 = r13.zzq
            long r7 = r13.zzi
            r9 = 1
            int r10 = r13.zzj
            r11 = 0
            r12 = 0
            r6.zzs(r7, r9, r10, r11, r12)
            long r0 = r13.zzi
            r2 = 20000(0x4e20, double:9.8813E-320)
            long r0 = r0 + r2
            r13.zzi = r0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaax.zze(com.google.android.gms.internal.ads.zzzj):int");
    }

    private static boolean zzf(zzzj zzzj, byte[] bArr) throws IOException {
        zzzj.zzj();
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        ((zzyy) zzzj).zzm(bArr2, 0, length, false);
        return Arrays.equals(bArr2, bArr);
    }

    private final boolean zzg(zzzj zzzj) throws IOException {
        byte[] bArr = zzd;
        if (zzf(zzzj, bArr)) {
            this.zzh = false;
            ((zzyy) zzzj).zzo(bArr.length, false);
            return true;
        }
        byte[] bArr2 = zze;
        if (!zzf(zzzj, bArr2)) {
            return false;
        }
        this.zzh = true;
        ((zzyy) zzzj).zzo(bArr2.length, false);
        return true;
    }

    public final int zza(zzzj zzzj, zzaai zzaai) throws IOException {
        zzdd.zzb(this.zzq);
        int i = zzen.zza;
        if (zzzj.zzf() != 0 || zzg(zzzj)) {
            if (!this.zzs) {
                this.zzs = true;
                boolean z = this.zzh;
                String str = true != z ? "audio/3gpp" : "audio/amr-wb";
                int i2 = true != z ? 8000 : 16000;
                zzaap zzaap = this.zzq;
                zzad zzad = new zzad();
                zzad.zzS(str);
                zzad.zzL(zzf);
                zzad.zzw(1);
                zzad.zzT(i2);
                zzaap.zzk(zzad.zzY());
            }
            int zze2 = zze(zzzj);
            if (this.zzl) {
                return zze2;
            }
            zzaak zzaak = new zzaak(-9223372036854775807L, 0);
            this.zzr = zzaak;
            this.zzp.zzN(zzaak);
            this.zzl = true;
            return zze2;
        }
        throw zzbu.zza("Could not find AMR header.", (Throwable) null);
    }

    public final void zzb(zzzl zzzl) {
        this.zzp = zzzl;
        this.zzq = zzzl.zzv(0, 1);
        zzzl.zzC();
    }

    public final void zzc(long j, long j2) {
        this.zzi = 0;
        this.zzj = 0;
        this.zzk = 0;
        this.zzo = 0;
    }

    public final boolean zzd(zzzj zzzj) throws IOException {
        return zzg(zzzj);
    }
}
