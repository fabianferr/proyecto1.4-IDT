package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzja implements Runnable {
    final /* synthetic */ zzik zza;
    final /* synthetic */ zzjs zzb;

    zzja(zzjs zzjs, zzik zzik) {
        this.zzb = zzjs;
        this.zza = zzik;
    }

    public final void run() {
        zzjs zzjs = this.zzb;
        zzee zzh = zzjs.zzb;
        if (zzh == null) {
            zzjs.zzs.zzay().zzd().zza("Failed to send current screen to service");
            return;
        }
        try {
            zzik zzik = this.zza;
            if (zzik == null) {
                zzh.zzq(0, (String) null, (String) null, zzjs.zzs.zzau().getPackageName());
            } else {
                zzh.zzq(zzik.zzc, zzik.zza, zzik.zzb, zzjs.zzs.zzau().getPackageName());
            }
            this.zzb.zzQ();
        } catch (RemoteException e) {
            this.zzb.zzs.zzay().zzd().zzb("Failed to send current screen to the service", e);
        }
    }
}
