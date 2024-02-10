package com.google.ads.interactivemedia.v3.internal;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzsy extends zzsz implements NavigableSet, zztu {
    final transient Comparator zza;
    @CheckForNull
    transient zzsy zzb;

    zzsy(Comparator comparator) {
        this.zza = comparator;
    }

    static zztp zzs(Comparator comparator) {
        if (zztf.zza.equals(comparator)) {
            return zztp.zzc;
        }
        int i = zzso.zzd;
        return new zztp(zzti.zza, comparator);
    }

    public final Comparator comparator() {
        return this.zza;
    }

    public Object first() {
        return iterator().next();
    }

    public Object last() {
        return descendingIterator().next();
    }

    @CheckForNull
    @Deprecated
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    @Deprecated
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    public final /* bridge */ /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    /* renamed from: zze */
    public abstract zztw iterator();

    /* access modifiers changed from: package-private */
    public abstract zzsy zzh();

    /* renamed from: zzn */
    public final zzsy descendingSet() {
        zzsy zzsy = this.zzb;
        if (zzsy != null) {
            return zzsy;
        }
        zzsy zzh = zzh();
        this.zzb = zzh;
        zzh.zzb = this;
        return zzh;
    }

    /* access modifiers changed from: package-private */
    public abstract zzsy zzo(Object obj, boolean z);

    /* access modifiers changed from: package-private */
    public abstract zzsy zzq(Object obj, boolean z, Object obj2, boolean z2);

    /* access modifiers changed from: package-private */
    public abstract zzsy zzr(Object obj, boolean z);

    /* renamed from: zzt */
    public abstract zztw descendingIterator();

    public final /* synthetic */ SortedSet headSet(Object obj) {
        obj.getClass();
        return zzo(obj, false);
    }

    public final /* synthetic */ SortedSet tailSet(Object obj) {
        obj.getClass();
        return zzr(obj, true);
    }

    @CheckForNull
    public Object ceiling(Object obj) {
        obj.getClass();
        return zzta.zza(zzr(obj, true), (Object) null);
    }

    @CheckForNull
    public Object floor(Object obj) {
        obj.getClass();
        return zztc.zza(zzo(obj, true).descendingIterator(), (Object) null);
    }

    @CheckForNull
    public Object higher(Object obj) {
        obj.getClass();
        return zzta.zza(zzr(obj, false), (Object) null);
    }

    @CheckForNull
    public Object lower(Object obj) {
        obj.getClass();
        return zztc.zza(zzo(obj, false).descendingIterator(), (Object) null);
    }

    public final /* synthetic */ NavigableSet headSet(Object obj, boolean z) {
        obj.getClass();
        return zzo(obj, z);
    }

    public final /* synthetic */ NavigableSet tailSet(Object obj, boolean z) {
        obj.getClass();
        return zzr(obj, z);
    }

    /* renamed from: zzp */
    public final zzsy subSet(Object obj, boolean z, Object obj2, boolean z2) {
        obj.getClass();
        obj2.getClass();
        zzrm.zzd(this.zza.compare(obj, obj2) <= 0);
        return zzq(obj, z, obj2, z2);
    }
}
