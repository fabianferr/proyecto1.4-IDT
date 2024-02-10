package com.appnext.ads.interstitial;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.appnext.ads.AdsError;
import com.appnext.base.a;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.AppnextError;
import com.appnext.core.ECPM;
import com.appnext.core.SettingsManager;
import com.appnext.core.callbacks.OnAdError;
import com.appnext.core.callbacks.OnAdLoaded;
import com.appnext.core.callbacks.OnECPMLoaded;
import com.appnext.core.d;
import com.appnext.core.g;
import com.appnext.core.n;
import com.appnext.core.webview.AppnextWebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

public class Interstitial extends Ad {
    private static final String JS_URL = "https://cdn.appnext.com/tools/sdk/interstitial/v75/script.min.js";
    protected static final String TID = "301";
    public static final String TYPE_MANAGED = "managed";
    public static final String TYPE_STATIC = "static";
    public static final String TYPE_VIDEO = "video";
    protected static final String VID = "2.7.0.473";
    protected static Interstitial currentAd;
    private boolean autoPlay;
    private String buttonColor;
    /* access modifiers changed from: private */
    public boolean calledShow;
    private Boolean canClose;
    /* access modifiers changed from: private */
    public boolean configLoaded;
    private String creativeType;
    private OnAdError internalOnAdError;
    private String language;
    private boolean setAutoPlay;
    private boolean setCanClose;
    private String skipText;
    private String titleText;
    /* access modifiers changed from: private */
    public WeakReference<OnAdError> userOnAdErrorWR;

    public String getAUID() {
        return "600";
    }

    /* access modifiers changed from: protected */
    public String getPageUrl() {
        return JS_URL;
    }

    public String getTID() {
        return TID;
    }

    public String getVID() {
        return VID;
    }

    @Deprecated
    public void setOrientation(String str) {
    }

    public Interstitial(Context context, String str) {
        super(context, str);
        this.creativeType = TYPE_MANAGED;
        this.titleText = "";
        this.skipText = "";
        this.autoPlay = true;
        this.setAutoPlay = false;
        this.setCanClose = false;
        this.configLoaded = false;
        this.calledShow = false;
        this.buttonColor = "";
        this.language = "";
        init();
    }

    public Interstitial(Context context, String str, InterstitialConfig interstitialConfig) {
        super(context, str);
        this.creativeType = TYPE_MANAGED;
        this.titleText = "";
        this.skipText = "";
        boolean z = true;
        this.autoPlay = true;
        this.setAutoPlay = false;
        this.setCanClose = false;
        this.configLoaded = false;
        this.calledShow = false;
        this.buttonColor = "";
        this.language = "";
        try {
            init();
            if (interstitialConfig != null) {
                setPostback(interstitialConfig.getPostback());
                setCategories(interstitialConfig.getCategories());
                setSpecificCategories(interstitialConfig.getSpecificCategories());
                setButtonColor(interstitialConfig.getButtonColor());
                if (interstitialConfig.backButtonCanClose != null) {
                    setBackButtonCanClose(interstitialConfig.isBackButtonCanClose());
                }
                setSkipText(interstitialConfig.getSkipText());
                if (interstitialConfig.autoPlay != null) {
                    setAutoPlay(interstitialConfig.isAutoPlay());
                }
                setCreativeType(interstitialConfig.getCreativeType());
                setOrientation(interstitialConfig.getOrientation());
                if (interstitialConfig.mute == null) {
                    z = false;
                }
                if (z) {
                    setMute(interstitialConfig.getMute());
                }
                setMinVideoLength(interstitialConfig.getMinVideoLength());
                setMaxVideoLength(interstitialConfig.getMaxVideoLength());
                setLanguage(interstitialConfig.getLanguage());
            }
        } catch (Throwable th) {
            a.a("Interstitial$Interstitial", th);
        }
    }

    protected Interstitial(Interstitial interstitial) {
        super(interstitial);
        this.creativeType = TYPE_MANAGED;
        this.titleText = "";
        this.skipText = "";
        this.autoPlay = true;
        this.setAutoPlay = false;
        this.setCanClose = false;
        this.configLoaded = false;
        this.calledShow = false;
        this.buttonColor = "";
        this.language = "";
        try {
            this.creativeType = interstitial.creativeType;
            this.titleText = interstitial.titleText;
            this.skipText = interstitial.skipText;
            this.autoPlay = interstitial.autoPlay;
            this.setAutoPlay = interstitial.setAutoPlay;
            this.setCanClose = interstitial.setCanClose;
            this.configLoaded = interstitial.configLoaded;
            this.calledShow = interstitial.calledShow;
            this.canClose = interstitial.canClose;
            this.buttonColor = interstitial.buttonColor;
            this.language = interstitial.language;
            this.userOnAdErrorWR = interstitial.userOnAdErrorWR;
        } catch (Throwable th) {
            a.a("Interstitial$Interstitial", th);
        }
    }

