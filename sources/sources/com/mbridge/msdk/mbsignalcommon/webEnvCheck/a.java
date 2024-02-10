package com.mbridge.msdk.mbsignalcommon.webEnvCheck;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.tools.aa;

/* compiled from: MBWebViewChecker */
public final class a {
    /* access modifiers changed from: private */
    public static volatile Boolean a;
    private static volatile Handler b;
    private static Boolean c;

    public static boolean a(final Context context) {
        e eVar;
        try {
            eVar = f.a().g(b.d().h());
        } catch (Exception unused) {
            eVar = null;
        }
        if (eVar != null) {
            c = Boolean.valueOf(eVar.p());
        } else {
            c = false;
        }
        Boolean bool = c;
        if (bool == null || !bool.booleanValue()) {
            return true;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (a == null) {
                try {
                    a = Boolean.valueOf(c(context));
                } catch (Exception unused2) {
                    a = false;
                }
            }
            if (a == null) {
                a = new Boolean(false);
            }
            return a.booleanValue();
        }
        if (a == null && b == null) {
            b = new Handler(Looper.getMainLooper());
            b.post(new Runnable() {
                public final void run() {
                    if (a.a == null) {
                        try {
                            Boolean unused = a.a = Boolean.valueOf(a.c(context));
                        } catch (Exception unused2) {
                            Boolean unused3 = a.a = false;
                        }
                    }
                }
            });
        }
        if (a == null) {
            return true;
        }
        return a.booleanValue();
    }

    /* access modifiers changed from: private */
    public static boolean c(Context context) {
        WebView webView;
        try {
            webView = new WebView(context);
        } catch (Exception unused) {
            webView = null;
        }
        if (webView == null) {
            return false;
        }
        try {
            webView.destroy();
            return true;
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return true;
            }
            aa.b("MBWebViewChecker", "destroy webview error", e);
            return true;
        }
    }
}
