package com.bytedance.sdk.openadsdk.core.video.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bykv.vk.openvk.component.video.api.a;
import com.bykv.vk.openvk.component.video.api.c.c;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.b.g;
import com.bytedance.sdk.openadsdk.core.g.f;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.model.o;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.video.c.d;
import com.bytedance.sdk.openadsdk.layout.TTVideoPlayLayoutForLiveLayout;
import com.bytedance.sdk.openadsdk.n.a.e;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;

/* compiled from: BaseVideoController */
public class a extends com.bytedance.sdk.openadsdk.core.video.a.a {
    protected long D = 0;
    protected boolean E = false;
    f F;
    final d.b G = new d.b() {
        private boolean b = true;

        public void b(com.bykv.vk.openvk.component.video.api.a aVar, int i) {
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar) {
            l.c(a.this.a, "onCompletion: ");
            a.this.b.post(new Runnable() {
                public void run() {
                    a.this.L();
                }
            });
            com.bytedance.sdk.openadsdk.core.g.a au = a.this.g.au();
            if (!(au == null || au.a() == null)) {
                long e = a.this.e();
                au.a().d(e);
                au.a().e(e);
            }
            e.a(a.this.g, 5);
            if (a.this.F != null) {
                a.this.F.a(9);
            }
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar, long j) {
            l.c(a.this.a, "onRenderStart: ");
            boolean unused = a.this.w = false;
            a.this.b.removeCallbacks(a.this.M);
            a.this.b.post(new Runnable() {
                public void run() {
                    if (a.this.f != null) {
                        a.this.f.b();
                    }
                }
            });
            if (!a.this.s.get()) {
                a.this.D = j;
                a aVar2 = a.this;
                aVar2.a(aVar2.H);
                a.this.E();
            }
            if (a.this.F != null) {
                a.this.F.c();
            }
            e.a(a.this.g, 0);
        }

        public void b(com.bykv.vk.openvk.component.video.api.a aVar) {
            l.c(a.this.a, "onPrepared: ");
            a.this.b.removeCallbacks(a.this.M);
            a.this.b.post(new Runnable() {
                public void run() {
                    if (a.this.f != null) {
                        a.this.f.b();
                    }
                }
            });
            if (a.this.F != null) {
                a.this.F.a(a.this.h(), a.this.n());
            }
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar, com.bykv.vk.openvk.component.video.api.c.a aVar2) {
            String u = a.this.a;
            l.e(u, "onError: " + aVar2.a() + "," + aVar2.b() + "," + aVar2.c());
            a.this.b.removeCallbacks(a.this.M);
            a.this.b.post(new Runnable() {
                public void run() {
                    if (a.this.f != null) {
                        a.this.f.b();
                    }
                    if (a.this.z != null) {
                        a.this.z.b(a.this.J, com.bykv.vk.openvk.component.video.a.e.a.a(a.this.h, a.this.B));
                    }
                }
            });
            a.this.a(aVar2);
            e.a(a.this.g, 6);
            if (a.this.F != null) {
                a.this.F.a(14);
            }
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar, boolean z) {
            String F = a.this.a;
            l.c(F, "onSeekCompletion: " + z);
            a.this.b.removeCallbacks(a.this.M);
            a.this.b.post(new Runnable() {
                public void run() {
                    if (a.this.f != null) {
                        a.this.f.b();
                    }
                }
            });
        }

        public void c(com.bykv.vk.openvk.component.video.api.a aVar) {
            l.c(a.this.a, "IVideoPlayerCallback onRelease: ");
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar, int i, int i2) {
            String L = a.this.a;
            l.c(L, "IVideoPlayerCallback onVideoSizeChanged: " + i + "x" + i2);
            a.this.b.post(new Runnable() {
                public void run() {
                    if (!a.this.M()) {
                        a.this.N();
                    } else if (o.b(a.this.g) || a.this.v.e == 4) {
                        a.this.g(true);
                    } else if (a.this.g.A() == 3) {
                        a.this.g(true);
                    } else if (a.this.g.A() == 0) {
                        a.this.Q();
                    } else {
                        a.this.P();
                    }
                }
            });
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar, int i, int i2, int i3) {
            String V = a.this.a;
            l.c(V, "IVideoPlayerCallback onBufferStart: " + i + ", " + i2 + ", " + i3);
            boolean unused = a.this.w = true;
            a.this.K();
            a.this.b.post(new Runnable() {
                public void run() {
                    if (a.this.f != null) {
                        a.this.f.q();
                    }
                }
            });
            e.a(a.this.g, 3);
            if (a.this.F != null) {
                a.this.F.a(4);
            }
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar, int i) {
            String ab = a.this.a;
            l.c(ab, "IVideoPlayerCallback onBufferEnd: " + i);
            boolean unused = a.this.w = false;
            a.this.b.removeCallbacks(a.this.M);
            a.this.b.post(new Runnable() {
                public void run() {
                    if (a.this.f != null) {
                        a.this.f.b();
                    }
                }
            });
            e.a(a.this.g, 0);
            if (a.this.F != null) {
                a.this.F.a(5);
            }
        }

        public void a(com.bykv.vk.openvk.component.video.api.a aVar, long j, long j2) {
            if (Math.abs(j - a.this.h) >= 50) {
                a aVar2 = a.this;
                aVar2.a(aVar2.H);
                a.this.a(j, j2);
                com.bytedance.sdk.openadsdk.core.g.a au = a.this.g.au();
                if (!(au == null || au.a() == null)) {
                    au.a().a(j, j2, a.this.F);
                }
                if (this.b && j2 - j < 500) {
                    this.b = false;
                    a(aVar);
                }
            }
        }

        public void d(com.bykv.vk.openvk.component.video.api.a aVar) {
            com.bytedance.sdk.openadsdk.core.g.a au = a.this.g.au();
            if (!(au == null || au.a() == null)) {
                au.a().b(a.this.h);
            }
            e.a(a.this.g, 3);
            if (a.this.F != null) {
                a.this.F.a(0);
            }
        }

        public void e(com.bykv.vk.openvk.component.video.api.a aVar) {
            e.a(a.this.g, 0);
            if (a.this.F != null) {
                a.this.F.a(1);
            }
        }

        public void a(int i, int i2) {
            a aVar = a.this;
            aVar.b(aVar.H);
            a.this.v.d = a.this.e.t();
            a.this.C();
            a.this.s.set(false);
            a aVar2 = a.this;
            aVar2.a(aVar2.H);
        }
    };
    /* access modifiers changed from: private */
    public final g H;
    /* access modifiers changed from: private */
    public long I = 0;
    /* access modifiers changed from: private */
    public long J = 0;
    private boolean K = false;
    private final int L;
    /* access modifiers changed from: private */
    public final Runnable M = new Runnable() {
        public void run() {
            if (a.this.z != null) {
                a.this.r();
                a.this.z.a();
            }
        }
    };

