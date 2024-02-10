package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zztl {
    private static final zztk zza;
    private static final zztk zzb = new zztk();

    static {
        zztk zztk;
        try {
            zztk = (zztk) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zztk = null;
        }
        zza = zztk;
    }

    static zztk zza() {
        return zza;
    }

    static zztk zzb() {
        return zzb;
    }
}
