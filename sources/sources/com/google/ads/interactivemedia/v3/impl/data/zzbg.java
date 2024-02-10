package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.internal.zzqy;

@zzqy(zza = zzz.class)
/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzbg {
    public static zzbg create(long j, AdErrorEvent adErrorEvent) {
        return new zzz(j, (zzbe) null, (zzbf) null, adErrorEvent, (zzbi) null);
    }

    private static zzbg create(long j, zzbe zzbe, zzbf zzbf, AdErrorEvent adErrorEvent, zzbi zzbi) {
        return new zzz(j, zzbe, zzbf, (AdErrorEvent) null, zzbi);
    }

    public static zzbg create(long j, zzbe zzbe, zzbf zzbf, Throwable th) {
        return create(j, zzbe, zzbf, (AdErrorEvent) null, zzbi.create(th));
    }

    public abstract AdErrorEvent adErrorEvent();

    public abstract zzbe component();

    public abstract zzbi loggableException();

    public abstract zzbf method();

    public abstract long timestamp();
}
