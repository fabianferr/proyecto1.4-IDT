package com.bytedance.sdk.openadsdk.component.reward.b;

import android.content.Context;
import android.graphics.Paint;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.b.b;
import com.bytedance.sdk.openadsdk.common.f;
import com.bytedance.sdk.openadsdk.component.reward.top.TopProxyLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.RFDownloadBarLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.RFEndCardBackUpLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.RewardFullBaseLayout;
import com.bytedance.sdk.openadsdk.core.b.e;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.model.o;
import com.bytedance.sdk.openadsdk.core.model.t;
import com.bytedance.sdk.openadsdk.core.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;
import com.google.android.material.badge.BadgeDrawable;

/* compiled from: RewardFullAdType */
public abstract class b extends a {
    protected String k;
    protected e l;
    public com.bytedance.sdk.openadsdk.core.widget.a m;
    public LinearLayout n;
    private com.bytedance.sdk.openadsdk.i.e o;

    /* compiled from: RewardFullAdType */
    public interface a {
        void a(boolean z);
    }

    /* access modifiers changed from: protected */
    public boolean B() {
        return true;
    }

    public abstract void a(FrameLayout frameLayout);

    public a d() {
        return null;
    }

    public abstract boolean e();

    public abstract boolean f();

    public abstract void g();

    public void n() {
    }

    public void s() {
    }

    public b(com.bytedance.sdk.openadsdk.component.reward.a.a aVar) {
        super(aVar);
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.c.b bVar, x xVar) {
        super.a(bVar, xVar);
        if (this.a.V.p()) {
            this.a.Q.a(false);
        }
        if (t.k(this.a.a)) {
            this.a.I.f();
        }
    }

    public void a(RewardFullBaseLayout rewardFullBaseLayout) {
        int B = this.b.B();
        if (B == 1 && !t.k(this.b)) {
            c(rewardFullBaseLayout);
        } else if (B == 3) {
            d(rewardFullBaseLayout);
        } else if (B == 5) {
            e(rewardFullBaseLayout);
        } else {
            b(rewardFullBaseLayout);
        }
    }

    public RFEndCardBackUpLayout h() {
        return new RFEndCardBackUpLayout(this.a.V);
    }

