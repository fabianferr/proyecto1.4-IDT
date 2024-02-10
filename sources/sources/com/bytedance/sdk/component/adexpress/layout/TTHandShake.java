package com.bytedance.sdk.component.adexpress.layout;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.utils.s;

public class TTHandShake extends LinearLayout implements a {
    private Context a;
    private LinearLayout b;
    private ImageView c;
    private TextView d;
    private TextView e;

    public TTHandShake(Context context) {
        super(context);
        this.a = context;
        a();
    }

    public LinearLayout getHandContainer() {
        return this.b;
    }

    public ImageView getRockImg() {
        return this.c;
    }

    public TextView getRockTopText() {
        return this.d;
    }

    public TextView getRockText() {
        return this.e;
    }

    private void a() {
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setOrientation(1);
        this.b = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) e.a(this.a, 110.0f), (int) e.a(this.a, 110.0f));
        this.b.setLayoutParams(layoutParams);
        layoutParams.gravity = 17;
        this.b.setGravity(17);
        this.b.setOrientation(1);
        addView(this.b);
        ImageView imageView = new ImageView(this.a);
        this.c = imageView;
        imageView.setLayoutParams(new LinearLayout.LayoutParams((int) e.a(this.a, 60.0f), (int) e.a(this.a, 60.0f)));
        this.c.setImageDrawable(s.c(this.a, "tt_splash_rock"));
        this.b.addView(this.c);
        this.d = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.d.setSingleLine(true);
        this.d.setLayoutParams(layoutParams2);
        this.d.setTextColor(-1);
        this.d.setText("Shake it");
        this.d.setTextSize(14.0f);
        this.d.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
        this.b.addView(this.d);
        this.e = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        this.e.setLayoutParams(layoutParams3);
        layoutParams3.gravity = 17;
        layoutParams3.topMargin = (int) e.a(this.a, 12.0f);
        this.e.setTextColor(-1);
        this.e.setText("Go to details page or third-party application");
        this.e.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
        addView(this.e);
    }
}
