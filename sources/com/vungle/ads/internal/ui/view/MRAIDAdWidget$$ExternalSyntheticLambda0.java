package com.vungle.ads.internal.ui.view;

import android.view.MotionEvent;
import android.view.View;
import com.vungle.ads.internal.ui.view.MRAIDAdWidget;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MRAIDAdWidget$$ExternalSyntheticLambda0 implements View.OnTouchListener {
    public final /* synthetic */ MRAIDAdWidget.OnViewTouchListener f$0;

    public /* synthetic */ MRAIDAdWidget$$ExternalSyntheticLambda0(MRAIDAdWidget.OnViewTouchListener onViewTouchListener) {
        this.f$0 = onViewTouchListener;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return MRAIDAdWidget.m2329bindListeners$lambda1$lambda0(this.f$0, view, motionEvent);
    }
}
