package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzmg extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzmg zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzmg zzmg = new zzmg();
        zzb = zzmg;
        zzsh.zzG(zzmg.class, zzmg);
    }

    private zzmg() {
    }

    public static zzmf zza() {
        return (zzmf) zzb.zzu();
    }

    static /* synthetic */ void zzd(zzmg zzmg, String str) {
        str.getClass();
        zzmg.zzd |= 1;
        zzmg.zze = str;
    }

    static /* synthetic */ void zze(zzmg zzmg, String str) {
        str.getClass();
        zzmg.zzd |= 2;
        zzmg.zzf = str;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzmg();
        } else {
            if (i2 == 4) {
                return new zzmf((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
