package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzsb extends AbstractMap implements Serializable, zzrt {
    private final zzsh zza;
    private transient Set zzb;

    zzsb(zzsh zzsh) {
        this.zza = zzsh;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean containsKey(@CheckForNull Object obj) {
        return this.zza.containsValue(obj);
    }

    public final boolean containsValue(@CheckForNull Object obj) {
        return this.zza.containsKey(obj);
    }

    public final Set entrySet() {
        Set set = this.zzb;
        if (set != null) {
            return set;
        }
        zzsc zzsc = new zzsc(this.zza);
        this.zzb = zzsc;
        return zzsc;
    }

    @CheckForNull
    public final Object get(@CheckForNull Object obj) {
        zzsh zzsh = this.zza;
        int zzd = zzsh.zzd(obj, zzsi.zzc(obj));
        if (zzd == -1) {
            return null;
        }
        return zzsh.zza[zzd];
    }

    public final Set keySet() {
        return this.zza.values();
    }

    @CheckForNull
    public final Object put(Object obj, Object obj2) {
        return this.zza.zzh(obj, obj2, false);
    }

    @CheckForNull
    public final Object remove(@CheckForNull Object obj) {
        zzsh zzsh = this.zza;
        int zzc = zzsi.zzc(obj);
        int zzd = zzsh.zzd(obj, zzc);
        if (zzd == -1) {
            return null;
        }
        Object obj2 = zzsh.zza[zzd];
        zzsh.zzm(zzd, zzc);
        return obj2;
    }

    public final int size() {
        return this.zza.zzc;
    }

    public final /* synthetic */ Collection values() {
        return this.zza.keySet();
    }
}
