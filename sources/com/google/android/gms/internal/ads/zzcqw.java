package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcqw implements zzezx {
    private final Context zza;
    private final zzq zzb;
    private final String zzc;
    private final zzcpw zzd;
    private final zzcqw zze = this;
    private final zzgxv zzf;
    private final zzgxv zzg;
    private final zzgxv zzh;
    private final zzgxv zzi;
    private final zzgxv zzj;
    private final zzgxv zzk;

    /* synthetic */ zzcqw(zzcpw zzcpw, Context context, String str, zzq zzq, zzcqv zzcqv) {
        this.zzd = zzcpw;
        this.zza = context;
        this.zzb = zzq;
        this.zzc = str;
        zzgxi zza2 = zzgxj.zza(context);
        this.zzf = zza2;
        zzgxi zza3 = zzgxj.zza(zzq);
        this.zzg = zza3;
        zzgxv zzc2 = zzgxh.zzc(new zzeog(zzcpw.zzo));
        this.zzh = zzc2;
        zzgxv zzc3 = zzgxh.zzc(zzeol.zza());
        this.zzi = zzc3;
        zzgxv zzc4 = zzgxh.zzc(zzdhx.zza());
        this.zzj = zzc4;
        this.zzk = zzgxh.zzc(new zzezv(zza2, zzcpw.zzp, zza3, zzcpw.zzR, zzc2, zzc3, zzfeh.zza(), zzc4));
    }

    public final zzenm zza() {
        zzcgv zzd2 = this.zzd.zza.zzd();
        zzgxq.zzb(zzd2);
        return new zzenm(this.zza, this.zzb, this.zzc, (zzezu) this.zzk.zzb(), (zzeof) this.zzh.zzb(), zzd2);
    }
}
