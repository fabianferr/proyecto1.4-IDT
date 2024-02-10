package com.vungle.ads.internal.ui;

import com.vungle.ads.internal.ui.view.MRAIDAdWidget;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/vungle/ads/internal/ui/AdActivity$onCreate$3$1", "Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$CloseDelegate;", "close", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AdActivity.kt */
public final class AdActivity$onCreate$3$1 implements MRAIDAdWidget.CloseDelegate {
    final /* synthetic */ AdActivity this$0;

    AdActivity$onCreate$3$1(AdActivity adActivity) {
        this.this$0 = adActivity;
    }

    public void close() {
        this.this$0.finish();
    }
}
