package com.vungle.ads;

import android.content.Context;
import com.vungle.ads.internal.AdInternal;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.util.ThreadUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010.\u001a\u00020/H\u0016¢\u0006\u0002\u00100J\u0015\u00101\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H ¢\u0006\u0002\b2J\u0012\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0005H\u0016J\u0015\u00106\u001a\u0002042\u0006\u00107\u001a\u000208H\u0010¢\u0006\u0002\b9J\b\u0010:\u001a\u000204H\u0002J\u001d\u0010;\u001a\u0002042\u0006\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>H\u0010¢\u0006\u0002\b?J\u001f\u0010@\u001a\u0002042\u0006\u0010<\u001a\u00020\u00002\b\u00105\u001a\u0004\u0018\u00010\u0005H\u0010¢\u0006\u0002\bAR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\"\u0010!\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u001c\u0010$\u001a\u00020%8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020%X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0014\u0010,\u001a\u00020%X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)¨\u0006B"}, d2 = {"Lcom/vungle/ads/BaseAd;", "Lcom/vungle/ads/Ad;", "context", "Landroid/content/Context;", "placementId", "", "adConfig", "Lcom/vungle/ads/AdConfig;", "(Landroid/content/Context;Ljava/lang/String;Lcom/vungle/ads/AdConfig;)V", "getAdConfig", "()Lcom/vungle/ads/AdConfig;", "adInternal", "Lcom/vungle/ads/internal/AdInternal;", "getAdInternal", "()Lcom/vungle/ads/internal/AdInternal;", "adInternal$delegate", "Lkotlin/Lazy;", "adListener", "Lcom/vungle/ads/BaseAdListener;", "getAdListener", "()Lcom/vungle/ads/BaseAdListener;", "setAdListener", "(Lcom/vungle/ads/BaseAdListener;)V", "getContext", "()Landroid/content/Context;", "<set-?>", "creativeId", "getCreativeId", "()Ljava/lang/String;", "displayToClickMetric", "Lcom/vungle/ads/OneShotTimeIntervalMetric;", "getDisplayToClickMetric$vungle_ads_release", "()Lcom/vungle/ads/OneShotTimeIntervalMetric;", "eventId", "getEventId", "getPlacementId", "requestToResponseMetric", "Lcom/vungle/ads/TimeIntervalMetric;", "getRequestToResponseMetric$vungle_ads_release$annotations", "()V", "getRequestToResponseMetric$vungle_ads_release", "()Lcom/vungle/ads/TimeIntervalMetric;", "responseToShowMetric", "getResponseToShowMetric$vungle_ads_release", "showToDisplayMetric", "getShowToDisplayMetric$vungle_ads_release", "canPlayAd", "", "()Ljava/lang/Boolean;", "constructAdInternal", "constructAdInternal$vungle_ads_release", "load", "", "adMarkup", "onAdLoaded", "advertisement", "Lcom/vungle/ads/internal/model/AdPayload;", "onAdLoaded$vungle_ads_release", "onLoadEnd", "onLoadFailure", "baseAd", "vungleError", "Lcom/vungle/ads/VungleError;", "onLoadFailure$vungle_ads_release", "onLoadSuccess", "onLoadSuccess$vungle_ads_release", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BaseAd.kt */
public abstract class BaseAd implements Ad {
    private final AdConfig adConfig;
    private final Lazy adInternal$delegate = LazyKt.lazy(new BaseAd$adInternal$2(this));
    private BaseAdListener adListener;
    private final Context context;
    private String creativeId;
    private final OneShotTimeIntervalMetric displayToClickMetric = new OneShotTimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.AD_DISPLAY_TO_CLICK_DURATION_MS);
    private String eventId;
    private final String placementId;
    private final TimeIntervalMetric requestToResponseMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.AD_REQUEST_TO_RESPONSE_DURATION_MS);
    private final TimeIntervalMetric responseToShowMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.AD_RESPONSE_TO_SHOW_DURATION_MS);
    private final TimeIntervalMetric showToDisplayMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.AD_SHOW_TO_DISPLAY_DURATION_MS);

    public static /* synthetic */ void getRequestToResponseMetric$vungle_ads_release$annotations() {
    }

    public abstract AdInternal constructAdInternal$vungle_ads_release(Context context2);

    public BaseAd(Context context2, String str, AdConfig adConfig2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str, "placementId");
        Intrinsics.checkNotNullParameter(adConfig2, "adConfig");
        this.context = context2;
        this.placementId = str;
        this.adConfig = adConfig2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getPlacementId() {
        return this.placementId;
    }

    public final AdConfig getAdConfig() {
        return this.adConfig;
    }

    public final BaseAdListener getAdListener() {
        return this.adListener;
    }

    public final void setAdListener(BaseAdListener baseAdListener) {
        this.adListener = baseAdListener;
    }

    public final AdInternal getAdInternal() {
        return (AdInternal) this.adInternal$delegate.getValue();
    }

    public final TimeIntervalMetric getRequestToResponseMetric$vungle_ads_release() {
        return this.requestToResponseMetric;
    }

    public final TimeIntervalMetric getResponseToShowMetric$vungle_ads_release() {
        return this.responseToShowMetric;
    }

    public final TimeIntervalMetric getShowToDisplayMetric$vungle_ads_release() {
        return this.showToDisplayMetric;
    }

    public final OneShotTimeIntervalMetric getDisplayToClickMetric$vungle_ads_release() {
        return this.displayToClickMetric;
    }

    public Boolean canPlayAd() {
        boolean z = false;
        if (AdInternal.canPlayAd$default(getAdInternal(), false, 1, (Object) null) == null) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public void load(String str) {
        this.requestToResponseMetric.markStart();
        getAdInternal().loadAd(this.placementId, str, new BaseAd$load$1(this, str));
    }

    public void onAdLoaded$vungle_ads_release(AdPayload adPayload) {
        Intrinsics.checkNotNullParameter(adPayload, "advertisement");
        adPayload.setAdConfig(this.adConfig);
        this.creativeId = adPayload.getCreativeId();
        this.eventId = adPayload.eventId();
    }

    public void onLoadSuccess$vungle_ads_release(BaseAd baseAd, String str) {
        Intrinsics.checkNotNullParameter(baseAd, "baseAd");
        ThreadUtil.INSTANCE.runOnUiThread(new BaseAd$$ExternalSyntheticLambda1(this));
        onLoadEnd();
    }

    /* access modifiers changed from: private */
    /* renamed from: onLoadSuccess$lambda-0  reason: not valid java name */
    public static final void m253onLoadSuccess$lambda0(BaseAd baseAd) {
        Intrinsics.checkNotNullParameter(baseAd, "this$0");
        BaseAdListener baseAdListener = baseAd.adListener;
        if (baseAdListener != null) {
            baseAdListener.onAdLoaded(baseAd);
        }
    }

    public void onLoadFailure$vungle_ads_release(BaseAd baseAd, VungleError vungleError) {
        Intrinsics.checkNotNullParameter(baseAd, "baseAd");
        Intrinsics.checkNotNullParameter(vungleError, "vungleError");
        ThreadUtil.INSTANCE.runOnUiThread(new BaseAd$$ExternalSyntheticLambda0(this, vungleError));
        onLoadEnd();
    }

    /* access modifiers changed from: private */
    /* renamed from: onLoadFailure$lambda-1  reason: not valid java name */
    public static final void m252onLoadFailure$lambda1(BaseAd baseAd, VungleError vungleError) {
        Intrinsics.checkNotNullParameter(baseAd, "this$0");
        Intrinsics.checkNotNullParameter(vungleError, "$vungleError");
        BaseAdListener baseAdListener = baseAd.adListener;
        if (baseAdListener != null) {
            baseAdListener.onAdFailedToLoad(baseAd, vungleError);
        }
    }

    private final void onLoadEnd() {
        this.requestToResponseMetric.markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.requestToResponseMetric, this.placementId, this.creativeId, this.eventId, (String) null, 16, (Object) null);
        this.responseToShowMetric.markStart();
    }
}
