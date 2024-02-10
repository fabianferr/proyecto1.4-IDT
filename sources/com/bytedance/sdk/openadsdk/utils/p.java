package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.b.l;
import com.bytedance.sdk.openadsdk.core.model.q;
import java.util.Map;

/* compiled from: OpenUtils */
public class p {
    public static void a(Activity activity, String str, final q qVar, final String str2) {
        if (!a(activity, str)) {
            c.a(qVar, str2, 0, 7, false);
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        final int b = ac.b((Context) activity, intent);
        b.a(activity, intent, new b.a() {
            public void a() {
                c.a(qVar, str2, b, 0, true);
            }

            public void a(Throwable th) {
                c.a(qVar, str2, b, 6, false, th.toString());
            }
        });
    }

    public static boolean b(Activity activity, String str, q qVar, String str2) {
        if (!a(activity, str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        c.a(qVar, str2, "open_url_app", (Map<String, Object>) null);
        try {
            activity.startActivity(intent);
            l.a().a(qVar, str2);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(Activity activity, String str) {
        return a(activity) && !TextUtils.isEmpty(str);
    }

    public static boolean a(Activity activity) {
        if (activity != null && !activity.isDestroyed()) {
            return !activity.isFinishing();
        }
        return false;
    }
}
