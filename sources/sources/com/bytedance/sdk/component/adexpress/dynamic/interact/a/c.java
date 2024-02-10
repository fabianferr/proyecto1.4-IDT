package com.bytedance.sdk.component.adexpress.dynamic.interact.a;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.interact.g;

/* compiled from: SlideRightTouch */
public class c implements View.OnTouchListener {
    private float a;
    private float b;
    private boolean c;
    private g d;
    private int e;

    public c(g gVar) {
        this(gVar, 5);
    }

    public c(g gVar, int i) {
        this.e = 5;
        this.d = gVar;
        if (i > 0) {
            this.e = i;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        g gVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a = motionEvent.getX();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                this.b = x;
                if (Math.abs(x - this.a) > 10.0f) {
                    this.c = true;
                }
            }
        } else if (!this.c) {
            return false;
        } else {
            int b2 = e.b(d.a(), Math.abs(this.b - this.a));
            if (this.b > this.a && b2 > this.e && (gVar = this.d) != null) {
                gVar.a();
            }
        }
        return true;
    }
}
