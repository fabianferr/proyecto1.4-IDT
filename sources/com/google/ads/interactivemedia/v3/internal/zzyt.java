package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzyt extends AbstractSet {
    final /* synthetic */ zzyy zza;

    zzyt(zzyy zzyy) {
        this.zza = zzyy;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(Object obj) {
        return (obj instanceof Map.Entry) && this.zza.zzb((Map.Entry) obj) != null;
    }

    public final Iterator iterator() {
        return new zzys(this);
    }

    public final boolean remove(Object obj) {
        zzyx zzb;
        if (!(obj instanceof Map.Entry) || (zzb = this.zza.zzb((Map.Entry) obj)) == null) {
            return false;
        }
        this.zza.zze(zzb, true);
        return true;
    }

    public final int size() {
        return this.zza.zzb;
    }
}
