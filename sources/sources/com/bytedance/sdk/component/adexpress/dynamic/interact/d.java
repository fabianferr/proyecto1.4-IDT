package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView2;

/* compiled from: ClickSlideUpInteract2 */
public class d extends o<ClickSlideUpView> {
    /* access modifiers changed from: protected */
    public void c() {
    }

    public d(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar) {
        super(context, dynamicBaseWidget, gVar);
        a(gVar);
    }

    private void a(g gVar) {
        this.a = new ClickSlideUpView2(this.b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 81;
        this.a.setLayoutParams(layoutParams);
        if (this.a instanceof ClickSlideUpView2) {
            ((ClickSlideUpView2) this.a).setButtonText(this.d.R());
        }
    }

    public void a() {
        this.a.a();
    }

    public void b() {
        this.a.b();
    }
}
