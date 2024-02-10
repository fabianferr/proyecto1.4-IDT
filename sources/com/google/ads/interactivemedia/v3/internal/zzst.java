package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzst<E> extends zzsk<E> implements Set<E> {
    @CheckForNull
    private transient zzso zza;

    zzst() {
    }

    static int zzj(int i) {
        double d;
        int max = Math.max(i, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            do {
                highestOneBit += highestOneBit;
                d = (double) highestOneBit;
                Double.isNaN(d);
            } while (d * 0.7d < ((double) max));
            return highestOneBit;
        }
        zzrm.zze(max < 1073741824, "collection too large");
        return 1073741824;
    }

    public static zzst zzl(Collection collection) {
        if ((collection instanceof zzst) && !(collection instanceof SortedSet)) {
            zzst zzst = (zzst) collection;
            if (!zzst.zzf()) {
                return zzst;
            }
        }
        Object[] array = collection.toArray();
        return zzh(array.length, array);
    }

    public static zzst zzm(Object obj) {
        return new zztt(obj);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzst) && zzi() && ((zzst) obj).zzi() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() != set.size() || !containsAll(set)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public int hashCode() {
        return zzts.zza(this);
    }

    public zzso zzd() {
        zzso zzso = this.zza;
        if (zzso != null) {
            return zzso;
        }
        zzso zzk = zzk();
        this.zza = zzk;
        return zzk;
    }

    /* renamed from: zze */
    public abstract zztw iterator();

    /* access modifiers changed from: package-private */
    public boolean zzi() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public zzso zzk() {
        Object[] array = toArray();
        int i = zzso.zzd;
        return zzso.zzj(array, array.length);
    }

    private static zzst zzh(int i, Object... objArr) {
        if (i == 0) {
            return zzto.zza;
        }
        if (i != 1) {
            int zzj = zzj(i);
            Object[] objArr2 = new Object[zzj];
            int i2 = zzj - 1;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                Object obj = objArr[i5];
                zztg.zza(obj, i5);
                int hashCode = obj.hashCode();
                int zzb = zzsi.zzb(hashCode);
                while (true) {
                    int i6 = zzb & i2;
                    Object obj2 = objArr2[i6];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        zzb++;
                    } else {
                        objArr[i4] = obj;
                        objArr2[i6] = obj;
                        i3 += hashCode;
                        i4++;
                        break;
                    }
                }
            }
            Arrays.fill(objArr, i4, i, (Object) null);
            if (i4 == 1) {
                Object obj3 = objArr[0];
                obj3.getClass();
                return new zztt(obj3);
            }
            if (zzj(i4) < zzj / 2) {
                return zzh(i4, objArr);
            }
            int length = objArr.length;
            if (i4 < (length >> 1) + (length >> 2)) {
                objArr = Arrays.copyOf(objArr, i4);
            }
            return new zzto(objArr, i3, objArr2, i2, i4);
        }
        Object obj4 = objArr[0];
        obj4.getClass();
        return new zztt(obj4);
    }
}
