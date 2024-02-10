package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzms extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzms zzb;
    private int zzd;
    private String zze = "";
    private long zzf;

    static {
        zzms zzms = new zzms();
        zzb = zzms;
        zzsh.zzG(zzms.class, zzms);
    }

    private zzms() {
    }

    public static zzmr zza() {
        return (zzmr) zzb.zzu();
    }

    static /* synthetic */ void zzd(zzms zzms, String str) {
        str.getClass();
        zzms.zzd |= 1;
        zzms.zze = str;
    }

    static /* synthetic */ void zze(zzms zzms, long j) {
        zzms.zzd |= 2;
        zzms.zzf = j;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzms();
        } else {
            if (i2 == 4) {
                return new zzmr((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
