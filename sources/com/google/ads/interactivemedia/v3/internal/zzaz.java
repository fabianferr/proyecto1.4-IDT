package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzaz extends zzaet implements zzaga {
    /* access modifiers changed from: private */
    public static final zzaz zzb;
    private int zzd;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private int zzk = 1000;
    private long zzl = -1;
    private long zzm = -1;
    private long zzn = -1;
    private int zzo = 1000;
    private long zzp = -1;
    private long zzq = -1;
    private long zzr = -1;
    private long zzs = -1;
    private long zzt;
    private long zzu;
    private long zzv = -1;
    private long zzw = -1;
    private long zzx = -1;
    private long zzy = -1;

    static {
        zzaz zzaz = new zzaz();
        zzb = zzaz;
        zzaet.zzaM(zzaz.class, zzaz);
    }

    private zzaz() {
    }

    public static zzay zza() {
        return (zzay) zzb.zzay();
    }

    static /* synthetic */ void zzc(zzaz zzaz, long j) {
        zzaz.zzd |= 1;
        zzaz.zze = j;
    }

    static /* synthetic */ void zzd(zzaz zzaz, long j) {
        zzaz.zzd |= 2;
        zzaz.zzf = j;
    }

    static /* synthetic */ void zze(zzaz zzaz, long j) {
        zzaz.zzd |= 4;
        zzaz.zzg = j;
    }

    static /* synthetic */ void zzf(zzaz zzaz, long j) {
        zzaz.zzd |= 8;
        zzaz.zzh = j;
    }

    static /* synthetic */ void zzg(zzaz zzaz) {
        zzaz.zzd &= -9;
        zzaz.zzh = -1;
    }

    static /* synthetic */ void zzh(zzaz zzaz, long j) {
        zzaz.zzd |= 16;
        zzaz.zzi = j;
    }

    static /* synthetic */ void zzi(zzaz zzaz, long j) {
        zzaz.zzd |= 32;
        zzaz.zzj = j;
    }

    static /* synthetic */ void zzk(zzaz zzaz, long j) {
        zzaz.zzd |= 128;
        zzaz.zzl = j;
    }

    static /* synthetic */ void zzl(zzaz zzaz, long j) {
        zzaz.zzd |= 256;
        zzaz.zzm = j;
    }

    static /* synthetic */ void zzm(zzaz zzaz, long j) {
        zzaz.zzd |= 512;
        zzaz.zzn = j;
    }

    static /* synthetic */ void zzn(zzaz zzaz, long j) {
        zzaz.zzd |= 2048;
        zzaz.zzp = j;
    }

    static /* synthetic */ void zzo(zzaz zzaz, long j) {
        zzaz.zzd |= 4096;
        zzaz.zzq = j;
    }

    static /* synthetic */ void zzp(zzaz zzaz, long j) {
        zzaz.zzd |= 8192;
        zzaz.zzr = j;
    }

    static /* synthetic */ void zzq(zzaz zzaz, long j) {
        zzaz.zzd |= 16384;
        zzaz.zzs = j;
    }

    static /* synthetic */ void zzr(zzaz zzaz, long j) {
        zzaz.zzd |= 32768;
        zzaz.zzt = j;
    }

    static /* synthetic */ void zzs(zzaz zzaz, long j) {
        zzaz.zzd |= 65536;
        zzaz.zzu = j;
    }

    static /* synthetic */ void zzt(zzaz zzaz, long j) {
        zzaz.zzd |= 131072;
        zzaz.zzv = j;
    }

    static /* synthetic */ void zzu(zzaz zzaz, long j) {
        zzaz.zzd |= 262144;
        zzaz.zzw = j;
    }

    static /* synthetic */ void zzv(zzaz zzaz, int i) {
        zzaz.zzk = i - 1;
        zzaz.zzd |= 64;
    }

    static /* synthetic */ void zzw(zzaz zzaz, int i) {
        zzaz.zzo = i - 1;
        zzaz.zzd |= 1024;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzaex zzaex = zzbi.zza;
            return zzaJ(zzb, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဌ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဌ\n\fဂ\u000b\rဂ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ\u0014", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzaex, "zzl", "zzm", "zzn", "zzo", zzaex, "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy"});
        } else if (i2 == 3) {
            return new zzaz();
        } else {
            if (i2 == 4) {
                return new zzay((zzae) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
