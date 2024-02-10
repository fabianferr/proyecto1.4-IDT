package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzaei {
    private static final zzaeg zza = new zzaeh();
    private static final zzaeg zzb;

    static {
        zzaeg zzaeg;
        try {
            zzaeg = (zzaeg) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzaeg = null;
        }
        zzb = zzaeg;
    }

    static zzaeg zza() {
        zzaeg zzaeg = zzb;
        if (zzaeg != null) {
            return zzaeg;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzaeg zzb() {
        return zza;
    }
}
