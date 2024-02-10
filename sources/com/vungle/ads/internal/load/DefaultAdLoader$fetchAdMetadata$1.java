package com.vungle.ads.internal.load;

import com.vungle.ads.AdRetryError;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.NoServeError;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.network.Call;
import com.vungle.ads.internal.network.Callback;
import com.vungle.ads.internal.network.Response;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J(\u0010\t\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"com/vungle/ads/internal/load/DefaultAdLoader$fetchAdMetadata$1", "Lcom/vungle/ads/internal/network/Callback;", "Lcom/vungle/ads/internal/model/AdPayload;", "onFailure", "", "call", "Lcom/vungle/ads/internal/network/Call;", "t", "", "onResponse", "response", "Lcom/vungle/ads/internal/network/Response;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DefaultAdLoader.kt */
public final class DefaultAdLoader$fetchAdMetadata$1 implements Callback<AdPayload> {
    final /* synthetic */ Placement $placement;
    final /* synthetic */ DefaultAdLoader this$0;

    DefaultAdLoader$fetchAdMetadata$1(DefaultAdLoader defaultAdLoader, Placement placement) {
        this.this$0 = defaultAdLoader;
        this.$placement = placement;
    }

    public void onResponse(Call<AdPayload> call, Response<AdPayload> response) {
        this.this$0.getSdkExecutors().getBackgroundExecutor().execute(new DefaultAdLoader$fetchAdMetadata$1$$ExternalSyntheticLambda0(this.this$0, this.$placement, response));
    }

    /* access modifiers changed from: private */
    /* renamed from: onResponse$lambda-0  reason: not valid java name */
    public static final void m2301onResponse$lambda0(DefaultAdLoader defaultAdLoader, Placement placement, Response response) {
        Intrinsics.checkNotNullParameter(defaultAdLoader, "this$0");
        Intrinsics.checkNotNullParameter(placement, "$placement");
        if (defaultAdLoader.getVungleApiClient().getRetryAfterHeaderValue(placement.getReferenceId()) > 0) {
            defaultAdLoader.onAdLoadFailed(new AdRetryError().logError$vungle_ads_release());
            return;
        }
        boolean z = false;
        if (response != null && !response.isSuccessful()) {
            z = true;
        }
        if (z) {
            AnalyticsClient.logError$vungle_ads_release$default(AnalyticsClient.INSTANCE, 104, "Failed to get a successful response from the API call", placement.getReferenceId(), (String) null, (String) null, 24, (Object) null);
            defaultAdLoader.onAdLoadFailed(new NoServeError());
            return;
        }
        AdPayload.AdUnit adUnit = null;
        AdPayload adPayload = response != null ? (AdPayload) response.body() : null;
        if (adPayload != null) {
            adUnit = adPayload.adUnit();
        }
        if (adUnit == null) {
            AnalyticsClient.logError$vungle_ads_release$default(AnalyticsClient.INSTANCE, 215, "Ad response is empty.", placement.getReferenceId(), (String) null, (String) null, 24, (Object) null);
            defaultAdLoader.onAdLoadFailed(new NoServeError());
            return;
        }
        defaultAdLoader.handleAdMetaData(adPayload);
    }

    public void onFailure(Call<AdPayload> call, Throwable th) {
        this.this$0.getSdkExecutors().getBackgroundExecutor().execute(new DefaultAdLoader$fetchAdMetadata$1$$ExternalSyntheticLambda1(this.this$0, th, this.$placement));
    }

    /* access modifiers changed from: private */
    /* renamed from: onFailure$lambda-1  reason: not valid java name */
    public static final void m2300onFailure$lambda1(DefaultAdLoader defaultAdLoader, Throwable th, Placement placement) {
        DefaultAdLoader defaultAdLoader2 = defaultAdLoader;
        Intrinsics.checkNotNullParameter(defaultAdLoader2, "this$0");
        Intrinsics.checkNotNullParameter(placement, "$placement");
        VungleError access$retrofitToVungleError = defaultAdLoader.retrofitToVungleError(th);
        defaultAdLoader2.onAdLoadFailed(access$retrofitToVungleError);
        int code = access$retrofitToVungleError.getCode();
        String str = null;
        if (code == 10020) {
            AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
            String referenceId = placement.getReferenceId();
            AdPayload advertisement$vungle_ads_release = defaultAdLoader.getAdvertisement$vungle_ads_release();
            String creativeId = advertisement$vungle_ads_release != null ? advertisement$vungle_ads_release.getCreativeId() : null;
            AdPayload advertisement$vungle_ads_release2 = defaultAdLoader.getAdvertisement$vungle_ads_release();
            if (advertisement$vungle_ads_release2 != null) {
                str = advertisement$vungle_ads_release2.eventId();
            }
            analyticsClient.logError$vungle_ads_release(101, "Ads request error.", referenceId, creativeId, str);
        } else if (code != 10047) {
            AnalyticsClient analyticsClient2 = AnalyticsClient.INSTANCE;
            String referenceId2 = placement.getReferenceId();
            AdPayload advertisement$vungle_ads_release3 = defaultAdLoader.getAdvertisement$vungle_ads_release();
            String creativeId2 = advertisement$vungle_ads_release3 != null ? advertisement$vungle_ads_release3.getCreativeId() : null;
            AdPayload advertisement$vungle_ads_release4 = defaultAdLoader.getAdvertisement$vungle_ads_release();
            if (advertisement$vungle_ads_release4 != null) {
                str = advertisement$vungle_ads_release4.eventId();
            }
            analyticsClient2.logError$vungle_ads_release(103, "Unable to decode ads response.", referenceId2, creativeId2, str);
        } else {
            AnalyticsClient analyticsClient3 = AnalyticsClient.INSTANCE;
            String referenceId3 = placement.getReferenceId();
            AdPayload advertisement$vungle_ads_release5 = defaultAdLoader.getAdvertisement$vungle_ads_release();
            String creativeId3 = advertisement$vungle_ads_release5 != null ? advertisement$vungle_ads_release5.getCreativeId() : null;
            AdPayload advertisement$vungle_ads_release6 = defaultAdLoader.getAdvertisement$vungle_ads_release();
            if (advertisement$vungle_ads_release6 != null) {
                str = advertisement$vungle_ads_release6.eventId();
            }
            analyticsClient3.logError$vungle_ads_release(217, "Timeout for ads call.", referenceId3, creativeId3, str);
        }
    }
}
