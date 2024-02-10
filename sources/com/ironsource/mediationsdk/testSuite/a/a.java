package com.ironsource.mediationsdk.testSuite.a;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.LevelPlayBannerListener;
import com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoManualListener;
import com.ironsource.mediationsdk.testSuite.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0006\u001a\u00020\u0007J(\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\u0006\u0010\u0011\u001a\u00020\u0007R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ironsource/mediationsdk/testSuite/adBridge/TestSuiteNativeBridge;", "", "javaScriptEvaluator", "Lcom/ironsource/mediationsdk/testSuite/listeners/TestSuiteJavaScriptEvaluatorListener;", "(Lcom/ironsource/mediationsdk/testSuite/listeners/TestSuiteJavaScriptEvaluatorListener;)V", "mJavaScriptEvaluator", "cleanTestSuiteObject", "", "onAdCallbackReceived", "callbackName", "", "adUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "args", "", "removeTestSuiteListeners", "resetAdLoadConfigObjects", "setupTestSuiteListeners", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {
    private final com.ironsource.mediationsdk.testSuite.c.b a;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\f\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000e"}, d2 = {"com/ironsource/mediationsdk/testSuite/adBridge/TestSuiteNativeBridge$setupTestSuiteListeners$1", "Lcom/ironsource/mediationsdk/sdk/LevelPlayInterstitialListener;", "onAdClicked", "", "adInfo", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdInfo;", "onAdClosed", "onAdLoadFailed", "error", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "onAdOpened", "onAdReady", "onAdShowFailed", "onAdShowSucceeded", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.ironsource.mediationsdk.testSuite.a.a$a  reason: collision with other inner class name */
    public static final class C0115a implements LevelPlayInterstitialListener {
        private /* synthetic */ a a;

        public C0115a(a aVar) {
            this.a = aVar;
        }

        public final void onAdClicked(AdInfo adInfo) {
            a aVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
            com.ironsource.mediationsdk.testSuite.d.a aVar2 = com.ironsource.mediationsdk.testSuite.d.a.a;
            aVar.a.a("onAdClicked", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(adInfo));
        }

        public final void onAdClosed(AdInfo adInfo) {
            a aVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
            com.ironsource.mediationsdk.testSuite.d.a aVar2 = com.ironsource.mediationsdk.testSuite.d.a.a;
            aVar.a.a("onAdClosed", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(adInfo));
        }

        public final void onAdLoadFailed(IronSourceError ironSourceError) {
            a aVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
            com.ironsource.mediationsdk.testSuite.d.a aVar2 = com.ironsource.mediationsdk.testSuite.d.a.a;
            Object[] objArr = new Object[1];
            objArr[0] = ironSourceError != null ? ironSourceError.getErrorMessage() : null;
            aVar.a.a("onAdLoadFailed", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(objArr));
        }

        public final void onAdOpened(AdInfo adInfo) {
            a aVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
            com.ironsource.mediationsdk.testSuite.d.a aVar2 = com.ironsource.mediationsdk.testSuite.d.a.a;
            aVar.a.a("onAdOpened", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(adInfo));
        }

        public final void onAdReady(AdInfo adInfo) {
            a aVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
            com.ironsource.mediationsdk.testSuite.d.a aVar2 = com.ironsource.mediationsdk.testSuite.d.a.a;
            aVar.a.a("onAdReady", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(adInfo));
        }

        public final void onAdShowFailed(IronSourceError ironSourceError, AdInfo adInfo) {
            a aVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
            com.ironsource.mediationsdk.testSuite.d.a aVar2 = com.ironsource.mediationsdk.testSuite.d.a.a;
            Object[] objArr = new Object[2];
            objArr[0] = ironSourceError != null ? ironSourceError.getErrorMessage() : null;
            objArr[1] = adInfo;
            aVar.a.a("onAdShowFailed", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(objArr));
        }

        public final void onAdShowSucceeded(AdInfo adInfo) {
            a aVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
            com.ironsource.mediationsdk.testSuite.d.a aVar2 = com.ironsource.mediationsdk.testSuite.d.a.a;
            aVar.a.a("onAdShowSucceeded", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(adInfo));
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0010\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0011\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016¨\u0006\u0013"}, d2 = {"com/ironsource/mediationsdk/testSuite/adBridge/TestSuiteNativeBridge$setupTestSuiteListeners$2", "Lcom/ironsource/mediationsdk/sdk/LevelPlayRewardedVideoManualListener;", "Lcom/ironsource/mediationsdk/sdk/LevelPlayRewardedVideoListener;", "onAdAvailable", "", "adInfo", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdInfo;", "onAdClicked", "placement", "Lcom/ironsource/mediationsdk/model/Placement;", "onAdClosed", "onAdLoadFailed", "error", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "onAdOpened", "onAdReady", "onAdRewarded", "onAdShowFailed", "onAdUnavailable", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements LevelPlayRewardedVideoListener, LevelPlayRewardedVideoManualListener {
        private /* synthetic */ a a;

        public b(a aVar) {
            this.a = aVar;
        }

        public final void onAdAvailable(AdInfo adInfo) {
            a aVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
            com.ironsource.mediationsdk.testSuite.d.a aVar2 = com.ironsource.mediationsdk.testSuite.d.a.a;
            aVar.a.a("onAdAvailable", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(adInfo));
        }

        public final void onAdClicked(Placement placement, AdInfo adInfo) {
            a aVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
            com.ironsource.mediationsdk.testSuite.d.a aVar2 = com.ironsource.mediationsdk.testSuite.d.a.a;
            d dVar = d.a;
            aVar.a.a("onAdClicked", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(d.a(placement), adInfo));
        }

        public final void onAdClosed(AdInfo adInfo) {
            a aVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
            com.ironsource.mediationsdk.testSuite.d.a aVar2 = com.ironsource.mediationsdk.testSuite.d.a.a;
            aVar.a.a("onAdClosed", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(adInfo));
        }

        public final void onAdLoadFailed(IronSourceError ironSourceError) {
            a aVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
            com.ironsource.mediationsdk.testSuite.d.a aVar2 = com.ironsource.mediationsdk.testSuite.d.a.a;
            Object[] objArr = new Object[1];
            objArr[0] = ironSourceError != null ? ironSourceError.getErrorMessage() : null;
            aVar.a.a("onAdLoadFailed", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(objArr));
        }

        public final void onAdOpened(AdInfo adInfo) {
            a aVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
            com.ironsource.mediationsdk.testSuite.d.a aVar2 = com.ironsource.mediationsdk.testSuite.d.a.a;
            aVar.a.a("onAdOpened", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(adInfo));
        }

        public final void onAdReady(AdInfo adInfo) {
            a aVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
            com.ironsource.mediationsdk.testSuite.d.a aVar2 = com.ironsource.mediationsdk.testSuite.d.a.a;
            aVar.a.a("onAdReady", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(adInfo));
        }

        public final void onAdRewarded(Placement placement, AdInfo adInfo) {
            a aVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
            com.ironsource.mediationsdk.testSuite.d.a aVar2 = com.ironsource.mediationsdk.testSuite.d.a.a;
            d dVar = d.a;
            aVar.a.a("onAdRewarded", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(d.a(placement), adInfo));
        }

        public final void onAdShowFailed(IronSourceError ironSourceError, AdInfo adInfo) {
            a aVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
            com.ironsource.mediationsdk.testSuite.d.a aVar2 = com.ironsource.mediationsdk.testSuite.d.a.a;
            Object[] objArr = new Object[2];
            objArr[0] = ironSourceError != null ? ironSourceError.getErrorMessage() : null;
            objArr[1] = adInfo;
            aVar.a.a("onAdShowFailed", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(objArr));
        }

        public final void onAdUnavailable() {
            a aVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
            com.ironsource.mediationsdk.testSuite.d.a aVar2 = com.ironsource.mediationsdk.testSuite.d.a.a;
            aVar.a.a("onAdUnavailable", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(new Object[0]));
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\r"}, d2 = {"com/ironsource/mediationsdk/testSuite/adBridge/TestSuiteNativeBridge$setupTestSuiteListeners$3", "Lcom/ironsource/mediationsdk/sdk/LevelPlayBannerListener;", "onAdClicked", "", "adInfo", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdInfo;", "onAdLeftApplication", "onAdLoadFailed", "error", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "onAdLoaded", "onAdScreenDismissed", "onAdScreenPresented", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements LevelPlayBannerListener {
        private /* synthetic */ a a;

        public c(a aVar) {
            this.a = aVar;
        }

        public final void onAdClicked(AdInfo adInfo) {
            a aVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
            com.ironsource.mediationsdk.testSuite.d.a aVar2 = com.ironsource.mediationsdk.testSuite.d.a.a;
            aVar.a.a("onAdClicked", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(adInfo));
        }

        public final void onAdLeftApplication(AdInfo adInfo) {
            a aVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
            com.ironsource.mediationsdk.testSuite.d.a aVar2 = com.ironsource.mediationsdk.testSuite.d.a.a;
            aVar.a.a("onAdLeftApplication", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(adInfo));
        }

        public final void onAdLoadFailed(IronSourceError ironSourceError) {
            a aVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
            com.ironsource.mediationsdk.testSuite.d.a aVar2 = com.ironsource.mediationsdk.testSuite.d.a.a;
            Object[] objArr = new Object[1];
            objArr[0] = ironSourceError != null ? ironSourceError.getErrorMessage() : null;
            aVar.a.a("onAdLoadFailed", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(objArr));
        }

        public final void onAdLoaded(AdInfo adInfo) {
            a aVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
            com.ironsource.mediationsdk.testSuite.d.a aVar2 = com.ironsource.mediationsdk.testSuite.d.a.a;
            aVar.a.a("onAdLoaded", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(adInfo));
        }

        public final void onAdScreenDismissed(AdInfo adInfo) {
            a aVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
            com.ironsource.mediationsdk.testSuite.d.a aVar2 = com.ironsource.mediationsdk.testSuite.d.a.a;
            aVar.a.a("onAdScreenDismissed", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(adInfo));
        }

        public final void onAdScreenPresented(AdInfo adInfo) {
            a aVar = this.a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
            com.ironsource.mediationsdk.testSuite.d.a aVar2 = com.ironsource.mediationsdk.testSuite.d.a.a;
            aVar.a.a("onAdScreenPresented", ad_unit, com.ironsource.mediationsdk.testSuite.d.a.a(adInfo));
        }
    }

    public a(com.ironsource.mediationsdk.testSuite.c.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "javaScriptEvaluator");
        this.a = bVar;
    }
}
