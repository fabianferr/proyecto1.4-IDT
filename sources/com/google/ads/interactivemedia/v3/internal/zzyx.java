package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzyx implements Map.Entry {
    zzyx zza;
    zzyx zzb;
    zzyx zzc;
    zzyx zzd;
    zzyx zze;
    final Object zzf;
    final boolean zzg;
    Object zzh;
    int zzi;

    zzyx(boolean z) {
        this.zzf = null;
        this.zzg = z;
        this.zze = this;
        this.zzd = this;
    }

    zzyx(boolean z, zzyx zzyx, Object obj, zzyx zzyx2, zzyx zzyx3) {
        this.zza = zzyx;
        this.zzf = obj;
        this.zzg = z;
        this.zzi = 1;
        this.zzd = zzyx2;
        this.zze = zzyx3;
        zzyx3.zzd = this;
        zzyx2.zze = this;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.zzf;
            if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                Object obj3 = this.zzh;
                if (obj3 == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (!obj3.equals(entry.getValue())) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public final Object getKey() {
        return this.zzf;
    }

    public final Object getValue() {
        return this.zzh;
    }

    public final Object setValue(Object obj) {
        if (obj != null || this.zzg) {
            Object obj2 = this.zzh;
            this.zzh = obj;
            return obj2;
        }
        throw new NullPointerException("value == null");
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzf);
        String valueOf2 = String.valueOf(this.zzh);
        return valueOf + "=" + valueOf2;
    }

    public final int hashCode() {
        int i;
        Object obj = this.zzf;
        int i2 = 0;
        if (obj == null) {
            i = 0;
        } else {
            i = obj.hashCode();
        }
        Object obj2 = this.zzh;
        if (obj2 != null) {
            i2 = obj2.hashCode();
        }
        return i ^ i2;
    }
}
