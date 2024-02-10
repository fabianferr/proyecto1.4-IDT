package com.google.ads.interactivemedia.v3.impl.data;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzap extends zzbu {
    private final Integer downloadBandwidthKbps;

    zzap(Integer num) {
        this.downloadBandwidthKbps = num;
    }

    public Integer downloadBandwidthKbps() {
        return this.downloadBandwidthKbps;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbu) {
            return this.downloadBandwidthKbps.equals(((zzbu) obj).downloadBandwidthKbps());
        }
        return false;
    }

    public int hashCode() {
        return this.downloadBandwidthKbps.hashCode() ^ 1000003;
    }

    public String toString() {
        Integer num = this.downloadBandwidthKbps;
        return "VideoEnvironmentData{downloadBandwidthKbps=" + num + "}";
    }
}
