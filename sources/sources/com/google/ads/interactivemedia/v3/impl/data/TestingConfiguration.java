package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.zzqy;

@zzqy(zza = zzan.class, zzb = {"extraParams", "isTv", "ignoreStrictModeFalsePositives"})
/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class TestingConfiguration {

    /* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
    public interface Builder {
    }

    TestingConfiguration() {
    }

    public abstract boolean forceAndroidTvMode();

    public abstract boolean forceTvMode();

    public abstract boolean ignoreStrictModeFalsePositives();
}
