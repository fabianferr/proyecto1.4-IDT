package com.google.android.gms.internal.cast;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public abstract class zzfd extends AbstractCollection implements Serializable {
    private static final Object[] zza = new Object[0];

    zzfd() {
    }

    @Deprecated
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean contains(@CheckForNull Object obj);

    @Deprecated
    public final boolean remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray() {
        return toArray(zza);
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i) {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public int zzb() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zzc() {
        throw new UnsupportedOperationException();
    }

    public zzfh zzd() {
        throw null;
    }

    /* renamed from: zze */
    public abstract zzfx iterator();

    /* access modifiers changed from: package-private */
    public abstract boolean zzf();

    /* access modifiers changed from: package-private */
    @CheckForNull
    public Object[] zzg() {
        return null;
    }

    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        int size = size();
        int length = objArr.length;
        if (length < size) {
            Object[] zzg = zzg();
            if (zzg != null) {
                return Arrays.copyOfRange(zzg, zzc(), zzb(), objArr.getClass());
            }
            if (length != 0) {
                objArr = Arrays.copyOf(objArr, 0);
            }
            objArr = Arrays.copyOf(objArr, size);
        } else if (length > size) {
            objArr[size] = null;
        }
        zza(objArr, 0);
        return objArr;
    }
}
