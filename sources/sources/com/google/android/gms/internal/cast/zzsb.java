package com.google.android.gms.internal.cast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzsb {
    private static final zzsb zzb = new zzsb(true);
    final zzun zza = new zzud(16);
    private boolean zzc;
    private boolean zzd;

    private zzsb() {
    }

    public static zzsb zza() {
        throw null;
    }

    private static final void zzd(zzsa zzsa, Object obj) {
        boolean z;
        zzvg zzb2 = zzsa.zzb();
        byte[] bArr = zzsq.zzd;
        obj.getClass();
        zzvg zzvg = zzvg.DOUBLE;
        zzvh zzvh = zzvh.INT;
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
                if ((obj instanceof zzrm) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzsj)) {
                    return;
                }
            case 8:
                if ((obj instanceof zztp) || (obj instanceof zzsu)) {
                    return;
                }
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzsa.zza()), zzsa.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzsb zzsb = new zzsb();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry zzg = this.zza.zzg(i);
            zzsb.zzc((zzsa) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzsb.zzc((zzsa) entry.getKey(), entry.getValue());
        }
        zzsb.zzd = this.zzd;
        return zzsb;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzsb)) {
            return false;
        }
        return this.zza.equals(((zzsb) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzc) {
            for (int i = 0; i < this.zza.zzb(); i++) {
                Map.Entry zzg = this.zza.zzg(i);
                if (zzg.getValue() instanceof zzsh) {
                    ((zzsh) zzg.getValue()).zzE();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzc(zzsa zzsa, Object obj) {
        if (!zzsa.zzc()) {
            zzd(zzsa, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzd(zzsa, arrayList.get(i));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzsu) {
            this.zzd = true;
        }
        this.zza.put(zzsa, obj);
    }

    private zzsb(boolean z) {
        zzb();
        zzb();
    }
}
