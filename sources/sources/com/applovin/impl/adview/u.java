package com.applovin.impl.adview;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.sdk.m;
import com.google.ads.mediation.applovin.AppLovinMediationAdapter;
import java.lang.ref.WeakReference;

public class u extends WebViewClient {
    private final com.applovin.impl.sdk.u a;
    private WeakReference<a> b;

    public interface a {
        void a(t tVar);

        void b(t tVar);

        void c(t tVar);
    }

    public u(m mVar) {
        this.a = mVar.A();
    }

    private void a(WebView webView, String str) {
        if (com.applovin.impl.sdk.u.a()) {
            com.applovin.impl.sdk.u uVar = this.a;
            uVar.c("WebViewButtonClient", "Processing click on ad URL \"" + str + "\"");
        }
        if (str != null && (webView instanceof t)) {
            t tVar = (t) webView;
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            String path = parse.getPath();
            a aVar = (a) this.b.get();
            if ("applovin".equalsIgnoreCase(scheme) && AppLovinMediationAdapter.APPLOVIN_SDK_ERROR_DOMAIN.equalsIgnoreCase(host) && aVar != null) {
                if ("/track_click".equals(path)) {
                    aVar.a(tVar);
                } else if ("/close_ad".equals(path)) {
                    aVar.b(tVar);
                } else if ("/skip_ad".equals(path)) {
                    aVar.c(tVar);
                } else if (com.applovin.impl.sdk.u.a()) {
                    com.applovin.impl.sdk.u uVar2 = this.a;
                    uVar2.d("WebViewButtonClient", "Unknown URL: " + str);
                    com.applovin.impl.sdk.u uVar3 = this.a;
                    uVar3.d("WebViewButtonClient", "Path: " + path);
                }
            }
        }
    }

    public void a(WeakReference<a> weakReference) {
        this.b = weakReference;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        a(webView, str);
        return true;
    }
}
