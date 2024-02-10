package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.t;
import java.util.ArrayList;
import java.util.List;

public class MBridgeSegmentsProgressBar extends LinearLayout {
    private final String a = "MBridgeSegmentsProgressBar";
    private int b;
    private int c = 1;
    private int d = 20;
    private int e = 10;
    private int f = 1;
    private int g = -1711276033;
    private int h = -1;
    private List<ProgressBar> i = new ArrayList();
    private TextView j;
    private String k;
    private boolean l = false;

    public MBridgeSegmentsProgressBar(Context context) {
        super(context);
    }

    public MBridgeSegmentsProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBridgeSegmentsProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public MBridgeSegmentsProgressBar(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public void init(int i2, int i3) {
        this.b = i2;
        this.c = i3;
        a();
    }

    public void init(int i2, int i3, int i4, int i5) {
        this.b = i2;
        this.c = i3;
        this.h = i4;
        this.g = i5;
        a();
    }

    public void init(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.b = i2;
        this.c = i3;
        this.h = i4;
        this.g = i5;
        this.d = i6;
        this.e = i7;
        a();
    }

    private void a() {
        Drawable drawable;
        try {
            this.l = getContext().getResources().getConfiguration().locale.getLanguage().contains("zh");
        } catch (Throwable th) {
            aa.d("MBridgeSegmentsProgressBar", th.getMessage());
        }
        try {
            if (this.c == 1) {
                setOrientation(1);
                if (TextUtils.isEmpty(this.k)) {
                    this.k = this.l ? "正在播放第%s个，共%s个视频" : "The %s is playing, %s videos.";
                }
            }
            if (this.c == 2) {
                setOrientation(0);
                if (TextUtils.isEmpty(this.k)) {
                    this.k = this.l ? "广告 %s/%s" : "ADS %s/%s";
                }
            }
            this.i.clear();
            removeAllViews();
            setBackground(c());
            TextView textView = new TextView(getContext());
            this.j = textView;
            textView.setTextColor(-1);
            this.j.setTextSize(12.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.j.setLayoutParams(layoutParams);
            if (this.c == 1) {
                layoutParams.gravity = 5;
                TextView textView2 = this.j;
                int i2 = this.d;
                textView2.setPadding(i2 / 2, 15, i2 / 2, 5);
            }
            if (this.c == 2) {
                this.j.setGravity(16);
                TextView textView3 = this.j;
                int i3 = this.d;
                textView3.setPadding(i3 / 2, 0, i3 / 2, 0);
            }
            int a2 = t.a(getContext(), "mbridge_reward_video_icon", "drawable");
            if (!(a2 == 0 || (drawable = getContext().getResources().getDrawable(a2)) == null)) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.j.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                this.j.setCompoundDrawablePadding(5);
            }
        } catch (Throwable th2) {
            aa.d("MBridgeSegmentsProgressBar", th2.getMessage());
            return;
        }
        this.j.setText(a(this.f));
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 25);
        linearLayout.setLayoutParams(layoutParams2);
        for (int i4 = 0; i4 < this.b; i4++) {
            ProgressBar progressBar = new ProgressBar(getContext(), (AttributeSet) null, 16842872);
            progressBar.setMax(100);
            progressBar.setProgress(0);
            progressBar.setProgressDrawable(b());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, 20, 1.0f);
            layoutParams3.leftMargin = this.d / 2;
            layoutParams3.rightMargin = this.d / 2;
            progressBar.setLayoutParams(layoutParams3);
            linearLayout.addView(progressBar);
            this.i.add(progressBar);
        }
        if (this.c == 1) {
            setPadding(15, 10, 15, 25);
            addView(this.j);
            addView(linearLayout);
        }
        if (this.c == 2) {
            setPadding(15, 0, 15, 25);
            layoutParams2.gravity = 16;
            layoutParams2.weight = 1.0f;
            addView(linearLayout);
            addView(this.j);
        }
    }

    public void setIndicatorText(String str) {
        this.k = str;
    }

    public void setProgress(int i2, int i3) {
        try {
            if (this.i.size() != 0) {
                if (i3 < this.i.size()) {
                    this.i.get(i3).setProgress(i2);
                }
                int i4 = i3 + 1;
                if (i4 > this.f) {
                    this.f = i4;
                    TextView textView = this.j;
                    if (textView != null) {
                        textView.setText(a(i4));
                    }
                }
            }
        } catch (Throwable th) {
            aa.d("MBridgeSegmentsProgressBar", th.getMessage());
        }
    }

    private StringBuilder a(int i2) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(String.format(this.k, new Object[]{Integer.valueOf(i2), Integer.valueOf(this.b)}));
        } catch (Throwable th) {
            sb.append(this.b);
            sb.append("videos, the");
            sb.append(i2);
            sb.append(" is playing.");
            aa.d("MBridgeSegmentsProgressBar", th.getMessage());
        }
        return sb;
    }

    public void dismiss() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                MBridgeSegmentsProgressBar.this.setVisibility(8);
            }
        });
        startAnimation(alphaAnimation);
    }

    private LayerDrawable b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float) this.e);
        gradientDrawable.setColor(this.g);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius((float) this.e);
        gradientDrawable2.setColor(this.h);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, new ScaleDrawable(gradientDrawable2, 3, 1.0f, -1.0f)});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908301);
        return layerDrawable;
    }

    private GradientDrawable c() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setDither(true);
        gradientDrawable.setColors(new int[]{0, 1291845632});
        return gradientDrawable;
    }
}
