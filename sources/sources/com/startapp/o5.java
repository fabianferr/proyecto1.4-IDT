package com.startapp;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.ByteArrayInputStream;
import java.util.Locale;

/* compiled from: Sta */
public class o5 extends WebViewClient {
    private static final String LOG_TAG = "o5";
    private static final String MRAID_JS = "mraid.js";
    private static final String MRAID_PREFIX = "mraid://";
    private e5 controller;
    private boolean isMraidInjected = false;

    public o5(e5 e5Var) {
        this.controller = e5Var;
    }

    private WebResourceResponse createMraidInjectionResponse() {
        StringBuilder a = p0.a("javascript:");
        a.append(f5.a());
        return new WebResourceResponse("text/javascript", "UTF-8", new ByteArrayInputStream(a.toString().getBytes()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0088 A[Catch:{ Exception -> 0x00c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008e A[Catch:{ Exception -> 0x00c0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean invokeMraidMethod(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "close"
            java.lang.String r1 = "resize"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1}
            java.lang.String r1 = "createCalendarEvent"
            java.lang.String r2 = "expand"
            java.lang.String r3 = "open"
            java.lang.String r4 = "playVideo"
            java.lang.String r5 = "storePicture"
            java.lang.String r6 = "useCustomClose"
            java.lang.String[] r1 = new java.lang.String[]{r1, r2, r3, r4, r5, r6}
            java.lang.String r2 = "setOrientationProperties"
            java.lang.String r3 = "setResizeProperties"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}
            r3 = 0
            java.util.Map r8 = com.startapp.m5.a(r8)     // Catch:{ Exception -> 0x00c0 }
            java.lang.String r4 = "command"
            java.lang.Object r4 = r8.get(r4)     // Catch:{ Exception -> 0x00c0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x00c0 }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ Exception -> 0x00c0 }
            boolean r0 = r0.contains(r4)     // Catch:{ Exception -> 0x00c0 }
            r5 = 1
            if (r0 == 0) goto L_0x004b
            java.lang.Class<com.startapp.e5> r8 = com.startapp.e5.class
            java.lang.Class[] r0 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x00c0 }
            java.lang.reflect.Method r8 = r8.getDeclaredMethod(r4, r0)     // Catch:{ Exception -> 0x00c0 }
            com.startapp.e5 r0 = r7.controller     // Catch:{ Exception -> 0x00c0 }
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x00c0 }
            r8.invoke(r0, r1)     // Catch:{ Exception -> 0x00c0 }
            goto L_0x00bf
        L_0x004b:
            java.util.List r0 = java.util.Arrays.asList(r1)     // Catch:{ Exception -> 0x00c0 }
            boolean r0 = r0.contains(r4)     // Catch:{ Exception -> 0x00c0 }
            if (r0 == 0) goto L_0x00a0
            java.lang.Class<com.startapp.e5> r0 = com.startapp.e5.class
            java.lang.Class[] r1 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x00c0 }
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            r1[r3] = r2     // Catch:{ Exception -> 0x00c0 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r4, r1)     // Catch:{ Exception -> 0x00c0 }
            int r1 = r4.hashCode()     // Catch:{ Exception -> 0x00c0 }
            r2 = -733616544(0xffffffffd445e660, float:-3.39989443E12)
            java.lang.String r6 = "useCustomClose"
            if (r1 == r2) goto L_0x007b
            r2 = 1614272768(0x6037d900, float:5.299048E19)
            if (r1 == r2) goto L_0x0073
            goto L_0x0085
        L_0x0073:
            boolean r1 = r4.equals(r6)     // Catch:{ Exception -> 0x00c0 }
            if (r1 == 0) goto L_0x0085
            r1 = 1
            goto L_0x0086
        L_0x007b:
            java.lang.String r1 = "createCalendarEvent"
            boolean r1 = r4.equals(r1)     // Catch:{ Exception -> 0x00c0 }
            if (r1 == 0) goto L_0x0085
            r1 = 0
            goto L_0x0086
        L_0x0085:
            r1 = -1
        L_0x0086:
            if (r1 == 0) goto L_0x008e
            if (r1 == r5) goto L_0x0090
            java.lang.String r6 = "url"
            goto L_0x0090
        L_0x008e:
            java.lang.String r6 = "eventJSON"
        L_0x0090:
            java.lang.Object r8 = r8.get(r6)     // Catch:{ Exception -> 0x00c0 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x00c0 }
            com.startapp.e5 r1 = r7.controller     // Catch:{ Exception -> 0x00c0 }
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x00c0 }
            r2[r3] = r8     // Catch:{ Exception -> 0x00c0 }
            r0.invoke(r1, r2)     // Catch:{ Exception -> 0x00c0 }
            goto L_0x00bf
        L_0x00a0:
            java.util.List r0 = java.util.Arrays.asList(r2)     // Catch:{ Exception -> 0x00c0 }
            boolean r0 = r0.contains(r4)     // Catch:{ Exception -> 0x00c0 }
            if (r0 == 0) goto L_0x00bf
            java.lang.Class<com.startapp.e5> r0 = com.startapp.e5.class
            java.lang.Class[] r1 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x00c0 }
            java.lang.Class<java.util.Map> r2 = java.util.Map.class
            r1[r3] = r2     // Catch:{ Exception -> 0x00c0 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r4, r1)     // Catch:{ Exception -> 0x00c0 }
            com.startapp.e5 r1 = r7.controller     // Catch:{ Exception -> 0x00c0 }
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x00c0 }
            r2[r3] = r8     // Catch:{ Exception -> 0x00c0 }
            r0.invoke(r1, r2)     // Catch:{ Exception -> 0x00c0 }
        L_0x00bf:
            return r5
        L_0x00c0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.o5.invokeMraidMethod(java.lang.String):boolean");
    }

    public boolean isMraidUrl(String str) {
        return str != null && str.startsWith(MRAID_PREFIX);
    }

    public boolean matchesInjectionUrl(String str) {
        try {
            return MRAID_JS.equals(Uri.parse(str.toLowerCase(Locale.US)).getLastPathSegment());
        } catch (Exception unused) {
            return false;
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (this.isMraidInjected || !matchesInjectionUrl(str)) {
            return super.shouldInterceptRequest(webView, str);
        }
        this.isMraidInjected = true;
        return createMraidInjectionResponse();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (webView == null || str == null || k9.b(webView.getContext(), str)) {
            return true;
        }
        if (isMraidUrl(str)) {
            return invokeMraidMethod(str);
        }
        return this.controller.open(str);
    }
}
