package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzna extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzna zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zzmc zzg;

    static {
        zzna zzna = new zzna();
        zzb = zzna;
        zzsh.zzG(zzna.class, zzna);
    }

    private zzna() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzhy.zza(), "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzna();
        } else {
            if (i2 == 4) {
                return new zzmz((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
