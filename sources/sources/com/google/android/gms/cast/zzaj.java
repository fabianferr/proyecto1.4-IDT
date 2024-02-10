package com.google.android.gms.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzaj implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ CastRemoteDisplayLocalService zzb;

    zzaj(CastRemoteDisplayLocalService castRemoteDisplayLocalService, boolean z) {
        this.zzb = castRemoteDisplayLocalService;
        this.zza = z;
    }

    public final void run() {
        this.zzb.zzx(this.zza);
    }
}
