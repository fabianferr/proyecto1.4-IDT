package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.zzqy;

@zzqy(zza = zzq.class)
/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class CuePointData {
    private static CuePointData create(double d, double d2, boolean z) {
        return new zzq(d, d2, z);
    }

    public abstract double end();

    public abstract boolean played();

    public abstract double start();
}
