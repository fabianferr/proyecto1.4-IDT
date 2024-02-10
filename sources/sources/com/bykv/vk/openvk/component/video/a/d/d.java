package com.bykv.vk.openvk.component.video.a.d;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.a.d.c;
import com.bykv.vk.openvk.component.video.api.a;
import com.bykv.vk.openvk.component.video.api.b;
import com.bytedance.sdk.component.utils.x;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SSMediaPlayerWrapper */
public class d implements c.a, c.b, c.C0033c, c.d, c.e, c.f, c.g, com.bykv.vk.openvk.component.video.api.a, x.a {
    private static final SparseIntArray x = new SparseIntArray();
    private com.bykv.vk.openvk.component.video.api.c.c A;
    /* access modifiers changed from: private */
    public boolean B;
    /* access modifiers changed from: private */
    public volatile int C;
    private AtomicBoolean D;
    private Surface E;
    private final Runnable F;
    private final a G;
    /* access modifiers changed from: private */
    public volatile boolean H;
    private long I;
    private long J;
    private boolean K;
    private SurfaceTexture a;
    private SurfaceHolder b;
    /* access modifiers changed from: private */
    public int c;
    private int d;
    private boolean e;
    /* access modifiers changed from: private */
    public volatile c f;
    private final boolean g;
    /* access modifiers changed from: private */
    public boolean h;
    private boolean i;
    private boolean j;
    /* access modifiers changed from: private */
    public volatile int k;
    /* access modifiers changed from: private */
    public long l;
    /* access modifiers changed from: private */
    public x m;
    /* access modifiers changed from: private */
    public boolean n;
    /* access modifiers changed from: private */
    public long o;
    /* access modifiers changed from: private */
    public long p;
    /* access modifiers changed from: private */
    public long q;
    private long r;
    private long s;
    private boolean t;
    private ArrayList<Runnable> u;
    private int v;
    /* access modifiers changed from: private */
    public String w;
    private boolean y;
    /* access modifiers changed from: private */
    public final List<WeakReference<a.C0034a>> z;

    /* access modifiers changed from: private */
    public void a(long j2, long j3) {
        for (WeakReference next : this.z) {
            if (!(next == null || next.get() == null)) {
                ((a.C0034a) next.get()).a((com.bykv.vk.openvk.component.video.api.a) this, j2, j3);
            }
        }
    }

    public d() {
        this.c = 0;
        this.e = false;
        this.f = null;
        this.g = false;
        this.h = false;
        this.k = 201;
        this.l = -1;
        this.n = false;
        this.o = 0;
        this.p = Long.MIN_VALUE;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.v = 0;
        this.w = "0";
        this.z = new CopyOnWriteArrayList();
        this.A = null;
        this.B = false;
        this.C = 200;
        this.D = new AtomicBoolean(false);
        this.E = null;
        this.F = new Runnable() {
            public void run() {
                if (d.this.f != null) {
                    long q = d.this.q();
                    if (q > 0 && Build.VERSION.SDK_INT >= 23 && d.this.f() && d.this.p != Long.MIN_VALUE) {
                        try {
                            if (d.this.p == q) {
                                if (!d.this.n && d.this.q >= 400) {
                                    d.this.b(701, 800);
                                    boolean unused = d.this.n = true;
                                }
                                d dVar = d.this;
                                long unused2 = dVar.q = dVar.q + ((long) d.this.C);
                            } else {
                                if (d.this.n) {
                                    d dVar2 = d.this;
                                    long unused3 = dVar2.o = dVar2.o + d.this.q;
                                    d.this.b(702, 800);
                                    com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_VIDEO_MEDIA", "handleMsg:  bufferingDuration =", Long.valueOf(d.this.o), "  bufferCount =", Integer.valueOf(d.this.c));
                                }
                                long unused4 = d.this.q = 0;
                                boolean unused5 = d.this.n = false;
                            }
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_VIDEO_MEDIA", "error:" + th.getMessage());
                        }
                    }
                    if (d.this.p() > 0) {
                        if (d.this.p != q) {
                            if (com.bykv.vk.openvk.component.video.api.c.e()) {
                                com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_VIDEO_MEDIA", "run: lastCur = ", Long.valueOf(d.this.p), "  curPosition = ", Long.valueOf(q));
                            }
                            d dVar3 = d.this;
                            dVar3.a(q, dVar3.p());
                        }
                        long unused6 = d.this.p = q;
                    }
                    if (d.this.b()) {
                        d dVar4 = d.this;
                        dVar4.a(dVar4.p(), d.this.p());
                    } else if (d.this.m != null) {
                        d.this.m.postDelayed(this, (long) d.this.C);
                    }
                }
            }
        };
        this.G = new a();
        this.I = 0;
        this.J = 0;
        this.K = false;
        this.v = 0;
        this.m = com.bytedance.sdk.component.g.a.a.a().a((x.a) this, "csj_SSMediaPlayerWrapper");
        this.K = true;
        u();
    }

    private void t() {
        this.o = 0;
        this.c = 0;
        this.q = 0;
        this.n = false;
        this.p = Long.MIN_VALUE;
    }

