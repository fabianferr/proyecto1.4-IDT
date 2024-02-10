package com.google.android.gms.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final /* synthetic */ class zzbp implements Runnable {
    public final /* synthetic */ zzbs zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzbp(zzbs zzbs, int i) {
        this.zza = zzbs;
        this.zzb = i;
    }

    public final void run() {
        zzbs zzbs = this.zza;
        int i = this.zzb;
        zzbs.zza.zzz = 3;
        synchronized (zzbs.zza.zzy) {
            for (zzq zzc : zzbs.zza.zzy) {
                zzc.zzc(i);
            }
        }
    }
}
