package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
public final class zzms extends AbstractList implements RandomAccess, zzkt {
    /* access modifiers changed from: private */
    public final zzkt zza;

    public zzms(zzkt zzkt) {
        this.zza = zzkt;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzks) this.zza).get(i);
    }

    public final Iterator iterator() {
        return new zzmr(this);
    }

    public final ListIterator listIterator(int i) {
        return new zzmq(this, i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzkt zze() {
        return this;
    }

    public final Object zzf(int i) {
        return this.zza.zzf(i);
    }

    public final List zzh() {
        return this.zza.zzh();
    }

    public final void zzi(zzjd zzjd) {
        throw new UnsupportedOperationException();
    }
}
