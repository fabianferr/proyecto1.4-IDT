package com.google.android.gms.flags;

/* compiled from: com.google.android.gms:play-services-flags@@17.0.1 */
public final class Singletons {
    private static Singletons zza;
    private final FlagRegistry zzb = new FlagRegistry();
    private final zzb zzc = new zzb();

    static {
        Singletons singletons = new Singletons();
        synchronized (Singletons.class) {
            zza = singletons;
        }
    }

    private Singletons() {
    }

    public static FlagRegistry flagRegistry() {
        return zzb().zzb;
    }

    public static zzb zza() {
        return zzb().zzc;
    }

    private static Singletons zzb() {
        Singletons singletons;
        synchronized (Singletons.class) {
            singletons = zza;
        }
        return singletons;
    }
}
