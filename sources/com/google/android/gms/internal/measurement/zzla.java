package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
final class zzla extends zzio implements RandomAccess, zzkk, zzls {
    private static final zzla zza;
    private long[] zzb;
    private int zzc;

    static {
        zzla zzla = new zzla(new long[0], 0);
        zza = zzla;
        zzla.zzb();
    }

    zzla() {
        this(new long[10], 0);
    }

    public static zzla zzf() {
        return zza;
    }

    private final String zzh(int i) {
        int i2 = this.zzc;
        return "Index:" + i + ", Size:" + i2;
    }

    private final void zzi(int i) {
        if (i < 0 || i >= this.zzc) {
            throw new IndexOutOfBoundsException(zzh(i));
        }
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        long longValue = ((Long) obj).longValue();
        zzbP();
        if (i < 0 || i > (i2 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzh(i));
        }
        long[] jArr = this.zzb;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.zzb, i, jArr2, i + 1, this.zzc - i);
            this.zzb = jArr2;
        }
        this.zzb[i] = longValue;
        this.zzc++;
        this.modCount++;
    }

    public final boolean addAll(Collection collection) {
        zzbP();
        zzkm.zze(collection);
        if (!(collection instanceof zzla)) {
            return super.addAll(collection);
        }
        zzla zzla = (zzla) collection;
        int i = zzla.zzc;
        if (i == 0) {
            return false;
        }
        int i2 = this.zzc;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zzb;
            if (i3 > jArr.length) {
                this.zzb = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzla.zzb, 0, this.zzb, this.zzc, zzla.zzc);
            this.zzc = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzla)) {
            return super.equals(obj);
        }
        zzla zzla = (zzla) obj;
        if (this.zzc != zzla.zzc) {
            return false;
        }
        long[] jArr = zzla.zzb;
        for (int i = 0; i < this.zzc; i++) {
            if (this.zzb[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        zzi(i);
        return Long.valueOf(this.zzb[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            i = (i * 31) + zzkm.zzc(this.zzb[i2]);
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int i = this.zzc;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zzb[i2] == longValue) {
                return i2;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zzbP();
        zzi(i);
        long[] jArr = this.zzb;
        long j = jArr[i];
        int i2 = this.zzc;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.zzc--;
        this.modCount++;
        return Long.valueOf(j);
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzbP();
        if (i2 >= i) {
            long[] jArr = this.zzb;
            System.arraycopy(jArr, i2, jArr, i, this.zzc - i2);
            this.zzc -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzbP();
        zzi(i);
        long[] jArr = this.zzb;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final int size() {
        return this.zzc;
    }

    public final long zza(int i) {
        zzi(i);
        return this.zzb[i];
    }

    /* renamed from: zze */
    public final zzkk zzd(int i) {
        if (i >= this.zzc) {
            return new zzla(Arrays.copyOf(this.zzb, i), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public final void zzg(long j) {
        zzbP();
        int i = this.zzc;
        long[] jArr = this.zzb;
        if (i == jArr.length) {
            long[] jArr2 = new long[(((i * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.zzb = jArr2;
        }
        long[] jArr3 = this.zzb;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        jArr3[i2] = j;
    }

    private zzla(long[] jArr, int i) {
        this.zzb = jArr;
        this.zzc = i;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzg(((Long) obj).longValue());
        return true;
    }
}