package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzoh extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzoh zzb;
    private int zzd;
    private long zze;
    private zzso zzf = zzy();
    private zzso zzg = zzy();

    static {
        zzoh zzoh = new zzoh();
        zzb = zzoh;
        zzsh.zzG(zzoh.class, zzoh);
    }

    private zzoh() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001စ\u0000\u0002\u0017\u0003\u0017", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzoh();
        } else {
            if (i2 == 4) {
                return new zzog((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
