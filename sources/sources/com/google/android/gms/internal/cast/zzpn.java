package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzpn extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzpn zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zzsp zzg = zzz();
    private zzsp zzh = zzz();
    private int zzi;

    static {
        zzpn zzpn = new zzpn();
        zzb = zzpn;
        zzsh.zzG(zzpn.class, zzpn);
    }

    private zzpn() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003\u001b\u0004\u001b\u0005ဌ\u0002", new Object[]{"zzd", "zze", zzlb.zza(), "zzf", zzle.zza(), "zzg", zznc.class, "zzh", zznc.class, "zzi", zzie.zza()});
        } else if (i2 == 3) {
            return new zzpn();
        } else {
            if (i2 == 4) {
                return new zzpm((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
