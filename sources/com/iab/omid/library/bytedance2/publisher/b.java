package com.iab.omid.library.bytedance2.publisher;

import android.os.Handler;
import android.webkit.WebView;
import com.iab.omid.library.bytedance2.adsession.AdSessionContext;
import com.iab.omid.library.bytedance2.adsession.VerificationScriptResource;
import com.iab.omid.library.bytedance2.internal.g;
import com.iab.omid.library.bytedance2.utils.c;
import com.iab.omid.library.bytedance2.utils.f;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class b extends AdSessionStatePublisher {
    /* access modifiers changed from: private */
    public WebView f;
    private Long g = null;
    private final Map<String, VerificationScriptResource> h;
    private final String i;

    class a implements Runnable {
        private final WebView a;

        a() {
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

    public void a(com.iab.omid.library.bytedance2.adsession.a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> injectedResourcesMap = adSessionContext.getInjectedResourcesMap();
        for (String next : injectedResourcesMap.keySet()) {
            c.a(jSONObject, next, injectedResourcesMap.get(next).toJsonObject());
        }
        a(aVar, adSessionContext, jSONObject);
    }

    public void b() {
        super.b();
        new Handler().postDelayed(new a(), Math.max(4000 - (this.g == null ? 4000 : TimeUnit.MILLISECONDS.convert(f.b() - this.g.longValue(), TimeUnit.NANOSECONDS)), 2000));
        this.f = null;
    }

    public void i() {
        super.i();
        j();
    }

    /* access modifiers changed from: package-private */
    public void j() {
        WebView webView = new WebView(com.iab.omid.library.bytedance2.internal.f.b().a());
        this.f = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f.getSettings().setAllowContentAccess(false);
        this.f.getSettings().setAllowFileAccess(false);
        a(this.f);
        g.a().c(this.f, this.i);
        for (String next : this.h.keySet()) {
            g.a().a(this.f, this.h.get(next).getResourceUrl().toExternalForm(), next);
        }
        this.g = Long.valueOf(f.b());
    }
}
