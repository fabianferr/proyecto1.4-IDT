package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzbl extends zzaet implements zzaga {
    /* access modifiers changed from: private */
    public static final zzbl zzb;
    private int zzd;
    private long zze;
    private String zzf = "";
    private zzadr zzg = zzadr.zzb;

    static {
        zzbl zzbl = new zzbl();
        zzb = zzbl;
        zzaet.zzaM(zzbl.class, zzbl);
    }

    private zzbl() {
    }

    public static zzbl zzc() {
        return zzb;
    }

    public final long zza() {
        return this.zze;
    }

    public final boolean zzd() {
        return (this.zzd & 1) != 0;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaJ(zzb, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzbl();
        } else {
            if (i2 == 4) {
                return new zzbk((zzae) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
