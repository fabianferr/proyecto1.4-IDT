package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzjj implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzq zzd;
    final /* synthetic */ zzjs zze;

    zzjj(zzjs zzjs, AtomicReference atomicReference, String str, String str2, String str3, zzq zzq) {
        this.zze = zzjs;
        this.zza = atomicReference;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzq;
    }

    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.zza) {
            try {
                zzjs zzjs = this.zze;
                zzee zzh = zzjs.zzb;
                if (zzh == null) {
                    zzjs.zzs.zzay().zzd().zzd("(legacy) Failed to get conditional properties; not connected to service", (Object) null, this.zzb, this.zzc);
                    this.zza.set(Collections.emptyList());
                    this.zza.notify();
                    return;
                }
                if (TextUtils.isEmpty((CharSequence) null)) {
                    Preconditions.checkNotNull(this.zzd);
                    this.zza.set(zzh.zzf(this.zzb, this.zzc, this.zzd));
                } else {
                    this.zza.set(zzh.zzg((String) null, this.zzb, this.zzc));
                }
                this.zze.zzQ();
                atomicReference = this.zza;
                atomicReference.notify();
            } catch (RemoteException e) {
                try {
                    this.zze.zzs.zzay().zzd().zzd("(legacy) Failed to get conditional properties; remote exception", (Object) null, this.zzb, e);
                    this.zza.set(Collections.emptyList());
                    atomicReference = this.zza;
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}
