package com.bytedance.sdk.openadsdk.component.reward.a;

import android.os.Message;
import android.view.View;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.component.reward.view.b;
import com.bytedance.sdk.openadsdk.core.model.o;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.t;
import com.bytedance.sdk.openadsdk.utils.ad;
import org.json.JSONObject;

/* compiled from: RewardFullEndCardManager */
public class e {
    private final a a;
    private final b b;

    public e(a aVar) {
        this.a = aVar;
        this.b = new b(aVar);
    }

    public void a() {
        this.b.a();
    }

    public void b() {
        this.b.c();
    }

    public void a(com.bytedance.sdk.openadsdk.core.b.e eVar) {
        this.b.a(eVar);
    }

    public void a(boolean z, boolean z2, boolean z3, com.bytedance.sdk.openadsdk.component.reward.b.b bVar, int i) {
        boolean z4 = z;
        boolean z5 = z2;
        boolean z6 = z3;
        com.bytedance.sdk.openadsdk.component.reward.b.b bVar2 = bVar;
        l.b("TTAD.RFEndM", "showEndCard() called with: isSkip = [" + z + "], force = [" + z2 + "], isFromLandingPage = [" + z6 + "], mAdType = [" + bVar2 + "]");
        if (!this.a.V.isFinishing() && bVar2 != null) {
            this.a.T.l();
            if (z5) {
                this.a.z.set(true);
            }
            if (!this.a.A.get() && !o.g(this.a.a) && (!o.b(this.a.a) || !this.a.z.get() || !this.a.B.get())) {
                if (o.b(this.a.a) && z6) {
                    return;
                }
                if ((o.b(this.a.a) || o.c(this.a.a)) && this.a.R != null) {
                    this.a.R.c(false);
                    bVar.p();
                    return;
                }
            }
            if (this.a.V.isDestroyed() || this.a.V.isFinishing()) {
                return;
            }
            if (this.a.a.bd()) {
                this.a.V.finish();
                return;
            }
            this.a.G.m();
            this.a.Q.z();
            this.a.v.set(false);
            this.a.w.set(false);
            this.a.N.a();
            this.a.R.a(!this.a.s && this.a.a.an());
            if (!this.a.u.getAndSet(true)) {
                if (t.b(this.a.a)) {
                    c.a(this.a.a, this.a.g, z, z2, z3, this.a.V.isFinishing(), i);
                }
                if (this.a.V.p() && t.b(this.a.a) && z4) {
                    this.a.R.d(true);
                }
                if (t.b(this.a.a)) {
                    this.a.R.c(true);
                }
                g();
                if (!t.k(this.a.a)) {
                    this.a.C.set(z);
                    bVar.o();
                    if (this.a.a.at()) {
                        this.a.R.d(false);
                    } else {
                        this.a.R.d(t.k(this.a.a));
                    }
                    this.a.R.c(t.b(this.a.a));
                    if (this.a.V.p() && t.b(this.a.a) && z4) {
                        this.a.R.d(true);
                    }
                    this.a.Q.A();
                    if (this.a.T.o != null) {
                        this.a.T.o.d();
                    }
                    this.a.T.c();
                    if (this.a.J != null) {
                        this.a.J.f();
                    }
                    if (q.a(this.a.a) || this.a.Q.H() || (!q.a(this.a.a, this.a.Q.p(), this.a.I.d(), this.a.Q.B()) && !t.b(this.a.a))) {
                        d();
                        return;
                    }
                    if (!q.b(this.a.a) && !t.b(this.a.a)) {
                        l.b("TTAD.RFEndM", "TimeTrackLog report Success from Android");
                        this.a.Q.a(true, 0, (String) null);
                    }
                    this.a.Q.a(0.0f);
                    this.a.T.a(0.0f);
                    this.a.Q.b(0);
                    this.a.Q.I();
                    if (this.a.s) {
                        ad.a((View) bVar2.n, 0);
                        this.a.T.f(8);
                    }
                    if (t.b(this.a.a)) {
                        int ar = this.a.a.ar();
                        if (t.k(this.a.a)) {
                            ar = (this.a.a.aq() + 1) * 1000;
                        }
                        l.b("TTAD.RFEndM", "showEndCard1: cT=" + ar);
                        if (ar == -1) {
                            if (t.c(this.a.a)) {
                                bVar.x();
                            } else {
                                bVar.p();
                            }
                        } else if (ar >= 0) {
                            if (t.c(this.a.a)) {
                                this.a.X.sendEmptyMessageDelayed(1, (long) ar);
                            } else {
                                this.a.X.sendEmptyMessageDelayed(600, (long) ar);
                            }
                        }
                    } else {
                        a(bVar2);
                    }
                    this.a.X.sendEmptyMessageDelayed(500, 100);
                    this.a.Q.a(this.a.d, true);
                    this.a.Q.c(true);
                    this.a.T.d(8);
                    this.a.T.g();
                    this.a.Q.b(true);
                    this.a.Q.j().a("prerender_page_show", (JSONObject) null);
                }
            }
        }
    }

    public boolean a(com.bytedance.sdk.openadsdk.component.reward.b.b bVar) {
        this.a.t = f();
        l.b("TTAD.RFEndM", "showEndCard: cT2=" + this.a.t);
        if (this.a.a.d()) {
            return false;
        }
        if (this.a.t == -1) {
            if (!t.c(this.a.a) || !this.a.Q.p()) {
                bVar.p();
                return true;
            }
            bVar.x();
            return true;
        } else if (this.a.t < 0) {
            return true;
        } else {
            Message obtain = Message.obtain();
            obtain.what = 700;
            obtain.arg1 = this.a.t;
            this.a.X.sendMessage(obtain);
            return true;
        }
    }

    private int f() {
        int as = this.a.a.as();
        if (as <= 5000 && as >= 0) {
            if (as < 1000) {
                as += 1000;
            }
            int a2 = com.bytedance.sdk.openadsdk.core.o.d().a(this.a.a.aZ());
            if (a2 <= 5000 && a2 >= 0) {
                if (a2 < 1000) {
                    a2 += 1000;
                }
                return Math.min(as, a2);
            }
        }
        return -1;
    }

    private void g() {
        if (t.l(this.a.a) && this.a.d) {
            this.a.R.b(true);
            this.a.O.a(true);
        }
    }

    public void c() {
        this.b.d();
    }

    public void d() {
        if (!q.b(this.a.a)) {
            l.b("TTAD.RFEndM", "TimeTrackLog report 408 from backup page");
            this.a.Q.a(false, 408, "end_card_timeout");
        }
        this.a.Q.C();
        this.a.Q.b(8);
        if (this.a.s) {
            ad.a((View) this.a.Y.n, 8);
            this.a.T.f(0);
        }
        this.a.T.d(8);
        if (!this.a.a.at()) {
            this.b.b();
        } else if (!this.b.a(this.a.G)) {
            this.a.V.finish();
        }
        this.a.T.g();
        a(this.a.Y);
        this.a.R.c(false);
        this.a.L.a(this.a.V.o());
    }

    public boolean e() {
        b bVar = this.b;
        if (bVar != null) {
            return bVar.e();
        }
        return false;
    }
}
