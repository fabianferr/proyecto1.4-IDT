package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzlx extends zzsh implements zztq {
    private static final zzsn zzb = new zzlv();
    /* access modifiers changed from: private */
    public static final zzlx zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private zzsm zzh = zzx();

    static {
        zzlx zzlx = new zzlx();
        zzd = zzlx;
        zzsh.zzG(zzlx.class, zzlx);
    }

    private zzlx() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzd, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001e", new Object[]{"zze", "zzf", "zzg", "zzh", zzln.zzb()});
        } else if (i2 == 3) {
            return new zzlx();
        } else {
            if (i2 == 4) {
                return new zzlw((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzd;
        }
    }
}
