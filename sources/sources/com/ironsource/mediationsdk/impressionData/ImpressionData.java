package com.ironsource.mediationsdk.impressionData;

import com.ironsource.mediationsdk.logger.IronLog;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;

public class ImpressionData {
    public static final String IMPRESSION_DATA_KEY_ABTEST = "ab";
    public static final String IMPRESSION_DATA_KEY_AD_NETWORK = "adNetwork";
    public static final String IMPRESSION_DATA_KEY_AD_UNIT = "adUnit";
    public static final String IMPRESSION_DATA_KEY_AUCTION_ID = "auctionId";
    public static final String IMPRESSION_DATA_KEY_COUNTRY = "country";
    public static final String IMPRESSION_DATA_KEY_ENCRYPTED_CPM = "encryptedCPM";
    public static final String IMPRESSION_DATA_KEY_INSTANCE_ID = "instanceId";
    public static final String IMPRESSION_DATA_KEY_INSTANCE_NAME = "instanceName";
    public static final String IMPRESSION_DATA_KEY_LIFETIME_REVENUE = "lifetimeRevenue";
    public static final String IMPRESSION_DATA_KEY_PLACEMENT = "placement";
    public static final String IMPRESSION_DATA_KEY_PRECISION = "precision";
    public static final String IMPRESSION_DATA_KEY_REVENUE = "revenue";
    public static final String IMPRESSION_DATA_KEY_SEGMENT_NAME = "segmentName";
    private JSONObject a;
    private String b = null;
    private String c = null;
    private String d = null;
    private String e = null;
    private String f = null;
    private String g = null;
    private String h = null;
    private String i = null;
    private String j = null;
    private Double k = null;
    private String l = null;
    private Double m = null;
    private String n = null;
    private DecimalFormat o = new DecimalFormat("#.#####");

    public ImpressionData(ImpressionData impressionData) {
        this.a = impressionData.a;
        this.b = impressionData.b;
        this.c = impressionData.c;
        this.d = impressionData.d;
        this.e = impressionData.e;
        this.f = impressionData.f;
        this.g = impressionData.g;
        this.h = impressionData.h;
        this.i = impressionData.i;
        this.j = impressionData.j;
        this.l = impressionData.l;
        this.n = impressionData.n;
        this.m = impressionData.m;
        this.k = impressionData.k;
    }

    public ImpressionData(JSONObject jSONObject) {
        Double d2 = null;
        if (jSONObject != null) {
            try {
                this.a = jSONObject;
                this.b = jSONObject.optString("auctionId", (String) null);
                this.c = jSONObject.optString("adUnit", (String) null);
                this.d = jSONObject.optString("country", (String) null);
                this.e = jSONObject.optString(IMPRESSION_DATA_KEY_ABTEST, (String) null);
                this.f = jSONObject.optString(IMPRESSION_DATA_KEY_SEGMENT_NAME, (String) null);
                this.g = jSONObject.optString("placement", (String) null);
                this.h = jSONObject.optString(IMPRESSION_DATA_KEY_AD_NETWORK, (String) null);
                this.i = jSONObject.optString(IMPRESSION_DATA_KEY_INSTANCE_NAME, (String) null);
                this.j = jSONObject.optString(IMPRESSION_DATA_KEY_INSTANCE_ID, (String) null);
                this.l = jSONObject.optString(IMPRESSION_DATA_KEY_PRECISION, (String) null);
                this.n = jSONObject.optString(IMPRESSION_DATA_KEY_ENCRYPTED_CPM, (String) null);
                double optDouble = jSONObject.optDouble(IMPRESSION_DATA_KEY_LIFETIME_REVENUE);
                this.m = Double.isNaN(optDouble) ? null : Double.valueOf(optDouble);
                double optDouble2 = jSONObject.optDouble(IMPRESSION_DATA_KEY_REVENUE);
                if (!Double.isNaN(optDouble2)) {
                    d2 = Double.valueOf(optDouble2);
                }
                this.k = d2;
            } catch (Exception e2) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("error parsing impression " + e2.getMessage());
            }
        }
    }

    public String getAb() {
        return this.e;
    }

    public String getAdNetwork() {
        return this.h;
    }

    public String getAdUnit() {
        return this.c;
    }

    public JSONObject getAllData() {
        return this.a;
    }

    public String getAuctionId() {
        return this.b;
    }

    public String getCountry() {
        return this.d;
    }

    public String getEncryptedCPM() {
        return this.n;
    }

    public String getInstanceId() {
        return this.j;
    }

    public String getInstanceName() {
        return this.i;
    }

    public Double getLifetimeRevenue() {
        return this.m;
    }

    public String getPlacement() {
        return this.g;
    }

    public String getPrecision() {
        return this.l;
    }

    public Double getRevenue() {
        return this.k;
    }

    public String getSegmentName() {
        return this.f;
    }

    public void replaceMacroForPlacementWithValue(String str, String str2) {
        String str3 = this.g;
        if (str3 != null) {
            String replace = str3.replace(str, str2);
            this.g = replace;
            JSONObject jSONObject = this.a;
            if (jSONObject != null) {
                try {
                    jSONObject.put("placement", replace);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("auctionId: '");
        sb.append(this.b);
        sb.append("', adUnit: '");
        sb.append(this.c);
        sb.append("', country: '");
        sb.append(this.d);
        sb.append("', ab: '");
        sb.append(this.e);
        sb.append("', segmentName: '");
        sb.append(this.f);
        sb.append("', placement: '");
        sb.append(this.g);
        sb.append("', adNetwork: '");
        sb.append(this.h);
        sb.append("', instanceName: '");
        sb.append(this.i);
        sb.append("', instanceId: '");
        sb.append(this.j);
        sb.append("', revenue: ");
        Double d2 = this.k;
        String str = null;
        sb.append(d2 == null ? null : this.o.format(d2));
        sb.append(", precision: '");
        sb.append(this.l);
        sb.append("', lifetimeRevenue: ");
        Double d3 = this.m;
        if (d3 != null) {
            str = this.o.format(d3);
        }
        sb.append(str);
        sb.append(", encryptedCPM: '");
        sb.append(this.n);
        return sb.toString();
    }
}
