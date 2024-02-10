package com.ironsource.mediationsdk.adunit.adapter.utility;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.adunit.data.DataKeys;
import com.ironsource.mediationsdk.d.c;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class AdData {
    private final Map<String, Object> mAdUnitData;
    private final Map<String, Object> mConfiguration;
    private final String mServerData;

    public AdData(String str, Map<String, Object> map, Map<String, Object> map2) {
        this.mServerData = str;
        this.mConfiguration = map;
        this.mAdUnitData = map2;
    }

    public static AdData createAdDataForNetworkAdapter(JSONObject jSONObject, IronSource.AD_UNIT ad_unit, String str) {
        return createAdDataForNetworkAdapter(jSONObject, ad_unit, str, (IronSourceBannerLayout) null);
    }

    public static AdData createAdDataForNetworkAdapter(JSONObject jSONObject, IronSource.AD_UNIT ad_unit, String str, IronSourceBannerLayout ironSourceBannerLayout) {
        HashMap hashMap = new HashMap();
        hashMap.put("adUnit", ad_unit);
        if (str != null) {
            hashMap.put(DataKeys.USER_ID, str);
        }
        if (ironSourceBannerLayout != null) {
            hashMap.put(IronSourceConstants.BANNER_LAYOUT, ironSourceBannerLayout);
        }
        return new AdData((String) null, c.a(jSONObject), hashMap);
    }

    public Map<String, Object> getAdUnitData() {
        return this.mAdUnitData;
    }

    public Boolean getBoolean(String str) {
        return (Boolean) this.mConfiguration.get(str);
    }

    public Map<String, Object> getConfiguration() {
        return this.mConfiguration;
    }

    public Integer getInt(String str) {
        return (Integer) this.mConfiguration.get(str);
    }

    public String getServerData() {
        return this.mServerData;
    }

    public String getString(String str) {
        return (String) this.mConfiguration.get(str);
    }
}
