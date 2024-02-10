package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.layout.TTHandShake;
import com.bytedance.sdk.component.adexpress.layout.TTHandShake16;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;

/* compiled from: ShakeInteract */
public class l implements f<ShakeAnimationView> {
    private ShakeAnimationView a;
    private Context b;
    private DynamicBaseWidget c;
    private g d;
    private String e;
    private int f;
    private int g;
    private int h;

    public l(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar, String str, int i, int i2, int i3) {
        this.b = context;
        this.c = dynamicBaseWidget;
        this.d = gVar;
        this.e = str;
        this.f = i;
        this.g = i2;
        this.h = i3;
        e();
    }

    private void e() {
        if ("16".equals(this.e)) {
            ShakeAnimationView shakeAnimationView = new ShakeAnimationView(this.b, new TTHandShake16(this.b), this.f, this.g, this.h);
            this.a = shakeAnimationView;
            if (shakeAnimationView.getShakeLayout() != null) {
                this.a.getShakeLayout().setOnClickListener((View.OnClickListener) this.c.getDynamicClickListener());
            }
        } else {
            this.a = new ShakeAnimationView(this.b, new TTHandShake(this.b), this.f, this.g, this.h);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) e.a(this.b, 80.0f);
        this.a.setLayoutParams(layoutParams);
        this.a.setShakeText(this.d.R());
        this.a.setClipChildren(false);
        this.a.setOnShakeViewListener(new ShakeAnimationView.a() {
        });
    }

    public void a() {
        this.a.a();
    }

    public void b() {
        this.a.clearAnimation();
    }

    /* renamed from: c */
    public ShakeAnimationView d() {
        return this.a;
    }
}