    public View i() {
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(this.a.V);
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(this.a.V);
        pAGRelativeLayout.setId(520093708);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ad.b((Context) this.a.V, 28.0f), ad.b((Context) this.a.V, 28.0f));
        layoutParams.gravity = BadgeDrawable.TOP_END;
        layoutParams.topMargin = ad.b((Context) this.a.V, 20.0f);
        layoutParams.rightMargin = ad.b((Context) this.a.V, 24.0f);
        pAGRelativeLayout.setLayoutParams(layoutParams);
        pAGRelativeLayout.setBackgroundResource(s.d(this.a.V, "tt_mute_btn_bg"));
        pAGRelativeLayout.setGravity(17);
        pAGRelativeLayout.setVisibility(8);
        pAGRelativeLayout.setContentDescription(s.a(this.a.V, "tt_ad_close_text"));
        PAGImageView pAGImageView = new PAGImageView(this.a.V);
        pAGImageView.setId(520093706);
        pAGImageView.setLayoutParams(new RelativeLayout.LayoutParams(ad.b((Context) this.a.V, 12.0f), ad.b((Context) this.a.V, 12.0f)));
        pAGImageView.setImageResource(s.d(this.a.V, "tt_video_close_drawable"));
        pAGImageView.setContentDescription(s.a(this.a.V, "tt_ad_close_text"));
        pAGRelativeLayout.addView(pAGImageView);
        PAGTextView pAGTextView = new PAGTextView(this.a.V);
        pAGTextView.setId(520093757);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ad.b((Context) this.a.V, 32.0f), ad.b((Context) this.a.V, 14.0f));
        layoutParams2.gravity = BadgeDrawable.BOTTOM_START;
        layoutParams2.leftMargin = ad.b((Context) this.a.V, 16.0f);
        layoutParams2.bottomMargin = ad.b((Context) this.a.V, 100.0f);
        pAGTextView.setLayoutParams(layoutParams2);
        pAGTextView.setBackgroundResource(s.d(this.a.V, "tt_ad_logo_new"));
        pAGTextView.setGravity(17);
        PAGImageView pAGImageView2 = new PAGImageView(this.a.V);
        pAGImageView2.setId(i.bh);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(ad.b((Context) this.a.V, 32.0f), ad.b((Context) this.a.V, 14.0f));
        layoutParams3.gravity = BadgeDrawable.BOTTOM_END;
        layoutParams3.rightMargin = ad.b((Context) this.a.V, 7.0f);
        layoutParams3.bottomMargin = ad.b((Context) this.a.V, 100.0f);
        pAGImageView2.setLayoutParams(layoutParams3);
        pAGImageView2.setPadding(ad.b((Context) this.a.V, 9.0f), 0, ad.b((Context) this.a.V, 9.0f), 0);
        pAGImageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        PlayableLoadingView playableLoadingView = new PlayableLoadingView(this.a.V);
        playableLoadingView.setId(i.bi);
        playableLoadingView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        playableLoadingView.setClickable(true);
        playableLoadingView.setFocusable(true);
        TopProxyLayout topProxyLayout = new TopProxyLayout(this.a.V);
        topProxyLayout.setId(i.bj);
        topProxyLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        pAGFrameLayout.addView(pAGRelativeLayout);
        pAGFrameLayout.addView(pAGTextView);
        pAGFrameLayout.addView(pAGImageView2);
        pAGFrameLayout.addView(playableLoadingView);
        pAGFrameLayout.addView(topProxyLayout);
        return pAGFrameLayout;
    }

    public View j() {
        PAGRelativeLayout pAGRelativeLayout;
        if (this.b.B() != 5) {
            pAGRelativeLayout = new PAGRelativeLayout(this.a.V);
            pAGRelativeLayout.setId(i.bg);
        } else {
            pAGRelativeLayout = null;
        }
        l.b("TTAD.RFAdType", "getLoadingFrameView" + pAGRelativeLayout);
        return pAGRelativeLayout;
    }

    /* access modifiers changed from: protected */
    public int k() {
        float f = 20.0f;
        float f2 = 100.0f;
        if (this.b.B() == 1 && !t.k(this.b)) {
            f2 = 20.0f;
        }
        if (!com.bytedance.sdk.openadsdk.core.model.l.a(this.b)) {
            f = f2;
        }
        return ad.b(this.a.W, f);
    }

    public void l() {
        this.a.K.a(this.a.f);
        this.a.T.b();
        this.a.T.a(k());
        this.a.S.a();
        if (!this.a.a.at()) {
            if (this.a.s) {
                m();
            }
            this.a.Q.a();
        }
        this.a.I.a();
        this.a.R.a();
        if (t.b(this.a.a)) {
            this.a.Q.h().setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            this.a.Q.i().setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            this.a.R.c(true);
            if (t.k(this.a.a)) {
                this.a.T.d();
                ad.a((View) this.a.Q.h(), 4);
                ad.a((View) this.a.Q.i(), 0);
            }
        }
        if (!o.c(this.a.a) && !o.b(this.a.a)) {
            this.a.T.a(ad.b(this.a.W, (float) this.a.l), ad.b(this.a.W, (float) this.a.m));
            this.a.H.a();
            if (t.k(this.a.a)) {
                this.a.Q.a(true);
                this.a.Q.e();
                a(false, false, false, b.a.c);
            } else if (this.a.V.q()) {
                this.a.T.b(0);
            }
        }
    }

    public void m() {
        LinearLayout linearLayout = (LinearLayout) this.a.V.findViewById(i.m);
        this.n = linearLayout;
        ad.a((View) linearLayout, 8);
        this.a.P = new f(this.a.V, this.a.a, "landingpage_endcard");
        this.a.P.c().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                b.this.a.T.j().performClick();
            }
        });
        this.n.addView(this.a.P.e(), new LinearLayout.LayoutParams(-1, -1));
        this.a.Q.a(this.a.P);
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        this.a.S.a(z, z2, z3, this, i);
    }

    public void o() {
        com.bytedance.sdk.openadsdk.core.widget.a aVar = this.m;
        if (aVar != null && aVar.isShowing()) {
            this.m.dismiss();
        }
    }

    public void p() {
        if (!this.a.s) {
            this.a.R.f();
            this.a.T.f(0);
        }
    }

    public void q() {
        this.j.removeMessages(300);
    }

    public void r() {
        if (this.a.u.get() && !this.a.s && this.a.F.getAndSet(false)) {
            if (this.a.t >= 0 || this.a.t == -1) {
                Message obtain = Message.obtain();
                obtain.what = 700;
                obtain.arg1 = this.a.t;
                this.a.X.sendMessage(obtain);
            }
        }
    }

    public void t() {
        if (this.a != null) {
            if (this.a.T != null) {
                this.a.T.q();
            }
            this.a.e = false;
            l.b("TTAD.RFAdType", "onPause mIsActivityShow=" + this.a.e + " mIsMute=" + this.a.d);
            if (!this.a.v.get()) {
                this.a.G.j();
            }
            q();
            this.a.Q.r();
            this.a.I.m();
            if (this.a.u.get()) {
                this.a.F.set(true);
            }
        }
    }

    public void u() {
        if (this.a != null) {
            if (this.a.T != null) {
                this.a.T.p();
            }
            l.b("TTAD.RFAdType", "onStop mIsMute=" + this.a.d + " mLast=" + this.a.O.a() + " mVolume=" + DeviceUtils.f());
            this.a.Q.q();
            if (this.a.d) {
                this.a.V.runOnUiThread(new Runnable() {
                    public void run() {
                        if (b.this.a.O.a() > 0) {
                            b.this.a.O.a(false);
                        }
                    }
                });
            }
        }
    }

    public void v() {
        if (this.a.J != null) {
            this.a.J.f();
        }
        if (this.a.T != null) {
            this.a.T.n();
        }
        this.a.G.d(this.a.f);
        if (!e() && !this.a.u.get()) {
            this.a.Q.x();
        }
        this.a.Q.n();
        this.a.I.e();
        this.a.T.l();
        this.a.S.c();
        this.a.K.b();
    }

    public void w() {
        int i;
        if (com.bytedance.sdk.openadsdk.core.o.d().s(String.valueOf(this.a.o)) == 1) {
            if (this.a.f) {
                if (t.k(this.a.a)) {
                    i = com.bytedance.sdk.openadsdk.core.o.d().a(String.valueOf(this.a.o), true);
                } else {
                    i = com.bytedance.sdk.openadsdk.core.o.d().j(String.valueOf(this.a.o));
                }
            } else if (t.k(this.a.a)) {
                i = com.bytedance.sdk.openadsdk.core.o.d().a(String.valueOf(this.a.o), false);
            } else {
                i = com.bytedance.sdk.openadsdk.core.o.d().q(String.valueOf(this.a.o));
            }
            if (this.a.T == null || !this.a.T.i()) {
                if ((this.a.u.get() && !t.k(this.a.a)) || i == -1) {
                    return;
                }
                if (((this.a.G != null && this.a.G.h() >= ((long) i) * 1000) || (this.a.I != null && this.a.I.j() - this.a.I.k() >= i)) && this.a.R != null) {
                    this.a.R.d();
                }
            } else if (this.a.T != null) {
                this.a.T.j().performClick();
            }
        }
    }

    public void x() {
        this.a.R.c();
        this.a.R.e(true);
    }

    public void y() {
        this.l = this.a.L.c();
    }

    public void z() {
        if (!f() && ((this instanceof g) || (this instanceof h))) {
            this.a.L.b();
        } else if (!this.i.a(this.e.i(), false)) {
            this.j.removeMessages(300);
            a(b.a.a);
            this.e.a(this.e.z() ^ true ? 1 : 0, 4);
        }
    }

    public void a(int i) {
        this.e.m();
        a(false, true, false, i);
        if (this.a.f) {
            this.i.c(10000);
        }
    }

    public void a(com.bytedance.sdk.openadsdk.i.e eVar) {
        this.o = eVar;
        c();
        if (!this.a.a.at() && B()) {
            A();
        }
        if (B()) {
            this.a.S.b();
        }
        if (o.c(this.a.a)) {
            this.j.sendEmptyMessageDelayed(500, 100);
        }
        this.a.T.a(this.a.k == 100.0f);
        y();
        g();
    }

    /* access modifiers changed from: protected */
    public final void A() {
        if (!this.a.V.isFinishing()) {
            this.a.Q.m();
            String str = this.a.f ? "reward_endcard" : "fullscreen_endcard";
            this.a.Q.a(Boolean.valueOf(this.a.V.o()), this.o, str);
            this.a.Q.a(str, (com.bytedance.sdk.openadsdk.core.video.c.b) this.a.V);
            this.a.I.a(this.o, this.a.d);
            this.a.Q.e();
        }
    }

    public void a(Message message) {
        l.b("TTAD.RFAdType", "handleMsg: " + message.what);
        int i = message.what;
        if (i == 1) {
            x();
        } else if (i == 300) {
            a(b.a.b);
            this.a.G.a(this.a.G.z() ^ true ? 1 : 0, true ^ this.a.G.z() ? 1 : 0);
            if (this.a.a.au() != null && this.a.a.au().a() != null) {
                this.a.a.au().a().a(com.bytedance.sdk.openadsdk.core.g.a.a.GENERAL_LINEAR_AD_ERROR);
            }
        } else if (i == 400) {
            this.a.G.m();
            a(false, true, false, 3);
        } else if (i == 500) {
            if (!t.b(this.a.a)) {
                this.a.R.c(false);
            }
            SSWebView h = this.a.Q.h();
            if (!(h == null || h.getWebView() == null)) {
                h.i();
                h.getWebView().resumeTimers();
            }
            if (this.a.Q.h() != null) {
                this.a.Q.a(1.0f);
                this.a.T.a(1.0f);
            }
            if (!this.a.V.o() && this.a.G.b() && this.a.C.get()) {
                this.a.G.m();
            }
        } else if (i == 600) {
            p();
        } else if (i == 700) {
            int i2 = message.arg1;
            if (this.a.F.get()) {
                return;
            }
            if (i2 > 0) {
                this.a.R.b();
                this.a.R.a((CharSequence) (i2 / 1000) + CmcdHeadersFactory.STREAMING_FORMAT_SS);
                this.a.R.e(false);
                Message obtain = Message.obtain();
                obtain.what = 700;
                obtain.arg1 = i2 - 1000;
                com.bytedance.sdk.openadsdk.component.reward.a.a aVar = this.a;
                aVar.t -= 1000;
                this.j.sendMessageDelayed(obtain, 1000);
                return;
            }
            this.j.removeMessages(700);
            if (!t.c(this.b) || !this.a.Q.p()) {
                p();
            } else {
                x();
            }
        }
    }

    static void b(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(context);
        pAGFrameLayout.setId(i.j);
        frameLayout.addView(pAGFrameLayout, new FrameLayout.LayoutParams(-1, -1));
        pAGFrameLayout.addView(a(context));
        RFDownloadBarLayout rFDownloadBarLayout = new RFDownloadBarLayout(context);
        rFDownloadBarLayout.setId(i.l);
        rFDownloadBarLayout.setPadding(ad.b(context, 15.0f), 0, 0, 0);
        rFDownloadBarLayout.setBackgroundColor(s.h(context, "tt_download_bar_background_new"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ad.b(context, 90.0f));
        layoutParams.gravity = 80;
        frameLayout.addView(rFDownloadBarLayout, layoutParams);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setId(i.m);
        pAGLinearLayout.setOrientation(1);
        pAGLinearLayout.setVisibility(8);
        frameLayout.addView(pAGLinearLayout, new FrameLayout.LayoutParams(-1, -1));
        SSWebView sSWebView = new SSWebView(context, true);
        sSWebView.setId(i.n);
        sSWebView.setLayerType(2, (Paint) null);
        sSWebView.setVisibility(4);
        frameLayout.addView(sSWebView, new FrameLayout.LayoutParams(-1, -1));
        SSWebView sSWebView2 = new SSWebView(context, true);
        sSWebView2.setId(i.o);
        sSWebView2.setVisibility(8);
        frameLayout.addView(sSWebView2, new FrameLayout.LayoutParams(-1, -1));
    }

    protected static FrameLayout a(Context context) {
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(context);
        pAGFrameLayout.setId(i.k);
        pAGFrameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        pAGFrameLayout.setLayoutParams(layoutParams);
        return pAGFrameLayout;
    }

    private void c(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        pAGRelativeLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        frameLayout.addView(pAGRelativeLayout, new FrameLayout.LayoutParams(-1, -1));
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(context);
        pAGFrameLayout.setId(i.k);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ad.b(context, 211.0f));
        layoutParams.addRule(13);
        pAGRelativeLayout.addView(pAGFrameLayout, layoutParams);
        View view = new View(context);
        view.setVisibility(8);
        view.setId(i.p);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(2, i.k);
        pAGRelativeLayout.addView(view, layoutParams2);
        RFDownloadBarLayout rFDownloadBarLayout = new RFDownloadBarLayout(context);
        rFDownloadBarLayout.setId(i.l);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ad.b(context, 280.0f), ad.b(context, 70.0f));
        layoutParams3.addRule(2, i.k);
        layoutParams3.addRule(14);
        layoutParams3.bottomMargin = ad.b(context, 33.0f);
        pAGRelativeLayout.addView(rFDownloadBarLayout, layoutParams3);
        View view2 = new View(context);
        view2.setId(i.aq);
        view2.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(3, i.k);
        pAGRelativeLayout.addView(view2, layoutParams4);
        PAGTextView pAGTextView = new PAGTextView(context);
        pAGTextView.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView.setLines(1);
        pAGTextView.setGravity(17);
        pAGTextView.setText(s.b(context, "tt_video_download_apk"));
        pAGTextView.setTextColor(-1);
        pAGTextView.setTextSize(2, 15.0f);
        pAGTextView.setBackgroundResource(s.d(context, "tt_reward_video_download_btn_bg"));
        pAGTextView.setId(520093705);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ad.b(context, 260.0f), ad.b(context, 36.0f));
        layoutParams5.addRule(3, i.k);
        layoutParams5.addRule(14);
        layoutParams5.topMargin = ad.b(context, 70.0f);
        pAGRelativeLayout.addView(pAGTextView, layoutParams5);
        SSWebView sSWebView = new SSWebView(context, true);
        sSWebView.setLayerType(2, (Paint) null);
        sSWebView.setVisibility(4);
        sSWebView.setId(i.n);
        pAGRelativeLayout.addView(sSWebView, new RelativeLayout.LayoutParams(-1, -1));
        SSWebView sSWebView2 = new SSWebView(context, true);
        sSWebView2.setVisibility(8);
        sSWebView2.setId(i.o);
        pAGRelativeLayout.addView(sSWebView2, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void d(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        frameLayout.addView(a(context));
        RFDownloadBarLayout rFDownloadBarLayout = new RFDownloadBarLayout(context);
        rFDownloadBarLayout.setBackgroundResource(s.d(context, "tt_reward_full_new_bar_bg"));
        rFDownloadBarLayout.setPadding(ad.b(context, 15.0f), 0, 0, 0);
        rFDownloadBarLayout.setId(i.l);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ad.b(context, 76.0f));
        layoutParams.gravity = 80;
        layoutParams.leftMargin = ad.b(context, 10.0f);
        layoutParams.rightMargin = ad.b(context, 10.0f);
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        layoutParams.bottomMargin = ad.b(context, 14.0f);
        frameLayout.addView(rFDownloadBarLayout, layoutParams);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setId(i.m);
        pAGLinearLayout.setVisibility(8);
        frameLayout.addView(pAGLinearLayout, new FrameLayout.LayoutParams(-1, -1));
        SSWebView sSWebView = new SSWebView(context, true);
        sSWebView.setLayerType(2, (Paint) null);
        sSWebView.setVisibility(4);
        sSWebView.setId(i.n);
        frameLayout.addView(sSWebView, new FrameLayout.LayoutParams(-1, -1));
        SSWebView sSWebView2 = new SSWebView(context, true);
        sSWebView2.setVisibility(8);
        sSWebView2.setId(i.o);
        frameLayout.addView(sSWebView2, new FrameLayout.LayoutParams(-1, -1));
    }

    private void e(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        frameLayout.addView(a(context));
        RFDownloadBarLayout rFDownloadBarLayout = new RFDownloadBarLayout(context);
        rFDownloadBarLayout.setBackgroundResource(s.d(context, "tt_reward_full_new_bar_bg"));
        rFDownloadBarLayout.setPadding(ad.b(context, 15.0f), 0, 0, 0);
        rFDownloadBarLayout.setId(i.l);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ad.b(context, 76.0f));
        layoutParams.gravity = 80;
        layoutParams.leftMargin = ad.b(context, 10.0f);
        layoutParams.rightMargin = ad.b(context, 10.0f);
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        layoutParams.bottomMargin = ad.b(context, 14.0f);
        frameLayout.addView(rFDownloadBarLayout, layoutParams);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setId(i.m);
        pAGLinearLayout.setVisibility(8);
        frameLayout.addView(pAGLinearLayout, new FrameLayout.LayoutParams(-1, -1));
        SSWebView sSWebView = new SSWebView(context, true);
        sSWebView.setLayerType(2, (Paint) null);
        sSWebView.setVisibility(4);
        sSWebView.setId(i.n);
        frameLayout.addView(sSWebView, new FrameLayout.LayoutParams(-1, -1));
        SSWebView sSWebView2 = new SSWebView(context, true);
        sSWebView2.setVisibility(8);
        sSWebView2.setId(i.o);
        frameLayout.addView(sSWebView2, new FrameLayout.LayoutParams(-1, -1));
    }
}
