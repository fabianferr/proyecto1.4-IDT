package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.AdPodInfo;
import com.google.ads.interactivemedia.v3.internal.zzaie;
import com.google.ads.interactivemedia.v3.internal.zzaig;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public class AdPodInfoImpl implements AdPodInfo {
    public int adPosition = 1;
    public boolean isBumper = false;
    public double maxDuration = -1.0d;
    public int podIndex;
    public double timeOffset;
    public int totalAds = 1;

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return zzaie.zzf(this, obj, false, (Class) null, false, new String[0]);
    }

    public int getAdPosition() {
        return this.adPosition;
    }

    public double getMaxDuration() {
        return this.maxDuration;
    }

    public int getPodIndex() {
        return this.podIndex;
    }

    public double getTimeOffset() {
        return this.timeOffset;
    }

    public int getTotalAds() {
        return this.totalAds;
    }

    public int hashCode() {
        return zzaig.zza(this, new String[0]);
    }

    public boolean isBumper() {
        return this.isBumper;
    }

    public String toString() {
        int i = this.totalAds;
        int i2 = this.adPosition;
        boolean z = this.isBumper;
        double d = this.maxDuration;
        int i3 = this.podIndex;
        double d2 = this.timeOffset;
        return "AdPodInfo [totalAds=" + i + ", adPosition=" + i2 + ", isBumper=" + z + ", maxDuration=" + d + ", podIndex=" + i3 + ", timeOffset=" + d2 + "]";
    }
}
