package com.ironsource.sdk.k;

import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0016J\b\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/ironsource/sdk/nativeAd/ISNNativeAdInterface;", "", "adData", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdData;", "getAdData", "()Lcom/ironsource/sdk/nativeAd/ISNNativeAdData;", "listener", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdInterface$Listener;", "getListener", "()Lcom/ironsource/sdk/nativeAd/ISNNativeAdInterface$Listener;", "setListener", "(Lcom/ironsource/sdk/nativeAd/ISNNativeAdInterface$Listener;)V", "destroy", "", "load", "activity", "Landroid/app/Activity;", "loadParams", "Lorg/json/JSONObject;", "register", "viewHolder", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdViewHolder;", "Listener", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface d {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/ironsource/sdk/nativeAd/ISNNativeAdInterface$Listener;", "", "onNativeAdClicked", "", "onNativeAdLoadFailed", "reason", "", "onNativeAdLoadSuccess", "adData", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdData;", "onNativeAdShown", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void onNativeAdClicked();

        void onNativeAdLoadFailed(String str);

        void onNativeAdLoadSuccess(c cVar);

        void onNativeAdShown();
    }

    c a();

    void a(e eVar);
}
