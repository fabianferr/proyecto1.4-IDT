package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzhw implements Runnable {
    final /* synthetic */ Boolean zza;
    final /* synthetic */ zzid zzb;

    zzhw(zzid zzid, Boolean bool) {
        this.zzb = zzid;
        this.zza = bool;
    }

    public final void run() {
        this.zzb.zzaa(this.zza, true);
    }
}
