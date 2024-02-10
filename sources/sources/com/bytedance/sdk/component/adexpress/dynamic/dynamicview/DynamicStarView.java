package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.widget.TTRatingBar2;

public class DynamicStarView extends DynamicBaseWidgetImp {
    private int a = 0;

    public DynamicStarView(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        this.o = new TTRatingBar2(context, (AttributeSet) null);
        this.o.setTag(Integer.valueOf(getClickArea()));
        addView(this.o, getWidgetLayoutParams());
    }

    /* access modifiers changed from: protected */
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        int a2 = (int) ((e.a(d.a(), this.l.e()) * 5.0f) + e.a(d.a(), ((float) this.l.c()) + e.a(d.a(), (float) this.l.d())));
        if (this.g > a2 && 4 == this.l.h()) {
            this.a = (this.g - a2) / 2;
        }
        this.g = a2;
        return new FrameLayout.LayoutParams(this.g, this.h);
    }

    public void f() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.g, this.h);
        layoutParams.topMargin = this.j;
        layoutParams.leftMargin = this.i + this.a;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    public boolean i() {
        super.i();
        double m = this.l.m();
        if (!d.b() || (m >= 0.0d && m <= 5.0d && (this.n == null || this.n.getRenderRequest() == null || this.n.getRenderRequest().j() == 4))) {
            double d = (m < 0.0d || m > 5.0d) ? 5.0d : m;
            this.o.setVisibility(0);
            ((TTRatingBar2) this.o).a(d, this.l.g(), (int) this.l.e(), ((int) e.a(this.k, (float) this.l.b())) + ((int) e.a(this.k, (float) this.l.a())) + ((int) e.a(this.k, this.l.e())));
            return true;
        }
        this.o.setVisibility(8);
        return true;
    }
}
