package com.bytedance.sdk.component.adexpress.c;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.d;

/* compiled from: GlobalAdTypeUtils */
public class c {
    public static boolean a(String str) {
        return d.b() && (TextUtils.equals(str, "embeded_ad") || TextUtils.equals(str, "banner_ad"));
    }
}
