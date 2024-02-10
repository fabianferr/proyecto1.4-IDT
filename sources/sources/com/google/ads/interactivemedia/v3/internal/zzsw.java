package com.google.ads.interactivemedia.v3.internal;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzsw extends zzsx implements NavigableMap {
    private static final Comparator zza;
    private static final zzsw zzb;
    /* access modifiers changed from: private */
    public final transient zztp zzc;
    /* access modifiers changed from: private */
    public final transient zzso zzd;
    @CheckForNull
    private final transient zzsw zze;

    static {
        zztf zztf = zztf.zza;
        zza = zztf;
        zztp zzs = zzsy.zzs(zztf);
        int i = zzso.zzd;
        zzb = new zzsw(zzs, zzti.zza, (zzsw) null);
    }

    zzsw(zztp zztp, zzso zzso, @CheckForNull zzsw zzsw) {
        this.zzc = zztp;
        this.zzd = zzso;
        this.zze = zzsw;
    }

    static zzsw zzk(Comparator comparator) {
        if (zztf.zza.equals(comparator)) {
            return zzb;
        }
        zztp zzs = zzsy.zzs(comparator);
        int i = zzso.zzd;
        return new zzsw(zzs, zzti.zza, (zzsw) null);
    }

    public static zzsw zzm() {
        return zzb;
    }

    private final zzsw zzq(int i, int i2) {
        if (i == 0) {
            if (i2 == this.zzd.size()) {
                return this;
            }
            i = 0;
        }
        if (i == i2) {
            return zzk(this.zzc.zza);
        }
        return new zzsw(this.zzc.zzw(i, i2), this.zzd.subList(i, i2), (zzsw) null);
    }

    @CheckForNull
    public final Map.Entry ceilingEntry(Object obj) {
        return tailMap(obj, true).firstEntry();
    }

    @CheckForNull
    public final Object ceilingKey(Object obj) {
        return zztd.zza(ceilingEntry(obj));
    }

    public final Comparator comparator() {
        return this.zzc.zza;
    }

    public final /* synthetic */ NavigableSet descendingKeySet() {
        return this.zzc.descendingSet();
    }

    public final /* bridge */ /* synthetic */ NavigableMap descendingMap() {
        zzth zzth;
        zzsw zzsw = this.zze;
        if (zzsw != null) {
            return zzsw;
        }
        if (!isEmpty()) {
            return new zzsw((zztp) this.zzc.descendingSet(), this.zzd.zzh(), this);
        }
        Comparator comparator = this.zzc.zza;
        if (comparator instanceof zzth) {
            zzth = (zzth) comparator;
        } else {
            zzth = new zzrw(comparator);
        }
        return zzk(zzth.zza());
    }

    public final /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @CheckForNull
    public final Map.Entry firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().zzd().get(0);
    }

    public final Object firstKey() {
        return this.zzc.first();
    }

    @CheckForNull
    public final Map.Entry floorEntry(Object obj) {
        return headMap(obj, true).lastEntry();
    }

    @CheckForNull
    public final Object floorKey(Object obj) {
        return zztd.zza(floorEntry(obj));
    }

    public final /* synthetic */ SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    @CheckForNull
    public final Map.Entry higherEntry(Object obj) {
        return tailMap(obj, false).firstEntry();
    }

    @CheckForNull
    public final Object higherKey(Object obj) {
        return zztd.zza(higherEntry(obj));
    }

    public final /* synthetic */ Set keySet() {
        return this.zzc;
    }

    @CheckForNull
    public final Map.Entry lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().zzd().get(this.zzd.size() - 1);
    }

    public final Object lastKey() {
        return this.zzc.last();
    }

    @CheckForNull
    public final Map.Entry lowerEntry(Object obj) {
        return headMap(obj, false).lastEntry();
    }

    @CheckForNull
    public final Object lowerKey(Object obj) {
        return zztd.zza(lowerEntry(obj));
    }

    public final /* synthetic */ NavigableSet navigableKeySet() {
        return this.zzc;
    }

    @CheckForNull
    @Deprecated
    public final Map.Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    @Deprecated
    public final Map.Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    public final int size() {
        return this.zzd.size();
    }

    public final /* bridge */ /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    public final /* synthetic */ SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }

    public final /* synthetic */ Collection values() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final zzsk zza() {
        throw new AssertionError("should never be called");
    }

    public final zzsk zzb() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final zzst zze() {
        if (isEmpty()) {
            return zzto.zza;
        }
        return new zzsv(this);
    }

    /* access modifiers changed from: package-private */
    public final zzst zzf() {
        throw new AssertionError("should never be called");
    }

    public final /* synthetic */ zzst zzh() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzi() {
        return this.zzc.zzd.zzf() || this.zzd.zzf();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        if (r4 < 0) goto L_0x0005;
     */
    @javax.annotation.CheckForNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object get(@javax.annotation.CheckForNull java.lang.Object r4) {
        /*
            r3 = this;
            com.google.ads.interactivemedia.v3.internal.zztp r0 = r3.zzc
            r1 = -1
            if (r4 != 0) goto L_0x0007
        L_0x0005:
            r4 = -1
            goto L_0x0014
        L_0x0007:
            com.google.ads.interactivemedia.v3.internal.zzso r2 = r0.zzd     // Catch:{ ClassCastException -> 0x0012 }
            java.util.Comparator r0 = r0.zza     // Catch:{ ClassCastException -> 0x0012 }
            int r4 = java.util.Collections.binarySearch(r2, r4, r0)     // Catch:{ ClassCastException -> 0x0012 }
            if (r4 >= 0) goto L_0x0014
            goto L_0x0005
        L_0x0012:
            goto L_0x0005
        L_0x0014:
            if (r4 != r1) goto L_0x0018
            r4 = 0
            return r4
        L_0x0018:
            com.google.ads.interactivemedia.v3.internal.zzso r0 = r3.zzd
            java.lang.Object r4 = r0.get(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzsw.get(java.lang.Object):java.lang.Object");
    }

    /* renamed from: zzl */
    public final zzsw headMap(Object obj, boolean z) {
        zztp zztp = this.zzc;
        obj.getClass();
        return zzq(0, zztp.zzu(obj, z));
    }

    /* renamed from: zzo */
    public final zzsw tailMap(Object obj, boolean z) {
        zztp zztp = this.zzc;
        obj.getClass();
        return zzq(zztp.zzv(obj, z), this.zzd.size());
    }

    /* renamed from: zzn */
    public final zzsw subMap(Object obj, boolean z, Object obj2, boolean z2) {
        obj.getClass();
        obj2.getClass();
        if (this.zzc.zza.compare(obj, obj2) <= 0) {
            return headMap(obj2, z2).tailMap(obj, z);
        }
        throw new IllegalArgumentException(zzro.zzb("expected fromKey <= toKey but %s > %s", obj, obj2));
    }
}
