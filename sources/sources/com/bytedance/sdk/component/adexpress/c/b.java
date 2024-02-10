package com.bytedance.sdk.component.adexpress.c;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: DeviceUtil */
public class b {
    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        if ((TextUtils.getLayoutDirectionFromLocale(context.getResources().getConfiguration().locale) == 1) && (context.getApplicationInfo().flags & 4194304) == 4194304) {
            return true;
        }
        return false;
    }
}
