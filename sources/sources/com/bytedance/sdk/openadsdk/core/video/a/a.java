package com.bytedance.sdk.openadsdk.core.video.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.component.video.api.d.b;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderTextureView;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.b.d.b.o;
import com.bytedance.sdk.openadsdk.b.g;
import com.bytedance.sdk.openadsdk.core.g.f;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.video.c.d;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.e;
import com.bytedance.sdk.openadsdk.core.widget.e;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: BaseController */
public abstract class a implements c, x.a, com.bytedance.sdk.openadsdk.core.video.nativevideo.a {
    /* access modifiers changed from: protected */
    public f A;
    /* access modifiers changed from: protected */
    public long B;
    protected Runnable C = new Runnable() {
        public void run() {
            l.b(a.this.a, "resumeVideo: run ", Boolean.valueOf(a.this.l));
            a.this.u();
        }
    };
    private long D;
    private long E = 0;
    private boolean F = true;
    private int G = 1;
    /* access modifiers changed from: protected */
    public String a = "TTAD.VideoController";
    /* access modifiers changed from: protected */
    public final x b = new x(Looper.getMainLooper(), this);
    protected SurfaceHolder c;
    protected SurfaceTexture d;
    /* access modifiers changed from: protected */
    public d e;
    /* access modifiers changed from: protected */
    public e f;
    /* access modifiers changed from: protected */
    public final q g;
    /* access modifiers changed from: protected */
    public long h = 0;
    protected long i = 0;
    protected final Context j;
    protected final List<Runnable> k = new ArrayList();
    protected boolean l = false;
    protected boolean m = false;
    /* access modifiers changed from: protected */
    public boolean n = true;
    /* access modifiers changed from: protected */
    public boolean o;
    protected boolean p = false;
    protected boolean q = false;
    protected boolean r = false;
    /* access modifiers changed from: protected */
    public AtomicBoolean s = new AtomicBoolean(false);
    protected boolean t;
    protected boolean u = true;
    /* access modifiers changed from: protected */
    public b v;
    /* access modifiers changed from: protected */
    public boolean w;
    protected final ViewGroup x;
    protected WeakReference<c.b> y;
    /* access modifiers changed from: protected */
    public c.a z;

    public void a(Message message) {
    }

