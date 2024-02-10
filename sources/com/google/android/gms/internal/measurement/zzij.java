package com.google.android.gms.internal.measurement;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzij implements zzih {
    @CheckForNull
    volatile zzih zza;
    volatile boolean zzb;
    @CheckForNull
    Object zzc;

    zzij(zzih zzih) {
        zzih.getClass();
        this.zza = zzih;
    }

    public final String toString() {
        Object obj = this.zza;
        StringBuilder sb = new StringBuilder("Suppliers.memoize(");
        if (obj == null) {
            obj = "<supplier that returned " + this.zzc + ">";
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }

    public final Object zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    zzih zzih = this.zza;
                    zzih.getClass();
                    Object zza2 = zzih.zza();
                    this.zzc = zza2;
                    this.zzb = true;
                    this.zza = null;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
