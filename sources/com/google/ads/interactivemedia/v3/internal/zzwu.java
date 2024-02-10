package com.google.ads.interactivemedia.v3.internal;

import java.util.Set;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzwu extends zzwr {
    private final zzyy zza = new zzyy(false);

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof zzwu) && ((zzwu) obj).zza.equals(this.zza);
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Set zza() {
        return this.zza.entrySet();
    }

    public final void zzb(String str, zzwr zzwr) {
        this.zza.put(str, zzwr);
    }
}
