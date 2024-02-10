package com.mbridge.msdk.video.module.b;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.al;
import java.util.Map;

/* compiled from: RewardDynamicViewReporter */
public final class a {
    public static void a(String str, CampaignEx campaignEx, Map<String, String> map) {
        String str2;
        String str3;
        if (!TextUtils.isEmpty(str) && campaignEx != null && map != null) {
            String str4 = "";
            if (campaignEx != null) {
                try {
                    String currentLRid = campaignEx.getCurrentLRid();
                    String mof_template_url = campaignEx.getMof_template_url();
                    if (!TextUtils.isEmpty(mof_template_url)) {
                        str2 = al.a(mof_template_url, "cltp");
                        str3 = al.a(mof_template_url, "xt");
                    } else {
                        str3 = str4;
                        str2 = str3;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        map.put("cltp", str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        map.put("xt", str3);
                    }
                    CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
                    if (rewardTemplateMode != null) {
                        String e = rewardTemplateMode.e();
                        if (!TextUtils.isEmpty(e)) {
                            str4 = al.a(e, "alecfc");
                        }
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        map.put("alecfc", str4);
                    }
                    str4 = currentLRid;
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        e2.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            if (map.get("type").equals("choseFromTwoShow")) {
                m.a().b(str, str4, map);
            } else {
                m.a().a(str, str4, map);
            }
        }
    }
}
