package com.google.ads.interactivemedia.v3.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zztp extends zzsy {
    static final zztp zzc = new zztp(zzti.zza, zztf.zza);
    final transient zzso zzd;

    static {
        int i = zzso.zzd;
    }

    zztp(zzso zzso, Comparator comparator) {
        super(comparator);
        this.zzd = zzso;
    }

    @CheckForNull
    public final Object ceiling(Object obj) {
        int zzv = zzv(obj, true);
        if (zzv == this.zzd.size()) {
            return null;
        }
        return this.zzd.get(zzv);
    }

    public final boolean contains(@CheckForNull Object obj) {
        if (obj != null) {
            try {
                if (Collections.binarySearch(this.zzd, obj, this.zza) >= 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    public final boolean containsAll(Collection collection) {
        if (collection instanceof zzte) {
            collection = ((zzte) collection).zza();
        }
        if (!zztv.zza(this.zza, collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        zztx zzn = this.zzd.listIterator(0);
        Iterator it = collection.iterator();
        if (!zzn.hasNext()) {
            return false;
        }
        Object next = it.next();
        Object next2 = zzn.next();
        while (true) {
            try {
                int compare = this.zza.compare(next2, next);
                if (compare >= 0) {
                    if (compare != 0) {
                        break;
                    } else if (!it.hasNext()) {
                        return true;
                    } else {
                        next = it.next();
                    }
                } else if (!zzn.hasNext()) {
                    return false;
                } else {
                    next2 = zzn.next();
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038 A[Catch:{ ClassCastException | NoSuchElementException -> 0x004c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(@javax.annotation.CheckForNull java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r7 instanceof java.util.Set
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            java.util.Set r7 = (java.util.Set) r7
            com.google.ads.interactivemedia.v3.internal.zzso r1 = r6.zzd
            int r1 = r1.size()
            int r3 = r7.size()
            if (r1 == r3) goto L_0x0019
            return r2
        L_0x0019:
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto L_0x0020
            return r0
        L_0x0020:
            java.util.Comparator r1 = r6.zza
            boolean r1 = com.google.ads.interactivemedia.v3.internal.zztv.zza(r1, r7)
            if (r1 == 0) goto L_0x004d
            java.util.Iterator r7 = r7.iterator()
            com.google.ads.interactivemedia.v3.internal.zzso r1 = r6.zzd     // Catch:{ ClassCastException | NoSuchElementException -> 0x004c }
            com.google.ads.interactivemedia.v3.internal.zztx r1 = r1.listIterator(r2)     // Catch:{ ClassCastException | NoSuchElementException -> 0x004c }
        L_0x0032:
            boolean r3 = r1.hasNext()     // Catch:{ ClassCastException | NoSuchElementException -> 0x004c }
            if (r3 == 0) goto L_0x004b
            java.lang.Object r3 = r1.next()     // Catch:{ ClassCastException | NoSuchElementException -> 0x004c }
            java.lang.Object r4 = r7.next()     // Catch:{ ClassCastException | NoSuchElementException -> 0x004c }
            if (r4 == 0) goto L_0x004a
            java.util.Comparator r5 = r6.zza     // Catch:{ ClassCastException | NoSuchElementException -> 0x004c }
            int r3 = r5.compare(r3, r4)     // Catch:{ ClassCastException | NoSuchElementException -> 0x004c }
            if (r3 == 0) goto L_0x0032
        L_0x004a:
            return r2
        L_0x004b:
            return r0
        L_0x004c:
            return r2
        L_0x004d:
            boolean r7 = r6.containsAll(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zztp.equals(java.lang.Object):boolean");
    }

    public final Object first() {
        if (!isEmpty()) {
            return this.zzd.get(0);
        }
        throw new NoSuchElementException();
    }

    @CheckForNull
    public final Object floor(Object obj) {
        int zzu = zzu(obj, true) - 1;
        if (zzu == -1) {
            return null;
        }
        return this.zzd.get(zzu);
    }

    @CheckForNull
    public final Object higher(Object obj) {
        int zzv = zzv(obj, false);
        if (zzv == this.zzd.size()) {
            return null;
        }
        return this.zzd.get(zzv);
    }

    public final /* synthetic */ Iterator iterator() {
        return this.zzd.listIterator(0);
    }

    public final Object last() {
        if (!isEmpty()) {
            zzso zzso = this.zzd;
            return zzso.get(zzso.size() - 1);
        }
        throw new NoSuchElementException();
    }

    @CheckForNull
    public final Object lower(Object obj) {
        int zzu = zzu(obj, false) - 1;
        if (zzu == -1) {
            return null;
        }
        return this.zzd.get(zzu);
    }

    public final int size() {
        return this.zzd.size();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return this.zzd.zza(objArr, 0);
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.zzd.zzb();
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return this.zzd.zzc();
    }

    public final zzso zzd() {
        return this.zzd;
    }

    public final zztw zze() {
        return this.zzd.listIterator(0);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return this.zzd.zzf();
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public final Object[] zzg() {
        return this.zzd.zzg();
    }

    /* access modifiers changed from: package-private */
    public final zzsy zzh() {
        Comparator reverseOrder = Collections.reverseOrder(this.zza);
        if (isEmpty()) {
            return zzs(reverseOrder);
        }
        return new zztp(this.zzd.zzh(), reverseOrder);
    }

    /* access modifiers changed from: package-private */
    public final zzsy zzo(Object obj, boolean z) {
        return zzw(0, zzu(obj, z));
    }

    /* access modifiers changed from: package-private */
    public final zzsy zzq(Object obj, boolean z, Object obj2, boolean z2) {
        return zzr(obj, z).zzo(obj2, z2);
    }

    /* access modifiers changed from: package-private */
    public final zzsy zzr(Object obj, boolean z) {
        return zzw(zzv(obj, z), this.zzd.size());
    }

    /* renamed from: zzt */
    public final zztw descendingIterator() {
        return this.zzd.zzh().listIterator(0);
    }

    /* access modifiers changed from: package-private */
    public final int zzu(Object obj, boolean z) {
        zzso zzso = this.zzd;
        obj.getClass();
        int binarySearch = Collections.binarySearch(zzso, obj, this.zza);
        if (binarySearch >= 0) {
            return z ? binarySearch + 1 : binarySearch;
        }
        return binarySearch ^ -1;
    }

    /* access modifiers changed from: package-private */
    public final int zzv(Object obj, boolean z) {
        zzso zzso = this.zzd;
        obj.getClass();
        int binarySearch = Collections.binarySearch(zzso, obj, this.zza);
        if (binarySearch >= 0) {
            return z ? binarySearch : binarySearch + 1;
        }
        return binarySearch ^ -1;
    }

    /* access modifiers changed from: package-private */
    public final zztp zzw(int i, int i2) {
        if (i == 0) {
            if (i2 == this.zzd.size()) {
                return this;
            }
            i = 0;
        }
        if (i < i2) {
            return new zztp(this.zzd.subList(i, i2), this.zza);
        }
        return zzs(this.zza);
    }
}