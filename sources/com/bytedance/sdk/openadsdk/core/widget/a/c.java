package com.bytedance.sdk.openadsdk.core.widget.a;

import android.content.Context;
import android.graphics.Paint;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.l;
import java.lang.ref.WeakReference;

/* compiled from: SSWebSettings */
public class c {
    private final WeakReference<Context> a;
    private boolean b = true;
    private final boolean c = true;
    private final boolean d = true;
    private final boolean e = false;
    private final boolean f = true;
    private boolean g = true;

    public static c a(Context context) {
        return new c(context);
    }

    private c(Context context) {
        this.a = new WeakReference<>(context);
    }

    public c a(boolean z) {
        this.g = z;
        return this;
    }

    public c b(boolean z) {
        this.b = z;
        return this;
    }

    public void a(WebView webView) {
        if (webView != null && this.a.get() != null) {
            b(webView);
            WebSettings settings = webView.getSettings();
            a(settings);
            if (settings != null) {
                try {
                    settings.setJavaScriptEnabled(true);
                } catch (Exception e2) {
                    l.e("SSWebSettings", e2.getMessage());
                }
                try {
                    if (this.b) {
                        settings.setSupportZoom(true);
                        settings.setBuiltInZoomControls(true);
                    } else {
                        settings.setSupportZoom(false);
                    }
                } catch (Throwable th) {
                    l.e("SSWebSettings", th.getMessage());
                }
                settings.setLoadWithOverviewMode(true);
                settings.setUseWideViewPort(true);
                settings.setDomStorageEnabled(true);
                settings.setAllowFileAccess(false);
                settings.setBlockNetworkImage(false);
                settings.setSavePassword(false);
                try {
                    if (this.g) {
                        webView.setLayerType(2, (Paint) null);
                    } else {
                        webView.setLayerType(0, (Paint) null);
                    }
                } catch (Throwable th2) {
                    l.e("SSWebSettings", th2.getMessage());
                }
            }
        }
    }

    public static void b(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            l.d(th.toString());
        }
    }

    private void a(WebSettings webSettings) {
        try {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            l.d(th.toString());
        }
    }
}
