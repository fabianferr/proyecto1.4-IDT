package com.bytedance.sdk.component.adexpress.c;

import android.text.TextUtils;

/* compiled from: RitScreenUtils */
public class d {
    public static boolean a(String str) {
        return TextUtils.equals(str, "fullscreen_interstitial_ad") || TextUtils.equals(str, "rewarded_video");
    }

    public static boolean b(String str) {
        return com.bytedance.sdk.component.adexpress.d.b() && a(str);
    }
}
