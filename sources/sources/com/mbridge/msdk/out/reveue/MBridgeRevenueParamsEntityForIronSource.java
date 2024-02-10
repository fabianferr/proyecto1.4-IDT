package com.mbridge.msdk.out.reveue;

import android.text.TextUtils;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import org.json.JSONObject;

public class MBridgeRevenueParamsEntityForIronSource extends MBridgeRevenueParamsEntity {
    public MBridgeRevenueParamsEntityForIronSource(String str, String str2) {
        super(str, str2);
        setMediationName(IronSourceConstants.IRONSOURCE_CONFIG_NAME);
    }

    public void setIronSourceImpressionDataString(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setMediationUnitId(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            String str3 = "{" + str2 + "}";
            try {
                setSourceData(str3, str3);
                JSONObject jSONObject = new JSONObject(str3);
                setNetworkName(jSONObject.optString(ImpressionData.IMPRESSION_DATA_KEY_AD_NETWORK, ""));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(ImpressionData.IMPRESSION_DATA_KEY_INSTANCE_NAME, jSONObject.optString(ImpressionData.IMPRESSION_DATA_KEY_INSTANCE_NAME, ""));
                jSONObject2.put(ImpressionData.IMPRESSION_DATA_KEY_INSTANCE_ID, jSONObject.optString(ImpressionData.IMPRESSION_DATA_KEY_INSTANCE_ID, ""));
                setNetworkInfo(jSONObject2);
                setAdType(jSONObject.optString("adUnit", ""));
                setRevenue(jSONObject.optString(ImpressionData.IMPRESSION_DATA_KEY_REVENUE, ""));
                setPrecision(jSONObject.optString(ImpressionData.IMPRESSION_DATA_KEY_PRECISION, ""));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setDspInfo(String str, String str2) {
        super.setDspInfo(str, str2);
    }
}
