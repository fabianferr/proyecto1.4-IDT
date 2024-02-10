package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.res.Configuration;
import java.util.Locale;

/* compiled from: LanguageUtils */
public class i {
    private static Context a;

    public static void a(Context context, String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        try {
            a = context.createConfigurationContext(b(context, str, str2));
        } catch (Throwable th) {
            l.d(th.getMessage());
        }
        s.a(a);
    }

    private static Configuration b(Context context, String str, String str2) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(new Locale(str, str2));
        return configuration;
    }
}
