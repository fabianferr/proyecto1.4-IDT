package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzbp extends zzaet implements zzaga {
    /* access modifiers changed from: private */
    public static final zzbp zzb;
    private int zzd;
    private zzaez zze = zzaF();
    private zzadr zzf = zzadr.zzb;
    private int zzg = 1;
    private int zzh = 1;

    static {
        zzbp zzbp = new zzbp();
        zzb = zzbp;
        zzaet.zzaM(zzbp.class, zzbp);
    }

    private zzbp() {
    }

    public static zzbo zza() {
        return (zzbo) zzb.zzay();
    }

    static /* synthetic */ void zzc(zzbp zzbp, zzadr zzadr) {
        zzaez zzaez = zzbp.zze;
        if (!zzaez.zzc()) {
            zzbp.zze = zzaet.zzaG(zzaez);
        }
        zzbp.zze.add(zzadr);
    }

    static /* synthetic */ void zzd(zzbp zzbp, zzadr zzadr) {
        zzbp.zzd |= 1;
        zzbp.zzf = zzadr;
    }

    static /* synthetic */ void zze(zzbp zzbp, int i) {
        zzbp.zzh = 4;
        zzbp.zzd = 4 | zzbp.zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaJ(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003ဌ\u0001\u0004ဌ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg", zzbj.zza, "zzh", zzbh.zza});
        } else if (i2 == 3) {
            return new zzbp();
        } else {
            if (i2 == 4) {
                return new zzbo((zzae) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
