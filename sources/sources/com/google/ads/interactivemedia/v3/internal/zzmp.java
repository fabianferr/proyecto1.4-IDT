package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzmp extends zzaet implements zzaga {
    /* access modifiers changed from: private */
    public static final zzmp zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private long zzh;
    private long zzi;

    static {
        zzmp zzmp = new zzmp();
        zzb = zzmp;
        zzaet.zzaM(zzmp.class, zzmp);
    }

    private zzmp() {
    }

    public static zzmo zzd() {
        return (zzmo) zzb.zzay();
    }

    public static zzmp zzf() {
        return zzb;
    }

    public static zzmp zzg(zzadr zzadr) throws zzafc {
        return (zzmp) zzaet.zzaB(zzb, zzadr);
    }

    public static zzmp zzh(zzadr zzadr, zzaef zzaef) throws zzafc {
        return (zzmp) zzaet.zzaC(zzb, zzadr, zzaef);
    }

    static /* synthetic */ void zzl(zzmp zzmp, String str) {
        str.getClass();
        zzmp.zzd |= 1;
        zzmp.zze = str;
    }

    static /* synthetic */ void zzm(zzmp zzmp, long j) {
        zzmp.zzd |= 16;
        zzmp.zzi = j;
    }

    static /* synthetic */ void zzn(zzmp zzmp, String str) {
        str.getClass();
        zzmp.zzd |= 2;
        zzmp.zzf = str;
    }

    static /* synthetic */ void zzo(zzmp zzmp, long j) {
        zzmp.zzd |= 4;
        zzmp.zzg = j;
    }

    static /* synthetic */ void zzp(zzmp zzmp, long j) {
        zzmp.zzd |= 8;
        zzmp.zzh = j;
    }

    public final long zza() {
        return this.zzh;
    }

    public final long zzb() {
        return this.zzg;
    }

    public final long zzc() {
        return this.zzi;
    }

    public final String zzi() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaJ(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzmp();
        } else {
            if (i2 == 4) {
                return new zzmo((zzmn) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final String zzk() {
        return this.zze;
    }
}
