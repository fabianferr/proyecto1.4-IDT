package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzja extends zzhj<Float> implements zzjl<Float>, zzkw, RandomAccess {
    private static final zzja zza;
    private float[] zzb;
    private int zzc;

    zzja() {
        this(new float[10], 0);
    }

    private zzja(float[] fArr, int i) {
        this.zzb = fArr;
        this.zzc = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzc();
        if (i2 >= i) {
            float[] fArr = this.zzb;
            System.arraycopy(fArr, i2, fArr, i, this.zzc - i2);
            this.zzc -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzja)) {
            return super.equals(obj);
        }
        zzja zzja = (zzja) obj;
        if (this.zzc != zzja.zzc) {
            return false;
        }
        float[] fArr = zzja.zzb;
        for (int i = 0; i < this.zzc; i++) {
            if (Float.floatToIntBits(this.zzb[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzb[i2]);
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.zzb[i] == floatValue) {
                return i;
            }
        }
        return -1;
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final int size() {
        return this.zzc;
    }

    public final void zza(float f) {
        zzc();
        int i = this.zzc;
        float[] fArr = this.zzb;
        if (i == fArr.length) {
            float[] fArr2 = new float[(((i * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.zzb = fArr2;
        }
        float[] fArr3 = this.zzb;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        fArr3[i2] = f;
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        zzc();
        zzjf.zza(collection);
        if (!(collection instanceof zzja)) {
            return super.addAll(collection);
        }
        zzja zzja = (zzja) collection;
        int i = zzja.zzc;
        if (i == 0) {
            return false;
        }
        int i2 = this.zzc;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.zzb;
            if (i3 > fArr.length) {
                this.zzb = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(zzja.zzb, 0, this.zzb, this.zzc, zzja.zzc);
            this.zzc = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    private final void zzb(int i) {
        if (i < 0 || i >= this.zzc) {
            throw new IndexOutOfBoundsException(zzc(i));
        }
    }

    private final String zzc(int i) {
        int i2 = this.zzc;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzc();
        zzb(i);
        float[] fArr = this.zzb;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    public final /* synthetic */ Object remove(int i) {
        zzc();
        zzb(i);
        float[] fArr = this.zzb;
        float f = fArr[i];
        int i2 = this.zzc;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.zzc--;
        this.modCount++;
        return Float.valueOf(f);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        float floatValue = ((Float) obj).floatValue();
        zzc();
        if (i < 0 || i > (i2 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzc(i));
        }
        float[] fArr = this.zzb;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.zzb, i, fArr2, i + 1, this.zzc - i);
            this.zzb = fArr2;
        }
        this.zzb[i] = floatValue;
        this.zzc++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zza(((Float) obj).floatValue());
        return true;
    }

    public final /* synthetic */ zzjl zza(int i) {
        if (i >= this.zzc) {
            return new zzja(Arrays.copyOf(this.zzb, i), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzb(i);
        return Float.valueOf(this.zzb[i]);
    }

    static {
        zzja zzja = new zzja(new float[0], 0);
        zza = zzja;
        zzja.zzb();
    }
}
