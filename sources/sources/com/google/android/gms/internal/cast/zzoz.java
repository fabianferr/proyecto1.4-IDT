package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzoz extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzoz zzb;
    private int zzd;
    private long zze;
    private long zzf;
    private zzsp zzg = zzz();

    static {
        zzoz zzoz = new zzoz();
        zzb = zzoz;
        zzsh.zzG(zzoz.class, zzoz);
    }

    private zzoz() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003\u001b", new Object[]{"zzd", "zze", "zzf", "zzg", zzpb.class});
        } else if (i2 == 3) {
            return new zzoz();
        } else {
            if (i2 == 4) {
                return new zzoy((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
