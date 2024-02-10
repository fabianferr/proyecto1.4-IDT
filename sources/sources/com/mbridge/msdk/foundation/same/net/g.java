package com.mbridge.msdk.foundation.same.net;

import android.text.TextUtils;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.tools.al;

/* compiled from: LoadUrlTool */
public final class g {
    public static String a(String str) {
        int i;
        e g = f.a().g(b.d().h());
        if (TextUtils.isEmpty(str)) {
            i = g.aJ();
        } else {
            i = g.aI();
        }
        String a = d.a().a(str, i);
        if (TextUtils.isEmpty(a)) {
            return "";
        }
        return al.a(a);
    }
}
