package com.ironsource.adapters.ironsource.nativeAd;

import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import org.json.JSONObject;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class IronSourceNativeAdAdapter$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ IronSourceNativeAdAdapter f$0;
    public final /* synthetic */ JSONObject f$1;
    public final /* synthetic */ NativeAdSmashListener f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ IronSourceNativeAdAdapter$$ExternalSyntheticLambda0(IronSourceNativeAdAdapter ironSourceNativeAdAdapter, JSONObject jSONObject, NativeAdSmashListener nativeAdSmashListener, String str) {
        this.f$0 = ironSourceNativeAdAdapter;
        this.f$1 = jSONObject;
        this.f$2 = nativeAdSmashListener;
        this.f$3 = str;
    }

    public final void run() {
        IronSourceNativeAdAdapter.m2127loadNativeAdForBidding$lambda0(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
