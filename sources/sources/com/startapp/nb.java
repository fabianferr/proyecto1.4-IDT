package com.startapp;

import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import com.iab.omid.library.startio.publisher.AdSessionStatePublisher;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: Sta */
public class nb extends AdSessionStatePublisher {
    public WebView f;
    public Long g = null;
    public final Map<String, w9> h;
    public final String i;

    /* compiled from: Sta */
    public class a implements Runnable {
        public final WebView a;

        public a(nb nbVar) {
            this.a = nbVar.f;
        }

        public void run() {
            this.a.destroy();
        }
    }

    public nb(Map<String, w9> map, String str) {
        this.h = map;
        this.i = str;
    }

    public void a(fb fbVar, q qVar) {
        JSONObject jSONObject = new JSONObject();
        Map<String, w9> unmodifiableMap = Collections.unmodifiableMap(qVar.d);
        for (String next : unmodifiableMap.keySet()) {
            rb.a(jSONObject, next, unmodifiableMap.get(next));
        }
        a(fbVar, qVar, jSONObject);
    }

    public void b() {
        long j;
        this.a.clear();
        if (this.g == null) {
            j = 4000;
        } else {
            j = TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.g.longValue(), TimeUnit.NANOSECONDS);
        }
        new Handler().postDelayed(new a(this), Math.max(4000 - j, 2000));
        this.f = null;
    }

    public void d() {
        WebView webView = new WebView(ac.b.a);
        this.f = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.a = new tb(this.f);
        WebView webView2 = this.f;
        String str = this.i;
        if (webView2 != null && !TextUtils.isEmpty(str)) {
            webView2.loadUrl("javascript: " + str);
        }
        for (String next : this.h.keySet()) {
            String externalForm = this.h.get(next).b.toExternalForm();
            WebView webView3 = this.f;
            if (externalForm != null && !TextUtils.isEmpty(next)) {
                String replace = "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};this.omidVerificationProperties.injectionId = '%INJECTION_ID%';var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", externalForm).replace("%INJECTION_ID%", next);
                if (webView3 != null && !TextUtils.isEmpty(replace)) {
                    webView3.loadUrl("javascript: " + replace);
                }
            }
        }
        this.g = Long.valueOf(System.nanoTime());
    }
}
