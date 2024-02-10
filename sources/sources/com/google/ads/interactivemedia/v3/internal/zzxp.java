package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzxp implements ParameterizedType, Serializable {
    private final Type zza;
    private final Type zzb;
    private final Type[] zzc;

    public zzxp(Type type, Type type2, Type... typeArr) {
        Type type3;
        type2.getClass();
        if (type2 instanceof Class) {
            Class cls = (Class) type2;
            boolean z = true;
            boolean z2 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
            if (type == null && !z2) {
                z = false;
            }
            zzxm.zza(z);
        }
        if (type == null) {
            type3 = null;
        } else {
            type3 = zzxr.zzc(type);
        }
        this.zza = type3;
        this.zzb = zzxr.zzc(type2);
        Type[] typeArr2 = (Type[]) typeArr.clone();
        this.zzc = typeArr2;
        int length = typeArr2.length;
        for (int i = 0; i < length; i++) {
            Type type4 = this.zzc[i];
            type4.getClass();
            zzxr.zzf(type4);
            Type[] typeArr3 = this.zzc;
            typeArr3[i] = zzxr.zzc(typeArr3[i]);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && zzxr.zzg(this, (ParameterizedType) obj);
    }

    public final Type[] getActualTypeArguments() {
        return (Type[]) this.zzc.clone();
    }

    public final Type getOwnerType() {
        return this.zza;
    }

    public final Type getRawType() {
        return this.zzb;
    }

    public final int hashCode() {
        int hashCode = Arrays.hashCode(this.zzc) ^ this.zzb.hashCode();
        Type type = this.zza;
        return hashCode ^ (type != null ? type.hashCode() : 0);
    }

    public final String toString() {
        int length = this.zzc.length;
        if (length == 0) {
            return zzxr.zzb(this.zzb);
        }
        StringBuilder sb = new StringBuilder((length + 1) * 30);
        sb.append(zzxr.zzb(this.zzb));
        sb.append("<");
        sb.append(zzxr.zzb(this.zzc[0]));
        for (int i = 1; i < length; i++) {
            sb.append(", ");
            sb.append(zzxr.zzb(this.zzc[i]));
        }
        sb.append(">");
        return sb.toString();
    }
}
