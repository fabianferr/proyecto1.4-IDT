package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
public final /* synthetic */ class zzfz implements Runnable {
    public final /* synthetic */ zzgq zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Bundle zzc;

    public /* synthetic */ zzfz(zzgq zzgq, String str, Bundle bundle) {
        this.zza = zzgq;
        this.zzb = str;
        this.zzc = bundle;
    }

    public final void run() {
        this.zza.zzw(this.zzb, this.zzc);
    }
}
