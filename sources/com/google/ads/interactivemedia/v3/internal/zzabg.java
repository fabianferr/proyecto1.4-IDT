package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzabg extends zzxi {
    zzabg() {
    }

    private static final zzwr zzb(zzacv zzacv, int i) throws IOException {
        int i2 = i - 1;
        if (i2 == 5) {
            return new zzww(zzacv.zzi());
        }
        if (i2 == 6) {
            return new zzww((Number) new zzyq(zzacv.zzi()));
        }
        if (i2 == 7) {
            return new zzww(Boolean.valueOf(zzacv.zzs()));
        }
        if (i2 == 8) {
            zzacv.zzn();
            return zzwt.zza;
        }
        throw new IllegalStateException("Unexpected token: ".concat(zzacw.zza(i)));
    }

    private static final zzwr zzc(zzacv zzacv, int i) throws IOException {
        int i2 = i - 1;
        if (i2 == 0) {
            zzacv.zzj();
            return new zzwp();
        } else if (i2 != 2) {
            return null;
        } else {
            zzacv.zzk();
            return new zzwu();
        }
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        int zzt = zzacv.zzt();
        zzwr zzc = zzc(zzacv, zzt);
        if (zzc == null) {
            return zzb(zzacv, zzt);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (zzacv.zzq()) {
                String zzh = zzc instanceof zzwu ? zzacv.zzh() : null;
                int zzt2 = zzacv.zzt();
                zzwr zzc2 = zzc(zzacv, zzt2);
                zzwr zzb = zzc2 == null ? zzb(zzacv, zzt2) : zzc2;
                if (zzc instanceof zzwp) {
                    ((zzwp) zzc).zza(zzb);
                } else {
                    ((zzwu) zzc).zzb(zzh, zzb);
                }
                if (zzc2 != null) {
                    arrayDeque.addLast(zzc);
                    zzc = zzb;
                }
            } else {
                if (zzc instanceof zzwp) {
                    zzacv.zzl();
                } else {
                    zzacv.zzm();
                }
                if (arrayDeque.isEmpty()) {
                    return zzc;
                }
                zzc = (zzwr) arrayDeque.removeLast();
            }
        }
    }

    /* renamed from: zza */
    public final void write(zzacx zzacx, zzwr zzwr) throws IOException {
        if (zzwr == null || (zzwr instanceof zzwt)) {
            zzacx.zzf();
        } else if (zzwr instanceof zzww) {
            zzww zzww = (zzww) zzwr;
            if (zzww.zzf()) {
                zzacx.zzj(zzww.zza());
            } else if (zzww.zze()) {
                zzacx.zzl(zzww.zzd());
            } else {
                zzacx.zzk(zzww.zzb());
            }
        } else if (zzwr instanceof zzwp) {
            zzacx.zza();
            Iterator it = ((zzwp) zzwr).iterator();
            while (it.hasNext()) {
                write(zzacx, (zzwr) it.next());
            }
            zzacx.zzc();
        } else if (zzwr instanceof zzwu) {
            zzacx.zzb();
            for (Map.Entry entry : ((zzwu) zzwr).zza()) {
                zzacx.zze((String) entry.getKey());
                write(zzacx, (zzwr) entry.getValue());
            }
            zzacx.zzd();
        } else {
            throw new IllegalArgumentException("Couldn't write ".concat(String.valueOf(String.valueOf(zzwr.getClass()))));
        }
    }
}
