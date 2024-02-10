package com.vungle.ads;

import com.vungle.ads.internal.presenter.AdPlayCallback;
import com.vungle.ads.internal.util.ThreadUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/vungle/ads/BannerAd$adPlayCallback$1", "Lcom/vungle/ads/internal/presenter/AdPlayCallback;", "onAdClick", "", "id", "", "onAdEnd", "onAdImpression", "onAdLeftApplication", "onAdRewarded", "onAdStart", "onFailure", "error", "Lcom/vungle/ads/VungleError;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BannerAd.kt */
public final class BannerAd$adPlayCallback$1 implements AdPlayCallback {
    final /* synthetic */ String $placementId;
    final /* synthetic */ BannerAd this$0;

    public void onAdRewarded(String str) {
    }

    BannerAd$adPlayCallback$1(BannerAd bannerAd, String str) {
        this.this$0 = bannerAd;
        this.$placementId = str;
    }

    public void onAdStart(String str) {
        ThreadUtil.INSTANCE.runOnUiThread(new BannerAd$adPlayCallback$1$$ExternalSyntheticLambda5(this.this$0));
    }

    /* access modifiers changed from: private */
    /* renamed from: onAdStart$lambda-0  reason: not valid java name */
    public static final void m2255onAdStart$lambda0(BannerAd bannerAd) {
        Intrinsics.checkNotNullParameter(bannerAd, "this$0");
        BaseAdListener adListener = bannerAd.getAdListener();
        if (adListener != null) {
            adListener.onAdStart(bannerAd);
        }
    }

    public void onAdImpression(String str) {
        ThreadUtil.INSTANCE.runOnUiThread(new BannerAd$adPlayCallback$1$$ExternalSyntheticLambda3(this.this$0));
        this.this$0.getShowToDisplayMetric$vungle_ads_release().markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.this$0.getShowToDisplayMetric$vungle_ads_release(), this.$placementId, this.this$0.getCreativeId(), this.this$0.getEventId(), (String) null, 16, (Object) null);
        this.this$0.getDisplayToClickMetric$vungle_ads_release().markStart();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAdImpression$lambda-1  reason: not valid java name */
    public static final void m2253onAdImpression$lambda1(BannerAd bannerAd) {
        Intrinsics.checkNotNullParameter(bannerAd, "this$0");
        BaseAdListener adListener = bannerAd.getAdListener();
        if (adListener != null) {
            adListener.onAdImpression(bannerAd);
        }
    }

    public void onAdEnd(String str) {
        ThreadUtil.INSTANCE.runOnUiThread(new BannerAd$adPlayCallback$1$$ExternalSyntheticLambda2(this.this$0));
    }

    /* access modifiers changed from: private */
    /* renamed from: onAdEnd$lambda-2  reason: not valid java name */
    public static final void m2252onAdEnd$lambda2(BannerAd bannerAd) {
        Intrinsics.checkNotNullParameter(bannerAd, "this$0");
        BaseAdListener adListener = bannerAd.getAdListener();
        if (adListener != null) {
            adListener.onAdEnd(bannerAd);
        }
    }

    public void onAdClick(String str) {
        ThreadUtil.INSTANCE.runOnUiThread(new BannerAd$adPlayCallback$1$$ExternalSyntheticLambda0(this.this$0));
        this.this$0.getDisplayToClickMetric$vungle_ads_release().markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.this$0.getDisplayToClickMetric$vungle_ads_release(), this.$placementId, this.this$0.getCreativeId(), this.this$0.getEventId(), (String) null, 16, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAdClick$lambda-3  reason: not valid java name */
    public static final void m2251onAdClick$lambda3(BannerAd bannerAd) {
        Intrinsics.checkNotNullParameter(bannerAd, "this$0");
        BaseAdListener adListener = bannerAd.getAdListener();
        if (adListener != null) {
            adListener.onAdClicked(bannerAd);
        }
    }

    public void onAdLeftApplication(String str) {
        ThreadUtil.INSTANCE.runOnUiThread(new BannerAd$adPlayCallback$1$$ExternalSyntheticLambda1(this.this$0));
    }

    /* access modifiers changed from: private */
    /* renamed from: onAdLeftApplication$lambda-4  reason: not valid java name */
    public static final void m2254onAdLeftApplication$lambda4(BannerAd bannerAd) {
        Intrinsics.checkNotNullParameter(bannerAd, "this$0");
        BaseAdListener adListener = bannerAd.getAdListener();
        if (adListener != null) {
            adListener.onAdLeftApplication(bannerAd);
        }
    }

    public void onFailure(VungleError vungleError) {
        Intrinsics.checkNotNullParameter(vungleError, "error");
        ThreadUtil.INSTANCE.runOnUiThread(new BannerAd$adPlayCallback$1$$ExternalSyntheticLambda4(this.this$0, vungleError));
    }

    /* access modifiers changed from: private */
    /* renamed from: onFailure$lambda-5  reason: not valid java name */
    public static final void m2256onFailure$lambda5(BannerAd bannerAd, VungleError vungleError) {
        Intrinsics.checkNotNullParameter(bannerAd, "this$0");
        Intrinsics.checkNotNullParameter(vungleError, "$error");
        BaseAdListener adListener = bannerAd.getAdListener();
        if (adListener != null) {
            adListener.onAdFailedToPlay(bannerAd, vungleError);
        }
    }
}
