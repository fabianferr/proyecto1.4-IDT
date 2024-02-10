package com.startapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataStyle;
import com.startapp.sdk.json.RatingBar;

/* compiled from: Sta */
public class t4 {
    public RelativeLayout a;
    public ImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public RatingBar f;
    public MetaDataStyle g = null;

    /* compiled from: Sta */
    public class a extends ShapeDrawable {
        public a(t4 t4Var, Shape shape) {
            super(shape);
        }

        public void onDraw(Shape shape, Canvas canvas, Paint paint) {
            paint.setColor(-11363070);
            paint.setMaskFilter(new EmbossMaskFilter(new float[]{1.0f, 1.0f, 1.0f}, 0.4f, 5.0f, 3.0f));
            super.onDraw(shape, canvas, paint);
        }
    }

    public t4(Context context) {
        Context context2 = context;
        context2.setTheme(16973829);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        this.a = new RelativeLayout(context2);
        this.a.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{AdsCommonMetaData.k().p(), AdsCommonMetaData.k().o()}));
        this.a.setLayoutParams(layoutParams);
        int a2 = f9.a(context2, 3);
        int a3 = f9.a(context2, 4);
        int a4 = f9.a(context2, 5);
        int a5 = f9.a(context2, 6);
        int a6 = f9.a(context2, 10);
        int a7 = f9.a(context2, 84);
        this.a.setPadding(a6, a2, a6, a2);
        this.a.setTag(this);
        ImageView imageView = new ImageView(context2);
        this.b = imageView;
        imageView.setId(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a7, a7);
        layoutParams2.addRule(15);
        this.b.setLayoutParams(layoutParams2);
        this.b.setPadding(0, 0, a5, 0);
        TextView textView = new TextView(context2);
        this.c = textView;
        textView.setId(2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(a0.a(17), 1);
        layoutParams3.addRule(6, 1);
        this.c.setLayoutParams(layoutParams3);
        this.c.setPadding(0, 0, 0, a4);
        this.c.setTextColor(AdsCommonMetaData.k().q().intValue());
        this.c.setTextSize((float) AdsCommonMetaData.k().s().intValue());
        this.c.setSingleLine(true);
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        f9.a(this.c, AdsCommonMetaData.k().r());
        TextView textView2 = new TextView(context2);
        this.d = textView2;
        textView2.setId(3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(a0.a(17), 1);
        layoutParams4.addRule(3, 2);
        layoutParams4.setMargins(0, 0, 0, a4);
        this.d.setLayoutParams(layoutParams4);
        this.d.setTextColor(AdsCommonMetaData.k().l().intValue());
        this.d.setTextSize((float) AdsCommonMetaData.k().n().intValue());
        this.d.setSingleLine(true);
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        f9.a(this.d, AdsCommonMetaData.k().m());
        this.f = new RatingBar(context2);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(a0.a(17), 1);
        layoutParams5.addRule(8, 1);
        layoutParams5.setMargins(0, 0, 0, -a4);
        this.f.setLayoutParams(layoutParams5);
        this.f.setPadding(0, 0, 0, a3);
        this.f.setId(5);
        this.e = new TextView(context2);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(a0.a(21));
        layoutParams6.addRule(8, 1);
        this.e.setLayoutParams(layoutParams6);
        a(false);
        this.e.setTextColor(-1);
        this.e.setTextSize(12.0f);
        this.e.setTypeface((Typeface) null, 1);
        this.e.setPadding(a6, a5, a6, a5);
        this.e.setId(4);
        this.e.setShadowLayer(2.5f, -3.0f, 3.0f, -9013642);
        this.e.setBackgroundDrawable(new a(this, new RoundRectShape(new float[]{10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f}, (RectF) null, (float[]) null)));
        this.a.addView(this.b);
        this.a.addView(this.c);
        this.a.addView(this.d);
        this.a.addView(this.f);
        this.a.addView(this.e);
    }

    public void a(boolean z) {
        if (z) {
            this.e.setText("Open");
        } else {
            this.e.setText("Download");
        }
    }
}
