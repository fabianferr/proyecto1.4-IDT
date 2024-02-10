package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzaeo implements zzafx {
    private static final zzaeo zza = new zzaeo();

    private zzaeo() {
    }

    public static zzaeo zza() {
        return zza;
    }

    public final zzafw zzb(Class cls) {
        if (zzaet.class.isAssignableFrom(cls)) {
            try {
                return (zzafw) zzaet.zzaz(cls.asSubclass(zzaet.class)).zzj(3, (Object) null, (Object) null);
            } catch (Exception e) {
                throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
    }

    public final boolean zzc(Class cls) {
        return zzaet.class.isAssignableFrom(cls);
    }
}
