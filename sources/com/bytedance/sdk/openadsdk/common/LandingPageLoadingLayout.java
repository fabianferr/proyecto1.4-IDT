package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.component.video.a.c.a;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.p;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.google.android.material.badge.BadgeDrawable;

public class LandingPageLoadingLayout extends PAGFrameLayout {
    View a;
    /* access modifiers changed from: private */
    public e b;
    /* access modifiers changed from: private */
    public int c;
    private long d = 10;
    private Runnable e;
    private Runnable f;

    public LandingPageLoadingLayout(Context context) {
        super(context);
        c();
    }

    private void c() {
        setBackgroundColor(-1);
        this.a = new PAGTextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ad.b(getContext(), 32.0f), ad.b(getContext(), 14.0f));
        this.a.setVisibility(8);
        this.a.setId(520093739);
        layoutParams.gravity = BadgeDrawable.BOTTOM_START;
        layoutParams.leftMargin = ad.b(getContext(), 16.0f);
        layoutParams.bottomMargin = ad.b(getContext(), 16.0f);
        this.a.setBackgroundResource(s.d(getContext(), "tt_ad_logo_new"));
        addView(this.a, layoutParams);
        setVisibility(8);
    }

    public void a(q qVar, String str) {
        a(qVar, str, false);
    }

    public void a(final q qVar, final String str, boolean z) {
        p pVar;
        n nVar;
        String[] strArr;
        String str2;
        int i;
        n nVar2 = null;
        if (qVar != null) {
            p i2 = qVar.i();
            if (i2 != null) {
                this.d = i2.a();
            }
            String aF = qVar.aF();
            String[] aG = qVar.aG();
            i = qVar.aE();
            if (qVar.N() != null && !TextUtils.isEmpty(qVar.N().a())) {
                nVar2 = qVar.N();
            }
            nVar = nVar2;
            pVar = i2;
            str2 = aF;
            strArr = aG;
        } else {
            str2 = null;
            strArr = null;
            nVar = null;
            pVar = null;
            i = 0;
        }
        if (i == 1) {
            this.b = new d(getContext(), str2, strArr, nVar, pVar);
        } else {
            this.b = new c(getContext(), str2, strArr, nVar, pVar);
        }
        View e2 = this.b.e();
        if (e2.getParent() instanceof ViewGroup) {
            ((ViewGroup) e2.getParent()).removeView(e2);
        }
        addView(e2);
        View view = this.a;
        if (view != null) {
            if (z) {
                view.setVisibility(0);
            }
            this.a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TTWebsiteActivity.a(LandingPageLoadingLayout.this.getContext(), qVar, str);
                }
            });
        }
    }

    public void a() {
        post(new Runnable() {
            public void run() {
                if (LandingPageLoadingLayout.this.b != null) {
                    LandingPageLoadingLayout.this.setVisibility(0);
                    LandingPageLoadingLayout.this.b.b();
                }
            }
        });
        if (this.e == null) {
            this.e = new Runnable() {
                public void run() {
                    LandingPageLoadingLayout.this.b();
                }
            };
        }
        postDelayed(this.e, this.d * 1000);
    }

    public void a(int i) {
        if (i == 100 || i - this.c >= 7) {
            this.c = i;
            if (a.b()) {
                b(this.c);
                return;
            }
            if (this.f == null) {
                this.f = new Runnable() {
                    public void run() {
                        LandingPageLoadingLayout landingPageLoadingLayout = LandingPageLoadingLayout.this;
                        landingPageLoadingLayout.b(landingPageLoadingLayout.c);
                    }
                };
            }
            post(this.f);
        }
    }

    /* access modifiers changed from: private */
    public void b(int i) {
        e eVar = this.b;
        if (eVar != null) {
            eVar.a(i);
        }
        if (i == 100) {
            b();
        }
    }

    public void b() {
        this.c = 0;
        e eVar = this.b;
        if (eVar != null) {
            removeView(eVar.e);
            this.b.d();
        }
        setVisibility(8);
        this.b = null;
        Runnable runnable = this.e;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f;
        if (runnable2 != null) {
            removeCallbacks(runnable2);
        }
        this.f = null;
        this.e = null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.e;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.e = null;
        }
    }
}
