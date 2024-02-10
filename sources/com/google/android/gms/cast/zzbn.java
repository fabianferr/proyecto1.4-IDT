package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzab;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final /* synthetic */ class zzbn implements Runnable {
    public final /* synthetic */ zzbs zza;
    public final /* synthetic */ zzab zzb;

    public /* synthetic */ zzbn(zzbs zzbs, zzab zzab) {
        this.zza = zzbs;
        this.zzb = zzab;
    }

    public final void run() {
        zzbs zzbs = this.zza;
        zzbt.zzA(zzbs.zza, this.zzb);
    }
}
