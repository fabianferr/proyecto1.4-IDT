package com.appnext.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.appnext.core.adswatched.a;
import java.util.ArrayList;

public class e {
    private static volatile e cs;

    public static e R() {
        if (cs == null) {
            synchronized (e.class) {
                if (cs == null) {
                    cs = new e();
                }
            }
        }
        return cs;
    }

    public static String a(Context context, String str, String str2, long j, String str3, String str4, String str5) {
        String str6;
        String str7 = str2;
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        String str8 = "adsServerResponseAuid" + str7;
        String str9 = "adsServerResponseAcceptedTimeAuid" + str7;
        if (!TextUtils.isEmpty(str4.trim()) || !TextUtils.isEmpty(str5.trim()) || System.currentTimeMillis() >= l.h(context).a(str9, 0) + (60000 * j)) {
            str6 = "";
        } else {
            str6 = l.h(context).c(str8, (String) null);
        }
        if (TextUtils.isEmpty(str6)) {
            try {
                if (TextUtils.isEmpty(str4.trim()) && TextUtils.isEmpty(str5.trim())) {
                    String str10 = str;
                    a.l(context).k(str, str7);
                }
                Context context2 = context;
                str6 = g.a(context, str3, (ArrayList<Pair<String, String>>) null, 16000);
                if (TextUtils.isEmpty(str4.trim()) && TextUtils.isEmpty(str5.trim())) {
                    if (TextUtils.isEmpty(str6) || str6.equals("{\"apps\":[]}")) {
                        l.h(context).d(str8, "");
                        l.h(context).b(str9, 0);
                    } else {
                        l.h(context).d(str8, str6);
                        l.h(context).b(str9, System.currentTimeMillis());
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return str6;
    }
}
