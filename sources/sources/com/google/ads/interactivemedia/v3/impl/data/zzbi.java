package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.zzqy;

@zzqy(zza = zzaa.class)
/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzbi {
    public static zzbi create(Throwable th) {
        return new zzaa(th.getClass().getName(), th.getMessage());
    }

    public abstract String message();

    public abstract String name();
}
