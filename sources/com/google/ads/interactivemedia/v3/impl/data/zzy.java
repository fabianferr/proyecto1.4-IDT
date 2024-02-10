package com.google.ads.interactivemedia.v3.impl.data;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzy extends zzbc {
    private final String adsIdentityToken;
    private final String appSetId;
    private final int appSetIdScope;
    private final String deviceId;
    private final String idType;
    private final boolean isLimitedAdTracking;

    zzy(String str, String str2, boolean z, String str3, int i, String str4) {
        this.deviceId = str;
        this.idType = str2;
        this.isLimitedAdTracking = z;
        if (str3 != null) {
            this.appSetId = str3;
            this.appSetIdScope = i;
            if (str4 != null) {
                this.adsIdentityToken = str4;
                return;
            }
            throw new NullPointerException("Null adsIdentityToken");
        }
        throw new NullPointerException("Null appSetId");
    }

    public String adsIdentityToken() {
        return this.adsIdentityToken;
    }

    public String appSetId() {
        return this.appSetId;
    }

    public int appSetIdScope() {
        return this.appSetIdScope;
    }

    public String deviceId() {
        return this.deviceId;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbc) {
            zzbc zzbc = (zzbc) obj;
            String str = this.deviceId;
            if (str != null ? str.equals(zzbc.deviceId()) : zzbc.deviceId() == null) {
                return this.idType.equals(zzbc.idType()) && this.isLimitedAdTracking == zzbc.isLimitedAdTracking() && this.appSetId.equals(zzbc.appSetId()) && this.appSetIdScope == zzbc.appSetIdScope() && this.adsIdentityToken.equals(zzbc.adsIdentityToken());
            }
        }
    }

    public String idType() {
        return this.idType;
    }

    public boolean isLimitedAdTracking() {
        return this.isLimitedAdTracking;
    }

    public String toString() {
        String str = this.deviceId;
        String str2 = this.idType;
        boolean z = this.isLimitedAdTracking;
        String str3 = this.appSetId;
        int i = this.appSetIdScope;
        String str4 = this.adsIdentityToken;
        return "IdentifierInfo{deviceId=" + str + ", idType=" + str2 + ", isLimitedAdTracking=" + z + ", appSetId=" + str3 + ", appSetIdScope=" + i + ", adsIdentityToken=" + str4 + "}";
    }

    public int hashCode() {
        int i;
        String str = this.deviceId;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        return ((((((((((i ^ 1000003) * 1000003) ^ this.idType.hashCode()) * 1000003) ^ (true != this.isLimitedAdTracking ? 1237 : 1231)) * 1000003) ^ this.appSetId.hashCode()) * 1000003) ^ this.appSetIdScope) * 1000003) ^ this.adsIdentityToken.hashCode();
    }
}
