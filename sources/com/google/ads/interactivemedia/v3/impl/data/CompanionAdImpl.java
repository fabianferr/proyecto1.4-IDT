package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.CompanionAd;
import com.google.ads.interactivemedia.v3.internal.zzaie;
import com.google.ads.interactivemedia.v3.internal.zzaig;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public class CompanionAdImpl implements CompanionAd {
    private String apiFramework;
    private String resourceValue;
    private zzbq size = zzbq.create(0, 0);

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return zzaie.zzf(this, obj, false, (Class) null, false, new String[0]);
    }

    public String getApiFramework() {
        return this.apiFramework;
    }

    public int getHeight() {
        return this.size.height().intValue();
    }

    public String getResourceValue() {
        return this.resourceValue;
    }

    public int getWidth() {
        return this.size.width().intValue();
    }

    public int hashCode() {
        return zzaig.zza(this, new String[0]);
    }

    /* access modifiers changed from: package-private */
    public void setApiFramework(String str) {
        this.apiFramework = str;
    }

    /* access modifiers changed from: package-private */
    public void setResourceValue(String str) {
        this.resourceValue = str;
    }

    /* access modifiers changed from: package-private */
    public void setSize(zzbq zzbq) {
        this.size = zzbq;
    }

    public String toString() {
        String str = this.apiFramework;
        String str2 = this.resourceValue;
        Integer width = this.size.width();
        Integer height = this.size.height();
        return "CompanionAd [apiFramework=" + str + ", resourceUrl=" + str2 + ", width=" + width + ", height=" + height + "]";
    }
}
