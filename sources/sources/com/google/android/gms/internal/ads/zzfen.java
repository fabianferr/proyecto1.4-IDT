package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfen implements zzfzc {
    final /* synthetic */ zzcmp zza;
    final /* synthetic */ zzfkm zzb;
    final /* synthetic */ zzego zzc;

    zzfen(zzcmp zzcmp, zzfkm zzfkm, zzego zzego) {
        this.zza = zzcmp;
        this.zzb = zzfkm;
        this.zzc = zzego;
    }

    public final void zza(Throwable th) {
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        if (!this.zza.zzF().zzak) {
            this.zzb.zzc(str, (zzfju) null);
            return;
        }
        long currentTimeMillis = zzt.zzB().currentTimeMillis();
        String str2 = this.zza.zzR().zzb;
        int i = 2;
        if (!zzt.zzo().zzv(this.zza.getContext())) {
            if (!((Boolean) zzay.zzc().zzb(zzbjc.zzfr)).booleanValue() || !this.zza.zzF().zzT) {
                i = 1;
            }
        }
        this.zzc.zzd(new zzegq(currentTimeMillis, str2, str, i));
    }
}
