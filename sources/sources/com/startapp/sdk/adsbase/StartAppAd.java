package com.startapp.sdk.adsbase;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.startapp.d2;
import com.startapp.f2;
import com.startapp.g;
import com.startapp.h;
import com.startapp.h0;
import com.startapp.i;
import com.startapp.i3;
import com.startapp.ia;
import com.startapp.j;
import com.startapp.k;
import com.startapp.k9;
import com.startapp.sdk.ads.interstitials.OverlayActivity;
import com.startapp.sdk.ads.splash.SplashConfig;
import com.startapp.sdk.ads.splash.SplashHideListener;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason;
import com.startapp.sdk.adsbase.adlisteners.VideoListener;
import com.startapp.sdk.adsbase.adrules.AdRulesResult;
import com.startapp.sdk.adsbase.c;
import com.startapp.sdk.adsbase.cache.CacheKey;
import com.startapp.sdk.adsbase.cache.d;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.w4;
import java.io.Serializable;

/* compiled from: Sta */
public class StartAppAd extends Ad {
    private static final long serialVersionUID = 5570787449025156740L;
    public d ad = null;
    /* access modifiers changed from: private */
    public CacheKey adKey = null;
    private AdMode adMode = AdMode.AUTOMATIC;
    private AdPreferences adPreferences = null;
    public AdDisplayListener callback = null;
    private final BroadcastReceiver callbackBroadcastReceiver = new a();
    public VideoListener videoListener = null;

    /* compiled from: Sta */
    public enum AdMode {
        AUTOMATIC,
        FULLPAGE,
        OFFERWALL,
        REWARDED_VIDEO,
        VIDEO,
        OVERLAY
    }

