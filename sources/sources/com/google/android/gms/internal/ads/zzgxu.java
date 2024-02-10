package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgxu implements zzgxv {
    private static final Object zza = new Object();
    private volatile zzgxv zzb;
    private volatile Object zzc = zza;

    private zzgxu(zzgxv zzgxv) {
        this.zzb = zzgxv;
    }

    public static zzgxv zza(zzgxv zzgxv) {
        if ((zzgxv instanceof zzgxu) || (zzgxv instanceof zzgxh)) {
            return zzgxv;
        }
        zzgxv.getClass();
        return new zzgxu(zzgxv);
    }

    public final Object zzb() {
        Object obj = this.zzc;
        if (obj != zza) {
            return obj;
        }
        zzgxv zzgxv = this.zzb;
        if (zzgxv == null) {
            return this.zzc;
        }
        Object zzb2 = zzgxv.zzb();
        this.zzc = zzb2;
        this.zzb = null;
        return zzb2;
    }
}
