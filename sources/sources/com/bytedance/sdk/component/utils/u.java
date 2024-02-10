package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.text.TextUtils;

/* compiled from: TTAppInfoUtils */
public class u {
    private static volatile String a;

    public static String a() {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        a = Build.MODEL;
        return a;
    }
}
