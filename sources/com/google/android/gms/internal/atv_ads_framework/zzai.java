package com.google.android.gms.internal.atv_ads_framework;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
final class zzai extends zzaf {
    private final transient zzae zza;
    /* access modifiers changed from: private */
    public final transient Object[] zzb;
    /* access modifiers changed from: private */
    public final transient int zzc;

    zzai(zzae zzae, Object[] objArr, int i, int i2) {
        this.zza = zzae;
        this.zzb = objArr;
        this.zzc = i2;
    }

    public final boolean contains(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.zza.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final /* synthetic */ Iterator iterator() {
        return zzd().listIterator(0);
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return zzd().zza(objArr, 0);
    }

    public final zzan zze() {
        return zzd().listIterator(0);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final zzab zzh() {
        return new zzah(this);
    }
}
