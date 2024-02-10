package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzpp extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzpp zzb;
    private int zzd;
    private int zze;
    private long zzf;
    private long zzg;

    static {
        zzpp zzpp = new zzpp();
        zzb = zzpp;
        zzsh.zzG(zzpp.class, zzpp);
    }

    private zzpp() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဂ\u0001\u0003ဂ\u0002", new Object[]{"zzd", "zze", zzlk.zza(), "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzpp();
        } else {
            if (i2 == 4) {
                return new zzpo((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
