package com.bytedance.sdk.component.adexpress.layout;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.utils.s;

public class TTDynamicHandShake extends LinearLayout {
    TextView a;
    private Context b;

    public TTDynamicHandShake(Context context) {
        super(context);
        this.b = context;
        a();
    }

    public TextView getTvButText() {
        return this.a;
    }

    private void a() {
        setGravity(17);
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setBackgroundResource(s.d(this.b, "tt_splash_unlock_btn_bg"));
        setPadding((int) e.a(this.b, 38.0f), (int) e.a(this.b, 20.0f), (int) e.a(this.b, 38.0f), (int) e.a(this.b, 20.0f));
        ImageView imageView = new ImageView(this.b);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setBackgroundResource(s.d(this.b, "tt_splash_shake_hand"));
        addView(imageView);
        this.a = new TextView(this.b);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.leftMargin = (int) e.a(this.b, 8.0f);
        this.a.setLayoutParams(marginLayoutParams);
        this.a.setTextColor(-1);
        this.a.setTextSize(17.0f);
        addView(this.a);
    }
}
