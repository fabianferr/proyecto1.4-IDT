package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgxh implements zzgxv, zzgxc {
    private static final Object zza = new Object();
    private volatile zzgxv zzb;
    private volatile Object zzc = zza;

    private zzgxh(zzgxv zzgxv) {
        this.zzb = zzgxv;
    }

    public static zzgxc zza(zzgxv zzgxv) {
        if (zzgxv instanceof zzgxc) {
            return (zzgxc) zzgxv;
        }
        zzgxv.getClass();
        return new zzgxh(zzgxv);
    }

    public final Object zzb() {
        Object obj = this.zzc;
        Object obj2 = zza;
        if (obj == obj2) {
            synchronized (this) {
                obj = this.zzc;
                if (obj == obj2) {
                    obj = this.zzb.zzb();
                    Object obj3 = this.zzc;
                    if (obj3 != obj2) {
                        if (obj3 != obj) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + obj + ". This is likely due to a circular dependency.");
                        }
                    }
                    this.zzc = obj;
                    this.zzb = null;
                }
            }
        }
        return obj;
    }

    public static zzgxv zzc(zzgxv zzgxv) {
        zzgxv.getClass();
        if (zzgxv instanceof zzgxh) {
            return zzgxv;
        }
        return new zzgxh(zzgxv);
    }
}
