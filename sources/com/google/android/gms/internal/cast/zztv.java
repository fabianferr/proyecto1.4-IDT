package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zztv {
    private static final zztu zza;
    private static final zztu zzb = new zztu();

    static {
        zztu zztu;
        try {
            zztu = (zztu) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zztu = null;
        }
        zza = zztu;
    }

    static zztu zza() {
        return zza;
    }

    static zztu zzb() {
        return zzb;
    }
}
