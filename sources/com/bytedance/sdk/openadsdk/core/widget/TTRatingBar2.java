package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.utils.ad;

public class TTRatingBar2 extends PAGFrameLayout {
    private static int f = -1;
    private static int g;
    private static int h;
    private static int i;
    private float a;
    private float b;
    private Drawable c;
    private Drawable d;
    private double e;
    private LinearLayout j;
    private LinearLayout k;

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public TTRatingBar2(Context context) {
        super(context);
        a();
    }

    private void a() {
        Context context = getContext();
        this.j = new LinearLayout(context);
        this.k = new LinearLayout(context);
        this.j.setOrientation(0);
        this.j.setGravity(8388611);
        this.k.setOrientation(0);
        this.k.setGravity(8388611);
        if (f < 0) {
            int a2 = (int) ad.a(context, 1.0f, false);
            f = a2;
            h = a2;
            i = (int) ad.a(context, 3.0f, false);
        }
        this.c = s.c(context, "tt_star_thick");
        this.d = s.c(context, "tt_star");
    }

    public Drawable getStarEmptyDrawable() {
        return this.c;
    }

    public Drawable getStarFillDrawable() {
        return this.d;
    }

    public void a(double d2, int i2, int i3) {
        float f2 = (float) i3;
        this.a = (float) ((int) ad.a(getContext(), f2, false));
        this.b = (float) ((int) ad.a(getContext(), f2, false));
        this.e = d2;
        this.j.removeAllViews();
        this.k.removeAllViews();
        removeAllViews();
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setColorFilter(i2);
            starImageView.setImageDrawable(getStarFillDrawable());
            this.k.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageDrawable(getStarEmptyDrawable());
            this.j.addView(starImageView2);
        }
        addView(this.j);
        addView(this.k);
        requestLayout();
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int) this.a, (int) this.b));
        imageView.setPadding(f, g, h, i);
        return imageView;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.j.measure(i2, i3);
        double d2 = this.e;
        float f2 = this.a;
        int i4 = f;
        double d3 = (double) ((((float) ((int) d2)) * f2) + ((float) i4));
        double d4 = (double) (f2 - ((float) (i4 + h)));
        double d5 = (double) ((int) d2);
        Double.isNaN(d5);
        Double.isNaN(d4);
        Double.isNaN(d3);
        this.k.measure(View.MeasureSpec.makeMeasureSpec((int) (d3 + (d4 * (d2 - d5))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.j.getMeasuredHeight(), 1073741824));
    }
}
