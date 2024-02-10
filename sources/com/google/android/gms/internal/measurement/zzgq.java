package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
public final class zzgq extends zzke implements zzlm {
    /* access modifiers changed from: private */
    public static final zzgq zza;
    private int zze;
    private String zzf = "";
    private zzkl zzg = zzbD();

    static {
        zzgq zzgq = new zzgq();
        zza = zzgq;
        zzke.zzbJ(zzgq.class, zzgq);
    }

    private zzgq() {
    }

    public final String zzb() {
        return this.zzf;
    }

    public final List zzc() {
        return this.zzg;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbI(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zze", "zzf", "zzg", zzgx.class});
        } else if (i2 == 3) {
            return new zzgq();
        } else {
            if (i2 == 4) {
                return new zzgp((zzgm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
