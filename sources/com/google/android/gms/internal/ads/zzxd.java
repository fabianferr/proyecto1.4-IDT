package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzxd {
    private zzxc zza = new zzxc();
    private zzxc zzb = new zzxc();
    private boolean zzc;
    private long zzd = -9223372036854775807L;
    private int zze;

    public final float zza() {
        if (!this.zza.zzf()) {
            return -1.0f;
        }
        double zza2 = (double) this.zza.zza();
        Double.isNaN(zza2);
        return (float) (1.0E9d / zza2);
    }

    public final int zzb() {
        return this.zze;
    }

    public final long zzc() {
        if (this.zza.zzf()) {
            return this.zza.zza();
        }
        return -9223372036854775807L;
    }

    public final long zzd() {
        if (this.zza.zzf()) {
            return this.zza.zzb();
        }
        return -9223372036854775807L;
    }

    public final void zze(long j) {
        this.zza.zzc(j);
        int i = 0;
        if (this.zza.zzf()) {
            this.zzc = false;
        } else if (this.zzd != -9223372036854775807L) {
            if (!this.zzc || this.zzb.zze()) {
                this.zzb.zzd();
                this.zzb.zzc(this.zzd);
            }
            this.zzc = true;
            this.zzb.zzc(j);
        }
        if (this.zzc && this.zzb.zzf()) {
            zzxc zzxc = this.zza;
            this.zza = this.zzb;
            this.zzb = zzxc;
            this.zzc = false;
        }
        this.zzd = j;
        if (!this.zza.zzf()) {
            i = this.zze + 1;
        }
        this.zze = i;
    }

    public final void zzf() {
        this.zza.zzd();
        this.zzb.zzd();
        this.zzc = false;
        this.zzd = -9223372036854775807L;
        this.zze = 0;
    }

    public final boolean zzg() {
        return this.zza.zzf();
    }
}
