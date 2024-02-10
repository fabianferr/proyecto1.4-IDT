package com.google.ads.interactivemedia.v3.impl.data;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzac extends zzbj {
    private final String content;
    private final String contentType;
    private final int errorCode;
    private final String id;

    zzac(String str, String str2, String str3, int i) {
        if (str != null) {
            this.id = str;
            if (str2 != null) {
                this.content = str2;
                if (str3 != null) {
                    this.contentType = str3;
                    this.errorCode = i;
                    return;
                }
                throw new NullPointerException("Null contentType");
            }
            throw new NullPointerException("Null content");
        }
        throw new NullPointerException("Null id");
    }

    public String content() {
        return this.content;
    }

    public String contentType() {
        return this.contentType;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbj) {
            zzbj zzbj = (zzbj) obj;
            return this.id.equals(zzbj.id()) && this.content.equals(zzbj.content()) && this.contentType.equals(zzbj.contentType()) && this.errorCode == zzbj.errorCode();
        }
    }

    public int errorCode() {
        return this.errorCode;
    }

    public int hashCode() {
        return ((((((this.id.hashCode() ^ 1000003) * 1000003) ^ this.content.hashCode()) * 1000003) ^ this.contentType.hashCode()) * 1000003) ^ this.errorCode;
    }

    public String id() {
        return this.id;
    }

    public String toString() {
        String str = this.id;
        String str2 = this.content;
        String str3 = this.contentType;
        int i = this.errorCode;
        return "NetworkResponseData{id=" + str + ", content=" + str2 + ", contentType=" + str3 + ", errorCode=" + i + "}";
    }
}
