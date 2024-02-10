package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
public final class zzgi extends zzka implements zzlm {
    private zzgi() {
        super(zzgj.zza);
    }

    public final zzgi zza(Iterable iterable) {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        zzgj.zzh((zzgj) this.zza, iterable);
        return this;
    }

    public final zzgi zzb(int i) {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        zzgj.zzg((zzgj) this.zza, i);
        return this;
    }

    /* synthetic */ zzgi(zzfj zzfj) {
        super(zzgj.zza);
    }
}
