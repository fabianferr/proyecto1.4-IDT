package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzao extends zzaet implements zzaga {
    /* access modifiers changed from: private */
    public static final zzao zzb;
    private int zzd;
    private long zze = -1;
    private int zzf = 1000;
    private int zzg = 1000;

    static {
        zzao zzao = new zzao();
        zzb = zzao;
        zzaet.zzaM(zzao.class, zzao);
    }

    private zzao() {
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzaex zzaex = zzbi.zza;
            return zzaJ(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဌ\u0001\u0003ဌ\u0002", new Object[]{"zzd", "zze", "zzf", zzaex, "zzg", zzaex});
        } else if (i2 == 3) {
            return new zzao();
        } else {
            if (i2 == 4) {
                return new zzan((zzae) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
