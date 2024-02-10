package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzjk implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzq zzc;
    final /* synthetic */ zzcf zzd;
    final /* synthetic */ zzjs zze;

    zzjk(zzjs zzjs, String str, String str2, zzq zzq, zzcf zzcf) {
        this.zze = zzjs;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzq;
        this.zzd = zzcf;
    }

    public final void run() {
        zzfy zzfy;
        ArrayList arrayList = new ArrayList();
        try {
            zzjs zzjs = this.zze;
            zzee zzh = zzjs.zzb;
            if (zzh == null) {
                zzjs.zzs.zzay().zzd().zzc("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                zzfy = this.zze.zzs;
            } else {
                Preconditions.checkNotNull(this.zzc);
                arrayList = zzlh.zzH(zzh.zzf(this.zza, this.zzb, this.zzc));
                this.zze.zzQ();
                zzfy = this.zze.zzs;
            }
        } catch (RemoteException e) {
            this.zze.zzs.zzay().zzd().zzd("Failed to get conditional properties; remote exception", this.zza, this.zzb, e);
            zzfy = this.zze.zzs;
        } catch (Throwable th) {
            this.zze.zzs.zzv().zzQ(this.zzd, arrayList);
            throw th;
        }
        zzfy.zzv().zzQ(this.zzd, arrayList);
    }
}