    public void a(b bVar, SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    public void a(b bVar, View view, boolean z2) {
    }

    public void a(c.d dVar) {
    }

    public final void a(Map<String, Object> map) {
    }

    public final void c(int i2) {
    }

    public void f(b bVar, View view) {
    }

    public a(Context context, q qVar, ViewGroup viewGroup) {
        this.g = qVar;
        this.j = context;
        this.x = viewGroup;
        this.a += hashCode();
    }

    /* access modifiers changed from: protected */
    public void s() {
        if (this.e != null) {
            if (r()) {
                SurfaceTexture surfaceTexture = this.d;
                if (surfaceTexture != null && surfaceTexture != this.e.s()) {
                    this.e.a(this.d);
                    return;
                }
                return;
            }
            SurfaceHolder surfaceHolder = this.c;
            if (surfaceHolder != null && surfaceHolder != this.e.r()) {
                this.e.a(this.c);
            }
        }
    }

    private boolean r() {
        e eVar = this.f;
        if (eVar != null) {
            return eVar.m() instanceof SSRenderTextureView;
        }
        return false;
    }

    public boolean q() {
        q qVar = this.g;
        if (qVar != null && qVar.aK() == 1 && Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if ((!t.e() || Build.VERSION.SDK_INT < 30) && !v.a(this.g) && !h.v() && !"Pixel 4".equals(Build.MODEL)) {
            return h.b().o();
        }
        return true;
    }

    public long e() {
        return this.h;
    }

    public void a(long j2) {
        this.h = j2;
        this.i = Math.max(this.i, j2);
    }

    /* access modifiers changed from: protected */
    public void a(Runnable runnable) {
        if (!this.f.v() || !this.l) {
            b(runnable);
        } else {
            runnable.run();
        }
    }

    /* access modifiers changed from: protected */
    public void b(Runnable runnable) {
        this.k.add(runnable);
    }

    /* access modifiers changed from: protected */
    public void t() {
        l.c(this.a, "execPendingActions: before ");
        if (!this.k.isEmpty()) {
            l.c(this.a, "execPendingActions:  exec");
            Iterator it = new ArrayList(this.k).iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.k.clear();
        }
    }

    public void a(b bVar, SurfaceHolder surfaceHolder) {
        this.l = true;
        this.c = surfaceHolder;
        d dVar = this.e;
        if (dVar != null) {
            dVar.a(surfaceHolder);
            l.c(this.a, "surfaceCreated: ");
            t();
        }
    }

    public void b(b bVar, SurfaceHolder surfaceHolder) {
        this.l = false;
        this.c = null;
        d dVar = this.e;
        if (dVar != null) {
            dVar.a(false);
        }
    }

    public void a(b bVar, SurfaceTexture surfaceTexture) {
        this.l = true;
        this.d = surfaceTexture;
        d dVar = this.e;
        if (dVar != null) {
            dVar.a(surfaceTexture);
            this.e.a(this.l);
        }
        l.c(this.a, "surfaceTextureCreated: ");
        t();
    }

    public void b(b bVar, SurfaceTexture surfaceTexture) {
        this.l = false;
        l.c(this.a, "surfaceTextureDestroyed: ");
        d dVar = this.e;
        if (dVar != null) {
            dVar.a(false);
        }
        this.d = null;
        t();
    }

    /* access modifiers changed from: protected */
    public void u() {
        this.b.postAtFrontOfQueue(new Runnable() {
            public void run() {
                if (a.this.e != null) {
                    l.b(a.this.a, "resumeVideo: execResumePlay", Boolean.valueOf(a.this.l));
                    a.this.e.j();
                }
            }
        });
    }

    public com.bykv.vk.openvk.component.video.api.a l() {
        return this.e;
    }

    /* renamed from: v */
    public final e m() {
        return this.f;
    }

    public boolean w() {
        return this.n;
    }

    public void a(boolean z2) {
        this.n = z2;
        e eVar = this.f;
        if (eVar != null) {
            eVar.d(z2);
        }
    }

    public void b(long j2) {
        this.E = j2;
    }

    public boolean k() {
        return this.p;
    }

    public void c(long j2) {
        this.B = j2;
    }

    public final long f() {
        d dVar = this.e;
        if (dVar == null) {
            return 0;
        }
        return dVar.n();
    }

    public final int g() {
        d dVar = this.e;
        if (dVar == null) {
            return 0;
        }
        return dVar.o();
    }

    public boolean n() {
        return this.o;
    }

    public final void b(final boolean z2) {
        this.o = z2;
        d dVar = this.e;
        if (dVar != null) {
            dVar.b(z2);
        }
        if (this.A == null) {
            return;
        }
        if (com.bykv.vk.openvk.component.video.a.c.a.b()) {
            this.A.a(z2);
        } else {
            this.b.post(new Runnable() {
                public void run() {
                    a.this.A.a(z2);
                }
            });
        }
    }

    public final long h() {
        d dVar = this.e;
        if (dVar == null) {
            return 0;
        }
        return dVar.p();
    }

    public boolean o() {
        return this.m;
    }

    public final void c(boolean z2) {
        this.m = z2;
    }

    /* access modifiers changed from: protected */
    public void f(boolean z2) {
        this.r = z2;
    }

    public boolean x() {
        return this.F;
    }

    public final void d(boolean z2) {
        this.F = z2;
    }

    public void b(com.bykv.vk.openvk.component.video.api.c.c cVar) {
        b bVar = (b) cVar;
        this.v = bVar;
        this.o = bVar.h();
        cVar.d(String.valueOf(this.g.aZ()));
    }

    public final boolean p() {
        return this.w;
    }

    public final int j() {
        return com.bykv.vk.openvk.component.video.a.e.a.a(this.i, this.B);
    }

    public void e(boolean z2) {
        this.u = z2;
    }

    public final void b(b bVar, View view) {
        b(bVar, view, false, false);
    }

    public final void b(b bVar, View view, boolean z2, boolean z3) {
        f(!this.r);
        Context context = this.j;
        if (context != null) {
            if (!(context instanceof Activity)) {
                l.b(this.a, "context is not activity, not support this function.");
                return;
            }
            if (this.r) {
                a(z2 ? 8 : 0);
                e eVar = this.f;
                if (eVar != null) {
                    eVar.a(this.x);
                    this.f.c(false);
                }
            } else {
                a(1);
                e eVar2 = this.f;
                if (eVar2 != null) {
                    eVar2.b(this.x);
                    this.f.c(false);
                }
            }
            WeakReference<c.b> weakReference = this.y;
            c.b bVar2 = weakReference != null ? (c.b) weakReference.get() : null;
            if (bVar2 != null) {
                bVar2.a(this.r);
            }
        }
    }

    public final void a(c.b bVar) {
        this.y = new WeakReference<>(bVar);
    }

    public final void e(b bVar, View view) {
        a(bVar, view, false);
    }

    public final boolean y() {
        d dVar = this.e;
        return dVar == null || dVar.b();
    }

    public final boolean z() {
        d dVar = this.e;
        return dVar != null && dVar.f();
    }

    public final void a(int i2) {
        Context context = this.j;
        if (context != null) {
            boolean z2 = i2 == 0 || i2 == 8;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                try {
                    activity.setRequestedOrientation(i2);
                } catch (Throwable unused) {
                }
                if (!z2) {
                    activity.getWindow().setFlags(1024, 1024);
                } else {
                    activity.getWindow().clearFlags(1024);
                }
            }
        }
    }

    public final void c(b bVar, View view) {
        e eVar = this.f;
        if (eVar != null) {
            eVar.i();
        }
        a(true, 3);
    }

    public final void a(b bVar, View view, boolean z2, boolean z3) {
        if (this.n) {
            a();
        }
        if (z2 && !this.n && !y()) {
            this.f.b(!z(), false);
            this.f.a(z3, true, false);
        }
        d dVar = this.e;
        if (dVar == null || !dVar.f()) {
            this.f.f();
            return;
        }
        this.f.f();
        this.f.e();
    }

    public final void d(b bVar, View view) {
        if (this.r) {
            f(false);
            e eVar = this.f;
            if (eVar != null) {
                eVar.b(this.x);
            }
            a(1);
            return;
        }
        a(true, 3);
    }

    public final void a(b bVar, int i2, boolean z2) {
        Context context = this.j;
        if (context != null) {
            long l2 = (long) ((((float) (((long) i2) * this.B)) * 1.0f) / ((float) s.l(context, "tt_video_progress_max")));
            if (this.B > 0) {
                this.D = (long) ((int) l2);
            } else {
                this.D = 0;
            }
            e eVar = this.f;
            if (eVar != null) {
                eVar.a(this.D);
            }
        }
    }

    public final void a(b bVar, int i2) {
        if (this.e != null) {
            a(this.D, d(i2));
        }
    }

    public final void b(b bVar, int i2) {
        e eVar = this.f;
        if (eVar != null) {
            eVar.f();
        }
    }

    private void a(long j2, boolean z2) {
        if (this.e != null) {
            if (z2) {
                F();
            }
            this.e.a(j2);
        }
    }

    private boolean d(int i2) {
        return this.f.b(i2);
    }

    private void F() {
        e eVar = this.f;
        if (eVar != null) {
            eVar.d(0);
            this.f.a(false, false);
            this.f.c(false);
            this.f.e();
            this.f.g();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(g gVar) {
        if (this.s.compareAndSet(false, true)) {
            o.a aVar = new o.a();
            aVar.a(x());
            aVar.c(h());
            com.bytedance.sdk.openadsdk.b.d.a.a.a(com.bytedance.sdk.openadsdk.core.o.a(), (com.bykv.vk.openvk.component.video.api.b.a) this.f, aVar, gVar);
        }
    }

    /* access modifiers changed from: protected */
    public final void A() {
        o.a aVar = new o.a();
        aVar.a(e());
        aVar.c(h() / ((long) D()));
        aVar.b(f());
        com.bytedance.sdk.openadsdk.b.d.a.a.b(m(), aVar);
    }

    /* access modifiers changed from: protected */
    public final void B() {
        o.a aVar = new o.a();
        aVar.a(e());
        aVar.c(h() / ((long) D()));
        aVar.b(f());
        com.bytedance.sdk.openadsdk.b.d.a.a.a((com.bykv.vk.openvk.component.video.api.b.a) this.f, aVar);
    }

    /* access modifiers changed from: protected */
    public final void b(g gVar) {
        o.a aVar = new o.a();
        aVar.a(e());
        aVar.c(h() / ((long) D()));
        aVar.b(f());
        aVar.d(g());
        com.bytedance.sdk.openadsdk.b.d.a.a.b(this.f, aVar, gVar);
    }

    /* access modifiers changed from: protected */
    public final void a(com.bykv.vk.openvk.component.video.api.c.a aVar) {
        o.a aVar2 = new o.a();
        aVar2.b(f());
        aVar2.c(h() / ((long) D()));
        aVar2.a(e());
        aVar2.a(aVar);
        com.bytedance.sdk.openadsdk.b.d.a.a.c(m(), aVar2);
    }

    /* access modifiers changed from: protected */
    public final void C() {
        com.bytedance.sdk.openadsdk.b.d.a.a.a(this.g, (com.bykv.vk.openvk.component.video.api.b.a) this.f, (com.bykv.vk.openvk.component.video.api.c.c) this.v);
    }

    public int D() {
        return this.G;
    }

    public void b(int i2) {
        this.G = i2;
    }

    public final void a(c.a aVar) {
        this.z = aVar;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.a.a$4  reason: invalid class name */
    /* compiled from: BaseController */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.bytedance.sdk.openadsdk.core.widget.e$a[] r0 = com.bytedance.sdk.openadsdk.core.widget.e.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.bytedance.sdk.openadsdk.core.widget.e$a r1 = com.bytedance.sdk.openadsdk.core.widget.e.a.PAUSE_VIDEO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bytedance.sdk.openadsdk.core.widget.e$a r1 = com.bytedance.sdk.openadsdk.core.widget.e.a.RELEASE_VIDEO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.bytedance.sdk.openadsdk.core.widget.e$a r1 = com.bytedance.sdk.openadsdk.core.widget.e.a.START_VIDEO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.a.a.AnonymousClass4.<clinit>():void");
        }
    }

    public final void a(e.a aVar, String str) {
        int i2 = AnonymousClass4.a[aVar.ordinal()];
        if (i2 == 1) {
            a();
        } else if (i2 == 2) {
            c();
        } else if (i2 == 3) {
            b();
            this.p = false;
            this.q = true;
        }
    }

    public final long i() {
        return e() + f();
    }

    public final void a() {
        d dVar = this.e;
        if (dVar != null) {
            dVar.k();
        }
        if (!this.t && this.s.get()) {
            B();
        }
    }

    /* access modifiers changed from: protected */
    public final void E() {
        com.bytedance.sdk.openadsdk.b.a.d.a(com.bytedance.sdk.openadsdk.n.a.a(this.g.U(), true, this.g));
    }

    public final void d(long j2) {
        this.h = j2;
        this.i = Math.max(this.i, j2);
        com.bytedance.sdk.openadsdk.core.video.nativevideo.e eVar = this.f;
        if (eVar != null) {
            eVar.a();
        }
        d dVar = this.e;
        if (dVar != null) {
            dVar.a(true, this.h, this.o);
        }
    }
}
