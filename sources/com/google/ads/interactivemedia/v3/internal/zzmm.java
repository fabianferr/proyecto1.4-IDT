package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzmm extends zzaet implements zzaga {
    /* access modifiers changed from: private */
    public static final zzmm zzb;
    private int zzd;
    private zzmp zze;
    private zzadr zzf = zzadr.zzb;
    private zzadr zzg = zzadr.zzb;

    static {
        zzmm zzmm = new zzmm();
        zzb = zzmm;
        zzaet.zzaM(zzmm.class, zzmm);
    }

    private zzmm() {
    }

    public static zzmm zzb(zzadr zzadr, zzaef zzaef) throws zzafc {
        return (zzmm) zzaet.zzaC(zzb, zzadr, zzaef);
    }

    public final zzmp zzc() {
        zzmp zzmp = this.zze;
        return zzmp == null ? zzmp.zzf() : zzmp;
    }

    public final zzadr zzd() {
        return this.zzg;
    }

    public final zzadr zze() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaJ(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzmm();
        } else {
            if (i2 == 4) {
                return new zzml((zzmk) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
