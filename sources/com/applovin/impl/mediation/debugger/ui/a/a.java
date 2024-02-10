package com.applovin.impl.mediation.debugger.ui.a;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.DTBAdResponse;
import com.applovin.impl.mediation.debugger.a.a;
import com.applovin.impl.mediation.debugger.b.a.b;
import com.applovin.impl.mediation.debugger.ui.a;
import com.applovin.impl.mediation.debugger.ui.a.b;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
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
import java.util.List;

public class a extends com.applovin.impl.mediation.debugger.ui.a implements a.C0014a, AdControlButton.a, MaxAdRevenueListener, MaxAdViewAdListener, MaxRewardedAdListener {
    /* access modifiers changed from: private */
    public m a;
    private com.applovin.impl.mediation.debugger.b.a.a b;
    private b c;
    private b d;
    /* access modifiers changed from: private */
    public MaxAdView e;
    private MaxInterstitialAd f;
    private MaxRewardedInterstitialAd g;
    private MaxRewardedAd h;
    /* access modifiers changed from: private */
    public MaxNativeAdView i;
    /* access modifiers changed from: private */
    public MaxNativeAdLoader j;
    /* access modifiers changed from: private */
    public d k;
    private ListView l;
    private View m;
    private AdControlButton n;
    private TextView o;
    private com.applovin.impl.mediation.debugger.a.a p;

