package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
final class zzjz implements zzlj {
    private static final zzjz zza = new zzjz();

    private zzjz() {
    }

    public static zzjz zza() {
        return zza;
    }

    public final zzli zzb(Class cls) {
        if (zzke.class.isAssignableFrom(cls)) {
            try {
                return (zzli) zzke.zzbz(cls.asSubclass(zzke.class)).zzl(3, (Object) null, (Object) null);
            } catch (Exception e) {
                throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
    }

    public final boolean zzc(Class cls) {
        return zzke.class.isAssignableFrom(cls);
    }
}
