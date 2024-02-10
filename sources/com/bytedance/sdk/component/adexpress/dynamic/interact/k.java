package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.PressInteractView;

/* compiled from: PressInteract */
public class k implements f<PressInteractView> {
    private PressInteractView a;

    public k(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar) {
        this.a = new PressInteractView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) e.a(context, 180.0f), (int) e.a(context, 180.0f));
        layoutParams.gravity = 17;
        layoutParams.leftMargin = (int) e.a(context, 20.0f);
        this.a.setLayoutParams(layoutParams);
        this.a.setGuideText(gVar.R());
    }

    public void a() {
        this.a.a();
    }

    public void b() {
        this.a.b();
    }

    /* renamed from: c */
    public PressInteractView d() {
        return this.a;
    }
}