    private void init() {
        try {
            loadConfig();
            AppnextWebView.q(this.context).a(getPageUrl(), (AppnextWebView.c) null);
        } catch (Throwable th) {
            a.a("Interstitial$init", th);
        }
    }

    public void loadAd() {
        try {
            if (getPlacementID().equals("")) {
                a.a("Interstitial$init", new Throwable("Placement ID cannot be empty"));
            }
            if (g.c(this.context, "android.permission.INTERNET")) {
                if (g.g(this.context)) {
                    n.aa().a(new Runnable() {
                        public final void run() {
                            try {
                                if (Interstitial.this.context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) {
                                    g.a(Interstitial.this.context, "http://www.appnext.com/myid.html", (HashMap<String, String>) null);
                                } else {
                                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) Interstitial.this.context.getSystemService("connectivity")).getActiveNetworkInfo();
                                    if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                                        return;
                                    }
                                }
                                Interstitial.this.getConfig().a(Interstitial.this.context, Interstitial.this.getPlacementID(), new SettingsManager.ConfigCallback() {
                                    public final void loaded(HashMap<String, Object> hashMap) {
                                        Interstitial.this.load();
                                    }

                                    public final void error(String str) {
                                        Interstitial.this.load();
                                    }
                                });
                            } catch (Throwable th) {
                                a.a("Interstitial$init", th);
                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    public final void run() {
                                        OnAdError onAdErrorCallback = Interstitial.this.getOnAdErrorCallback();
                                        if (onAdErrorCallback != null) {
                                            onAdErrorCallback.adError(AppnextError.CONNECTION_ERROR);
                                        }
                                    }
                                });
                            }
                        }
                    });
                    return;
                }
            }
            OnAdError onAdErrorCallback = getOnAdErrorCallback();
            if (onAdErrorCallback != null) {
                onAdErrorCallback.adError(AppnextError.CONNECTION_ERROR);
            }
        } catch (Throwable th) {
            a.a("Interstitial$loadAd", th);
        }
    }

    /* access modifiers changed from: private */
    public void load() {
        a.C().a(this.context, this, getPlacementID(), new d.a() {
            public final <T> void a(T t) {
                AppnextAd appnextAd;
                try {
                    appnextAd = a.C().a(Interstitial.this.context, (ArrayList<AppnextAd>) (ArrayList) t, Interstitial.this.getCreative(), (Ad) Interstitial.this);
                } catch (Throwable th) {
                    a.a("Interstitial$load", th);
                    return;
                }
                if (appnextAd != null) {
                    OnAdLoaded onAdLoadedCallback = Interstitial.this.getOnAdLoadedCallback();
                    if (onAdLoadedCallback != null) {
                        onAdLoadedCallback.adLoaded(appnextAd.getBannerID(), appnextAd.getCreativeType());
                        return;
                    }
                    return;
                }
                OnAdError onAdErrorCallback = Interstitial.this.getOnAdErrorCallback();
                if (onAdErrorCallback != null) {
                    onAdErrorCallback.adError(AppnextError.NO_ADS);
                }
            }

            public final void error(String str) {
                try {
                    OnAdError onAdErrorCallback = Interstitial.this.getOnAdErrorCallback();
                    if (onAdErrorCallback != null) {
                        onAdErrorCallback.adError(str);
                    }
                } catch (Throwable th) {
                    a.a("Interstitial$error", th);
                }
            }
        }, getCreative());
    }

    public void showAd() {
        try {
            if (getPlacementID().equals("")) {
                throw new IllegalArgumentException("Placement ID cannot be empty");
            } else if (!g.c(this.context, "android.permission.INTERNET")) {
                OnAdError onAdErrorCallback = getOnAdErrorCallback();
                if (onAdErrorCallback != null) {
                    onAdErrorCallback.adError(AppnextError.CONNECTION_ERROR);
                }
            } else {
                int q = g.q(getConfig().t("min_internet_connection"));
                int q2 = g.q(g.c(this.context));
                if (q2 == -1) {
                    OnAdError onAdErrorCallback2 = getOnAdErrorCallback();
                    if (onAdErrorCallback2 != null) {
                        onAdErrorCallback2.adError(AppnextError.CONNECTION_ERROR);
                    }
                } else if (q2 < q) {
                    OnAdError onAdErrorCallback3 = getOnAdErrorCallback();
                    if (onAdErrorCallback3 != null) {
                        onAdErrorCallback3.adError(AppnextError.SLOW_CONNECTION);
                    }
                } else {
                    currentAd = this;
                    if (a.C().f(this)) {
                        startInterstitialActivity();
                        return;
                    }
                    a.C().a(this.context, this, getPlacementID(), new d.a() {
                        public final <T> void a(T t) {
                            Interstitial.this.startInterstitialActivity();
                        }

                        public final void error(final String str) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                public final void run() {
                                    try {
                                        OnAdError onAdErrorCallback = Interstitial.this.getOnAdErrorCallback();
                                        if (onAdErrorCallback != null) {
                                            onAdErrorCallback.adError(str);
                                        }
                                    } catch (Throwable unused) {
                                    }
                                }
                            });
                        }
                    }, getCreative());
                }
            }
        } catch (Throwable th) {
            a.a("Interstitial$showAd", th);
        }
    }

    /* access modifiers changed from: private */
    public void startInterstitialActivity() {
        try {
            Intent activityIntent = getActivityIntent();
            if (activityIntent != null) {
                this.context.startActivity(activityIntent);
                return;
            }
            throw new IllegalArgumentException("null intent");
        } catch (Throwable th) {
            a.a("Interstitial$startInterstitialActivity", th);
        }
    }

    public void getECPM(final OnECPMLoaded onECPMLoaded) {
        if (onECPMLoaded != null) {
            try {
                a.C().a(this.context, this, getPlacementID(), new d.a() {
                    public final <T> void a(T t) {
                        try {
                            AppnextAd a = a.C().a(Interstitial.this.context, (ArrayList<AppnextAd>) (ArrayList) t, Interstitial.this.getCreative(), (Ad) Interstitial.this);
                            if (a != null) {
                                onECPMLoaded.ecpm(new ECPM(a.getECPM(), a.getPPR(), a.getBannerID()));
                            } else {
                                onECPMLoaded.error(AppnextError.NO_ADS);
                            }
                        } catch (Throwable unused) {
                        }
                    }

                    public final void error(String str) {
                        onECPMLoaded.error(str);
                    }
                }, false);
            } catch (Throwable th) {
                a.a("Interstitial$getECPM", th);
            }
        } else {
            throw new IllegalArgumentException("Callback cannot be null");
        }
    }

    /* access modifiers changed from: private */
    public String getCreative() {
        int q = g.q(getConfig().t("min_internet_connection"));
        int q2 = g.q(getConfig().t("min_internet_connection_video"));
        int q3 = g.q(g.c(this.context));
        if (q3 < q || q3 >= q2) {
            return getCreativeType();
        }
        return "static";
    }

    /* access modifiers changed from: protected */
    public Intent getActivityIntent() {
        Intent intent = new Intent(this.context, InterstitialActivity.class);
        try {
            intent.setFlags(268435456);
            intent.addFlags(67108864);
            intent.putExtra("id", getPlacementID());
            if (this.setAutoPlay) {
                intent.putExtra("auto_play", this.autoPlay);
            }
            if (this.setCanClose) {
                intent.putExtra("can_close", isBackButtonCanClose());
            }
            if (this.setMute) {
                intent.putExtra(CampaignEx.JSON_NATIVE_VIDEO_MUTE, getMute());
            }
            intent.putExtra("cat", getCategories());
            intent.putExtra("lockcat", getSpecificCategories());
            intent.putExtra("pbk", getPostback());
            intent.putExtra("b_color", getButtonColor());
            intent.putExtra("skip_title", getSkipText());
            intent.putExtra("creative", getCreative());
        } catch (Throwable th) {
            a.a("Interstitial$getActivityIntent", th);
        }
        return intent;
    }

    public boolean isAdLoaded() {
        try {
            return !getPlacementID().equals("") && a.C().f(this);
        } catch (Throwable th) {
            a.a("Interstitial$isAdLoaded", th);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public SettingsManager getConfig() {
        return c.E();
    }

    private void loadConfig() {
        getConfig().g(ScarConstants.TOKEN_ID_KEY, getTID());
        getConfig().a(this.context, getPlacementID(), new SettingsManager.ConfigCallback() {
            public final void loaded(HashMap<String, Object> hashMap) {
                try {
                    Interstitial.this.configLoaded = true;
                    if (Interstitial.this.calledShow) {
                        Interstitial.this.showAd();
                    }
                } catch (Throwable th) {
                    a.a("Interstitial$loadConfig", th);
                }
            }

            public final void error(String str) {
                try {
                    Interstitial.this.configLoaded = true;
                    if (Interstitial.this.calledShow) {
                        Interstitial.this.showAd();
                    }
                } catch (Throwable th) {
                    a.a("Interstitial$error", th);
                }
            }
        });
    }

    public void setOnAdErrorCallback(OnAdError onAdError) {
        if (onAdError != null) {
            try {
                AnonymousClass6 r0 = new OnAdError() {
                    public final void adError(String str) {
                        String str2;
                        OnAdError onAdError;
                        str.hashCode();
                        char c = 65535;
                        switch (str.hashCode()) {
                            case -2026653947:
                                if (str.equals(AppnextError.INTERNAL_ERROR)) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case -1958363695:
                                if (str.equals(AppnextError.NO_ADS)) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case -1477010874:
                                if (str.equals(AppnextError.CONNECTION_ERROR)) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case -507110949:
                                if (str.equals(AppnextError.NO_MARKET)) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 297538105:
                                if (str.equals(AdsError.AD_NOT_READY)) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case 350741825:
                                if (str.equals("Timeout")) {
                                    c = 5;
                                    break;
                                }
                                break;
                            case 844170097:
                                if (str.equals(AppnextError.SLOW_CONNECTION)) {
                                    c = 6;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                str2 = "error_internal_error";
                                break;
                            case 1:
                                str2 = "error_no_ads";
                                break;
                            case 2:
                                str2 = "error_connection_error";
                                break;
                            case 3:
                                str2 = "error_no_market";
                                break;
                            case 4:
                                str2 = "error_ad_not_ready";
                                break;
                            case 5:
                                str2 = "error_timeout";
                                break;
                            case 6:
                                str2 = "error_slow_connection";
                                break;
                            default:
                                str2 = "";
                                break;
                        }
                        g.a(Interstitial.this.context, Interstitial.this.getTID(), Interstitial.this.getVID(), Interstitial.this.getAUID(), Interstitial.this.getPlacementID(), Interstitial.this.getSessionId(), str2, "current_interstitial", "", "");
                        if (Interstitial.this.userOnAdErrorWR != null && (onAdError = (OnAdError) Interstitial.this.userOnAdErrorWR.get()) != null) {
                            onAdError.adError(str);
                        }
                    }
                };
                this.internalOnAdError = r0;
                super.setOnAdErrorCallback(r0);
                this.userOnAdErrorWR = new WeakReference<>(onAdError);
            } catch (Throwable th) {
                a.a("Interstitial$setOnAdErrorCallback", th);
            }
        }
    }

    public OnAdError getOnAdErrorCallback() {
        return super.getOnAdErrorCallback();
    }

    public void setCreativeType(String str) {
        if (str != null) {
            try {
                if (!str.equals(TYPE_MANAGED) && !str.equals("static")) {
                    if (!str.equals("video")) {
                        throw new IllegalArgumentException("Wrong creative type");
                    }
                }
                this.creativeType = str;
            } catch (Throwable th) {
                a.a("Interstitial$setCreativeType", th);
            }
        } else {
            throw new IllegalArgumentException("Wrong creative type");
        }
    }

    public String getCreativeType() {
        return this.creativeType;
    }

    @Deprecated
    public void setBackButtonCanClose(boolean z) {
        this.setCanClose = true;
        this.canClose = Boolean.valueOf(z);
    }

    @Deprecated
    public boolean isBackButtonCanClose() {
        Boolean bool = this.canClose;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean isAutoPlay() {
        return this.autoPlay;
    }

    public void setAutoPlay(boolean z) {
        this.setAutoPlay = true;
        this.autoPlay = z;
    }

    public void setSkipText(String str) {
        if (str == null) {
            str = "";
        }
        this.skipText = str;
    }

    public String getSkipText() {
        return this.skipText;
    }

    public String getButtonColor() {
        return this.buttonColor;
    }

    public void setButtonColor(String str) {
        if (str == null || str.equals("")) {
            this.buttonColor = "";
            return;
        }
        if (!str.startsWith("#")) {
            str = "#" + str;
        }
        try {
            Color.parseColor(str);
            this.buttonColor = str;
        } catch (Throwable unused) {
            throw new IllegalArgumentException("Unknown color");
        }
    }

    private boolean hasVideo(AppnextAd appnextAd) {
        return !appnextAd.getVideoUrl().equals("") || !appnextAd.getVideoUrlHigh().equals("") || !appnextAd.getVideoUrl30Sec().equals("") || !appnextAd.getVideoUrlHigh30Sec().equals("");
    }

    public void setParams(String str, String str2) {
        getConfig().i(str, str2);
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    /* access modifiers changed from: protected */
    public String getSessionId() {
        return super.getSessionId();
    }

    /* access modifiers changed from: protected */
    public com.appnext.core.webview.a getFallback() {
        return new b();
    }

    public void destroy() {
        super.destroy();
        currentAd = null;
    }
}
