package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.dynamic.c;
import java.util.Iterator;
import java.util.List;

public class DynamicTimeOuterContainerWidgetImp extends DynamicBaseWidgetImp implements c {
    int a;
    boolean b;
    private int t;
    private int u = 0;
    private boolean v;

    public DynamicTimeOuterContainerWidgetImp(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        setTag(Integer.valueOf(getClickArea()));
        a();
        dynamicRootView.setTimeOutListener(this);
    }

    /* access modifiers changed from: protected */
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    public void f() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.b) {
            layoutParams.leftMargin = this.i;
        } else {
            layoutParams.leftMargin = this.i + this.u;
        }
        if (this.v && this.l != null) {
            layoutParams.leftMargin = ((this.i + this.u) - ((int) e.a(d.a(), (float) this.l.c()))) - ((int) e.a(d.a(), (float) this.l.d()));
        }
        if (d.b()) {
            layoutParams.topMargin = this.j - ((int) e.a(d.a(), (float) this.l.b()));
        }
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    public boolean i() {
        if (com.bytedance.sdk.component.adexpress.c.d.b(this.n.getRenderRequest().d())) {
            return true;
        }
        super.i();
        setPadding((int) e.a(d.a(), (float) this.l.c()), (int) e.a(d.a(), (float) this.l.b()), (int) e.a(d.a(), (float) this.l.d()), (int) e.a(d.a(), (float) this.l.a()));
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.v && this.l != null) {
            setMeasuredDimension(this.t + ((int) e.a(d.a(), (float) this.l.c())) + ((int) e.a(d.a(), (float) this.l.d())), this.h);
        } else if (this.b) {
            setMeasuredDimension(this.g, this.h);
        } else {
            setMeasuredDimension(this.a, this.h);
        }
    }

    private void a() {
        List<h> k = this.m.k();
        if (k != null && k.size() > 0) {
            Iterator<h> it = k.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (TextUtils.equals("skip-with-time-skip-btn", next.j().b())) {
                    this.t = (int) e.a(this.k, next.h() + ((float) (d.b() ? next.m() : 0)));
                    this.a = this.g - this.t;
                }
            }
            this.u = this.g - this.a;
        }
    }

    public void a(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (!z2 || this.v == z2) {
            if (z && this.b != z) {
                this.b = z;
                f();
            }
            this.b = z;
            return;
        }
        this.v = z2;
        f();
    }
}
