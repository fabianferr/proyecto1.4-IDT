package com.applovin.impl.sdk.f;

import android.net.Uri;
import android.webkit.WebView;
import com.applovin.impl.adview.b;
import com.applovin.impl.adview.d;
import com.applovin.impl.adview.e;
import com.applovin.impl.mediation.h;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdkUtils;
import org.json.JSONObject;

public class q extends a implements h.a {
    /* access modifiers changed from: private */
    public final com.applovin.impl.sdk.ad.a a;
    /* access modifiers changed from: private */
    public AppLovinAdLoadListener c;
    /* access modifiers changed from: private */
    public d d;

    private class a extends e {
        private a(m mVar) {
            super((b) null, mVar);
        }

        private boolean a(String str, com.applovin.impl.sdk.d.b<String> bVar) {
            for (String equalsIgnoreCase : q.this.b.b(bVar)) {
                if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public boolean a(WebView webView, String str) {
            if (u.a()) {
                q qVar = q.this;
                qVar.b("Processing click on ad URL \"" + str + "\"");
            }
            if (str == null || !(webView instanceof d)) {
                return true;
            }
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            if (!a(scheme, com.applovin.impl.sdk.d.b.cb)) {
                return true;
            }
            if (a(host, com.applovin.impl.sdk.d.b.cc)) {
                if (u.a()) {
                    q.this.a("Ad load succeeded");
                }
                if (q.this.c == null) {
                    return true;
                }
                q.this.c.adReceived(q.this.a);
            } else if (a(host, com.applovin.impl.sdk.d.b.cd)) {
                if (u.a()) {
                    q.this.a("Ad load failed");
                }
                if (q.this.c == null) {
                    return true;
                }
                q.this.c.failedToReceiveAd(204);
            } else if (!u.a()) {
                return true;
            } else {
                q.this.d("Unrecognized webview event");
                return true;
            }
            AppLovinAdLoadListener unused = q.this.c = null;
            return true;
        }
    }

    public q(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.ad.b bVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
        super("TaskProcessJavaScriptTagAd", mVar);
        this.a = new com.applovin.impl.sdk.ad.a(jSONObject, jSONObject2, bVar, mVar);
        this.c = appLovinAdLoadListener;
        mVar.H().a((h.a) this);
    }

    public void a(com.applovin.impl.mediation.a.a aVar) {
        if (aVar.f().equalsIgnoreCase(this.a.N())) {
            this.b.H().b(this);
            AppLovinAdLoadListener appLovinAdLoadListener = this.c;
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.adReceived(this.a);
                this.c = null;
            }
        }
    }

    public void run() {
        if (u.a()) {
            a("Rendering AppLovin ad #" + this.a.getAdIdNumber());
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    q qVar = q.this;
                    q qVar2 = q.this;
                    d unused = qVar.d = new d(new a(qVar2.b), q.this.b, q.this.f());
                    q.this.d.loadDataWithBaseURL(q.this.a.aw(), q.this.a.b(), "text/html", (String) null, "");
                } catch (Throwable th) {
                    q.this.b.H().b(q.this);
                    if (u.a()) {
                        q.this.a("Failed to initialize WebView", th);
                    }
                    if (q.this.c != null) {
                        q.this.c.failedToReceiveAd(-1);
                        AppLovinAdLoadListener unused2 = q.this.c = null;
                    }
                }
            }
        });
    }
}
