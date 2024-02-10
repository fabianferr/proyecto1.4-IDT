package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import okhttp3.HttpUrl;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzxo implements GenericArrayType, Serializable {
    private final Type zza;

    public zzxo(Type type) {
        type.getClass();
        this.zza = zzxr.zzc(type);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && zzxr.zzg(this, (GenericArrayType) obj);
    }

    public final Type getGenericComponentType() {
        return this.zza;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return String.valueOf(zzxr.zzb(this.zza)).concat(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
    }
}
