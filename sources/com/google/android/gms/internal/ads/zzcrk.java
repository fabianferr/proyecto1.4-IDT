package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcrk implements zzdyz {
    /* access modifiers changed from: private */
    public final Context zza;
    private final zzbqr zzb;
    private final zzcpw zzc;
    private final zzcrk zzd = this;
    private final zzgxv zze;
    private final zzgxv zzf;
    private final zzgxv zzg;
    private final zzgxv zzh;

    /* synthetic */ zzcrk(zzcpw zzcpw, Context context, zzbqr zzbqr, zzcrj zzcrj) {
        this.zzc = zzcpw;
        this.zza = context;
        this.zzb = zzbqr;
        zzgxi zza2 = zzgxj.zza(this);
        this.zze = zza2;
        zzgxi zza3 = zzgxj.zza(zzbqr);
        this.zzf = zza3;
        zzdyv zzdyv = new zzdyv(zza3);
        this.zzg = zzdyv;
        this.zzh = zzgxh.zzc(new zzdyx(zza2, zzdyv));
    }

    public final zzdyq zzb() {
        return new zzcre(this.zzc, this.zzd, (zzcrd) null);
    }

    public final zzdyw zzd() {
        return (zzdyw) this.zzh.zzb();
    }
}
