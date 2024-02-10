package com.mbridge.msdk.reward.d;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.b.a;
import com.mbridge.msdk.foundation.same.net.d.b;
import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.l;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.out.Frame;
import java.util.List;
import org.json.JSONObject;

/* compiled from: RewardResponseHandler */
public abstract class c extends f<JSONObject> {
    private static final String a = "c";
    private int b;
    /* access modifiers changed from: private */
    public String c;

    public abstract void a(List<Frame> list);

    public abstract void a(List<b> list, CampaignUnit campaignUnit);

    public abstract void b(int i, String str, int i2);

    public final void a(String str) {
        this.c = str;
    }

    public void onPreExecute() {
        super.onPreExecute();
    }

    public void onSuccess(l<JSONObject> lVar) {
        CampaignUnit campaignUnit;
        super.onSuccess(lVar);
        if (lVar != null && lVar.c != null) {
            int i = this.b;
            if (i == 0) {
                final List<b> list = lVar.c.d;
                final JSONObject jSONObject = (JSONObject) lVar.a;
                final int optInt = jSONObject.optInt("status");
                if (1 == optInt) {
                    calcRequestTime(System.currentTimeMillis());
                    final String optString = jSONObject.optString("version");
                    com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() {
                        public final void run() {
                            final CampaignUnit campaignUnit;
                            if ("v5".equals(optString)) {
                                campaignUnit = CampaignUnit.parseV5CampaignUnit(jSONObject.optJSONObject("data"), c.this.c);
                            } else {
                                campaignUnit = CampaignUnit.parseCampaignUnit(jSONObject.optJSONObject("data"), c.this.c);
                            }
                            com.mbridge.msdk.foundation.same.f.b.h().post(new Runnable() {
                                public final void run() {
                                    CampaignUnit campaignUnit = campaignUnit;
                                    if (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() <= 0) {
                                        CampaignUnit campaignUnit2 = campaignUnit;
                                        String msg = campaignUnit2 != null ? campaignUnit2.getMsg() : null;
                                        if (TextUtils.isEmpty(msg)) {
                                            msg = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                                        }
                                        c.this.b(optInt, msg, 2);
                                        return;
                                    }
                                    c.this.a(list, campaignUnit);
                                    c.this.saveRequestTime(campaignUnit.getAds().size());
                                }
                            });
                        }
                    });
                    return;
                }
                a(list, jSONObject, optInt);
            } else if (i == 1) {
                List<b> list2 = lVar.c.d;
                JSONObject jSONObject2 = (JSONObject) lVar.a;
                int optInt2 = jSONObject2.optInt("status");
                if (1 == optInt2) {
                    calcRequestTime(System.currentTimeMillis());
                    if ("v5".equals(jSONObject2.optString("version"))) {
                        campaignUnit = CampaignUnit.parseV5CampaignUnit(jSONObject2.optJSONObject("data"), this.c);
                    } else {
                        campaignUnit = CampaignUnit.parseCampaignUnit(jSONObject2.optJSONObject("data"), this.c);
                    }
                    if (campaignUnit == null || campaignUnit.getListFrames() == null || campaignUnit.getListFrames().size() <= 0) {
                        String msg = campaignUnit != null ? campaignUnit.getMsg() : null;
                        if (TextUtils.isEmpty(msg)) {
                            msg = jSONObject2.optString(NotificationCompat.CATEGORY_MESSAGE);
                        }
                        b(optInt2, msg, 2);
                        return;
                    }
                    List<Frame> listFrames = campaignUnit.getListFrames();
                    a(listFrames);
                    saveRequestTime(listFrames.size());
                    return;
                }
                a(list2, jSONObject2, optInt2);
            }
        }
    }

    private void a(List<b> list, JSONObject jSONObject, int i) {
        String str = "";
        if (list != null && list.size() > 0) {
            for (b next : list) {
                if (next != null) {
                    String a2 = next.a();
                    if (!TextUtils.isEmpty(a2) && a2.equals("data_res_type")) {
                        str = next.b();
                    }
                }
            }
        }
        if (TextUtils.isEmpty(str) || !str.equals("1")) {
            b(i, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE), 2);
        } else {
            b(i, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE), 3);
        }
    }

    public void onError(a aVar) {
        String str = a;
        aa.d(str, "errorCode = " + aVar.a);
        b(aVar.a, com.mbridge.msdk.foundation.same.net.g.a.a(aVar), 1);
    }
}
