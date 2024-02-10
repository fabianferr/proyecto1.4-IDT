package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.VersionInfo;
import com.google.ads.interactivemedia.v3.api.signals.SecureSignals;
import com.google.ads.interactivemedia.v3.internal.zzqy;

@zzqy(zza = zzak.class)
/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzbo {
    public static zzbo createBy1stPartyData(SecureSignals secureSignals) {
        return new zzak((zzbp) null, (zzbp) null, "", secureSignals.getSecureSignal(), true);
    }

    public static zzbo createBy3rdPartyData(VersionInfo versionInfo, VersionInfo versionInfo2, String str, String str2) {
        return createBy3rdPartyData(zzbp.create(versionInfo), zzbp.create(versionInfo2), str, str2);
    }

    public abstract zzbp adapterVersion();

    public abstract Boolean isPublisherCreated();

    public abstract String name();

    public abstract zzbp sdkVersion();

    public abstract String signals();

    public static zzbo createBy3rdPartyData(zzbp zzbp, zzbp zzbp2, String str, String str2) {
        return new zzak(zzbp, zzbp2, str, str2, false);
    }
}
