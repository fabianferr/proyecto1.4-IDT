package com.mbridge.msdk.video.dynview.f.a;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.d.b;
import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.l;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AbsMoreOfferResponseHandler */
public abstract class a extends f<JSONObject> {
    private int a;
    private String b;

    public abstract void a(int i, String str);

    public abstract void a(List<b> list, CampaignUnit campaignUnit);

    public void onPreExecute() {
        super.onPreExecute();
    }

    public void onSuccess(l<JSONObject> lVar) {
        CampaignUnit campaignUnit;
        super.onSuccess(lVar);
        if (lVar != null && lVar.c != null && this.a == 0) {
            List<b> list = lVar.c.d;
            JSONObject jSONObject = (JSONObject) lVar.a;
            int optInt = jSONObject.optInt("status");
            if (1 == optInt) {
                calcRequestTime(System.currentTimeMillis());
                if ("v5".equals(jSONObject.optString("version"))) {
                    campaignUnit = CampaignUnit.parseV5CampaignUnit(jSONObject.optJSONObject("data"), this.b);
                } else {
                    campaignUnit = CampaignUnit.parseCampaignUnit(jSONObject.optJSONObject("data"), this.b);
                }
                if (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() <= 0) {
                    String msg = campaignUnit != null ? campaignUnit.getMsg() : null;
                    if (TextUtils.isEmpty(msg)) {
                        msg = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                    }
                    a(optInt, msg);
                    return;
                }
                a(list, campaignUnit);
                saveRequestTime(campaignUnit.getAds().size());
                return;
            }
            a(optInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
        }
    }

    public void onError(com.mbridge.msdk.foundation.same.net.b.a aVar) {
        a(aVar.a, com.mbridge.msdk.foundation.same.net.g.a.a(aVar));
    }
}
