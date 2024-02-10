package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzke {
    final /* synthetic */ zzki zza;
    private zzkd zzb;

    zzke(zzki zzki) {
        this.zza = zzki;
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j) {
        this.zzb = new zzkd(this, this.zza.zzs.zzav().currentTimeMillis(), j);
        this.zza.zzd.postDelayed(this.zzb, 2000);
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        this.zza.zzg();
        zzkd zzkd = this.zzb;
        if (zzkd != null) {
            this.zza.zzd.removeCallbacks(zzkd);
        }
        this.zza.zzs.zzm().zzl.zza(false);
    }
}
