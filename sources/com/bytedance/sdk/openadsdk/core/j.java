package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.e.c;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.Locale;

/* compiled from: IdUtils */
public class j {
    private static String a;
    private static String b;
    private static String c;
    private static String d;
    private static boolean e;

    private static Context d(Context context) {
        return context == null ? o.a() : context;
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        f(context);
        return a;
    }

    public static String b(Context context) {
        if (c == null && !e) {
            synchronized (j.class) {
                if (!e) {
                    e(context);
                }
            }
        }
        return c;
    }

    public static String c(Context context) {
        if (TextUtils.isEmpty(d) && !e) {
            synchronized (j.class) {
                if (!e) {
                    e(context);
                }
            }
        }
        return d;
    }

    public static void a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(a)) {
            c.a(context).a("did", str);
            a = str;
        }
        if (!TextUtils.isEmpty(a)) {
            c.a(a);
        }
    }

    private static void e(Context context) {
        Context d2;
        if (!e && (d2 = d(context)) != null) {
            b = b();
            c = String.valueOf(Build.TIME);
            d = c.a(d2).b("uuid", (String) null);
            e = true;
        }
    }

    private static void f(Context context) {
        Context d2 = d(context);
        if (d2 != null) {
            a = c.a(d2).b("did", (String) null);
        }
    }

    private static String b() {
        StringBuilder sb = new StringBuilder();
        try {
            if (t.e()) {
                sb.append("MIUI-");
            } else if (t.b()) {
                sb.append("FLYME-");
            } else {
                String n = t.n();
                if (t.a(n)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(n)) {
                    sb.append(n);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    public static String a() {
        Locale locale;
        String str;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = LocaleList.getDefault().get(0);
            } else {
                locale = Locale.getDefault();
            }
            if (locale != null) {
                str = locale.getLanguage();
            } else {
                str = "";
            }
            if (locale == null || !"zh".equals(str)) {
                return str;
            }
            String locale2 = locale.toString();
            if (locale.toString().length() >= 5) {
                locale2 = locale2.substring(0, 5);
            }
            if (Locale.SIMPLIFIED_CHINESE.toString().equals(locale2)) {
                return "zh";
            }
            return "zh-Hant";
        } catch (Throwable unused) {
            return "";
        }
    }
}
