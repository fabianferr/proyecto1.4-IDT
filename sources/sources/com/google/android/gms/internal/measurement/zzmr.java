package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
final class zzmr implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzms zzb;

    zzmr(zzms zzms) {
        this.zzb = zzms;
        this.zza = zzms.zza.iterator();
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
