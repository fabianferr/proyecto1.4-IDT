package com.bytedance.sdk.openadsdk.component.reward.b;

import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.component.reward.a.a;
import com.bytedance.sdk.openadsdk.component.reward.b.b;
import com.bytedance.sdk.openadsdk.component.reward.view.FullInteractionStyleView;
import com.bytedance.sdk.openadsdk.core.model.q;

/* compiled from: RewardFullTypeInteraction */
public class h extends b {
    /* access modifiers changed from: private */
    public FullInteractionStyleView o;

    public h(a aVar) {
        super(aVar);
    }

    public void a(FrameLayout frameLayout) {
        FullInteractionStyleView fullInteractionStyleView = new FullInteractionStyleView(this.a.V, this.k);
        this.o = fullInteractionStyleView;
        fullInteractionStyleView.setDownloadListener(this.l);
        this.o.a(this.b, this.a.k, this.a.j, this.c, this.d);
        frameLayout.addView(this.o.getInteractionStyleRootView());
    }

    public static boolean a(q qVar) {
        if (!qVar.aW() && qVar.al() != 100.0f) {
            return true;
        }
        return false;
    }

    public b.a d() {
        return new b.a() {
            public void a(boolean z) {
                if (h.this.o != null) {
                    h.this.o.setIsMute(z);
                }
            }
        };
    }

    public FrameLayout C() {
        FullInteractionStyleView fullInteractionStyleView = this.o;
        if (fullInteractionStyleView != null) {
            return fullInteractionStyleView.getVideoContainer();
        }
        return null;
    }

    public boolean e() {
        return D();
    }

    public boolean f() {
        return D();
    }

    public void g() {
        this.f.d(8);
        this.f.c(8);
        if (this.b.u() == 2) {
            this.h.a(false);
            this.h.c(false);
            this.h.d(false);
            this.f.f(8);
            return;
        }
        this.h.a(this.b.an());
        this.h.c(D());
        this.h.d(D());
        if (D()) {
            this.f.f(8);
            return;
        }
        this.h.f();
        this.f.f(0);
    }

    private boolean D() {
        return q.c(this.b);
    }
}
