package com.appnext.ads.interstitial;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import androidx.palette.graphics.Palette;
import com.appnext.R;
import com.appnext.ads.AdsError;
import com.appnext.core.Ad;
import com.appnext.core.AppnextActivity;
import com.appnext.core.AppnextAd;
import com.appnext.core.AppnextError;
import com.appnext.core.SettingsManager;
import com.appnext.core.callbacks.OnAdClicked;
import com.appnext.core.callbacks.OnAdClosed;
import com.appnext.core.callbacks.OnAdError;
import com.appnext.core.f;
import com.appnext.core.g;
import com.appnext.core.i;
import com.appnext.core.n;
import com.appnext.core.p;
import com.appnext.core.result.ResultPageActivity;
import com.appnext.core.result.c;
import com.appnext.core.result.d;
import com.appnext.core.webview.AppnextWebView;
import com.appnext.core.webview.WebAppInterface;
import com.bykv.vk.openvk.preload.falconx.statistic.StatisticData;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InterstitialActivity extends AppnextActivity {
    /* access modifiers changed from: private */
    public boolean aA = false;
    /* access modifiers changed from: private */
    public Runnable aB = new Runnable() {
        public final void run() {
            InterstitialActivity.this.pageFinished();
        }
    };
    private ArrayList<AppnextAd> ads;
    protected WebView am;
    private boolean an = false;
    /* access modifiers changed from: private */
    public Interstitial ao;
    /* access modifiers changed from: private */
    public InterstitialAd ap;
    private String aq = "";
    private boolean ar = false;
    /* access modifiers changed from: private */
    public int as = 0;
    /* access modifiers changed from: private */
    public Handler at;
    private f.a au;
    /* access modifiers changed from: private */
    public Boolean autoPlay;
    private WebAppInterface av;
    private boolean aw = false;
    private boolean ax = false;
    /* access modifiers changed from: private */
    public String ay;
    /* access modifiers changed from: private */
    public String az = "";
    private Boolean canClose;
    /* access modifiers changed from: private */
    public AppnextAd j;
    private Boolean mute;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        setRequestedOrientation(7);
        super.onCreate(bundle);
        try {
            if (Interstitial.currentAd == null) {
                finish();
                return;
            }
            this.ao = new Interstitial(Interstitial.currentAd);
            if (getRequestedOrientation() == 6) {
                a(this, "loaded_landscape");
            } else {
                a(this, "loaded_portrait");
            }
            this.cv = new RelativeLayout(this);
            setContentView(this.cv);
            this.cv.getLayoutParams().width = -1;
            this.cv.getLayoutParams().height = -1;
            this.cv.setBackgroundColor(-1);
            this.placementID = getIntent().getExtras().getString("id");
            if (getIntent().hasExtra("auto_play")) {
                Boolean valueOf = Boolean.valueOf(getIntent().getBooleanExtra("auto_play", true));
                this.autoPlay = valueOf;
                if (valueOf.booleanValue()) {
                    a(this, "auto_play_on");
                } else {
                    a(this, "auto_play_off");
                }
            }
            if (getIntent().hasExtra("can_close")) {
                this.canClose = Boolean.valueOf(getIntent().getBooleanExtra("can_close", false));
            }
            if (getIntent().hasExtra(CampaignEx.JSON_NATIVE_VIDEO_MUTE)) {
                Boolean valueOf2 = Boolean.valueOf(getIntent().getBooleanExtra(CampaignEx.JSON_NATIVE_VIDEO_MUTE, true));
                this.mute = valueOf2;
                if (valueOf2.booleanValue()) {
                    a(this, "mute_on");
                } else {
                    a(this, "mute_off");
                }
            }
            if (getIntent().hasExtra("pview")) {
                this.ct = getIntent().getStringExtra("pview");
                this.banner = getIntent().getStringExtra("banner");
                this.guid = getIntent().getStringExtra("guid");
            }
            if (getIntent().getSerializableExtra(CampaignUnit.JSON_KEY_ADS) != null) {
                this.ads = (ArrayList) getIntent().getSerializableExtra(CampaignUnit.JSON_KEY_ADS);
            }
            this.at = new Handler();
            AppnextWebView.q(this).a(this.ao.getPageUrl(), (AppnextWebView.c) new AppnextWebView.c() {
                public final void f(String str) {
                    InterstitialActivity.this.r();
                }

                public final void error(String str) {
                    try {
                        InterstitialActivity.this.r();
                    } catch (Throwable unused) {
                    }
                }
            });
            this.au = new f.a() {
                public final void onMarket(String str) {
                    try {
                        if (InterstitialActivity.this.handler != null) {
                            InterstitialActivity.this.handler.removeCallbacks((Runnable) null);
                        }
                        InterstitialActivity.this.S();
                    } catch (Throwable unused) {
                    }
                }

                public final void error(String str) {
                    try {
                        if (InterstitialActivity.this.handler != null) {
                            InterstitialActivity.this.handler.removeCallbacks((Runnable) null);
                        }
                        InterstitialActivity.this.S();
                        String unused = InterstitialActivity.this.placementID;
                        new InterstitialAd(InterstitialActivity.this.j).getAppURL();
                    } catch (Throwable unused2) {
                    }
                }
            };
            this.userAction = new p(this, new p.a() {
                public final void report(String str) {
                }

                public final Ad c() {
                    return InterstitialActivity.this.ao;
                }

                public final AppnextAd d() {
                    return InterstitialActivity.this.j;
                }

                public final SettingsManager e() {
                    return InterstitialActivity.this.getConfig();
                }
            });
            n.aa().a(new Runnable() {
                public final void run() {
                    try {
                        InterstitialActivity interstitialActivity = InterstitialActivity.this;
                        interstitialActivity.az = g.b((Context) interstitialActivity, true);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            com.appnext.base.a.a("InterstitialActivity$onCreate", th);
        }
    }

    /* access modifiers changed from: private */
    public void r() {
        try {
            AppnextWebView q = AppnextWebView.q(this);
            this.am = q.C(this.ads != null ? "fullscreen" : IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE);
            WebView a2 = q.a(this, this.ao.getPlacementID(), this.ao.getAUID(), this.ao.getPageUrl(), s(), this.ao.getFallback(), this.ads != null ? "fullscreen" : IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE);
            this.am = a2;
            a2.setWebViewClient(new WebViewClient() {
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
                    InterstitialActivity.this.at.removeCallbacksAndMessages((Object) null);
                    InterstitialActivity.this.pageFinished();
                }
            });
            this.am.setWebChromeClient(new WebChromeClient() {
                public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                    consoleMessage.message();
                    if (consoleMessage.message().contains(CampaignEx.JSON_NATIVE_VIDEO_PAUSE)) {
                        return true;
                    }
                    if (!consoleMessage.message().contains("TypeError") && !consoleMessage.message().contains("has no method") && !consoleMessage.message().contains("is not a function")) {
                        return true;
                    }
                    InterstitialActivity.this.onError(AppnextError.INTERNAL_ERROR);
                    InterstitialActivity.this.finish();
                    return true;
                }
            });
        } catch (Throwable th) {
            com.appnext.base.a.a("InterstitialActivity$initWebView", th);
            onError(AppnextError.INTERNAL_ERROR);
            finish();
        }
    }

    /* access modifiers changed from: private */
    public void pageFinished() {
        try {
            Handler handler = this.at;
            if (handler != null) {
                handler.removeCallbacks(this.aB);
            }
            this.an = true;
            String string = getIntent().getExtras().getString("creative");
            this.aq = string;
            if (string == null || string.equals(Interstitial.TYPE_MANAGED)) {
                this.aq = d("creative");
            }
            n.aa().a(new Runnable() {
                public final void run() {
                    InterstitialActivity.this.t();
                }
            });
            WebView webView = this.am;
            if (webView == null) {
                onError(AppnextError.INTERNAL_ERROR);
                finish();
                return;
            }
            if (webView.getParent() != null) {
                ((ViewGroup) this.am.getParent()).removeView(this.am);
            }
            this.cv.addView(this.am);
            this.am.getLayoutParams().width = -1;
            this.am.getLayoutParams().height = -1;
        } catch (Throwable th) {
            com.appnext.base.a.a("InterstitialActivity$pageFinished", th);
        }
    }

    /* access modifiers changed from: private */
    public void c(final String str) {
        n.aa().a(new Runnable() {
            public final void run() {
                try {
                    if (!TextUtils.isEmpty(InterstitialActivity.this.placementID) && !TextUtils.isEmpty(str)) {
                        com.appnext.core.adswatched.a.l(InterstitialActivity.this).j(str, InterstitialActivity.this.ao.getAUID());
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public final SettingsManager getConfig() {
        return c.E();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        Boolean bool;
        super.onResume();
        try {
            if (this.aA) {
                a();
                finish();
                return;
            }
            if (this.an && (bool = this.autoPlay) != null && bool.booleanValue()) {
                loadJS("Appnext.Layout.Video.play();");
            }
            try {
                this.am.loadUrl("javascript:(function() { try{Appnext.countToClose();}catch(e){}})()");
            } catch (Throwable unused) {
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("InterstitialActivity$onResume", th);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        try {
            if (!this.ar) {
                WebView webView = this.am;
                if (webView != null) {
                    webView.loadUrl("javascript:(function() { Appnext.Layout.Video.pause();})()");
                }
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("InterstitialActivity$onPause", th);
        }
    }

    public void onBackPressed() {
        try {
            Boolean bool = this.canClose;
            if (bool != null) {
                if (!bool.booleanValue()) {
                    return;
                }
            } else if (!Boolean.parseBoolean(d("can_close"))) {
                return;
            }
            loadJS("Appnext.Layout.destroy('internal');");
            this.ar = true;
            a();
            finish();
        } catch (Throwable th) {
            com.appnext.base.a.a("InterstitialActivity$onBackPressed", th);
        }
    }

    /* access modifiers changed from: protected */
    public final void onError(final String str) {
        try {
            runOnUiThread(new Runnable() {
                public final void run() {
                    if (InterstitialActivity.this.ao != null) {
                        try {
                            OnAdError onAdErrorCallback = InterstitialActivity.this.ao.getOnAdErrorCallback();
                            if (onAdErrorCallback != null) {
                                onAdErrorCallback.adError(str);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Throwable th) {
            com.appnext.base.a.a("InterstitialActivity$onError", th);
        }
    }

    /* access modifiers changed from: private */
    public void e(String str) {
        OnAdClicked onAdClickedCallback;
        try {
            a.C();
            AppnextAd appnextAd = (AppnextAd) a.parseAd(str);
            if (appnextAd != null) {
                this.j = new InterstitialAd(appnextAd);
                Interstitial interstitial = this.ao;
                if (!(interstitial == null || (onAdClickedCallback = interstitial.getOnAdClickedCallback()) == null)) {
                    onAdClickedCallback.adClicked();
                }
                b(this.j, this.au);
                a(this, "click_event");
                String bannerID = this.j.getBannerID();
                InterstitialAd interstitialAd = this.ap;
                if (bannerID.equals(interstitialAd != null ? interstitialAd.getBannerID() : "")) {
                    if (!this.aw) {
                        this.aw = true;
                        a(this, "interstitial_main_click");
                    }
                } else if (!this.ax) {
                    this.ax = true;
                    a(this, "interstitial_suggested_click");
                }
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("InterstitialActivity$adClick", th);
        }
    }

    /* access modifiers changed from: protected */
    public final void b(AppnextAd appnextAd, f.a aVar) {
        try {
            a((ViewGroup) this.cv, getResources().getDrawable(R.drawable.apnxt_loader));
            super.b(appnextAd, aVar);
        } catch (Throwable th) {
            com.appnext.base.a.a("InterstitialActivity$doClick", th);
        }
    }

    /* access modifiers changed from: protected */
    public final WebAppInterface s() {
        if (this.av == null) {
            this.av = new WebInterface();
        }
        return this.av;
    }

    protected class WebInterface extends WebAppInterface {
        @JavascriptInterface
        public String filterAds(String str) {
            return str;
        }

        @JavascriptInterface
        public void gotoAppWall() {
        }

        @JavascriptInterface
        public String loadAds() {
            return "";
        }

        @JavascriptInterface
        public void videoPlayed() {
        }

        public WebInterface() {
            super(InterstitialActivity.this);
        }

        @JavascriptInterface
        public void destroy(String str) {
            try {
                if (str.equals("c_close")) {
                    InterstitialActivity.this.aA = true;
                    InterstitialActivity.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            try {
                                JSONObject jSONObject = new JSONObject(InterstitialActivity.this.ap.getAdJSON());
                                jSONObject.put("urlApp", jSONObject.getString("urlApp") + "&tem_id=156");
                                InterstitialActivity.this.e(jSONObject.toString());
                            } catch (JSONException unused) {
                                InterstitialActivity.this.e(InterstitialActivity.this.ap.getAdJSON());
                            }
                        }
                    });
                } else if (str.equals("close")) {
                    InterstitialActivity.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            InterstitialActivity.this.a();
                            InterstitialActivity.this.finish();
                        }
                    });
                } else {
                    InterstitialActivity.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            InterstitialActivity.this.onError(AdsError.AD_NOT_READY);
                            InterstitialActivity.this.finish();
                        }
                    });
                }
            } catch (Throwable th) {
                com.appnext.base.a.a("InterstitialActivity$destroy", th);
            }
        }

        @JavascriptInterface
        public void notifyImpression(String str) {
            super.notifyImpression(str);
            try {
                if (InterstitialActivity.this.ap != null) {
                    InterstitialActivity interstitialActivity = InterstitialActivity.this;
                    interstitialActivity.c(interstitialActivity.ap.getBannerID());
                    InterstitialActivity.this.ap.setImpressionURL(str);
                    InterstitialActivity.this.handler.postDelayed(new a(str), Long.parseLong(InterstitialActivity.this.getConfig().t("postpone_impression_sec")) * 1000);
                }
                if (InterstitialActivity.this.autoPlay != null && InterstitialActivity.this.autoPlay.booleanValue()) {
                    play();
                }
            } catch (Throwable th) {
                com.appnext.base.a.a("InterstitialActivity$notifyImpression", th);
            }
        }

        @JavascriptInterface
        public void postView(String str) {
            try {
                if (InterstitialActivity.this.ap != null) {
                    InterstitialActivity.this.c(g.f(str, "b"));
                }
                if (Boolean.parseBoolean(InterstitialActivity.this.d("pview"))) {
                    InterstitialActivity.this.handler.postDelayed(new b(str), Long.parseLong(InterstitialActivity.this.getConfig().t("postpone_vta_sec")) * 1000);
                }
            } catch (Throwable th) {
                com.appnext.base.a.a("InterstitialActivity$postView", th);
            }
        }

        @JavascriptInterface
        public void openStore(final String str) {
            InterstitialActivity.this.runOnUiThread(new Runnable() {
                public final void run() {
                    InterstitialActivity.this.e(str);
                }
            });
        }

        @JavascriptInterface
        public void play() {
            try {
                String unused = InterstitialActivity.this.placementID;
                InterstitialActivity.this.play();
            } catch (Throwable th) {
                com.appnext.base.a.a("InterstitialActivity$play", th);
            }
        }

        @JavascriptInterface
        public void openLink(String str) {
            try {
                InterstitialActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Throwable th) {
                com.appnext.base.a.a("InterstitialActivity$openLink", th);
            }
        }

        @JavascriptInterface
        public void logSTP(String str, String str2) {
            try {
                g.a((Ad) InterstitialActivity.this.ao, (AppnextAd) InterstitialActivity.this.ap, str, str2, InterstitialActivity.this.getConfig());
            } catch (Throwable th) {
                com.appnext.base.a.a("InterstitialActivity$logSTP", th);
            }
        }

        @JavascriptInterface
        public void jsError(String str) {
            try {
                if (TextUtils.isEmpty(str)) {
                    if (str.contains("is not a function") || str.contains("has no method")) {
                        InterstitialActivity interstitialActivity = InterstitialActivity.this;
                        int r0 = interstitialActivity.as;
                        interstitialActivity.as = r0 + 1;
                        if (r0 < 5) {
                            InterstitialActivity.this.at.postDelayed(InterstitialActivity.this.aB, 500);
                            return;
                        }
                        InterstitialActivity.this.onError(AppnextError.INTERNAL_ERROR);
                        InterstitialActivity.this.finish();
                        return;
                    }
                }
                InterstitialActivity.this.onError(AppnextError.INTERNAL_ERROR);
                InterstitialActivity.this.finish();
            } catch (Throwable th) {
                com.appnext.base.a.a("InterstitialActivity$jsError", th);
            }
        }

        @JavascriptInterface
        public void openResultPage(String str) {
            try {
                d.ay().a(new c() {
                    public final String v() {
                        return "160";
                    }

                    public final JSONObject getConfigParams() throws JSONException {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("vid", "2.7.0.473");
                        String str = "";
                        jSONObject.put(ScarConstants.TOKEN_ID_KEY, InterstitialActivity.this.ao == null ? str : InterstitialActivity.this.ao.getTID());
                        if (InterstitialActivity.this.ao != null) {
                            str = InterstitialActivity.this.ao.getAUID();
                        }
                        jSONObject.put(JsonStorageKeyNames.AUID_ID_KEY, str);
                        jSONObject.put("osid", StatisticData.ERROR_CODE_NOT_FOUND);
                        jSONObject.put("tem_id", "1601");
                        jSONObject.put("id", getPlacementId());
                        jSONObject.put("cat", InterstitialActivity.this.ap.getCategories());
                        jSONObject.put("lockcat", InterstitialActivity.this.ap.getSpecificCategories());
                        jSONObject.put("pview", InterstitialActivity.this.getConfig().t("pview"));
                        jSONObject.put("devn", g.V());
                        jSONObject.put("dosv", Build.VERSION.SDK_INT);
                        jSONObject.put("dds", "0");
                        jSONObject.put("ads_type", "banner");
                        jSONObject.put("country", InterstitialActivity.this.ap.getCountry());
                        jSONObject.put("gdpr", i.a((AppnextAd) InterstitialActivity.this.ap, InterstitialActivity.this.getConfig()));
                        return jSONObject;
                    }

                    public final AppnextAd getSelectedAd() {
                        return InterstitialActivity.this.ap;
                    }

                    public final String getPlacementId() {
                        return InterstitialActivity.this.placementID;
                    }

                    public final String w() {
                        return a.C().k(InterstitialActivity.this.ao);
                    }

                    public final String x() {
                        return InterstitialActivity.this.ay;
                    }

                    public final SettingsManager y() {
                        return InterstitialActivity.this.getConfig();
                    }

                    public final Ad z() {
                        return InterstitialActivity.this.ao;
                    }

                    public final com.appnext.core.result.a A() {
                        return new com.appnext.core.result.a() {
                            public final Object B() {
                                return null;
                            }

                            public final String getFallbackScript() {
                                return null;
                            }

                            public final String getJSurl() {
                                return "https://cdn.appnext.com/tools/sdk/interstitial/v75/result.min.js";
                            }

                            public final WebViewClient getWebViewClient() {
                                return null;
                            }
                        };
                    }
                });
                Intent intent = new Intent(InterstitialActivity.this, ResultPageActivity.class);
                intent.putExtra("shouldClose", false);
                intent.setFlags(65536);
                InterstitialActivity.this.startActivity(intent);
            } catch (Throwable th) {
                com.appnext.base.a.a("InterstitialActivity$openResultPage", th);
            }
        }
    }

    private class a implements Runnable {
        AppnextAd aF;

        a(String str) {
            try {
                InterstitialAd interstitialAd = new InterstitialAd(InterstitialActivity.this.ap);
                this.aF = interstitialAd;
                InterstitialAd interstitialAd2 = interstitialAd;
                interstitialAd.setImpressionURL(str);
            } catch (Throwable th) {
                com.appnext.base.a.a("InterstitialActivity$Impression", th);
            }
        }

        public final void run() {
            try {
                if (InterstitialActivity.this.userAction != null) {
                    InterstitialActivity.this.userAction.d(this.aF);
                    InterstitialActivity interstitialActivity = InterstitialActivity.this;
                    interstitialActivity.a(interstitialActivity, "impression_event");
                }
            } catch (Throwable th) {
                com.appnext.base.a.a("InterstitialActivity$Impression", th);
            }
        }
    }

    private class b implements Runnable {
        AppnextAd aF;

        b(String str) {
            try {
                a.C();
                this.aF = (AppnextAd) a.parseAd(str);
            } catch (Throwable th) {
                com.appnext.base.a.a("InterstitialActivity$PostView", th);
            }
        }

        public final void run() {
            try {
                InterstitialActivity.this.a(this.aF, (f.a) null);
            } catch (Throwable th) {
                com.appnext.base.a.a("InterstitialActivity$PostView", th);
            }
        }
    }

    /* access modifiers changed from: private */
    public void play() {
        loadJS("Appnext.Layout.Video.play();");
    }

    /* access modifiers changed from: private */
    public void a() {
        OnAdClosed onAdClosedCallback;
        try {
            Interstitial interstitial = this.ao;
            if (interstitial != null && (onAdClosedCallback = interstitial.getOnAdClosedCallback()) != null) {
                onAdClosedCallback.onAdClosed();
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("InterstitialActivity$onClose", th);
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context, String str) {
        try {
            Interstitial interstitial = this.ao;
            if (interstitial != null) {
                String tid = interstitial.getTID();
                String vid = this.ao.getVID();
                String auid = this.ao.getAUID();
                String placementID = this.ao.getPlacementID();
                String sessionId = this.ao.getSessionId();
                InterstitialAd interstitialAd = this.ap;
                String bannerID = interstitialAd != null ? interstitialAd.getBannerID() : "";
                InterstitialAd interstitialAd2 = this.ap;
                g.a(context, tid, vid, auid, placementID, sessionId, str, "current_interstitial", bannerID, interstitialAd2 != null ? interstitialAd2.getCampaignID() : "");
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("InterstitialActivity$report", th);
        }
    }

    private void loadJS(final String str) {
        runOnUiThread(new Runnable() {
            public final void run() {
                if (InterstitialActivity.this.am != null) {
                    try {
                        WebView webView = InterstitialActivity.this.am;
                        webView.loadUrl("javascript:(function() { try { " + str + "} catch(err){ Appnext.jsError(err.message); }})()");
                    } catch (Throwable th) {
                        com.appnext.base.a.a("InterstitialActivity$loadJS", th);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009a A[Catch:{ all -> 0x0146 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b8 A[Catch:{ all -> 0x0146 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d6 A[Catch:{ all -> 0x0146 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ee A[Catch:{ all -> 0x0146 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x012b A[Catch:{ all -> 0x0146 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void t() {
        /*
            r8 = this;
            monitor-enter(r8)
            com.appnext.ads.interstitial.a r0 = com.appnext.ads.interstitial.a.C()     // Catch:{ all -> 0x0146 }
            com.appnext.ads.interstitial.Interstitial r1 = r8.ao     // Catch:{ all -> 0x0146 }
            java.lang.String r2 = r8.aq     // Catch:{ all -> 0x0146 }
            java.util.ArrayList r0 = r0.b(r8, r1, r2)     // Catch:{ all -> 0x0146 }
            if (r0 != 0) goto L_0x0019
            r8.finish()     // Catch:{ all -> 0x0146 }
            java.lang.String r0 = "No Ads"
            r8.onError(r0)     // Catch:{ all -> 0x0146 }
            monitor-exit(r8)
            return
        L_0x0019:
            com.appnext.ads.interstitial.a r1 = com.appnext.ads.interstitial.a.C()     // Catch:{ all -> 0x0146 }
            java.lang.String r1 = r1.a(r0)     // Catch:{ all -> 0x0146 }
            if (r1 != 0) goto L_0x002d
            r8.finish()     // Catch:{ all -> 0x0146 }
            java.lang.String r0 = "No Ads"
            r8.onError(r0)     // Catch:{ all -> 0x0146 }
            monitor-exit(r8)
            return
        L_0x002d:
            java.lang.String r2 = " "
            java.lang.String r3 = "\\u2028"
            java.lang.String r1 = r1.replace(r2, r3)     // Catch:{ all -> 0x0146 }
            java.lang.String r2 = " "
            java.lang.String r3 = "\\u2029"
            java.lang.String r1 = r1.replace(r2, r3)     // Catch:{ all -> 0x0146 }
            r8.ay = r1     // Catch:{ all -> 0x0146 }
            com.appnext.ads.interstitial.InterstitialAd r2 = new com.appnext.ads.interstitial.InterstitialAd     // Catch:{ all -> 0x0146 }
            r3 = 0
            java.lang.Object r4 = r0.get(r3)     // Catch:{ all -> 0x0146 }
            com.appnext.core.AppnextAd r4 = (com.appnext.core.AppnextAd) r4     // Catch:{ all -> 0x0146 }
            r2.<init>(r4)     // Catch:{ all -> 0x0146 }
            r8.ap = r2     // Catch:{ all -> 0x0146 }
            android.content.res.Resources r2 = r8.getResources()     // Catch:{ all -> 0x0146 }
            android.content.res.Configuration r2 = r2.getConfiguration()     // Catch:{ all -> 0x0146 }
            int r2 = r2.orientation     // Catch:{ all -> 0x0146 }
            org.json.JSONObject r2 = r8.u()     // Catch:{ all -> 0x0146 }
            java.lang.Object r4 = r0.get(r3)     // Catch:{ all -> 0x0146 }
            com.appnext.core.AppnextAd r4 = (com.appnext.core.AppnextAd) r4     // Catch:{ all -> 0x0146 }
            java.lang.String r5 = r4.getVideoUrl()     // Catch:{ all -> 0x0146 }
            java.lang.String r6 = ""
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x0146 }
            r6 = 1
            if (r5 == 0) goto L_0x0097
            java.lang.String r5 = r4.getVideoUrlHigh()     // Catch:{ all -> 0x0146 }
            java.lang.String r7 = ""
            boolean r5 = r5.equals(r7)     // Catch:{ all -> 0x0146 }
            if (r5 == 0) goto L_0x0097
            java.lang.String r5 = r4.getVideoUrl30Sec()     // Catch:{ all -> 0x0146 }
            java.lang.String r7 = ""
            boolean r5 = r5.equals(r7)     // Catch:{ all -> 0x0146 }
            if (r5 == 0) goto L_0x0097
            java.lang.String r4 = r4.getVideoUrlHigh30Sec()     // Catch:{ all -> 0x0146 }
            java.lang.String r5 = ""
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0146 }
            if (r4 != 0) goto L_0x0095
            goto L_0x0097
        L_0x0095:
            r4 = 0
            goto L_0x0098
        L_0x0097:
            r4 = 1
        L_0x0098:
            if (r4 == 0) goto L_0x00b8
            java.lang.String r4 = "remote_auto_play"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0146 }
            r5.<init>()     // Catch:{ all -> 0x0146 }
            java.lang.Boolean r7 = r8.autoPlay     // Catch:{ all -> 0x0146 }
            if (r7 == 0) goto L_0x00ac
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0146 }
            if (r7 == 0) goto L_0x00ac
            goto L_0x00ad
        L_0x00ac:
            r6 = 0
        L_0x00ad:
            r5.append(r6)     // Catch:{ all -> 0x0146 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0146 }
            r2.put(r4, r5)     // Catch:{ all -> 0x0146 }
            goto L_0x00bf
        L_0x00b8:
            java.lang.String r4 = "remote_auto_play"
            java.lang.String r5 = "false"
            r2.put(r4, r5)     // Catch:{ all -> 0x0146 }
        L_0x00bf:
            com.appnext.ads.interstitial.InterstitialAd r4 = new com.appnext.ads.interstitial.InterstitialAd     // Catch:{ all -> 0x0146 }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x0146 }
            com.appnext.core.AppnextAd r0 = (com.appnext.core.AppnextAd) r0     // Catch:{ all -> 0x0146 }
            r4.<init>(r0)     // Catch:{ all -> 0x0146 }
            java.lang.String r0 = r4.getButtonText()     // Catch:{ all -> 0x0146 }
            java.lang.String r3 = ""
            boolean r0 = r0.equals(r3)     // Catch:{ all -> 0x0146 }
            if (r0 == 0) goto L_0x00ee
            java.lang.String r0 = r4.getAdPackage()     // Catch:{ all -> 0x0146 }
            boolean r0 = com.appnext.core.g.b((android.content.Context) r8, (java.lang.String) r0)     // Catch:{ all -> 0x0146 }
            if (r0 == 0) goto L_0x00e7
            java.lang.String r0 = "existing_button_text"
            java.lang.String r0 = r8.d((java.lang.String) r0)     // Catch:{ all -> 0x0146 }
            goto L_0x00f2
        L_0x00e7:
            java.lang.String r0 = "new_button_text"
            java.lang.String r0 = r8.d((java.lang.String) r0)     // Catch:{ all -> 0x0146 }
            goto L_0x00f2
        L_0x00ee:
            java.lang.String r0 = r4.getButtonText()     // Catch:{ all -> 0x0146 }
        L_0x00f2:
            java.lang.String r3 = "b_title"
            r2.put(r3, r0)     // Catch:{ all -> 0x0146 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0146 }
            java.lang.String r3 = "Appnext.setParams("
            r0.<init>(r3)     // Catch:{ all -> 0x0146 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0146 }
            r0.append(r2)     // Catch:{ all -> 0x0146 }
            java.lang.String r2 = ");"
            r0.append(r2)     // Catch:{ all -> 0x0146 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0146 }
            r8.loadJS(r0)     // Catch:{ all -> 0x0146 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0146 }
            java.lang.String r2 = "Appnext.loadInterstitial("
            r0.<init>(r2)     // Catch:{ all -> 0x0146 }
            r0.append(r1)     // Catch:{ all -> 0x0146 }
            java.lang.String r1 = ");"
            r0.append(r1)     // Catch:{ all -> 0x0146 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0146 }
            r8.loadJS(r0)     // Catch:{ all -> 0x0146 }
            com.appnext.ads.interstitial.InterstitialAd r0 = r8.ap     // Catch:{ all -> 0x0146 }
            if (r0 == 0) goto L_0x013a
            com.appnext.ads.interstitial.a r0 = com.appnext.ads.interstitial.a.C()     // Catch:{ all -> 0x0146 }
            com.appnext.ads.interstitial.InterstitialAd r1 = r8.ap     // Catch:{ all -> 0x0146 }
            java.lang.String r1 = r1.getBannerID()     // Catch:{ all -> 0x0146 }
            com.appnext.ads.interstitial.Interstitial r2 = com.appnext.ads.interstitial.Interstitial.currentAd     // Catch:{ all -> 0x0146 }
            r0.a((android.content.Context) r8, (java.lang.String) r1, (com.appnext.core.Ad) r2)     // Catch:{ all -> 0x0146 }
        L_0x013a:
            android.os.Handler r0 = r8.handler     // Catch:{ all -> 0x0146 }
            com.appnext.ads.interstitial.InterstitialActivity$4 r1 = new com.appnext.ads.interstitial.InterstitialActivity$4     // Catch:{ all -> 0x0146 }
            r1.<init>()     // Catch:{ all -> 0x0146 }
            r0.post(r1)     // Catch:{ all -> 0x0146 }
            monitor-exit(r8)
            return
        L_0x0146:
            r0 = move-exception
            java.lang.String r1 = "InterstitialActivity$loadAdsData"
            com.appnext.base.a.a(r1, r0)     // Catch:{ all -> 0x0156 }
            r8.finish()     // Catch:{ all -> 0x0156 }
            java.lang.String r0 = "Internal error"
            r8.onError(r0)     // Catch:{ all -> 0x0156 }
            monitor-exit(r8)
            return
        L_0x0156:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.ads.interstitial.InterstitialActivity.t():void");
    }

    /* access modifiers changed from: protected */
    public final JSONObject u() throws JSONException {
        String str;
        try {
            String d = this.ao.getButtonColor().equals("") ? d("button_color") : this.ao.getButtonColor();
            if (d.startsWith("#")) {
                d = d.substring(1);
            }
            if (this.autoPlay == null) {
                this.autoPlay = Boolean.valueOf(Boolean.parseBoolean(d("auto_play")));
            }
            if (this.mute == null) {
                this.mute = Boolean.valueOf(Boolean.parseBoolean(d(CampaignEx.JSON_NATIVE_VIDEO_MUTE)));
            }
            JSONObject jSONObject = new JSONObject();
            String str2 = "InterstitialActivity$getAdParams";
            try {
                jSONObject.put("id", this.placementID);
                jSONObject.put("cat", this.ao.getCategories());
                jSONObject.put("lockcat", this.ao.getSpecificCategories());
                jSONObject.put("pbk", this.ao.getPostback());
                jSONObject.put("b_color", d);
                if (this.ads == null) {
                    jSONObject.put("skip_title", this.ao.getSkipText().equals("") ? d("skip_title") : this.ao.getSkipText());
                    jSONObject.put("pview", this.ads != null ? "false" : d("pview"));
                    jSONObject.put(CampaignEx.JSON_KEY_VIDEO_LENGTHL, d(CampaignEx.JSON_KEY_VIDEO_LENGTHL));
                    jSONObject.put("min_internet_connection", d("min_internet_connection"));
                    jSONObject.put("min_internet_connection_video", d("min_internet_connection_video"));
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.mute);
                    jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_MUTE, sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.autoPlay);
                    jSONObject.put("auto_play", sb2.toString());
                    jSONObject.put("remove_poster_on_auto_play", d("remove_poster_on_auto_play"));
                    jSONObject.put("show_rating", d("show_rating"));
                    jSONObject.put("show_desc", d("show_desc"));
                    jSONObject.put("creative", this.aq);
                    jSONObject.put("remote_auto_play", true);
                }
                jSONObject.put("stp_flag", d("stp_flag"));
                jSONObject.put("ext", "t");
                jSONObject.put("dct", g.c((Context) this));
                jSONObject.put("did", this.az);
                jSONObject.put("devn", g.V());
                jSONObject.put("dosv", Build.VERSION.SDK_INT);
                jSONObject.put("dds", "0");
                jSONObject.put("urlApp_protection", d("urlApp_protection"));
                jSONObject.put("vid", this.ao.getVID());
                jSONObject.put(ScarConstants.TOKEN_ID_KEY, this.ao.getTID());
                jSONObject.put(JsonStorageKeyNames.AUID_ID_KEY, this.ao.getAUID());
                jSONObject.put("osid", StatisticData.ERROR_CODE_NOT_FOUND);
                jSONObject.put("ads_type", IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE);
                jSONObject.put("country", this.ap.getCountry());
                jSONObject.put("gdpr", i.a((AppnextAd) this.ap, (SettingsManager) c.E()));
                jSONObject.put("lang_settings", new JSONObject(com.appnext.core.a.a.n(this).ag()).toString());
                String language = this.ao.getLanguage();
                if (language == null || language.equals("")) {
                    language = Locale.getDefault().getLanguage().toUpperCase();
                }
                jSONObject.put("lang", language);
                jSONObject.put("tem", new JSONArray(d("S1")).toString());
                jSONObject.put("click_x", d("clickType_A"));
                if (getIntent() != null && getIntent().hasExtra("show_desc")) {
                    jSONObject.put("show_desc", getIntent().getStringExtra("show_desc"));
                }
                try {
                    Bitmap p = g.p(this.ap.getImageURL());
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    p.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    String str3 = "data:image/" + this.ap.getImageURL().substring(this.ap.getImageURL().lastIndexOf(46) + 1) + ";base64," + Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                    try {
                        Palette.Swatch vibrantSwatch = Palette.from(p).generate().getVibrantSwatch();
                        if (vibrantSwatch != null) {
                            jSONObject.put("icon_color", String.format("#%06X", new Object[]{Integer.valueOf(vibrantSwatch.getRgb() & ViewCompat.MEASURED_SIZE_MASK)}));
                        } else {
                            jSONObject.put("icon_color", "");
                        }
                        String str4 = str2;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            com.appnext.base.a.a(str, th);
                            return jSONObject;
                        } catch (Throwable th2) {
                            th = th2;
                            com.appnext.base.a.a(str, th);
                            return new JSONObject();
                        }
                    }
                    jSONObject.put("icon_src", str3);
                } catch (Throwable th3) {
                    th = th3;
                    str = str2;
                    com.appnext.base.a.a(str, th);
                    return jSONObject;
                }
                return jSONObject;
            } catch (Throwable th4) {
                th = th4;
                str = str2;
                com.appnext.base.a.a(str, th);
                return new JSONObject();
            }
        } catch (Throwable th5) {
            th = th5;
            str = "InterstitialActivity$getAdParams";
            com.appnext.base.a.a(str, th);
            return new JSONObject();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        try {
            a.C().g(this.ao);
            this.ao.destroy();
            this.ao = null;
            Handler handler = this.at;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            this.at = null;
            this.aB = null;
            this.ap = null;
            WebView webView = this.am;
            if (webView != null) {
                webView.stopLoading();
                if (this.am.getParent() != null) {
                    ((ViewGroup) this.am.getParent()).removeView(this.am);
                }
                this.am.setWebChromeClient((WebChromeClient) null);
                this.am.setWebViewClient((WebViewClient) null);
                this.am.destroy();
                this.am = null;
            }
            AppnextWebView.q(this).a(s());
            this.av = null;
            this.au = null;
        } catch (Throwable th) {
            com.appnext.base.a.a("InterstitialActivity$onDestroy", th);
        }
    }

    /* access modifiers changed from: private */
    public String d(String str) {
        String t = c.E().t(str);
        return t == null ? "" : t;
    }
}
