package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzv extends zzaet implements zzaga {
    /* access modifiers changed from: private */
    public static final zzv zzb;
    private int zzd;
    private String zze = "";
    private long zzf;
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private long zzj;
    private long zzk;
    private String zzl = "";
    private long zzm;
    private String zzn = "";
    private String zzo = "";
    private zzaez zzp = zzaF();
    private int zzq;

    static {
        zzv zzv = new zzv();
        zzb = zzv;
        zzaet.zzaM(zzv.class, zzv);
    }

    private zzv() {
    }

    public static zzr zza() {
        return (zzr) zzb.zzay();
    }

    static /* synthetic */ void zzc(zzv zzv, long j) {
        zzv.zzd |= 2;
        zzv.zzf = j;
    }

    static /* synthetic */ void zzd(zzv zzv, String str) {
        str.getClass();
        zzv.zzd |= 4;
        zzv.zzg = str;
    }

    static /* synthetic */ void zze(zzv zzv, String str) {
        str.getClass();
        zzv.zzd |= 8;
        zzv.zzh = str;
    }

    static /* synthetic */ void zzf(zzv zzv, String str) {
        zzv.zzd |= 16;
        zzv.zzi = str;
    }

    static /* synthetic */ void zzg(zzv zzv, String str) {
        zzv.zzd |= 1024;
        zzv.zzo = str;
    }

    static /* synthetic */ void zzh(zzv zzv, String str) {
        str.getClass();
        zzv.zzd |= 1;
        zzv.zze = str;
    }

    static /* synthetic */ void zzi(zzv zzv, int i) {
        zzv.zzq = i - 1;
        zzv.zzd |= 2048;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaJ(zzb, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\rဌ\u000b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", zzt.class, "zzq", zzu.zza});
        } else if (i2 == 3) {
            return new zzv();
        } else {
            if (i2 == 4) {
                return new zzr((zzq) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
