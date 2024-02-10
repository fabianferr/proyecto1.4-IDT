package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzyn implements Cloneable, zzxj {
    public static final zzyn zza = new zzyn();
    private List zzb = Collections.emptyList();
    private final List zzc = Collections.emptyList();

    private final boolean zzf(Class cls, boolean z) {
        for (zzqz zzqz : z ? this.zzb : this.zzc) {
        }
        return false;
    }

    private static final boolean zzg(Class cls) {
        if (Enum.class.isAssignableFrom(cls) || (cls.getModifiers() & 8) != 0) {
            return false;
        }
        if (cls.isAnonymousClass() || cls.isLocalClass()) {
            return true;
        }
        return false;
    }

    public final zzxi zza(zzwm zzwm, zzact zzact) {
        boolean z;
        boolean z2;
        Class zzc2 = zzact.zzc();
        boolean zzg = zzg(zzc2);
        if (!zzg) {
            zzf(zzc2, true);
            z = false;
        } else {
            z = true;
        }
        if (!zzg) {
            zzf(zzc2, false);
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z) {
            return null;
        }
        return new zzym(this, z2, true, zzwm, zzact);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzb */
    public final zzyn clone() {
        try {
            return (zzyn) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean zzc(Class cls, boolean z) {
        if (zzg(cls)) {
            return true;
        }
        zzf(cls, z);
        return false;
    }

    public final boolean zzd(Field field, boolean z) {
        List<zzqz> list;
        if ((field.getModifiers() & 136) != 0 || field.isSynthetic() || zzg(field.getType())) {
            return true;
        }
        if (z) {
            list = this.zzb;
        } else {
            list = this.zzc;
        }
        if (list.isEmpty()) {
            return false;
        }
        field.getClass();
        for (zzqz zzqz : list) {
            zzqy zzqy = (zzqy) zzwd.zza(field).getAnnotation(zzqy.class);
            if (zzqy != null && Arrays.asList(zzqy.zzb()).contains(zzwd.zzb(field))) {
                return true;
            }
        }
        return false;
    }

    public final zzyn zze(zzqz zzqz, boolean z, boolean z2) {
        zzyn zzb2 = clone();
        ArrayList arrayList = new ArrayList(this.zzb);
        zzb2.zzb = arrayList;
        arrayList.add(zzqz);
        return zzb2;
    }
}
