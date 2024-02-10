package com.bytedance.sdk.openadsdk.component.reward;

import android.os.CountDownTimer;
import com.bykv.vk.openvk.component.video.api.d.b;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.openadsdk.b.d.b.o;
import com.bytedance.sdk.openadsdk.b.g;
import com.bytedance.sdk.openadsdk.core.model.q;
import java.util.Map;

/* compiled from: FakeVideoController */
public class c implements com.bykv.vk.openvk.component.video.api.d.c {
    private final a a;
    private boolean b = true;
    private long c = 0;
    private boolean d = false;
    private boolean e;
    private final q f;
    private final com.bykv.vk.openvk.component.video.api.b.a g;

    public void a(c.b bVar) {
    }

    public void a(c.d dVar) {
    }

    public void a(Map<String, Object> map) {
    }

    public void b(com.bykv.vk.openvk.component.video.api.c.c cVar) {
    }

    public void c(long j) {
    }

    public void d(boolean z) {
    }

    public void e(boolean z) {
    }

    public long f() {
        return 0;
    }

    public int g() {
        return 0;
    }

    public boolean k() {
        return false;
    }

    public b m() {
        return null;
    }

    public boolean p() {
        return false;
    }

    public boolean q() {
        return false;
    }

    public c(q qVar, g gVar) {
        AnonymousClass1 r2 = new com.bykv.vk.openvk.component.video.api.b.a() {
        };
        this.g = r2;
        this.f = qVar;
        com.bykv.vk.openvk.component.video.api.c.b K = qVar.K();
        long j = 10;
        long f2 = K != null ? (long) K.f() : 10;
        if (f2 <= 0) {
            K.a((double) 10);
        } else {
            j = f2;
        }
        this.a = new a(j * 1000, r2, gVar);
    }

    public void a() {
        this.a.j();
        o.a aVar = new o.a();
        aVar.a(e());
        aVar.c(h());
        aVar.b(f());
        com.bytedance.sdk.openadsdk.b.d.a.a.a(this.g, aVar);
    }

    public void b() {
        this.a.i();
        o.a aVar = new o.a();
        aVar.a(e());
        aVar.c(h());
        aVar.b(f());
        com.bytedance.sdk.openadsdk.b.d.a.a.b(this.g, aVar);
    }

    public void c() {
        this.a.k();
    }

    public void a(boolean z, int i) {
        c();
    }

    public void d() {
        c();
    }

    public boolean a(com.bykv.vk.openvk.component.video.api.c.c cVar) {
        this.d = cVar.h();
        if (cVar.g() > 0) {
            this.a.a(cVar.g());
        }
        com.bytedance.sdk.openadsdk.b.d.a.a.a(this.f, this.g, cVar);
        this.a.i();
        return true;
    }

    public long e() {
        return this.a.o();
    }

    public void a(long j) {
        this.a.a(j);
    }

    public void a(boolean z) {
        this.b = z;
    }

    public long h() {
        return this.a.n();
    }

    public long i() {
        return e();
    }

    public int j() {
        return com.bykv.vk.openvk.component.video.a.e.a.a(this.a.f, this.a.a);
    }

    public void b(long j) {
        this.c = j;
    }

    public com.bykv.vk.openvk.component.video.api.a l() {
        return this.a;
    }

    public boolean n() {
        return this.d;
    }

    public void b(boolean z) {
        this.d = z;
    }

    public boolean o() {
        return this.e;
    }

    public void c(boolean z) {
        this.e = z;
    }

    public void a(c.a aVar) {
        this.a.a(aVar);
    }

    public com.bykv.vk.openvk.component.video.api.b.a r() {
        return this.g;
    }

    /* compiled from: FakeVideoController */
    private static class a implements com.bykv.vk.openvk.component.video.api.a {
        /* access modifiers changed from: private */
        public final long a;
        /* access modifiers changed from: private */
        public long b;
        /* access modifiers changed from: private */
        public int c = 0;
        private CountDownTimer d;
        /* access modifiers changed from: private */
        public c.a e;
        /* access modifiers changed from: private */
        public long f;
        /* access modifiers changed from: private */
        public final com.bykv.vk.openvk.component.video.api.b.a g;
        /* access modifiers changed from: private */
        public final g h;

        public boolean a() {
            return false;
        }

        public boolean b() {
            return false;
        }

        public boolean c() {
            return false;
        }

        public int d() {
            return 0;
        }

        public int e() {
            return 0;
        }

        public long l() {
            return 0;
        }

        public int m() {
            return 0;
        }

        public a(long j, com.bykv.vk.openvk.component.video.api.b.a aVar, g gVar) {
            this.a = j;
            this.g = aVar;
            this.h = gVar;
        }

        public void i() {
            if (this.c != 1) {
                this.c = 1;
                final long n = n();
                final long j = n - this.b;
                AnonymousClass1 r2 = new CountDownTimer(j, 200) {
                    public void onTick(long j) {
                        long c2 = (j - j) + a.this.b;
                        long unused = a.this.f = c2;
                        if (a.this.e != null) {
                            a.this.e.a(c2, n);
                        }
                    }

                    public void onFinish() {
                        int unused = a.this.c = 4;
                        if (a.this.e != null) {
                            a.this.e.a(a.this.o(), 100);
                        }
                        o.a aVar = new o.a();
                        aVar.a(n);
                        aVar.c(n);
                        aVar.b(a.this.l());
                        aVar.d(a.this.m());
                        com.bytedance.sdk.openadsdk.b.d.a.a.b(a.this.g, aVar, a.this.h);
                    }
                };
                this.d = r2;
                r2.start();
            }
        }

        public void j() {
            this.c = 2;
            this.b = this.f;
            CountDownTimer countDownTimer = this.d;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.d = null;
            }
        }

        public void k() {
            this.c = 0;
            CountDownTimer countDownTimer = this.d;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.d = null;
            }
            if (this.e != null) {
                this.e = null;
            }
        }

        public boolean f() {
            return this.c == 1;
        }

        public boolean g() {
            return this.c == 2;
        }

        public boolean h() {
            return this.c == 0;
        }

        public long n() {
            return this.a;
        }

        public long o() {
            return this.f;
        }

        public void a(long j) {
            this.b = j;
        }

        public void a(c.a aVar) {
            this.e = aVar;
        }
    }
}
