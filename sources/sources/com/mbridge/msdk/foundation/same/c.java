package com.mbridge.msdk.foundation.same;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;

/* compiled from: SameTools */
public final class c {
    public static int a(CampaignEx campaignEx, String str) {
        int i;
        if (campaignEx == null) {
            return -1;
        }
        try {
            if (!TextUtils.isEmpty(campaignEx.getMof_template_url())) {
                i = af.l(campaignEx.getMof_template_url());
            } else {
                i = af.l(str);
            }
            return i;
        } catch (Exception e) {
            aa.d("SameTools", e.getMessage());
            return -1;
        }
    }
}
