package com.vungle.ads;

import com.vungle.ads.internal.load.AdLoaderCallback;
import com.vungle.ads.internal.model.AdPayload;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/vungle/ads/BaseAd$load$1", "Lcom/vungle/ads/internal/load/AdLoaderCallback;", "onFailure", "", "error", "Lcom/vungle/ads/VungleError;", "onSuccess", "advertisement", "Lcom/vungle/ads/internal/model/AdPayload;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BaseAd.kt */
public final class BaseAd$load$1 implements AdLoaderCallback {
    final /* synthetic */ String $adMarkup;
    final /* synthetic */ BaseAd this$0;

    BaseAd$load$1(BaseAd baseAd, String str) {
        this.this$0 = baseAd;
        this.$adMarkup = str;
    }

    public void onSuccess(AdPayload adPayload) {
        Intrinsics.checkNotNullParameter(adPayload, "advertisement");
        this.this$0.onAdLoaded$vungle_ads_release(adPayload);
        BaseAd baseAd = this.this$0;
        baseAd.onLoadSuccess$vungle_ads_release(baseAd, this.$adMarkup);
    }

    public void onFailure(VungleError vungleError) {
        Intrinsics.checkNotNullParameter(vungleError, "error");
        BaseAd baseAd = this.this$0;
        baseAd.onLoadFailure$vungle_ads_release(baseAd, vungleError);
    }
}
