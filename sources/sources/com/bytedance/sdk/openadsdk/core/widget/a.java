package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.customview.PAGButton;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ad;

/* compiled from: CustomCommonDialog */
public class a extends Dialog {
    public C0070a a;
    private PAGImageView b;
    private PAGTextView c;
    private PAGTextView d;
    private PAGButton e;
    private PAGButton f;
    private View g;
    private final Context h;
    private String i;
    private String j;
    private String k;
    private String l;
    private int m = -1;
    private boolean n = false;

    /* renamed from: com.bytedance.sdk.openadsdk.core.widget.a$a  reason: collision with other inner class name */
    /* compiled from: CustomCommonDialog */
    public interface C0070a {
        void a();

        void b();
    }

    public a(Context context) {
        super(context, s.f(context, "tt_custom_dialog"));
        this.h = context;
    }

    private int a(float f2) {
        return ad.b(getContext(), f2);
    }

    private View a(Context context) {
        Context context2 = context;
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context2);
        pAGRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        pAGLinearLayout.setMinimumWidth(a(260.0f));
        pAGLinearLayout.setPadding(0, a(32.0f), 0, 0);
        pAGLinearLayout.setBackground(s.c(context2, "tt_custom_dialog_bg"));
        pAGLinearLayout.setOrientation(1);
        pAGLinearLayout.setLayoutParams(layoutParams);
        this.c = new PAGTextView(context2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.leftMargin = a(16.0f);
        layoutParams2.rightMargin = a(16.0f);
        layoutParams2.bottomMargin = a(16.0f);
        this.c.setGravity(17);
        this.c.setVisibility(0);
        this.c.setTextColor(Color.parseColor("#333333"));
        this.c.setTextSize(18.0f);
        this.c.setLayoutParams(layoutParams2);
        this.b = new PAGImageView(context2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        layoutParams3.leftMargin = a(16.0f);
        layoutParams3.rightMargin = a(16.0f);
        layoutParams3.bottomMargin = a(10.0f);
        this.b.setMaxHeight(a(150.0f));
        this.b.setMaxWidth(a(150.0f));
        this.b.setVisibility(0);
        this.b.setLayoutParams(layoutParams3);
        this.d = new PAGTextView(context2);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.leftMargin = a(20.0f);
        layoutParams4.rightMargin = a(20.0f);
        this.d.setGravity(17);
        this.d.setLineSpacing((float) a(3.0f), 1.2f);
        this.d.setTextSize(18.0f);
        this.d.setTextColor(Color.parseColor("#000000"));
        this.d.setLayoutParams(layoutParams4);
        View view = new View(context2);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, 1);
        layoutParams5.topMargin = a(32.0f);
        view.setBackgroundColor(Color.parseColor("#E4E4E4"));
        view.setLayoutParams(layoutParams5);
        PAGLinearLayout pAGLinearLayout2 = new PAGLinearLayout(context2);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        pAGLinearLayout2.setOrientation(0);
        pAGLinearLayout2.setLayoutParams(layoutParams6);
        PAGButton pAGButton = new PAGButton(context2);
        this.e = pAGButton;
        pAGButton.setId(520093718);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -2);
        layoutParams7.leftMargin = a(10.0f);
        layoutParams7.weight = 1.0f;
        this.e.setPadding(0, a(16.0f), 0, a(16.0f));
        this.e.setBackground((Drawable) null);
        this.e.setGravity(17);
        this.e.setSingleLine(true);
        this.e.setTextColor(Color.parseColor("#999999"));
        this.e.setTextSize(16.0f);
        this.e.setLayoutParams(layoutParams7);
        this.g = new View(context2);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(1, -1);
        this.g.setBackgroundColor(Color.parseColor("#E4E4E4"));
        this.g.setLayoutParams(layoutParams8);
        this.f = new PAGButton(context2);
        this.e.setId(520093719);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(0, -2);
        layoutParams9.rightMargin = a(10.0f);
        layoutParams9.weight = 1.0f;
        this.f.setPadding(0, a(16.0f), 0, a(16.0f));
        this.f.setBackground((Drawable) null);
        this.f.setGravity(17);
        this.f.setSingleLine(true);
        this.f.setTextColor(Color.parseColor("#38ADFF"));
        this.f.setTextSize(16.0f);
        this.f.setLayoutParams(layoutParams9);
        pAGRelativeLayout.addView(pAGLinearLayout);
        pAGLinearLayout.addView(this.c);
        pAGLinearLayout.addView(this.b);
        pAGLinearLayout.addView(this.d);
        pAGLinearLayout.addView(view);
        pAGLinearLayout.addView(pAGLinearLayout2);
        pAGLinearLayout2.addView(this.e);
        pAGLinearLayout2.addView(this.g);
        pAGLinearLayout2.addView(this.f);
        return pAGRelativeLayout;
    }

    private void a() {
        this.f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (a.this.a != null) {
                    a.this.a.a();
                }
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (a.this.a != null) {
                    a.this.a.b();
                }
            }
        });
    }

    private void b() {
        String str;
        PAGButton pAGButton;
        String str2;
        PAGButton pAGButton2;
        if (!TextUtils.isEmpty(this.j)) {
            this.c.setText(this.j);
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.i)) {
            this.d.setText(this.i);
        }
        if (!TextUtils.isEmpty(this.k)) {
            pAGButton = this.f;
            str = this.k;
        } else {
            pAGButton = this.f;
            str = s.a(o.a(), "tt_postive_txt");
        }
        pAGButton.setText(str);
        if (!TextUtils.isEmpty(this.l)) {
            pAGButton2 = this.e;
            str2 = this.l;
        } else {
            pAGButton2 = this.e;
            str2 = s.a(o.a(), "tt_negtive_txt");
        }
        pAGButton2.setText(str2);
        int i2 = this.m;
        if (i2 != -1) {
            this.b.setImageResource(i2);
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
        if (this.n) {
            this.g.setVisibility(8);
            this.e.setVisibility(8);
            return;
        }
        this.e.setVisibility(0);
        this.g.setVisibility(0);
    }

    public a a(C0070a aVar) {
        this.a = aVar;
        return this;
    }

    public a a(String str) {
        this.i = str;
        return this;
    }

    public a b(String str) {
        this.k = str;
        return this;
    }

    public a c(String str) {
        this.l = str;
        return this;
    }

    public void onBackPressed() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a(this.h));
        setCanceledOnTouchOutside(false);
        b();
        a();
    }

    public void show() {
        super.show();
        b();
    }
}
