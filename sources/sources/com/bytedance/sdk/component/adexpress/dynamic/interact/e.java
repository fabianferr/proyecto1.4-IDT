package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpShakeView;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import com.bytedance.sdk.component.adexpress.widget.ShakeClickView;

/* compiled from: ClickSlideUpShakeInteract */
public class e extends o<ClickSlideUpShakeView> {
    /* access modifiers changed from: protected */
    public void c() {
    }

    public e(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar, int i, int i2, int i3) {
        super(context, dynamicBaseWidget, gVar);
        this.b = context;
        this.d = gVar;
        this.c = dynamicBaseWidget;
        a(i, i2, i3, gVar);
    }

    private void a(int i, int i2, int i3, g gVar) {
        this.a = new ClickSlideUpShakeView(this.b, i, i2, i3);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.c.e.a(this.b, 300.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.c.e.a(this.b, gVar.N() > 0 ? (float) gVar.N() : 0.0f);
        this.a.setLayoutParams(layoutParams);
        this.a.setClipChildren(false);
        this.a.setSlideText(this.d.R());
        if (this.a instanceof ClickSlideUpShakeView) {
            ((ClickSlideUpShakeView) this.a).setShakeText(this.d.T());
            final ShakeClickView shakeView = ((ClickSlideUpShakeView) this.a).getShakeView();
            if (shakeView != null) {
                shakeView.setOnShakeViewListener(new ShakeAnimationView.a() {
                });
                shakeView.setOnClickListener((View.OnClickListener) this.c.getDynamicClickListener());
            }
        }
    }
}
