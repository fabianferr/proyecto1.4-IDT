package com.bytedance.sdk.openadsdk.component.reward.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.media3.common.C;
import com.bytedance.sdk.component.d.j;
import com.bytedance.sdk.component.d.o;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.component.reward.view.PAGLoadingBaseLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.PAGPAGLoadingFourLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.PAGPAGLoadingOneLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.PAGPAGLoadingThreeLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.PAGPAGLoadingTwoLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGProgressBar;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.core.widget.TwoSemicirclesView;
import com.bytedance.sdk.openadsdk.f.b;
import com.bytedance.sdk.openadsdk.f.d;
import com.bytedance.sdk.openadsdk.utils.ad;
import java.lang.ref.WeakReference;

/* compiled from: RewardFullVideoLoadingManager */
public class k {
    TTRoundRectImageView a;
    TextView b;
    PAGProgressBar c;
    TextView d;
    /* access modifiers changed from: private */
    public final q e;
    /* access modifiers changed from: private */
    public final Context f;
    private int g = 0;
    private PAGLoadingBaseLayout h;
    private LinearLayout i;
    private TwoSemicirclesView j;
    private TwoSemicirclesView k;
    private TextView l;
    /* access modifiers changed from: private */
    public final String m;
    private final int n;
    private AnimatorSet o;
    private AnimatorSet p;

    public k(a aVar) {
        this.f = aVar.W;
        this.e = aVar.a;
        this.m = aVar.g;
        this.n = aVar.j;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0029 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e A[Catch:{ all -> 0x0048 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044 A[Catch:{ all -> 0x0048 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r3 = this;
            com.bytedance.sdk.openadsdk.core.model.q r0 = r3.e     // Catch:{ all -> 0x0048 }
            boolean r0 = com.bytedance.sdk.openadsdk.core.model.q.c((com.bytedance.sdk.openadsdk.core.model.q) r0)     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0048
            com.bytedance.sdk.openadsdk.core.model.q r0 = r3.e     // Catch:{ all -> 0x0048 }
            boolean r0 = com.bytedance.sdk.openadsdk.core.model.t.k(r0)     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0011
            goto L_0x0048
        L_0x0011:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0029 }
            com.bytedance.sdk.openadsdk.core.model.q r1 = r3.e     // Catch:{ JSONException -> 0x0029 }
            com.bytedance.sdk.openadsdk.core.model.q$a r1 = r1.I()     // Catch:{ JSONException -> 0x0029 }
            java.lang.String r1 = r1.j()     // Catch:{ JSONException -> 0x0029 }
            r0.<init>(r1)     // Catch:{ JSONException -> 0x0029 }
            java.lang.String r1 = "loading_page_type"
            r2 = 0
            int r0 = r0.optInt(r1, r2)     // Catch:{ JSONException -> 0x0029 }
            r3.g = r0     // Catch:{ JSONException -> 0x0029 }
        L_0x0029:
            int r0 = r3.g     // Catch:{ all -> 0x0048 }
            r1 = 1
            if (r0 == r1) goto L_0x0044
            r1 = 2
            if (r0 == r1) goto L_0x0040
            r1 = 3
            if (r0 == r1) goto L_0x003c
            r1 = 4
            if (r0 == r1) goto L_0x0038
            goto L_0x0048
        L_0x0038:
            r3.h()     // Catch:{ all -> 0x0048 }
            goto L_0x0048
        L_0x003c:
            r3.g()     // Catch:{ all -> 0x0048 }
            goto L_0x0048
        L_0x0040:
            r3.f()     // Catch:{ all -> 0x0048 }
            goto L_0x0048
        L_0x0044:
            r3.e()     // Catch:{ all -> 0x0048 }
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.a.k.a():void");
    }

    public void b() {
        try {
            int i2 = this.g;
            if (i2 == 1) {
                i();
            } else if (i2 == 2) {
                j();
            } else if (i2 == 3) {
                k();
            } else if (i2 == 4) {
                l();
            }
        } catch (Throwable unused) {
        }
    }

    private void e() {
        PAGPAGLoadingOneLayout pAGPAGLoadingOneLayout = new PAGPAGLoadingOneLayout(this.f);
        this.h = pAGPAGLoadingOneLayout;
        this.a = pAGPAGLoadingOneLayout.getLoadingIcon();
        this.b = this.h.getLoadingAppName();
        this.c = this.h.getLoadingProgressBar();
        this.d = this.h.getLoadingProgressNumber();
        this.l = this.h.getLoadingLogo();
        if (this.n == 1 && this.e.aa() != null && !TextUtils.isEmpty(this.e.aa().b())) {
            this.b.setText(this.e.aa().b());
        } else if (!TextUtils.isEmpty(this.e.V())) {
            this.b.setText(this.e.V());
        } else {
            this.b.setVisibility(8);
        }
        m();
        this.l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TTWebsiteActivity.a(k.this.f, k.this.e, k.this.m);
            }
        });
    }

