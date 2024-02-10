package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzcf;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzjd implements Runnable {
    final /* synthetic */ zzaw zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcf zzc;
    final /* synthetic */ zzjs zzd;

    zzjd(zzjs zzjs, zzaw zzaw, String str, zzcf zzcf) {
        this.zzd = zzjs;
        this.zza = zzaw;
        this.zzb = str;
        this.zzc = zzcf;
    }

    public final void run() {
        zzfy zzfy;
        byte[] bArr = null;
        try {
            zzjs zzjs = this.zzd;
            zzee zzh = zzjs.zzb;
            if (zzh == null) {
                zzjs.zzs.zzay().zzd().zza("Discarding data. Failed to send event to service to bundle");
                zzfy = this.zzd.zzs;
            } else {
                bArr = zzh.zzu(this.zza, this.zzb);
                this.zzd.zzQ();
                zzfy = this.zzd.zzs;
            }
        } catch (RemoteException e) {
            this.zzd.zzs.zzay().zzd().zzb("Failed to send event to the service to bundle", e);
            zzfy = this.zzd.zzs;
        } catch (Throwable th) {
            this.zzd.zzs.zzv().zzS(this.zzc, bArr);
            throw th;
        }
        zzfy.zzv().zzS(this.zzc, bArr);
    }
}
