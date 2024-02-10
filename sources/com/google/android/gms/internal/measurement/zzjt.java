package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
final class zzjt {
    private static final zzjr zza = new zzjs();
    private static final zzjr zzb;

    static {
        zzjr zzjr;
        try {
            zzjr = (zzjr) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzjr = null;
        }
        zzb = zzjr;
    }

    static zzjr zza() {
        zzjr zzjr = zzb;
        if (zzjr != null) {
            return zzjr;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzjr zzb() {
        return zza;
    }
}
