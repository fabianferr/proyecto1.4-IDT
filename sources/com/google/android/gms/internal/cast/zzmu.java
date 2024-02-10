package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzmu extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzmu zzb;
    private int zzd;
    private String zze = "";
    private long zzf;
    private long zzg;
    private zzsp zzh = zzz();
    private int zzi;
    private boolean zzj;
    private String zzk = "";
    private long zzl;
    private long zzm;

    static {
        zzmu zzmu = new zzmu();
        zzb = zzmu;
        zzsh.zzG(zzmu.class, zzmu);
    }

    private zzmu() {
    }

    public static zzmt zza() {
        return (zzmt) zzb.zzu();
    }

    static /* synthetic */ void zzd(zzmu zzmu, String str) {
        str.getClass();
        zzmu.zzd |= 1;
        zzmu.zze = str;
    }

    static /* synthetic */ void zze(zzmu zzmu, long j) {
        zzmu.zzd |= 2;
        zzmu.zzf = j;
    }

    static /* synthetic */ void zzf(zzmu zzmu, long j) {
        zzmu.zzd |= 4;
        zzmu.zzg = j;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.util.Collection, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void zzg(com.google.android.gms.internal.cast.zzmu r3, java.lang.Iterable r4) {
        /*
            com.google.android.gms.internal.cast.zzsp r0 = r3.zzh
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x000e
            com.google.android.gms.internal.cast.zzsp r0 = com.google.android.gms.internal.cast.zzsh.zzA(r0)
            r3.zzh = r0
        L_0x000e:
            com.google.android.gms.internal.cast.zzsp r3 = r3.zzh
            byte[] r0 = com.google.android.gms.internal.cast.zzsq.zzd
            boolean r0 = r3 instanceof java.util.ArrayList
            if (r0 == 0) goto L_0x0025
            r0 = r3
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r1 = r3.size()
            int r2 = r4.size()
            int r1 = r1 + r2
            r0.ensureCapacity(r1)
        L_0x0025:
            int r0 = r3.size()
            java.util.Iterator r4 = r4.iterator()
        L_0x002d:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x0067
            java.lang.Object r1 = r4.next()
            if (r1 != 0) goto L_0x0063
            int r4 = r3.size()
            int r4 = r4 - r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Element at index "
            r1.<init>(r2)
            r1.append(r4)
            java.lang.String r4 = " is null."
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            int r1 = r3.size()
        L_0x0055:
            int r1 = r1 + -1
            if (r1 < r0) goto L_0x005d
            r3.remove(r1)
            goto L_0x0055
        L_0x005d:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            r3.<init>(r4)
            throw r3
        L_0x0063:
            r3.add(r1)
            goto L_0x002d
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzmu.zzg(com.google.android.gms.internal.cast.zzmu, java.lang.Iterable):void");
    }

    static /* synthetic */ void zzh(zzmu zzmu, int i) {
        zzmu.zzd |= 8;
        zzmu.zzi = i;
    }

    static /* synthetic */ void zzi(zzmu zzmu, boolean z) {
        zzmu.zzd |= 16;
        zzmu.zzj = z;
    }

    static /* synthetic */ void zzj(zzmu zzmu, String str) {
        str.getClass();
        zzmu.zzd |= 32;
        zzmu.zzk = str;
    }

    static /* synthetic */ void zzk(zzmu zzmu, long j) {
        zzmu.zzd |= 64;
        zzmu.zzl = j;
    }

    static /* synthetic */ void zzl(zzmu zzmu, long j) {
        zzmu.zzd |= 128;
        zzmu.zzm = j;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzD(zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004\u001b\u0005င\u0003\u0006ဇ\u0004\u0007ဈ\u0005\bဂ\u0006\tဂ\u0007", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zzms.class, "zzi", "zzj", "zzk", "zzl", "zzm"});
        } else if (i2 == 3) {
            return new zzmu();
        } else {
            if (i2 == 4) {
                return new zzmt((zzlu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
