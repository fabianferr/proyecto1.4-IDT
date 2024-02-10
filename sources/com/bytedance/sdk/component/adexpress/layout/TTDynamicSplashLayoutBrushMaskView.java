package com.bytedance.sdk.component.adexpress.layout;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.dynamic.a;
import com.bytedance.sdk.component.adexpress.widget.BrushMaskView;
import com.bytedance.sdk.component.utils.s;

public class TTDynamicSplashLayoutBrushMaskView extends RelativeLayout {
    private Context a;
    private BrushMaskView b;
    private RelativeLayout c;
    private ImageView d;
    private TextView e;
    private FrameLayout f;
    private ImageView g;

    public TTDynamicSplashLayoutBrushMaskView(Context context) {
        super(context);
        this.a = context;
        a();
    }

    public BrushMaskView getBrushMaskView() {
        return this.b;
    }

    public RelativeLayout getBrushHandRelativeLayout() {
        return this.c;
    }

    public ImageView getFirstStepImage() {
        return this.d;
    }

    public TextView getBrushView() {
        return this.e;
    }

    public ImageView getImageHand() {
        return this.g;
    }

    public FrameLayout getSplashBrushFl() {
        return this.f;
    }

    private void a() {
        setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        FrameLayout frameLayout = new FrameLayout(this.a);
        this.f = frameLayout;
        frameLayout.setId(a.l);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) e.a(this.a, 300.0f), (int) e.a(this.a, 60.0f));
        layoutParams.addRule(14);
        this.f.setLayoutParams(layoutParams);
        this.f.setBackgroundResource(s.d(this.a, "tt_interact_round_rect"));
        addView(this.f);
        BrushMaskView brushMaskView = new BrushMaskView(this.a);
        this.b = brushMaskView;
        brushMaskView.setId(a.m);
        this.b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f.addView(this.b);
        this.d = new ImageView(this.a);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) e.a(this.a, 150.0f), (int) e.a(this.a, 30.0f));
        layoutParams2.leftMargin = (int) e.a(this.a, 40.0f);
        layoutParams2.topMargin = (int) e.a(this.a, 30.0f);
        this.d.setLayoutParams(layoutParams2);
        this.d.setBackgroundResource(s.d(this.a, "tt_interact_round_rect"));
        this.f.addView(this.d);
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f.addView(relativeLayout);
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        relativeLayout.addView(linearLayout);
        TextView textView = new TextView(this.a);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText(s.b(this.a, "tt_splash_brush_mask_title"));
        textView.setTextColor(-1);
        textView.setTextSize(20.0f);
        linearLayout.addView(textView);
        this.e = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = (int) e.a(this.a, 5.0f);
        layoutParams3.leftMargin = (int) e.a(this.a, 20.0f);
        layoutParams3.rightMargin = (int) e.a(this.a, 20.0f);
        this.e.setLayoutParams(layoutParams3);
        this.e.setText(s.b(this.a, "tt_splash_brush_mask_hint"));
        this.e.setTextColor(-1);
        this.e.setTextSize(14.0f);
        linearLayout.addView(this.e);
        this.c = new RelativeLayout(this.a);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.leftMargin = (int) e.a(this.a, 40.0f);
        layoutParams4.rightMargin = (int) e.a(this.a, 30.0f);
        this.c.setLayoutParams(layoutParams4);
        ImageView imageView = new ImageView(this.a);
        this.g = imageView;
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.g.setImageDrawable(s.c(this.a, "tt_splash_hand3"));
        this.c.addView(this.g);
        addView(this.c);
    }
}
