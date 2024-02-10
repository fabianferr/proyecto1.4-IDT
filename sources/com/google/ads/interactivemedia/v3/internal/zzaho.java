package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@Deprecated
/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzaho extends AbstractList implements RandomAccess, zzafh {
    /* access modifiers changed from: private */
    public final zzafh zza;

    public zzaho(zzafh zzafh) {
        this.zza = zzafh;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzafg) this.zza).get(i);
    }

    public final Iterator iterator() {
        return new zzahn(this);
    }

    public final ListIterator listIterator(int i) {
        return new zzahm(this, i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzafh zze() {
        return this;
    }

    public final Object zzf(int i) {
        return this.zza.zzf(i);
    }

    public final List zzh() {
        return this.zza.zzh();
    }

    public final void zzi(zzadr zzadr) {
        throw new UnsupportedOperationException();
    }
}
