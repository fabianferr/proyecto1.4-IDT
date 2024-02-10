package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.SlideUpView;

/* compiled from: SlideUpInteract */
public class o<E extends SlideUpView> implements f<E> {
    protected SlideUpView a;
    protected Context b;
    protected DynamicBaseWidget c;
    protected g d;
    protected int e;

    public o(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar, int i) {
        this.e = i;
        this.b = context;
        this.c = dynamicBaseWidget;
        this.d = gVar;
        c();
    }

    public o(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar) {
        this(context, dynamicBaseWidget, gVar, 0);
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.a = new SlideUpView(this.b, this.d.K());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) e.a(this.b, 200.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) e.a(this.b, (float) (100 - this.e));
        this.a.setLayoutParams(layoutParams);
        try {
            this.a.setGuideText(this.d.R());
        } catch (Throwable unused) {
        }
    }

    public void a() {
        this.a.a();
    }

    public void b() {
        this.a.b();
    }

    /* renamed from: e */
    public E d() {
        return this.a;
    }
}
