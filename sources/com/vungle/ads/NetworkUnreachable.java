package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/vungle/ads/NetworkUnreachable;", "Lcom/vungle/ads/VungleError;", "()V", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: VungleError.kt */
public final class NetworkUnreachable extends VungleError {
    public NetworkUnreachable() {
        super(Integer.valueOf(VungleError.NETWORK_UNREACHABLE), Sdk.SDKError.Reason.API_REQUEST_ERROR, "Config: Network Unreachable", (String) null, (String) null, (String) null, 56, (DefaultConstructorMarker) null);
    }
}