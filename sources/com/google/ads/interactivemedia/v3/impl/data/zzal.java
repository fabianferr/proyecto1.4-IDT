package com.google.ads.interactivemedia.v3.impl.data;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzal extends zzbp {
    private final int major;
    private final int micro;
    private final int minor;

    zzal(int i, int i2, int i3) {
        this.major = i;
        this.minor = i2;
        this.micro = i3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbp) {
            zzbp zzbp = (zzbp) obj;
            return this.major == zzbp.major() && this.minor == zzbp.minor() && this.micro == zzbp.micro();
        }
    }

    public int hashCode() {
        return ((((this.major ^ 1000003) * 1000003) ^ this.minor) * 1000003) ^ this.micro;
    }

    public int major() {
        return this.major;
    }

    public int micro() {
        return this.micro;
    }

    public int minor() {
        return this.minor;
    }

    public String toString() {
        int i = this.major;
        int i2 = this.minor;
        int i3 = this.micro;
        return "SecureSignalsVersionData{major=" + i + ", minor=" + i2 + ", micro=" + i3 + "}";
    }
}
