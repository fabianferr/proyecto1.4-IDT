package com.vungle.ads.internal.ui;

import android.view.MotionEvent;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.ui.view.MRAIDAdWidget;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/vungle/ads/internal/ui/AdActivity$onCreate$3$2", "Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$OnViewTouchListener;", "onTouch", "", "event", "Landroid/view/MotionEvent;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AdActivity.kt */
public final class AdActivity$onCreate$3$2 implements MRAIDAdWidget.OnViewTouchListener {
    final /* synthetic */ AdActivity this$0;

    AdActivity$onCreate$3$2(AdActivity adActivity) {
        this.this$0 = adActivity;
    }

    public boolean onTouch(MotionEvent motionEvent) {
        MRAIDPresenter mraidPresenter$vungle_ads_release = this.this$0.getMraidPresenter$vungle_ads_release();
        if (mraidPresenter$vungle_ads_release == null) {
            return false;
        }
        mraidPresenter$vungle_ads_release.onViewTouched(motionEvent);
        return false;
    }
}
