package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfxe extends zzfwv implements Serializable {
    final zzfwv zza;

    zzfxe(zzfwv zzfwv) {
        this.zza = zzfwv;
    }

    public final int compare(Object obj, Object obj2) {
        return this.zza.compare(obj2, obj);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfxe) {
            return this.zza.equals(((zzfxe) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return -this.zza.hashCode();
    }

    public final String toString() {
        zzfwv zzfwv = this.zza;
        Objects.toString(zzfwv);
        return zzfwv.toString().concat(".reverse()");
    }

    public final zzfwv zza() {
        return this.zza;
    }
}
