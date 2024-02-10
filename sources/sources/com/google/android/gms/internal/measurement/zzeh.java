package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
public final class zzeh extends zzke implements zzlm {
    /* access modifiers changed from: private */
    public static final zzeh zza;
    private int zze;
    private int zzf;
    private zzkl zzg = zzbD();
    private zzkl zzh = zzbD();
    private boolean zzi;
    private boolean zzj;

    static {
        zzeh zzeh = new zzeh();
        zza = zzeh;
        zzke.zzbJ(zzeh.class, zzeh);
    }

    private zzeh() {
    }

    static /* synthetic */ void zzi(zzeh zzeh, int i, zzes zzes) {
        zzes.getClass();
        zzkl zzkl = zzeh.zzg;
        if (!zzkl.zzc()) {
            zzeh.zzg = zzke.zzbE(zzkl);
        }
        zzeh.zzg.set(i, zzes);
    }

    static /* synthetic */ void zzj(zzeh zzeh, int i, zzej zzej) {
        zzej.getClass();
        zzkl zzkl = zzeh.zzh;
        if (!zzkl.zzc()) {
            zzeh.zzh = zzke.zzbE(zzkl);
        }
        zzeh.zzh.set(i, zzej);
    }

    public final int zza() {
        return this.zzf;
    }

    public final int zzb() {
        return this.zzh.size();
    }

    public final int zzc() {
        return this.zzg.size();
    }

    public final zzej zze(int i) {
        return (zzej) this.zzh.get(i);
    }

    public final zzes zzf(int i) {
        return (zzes) this.zzg.get(i);
    }

    public final List zzg() {
        return this.zzh;
    }

    public final List zzh() {
        return this.zzg;
    }

    public final boolean zzk() {
        return (this.zze & 1) != 0;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbI(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zze", "zzf", "zzg", zzes.class, "zzh", zzej.class, "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzeh();
        } else {
            if (i2 == 4) {
                return new zzeg((zzef) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