    /* access modifiers changed from: protected */
    public void r() {
    }

    public boolean x() {
        return true;
    }

    public void F() {
        this.G.a((com.bykv.vk.openvk.component.video.api.a) null, 0, 0);
    }

    /* access modifiers changed from: protected */
    public void g(boolean z) {
        try {
            String str = this.a;
            l.c(str, "landingPageChangeVideoSize start......." + this.g.D());
            if (!O() || z) {
                l.c(this.a, "landingPageChangeVideoSize start check condition complete ... go ..");
                float d = (float) this.e.d();
                float e = (float) this.e.e();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) d, (int) e);
                layoutParams.addRule(13);
                if (H() != null) {
                    if (H() instanceof TextureView) {
                        ((TextureView) H()).setLayoutParams(layoutParams);
                    } else if (H() instanceof SurfaceView) {
                        ((SurfaceView) H()).setLayoutParams(layoutParams);
                    }
                    ViewGroup.LayoutParams layoutParams2 = this.x.getLayoutParams();
                    if (this.x.getHeight() > 0) {
                        float min = Math.min(((float) this.x.getWidth()) / d, ((float) this.x.getHeight()) / e);
                        if (layoutParams2 != null) {
                            layoutParams.width = (int) (d * min);
                            layoutParams.height = (int) (e * min);
                            if (H() instanceof TextureView) {
                                ((TextureView) H()).setLayoutParams(layoutParams);
                            } else if (H() instanceof SurfaceView) {
                                ((SurfaceView) H()).setLayoutParams(layoutParams);
                            }
                            if (this.v.e == 4) {
                                layoutParams2.width = layoutParams.width;
                                layoutParams2.height = layoutParams.height;
                                this.x.setLayoutParams(layoutParams2);
                            }
                        }
                    }
                }
                l.b(this.a, "changeVideoSize .... complete ... end !!!");
            }
        } catch (Throwable th) {
            l.c(this.a, "changeSize error", th);
        }
    }

    public a(Context context, ViewGroup viewGroup, q qVar, g gVar) {
        super(context, qVar, viewGroup);
        this.H = gVar;
        this.L = qVar.aZ();
        if (!(!qVar.at() || qVar.au() == null || this.x == null)) {
            if (this.F == null) {
                this.F = f.a();
            }
            this.F.a((View) this.x, qVar.au().n());
        }
        this.f = new com.bytedance.sdk.openadsdk.core.video.nativevideo.e(context.getApplicationContext(), new TTVideoPlayLayoutForLiveLayout(context), true, 17, this.g, this);
        this.f.a((com.bykv.vk.openvk.component.video.api.d.a) this);
    }

    public boolean a(c cVar) {
        int i;
        View view;
        boolean z = false;
        if (this.e != null) {
            l.e(this.a, "playVideoUrl: already invoked");
            return false;
        }
        String str = this.a;
        l.b(str, "video local url " + cVar.m());
        if (TextUtils.isEmpty(cVar.m())) {
            l.e(this.a, "No video info");
            return false;
        }
        b(cVar);
        cVar.c(1);
        this.E = !cVar.m().startsWith("http");
        if (this.F != null) {
            if (this.v.e == 1) {
                i = com.bytedance.sdk.openadsdk.core.o.d().j(String.valueOf(this.L));
            } else {
                i = com.bytedance.sdk.openadsdk.core.o.d().q(String.valueOf(this.L));
            }
            if (!(this.x == null || (view = (View) this.x.getParent()) == null)) {
                try {
                    View findViewById = view.findViewById(i.l);
                    View findViewById2 = view.findViewById(520093757);
                    View findViewById3 = view.findViewById(i.bs);
                    this.F.a(findViewById, FriendlyObstructionPurpose.OTHER);
                    this.F.a(findViewById3, FriendlyObstructionPurpose.OTHER);
                    this.F.a(findViewById2, FriendlyObstructionPurpose.OTHER);
                } catch (Throwable unused) {
                }
            }
            f fVar = this.F;
            if (i > 0) {
                z = true;
            }
            fVar.a(z, ((float) i) / 1000.0f);
        }
        C();
        if (cVar.g() > 0) {
            this.h = cVar.g();
            this.i = Math.max(this.i, this.h);
        }
        if (this.f != null) {
            this.f.a();
            this.f.g();
            this.f.c(cVar.e(), cVar.f());
            this.f.c(this.x);
        }
        this.e = new d();
        this.e.a((a.C0034a) this.G);
        s();
        this.J = 0;
        J();
        return true;
    }

    private void J() {
        this.e.c(D());
        this.e.a((c) this.v);
        this.I = System.currentTimeMillis();
        this.f.c(8);
        this.f.c(0);
        a((Runnable) new Runnable() {
            public void run() {
                if (a.this.e != null) {
                    long unused = a.this.I = System.currentTimeMillis();
                    a.this.f.d(0);
                    a.this.e.a(true, a.this.h, a.this.o);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void K() {
        int i;
        int i2 = this.v.e;
        if (i2 == 2 || i2 == 1) {
            i = com.bytedance.sdk.openadsdk.core.o.d().O() * 1000;
        } else {
            i = i2 == 4 ? com.bytedance.sdk.openadsdk.core.o.d().i(String.valueOf(this.L)) : 5000;
        }
        this.b.removeCallbacks(this.M);
        this.b.postDelayed(this.M, (long) i);
    }

    /* access modifiers changed from: private */
    public void L() {
        if (this.f != null) {
            this.b.removeCallbacks(this.M);
            this.f.b();
            this.J = System.currentTimeMillis() - this.I;
            if (!this.K) {
                this.K = true;
                a(this.B, this.B);
                long j = this.B;
                this.h = j;
                this.i = j;
                b(this.H);
            }
            if (this.z != null) {
                this.z.a(this.J, com.bykv.vk.openvk.component.video.a.e.a.a(this.h, this.B));
            }
            this.m = true;
        }
    }

    public void b() {
        if (this.f != null) {
            this.f.a();
            this.f.o();
            this.f.r();
        }
        l.b(this.a, "resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.l));
        if (this.e != null) {
            if (this.e.g()) {
                if (!this.l) {
                    b(this.C);
                } else if (h.v()) {
                    this.e.b(3);
                    this.e.a(false, this.e.q(), this.o);
                } else {
                    u();
                }
                l.b(this.a, "resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.l));
            } else {
                this.e.a(false, this.h, this.o);
            }
        }
        if (!this.K && this.s.get()) {
            A();
            com.bytedance.sdk.openadsdk.core.g.a au = this.g.au();
            if (au != null && au.a() != null) {
                au.a().c(e());
            }
        }
    }

    public void G() {
        if (!this.K && this.s.get()) {
            A();
            com.bytedance.sdk.openadsdk.core.g.a au = this.g.au();
            if (au != null && au.a() != null) {
                au.a().c(e());
            }
        }
    }

    public void c() {
        if (this.e != null) {
            this.e.l();
            this.e = null;
            if (this.f != null) {
                this.f.i();
            }
            this.b.removeCallbacks(this.M);
            this.b.removeCallbacksAndMessages((Object) null);
            f fVar = this.F;
            if (fVar != null) {
                fVar.d();
            }
        }
    }

    public void a(boolean z, int i) {
        c();
    }

    public void d() {
        c();
    }

    /* access modifiers changed from: private */
    public boolean M() {
        return this.g.al() == 100.0f;
    }

    /* access modifiers changed from: private */
    public void N() {
        try {
            if (H() != null && this.e != null) {
                if (this.x != null) {
                    int width = this.x.getWidth();
                    int height = this.x.getHeight();
                    float d = (float) this.e.d();
                    float e = (float) this.e.e();
                    float f = (float) width;
                    float f2 = (float) height;
                    if (d / (f * 1.0f) <= e / (1.0f * f2)) {
                        f = (f2 / e) * d;
                    } else {
                        f2 = (f / d) * e;
                    }
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f, (int) f2);
                    layoutParams.addRule(13);
                    if (H() instanceof TextureView) {
                        ((TextureView) H()).setLayoutParams(layoutParams);
                    } else if (H() instanceof SurfaceView) {
                        ((SurfaceView) H()).setLayoutParams(layoutParams);
                    }
                }
            }
        } catch (Throwable th) {
            l.c(this.a, "changeVideoSizeSupportInteraction error", th);
        }
    }

    private boolean O() {
        return H() == null || this.e == null || this.g.I() != null || this.g.B() == 1;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0122 A[Catch:{ all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x013e A[Catch:{ all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0152 A[Catch:{ all -> 0x018e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void P() {
        /*
            r17 = this;
            r7 = r17
            java.lang.String r0 = ",videoWidth="
            java.lang.String r1 = " Screen w/h == Video w/h and in other cases，use screen width and height，videoHeight="
            java.lang.String r2 = "Width and height after adaptation：videoHeight="
            java.lang.String r3 = ",VERTICAL_SCALE(9:16)=0.5625,HORIZONTAL_SCALE(16:9) =1.7777778"
            java.lang.String r4 = "video w/h,videoScale="
            java.lang.String r5 = "videoHeight="
            java.lang.String r6 = "screenHeight="
            java.lang.String r8 = "changeVideoSize start.......slot="
            java.lang.String r9 = r7.a     // Catch:{ all -> 0x018e }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x018e }
            r10.<init>(r8)     // Catch:{ all -> 0x018e }
            com.bytedance.sdk.openadsdk.core.model.q r8 = r7.g     // Catch:{ all -> 0x018e }
            com.bytedance.sdk.openadsdk.AdSlot r8 = r8.D()     // Catch:{ all -> 0x018e }
            r10.append(r8)     // Catch:{ all -> 0x018e }
            java.lang.String r8 = r10.toString()     // Catch:{ all -> 0x018e }
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r9, (java.lang.String) r8)     // Catch:{ all -> 0x018e }
            boolean r8 = r17.O()     // Catch:{ all -> 0x018e }
            if (r8 == 0) goto L_0x0030
            return
        L_0x0030:
            java.lang.String r8 = r7.a     // Catch:{ all -> 0x018e }
            java.lang.String r9 = "changeVideoSize start check condition complete ... go .."
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r8, (java.lang.String) r9)     // Catch:{ all -> 0x018e }
            android.content.Context r8 = com.bytedance.sdk.openadsdk.core.o.a()     // Catch:{ all -> 0x018e }
            int[] r8 = com.bytedance.sdk.openadsdk.utils.ad.b((android.content.Context) r8)     // Catch:{ all -> 0x018e }
            com.bytedance.sdk.openadsdk.core.model.q r9 = r7.g     // Catch:{ all -> 0x018e }
            int r9 = r9.ak()     // Catch:{ all -> 0x018e }
            r10 = 0
            r11 = 1
            if (r9 != r11) goto L_0x004b
            r9 = 1
            goto L_0x004c
        L_0x004b:
            r9 = 0
        L_0x004c:
            r12 = r8[r10]     // Catch:{ all -> 0x018e }
            float r12 = (float) r12     // Catch:{ all -> 0x018e }
            r8 = r8[r11]     // Catch:{ all -> 0x018e }
            float r8 = (float) r8     // Catch:{ all -> 0x018e }
            com.bytedance.sdk.openadsdk.core.video.c.d r13 = r7.e     // Catch:{ all -> 0x018e }
            int r13 = r13.d()     // Catch:{ all -> 0x018e }
            float r13 = (float) r13     // Catch:{ all -> 0x018e }
            com.bytedance.sdk.openadsdk.core.video.c.d r14 = r7.e     // Catch:{ all -> 0x018e }
            int r14 = r14.e()     // Catch:{ all -> 0x018e }
            float r14 = (float) r14     // Catch:{ all -> 0x018e }
            if (r9 == 0) goto L_0x0078
            int r15 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
            if (r15 <= 0) goto L_0x008e
            java.lang.String r0 = r7.a     // Catch:{ all -> 0x018e }
            java.lang.String r1 = "Separate adaptation for landscape to portrait ....."
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x018e }
            r6 = 1
            r1 = r17
            r2 = r12
            r3 = r8
            r4 = r13
            r5 = r14
            r1.a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x018e }
            return
        L_0x0078:
            int r15 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
            if (r15 >= 0) goto L_0x008e
            java.lang.String r0 = r7.a     // Catch:{ all -> 0x018e }
            java.lang.String r1 = "Separate adaptation for portrait to landscape....."
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x018e }
            r6 = 0
            r1 = r17
            r2 = r12
            r3 = r8
            r4 = r13
            r5 = r14
            r1.a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x018e }
            return
        L_0x008e:
            float r15 = r13 / r14
            float r10 = r12 / r8
            java.lang.String r11 = r7.a     // Catch:{ all -> 0x018e }
            r16 = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x018e }
            r1.<init>(r6)     // Catch:{ all -> 0x018e }
            r1.append(r8)     // Catch:{ all -> 0x018e }
            java.lang.String r6 = ",screenWidth="
            r1.append(r6)     // Catch:{ all -> 0x018e }
            r1.append(r12)     // Catch:{ all -> 0x018e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x018e }
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r11, (java.lang.String) r1)     // Catch:{ all -> 0x018e }
            java.lang.String r1 = r7.a     // Catch:{ all -> 0x018e }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x018e }
            r6.<init>(r5)     // Catch:{ all -> 0x018e }
            r6.append(r14)     // Catch:{ all -> 0x018e }
            r6.append(r0)     // Catch:{ all -> 0x018e }
            r6.append(r13)     // Catch:{ all -> 0x018e }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x018e }
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r1, (java.lang.String) r5)     // Catch:{ all -> 0x018e }
            java.lang.String r1 = r7.a     // Catch:{ all -> 0x018e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x018e }
            r5.<init>(r4)     // Catch:{ all -> 0x018e }
            r5.append(r15)     // Catch:{ all -> 0x018e }
            java.lang.String r4 = ",screen  w/h .screenScale="
            r5.append(r4)     // Catch:{ all -> 0x018e }
            r5.append(r10)     // Catch:{ all -> 0x018e }
            r5.append(r3)     // Catch:{ all -> 0x018e }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x018e }
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r1, (java.lang.String) r3)     // Catch:{ all -> 0x018e }
            r1 = 1098907648(0x41800000, float:16.0)
            r3 = 1091567616(0x41100000, float:9.0)
            if (r9 == 0) goto L_0x00f6
            r4 = 1058013184(0x3f100000, float:0.5625)
            int r5 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r5 >= 0) goto L_0x0108
            int r4 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x0108
            float r3 = r3 * r8
            float r13 = r3 / r1
            r14 = r8
            goto L_0x0106
        L_0x00f6:
            r4 = 1071877689(0x3fe38e39, float:1.7777778)
            int r5 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x0108
            int r4 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x0108
            float r3 = r3 * r12
            float r14 = r3 / r1
            r13 = r12
        L_0x0106:
            r10 = 1
            goto L_0x0109
        L_0x0108:
            r10 = 0
        L_0x0109:
            java.lang.String r1 = r7.a     // Catch:{ all -> 0x018e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x018e }
            r3.<init>(r2)     // Catch:{ all -> 0x018e }
            r3.append(r14)     // Catch:{ all -> 0x018e }
            r3.append(r0)     // Catch:{ all -> 0x018e }
            r3.append(r13)     // Catch:{ all -> 0x018e }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x018e }
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ all -> 0x018e }
            if (r10 != 0) goto L_0x013e
            java.lang.String r0 = r7.a     // Catch:{ all -> 0x018e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x018e }
            r2 = r16
            r1.<init>(r2)     // Catch:{ all -> 0x018e }
            r1.append(r8)     // Catch:{ all -> 0x018e }
            java.lang.String r2 = "，videoWidth="
            r1.append(r2)     // Catch:{ all -> 0x018e }
            r1.append(r12)     // Catch:{ all -> 0x018e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x018e }
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x018e }
            goto L_0x0140
        L_0x013e:
            r12 = r13
            r8 = r14
        L_0x0140:
            android.widget.RelativeLayout$LayoutParams r0 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x018e }
            int r1 = (int) r12     // Catch:{ all -> 0x018e }
            int r2 = (int) r8     // Catch:{ all -> 0x018e }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x018e }
            r3 = 13
            r0.addRule(r3)     // Catch:{ all -> 0x018e }
            com.bykv.vk.openvk.component.video.api.renderview.b r3 = r17.H()     // Catch:{ all -> 0x018e }
            if (r3 == 0) goto L_0x0186
            com.bykv.vk.openvk.component.video.api.renderview.b r3 = r17.H()     // Catch:{ all -> 0x018e }
            boolean r3 = r3 instanceof android.view.TextureView     // Catch:{ all -> 0x018e }
            if (r3 == 0) goto L_0x0164
            com.bykv.vk.openvk.component.video.api.renderview.b r3 = r17.H()     // Catch:{ all -> 0x018e }
            android.view.TextureView r3 = (android.view.TextureView) r3     // Catch:{ all -> 0x018e }
            r3.setLayoutParams(r0)     // Catch:{ all -> 0x018e }
            goto L_0x0175
        L_0x0164:
            com.bykv.vk.openvk.component.video.api.renderview.b r3 = r17.H()     // Catch:{ all -> 0x018e }
            boolean r3 = r3 instanceof android.view.SurfaceView     // Catch:{ all -> 0x018e }
            if (r3 == 0) goto L_0x0175
            com.bykv.vk.openvk.component.video.api.renderview.b r3 = r17.H()     // Catch:{ all -> 0x018e }
            android.view.SurfaceView r3 = (android.view.SurfaceView) r3     // Catch:{ all -> 0x018e }
            r3.setLayoutParams(r0)     // Catch:{ all -> 0x018e }
        L_0x0175:
            android.view.ViewGroup r0 = r7.x     // Catch:{ all -> 0x018e }
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()     // Catch:{ all -> 0x018e }
            if (r0 == 0) goto L_0x0186
            r0.height = r2     // Catch:{ all -> 0x018e }
            r0.width = r1     // Catch:{ all -> 0x018e }
            android.view.ViewGroup r1 = r7.x     // Catch:{ all -> 0x018e }
            r1.setLayoutParams(r0)     // Catch:{ all -> 0x018e }
        L_0x0186:
            java.lang.String r0 = r7.a     // Catch:{ all -> 0x018e }
            java.lang.String r1 = "changeVideoSize .... complete ... end !!!"
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x018e }
            goto L_0x0196
        L_0x018e:
            r0 = move-exception
            java.lang.String r1 = r7.a
            java.lang.String r2 = "changeSize error"
            com.bytedance.sdk.component.utils.l.c(r1, r2, r0)
        L_0x0196:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.c.a.P():void");
    }

    /* access modifiers changed from: private */
    public void Q() {
        try {
            if (H() == null) {
                return;
            }
            if (this.e != null) {
                boolean z = this.g.ak() == 1;
                int[] b = ad.b(com.bytedance.sdk.openadsdk.core.o.a());
                a((float) b[0], (float) b[1], (float) this.e.d(), (float) this.e.e(), z);
                l.b(this.a, "changeSize=end");
            }
        } catch (Throwable th) {
            l.a(this.a, "changeSize error", th);
        }
    }

    private void a(float f, float f2, float f3, float f4, boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        try {
            String str = this.a;
            l.b(str, "sWh=" + f + "x" + f2 + ", vWH=" + f3 + "x" + f4 + ", " + z);
            if (f3 <= 0.0f || f4 <= 0.0f) {
                f3 = (float) this.g.K().c();
                f4 = (float) this.g.K().b();
            }
            if (f4 <= 0.0f) {
                return;
            }
            if (f3 > 0.0f) {
                if (z) {
                    if (f3 >= f4) {
                        l.b(this.a, "Vertical screen mode use video width compute scale value");
                        layoutParams = new RelativeLayout.LayoutParams((int) f, (int) ((f4 * f) / f3));
                    } else {
                        return;
                    }
                } else if (f3 <= f4) {
                    l.b(this.a, "Landscape screen mode use video height compute scale value");
                    layoutParams = new RelativeLayout.LayoutParams((int) ((f3 * f2) / f4), (int) f2);
                } else {
                    return;
                }
                layoutParams.addRule(13);
                if (H() != null) {
                    if (H() instanceof TextureView) {
                        ((TextureView) H()).setLayoutParams(layoutParams);
                    } else if (H() instanceof SurfaceView) {
                        ((SurfaceView) H()).setLayoutParams(layoutParams);
                    }
                    ViewGroup.LayoutParams layoutParams2 = this.x.getLayoutParams();
                    if (b.a(com.bytedance.sdk.openadsdk.core.o.a()) && this.x.getHeight() > 0 && layoutParams2 != null) {
                        layoutParams2.width = layoutParams.width;
                        layoutParams2.height = layoutParams.height;
                        this.x.setLayoutParams(layoutParams2);
                    }
                }
            }
        } catch (Throwable th) {
            l.a(this.a, "changeSize error", th);
        }
    }

    public void a(com.bykv.vk.openvk.component.video.api.d.b bVar, View view) {
        if (this.e != null) {
            if (this.e.f()) {
                a();
                this.f.b(true, false);
                this.f.f();
            } else if (!this.e.g()) {
                if (this.f != null) {
                    this.f.c(this.x);
                }
                d(this.h);
                if (this.f != null) {
                    this.f.b(false, false);
                }
            } else {
                b();
                if (this.f != null) {
                    this.f.b(false, false);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(long j, long j2) {
        this.g.c(j);
        this.h = j;
        this.B = j2;
        final int a = com.bykv.vk.openvk.component.video.a.e.a.a(j, j2);
        final long j3 = j;
        final long j4 = j2;
        this.b.post(new Runnable() {
            public void run() {
                a.this.f.a(j3, j4);
                a.this.f.a(a);
                try {
                    if (a.this.z != null) {
                        a.this.z.a(j3, j4);
                    }
                } catch (Throwable th) {
                    l.c(a.this.a, "onProgressUpdate error: ", th);
                }
            }
        });
    }

    public com.bykv.vk.openvk.component.video.api.renderview.b H() {
        if (this.f != null) {
            return this.f.m();
        }
        return null;
    }

    public void I() {
        f fVar = this.F;
        if (fVar != null) {
            fVar.a(2);
        }
    }
}
