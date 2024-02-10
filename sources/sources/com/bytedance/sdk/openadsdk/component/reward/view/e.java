package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.component.reward.a.a;
import com.bytedance.sdk.openadsdk.component.reward.a.k;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.customview.PAGProgressBar;
import com.bytedance.sdk.openadsdk.core.model.o;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.t;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: RewardFullVideoLayout */
public class e {
    int a = 3;
    final Activity b;
    final q c;
    ImageView d;
    RelativeLayout e;
    FrameLayout f;
    View g;
    View h;
    TextView i;
    ImageView j;
    RelativeLayout k;
    k l;
    protected int m = 0;
    protected final AtomicBoolean n = new AtomicBoolean(false);
    public o o;
    PAGProgressBar p;
    Runnable q = new Runnable() {
        public void run() {
            try {
                if ((e.this.c == null || !e.this.c.bd()) && e.this.e != null) {
                    int[] iArr = new int[2];
                    e.this.e.getLocationOnScreen(iArr);
                    e.this.r.R.b(iArr[0]);
                }
            } catch (Exception unused) {
            }
        }
    };
    /* access modifiers changed from: private */
    public final a r;
    private final boolean s;
    /* access modifiers changed from: private */
    public final String t;
    private int u;
    private boolean v;
    private RFDownloadBarLayout w;

    /* access modifiers changed from: protected */
    public boolean a() {
        return true;
    }

    public e(a aVar) {
        this.r = aVar;
        this.b = aVar.V;
        this.c = aVar.a;
        this.t = aVar.g;
        this.s = aVar.f;
    }

    public void b() {
        if (!this.v) {
            this.v = true;
            this.u = this.r.j;
            if (a()) {
                k kVar = new k(this.r);
                this.l = kVar;
                kVar.a();
            }
            s();
            o oVar = new o(this.b, this.c, this.t, this.f);
            this.o = oVar;
            oVar.a();
        }
    }

    private void s() {
        RelativeLayout relativeLayout;
        RFDownloadBarLayout rFDownloadBarLayout = (RFDownloadBarLayout) this.b.findViewById(i.l);
        this.w = rFDownloadBarLayout;
        rFDownloadBarLayout.a(this.r);
        this.i = (TextView) this.b.findViewById(520093757);
        this.j = (ImageView) this.b.findViewById(i.bh);
        this.d = (ImageView) this.b.findViewById(520093706);
        this.e = (RelativeLayout) this.b.findViewById(520093708);
        this.f = (FrameLayout) this.b.findViewById(i.k);
        this.g = this.b.findViewById(i.p);
        this.h = this.b.findViewById(i.aq);
        this.k = (RelativeLayout) this.b.findViewById(i.bg);
        k kVar = this.l;
        if (kVar != null && kVar.d() != null && (relativeLayout = this.k) != null) {
            relativeLayout.addView(this.l.d(), new LinearLayout.LayoutParams(-1, -1));
            this.l.b();
        }
    }

    public void c() {
        this.f.removeAllViews();
    }

    public void a(int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
        marginLayoutParams.setMargins(16, 0, 0, i2);
        this.i.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.j.getLayoutParams();
        marginLayoutParams2.setMargins(0, 0, 7, i2);
        marginLayoutParams2.setMarginStart(0);
        marginLayoutParams2.setMarginEnd(7);
        this.j.setLayoutParams(marginLayoutParams2);
    }

    public void a(boolean z) {
        int i2 = 8;
        ad.a((View) this.i, t.k(this.c) ? 8 : 0);
        ImageView imageView = this.j;
        if (this.c.at() && this.c.h()) {
            i2 = 0;
        }
        ad.a((View) imageView, i2);
        b(z);
        if (this.s) {
            e();
        }
    }

    public void b(int i2) {
        if (this.p == null) {
            this.p = new PAGProgressBar(this.r.V);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(120, 120);
            layoutParams.gravity = 17;
            this.p.setLayoutParams(layoutParams);
            this.p.setIndeterminateDrawable(ResourcesCompat.getDrawable(this.r.V.getResources(), s.d(this.r.V, "tt_video_loading_progress_bar"), (Resources.Theme) null));
            this.r.T.f().addView(this.p);
        }
        this.p.setVisibility(i2);
    }

