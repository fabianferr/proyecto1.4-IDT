package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.model.f;

/* compiled from: AutoTestUtils */
public class d {
    public static String a(String str) {
        if (!l.d() || TextUtils.isEmpty(str)) {
            return str;
        }
        f fVar = new f(h.b().l());
        StringBuilder sb = new StringBuilder(str);
        for (String contains : fVar.b()) {
            if (sb.toString().contains(contains)) {
                if (sb.toString().contains("?")) {
                    sb.append("&");
                    sb.append(fVar.a());
                } else {
                    sb.append("?");
                    sb.append(fVar.a());
                }
            }
        }
        return sb.toString();
    }
}
