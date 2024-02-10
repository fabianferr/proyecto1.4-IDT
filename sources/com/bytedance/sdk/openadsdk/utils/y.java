package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TempSPUtils */
public class y {
    private static final Map<String, y> a = new HashMap();
    private SharedPreferences b;

    public static y a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_sp";
        }
        Map<String, y> map = a;
        y yVar = map.get(str);
        if (yVar != null) {
            return yVar;
        }
        y yVar2 = new y(str, context);
        map.put(str, yVar2);
        return yVar2;
    }

    private y(String str, Context context) {
        if (context != null) {
            this.b = context.getSharedPreferences(str, 0);
        }
    }

    public String a(String str, String str2) {
        try {
            return this.b.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public void a(String str) {
        try {
            this.b.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }
}
