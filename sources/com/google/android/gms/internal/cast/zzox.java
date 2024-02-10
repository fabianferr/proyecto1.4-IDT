package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzox extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzox zzb;
    private int zzd;
    private zznc zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private long zzj;
    private zzsp zzk = zzz();

    static {
        zzox zzox = new zzox();
        zzb = zzox;
        zzsh.zzG(zzox.class, zzox);
    }

    private zzox() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဌ\u0004\u0006ဂ\u0005\u0007\u001b", new Object[]{"zzd", "zze", "zzf", zzkg.zza(), "zzg", zzkd.zza(), "zzh", zzie.zza(), "zzi", zzha.zza(), "zzj", "zzk", zznc.class});
        } else if (i2 == 3) {
            return new zzox();
        } else {
            if (i2 == 4) {
                return new zzow((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
