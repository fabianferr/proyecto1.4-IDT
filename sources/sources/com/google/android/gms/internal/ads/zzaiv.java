package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaiv implements zzaiu {
    private final zzzl zza;
    private final zzaap zzb;
    private final zzaix zzc;
    private final zzaf zzd;
    private final int zze;
    private long zzf;
    private int zzg;
    private long zzh;

    public zzaiv(zzzl zzzl, zzaap zzaap, zzaix zzaix, String str, int i) throws zzbu {
        this.zza = zzzl;
        this.zzb = zzaap;
        this.zzc = zzaix;
        int i2 = (zzaix.zzb * zzaix.zze) / 8;
        int i3 = zzaix.zzd;
        if (i3 == i2) {
            int i4 = zzaix.zzc * i2;
            int i5 = i4 * 8;
            int max = Math.max(i2, i4 / 10);
            this.zze = max;
            zzad zzad = new zzad();
            zzad.zzS(str);
            zzad.zzv(i5);
            zzad.zzO(i5);
            zzad.zzL(max);
            zzad.zzw(zzaix.zzb);
            zzad.zzT(zzaix.zzc);
            zzad.zzN(i);
            this.zzd = zzad.zzY();
            return;
        }
        throw zzbu.zza("Expected block size: " + i2 + "; got: " + i3, (Throwable) null);
    }

    public final void zza(int i, long j) {
        this.zza.zzN(new zzaja(this.zzc, 1, (long) i, j));
        this.zzb.zzk(this.zzd);
    }

    public final void zzb(long j) {
        this.zzf = j;
        this.zzg = 0;
        this.zzh = 0;
    }

    public final boolean zzc(zzzj zzzj, long j) throws IOException {
        long j2;
        int i;
        int i2;
        long j3 = j;
        while (j3 > 0 && (i = this.zzg) < (i2 = this.zze)) {
            int zza2 = zzaan.zza(this.zzb, zzzj, (int) Math.min((long) (i2 - i), j3), true);
            if (zza2 == -1) {
                j3 = 0;
            } else {
                this.zzg += zza2;
                j3 -= (long) zza2;
            }
        }
        zzaix zzaix = this.zzc;
        int i3 = zzaix.zzd;
        int i4 = this.zzg / i3;
        if (i4 > 0) {
            long j4 = this.zzf;
            long zzw = zzen.zzw(this.zzh, 1000000, (long) zzaix.zzc);
            int i5 = i4 * i3;
            int i6 = this.zzg - i5;
            this.zzb.zzs(j4 + zzw, 1, i5, i6, (zzaao) null);
            this.zzh += (long) i4;
            this.zzg = i6;
            j2 = 0;
        } else {
            j2 = 0;
        }
        return j3 <= j2;
    }
}
