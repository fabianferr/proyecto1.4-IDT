package com.bytedance.sdk.openadsdk.component.reward.b;

import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.component.reward.a.a;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.t;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;

/* compiled from: RewardFullTypePlayable */
public class i extends b {
    public void a(FrameLayout frameLayout) {
    }

    public boolean e() {
        return true;
    }

    public boolean f() {
        return true;
    }

    public void g() {
    }

    public i(a aVar) {
        super(aVar);
    }

    public static boolean a(q qVar) {
        return t.b(qVar) || t.k(qVar);
    }

    public void r() {
        if (t.b(this.a.a)) {
            if (DeviceUtils.f() == 0) {
                this.a.d = true;
            }
            if (this.a.d) {
                this.a.R.b(true);
                this.a.O.a(true);
            }
        }
    }

    public void s() {
        if (this.a.I.i() && t.k(this.a.a)) {
            this.a.I.a("return_foreground");
            if ((this.m == null || !this.m.isShowing()) && this.a.I.k() >= 0) {
                this.a.I.a(0);
            }
        }
    }

    public void t() {
        super.t();
        if (t.k(this.a.a)) {
            this.j.removeMessages(600);
            this.a.I.a("go_background");
        }
    }

    public void u() {
        super.u();
        if (t.k(this.a.a)) {
            this.j.removeMessages(600);
            this.a.I.a("go_background");
        }
    }
}
