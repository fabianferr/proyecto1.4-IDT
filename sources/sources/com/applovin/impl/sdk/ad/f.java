package com.applovin.impl.sdk.ad;

import com.applovin.impl.sdk.m;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import java.util.List;
import org.json.JSONObject;

public final class f extends AppLovinAdImpl {
    private AppLovinAd a;
    private final d b;

    public f(d dVar, m mVar) {
        super(new JSONObject(), new JSONObject(), b.UNKNOWN, mVar);
        this.b = dVar;
    }

    private AppLovinAd c() {
        return (AppLovinAd) this.sdk.Z().c(this.b);
    }

    private String d() {
        d adZone = getAdZone();
        if (adZone == null || adZone.e()) {
            return null;
        }
        return adZone.a();
    }

    public AppLovinAd a() {
        return this.a;
    }

    public void a(AppLovinAd appLovinAd) {
        this.a = appLovinAd;
    }

    public AppLovinAd b() {
        AppLovinAd appLovinAd = this.a;
        return appLovinAd != null ? appLovinAd : c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppLovinAd b2 = b();
        return b2 != null ? b2.equals(obj) : super.equals(obj);
    }

    public long getAdIdNumber() {
        AppLovinAd b2 = b();
        if (b2 != null) {
            return b2.getAdIdNumber();
        }
        return 0;
    }

    public d getAdZone() {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) b();
        return appLovinAdImpl != null ? appLovinAdImpl.getAdZone() : this.b;
    }

    public long getCreatedAtMillis() {
        AppLovinAd b2 = b();
        if (b2 instanceof AppLovinAdImpl) {
            return ((AppLovinAdImpl) b2).getCreatedAtMillis();
        }
        return 0;
    }

    public String getDirectDownloadToken() {
        return null;
    }

    public String getOpenMeasurementContentUrl() {
        return null;
    }

    public String getOpenMeasurementCustomReferenceData() {
        return null;
    }

    public List<VerificationScriptResource> getOpenMeasurementVerificationScriptResources() {
        return null;
    }

    public JSONObject getOriginalFullResponse() {
        AppLovinAd b2 = b();
        if (b2 instanceof AppLovinAdImpl) {
            return ((AppLovinAdImpl) b2).getOriginalFullResponse();
        }
        return null;
    }

    public AppLovinAdSize getSize() {
        return getAdZone().c();
    }

    public b getSource() {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) b();
        return appLovinAdImpl != null ? appLovinAdImpl.getSource() : b.UNKNOWN;
    }

    public AppLovinAdType getType() {
        return getAdZone().d();
    }

    public String getZoneId() {
        if (this.b.e()) {
            return null;
        }
        return this.b.a();
    }

    public int hashCode() {
        AppLovinAd b2 = b();
        return b2 != null ? b2.hashCode() : super.hashCode();
    }

    public boolean isDirectDownloadEnabled() {
        return false;
    }

    public boolean isOpenMeasurementEnabled() {
        return false;
    }

    public boolean isVideoAd() {
        AppLovinAd b2 = b();
        return b2 != null && b2.isVideoAd();
    }

    public String toString() {
        return "AppLovinAd{ #" + getAdIdNumber() + ", adType=" + getType() + ", adSize=" + getSize() + ", zoneId='" + d() + "'}";
    }
}
