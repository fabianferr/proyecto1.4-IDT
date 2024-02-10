package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/vungle/ads/AdCantPlayWithoutWebView;", "Lcom/vungle/ads/VungleError;", "()V", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: VungleError.kt */
public final class AdCantPlayWithoutWebView extends VungleError {
    public AdCantPlayWithoutWebView() {
        super(Integer.valueOf(VungleError.AD_UNABLE_TO_PLAY), Sdk.SDKError.Reason.AD_HTML_FAILED_TO_LOAD, "No WebView when playing ads.", (String) null, (String) null, (String) null, 56, (DefaultConstructorMarker) null);
    }
}
