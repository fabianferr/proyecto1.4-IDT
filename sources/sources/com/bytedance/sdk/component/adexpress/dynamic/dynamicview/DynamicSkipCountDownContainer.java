package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.dynamic.c;
import java.util.List;

public class DynamicSkipCountDownContainer extends DynamicBaseWidgetImp implements c {
    private int a;
    private int b;
    private int t;

    public DynamicSkipCountDownContainer(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        setTag(Integer.valueOf(getClickArea()));
        dynamicRootView.setTimeOutListener(this);
        a();
    }

    /* access modifiers changed from: protected */
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    public boolean i() {
        setBackground(getBackgroundDrawable());
        setPadding((int) e.a(d.a(), (float) this.l.c()), (int) e.a(d.a(), (float) this.l.b()), (int) e.a(d.a(), (float) this.l.d()), (int) e.a(d.a(), (float) this.l.a()));
        return true;
    }

    public void f() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.i;
        layoutParams.topMargin = this.j;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.t == 0) {
            setMeasuredDimension(this.b, this.h);
        } else {
            setMeasuredDimension(this.a, this.h);
        }
    }

    public void a(CharSequence charSequence, boolean z, int i, boolean z2) {
        this.t = i;
    }

    private void a() {
        List<h> k = this.m.k();
        if (k != null && k.size() > 0) {
            for (h next : k) {
                if (next.j().a() == 21) {
                    this.a = (int) (((float) this.g) - e.a(this.k, next.h()));
                }
                if (next.j().a() == 20) {
                    this.b = (int) (((float) this.g) - e.a(this.k, next.h()));
                }
            }
        }
    }
}
