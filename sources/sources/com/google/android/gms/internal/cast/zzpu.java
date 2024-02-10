package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzpu extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzpu zzb;
    private int zzd;
    private String zze = "";
    private long zzf;
    private long zzg;
    private zzpw zzh;

    static {
        zzpu zzpu = new zzpu();
        zzb = zzpu;
        zzsh.zzG(zzpu.class, zzpu);
    }

    private zzpu() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဉ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzpu();
        } else {
            if (i2 == 4) {
                return new zzpt((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
