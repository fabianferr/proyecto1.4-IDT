package com.google.android.gms.internal.cast;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public abstract class zzeq implements Serializable {
    zzeq() {
    }

    public static zzeq zzb(@CheckForNull Object obj) {
        return obj == null ? zzem.zza : new zzev(obj);
    }

    @CheckForNull
    public abstract Object zza();
}
