package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzru extends zzth implements Serializable {
    final zzrc zza;
    final zzth zzb;

    zzru(zzrc zzrc, zzth zzth) {
        this.zza = zzrc;
        this.zzb = zzth;
    }

    public final int compare(Object obj, Object obj2) {
        return this.zzb.compare(this.zza.zza(obj), this.zza.zza(obj2));
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzru) {
            zzru zzru = (zzru) obj;
            return this.zza.equals(zzru.zza) && this.zzb.equals(zzru.zzb);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        String obj = this.zzb.toString();
        String obj2 = this.zza.toString();
        return obj + ".onResultOf(" + obj2 + ")";
    }
}