    /* compiled from: Sta */
    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            g gVar;
            ia iaVar;
            i iVar;
            h hVar;
            String action = intent.getAction();
            if (action == null) {
                action = "";
            }
            String stringExtra = intent.getStringExtra("dParam");
            if (action.equals("com.startapp.android.ShowFailedDisplayBroadcastListener")) {
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    extras = Bundle.EMPTY;
                }
                if (extras.containsKey("showFailedReason")) {
                    StartAppAd.this.a((NotDisplayedReason) extras.getSerializable("showFailedReason"));
                }
                StartAppAd startAppAd = StartAppAd.this;
                j.a(context, startAppAd.callback, startAppAd);
                w4.a(context).a((BroadcastReceiver) this);
            } else {
                boolean z = true;
                if (action.equals("com.startapp.android.ShowDisplayBroadcastListener")) {
                    StartAppAd startAppAd2 = StartAppAd.this;
                    AdDisplayListener adDisplayListener = startAppAd2.callback;
                    if (adDisplayListener == null) {
                        z = false;
                    }
                    d2.a("onShow", z, stringExtra, (String) null);
                    if (adDisplayListener == null) {
                        hVar = null;
                    } else {
                        hVar = new h(adDisplayListener, startAppAd2, context);
                    }
                    a.a((Runnable) hVar);
                } else if (action.equals("com.startapp.android.OnClickCallback")) {
                    StartAppAd startAppAd3 = StartAppAd.this;
                    AdDisplayListener adDisplayListener2 = startAppAd3.callback;
                    if (adDisplayListener2 == null) {
                        z = false;
                    }
                    d2.a("onClicked", z, stringExtra, (String) null);
                    if (adDisplayListener2 == null) {
                        iVar = null;
                    } else {
                        iVar = new i(adDisplayListener2, startAppAd3, context);
                    }
                    a.a((Runnable) iVar);
                } else if (action.equals("com.startapp.android.OnVideoCompleted")) {
                    VideoListener videoListener = StartAppAd.this.videoListener;
                    if (videoListener == null) {
                        z = false;
                    }
                    d2.a("onVideoCompleted", z, stringExtra, (String) null);
                    if (videoListener == null) {
                        iaVar = null;
                    } else {
                        iaVar = new ia(videoListener, context);
                    }
                    a.a((Runnable) iaVar);
                } else {
                    StartAppAd startAppAd4 = StartAppAd.this;
                    AdDisplayListener adDisplayListener3 = startAppAd4.callback;
                    if (adDisplayListener3 == null) {
                        z = false;
                    }
                    d2.a("adHidden", z, stringExtra, (String) null);
                    if (adDisplayListener3 == null) {
                        gVar = null;
                    } else {
                        gVar = new g(adDisplayListener3, startAppAd4, context);
                    }
                    a.a((Runnable) gVar);
                    w4.a(context).a((BroadcastReceiver) this);
                }
            }
            StartAppAd.this.ad = null;
        }
    }

    /* compiled from: Sta */
    public class b implements d.C0000d {
        public final /* synthetic */ AdEventListener a;

        public b(AdEventListener adEventListener) {
            this.a = adEventListener;
        }

        public void a(Ad ad, CacheKey cacheKey, boolean z) {
            CacheKey unused = StartAppAd.this.adKey = cacheKey;
            AdEventListener adEventListener = this.a;
            if (adEventListener == null) {
                return;
            }
            if (!z || ad == null) {
                adEventListener.onFailedToReceiveAd(ad);
            } else {
                adEventListener.onReceiveAd(ad);
            }
        }
    }

    /* compiled from: Sta */
    public class c implements d.C0000d {
        public final /* synthetic */ d.C0000d a;

        public c(d.C0000d dVar) {
            this.a = dVar;
        }

        public void a(Ad ad, CacheKey cacheKey, boolean z) {
            CacheKey unused = StartAppAd.this.adKey = cacheKey;
            d.C0000d dVar = this.a;
            if (dVar != null) {
                dVar.a(ad, cacheKey, z);
            }
        }
    }

    /* compiled from: Sta */
    public class d extends BroadcastReceiver {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ SplashHideListener b;

        public d(Activity activity, SplashHideListener splashHideListener) {
            this.a = activity;
            this.b = splashHideListener;
        }

        public void onReceive(Context context, Intent intent) {
            k9.a(this.a, false);
            SplashHideListener splashHideListener = this.b;
            if (splashHideListener != null) {
                splashHideListener.splashHidden();
            }
            w4.a((Context) this.a).a((BroadcastReceiver) this);
        }
    }

    /* compiled from: Sta */
    public static /* synthetic */ class e {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.startapp.sdk.adsbase.StartAppAd$AdMode[] r0 = com.startapp.sdk.adsbase.StartAppAd.AdMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.startapp.sdk.adsbase.StartAppAd$AdMode r1 = com.startapp.sdk.adsbase.StartAppAd.AdMode.FULLPAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.startapp.sdk.adsbase.StartAppAd$AdMode r1 = com.startapp.sdk.adsbase.StartAppAd.AdMode.OFFERWALL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.startapp.sdk.adsbase.StartAppAd$AdMode r1 = com.startapp.sdk.adsbase.StartAppAd.AdMode.OVERLAY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.startapp.sdk.adsbase.StartAppAd$AdMode r1 = com.startapp.sdk.adsbase.StartAppAd.AdMode.REWARDED_VIDEO     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.StartAppAd.e.<clinit>():void");
        }
    }

    public StartAppAd(Context context) {
        super(context, (AdPreferences.Placement) null);
        try {
            ComponentLocator.a(context).t().a(8192);
        } catch (Throwable unused) {
        }
    }

    public static void disableAutoInterstitial() {
        c.a.a.a = false;
    }

    public static void disableSplash() {
        Object obj = StartAppSDKInternal.E;
        StartAppSDKInternal.d.a.x = true;
        com.startapp.sdk.adsbase.cache.d.h.b(AdPreferences.Placement.INAPP_SPLASH);
    }

    public static void enableAutoInterstitial() {
        c.a.a.a = true;
    }

    public static void enableConsent(Context context, boolean z) {
        ComponentLocator.a(context).g().e = z;
    }

    public static void init(Context context, String str, String str2) {
        StartAppSDK.init(context, str, str2);
    }

    public static void setAutoInterstitialPreferences(AutoInterstitialPreferences autoInterstitialPreferences) {
        c cVar = c.a.a;
        cVar.b = autoInterstitialPreferences;
        cVar.c = -1;
        cVar.d = -1;
    }

    public static void setCommonAdsPreferences(Context context, SDKAdPreferences sDKAdPreferences) {
        Context a2 = h0.a(context);
        if (a2 != null) {
            Object obj = StartAppSDKInternal.E;
            StartAppSDKInternal.d.a.a = sDKAdPreferences;
            f2.b(a2, "shared_prefs_sdk_ad_prefs", sDKAdPreferences);
        }
    }

    public static void setReturnAdsPreferences(AdPreferences adPreferences2) {
        Object obj = StartAppSDKInternal.E;
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.d.a;
        boolean z = !k9.a(startAppSDKInternal.s, adPreferences2);
        startAppSDKInternal.s = adPreferences2 != null ? new AdPreferences(adPreferences2) : null;
        if (z) {
            com.startapp.sdk.adsbase.cache.d dVar = com.startapp.sdk.adsbase.cache.d.h;
            AdPreferences.Placement placement = AdPreferences.Placement.INAPP_RETURN;
            if (!dVar.d) {
                synchronized (dVar.a) {
                    for (com.startapp.sdk.adsbase.cache.h next : dVar.a.values()) {
                        if (next.a == placement) {
                            next.b();
                        }
                    }
                }
            }
        }
    }

    public static void showSplash(Activity activity, Bundle bundle) {
        showSplash(activity, bundle, new SplashConfig());
    }

    public void a(AdPreferences adPreferences2, AdEventListener adEventListener) {
    }

    public void close() {
        w4.a(this.a).a(this.callbackBroadcastReceiver);
        w4.a(this.a).a(new Intent("com.startapp.android.CloseAdActivity"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r3.adKey;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.startapp.sdk.adsbase.model.AdPreferences.Placement f() {
        /*
            r3 = this;
            com.startapp.sdk.adsbase.model.AdPreferences$Placement r0 = r3.placement
            if (r0 != 0) goto L_0x001e
            com.startapp.sdk.adsbase.cache.CacheKey r1 = r3.adKey
            if (r1 == 0) goto L_0x001e
            com.startapp.sdk.adsbase.cache.d r2 = com.startapp.sdk.adsbase.cache.d.h
            com.startapp.sdk.adsbase.d r1 = r2.a((com.startapp.sdk.adsbase.cache.CacheKey) r1)
            if (r1 == 0) goto L_0x001e
            com.startapp.sdk.adsbase.cache.d r0 = com.startapp.sdk.adsbase.cache.d.h
            com.startapp.sdk.adsbase.cache.CacheKey r1 = r3.adKey
            com.startapp.sdk.adsbase.d r0 = r0.a((com.startapp.sdk.adsbase.cache.CacheKey) r1)
            com.startapp.sdk.adsbase.Ad r0 = (com.startapp.sdk.adsbase.Ad) r0
            com.startapp.sdk.adsbase.model.AdPreferences$Placement r0 = r0.f()
        L_0x001e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.StartAppAd.f():com.startapp.sdk.adsbase.model.AdPreferences$Placement");
    }

    public String getAdId() {
        d a2 = com.startapp.sdk.adsbase.cache.d.h.a(this.adKey);
        if (a2 instanceof HtmlAd) {
            return ((HtmlAd) a2).getAdId();
        }
        return null;
    }

    public String getBidToken() {
        d a2 = com.startapp.sdk.adsbase.cache.d.h.a(this.adKey);
        if (a2 instanceof HtmlAd) {
            return ((HtmlAd) a2).getBidToken();
        }
        return null;
    }

    public Ad.AdState getState() {
        d a2 = com.startapp.sdk.adsbase.cache.d.h.a(this.adKey);
        if (a2 != null) {
            return a2.getState();
        }
        return Ad.AdState.UN_INITIALIZED;
    }

    public boolean isBelowMinCPM() {
        d a2 = com.startapp.sdk.adsbase.cache.d.h.a(this.adKey);
        if (a2 != null) {
            return a2.isBelowMinCPM();
        }
        return false;
    }

    public boolean isNetworkAvailable() {
        return k9.g(this.a);
    }

    public boolean isReady() {
        d a2 = com.startapp.sdk.adsbase.cache.d.h.a(this.adKey);
        if (a2 != null) {
            return a2.isReady();
        }
        return false;
    }

    @Deprecated
    public void load(AdPreferences adPreferences2, AdEventListener adEventListener) {
        if (MetaData.k.b()) {
            if (adPreferences2 == null) {
                adPreferences2 = new AdPreferences();
            }
            AdPreferences adPreferences3 = adPreferences2;
            if (adPreferences3.getPlacementId() == null) {
                adPreferences3.setPlacementId(a.a(this.a, (Object) this));
            }
            com.startapp.sdk.adsbase.cache.d.h.a(this.a, this, this.adMode, adPreferences3, (d.C0000d) new b(adEventListener));
        } else if (adEventListener != null) {
            setErrorMessage("serving ads disabled");
            k.a(this.a, adEventListener, this, false);
        }
    }

    public void loadAd() {
        loadAd(AdMode.AUTOMATIC, new AdPreferences(), (AdEventListener) null);
    }

    public void loadSplash(AdPreferences adPreferences2, d.C0000d dVar) {
        com.startapp.sdk.adsbase.cache.d dVar2 = com.startapp.sdk.adsbase.cache.d.h;
        Context context = this.a;
        c cVar = new c(dVar);
        AdPreferences.Placement placement = AdPreferences.Placement.INAPP_SPLASH;
        if (dVar2.a(placement)) {
            dVar2.a(context, this, placement, adPreferences2, cVar, false, 0);
        } else {
            cVar.a((Ad) null, (CacheKey) null, false);
        }
    }

    public void onBackPressed() {
        showAd("exit_ad");
        Object obj = StartAppSDKInternal.E;
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.d.a;
        startAppSDKInternal.d = false;
        startAppSDKInternal.f = true;
    }

    public void onPause() {
    }

    public void onRestoreInstanceState(Bundle bundle) {
        int i = bundle.getInt("AdMode");
        this.adMode = AdMode.AUTOMATIC;
        if (i == 1) {
            this.adMode = AdMode.FULLPAGE;
        } else if (i == 2) {
            this.adMode = AdMode.OFFERWALL;
        } else if (i == 3) {
            this.adMode = AdMode.OVERLAY;
        } else if (i == 4) {
            this.adMode = AdMode.REWARDED_VIDEO;
        } else if (i == 5) {
            this.adMode = AdMode.VIDEO;
        }
        Serializable serializable = bundle.getSerializable("AdPrefs");
        if (serializable != null) {
            this.adPreferences = (AdPreferences) serializable;
        }
    }

    public void onResume() {
        if (!isReady()) {
            loadAd();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        int i = e.a[this.adMode.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    i2 = 4;
                    if (i != 4) {
                        i2 = 0;
                    }
                }
            }
        }
        AdPreferences adPreferences2 = this.adPreferences;
        if (adPreferences2 != null) {
            bundle.putSerializable("AdPrefs", adPreferences2);
        }
        bundle.putInt("AdMode", i2);
    }

    public void setVideoListener(VideoListener videoListener2) {
        this.videoListener = videoListener2;
    }

    public boolean showAd() {
        return showAd((String) null, (AdDisplayListener) null);
    }

    public static void showSplash(Activity activity, Bundle bundle, SplashConfig splashConfig) {
        showSplash(activity, bundle, splashConfig, new AdPreferences());
    }

    public AdRulesResult a(String str, AdPreferences.Placement placement) {
        return AdsCommonMetaData.h.b().a(placement, str);
    }

    public void loadAd(AdPreferences adPreferences2) {
        loadAd(AdMode.AUTOMATIC, adPreferences2, (AdEventListener) null);
    }

    @Deprecated
    public boolean showAd(String str) {
        return showAd(str, (AdDisplayListener) null);
    }

    public static void showSplash(Activity activity, Bundle bundle, AdPreferences adPreferences2) {
        showSplash(activity, bundle, new SplashConfig(), adPreferences2);
    }

    public void loadAd(AdEventListener adEventListener) {
        loadAd(AdMode.AUTOMATIC, new AdPreferences(), adEventListener);
    }

    public boolean showAd(AdDisplayListener adDisplayListener) {
        return showAd((String) null, adDisplayListener);
    }

    public static void showSplash(Activity activity, Bundle bundle, SplashConfig splashConfig, AdPreferences adPreferences2) {
        showSplash(activity, bundle, splashConfig, adPreferences2, (SplashHideListener) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:80:0x016b, code lost:
        if (r14 == false) goto L_0x016e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r13, com.startapp.sdk.adsbase.adlisteners.AdDisplayListener r14) {
        /*
            r12 = this;
            android.content.Context r0 = r12.a
            com.startapp.sdk.components.ComponentLocator r0 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r0)
            com.startapp.g7 r1 = r0.t()     // Catch:{ all -> 0x0011 }
            r2 = 32768(0x8000, float:4.5918E-41)
            r1.a((int) r2)     // Catch:{ all -> 0x0011 }
            goto L_0x0012
        L_0x0011:
        L_0x0012:
            r1 = 0
            r12.a((com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason) r1)
            r12.callback = r14
            com.startapp.sdk.adsbase.remoteconfig.MetaData r14 = com.startapp.sdk.adsbase.remoteconfig.MetaData.k
            boolean r14 = r14.b()
            r2 = 0
            if (r14 != 0) goto L_0x002e
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r13 = com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason.SERVING_ADS_DISABLED
            r12.a((com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason) r13)
            android.content.Context r13 = r12.a
            com.startapp.sdk.adsbase.adlisteners.AdDisplayListener r14 = r12.callback
            com.startapp.j.a(r13, r14, r12)
            return r2
        L_0x002e:
            com.startapp.sdk.adsbase.cache.CacheKey r14 = r12.adKey
            if (r14 != 0) goto L_0x0039
            com.startapp.sdk.adsbase.StartAppAd$AdMode r14 = r12.adMode
            com.startapp.sdk.adsbase.model.AdPreferences r3 = r12.adPreferences
            r12.loadAd((com.startapp.sdk.adsbase.StartAppAd.AdMode) r14, (com.startapp.sdk.adsbase.model.AdPreferences) r3)
        L_0x0039:
            com.startapp.sdk.adsbase.AdsCommonMetaData r14 = com.startapp.sdk.adsbase.AdsCommonMetaData.h
            boolean r14 = r14.O()
            r3 = 1
            if (r14 == 0) goto L_0x004d
            android.content.Context r14 = r12.a
            boolean r14 = com.startapp.k9.e((android.content.Context) r14)
            if (r14 == 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r14 = 0
            goto L_0x004e
        L_0x004d:
            r14 = 1
        L_0x004e:
            if (r14 == 0) goto L_0x017e
            boolean r14 = r12.isNetworkAvailable()
            if (r14 == 0) goto L_0x0178
            boolean r14 = r12.isReady()
            if (r14 == 0) goto L_0x0114
            com.startapp.sdk.adsbase.model.AdPreferences$Placement r14 = r12.f()
            com.startapp.sdk.adsbase.adrules.AdRulesResult r4 = r12.a((java.lang.String) r13, (com.startapp.sdk.adsbase.model.AdPreferences.Placement) r14)
            boolean r5 = r4.b()
            if (r5 == 0) goto L_0x010b
            com.startapp.sdk.adsbase.cache.d r5 = com.startapp.sdk.adsbase.cache.d.h
            com.startapp.sdk.adsbase.cache.CacheKey r6 = r12.adKey
            com.startapp.sdk.adsbase.d r5 = r5.c(r6)
            r12.ad = r5
            if (r5 == 0) goto L_0x0110
            com.startapp.sdk.adsbase.model.AdPreferences$Placement r6 = r12.placement
            com.startapp.sdk.adsbase.model.AdPreferences$Placement r7 = com.startapp.sdk.adsbase.model.AdPreferences.Placement.INAPP_SPLASH
            if (r6 != r7) goto L_0x0094
            java.lang.Object r6 = com.startapp.sdk.adsbase.StartAppSDKInternal.E
            com.startapp.sdk.adsbase.StartAppSDKInternal r6 = com.startapp.sdk.adsbase.StartAppSDKInternal.d.a
            boolean r8 = r6.c
            if (r8 == 0) goto L_0x008a
            boolean r6 = r6.d
            if (r6 == 0) goto L_0x008a
            r6 = 1
            goto L_0x008b
        L_0x008a:
            r6 = 0
        L_0x008b:
            if (r6 == 0) goto L_0x0094
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r14 = com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason.APP_IN_BACKGROUND
            r12.a((com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason) r14)
            goto L_0x0110
        L_0x0094:
            boolean r5 = r5.a((java.lang.String) r13)
            if (r5 == 0) goto L_0x00ee
            com.startapp.f r6 = com.startapp.f.d
            com.startapp.e r8 = new com.startapp.e
            r8.<init>(r14, r13)
            r6.a(r8)
            com.startapp.sdk.adsbase.StartAppAd$AdMode r14 = r12.adMode
            if (r14 == 0) goto L_0x00bc
            com.startapp.sdk.adsbase.model.AdPreferences$Placement r14 = r12.placement
            if (r14 == r7) goto L_0x00bc
            com.startapp.sdk.adsbase.model.AdPreferences r14 = r12.adPreferences
            if (r14 == 0) goto L_0x00bd
            com.startapp.sdk.adsbase.model.AdPreferences r6 = new com.startapp.sdk.adsbase.model.AdPreferences
            r6.<init>()
            boolean r14 = r14.equals(r6)
            if (r14 == 0) goto L_0x00bc
            goto L_0x00bd
        L_0x00bc:
            r3 = 0
        L_0x00bd:
            if (r3 == 0) goto L_0x00fd
            com.startapp.sdk.adsbase.cache.d r14 = com.startapp.sdk.adsbase.cache.d.h
            com.startapp.sdk.adsbase.StartAppAd$AdMode r14 = r12.adMode
            java.lang.String r14 = com.startapp.sdk.adsbase.cache.d.a((com.startapp.sdk.adsbase.StartAppAd.AdMode) r14)
            com.startapp.sdk.adsbase.e r0 = r0.e()
            com.startapp.sdk.adsbase.e$a r0 = r0.edit()
            r0.a((java.lang.String) r14, (int) r2)
            com.startapp.sdk.adsbase.StartAppAd$AdMode r14 = r12.adMode
            com.startapp.sdk.adsbase.StartAppAd$AdMode r3 = com.startapp.sdk.adsbase.StartAppAd.AdMode.AUTOMATIC
            if (r14 != r3) goto L_0x00ea
            com.startapp.sdk.adsbase.StartAppAd$AdMode r14 = com.startapp.sdk.adsbase.StartAppAd.AdMode.FULLPAGE
            java.lang.String r14 = com.startapp.sdk.adsbase.cache.d.a((com.startapp.sdk.adsbase.StartAppAd.AdMode) r14)
            r0.a((java.lang.String) r14, (int) r2)
            com.startapp.sdk.adsbase.StartAppAd$AdMode r14 = com.startapp.sdk.adsbase.StartAppAd.AdMode.OFFERWALL
            java.lang.String r14 = com.startapp.sdk.adsbase.cache.d.a((com.startapp.sdk.adsbase.StartAppAd.AdMode) r14)
            r0.a((java.lang.String) r14, (int) r2)
        L_0x00ea:
            r0.apply()
            goto L_0x00fd
        L_0x00ee:
            com.startapp.sdk.adsbase.d r14 = r12.ad
            boolean r0 = r14 instanceof com.startapp.sdk.adsbase.Ad
            if (r0 == 0) goto L_0x00fd
            com.startapp.sdk.adsbase.Ad r14 = (com.startapp.sdk.adsbase.Ad) r14
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r14 = r14.getNotDisplayedReason()
            r12.a((com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason) r14)
        L_0x00fd:
            boolean r14 = com.startapp.sdk.adsbase.cache.CacheMetaData.d()
            if (r14 == 0) goto L_0x0111
            com.startapp.sdk.adsbase.StartAppAd$AdMode r14 = r12.adMode
            com.startapp.sdk.adsbase.model.AdPreferences r0 = r12.adPreferences
            r12.loadAd(r14, r0, r1)
            goto L_0x0111
        L_0x010b:
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r14 = com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason.AD_RULES
            r12.a((com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason) r14)
        L_0x0110:
            r5 = 0
        L_0x0111:
            r3 = 0
            goto L_0x0186
        L_0x0114:
            com.startapp.sdk.adsbase.StartAppAd$AdMode r14 = r12.adMode
            com.startapp.sdk.adsbase.StartAppAd$AdMode r0 = com.startapp.sdk.adsbase.StartAppAd.AdMode.REWARDED_VIDEO
            if (r14 == r0) goto L_0x016e
            com.startapp.sdk.adsbase.StartAppAd$AdMode r0 = com.startapp.sdk.adsbase.StartAppAd.AdMode.VIDEO
            if (r14 == r0) goto L_0x016e
            com.startapp.sdk.adsbase.remoteconfig.MetaData r14 = com.startapp.sdk.adsbase.remoteconfig.MetaData.k
            boolean r14 = r14.b()
            if (r14 == 0) goto L_0x016a
            com.startapp.sdk.adsbase.AdsCommonMetaData r14 = com.startapp.sdk.adsbase.AdsCommonMetaData.h
            com.startapp.sdk.adsbase.VideoConfig r14 = r14.G()
            boolean r14 = r14.q()
            if (r14 != 0) goto L_0x0133
            goto L_0x016a
        L_0x0133:
            com.startapp.sdk.adsbase.model.AdPreferences r14 = r12.adPreferences
            if (r14 != 0) goto L_0x013c
            com.startapp.sdk.adsbase.model.AdPreferences r14 = new com.startapp.sdk.adsbase.model.AdPreferences
            r14.<init>()
        L_0x013c:
            com.startapp.sdk.adsbase.Ad$AdType r0 = com.startapp.sdk.adsbase.Ad.AdType.NON_VIDEO
            r14.setType(r0)
            com.startapp.sdk.adsbase.model.AdPreferences$Placement r0 = r12.f()
            com.startapp.sdk.adsbase.cache.d r4 = com.startapp.sdk.adsbase.cache.d.h
            com.startapp.sdk.adsbase.cache.CacheKey r5 = new com.startapp.sdk.adsbase.cache.CacheKey
            r5.<init>(r0, r14)
            com.startapp.sdk.adsbase.d r14 = r4.a((com.startapp.sdk.adsbase.cache.CacheKey) r5)
            if (r14 == 0) goto L_0x016a
            boolean r4 = r14.isReady()
            if (r4 == 0) goto L_0x016a
            com.startapp.sdk.adsbase.adrules.AdRulesResult r0 = r12.a((java.lang.String) r13, (com.startapp.sdk.adsbase.model.AdPreferences.Placement) r0)
            boolean r0 = r0.b()
            if (r0 == 0) goto L_0x016a
            r14.a((boolean) r3)
            boolean r14 = r14.a((java.lang.String) r13)
            goto L_0x016b
        L_0x016a:
            r14 = 0
        L_0x016b:
            if (r14 == 0) goto L_0x016e
            goto L_0x016f
        L_0x016e:
            r3 = 0
        L_0x016f:
            if (r3 != 0) goto L_0x0176
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r14 = com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason.AD_NOT_READY
            r12.a((com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason) r14)
        L_0x0176:
            r4 = r1
            goto L_0x0185
        L_0x0178:
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r14 = com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason.NETWORK_PROBLEM
            r12.a((com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason) r14)
            goto L_0x0183
        L_0x017e:
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r14 = com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason.APP_IN_BACKGROUND
            r12.a((com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason) r14)
        L_0x0183:
            r4 = r1
            r3 = 0
        L_0x0185:
            r5 = 0
        L_0x0186:
            if (r5 != 0) goto L_0x018a
            if (r3 == 0) goto L_0x01e4
        L_0x018a:
            android.content.Context r14 = r12.a
            com.startapp.w4 r14 = com.startapp.w4.a((android.content.Context) r14)
            android.content.BroadcastReceiver r0 = r12.callbackBroadcastReceiver
            android.content.IntentFilter r6 = new android.content.IntentFilter
            java.lang.String r7 = "com.startapp.android.HideDisplayBroadcastListener"
            r6.<init>(r7)
            r14.a(r0, r6)
            android.content.Context r14 = r12.a
            com.startapp.w4 r14 = com.startapp.w4.a((android.content.Context) r14)
            android.content.BroadcastReceiver r0 = r12.callbackBroadcastReceiver
            android.content.IntentFilter r6 = new android.content.IntentFilter
            java.lang.String r7 = "com.startapp.android.ShowDisplayBroadcastListener"
            r6.<init>(r7)
            r14.a(r0, r6)
            android.content.Context r14 = r12.a
            com.startapp.w4 r14 = com.startapp.w4.a((android.content.Context) r14)
            android.content.BroadcastReceiver r0 = r12.callbackBroadcastReceiver
            android.content.IntentFilter r6 = new android.content.IntentFilter
            java.lang.String r7 = "com.startapp.android.ShowFailedDisplayBroadcastListener"
            r6.<init>(r7)
            r14.a(r0, r6)
            android.content.Context r14 = r12.a
            com.startapp.w4 r14 = com.startapp.w4.a((android.content.Context) r14)
            android.content.BroadcastReceiver r0 = r12.callbackBroadcastReceiver
            android.content.IntentFilter r6 = new android.content.IntentFilter
            java.lang.String r7 = "com.startapp.android.OnClickCallback"
            r6.<init>(r7)
            r14.a(r0, r6)
            android.content.Context r14 = r12.a
            com.startapp.w4 r14 = com.startapp.w4.a((android.content.Context) r14)
            android.content.BroadcastReceiver r0 = r12.callbackBroadcastReceiver
            android.content.IntentFilter r6 = new android.content.IntentFilter
            java.lang.String r7 = "com.startapp.android.OnVideoCompleted"
            r6.<init>(r7)
            r14.a(r0, r6)
        L_0x01e4:
            if (r5 != 0) goto L_0x022f
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r14 = r12.getNotDisplayedReason()
            if (r14 != 0) goto L_0x01f1
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r14 = com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason.INTERNAL_ERROR
            r12.a((com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason) r14)
        L_0x01f1:
            com.startapp.sdk.adsbase.cache.d r0 = com.startapp.sdk.adsbase.cache.d.h
            com.startapp.sdk.adsbase.cache.CacheKey r6 = r12.adKey
            com.startapp.sdk.adsbase.d r0 = r0.a((com.startapp.sdk.adsbase.cache.CacheKey) r6)
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r6 = com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason.AD_RULES
            if (r14 == r6) goto L_0x0217
            if (r3 == 0) goto L_0x0201
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r14 = com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason.AD_NOT_READY_VIDEO_FALLBACK
        L_0x0201:
            android.content.Context r6 = r12.a
            com.startapp.sdk.adsbase.d r2 = r12.ad
            if (r2 == 0) goto L_0x0208
            r0 = r2
        L_0x0208:
            java.lang.String[] r7 = com.startapp.sdk.adsbase.a.a((com.startapp.sdk.adsbase.d) r0)
            java.lang.String r10 = r14.toString()
            r9 = 0
            r11 = 0
            r8 = r13
            com.startapp.sdk.adsbase.a.a((android.content.Context) r6, (java.lang.String[]) r7, (java.lang.String) r8, (int) r9, (java.lang.String) r10, (org.json.JSONObject) r11)
            goto L_0x0224
        L_0x0217:
            if (r4 == 0) goto L_0x0224
            java.lang.String[] r14 = com.startapp.sdk.adsbase.a.a((com.startapp.sdk.adsbase.d) r0)
            java.lang.String r0 = r4.a()
            com.startapp.sdk.adsbase.a.a((java.lang.String[]) r14, (java.lang.String) r13, (int) r2, (java.lang.String) r0)
        L_0x0224:
            r12.ad = r1
            if (r3 != 0) goto L_0x022f
            android.content.Context r13 = r12.a
            com.startapp.sdk.adsbase.adlisteners.AdDisplayListener r14 = r12.callback
            com.startapp.j.a(r13, r14, r12)
        L_0x022f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.StartAppAd.a(java.lang.String, com.startapp.sdk.adsbase.adlisteners.AdDisplayListener):boolean");
    }

    public void loadAd(AdPreferences adPreferences2, AdEventListener adEventListener) {
        loadAd(AdMode.AUTOMATIC, adPreferences2, adEventListener);
    }

    public boolean showAd(@Deprecated String str, AdDisplayListener adDisplayListener) {
        try {
            return a(str, adDisplayListener);
        } catch (Throwable th) {
            i3.a(th);
            a(NotDisplayedReason.INTERNAL_ERROR);
            j.a(this.a, this.callback, (Ad) null);
            return false;
        }
    }

    public static void showSplash(Activity activity, Bundle bundle, SplashConfig splashConfig, AdPreferences adPreferences2, SplashHideListener splashHideListener) {
        a(activity, bundle, splashConfig, adPreferences2, splashHideListener, true);
    }

    public void loadAd(AdMode adMode2) {
        loadAd(adMode2, new AdPreferences(), (AdEventListener) null);
    }

    public static void onBackPressed(Context context) {
        new StartAppAd(context).onBackPressed();
    }

    public void loadAd(AdMode adMode2, AdPreferences adPreferences2) {
        loadAd(adMode2, adPreferences2, (AdEventListener) null);
    }

    public void loadAd(AdMode adMode2, AdEventListener adEventListener) {
        loadAd(adMode2, new AdPreferences(), adEventListener);
    }

    public void loadAd(AdMode adMode2, AdPreferences adPreferences2, AdEventListener adEventListener) {
        try {
            ComponentLocator.a(this.a).t().a(16384);
        } catch (Throwable unused) {
        }
        this.adMode = adMode2;
        this.adPreferences = adPreferences2;
        try {
            load(adPreferences2, adEventListener);
        } catch (Throwable th) {
            i3.a(th);
            if (adEventListener != null) {
                k.a(this.a, adEventListener, this, false);
            }
        }
    }

    public static boolean showAd(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return new StartAppAd(context).showAd();
        } catch (Throwable th) {
            i3.a(th);
            return false;
        }
    }

    public static void a(Activity activity, Bundle bundle, SplashConfig splashConfig, AdPreferences adPreferences2, SplashHideListener splashHideListener, boolean z) {
        if (activity != null && bundle == null && MetaData.k.b() && k9.e((Context) activity) && ComponentLocator.a((Context) activity).c().a()) {
            try {
                Object obj = StartAppSDKInternal.E;
                StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.d.a;
                if (!(!startAppSDKInternal.x) && z) {
                    startAppSDKInternal.x = false;
                }
                startAppSDKInternal.w = z;
                if (!z) {
                    if (adPreferences2 == null) {
                        adPreferences2 = new AdPreferences();
                    }
                    adPreferences2.setAs(Boolean.TRUE);
                }
                splashConfig.setDefaults(activity);
                k9.a(activity, activity.getResources().getConfiguration().orientation, true);
                Intent intent = new Intent(activity, OverlayActivity.class);
                intent.putExtra("SplashConfig", splashConfig);
                intent.putExtra("AdPreference", adPreferences2);
                intent.putExtra("testMode", false);
                intent.putExtra("fullscreen", a.a(activity));
                intent.putExtra("placement", AdPreferences.Placement.INAPP_SPLASH.a());
                intent.addFlags(32768 | 67108864 | 1073741824);
                activity.startActivity(intent);
                w4.a((Context) activity).a(new d(activity, splashHideListener), new IntentFilter("com.startapp.android.splashHidden"));
            } catch (Throwable th) {
                i3.a(th);
                if (splashHideListener != null) {
                    splashHideListener.splashHidden();
                }
            }
        }
    }
}
