package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzmo extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzmo zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private int zzi;

    static {
        zzmo zzmo = new zzmo();
        zzb = zzmo;
        zzsh.zzG(zzmo.class, zzmo);
    }

    private zzmo() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0005င\u0004", new Object[]{"zzd", "zze", zzka.zza(), "zzf", zzju.zza(), "zzg", zzjx.zza(), "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzmo();
        } else {
            if (i2 == 4) {
                return new zzmn((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
