package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.webkit.WebView;

public class h extends WebView {
    private PointF a = new PointF();

    public h(Context context) {
        super(context);
    }

    public PointF getAndClearLastClickLocation() {
        PointF pointF = this.a;
        this.a = new PointF();
        return pointF;
    }

    public PointF getLastClickLocation() {
        return this.a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.a = new PointF(motionEvent.getRawX(), motionEvent.getRawY());
        return super.onTouchEvent(motionEvent);
    }
}
