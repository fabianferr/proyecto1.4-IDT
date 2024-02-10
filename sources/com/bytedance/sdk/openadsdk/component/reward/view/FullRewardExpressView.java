package com.bytedance.sdk.openadsdk.component.reward.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.b.c;
import com.bytedance.sdk.component.adexpress.b.d;
import com.bytedance.sdk.component.adexpress.b.n;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.component.reward.a.a;
import com.bytedance.sdk.openadsdk.core.model.r;
import com.bytedance.sdk.openadsdk.core.nativeexpress.FullRewardExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.p;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ad;

public class FullRewardExpressView extends NativeExpressView {
    public static float a = 100.0f;
    l b;
    FullRewardExpressBackupView c;

    public FullRewardExpressView(a aVar, AdSlot adSlot, String str) {
        super(aVar.V, aVar.a, adSlot, str, aVar.d);
    }

    /* access modifiers changed from: protected */
    public void g() {
        this.m = true;
        this.k = new FrameLayout(this.g);
        addView(this.k, new FrameLayout.LayoutParams(-1, -1));
        super.g();
        SSWebView webView = getWebView();
        if (webView != null) {
            webView.setBackgroundColor(0);
        }
        h();
    }

    private void h() {
        setBackupListener(new c() {
            public boolean a(ViewGroup viewGroup, int i) {
                try {
                    ((NativeExpressView) viewGroup).m();
                    FullRewardExpressView.this.c = new FullRewardExpressBackupView(viewGroup.getContext());
                    FullRewardExpressView.this.c.a(FullRewardExpressView.this.j, (NativeExpressView) viewGroup);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
    }

    public void a(d<? extends View> dVar, n nVar) {
        if (this.j == null || !this.j.bd()) {
            if (dVar instanceof p) {
                p pVar = (p) dVar;
                if (pVar.q() != null) {
                    pVar.q().a((l) this);
                }
            }
            if (nVar != null && nVar.c()) {
                b(nVar);
            }
            super.a(dVar, nVar);
            return;
        }
        super.a(dVar, nVar);
    }

    /* access modifiers changed from: protected */
    public boolean a(n nVar) {
        if (!(this.j instanceof r) || !((r) this.j).bw() || !nVar.c() || nVar.b() != 1) {
            return super.a(nVar);
        }
        return false;
    }

    public void setExpressVideoListenerProxy(l lVar) {
        this.b = lVar;
    }

    public void b(final n nVar) {
        if (nVar != null) {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    FullRewardExpressView.this.c(nVar);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void c(n nVar) {
        if (nVar != null) {
            double f = nVar.f();
            double g = nVar.g();
            double h = nVar.h();
            double i = nVar.i();
            int b2 = ad.b(this.g, (float) f);
            int b3 = ad.b(this.g, (float) g);
            int b4 = ad.b(this.g, (float) h);
            int b5 = ad.b(this.g, (float) i);
            com.bytedance.sdk.component.utils.l.b("ExpressView", "vW x vH =" + h + "x" + i);
            if (i != 0.0d && h != 0.0d) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.k.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new FrameLayout.LayoutParams(b4, b5);
                }
                layoutParams.width = b4;
                layoutParams.height = b5;
                layoutParams.topMargin = b3;
                layoutParams.leftMargin = b2;
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                this.k.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(boolean z) {
        com.bytedance.sdk.component.utils.l.b("TTAD.FRExpressView", "onMuteVideo,mute:" + z);
        l lVar = this.b;
        if (lVar != null) {
            lVar.a(z);
        }
        setSoundMute(z);
    }

    public void a() {
        com.bytedance.sdk.component.utils.l.b("TTAD.FRExpressView", "onSkipVideo");
        l lVar = this.b;
        if (lVar != null) {
            lVar.a();
        }
    }

    public void b() {
        l lVar = this.b;
        if (lVar != null) {
            lVar.b();
        }
    }

    public void a(int i) {
        com.bytedance.sdk.component.utils.l.b("TTAD.FRExpressView", "onChangeVideoState,stateType:" + i);
        l lVar = this.b;
        if (lVar != null) {
            lVar.a(i);
        }
    }

    public long c() {
        l lVar = this.b;
        if (lVar != null) {
            return lVar.c();
        }
        return 0;
    }

    public int d() {
        l lVar = this.b;
        if (lVar != null) {
            return lVar.d();
        }
        return 0;
    }

    public void e() {
        l lVar = this.b;
        if (lVar != null) {
            lVar.e();
        }
    }

    public void a(View view, int i, com.bytedance.sdk.component.adexpress.c cVar) {
        if (i == -1 || cVar == null || i != 3) {
            super.a(view, i, cVar);
        } else {
            e();
        }
    }

    public FrameLayout getVideoFrameLayout() {
        if (n()) {
            return this.c.getVideoContainer();
        }
        return this.k;
    }

    public View getBackupContainerBackgroundView() {
        if (n()) {
            return this.c.getBackupContainerBackgroundView();
        }
        return null;
    }

    public void b(int i) {
        l lVar = this.b;
        if (lVar != null) {
            lVar.b(i);
        }
    }
}
