package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.a.c.b;
import com.bytedance.sdk.component.adexpress.b.g;
import com.bytedance.sdk.component.adexpress.b.k;
import com.bytedance.sdk.component.adexpress.b.m;
import com.bytedance.sdk.component.adexpress.b.n;
import com.bytedance.sdk.component.adexpress.d.a;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.b.c.e;
import com.bytedance.sdk.openadsdk.b.j;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.widget.a.d;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.z;
import com.com.bytedance.overseas.sdk.a.c;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: WebViewRender */
public class p extends a {
    com.bytedance.sdk.openadsdk.utils.a f;
    private Context g;
    private String h;
    /* access modifiers changed from: private */
    public q i;
    /* access modifiers changed from: private */
    public JSONObject j;
    private e k;
    private String l;
    private j m;
    private final Map<String, c> n = Collections.synchronizedMap(new HashMap());
    private x o;
    /* access modifiers changed from: private */
    public g p;
    private q.a q;
    /* access modifiers changed from: private */
    public volatile int r = 0;
    private final h s = new h("webviewrender_template") {
        public void run() {
            if (!p.this.e.get()) {
                p pVar = p.this;
                JSONObject unused = pVar.j = pVar.m().c();
                p pVar2 = p.this;
                pVar2.a(pVar2.j);
                if (!(p.this.i == null || p.this.i.I() == null)) {
                    p pVar3 = p.this;
                    b unused2 = pVar3.d = com.bytedance.sdk.component.adexpress.a.b.a.c(pVar3.i.I().e());
                }
                if (p.this.r == 0) {
                    p.this.r();
                }
                l.c().post(p.this.t);
            }
        }
    };
    /* access modifiers changed from: private */
    public final Runnable t = new Runnable() {
        public void run() {
            if (!p.this.e.get() && p.this.p != null) {
                p.this.n();
                p pVar = p.this;
                p.super.a(pVar.p);
            }
        }
    };

    public p(Context context, m mVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, e eVar, q qVar) {
        super(context, mVar, themeStatusBroadcastReceiver);
        if (this.b != null) {
            this.g = context;
            this.h = mVar.d();
            this.i = qVar;
            this.k = eVar;
            themeStatusBroadcastReceiver.a(this);
            r();
        }
    }

    /* access modifiers changed from: private */
    public void r() {
        if (this.b.getWebView() == null || !aa.e()) {
            this.r = 1;
            aa.a((Runnable) new Runnable() {
                public void run() {
                    p.this.s();
                }
            });
            return;
        }
        s();
    }

    /* access modifiers changed from: private */
    public void s() {
        if (this.b != null && this.b.getWebView() != null && this.r != 2) {
            this.l = com.bytedance.sdk.component.adexpress.a.b.a.e();
            this.b.setDisplayZoomControls(false);
            a(z.a(this.l));
            o();
            x xVar = new x(this.g);
            this.o = xVar;
            xVar.e(true);
            p();
            this.r = 2;
        }
    }

    public void n() {
        x xVar;
        if (this.b != null && this.b.getWebView() != null && (xVar = this.o) != null) {
            xVar.b(this.b).a(this.i).d(this.i.Y()).e(this.i.ac()).b(ac.a(this.h)).f(this.i.bb()).a((k) this).a(this.j).a(this.b).a(this.k);
        }
    }

    public void o() {
        q qVar = this.i;
        if (qVar != null && qVar.I() != null) {
            this.q = this.i.I();
        }
    }

    public void p() {
        if (this.b != null && this.b.getWebView() != null) {
            this.b.setBackgroundColor(0);
            this.b.setBackgroundResource(17170445);
            a(this.b);
            if (a() != null) {
                this.m = new j(this.i, a().getWebView()).a(false);
            }
            this.m.a(this.k);
            this.b.setWebViewClient(new h(this.g, this.o, this.i, this.m));
            this.b.setWebChromeClient(new d(this.o, this.m));
            com.bytedance.sdk.component.adexpress.d.e.a().a(this.b, (com.bytedance.sdk.component.adexpress.d.b) this.o);
        }
    }

