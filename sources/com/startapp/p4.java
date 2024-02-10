package com.startapp;

import android.view.MotionEvent;
import com.startapp.sdk.ads.list3d.List3DView;

/* compiled from: Sta */
public class p4 implements Runnable {
    public final /* synthetic */ List3DView a;

    public p4(List3DView list3DView) {
        this.a = list3DView;
    }

    public void run() {
        this.a.dispatchTouchEvent(MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), 2, 0.0f, -20.0f, 0));
        this.a.dispatchTouchEvent(MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), 1, 0.0f, -20.0f, 0));
    }
}
