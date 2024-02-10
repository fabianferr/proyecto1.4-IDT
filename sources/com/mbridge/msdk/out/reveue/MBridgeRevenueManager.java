package com.mbridge.msdk.out.reveue;

import android.content.Context;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.same.report.l;
import com.mbridge.msdk.foundation.same.report.m;
import java.util.HashMap;

public class MBridgeRevenueManager {
    public static void track(Context context, MBridgeRevenueParamsEntity mBridgeRevenueParamsEntity) {
        if (b.d().g() == null) {
            b.d().b(context);
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("name", mBridgeRevenueParamsEntity.getMediationName());
            m.a().b("m_start_ad_rev", "roas", "", "", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        l.a().a(mBridgeRevenueParamsEntity.getReportData());
    }
}
