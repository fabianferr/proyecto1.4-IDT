package com.bytedance.sdk.openadsdk.component.reward.a;

import android.app.Activity;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.b.d.b.o;
import com.bytedance.sdk.openadsdk.b.g;
import com.bytedance.sdk.openadsdk.component.reward.b.b;
import com.bytedance.sdk.openadsdk.component.reward.e;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.t;
import com.bytedance.sdk.openadsdk.core.video.c.a;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.io.File;
import java.util.Map;

/* compiled from: RewardFullVideoPlayerManager */
public class l {
    protected boolean a = false;
    boolean b = false;
    boolean c;
    final boolean d;
    protected boolean e = false;
    c f;
    private final Activity g;
    /* access modifiers changed from: private */
    public final q h;
    private FrameLayout i;
    private final String j;
    private long k;
    private long l;
    private boolean m;
    private final a n;
    private boolean o;
    private g p;

    public g a() {
        return this.p;
    }

    public l(a aVar) {
        this.n = aVar;
        this.g = aVar.V;
        this.h = aVar.a;
        this.d = aVar.f;
        this.j = aVar.g;
    }

    public void a(FrameLayout frameLayout, g gVar) {
        if (!this.m) {
            this.m = true;
            this.i = frameLayout;
            this.p = gVar;
            if (q.c(this.h)) {
                this.f = new a(this.g, this.i, this.h, gVar);
                e(this.o);
                return;
            }
            this.f = new com.bytedance.sdk.openadsdk.component.reward.c(this.h, gVar);
        }
    }

    public boolean b() {
        c cVar = this.f;
        return (cVar == null || cVar.l() == null || !this.f.l().f()) ? false : true;
    }

    public com.bykv.vk.openvk.component.video.api.b.a c() {
        c cVar = this.f;
        if (cVar == null) {
            return null;
        }
        if (cVar instanceof com.bytedance.sdk.openadsdk.component.reward.c) {
            return ((com.bytedance.sdk.openadsdk.component.reward.c) cVar).r();
        }
        return cVar.m();
    }

    public boolean d() {
        c cVar = this.f;
        return (cVar == null || cVar.l() == null || !this.f.l().g()) ? false : true;
    }

    public boolean e() {
        c cVar = this.f;
        return cVar != null && cVar.p();
    }

    public void a(long j2) {
        this.l = j2;
    }

    public boolean f() {
        return this.a;
    }

