package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzpb extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzpb zzb;
    private int zzd;
    private String zze = "";
    private zzsp zzf = zzz();
    private zzsp zzg = zzz();
    private boolean zzh;

    static {
        zzpb zzpb = new zzpb();
        zzb = zzpb;
        zzsh.zzG(zzpb.class, zzpb);
    }

    private zzpb() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဈ\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001", new Object[]{"zzd", "zze", "zzf", zznr.class, "zzg", zznc.class, "zzh"});
        } else if (i2 == 3) {
            return new zzpb();
        } else {
            if (i2 == 4) {
                return new zzpa((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
