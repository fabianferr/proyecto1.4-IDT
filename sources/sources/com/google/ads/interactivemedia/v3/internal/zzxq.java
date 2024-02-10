package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzxq implements WildcardType, Serializable {
    private final Type zza;
    private final Type zzb;

    public zzxq(Type[] typeArr, Type[] typeArr2) {
        int length = typeArr2.length;
        boolean z = true;
        zzxm.zza(length <= 1);
        zzxm.zza(typeArr.length == 1);
        if (length == 1) {
            Type type = typeArr2[0];
            type.getClass();
            zzxr.zzf(type);
            zzxm.zza(typeArr[0] != Object.class ? false : z);
            this.zzb = zzxr.zzc(typeArr2[0]);
            this.zza = Object.class;
            return;
        }
        Type type2 = typeArr[0];
        type2.getClass();
        zzxr.zzf(type2);
        this.zzb = null;
        this.zza = zzxr.zzc(typeArr[0]);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && zzxr.zzg(this, (WildcardType) obj);
    }

    public final Type[] getLowerBounds() {
        Type type = this.zzb;
        if (type == null) {
            return zzxr.zza;
        }
        return new Type[]{type};
    }

    public final Type[] getUpperBounds() {
        return new Type[]{this.zza};
    }

    public final int hashCode() {
        Type type = this.zzb;
        return (type != null ? type.hashCode() + 31 : 1) ^ (this.zza.hashCode() + 31);
    }

    public final String toString() {
        Type type = this.zzb;
        if (type != null) {
            return "? super ".concat(String.valueOf(zzxr.zzb(type)));
        }
        Type type2 = this.zza;
        if (type2 == Object.class) {
            return "?";
        }
        return "? extends ".concat(String.valueOf(zzxr.zzb(type2)));
    }
}
