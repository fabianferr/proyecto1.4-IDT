package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzaa extends zzaet implements zzaga {
    /* access modifiers changed from: private */
    public static final zzaa zzb;
    private int zzd;
    private int zze = 2;

    static {
        zzaa zzaa = new zzaa();
        zzb = zzaa;
        zzaet.zzaM(zzaa.class, zzaa);
    }

    private zzaa() {
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaJ(zzb, "\u0001\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001bဌ\u0000", new Object[]{"zzd", "zze", zzab.zza});
        } else if (i2 == 3) {
            return new zzaa();
        } else {
            if (i2 == 4) {
                return new zzz((zzw) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
