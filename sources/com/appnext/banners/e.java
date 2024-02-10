package com.appnext.banners;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.SettingsManager;
import com.appnext.core.f;
import com.appnext.core.g;
import com.appnext.core.i;
import com.appnext.core.n;
import com.appnext.core.webview.AppnextWebView;
import com.bykv.vk.openvk.preload.falconx.statistic.StatisticData;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class e extends a {
    /* access modifiers changed from: private */
    public String adsid = "";
    /* access modifiers changed from: private */
    public boolean clicked = false;
    /* access modifiers changed from: private */
    public Handler handler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public Handler refreshHandler = new Handler(Looper.getMainLooper());
    private BannerAdData selectedAd = null;
    /* access modifiers changed from: private */
    public ArrayList<String> shown = new ArrayList<>();
    protected WebView webView;

    /* access modifiers changed from: protected */
    public String getJSurl() {
        return "https://cdn.appnext.com/tools/sdk/banner/2.4.3/banner.min.js";
    }

    /* access modifiers changed from: protected */
    public String getTargetJSurl() {
        return "https://cdn.appnext.com/tools/sdk/banner/2.4.3/result.min.js";
    }

    /* access modifiers changed from: protected */
    public void inflateView(int i, AppnextAd appnextAd) {
        try {
            if (this.webView != null) {
                this.rootView.removeAllViews();
                this.webView.destroyDrawingCache();
                this.webView.destroy();
            }
            View inflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(getLayout(), this.rootView, false);
            WebView webView2 = new WebView(this.context.getApplicationContext());
            this.webView = webView2;
            ((ViewGroup) inflate).addView(webView2);
            this.webView.getLayoutParams().height = -1;
            this.webView.getLayoutParams().width = -1;
            this.webView.getSettings().setJavaScriptEnabled(true);
            this.webView.getSettings().setAppCacheEnabled(true);
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
            loadWebview(getJSurl());
            AppnextWebView.q(this.context).a(getTargetJSurl(), (AppnextWebView.c) null);
            this.webView.addJavascriptInterface(getWebInterface(), "Appnext");
            this.rootView.addView(inflate);
        } catch (Throwable th) {
            com.appnext.base.a.a("JSBannerAdapter$inflateView", th);
        }
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        try {
            if (getBannerSize().toString().equals(BannerSize.BANNER.toString())) {
                return R.layout.apnxt_banner;
            }
            if (getBannerSize().toString().equals(BannerSize.LARGE_BANNER.toString())) {
                return R.layout.apnxt_large_banner;
            }
            if (getBannerSize().toString().equals(BannerSize.MEDIUM_RECTANGLE.toString())) {
                return R.layout.apnxt_medium_rectangle;
            }
            return R.layout.apnxt_banner;
        } catch (Throwable th) {
            com.appnext.base.a.a("JSBannerAdapter$getLayout", th);
        }
    }

    /* access modifiers changed from: protected */
    public void loadJS(String str) {
        try {
            WebView webView2 = this.webView;
            if (webView2 != null) {
                webView2.loadUrl(str);
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("JSBannerAdapter$loadJS", th);
        }
    }

    /* access modifiers changed from: protected */
    public void loadWebview(String str) {
        try {
            URL url = new URL(str);
            this.webView.setBackgroundColor(0);
            this.webView.loadDataWithBaseURL(url.getProtocol() + "://" + url.getHost(), "<html ValidateRequest=\"false\" ><body><script src='https://cdn.appnext.com/tools/sdk/banner/2.4.0/banner.min.js'></script></body></html>", (String) null, "UTF-8", (String) null);
        } catch (Throwable th) {
            com.appnext.base.a.a("JSBannerAdapter$loadWebview", th);
        }
    }

    public void destroy() {
        super.destroy();
        try {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    try {
                        if (e.this.webView != null) {
                            ViewGroup viewGroup = (ViewGroup) e.this.webView.getParent();
                            if (viewGroup != null) {
                                viewGroup.removeView(e.this.webView);
                            }
                            e.this.webView.destroyDrawingCache();
                            e.this.webView.destroy();
                        }
                    } catch (Throwable th) {
                        com.appnext.base.a.a("JSBannerAdapter$destroy", th);
                    }
                }
            });
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages((Object) null);
            }
            Handler handler3 = this.refreshHandler;
            if (handler3 != null) {
                handler3.removeCallbacksAndMessages((Object) null);
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("JSBannerAdapter$destroy", th);
        }
    }

    /* access modifiers changed from: private */
    public boolean isDestroyed() {
        return getBannerAd() == null;
    }

    /* access modifiers changed from: protected */
    public JSONObject getConfigParams() throws JSONException {
        String str;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("vid", "2.7.0.473");
        jSONObject.put(ScarConstants.TOKEN_ID_KEY, getBannerAd() == null ? "" : getBannerAd().getTID());
        if (getBannerAd() == null) {
            str = "";
        } else {
            str = getBannerAd().getAUID();
        }
        jSONObject.put(JsonStorageKeyNames.AUID_ID_KEY, str);
        jSONObject.put("osid", StatisticData.ERROR_CODE_NOT_FOUND);
        jSONObject.put("tem_id", getBannerAd().getTemId(getSelectedAd()));
        jSONObject.put("id", getPlacementId());
        jSONObject.put("b_title", getButtonText(getSelectedAd()));
        jSONObject.put("creative", getCreativeType(getSelectedAd()) == 0 ? "video" : "static");
        jSONObject.put("cat", getSelectedAd().getCategories());
        jSONObject.put("lockcat", getSelectedAd().getSpecificCategories());
        jSONObject.put("pview", d.K().t("pview"));
        jSONObject.put(CampaignEx.JSON_KEY_VIDEO_LENGTHL, getAdRequest().getVideoLength());
        StringBuilder sb = new StringBuilder();
        sb.append(getAdRequest().isMute());
        jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_MUTE, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getAdRequest().isAutoPlay());
        jSONObject.put("auto_play", sb2.toString());
        jSONObject.put("remove_poster_on_auto_play", d.K().t("remove_poster_on_auto_play"));
        jSONObject.put("remote_auto_play", true);
        jSONObject.put("did", this.adsid);
        jSONObject.put("devn", g.V());
        jSONObject.put("dosv", Build.VERSION.SDK_INT);
        jSONObject.put("dds", "0");
        jSONObject.put("ads_type", "banner");
        jSONObject.put("country", getSelectedAd().getCountry());
        jSONObject.put("gdpr", i.a((AppnextAd) getSelectedAd(), (SettingsManager) d.K()));
        jSONObject.put("lang_settings", new JSONObject(com.appnext.core.a.a.n(this.context).ag()).toString());
        String language = getLanguage();
        if (language == null || language.equals("")) {
            language = Locale.getDefault().getLanguage().toUpperCase();
        }
        jSONObject.put("lang", language);
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    public String getFallbackScript() {
        return new c().D();
    }

    /* access modifiers changed from: protected */
    public BannerAdData getSelectedAd() {
        try {
            if (this.selectedAd == null || (super.getSelectedAd() != null && !super.getSelectedAd().getBannerID().equals(this.selectedAd.getBannerID()))) {
                BannerAdData bannerAdData = new BannerAdData(super.getSelectedAd());
                this.selectedAd = bannerAdData;
                bannerAdData.setImpressionURL(this.selectedAd.getImpressionURL() + "&tem_id=" + getBannerAd().getTemId(this.selectedAd));
                BannerAdData bannerAdData2 = this.selectedAd;
                bannerAdData2.setAppURL(this.selectedAd.getAppURL() + "&tem_id=" + getBannerAd().getTemId(this.selectedAd));
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("JSBannerAdapter$getSelectedAd", th);
        }
        return this.selectedAd;
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        if (i == 0) {
            try {
                if (this.clicked) {
                    this.clicked = false;
                    openResultPage(false);
                }
            } catch (Throwable th) {
                com.appnext.base.a.a("JSBannerAdapter$onWindowVisibilityChanged", th);
            }
        }
    }

    /* access modifiers changed from: protected */
    public WebViewClient getWebViewClient() {
        return new b();
    }

    /* access modifiers changed from: protected */
    public a getWebInterface() {
        return new a();
    }

    public class a {
        @JavascriptInterface
        public void destroy(String str) {
        }

        @JavascriptInterface
        public void jsError(String str) {
        }

        public a() {
        }

        @JavascriptInterface
        public void openStore(String str) {
            if (e.this.handler != null) {
                e.this.handler.removeCallbacksAndMessages((Object) null);
                if (!e.this.isDestroyed()) {
                    e.this.handler.post(new Runnable() {
                        public final void run() {
                            try {
                                if (!e.this.getSelectedAd().getWebview().equals("0")) {
                                    e.this.click();
                                    return;
                                }
                                char c = 65535;
                                if (e.this.getSelectedAd().getRevenueType().equals("cpi")) {
                                    d K = d.K();
                                    String lowerCase = K.t(e.this.getBannerSize().toString() + "_cpiActiveFlow").toLowerCase();
                                    e.this.getBannerSize().toString();
                                    switch (lowerCase.hashCode()) {
                                        case 97:
                                            if (lowerCase.equals("a")) {
                                                c = 0;
                                                break;
                                            }
                                            break;
                                        case 98:
                                            if (lowerCase.equals("b")) {
                                                c = 1;
                                                break;
                                            }
                                            break;
                                        case 99:
                                            if (lowerCase.equals("c")) {
                                                c = 2;
                                                break;
                                            }
                                            break;
                                        case 100:
                                            if (lowerCase.equals("d")) {
                                                c = 3;
                                                break;
                                            }
                                            break;
                                    }
                                    if (c != 0) {
                                        if (c == 1) {
                                            e.this.clicked = true;
                                        } else if (c == 2) {
                                            e.this.openResultPage(false);
                                            return;
                                        }
                                        e.this.click();
                                        return;
                                    }
                                    e.this.openResultPage(true);
                                    return;
                                }
                                d K2 = d.K();
                                String lowerCase2 = K2.t(e.this.getBannerSize().toString() + "_cpcActiveFlow").toLowerCase();
                                e.this.getBannerSize().toString();
                                int hashCode = lowerCase2.hashCode();
                                if (hashCode != 97) {
                                    if (hashCode == 98) {
                                        if (lowerCase2.equals("b")) {
                                            c = 1;
                                        }
                                    }
                                } else if (lowerCase2.equals("a")) {
                                    c = 0;
                                }
                                if (c != 0) {
                                    e.this.click();
                                    return;
                                }
                                e.this.clicked = true;
                                e.this.click();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            }
        }

        @JavascriptInterface
        public void openLink(String str) {
            if (!e.this.isDestroyed()) {
                e.this.openLink(str);
            }
        }

        @JavascriptInterface
        public void logSTP(String str, String str2) {
            g.a((Ad) e.this.getBannerAd(), (AppnextAd) e.this.getSelectedAd(), str, str2, (SettingsManager) d.K());
        }
    }

    /* access modifiers changed from: private */
    public void openResultPage(boolean z) {
        Intent intent = new Intent(this.context, BannerActivity.class);
        intent.putExtra("placement", getBannerAd().getPlacementID());
        intent.putExtra("postback", getBannerAd().getPostback());
        intent.putExtra("category", getBannerAd().getCategories());
        intent.putExtra("clicked", getSelectedAd().getBannerID());
        intent.putExtra("selected", getSelectedAd());
        intent.putExtra("size", getBannerSize().toString());
        intent.putExtra("shouldClose", z);
        intent.setFlags(65536);
        this.context.startActivity(intent);
    }

    public class b extends WebViewClient {
        public b() {
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str == null) {
                return false;
            }
            try {
                if (str.startsWith("http")) {
                    webView.loadUrl(str);
                    return true;
                }
            } catch (Throwable th) {
                com.appnext.base.a.a("JSBannerAdapter$JSWebViewClient", th);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26 || renderProcessGoneDetail.didCrash()) {
                return false;
            }
            if (webView == null) {
                return true;
            }
            webView.destroy();
            return true;
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            try {
                e.this.pageFinished();
            } catch (Throwable th) {
                com.appnext.base.a.a("JSBannerAdapter$JSWebViewClient", th);
            }
        }
    }

    /* access modifiers changed from: private */
    public void pageFinished() {
        if (!isDestroyed()) {
            n.aa().a(new Runnable() {
                public final void run() {
                    try {
                        e eVar = e.this;
                        eVar.adsid = g.b(eVar.context, false);
                        e.this.handler.removeCallbacksAndMessages((Object) null);
                        e.this.handler.post(new Runnable() {
                            public final void run() {
                                try {
                                    e.this.loadJS("javascript:(function() { try { Appnext.Layout.destroy('internal'); } catch(err){ Appnext.jsError(err.message); }})()");
                                    e eVar = e.this;
                                    eVar.loadJS("javascript:(function() { try { Appnext.setParams(" + e.this.getConfigParams().toString() + "); } catch(err){ Appnext.jsError(err.message); }})()");
                                    e eVar2 = e.this;
                                    eVar2.loadJS("javascript:(function() { try { Appnext.loadBanner(" + new JSONObject(e.this.getSelectedAd().getAdJSON()).toString() + ",'" + e.this.getBannerSize().toString() + "'); } catch(err){ Appnext.jsError(err.message); }})()");
                                    e.this.shown.add(e.this.getSelectedAd().getBannerID());
                                } catch (Throwable unused) {
                                }
                            }
                        });
                    } catch (Throwable th) {
                        com.appnext.base.a.a("JSBannerAdapter$pageFinished", th);
                    }
                }
            });
        }
    }

    private void activateAutoRefresh() {
        int i;
        d K = d.K();
        try {
            i = Integer.parseInt(K.t(getBannerSize().toString().toLowerCase() + "_ar"));
        } catch (Throwable unused) {
            i = 10;
        }
        if (Boolean.parseBoolean(K.t("_arFlag")) && i > 0) {
            this.refreshHandler.postDelayed(new Runnable() {
                public final void run() {
                    try {
                        AppnextAd a = b.J().a(e.this.context, (Ad) e.this.getBannerAd(), (ArrayList<?>) e.this.getAds(), e.this.getAdRequest().getCreativeType(), (ArrayList<String>) e.this.shown);
                        if (a != null) {
                            e.this.setSelectedAd(new BannerAdData(a));
                            if (Boolean.parseBoolean(d.K().t("impOne"))) {
                                e.this.setReportedImpression(false);
                                e.this.impression();
                            } else if (Boolean.parseBoolean(d.K().t("pview"))) {
                                e.this.refreshHandler.postDelayed(new Runnable() {
                                    public final void run() {
                                        e.this.getUserAction().a(e.this.getSelectedAd(), e.this.getSelectedAd().getImpressionURL(), (f.a) null);
                                    }
                                }, (long) (Integer.parseInt(d.K().t("postpone_vta_sec")) * 1000));
                            }
                            e.this.pageFinished();
                        }
                    } catch (Throwable th) {
                        com.appnext.base.a.a("JSBannerAdapter$activateAutoRefresh", th);
                    }
                }
            }, (long) (i * 1000));
        }
    }

    public void impression() {
        try {
            boolean isReportedImpression = isReportedImpression();
            super.impression();
            if (isReportedImpression != isReportedImpression()) {
                activateAutoRefresh();
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("JSBannerAdapter$impression", th);
        }
    }
}
