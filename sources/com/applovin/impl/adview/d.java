package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.a.a;
import com.applovin.impl.a.h;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.i;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.g;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class d extends h {
    /* access modifiers changed from: private */
    public static WebView c;
    /* access modifiers changed from: private */
    public final u a;
    private final m b;
    private com.applovin.impl.sdk.e.d d;
    private e e;
    private boolean f;

    public d(e eVar, m mVar, Context context) {
        this(eVar, mVar, context, false);
    }

    d(e eVar, m mVar, Context context, boolean z) {
        super(context);
        if (mVar != null) {
            this.b = mVar;
            this.a = mVar.A();
            setBackgroundColor(0);
            WebSettings settings = getSettings();
            settings.setSupportMultipleWindows(false);
            settings.setJavaScriptEnabled(true);
            setWebViewClient(eVar);
            setWebChromeClient(new c(eVar != null ? eVar.a() : null, mVar));
            setVerticalScrollBarEnabled(false);
            setHorizontalScrollBarEnabled(false);
            setScrollBarStyle(33554432);
            if (g.i() && ((Boolean) mVar.a(b.eN)).booleanValue()) {
                setWebViewRenderProcessClient(new f(mVar).a());
            }
            setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (view.hasFocus()) {
                        return false;
                    }
                    view.requestFocus();
                    return false;
                }
            });
            setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    if (!u.a()) {
                        return true;
                    }
                    d.this.a.b("AdWebView", "Received a LongClick event.");
                    return true;
                }
            });
            return;
        }
        throw new IllegalArgumentException("No sdk specified.");
    }

    private String a(String str, String str2) {
        if (StringUtils.isValidString(str)) {
            return str.replace("{SOURCE}", str2);
        }
        return null;
    }

    public static void a(final i iVar, final m mVar, final AppLovinPostbackListener appLovinPostbackListener) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                String a2 = i.this.a();
                d.c();
                if (d.c == null) {
                    appLovinPostbackListener.onPostbackFailure(a2, -1);
                    return;
                }
                if (i.this.c() != null) {
                    a2 = StringUtils.appendQueryParameters(a2, i.this.c(), ((Boolean) mVar.a(b.dg)).booleanValue());
                }
                String str = "al_firePostback('" + a2 + "');";
                if (g.c()) {
                    d.c.evaluateJavascript(str, (ValueCallback) null);
                } else {
                    d.c.loadUrl("javascript:" + str);
                }
                appLovinPostbackListener.onPostbackSuccess(a2);
            }
        });
    }

    private void a(String str, String str2, String str3, m mVar, a aVar) {
        String str4;
        u uVar;
        StringBuilder sb;
        String a2 = a(str3, str);
        if (StringUtils.isValidString(a2)) {
            if (aVar.c() && aVar.isOpenMeasurementEnabled() && !aVar.q()) {
                a2 = mVar.al().a(a2);
            }
            str4 = a2;
            if (u.a()) {
                uVar = this.a;
                sb = new StringBuilder("Rendering webview for VAST ad with resourceContents : ");
            }
            loadDataWithBaseURL(str2, str4, "text/html", (String) null, "");
        }
        String a3 = a((String) mVar.a(b.ej), str);
        if (StringUtils.isValidString(a3)) {
            if (aVar.c() && aVar.isOpenMeasurementEnabled()) {
                a3 = mVar.al().a(a3);
            }
            str4 = a3;
            if (u.a()) {
                uVar = this.a;
                sb = new StringBuilder("Rendering webview for VAST ad with resourceContents : ");
            }
            loadDataWithBaseURL(str2, str4, "text/html", (String) null, "");
        }
        if (u.a()) {
            u uVar2 = this.a;
            uVar2.b("AdWebView", "Rendering webview for VAST ad with resourceURL : " + str);
        }
        loadUrl(str);
        return;
        sb.append(str4);
        uVar.b("AdWebView", sb.toString());
        loadDataWithBaseURL(str2, str4, "text/html", (String) null, "");
    }

    private void b(e eVar) {
        Boolean n;
        Integer a2;
        loadUrl("about:blank");
        int az = this.e.az();
        if (az >= 0) {
            setLayerType(az, (Paint) null);
        }
        if (g.b()) {
            getSettings().setMediaPlaybackRequiresUserGesture(eVar.av());
        }
        if (g.c() && eVar.ax()) {
            setWebContentsDebuggingEnabled(true);
        }
        v ay = eVar.ay();
        if (ay != null) {
            WebSettings settings = getSettings();
            WebSettings.PluginState b2 = ay.b();
            if (b2 != null) {
                settings.setPluginState(b2);
            }
            Boolean c2 = ay.c();
            if (c2 != null) {
                settings.setAllowFileAccess(c2.booleanValue());
            }
            Boolean d2 = ay.d();
            if (d2 != null) {
                settings.setLoadWithOverviewMode(d2.booleanValue());
            }
            Boolean e2 = ay.e();
            if (e2 != null) {
                settings.setUseWideViewPort(e2.booleanValue());
            }
            Boolean f2 = ay.f();
            if (f2 != null) {
                settings.setAllowContentAccess(f2.booleanValue());
            }
            Boolean g = ay.g();
            if (g != null) {
                settings.setBuiltInZoomControls(g.booleanValue());
            }
            Boolean h = ay.h();
            if (h != null) {
                settings.setDisplayZoomControls(h.booleanValue());
            }
            Boolean i = ay.i();
            if (i != null) {
                settings.setSaveFormData(i.booleanValue());
            }
            Boolean j = ay.j();
            if (j != null) {
                settings.setGeolocationEnabled(j.booleanValue());
            }
            Boolean k = ay.k();
            if (k != null) {
                settings.setNeedInitialFocus(k.booleanValue());
            }
            Boolean l = ay.l();
            if (l != null) {
                settings.setAllowFileAccessFromFileURLs(l.booleanValue());
            }
            Boolean m = ay.m();
            if (m != null) {
                settings.setAllowUniversalAccessFromFileURLs(m.booleanValue());
            }
            if (g.d() && (a2 = ay.a()) != null) {
                settings.setMixedContentMode(a2.intValue());
            }
            if (g.e() && (n = ay.n()) != null) {
                settings.setOffscreenPreRaster(n.booleanValue());
            }
        }
    }

    /* access modifiers changed from: private */
    public static void c() {
        if (c == null) {
            WebView tryToCreateWebView = Utils.tryToCreateWebView(m.M(), "postbacks");
            c = tryToCreateWebView;
            if (tryToCreateWebView != null) {
                tryToCreateWebView.getSettings().setJavaScriptEnabled(true);
                c.loadData("<html><head>\n<script type=\"text/javascript\">\n    window.al_firePostback = function(postback) {\n    setTimeout(function() {\n        var img = new Image();\n        img.src = postback;\n    }, 100);\n};\n</script></head>\n<body></body></html>", "text/html", "UTF-8");
                c.setWebViewClient(new WebViewClient() {
                    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                        if (webView != d.c) {
                            return true;
                        }
                        d.c.destroy();
                        WebView unused = d.c = null;
                        AppLovinSdkUtils.runOnUiThread(new Runnable() {
                            public void run() {
                                d.c();
                            }
                        });
                        return true;
                    }
                });
            }
        }
    }

    public void a(e eVar) {
        u uVar;
        String str;
        u uVar2;
        String str2;
        String aw;
        String str3;
        String str4;
        String str5;
        String aw2;
        m mVar;
        if (!this.f) {
            this.e = eVar;
            try {
                b(eVar);
                if (Utils.isBML(eVar.getSize())) {
                    setVisibility(0);
                }
                if (eVar instanceof com.applovin.impl.sdk.ad.a) {
                    com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) eVar;
                    String b2 = aVar.b();
                    if (!aVar.q() && aVar.isOpenMeasurementEnabled()) {
                        b2 = this.b.al().a(b2);
                    }
                    loadDataWithBaseURL(eVar.aw(), b2, "text/html", (String) null, "");
                    if (u.a()) {
                        uVar = this.a;
                        str = "AppLovinAd rendered";
                    } else {
                        return;
                    }
                } else if (eVar instanceof a) {
                    a aVar2 = (a) eVar;
                    com.applovin.impl.a.d aO = aVar2.aO();
                    if (aO != null) {
                        h b3 = aO.b();
                        Uri b4 = b3.b();
                        String uri = b4 != null ? b4.toString() : "";
                        String c2 = b3.c();
                        String aQ = aVar2.aQ();
                        if (!StringUtils.isValidString(uri)) {
                            if (!StringUtils.isValidString(c2)) {
                                if (u.a()) {
                                    uVar2 = this.a;
                                    str2 = "Unable to load companion ad. No resources provided.";
                                    uVar2.e("AdWebView", str2);
                                    return;
                                }
                                return;
                            }
                        }
                        if (b3.a() == h.a.STATIC) {
                            if (u.a()) {
                                this.a.b("AdWebView", "Rendering WebView for static VAST ad");
                            }
                            String a2 = a((String) this.b.a(b.ei), uri);
                            if (aVar2.c() && aVar2.isOpenMeasurementEnabled() && aVar2.e()) {
                                a2 = this.b.al().a(a2);
                            }
                            loadDataWithBaseURL(eVar.aw(), a2, "text/html", (String) null, "");
                            return;
                        }
                        if (b3.a() == h.a.HTML) {
                            if (StringUtils.isValidString(c2)) {
                                String a3 = a(aQ, c2);
                                if (StringUtils.isValidString(a3)) {
                                    c2 = a3;
                                }
                                if (aVar2.c() && aVar2.isOpenMeasurementEnabled() && !aVar2.q()) {
                                    c2 = this.b.al().a(c2);
                                }
                                if (u.a()) {
                                    u uVar3 = this.a;
                                    uVar3.b("AdWebView", "Rendering WebView for HTML VAST ad with resourceContents: " + c2);
                                }
                                aw = eVar.aw();
                                str3 = "text/html";
                                str4 = null;
                                str5 = "";
                            } else if (StringUtils.isValidString(uri)) {
                                if (u.a()) {
                                    this.a.b("AdWebView", "Preparing to load HTML VAST ad resourceUri");
                                }
                                aw2 = eVar.aw();
                                mVar = this.b;
                                a(uri, aw2, aQ, mVar, aVar2);
                                return;
                            } else {
                                return;
                            }
                        } else if (b3.a() == h.a.IFRAME) {
                            if (StringUtils.isValidString(uri)) {
                                if (u.a()) {
                                    this.a.b("AdWebView", "Preparing to load iFrame VAST ad resourceUri");
                                }
                                aw2 = eVar.aw();
                                mVar = this.b;
                                a(uri, aw2, aQ, mVar, aVar2);
                                return;
                            } else if (StringUtils.isValidString(c2)) {
                                String a4 = a(aQ, c2);
                                if (StringUtils.isValidString(a4)) {
                                    c2 = a4;
                                }
                                if (aVar2.c() && aVar2.isOpenMeasurementEnabled() && !aVar2.q()) {
                                    c2 = this.b.al().a(c2);
                                }
                                if (u.a()) {
                                    u uVar4 = this.a;
                                    uVar4.b("AdWebView", "Rendering WebView for iFrame VAST ad with resourceContents: " + c2);
                                }
                                aw = eVar.aw();
                                str3 = "text/html";
                                str4 = null;
                                str5 = "";
                            } else {
                                return;
                            }
                        } else if (u.a()) {
                            uVar2 = this.a;
                            str2 = "Failed to render VAST companion ad of invalid type";
                            uVar2.e("AdWebView", str2);
                            return;
                        } else {
                            return;
                        }
                        loadDataWithBaseURL(aw, c2, str3, str4, str5);
                        return;
                    } else if (u.a()) {
                        uVar = this.a;
                        str = "No companion ad provided.";
                    } else {
                        return;
                    }
                } else {
                    return;
                }
                uVar.b("AdWebView", str);
            } catch (Throwable th) {
                String valueOf = eVar != null ? String.valueOf(eVar.getAdIdNumber()) : AbstractJsonLexerKt.NULL;
                throw new RuntimeException("Unable to render AppLovin ad (" + valueOf + ") - " + th);
            }
        } else if (u.a()) {
            u.i("AdWebView", "Ad can not be loaded in a destroyed webview");
        }
    }

    public void a(String str) {
        a(str, (Runnable) null);
    }

    public void a(String str, Runnable runnable) {
        try {
            if (u.a()) {
                u uVar = this.a;
                uVar.b("AdWebView", "Forwarding \"" + str + "\" to ad template");
            }
            loadUrl(str);
        } catch (Throwable th) {
            if (u.a()) {
                this.a.b("AdWebView", "Unable to forward to template", th);
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public void computeScroll() {
    }

    public void destroy() {
        this.f = true;
        super.destroy();
    }

    /* access modifiers changed from: package-private */
    public e getCurrentAd() {
        return this.e;
    }

    public com.applovin.impl.sdk.e.d getStatsManagerHelper() {
        return this.d;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
    }

    public void scrollTo(int i, int i2) {
    }

    public void setStatsManagerHelper(com.applovin.impl.sdk.e.d dVar) {
        this.d = dVar;
    }
}
