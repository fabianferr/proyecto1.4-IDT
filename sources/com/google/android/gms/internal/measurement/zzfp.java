package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
public final class zzfp extends zzka implements zzlm {
    private zzfp() {
        super(zzfq.zza);
    }

    public final zzfp zza(long j) {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        zzfq.zzf((zzfq) this.zza, j);
        return this;
    }

    public final zzfp zzb(int i) {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        zzfq.zze((zzfq) this.zza, i);
        return this;
    }

    /* synthetic */ zzfp(zzfj zzfj) {
        super(zzfq.zza);
    }
}
