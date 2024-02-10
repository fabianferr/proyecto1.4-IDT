package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView;

/* compiled from: UnlockInteract */
public class p implements f<DynamicUnlockView> {
    private final DynamicUnlockView a;

    public p(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar) {
        DynamicUnlockView dynamicUnlockView = new DynamicUnlockView(context);
        this.a = dynamicUnlockView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) e.a(context, gVar.N() > 0 ? (float) gVar.N() : 0.0f);
        dynamicUnlockView.setLayoutParams(layoutParams);
        dynamicUnlockView.setClipChildren(false);
        dynamicUnlockView.setText(gVar.R());
    }

    public void a() {
        DynamicUnlockView dynamicUnlockView = this.a;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.a();
        }
    }

    public void b() {
        DynamicUnlockView dynamicUnlockView = this.a;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.b();
        }
    }

    /* renamed from: c */
    public DynamicUnlockView d() {
        return this.a;
    }
}
