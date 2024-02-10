package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzov extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzov zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzov zzov = new zzov();
        zzb = zzov;
        zzsh.zzG(zzov.class, zzov);
    }

    private zzov() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zzd", "zze", zzka.zza(), "zzf", zzka.zza()});
        } else if (i2 == 3) {
            return new zzov();
        } else {
            if (i2 == 4) {
                return new zzou((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