    public void a(final boolean z2) {
        if (!h()) {
            this.y = z2;
            if (this.f != null) {
                this.f.a(z2);
                return;
            }
            x xVar = this.m;
            if (xVar != null) {
                xVar.post(new Runnable() {
                    public void run() {
                        if (d.this.f != null) {
                            d.this.f.a(z2);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void u() {
        StringBuilder sb = new StringBuilder("initMediaPlayer: ");
        sb.append(this.m != null);
        com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", sb.toString());
        x xVar = this.m;
        if (xVar != null) {
            xVar.post(new Runnable() {
                public void run() {
                    if (d.this.f == null) {
                        try {
                            c unused = d.this.f = new b();
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.f.c.c("CSJ_VIDEO_MEDIA", th.getMessage());
                        }
                        if (d.this.f != null) {
                            StringBuilder sb = new StringBuilder("initMediaPlayer mMediaPlayer is null :");
                            sb.append(d.this.f == null);
                            com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", sb.toString());
                            String unused2 = d.this.w = "0";
                            d.this.f.a((c.e) d.this);
                            d.this.f.a((c.b) d.this);
                            d.this.f.a((c.C0033c) d.this);
                            d.this.f.a((c.a) d.this);
                            d.this.f.a((c.f) d.this);
                            d.this.f.a((c.d) d.this);
                            d.this.f.a((c.g) d.this);
                            try {
                                d.this.f.c(false);
                            } catch (Throwable th2) {
                                com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "setLooping error: ", th2);
                            }
                            boolean unused3 = d.this.h = false;
                        }
                    }
                }
            });
        }
    }

    public void i() {
        if (!h()) {
            com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#restart:" + this.k);
            if (this.f != null) {
                this.D.set(true);
                if (this.k != 206) {
                    t();
                    this.H = false;
                    this.G.a(true);
                    b(0);
                    x xVar = this.m;
                    if (xVar != null) {
                        xVar.removeCallbacks(this.F);
                        this.m.postDelayed(this.F, (long) this.C);
                    }
                }
            }
        }
    }

    public void a(boolean z2, long j2, boolean z3) {
        StringBuilder sb = new StringBuilder("[video] MediaPlayerProxy#start firstSeekToPosition=");
        sb.append(j2);
        sb.append(",isFirst :");
        sb.append(z2);
        sb.append(",isPauseOtherMusicVolume=");
        sb.append(z3);
        sb.append(" ");
        sb.append(this.k);
        sb.append(" ");
        sb.append(this.f == null);
        com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", sb.toString());
        if (!h()) {
            u();
            this.B = z3;
            this.D.set(true);
            this.H = false;
            b(z3);
            if (z2) {
                com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "[video] first start , SSMediaPlayer  start method !");
                this.l = j2;
                v();
            } else {
                b(j2);
            }
            x xVar = this.m;
            if (xVar != null) {
                xVar.removeCallbacks(this.F);
                this.m.postDelayed(this.F, (long) this.C);
            }
        }
    }

    private void b(long j2) {
        this.G.a(j2);
        if (this.y) {
            b((Runnable) this.G);
        } else if (b(this.A)) {
            b((Runnable) this.G);
        } else {
            a((Runnable) this.G);
        }
    }

    private boolean b(com.bykv.vk.openvk.component.video.api.c.c cVar) {
        return cVar != null && cVar.d();
    }

    public void j() {
        if (!h() && this.m != null) {
            this.D.set(true);
            this.m.post(new Runnable() {
                public void run() {
                    if (d.this.g() && d.this.f != null) {
                        try {
                            d.this.f.e();
                            com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_VIDEO_MEDIA", "resume play exec start ");
                            for (WeakReference weakReference : d.this.z) {
                                if (!(weakReference == null || weakReference.get() == null)) {
                                    ((a.C0034a) weakReference.get()).e(d.this);
                                }
                            }
                            int unused = d.this.k = 206;
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_VIDEO_MEDIA", "play: catch exception ", th.getMessage());
                        }
                    }
                }
            });
        }
    }

    /* compiled from: SSMediaPlayerWrapper */
    class a implements Runnable {
        private long b;
        private boolean c;

        a() {
        }

        public void a(boolean z) {
            this.c = z;
        }

        public void a(long j) {
            this.b = j;
        }

        public void run() {
            if (d.this.f != null) {
                try {
                    if (!this.c) {
                        long unused = d.this.l = Math.max(this.b, d.this.f.i());
                    }
                    com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#start, OpStartTask:" + d.this.l);
                } catch (Throwable th) {
                    com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#start  error: getCurrentPosition :" + th);
                }
            }
            if (d.this.m != null) {
                d.this.m.sendEmptyMessageDelayed(100, 0);
            }
            com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#start not first play ! sendMsg --> OP_START , video start to play !");
        }
    }

    public void k() {
        x xVar;
        com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_VIDEO_MEDIA", "pause: from outer");
        if (!h() && (xVar = this.m) != null) {
            xVar.removeMessages(100);
            this.H = true;
            if (!this.K) {
                if (this.t || b(this.A)) {
                    x xVar2 = this.m;
                    if (xVar2 != null) {
                        xVar2.sendEmptyMessage(101);
                        return;
                    }
                    return;
                }
                a((Runnable) new Runnable() {
                    public void run() {
                        if (d.this.m != null) {
                            d.this.m.sendEmptyMessage(101);
                        }
                    }
                });
            } else if (this.e || b(this.A)) {
                x xVar3 = this.m;
                if (xVar3 != null) {
                    xVar3.sendEmptyMessage(101);
                }
            } else {
                a((Runnable) new Runnable() {
                    public void run() {
                        if (d.this.m != null) {
                            d.this.m.sendEmptyMessage(101);
                        }
                    }
                });
            }
        }
    }

    public void l() {
        if (!h()) {
            this.j = true;
            D();
            x xVar = this.m;
            if (xVar != null) {
                try {
                    xVar.removeCallbacksAndMessages((Object) null);
                    if (this.f != null) {
                        this.m.sendEmptyMessage(103);
                    }
                } catch (Throwable th) {
                    x();
                    throw th;
                }
                x();
            }
        }
    }

    private void v() {
        com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#start first play prepare invoke !");
        b((Runnable) new Runnable() {
            public void run() {
                if (d.this.m != null) {
                    d.this.m.sendEmptyMessage(104);
                    com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#start first play prepare invoke ! sendMsg --> OP_PREPARE_ASYNC");
                }
            }
        });
    }

    public void a(final long j2) {
        if (!h()) {
            if (this.k == 207 || this.k == 206 || this.k == 209) {
                b((Runnable) new Runnable() {
                    public void run() {
                        if (d.this.m != null) {
                            d.this.m.obtainMessage(106, Long.valueOf(j2)).sendToTarget();
                        }
                    }
                });
            }
        }
    }

    public boolean a() {
        return this.e;
    }

    public void a(final SurfaceTexture surfaceTexture) {
        if (!h()) {
            this.a = surfaceTexture;
            a(true);
            b((Runnable) new Runnable() {
                public void run() {
                    com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "setSurface() runnable exec");
                    d.this.u();
                    if (d.this.m != null) {
                        d.this.m.obtainMessage(111, surfaceTexture).sendToTarget();
                    }
                }
            });
        }
    }

    public void a(final SurfaceHolder surfaceHolder) {
        if (!h()) {
            this.b = surfaceHolder;
            a(true);
            b((Runnable) new Runnable() {
                public void run() {
                    com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "setDisplay() runnable exec");
                    d.this.u();
                    if (d.this.m != null) {
                        d.this.m.obtainMessage(110, surfaceHolder).sendToTarget();
                    }
                }
            });
        }
    }

    public void a(final com.bykv.vk.openvk.component.video.api.c.c cVar) {
        if (!h()) {
            this.A = cVar;
            if (cVar != null) {
                this.K = this.K && !cVar.d();
            }
            b((Runnable) new Runnable() {
                public void run() {
                    com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "setDataSource() runnable exec ");
                    d.this.u();
                    if (d.this.m != null) {
                        d.this.m.obtainMessage(107, cVar).sendToTarget();
                    }
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r2.m;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean f() {
        /*
            r2 = this;
            int r0 = r2.k
            r1 = 206(0xce, float:2.89E-43)
            if (r0 == r1) goto L_0x0012
            com.bytedance.sdk.component.utils.x r0 = r2.m
            if (r0 == 0) goto L_0x0018
            r1 = 100
            boolean r0 = r0.hasMessages(r1)
            if (r0 == 0) goto L_0x0018
        L_0x0012:
            boolean r0 = r2.H
            if (r0 != 0) goto L_0x0018
            r0 = 1
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.a.d.d.f():boolean");
    }

    public boolean c() {
        return m() || f() || g();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r2.m;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean g() {
        /*
            r2 = this;
            int r0 = r2.k
            r1 = 207(0xcf, float:2.9E-43)
            if (r0 == r1) goto L_0x000a
            boolean r0 = r2.H
            if (r0 == 0) goto L_0x0018
        L_0x000a:
            com.bytedance.sdk.component.utils.x r0 = r2.m
            if (r0 == 0) goto L_0x0018
            r1 = 100
            boolean r0 = r0.hasMessages(r1)
            if (r0 != 0) goto L_0x0018
            r0 = 1
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.a.d.d.g():boolean");
    }

    public boolean h() {
        return this.j;
    }

    public boolean m() {
        return this.k == 205;
    }

    public boolean b() {
        return this.k == 209;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0200, code lost:
        r12 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.os.Message r17) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            java.lang.String r2 = "setDataSource：  url"
            java.lang.String r3 = "setDataSource： MediaDataSource url"
            java.lang.String r4 = "setDataSource： try paly local:"
            java.lang.String r5 = "setDataSource： paly net:"
            java.lang.String r6 = "[video] OP_START, seekTo:"
            int r7 = r1.k
            int r8 = r0.what
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "[video]  execute , mCurrentState = "
            r9.<init>(r10)
            int r10 = r1.k
            r9.append(r10)
            java.lang.String r10 = " handlerMsg="
            r9.append(r10)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            java.lang.String r10 = "CSJ_VIDEO_MEDIA"
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r10, (java.lang.String) r9)
            com.bykv.vk.openvk.component.video.a.d.c r9 = r1.f
            r11 = 1
            r12 = 0
            if (r9 == 0) goto L_0x0330
            int r9 = r0.what
            r13 = 203(0xcb, float:2.84E-43)
            r14 = 201(0xc9, float:2.82E-43)
            r15 = 207(0xcf, float:2.9E-43)
            switch(r9) {
                case 100: goto L_0x02d1;
                case 101: goto L_0x026e;
                case 102: goto L_0x0253;
                case 103: goto L_0x0217;
                case 104: goto L_0x01ee;
                case 105: goto L_0x01ba;
                case 106: goto L_0x018c;
                case 107: goto L_0x008b;
                case 108: goto L_0x0040;
                case 109: goto L_0x0040;
                case 110: goto L_0x006b;
                case 111: goto L_0x0042;
                default: goto L_0x0040;
            }
        L_0x0040:
            goto L_0x0330
        L_0x0042:
            java.lang.String r2 = "OP_SET_SURFACE"
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r10, (java.lang.String) r2)
            java.lang.Object r0 = r0.obj     // Catch:{ all -> 0x0063 }
            android.graphics.SurfaceTexture r0 = (android.graphics.SurfaceTexture) r0     // Catch:{ all -> 0x0063 }
            android.view.Surface r2 = new android.view.Surface     // Catch:{ all -> 0x0063 }
            r2.<init>(r0)     // Catch:{ all -> 0x0063 }
            r1.E = r2     // Catch:{ all -> 0x0063 }
            com.bykv.vk.openvk.component.video.a.d.c r0 = r1.f     // Catch:{ all -> 0x0063 }
            android.view.Surface r2 = r1.E     // Catch:{ all -> 0x0063 }
            r0.a((android.view.Surface) r2)     // Catch:{ all -> 0x0063 }
            com.bykv.vk.openvk.component.video.a.d.c r0 = r1.f     // Catch:{ all -> 0x0063 }
            r0.b(r11)     // Catch:{ all -> 0x0063 }
            r16.C()     // Catch:{ all -> 0x0063 }
            goto L_0x0330
        L_0x0063:
            r0 = move-exception
            java.lang.String r2 = "OP_SET_SURFACE error: "
            com.bykv.vk.openvk.component.video.api.f.c.a(r10, r2, r0)
            goto L_0x0330
        L_0x006b:
            java.lang.String r2 = "OP_SET_DISPLAY"
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r10, (java.lang.String) r2)
            java.lang.Object r0 = r0.obj     // Catch:{ all -> 0x0083 }
            android.view.SurfaceHolder r0 = (android.view.SurfaceHolder) r0     // Catch:{ all -> 0x0083 }
            com.bykv.vk.openvk.component.video.a.d.c r2 = r1.f     // Catch:{ all -> 0x0083 }
            r2.a((android.view.SurfaceHolder) r0)     // Catch:{ all -> 0x0083 }
            com.bykv.vk.openvk.component.video.a.d.c r0 = r1.f     // Catch:{ all -> 0x0083 }
            r0.b(r11)     // Catch:{ all -> 0x0083 }
            r16.C()     // Catch:{ all -> 0x0083 }
            goto L_0x0330
        L_0x0083:
            r0 = move-exception
            java.lang.String r2 = "OP_SET_DISPLAY error: "
            com.bykv.vk.openvk.component.video.api.f.c.a(r10, r2, r0)
            goto L_0x0330
        L_0x008b:
            java.lang.String r6 = "OP_SET_DATASOURCE"
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r10, (java.lang.String) r6)
            r16.t()
            int r6 = r1.k
            if (r6 == r14) goto L_0x009b
            int r6 = r1.k
            if (r6 != r13) goto L_0x0200
        L_0x009b:
            java.lang.Object r0 = r0.obj     // Catch:{ all -> 0x0184 }
            com.bykv.vk.openvk.component.video.api.c.c r0 = (com.bykv.vk.openvk.component.video.api.c.c) r0     // Catch:{ all -> 0x0184 }
            java.lang.String r6 = r0.b()     // Catch:{ all -> 0x0184 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0184 }
            if (r6 == 0) goto L_0x00b0
            java.lang.String r6 = com.bykv.vk.openvk.component.video.api.c.b()     // Catch:{ all -> 0x0184 }
            r0.a((java.lang.String) r6)     // Catch:{ all -> 0x0184 }
        L_0x00b0:
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x0184 }
            java.lang.String r9 = r0.b()     // Catch:{ all -> 0x0184 }
            java.lang.String r13 = r0.n()     // Catch:{ all -> 0x0184 }
            r6.<init>(r9, r13)     // Catch:{ all -> 0x0184 }
            boolean r9 = r6.exists()     // Catch:{ all -> 0x0184 }
            if (r9 == 0) goto L_0x00f1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0184 }
            r0.<init>(r4)     // Catch:{ all -> 0x0184 }
            java.lang.String r2 = r6.getAbsolutePath()     // Catch:{ all -> 0x0184 }
            r0.append(r2)     // Catch:{ all -> 0x0184 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0184 }
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r10, (java.lang.String) r0)     // Catch:{ all -> 0x0184 }
            boolean r0 = com.bykv.vk.openvk.component.video.api.c.c()     // Catch:{ all -> 0x0184 }
            if (r0 == 0) goto L_0x00e7
            java.lang.String r0 = r6.getAbsolutePath()     // Catch:{ all -> 0x0184 }
            r1.a((java.lang.String) r0)     // Catch:{ all -> 0x0184 }
        L_0x00e3:
            r0 = 202(0xca, float:2.83E-43)
            goto L_0x0180
        L_0x00e7:
            com.bykv.vk.openvk.component.video.a.d.c r0 = r1.f     // Catch:{ all -> 0x0184 }
            java.lang.String r2 = r6.getAbsolutePath()     // Catch:{ all -> 0x0184 }
            r0.a((java.lang.String) r2)     // Catch:{ all -> 0x0184 }
            goto L_0x00e3
        L_0x00f1:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0184 }
            r4.<init>(r5)     // Catch:{ all -> 0x0184 }
            java.lang.String r5 = r0.m()     // Catch:{ all -> 0x0184 }
            r4.append(r5)     // Catch:{ all -> 0x0184 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0184 }
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r10, (java.lang.String) r4)     // Catch:{ all -> 0x0184 }
            int r4 = r0.b     // Catch:{ all -> 0x0184 }
            r5 = 23
            if (r4 != r11) goto L_0x012b
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0184 }
            if (r4 >= r5) goto L_0x012b
            com.bykv.vk.openvk.component.video.a.d.c r3 = r1.f     // Catch:{ all -> 0x0184 }
            java.lang.String r4 = r0.m()     // Catch:{ all -> 0x0184 }
            r3.a((java.lang.String) r4)     // Catch:{ all -> 0x0184 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0184 }
            r3.<init>(r2)     // Catch:{ all -> 0x0184 }
            java.lang.String r0 = r0.m()     // Catch:{ all -> 0x0184 }
            r3.append(r0)     // Catch:{ all -> 0x0184 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0184 }
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r10, (java.lang.String) r0)     // Catch:{ all -> 0x0184 }
            goto L_0x00e3
        L_0x012b:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0184 }
            if (r2 < r5) goto L_0x0148
            com.bykv.vk.openvk.component.video.a.d.c r2 = r1.f     // Catch:{ all -> 0x0184 }
            r2.a((com.bykv.vk.openvk.component.video.api.c.c) r0)     // Catch:{ all -> 0x0184 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0184 }
            r2.<init>(r3)     // Catch:{ all -> 0x0184 }
            java.lang.String r0 = r0.m()     // Catch:{ all -> 0x0184 }
            r2.append(r0)     // Catch:{ all -> 0x0184 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0184 }
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r10, (java.lang.String) r0)     // Catch:{ all -> 0x0184 }
            goto L_0x00e3
        L_0x0148:
            com.bykv.vk.openvk.component.video.a.b.f.a r2 = com.bykv.vk.openvk.component.video.a.b.f.a.a()     // Catch:{ all -> 0x0184 }
            java.lang.String r0 = r2.b(r0)     // Catch:{ all -> 0x0184 }
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0184 }
            java.lang.String r3 = "setDataSource：  local url = "
            r2[r12] = r3     // Catch:{ all -> 0x0184 }
            r2[r11] = r0     // Catch:{ all -> 0x0184 }
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r10, (java.lang.Object[]) r2)     // Catch:{ all -> 0x0184 }
            if (r0 == 0) goto L_0x0179
            boolean r2 = com.bykv.vk.openvk.component.video.api.c.c()     // Catch:{ all -> 0x0184 }
            if (r2 == 0) goto L_0x0179
            java.lang.String r2 = "file"
            boolean r2 = r0.startsWith(r2)     // Catch:{ all -> 0x0184 }
            if (r2 == 0) goto L_0x0179
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ all -> 0x0184 }
            java.lang.String r0 = r0.getPath()     // Catch:{ all -> 0x0184 }
            r1.a((java.lang.String) r0)     // Catch:{ all -> 0x0184 }
            goto L_0x00e3
        L_0x0179:
            com.bykv.vk.openvk.component.video.a.d.c r2 = r1.f     // Catch:{ all -> 0x0184 }
            r2.a((java.lang.String) r0)     // Catch:{ all -> 0x0184 }
            goto L_0x00e3
        L_0x0180:
            r1.k = r0     // Catch:{ all -> 0x0184 }
            goto L_0x0330
        L_0x0184:
            r0 = move-exception
            java.lang.String r2 = "OP_SET_DATASOURCE error: "
            com.bykv.vk.openvk.component.video.api.f.c.a(r10, r2, r0)
            goto L_0x0330
        L_0x018c:
            java.lang.String r2 = "OP_SEEKTO"
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r10, (java.lang.String) r2)
            int r2 = r1.k
            r3 = 206(0xce, float:2.89E-43)
            if (r2 == r3) goto L_0x01a1
            int r2 = r1.k
            if (r2 == r15) goto L_0x01a1
            int r2 = r1.k
            r3 = 209(0xd1, float:2.93E-43)
            if (r2 != r3) goto L_0x0200
        L_0x01a1:
            com.bykv.vk.openvk.component.video.a.d.c r2 = r1.f     // Catch:{ all -> 0x01b2 }
            java.lang.Object r0 = r0.obj     // Catch:{ all -> 0x01b2 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x01b2 }
            long r3 = r0.longValue()     // Catch:{ all -> 0x01b2 }
            int r0 = r1.d     // Catch:{ all -> 0x01b2 }
            r2.a(r3, r0)     // Catch:{ all -> 0x01b2 }
            goto L_0x0330
        L_0x01b2:
            r0 = move-exception
            java.lang.String r2 = "OP_SEEKTO error: "
            com.bykv.vk.openvk.component.video.api.f.c.a(r10, r2, r0)
            goto L_0x0330
        L_0x01ba:
            java.lang.String r0 = "OP_STOP"
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r10, (java.lang.String) r0)
            int r0 = r1.k
            r2 = 205(0xcd, float:2.87E-43)
            if (r0 == r2) goto L_0x01db
            int r0 = r1.k
            r2 = 206(0xce, float:2.89E-43)
            if (r0 == r2) goto L_0x01db
            int r0 = r1.k
            r2 = 208(0xd0, float:2.91E-43)
            if (r0 == r2) goto L_0x01db
            int r0 = r1.k
            if (r0 == r15) goto L_0x01db
            int r0 = r1.k
            r2 = 209(0xd1, float:2.93E-43)
            if (r0 != r2) goto L_0x0200
        L_0x01db:
            com.bykv.vk.openvk.component.video.a.d.c r0 = r1.f     // Catch:{ all -> 0x01e6 }
            r0.f()     // Catch:{ all -> 0x01e6 }
            r0 = 208(0xd0, float:2.91E-43)
            r1.k = r0     // Catch:{ all -> 0x01e6 }
            goto L_0x0330
        L_0x01e6:
            r0 = move-exception
            java.lang.String r2 = "OP_STOP error: "
            com.bykv.vk.openvk.component.video.api.f.c.a(r10, r2, r0)
            goto L_0x0330
        L_0x01ee:
            java.lang.String r0 = "OP_PREPARE_ASYNC"
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r10, (java.lang.String) r0)
            int r0 = r1.k
            r2 = 202(0xca, float:2.83E-43)
            if (r0 == r2) goto L_0x0203
            int r0 = r1.k
            r2 = 208(0xd0, float:2.91E-43)
            if (r0 != r2) goto L_0x0200
            goto L_0x0203
        L_0x0200:
            r12 = 1
            goto L_0x0330
        L_0x0203:
            com.bykv.vk.openvk.component.video.a.d.c r0 = r1.f     // Catch:{ all -> 0x020f }
            r0.h()     // Catch:{ all -> 0x020f }
            java.lang.String r0 = "[video] OP_PREPARE_ASYNC execute , mMediaPlayer real prepareAsync !"
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r10, (java.lang.String) r0)     // Catch:{ all -> 0x020f }
            goto L_0x0330
        L_0x020f:
            r0 = move-exception
            java.lang.String r2 = "OP_PREPARE_ASYNC error: "
            com.bykv.vk.openvk.component.video.api.f.c.c(r10, r2, r0)
            goto L_0x0330
        L_0x0217:
            java.lang.String r0 = "OP_RELEASE"
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r10, (java.lang.String) r0)
            r16.w()     // Catch:{ all -> 0x0225 }
            java.lang.String r0 = "[video] OP_RELEASE execute , releaseMediaplayer !"
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r10, (java.lang.String) r0)     // Catch:{ all -> 0x0225 }
            goto L_0x022b
        L_0x0225:
            r0 = move-exception
            java.lang.String r2 = "OP_RELEASE error: "
            com.bykv.vk.openvk.component.video.api.f.c.c(r10, r2, r0)
        L_0x022b:
            java.util.List<java.lang.ref.WeakReference<com.bykv.vk.openvk.component.video.api.a$a>> r0 = r1.z
            java.util.Iterator r0 = r0.iterator()
        L_0x0231:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x024f
            java.lang.Object r2 = r0.next()
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2
            if (r2 == 0) goto L_0x0231
            java.lang.Object r3 = r2.get()
            if (r3 == 0) goto L_0x0231
            java.lang.Object r2 = r2.get()
            com.bykv.vk.openvk.component.video.api.a$a r2 = (com.bykv.vk.openvk.component.video.api.a.C0034a) r2
            r2.c(r1)
            goto L_0x0231
        L_0x024f:
            r1.k = r13
            goto L_0x0330
        L_0x0253:
            java.lang.String r0 = "OP_RESET"
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r10, (java.lang.String) r0)
            com.bykv.vk.openvk.component.video.a.d.c r0 = r1.f     // Catch:{ all -> 0x0266 }
            r0.l()     // Catch:{ all -> 0x0266 }
            java.lang.String r0 = "[video] OP_RESET execute!"
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r10, (java.lang.String) r0)     // Catch:{ all -> 0x0266 }
            r1.k = r14     // Catch:{ all -> 0x0266 }
            goto L_0x0330
        L_0x0266:
            r0 = move-exception
            java.lang.String r2 = "OP_RESET error: "
            com.bykv.vk.openvk.component.video.api.f.c.a(r10, r2, r0)
            goto L_0x0330
        L_0x026e:
            java.lang.String r0 = "OP_PAUSE"
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r10, (java.lang.String) r0)
            boolean r0 = r1.n
            if (r0 == 0) goto L_0x027e
            long r2 = r1.o
            long r4 = r1.q
            long r2 = r2 + r4
            r1.o = r2
        L_0x027e:
            r1.n = r12
            r2 = 0
            r1.q = r2
            r2 = -9223372036854775808
            r1.p = r2
            int r0 = r1.k
            r2 = 206(0xce, float:2.89E-43)
            if (r0 == r2) goto L_0x0298
            int r0 = r1.k
            if (r0 == r15) goto L_0x0298
            int r0 = r1.k
            r2 = 209(0xd1, float:2.93E-43)
            if (r0 != r2) goto L_0x0200
        L_0x0298:
            java.lang.String r0 = "[video] OP_PAUSE execute , mMediaPlayer  OP_PAUSE !"
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r10, (java.lang.String) r0)     // Catch:{ all -> 0x02ca }
            com.bykv.vk.openvk.component.video.a.d.c r0 = r1.f     // Catch:{ all -> 0x02ca }
            r0.g()     // Catch:{ all -> 0x02ca }
            r1.k = r15     // Catch:{ all -> 0x02ca }
            r1.H = r12     // Catch:{ all -> 0x02ca }
            java.util.List<java.lang.ref.WeakReference<com.bykv.vk.openvk.component.video.api.a$a>> r0 = r1.z     // Catch:{ all -> 0x02ca }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x02ca }
        L_0x02ac:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x02ca }
            if (r2 == 0) goto L_0x0330
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x02ca }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x02ca }
            if (r2 == 0) goto L_0x02ac
            java.lang.Object r3 = r2.get()     // Catch:{ all -> 0x02ca }
            if (r3 == 0) goto L_0x02ac
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x02ca }
            com.bykv.vk.openvk.component.video.api.a$a r2 = (com.bykv.vk.openvk.component.video.api.a.C0034a) r2     // Catch:{ all -> 0x02ca }
            r2.d(r1)     // Catch:{ all -> 0x02ca }
            goto L_0x02ac
        L_0x02ca:
            r0 = move-exception
            java.lang.String r2 = "OP_PAUSE error: "
            com.bykv.vk.openvk.component.video.api.f.c.a(r10, r2, r0)
            goto L_0x0330
        L_0x02d1:
            java.lang.String r0 = "OP_START"
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r10, (java.lang.String) r0)
            int r0 = r1.k
            r2 = 205(0xcd, float:2.87E-43)
            if (r0 == r2) goto L_0x02e6
            int r0 = r1.k
            if (r0 == r15) goto L_0x02e6
            int r0 = r1.k
            r2 = 209(0xd1, float:2.93E-43)
            if (r0 != r2) goto L_0x0200
        L_0x02e6:
            com.bykv.vk.openvk.component.video.a.d.c r0 = r1.f     // Catch:{ all -> 0x032a }
            r0.e()     // Catch:{ all -> 0x032a }
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x032a }
            r1.s = r2     // Catch:{ all -> 0x032a }
            java.lang.String r0 = "[video] OP_START execute , mMediaPlayer real start !"
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r10, (java.lang.String) r0)     // Catch:{ all -> 0x032a }
            r0 = 206(0xce, float:2.89E-43)
            r1.k = r0     // Catch:{ all -> 0x032a }
            long r2 = r1.l     // Catch:{ all -> 0x032a }
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0320
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x032a }
            r0.<init>(r6)     // Catch:{ all -> 0x032a }
            long r2 = r1.l     // Catch:{ all -> 0x032a }
            r0.append(r2)     // Catch:{ all -> 0x032a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x032a }
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r10, (java.lang.String) r0)     // Catch:{ all -> 0x032a }
            com.bykv.vk.openvk.component.video.a.d.c r0 = r1.f     // Catch:{ all -> 0x032a }
            long r2 = r1.l     // Catch:{ all -> 0x032a }
            int r4 = r1.d     // Catch:{ all -> 0x032a }
            r0.a(r2, r4)     // Catch:{ all -> 0x032a }
            r2 = -1
            r1.l = r2     // Catch:{ all -> 0x032a }
        L_0x0320:
            com.bykv.vk.openvk.component.video.api.c.c r0 = r1.A     // Catch:{ all -> 0x032a }
            if (r0 == 0) goto L_0x0330
            boolean r0 = r1.B     // Catch:{ all -> 0x032a }
            r1.b((boolean) r0)     // Catch:{ all -> 0x032a }
            goto L_0x0330
        L_0x032a:
            r0 = move-exception
            java.lang.String r2 = "OP_START error: "
            com.bykv.vk.openvk.component.video.api.f.c.a(r10, r2, r0)
        L_0x0330:
            if (r12 == 0) goto L_0x0383
            java.lang.String r0 = "wrongState"
            com.bykv.vk.openvk.component.video.api.f.c.a((java.lang.String) r10, (java.lang.String) r0)
            r0 = 200(0xc8, float:2.8E-43)
            r1.k = r0
            boolean r0 = r1.h
            if (r0 != 0) goto L_0x0383
            com.bykv.vk.openvk.component.video.api.c.a r0 = new com.bykv.vk.openvk.component.video.api.c.a
            r2 = 308(0x134, float:4.32E-43)
            r0.<init>(r2, r8)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            java.lang.String r3 = ","
            r2.append(r3)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            r0.a(r2)
            java.util.List<java.lang.ref.WeakReference<com.bykv.vk.openvk.component.video.api.a$a>> r2 = r1.z
            java.util.Iterator r2 = r2.iterator()
        L_0x0363:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0381
            java.lang.Object r3 = r2.next()
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3
            if (r3 == 0) goto L_0x0363
            java.lang.Object r4 = r3.get()
            if (r4 == 0) goto L_0x0363
            java.lang.Object r3 = r3.get()
            com.bykv.vk.openvk.component.video.api.a$a r3 = (com.bykv.vk.openvk.component.video.api.a.C0034a) r3
            r3.a((com.bykv.vk.openvk.component.video.api.a) r1, (com.bykv.vk.openvk.component.video.api.c.a) r0)
            goto L_0x0363
        L_0x0381:
            r1.h = r11
        L_0x0383:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.a.d.d.a(android.os.Message):void");
    }

    private void a(String str) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.f.a(fileInputStream.getFD());
        fileInputStream.close();
    }

    private void w() {
        com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_VIDEO_MEDIA", "releaseMediaPlayer: ");
        if (this.f != null) {
            try {
                this.f.l();
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "releaseMediaplayer error1: ", th);
            }
            this.f.a((c.b) null);
            this.f.a((c.g) null);
            this.f.a((c.a) null);
            this.f.a((c.d) null);
            this.f.a((c.C0033c) null);
            this.f.a((c.e) null);
            this.f.a((c.f) null);
            try {
                this.f.k();
            } catch (Throwable th2) {
                com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "releaseMediaplayer error2: ", th2);
            }
        }
    }

    private void x() {
        x xVar = this.m;
        if (xVar != null && xVar.getLooper() != null) {
            this.m.post(new Runnable() {
                public void run() {
                    if (d.this.m != null && d.this.m.getLooper() != null) {
                        try {
                            com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "onDestory............");
                            com.bytedance.sdk.component.g.a.a.a().a(d.this.m);
                            x unused = d.this.m = null;
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "onDestroy error: ", th);
                        }
                    }
                }
            });
        }
    }

    public void a(c cVar, int i2) {
        if (this.f == cVar) {
            for (WeakReference next : this.z) {
                if (!(next == null || next.get() == null)) {
                    ((a.C0034a) next.get()).b(this, i2);
                }
            }
        }
    }

    private void y() {
        SparseIntArray sparseIntArray = x;
        Integer valueOf = Integer.valueOf(sparseIntArray.get(this.v));
        if (valueOf == null) {
            sparseIntArray.put(this.v, 1);
        } else {
            sparseIntArray.put(this.v, Integer.valueOf(valueOf.intValue() + 1).intValue());
        }
    }

    public void a(c cVar) {
        this.k = 209;
        x.delete(this.v);
        x xVar = this.m;
        if (xVar != null) {
            xVar.removeCallbacks(this.F);
        }
        for (WeakReference next : this.z) {
            if (!(next == null || next.get() == null)) {
                ((a.C0034a) next.get()).a(this);
            }
        }
    }

    public boolean a(c cVar, int i2, int i3) {
        com.bykv.vk.openvk.component.video.api.f.c.c("CSJ_VIDEO_MEDIA", "what=" + i2 + "extra=" + i3);
        y();
        this.k = 200;
        x xVar = this.m;
        if (xVar != null) {
            xVar.removeCallbacks(this.F);
        }
        if (a(i2, i3)) {
            x();
        }
        if (!this.D.get()) {
            return true;
        }
        this.D.set(false);
        com.bykv.vk.openvk.component.video.api.c.a aVar = new com.bykv.vk.openvk.component.video.api.c.a(i2, i3);
        for (WeakReference next : this.z) {
            if (!(next == null || next.get() == null)) {
                ((a.C0034a) next.get()).a((com.bykv.vk.openvk.component.video.api.a) this, aVar);
            }
        }
        return true;
    }

    private boolean a(int i2, int i3) {
        com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "OnError - Error code: " + i2 + " Extra code: " + i3);
        boolean z2 = i2 == -1010 || i2 == -1007 || i2 == -1004 || i2 == -110 || i2 == 100 || i2 == 200;
        if (i3 == 1 || i3 == 700 || i3 == 800) {
            return true;
        }
        return z2;
    }

    public boolean b(c cVar, int i2, int i3) {
        com.bykv.vk.openvk.component.video.api.f.c.c("CSJ_VIDEO_MEDIA", "what,extra:" + i2 + "," + i3);
        if (this.f != cVar) {
            return false;
        }
        if (i3 == -1004) {
            com.bykv.vk.openvk.component.video.api.c.a aVar = new com.bykv.vk.openvk.component.video.api.c.a(i2, i3);
            for (WeakReference next : this.z) {
                if (!(next == null || next.get() == null)) {
                    ((a.C0034a) next.get()).a((com.bykv.vk.openvk.component.video.api.a) this, aVar);
                }
            }
        }
        b(i2, i3);
        return false;
    }

    /* access modifiers changed from: private */
    public void b(int i2, int i3) {
        if (i2 == 701) {
            this.I = SystemClock.elapsedRealtime();
            this.c++;
            for (WeakReference next : this.z) {
                if (!(next == null || next.get() == null)) {
                    ((a.C0034a) next.get()).a(this, Integer.MAX_VALUE, 0, 0);
                }
            }
            com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_VIDEO_MEDIA", "bufferCount = ", Integer.valueOf(this.c));
        } else if (i2 == 702) {
            if (this.I > 0) {
                this.J += SystemClock.elapsedRealtime() - this.I;
                this.I = 0;
            }
            for (WeakReference next2 : this.z) {
                if (!(next2 == null || next2.get() == null)) {
                    ((a.C0034a) next2.get()).a((com.bykv.vk.openvk.component.video.api.a) this, Integer.MAX_VALUE);
                }
            }
            com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_VIDEO_MEDIA", "bufferCount = ", Integer.valueOf(this.c), " mBufferTotalTime = ", Long.valueOf(this.J));
        } else if (this.K && i2 == 3) {
            com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_VIDEO_MEDIA", "hasPendingPauseCommand:" + this.H);
            C();
            z();
            b(this.B);
            com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_VIDEO_MEDIA", "onRenderStart");
        }
    }

    public void b(c cVar) {
        if (!h()) {
            this.k = 205;
            try {
                com.bykv.vk.openvk.component.video.api.c.c cVar2 = this.A;
                if (cVar2 != null) {
                    float l2 = cVar2.l();
                    if (l2 > 0.0f) {
                        b bVar = new b();
                        bVar.a(l2);
                        this.f.a(bVar);
                    }
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "speed error: ", th);
            }
            if (this.m != null) {
                if (this.H) {
                    A();
                } else {
                    com.bykv.vk.openvk.component.video.api.f.c.c("CSJ_VIDEO_MEDIA", "onPrepared op_Start");
                    x xVar = this.m;
                    xVar.sendMessage(xVar.obtainMessage(100, -1, -1));
                }
            }
            x.delete(this.v);
            com.bykv.vk.openvk.component.video.api.f.c.c("CSJ_VIDEO_MEDIA", "onPrepared:" + this.K + " " + this.t);
            if (!this.K && !this.t) {
                z();
                this.t = true;
            }
            for (WeakReference next : this.z) {
                if (!(next == null || next.get() == null)) {
                    ((a.C0034a) next.get()).b(this);
                }
            }
        }
    }

    private void z() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.s;
        for (WeakReference next : this.z) {
            if (!(next == null || next.get() == null)) {
                ((a.C0034a) next.get()).a((com.bykv.vk.openvk.component.video.api.a) this, elapsedRealtime);
            }
        }
        this.e = true;
    }

    private void A() {
        x xVar = this.m;
        if (xVar != null) {
            xVar.post(new Runnable() {
                public void run() {
                    try {
                        d.this.f.g();
                        int unused = d.this.k = 207;
                        boolean unused2 = d.this.H = false;
                    } catch (Throwable th) {
                        com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "pauseBeforePlayIfNeed error: ", th);
                    }
                }
            });
        }
    }

    public void c(c cVar) {
        for (WeakReference next : this.z) {
            if (!(next == null || next.get() == null)) {
                ((a.C0034a) next.get()).a((com.bykv.vk.openvk.component.video.api.a) this, true);
            }
        }
    }

    private void a(Runnable runnable) {
        try {
            com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "enqueueAction()");
            if (this.u == null) {
                this.u = new ArrayList<>();
            }
            this.u.add(runnable);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.c.c("CSJ_VIDEO_MEDIA", th.getMessage());
        }
    }

    private void B() {
        if (!this.i) {
            this.i = true;
            Iterator it = new ArrayList(this.u).iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.u.clear();
            this.i = false;
        }
    }

    private void C() {
        ArrayList<Runnable> arrayList = this.u;
        boolean z2 = arrayList == null || arrayList.isEmpty();
        com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "isPendingAction:" + z2);
        if (!z2) {
            B();
        }
    }

    private void D() {
        ArrayList<Runnable> arrayList = this.u;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.u.clear();
        }
    }

    private void b(Runnable runnable) {
        if (runnable != null && !h()) {
            if (!this.j) {
                runnable.run();
            } else {
                a(runnable);
            }
        }
    }

    public void b(final boolean z2) {
        if (!h()) {
            x xVar = this.m;
            if (xVar == null) {
                com.bykv.vk.openvk.component.video.api.f.c.b("CSJ_VIDEO_MEDIA", "quietPlay set opHandler is null");
            } else {
                xVar.post(new Runnable() {
                    public void run() {
                        if (!d.this.h() && d.this.f != null) {
                            try {
                                boolean unused = d.this.B = z2;
                                d.this.f.d(z2);
                            } catch (Throwable th) {
                                com.bykv.vk.openvk.component.video.api.f.c.a("CSJ_VIDEO_MEDIA", "setQuietPlay error: ", th);
                            }
                        }
                    }
                });
            }
        }
    }

    public long n() {
        if (Build.VERSION.SDK_INT < 23) {
            return this.J;
        }
        if (this.n) {
            long j2 = this.q;
            if (j2 > 0) {
                return this.o + j2;
            }
        }
        return this.o;
    }

    public int d() {
        if (this.f == null || h()) {
            return 0;
        }
        return this.f.m();
    }

    public int e() {
        if (this.f == null || h()) {
            return 0;
        }
        return this.f.n();
    }

    public int o() {
        return this.c;
    }

    public void a(c cVar, int i2, int i3, int i4, int i5) {
        for (WeakReference next : this.z) {
            if (!(next == null || next.get() == null)) {
                ((a.C0034a) next.get()).a((com.bykv.vk.openvk.component.video.api.a) this, i2, i3);
            }
        }
    }

    public long p() {
        long j2 = this.r;
        if (j2 != 0) {
            return j2;
        }
        if (this.k == 206 || this.k == 207) {
            try {
                this.r = this.f.j();
            } catch (Throwable unused) {
            }
        }
        return this.r;
    }

    public long q() {
        if (h()) {
            return 0;
        }
        if (this.k == 206 || this.k == 207) {
            try {
                return this.f.i();
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public void a(a.C0034a aVar) {
        if (aVar != null) {
            for (WeakReference next : this.z) {
                if (next != null && next.get() == aVar) {
                    return;
                }
            }
            this.z.add(new WeakReference(aVar));
        }
    }

    public void a(int i2) {
        if (!h()) {
            this.C = i2;
        }
    }

    public SurfaceHolder r() {
        return this.b;
    }

    public SurfaceTexture s() {
        return this.a;
    }

    public void b(int i2) {
        this.d = i2;
    }
}
