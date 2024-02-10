package com.bytedance.sdk.openadsdk.b;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: AdEventConstants */
public class b {
    public static final Set<String> a = new HashSet(Arrays.asList(new String[]{CampaignEx.JSON_NATIVE_VIDEO_CLICK, "show", "insight_log"}));

    /* compiled from: AdEventConstants */
    public static class a {
        public static int a = 1;
        public static int b = 2;
        public static int c = 100;
    }

    public static boolean a(String str) {
        return "embeded_ad".equals(str) || "banner_ad".equals(str) || "interaction".equals(str) || "slide_banner_ad".equals(str);
    }
}
