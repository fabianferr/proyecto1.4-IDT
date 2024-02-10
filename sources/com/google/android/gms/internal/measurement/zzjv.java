package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
final class zzjv {
    private static final zzjv zzb = new zzjv(true);
    final zzmj zza = new zzlz(16);
    private boolean zzc;
    private boolean zzd;

    private zzjv() {
    }

    public static zzjv zza() {
        throw null;
    }

    private static final void zzd(zzju zzju, Object obj) {
        boolean z;
        zznd zzb2 = zzju.zzb();
        zzkm.zze(obj);
        zznd zznd = zznd.DOUBLE;
        zzne zzne = zzne.INT;
        switch (zzb2.zza().ordinal()) {
            case 0:
                z = obj instanceof Integer;
                break;
            case 1:
                z = obj instanceof Long;
                break;
            case 2:
                z = obj instanceof Float;
                break;
            case 3:
                z = obj instanceof Double;
                break;
            case 4:
                z = obj instanceof Boolean;
                break;
            case 5:
                z = obj instanceof String;
                break;
            case 6:
                if ((obj instanceof zzjd) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzkg)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzll) || (obj instanceof zzkq)) {
                    return;
                }
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzju.zza()), zzju.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzjv zzjv = new zzjv();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry zzg = this.zza.zzg(i);
            zzjv.zzc((zzju) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzjv.zzc((zzju) entry.getKey(), entry.getValue());
        }
        zzjv.zzd = this.zzd;
        return zzjv;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjv)) {
            return false;
        }
        return this.zza.equals(((zzjv) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzc) {
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzc(zzju zzju, Object obj) {
        if (!zzju.zzc()) {
            zzd(zzju, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzd(zzju, arrayList.get(i));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzkq) {
            this.zzd = true;
        }
        this.zza.put(zzju, obj);
    }

    private zzjv(boolean z) {
        zzb();
        zzb();
    }
}
