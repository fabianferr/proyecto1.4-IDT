package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
public final class zzft extends zzka implements zzlm {
    private zzft() {
        super(zzfu.zza);
    }

    public final zzft zza(long j) {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        zzfu.zzd((zzfu) this.zza, j);
        return this;
    }

    public final zzft zzb(String str) {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        zzfu.zzc((zzfu) this.zza, str);
        return this;
    }

    /* synthetic */ zzft(zzfj zzfj) {
        super(zzfu.zza);
    }
}
