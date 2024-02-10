package com.google.ads.interactivemedia.v3.internal;

import java.util.Iterator;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzahn implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzaho zzb;

    zzahn(zzaho zzaho) {
        this.zzb = zzaho;
        this.zza = zzaho.zza.iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
