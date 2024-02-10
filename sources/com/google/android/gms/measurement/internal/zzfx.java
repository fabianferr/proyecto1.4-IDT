package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzfx implements Runnable {
    final /* synthetic */ zzhb zza;
    final /* synthetic */ zzfy zzb;

    zzfx(zzfy zzfy, zzhb zzhb) {
        this.zzb = zzfy;
        this.zza = zzhb;
    }

    public final void run() {
        zzfy.zzA(this.zzb, this.zza);
        this.zzb.zzH(this.zza.zzg);
    }
}
