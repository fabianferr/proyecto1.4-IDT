package com.appnext.core;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

public class o {
    private static volatile o dB;

    public static o ab() {
        if (dB == null) {
            synchronized (o.class) {
                if (dB == null) {
                    dB = new o();
                }
            }
        }
        return dB;
    }

    public static String i(Context context) {
        String c = System.currentTimeMillis() < l.h(context).a("translateServerResponseAcceptedTime", 0) + 604800000 ? l.h(context).c("translateServerResponses", (String) null) : "";
        if (TextUtils.isEmpty(c)) {
            try {
                c = g.a(context, "https://cdn.appnext.com/tools/sdk/langs/2.4.4/langs.json", (HashMap<String, String>) null);
                if (!TextUtils.isEmpty(c)) {
                    l.h(context).d("translateServerResponses", c);
                    l.h(context).b("translateServerResponseAcceptedTime", System.currentTimeMillis());
                }
            } catch (Throwable unused) {
            }
        }
        return c;
    }
}
