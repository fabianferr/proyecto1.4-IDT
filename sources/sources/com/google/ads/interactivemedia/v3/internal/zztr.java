package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zztr extends zzth implements Serializable {
    final zzth zza;

    zztr(zzth zzth) {
        this.zza = zzth;
    }

    public final int compare(Object obj, Object obj2) {
        return this.zza.compare(obj2, obj);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zztr) {
            return this.zza.equals(((zztr) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return -this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString().concat(".reverse()");
    }

    public final zzth zza() {
        return this.zza;
    }
}
