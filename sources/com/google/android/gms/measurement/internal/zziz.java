package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zziz implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ zzjs zzb;

    zziz(zzjs zzjs, zzq zzq) {
        this.zzb = zzjs;
        this.zza = zzq;
    }

    public final void run() {
        zzjs zzjs = this.zzb;
        zzee zzh = zzjs.zzb;
        if (zzh == null) {
            zzjs.zzs.zzay().zzd().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzh.zzj(this.zza);
            this.zzb.zzs.zzi().zzm();
            this.zzb.zzD(zzh, (AbstractSafeParcelable) null, this.zza);
            this.zzb.zzQ();
        } catch (RemoteException e) {
            this.zzb.zzs.zzay().zzd().zzb("Failed to send app launch to the service", e);
        }
    }
}
