package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzaek {
    private static final zzaek zzb = new zzaek(true);
    final zzahf zza = new zzagv(16);
    private boolean zzc;
    private boolean zzd;

    private zzaek() {
    }

    public static zzaek zza() {
        throw null;
    }

    private static final void zzd(zzaej zzaej, Object obj) {
        boolean z;
        zzahz zzb2 = zzaej.zzb();
        byte[] bArr = zzafa.zzd;
        obj.getClass();
        zzahz zzahz = zzahz.DOUBLE;
        zzaia zzaia = zzaia.INT;
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
                if ((obj instanceof zzadr) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzaev)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzafz) || (obj instanceof zzafe)) {
                    return;
                }
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzaej.zza()), zzaej.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzaek zzaek = new zzaek();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry zzg = this.zza.zzg(i);
            zzaek.zzc((zzaej) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzaek.zzc((zzaej) entry.getKey(), entry.getValue());
        }
        zzaek.zzd = this.zzd;
        return zzaek;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaek)) {
            return false;
        }
        return this.zza.equals(((zzaek) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzc) {
            for (int i = 0; i < this.zza.zzb(); i++) {
                Map.Entry zzg = this.zza.zzg(i);
                if (zzg.getValue() instanceof zzaet) {
                    ((zzaet) zzg.getValue()).zzaK();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzc(zzaej zzaej, Object obj) {
        if (!zzaej.zzc()) {
            zzd(zzaej, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzd(zzaej, arrayList.get(i));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzafe) {
            this.zzd = true;
        }
        this.zza.put(zzaej, obj);
    }

    private zzaek(boolean z) {
        zzb();
        zzb();
    }
}
