package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzot extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzot zzb;
    private int zzd;
    private zzsp zze = zzz();
    private zzsp zzf = zzz();
    private zzpd zzg;

    static {
        zzot zzot = new zzot();
        zzb = zzot;
        zzsh.zzG(zzot.class, zzot);
    }

    private zzot() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u001b\u0002\u001b\u0003ဉ\u0000", new Object[]{"zzd", "zze", zzpj.class, "zzf", zzna.class, "zzg"});
        } else if (i2 == 3) {
            return new zzot();
        } else {
            if (i2 == 4) {
                return new zzos((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
