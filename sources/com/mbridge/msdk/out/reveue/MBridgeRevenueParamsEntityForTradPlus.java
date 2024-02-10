package com.mbridge.msdk.out.reveue;

import android.text.TextUtils;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import org.json.JSONObject;

public class MBridgeRevenueParamsEntityForTradPlus extends MBridgeRevenueParamsEntity {
    public MBridgeRevenueParamsEntityForTradPlus(String str, String str2) {
        super(str, str2);
        setMediationName("TradPlus");
    }

    public void setTradPlusAdInfo(String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            try {
                String replace = str.replace("\"", "\\\"").replace("----------------------\n", "{\"").replaceAll("(?<!\"):(?!\")", "\":\"").replace("\n", "\",\"");
                if (replace.endsWith("\"")) {
                    str2 = (replace + "}").replace(",\"}", "}");
                } else {
                    str2 = replace + "\"}";
                }
                JSONObject jSONObject = new JSONObject(str2);
                setAdType(jSONObject.optInt("placementAdType") + "");
                setMediationUnitId(jSONObject.optString("tpAdUnitId"));
                setNetworkName(jSONObject.optString("adSourceName"));
                setBidType(Boolean.valueOf(jSONObject.optBoolean("isBiddingNetwork", false)));
                setRevenue(jSONObject.optString("ecpm", ""));
                setPrecision(jSONObject.optString("ecpmPrecision", ""));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(ImpressionData.IMPRESSION_DATA_KEY_INSTANCE_NAME, jSONObject.optString("adSourceName", ""));
                jSONObject2.put(ImpressionData.IMPRESSION_DATA_KEY_INSTANCE_ID, jSONObject.optString("adSourceId", ""));
                setNetworkInfo(jSONObject2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        setSourceData(str, str);
    }

    public void setDspInfo(String str, String str2) {
        super.setDspInfo(str, str2);
    }
}