package com.ironsource.adapters.ironsource.nativeAd;

import android.net.Uri;
import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface;
import com.ironsource.sdk.k.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/ironsource/adapters/ironsource/nativeAd/IronSourceNativeAdData;", "Lcom/ironsource/mediationsdk/ads/nativead/AdapterNativeAdData;", "nativeAdData", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdData;", "(Lcom/ironsource/sdk/nativeAd/ISNNativeAdData;)V", "advertiser", "", "getAdvertiser", "()Ljava/lang/String;", "body", "getBody", "callToAction", "getCallToAction", "icon", "Lcom/ironsource/mediationsdk/ads/nativead/interfaces/NativeAdDataInterface$Image;", "getIcon", "()Lcom/ironsource/mediationsdk/ads/nativead/interfaces/NativeAdDataInterface$Image;", "title", "getTitle", "ironsourceadapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IronSourceNativeAdData extends AdapterNativeAdData {
    private final String advertiser;
    private final String body;
    private final String callToAction;
    private final NativeAdDataInterface.Image icon;
    private final String title;

    public IronSourceNativeAdData(c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "nativeAdData");
        this.title = cVar.a;
        this.advertiser = cVar.b;
        this.body = cVar.c;
        this.callToAction = cVar.d;
        this.icon = new NativeAdDataInterface.Image(cVar.e, (Uri) null);
    }

    public final String getAdvertiser() {
        return this.advertiser;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getCallToAction() {
        return this.callToAction;
    }

    public final NativeAdDataInterface.Image getIcon() {
        return this.icon;
    }

    public final String getTitle() {
        return this.title;
    }
}
