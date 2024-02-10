package com.google.ads.interactivemedia.v3.impl.data;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzak extends zzbo {
    private final zzbp adapterVersion;
    private final Boolean isPublisherCreated;
    private final String name;
    private final zzbp sdkVersion;
    private final String signals;

    zzak(zzbp zzbp, zzbp zzbp2, String str, String str2, Boolean bool) {
        this.adapterVersion = zzbp;
        this.sdkVersion = zzbp2;
        if (str != null) {
            this.name = str;
            if (str2 != null) {
                this.signals = str2;
                this.isPublisherCreated = bool;
                return;
            }
            throw new NullPointerException("Null signals");
        }
        throw new NullPointerException("Null name");
    }

    public zzbp adapterVersion() {
        return this.adapterVersion;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbo) {
            zzbo zzbo = (zzbo) obj;
            zzbp zzbp = this.adapterVersion;
            if (zzbp != null ? zzbp.equals(zzbo.adapterVersion()) : zzbo.adapterVersion() == null) {
                zzbp zzbp2 = this.sdkVersion;
                if (zzbp2 != null ? zzbp2.equals(zzbo.sdkVersion()) : zzbo.sdkVersion() == null) {
                    return this.name.equals(zzbo.name()) && this.signals.equals(zzbo.signals()) && this.isPublisherCreated.equals(zzbo.isPublisherCreated());
                }
            }
        }
    }

    public Boolean isPublisherCreated() {
        return this.isPublisherCreated;
    }

    public String name() {
        return this.name;
    }

    public zzbp sdkVersion() {
        return this.sdkVersion;
    }

    public String signals() {
        return this.signals;
    }

    public String toString() {
        String valueOf = String.valueOf(this.adapterVersion);
        String valueOf2 = String.valueOf(this.sdkVersion);
        String str = this.name;
        String str2 = this.signals;
        Boolean bool = this.isPublisherCreated;
        return "SecureSignalsData{adapterVersion=" + valueOf + ", sdkVersion=" + valueOf2 + ", name=" + str + ", signals=" + str2 + ", isPublisherCreated=" + bool + "}";
    }

    public int hashCode() {
        int i;
        zzbp zzbp = this.adapterVersion;
        int i2 = 0;
        if (zzbp == null) {
            i = 0;
        } else {
            i = zzbp.hashCode();
        }
        zzbp zzbp2 = this.sdkVersion;
        if (zzbp2 != null) {
            i2 = zzbp2.hashCode();
        }
        return ((((((((i ^ 1000003) * 1000003) ^ i2) * 1000003) ^ this.name.hashCode()) * 1000003) ^ this.signals.hashCode()) * 1000003) ^ this.isPublisherCreated.hashCode();
    }
}
