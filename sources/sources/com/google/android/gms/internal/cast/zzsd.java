package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzsd implements zztn {
    private static final zzsd zza = new zzsd();

    private zzsd() {
    }

    public static zzsd zza() {
        return zza;
    }

    public final zztm zzb(Class cls) {
        if (zzsh.class.isAssignableFrom(cls)) {
            try {
                return (zztm) zzsh.zzv(cls.asSubclass(zzsh.class)).zzb(3, (Object) null, (Object) null);
            } catch (Exception e) {
                throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
    }

    public final boolean zzc(Class cls) {
        return zzsh.class.isAssignableFrom(cls);
    }
}
