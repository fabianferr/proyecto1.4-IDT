package com.applovin.impl.mediation.debugger.ui.testmode;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.DTBAdResponse;
import com.applovin.impl.mediation.debugger.a.a;
import com.applovin.impl.mediation.debugger.b.b.b;
import com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.ads.MaxRewardedAd;
import com.applovin.mediation.ads.MaxRewardedInterstitialAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import java.util.Map;

public class a extends com.applovin.impl.mediation.debugger.ui.a implements a.C0014a, AdControlButton.a, MaxAdRevenueListener, MaxAdViewAdListener, MaxRewardedAdListener {
    private b a;
    private m b;
    private MaxAdView c;
    private MaxAdView d;
    private MaxInterstitialAd e;
    private MaxRewardedInterstitialAd f;
    private MaxRewardedAd g;
    /* access modifiers changed from: private */
    public MaxAd h;
    /* access modifiers changed from: private */
    public MaxNativeAdLoader i;
    private String j;
    private AdControlButton k;
    private AdControlButton l;
    private AdControlButton m;
    private AdControlButton n;
    private AdControlButton o;
    private AdControlButton p;
    /* access modifiers changed from: private */
    public Button q;
    /* access modifiers changed from: private */
    public Button r;
    /* access modifiers changed from: private */
    public FrameLayout s;
    /* access modifiers changed from: private */
    public FrameLayout t;
    private Map<MaxAdFormat, com.applovin.impl.mediation.debugger.a.a> u;

    private AdControlButton a(String str) {
        if (str.equals("test_mode_banner") || str.equals("test_mode_leader")) {
            return this.k;
        }
        if (str.equals("test_mode_mrec")) {
            return this.l;
        }
        if (str.equals("test_mode_interstitial")) {
            return this.m;
        }
        if (str.equals("test_mode_rewarded_interstitial")) {
            return this.n;
        }
        if (str.equals(this.j)) {
            return this.o;
        }
        if (str.equals("test_mode_native")) {
            return this.p;
        }
        throw new IllegalArgumentException("Invalid test mode ad unit identifier provided " + str);
    }

