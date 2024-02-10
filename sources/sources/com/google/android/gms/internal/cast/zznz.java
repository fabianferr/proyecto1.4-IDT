package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zznz extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zznz zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private byte zzh = 2;

    static {
        zznz zznz = new zznz();
        zzb = zznz;
        zzsh.zzG(zznz.class, zznz);
    }

    private zznz() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        byte b = 1;
        if (i2 == 2) {
            return zzD(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ᔌ\u0000\u0002င\u0001\u0003ဌ\u0002", new Object[]{"zzd", "zze", zzjc.zza(), "zzf", "zzg", zzlt.zza()});
        } else if (i2 == 3) {
            return new zznz();
        } else {
            if (i2 == 4) {
                return new zzny((zzlu) null);
            }
            if (i2 == 5) {
                return zzb;
            }
            if (obj == null) {
                b = 0;
            }
            this.zzh = b;
            return null;
        }
    }
}
