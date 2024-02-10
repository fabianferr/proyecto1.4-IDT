package com.iab.omid.library.vungle.publisher;

import android.os.Handler;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.iab.omid.library.vungle.adsession.AdSessionContext;
import com.iab.omid.library.vungle.adsession.VerificationScriptResource;
import com.iab.omid.library.vungle.internal.g;
import com.iab.omid.library.vungle.utils.c;
import com.iab.omid.library.vungle.utils.f;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class b extends AdSessionStatePublisher {
    /* access modifiers changed from: private */
    public WebView f;
    private Long g = null;
    private final Map<String, VerificationScriptResource> h;
    private final String i;

    class a extends WebViewClient {
        String a = "OMID NativeBridge WebViewClient";

        a() {
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            String str = this.a;
            Log.w(str, "WebView renderer gone: " + renderProcessGoneDetail.toString());
            if (b.this.getWebView() != webView) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            Log.w(this.a, "Deallocating the Native bridge as it is unusable. No further events will be generated for this session.");
            b.this.a((WebView) null);
            webView.destroy();
            return true;
        }
    }

    /* renamed from: com.iab.omid.library.vungle.publisher.b$b  reason: collision with other inner class name */
    class C0092b implements Runnable {
        private final WebView a;

        C0092b() {
            this.a = b.this.f;
        }

        public void run() {
            this.a.destroy();
        }
    }

    public b(Map<String, VerificationScriptResource> map, String str) {
        this.h = map;
        this.i = str;
    }

    public void a(com.iab.omid.library.vungle.adsession.a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> injectedResourcesMap = adSessionContext.getInjectedResourcesMap();
        for (String next : injectedResourcesMap.keySet()) {
            c.a(jSONObject, next, injectedResourcesMap.get(next).toJsonObject());
        }
        a(aVar, adSessionContext, jSONObject);
    }

    public void b() {
        super.b();
        new Handler().postDelayed(new C0092b(), Math.max(4000 - (this.g == null ? 4000 : TimeUnit.MILLISECONDS.convert(f.b() - this.g.longValue(), TimeUnit.NANOSECONDS)), 2000));
        this.f = null;
    }

    public void i() {
        super.i();
        j();
    }

    /* access modifiers changed from: package-private */
    public void j() {
        WebView webView = new WebView(com.iab.omid.library.vungle.internal.f.b().a());
        this.f = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f.getSettings().setAllowContentAccess(false);
        this.f.getSettings().setAllowFileAccess(false);
        this.f.setWebViewClient(new a());
        a(this.f);
        g.a().c(this.f, this.i);
        for (String next : this.h.keySet()) {
            g.a().a(this.f, this.h.get(next).getResourceUrl().toExternalForm(), next);
        }
        this.g = Long.valueOf(f.b());
    }
}
