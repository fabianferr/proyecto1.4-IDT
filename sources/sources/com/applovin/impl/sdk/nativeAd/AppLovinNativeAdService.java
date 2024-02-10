package com.applovin.impl.sdk.nativeAd;

import android.text.TextUtils;
import com.applovin.impl.sdk.ad.c;
import com.applovin.impl.sdk.f.a;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.j;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppLovinNativeAdService {
    private static final String TAG = "AppLovinNativeAdService";
    private final u logger;
    private final m sdk;

    public AppLovinNativeAdService(m mVar) {
        this.sdk = mVar;
        this.logger = mVar.A();
    }

    public void loadNextAdForAdToken(String str, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        StringBuilder sb;
        String trim = str != null ? str.trim() : null;
        if (TextUtils.isEmpty(trim)) {
            if (u.a()) {
                u.i(TAG, "Invalid ad token specified");
            }
            j.a(appLovinNativeAdLoadListener, -8);
            return;
        }
        c cVar = new c(trim, this.sdk);
        if (cVar.b() == c.a.REGULAR) {
            if (u.a()) {
                u uVar = this.logger;
                uVar.b(TAG, "Loading next ad for token: " + cVar);
            }
            this.sdk.S().a((a) new b(cVar, appLovinNativeAdLoadListener, this.sdk), o.a.MAIN);
            return;
        }
        if (cVar.b() == c.a.AD_RESPONSE_JSON) {
            JSONObject d = cVar.d();
            if (d != null) {
                h.f(d, this.sdk);
                h.d(d, this.sdk);
                h.c(d, this.sdk);
                h.e(d, this.sdk);
                if (JsonUtils.getJSONArray(d, CampaignUnit.JSON_KEY_ADS, new JSONArray()).length() > 0) {
                    if (u.a()) {
                        u uVar2 = this.logger;
                        uVar2.b(TAG, "Rendering ad for token: " + cVar);
                    }
                    this.sdk.S().a((a) new d(d, appLovinNativeAdLoadListener, this.sdk), o.a.MAIN);
                    return;
                }
                if (u.a()) {
                    u uVar3 = this.logger;
                    uVar3.e(TAG, "No ad returned from the server for token: " + cVar);
                }
                j.a(appLovinNativeAdLoadListener, 204);
                return;
            }
            if (u.a()) {
                sb = new StringBuilder("Unable to retrieve ad response JSON from token: ");
            }
            j.a(appLovinNativeAdLoadListener, -8);
        }
        if (u.a()) {
            sb = new StringBuilder("Invalid ad token specified: ");
        }
        j.a(appLovinNativeAdLoadListener, -8);
        sb.append(cVar);
        u.i(TAG, sb.toString());
        j.a(appLovinNativeAdLoadListener, -8);
    }
}
