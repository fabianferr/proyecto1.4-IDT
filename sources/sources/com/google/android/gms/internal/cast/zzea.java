package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzea extends zzef {
    final /* synthetic */ zzeb zza;

    zzea(zzeb zzeb) {
        this.zza = zzeb;
    }

    public final void zza(long j) {
        zzeb zzeb = this.zza;
        zzeb.zzc = zzeb.zzc + 1;
        zzeb zzeb2 = this.zza;
        if (!zzeb2.zza(zzeb2.zza) && !this.zza.zza.isStarted()) {
            zzeb zzeb3 = this.zza;
            if (!zzeb.zze(zzeb3)) {
                zzeb3.zza.start();
            }
        }
    }
}
