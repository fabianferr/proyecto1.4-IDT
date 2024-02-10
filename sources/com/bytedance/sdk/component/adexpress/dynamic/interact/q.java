package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.layout.TTHandWriggleGuide;
import com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView;
import com.bytedance.sdk.component.adexpress.widget.WriggleGuideView;
import com.bytedance.sdk.component.utils.s;

/* compiled from: WriggleGuideInteract */
public class q implements f<WriggleGuideAnimationView> {
    private WriggleGuideAnimationView a;
    private Context b;
    private DynamicBaseWidget c;
    private g d;
    private String e;
    private int f;

    public q(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar, String str, int i) {
        this.b = context;
        this.c = dynamicBaseWidget;
        this.d = gVar;
        this.e = str;
        this.f = i;
        e();
    }

    private void e() {
        int N = this.d.N();
        if ("18".equals(this.e)) {
            WriggleGuideAnimationView wriggleGuideAnimationView = new WriggleGuideAnimationView(this.b, new TTHandWriggleGuide(this.b), this.f);
            this.a = wriggleGuideAnimationView;
            if (wriggleGuideAnimationView.getWriggleLayout() != null) {
                this.a.getWriggleLayout().setOnClickListener((View.OnClickListener) this.c.getDynamicClickListener());
            }
            if (this.a.getTopTextView() != null) {
                this.a.getTopTextView().setText(s.b(this.b, "tt_splash_wriggle_top_text_style_17"));
            }
        } else {
            this.a = new WriggleGuideAnimationView(this.b, new TTHandWriggleGuide(this.b), this.f);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        this.a.setTranslationY((float) (-((int) e.a(this.b, (float) N))));
        this.a.setLayoutParams(layoutParams);
        this.a.setShakeText(this.d.R());
        this.a.setClipChildren(false);
        final WriggleGuideView wriggleProgressIv = this.a.getWriggleProgressIv();
        this.a.setOnShakeViewListener(new WriggleGuideAnimationView.a() {
        });
    }

    public void a() {
        this.a.a();
    }

    public void b() {
        this.a.clearAnimation();
    }

    /* renamed from: c */
    public WriggleGuideAnimationView d() {
        return this.a;
    }
}
