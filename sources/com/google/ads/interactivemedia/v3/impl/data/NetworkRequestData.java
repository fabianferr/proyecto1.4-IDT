package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.zzqy;

@zzqy(zza = zzab.class)
/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class NetworkRequestData {

    /* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
    public enum RequestType {
        GET,
        POST
    }

    public static NetworkRequestData create(RequestType requestType, String str, String str2, String str3, String str4, int i, int i2) {
        return new zzab(requestType, str, str2, str4, str3, i, i2);
    }

    public abstract int connectionTimeoutMs();

    public abstract String content();

    public abstract String id();

    public abstract int readTimeoutMs();

    public abstract RequestType requestType();

    public abstract String url();

    public abstract String userAgent();
}
