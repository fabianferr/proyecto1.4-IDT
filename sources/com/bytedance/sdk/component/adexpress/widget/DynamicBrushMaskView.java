package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.layout.TTDynamicSplashLayoutBrushMaskView;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.s;

public class DynamicBrushMaskView extends FrameLayout {
    private RelativeLayout a;
    /* access modifiers changed from: private */
    public BrushMaskView b;
    private TextView c;
    private Context d;
    /* access modifiers changed from: private */
    public ObjectAnimator e;
    /* access modifiers changed from: private */
    public ImageView f;
    private ImageView g;
    private FrameLayout h;
    /* access modifiers changed from: private */
    public volatile boolean i;
    /* access modifiers changed from: private */
    public volatile boolean j = false;

    public void a() {
    }

    public DynamicBrushMaskView(Context context) {
        super(context);
        this.d = context;
        TTDynamicSplashLayoutBrushMaskView tTDynamicSplashLayoutBrushMaskView = new TTDynamicSplashLayoutBrushMaskView(context);
        addView(tTDynamicSplashLayoutBrushMaskView);
        a(tTDynamicSplashLayoutBrushMaskView);
    }

    public void setBrushText(String str) {
        if (this.c != null && !TextUtils.isEmpty(str)) {
            this.c.setText(str);
        }
    }

    private void a(TTDynamicSplashLayoutBrushMaskView tTDynamicSplashLayoutBrushMaskView) {
        this.b = tTDynamicSplashLayoutBrushMaskView.getBrushMaskView();
        this.a = tTDynamicSplashLayoutBrushMaskView.getBrushHandRelativeLayout();
        this.f = tTDynamicSplashLayoutBrushMaskView.getFirstStepImage();
        this.h = tTDynamicSplashLayoutBrushMaskView.getSplashBrushFl();
        this.g = tTDynamicSplashLayoutBrushMaskView.getImageHand();
        this.h.setClipChildren(false);
        this.c = tTDynamicSplashLayoutBrushMaskView.getBrushView();
        if (this.b != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.b.setWatermark(s.d(this.d, "tt_splash_brush_bg"));
            }
            this.b.post(new Runnable() {
                public void run() {
                    try {
                        if (DynamicBrushMaskView.this.e == null || !DynamicBrushMaskView.this.e.isStarted()) {
                            DynamicBrushMaskView.this.d();
                        }
                    } catch (Exception e) {
                        l.b("DynamicBrushMaskView", e.getMessage());
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        if (this.b != null) {
            this.i = false;
            int a2 = e.a(this.d);
            int i2 = (a2 * 336) / 375;
            int i3 = (i2 * 80) / 336;
            this.h.setLayoutParams(new RelativeLayout.LayoutParams(i2, i3));
            float f2 = (float) i2;
            final float f3 = f2 - (f2 / 3.0f);
            this.b.setEraserSize(((float) (this.b.getHeight() * 3)) / 5.0f);
            float a3 = e.a(getContext(), 15.0f);
            final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) f3, i3 / 2);
            int i4 = i3 / 4;
            layoutParams.topMargin = i4;
            float f4 = f2 / 6.0f;
            layoutParams.leftMargin = (int) f4;
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
            this.f.setLayoutParams(layoutParams);
            int i5 = (a2 * 58) / 375;
            this.g.setLayoutParams(new RelativeLayout.LayoutParams(500, 500));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i5, (i5 * 76) / 58);
            layoutParams2.topMargin = (int) (((float) i4) + a3);
            layoutParams2.leftMargin = (int) (f4 - (a3 * 1.5f));
            layoutParams2.setMarginStart(layoutParams2.leftMargin);
            layoutParams2.setMarginEnd(layoutParams2.rightMargin);
            this.a.setLayoutParams(layoutParams2);
            this.b.a(((float) this.b.getWidth()) / 6.0f, ((float) this.b.getHeight()) / 2.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "translationX", new float[]{0.0f, f3});
            this.e = ofFloat;
            ofFloat.setDuration(1000);
            this.e.setRepeatMode(1);
            this.e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    if (DynamicBrushMaskView.this.f != null) {
                        layoutParams.width = (int) (f3 * animatedFraction);
                        DynamicBrushMaskView.this.f.setLayoutParams(layoutParams);
                    }
                }
            });
            this.e.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (DynamicBrushMaskView.this.b != null) {
                        if (DynamicBrushMaskView.this.f != null) {
                            layoutParams.width = 0;
                            DynamicBrushMaskView.this.f.setLayoutParams(layoutParams);
                        }
                        if (!DynamicBrushMaskView.this.i) {
                            boolean unused = DynamicBrushMaskView.this.j = true;
                            DynamicBrushMaskView.this.b.postDelayed(new Runnable() {
                                public void run() {
                                    boolean unused = DynamicBrushMaskView.this.j = false;
                                    if (!DynamicBrushMaskView.this.i) {
                                        DynamicBrushMaskView.this.e.start();
                                    }
                                }
                            }, 100);
                        }
                    }
                }
            });
            ObjectAnimator objectAnimator = this.e;
            if (objectAnimator != null && !objectAnimator.isStarted() && !this.e.isRunning() && !this.j) {
                this.e.start();
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            try {
                ObjectAnimator objectAnimator = this.e;
                if (objectAnimator == null || (!objectAnimator.isStarted() && !this.e.isRunning() && !this.j)) {
                    BrushMaskView brushMaskView = this.b;
                    if (brushMaskView != null) {
                        brushMaskView.a();
                    }
                    RelativeLayout relativeLayout = this.a;
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(0);
                    }
                    d();
                }
            } catch (Exception e2) {
                l.e("DynamicBrushMaskView", e2.getMessage());
            }
        }
    }

    public void b() {
        if (!this.i) {
            this.i = true;
            ObjectAnimator objectAnimator = this.e;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                RelativeLayout relativeLayout = this.a;
                if (relativeLayout != null) {
                    relativeLayout.clearAnimation();
                    this.a.setVisibility(4);
                }
                this.b.a();
            }
            BrushMaskView brushMaskView = this.b;
            if (brushMaskView != null) {
                brushMaskView.setEraserSize((float) brushMaskView.getHeight());
                BrushMaskView brushMaskView2 = this.b;
                brushMaskView2.a(0.0f, ((float) brushMaskView2.getHeight()) / 2.0f);
                this.b.b();
            }
        }
    }

    public void c() {
        clearAnimation();
    }
}
