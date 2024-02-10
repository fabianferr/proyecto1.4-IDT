package com.google.android.gms.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final /* synthetic */ class zzbm implements Runnable {
    public final /* synthetic */ zzbs zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzbm(zzbs zzbs, int i) {
        this.zza = zzbs;
        this.zzb = i;
    }

    public final void run() {
        zzbs zzbs = this.zza;
        zzbs.zza.zzx.onApplicationDisconnected(this.zzb);
    }
}
