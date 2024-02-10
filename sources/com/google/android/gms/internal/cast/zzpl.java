package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzpl extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzpl zzb;
    private int zzd;
    private int zze;
    private zzsp zzf = zzz();
    private zzsp zzg = zzz();
    private int zzh;

    static {
        zzpl zzpl = new zzpl();
        zzb = zzpl;
        zzsh.zzG(zzpl.class, zzpl);
    }

    private zzpl() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဌ\u0000\u0002\u001b\u0003\u001b\u0004င\u0001", new Object[]{"zzd", "zze", zzky.zza(), "zzf", zzon.class, "zzg", zzon.class, "zzh"});
        } else if (i2 == 3) {
            return new zzpl();
        } else {
            if (i2 == 4) {
                return new zzpk((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
