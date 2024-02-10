package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzafg extends zzadc implements RandomAccess, zzafh {
    @Deprecated
    public static final zzafh zza;
    private static final zzafg zzb;
    private final List zzc;

    static {
        zzafg zzafg = new zzafg(false);
        zzb = zzafg;
        zza = zzafg;
    }

    public zzafg() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzadr) {
            return ((zzadr) obj).zzu(zzafa.zzb);
        }
        return zzafa.zzd((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zza();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i, Collection collection) {
        zza();
        if (collection instanceof zzafh) {
            collection = ((zzafh) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zza();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        Object remove = this.zzc.remove(i);
        this.modCount++;
        return zzj(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zza();
        return zzj(this.zzc.set(i, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final /* bridge */ /* synthetic */ zzaez zzd(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzc);
            return new zzafg(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final zzafh zze() {
        return zzc() ? new zzaho(this) : this;
    }

    public final Object zzf(int i) {
        return this.zzc.get(i);
    }

    /* renamed from: zzg */
    public final String get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzadr) {
            zzadr zzadr = (zzadr) obj;
            String zzu = zzadr.zzu(zzafa.zzb);
            if (zzadr.zzo()) {
                this.zzc.set(i, zzu);
            }
            return zzu;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzafa.zzd(bArr);
        if (zzahy.zzh(bArr)) {
            this.zzc.set(i, zzd);
        }
        return zzd;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final void zzi(zzadr zzadr) {
        zza();
        this.zzc.add(zzadr);
        this.modCount++;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzafg(int i) {
        super(true);
        ArrayList arrayList = new ArrayList(i);
        this.zzc = arrayList;
    }

    private zzafg(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzafg(boolean z) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
