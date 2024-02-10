package com.vungle.ads;

import android.content.Context;
import com.vungle.ads.internal.AdInternal;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.presenter.AdPlayCallbackWrapper;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.ThreadUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0010¢\u0006\u0002\b\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/vungle/ads/BannerAd;", "Lcom/vungle/ads/BaseAd;", "context", "Landroid/content/Context;", "placementId", "", "adSize", "Lcom/vungle/ads/BannerAdSize;", "(Landroid/content/Context;Ljava/lang/String;Lcom/vungle/ads/BannerAdSize;)V", "adConfig", "Lcom/vungle/ads/AdConfig;", "(Landroid/content/Context;Ljava/lang/String;Lcom/vungle/ads/BannerAdSize;Lcom/vungle/ads/AdConfig;)V", "adPlayCallback", "Lcom/vungle/ads/internal/presenter/AdPlayCallbackWrapper;", "bannerView", "Lcom/vungle/ads/BannerView;", "constructAdInternal", "Lcom/vungle/ads/BannerAdInternal;", "constructAdInternal$vungle_ads_release", "finishAd", "", "getBannerView", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BannerAd.kt */
public final class BannerAd extends BaseAd {
    private final AdPlayCallbackWrapper adPlayCallback;
    private BannerAdSize adSize;
    private BannerView bannerView;

    private BannerAd(Context context, String str, BannerAdSize bannerAdSize, AdConfig adConfig) {
        super(context, str, adConfig);
        this.adSize = bannerAdSize;
        AdInternal adInternal = getAdInternal();
        Intrinsics.checkNotNull(adInternal, "null cannot be cast to non-null type com.vungle.ads.BannerAdInternal");
        this.adPlayCallback = ((BannerAdInternal) adInternal).wrapCallback$vungle_ads_release(new BannerAd$adPlayCallback$1(this, str));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BannerAd(Context context, String str, BannerAdSize bannerAdSize) {
        this(context, str, bannerAdSize, new AdConfig());
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "placementId");
        Intrinsics.checkNotNullParameter(bannerAdSize, "adSize");
    }

    public BannerAdInternal constructAdInternal$vungle_ads_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new BannerAdInternal(context, this.adSize);
    }

    public final void finishAd() {
        BannerView bannerView2 = this.bannerView;
        if (bannerView2 != null) {
            bannerView2.finishAdInternal(true);
        }
    }

    public final BannerView getBannerView() {
        Placement placement;
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.PLAY_AD_API), getPlacementId(), getCreativeId(), getEventId(), (String) null, 16, (Object) null);
        BannerView bannerView2 = this.bannerView;
        if (bannerView2 != null) {
            return bannerView2;
        }
        VungleError canPlayAd = getAdInternal().canPlayAd(true);
        if (canPlayAd != null) {
            if (getAdInternal().isErrorTerminal$vungle_ads_release(canPlayAd.getCode())) {
                getAdInternal().setAdState(AdInternal.AdState.ERROR);
            }
            ThreadUtil.INSTANCE.runOnUiThread(new BannerAd$$ExternalSyntheticLambda0(this, canPlayAd));
            return null;
        }
        AdPayload advertisement = getAdInternal().getAdvertisement();
        if (advertisement == null || (placement = getAdInternal().getPlacement()) == null) {
            return null;
        }
        getAdInternal().cancelDownload$vungle_ads_release();
        try {
            this.bannerView = new BannerView(getContext(), placement, advertisement, this.adSize, getAdConfig(), this.adPlayCallback, getAdInternal().getBidPayload());
            getResponseToShowMetric$vungle_ads_release().markEnd();
            AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, getResponseToShowMetric$vungle_ads_release(), getPlacementId(), getCreativeId(), getEventId(), (String) null, 16, (Object) null);
            getShowToDisplayMetric$vungle_ads_release().markStart();
            return this.bannerView;
        } catch (InstantiationException e) {
            Logger.Companion companion = Logger.Companion;
            companion.e("BannerAd", "Can not create banner view: " + e.getMessage(), e);
            getResponseToShowMetric$vungle_ads_release().markEnd();
            AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, getResponseToShowMetric$vungle_ads_release(), getPlacementId(), getCreativeId(), getEventId(), (String) null, 16, (Object) null);
            return null;
        } catch (Throwable th) {
            getResponseToShowMetric$vungle_ads_release().markEnd();
            AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, getResponseToShowMetric$vungle_ads_release(), getPlacementId(), getCreativeId(), getEventId(), (String) null, 16, (Object) null);
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: getBannerView$lambda-0  reason: not valid java name */
    public static final void m2247getBannerView$lambda0(BannerAd bannerAd, VungleError vungleError) {
        Intrinsics.checkNotNullParameter(bannerAd, "this$0");
        BaseAdListener adListener = bannerAd.getAdListener();
        if (adListener != null) {
            adListener.onAdFailedToPlay(bannerAd, vungleError);
        }
    }
}
