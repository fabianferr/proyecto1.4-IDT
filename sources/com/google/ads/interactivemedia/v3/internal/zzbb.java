package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzbb extends zzaet implements zzaga {
    /* access modifiers changed from: private */
    public static final zzbb zzb;
    private int zzd;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private long zzk = -1;
    private long zzl = -1;

    static {
        zzbb zzbb = new zzbb();
        zzb = zzbb;
        zzaet.zzaM(zzbb.class, zzbb);
    }

    private zzbb() {
    }

    public static zzba zza() {
        return (zzba) zzb.zzay();
    }

    static /* synthetic */ void zzc(zzbb zzbb, long j) {
        zzbb.zzd |= 1;
        zzbb.zze = j;
    }

    static /* synthetic */ void zzd(zzbb zzbb, long j) {
        zzbb.zzd |= 4;
        zzbb.zzg = j;
    }

    static /* synthetic */ void zze(zzbb zzbb, long j) {
        zzbb.zzd |= 8;
        zzbb.zzh = j;
    }

    static /* synthetic */ void zzf(zzbb zzbb, long j) {
        zzbb.zzd |= 16;
        zzbb.zzi = j;
    }

    static /* synthetic */ void zzg(zzbb zzbb, long j) {
        zzbb.zzd |= 32;
        zzbb.zzj = j;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaJ(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        } else if (i2 == 3) {
            return new zzbb();
        } else {
            if (i2 == 4) {
                return new zzba((zzae) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
