package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
public final class zznu implements zznt {
    public static final zzia zza;
    public static final zzia zzb;
    public static final zzia zzc;

    static {
        zzhx zza2 = new zzhx(zzhp.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zzf("measurement.collection.event_safelist", true);
        zzb = zza2.zzf("measurement.service.store_null_safelist", true);
        zzc = zza2.zzf("measurement.service.store_safelist", true);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return ((Boolean) zzb.zzb()).booleanValue();
    }

    public final boolean zzc() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }
}
