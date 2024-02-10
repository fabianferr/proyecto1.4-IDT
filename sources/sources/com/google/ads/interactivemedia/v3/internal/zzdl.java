package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzdl implements AdErrorEvent {
    private final AdError zza;
    private final Object zzb;

    zzdl(AdError adError) {
        this.zza = adError;
        this.zzb = null;
    }

    zzdl(AdError adError, Object obj) {
        this.zza = adError;
        this.zzb = obj;
    }

    public final AdError getError() {
        return this.zza;
    }

    public final Object getUserRequestContext() {
        return this.zzb;
    }

    public final String toString() {
        return String.format("AdErrorEvent: [error=%s]", new Object[]{this.zza});
    }
}