    private void a() {
        String a2 = this.b.a();
        if (this.b.d().isAdViewAd()) {
            MaxAdView maxAdView = new MaxAdView(a2, this.b.d(), this.a.Y(), this);
            this.e = maxAdView;
            maxAdView.setExtraParameter(AppLovinSdkExtraParameterKey.IS_ADAPTIVE_BANNER, "false");
            this.e.setListener(this);
        } else if (MaxAdFormat.INTERSTITIAL == this.b.d()) {
            MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd(a2, this.a.Y(), this);
            this.f = maxInterstitialAd;
            maxInterstitialAd.setListener(this);
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == this.b.d()) {
            MaxRewardedInterstitialAd maxRewardedInterstitialAd = new MaxRewardedInterstitialAd(a2, this.a.Y(), this);
            this.g = maxRewardedInterstitialAd;
            maxRewardedInterstitialAd.setListener(this);
        } else if (MaxAdFormat.REWARDED == this.b.d()) {
            MaxRewardedAd instance = MaxRewardedAd.getInstance(a2, this.a.Y(), this);
            this.h = instance;
            instance.setListener(this);
        } else if (MaxAdFormat.NATIVE == this.b.d()) {
            MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader(a2, this.a.Y(), this);
            this.j = maxNativeAdLoader;
            maxNativeAdLoader.setNativeAdListener(new MaxNativeAdListener() {
                public void onNativeAdClicked(MaxAd maxAd) {
                    a.this.onAdClicked(maxAd);
                }

                public void onNativeAdLoadFailed(String str, MaxError maxError) {
                    a.this.onAdLoadFailed(str, maxError);
                }

                public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
                    if (maxNativeAdView != null) {
                        MaxNativeAdView unused = a.this.i = maxNativeAdView;
                    } else {
                        MaxNativeAdView unused2 = a.this.i = new MaxNativeAdView(MaxNativeAdView.MEDIUM_TEMPLATE_1, a.this.a.L());
                        a.this.j.render(a.this.i, maxAd);
                    }
                    a.this.onAdLoaded(maxAd);
                }
            });
            this.j.setRevenueListener(this);
        }
    }

    private void a(final ViewGroup viewGroup, AppLovinSdkUtils.Size size, DialogInterface.OnShowListener onShowListener) {
        if (this.k == null) {
            d dVar = new d(viewGroup, size, this);
            this.k = dVar;
            dVar.setOnShowListener(onShowListener);
            this.k.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    ViewGroup viewGroup = viewGroup;
                    if (viewGroup instanceof MaxAdView) {
                        ((MaxAdView) viewGroup).stopAutoRefresh();
                    }
                    d unused = a.this.k = null;
                }
            });
            this.k.show();
        }
    }

    private void a(MaxAdFormat maxAdFormat) {
        if (this.d != null) {
            this.a.J().a(this.d.a().a());
            this.a.J().a(true);
        }
        if (maxAdFormat.isAdViewAd()) {
            this.e.setPlacement("[Mediation Debugger Live Ad]");
            this.e.loadAd();
        } else if (MaxAdFormat.INTERSTITIAL == this.b.d()) {
            this.f.loadAd();
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == this.b.d()) {
            this.g.loadAd();
        } else if (MaxAdFormat.REWARDED == this.b.d()) {
            this.h.loadAd();
        } else if (MaxAdFormat.NATIVE == this.b.d()) {
            this.j.setPlacement("[Mediation Debugger Live Ad]");
            this.j.loadAd();
        } else {
            Utils.showToast("Live ads currently unavailable for ad format", this);
        }
    }

    private void b(MaxAdFormat maxAdFormat) {
        if (maxAdFormat.isAdViewAd()) {
            a(this.e, maxAdFormat.getSize(), new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    a.this.e.startAutoRefresh();
                }
            });
        } else if (MaxAdFormat.INTERSTITIAL == this.b.d()) {
            this.f.showAd("[Mediation Debugger Live Ad]");
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == this.b.d()) {
            this.g.showAd("[Mediation Debugger Live Ad]");
        } else if (MaxAdFormat.REWARDED == this.b.d()) {
            this.h.showAd("[Mediation Debugger Live Ad]");
        } else if (MaxAdFormat.NATIVE == this.b.d()) {
            a(this.i, MaxAdFormat.MREC.getSize(), (DialogInterface.OnShowListener) null);
        }
    }

    /* access modifiers changed from: protected */
    public m getSdk() {
        return this.a;
    }

    public void initialize(final com.applovin.impl.mediation.debugger.b.a.a aVar, b bVar, final m mVar) {
        List<?> a2;
        this.a = mVar;
        this.b = aVar;
        this.d = bVar;
        b bVar2 = new b(aVar, bVar, this);
        this.c = bVar2;
        bVar2.a((d.a) new d.a() {
            public void a(com.applovin.impl.mediation.debugger.ui.d.a aVar, final c cVar) {
                if (cVar instanceof b.a) {
                    a.this.startActivity(MaxDebuggerAdUnitDetailActivity.class, mVar.af(), new a.C0016a<MaxDebuggerAdUnitDetailActivity>() {
                        public void a(MaxDebuggerAdUnitDetailActivity maxDebuggerAdUnitDetailActivity) {
                            maxDebuggerAdUnitDetailActivity.initialize(aVar, ((b.a) cVar).a(), mVar);
                        }
                    });
                }
            }
        });
        a();
        if (!aVar.e().d()) {
            return;
        }
        if ((bVar == null || bVar.a().c().z()) && (a2 = mVar.G().a(aVar.a())) != null && !a2.isEmpty()) {
            this.p = new com.applovin.impl.mediation.debugger.a.a(a2, aVar.d(), (a.C0014a) this);
        }
    }

    public void onAdClicked(MaxAd maxAd) {
        Utils.showToast("onAdClicked", maxAd, this);
    }

    public void onAdCollapsed(MaxAd maxAd) {
        Utils.showToast("onAdCollapsed", maxAd, this);
    }

    public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        this.n.setControlState(AdControlButton.b.LOAD);
        this.o.setText("");
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
        if (maxAdFormat.isAdViewAd()) {
            this.e.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.g.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.h.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.j.setLocalExtraParameter("amazon_ad_error", adError);
        }
        a(maxAdFormat);
    }

    public void onAdLoadFailed(String str, MaxError maxError) {
        this.n.setControlState(AdControlButton.b.LOAD);
        this.o.setText("");
        if (204 == maxError.getCode()) {
            Utils.showAlert("No Fill", "No fills often happen in live environments. Please make sure to use the Mediation Debugger test mode before you go live.", this);
            return;
        }
        Utils.showAlert("", "Failed to load with error code: " + maxError.getCode(), this);
    }

    public void onAdLoaded(MaxAd maxAd) {
        TextView textView = this.o;
        textView.setText(maxAd.getNetworkName() + " ad loaded");
        this.n.setControlState(AdControlButton.b.SHOW);
        if (maxAd.getFormat().isAdViewAd()) {
            a(this.e, maxAd.getFormat().getSize(), (DialogInterface.OnShowListener) null);
        } else if (MaxAdFormat.NATIVE == this.b.d()) {
            a(this.i, MaxAdFormat.MREC.getSize(), (DialogInterface.OnShowListener) null);
        }
    }

    public void onAdResponseLoaded(DTBAdResponse dTBAdResponse, MaxAdFormat maxAdFormat) {
        if (maxAdFormat.isAdViewAd()) {
            this.e.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.g.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.h.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.j.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        }
        a(maxAdFormat);
    }

    public void onAdRevenuePaid(MaxAd maxAd) {
        Utils.showToast("onAdRevenuePaid", maxAd, this);
    }

    public void onClick(AdControlButton adControlButton) {
        if (this.a.J().a()) {
            Utils.showAlert("Not Supported", "Ad loads are not supported while Test Mode is enabled. Please restart the app.", this);
            return;
        }
        MaxAdFormat d2 = this.b.d();
        if (AdControlButton.b.LOAD == adControlButton.getControlState()) {
            adControlButton.setControlState(AdControlButton.b.LOADING);
            com.applovin.impl.mediation.debugger.a.a aVar = this.p;
            if (aVar != null) {
                aVar.a();
            } else {
                a(d2);
            }
        } else if (AdControlButton.b.SHOW == adControlButton.getControlState()) {
            if (!d2.isAdViewAd() && d2 != MaxAdFormat.NATIVE) {
                adControlButton.setControlState(AdControlButton.b.LOAD);
            }
            b(d2);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_ad_unit_detail_activity);
        setTitle(this.c.a());
        this.l = (ListView) findViewById(R.id.listView);
        this.m = findViewById(R.id.ad_presenter_view);
        this.n = (AdControlButton) findViewById(R.id.ad_control_button);
        this.o = (TextView) findViewById(R.id.status_textview);
        this.l.setAdapter(this.c);
        this.o.setText(this.a.J().a() ? "Not Supported while Test Mode is enabled" : "Tap to load an ad");
        this.o.setTypeface(Typeface.DEFAULT_BOLD);
        this.n.setOnClickListener(this);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setPadding(0, 10, 0, 0);
        shapeDrawable.getPaint().setColor(-1);
        shapeDrawable.getPaint().setShadowLayer((float) 10, 0.0f, (float) -10, 855638016);
        shapeDrawable.setShape(new RectShape());
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable});
        layerDrawable.setLayerInset(0, 0, 10, 0, 0);
        this.m.setBackground(layerDrawable);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            this.a.J().a((String) null);
            this.a.J().a(false);
        }
        MaxAdView maxAdView = this.e;
        if (maxAdView != null) {
            maxAdView.destroy();
        }
        MaxInterstitialAd maxInterstitialAd = this.f;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.destroy();
        }
        MaxRewardedAd maxRewardedAd = this.h;
        if (maxRewardedAd != null) {
            maxRewardedAd.destroy();
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
