package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.UniversalAdId;
import com.google.ads.interactivemedia.v3.internal.zzaie;
import com.google.ads.interactivemedia.v3.internal.zzaig;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public class UniversalAdIdImpl implements UniversalAdId {
    private String adIdRegistry = "unknown";
    private String adIdValue = "unknown";

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return zzaie.zzf(this, obj, false, (Class) null, false, new String[0]);
    }

    public String getAdIdRegistry() {
        return this.adIdRegistry;
    }

    public String getAdIdValue() {
        return this.adIdValue;
    }

    public int hashCode() {
        return zzaig.zza(this, new String[0]);
    }

    public void setAdIdRegistry(String str) {
        this.adIdRegistry = str;
    }

    public void setAdIdValue(String str) {
        this.adIdValue = str;
    }

    public String toString() {
        String str = this.adIdValue;
        String str2 = this.adIdRegistry;
        return "UniversalAdId [adIdValue=" + str + ", adIdRegistry=" + str2 + "]";
    }
}
