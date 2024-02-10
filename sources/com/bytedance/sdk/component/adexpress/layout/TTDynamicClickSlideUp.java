package com.bytedance.sdk.component.adexpress.layout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.utils.s;

public class TTDynamicClickSlideUp extends LinearLayout {
    LinearLayout a;
    private Context b;
    private TextView c;

    public TTDynamicClickSlideUp(Context context) {
        super(context);
        this.b = context;
        a();
    }

    public TextView getTvButText() {
        return this.c;
    }

    public LinearLayout getBgContainer() {
        return this.a;
    }

    private void a() {
        setClipChildren(false);
        setGravity(81);
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this.b);
        this.a = linearLayout;
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams((int) e.a(this.b, 46.0f), (int) e.a(this.b, 32.0f)));
        this.a.setGravity(17);
        this.a.setOrientation(1);
        this.a.setBackgroundResource(s.d(this.b, "tt_interact_round_rect_stroke"));
        addView(this.a);
        ImageView imageView = new ImageView(this.b);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setBackgroundResource(s.d(this.b, "tt_splash_slide_up_10"));
        this.a.addView(imageView);
        View view = new View(this.b);
        view.setLayoutParams(new ViewGroup.LayoutParams(0, (int) e.a(this.b, 4.0f)));
        addView(view);
        this.c = new TextView(this.b);
        this.c.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
        this.c.setGravity(1);
        this.c.setTextColor(-1);
        this.c.setTextSize(14.0f);
        addView(this.c);
    }
}
