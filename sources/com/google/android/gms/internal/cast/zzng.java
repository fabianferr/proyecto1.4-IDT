package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzng extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzng zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private zzsp zzh = zzz();

    static {
        zzng zzng = new zzng();
        zzb = zzng;
        zzsh.zzG(zzng.class, zzng);
    }

    private zzng() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004\u001b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zznf.class});
        } else if (i2 == 3) {
            return new zzng();
        } else {
            if (i2 == 4) {
                return new zznd((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
