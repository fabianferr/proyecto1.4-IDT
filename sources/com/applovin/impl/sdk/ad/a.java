package com.applovin.impl.sdk.ad;

import android.net.Uri;
import com.applovin.impl.adview.i;
import com.applovin.impl.sdk.b.c;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends e {
    private final String a = b();
    private final String b = i();
    private final String c = aM();
    private final c d = new c(this);

    public a(JSONObject jSONObject, JSONObject jSONObject2, b bVar, m mVar) {
        super(jSONObject, jSONObject2, bVar, mVar);
    }

    private String aM() {
        return getStringFromAdObject("stream_url", "");
    }

    public void a() {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html", this.a);
            JsonUtils.putString(this.adObject, "stream_url", this.c);
        }
    }

    public void a(Uri uri) {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "video", uri.toString());
        }
    }

    public void a(String str) {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html", str);
        }
    }

    public String b() {
        String string;
        synchronized (this.adObjectLock) {
            string = JsonUtils.getString(this.adObject, "html", "");
        }
        return string;
    }

    /* renamed from: c */
    public c o() {
        return this.d;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.c;
    }

    public boolean f() {
        return this.adObject.has("stream_url");
    }

    public void g() {
        synchronized (this.adObjectLock) {
            this.adObject.remove("stream_url");
        }
    }

    public JSONObject getOriginalFullResponse() {
        JSONObject deepCopy;
        synchronized (this.fullResponseLock) {
            deepCopy = JsonUtils.deepCopy(this.fullResponse);
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(deepCopy, CampaignUnit.JSON_KEY_ADS, new JSONArray());
        if (jSONArray.length() > 0) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, 0, new JSONObject());
            JsonUtils.putString(jSONObject, "html", this.a);
            JsonUtils.putString(jSONObject, "video", this.b);
            JsonUtils.putString(jSONObject, "stream_url", this.c);
        }
        return deepCopy;
    }

    public Uri h() {
        String aM = aM();
        if (StringUtils.isValidString(aM)) {
            return Uri.parse(aM);
        }
        String i = i();
        if (StringUtils.isValidString(i)) {
            return Uri.parse(i);
        }
        return null;
    }

    public boolean hasVideoUrl() {
        return h() != null;
    }

    public String i() {
        return getStringFromAdObject("video", "");
    }

    public boolean isOpenMeasurementEnabled() {
        return getBooleanFromAdObject("omsdk_enabled", false);
    }

    public Uri j() {
        String stringFromAdObject = getStringFromAdObject(CampaignEx.JSON_KEY_CLICK_URL, "");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public Uri k() {
        String stringFromAdObject = getStringFromAdObject("video_click_url", "");
        return StringUtils.isValidString(stringFromAdObject) ? Uri.parse(stringFromAdObject) : j();
    }

    public float l() {
        return getFloatFromAdObject("mraid_close_delay_graphic", 0.0f);
    }

    public boolean m() {
        if (this.adObject.has("close_button_expandable_hidden")) {
            return getBooleanFromAdObject("close_button_expandable_hidden", false);
        }
        return true;
    }

    public i.a n() {
        return a(getIntFromAdObject("expandable_style", i.a.INVISIBLE.a()));
    }
}
