package com.bytedance.sdk.component.adexpress.dynamic.interact.a;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.dynamic.interact.g;

/* compiled from: SlideUpTouch */
public class d implements View.OnTouchListener {
    private float a;
    private float b;
    private boolean c;
    private g d;
    private int e;

    public d(g gVar, int i) {
        this.d = gVar;
        this.e = i;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        g gVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.b = y;
                if (Math.abs(y - this.a) > 10.0f) {
                    this.c = true;
                }
            }
        } else if (!this.c) {
            return false;
        } else {
            int b2 = e.b(com.bytedance.sdk.component.adexpress.d.a(), Math.abs(this.b - this.a));
            if (this.b - this.a < 0.0f && b2 > this.e && (gVar = this.d) != null) {
                gVar.a();
            }
        }
        return true;
    }
}
