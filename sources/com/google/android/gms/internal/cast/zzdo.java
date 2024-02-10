package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzdo extends zzdt {
    final /* synthetic */ zzdu zza;
    final /* synthetic */ zzdp zzb;

    zzdo(zzdp zzdp, zzdu zzdu) {
        this.zzb = zzdp;
        this.zza = zzdu;
    }

    public final void zzb(int i) throws RemoteException {
        zzdp.zze.d("onRemoteDisplayEnded", new Object[0]);
        zzdu zzdu = this.zza;
        if (zzdu != null) {
            zzdu.zzb(i);
        }
        zzdp zzdp = this.zzb;
        if (zzdp.zzf != null) {
            zzdp.zzf.onRemoteDisplayEnded(new Status(i));
        }
    }
}
