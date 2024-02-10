package com.applovin.impl.adview;

import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.e.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;

class f {
    /* access modifiers changed from: private */
    public final m a;
    private final WebViewRenderProcessClient b = new WebViewRenderProcessClient() {
        public void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        }

        public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
            if (webView instanceof d) {
                e currentAd = ((d) webView).getCurrentAd();
                f.this.a.ac().a(currentAd).a(b.C).a();
                if (u.a()) {
                    u A = f.this.a.A();
                    A.e("AdWebViewRenderProcessClient", "WebView render process unresponsive for ad: " + currentAd);
                }
            }
        }
    };

    f(m mVar) {
        this.a = mVar;
    }

    /* access modifiers changed from: package-private */
    public WebViewRenderProcessClient a() {
        return this.b;
    }
}
