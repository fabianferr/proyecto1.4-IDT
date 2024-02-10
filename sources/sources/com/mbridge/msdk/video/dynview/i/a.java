package com.mbridge.msdk.video.dynview.i;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.w;

/* compiled from: UIControlUtil */
public final class a {
    public static String a(Context context, int i) {
        String str = i == 1 ? "_por" : "_land";
        String g = w.g(context);
        if (g.startsWith("zh")) {
            return (g.contains("TW") || g.contains("HK")) ? "mbridge_reward_two_title_zh_trad" : "mbridge_reward_two_title_zh";
        }
        if (g.startsWith("ja")) {
            return "mbridge_reward_two_title_japan".concat(str);
        }
        if (g.startsWith(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR)) {
            return "mbridge_reward_two_title_germany".concat(str);
        }
        if (g.startsWith("ko")) {
            return "mbridge_reward_two_title_korea".concat(str);
        }
        if (g.startsWith("fr")) {
            return "mbridge_reward_two_title_france".concat(str);
        }
        if (g.startsWith("ar")) {
            return "mbridge_reward_two_title_arabia".concat(str);
        }
        if (g.startsWith("ru")) {
            return "mbridge_reward_two_title_russian".concat(str);
        }
        return "mbridge_reward_two_title_en".concat(str);
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return false;
            }
            String queryParameter = parse.getQueryParameter("alecfc");
            if (TextUtils.isEmpty(queryParameter) || !queryParameter.equals("1")) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int a(CampaignEx campaignEx) {
        if (!(campaignEx == null || campaignEx.getRewardTemplateMode() == null)) {
            int b = campaignEx.getRewardTemplateMode().b();
            if (b == 302 || b == 802) {
                return -3;
            }
            if (b == 904) {
                if (!a(campaignEx.getRewardTemplateMode().e())) {
                    return -1;
                }
                return -3;
            }
        }
        return 100;
    }
}
