package com.google.android.gms.internal.atv_ads_framework;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
public abstract class zzae implements Map, Serializable {
    @CheckForNull
    private transient zzaf zza;
    @CheckForNull
    private transient zzaf zzb;
    @CheckForNull
    private transient zzy zzc;

    zzae() {
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
        return zzam.zza(entrySet());
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final /* bridge */ /* synthetic */ Set keySet() {
        zzaf zzaf = this.zzb;
        if (zzaf != null) {
            return zzaf;
        }
        zzaf zzd = zzd();
        this.zzb = zzd;
        return zzd;
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
        if (size >= 0) {
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
        throw new IllegalArgumentException("size cannot be negative but was: " + size);
    }

    /* access modifiers changed from: package-private */
    public abstract zzy zza();

    /* renamed from: zzb */
    public final zzy values() {
        zzy zzy = this.zzc;
        if (zzy != null) {
            return zzy;
        }
        zzy zza2 = zza();
        this.zzc = zza2;
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public abstract zzaf zzc();

    /* access modifiers changed from: package-private */
    public abstract zzaf zzd();

    /* renamed from: zze */
    public final zzaf entrySet() {
        zzaf zzaf = this.zza;
        if (zzaf != null) {
            return zzaf;
        }
        zzaf zzc2 = zzc();
        this.zza = zzc2;
        return zzc2;
    }
}
