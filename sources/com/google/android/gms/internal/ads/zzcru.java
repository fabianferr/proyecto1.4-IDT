package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcru implements zzfbq {
    private final zzcpw zza;
    private final zzcru zzb = this;
    private final zzgxv zzc;
    private final zzgxv zzd;
    private final zzgxv zze;
    private final zzgxv zzf;
    private final zzgxv zzg;
    private final zzgxv zzh;
    private final zzgxv zzi;

    /* synthetic */ zzcru(zzcpw zzcpw, Context context, String str, zzq zzq, zzcrt zzcrt) {
        this.zza = zzcpw;
        zzgxi zza2 = zzgxj.zza(context);
        this.zzc = zza2;
        zzgxi zza3 = zzgxj.zza(zzq);
        this.zzd = zza3;
        zzgxi zza4 = zzgxj.zza(str);
        this.zze = zza4;
        zzgxv zzc2 = zzgxh.zzc(new zzeog(zzcpw.zzo));
        this.zzf = zzc2;
        zzgxv zzc3 = zzgxh.zzc(new zzfco(zzcpw.zzaz));
        this.zzg = zzc3;
        zzgxi zzgxi = zza2;
        zzgxv zzc4 = zzgxh.zzc(new zzfbo(zzgxi, zzcpw.zzp, zzcpw.zzR, zzc2, zzc3, zzfeh.zza()));
        this.zzh = zzc4;
        this.zzi = zzgxh.zzc(new zzeoo(zzgxi, zza3, zza4, zzc4, zzc2, zzc3, zzcpw.zzi));
    }

    public final zzeon zza() {
        return (zzeon) this.zzi.zzb();
    }
}
