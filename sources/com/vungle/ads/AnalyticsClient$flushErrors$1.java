package com.vungle.ads;

import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.util.Logger;
import java.util.concurrent.BlockingQueue;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/vungle/ads/AnalyticsClient$flushErrors$1", "Lcom/vungle/ads/AnalyticsClient$RequestListener;", "onFailure", "", "onSuccess", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AnalyticsClient.kt */
public final class AnalyticsClient$flushErrors$1 implements AnalyticsClient.RequestListener {
    final /* synthetic */ BlockingQueue<Sdk.SDKError.Builder> $currentSendingErrors;

    AnalyticsClient$flushErrors$1(BlockingQueue<Sdk.SDKError.Builder> blockingQueue) {
        this.$currentSendingErrors = blockingQueue;
    }

    public void onSuccess() {
        Logger.Companion companion = Logger.Companion;
        String access$getTAG$p = AnalyticsClient.TAG;
        companion.d(access$getTAG$p, "Sent " + this.$currentSendingErrors.size() + " errors");
    }

    public void onFailure() {
        Logger.Companion companion = Logger.Companion;
        String access$getTAG$p = AnalyticsClient.TAG;
        companion.d(access$getTAG$p, "Failed to send " + this.$currentSendingErrors.size() + " errors");
        AnalyticsClient.INSTANCE.getErrors$vungle_ads_release().addAll(this.$currentSendingErrors);
    }
}
