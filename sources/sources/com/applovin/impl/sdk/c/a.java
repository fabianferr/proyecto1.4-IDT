package com.applovin.impl.sdk.c;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.ad.f;
import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.f.aa;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.f.v;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.j;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.SoftReference;
import java.util.Map;

public class a {
    protected final m a;
    protected final AppLovinAdServiceImpl b;
    /* access modifiers changed from: private */
    public AppLovinAd c;
    private String d;
    private SoftReference<AppLovinAdLoadListener> e;
    private final Object f = new Object();
    private volatile String g;
    /* access modifiers changed from: private */
    public volatile boolean h = false;

    /* renamed from: com.applovin.impl.sdk.c.a$a  reason: collision with other inner class name */
    private class C0020a implements AppLovinAdLoadListener {
        /* access modifiers changed from: private */
        public final AppLovinAdLoadListener b;

        C0020a(AppLovinAdLoadListener appLovinAdLoadListener) {
            this.b = appLovinAdLoadListener;
        }

        public void adReceived(final AppLovinAd appLovinAd) {
            AppLovinAd unused = a.this.c = appLovinAd;
            if (this.b != null) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            C0020a.this.b.adReceived(appLovinAd);
                        } catch (Throwable th) {
                            if (u.a()) {
                                u.c("AppLovinIncentivizedInterstitial", "Unable to notify ad listener about a newly loaded ad", th);
                            }
                        }
                    }
                });
            }
        }

        public void failedToReceiveAd(final int i) {
            if (this.b != null) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            C0020a.this.b.failedToReceiveAd(i);
                        } catch (Throwable th) {
                            if (u.a()) {
                                u.c("AppLovinIncentivizedInterstitial", "Unable to notify listener about ad load failure", th);
                            }
                        }
                    }
                });
            }
        }
    }

    private class b implements g, AppLovinAdClickListener, AppLovinAdRewardListener, AppLovinAdVideoPlaybackListener {
        private final AppLovinAdDisplayListener b;
        private final AppLovinAdClickListener c;
        private final AppLovinAdVideoPlaybackListener d;
        private final AppLovinAdRewardListener e;

        private b(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
            this.b = appLovinAdDisplayListener;
            this.c = appLovinAdClickListener;
            this.d = appLovinAdVideoPlaybackListener;
            this.e = appLovinAdRewardListener;
        }

        private void a(e eVar) {
            int i;
            String str;
            String a2 = a.this.d();
            if (!StringUtils.isValidString(a2) || !a.this.h) {
                if (u.a()) {
                    u A = a.this.a.A();
                    A.e("IncentivizedAdController", "Invalid reward state - result: " + a2 + " and wasFullyEngaged: " + a.this.h);
                    a.this.a.A().b("IncentivizedAdController", "Cancelling any incoming reward requests for this ad");
                }
                eVar.aF();
                if (a.this.h) {
                    if (u.a()) {
                        a.this.a.A().e("IncentivizedAdController", "User close the ad after fully watching but reward validation task did not return on time");
                    }
                    str = "network_timeout";
                    i = AppLovinErrorCodes.INCENTIVIZED_SERVER_TIMEOUT;
                } else {
                    if (u.a()) {
                        a.this.a.A().e("IncentivizedAdController", "User close the ad prematurely");
                    }
                    str = "user_closed_video";
                    i = AppLovinErrorCodes.INCENTIVIZED_USER_CLOSED_VIDEO;
                }
                eVar.a(c.a(str));
                if (u.a()) {
                    a.this.a.A().b("IncentivizedAdController", "Notifying listener of reward validation failure");
                }
                j.a(this.e, (AppLovinAd) eVar, i);
            }
            a.this.a((AppLovinAd) eVar);
            if (u.a()) {
                a.this.a.A().b("IncentivizedAdController", "Notifying listener of rewarded ad dismissal");
            }
            j.b(this.b, (AppLovinAd) eVar);
            if (!eVar.ag().getAndSet(true)) {
                if (u.a()) {
                    a.this.a.A().b("IncentivizedAdController", "Scheduling report rewarded ad...");
                }
                a.this.a.S().a((com.applovin.impl.sdk.f.a) new v(eVar, a.this.a), o.a.REWARD);
            }
        }

        public void adClicked(AppLovinAd appLovinAd) {
            j.a(this.c, appLovinAd);
        }

        public void adDisplayed(AppLovinAd appLovinAd) {
            j.a(this.b, appLovinAd);
        }

        public void adHidden(AppLovinAd appLovinAd) {
            if (appLovinAd instanceof f) {
                appLovinAd = ((f) appLovinAd).a();
            }
            if (appLovinAd instanceof e) {
                a((e) appLovinAd);
            } else if (u.a()) {
                u A = a.this.a.A();
                A.e("IncentivizedAdController", "Something is terribly wrong. Received `adHidden` callback for invalid ad of type: " + appLovinAd);
            }
        }

        public void onAdDisplayFailed(String str) {
            j.a(this.b, str);
        }

        public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
            a.this.a("quota_exceeded");
            j.b(this.e, appLovinAd, map);
        }

        public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
            a.this.a("rejected");
            j.c(this.e, appLovinAd, map);
        }

        public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
            a.this.a("accepted");
            j.a(this.e, appLovinAd, map);
        }

        public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
            a.this.a("network_timeout");
            j.a(this.e, appLovinAd, i);
        }

        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            j.a(this.d, appLovinAd);
        }

        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d2, boolean z) {
            j.a(this.d, appLovinAd, d2, z);
            boolean unused = a.this.h = z;
        }
    }

    public a(String str, AppLovinSdk appLovinSdk) {
        this.a = appLovinSdk.coreSdk;
        this.b = (AppLovinAdServiceImpl) appLovinSdk.getAdService();
        this.d = str;
    }

    private void a(AppLovinAdImpl appLovinAdImpl, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAdImpl.getType() == AppLovinAdType.INCENTIVIZED || appLovinAdImpl.getType() == AppLovinAdType.AUTO_INCENTIVIZED) {
            AppLovinAd maybeRetrieveNonDummyAd = Utils.maybeRetrieveNonDummyAd(appLovinAdImpl, this.a);
            if (maybeRetrieveNonDummyAd == null) {
                a(appLovinAdImpl, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener);
                return;
            }
            AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(this.a.Y(), context);
            b bVar = new b(appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
            create.setAdDisplayListener(bVar);
            create.setAdVideoPlaybackListener(bVar);
            create.setAdClickListener(bVar);
            create.showAndRender(maybeRetrieveNonDummyAd);
            if (maybeRetrieveNonDummyAd instanceof e) {
                a((e) maybeRetrieveNonDummyAd, (AppLovinAdRewardListener) bVar);
                return;
            }
            return;
        }
        if (u.a()) {
            u A = this.a.A();
            A.e("IncentivizedAdController", "Failed to render an ad of type " + appLovinAdImpl.getType() + " in an Incentivized Ad interstitial.");
        }
        a(appLovinAdImpl, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener);
    }

    private void a(AppLovinAdImpl appLovinAdImpl, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        AppLovinAdImpl appLovinAdImpl2 = appLovinAdImpl;
        AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener2 = appLovinAdVideoPlaybackListener;
        AppLovinAdDisplayListener appLovinAdDisplayListener2 = appLovinAdDisplayListener;
        if (appLovinAdImpl.getType() == AppLovinAdType.INCENTIVIZED || appLovinAdImpl.getType() == AppLovinAdType.AUTO_INCENTIVIZED) {
            AppLovinAd maybeRetrieveNonDummyAd = Utils.maybeRetrieveNonDummyAd(appLovinAdImpl, this.a);
            if (maybeRetrieveNonDummyAd == null) {
                a(appLovinAdImpl, appLovinAdVideoPlaybackListener2, appLovinAdDisplayListener2);
                return;
            }
            Context context2 = context;
            AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(this.a.Y(), context);
            b bVar = new b(appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
            create.setAdDisplayListener(bVar);
            create.setAdVideoPlaybackListener(bVar);
            create.setAdClickListener(bVar);
            ViewGroup viewGroup2 = viewGroup;
            Lifecycle lifecycle2 = lifecycle;
            create.showAndRender(maybeRetrieveNonDummyAd, viewGroup, lifecycle);
            if (maybeRetrieveNonDummyAd instanceof e) {
                a((e) maybeRetrieveNonDummyAd, (AppLovinAdRewardListener) bVar);
                return;
            }
            return;
        }
        if (u.a()) {
            u A = this.a.A();
            A.e("IncentivizedAdController", "Failed to render an ad of type " + appLovinAdImpl.getType() + " in an Incentivized Ad interstitial.");
        }
        a(appLovinAdImpl, appLovinAdVideoPlaybackListener2, appLovinAdDisplayListener2);
    }

    private void a(e eVar, AppLovinAdRewardListener appLovinAdRewardListener) {
        this.a.S().a((com.applovin.impl.sdk.f.a) new aa(eVar, appLovinAdRewardListener, this.a), o.a.REWARD);
    }

    /* access modifiers changed from: private */
    public void a(AppLovinAd appLovinAd) {
        AppLovinAd appLovinAd2 = this.c;
        if (appLovinAd2 != null) {
            if (appLovinAd2 instanceof f) {
                if (appLovinAd != ((f) appLovinAd2).a()) {
                    return;
                }
            } else if (appLovinAd != appLovinAd2) {
                return;
            }
            this.c = null;
        }
    }

    private void a(AppLovinAd appLovinAd, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAd == null) {
            appLovinAd = this.c;
        }
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        if (appLovinAdImpl != null) {
            a(appLovinAdImpl, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
            return;
        }
        if (u.a()) {
            u.i("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
        }
        c();
    }

    private void a(AppLovinAd appLovinAd, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.a.T().a(com.applovin.impl.sdk.e.f.l);
        j.a(appLovinAdVideoPlaybackListener, appLovinAd, 0.0d, false);
        j.b(appLovinAdDisplayListener, appLovinAd);
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        synchronized (this.f) {
            this.g = str;
        }
    }

    private void b(AppLovinAd appLovinAd, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        AppLovinAdImpl appLovinAdImpl;
        if (appLovinAd != null) {
            appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        } else {
            appLovinAdImpl = (AppLovinAdImpl) this.c;
        }
        if (appLovinAdImpl != null) {
            a(appLovinAdImpl, viewGroup, lifecycle, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
            return;
        }
        if (u.a()) {
            u.i("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
        }
        c();
    }

    private void b(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.b.loadNextIncentivizedAd(this.d, appLovinAdLoadListener);
    }

    private void c() {
        AppLovinAdLoadListener appLovinAdLoadListener;
        SoftReference<AppLovinAdLoadListener> softReference = this.e;
        if (softReference != null && (appLovinAdLoadListener = softReference.get()) != null) {
            appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.INCENTIVIZED_NO_AD_PRELOADED);
        }
    }

    /* access modifiers changed from: private */
    public String d() {
        String str;
        synchronized (this.f) {
            str = this.g;
        }
        return str;
    }

    private AppLovinAdRewardListener e() {
        return new AppLovinAdRewardListener() {
            public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
                if (u.a()) {
                    u A = a.this.a.A();
                    A.e("IncentivizedAdController", "User over quota: " + map);
                }
            }

            public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
                if (u.a()) {
                    u A = a.this.a.A();
                    A.e("IncentivizedAdController", "Reward rejected: " + map);
                }
            }

            public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
                if (u.a()) {
                    u A = a.this.a.A();
                    A.b("IncentivizedAdController", "Reward validated: " + map);
                }
            }

            public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
                if (u.a()) {
                    u A = a.this.a.A();
                    A.e("IncentivizedAdController", "Reward validation failed: " + i);
                }
            }
        };
    }

    public void a(AppLovinAd appLovinAd, Context context, String str, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAdRewardListener == null) {
            appLovinAdRewardListener = e();
        }
        a(appLovinAd, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    public void a(AppLovinAd appLovinAd, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        b(appLovinAd, viewGroup, lifecycle, context, appLovinAdRewardListener == null ? e() : appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    public void a(AppLovinAdLoadListener appLovinAdLoadListener) {
        if (u.a()) {
            this.a.A().b("IncentivizedAdController", "User requested preload of incentivized ad...");
        }
        this.e = new SoftReference<>(appLovinAdLoadListener);
        if (a()) {
            if (u.a()) {
                u.i("IncentivizedAdController", "Attempted to call preloadAndNotify: while an ad was already loaded or currently being played. Do not call preloadAndNotify: again until the last ad has been closed (adHidden).");
            }
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.adReceived(this.c);
                return;
            }
            return;
        }
        b((AppLovinAdLoadListener) new C0020a(appLovinAdLoadListener));
    }

    public boolean a() {
        return this.c != null;
    }

    public String b() {
        return this.d;
    }
}
