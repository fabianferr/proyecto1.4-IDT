package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzm extends zzaet implements zzaga {
    /* access modifiers changed from: private */
    public static final zzm zzb;
    private int zzd;
    private int zze;
    private boolean zzf = true;
    private String zzg = "unknown_host";
    private boolean zzh;
    private boolean zzi = true;

    static {
        zzm zzm = new zzm();
        zzb = zzm;
        zzaet.zzaM(zzm.class, zzm);
    }

    private zzm() {
    }

    public static zzl zza() {
        return (zzl) zzb.zzay();
    }

    static /* synthetic */ void zzd(zzm zzm, boolean z) {
        zzm.zzd |= 16;
        zzm.zzi = false;
    }

    static /* synthetic */ void zze(zzm zzm, String str) {
        zzm.zzd |= 4;
        zzm.zzg = "a.3.30.3";
    }

    static /* synthetic */ void zzf(zzm zzm, boolean z) {
        zzm.zzd |= 8;
        zzm.zzh = false;
    }

    static /* synthetic */ void zzl(zzm zzm, int i) {
        zzm.zze = i - 1;
        zzm.zzd |= 1;
    }

    public final String zzc() {
        return this.zzg;
    }

    public final boolean zzg() {
        return this.zzh;
    }

    public final boolean zzh() {
        return this.zzi;
    }

    public final boolean zzi() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaJ(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဇ\u0003\u0005ဇ\u0004", new Object[]{"zzd", "zze", zzo.zza, "zzf", "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzm();
        } else {
            if (i2 == 4) {
                return new zzl((zzk) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final int zzk() {
        int zza = zzp.zza(this.zze);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }
}
