package com.startapp;

import android.content.Context;
import android.webkit.WebView;

/* compiled from: Sta */
public final class j5 {
    public static void a(Context context, WebView webView, k5 k5Var) {
        if (k5Var == null) {
            k5Var = new k5(context);
        }
        boolean z = true;
        g5.a(webView, "mraid.SUPPORTED_FEATURES.CALENDAR", k5Var.b.contains("calendar") && a0.a(k5Var.a, "android.permission.WRITE_CALENDAR"));
        g5.a(webView, "mraid.SUPPORTED_FEATURES.INLINEVIDEO", k5Var.b.contains("inlineVideo"));
        g5.a(webView, "mraid.SUPPORTED_FEATURES.SMS", k5Var.b.contains("sms") && a0.a(k5Var.a, "android.permission.SEND_SMS"));
        g5.a(webView, "mraid.SUPPORTED_FEATURES.STOREPICTURE", k5Var.b.contains("storePicture"));
        if (!k5Var.b.contains("tel") || !a0.a(k5Var.a, "android.permission.CALL_PHONE")) {
            z = false;
        }
        g5.a(webView, "mraid.SUPPORTED_FEATURES.TEL", z);
    }
}
