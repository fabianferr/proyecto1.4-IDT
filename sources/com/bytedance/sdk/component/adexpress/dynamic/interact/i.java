package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.HandLongPressView;

/* compiled from: LongPressInteract */
public class i implements f {
    private HandLongPressView a;

    public i(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar) {
        this.a = new HandLongPressView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) e.a(context, 180.0f), (int) e.a(context, 180.0f));
        layoutParams.gravity = 17;
        this.a.setLayoutParams(layoutParams);
        this.a.setGuideText(gVar.R());
    }

    public void a() {
        this.a.a();
    }

    public void b() {
        this.a.b();
    }

    public ViewGroup d() {
        return this.a;
    }
}
