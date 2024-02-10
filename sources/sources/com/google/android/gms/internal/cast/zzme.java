package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzme extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzme zzb;
    private int zzd;
    private int zze;
    private boolean zzf;
    private int zzg;
    private boolean zzh;
    private zzsp zzi = zzz();
    private zzsp zzj = zzz();
    private String zzk = "";

    static {
        zzme zzme = new zzme();
        zzb = zzme;
        zzsh.zzG(zzme.class, zzme);
    }

    private zzme() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzb, "\u0001\u0007\u0000\u0001\u0001\t\u0007\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0007\u001b\b\u001b\tဈ\u0004", new Object[]{"zzd", "zze", zzgo.zza(), "zzf", "zzg", zzie.zza(), "zzh", "zzi", zzon.class, "zzj", zzon.class, "zzk"});
        } else if (i2 == 3) {
            return new zzme();
        } else {
            if (i2 == 4) {
                return new zzmd((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
