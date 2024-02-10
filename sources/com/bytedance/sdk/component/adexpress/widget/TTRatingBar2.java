package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.dynamic.c.j;
import com.bytedance.sdk.component.utils.s;

public class TTRatingBar2 extends FrameLayout {
    private static final int i = ((j.b("", 0.0f, true)[1] / 2) + 1);
    private static final int j = ((j.b("", 0.0f, true)[1] / 2) + 3);
    LinearLayout a = new LinearLayout(getContext());
    LinearLayout b = new LinearLayout(getContext());
    private float c;
    private float d;
    private Drawable e;
    private Drawable f;
    private double g;
    private float h;

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a.setOrientation(0);
        this.a.setGravity(8388611);
        this.b.setOrientation(0);
        this.b.setGravity(8388611);
        this.e = s.c(context, "tt_star_thick");
        this.f = s.c(context, "tt_star");
    }

    public Drawable getStarEmptyDrawable() {
        return this.e;
    }

    public Drawable getStarFillDrawable() {
        return this.f;
    }

    public void a(double d2, int i2, int i3, int i4) {
        float f2 = (float) i3;
        this.c = (float) ((int) e.c(getContext(), f2));
        this.d = (float) ((int) e.c(getContext(), f2));
        this.g = d2;
        this.h = (float) i4;
        removeAllViews();
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
            starImageView.setImageDrawable(getStarFillDrawable());
            this.b.addView(starImageView);
        }
        for (int i6 = 0; i6 < 5; i6++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageDrawable(getStarEmptyDrawable());
            this.a.addView(starImageView2);
        }
        addView(this.a);
        addView(this.b);
        requestLayout();
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int) this.c, (int) this.d));
        imageView.setPadding(1, i, 1, j);
        return imageView;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.a.measure(i2, i3);
        double d2 = this.g;
        float f2 = this.c;
        double d3 = (double) ((((float) ((int) d2)) * f2) + 1.0f);
        double d4 = (double) (f2 - 2.0f);
        double d5 = (double) ((int) d2);
        Double.isNaN(d5);
        Double.isNaN(d4);
        Double.isNaN(d3);
        this.b.measure(View.MeasureSpec.makeMeasureSpec((int) (d3 + (d4 * (d2 - d5))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.a.getMeasuredHeight(), 1073741824));
        if (this.h > 0.0f) {
            LinearLayout linearLayout = this.a;
            linearLayout.setPadding(0, ((int) (((float) linearLayout.getMeasuredHeight()) - this.h)) / 2, 0, 0);
            this.b.setPadding(0, ((int) (((float) this.a.getMeasuredHeight()) - this.h)) / 2, 0, 0);
        }
    }
}