    private void a() {
        String str;
        MaxAdFormat maxAdFormat;
        boolean isTablet = AppLovinSdkUtils.isTablet(this);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.banner_ad_view_container);
        if (isTablet) {
            maxAdFormat = MaxAdFormat.LEADER;
            ((TextView) findViewById(R.id.banner_label)).setText("Leader");
            str = "test_mode_leader";
        } else {
            maxAdFormat = MaxAdFormat.BANNER;
            str = "test_mode_banner";
        }
        if (this.a.p().contains(maxAdFormat)) {
            MaxAdView maxAdView = new MaxAdView(str, maxAdFormat, this.b.Y(), this);
            this.c = maxAdView;
            maxAdView.setExtraParameter(AppLovinSdkExtraParameterKey.IS_ADAPTIVE_BANNER, "false");
            this.c.setListener(this);
            frameLayout.addView(this.c, new FrameLayout.LayoutParams(AppLovinSdkUtils.dpToPx(this, maxAdFormat.getSize().getWidth()), AppLovinSdkUtils.dpToPx(this, maxAdFormat.getSize().getHeight())));
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.banner_control_button);
            this.k = adControlButton;
            adControlButton.setOnClickListener(this);
            this.k.setFormat(maxAdFormat);
            return;
        }
        findViewById(R.id.banner_control_view).setVisibility(8);
        frameLayout.setVisibility(8);
    }

    private void a(MaxAdFormat maxAdFormat) {
        MaxAdView maxAdView;
        this.b.J().a(getTestModeNetwork(maxAdFormat));
        if (MaxAdFormat.BANNER == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) {
            maxAdView = this.c;
        } else if (MaxAdFormat.MREC == maxAdFormat) {
            maxAdView = this.d;
        } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.e.loadAd();
            return;
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.f.loadAd();
            return;
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.g.loadAd();
            return;
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.i.loadAd();
            return;
        } else {
            return;
        }
        maxAdView.loadAd();
    }

    private void b() {
        this.s = (FrameLayout) findViewById(R.id.mrec_ad_view_container);
        if (this.a.p().contains(MaxAdFormat.MREC)) {
            MaxAdView maxAdView = new MaxAdView("test_mode_mrec", MaxAdFormat.MREC, this.b.Y(), this);
            this.d = maxAdView;
            maxAdView.setListener(this);
            this.s.addView(this.d, new FrameLayout.LayoutParams(-1, -1));
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.mrec_control_button);
            this.l = adControlButton;
            adControlButton.setOnClickListener(this);
            this.l.setFormat(MaxAdFormat.MREC);
            return;
        }
        findViewById(R.id.mrec_control_view).setVisibility(8);
        this.s.setVisibility(8);
    }

    private void b(MaxAdFormat maxAdFormat) {
        if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.e.showAd();
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.f.showAd();
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.g.showAd();
        }
    }

    private void c() {
        if (this.a.p().contains(MaxAdFormat.INTERSTITIAL)) {
            MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd("test_mode_interstitial", this.b.Y(), this);
            this.e = maxInterstitialAd;
            maxInterstitialAd.setListener(this);
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.interstitial_control_button);
            this.m = adControlButton;
            adControlButton.setOnClickListener(this);
            this.m.setFormat(MaxAdFormat.INTERSTITIAL);
            return;
        }
        findViewById(R.id.interstitial_control_view).setVisibility(8);
    }

    private void d() {
        if (this.a.p().contains(MaxAdFormat.REWARDED)) {
            String str = "test_mode_rewarded_" + this.a.h();
            this.j = str;
            MaxRewardedAd instance = MaxRewardedAd.getInstance(str, this.b.Y(), this);
            this.g = instance;
            instance.setListener(this);
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.rewarded_control_button);
            this.o = adControlButton;
            adControlButton.setOnClickListener(this);
            this.o.setFormat(MaxAdFormat.REWARDED);
            return;
        }
        findViewById(R.id.rewarded_control_view).setVisibility(8);
    }

    private void e() {
        this.t = (FrameLayout) findViewById(R.id.native_ad_view_container);
        if (this.a.q()) {
            MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader("test_mode_native", this.b.Y(), this);
            this.i = maxNativeAdLoader;
            maxNativeAdLoader.setNativeAdListener(new MaxNativeAdListener() {
                public void onNativeAdClicked(MaxAd maxAd) {
                    a.this.onAdClicked(maxAd);
                }

                public void onNativeAdLoadFailed(String str, MaxError maxError) {
                    a.this.onAdLoadFailed(str, maxError);
                }

                public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
                    if (a.this.h != null) {
                        a.this.i.destroy(a.this.h);
                    }
                    MaxAd unused = a.this.h = maxAd;
                    a.this.t.removeAllViews();
                    a.this.t.addView(maxNativeAdView);
                    a.this.onAdLoaded(maxAd);
                }
            });
            this.i.setRevenueListener(this);
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.native_control_button);
            this.p = adControlButton;
            adControlButton.setOnClickListener(this);
            this.p.setFormat(MaxAdFormat.NATIVE);
            return;
        }
        findViewById(R.id.native_control_view).setVisibility(8);
        this.t.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public m getSdk() {
        return this.b;
    }

    public String getTestModeNetwork(MaxAdFormat maxAdFormat) {
        return (this.a.u() == null || !this.a.u().containsKey(maxAdFormat)) ? this.a.h() : this.a.u().get(maxAdFormat);
    }

    public void initialize(b bVar) {
        this.a = bVar;
        this.b = bVar.x();
    }

    public void onAdClicked(MaxAd maxAd) {
        Utils.showToast("onAdClicked", maxAd, this);
    }

    public void onAdCollapsed(MaxAd maxAd) {
        Utils.showToast("onAdCollapsed", maxAd, this);
    }

    public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        a(maxAd.getAdUnitId()).setControlState(AdControlButton.b.LOAD);
        Utils.showAlert("Failed to display " + maxAd.getFormat().getDisplayName(), "MAX Error\nCode: " + maxError.getCode() + "\nMessage: " + maxError.getMessage() + "\n\n" + maxAd.getNetworkName() + " Display Error\nCode: " + maxError.getMediatedNetworkErrorCode() + "\nMessage: " + maxError.getMediatedNetworkErrorMessage(), this);
    }

    public void onAdDisplayed(MaxAd maxAd) {
        Utils.showToast("onAdDisplayed", maxAd, this);
    }

    public void onAdExpanded(MaxAd maxAd) {
        Utils.showToast("onAdExpanded", maxAd, this);
    }

    public void onAdHidden(MaxAd maxAd) {
        Utils.showToast("onAdHidden", maxAd, this);
    }

    public void onAdLoadFailed(AdError adError, MaxAdFormat maxAdFormat) {
        MaxAdView maxAdView;
        if (MaxAdFormat.BANNER == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) {
            maxAdView = this.c;
        } else if (MaxAdFormat.MREC == maxAdFormat) {
            maxAdView = this.d;
        } else {
            if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
                this.e.setLocalExtraParameter("amazon_ad_error", adError);
            } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
                this.f.setLocalExtraParameter("amazon_ad_error", adError);
            } else if (MaxAdFormat.REWARDED == maxAdFormat) {
                this.g.setLocalExtraParameter("amazon_ad_error", adError);
            } else if (MaxAdFormat.NATIVE == maxAdFormat) {
                this.i.setLocalExtraParameter("amazon_ad_error", adError);
            }
            a(maxAdFormat);
        }
        maxAdView.setLocalExtraParameter("amazon_ad_error", adError);
        a(maxAdFormat);
    }

    public void onAdLoadFailed(String str, MaxError maxError) {
        AdControlButton a2 = a(str);
        a2.setControlState(AdControlButton.b.LOAD);
        Utils.showAlert("", "Failed to load " + a2.getFormat().getLabel() + " with error code: " + maxError.getCode(), this);
    }

    public void onAdLoaded(MaxAd maxAd) {
        a(maxAd.getAdUnitId()).setControlState((maxAd.getFormat().isAdViewAd() || maxAd.getFormat().equals(MaxAdFormat.NATIVE)) ? AdControlButton.b.LOAD : AdControlButton.b.SHOW);
    }

    public void onAdResponseLoaded(DTBAdResponse dTBAdResponse, MaxAdFormat maxAdFormat) {
        MaxAdView maxAdView;
        if (MaxAdFormat.BANNER == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) {
            maxAdView = this.c;
        } else if (MaxAdFormat.MREC == maxAdFormat) {
            maxAdView = this.d;
        } else {
            if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
                this.e.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
            } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
                this.f.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
            } else if (MaxAdFormat.REWARDED == maxAdFormat) {
                this.g.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
            } else if (MaxAdFormat.NATIVE == maxAdFormat) {
                this.i.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
            }
            a(maxAdFormat);
        }
        maxAdView.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        a(maxAdFormat);
    }

    public void onAdRevenuePaid(MaxAd maxAd) {
        Utils.showToast("onAdRevenuePaid", maxAd, this);
    }

    public void onClick(AdControlButton adControlButton) {
        MaxAdFormat format = adControlButton.getFormat();
        if (AdControlButton.b.LOAD == adControlButton.getControlState()) {
            adControlButton.setControlState(AdControlButton.b.LOADING);
            Map<MaxAdFormat, com.applovin.impl.mediation.debugger.a.a> map = this.u;
            if (map == null || map.get(format) == null) {
                a(format);
            } else {
                this.u.get(format).a();
            }
        } else if (AdControlButton.b.SHOW == adControlButton.getControlState()) {
            adControlButton.setControlState(AdControlButton.b.LOAD);
            b(format);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.a == null) {
            u.i("MaxDebuggerMultiAdActivity", "Failed to initialize activity with a network model.");
            return;
        }
        setContentView(R.layout.mediation_debugger_multi_ad_activity);
        setTitle(this.a.i() + " Test Ads");
        a();
        b();
        c();
        d();
        e();
        findViewById(R.id.rewarded_interstitial_control_view).setVisibility(8);
        this.q = (Button) findViewById(R.id.show_mrec_button);
        this.r = (Button) findViewById(R.id.show_native_button);
        if (!this.a.q() || !this.a.p().contains(MaxAdFormat.MREC)) {
            this.q.setVisibility(8);
            this.r.setVisibility(8);
        } else {
            this.t.setVisibility(8);
            this.q.setBackgroundColor(-1);
            this.r.setBackgroundColor(-3355444);
            this.q.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    a.this.s.setVisibility(0);
                    a.this.t.setVisibility(8);
                    a.this.q.setBackgroundColor(-1);
                    a.this.r.setBackgroundColor(-3355444);
                }
            });
            this.r.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    a.this.t.setVisibility(0);
                    a.this.s.setVisibility(8);
                    a.this.r.setBackgroundColor(-1);
                    a.this.q.setBackgroundColor(-3355444);
                }
            });
        }
        if (StringUtils.isValidString(this.a.A()) && this.a.B() != null && this.a.B().size() > 0) {
            AdRegistration.getInstance(this.a.A(), this);
            AdRegistration.enableTesting(true);
            AdRegistration.enableLogging(true);
            Map<MaxAdFormat, com.applovin.impl.mediation.debugger.a.a> map = CollectionUtils.map(this.a.B().size());
            for (MaxAdFormat next : this.a.B().keySet()) {
                map.put(next, new com.applovin.impl.mediation.debugger.a.a(this.a.B().get(next), next, (a.C0014a) this));
            }
            this.u = map;
        }
        try {
            setRequestedOrientation(7);
        } catch (Throwable th) {
            u.c("AppLovinSdk", "Failed to set portrait orientation", th);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        MaxAd maxAd;
        super.onDestroy();
        this.b.J().a((String) null);
        MaxAdView maxAdView = this.c;
        if (maxAdView != null) {
            maxAdView.destroy();
        }
        MaxAdView maxAdView2 = this.d;
        if (maxAdView2 != null) {
            maxAdView2.destroy();
        }
        MaxInterstitialAd maxInterstitialAd = this.e;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.destroy();
        }
        MaxRewardedAd maxRewardedAd = this.g;
        if (maxRewardedAd != null) {
            maxRewardedAd.destroy();
        }
        MaxNativeAdLoader maxNativeAdLoader = this.i;
        if (maxNativeAdLoader != null && (maxAd = this.h) != null) {
            maxNativeAdLoader.destroy(maxAd);
        }
    }

    public void onRewardedVideoCompleted(MaxAd maxAd) {
        Utils.showToast("onRewardedVideoCompleted", maxAd, this);
    }

    public void onRewardedVideoStarted(MaxAd maxAd) {
        Utils.showToast("onRewardedVideoStarted", maxAd, this);
    }

    public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
        Utils.showToast("onUserRewarded", maxAd, this);
    }
}
