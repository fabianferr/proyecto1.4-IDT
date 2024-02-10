package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractSet;
import java.util.Iterator;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
abstract class zzsg extends AbstractSet {
    final zzsh zzb;

    zzsg(zzsh zzsh) {
        this.zzb = zzsh;
    }

    public final void clear() {
        this.zzb.clear();
    }

    public final Iterator iterator() {
        return new zzsf(this);
    }

    public final int size() {
        return this.zzb.zzc;
    }

    /* access modifiers changed from: package-private */
    public abstract Object zza(int i);
}
