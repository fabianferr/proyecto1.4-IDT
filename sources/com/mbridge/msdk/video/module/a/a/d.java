package com.mbridge.msdk.video.module.a.a;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.module.b.b;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;

/* compiled from: ContainerViewStatisticsListener */
public class d extends k {
    public d(CampaignEx campaignEx, a aVar, c cVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i, boolean z) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i, z);
    }

    public void a(int i, Object obj) {
        super.a(i, obj);
        if (this.a) {
            try {
                if (this.b != null && this.b.getDynamicTempCode() == 5) {
                    b(obj.toString());
                }
            } catch (Exception unused) {
            }
            if (i == 105 || i == 106 || i == 113) {
                b.d(com.mbridge.msdk.foundation.controller.b.d().g(), this.b);
                if (i != 105) {
                    String noticeUrl = this.b.getNoticeUrl();
                    if (!TextUtils.isEmpty(noticeUrl)) {
                        if (!noticeUrl.contains(com.mbridge.msdk.foundation.same.a.i)) {
                            noticeUrl = noticeUrl + "&" + com.mbridge.msdk.foundation.same.a.i + "=2";
                        } else {
                            noticeUrl = noticeUrl.replace(com.mbridge.msdk.foundation.same.a.i + "=" + Uri.parse(noticeUrl).getQueryParameter(com.mbridge.msdk.foundation.same.a.i), com.mbridge.msdk.foundation.same.a.i + "=2");
                        }
                    }
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.b, this.g, noticeUrl, true, false, com.mbridge.msdk.click.a.a.i);
                }
            } else if (i != 122) {
                switch (i) {
                    case 109:
                        b(2);
                        a(2);
                        return;
                    case 110:
                        b(1);
                        a(1);
                        return;
                    case 111:
                        a(1);
                        return;
                    default:
                        return;
                }
            } else {
                a();
            }
        }
    }
}
