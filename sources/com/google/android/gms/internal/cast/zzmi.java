package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzmi extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzmi zzb;
    private int zzd;
    private zznc zze;
    private boolean zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private zzov zzm;
    private int zzn;
    private int zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;
    private boolean zzs;

    static {
        zzmi zzmi = new zzmi();
        zzb = zzmi;
        zzsh.zzG(zzmi.class, zzmi);
    }

    private zzmi() {
    }

    public static zzmh zza() {
        return (zzmh) zzb.zzu();
    }

    public static zzmh zzc(zzmi zzmi) {
        zzse zzu = zzb.zzu();
        zzu.zzo(zzmi);
        return (zzmh) zzu;
    }

    public static zzmi zze() {
        return zzb;
    }

    static /* synthetic */ void zzf(zzmi zzmi, zznc zznc) {
        zznc.getClass();
        zzmi.zze = zznc;
        zzmi.zzd |= 1;
    }

    static /* synthetic */ void zzg(zzmi zzmi, boolean z) {
        zzmi.zzd |= 2;
        zzmi.zzf = z;
    }

    static /* synthetic */ void zzh(zzmi zzmi, long j) {
        zzmi.zzd |= 4;
        zzmi.zzg = j;
    }

    static /* synthetic */ void zzi(zzmi zzmi, int i) {
        zzmi.zzd |= 64;
        zzmi.zzk = i;
    }

    static /* synthetic */ void zzj(zzmi zzmi, int i) {
        zzmi.zzd |= 128;
        zzmi.zzl = i;
    }

    static /* synthetic */ void zzk(zzmi zzmi, int i) {
        zzmi.zzd |= 1024;
        zzmi.zzo = i;
    }

    static /* synthetic */ void zzl(zzmi zzmi, boolean z) {
        zzmi.zzd |= 2048;
        zzmi.zzp = z;
    }

    static /* synthetic */ void zzm(zzmi zzmi, int i) {
        zzmi.zzd |= 4096;
        zzmi.zzq = i;
    }

    static /* synthetic */ void zzn(zzmi zzmi, int i) {
        zzmi.zzd |= 8192;
        zzmi.zzr = i;
    }

    static /* synthetic */ void zzo(zzmi zzmi, boolean z) {
        zzmi.zzd |= 16384;
        zzmi.zzs = z;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzb, "\u0001\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဇ\u0001\u0003စ\u0002\u0004ဆ\u0003\u0005ဌ\u0004\u0006ဌ\u0005\u0007င\u0006\bင\u0007\tဉ\b\nဌ\t\u000bင\n\fဇ\u000b\rင\f\u000eင\r\u000fဇ\u000e", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzgu.zza(), "zzj", zzgr.zza(), "zzk", "zzl", "zzm", "zzn", zzih.zza(), "zzo", "zzp", "zzq", "zzr", "zzs"});
        } else if (i2 == 3) {
            return new zzmi();
        } else {
            if (i2 == 4) {
                return new zzmh((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