    /* access modifiers changed from: protected */
    public void k() {
        super.k();
        com.bytedance.sdk.openadsdk.utils.a g2 = com.bytedance.sdk.openadsdk.core.m.a().g();
        this.f = g2;
        g2.a((com.bytedance.sdk.component.adexpress.a) this);
    }

    /* access modifiers changed from: protected */
    public void l() {
        super.l();
        com.bytedance.sdk.openadsdk.utils.a aVar = this.f;
        if (aVar != null) {
            aVar.b((com.bytedance.sdk.component.adexpress.a) this);
        }
    }

    public void a(g gVar) {
        this.p = gVar;
        aa.b(this.s);
    }

    private void a(SSWebView sSWebView) {
        if (sSWebView != null) {
            try {
                com.bytedance.sdk.openadsdk.core.widget.a.c.a(this.g).a(false).a(sSWebView.getWebView());
                sSWebView.setVerticalScrollBarEnabled(false);
                sSWebView.setHorizontalScrollBarEnabled(false);
                sSWebView.a(true);
                sSWebView.j();
                sSWebView.setUserAgentString(com.bytedance.sdk.openadsdk.utils.l.a(sSWebView.getWebView(), (int) BuildConfig.VERSION_CODE));
                if (Build.VERSION.SDK_INT >= 21) {
                    sSWebView.setMixedContentMode(0);
                }
                sSWebView.setJavaScriptEnabled(true);
                sSWebView.setJavaScriptCanOpenWindowsAutomatically(true);
                sSWebView.setDomStorageEnabled(true);
                sSWebView.setDatabaseEnabled(true);
                sSWebView.setAppCacheEnabled(true);
                sSWebView.setAllowFileAccess(false);
                sSWebView.setSupportZoom(true);
                sSWebView.setBuiltInZoomControls(true);
                sSWebView.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
                sSWebView.setUseWideViewPort(true);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.l.e("TTAD.WebViewRender", e.toString());
            }
        }
    }

    public SSWebView a() {
        return this.b;
    }

    public void d() {
        if (!this.e.get()) {
            x xVar = this.o;
            if (xVar != null) {
                xVar.b();
                this.o.m();
                this.o = null;
            }
            j jVar = this.m;
            if (jVar != null) {
                jVar.c(false);
            }
            super.d();
            l.c().removeCallbacks(this.t);
            this.n.clear();
        }
    }

    public void f() {
        if (a() != null) {
            try {
                a().getWebView().resumeTimers();
            } catch (Exception unused) {
            }
        }
    }

    public void j() {
        super.j();
        if (this.o != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("expressShow", true);
                this.o.a("expressShow", jSONObject);
            } catch (Exception unused) {
            }
        }
    }

    public void g() {
        x xVar = this.o;
        if (xVar != null) {
            xVar.a("expressWebviewRecycle", (JSONObject) null);
        }
    }

    public void a(int i2) {
        if (i2 != this.c) {
            this.c = i2;
            b(i2 == 0);
        }
    }

    private void b(boolean z) {
        if (this.o != null && this.b != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adVisible", z);
                this.o.a("expressAdShow", jSONObject);
            } catch (Exception unused) {
            }
        }
    }

    public x q() {
        return this.o;
    }

    public void b(int i2) {
        if (this.o != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", i2);
            } catch (JSONException unused) {
            }
            this.o.a("themeChange", jSONObject);
        }
    }

    public static boolean b(String str) {
        return "banner_call".equals(str) || "banner_ad".equals(str) || "slide_banner_ad".equals(str) || "banner_ad_landingpage".equals(str);
    }

    public void a(n nVar) {
        super.a(nVar);
        if (this.a) {
            com.bytedance.sdk.component.utils.h.b().postDelayed(new Runnable() {
                public void run() {
                    com.bytedance.sdk.component.utils.l.b("TTAD.WebViewRender", "resumeTimers..........");
                    WebView webView = p.this.b.getWebView();
                    if (webView != null) {
                        webView.resumeTimers();
                    }
                }
            }, 2000);
        }
    }
}
