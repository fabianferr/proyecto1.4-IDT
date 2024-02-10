package com.bytedance.sdk.openadsdk.component.reward.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.component.reward.a.a;
import com.bytedance.sdk.openadsdk.component.reward.view.RFEndCardBackUpLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.RewardFullBaseLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.model.o;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;

/* compiled from: RewardFullLandingPageType */
public class c extends b {
    public void a(FrameLayout frameLayout) {
    }

    public boolean e() {
        return true;
    }

    public void g() {
    }

    public RFEndCardBackUpLayout h() {
        return null;
    }

    public int k() {
        return 16;
    }

    public c(a aVar) {
        super(aVar);
    }

    public static boolean a(q qVar) {
        return o.b(qVar) || o.c(qVar);
    }

    public static void a(q qVar, FrameLayout frameLayout) {
        if (o.b(qVar)) {
            c(frameLayout);
        } else if (o.c(qVar)) {
            d(frameLayout);
        } else {
            b(frameLayout);
        }
    }

    static void c(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setOrientation(1);
        frameLayout.addView(pAGLinearLayout, new FrameLayout.LayoutParams(-1, -1));
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(context);
        pAGFrameLayout.setId(i.E);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        pAGLinearLayout.addView(pAGFrameLayout, layoutParams);
        PAGFrameLayout pAGFrameLayout2 = new PAGFrameLayout(context);
        pAGFrameLayout2.setId(i.j);
        pAGFrameLayout.addView(pAGFrameLayout2, new FrameLayout.LayoutParams(-1, -1));
        pAGFrameLayout2.addView(a(context));
        PAGFrameLayout pAGFrameLayout3 = new PAGFrameLayout(context);
        pAGFrameLayout3.setId(i.q);
        pAGFrameLayout3.setVisibility(8);
        pAGFrameLayout3.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        pAGFrameLayout2.addView(pAGFrameLayout3, layoutParams2);
        PAGImageView pAGImageView = new PAGImageView(context);
        pAGImageView.setId(i.r);
        pAGImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        pAGFrameLayout3.addView(pAGImageView, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.component.reward.view.a.b(pAGFrameLayout);
        PAGFrameLayout pAGFrameLayout4 = new PAGFrameLayout(context);
        pAGFrameLayout4.setId(i.s);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 0.0f;
        pAGLinearLayout.addView(pAGFrameLayout4, layoutParams3);
        pAGFrameLayout4.addView(b(context));
        LinearLayout c = c(context);
        c.setBackgroundColor(Color.parseColor("#70161823"));
        pAGFrameLayout4.addView(c);
        c.addView(d(context));
        com.bytedance.sdk.openadsdk.component.reward.view.a.a(pAGFrameLayout4);
    }

    private static SSWebView b(Context context) {
        SSWebView sSWebView = new SSWebView(context);
        sSWebView.setId(i.t);
        sSWebView.setLayerType(2, (Paint) null);
        sSWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return sSWebView;
    }

    private static LinearLayout c(Context context) {
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setId(i.u);
        pAGLinearLayout.setOrientation(1);
        pAGLinearLayout.setVisibility(8);
        pAGLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return pAGLinearLayout;
    }

    private static ImageView d(Context context) {
        PAGImageView pAGImageView = new PAGImageView(context);
        pAGImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        pAGImageView.setImageResource(s.d(context, "tt_up_slide"));
        pAGImageView.setId(i.v);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ad.b(context, 18.0f), ad.b(context, 16.0f));
        layoutParams.gravity = 17;
        layoutParams.topMargin = ad.b(context, 45.0f);
        pAGImageView.setLayoutParams(layoutParams);
        return pAGImageView;
    }

    static void d(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(context);
        pAGFrameLayout.setId(i.s);
        frameLayout.addView(pAGFrameLayout, new FrameLayout.LayoutParams(-1, -1));
        pAGFrameLayout.addView(b(context));
        LinearLayout c = c(context);
        c.setBackgroundColor(Color.parseColor("#99161823"));
        pAGFrameLayout.addView(c);
        c.addView(d(context));
        com.bytedance.sdk.openadsdk.component.reward.view.a.a(pAGFrameLayout);
        PAGFrameLayout pAGFrameLayout2 = new PAGFrameLayout(context);
        pAGFrameLayout2.setId(i.E);
        frameLayout.addView(pAGFrameLayout2, new FrameLayout.LayoutParams(-1, -1));
        PAGFrameLayout pAGFrameLayout3 = new PAGFrameLayout(context);
        pAGFrameLayout3.setId(i.j);
        pAGFrameLayout2.addView(pAGFrameLayout3, new FrameLayout.LayoutParams(-1, -1));
        pAGFrameLayout3.addView(a(context));
        PAGFrameLayout pAGFrameLayout4 = new PAGFrameLayout(context);
        pAGFrameLayout4.setId(i.q);
        pAGFrameLayout4.setVisibility(8);
        pAGFrameLayout4.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        pAGFrameLayout3.addView(pAGFrameLayout4, layoutParams);
        PAGImageView pAGImageView = new PAGImageView(context);
        pAGImageView.setId(i.r);
        pAGImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        pAGFrameLayout4.addView(pAGImageView, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.component.reward.view.a.b(pAGFrameLayout2);
        PlayableLoadingView playableLoadingView = new PlayableLoadingView(context);
        playableLoadingView.setId(i.F);
        playableLoadingView.setClickable(true);
        playableLoadingView.setFocusable(true);
        frameLayout.addView(playableLoadingView, new FrameLayout.LayoutParams(-1, -1));
    }

    public void a(RewardFullBaseLayout rewardFullBaseLayout) {
        a(this.b, rewardFullBaseLayout);
    }

    public void n() {
        if (!(!o.b(this.a.a) || this.a.T == null || this.a.T.o == null)) {
            if (this.a.T.o.c()) {
                this.a.T.c(0);
                this.a.A.set(true);
            } else {
                this.a.B.set(true);
                a(true, false, true, 80);
            }
        }
        if (o.c(this.a.a)) {
            a(true, false, true, 70);
        }
    }

    public boolean f() {
        if (o.b(this.a.a)) {
            return true;
        }
        return !o.c(this.a.a);
    }
}
