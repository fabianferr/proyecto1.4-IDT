package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzabh implements zzxj {
    zzabh() {
    }

    public final zzxi zza(zzwm zzwm, zzact zzact) {
        Class<? super Enum> zzc = zzact.zzc();
        if (!Enum.class.isAssignableFrom(zzc) || zzc == Enum.class) {
            return null;
        }
        if (!zzc.isEnum()) {
            zzc = zzc.getSuperclass();
        }
        return new zzabx(zzc);
    }
}
