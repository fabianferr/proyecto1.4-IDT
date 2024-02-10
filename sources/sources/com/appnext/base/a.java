package com.appnext.base;

import android.text.TextUtils;
import com.appnext.core.crashes.b;

public final class a {
    public static void a(String str, Throwable th) {
        String message = th.getMessage();
        if (TextUtils.isEmpty(message)) {
            message = th.toString();
            if (TextUtils.isEmpty(message)) {
                return;
            }
        }
        b.m(com.appnext.base.b.a.getContext()).l(str, message);
    }
}
