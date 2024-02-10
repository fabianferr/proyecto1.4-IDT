package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zznc extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zznc zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zznc zznc = new zznc();
        zzb = zznc;
        zzsh.zzG(zznc.class, zznc);
    }

    private zznc() {
    }

    public static zznb zza() {
        return (zznb) zzb.zzu();
    }

    static /* synthetic */ void zzd(zznc zznc, String str) {
        str.getClass();
        zznc.zzd |= 1;
        zznc.zze = str;
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
            return new zznc();
        } else {
            if (i2 == 4) {
                return new zznb((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
