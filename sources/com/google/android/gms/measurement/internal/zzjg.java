package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzjg implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ zzjs zzb;

    zzjg(zzjs zzjs, zzq zzq) {
        this.zzb = zzjs;
        this.zza = zzq;
    }

    public final void run() {
        zzjs zzjs = this.zzb;
        zzee zzh = zzjs.zzb;
        if (zzh == null) {
            zzjs.zzs.zzay().zzd().zza("Failed to send consent settings to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzh.zzp(this.zza);
            this.zzb.zzQ();
        } catch (RemoteException e) {
            this.zzb.zzs.zzay().zzd().zzb("Failed to send consent settings to the service", e);
        }
    }
}
