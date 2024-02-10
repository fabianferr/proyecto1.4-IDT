package com.mbridge.msdk.click.b;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.foundation.tools.y;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;

/* compiled from: DspFilterUtils */
public final class a {
    public static int a = 1;
    public static int b = 2;
    public static int c = 1500;
    private static String d = "2000109";
    private static String e = "DspFilterUtils";

    public static boolean a(CampaignEx campaignEx, String str, int i) {
        boolean z = false;
        if (campaignEx != null && campaignEx.getTpOffer() == 1) {
            if (campaignEx.getFac() != 0) {
                z = true;
            }
            try {
                Context g = b.d().g();
                if (!(g == null || campaignEx == null)) {
                    if (URLUtil.isFileUrl(str)) {
                        File file = new File(str.replace("file:////", "").replace("file:///", "").replace(AdPayload.FILE_SCHEME, ""));
                        if (file.exists()) {
                            str = y.a(file);
                        }
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    StringBuffer append = stringBuffer.append("key=" + d + "&");
                    StringBuffer append2 = append.append("type=" + i + "&");
                    StringBuffer append3 = append2.append("html=" + str + "&");
                    append3.append("network_type=" + w.r(g) + "&");
                    append3.append("unit_id=" + campaignEx.getCampaignUnitId() + "&");
                    String requestId = campaignEx.getRequestId();
                    if (!TextUtils.isEmpty(requestId)) {
                        append3.append("rid=").append(requestId).append("&");
                    }
                    if (campaignEx.isBidCampaign()) {
                        append3.append("hb=1&");
                    }
                    String requestIdNotice = campaignEx.getRequestIdNotice();
                    if (!TextUtils.isEmpty(requestIdNotice)) {
                        append3 = append3.append("rid_n=").append(requestIdNotice).append("&");
                    }
                    StringBuffer append4 = append3.append("cid=" + campaignEx.getId());
                    if (k.a().c()) {
                        k.a().a(append4.toString());
                    } else {
                        q.b(g, append4.toString());
                    }
                }
            } catch (Throwable th) {
                aa.d(e, th.getMessage());
            }
        }
        return z;
    }
}
