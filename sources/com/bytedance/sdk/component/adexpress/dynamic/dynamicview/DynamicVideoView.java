package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.adexpress.dynamic.a;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.dynamic.e;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.material.badge.BadgeDrawable;

public class DynamicVideoView extends DynamicBaseWidgetImp implements e {
    TextView a;
    FrameLayout b;
    boolean t = false;

    public boolean e() {
        return true;
    }

    public DynamicVideoView(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        this.o = new View(context);
        this.o.setTag(Integer.valueOf(getClickArea()));
        this.a = new TextView(context);
        this.b = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.c.e.a(context, 40.0f), (int) com.bytedance.sdk.component.adexpress.c.e.a(context, 15.0f));
        layoutParams.gravity = BadgeDrawable.BOTTOM_END;
        layoutParams.rightMargin = 20;
        layoutParams.bottomMargin = 20;
        this.a.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(25.0f);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.a.setBackground(gradientDrawable);
        this.a.setTextSize(10.0f);
        this.a.setGravity(17);
        this.a.setTextColor(-1);
        this.a.setVisibility(8);
        addView(this.b, new FrameLayout.LayoutParams(-1, -1));
        addView(this.a);
        addView(this.o, getWidgetLayoutParams());
        dynamicRootView.setVideoListener(this);
    }

    public boolean i() {
        super.i();
        double d = 0.0d;
        double d2 = 0.0d;
        for (h hVar = this.m; hVar != null; hVar = hVar.l()) {
            double f = (double) hVar.f();
            Double.isNaN(f);
            double d3 = d2 + f;
            double g = (double) hVar.g();
            Double.isNaN(g);
            double d4 = d + g;
            double d5 = (double) hVar.d();
            Double.isNaN(d5);
            d2 = d3 - d5;
            double e = (double) hVar.e();
            Double.isNaN(e);
            d = d4 - e;
        }
        try {
            float f2 = (float) d2;
            int a2 = (int) com.bytedance.sdk.component.adexpress.c.e.a(getContext(), f2);
            int a3 = (int) com.bytedance.sdk.component.adexpress.c.e.a(getContext(), f2 + this.e);
            if (b.a(getContext())) {
                DynamicRoot dynamicRoot = (DynamicRoot) this.n.getChildAt(0);
                DynamicRoot dynamicRoot2 = dynamicRoot;
                int dynamicWidth = dynamicRoot.getDynamicWidth();
                int i = dynamicWidth - a3;
                a3 = dynamicWidth - a2;
                a2 = i;
            }
            if (!"open_ad".equals(this.n.getRenderRequest().d())) {
                DynamicRoot dynamicRoot3 = (DynamicRoot) this.n.getChildAt(0);
                DynamicRoot dynamicRoot4 = dynamicRoot3;
                float f3 = (float) d;
                dynamicRoot3.a.a(a2, (int) com.bytedance.sdk.component.adexpress.c.e.a(getContext(), f3), a3, (int) com.bytedance.sdk.component.adexpress.c.e.a(getContext(), f3 + this.f));
            } else {
                this.n.c = this.b;
            }
        } catch (Exception unused) {
        }
        this.n.a(d2, d, (double) this.e, (double) this.f, this.l.o());
        return true;
    }

    public void setTimeUpdate(int i) {
        String str;
        String str2;
        if (!this.m.j().e().ay() || i <= 0 || this.t) {
            this.t = true;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                c(getChildAt(i2));
            }
            this.a.setVisibility(8);
            return;
        }
        if (i >= 60) {
            str = "0" + (i / 60);
        } else {
            str = "00";
        }
        String str3 = str + CertificateUtil.DELIMITER;
        int i3 = i % 60;
        if (i3 > 9) {
            str2 = str3 + i3;
        } else {
            str2 = str3 + "0" + i3;
        }
        this.a.setText(str2);
        this.a.setVisibility(0);
    }

    private void c(View view) {
        if (view != this.a && view != this.s) {
            try {
                if (((Integer) view.getTag(a.f)).intValue() == 1) {
                    return;
                }
            } catch (Throwable unused) {
            }
            int i = 0;
            view.setVisibility(0);
            if (view instanceof ViewGroup) {
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (i < viewGroup.getChildCount()) {
                        c(viewGroup.getChildAt(i));
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void a() {
        this.a.setVisibility(8);
    }
}
