package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView;

/* compiled from: ClickSlideUpInteract */
public class c extends o<ClickSlideUpView> {
    /* access modifiers changed from: protected */
    public void c() {
    }

    public c(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar) {
        super(context, dynamicBaseWidget, gVar);
        a(gVar);
    }

    private void a(g gVar) {
        this.a = new ClickSlideUpView(this.b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) e.a(this.b, (float) gVar.N());
        this.a.setLayoutParams(layoutParams);
        this.a.setSlideText(this.d.R());
        if (this.a instanceof ClickSlideUpView) {
            ((ClickSlideUpView) this.a).setButtonText(this.d.j());
        }
    }

    public void a() {
        this.a.a();
    }

    public void b() {
        this.a.b();
    }
}
