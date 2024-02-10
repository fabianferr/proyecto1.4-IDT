package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.a.f;
import com.applovin.impl.mediation.a.h;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdViewAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdViewAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import java.util.concurrent.atomic.AtomicBoolean;

public class g {
    /* access modifiers changed from: private */
    public final Handler a = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final m b;
    /* access modifiers changed from: private */
    public final u c;
    /* access modifiers changed from: private */
    public final String d;
    /* access modifiers changed from: private */
    public final f e;
    /* access modifiers changed from: private */
    public final String f;
    /* access modifiers changed from: private */
    public MaxAdapter g;
    /* access modifiers changed from: private */
    public String h;
    /* access modifiers changed from: private */
    public com.applovin.impl.mediation.a.a i;
    /* access modifiers changed from: private */
    public View j;
    /* access modifiers changed from: private */
    public MaxNativeAd k;
    /* access modifiers changed from: private */
    public MaxNativeAdView l;
    /* access modifiers changed from: private */
    public final a m = new a();
    /* access modifiers changed from: private */
    public MaxAdapterResponseParameters n;
    private final AtomicBoolean o = new AtomicBoolean(true);
    /* access modifiers changed from: private */
    public final AtomicBoolean p = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final AtomicBoolean q = new AtomicBoolean(false);
    private final boolean r;

    private class a implements MaxAdViewAdapterListener, MaxInterstitialAdapterListener, MaxNativeAdAdapterListener, MaxRewardedAdapterListener, MaxRewardedInterstitialAdapterListener {
        /* access modifiers changed from: private */
        public MediationServiceImpl.a b;

        private a() {
        }

        /* access modifiers changed from: private */
        public void a(MediationServiceImpl.a aVar) {
            if (aVar != null) {
                this.b = aVar;
                return;
            }
            throw new IllegalArgumentException("No listener specified");
        }

        private void a(String str, final Bundle bundle) {
            g.this.q.set(true);
            a(str, (MaxAdListener) this.b, (Runnable) new Runnable() {
                public void run() {
                    if (g.this.p.compareAndSet(false, true)) {
                        a.this.b.a(g.this.i, bundle);
                    }
                }
            });
        }

        private void a(final String str, final MaxAdListener maxAdListener, final Runnable runnable) {
            g.this.a.post(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } catch (Exception e) {
                        MaxAdListener maxAdListener = maxAdListener;
                        String name = maxAdListener != null ? maxAdListener.getClass().getName() : null;
                        if (u.a()) {
                            u.c("MediationAdapterWrapper", "Failed to forward call (" + str + ") to " + name, e);
                        }
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        public void a(String str, final MaxError maxError) {
            a(str, (MaxAdListener) this.b, (Runnable) new Runnable() {
                public void run() {
                    if (g.this.p.compareAndSet(false, true)) {
                        a.this.b.onAdLoadFailed(g.this.h, maxError);
                    }
                }
            });
        }

        private void b(String str, final Bundle bundle) {
            if (g.this.i.s().compareAndSet(false, true)) {
                a(str, (MaxAdListener) this.b, (Runnable) new Runnable() {
                    public void run() {
                        a.this.b.b(g.this.i, bundle);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public void b(String str, final MaxError maxError) {
            a(str, (MaxAdListener) this.b, (Runnable) new Runnable() {
                public void run() {
                    a.this.b.onAdDisplayFailed(g.this.i, maxError);
                }
            });
        }

        public void onAdViewAdClicked() {
            onAdViewAdClicked((Bundle) null);
        }

        public void onAdViewAdClicked(final Bundle bundle) {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": adview ad clicked with extra info: " + bundle);
            }
            a("onAdViewAdClicked", (MaxAdListener) this.b, (Runnable) new Runnable() {
                public void run() {
                    a.this.b.d(g.this.i, bundle);
                }
            });
        }

        public void onAdViewAdCollapsed() {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": adview ad collapsed");
            }
            a("onAdViewAdCollapsed", (MaxAdListener) this.b, (Runnable) new Runnable() {
                public void run() {
                    a.this.b.onAdCollapsed(g.this.i);
                }
            });
        }

        public void onAdViewAdDisplayFailed(MaxAdapterError maxAdapterError) {
            if (u.a()) {
                u c = g.this.c;
                c.d("MediationAdapterWrapper", g.this.f + ": adview ad failed to display with error: " + maxAdapterError);
            }
            b("onAdViewAdDisplayFailed", (MaxError) maxAdapterError);
        }

        public void onAdViewAdDisplayed() {
            onAdViewAdDisplayed((Bundle) null);
        }

        public void onAdViewAdDisplayed(Bundle bundle) {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": adview ad displayed with extra info: " + bundle);
            }
            b("onAdViewAdDisplayed", bundle);
        }

        public void onAdViewAdExpanded() {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": adview ad expanded");
            }
            a("onAdViewAdExpanded", (MaxAdListener) this.b, (Runnable) new Runnable() {
                public void run() {
                    a.this.b.onAdExpanded(g.this.i);
                }
            });
        }

