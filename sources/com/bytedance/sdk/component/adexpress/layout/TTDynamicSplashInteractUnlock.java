package com.bytedance.sdk.component.adexpress.layout;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.dynamic.a;
import com.bytedance.sdk.component.adexpress.widget.FlowLightView;
import com.bytedance.sdk.component.utils.s;

public class TTDynamicSplashInteractUnlock extends RelativeLayout {
    private Context a;
    private RelativeLayout b;
    private TextView c;
    private ImageView d;
    private FlowLightView e;
    private ImageView f;

    public TTDynamicSplashInteractUnlock(Context context) {
        super(context);
        this.a = context;
        a();
    }

    public RelativeLayout getUnlockBtn() {
        return this.b;
    }

    public TextView getUnlockText() {
        return this.c;
    }

    public ImageView getUnlockGo() {
        return this.d;
    }

    public FlowLightView getFlowLightView() {
        return this.e;
    }

    public ImageView getUnlockEmpty() {
        return this.f;
    }

    private void a() {
        setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        this.b = relativeLayout;
        relativeLayout.setId(a.g);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) e.a(this.a, 247.0f), (int) e.a(this.a, 56.0f));
        layoutParams.addRule(14);
        this.b.setLayoutParams(layoutParams);
        this.b.setBackgroundResource(s.d(this.a, "tt_splash_unlock_btn_bg"));
        addView(this.b);
        this.d = new ImageView(this.a);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) e.a(this.a, 48.0f), (int) e.a(this.a, 48.0f));
        this.d.setLayoutParams(layoutParams2);
        layoutParams2.addRule(20);
        layoutParams2.addRule(15);
        layoutParams2.setMarginStart((int) e.a(this.a, 4.0f));
        this.d.setImageDrawable(s.c(this.a, "tt_splash_unlock_image_go"));
        this.d.setId(a.h);
        this.b.addView(this.d);
        FlowLightView flowLightView = new FlowLightView(this.a);
        this.e = flowLightView;
        flowLightView.setId(a.i);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) e.a(this.a, 24.0f));
        layoutParams3.addRule(15);
        layoutParams3.addRule(16, a.j);
        layoutParams3.addRule(17, a.h);
        layoutParams3.addRule(15);
        layoutParams3.setMarginStart((int) e.a(this.a, 12.0f));
        layoutParams3.setMarginEnd((int) e.a(this.a, 12.0f));
        this.e.setLayoutParams(layoutParams3);
        this.b.addView(this.e);
        ImageView imageView = new ImageView(this.a);
        this.f = imageView;
        imageView.setId(a.j);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) e.a(this.a, 48.0f), (int) e.a(this.a, 48.0f));
        layoutParams4.addRule(21);
        layoutParams4.addRule(15);
        layoutParams4.setMarginStart((int) e.a(this.a, 2.0f));
        layoutParams4.setMarginEnd((int) e.a(this.a, 4.0f));
        this.f.setLayoutParams(layoutParams4);
        this.f.setImageDrawable(s.c(this.a, "tt_splash_unlock_icon_empty"));
        this.b.addView(this.f);
        TextView textView = new TextView(this.a);
        this.c = textView;
        textView.setId(a.k);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = (int) e.a(this.a, 12.0f);
        layoutParams5.addRule(14);
        layoutParams5.addRule(3, a.g);
        this.c.setLayoutParams(layoutParams5);
        this.c.setGravity(17);
        this.c.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
        this.c.setTextColor(-1);
        addView(this.c);
    }
}
