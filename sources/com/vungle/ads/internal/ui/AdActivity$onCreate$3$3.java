package com.vungle.ads.internal.ui;

import com.vungle.ads.internal.ui.view.MRAIDAdWidget;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/vungle/ads/internal/ui/AdActivity$onCreate$3$3", "Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$OrientationDelegate;", "setOrientation", "", "orientation", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AdActivity.kt */
public final class AdActivity$onCreate$3$3 implements MRAIDAdWidget.OrientationDelegate {
    final /* synthetic */ AdActivity this$0;

    AdActivity$onCreate$3$3(AdActivity adActivity) {
        this.this$0 = adActivity;
    }

    public void setOrientation(int i) {
        this.this$0.setRequestedOrientation(i);
    }
}
