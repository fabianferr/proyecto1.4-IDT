package com.applovin.impl.mediation.ads;

import android.text.TextUtils;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.a.d;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.g;
import com.applovin.impl.sdk.utils.j;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class MaxNativeAdLoaderImpl extends a {
    /* access modifiers changed from: private */
    public final a a = new a();
    /* access modifiers changed from: private */
    public String b;
    /* access modifiers changed from: private */
    public String c;
    /* access modifiers changed from: private */
    public MaxNativeAdListener d;
    private final Map<String, MaxNativeAdView> e = CollectionUtils.map();
    private final Object f = new Object();

    private class a implements a.C0011a {
        private a() {
        }

        /* access modifiers changed from: private */
        public void a(MaxNativeAdView maxNativeAdView) {
            d c;
            b adViewTracker = maxNativeAdView.getAdViewTracker();
            if (adViewTracker != null && (c = adViewTracker.c()) != null) {
                MaxNativeAdLoaderImpl.this.logger.b(MaxNativeAdLoaderImpl.this.tag, "Destroying previous ad");
                MaxNativeAdLoaderImpl.this.destroy(c);
            }
        }

        public void onAdClicked(MaxAd maxAd) {
            j.a(MaxNativeAdLoaderImpl.this.d, maxAd, true);
        }

        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        }

        public void onAdDisplayed(MaxAd maxAd) {
        }

        public void onAdHidden(MaxAd maxAd) {
        }

        public void onAdLoadFailed(String str, MaxError maxError) {
            MaxNativeAdView unused = MaxNativeAdLoaderImpl.this.a(((MaxErrorImpl) maxError).getLoadTag());
            j.a(MaxNativeAdLoaderImpl.this.d, str, maxError, true);
        }

        public void onAdLoaded(final MaxAd maxAd) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    MaxNativeAdLoaderImpl.this.logger.b(MaxNativeAdLoaderImpl.this.tag, "Native ad loaded");
                    d dVar = (d) maxAd;
                    dVar.e(MaxNativeAdLoaderImpl.this.b);
                    dVar.f(MaxNativeAdLoaderImpl.this.c);
                    MaxNativeAdView a2 = MaxNativeAdLoaderImpl.this.a(dVar.a());
                    if (a2 == null) {
                        MaxNativeAdLoaderImpl.this.logger.b(MaxNativeAdLoaderImpl.this.tag, "No custom view provided, checking template");
                        String v = dVar.v();
                        if (StringUtils.isValidString(v)) {
                            u uVar = MaxNativeAdLoaderImpl.this.logger;
                            String str = MaxNativeAdLoaderImpl.this.tag;
                            uVar.b(str, "Using template: " + v + "...");
                            a2 = new MaxNativeAdView(v, MaxNativeAdLoaderImpl.this.sdk.L());
                        }
                    }
                    if (a2 == null) {
                        MaxNativeAdLoaderImpl.this.logger.b(MaxNativeAdLoaderImpl.this.tag, "No native ad view to render. Returning the native ad to be rendered later.");
                        j.a(MaxNativeAdLoaderImpl.this.d, (MaxNativeAdView) null, maxAd, true);
                        return;
                    }
                    a.this.a(a2);
                    MaxNativeAdLoaderImpl.this.a(a2, dVar, dVar.getNativeAd());
                    j.a(MaxNativeAdLoaderImpl.this.d, a2, maxAd, true);
                    MaxNativeAdLoaderImpl.this.a(a2);
                }
            });
        }

        public void onAdRequestStarted(String str) {
        }

        public void onAdRevenuePaid(MaxAd maxAd) {
            j.a(MaxNativeAdLoaderImpl.this.revenueListener, maxAd, true);
        }
    }

    public MaxNativeAdLoaderImpl(String str, m mVar) {
        super(str, MaxAdFormat.NATIVE, "MaxNativeAdLoader", mVar);
        if (u.a()) {
            u uVar = this.logger;
            String str2 = this.tag;
            uVar.b(str2, "Created new MaxNativeAdLoader (" + this + ")");
        }
    }

    /* access modifiers changed from: private */
    public MaxNativeAdView a(String str) {
        MaxNativeAdView remove;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f) {
            remove = this.e.remove(str);
        }
        return remove;
    }

    /* access modifiers changed from: private */
    public void a(MaxNativeAdView maxNativeAdView) {
        b adViewTracker = maxNativeAdView.getAdViewTracker();
        if (adViewTracker != null) {
            if (g.c()) {
                if (!maxNativeAdView.isAttachedToWindow()) {
                    return;
                }
            } else if (maxNativeAdView.getParent() == null) {
                return;
            }
            adViewTracker.b();
        }
    }

    /* access modifiers changed from: private */
    public void a(final MaxNativeAdView maxNativeAdView, final d dVar, final MaxNativeAd maxNativeAd) {
        dVar.a(maxNativeAdView);
        a(dVar);
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                u uVar = MaxNativeAdLoaderImpl.this.logger;
                String str = MaxNativeAdLoaderImpl.this.tag;
                uVar.b(str, "Rendering native ad view: " + maxNativeAdView);
                maxNativeAdView.render(dVar, MaxNativeAdLoaderImpl.this.a, MaxNativeAdLoaderImpl.this.sdk);
                maxNativeAd.setNativeAdView(maxNativeAdView);
                maxNativeAd.prepareViewForInteraction(maxNativeAdView);
            }
        });
    }

    private void a(String str, MaxNativeAdView maxNativeAdView) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f) {
                this.e.put(str, maxNativeAdView);
            }
        }
    }

    public void destroy() {
        this.d = null;
        super.destroy();
    }

    public void destroy(MaxAd maxAd) {
        if (maxAd instanceof d) {
            d dVar = (d) maxAd;
            if (!dVar.w()) {
                MaxNativeAdView u = dVar.u();
                if (u != null) {
                    b adViewTracker = u.getAdViewTracker();
                    if (adViewTracker != null && maxAd.equals(adViewTracker.c())) {
                        u.recycle();
                    }
                } else if (u.a()) {
                    u uVar = this.logger;
                    String str = this.tag;
                    uVar.b(str, "Destroy failed on native ad(" + dVar + "): native ad view not found");
                }
                this.sdk.E().destroyAd(dVar);
            } else if (u.a()) {
                u uVar2 = this.logger;
                String str2 = this.tag;
                uVar2.b(str2, "Native ad(" + dVar + ") has already been destroyed");
            }
        } else if (u.a()) {
            u uVar3 = this.logger;
            String str3 = this.tag;
            uVar3.b(str3, "Destroy failed on non-native ad(" + maxAd + ")");
        }
    }

    public String getPlacement() {
        return this.b;
    }

    public void loadAd(MaxNativeAdView maxNativeAdView) {
        if (u.a()) {
            u uVar = this.logger;
            String str = this.tag;
            uVar.b(str, "Loading native ad for '" + this.adUnitId + "' and notifying " + this.a + "...");
        }
        this.extraParameters.put("integration_type", maxNativeAdView != null ? "custom_ad_view" : "no_ad_view");
        String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        a(lowerCase, maxNativeAdView);
        this.sdk.E().loadAd(this.adUnitId, lowerCase, MaxAdFormat.NATIVE, this.localExtraParameters, this.extraParameters, this.sdk.L(), this.a);
    }

    public boolean render(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        if (!(maxAd instanceof d)) {
            u.i(this.tag, "Failed to render native ad. `ad` needs to be of type `MediatedNativeAd` to render.");
            return false;
        } else if (maxNativeAdView == null) {
            u.i(this.tag, "Failed to render native ad. `adView` to render cannot be null.");
            return false;
        } else {
            d dVar = (d) maxAd;
            MaxNativeAd nativeAd = dVar.getNativeAd();
            if (nativeAd == null) {
                this.logger.e(this.tag, "Failed to render native ad. Could not retrieve MaxNativeAd. The ad may have already been destroyed.");
                return false;
            }
            a(maxNativeAdView, dVar, nativeAd);
            a(maxNativeAdView);
            return true;
        }
    }

    public void setCustomData(String str) {
        Utils.maybeLogCustomDataSizeLimit(str, this.tag);
        this.c = str;
    }

    public void setNativeAdListener(MaxNativeAdListener maxNativeAdListener) {
        if (u.a()) {
            u uVar = this.logger;
            String str = this.tag;
            uVar.b(str, "Setting native ad listener: " + maxNativeAdListener);
        }
        this.d = maxNativeAdListener;
    }

    public void setPlacement(String str) {
        this.b = str;
    }

    public String toString() {
        return "MaxNativeAdLoader{adUnitId='" + this.adUnitId + "', nativeAdListener=" + this.d + ", revenueListener=" + this.revenueListener + AbstractJsonLexerKt.END_OBJ;
    }
}
