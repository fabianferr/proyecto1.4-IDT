package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzact {
    private final Class zza;
    private final Type zzb;
    private final int zzc;

    protected zzact() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Class<zzact> cls = zzact.class;
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == cls) {
                this.zzb = zzxr.zzc(parameterizedType.getActualTypeArguments()[0]);
                throw null;
            }
        } else if (genericSuperclass == cls) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.");
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    public static zzact zza(Class cls) {
        return new zzact(cls);
    }

    public static zzact zzb(Type type) {
        return new zzact(type);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzact) && zzxr.zzg(this.zzb, ((zzact) obj).zzb);
    }

    public final int hashCode() {
        return this.zzc;
    }

    public final String toString() {
        return zzxr.zzb(this.zzb);
    }

    public final Class zzc() {
        return this.zza;
    }

    public final Type zzd() {
        return this.zzb;
    }

    private zzact(Type type) {
        type.getClass();
        Type zzc2 = zzxr.zzc(type);
        this.zzb = zzc2;
        this.zza = zzxr.zza(zzc2);
        this.zzc = zzc2.hashCode();
    }
}
