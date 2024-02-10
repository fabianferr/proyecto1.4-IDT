package com.vungle.ads.internal.network;

import android.util.Log;
import androidx.core.util.Consumer;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.TimeIntervalMetric;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/vungle/ads/internal/network/VungleApiClient$initUserAgentLazy$1", "Landroidx/core/util/Consumer;", "", "accept", "", "uaString", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: VungleApiClient.kt */
public final class VungleApiClient$initUserAgentLazy$1 implements Consumer<String> {
    final /* synthetic */ TimeIntervalMetric $uaMetric;
    final /* synthetic */ VungleApiClient this$0;

    VungleApiClient$initUserAgentLazy$1(TimeIntervalMetric timeIntervalMetric, VungleApiClient vungleApiClient) {
        this.$uaMetric = timeIntervalMetric;
        this.this$0 = vungleApiClient;
    }

    public void accept(String str) {
        if (str == null) {
            Log.e("VungleApiClient", "Cannot Get UserAgent. Setting Default Device UserAgent");
            AnalyticsClient.logError$vungle_ads_release$default(AnalyticsClient.INSTANCE, 7, "Fail to get user agent.", (String) null, (String) null, (String) null, 28, (Object) null);
            return;
        }
        this.$uaMetric.markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.$uaMetric.getMetricType(), this.$uaMetric.calculateIntervalDuration(), (String) null, (String) null, (String) null, (String) null, 60, (Object) null);
        this.this$0.uaString = str;
    }
}
