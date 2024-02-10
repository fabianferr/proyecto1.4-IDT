package com.ironsource.sdk.k;

import android.app.Activity;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001:\u0001\u0018J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\tH&J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH&J\b\u0010\u0011\u001a\u00020\tH&J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/ironsource/sdk/nativeAd/NativeAdControllerApiInterface;", "", "listener", "Lcom/ironsource/sdk/nativeAd/NativeAdControllerApiInterface$Listener;", "getListener", "()Lcom/ironsource/sdk/nativeAd/NativeAdControllerApiInterface$Listener;", "setListener", "(Lcom/ironsource/sdk/nativeAd/NativeAdControllerApiInterface$Listener;)V", "click", "", "clickParams", "Lorg/json/JSONObject;", "destroy", "load", "activity", "Landroid/app/Activity;", "loadParams", "privacyClick", "register", "viewHolder", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdViewHolder;", "visibilityChanged", "viewVisibilityParams", "Lcom/ironsource/sdk/data/ViewVisibilityParams;", "Listener", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface g {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/ironsource/sdk/nativeAd/NativeAdControllerApiInterface$Listener;", "", "onClicked", "", "onLoadFailed", "reason", "", "onLoadSuccess", "adData", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdData;", "onShown", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a();

        void a(c cVar);

        void a(String str);

        void b();
    }

    void a();

    void a(Activity activity, JSONObject jSONObject);

    void a(com.ironsource.sdk.g.g gVar);

    void a(e eVar);

    void a(a aVar);

    void a(JSONObject jSONObject);

    void b();
}
