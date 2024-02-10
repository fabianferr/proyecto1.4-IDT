package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzmk extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzmk zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzmk zzmk = new zzmk();
        zzb = zzmk;
        zzsh.zzG(zzmk.class, zzmk);
    }

    private zzmk() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဋ\u0000\u0002ဋ\u0001\u0003ဌ\u0002\u0004င\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", zziz.zza(), "zzh"});
        } else if (i2 == 3) {
            return new zzmk();
        } else {
            if (i2 == 4) {
                return new zzmj((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
