package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzgl extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzgl zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private zzgh zzi;
    private int zzj;

    static {
        zzgl zzgl = new zzgl();
        zzb = zzgl;
        zzsh.zzG(zzgl.class, zzgl);
    }

    private zzgl() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဌ\u0001\u0003င\u0002\u0004င\u0003\u0005ဉ\u0004\u0006ဌ\u0005", new Object[]{"zzd", "zze", "zzf", zzgk.zza, "zzg", "zzh", "zzi", "zzj", zzgj.zza});
        } else if (i2 == 3) {
            return new zzgl();
        } else {
            if (i2 == 4) {
                return new zzgi((zzfz) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
