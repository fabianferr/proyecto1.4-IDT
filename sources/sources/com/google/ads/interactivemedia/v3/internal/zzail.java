package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzail implements Map.Entry, Comparable, Serializable {
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzail zzail = (zzail) obj;
        zzaid zzaid = new zzaid();
        zzaid.zzb(zza(), zzail.zza(), (Comparator) null);
        zzaid.zzb(zzb(), zzail.zzb(), (Comparator) null);
        return zzaid.zza();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            return zzaik.zza(zza(), entry.getKey()) && zzaik.zza(zzb(), entry.getValue());
        }
    }

    public final Object getKey() {
        return zza();
    }

    public final Object getValue() {
        return zzb();
    }

    public final String toString() {
        String valueOf = String.valueOf(zza());
        String valueOf2 = String.valueOf(zzb());
        return "(" + valueOf + "," + valueOf2 + ")";
    }

    public abstract Object zza();

    public abstract Object zzb();

    public final int hashCode() {
        int i;
        int i2 = 0;
        if (zza() == null) {
            i = 0;
        } else {
            i = zza().hashCode();
        }
        if (zzb() != null) {
            i2 = zzb().hashCode();
        }
        return i ^ i2;
    }
}
