package com.bytedance.sdk.openadsdk.component.reward.b;

import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.component.reward.a.j;
import com.bytedance.sdk.openadsdk.component.reward.a.l;
import com.bytedance.sdk.openadsdk.component.reward.a.m;
import com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.component.reward.view.e;
import com.bytedance.sdk.openadsdk.core.model.o;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.t;
import com.bytedance.sdk.openadsdk.core.video.c.b;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;

/* compiled from: BaseRewardFullAdType */
public class a {
    protected com.bytedance.sdk.openadsdk.component.reward.a.a a;
    protected q b;
    protected int c;
    protected int d;
    protected final l e;
    protected final e f;
    protected final m g;
    protected final j h;
    protected b i;
    protected x j;

    public a(com.bytedance.sdk.openadsdk.component.reward.a.a aVar) {
        this.a = aVar;
        this.b = aVar.a;
        this.c = aVar.l;
        this.d = aVar.m;
        this.e = aVar.G;
        this.f = aVar.T;
        this.g = aVar.Q;
        this.h = aVar.R;
    }

    public void a(b bVar, x xVar) {
        this.i = bVar;
        this.j = xVar;
    }

    public boolean a() {
        return this.a.a.at() || this.a.a.ad() == 15 || this.a.a.ad() == 5 || this.a.a.ad() == 50;
    }

    public void a(boolean z) {
        if (!this.a.u.get()) {
            q qVar = this.b;
            if (qVar == null || !qVar.bd()) {
                if (!z) {
                    this.h.c(false);
                    this.h.a(false);
                    this.h.d(false);
                    this.a.T.f(8);
                } else {
                    this.h.a(this.a.a.an());
                    if (t.k(this.a.a) || a()) {
                        this.h.c(true);
                    }
                    if (a() || ((this instanceof g) && this.a.V.p())) {
                        this.h.d(true);
                    } else {
                        this.h.f();
                        this.a.T.f(0);
                    }
                }
                if (!z) {
                    this.a.T.c(4);
                    this.a.T.d(8);
                } else if (this.a.f || (this.a.k == FullRewardExpressView.a && a())) {
                    this.a.T.c(0);
                    this.a.T.d(0);
                } else {
                    this.a.T.c(8);
                    this.a.T.d(8);
                }
            } else {
                this.h.c(false);
                this.h.a(true);
                this.a.T.c(8);
                this.a.T.d(8);
            }
        }
    }

    public boolean b() {
        if (o.b(this.a.a) && this.a.D.get()) {
            FrameLayout f2 = this.a.T.f();
            f2.setVisibility(4);
            f2.setVisibility(0);
            return false;
        } else if (this.a.u.get() || this.a.v.get() || t.k(this.a.a)) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (t.b(this.a.a) && DeviceUtils.f() == 0) {
            this.a.d = true;
        }
        this.a.R.b(this.a.d);
    }
}
