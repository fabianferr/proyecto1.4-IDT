package com.google.android.gms.internal.ads;

import android.content.Context;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzke {
    private final zzhk zza;

    @Deprecated
    public zzke(Context context, zzcly zzcly, byte[] bArr) {
        this.zza = new zzhk(context, zzcly, (byte[]) null);
    }

    @Deprecated
    public final zzke zza(zzjh zzjh) {
        zzhk zzhk = this.zza;
        zzdd.zzf(!zzhk.zzq);
        zzjh.getClass();
        zzhk.zzf = new zzhc(zzjh);
        return this;
    }

    @Deprecated
    public final zzke zzb(zzvz zzvz) {
        zzhk zzhk = this.zza;
        zzdd.zzf(!zzhk.zzq);
        zzvz.getClass();
        zzhk.zze = new zzhd(zzvz);
        return this;
    }

    @Deprecated
    public final zzkf zzc() {
        zzhk zzhk = this.zza;
        zzdd.zzf(!zzhk.zzq);
        zzhk.zzq = true;
        return new zzkf(zzhk);
    }
}
