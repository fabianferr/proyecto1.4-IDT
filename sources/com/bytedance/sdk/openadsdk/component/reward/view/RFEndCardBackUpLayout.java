package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.component.reward.a.a;
import com.bytedance.sdk.openadsdk.core.b.e;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar2;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.k.c;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;
import com.google.android.material.badge.BadgeDrawable;

public class RFEndCardBackUpLayout extends PAGFrameLayout {
    private boolean a;
    /* access modifiers changed from: private */
    public a b;
    private TTRoundRectImageView c;
    private TextView d;
    private TTRatingBar2 e;
    private TextView f;
    private TextView g;
    private TextView h;

    public RFEndCardBackUpLayout(Context context) {
        super(context);
        setVisibility(8);
        setId(i.ap);
    }

    public void a(a aVar) {
        this.b = aVar;
        if (aVar.a.at()) {
            a();
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            a();
        }
    }

    private void a() {
        if (!this.a) {
            this.a = true;
            q qVar = this.b.a;
            if (qVar.at()) {
                b();
                return;
            }
            c();
            Context context = getContext();
            e e2 = this.b.L.e();
            this.g.setOnClickListener(e2);
            this.g.setOnTouchListener(e2);
            String X = qVar.X();
            if (!TextUtils.isEmpty(X)) {
                this.g.setText(X);
            }
            TTRoundRectImageView tTRoundRectImageView = this.c;
            if (tTRoundRectImageView != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tTRoundRectImageView.getLayoutParams();
                layoutParams.setMargins(0, ad.b(context, 50.0f), 0, 0);
                this.c.setLayoutParams(layoutParams);
            }
            if (!(this.c == null || qVar.N() == null || TextUtils.isEmpty(qVar.N().a()))) {
                c.a().a(qVar.N(), (ImageView) this.c, qVar);
            }
            TTRatingBar2 tTRatingBar2 = this.e;
            if (tTRatingBar2 != null) {
                ad.a((TextView) null, tTRatingBar2, qVar);
            }
            if (this.d != null) {
                if (qVar.aa() == null || TextUtils.isEmpty(qVar.aa().b())) {
                    this.d.setText(qVar.V());
                } else {
                    this.d.setText(qVar.aa().b());
                }
            }
            TextView textView = this.f;
            if (textView != null) {
                ad.a(textView, qVar, getContext(), "tt_comment_num_backup");
            }
            this.h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    try {
                        TTWebsiteActivity.a(RFEndCardBackUpLayout.this.b.V, RFEndCardBackUpLayout.this.b.a, RFEndCardBackUpLayout.this.b.g);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private void b() {
        Context context = getContext();
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        PAGImageView pAGImageView = new PAGImageView(context);
        pAGImageView.setId(i.h);
        pAGImageView.setVisibility(8);
        addView(pAGImageView, new FrameLayout.LayoutParams(-1, -1));
        SSWebView sSWebView = new SSWebView(context, true);
        sSWebView.setVisibility(8);
        sSWebView.setId(i.i);
        addView(sSWebView, new FrameLayout.LayoutParams(-1, -1));
    }

    private void c() {
        Context context = getContext();
        setBackgroundColor(-1);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setGravity(1);
        pAGLinearLayout.setOrientation(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        addView(pAGLinearLayout, layoutParams);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
        this.c = tTRoundRectImageView;
        tTRoundRectImageView.setBackgroundColor(0);
        pAGLinearLayout.addView(this.c, new LinearLayout.LayoutParams(ad.b(context, 100.0f), ad.b(context, 100.0f)));
        PAGTextView pAGTextView = new PAGTextView(context);
        this.d = pAGTextView;
        pAGTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.d.setSingleLine(true);
        this.d.setMaxWidth(ad.b(context, 180.0f));
        this.d.setTextColor(Color.parseColor("#ff333333"));
        this.d.setTextSize(2, 20.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, ad.b(context, 28.0f));
        layoutParams2.topMargin = ad.b(context, 16.0f);
        pAGLinearLayout.addView(this.d, layoutParams2);
        this.e = new TTRatingBar2(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, ad.b(context, 16.0f));
        layoutParams3.topMargin = ad.b(context, 12.0f);
        pAGLinearLayout.addView(this.e, layoutParams3);
        PAGTextView pAGTextView2 = new PAGTextView(context);
        this.f = pAGTextView2;
        pAGTextView2.setEllipsize(TextUtils.TruncateAt.END);
        this.f.setSingleLine(true);
        this.f.setTextColor(Color.parseColor("#ff93959a"));
        this.f.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, ad.b(context, 20.0f));
        layoutParams4.topMargin = ad.b(context, 8.0f);
        pAGLinearLayout.addView(this.f, layoutParams4);
        PAGTextView pAGTextView3 = new PAGTextView(context);
        this.g = pAGTextView3;
        pAGTextView3.setId(520093707);
        this.g.setGravity(17);
        this.g.setText(s.b(context, "tt_video_download_apk"));
        this.g.setTextColor(-1);
        this.g.setTextSize(2, 16.0f);
        this.g.setBackgroundResource(s.d(context, "tt_reward_full_video_backup_btn_bg"));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, ad.b(context, 46.0f));
        int b2 = ad.b(context, 20.0f);
        layoutParams5.bottomMargin = b2;
        layoutParams5.rightMargin = b2;
        layoutParams5.topMargin = b2;
        layoutParams5.leftMargin = b2;
        pAGLinearLayout.addView(this.g, layoutParams5);
        PAGTextView pAGTextView4 = new PAGTextView(context);
        this.h = pAGTextView4;
        pAGTextView4.setBackgroundResource(s.d(context, "tt_ad_logo_new"));
        this.h.setGravity(17);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(ad.b(context, 32.0f), ad.b(context, 14.0f));
        layoutParams6.gravity = BadgeDrawable.BOTTOM_START;
        layoutParams6.bottomMargin = ad.b(context, 16.0f);
        layoutParams6.leftMargin = ad.b(context, 20.0f);
        pAGLinearLayout.addView(this.h, layoutParams6);
    }
}
