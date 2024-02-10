package com.google.android.gms.internal.cast;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzma extends zzsh implements zztq {
    private static final zzsn zzb = new zzly();
    /* access modifiers changed from: private */
    public static final zzma zzd;
    private int zze;
    private zzmg zzf;
    private zzob zzg;
    private zzsp zzh = zzz();
    private zzsm zzi = zzx();

    static {
        zzma zzma = new zzma();
        zzd = zzma;
        zzsh.zzG(zzma.class, zzma);
    }

    private zzma() {
    }

    public static zzlz zza() {
        return (zzlz) zzd.zzu();
    }

    static /* synthetic */ void zzd(zzma zzma, zzmg zzmg) {
        zzmg.getClass();
        zzma.zzf = zzmg;
        zzma.zze |= 1;
    }

    static /* synthetic */ void zze(zzma zzma, Iterable iterable) {
        zzsm zzsm = zzma.zzi;
        if (!zzsm.zzc()) {
            int size = zzsm.size();
            zzma.zzi = zzsm.zzf(size == 0 ? 10 : size + size);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzma.zzi.zzh(((zzln) it.next()).zza());
        }
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzd, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b\u0004\u001e", new Object[]{"zze", "zzf", "zzg", "zzh", zznx.class, "zzi", zzln.zzb()});
        } else if (i2 == 3) {
            return new zzma();
        } else {
            if (i2 == 4) {
                return new zzlz((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzd;
        }
    }
}
