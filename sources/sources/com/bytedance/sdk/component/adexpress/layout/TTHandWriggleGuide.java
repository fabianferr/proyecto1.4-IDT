package com.bytedance.sdk.component.adexpress.layout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.widget.WriggleGuideView;
import com.bytedance.sdk.component.utils.s;

public class TTHandWriggleGuide extends LinearLayout {
    private Context a;
    private LinearLayout b;
    private WriggleGuideView c;
    private ImageView d;
    private TextView e;
    private TextView f;

    public TTHandWriggleGuide(Context context) {
        super(context);
        this.a = context;
        a();
    }

    public LinearLayout getWriggleLayout() {
        return this.b;
    }

    public WriggleGuideView getProgressImg() {
        return this.c;
    }

    public ImageView getTopImage() {
        return this.d;
    }

    public TextView getTopText() {
        return this.e;
    }

    public TextView getBarText() {
        return this.f;
    }

    private void a() {
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setOrientation(1);
        this.b = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) e.a(this.a, 110.0f), (int) e.a(this.a, 110.0f));
        layoutParams.gravity = 17;
        this.b.setBottom((int) e.a(this.a, 4.0f));
        this.b.setLayoutParams(layoutParams);
        this.b.setGravity(17);
        this.b.setOrientation(1);
        addView(this.b);
        WriggleGuideView wriggleGuideView = new WriggleGuideView(this.a);
        this.c = wriggleGuideView;
        wriggleGuideView.setLayoutParams(new LinearLayout.LayoutParams((int) e.a(this.a, 60.0f), (int) e.a(this.a, 20.0f)));
        this.b.addView(this.c);
        ImageView imageView = new ImageView(this.a);
        this.d = imageView;
        imageView.setLayoutParams(new LinearLayout.LayoutParams((int) e.a(this.a, 60.0f), (int) e.a(this.a, 60.0f)));
        this.d.setImageDrawable(s.c(this.a, "tt_splash_twist"));
        this.b.addView(this.d);
        this.e = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.e.setLayoutParams(layoutParams2);
        this.e.setSingleLine(true);
        this.e.setTextColor(-1);
        this.e.setText(s.b(this.a, "tt_splash_wriggle_top_text"));
        this.e.setTextSize(18.0f);
        this.e.setTypeface((Typeface) null, 1);
        this.e.setShadowLayer(2.0f, 0.0f, 1.0f, Color.parseColor("#4D000000"));
        addView(this.e);
        this.f = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        this.f.setLayoutParams(layoutParams3);
        this.f.setSingleLine(true);
        this.f.setTextColor(-1);
        this.f.setText(s.b(this.a, "tt_splash_wriggle_text"));
        this.f.setTextSize(14.0f);
        this.f.setTypeface((Typeface) null, 1);
        this.f.setShadowLayer(2.0f, 0.0f, 1.0f, Color.parseColor("#4D000000"));
        addView(this.f);
    }
}
