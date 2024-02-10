package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.component.reward.a.a;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.f;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.com.bytedance.overseas.sdk.a.d;

/* compiled from: RewardFullExpressVideoLayout */
public class c {
    com.com.bytedance.overseas.sdk.a.c a;
    Handler b;
    boolean c = false;
    boolean d = false;
    boolean e = false;
    private final Activity f;
    private final q g;
    private final String h;
    private FullRewardExpressView i;
    private final a j;
    private boolean k;

    public c(a aVar) {
        this.j = aVar;
        this.f = aVar.V;
        this.g = aVar.a;
        this.h = aVar.g;
    }

    public void a(AdSlot adSlot) {
        if (!this.e) {
            this.e = true;
            this.i = new FullRewardExpressView(this.j, adSlot, this.h);
        }
    }

    public FullRewardExpressView a() {
        return this.i;
    }

    public FrameLayout b() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView == null) {
            return null;
        }
        FrameLayout videoFrameLayout = fullRewardExpressView.getVideoFrameLayout();
        if (this.i.n()) {
            l();
        }
        return videoFrameLayout;
    }

    public boolean c() {
        return this.c;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean d() {
        return this.d;
    }

    public void b(boolean z) {
        this.d = z;
    }

    public void a(g gVar, f fVar) {
        q qVar;
        if (this.i != null && (qVar = this.g) != null) {
            this.a = a(qVar);
            gVar.a((View) this.i);
            gVar.a(this.a);
            this.i.setClickListener(gVar);
            fVar.a((View) this.i);
            fVar.a(this.a);
            this.i.setClickCreativeListener(fVar);
        }
    }

    private com.com.bytedance.overseas.sdk.a.c a(q qVar) {
        if (qVar.M() == 4) {
            return d.a(this.f, qVar, this.h);
        }
        return null;
    }

    public void a(l lVar) {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.setExpressVideoListenerProxy(lVar);
        }
    }

    public void a(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.setExpressInteractionListener(pAGBannerAdWrapperListener);
        }
    }

    public Handler e() {
        if (this.b == null) {
            this.b = new Handler(Looper.getMainLooper());
        }
        return this.b;
    }

    public void f() {
        if (!this.k) {
            this.k = true;
            FullRewardExpressView fullRewardExpressView = this.i;
            if (fullRewardExpressView != null) {
                fullRewardExpressView.l();
            }
            Handler handler = this.b;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
        }
    }

    public void g() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.k();
        }
    }

    public boolean h() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView == null) {
            return false;
        }
        return fullRewardExpressView.n();
    }

    public int i() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getDynamicShowType();
        }
        return 0;
    }

    public void j() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.i();
        }
    }

    public void k() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.j();
            this.i.k();
        }
    }

    public void l() {
        if (q.c(this.g) && this.g.A() == 3 && this.g.B() == 0) {
            try {
                if (this.g.ak() == 1) {
                    int b2 = ad.b(o.a(), 90.0f);
                    FrameLayout frameLayout = (FrameLayout) this.i.getBackupContainerBackgroundView();
                    if (frameLayout != null) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                        layoutParams.bottomMargin = b2;
                        frameLayout.setLayoutParams(layoutParams);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
