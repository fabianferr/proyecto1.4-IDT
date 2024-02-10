package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.SlideUp3DView;

/* compiled from: SlideUp3DInteract */
public class n implements f<SlideUp3DView> {
    private SlideUp3DView a;
    private Context b;
    private DynamicBaseWidget c;
    private g d;

    public n(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar) {
        this.b = context;
        this.c = dynamicBaseWidget;
        this.d = gVar;
        c();
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.a = new SlideUp3DView(this.b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) e.a(this.b, 250.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) e.a(this.b, 120.0f);
        this.a.setLayoutParams(layoutParams);
        this.a.setGuideText(this.d.R());
    }

    public void a() {
        this.a.b();
    }

    public void b() {
        this.a.c();
    }

    /* renamed from: e */
    public SlideUp3DView d() {
        return this.a;
    }
}
