package com.google.android.gms.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final /* synthetic */ class zzbr implements Runnable {
    public final /* synthetic */ zzbs zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzbr(zzbs zzbs, int i) {
        this.zza = zzbs;
        this.zzb = i;
    }

    public final void run() {
        zzbs zzbs = this.zza;
        int i = this.zzb;
        if (i == 0) {
            zzbs.zza.zzz = 2;
            zzbs.zza.zzk = true;
            zzbs.zza.zzl = true;
            synchronized (zzbs.zza.zzy) {
                for (zzq zza2 : zzbs.zza.zzy) {
                    zza2.zza();
                }
            }
            return;
        }
        zzbs.zza.zzz = 1;
        synchronized (zzbs.zza.zzy) {
            for (zzq zzb2 : zzbs.zza.zzy) {
                zzb2.zzb(i);
            }
        }
        zzbs.zza.zzS();
    }
}
