package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public abstract class zzei {
    private static final ThreadLocal zza = new zzec();

    public static zzei zzb() {
        return (zzei) zza.get();
    }

    public abstract void zza(zzef zzef);
}
