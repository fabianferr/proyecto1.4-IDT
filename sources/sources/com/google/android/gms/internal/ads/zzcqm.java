package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcqm implements zzeyj {
    private final zzcpw zza;
    private final zzcqm zzb = this;
    private final zzgxv zzc;
    private final zzgxv zzd;
    private final zzgxv zze;
    private final zzgxv zzf;
    private final zzgxv zzg;
    private final zzgxv zzh;
    private final zzgxv zzi;
    private final zzgxv zzj;
    private final zzgxv zzk;

    /* synthetic */ zzcqm(zzcpw zzcpw, Context context, String str, zzcql zzcql) {
        this.zza = zzcpw;
        zzgxi zza2 = zzgxj.zza(context);
        this.zzc = zza2;
        zzgxi zza3 = zzgxj.zza(str);
        this.zzd = zza3;
        zzfbd zzfbd = new zzfbd(zza2, zzcpw.zzaz, zzcpw.zzaA);
        this.zze = zzfbd;
        zzgxv zzc2 = zzgxh.zzc(new zzezh(zzcpw.zzaz));
        this.zzf = zzc2;
        zzgxv zzgxv = zzc2;
        zzgxv zzc3 = zzgxh.zzc(new zzeyb(zza2, zzcpw.zzp, zzcpw.zzR, zzfbd, zzgxv, zzfeh.zza(), zzcpw.zzi));
        this.zzg = zzc3;
        this.zzh = zzgxh.zzc(new zzeyh(zzcpw.zzR, zza2, zza3, zzc3, zzgxv, zzcpw.zzi));
        zzfbc zzfbc = new zzfbc(zza2, zzcpw.zzaz, zzcpw.zzaA);
        this.zzi = zzfbc;
        zzgxv zzc4 = zzgxh.zzc(new zzezj(zza2, zzcpw.zzp, zzcpw.zzR, zzfbc, zzgxv, zzfeh.zza(), zzcpw.zzi));
        this.zzj = zzc4;
        this.zzk = zzgxh.zzc(new zzezp(zzcpw.zzR, zza2, zza3, zzc4, zzgxv, zzcpw.zzi));
    }

    public final zzeyg zza() {
        return (zzeyg) this.zzh.zzb();
    }

    public final zzezo zzb() {
        return (zzezo) this.zzk.zzb();
    }
}
