package com.vungle.ads;

import com.vungle.ads.internal.util.ActivityManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/vungle/ads/AnalyticsClient$init$2", "Lcom/vungle/ads/internal/util/ActivityManager$LifeCycleCallback;", "onPause", "", "onResume", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AnalyticsClient.kt */
public final class AnalyticsClient$init$2 extends ActivityManager.LifeCycleCallback {
    AnalyticsClient$init$2() {
    }

    public void onResume() {
        super.onResume();
        AnalyticsClient.INSTANCE.resume();
    }

    public void onPause() {
        super.onPause();
        AnalyticsClient.INSTANCE.pause();
    }
}
