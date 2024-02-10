package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzsr<K, V> implements Map<K, V>, Serializable {
    @CheckForNull
    private transient zzst zza;
    @CheckForNull
    private transient zzst zzb;
    @CheckForNull
    private transient zzsk zzc;

    zzsr() {
    }

    public static zzsr zzc(Map map) {
        if ((map instanceof zzsr) && !(map instanceof SortedMap)) {
            zzsr zzsr = (zzsr) map;
            if (!zzsr.zzi()) {
                return zzsr;
            }
        }
        Set entrySet = map.entrySet();
        zzsq zzsq = new zzsq(entrySet instanceof Collection ? entrySet.size() : 4);
        zzsq.zzb(entrySet);
        return zzsq.zzc();
    }

    public static zzsr zzd(Object obj, Object obj2) {
        zzrv.zzb("adBreakTime", obj2);
        return zztn.zzj(1, new Object[]{"adBreakTime", obj2}, (zzsq) null);
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public final boolean containsKey(@CheckForNull Object obj) {
        return get(obj) != null;
    }

    public final boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return entrySet().equals(((Map) obj).entrySet());
    }

    @CheckForNull
    public abstract Object get(@CheckForNull Object obj);

    @CheckForNull
    public final Object getOrDefault(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public final int hashCode() {
        return zzts.zza(entrySet());
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    @CheckForNull
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    @Deprecated
    public final Object remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        zzrv.zza(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824));
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public abstract zzsk zza();

    /* renamed from: zzb */
    public zzsk values() {
        zzsk zzsk = this.zzc;
        if (zzsk != null) {
            return zzsk;
        }
        zzsk zza2 = zza();
        this.zzc = zza2;
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public abstract zzst zze();

    /* access modifiers changed from: package-private */
    public abstract zzst zzf();

    /* renamed from: zzg */
    public final zzst entrySet() {
        zzst zzst = this.zza;
        if (zzst != null) {
            return zzst;
        }
        zzst zze = zze();
        this.zza = zze;
        return zze;
    }

    /* renamed from: zzh */
    public zzst keySet() {
        zzst zzst = this.zzb;
        if (zzst != null) {
            return zzst;
        }
        zzst zzf = zzf();
        this.zzb = zzf;
        return zzf;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean zzi();
}
