package com.appnext.core.result;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.SettingsManager;
import com.appnext.core.f;
import com.appnext.core.g;
import com.appnext.core.h;
import com.appnext.core.k;
import com.appnext.core.n;
import com.appnext.core.p;
import com.appnext.core.webview.AppnextWebView;
import java.net.URL;
import org.json.JSONObject;

public class ResultPageActivity extends Activity {
    /* access modifiers changed from: private */
    public boolean aA;
    /* access modifiers changed from: private */
    public String ay;
    /* access modifiers changed from: private */
    public String bW;
    /* access modifiers changed from: private */
    public c eA;
    /* access modifiers changed from: private */
    public AppnextAd ex;
    /* access modifiers changed from: private */
    public String ey;
    private a ez;
    /* access modifiers changed from: private */
    public AppnextAd j;
    /* access modifiers changed from: private */
    public String placementID;
    /* access modifiers changed from: private */
    public p userAction;
    private WebView webView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        final String str;
        Object obj;
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            c az = d.ay().az();
            this.eA = az;
            this.placementID = az.getPlacementId();
            this.ey = this.eA.v();
            this.aA = getIntent().getExtras().getBoolean("shouldClose");
            this.ex = this.eA.getSelectedAd();
            this.bW = this.eA.w();
            this.ay = this.eA.x();
            this.userAction = new p(this, new p.a() {
                public final void report(String str) {
                }

                public final Ad c() {
                    return ResultPageActivity.this.eA.z();
                }

                public final AppnextAd d() {
                    return ResultPageActivity.this.j;
                }

                public final SettingsManager e() {
                    return ResultPageActivity.this.eA.y();
                }
            });
            this.ez = this.eA.A();
            try {
                RelativeLayout relativeLayout = new RelativeLayout(this);
                setContentView(relativeLayout);
                relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                WebView webView2 = new WebView(getApplicationContext());
                this.webView = webView2;
                relativeLayout.addView(webView2);
                this.webView.getLayoutParams().height = -1;
                this.webView.getLayoutParams().width = -1;
                this.webView.getSettings().setJavaScriptEnabled(true);
                this.webView.getSettings().setAppCacheEnabled(true);
                this.webView.getSettings().setDomStorageEnabled(true);
                this.webView.getSettings().setDatabaseEnabled(true);
                if (Build.VERSION.SDK_INT >= 21) {
                    this.webView.getSettings().setMixedContentMode(0);
                }
                this.webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
                this.webView.setWebChromeClient(new WebChromeClient() {
                    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                        consoleMessage.messageLevel().name();
                        consoleMessage.lineNumber();
                        consoleMessage.message();
                        consoleMessage.sourceId();
                        consoleMessage.lineNumber();
                        return true;
                    }
                });
                this.webView.setWebViewClient(getWebViewClient());
                a aVar = this.ez;
                if (aVar != null) {
                    aVar.getJSurl();
                    str = this.ez.getJSurl();
                } else {
                    str = "https://cdn.appnext.com/tools/sdk/banner/2.4.3/result.min.js";
                }
                AppnextWebView.q(this).a(str, (AppnextWebView.c) new AppnextWebView.c() {
                    public final void f(String str) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public final void run() {
                                try {
                                    ResultPageActivity.this.o(str, AppnextWebView.q(ResultPageActivity.this).D(str));
                                } catch (Throwable th) {
                                    com.appnext.base.a.a("ResultPageActivity$loaded", th);
                                }
                            }
                        });
                    }

                    public final void error(String str) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public final void run() {
                                ResultPageActivity.this.o(str, ResultPageActivity.this.getFallbackScript());
                            }
                        });
                    }
                });
                WebView webView3 = this.webView;
                a aVar2 = this.ez;
                if (aVar2 == null || aVar2.B() == null) {
                    obj = new b();
                } else {
                    obj = this.ez.B();
                }
                webView3.addJavascriptInterface(obj, "Appnext");
            } catch (Throwable unused) {
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("ResultPageActivity$onCreate", th);
            finish();
        }
    }

    /* access modifiers changed from: private */
    public String getFallbackScript() {
        a aVar = this.ez;
        if (aVar == null || aVar.getFallbackScript() == null) {
            return new b().D();
        }
        return this.ez.getFallbackScript();
    }

    public class b {
        public b() {
        }

        @JavascriptInterface
        public final void adClicked(String str, int i) {
            try {
                ResultPageActivity resultPageActivity = ResultPageActivity.this;
                resultPageActivity.j = (AppnextAd) resultPageActivity.parseAd(str);
                if (ResultPageActivity.this.userAction != null) {
                    p r4 = ResultPageActivity.this.userAction;
                    AppnextAd r5 = ResultPageActivity.this.j;
                    StringBuilder sb = new StringBuilder();
                    ResultPageActivity resultPageActivity2 = ResultPageActivity.this;
                    sb.append(resultPageActivity2.f(resultPageActivity2.j).getAppURL());
                    sb.append("&tem_id=");
                    sb.append(ResultPageActivity.this.ey);
                    sb.append("1");
                    r4.a(r5, sb.toString(), ResultPageActivity.this.placementID, new f.a() {
                        public final void error(String str) {
                        }

                        public final void onMarket(String str) {
                            if (ResultPageActivity.this.aA) {
                                ResultPageActivity.this.finish();
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                com.appnext.base.a.a("WebInterface$adClicked", th);
            }
        }

        @JavascriptInterface
        public final void impression(String str) {
            try {
                ResultPageActivity.this.userAction.d((AppnextAd) ResultPageActivity.this.parseAd(str));
            } catch (Throwable th) {
                com.appnext.base.a.a("WebInterface$impression", th);
            }
        }

        @JavascriptInterface
        public final void postView(String str) {
            try {
                AppnextAd appnextAd = (AppnextAd) ResultPageActivity.this.parseAd(str);
                p r0 = ResultPageActivity.this.userAction;
                r0.a(appnextAd, ResultPageActivity.this.f(appnextAd).getImpressionURL() + "&tem_id=" + ResultPageActivity.this.ey + "1", (f.a) null);
            } catch (Throwable th) {
                com.appnext.base.a.a("WebInterface$postView", th);
            }
        }

        @JavascriptInterface
        public final void openLink(String str) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.addFlags(268435456);
                ResultPageActivity.this.startActivity(intent);
            } catch (Throwable th) {
                com.appnext.base.a.a("WebInterface$openLink", th);
            }
        }
    }

    private WebViewClient getWebViewClient() {
        try {
            a aVar = this.ez;
            if (aVar == null || aVar.getWebViewClient() == null) {
                return new a();
            }
            return this.ez.getWebViewClient();
        } catch (Throwable unused) {
            return new a();
        }
    }

    public class a extends WebViewClient {
        public a() {
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str == null) {
                return false;
            }
            if (!str.startsWith("http")) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            webView.loadUrl(str);
            return true;
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            try {
                n.aa().a(new Runnable() {
                    public final void run() {
                        final String b = g.b((Context) ResultPageActivity.this, false);
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public final void run() {
                                try {
                                    ResultPageActivity resultPageActivity = ResultPageActivity.this;
                                    resultPageActivity.loadJS("Appnext.setParams(" + d.ay().az().getConfigParams().put("did", b).toString() + ");");
                                } catch (Throwable unused) {
                                }
                                ResultPageActivity resultPageActivity2 = ResultPageActivity.this;
                                resultPageActivity2.loadJS("Appnext.load(" + ResultPageActivity.this.f(ResultPageActivity.this.ex).getAdJSON() + "," + ResultPageActivity.this.ay + "," + ResultPageActivity.this.bW + ");");
                            }
                        });
                    }
                });
            } catch (Throwable th) {
                com.appnext.base.a.a("WebInterface$onPageFinished", th);
            }
        }
    }

    public h parseAd(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            AppnextAd appnextAd = (AppnextAd) k.a((Class<?>) AppnextAd.class, jSONObject);
            if (appnextAd != null) {
                f(appnextAd).setAdJSON(jSONObject.toString());
                if (TextUtils.isEmpty(appnextAd.getStoreRating())) {
                    f(appnextAd).setStoreRating("0");
                }
            }
            return appnextAd;
        } catch (Throwable th) {
            com.appnext.base.a.a("ResultPageActivity$parseAd", th);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final void loadJS(String str) {
        try {
            WebView webView2 = this.webView;
            if (webView2 != null) {
                webView2.loadUrl("javascript:(function() { try { " + str + " } catch(err){ Appnext.jsError(err.message); }})()");
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("ResultPageActivity$loadJS", th);
        }
    }

    /* access modifiers changed from: protected */
    public final void o(String str, String str2) {
        try {
            URL url = new URL(str);
            this.webView.loadDataWithBaseURL(url.getProtocol() + "://" + url.getHost(), "<html><body><script>" + str2 + "</script></body></html>", (String) null, "UTF-8", (String) null);
        } catch (Throwable th) {
            com.appnext.base.a.a("ResultPageActivity$loadWebview", th);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        try {
            WebView webView2 = this.webView;
            if (webView2 != null) {
                webView2.destroy();
                this.webView = null;
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("ResultPageActivity$onDestroy", th);
        }
        try {
            this.userAction.destroy();
        } catch (Throwable th2) {
            com.appnext.base.a.a("ResultPageActivity$onDestroy", th2);
        }
    }

    /* access modifiers changed from: private */
    public CustomAd f(AppnextAd appnextAd) {
        return new CustomAd(appnextAd);
    }

    private class CustomAd extends AppnextAd {
        CustomAd(AppnextAd appnextAd) {
            super(appnextAd);
        }

        /* access modifiers changed from: protected */
        public void setAdJSON(String str) {
            super.setAdJSON(str);
        }

        /* access modifiers changed from: protected */
        public String getAdJSON() {
            return super.getAdJSON();
        }

        public String getAppURL() {
            return super.getAppURL();
        }

        /* access modifiers changed from: protected */
        public void setStoreRating(String str) {
            super.setStoreRating(str);
        }

        /* access modifiers changed from: protected */
        public String getImpressionURL() {
            return super.getImpressionURL();
        }
    }
}
