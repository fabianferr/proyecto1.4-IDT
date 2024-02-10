package com.applovin.impl.mediation.a;

import android.os.Bundle;
import android.os.SystemClock;
import com.applovin.impl.mediation.g;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public abstract class a extends f implements MaxAd {
    protected g a;
    private final AtomicBoolean c = new AtomicBoolean();
    private MaxAdWaterfallInfo d;
    private String e;
    private String f;

    protected a(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, g gVar, m mVar) {
        super(map, jSONObject, jSONObject2, mVar);
        this.a = gVar;
    }

    public static a a(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, m mVar) {
        String string = JsonUtils.getString(jSONObject2, FirebaseAnalytics.Param.AD_FORMAT, (String) null);
        MaxAdFormat formatFromString = MaxAdFormat.formatFromString(string);
        if (formatFromString.isAdViewAd()) {
            return new b(map, jSONObject, jSONObject2, mVar);
        }
        if (formatFromString == MaxAdFormat.NATIVE) {
            return new d(map, jSONObject, jSONObject2, mVar);
        }
        if (formatFromString.isFullscreenAd()) {
            return new c(map, jSONObject, jSONObject2, mVar);
        }
        throw new IllegalArgumentException("Unsupported ad format: " + string);
    }

    private long u() {
        return b("load_started_time_ms", 0);
    }

    public abstract a a(g gVar);

    public String a() {
        return this.e;
    }

    public void a(Bundle bundle) {
        if (bundle != null) {
            if (bundle.containsKey(CampaignEx.JSON_KEY_CREATIVE_ID) && !c(CampaignEx.JSON_KEY_CREATIVE_ID)) {
                c(CampaignEx.JSON_KEY_CREATIVE_ID, BundleUtils.getString(CampaignEx.JSON_KEY_CREATIVE_ID, bundle));
            }
            if (bundle.containsKey("ad_width") && !c("ad_width") && bundle.containsKey("ad_height") && !c("ad_height")) {
                int i = BundleUtils.getInt("ad_width", bundle);
                int i2 = BundleUtils.getInt("ad_height", bundle);
                c("ad_width", i);
                c("ad_height", i2);
            }
        }
    }

    public void a(MaxAdWaterfallInfo maxAdWaterfallInfo) {
        this.d = maxAdWaterfallInfo;
    }

    public void a(String str) {
        this.e = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            JSONObject b = b();
            JsonUtils.putAll(b, jSONObject);
            a(Utils.KEY_AD_VALUES, (Object) b);
        }
    }

    public JSONObject b() {
        return a(Utils.KEY_AD_VALUES, new JSONObject());
    }

    public void b(String str) {
        this.f = str;
    }

    public JSONObject c() {
        return a("revenue_parameters", new JSONObject());
    }

    public String d() {
        return JsonUtils.getString(c(), "revenue_event", "");
    }

    public boolean e() {
        g gVar = this.a;
        return gVar != null && gVar.f() && this.a.g();
    }

    public String f() {
        return a("event_id", "");
    }

    public g g() {
        return this.a;
    }

    public String getAdReviewCreativeId() {
        return this.f;
    }

    public String getAdValue(String str) {
        return getAdValue(str, (String) null);
    }

    public String getAdValue(String str, String str2) {
        JSONObject b = b();
        if (b.has(str)) {
            return JsonUtils.getString(b, str, str2);
        }
        Bundle W = W();
        return W.containsKey(str) ? W.getString(str) : b(str, str2);
    }

    public String getCreativeId() {
        return b(CampaignEx.JSON_KEY_CREATIVE_ID, (String) null);
    }

    public String getDspId() {
        return b("dsp_id", (String) null);
    }

    public String getDspName() {
        return b("dsp_name", (String) null);
    }

    public MaxAdFormat getFormat() {
        return MaxAdFormat.formatFromString(b(FirebaseAnalytics.Param.AD_FORMAT, a(FirebaseAnalytics.Param.AD_FORMAT, (String) null)));
    }

    public MaxNativeAd getNativeAd() {
        return null;
    }

    public String getNetworkName() {
        return b("network_name", "");
    }

    public String getNetworkPlacement() {
        return StringUtils.emptyIfNull(l());
    }

    public double getRevenue() {
        return JsonUtils.getDouble(a("revenue_parameters", (JSONObject) null), ImpressionData.IMPRESSION_DATA_KEY_REVENUE, -1.0d);
    }

    public String getRevenuePrecision() {
        return JsonUtils.getString(a("revenue_parameters", (JSONObject) null), ImpressionData.IMPRESSION_DATA_KEY_PRECISION, "");
    }

    public AppLovinSdkUtils.Size getSize() {
        int b = b("ad_width", -3);
        int b2 = b("ad_height", -3);
        return (b == -3 || b2 == -3) ? getFormat().getSize() : new AppLovinSdkUtils.Size(b, b2);
    }

    public MaxAdWaterfallInfo getWaterfall() {
        return this.d;
    }

    public Bundle h() {
        JSONObject jSONObject;
        if (c("credentials")) {
            jSONObject = a("credentials", new JSONObject());
        } else {
            jSONObject = a("server_parameters", new JSONObject());
            JsonUtils.putString(jSONObject, FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER, l());
        }
        return JsonUtils.toBundle(jSONObject);
    }

    public String i() {
        return b("bid_response", (String) null);
    }

    public long j() {
        return b("bid_expiration_ms", BundleUtils.getLong("bid_expiration_ms", -1, W()));
    }

    public boolean k() {
        return b("is_js_tag_ad", (Boolean) false).booleanValue();
    }

    public String l() {
        return b("third_party_ad_placement_id", (String) null);
    }

    public String m() {
        return a("waterfall_name", "");
    }

    public String n() {
        return a("waterfall_test_name", "");
    }

    public long o() {
        if (u() > 0) {
            return q() - u();
        }
        return -1;
    }

    public void p() {
        c("load_started_time_ms", SystemClock.elapsedRealtime());
    }

    public long q() {
        return b("load_completed_time_ms", 0);
    }

    public void r() {
        c("load_completed_time_ms", SystemClock.elapsedRealtime());
    }

    public AtomicBoolean s() {
        return this.c;
    }

    public void t() {
        this.a = null;
        this.d = null;
    }

    public String toString() {
        return "MediatedAd{thirdPartyAdPlacementId=" + l() + ", adUnitId=" + getAdUnitId() + ", format=" + getFormat().getLabel() + ", networkName='" + getNetworkName() + "'}";
    }
}
