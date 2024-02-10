package com.vungle.ads;

import android.content.Context;
import com.ironsource.mediationsdk.adunit.data.DataKeys;
import com.vungle.ads.internal.AdInternal;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0010¢\u0006\u0002\b\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0005J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0005R\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/vungle/ads/RewardedAd;", "Lcom/vungle/ads/BaseFullscreenAd;", "context", "Landroid/content/Context;", "placementId", "", "adConfig", "Lcom/vungle/ads/AdConfig;", "(Landroid/content/Context;Ljava/lang/String;Lcom/vungle/ads/AdConfig;)V", "rewardedAdInternal", "Lcom/vungle/ads/RewardedAdInternal;", "getRewardedAdInternal", "()Lcom/vungle/ads/RewardedAdInternal;", "constructAdInternal", "constructAdInternal$vungle_ads_release", "setAlertBodyText", "", "bodyText", "setAlertCloseButtonText", "closeButtonText", "setAlertContinueButtonText", "continueButtonText", "setAlertTitleText", "titleText", "setUserId", "userId", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RewardedAd.kt */
public final class RewardedAd extends BaseFullscreenAd {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RewardedAd(Context context, String str, AdConfig adConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i & 4) != 0 ? new AdConfig() : adConfig);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RewardedAd(Context context, String str, AdConfig adConfig) {
        super(context, str, adConfig);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "placementId");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
    }

    public RewardedAdInternal constructAdInternal$vungle_ads_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new RewardedAdInternal(context);
    }

    private final RewardedAdInternal getRewardedAdInternal() {
        AdInternal adInternal = getAdInternal();
        Intrinsics.checkNotNull(adInternal, "null cannot be cast to non-null type com.vungle.ads.RewardedAdInternal");
        return (RewardedAdInternal) adInternal;
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, DataKeys.USER_ID);
        getRewardedAdInternal().setUserId$vungle_ads_release(str);
    }

    public final void setAlertTitleText(String str) {
        Intrinsics.checkNotNullParameter(str, "titleText");
        getRewardedAdInternal().setAlertTitleText$vungle_ads_release(str);
    }

    public final void setAlertBodyText(String str) {
        Intrinsics.checkNotNullParameter(str, "bodyText");
        getRewardedAdInternal().setAlertBodyText$vungle_ads_release(str);
    }

    public final void setAlertCloseButtonText(String str) {
        Intrinsics.checkNotNullParameter(str, "closeButtonText");
        getRewardedAdInternal().setAlertCloseButtonText$vungle_ads_release(str);
    }

    public final void setAlertContinueButtonText(String str) {
        Intrinsics.checkNotNullParameter(str, "continueButtonText");
        getRewardedAdInternal().setAlertContinueButtonText$vungle_ads_release(str);
    }
}
