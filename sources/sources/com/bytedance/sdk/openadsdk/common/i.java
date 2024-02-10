package com.bytedance.sdk.openadsdk.common;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog;
import com.bytedance.sdk.openadsdk.core.customview.PAGProgressBar;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ad;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TTTitleNewStyleManager */
public class i {
    TTAdDislikeDialog a;
    TTAdDislikeToast b;
    final AtomicBoolean c = new AtomicBoolean(false);
    final AtomicBoolean d = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final RelativeLayout e;
    private final q f;
    private final Context g;
    private ImageView h;
    private TextView i;
    private PAGProgressBar j;
    private final int k;
    /* access modifiers changed from: private */
    public boolean l;

    public i(Context context, RelativeLayout relativeLayout, q qVar) {
        this.g = context;
        this.e = relativeLayout;
        this.f = qVar;
        this.k = ad.b(o.a(), 44.0f);
        e();
    }

    private void e() {
        this.h = (ImageView) this.e.findViewById(com.bytedance.sdk.openadsdk.utils.i.ad);
        this.i = (TextView) this.e.findViewById(com.bytedance.sdk.openadsdk.utils.i.ae);
        ImageView imageView = (ImageView) this.e.findViewById(com.bytedance.sdk.openadsdk.utils.i.af);
        this.j = (PAGProgressBar) this.e.findViewById(com.bytedance.sdk.openadsdk.utils.i.ag);
        q qVar = this.f;
        if (qVar != null) {
            this.i.setText(TextUtils.isEmpty(qVar.V()) ? s.a(this.g, "tt_web_title_default") : this.f.V());
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                i.this.d();
            }
        });
    }

    public void a(int i2) {
        if (i2 == 100) {
            this.j.setVisibility(8);
            return;
        }
        this.j.setVisibility(0);
        this.j.setProgress(i2);
    }

    public void a() {
        try {
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.e.getLayoutParams();
            if (!this.l) {
                int i2 = marginLayoutParams.topMargin;
                int i3 = this.k;
                if (i2 == (-i3)) {
                    ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{-i3, 0});
                    ofInt.setDuration(300);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            marginLayoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            i.this.e.setLayoutParams(marginLayoutParams);
                        }
                    });
                    ofInt.addListener(new Animator.AnimatorListener() {
                        public void onAnimationCancel(Animator animator) {
                        }

                        public void onAnimationRepeat(Animator animator) {
                        }

                        public void onAnimationStart(Animator animator) {
                            boolean unused = i.this.l = true;
                        }

                        public void onAnimationEnd(Animator animator) {
                            boolean unused = i.this.l = false;
                        }
                    });
                    ofInt.start();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void b() {
        try {
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.e.getLayoutParams();
            if (!this.l && marginLayoutParams.topMargin == 0) {
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, -this.k});
                ofInt.setDuration(300);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        marginLayoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        i.this.e.setLayoutParams(marginLayoutParams);
                    }
                });
                ofInt.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                        boolean unused = i.this.l = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        boolean unused = i.this.l = false;
                    }
                });
                ofInt.start();
            }
        } catch (Throwable unused) {
        }
    }

    public ImageView c() {
        return this.h;
    }

    /* access modifiers changed from: protected */
    public void d() {
        if (this.d.get()) {
            g();
            return;
        }
        if (this.a == null) {
            f();
        }
        this.a.a();
    }

    private void f() {
        try {
            if (this.a == null) {
                TTAdDislikeDialog tTAdDislikeDialog = new TTAdDislikeDialog(this.g, this.f);
                this.a = tTAdDislikeDialog;
                tTAdDislikeDialog.setCallback(new TTAdDislikeDialog.a() {
                    public void c(View view) {
                    }

                    public void a(View view) {
                        i.this.c.set(true);
                    }

                    public void b(View view) {
                        i.this.c.set(false);
                    }

                    public void a(int i, FilterWord filterWord) {
                        if (!i.this.d.get() && filterWord != null && !filterWord.hasSecondOptions()) {
                            i.this.d.set(true);
                        }
                    }
                });
            }
            FrameLayout frameLayout = (FrameLayout) this.e.getRootView().findViewById(16908290);
            frameLayout.addView(this.a);
            if (this.b == null) {
                TTAdDislikeToast tTAdDislikeToast = new TTAdDislikeToast(this.g);
                this.b = tTAdDislikeToast;
                frameLayout.addView(tTAdDislikeToast);
            }
        } catch (Throwable unused) {
        }
    }

    private void g() {
        this.b.a(TTAdDislikeToast.getDislikeTip());
    }
}
