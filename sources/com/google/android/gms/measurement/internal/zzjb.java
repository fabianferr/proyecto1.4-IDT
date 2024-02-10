package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzjb implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ Bundle zzb;
    final /* synthetic */ zzjs zzc;

    zzjb(zzjs zzjs, zzq zzq, Bundle bundle) {
        this.zzc = zzjs;
        this.zza = zzq;
        this.zzb = bundle;
    }

    public final void run() {
        zzjs zzjs = this.zzc;
        zzee zzh = zzjs.zzb;
        if (zzh == null) {
            zzjs.zzs.zzay().zzd().zza("Failed to send default event parameters to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzh.zzr(this.zzb, this.zza);
        } catch (RemoteException e) {
            this.zzc.zzs.zzay().zzd().zzb("Failed to send default event parameters to service", e);
        }
    }
}
