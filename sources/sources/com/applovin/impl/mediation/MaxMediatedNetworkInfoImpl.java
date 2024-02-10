package com.applovin.impl.mediation;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

public class MaxMediatedNetworkInfoImpl implements MaxMediatedNetworkInfo {
    private final JSONObject a;

    public MaxMediatedNetworkInfoImpl(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public String getAdapterClassName() {
        return JsonUtils.getString(this.a, "class", "");
    }

    public String getAdapterVersion() {
        return JsonUtils.getString(this.a, "version", "");
    }

    public String getName() {
        return JsonUtils.getString(this.a, "name", "");
    }

    public String getSdkVersion() {
        return JsonUtils.getString(this.a, "sdk_version", "");
    }

    public String toString() {
        return "MaxMediatedNetworkInfo{name=" + getName() + ", adapterClassName=" + getAdapterClassName() + ", adapterVersion=" + getAdapterVersion() + ", sdkVersion=" + getSdkVersion() + AbstractJsonLexerKt.END_OBJ;
    }
}