        public void onAdViewAdHidden() {
            onAdViewAdHidden((Bundle) null);
        }

        public void onAdViewAdHidden(final Bundle bundle) {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": adview ad hidden with extra info: " + bundle);
            }
            a("onAdViewAdHidden", (MaxAdListener) this.b, (Runnable) new Runnable() {
                public void run() {
                    a.this.b.c(g.this.i, bundle);
                }
            });
        }

        public void onAdViewAdLoadFailed(MaxAdapterError maxAdapterError) {
            if (u.a()) {
                u c = g.this.c;
                c.d("MediationAdapterWrapper", g.this.f + ": adview ad ad failed to load with error: " + maxAdapterError);
            }
            a("onAdViewAdLoadFailed", (MaxError) maxAdapterError);
        }

        public void onAdViewAdLoaded(View view) {
            onAdViewAdLoaded(view, (Bundle) null);
        }

        public void onAdViewAdLoaded(View view, Bundle bundle) {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": adview ad loaded with extra info: " + bundle);
            }
            View unused = g.this.j = view;
            a("onAdViewAdLoaded", bundle);
        }

        public void onInterstitialAdClicked() {
            onInterstitialAdClicked((Bundle) null);
        }

        public void onInterstitialAdClicked(final Bundle bundle) {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": interstitial ad clicked with extra info: " + bundle);
            }
            a("onInterstitialAdClicked", (MaxAdListener) this.b, (Runnable) new Runnable() {
                public void run() {
                    a.this.b.d(g.this.i, bundle);
                }
            });
        }

        public void onInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError) {
            if (u.a()) {
                u c = g.this.c;
                c.d("MediationAdapterWrapper", g.this.f + ": interstitial ad failed to display with error " + maxAdapterError);
            }
            b("onInterstitialAdDisplayFailed", (MaxError) maxAdapterError);
        }

        public void onInterstitialAdDisplayed() {
            onInterstitialAdDisplayed((Bundle) null);
        }

        public void onInterstitialAdDisplayed(Bundle bundle) {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": interstitial ad displayed with extra info: " + bundle);
            }
            b("onInterstitialAdDisplayed", bundle);
        }

        public void onInterstitialAdHidden() {
            onInterstitialAdHidden((Bundle) null);
        }

        public void onInterstitialAdHidden(final Bundle bundle) {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": interstitial ad hidden with extra info " + bundle);
            }
            a("onInterstitialAdHidden", (MaxAdListener) this.b, (Runnable) new Runnable() {
                public void run() {
                    a.this.b.c(g.this.i, bundle);
                }
            });
        }

        public void onInterstitialAdLoadFailed(MaxAdapterError maxAdapterError) {
            if (u.a()) {
                u c = g.this.c;
                c.d("MediationAdapterWrapper", g.this.f + ": interstitial ad failed to load with error " + maxAdapterError);
            }
            a("onInterstitialAdLoadFailed", (MaxError) maxAdapterError);
        }

        public void onInterstitialAdLoaded() {
            onInterstitialAdLoaded((Bundle) null);
        }

        public void onInterstitialAdLoaded(Bundle bundle) {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": interstitial ad loaded with extra info: " + bundle);
            }
            a("onInterstitialAdLoaded", bundle);
        }

        public void onNativeAdClicked() {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": native ad clicked");
            }
            a("onNativeAdClicked", (MaxAdListener) this.b, (Runnable) new Runnable() {
                public void run() {
                    a.this.b.onAdClicked(g.this.i);
                }
            });
        }

        public void onNativeAdDisplayed(Bundle bundle) {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": native ad displayed with extra info: " + bundle);
            }
            b("onNativeAdDisplayed", bundle);
        }

        public void onNativeAdLoadFailed(MaxAdapterError maxAdapterError) {
            if (u.a()) {
                u c = g.this.c;
                c.d("MediationAdapterWrapper", g.this.f + ": native ad ad failed to load with error: " + maxAdapterError);
            }
            a("onNativeAdLoadFailed", (MaxError) maxAdapterError);
        }

        public void onNativeAdLoaded(MaxNativeAd maxNativeAd, Bundle bundle) {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": native ad loaded with extra info: " + bundle);
            }
            MaxNativeAd unused = g.this.k = maxNativeAd;
            a("onNativeAdLoaded", bundle);
        }

        public void onRewardedAdClicked() {
            onRewardedAdClicked((Bundle) null);
        }

        public void onRewardedAdClicked(final Bundle bundle) {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": rewarded ad clicked with extra info: " + bundle);
            }
            a("onRewardedAdClicked", (MaxAdListener) this.b, (Runnable) new Runnable() {
                public void run() {
                    a.this.b.d(g.this.i, bundle);
                }
            });
        }

        public void onRewardedAdDisplayFailed(MaxAdapterError maxAdapterError) {
            if (u.a()) {
                u c = g.this.c;
                c.d("MediationAdapterWrapper", g.this.f + ": rewarded ad display failed with error: " + maxAdapterError);
            }
            b("onRewardedAdDisplayFailed", (MaxError) maxAdapterError);
        }

        public void onRewardedAdDisplayed() {
            onRewardedAdDisplayed((Bundle) null);
        }

        public void onRewardedAdDisplayed(Bundle bundle) {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": rewarded ad displayed with extra info: " + bundle);
            }
            b("onRewardedAdDisplayed", bundle);
        }

        public void onRewardedAdHidden() {
            onRewardedAdHidden((Bundle) null);
        }

        public void onRewardedAdHidden(final Bundle bundle) {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": rewarded ad hidden with extra info: " + bundle);
            }
            a("onRewardedAdHidden", (MaxAdListener) this.b, (Runnable) new Runnable() {
                public void run() {
                    a.this.b.c(g.this.i, bundle);
                }
            });
        }

        public void onRewardedAdLoadFailed(MaxAdapterError maxAdapterError) {
            if (u.a()) {
                u c = g.this.c;
                c.d("MediationAdapterWrapper", g.this.f + ": rewarded ad failed to load with error: " + maxAdapterError);
            }
            a("onRewardedAdLoadFailed", (MaxError) maxAdapterError);
        }

        public void onRewardedAdLoaded() {
            onRewardedAdLoaded((Bundle) null);
        }

        public void onRewardedAdLoaded(Bundle bundle) {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": rewarded ad loaded with extra info: " + bundle);
            }
            a("onRewardedAdLoaded", bundle);
        }

        public void onRewardedAdVideoCompleted() {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": rewarded video completed");
            }
            a("onRewardedAdVideoCompleted", (MaxAdListener) this.b, (Runnable) new Runnable() {
                public void run() {
                    a.this.b.onRewardedVideoCompleted(g.this.i);
                }
            });
        }

        public void onRewardedAdVideoStarted() {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": rewarded video started");
            }
            a("onRewardedAdVideoStarted", (MaxAdListener) this.b, (Runnable) new Runnable() {
                public void run() {
                    a.this.b.onRewardedVideoStarted(g.this.i);
                }
            });
        }

        public void onRewardedInterstitialAdClicked() {
            onRewardedInterstitialAdClicked((Bundle) null);
        }

        public void onRewardedInterstitialAdClicked(final Bundle bundle) {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": rewarded interstitial ad clicked with extra info: " + bundle);
            }
            a("onRewardedInterstitialAdClicked", (MaxAdListener) this.b, (Runnable) new Runnable() {
                public void run() {
                    a.this.b.d(g.this.i, bundle);
                }
            });
        }

        public void onRewardedInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError) {
            if (u.a()) {
                u c = g.this.c;
                c.d("MediationAdapterWrapper", g.this.f + ": rewarded interstitial ad display failed with error: " + maxAdapterError);
            }
            b("onRewardedInterstitialAdDisplayFailed", (MaxError) maxAdapterError);
        }

        public void onRewardedInterstitialAdDisplayed() {
            onRewardedInterstitialAdDisplayed((Bundle) null);
        }

        public void onRewardedInterstitialAdDisplayed(Bundle bundle) {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": rewarded interstitial ad displayed with extra info: " + bundle);
            }
            b("onRewardedInterstitialAdDisplayed", bundle);
        }

        public void onRewardedInterstitialAdHidden() {
            onRewardedInterstitialAdHidden((Bundle) null);
        }

        public void onRewardedInterstitialAdHidden(final Bundle bundle) {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": rewarded interstitial ad hidden with extra info: " + bundle);
            }
            a("onRewardedInterstitialAdHidden", (MaxAdListener) this.b, (Runnable) new Runnable() {
                public void run() {
                    a.this.b.c(g.this.i, bundle);
                }
            });
        }

        public void onRewardedInterstitialAdLoadFailed(MaxAdapterError maxAdapterError) {
            if (u.a()) {
                u c = g.this.c;
                c.d("MediationAdapterWrapper", g.this.f + ": rewarded ad failed to load with error: " + maxAdapterError);
            }
            a("onRewardedInterstitialAdLoadFailed", (MaxError) maxAdapterError);
        }

        public void onRewardedInterstitialAdLoaded() {
            onRewardedInterstitialAdLoaded((Bundle) null);
        }

        public void onRewardedInterstitialAdLoaded(Bundle bundle) {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": rewarded interstitial ad loaded with extra info: " + bundle);
            }
            a("onRewardedInterstitialAdLoaded", bundle);
        }

        public void onRewardedInterstitialAdVideoCompleted() {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": rewarded interstitial completed");
            }
            a("onRewardedInterstitialAdVideoCompleted", (MaxAdListener) this.b, (Runnable) new Runnable() {
                public void run() {
                    a.this.b.onRewardedVideoCompleted(g.this.i);
                }
            });
        }

        public void onRewardedInterstitialAdVideoStarted() {
            if (u.a()) {
                u c = g.this.c;
                c.c("MediationAdapterWrapper", g.this.f + ": rewarded interstitial started");
            }
            a("onRewardedInterstitialAdVideoStarted", (MaxAdListener) this.b, (Runnable) new Runnable() {
                public void run() {
                    a.this.b.onRewardedVideoStarted(g.this.i);
                }
            });
        }

        public void onUserRewarded(final MaxReward maxReward) {
            if (g.this.i instanceof com.applovin.impl.mediation.a.c) {
                final com.applovin.impl.mediation.a.c cVar = (com.applovin.impl.mediation.a.c) g.this.i;
                if (cVar.H().compareAndSet(false, true)) {
                    if (u.a()) {
                        u c = g.this.c;
                        c.c("MediationAdapterWrapper", g.this.f + ": user was rewarded: " + maxReward);
                    }
                    a("onUserRewarded", (MaxAdListener) this.b, (Runnable) new Runnable() {
                        public void run() {
                            a.this.b.onUserRewarded(cVar, maxReward);
                        }
                    });
                }
            }
        }
    }

    private static class b {
        /* access modifiers changed from: private */
        public final h a;
        /* access modifiers changed from: private */
        public final MaxSignalCollectionListener b;
        /* access modifiers changed from: private */
        public final AtomicBoolean c = new AtomicBoolean();

        b(h hVar, MaxSignalCollectionListener maxSignalCollectionListener) {
            this.a = hVar;
            this.b = maxSignalCollectionListener;
        }
    }

    private class c extends com.applovin.impl.sdk.f.a {
        private c() {
            super("TaskTimeoutMediatedAd", g.this.b);
        }

        private void a(com.applovin.impl.mediation.a.a aVar) {
            if (aVar != null) {
                this.b.H().a(aVar);
            }
        }

        public void run() {
            if (g.this.p.get()) {
                return;
            }
            if (g.this.i.k()) {
                if (u.a()) {
                    a(g.this.f + " is timing out, considering JS Tag ad loaded: " + g.this.i);
                }
                a(g.this.i);
                return;
            }
            if (u.a()) {
                d(g.this.f + " is timing out " + g.this.i + "...");
            }
            a(g.this.i);
            g.this.m.a(e(), (MaxError) new MaxErrorImpl(-5101, "Adapter timed out"));
        }
    }

    private class d extends com.applovin.impl.sdk.f.a {
        private final b c;

        private d(b bVar) {
            super("TaskTimeoutSignalCollection", g.this.b);
            this.c = bVar;
        }

        public void run() {
            if (!this.c.c.get()) {
                if (u.a()) {
                    d(g.this.f + " is timing out " + this.c.a + "...");
                }
                g gVar = g.this;
                gVar.b("The adapter (" + g.this.f + ") timed out", this.c);
            }
        }
    }

    g(f fVar, MaxAdapter maxAdapter, boolean z, m mVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("No adapter name specified");
        } else if (maxAdapter == null) {
            throw new IllegalArgumentException("No adapter specified");
        } else if (mVar != null) {
            this.d = fVar.N();
            this.g = maxAdapter;
            this.b = mVar;
            this.c = mVar.A();
            this.e = fVar;
            this.f = maxAdapter.getClass().getSimpleName();
            this.r = z;
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    private void a(final Runnable runnable, com.applovin.impl.mediation.a.a aVar) {
        a("show_ad", (Runnable) new Runnable() {
            public void run() {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    String str = "Failed to start displaying ad for " + g.this.d + " due to: " + th;
                    u.i("MediationAdapterWrapper", str);
                    g.this.m.b("show_ad", (MaxError) new MaxErrorImpl(-1, str));
                    g.this.a("show_ad");
                    g.this.b.C().a(g.this.e.M(), "show_ad", g.this.i);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        if (u.a()) {
            u uVar = this.c;
            uVar.c("MediationAdapterWrapper", "Marking " + this.f + " as disabled due to: " + str);
        }
        this.o.set(false);
    }

    /* access modifiers changed from: private */
    public void a(String str, b bVar) {
        if (bVar.c.compareAndSet(false, true) && bVar.b != null) {
            bVar.b.onSignalCollected(str);
        }
    }

    private void a(final String str, final Runnable runnable) {
        AnonymousClass8 r0 = new Runnable() {
            public void run() {
                try {
                    if (u.a()) {
                        u c2 = g.this.c;
                        c2.b("MediationAdapterWrapper", g.this.f + ": running " + str + "...");
                    }
                    runnable.run();
                    if (u.a()) {
                        u c3 = g.this.c;
                        c3.b("MediationAdapterWrapper", g.this.f + ": finished " + str + "");
                    }
                } catch (Throwable th) {
                    u.c("MediationAdapterWrapper", "Failed operation " + str + " for " + g.this.d, th);
                    g gVar = g.this;
                    StringBuilder sb = new StringBuilder("fail_");
                    sb.append(str);
                    gVar.a(sb.toString());
                    if (!str.equals("destroy")) {
                        g.this.b.C().a(g.this.e.M(), str, g.this.i);
                    }
                }
            }
        };
        if (this.e.U()) {
            this.a.post(r0);
        } else {
            r0.run();
        }
    }

    /* access modifiers changed from: private */
    public void b(String str, b bVar) {
        if (bVar.c.compareAndSet(false, true) && bVar.b != null) {
            bVar.b.onSignalCollectionFailed(str);
        }
    }

    private boolean b(com.applovin.impl.mediation.a.a aVar, Activity activity) {
        if (aVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        } else if (aVar.g() == null) {
            if (u.a()) {
                u.i("MediationAdapterWrapper", "Adapter has been garbage collected");
            }
            this.m.b("ad_show", (MaxError) new MaxErrorImpl(-1, "Adapter has been garbage collected"));
            return false;
        } else if (aVar.g() != this) {
            throw new IllegalArgumentException("Mediated ad belongs to a different adapter");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (!this.o.get()) {
            String str = "Mediation adapter '" + this.f + "' is disabled. Showing ads with this adapter is disabled.";
            if (u.a()) {
                u.i("MediationAdapterWrapper", str);
            }
            this.m.b("ad_show", (MaxError) new MaxErrorImpl(-1, str));
            return false;
        } else if (g()) {
            return true;
        } else {
            throw new IllegalStateException("Mediation adapter '" + this.f + "' does not have an ad loaded. Please load an ad first");
        }
    }

    public View a() {
        return this.j;
    }

    public void a(com.applovin.impl.mediation.a.a aVar, final Activity activity) {
        Runnable runnable;
        if (b(aVar, activity)) {
            if (aVar.getFormat() == MaxAdFormat.INTERSTITIAL) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxInterstitialAdapter) g.this.g).showInterstitialAd(g.this.n, activity, g.this.m);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxRewardedAdapter) g.this.g).showRewardedAd(g.this.n, activity, g.this.m);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxRewardedInterstitialAdapter) g.this.g).showRewardedInterstitialAd(g.this.n, activity, g.this.m);
                    }
                };
            } else {
                throw new IllegalStateException("Failed to show " + aVar + ": " + aVar.getFormat() + " is not a supported ad format");
            }
            a(runnable, aVar);
        }
    }

    public void a(com.applovin.impl.mediation.a.a aVar, final ViewGroup viewGroup, final Lifecycle lifecycle, final Activity activity) {
        Runnable runnable;
        if (b(aVar, activity)) {
            if (aVar.getFormat() == MaxAdFormat.INTERSTITIAL) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxInterstitialAdViewAdapter) g.this.g).showInterstitialAd(g.this.n, viewGroup, lifecycle, activity, g.this.m);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxRewardedAdViewAdapter) g.this.g).showRewardedAd(g.this.n, viewGroup, lifecycle, activity, g.this.m);
                    }
                };
            } else {
                throw new IllegalStateException("Failed to show " + aVar + ": " + aVar.getFormat() + " is not a supported ad format");
            }
            a(runnable, aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(final MaxAdapterInitializationParameters maxAdapterInitializationParameters, final Activity activity, final Runnable runnable) {
        a(MobileAdsBridgeBase.initializeMethodName, (Runnable) new Runnable() {
            public void run() {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                if (u.a()) {
                    u c2 = g.this.c;
                    c2.b("MediationAdapterWrapper", "Initializing " + g.this.f + " on thread: " + Thread.currentThread() + " with 'run_on_ui_thread' value: " + g.this.e.U());
                }
                g.this.g.initialize(maxAdapterInitializationParameters, activity, new MaxAdapter.OnCompletionListener() {
                    public void onCompletion(final MaxAdapter.InitializationStatus initializationStatus, final String str) {
                        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                            public void run() {
                                g.this.b.D().a(g.this.e, SystemClock.elapsedRealtime() - elapsedRealtime, initializationStatus, str);
                                if (runnable != null) {
                                    runnable.run();
                                }
                            }
                        }, g.this.e.Z());
                    }
                });
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void a(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, h hVar, Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        if (maxSignalCollectionListener == null) {
            throw new IllegalArgumentException("No callback specified");
        } else if (!this.o.get()) {
            if (u.a()) {
                u.i("MediationAdapterWrapper", "Mediation adapter '" + this.f + "' is disabled. Signal collection ads with this adapter is disabled.");
            }
            maxSignalCollectionListener.onSignalCollectionFailed("The adapter (" + this.f + ") is disabled");
        } else {
            final b bVar = new b(hVar, maxSignalCollectionListener);
            MaxAdapter maxAdapter = this.g;
            if (maxAdapter instanceof MaxSignalProvider) {
                final MaxSignalProvider maxSignalProvider = (MaxSignalProvider) maxAdapter;
                final MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters2 = maxAdapterSignalCollectionParameters;
                final Activity activity2 = activity;
                final h hVar2 = hVar;
                a("collect_signal", (Runnable) new Runnable() {
                    public void run() {
                        try {
                            maxSignalProvider.collectSignal(maxAdapterSignalCollectionParameters2, activity2, new MaxSignalCollectionListener() {
                                public void onSignalCollected(String str) {
                                    g.this.a(str, bVar);
                                }

                                public void onSignalCollectionFailed(String str) {
                                    g.this.b(str, bVar);
                                }
                            });
                        } catch (Throwable th) {
                            String str = "Failed signal collection for " + g.this.d + " due to: " + th;
                            u.i("MediationAdapterWrapper", str);
                            g.this.b(str, bVar);
                            g.this.a("collect_signal");
                            g.this.b.C().a(g.this.e.M(), "collect_signal", g.this.i);
                        }
                        if (bVar.c.get()) {
                            return;
                        }
                        if (hVar2.Y() == 0) {
                            if (u.a()) {
                                g.this.c.b("MediationAdapterWrapper", "Failing signal collection " + hVar2 + " since it has 0 timeout");
                            }
                            g.this.b("The adapter (" + g.this.f + ") has 0 timeout", bVar);
                            return;
                        }
                        int i = (hVar2.Y() > 0 ? 1 : (hVar2.Y() == 0 ? 0 : -1));
                        boolean a2 = u.a();
                        if (i > 0) {
                            if (a2) {
                                g.this.c.b("MediationAdapterWrapper", "Setting timeout " + hVar2.Y() + "ms. for " + hVar2);
                            }
                            g.this.b.S().a((com.applovin.impl.sdk.f.a) new d(bVar), o.a.MEDIATION_TIMEOUT, hVar2.Y());
                        } else if (a2) {
                            g.this.c.b("MediationAdapterWrapper", "Negative timeout set for " + hVar2 + ", not scheduling a timeout");
                        }
                    }
                });
                return;
            }
            b("The adapter (" + this.f + ") does not support signal collection", bVar);
        }
    }

    public void a(MaxNativeAdView maxNativeAdView) {
        this.l = maxNativeAdView;
    }

    /* access modifiers changed from: package-private */
    public void a(String str, com.applovin.impl.mediation.a.a aVar) {
        this.h = str;
        this.i = aVar;
    }

    public void a(String str, final MaxAdapterResponseParameters maxAdapterResponseParameters, final com.applovin.impl.mediation.a.a aVar, final Activity activity, MediationServiceImpl.a aVar2) {
        final Runnable runnable;
        if (aVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        } else if (!this.o.get()) {
            String str2 = "Mediation adapter '" + this.f + "' was disabled due to earlier failures. Loading ads with this adapter is disabled.";
            if (u.a()) {
                u.i("MediationAdapterWrapper", str2);
            }
            aVar2.onAdLoadFailed(str, new MaxErrorImpl(-1, str2));
        } else {
            this.n = maxAdapterResponseParameters;
            this.m.a(aVar2);
            if (aVar.getFormat() == MaxAdFormat.INTERSTITIAL) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxInterstitialAdapter) g.this.g).loadInterstitialAd(maxAdapterResponseParameters, activity, g.this.m);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxRewardedAdapter) g.this.g).loadRewardedAd(maxAdapterResponseParameters, activity, g.this.m);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxRewardedInterstitialAdapter) g.this.g).loadRewardedInterstitialAd(maxAdapterResponseParameters, activity, g.this.m);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.NATIVE) {
                runnable = new Runnable() {
                    public void run() {
                        ((MediationAdapterBase) g.this.g).loadNativeAd(maxAdapterResponseParameters, activity, g.this.m);
                    }
                };
            } else if (aVar.getFormat().isAdViewAd()) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxAdViewAdapter) g.this.g).loadAdViewAd(maxAdapterResponseParameters, aVar.getFormat(), activity, g.this.m);
                    }
                };
            } else {
                throw new IllegalStateException("Failed to load " + aVar + ": " + aVar.getFormat() + " is not a supported ad format");
            }
            a("load_ad", (Runnable) new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        String str = "Failed to start loading ad for " + g.this.d + " due to: " + th;
                        u.i("MediationAdapterWrapper", str);
                        g.this.m.a("load_ad", (MaxError) new MaxErrorImpl(-1, str));
                        g.this.a("load_ad");
                        g.this.b.C().a(g.this.e.M(), "load_ad", g.this.i);
                    }
                    if (!g.this.p.get()) {
                        long Y = g.this.e.Y();
                        if (Y > 0) {
                            if (u.a()) {
                                g.this.c.b("MediationAdapterWrapper", "Setting timeout " + Y + "ms. for " + aVar);
                            }
                            g.this.b.S().a((com.applovin.impl.sdk.f.a) new c(), o.a.MEDIATION_TIMEOUT, Y);
                        } else if (u.a()) {
                            g.this.c.b("MediationAdapterWrapper", "Negative timeout set for " + aVar + ", not scheduling a timeout");
                        }
                    }
                }
            });
        }
    }

    public MaxNativeAd b() {
        return this.k;
    }

    public MaxNativeAdView c() {
        return this.l;
    }

    public String d() {
        return this.d;
    }

    public MediationServiceImpl.a e() {
        return this.m.b;
    }

    public boolean f() {
        return this.o.get();
    }

    public boolean g() {
        return this.p.get() && this.q.get();
    }

    public String h() {
        MaxAdapter maxAdapter = this.g;
        if (maxAdapter == null) {
            return null;
        }
        try {
            return maxAdapter.getSdkVersion();
        } catch (Throwable th) {
            u.c("MediationAdapterWrapper", "Failed to get adapter's SDK version for " + this.d, th);
            a("sdk_version");
            this.b.C().a(this.e.M(), "sdk_version", this.i);
            return null;
        }
    }

    public String i() {
        MaxAdapter maxAdapter = this.g;
        if (maxAdapter == null) {
            return null;
        }
        try {
            return maxAdapter.getAdapterVersion();
        } catch (Throwable th) {
            u.c("MediationAdapterWrapper", "Failed to get adapter version for " + this.d, th);
            a("adapter_version");
            this.b.C().a(this.e.M(), "adapter_version", this.i);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        if (!this.r) {
            a("destroy", (Runnable) new Runnable() {
                public void run() {
                    g.this.a("destroy");
                    g.this.g.onDestroy();
                    MaxAdapter unused = g.this.g = null;
                    View unused2 = g.this.j = null;
                    MaxNativeAd unused3 = g.this.k = null;
                    MaxNativeAdView unused4 = g.this.l = null;
                }
            });
        }
    }

    public String toString() {
        return "MediationAdapterWrapper{adapterTag='" + this.f + "'}";
    }
}
