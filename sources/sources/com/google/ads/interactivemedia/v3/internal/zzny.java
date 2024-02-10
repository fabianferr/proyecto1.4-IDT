package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzny {
    static final AtomicBoolean zza = new AtomicBoolean();
    private static final AtomicReference zzb = new AtomicReference();
    private static final AtomicReference zzc = new AtomicReference();

    static zznw zza() {
        return (zznw) zzb.get();
    }

    static zznx zzb() {
        return (zznx) zzc.get();
    }

    public static void zzc(zznw zznw) {
        zzb.set(zznw);
    }
}
