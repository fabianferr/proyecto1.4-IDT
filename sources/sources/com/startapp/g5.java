package com.startapp;

import android.content.Context;
import android.webkit.WebView;
import com.startapp.sdk.adsbase.mraid.bridge.MraidState;

/* compiled from: Sta */
public final class g5 {
    public static void a(MraidState mraidState, WebView webView) {
        k9.a(webView, true, "mraid.fireStateChangeEvent", mraidState.name().toLowerCase());
    }

    public static void b(Context context, int i, int i2, WebView webView) {
        k9.a(webView, true, "mraid.setScreenSize", Integer.valueOf(Math.round(((float) i) / context.getResources().getDisplayMetrics().density)), Integer.valueOf(Math.round(((float) i2) / context.getResources().getDisplayMetrics().density)));
    }

    public static void a(Context context, int i, int i2, WebView webView) {
        k9.a(webView, true, "mraid.setMaxSize", Integer.valueOf(Math.round(((float) i) / context.getResources().getDisplayMetrics().density)), Integer.valueOf(Math.round(((float) i2) / context.getResources().getDisplayMetrics().density)));
    }

    public static void b(Context context, int i, int i2, int i3, int i4, WebView webView) {
        k9.a(webView, true, "mraid.setDefaultPosition", Integer.valueOf(Math.round(((float) i) / context.getResources().getDisplayMetrics().density)), Integer.valueOf(Math.round(((float) i2) / context.getResources().getDisplayMetrics().density)), Integer.valueOf(Math.round(((float) i3) / context.getResources().getDisplayMetrics().density)), Integer.valueOf(Math.round(((float) i4) / context.getResources().getDisplayMetrics().density)));
    }

    public static void a(Context context, int i, int i2, int i3, int i4, WebView webView) {
        k9.a(webView, true, "mraid.setCurrentPosition", Integer.valueOf(Math.round(((float) i) / context.getResources().getDisplayMetrics().density)), Integer.valueOf(Math.round(((float) i2) / context.getResources().getDisplayMetrics().density)), Integer.valueOf(Math.round(((float) i3) / context.getResources().getDisplayMetrics().density)), Integer.valueOf(Math.round(((float) i4) / context.getResources().getDisplayMetrics().density)));
    }

    public static void a(WebView webView, String str, String str2) {
        k9.a(webView, true, "mraid.fireErrorEvent", str, str2);
    }

    public static void a(WebView webView, String str, boolean z) {
        k9.a(webView, false, "mraid.setSupports", str, Boolean.valueOf(z));
    }
}
