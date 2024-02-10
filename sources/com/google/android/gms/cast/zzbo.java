package com.google.android.gms.cast;

import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final /* synthetic */ class zzbo implements Runnable {
    public final /* synthetic */ zzbs zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzbo(zzbs zzbs, int i) {
        this.zza = zzbs;
        this.zzb = i;
    }

    public final void run() {
        zzbs zzbs = this.zza;
        int i = this.zzb;
        zzbt.zzy(zzbs.zza);
        zzbs.zza.zzz = 1;
        synchronized (zzbs.zza.zzy) {
            for (zzq zzd : zzbs.zza.zzy) {
                zzd.zzd(i);
            }
        }
        zzbs.zza.zzS();
        zzbt zzbt = zzbs.zza;
        Task unused = zzbt.zzQ(zzbt.zza);
    }
}
