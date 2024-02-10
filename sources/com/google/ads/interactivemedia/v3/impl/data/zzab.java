package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.impl.data.NetworkRequestData;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzab extends NetworkRequestData {
    private final int connectionTimeoutMs;
    private final String content;
    private final String id;
    private final int readTimeoutMs;
    private final NetworkRequestData.RequestType requestType;
    private final String url;
    private final String userAgent;

    zzab(NetworkRequestData.RequestType requestType2, String str, String str2, String str3, String str4, int i, int i2) {
        if (requestType2 != null) {
            this.requestType = requestType2;
            if (str != null) {
                this.id = str;
                if (str2 != null) {
                    this.url = str2;
                    this.content = str3;
                    if (str4 != null) {
                        this.userAgent = str4;
                        this.connectionTimeoutMs = i;
                        this.readTimeoutMs = i2;
                        return;
                    }
                    throw new NullPointerException("Null userAgent");
                }
                throw new NullPointerException("Null url");
            }
            throw new NullPointerException("Null id");
        }
        throw new NullPointerException("Null requestType");
    }

    public int connectionTimeoutMs() {
        return this.connectionTimeoutMs;
    }

    public String content() {
        return this.content;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
        r1 = r4.content;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.ads.interactivemedia.v3.impl.data.NetworkRequestData
            r2 = 0
            if (r1 == 0) goto L_0x0062
            com.google.ads.interactivemedia.v3.impl.data.NetworkRequestData r5 = (com.google.ads.interactivemedia.v3.impl.data.NetworkRequestData) r5
            com.google.ads.interactivemedia.v3.impl.data.NetworkRequestData$RequestType r1 = r4.requestType
            com.google.ads.interactivemedia.v3.impl.data.NetworkRequestData$RequestType r3 = r5.requestType()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0062
            java.lang.String r1 = r4.id
            java.lang.String r3 = r5.id()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0062
            java.lang.String r1 = r4.url
            java.lang.String r3 = r5.url()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0062
            java.lang.String r1 = r4.content
            if (r1 != 0) goto L_0x003a
            java.lang.String r1 = r5.content()
            if (r1 != 0) goto L_0x0062
            goto L_0x0045
        L_0x003a:
            java.lang.String r3 = r5.content()
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0045
            goto L_0x0062
        L_0x0045:
            java.lang.String r1 = r4.userAgent
            java.lang.String r3 = r5.userAgent()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0062
            int r1 = r4.connectionTimeoutMs
            int r3 = r5.connectionTimeoutMs()
            if (r1 != r3) goto L_0x0062
            int r1 = r4.readTimeoutMs
            int r5 = r5.readTimeoutMs()
            if (r1 != r5) goto L_0x0062
            return r0
        L_0x0062:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.impl.data.zzab.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i;
        int hashCode = ((((this.requestType.hashCode() ^ 1000003) * 1000003) ^ this.id.hashCode()) * 1000003) ^ this.url.hashCode();
        String str = this.content;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        return (((((((hashCode * 1000003) ^ i) * 1000003) ^ this.userAgent.hashCode()) * 1000003) ^ this.connectionTimeoutMs) * 1000003) ^ this.readTimeoutMs;
    }

    public String id() {
        return this.id;
    }

    public int readTimeoutMs() {
        return this.readTimeoutMs;
    }

    public NetworkRequestData.RequestType requestType() {
        return this.requestType;
    }

    public String toString() {
        String valueOf = String.valueOf(this.requestType);
        String str = this.id;
        String str2 = this.url;
        String str3 = this.content;
        String str4 = this.userAgent;
        int i = this.connectionTimeoutMs;
        int i2 = this.readTimeoutMs;
        return "NetworkRequestData{requestType=" + valueOf + ", id=" + str + ", url=" + str2 + ", content=" + str3 + ", userAgent=" + str4 + ", connectionTimeoutMs=" + i + ", readTimeoutMs=" + i2 + "}";
    }

    public String url() {
        return this.url;
    }

    public String userAgent() {
        return this.userAgent;
    }
}
