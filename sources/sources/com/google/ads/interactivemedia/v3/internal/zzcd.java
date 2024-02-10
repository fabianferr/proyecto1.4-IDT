package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Handler;
import com.google.ads.interactivemedia.omid.library.adsession.zze;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzcd {
    private static zzcd zza;
    private float zzb = 0.0f;
    private final zzbw zzc;
    private final zzbu zzd;
    private zzbv zze;
    private zzbx zzf;

    public zzcd(zzbw zzbw, zzbu zzbu) {
        this.zzc = zzbw;
        this.zzd = zzbu;
    }

    public static zzcd zzb() {
        if (zza == null) {
            zza = new zzcd(new zzbw(), new zzbu());
        }
        return zza;
    }

    public final float zza() {
        return this.zzb;
    }

    public final void zzc(Context context) {
        this.zze = new zzbv(new Handler(), context, new zzbt(), this);
    }

    public final void zzd(float f) {
        this.zzb = f;
        if (this.zzf == null) {
            this.zzf = zzbx.zza();
        }
        for (zze zzh : this.zzf.zzb()) {
            zzh.zzh().zzh(f);
        }
    }

    public final void zze() {
        zzby.zza().zzd(this);
        zzby.zza().zzb();
        zzcz.zzd().zzi();
        this.zze.zza();
    }

    public final void zzf() {
        zzcz.zzd().zzj();
        zzby.zza().zzc();
        this.zze.zzb();
    }
}
