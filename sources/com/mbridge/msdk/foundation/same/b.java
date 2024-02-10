package com.mbridge.msdk.foundation.same;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SameCommon */
public final class b {
    public static String a(List<CampaignEx> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (CampaignEx next : list) {
            if (!(next == null || next.getCreativeId() == 0)) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < arrayList.size()) {
            try {
                CampaignEx campaignEx = (CampaignEx) arrayList.get(i);
                if (campaignEx != null) {
                    long creativeId = campaignEx.getCreativeId();
                    if (i == arrayList.size() - 1) {
                        sb.append(creativeId);
                    } else {
                        sb.append(creativeId);
                        sb.append(",");
                    }
                }
                i++;
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.b("SameCommon", "getCreativeID", e);
                }
            }
        }
        return sb.toString();
    }
}
