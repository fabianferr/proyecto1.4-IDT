package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcry implements zzfde {
    private final zzcpw zza;
    private final zzcry zzb = this;
    private final zzgxv zzc;
    private final zzgxv zzd;
    private final zzgxv zze;
    private final zzgxv zzf;
    private final zzgxv zzg;
    private final zzgxv zzh;
    private final zzgxv zzi;
    private final zzgxv zzj;

    /* synthetic */ zzcry(zzcpw zzcpw, Context context, String str, zzcrx zzcrx) {
        this.zza = zzcpw;
        zzgxi zza2 = zzgxj.zza(context);
        this.zzc = zza2;
        zzfbe zzfbe = new zzfbe(zza2, zzcpw.zzaz, zzcpw.zzaA);
        this.zzd = zzfbe;
        zzgxv zzc2 = zzgxh.zzc(new zzfco(zzcpw.zzaz));
        this.zze = zzc2;
        zzgxv zzc3 = zzgxh.zzc(zzfec.zza());
        this.zzf = zzc3;
        zzgxv zzc4 = zzgxh.zzc(new zzfcy(zza2, zzcpw.zzp, zzcpw.zzR, zzfbe, zzc2, zzfeh.zza(), zzc3));
        this.zzg = zzc4;
        this.zzh = zzgxh.zzc(new zzfdi(zzc4, zzc2, zzc3));
        zzgxi zzc5 = zzgxj.zzc(str);
        this.zzi = zzc5;
        this.zzj = zzgxh.zzc(new zzfdc(zzc5, zzc4, zza2, zzc2, zzc3, zzcpw.zzi));
    }

    public final zzfdb zza() {
        return (zzfdb) this.zzj.zzb();
    }

    public final zzfdh zzb() {
        return (zzfdh) this.zzh.zzb();
    }
}
