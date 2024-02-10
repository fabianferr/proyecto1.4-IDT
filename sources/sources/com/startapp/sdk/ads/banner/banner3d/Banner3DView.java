package com.startapp.sdk.ads.banner.banner3d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.startapp.a0;
import com.startapp.f9;
import com.startapp.i0;
import com.startapp.sdk.ads.banner.banner3d.Banner3DSize;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.json.RatingBar;

/* compiled from: Sta */
public class Banner3DView extends RelativeLayout {
    public TextView a;
    public TextView b;
    public ImageView c;
    public RatingBar d;
    public TextView e;
    public Point f;

    /* compiled from: Sta */
    public enum Template {
        a,
        M,
        L,
        XL
    }

    /* compiled from: Sta */
    public class a extends ShapeDrawable {
        public a(Banner3DView banner3DView, Shape shape) {
            super(shape);
        }

        public void onDraw(Shape shape, Canvas canvas, Paint paint) {
            paint.setColor(-11363070);
            paint.setMaskFilter(new EmbossMaskFilter(new float[]{1.0f, 1.0f, 1.0f}, 0.4f, 5.0f, 3.0f));
            super.onDraw(shape, canvas, paint);
        }
    }

    public Banner3DView(Context context) {
        super(context);
        a();
    }

    public final void a() {
        Context context = getContext();
        Template template = Template.a;
        int i = this.f.x;
        Banner3DSize.Size size = Banner3DSize.Size.SMALL;
        if (i > size.getSize().a.x || this.f.y > size.getSize().a.y) {
            template = Template.M;
        }
        int i2 = this.f.x;
        Banner3DSize.Size size2 = Banner3DSize.Size.MEDIUM;
        if (i2 > size2.getSize().a.x || this.f.y > size2.getSize().a.y) {
            template = Template.L;
        }
        int i3 = this.f.x;
        Banner3DSize.Size size3 = Banner3DSize.Size.LARGE;
        if (i3 > size3.getSize().a.x || this.f.y > size3.getSize().a.y) {
            template = Template.XL;
        }
        setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{AdsCommonMetaData.h.p(), AdsCommonMetaData.h.o()}));
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        int a2 = f9.a(context, 2);
        int a3 = i0.a(context, 1, (float) 3);
        Math.round(TypedValue.applyDimension(1, (float) 4, context.getResources().getDisplayMetrics()));
        int a4 = i0.a(context, 1, (float) 5);
        int a5 = i0.a(context, 1, (float) 6);
        int a6 = i0.a(context, 1, (float) 8);
        Math.round(TypedValue.applyDimension(1, (float) 10, context.getResources().getDisplayMetrics()));
        int a7 = i0.a(context, 1, (float) 20);
        Math.round(TypedValue.applyDimension(1, (float) 84, context.getResources().getDisplayMetrics()));
        int a8 = i0.a(context, 1, (float) 90);
        setPadding(a4, 0, a4, 0);
        setTag(this);
        ImageView imageView = new ImageView(context);
        this.c = imageView;
        imageView.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a8, a8);
        layoutParams.addRule(15);
        this.c.setLayoutParams(layoutParams);
        TextView textView = new TextView(context);
        this.a = textView;
        textView.setId(2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(a0.a(17), 1);
        layoutParams2.addRule(14);
        this.a.setLayoutParams(layoutParams2);
        this.a.setTextColor(AdsCommonMetaData.h.q().intValue());
        this.a.setGravity(a0.a(8388611));
        this.a.setBackgroundColor(0);
        int ordinal = template.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            this.a.setTextSize(17.0f);
            this.a.setPadding(a3, 0, 0, a2);
            Context context2 = getContext();
            double d2 = (double) this.f.x;
            Double.isNaN(d2);
            layoutParams2.width = f9.a(context2, (int) (d2 * 0.55d));
        } else if (ordinal == 2) {
            this.a.setTextSize(17.0f);
            this.a.setPadding(a3, 0, 0, a2);
            Context context3 = getContext();
            double d3 = (double) this.f.x;
            Double.isNaN(d3);
            layoutParams2.width = f9.a(context3, (int) (d3 * 0.65d));
        } else if (ordinal == 3 || ordinal == 4) {
            this.a.setTextSize(22.0f);
            this.a.setPadding(a3, 0, 0, a4);
        }
        this.a.setSingleLine(true);
        this.a.setEllipsize(TextUtils.TruncateAt.END);
        f9.a(this.a, AdsCommonMetaData.h.r());
        TextView textView2 = new TextView(context);
        this.b = textView2;
        textView2.setId(3);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(a0.a(17), 1);
        layoutParams3.addRule(3, 2);
        layoutParams3.setMargins(0, 0, 0, a4);
        this.b.setLayoutParams(layoutParams3);
        this.b.setTextColor(AdsCommonMetaData.h.l().intValue());
        this.b.setTextSize(18.0f);
        this.b.setMaxLines(2);
        this.b.setLines(2);
        this.b.setSingleLine(false);
        this.b.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.b.setHorizontallyScrolling(true);
        this.b.setPadding(a3, 0, 0, 0);
        RatingBar ratingBar = new RatingBar(getContext());
        this.d = ratingBar;
        ratingBar.setId(5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        int ordinal2 = template.ordinal();
        if (ordinal2 == 0 || ordinal2 == 1 || ordinal2 == 2) {
            layoutParams4.addRule(a0.a(17), 1);
            layoutParams4.addRule(8, 1);
        } else if (ordinal2 == 3 || ordinal2 == 4) {
            layoutParams4.addRule(a0.a(17), 2);
            Context context4 = getContext();
            double d4 = (double) this.f.x;
            Double.isNaN(d4);
            layoutParams3.width = f9.a(context4, (int) (d4 * 0.6d));
        }
        layoutParams4.setMargins(a3, a6, a3, 0);
        this.d.setLayoutParams(layoutParams4);
        this.e = new TextView(context);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        int ordinal3 = template.ordinal();
        if (ordinal3 == 0 || ordinal3 == 1 || ordinal3 == 2) {
            this.e.setTextSize(13.0f);
            layoutParams5.addRule(a0.a(17), 2);
            layoutParams5.addRule(15);
        } else if (ordinal3 == 3) {
            layoutParams5.addRule(a0.a(17), 3);
            layoutParams5.addRule(15);
            layoutParams5.setMargins(a7, 0, 0, 0);
            this.e.setTextSize(26.0f);
        } else if (ordinal3 == 4) {
            layoutParams5.addRule(a0.a(17), 3);
            layoutParams5.addRule(15);
            layoutParams5.setMargins(a7 * 7, 0, 0, 0);
            this.e.setTextSize(26.0f);
        }
        this.e.setPadding(a5, a5, a5, a5);
        this.e.setLayoutParams(layoutParams5);
        setButtonText(false);
        this.e.setTextColor(-1);
        this.e.setTypeface((Typeface) null, 1);
        this.e.setId(4);
        this.e.setShadowLayer(2.5f, -3.0f, 3.0f, -9013642);
        this.e.setBackgroundDrawable(new a(this, new RoundRectShape(new float[]{10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f}, (RectF) null, (float[]) null)));
        addView(this.c);
        addView(this.a);
        int ordinal4 = template.ordinal();
        if (ordinal4 == 0 || ordinal4 == 1 || ordinal4 == 2) {
            addView(this.e);
        } else if (ordinal4 == 3 || ordinal4 == 4) {
            addView(this.e);
            addView(this.b);
        }
        addView(this.d);
    }

    public void setButtonText(boolean z) {
        if (z) {
            this.e.setText("OPEN");
        } else {
            this.e.setText("DOWNLOAD");
        }
    }

    public void setDescription(String str) {
        if (str != null) {
            String str2 = "";
            if (str.compareTo(str2) != 0) {
                String[] a2 = a(str);
                String str3 = a2[0];
                String str4 = a2[1];
                if (str4 != null) {
                    str2 = a(str4)[0];
                }
                if (str.length() >= 110) {
                    str2 = str2 + "...";
                }
                this.b.setText(str3 + "\n" + str2);
            }
        }
    }

    public void setImage(Bitmap bitmap) {
        this.c.setImageBitmap(bitmap);
    }

    public void setRating(float f2) {
        try {
            this.d.setRating(f2);
        } catch (NullPointerException unused) {
        }
    }

    public void setText(String str) {
        this.a.setText(str);
    }

    public void setImage(int i, int i2, int i3) {
        this.c.setImageResource(i);
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i3;
        this.c.setLayoutParams(layoutParams);
    }

    public Banner3DView(Context context, Point point) {
        super(context);
        this.f = point;
        a();
    }

    public void setImage(Bitmap bitmap, int i, int i2) {
        this.c.setImageBitmap(bitmap);
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.c.setLayoutParams(layoutParams);
    }

    public Banner3DView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public Banner3DView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public final String[] a(String str) {
        boolean z;
        String[] strArr = new String[2];
        int i = 55;
        if (str.length() > 55) {
            char[] charArray = str.substring(0, 55).toCharArray();
            int length = charArray.length - 1;
            int i2 = length - 1;
            while (true) {
                if (i2 <= 0) {
                    z = false;
                    break;
                } else if (charArray[i2] == ' ') {
                    length = i2;
                    z = true;
                    break;
                } else {
                    i2--;
                }
            }
            if (z) {
                i = length;
            }
            strArr[0] = str.substring(0, i);
            strArr[1] = str.substring(i + 1, str.length());
        } else {
            strArr[0] = str;
            strArr[1] = null;
        }
        return strArr;
    }
}
