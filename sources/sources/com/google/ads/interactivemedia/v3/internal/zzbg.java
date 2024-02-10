package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzbg extends zzaet implements zzaga {
    /* access modifiers changed from: private */
    public static final zzbg zzb;
    private int zzd;
    private zzadr zze = zzadr.zzb;
    private zzadr zzf;
    private zzadr zzg;
    private zzadr zzh;

    static {
        zzbg zzbg = new zzbg();
        zzb = zzbg;
        zzaet.zzaM(zzbg.class, zzbg);
    }

    private zzbg() {
        zzadr zzadr = zzadr.zzb;
        this.zzf = zzadr;
        this.zzg = zzadr;
        this.zzh = zzadr;
    }

    public static zzbf zza() {
        return (zzbf) zzb.zzay();
    }

    public static zzbg zzc(byte[] bArr, zzaef zzaef) throws zzafc {
        return (zzbg) zzaet.zzaD(zzb, bArr, zzaef);
    }

    static /* synthetic */ void zzh(zzbg zzbg, zzadr zzadr) {
        zzbg.zzd |= 1;
        zzbg.zze = zzadr;
    }

    static /* synthetic */ void zzi(zzbg zzbg, zzadr zzadr) {
        zzbg.zzd |= 2;
        zzbg.zzf = zzadr;
    }

    static /* synthetic */ void zzk(zzbg zzbg, zzadr zzadr) {
        zzbg.zzd |= 4;
        zzbg.zzg = zzadr;
    }

    static /* synthetic */ void zzl(zzbg zzbg, zzadr zzadr) {
        zzbg.zzd |= 8;
        zzbg.zzh = zzadr;
    }

    public final zzadr zzd() {
        return this.zze;
    }

    public final zzadr zze() {
        return this.zzf;
    }

    public final zzadr zzf() {
        return this.zzh;
    }

    public final zzadr zzg() {
        return this.zzg;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaJ(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzbg();
        } else {
            if (i2 == 4) {
                return new zzbf((zzae) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
