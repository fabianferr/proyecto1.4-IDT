package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.zzqy;

@zzqy(zza = zzac.class)
/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzbj {
    private static zzbj create(String str, String str2, String str3, int i) {
        return new zzac(str, str2, str3, i);
    }

    public static zzbj forError(String str, int i) {
        return create(str, "", "unknown", i);
    }

    public static zzbj forResponse(String str, String str2) {
        return forResponse(str, str2, "unknown");
    }

    public abstract String content();

    public abstract String contentType();

    public abstract int errorCode();

    public abstract String id();

    public static zzbj forResponse(String str, String str2, String str3) {
        return create(str, str2, str3, 0);
    }
}