    public long g() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.e();
        }
        return this.k;
    }

    public long h() {
        return this.l;
    }

    public long i() {
        return this.k;
    }

    public void b(long j2) {
        this.k = j2;
    }

    public void a(boolean z) {
        this.a = z;
    }

    public void j() {
        try {
            if (b()) {
                this.f.a();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.l.d("RewardFullVideoPlayerManager onPause throw Exception :" + th.getMessage());
        }
    }

    public void a(int i2, int i3) {
        if (this.f != null) {
            o.a aVar = new o.a();
            aVar.b(k());
            aVar.c(s());
            aVar.a(g());
            aVar.a(i2);
            aVar.b(i3);
            com.bytedance.sdk.openadsdk.b.d.a.a.d(this.f.m(), aVar);
        }
    }

    public long k() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.f();
        }
        return 0;
    }

    private void E() {
        c cVar = this.f;
        if (cVar != null && cVar.l() != null) {
            this.k = this.f.e();
            if (this.f.l().c() || !this.f.l().b()) {
                this.f.a();
                this.f.c();
                this.a = true;
            }
        }
    }

    public void l() {
        c cVar = this.f;
        if (cVar != null) {
            cVar.c();
            this.f = null;
        }
    }

    public void m() {
        c cVar = this.f;
        if (cVar != null) {
            cVar.d();
        }
    }

    public void n() {
        c cVar = this.f;
        if (cVar != null) {
            cVar.b();
        }
    }

    public void o() {
        c cVar = this.f;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void a(Map<String, Object> map) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.a(map);
        }
    }

    public void a(c.a aVar) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.a(aVar);
        }
    }

    public void b(boolean z) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.b(z);
        }
    }

    public long p() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.h();
        }
        return 0;
    }

    public int q() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.j();
        }
        return 0;
    }

    public int r() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.g();
        }
        return 0;
    }

    public long s() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.h() + this.f.f();
        }
        return 0;
    }

    public void a(String str) {
        c cVar = this.f;
        if (cVar != null) {
            String str2 = str;
            com.bytedance.sdk.openadsdk.b.c.a(this.h, this.j, str2, g(), q(), ac.a(this.h, cVar.f(), this.f.l()), this.p);
            com.bytedance.sdk.component.utils.l.b("TTAD.RFVideoPlayerMag", "event tag:" + this.j + ", TotalPlayDuration=" + s() + ",mBasevideoController.getPct()=" + q());
        }
        D();
    }

    public long t() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.h();
        }
        return 0;
    }

    public boolean u() {
        c cVar = this.f;
        if (cVar != null) {
            if (cVar.l() != null) {
                com.bykv.vk.openvk.component.video.api.a l2 = this.f.l();
                if (l2.g() || l2.h()) {
                    c cVar2 = this.f;
                    if (cVar2 instanceof a) {
                        ((a) cVar2).G();
                    }
                    return true;
                }
            } else if (f()) {
                a(false);
                c cVar3 = this.f;
                if (cVar3 instanceof a) {
                    ((a) cVar3).G();
                }
                return true;
            }
        }
        return false;
    }

    public boolean v() {
        return this.f != null;
    }

    public boolean w() {
        c cVar = this.f;
        return cVar != null && cVar.l() == null;
    }

    public boolean a(long j2, boolean z, Map<String, Object> map, b bVar) {
        boolean z2 = false;
        if (!v()) {
            return false;
        }
        if (com.bytedance.sdk.openadsdk.core.model.o.c(this.n.a)) {
            return true;
        }
        if (!z || !w()) {
            a(bVar);
        }
        try {
            z2 = a(j2, this.n.d);
        } catch (Exception e2) {
            Log.e("TTAD.RFVideoPlayerMag", "playVideo: ", e2);
        }
        if (z2 && !z) {
            this.n.L.a(map);
        }
        return z2;
    }

    public void a(b bVar) {
        if (!this.n.u.get() && this.n.e && !t.k(this.n.a)) {
            if ((q.c(this.n.a) || com.bytedance.sdk.openadsdk.core.o.d().l(String.valueOf(this.n.o)) != 1 || !this.n.J.d()) && !com.bytedance.sdk.openadsdk.core.model.o.c(this.n.a) && bVar.f()) {
                this.n.X.removeMessages(300);
                Message obtain = Message.obtain();
                obtain.what = 300;
                this.n.X.sendMessageDelayed(obtain, 5000);
            }
        }
    }

    private boolean a(long j2, boolean z) {
        com.bytedance.sdk.component.utils.l.b("TTAD.RFVideoPlayerMag", "playVideo start");
        if (this.f == null || this.h.K() == null) {
            com.bytedance.sdk.component.utils.l.b("TTAD.RFVideoPlayerMag", "playVideo controller is Empty");
            return false;
        }
        String a2 = CacheDirFactory.getICacheDir(this.h.aK()).a();
        File file = new File(a2, this.h.K().n());
        if (file.exists() && file.length() > 0) {
            this.b = true;
        }
        com.bytedance.sdk.openadsdk.core.video.a.b a3 = q.a(a2, this.h);
        a3.b(this.h.Y());
        a3.a(this.i.getWidth());
        a3.b(this.i.getHeight());
        a3.c(this.h.ac());
        a3.a(j2);
        a3.a(z);
        if (this.n.V.p() && !this.n.J.h() && q.c(this.h)) {
            a3.d = 1;
        }
        return this.f.a((com.bykv.vk.openvk.component.video.api.c.c) a3);
    }

    public void c(boolean z) {
        this.c = z;
    }

    public boolean x() {
        return this.c;
    }

    public void d(final boolean z) {
        l();
        com.bytedance.sdk.openadsdk.core.l.b().post(new Runnable() {
            public void run() {
                if (l.this.c) {
                    return;
                }
                if (z) {
                    com.bytedance.sdk.openadsdk.component.reward.l.a(com.bytedance.sdk.openadsdk.core.o.a()).a(l.this.h.D());
                } else {
                    e.a(com.bytedance.sdk.openadsdk.core.o.a()).a(l.this.h.D());
                }
            }
        });
    }

    public void y() {
        try {
            if (b()) {
                this.e = true;
                o();
            }
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.l.e("TTAD.RFVideoPlayerMag", "onPause throw Exception :" + e2.getMessage());
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.c.b bVar) {
        try {
            this.e = false;
            if (f()) {
                E();
                b(bVar);
            } else if (d()) {
                n();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.l.e("TTAD.RFVideoPlayerMag", "onContinue throw Exception :" + th.getMessage());
        }
    }

    public void a(boolean z, com.bytedance.sdk.openadsdk.core.video.c.b bVar, boolean z2) {
        if (z2 && !z && !this.e) {
            if (d()) {
                n();
                Log.i("TTAD.RFVideoPlayerMag", "resumeOrRestartVideo: continue play");
                return;
            }
            E();
            b(bVar);
            Log.i("TTAD.RFVideoPlayerMag", "resumeOrRestartVideo: recreate video player & exec play");
        }
    }

    public boolean z() {
        c cVar = this.f;
        if (cVar == null || cVar.l() == null) {
            return false;
        }
        return this.f.l().a();
    }

    /* access modifiers changed from: protected */
    public void b(com.bytedance.sdk.openadsdk.core.video.c.b bVar) {
        if (u() && bVar != null) {
            bVar.a(i(), true);
        }
    }

    public double A() {
        if (com.bytedance.sdk.openadsdk.core.model.o.c(this.h) && this.h.i() != null) {
            return (double) this.h.i().b();
        }
        com.bykv.vk.openvk.component.video.api.c.b K = this.h.K();
        if (K == null) {
            return 0.0d;
        }
        double f2 = K.f();
        double w = (double) K.w();
        Double.isNaN(w);
        return f2 * w;
    }

    public void B() {
        c cVar = this.f;
        if (cVar instanceof a) {
            ((a) cVar).F();
        }
    }

    public View C() {
        c cVar = this.f;
        if (cVar instanceof a) {
            return (View) ((a) cVar).H();
        }
        return null;
    }

    public void D() {
        c cVar = this.f;
        if (cVar instanceof a) {
            ((a) cVar).I();
        }
    }

    public void e(boolean z) {
        this.o = z;
        if (this.f instanceof a) {
            if (z) {
                ((a) this.f).b(this.h.K().w());
                return;
            }
            this.h.K().j(1);
            ((a) this.f).b(1);
        }
    }
}
