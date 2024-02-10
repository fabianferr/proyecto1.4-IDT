package com.google.ads.interactivemedia.v3.impl.data;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzp extends zzaw {
    private final String addtlConsent;
    private final String gdprApplies;
    private final String tcString;
    private final String uspString;

    zzp(String str, String str2, String str3, String str4) {
        if (str != null) {
            this.gdprApplies = str;
            if (str2 != null) {
                this.tcString = str2;
                if (str3 != null) {
                    this.addtlConsent = str3;
                    if (str4 != null) {
                        this.uspString = str4;
                        return;
                    }
                    throw new NullPointerException("Null uspString");
                }
                throw new NullPointerException("Null addtlConsent");
            }
            throw new NullPointerException("Null tcString");
        }
        throw new NullPointerException("Null gdprApplies");
    }

    public String addtlConsent() {
        return this.addtlConsent;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzaw) {
            zzaw zzaw = (zzaw) obj;
            return this.gdprApplies.equals(zzaw.gdprApplies()) && this.tcString.equals(zzaw.tcString()) && this.addtlConsent.equals(zzaw.addtlConsent()) && this.uspString.equals(zzaw.uspString());
        }
    }

    public String gdprApplies() {
        return this.gdprApplies;
    }

    public int hashCode() {
        return ((((((this.gdprApplies.hashCode() ^ 1000003) * 1000003) ^ this.tcString.hashCode()) * 1000003) ^ this.addtlConsent.hashCode()) * 1000003) ^ this.uspString.hashCode();
    }

    public String tcString() {
        return this.tcString;
    }

    public String toString() {
        String str = this.gdprApplies;
        String str2 = this.tcString;
        String str3 = this.addtlConsent;
        String str4 = this.uspString;
        return "ConsentSettings{gdprApplies=" + str + ", tcString=" + str2 + ", addtlConsent=" + str3 + ", uspString=" + str4 + "}";
    }

    public String uspString() {
        return this.uspString;
    }
}
