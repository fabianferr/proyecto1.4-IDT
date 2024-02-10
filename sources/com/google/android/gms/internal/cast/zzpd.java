package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzpd extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzpd zzb;
    private int zzd;
    private zzmc zze;

    static {
        zzpd zzpd = new zzpd();
        zzb = zzpd;
        zzsh.zzG(zzpd.class, zzpd);
    }

    private zzpd() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzd", "zze"});
        } else if (i2 == 3) {
            return new zzpd();
        } else {
            if (i2 == 4) {
                return new zzpc((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
