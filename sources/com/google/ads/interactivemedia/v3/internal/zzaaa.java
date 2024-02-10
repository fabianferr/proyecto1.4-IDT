package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzaaa extends zzxi {
    private static final zzxj zza = new zzzy(zzxf.DOUBLE);
    private final zzwm zzb;
    private final zzxg zzc;

    /* synthetic */ zzaaa(zzwm zzwm, zzxg zzxg, zzzz zzzz) {
        this.zzb = zzwm;
        this.zzc = zzxg;
    }

    public static zzxj zza(zzxg zzxg) {
        return zzxg == zzxf.DOUBLE ? zza : new zzzy(zzxg);
    }

    private final Object zzb(zzacv zzacv, int i) throws IOException {
        int i2 = i - 1;
        if (i2 == 5) {
            return zzacv.zzi();
        }
        if (i2 == 6) {
            return this.zzc.zza(zzacv);
        }
        if (i2 == 7) {
            return Boolean.valueOf(zzacv.zzs());
        }
        if (i2 == 8) {
            zzacv.zzn();
            return null;
        }
        throw new IllegalStateException("Unexpected token: ".concat(zzacw.zza(i)));
    }

    private static final Object zzc(zzacv zzacv, int i) throws IOException {
        int i2 = i - 1;
        if (i2 == 0) {
            zzacv.zzj();
            return new ArrayList();
        } else if (i2 != 2) {
            return null;
        } else {
            zzacv.zzk();
            return new zzyy();
        }
    }

    public final Object read(zzacv zzacv) throws IOException {
        int zzt = zzacv.zzt();
        Object zzc2 = zzc(zzacv, zzt);
        if (zzc2 == null) {
            return zzb(zzacv, zzt);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (zzacv.zzq()) {
                String zzh = zzc2 instanceof Map ? zzacv.zzh() : null;
                int zzt2 = zzacv.zzt();
                Object zzc3 = zzc(zzacv, zzt2);
                Object zzb2 = zzc3 == null ? zzb(zzacv, zzt2) : zzc3;
                if (zzc2 instanceof List) {
                    ((List) zzc2).add(zzb2);
                } else {
                    ((Map) zzc2).put(zzh, zzb2);
                }
                if (zzc3 != null) {
                    arrayDeque.addLast(zzc2);
                    zzc2 = zzb2;
                }
            } else {
                if (zzc2 instanceof List) {
                    zzacv.zzl();
                } else {
                    zzacv.zzm();
                }
                if (arrayDeque.isEmpty()) {
                    return zzc2;
                }
                zzc2 = arrayDeque.removeLast();
            }
        }
    }

    public final void write(zzacx zzacx, Object obj) throws IOException {
        if (obj == null) {
            zzacx.zzf();
            return;
        }
        zzxi zza2 = this.zzb.zza(zzact.zza(obj.getClass()));
        if (zza2 instanceof zzaaa) {
            zzacx.zzb();
            zzacx.zzd();
            return;
        }
        zza2.write(zzacx, obj);
    }
}
