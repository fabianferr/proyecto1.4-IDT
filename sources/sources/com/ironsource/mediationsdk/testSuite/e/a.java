package com.ironsource.mediationsdk.testSuite.e;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.testSuite.c;
import com.ironsource.mediationsdk.testSuite.c.b;
import com.ironsource.mediationsdk.testSuite.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\rH\u0007J\b\u0010\u0011\u001a\u00020\rH\u0007J\b\u0010\u0012\u001a\u00020\rH\u0007J\b\u0010\u0013\u001a\u00020\rH\u0007J8\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007J \u0010\u001e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0007J \u0010\u001f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0007J(\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010%H\u0002J\b\u0010&\u001a\u00020\rH\u0007J\b\u0010'\u001a\u00020\rH\u0007J\b\u0010(\u001a\u00020\rH\u0007R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/ironsource/mediationsdk/testSuite/webView/TestSuiteJavaScriptBridge;", "", "adsManager", "Lcom/ironsource/mediationsdk/testSuite/TestSuiteAdsManager;", "uiLifeCycleListener", "Lcom/ironsource/mediationsdk/testSuite/listeners/ITestSuiteUILifeCycleListener;", "javaScriptEvaluator", "Lcom/ironsource/mediationsdk/testSuite/listeners/TestSuiteJavaScriptEvaluatorListener;", "(Lcom/ironsource/mediationsdk/testSuite/TestSuiteAdsManager;Lcom/ironsource/mediationsdk/testSuite/listeners/ITestSuiteUILifeCycleListener;Lcom/ironsource/mediationsdk/testSuite/listeners/TestSuiteJavaScriptEvaluatorListener;)V", "mAdsManager", "mJavaScriptEvaluator", "mUILifeCycleListener", "addBannerAdToScreen", "", "marginPercentageFromTop", "", "closeTestSuite", "destroyBannerAd", "isInterstitialReady", "isRewardedVideoReady", "loadBannerAd", "adNetwork", "", "isBidding", "", "isTest", "description", "width", "", "height", "loadInterstitialAd", "loadRewardedVideoAd", "onAdCallbackReceived", "callbackName", "adUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "args", "", "onDataLoaded", "showInterstitialAd", "showRewardedVideoAd", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {
    private final com.ironsource.mediationsdk.testSuite.a a;
    private final b b;
    private final com.ironsource.mediationsdk.testSuite.c.a c;

    public a(com.ironsource.mediationsdk.testSuite.a aVar, com.ironsource.mediationsdk.testSuite.c.a aVar2, b bVar) {
        Intrinsics.checkNotNullParameter(aVar, "adsManager");
        Intrinsics.checkNotNullParameter(aVar2, "uiLifeCycleListener");
        Intrinsics.checkNotNullParameter(bVar, "javaScriptEvaluator");
        this.a = aVar;
        this.b = bVar;
        this.c = aVar2;
    }

    private final void a(String str, IronSource.AD_UNIT ad_unit, List<? extends Object> list) {
        this.b.a(str, ad_unit, list);
    }

    @JavascriptInterface
    public final void addBannerAdToScreen(double d) {
        this.a.a(d);
    }

    @JavascriptInterface
    public final void closeTestSuite() {
        destroyBannerAd();
        this.c.onClosed();
    }

    @JavascriptInterface
    public final void destroyBannerAd() {
        this.a.a();
    }

    @JavascriptInterface
    public final void isInterstitialReady() {
        d dVar = d.a;
        boolean g = d.g();
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
        com.ironsource.mediationsdk.testSuite.d.a aVar = com.ironsource.mediationsdk.testSuite.d.a.a;
        a("isInterstitialReady", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(Boolean.valueOf(g)));
    }

    @JavascriptInterface
    public final void isRewardedVideoReady() {
        d dVar = d.a;
        boolean i = d.i();
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
        com.ironsource.mediationsdk.testSuite.d.a aVar = com.ironsource.mediationsdk.testSuite.d.a.a;
        a("isRewardedVideoReady", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(Boolean.valueOf(i)));
    }

    @JavascriptInterface
    public final void loadBannerAd(String str, boolean z, boolean z2, String str2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, ImpressionData.IMPRESSION_DATA_KEY_AD_NETWORK);
        Intrinsics.checkNotNullParameter(str2, "description");
        this.a.a(new c(str, z, Boolean.valueOf(z2)), str2, i, i2);
    }

    @JavascriptInterface
    public final void loadInterstitialAd(String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, ImpressionData.IMPRESSION_DATA_KEY_AD_NETWORK);
        c cVar = new c(str, z, Boolean.valueOf(z2));
        Intrinsics.checkNotNullParameter(cVar, "loadAdConfig");
        d dVar = d.a;
        d.a(IronSource.AD_UNIT.INTERSTITIAL, cVar);
        d dVar2 = d.a;
        d.f();
    }

    @JavascriptInterface
    public final void loadRewardedVideoAd(String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, ImpressionData.IMPRESSION_DATA_KEY_AD_NETWORK);
        c cVar = new c(str, z, Boolean.valueOf(z2));
        Intrinsics.checkNotNullParameter(cVar, "loadAdConfig");
        d dVar = d.a;
        d.a(IronSource.AD_UNIT.REWARDED_VIDEO, cVar);
        d dVar2 = d.a;
        d.h();
    }

    @JavascriptInterface
    public final void onDataLoaded() {
        this.c.onUIReady();
    }

    @JavascriptInterface
    public final void showInterstitialAd() {
        com.ironsource.mediationsdk.testSuite.a aVar = this.a;
        d dVar = d.a;
        d.a((Activity) aVar.a.get());
    }

    @JavascriptInterface
    public final void showRewardedVideoAd() {
        com.ironsource.mediationsdk.testSuite.a aVar = this.a;
        d dVar = d.a;
        d.b((Activity) aVar.a.get());
    }
}
