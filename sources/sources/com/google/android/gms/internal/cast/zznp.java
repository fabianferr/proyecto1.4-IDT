package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zznp extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zznp zzb;
    private int zzd;
    private int zze;

    static {
        zznp zznp = new zznp();
        zzb = zznp;
        zzsh.zzG(zznp.class, zznp);
    }

    private zznp() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzd", "zze", zziq.zza()});
        } else if (i2 == 3) {
            return new zznp();
        } else {
            if (i2 == 4) {
                return new zzno((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
