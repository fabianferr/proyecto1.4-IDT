package com.vungle.ads.internal.presenter;

import com.vungle.ads.VungleError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0001J\u0013\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0001J\u0013\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0001J\u0013\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0001J\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0001J\u0013\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0001J\u0011\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/vungle/ads/internal/presenter/AdPlayCallbackWrapper;", "Lcom/vungle/ads/internal/presenter/AdPlayCallback;", "adPlayCallback", "(Lcom/vungle/ads/internal/presenter/AdPlayCallback;)V", "onAdClick", "", "id", "", "onAdEnd", "onAdImpression", "onAdLeftApplication", "onAdRewarded", "onAdStart", "onFailure", "error", "Lcom/vungle/ads/VungleError;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AdPlayCallback.kt */
public class AdPlayCallbackWrapper implements AdPlayCallback {
    private final AdPlayCallback adPlayCallback;

    public void onAdClick(String str) {
        this.adPlayCallback.onAdClick(str);
    }

    public void onAdEnd(String str) {
        this.adPlayCallback.onAdEnd(str);
    }

    public void onAdImpression(String str) {
        this.adPlayCallback.onAdImpression(str);
    }

    public void onAdLeftApplication(String str) {
        this.adPlayCallback.onAdLeftApplication(str);
    }

    public void onAdRewarded(String str) {
        this.adPlayCallback.onAdRewarded(str);
    }

    public void onAdStart(String str) {
        this.adPlayCallback.onAdStart(str);
    }

    public void onFailure(VungleError vungleError) {
        Intrinsics.checkNotNullParameter(vungleError, "error");
        this.adPlayCallback.onFailure(vungleError);
    }

    public AdPlayCallbackWrapper(AdPlayCallback adPlayCallback2) {
        Intrinsics.checkNotNullParameter(adPlayCallback2, "adPlayCallback");
        this.adPlayCallback = adPlayCallback2;
    }
}
