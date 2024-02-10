package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.apiImpl.b.b;
import com.bytedance.sdk.openadsdk.b.d.a.a;
import com.bytedance.sdk.openadsdk.b.d.b.o;
import com.bytedance.sdk.openadsdk.b.g;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.model.o;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.t;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.n.a.e;
import com.bytedance.sdk.openadsdk.utils.aa;
import java.util.Map;

public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    private static b l;
    private b k;
    private boolean m;

    public void c(int i) {
    }

    public boolean o() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        l = this.k;
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.b != null && !q.c(this.b.a)) {
            com.bykv.vk.openvk.component.video.api.c.b K = this.b.a.K();
            if (K == null) {
                com.bykv.vk.openvk.component.video.api.c.b bVar = new com.bykv.vk.openvk.component.video.api.c.b();
                bVar.a(10.0d);
                this.b.a.a(bVar);
            } else if (K.f() <= 0.0d) {
                K.a(10.0d);
            }
        }
    }

    private void a(final String str) {
        aa.c(new h("FullScreen_executeMultiProcessCallback") {
            public void run() {
                try {
                    TTFullScreenVideoActivity.this.a(1).executeFullVideoCallback(TTFullScreenVideoActivity.this.b.c, str);
                } catch (Throwable th) {
                    l.a("TTAD.FSVA", "fullscreen_interstitial_ad", "executeFullVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    /* access modifiers changed from: protected */
    public void a(Intent intent) {
        super.a(intent);
        this.b.q = intent.getBooleanExtra("is_verity_playable", false);
    }

    public void a(Bundle bundle) {
        if (!com.bytedance.sdk.openadsdk.multipro.b.c()) {
            this.k = s.a().d();
        }
        if (this.k == null && bundle != null) {
            this.k = l;
            l = null;
        }
    }

    /* access modifiers changed from: protected */
    public void n() {
        View j = this.b.T.j();
        if (j != null) {
            AnonymousClass2 r1 = new View.OnClickListener() {
                /* JADX WARNING: Removed duplicated region for block: B:26:0x00b7 A[RETURN] */
                /* JADX WARNING: Removed duplicated region for block: B:27:0x00b8  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onClick(android.view.View r4) {
                    /*
                        r3 = this;
                        com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.component.reward.a.m r4 = r4.Q
                        boolean r4 = r4.w()
                        if (r4 == 0) goto L_0x003a
                        com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        java.util.concurrent.atomic.AtomicBoolean r4 = r4.u
                        boolean r4 = r4.get()
                        if (r4 == 0) goto L_0x003a
                        com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.component.reward.a.m r4 = r4.Q
                        r4.G()
                        com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.component.reward.view.e r4 = r4.T
                        r0 = 8
                        r4.f(r0)
                        com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.component.utils.x r4 = r4.X
                        r0 = 600(0x258, float:8.41E-43)
                        r1 = 5000(0x1388, double:2.4703E-320)
                        r4.sendEmptyMessageDelayed(r0, r1)
                        return
                    L_0x003a:
                        com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.core.model.q r4 = r4.a
                        boolean r4 = r4.bh()
                        if (r4 == 0) goto L_0x00b4
                        com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.core.model.q r4 = r4.a
                        boolean r4 = r4.at()
                        if (r4 == 0) goto L_0x006f
                        com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.component.reward.a.e r4 = r4.S
                        if (r4 == 0) goto L_0x00b4
                        com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.core.model.q r4 = r4.a
                        r0 = 2
                        r4.E(r0)
                        com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.component.reward.a.e r4 = r4.S
                        boolean r4 = r4.e()
                        goto L_0x00b5
                    L_0x006f:
                        com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.core.model.q r4 = r4.a
                        int r4 = r4.be()
                        if (r4 != 0) goto L_0x00b4
                        com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.component.reward.a.m r4 = r4.Q
                        boolean r4 = r4.o()
                        if (r4 != 0) goto L_0x00b4
                        com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.core.model.q r4 = r4.a
                        r0 = 11
                        r4.E(r0)
                        com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.component.reward.a.m r4 = r4.Q
                        boolean r4 = r4.d()
                        if (r4 == 0) goto L_0x00a9
                        com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.core.model.q r4 = r4.a
                        r0 = 12
                        r4.E(r0)
                    L_0x00a9:
                        com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.this     // Catch:{ Exception -> 0x00b4 }
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b     // Catch:{ Exception -> 0x00b4 }
                        com.bytedance.sdk.openadsdk.component.reward.view.e r4 = r4.T     // Catch:{ Exception -> 0x00b4 }
                        r4.r()     // Catch:{ Exception -> 0x00b4 }
                        r4 = 1
                        goto L_0x00b5
                    L_0x00b4:
                        r4 = 0
                    L_0x00b5:
                        if (r4 == 0) goto L_0x00b8
                        return
                    L_0x00b8:
                        com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.component.reward.a.m r4 = r4.Q
                        r4.y()
                        com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.component.reward.a.h r4 = r4.L
                        r4.f()
                        com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.this
                        r4.finish()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.AnonymousClass2.onClick(android.view.View):void");
                }
            };
            j.setOnClickListener(r1);
            j.setTag(j.getId(), r1);
        }
        this.b.R.a((com.bytedance.sdk.openadsdk.component.reward.top.b) new com.bytedance.sdk.openadsdk.component.reward.top.b() {
            public void a(View view) {
                if (t.c(TTFullScreenVideoActivity.this.b.a) && (t.k(TTFullScreenVideoActivity.this.b.a) || TTFullScreenVideoActivity.this.b.u.get())) {
                    TTFullScreenVideoActivity.this.b.Q.g();
                } else if (t.k(TTFullScreenVideoActivity.this.b.a) || (o.a(TTFullScreenVideoActivity.this.b.a) && !TTFullScreenVideoActivity.this.b.A.get())) {
                    TTFullScreenVideoActivity.this.finish();
                } else if (!TTFullScreenVideoActivity.this.b.a.bi()) {
                    if (!TTFullScreenVideoActivity.this.b.b && TTFullScreenVideoActivity.this.b.a.bh() && !TTFullScreenVideoActivity.this.b.a.at()) {
                        TTFullScreenVideoActivity.this.b.a.E(13);
                        try {
                            TTFullScreenVideoActivity.this.b.T.r();
                            return;
                        } catch (Exception unused) {
                        }
                    }
                    o.a aVar = new o.a();
                    aVar.a(TTFullScreenVideoActivity.this.b.G.g());
                    aVar.c(TTFullScreenVideoActivity.this.b.G.s());
                    aVar.b(TTFullScreenVideoActivity.this.b.G.k());
                    aVar.c(3);
                    aVar.d(TTFullScreenVideoActivity.this.b.G.r());
                    a.a(TTFullScreenVideoActivity.this.b.G.c(), aVar, TTFullScreenVideoActivity.this.b.G.a());
                    r.c(TTFullScreenVideoActivity.this.b.o);
                    TTFullScreenVideoActivity.this.b.G.a("skip");
                    TTFullScreenVideoActivity.this.b.R.d(false);
                    if (TTFullScreenVideoActivity.this.b.b) {
                        TTFullScreenVideoActivity.this.a(true, 4);
                    } else {
                        TTFullScreenVideoActivity.this.finish();
                    }
                    if (!(TTFullScreenVideoActivity.this.b.a == null || TTFullScreenVideoActivity.this.b.a.au() == null || TTFullScreenVideoActivity.this.b.G == null)) {
                        TTFullScreenVideoActivity.this.b.a.au().a().f(TTFullScreenVideoActivity.this.b.G.g());
                        TTFullScreenVideoActivity.this.b.a.au().a().e(TTFullScreenVideoActivity.this.b.G.g());
                    }
                    e.a(TTFullScreenVideoActivity.this.b.a, 5);
                } else if (TTFullScreenVideoActivity.this.b.T.k() != null) {
                    TTFullScreenVideoActivity.this.b.a.E(2);
                    TTFullScreenVideoActivity.this.b.T.r();
                }
            }

            public void b(View view) {
                TTFullScreenVideoActivity.this.b.d = !TTFullScreenVideoActivity.this.b.d;
                if (!(TTFullScreenVideoActivity.this.c == null || TTFullScreenVideoActivity.this.c.d() == null)) {
                    TTFullScreenVideoActivity.this.c.d().a(TTFullScreenVideoActivity.this.b.d);
                }
                TTFullScreenVideoActivity.this.b.G.b(TTFullScreenVideoActivity.this.b.d);
                if (!t.l(TTFullScreenVideoActivity.this.b.a) || TTFullScreenVideoActivity.this.b.u.get()) {
                    if (t.b(TTFullScreenVideoActivity.this.b.a)) {
                        TTFullScreenVideoActivity.this.b.O.a(TTFullScreenVideoActivity.this.b.d, true);
                    }
                    TTFullScreenVideoActivity.this.b.Q.d(TTFullScreenVideoActivity.this.b.d);
                    if (TTFullScreenVideoActivity.this.b.a != null && TTFullScreenVideoActivity.this.b.a.au() != null && TTFullScreenVideoActivity.this.b.a.au().a() != null && TTFullScreenVideoActivity.this.b.G != null) {
                        if (TTFullScreenVideoActivity.this.b.d) {
                            TTFullScreenVideoActivity.this.b.a.au().a().h(TTFullScreenVideoActivity.this.b.G.g());
                        } else {
                            TTFullScreenVideoActivity.this.b.a.au().a().i(TTFullScreenVideoActivity.this.b.G.g());
                        }
                    }
                }
            }

            public void c(View view) {
                TTFullScreenVideoActivity.this.b.N.a(TTFullScreenVideoActivity.this.c);
            }
        });
    }

    public boolean a(long j, boolean z) {
        g gVar = new g();
        gVar.a(System.currentTimeMillis(), 1.0f);
        if (this.c == null || !(this.c instanceof com.bytedance.sdk.openadsdk.component.reward.b.h)) {
            this.b.G.a(this.b.T.f(), gVar);
        } else {
            this.b.G.a(((com.bytedance.sdk.openadsdk.component.reward.b.h) this.c).C(), gVar);
        }
        AnonymousClass4 r0 = new c.a() {
            boolean a;

            public void a(long j, int i) {
                if (!this.a) {
                    this.a = true;
                    TTFullScreenVideoActivity.this.d.removeMessages(300);
                    TTFullScreenVideoActivity.this.m();
                    TTFullScreenVideoActivity.this.b.D.set(true);
                    if (TTFullScreenVideoActivity.this.b.a.bg()) {
                        TTFullScreenVideoActivity.this.b.a.E(1);
                        TTFullScreenVideoActivity.this.b.T.r();
                    }
                    if (TTFullScreenVideoActivity.this.b.a.o() == 21 && !TTFullScreenVideoActivity.this.b.a.c()) {
                        TTFullScreenVideoActivity.this.b.a.b(true);
                        TTFullScreenVideoActivity.this.b.T.r();
                    }
                    if (TTFullScreenVideoActivity.this.b.b) {
                        TTFullScreenVideoActivity.this.a(false, 5);
                    } else {
                        TTFullScreenVideoActivity.this.finish();
                    }
                }
            }

            public void b(long j, int i) {
                TTFullScreenVideoActivity.this.d.removeMessages(300);
                if (TTFullScreenVideoActivity.this.b.G.b()) {
                    TTFullScreenVideoActivity.this.l();
                    return;
                }
                TTFullScreenVideoActivity.this.b.G.m();
                l.d("TTAD.FSVA", "fullscreen_interstitial_ad", "onError、、、、、、、、");
                if (TTFullScreenVideoActivity.this.b.b) {
                    TTFullScreenVideoActivity.this.a(false, true, 3);
                    TTFullScreenVideoActivity.this.b.G.a(TTFullScreenVideoActivity.this.b.G.z() ^ true ? 1 : 0, 2);
                    return;
                }
                TTFullScreenVideoActivity.this.finish();
            }

            public void a() {
                TTFullScreenVideoActivity.this.d.removeMessages(300);
                TTFullScreenVideoActivity.this.m();
                l.a("TTAD.FSVA", "fullscreen_interstitial_ad", "onTimeOut、、、、、、、、");
                if (TTFullScreenVideoActivity.this.b.b) {
                    TTFullScreenVideoActivity.this.a(false, true, 6);
                } else {
                    TTFullScreenVideoActivity.this.finish();
                }
                TTFullScreenVideoActivity.this.b.G.a(TTFullScreenVideoActivity.this.b.G.z() ^ true ? 1 : 0, TTFullScreenVideoActivity.this.b.G.z() ^ true ? 1 : 0);
                TTFullScreenVideoActivity.this.b.G.m();
            }

            public void a(long j, long j2) {
                if (!TTFullScreenVideoActivity.this.b.e && TTFullScreenVideoActivity.this.b.G.b()) {
                    TTFullScreenVideoActivity.this.b.G.o();
                }
                if (!TTFullScreenVideoActivity.this.b.u.get()) {
                    TTFullScreenVideoActivity.this.d.removeMessages(300);
                    if (j != TTFullScreenVideoActivity.this.b.G.h()) {
                        TTFullScreenVideoActivity.this.m();
                    }
                    TTFullScreenVideoActivity.this.b.G.a(j);
                    TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                    double A = tTFullScreenVideoActivity.b.G.A();
                    long j3 = j / 1000;
                    double d = (double) j3;
                    Double.isNaN(d);
                    tTFullScreenVideoActivity.f = (int) (A - d);
                    int i = (int) j3;
                    if ((TTFullScreenVideoActivity.this.b.E.get() || TTFullScreenVideoActivity.this.b.v.get()) && TTFullScreenVideoActivity.this.b.G.b()) {
                        TTFullScreenVideoActivity.this.b.G.o();
                    }
                    TTFullScreenVideoActivity.this.b(i);
                    if (TTFullScreenVideoActivity.this.f >= 0) {
                        TTFullScreenVideoActivity.this.b.R.a(String.valueOf(TTFullScreenVideoActivity.this.f), (CharSequence) null);
                    }
                }
            }
        };
        this.b.G.a((c.a) r0);
        if (this.b.T.o != null) {
            this.b.T.o.a((c.a) r0);
        }
        return this.b.G.a(j, z, (Map<String, Object>) null, this.c);
    }

    /* access modifiers changed from: protected */
    public void b(int i) {
        int q = com.bytedance.sdk.openadsdk.core.o.d().q(String.valueOf(this.b.o));
        if (q < 0) {
            q = 5;
        }
        if (com.bytedance.sdk.openadsdk.core.o.d().f(String.valueOf(this.b.o)) && (q.c(this.b.a) || this.b.b)) {
            if (!this.b.p) {
                this.b.a(true);
            }
            if (i <= q) {
                d(q - i);
                this.b.R.e(false);
                return;
            }
            a();
        } else if (i >= q) {
            if (!this.b.p) {
                this.b.a(true);
            }
            a();
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        if (q.c(this.b.a) || this.b.b) {
            this.b.R.a((String) null, TTAdDislikeToast.getSkipText());
        } else {
            this.b.R.a((String) null, "X");
        }
        this.b.R.e(true);
    }

    private void d(int i) {
        this.b.R.a((String) null, new SpannableStringBuilder(String.format(com.bytedance.sdk.component.utils.s.a(com.bytedance.sdk.openadsdk.core.o.a(), "tt_skip_ad_time_text"), new Object[]{Integer.valueOf(i)})));
    }

    public void onRewardBarClick(View view) {
        if (this.b.a.al() != 100.0f) {
            this.m = true;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            a("onAdVideoBarClick");
            return;
        }
        b bVar = this.k;
        if (bVar != null) {
            bVar.b();
        }
    }

    /* access modifiers changed from: protected */
    public void h() {
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            a("onAdShow");
        } else {
            b bVar = this.k;
            if (bVar != null) {
                bVar.a();
            }
        }
        if (p()) {
            this.b.J.j();
        }
    }

    public void r() {
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            a("onAdVideoBarClick");
        } else {
            b bVar = this.k;
            if (bVar != null) {
                bVar.b();
            }
        }
        this.b.a.bl();
        this.b.a.a(true);
        if (q.c(this.b.a)) {
            com.bytedance.sdk.openadsdk.b.c.b(this.b.a, this.b.g, this.b.a.bm());
        }
    }

    public void finish() {
        if (this.b != null) {
            this.b.I.b(this.b.q);
        }
        try {
            s();
        } catch (Exception unused) {
        }
        super.finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        s();
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            a("recycleRes");
        }
        this.k = null;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        l = null;
    }

    private void s() {
        if (!this.g) {
            this.g = true;
            if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                a("onAdClose");
                return;
            }
            b bVar = this.k;
            if (bVar != null) {
                bVar.c();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (this.b == null || !b(this.b.a) || a(this.b.a)) {
            return;
        }
        if (this.m) {
            this.m = false;
            finish();
        } else if (this.b.Q.E()) {
            finish();
        }
    }

    private boolean a(q qVar) {
        return qVar == null || qVar.al() == 100.0f;
    }

    private boolean b(q qVar) {
        if (qVar == null) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.core.o.d().r(String.valueOf(this.b.o));
    }
}
