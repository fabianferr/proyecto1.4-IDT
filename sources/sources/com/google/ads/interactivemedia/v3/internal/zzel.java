package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzel extends zzeb {
    private final int appVersion;
    private final String packageName;

    zzel(int i, String str) {
        this.appVersion = i;
        if (str != null) {
            this.packageName = str;
            return;
        }
        throw new NullPointerException("Null packageName");
    }

    public int appVersion() {
        return this.appVersion;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzeb) {
            zzeb zzeb = (zzeb) obj;
            return this.appVersion == zzeb.appVersion() && this.packageName.equals(zzeb.packageName());
        }
    }

    public int hashCode() {
        return ((this.appVersion ^ 1000003) * 1000003) ^ this.packageName.hashCode();
    }

    public String packageName() {
        return this.packageName;
    }

    public String toString() {
        int i = this.appVersion;
        String str = this.packageName;
        return "MarketAppInfo{appVersion=" + i + ", packageName=" + str + "}";
    }
}