    public void a(int i2, int i3) {
        FrameLayout frameLayout;
        if (this.c.B() == 1 && (frameLayout = this.f) != null && (frameLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            int c2 = ad.c((Context) this.b);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams.width = c2;
            int i4 = (c2 * 9) / 16;
            layoutParams.height = i4;
            this.f.setLayoutParams(layoutParams);
            this.m = (ad.d((Context) this.b) - i4) / 2;
            l.e("TTAD.RFullVideoLayout", "NonContentAreaHeight:" + this.m);
        }
    }

    public void a(c cVar, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        View view;
        View view2;
        q qVar;
        if (!(this.f == null || (qVar = this.c) == null || qVar.C() == null)) {
            if (!this.c.C().f || o.b(this.c)) {
                a(onClickListener);
            } else {
                a((View.OnClickListener) cVar);
                a(cVar);
            }
        }
        q qVar2 = this.c;
        if (qVar2 != null && qVar2.B() == 1) {
            if (!(this.c.C() == null || (view2 = this.g) == null)) {
                ad.a(view2, 0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
                layoutParams.height = this.m;
                this.g.setLayoutParams(layoutParams);
                if (this.c.C().b) {
                    this.g.setOnClickListener(cVar);
                    this.g.setOnTouchListener(onTouchListener);
                } else {
                    this.g.setOnClickListener(onClickListener);
                }
            }
            if (!(this.c.C() == null || (view = this.h) == null)) {
                ad.a(view, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
                layoutParams2.height = this.m;
                this.h.setLayoutParams(layoutParams2);
                if (this.c.C().d) {
                    this.h.setOnClickListener(cVar);
                    this.h.setOnTouchListener(onTouchListener);
                } else {
                    this.h.setOnClickListener(onClickListener);
                }
            }
        }
        TextView textView = this.i;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    l.c("mAdLogo", "mAdLogo,,,,,,,onClick,,,,,");
                    try {
                        TTWebsiteActivity.a(e.this.b, e.this.c, e.this.t);
                    } catch (Throwable th) {
                        l.e("TTAD.RFullVideoLayout", th.getMessage());
                    }
                }
            });
        }
        ImageView imageView = this.j;
        if (imageView != null) {
            imageView.setClickable(true);
            com.bytedance.sdk.openadsdk.k.c.a().a((int) ad.a(com.bytedance.sdk.openadsdk.core.o.a(), 14.0f, true), this.j, this.r.a);
        }
    }

    public void d() {
        ad.a((View) this.f, 8);
        ad.a(this.g, 8);
        ad.a(this.h, 8);
        c(8);
        ad.a((View) this.d, 8);
        ad.a((View) this.e, 8);
        ad.a((View) this.i, 8);
        ad.a((View) this.k, 8);
        ad.a((View) this.j, 8);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        int E = this.c.E();
        this.a = E;
        if (E == -200) {
            this.a = com.bytedance.sdk.openadsdk.core.o.d().n(String.valueOf(this.c.aZ()));
        }
        if (this.a == -1 && !a() && !(this.r.Y instanceof com.bytedance.sdk.openadsdk.component.reward.b.c)) {
            c(0);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z) {
        RelativeLayout relativeLayout;
        if (!(this.u == 1 || (relativeLayout = this.e) == null || !z)) {
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                int a2 = a("status_bar_height");
                int a3 = a("navigation_bar_height");
                if (a2 > 0) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (a2 > marginLayoutParams.topMargin) {
                        marginLayoutParams.topMargin = a2;
                        this.r.R.a(a2);
                    }
                }
                if (a3 > 0) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (a3 > marginLayoutParams2.rightMargin) {
                        marginLayoutParams2.rightMargin = a3;
                    }
                }
            }
        }
        if (!(this.r.Y instanceof com.bytedance.sdk.openadsdk.component.reward.b.c)) {
            c(0);
        }
    }

    private int a(String str) {
        Resources resources = this.b.getResources();
        if (resources != null) {
            return resources.getDimensionPixelSize(resources.getIdentifier(str, "dimen", "android"));
        }
        return 0;
    }

    public void c(int i2) {
        q qVar = this.c;
        if (qVar == null || !qVar.at() || !com.bytedance.sdk.openadsdk.core.model.l.a(this.c)) {
            ad.a((View) this.w, i2);
        } else {
            ad.a((View) this.w, 8);
        }
    }

    public FrameLayout f() {
        return this.f;
    }

    public void d(int i2) {
        ad.a((View) this.i, i2);
    }

    public void g() {
        if (this.j.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.j.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 11, 16);
            marginLayoutParams.setMarginStart(0);
            marginLayoutParams.setMarginEnd(11);
            this.j.setLayoutParams(marginLayoutParams);
        }
    }

    public void e(int i2) {
        int i3 = this.a;
        if (i3 != -1 && i2 == i3 && !this.n.get()) {
            c(0);
            this.n.set(true);
            h();
        }
    }

    /* access modifiers changed from: protected */
    public void h() {
        RFDownloadBarLayout rFDownloadBarLayout = this.w;
        if (rFDownloadBarLayout != null) {
            rFDownloadBarLayout.a();
        }
    }

    public void f(int i2) {
        RelativeLayout relativeLayout;
        ad.a((View) this.d, i2);
        ad.a((View) this.e, i2);
        if (!b.a(this.r.W) && (relativeLayout = this.e) != null) {
            relativeLayout.post(this.q);
        }
        if (i2 == 0 && !this.r.u.get() && t.b(this.r.a)) {
            com.bytedance.sdk.openadsdk.b.c.a(this.r.a, this.r.g, "show_close_button", (JSONObject) null, System.currentTimeMillis() - this.r.r);
        }
    }

    public boolean i() {
        ImageView imageView = this.d;
        if (imageView == null || this.e == null || imageView.getVisibility() != 0 || this.e.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void a(View.OnClickListener onClickListener) {
        ad.a((View) this.f, onClickListener, "TTBaseVideoActivity#mVideoNativeFrame");
    }

    private void a(c cVar) {
        ad.a((View) this.f, (View.OnTouchListener) cVar, "TTBaseVideoActivity#mVideoNativeFrame");
    }

    public View j() {
        return this.e;
    }

    public View k() {
        return this.w;
    }

    public void a(float f2) {
        ad.a((View) this.d, f2);
        ad.a((View) this.e, f2);
    }

    public void a(Animation animation) {
        RelativeLayout relativeLayout = this.k;
        if (relativeLayout != null) {
            relativeLayout.startAnimation(animation);
        }
    }

    public void l() {
        try {
            k kVar = this.l;
            if (kVar != null) {
                kVar.c();
            }
            RelativeLayout relativeLayout = this.k;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
        } catch (Throwable unused) {
            RelativeLayout relativeLayout2 = this.k;
            if (relativeLayout2 != null) {
                relativeLayout2.setAlpha(0.0f);
            }
        }
    }

    public void m() {
        try {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.r.V, s.j(this.r.V, "tt_fade_out"));
            if (loadAnimation != null) {
                loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        e.this.r.T.l();
                    }
                });
                this.r.T.a(loadAnimation);
                return;
            }
            this.r.T.l();
        } catch (Throwable unused) {
            this.r.T.l();
        }
    }

    public void n() {
        o oVar = this.o;
        if (oVar != null) {
            oVar.e();
        }
        RelativeLayout relativeLayout = this.e;
        if (relativeLayout != null) {
            relativeLayout.removeCallbacks(this.q);
        }
    }

    public void o() {
        o oVar = this.o;
        if (oVar != null) {
            oVar.f();
        }
    }

    public void p() {
        o oVar = this.o;
        if (oVar != null) {
            oVar.g();
        }
    }

    public void q() {
        o oVar = this.o;
        if (oVar != null) {
            oVar.h();
        }
    }

    public void r() {
        this.r.L.e().onClick(this.w);
    }
}
