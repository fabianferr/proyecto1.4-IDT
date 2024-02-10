package com.google.android.gms.internal.cast;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzuv implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzuw zzb;

    zzuv(zzuw zzuw) {
        this.zzb = zzuw;
        this.zza = zzuw.zza.iterator();
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
