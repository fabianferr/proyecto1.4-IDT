package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zziy implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ zzcf zzb;
    final /* synthetic */ zzjs zzc;

    zziy(zzjs zzjs, zzq zzq, zzcf zzcf) {
        this.zzc = zzjs;
        this.zza = zzq;
        this.zzb = zzcf;
    }

    public final void run() {
        zzfy zzfy;
        String str = null;
        try {
            if (!this.zzc.zzs.zzm().zzc().zzi(zzah.ANALYTICS_STORAGE)) {
                this.zzc.zzs.zzay().zzl().zza("Analytics storage consent denied; will not get app instance id");
                this.zzc.zzs.zzq().zzO((String) null);
                this.zzc.zzs.zzm().zze.zzb((String) null);
                zzfy = this.zzc.zzs;
            } else {
                zzjs zzjs = this.zzc;
                zzee zzh = zzjs.zzb;
                if (zzh == null) {
                    zzjs.zzs.zzay().zzd().zza("Failed to get app instance id");
                    zzfy = this.zzc.zzs;
                } else {
                    Preconditions.checkNotNull(this.zza);
                    str = zzh.zzd(this.zza);
                    if (str != null) {
                        this.zzc.zzs.zzq().zzO(str);
                        this.zzc.zzs.zzm().zze.zzb(str);
                    }
                    this.zzc.zzQ();
                    zzfy = this.zzc.zzs;
                }
            }
        } catch (RemoteException e) {
            this.zzc.zzs.zzay().zzd().zzb("Failed to get app instance id", e);
            zzfy = this.zzc.zzs;
        } catch (Throwable th) {
            this.zzc.zzs.zzv().zzV(this.zzb, (String) null);
            throw th;
        }
        zzfy.zzv().zzV(this.zzb, str);
    }
}