    private void f() {
        PAGPAGLoadingTwoLayout pAGPAGLoadingTwoLayout = new PAGPAGLoadingTwoLayout(this.f);
        this.h = pAGPAGLoadingTwoLayout;
        this.a = pAGPAGLoadingTwoLayout.getLoadingIcon();
        this.d = this.h.getLoadingProgressNumber();
        this.l = this.h.getLoadingLogo();
        m();
        this.l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TTWebsiteActivity.a(k.this.f, k.this.e, k.this.m);
            }
        });
    }

    private void g() {
        PAGPAGLoadingThreeLayout pAGPAGLoadingThreeLayout = new PAGPAGLoadingThreeLayout(this.f);
        this.h = pAGPAGLoadingThreeLayout;
        this.i = pAGPAGLoadingThreeLayout.getWaveContainer();
        this.d = this.h.getLoadingProgressNumber();
        PAGTextView loadingLogo = this.h.getLoadingLogo();
        this.l = loadingLogo;
        loadingLogo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TTWebsiteActivity.a(k.this.f, k.this.e, k.this.m);
            }
        });
    }

    private void h() {
        PAGPAGLoadingFourLayout pAGPAGLoadingFourLayout = new PAGPAGLoadingFourLayout(this.f);
        this.h = pAGPAGLoadingFourLayout;
        this.j = pAGPAGLoadingFourLayout.getInnerCircle();
        this.k = this.h.getOuterCircle();
        this.j.setRadius((float) ad.b(this.f, 80.0f));
        Paint paintTwo = this.j.getPaintTwo();
        paintTwo.setColor(Color.parseColor("#C4C4C4"));
        this.j.setPaintTwo(paintTwo);
        this.k.setRadius((float) ad.b(this.f, 95.0f));
        Paint paintTwo2 = this.k.getPaintTwo();
        paintTwo2.setStrokeWidth(6.0f);
        paintTwo2.setColor(Color.parseColor("#118BFF"));
        this.k.setPaintTwo(paintTwo2);
        this.d = this.h.getLoadingProgressNumber();
        PAGTextView loadingLogo = this.h.getLoadingLogo();
        this.l = loadingLogo;
        loadingLogo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TTWebsiteActivity.a(k.this.f, k.this.e, k.this.m);
            }
        });
    }

    private void i() {
        n();
    }

    private void j() {
        Context context = this.f;
        this.a.setAnimation(AnimationUtils.loadAnimation(context, s.j(context, "tt_loading_two_icon_scale")));
        n();
    }

    private void k() {
        this.o = new AnimatorSet();
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(linearLayout.getChildAt(0), "translationY", new float[]{-9.0f, 9.0f}).setDuration(300);
            duration.setRepeatMode(2);
            duration.setRepeatCount(-1);
            AnimatorSet.Builder play = this.o.play(duration);
            for (int i2 = 1; i2 < this.i.getChildCount(); i2++) {
                float f2 = i2 % 2 == 0 ? 9.0f : -9.0f;
                ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.i.getChildAt(i2), "translationY", new float[]{-f2, f2}).setDuration(300);
                duration2.setRepeatMode(2);
                duration2.setRepeatCount(-1);
                play = play.with(duration2);
            }
            this.o.start();
        }
        n();
    }

    private void l() {
        this.o = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.j, Key.ROTATION, new float[]{0.0f, 360.0f}).setDuration(1500);
        duration.setInterpolator(new LinearInterpolator());
        duration.setRepeatCount(-1);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.k, Key.ROTATION, new float[]{0.0f, 360.0f}).setDuration(2500);
        duration2.setRepeatCount(-1);
        this.o.playTogether(new Animator[]{duration, duration2});
        this.o.start();
        n();
    }

    private void m() {
        if (this.e.N() == null || TextUtils.isEmpty(this.e.N().a())) {
            this.a.setVisibility(8);
            return;
        }
        try {
            j a2 = d.a(this.e.N());
            q qVar = this.e;
            a2.a((o) new b(qVar, qVar.N().a(), new a(this.a)));
        } catch (Throwable unused) {
            this.a.setVisibility(8);
        }
    }

    private void n() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{1, 80});
        ofInt.setDuration(2000);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (k.this.c != null) {
                    k.this.c.setProgress(intValue);
                }
                k.this.d.setText(String.valueOf(intValue));
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{81, 99});
        ofInt2.setDuration(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (k.this.c != null) {
                    k.this.c.setProgress(intValue);
                }
                k.this.d.setText(String.valueOf(intValue));
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.p = animatorSet;
        animatorSet.play(ofInt).before(ofInt2);
        this.p.start();
    }

    public void c() {
        AnimatorSet animatorSet = this.o;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.p;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
    }

    public View d() {
        return this.h;
    }

    /* compiled from: RewardFullVideoLoadingManager */
    private static class a implements o<Bitmap> {
        private final WeakReference<ImageView> a;

        public a(ImageView imageView) {
            this.a = new WeakReference<>(imageView);
        }

        public void a(com.bytedance.sdk.component.d.k<Bitmap> kVar) {
            ImageView imageView = (ImageView) this.a.get();
            if (imageView != null) {
                if (kVar != null) {
                    try {
                        if (kVar.b() != null) {
                            imageView.setImageBitmap(kVar.b());
                            return;
                        }
                    } catch (Throwable unused) {
                        imageView.setVisibility(8);
                        return;
                    }
                }
                imageView.setVisibility(8);
            }
        }

        public void a(int i, String str, Throwable th) {
            ImageView imageView = (ImageView) this.a.get();
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
    }
}
