package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.SlideRightView;

/* compiled from: SlideRightInteract */
public class m implements f {
    private SlideRightView a;
    private Context b;
    private DynamicBaseWidget c;
    private g d;

    public void b() {
    }

    public m(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar) {
        this.b = context;
        this.c = dynamicBaseWidget;
        this.d = gVar;
        c();
    }

    private void c() {
        this.a = new SlideRightView(this.b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) e.a(this.b, 120.0f), (int) e.a(this.b, 120.0f));
        layoutParams.gravity = 17;
        this.a.setLayoutParams(layoutParams);
        this.a.setClipChildren(false);
        this.a.setGuideText(this.d.R());
    }

    public void a() {
        this.a.a();
    }

    public ViewGroup d() {
        return this.a;
    }
}
