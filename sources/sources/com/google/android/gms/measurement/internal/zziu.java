package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zziu implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzlc zzc;
    final /* synthetic */ zzjs zzd;

    zziu(zzjs zzjs, zzq zzq, boolean z, zzlc zzlc) {
        this.zzd = zzjs;
        this.zza = zzq;
        this.zzb = z;
        this.zzc = zzlc;
    }

    public final void run() {
        zzlc zzlc;
        zzjs zzjs = this.zzd;
        zzee zzh = zzjs.zzb;
        if (zzh == null) {
            zzjs.zzs.zzay().zzd().zza("Discarding data. Failed to set user property");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzjs zzjs2 = this.zzd;
        if (this.zzb) {
            zzlc = null;
        } else {
            zzlc = this.zzc;
        }
        zzjs2.zzD(zzh, zzlc, this.zza);
        this.zzd.zzQ();
    }
}
