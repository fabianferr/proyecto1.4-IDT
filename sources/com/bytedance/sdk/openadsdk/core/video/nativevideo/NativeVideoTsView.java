package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.b.d.b.o;
import com.bytedance.sdk.openadsdk.b.g;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.g.f;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.p;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.h;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativeVideoTsView extends PAGFrameLayout implements c.a, x.a, c.a {
    /* access modifiers changed from: private */
    public static final Integer u = 0;
    private static final Integer v = 1;
    private boolean A;
    private long B;
    private final boolean C;
    private final Handler D;
    /* access modifiers changed from: private */
    public boolean E;
    private long F;
    private boolean G;
    private final String H;
    private View I;
    private c.C0035c J;
    /* access modifiers changed from: private */
    public ViewTreeObserver.OnGlobalLayoutListener K;
    private final AtomicBoolean L;
    private final Runnable M;
    private boolean N;
    private final AtomicBoolean O;
    private final ViewTreeObserver.OnScrollChangedListener P;
    protected final q a;
    protected com.bykv.vk.openvk.component.video.api.d.c b;
    protected FrameLayout c;
    protected boolean d;
    public boolean e;
    public g f;
    protected RelativeLayout g;
    protected ImageView h;
    protected ImageView i;
    protected ImageView j;
    protected boolean k;
    protected String l;
    protected int m;
    boolean n;
    public b o;
    private final Context p;
    /* access modifiers changed from: private */
    public ViewGroup q;
    private boolean r;
    private boolean s;
    private String t;
    private String w;
    private boolean x;
    private boolean y;
    private boolean z;

    public interface a {
        void a(View view, int i);
    }

    public interface b {
        void a(boolean z, long j, long j2, long j3, boolean z2);
    }

    public void setAdCreativeClickListener(a aVar) {
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
        if (cVar != null) {
            ((c) cVar).a(aVar);
        }
    }

    public void setVideoPlayCallback(b bVar) {
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
        if (cVar != null) {
            ((c) cVar).a(bVar);
        }
    }

    public void setControllerStatusCallBack(b bVar) {
        this.o = bVar;
    }

    public void a(long j2, int i2) {
        l.b("NativeVideoTsView", "onComplete() called with: totalPlayTime = [" + j2 + "], percent = [" + i2 + "]");
        c.C0035c cVar = this.J;
        if (cVar != null) {
            cVar.f_();
        }
    }

    private void d() {
        a(0, 0);
        this.J = null;
    }

    public void b(long j2, int i2) {
        l.b("NativeVideoTsView", "onError() called with: totalPlayTime = [" + j2 + "], percent = [" + i2 + "]");
    }

    public void a() {
        l.a("NativeVideoTsView", "embeded_ad", "onTimeOut、、、、、、、、");
    }

    public void a(long j2, long j3) {
        c.C0035c cVar = this.J;
        if (cVar != null) {
            cVar.a(j2, j3);
        }
    }

    public NativeVideoTsView(Context context, q qVar, boolean z2, g gVar) {
        this(context, qVar, z2, "embeded_ad", false, false, gVar);
    }

    public NativeVideoTsView(Context context, q qVar, String str, boolean z2, boolean z3, g gVar) {
        this(context, qVar, false, str, z2, z3, gVar);
    }

    public NativeVideoTsView(Context context, q qVar, g gVar) {
        this(context, qVar, false, gVar);
    }

    public NativeVideoTsView(Context context, q qVar, boolean z2, String str, boolean z3, boolean z4, g gVar) {
        super(context);
        this.r = true;
        this.d = true;
        this.s = false;
        this.e = false;
        this.x = true;
        this.y = false;
        this.z = true;
        this.k = true;
        this.l = "embeded_ad";
        this.m = 50;
        this.A = true;
        this.C = false;
        this.D = new x(com.bytedance.sdk.openadsdk.core.l.b().getLooper(), this);
        this.G = false;
        this.H = Build.MODEL;
        this.n = false;
        this.L = new AtomicBoolean(false);
        this.M = new Runnable() {
            public void run() {
                NativeVideoTsView nativeVideoTsView = NativeVideoTsView.this;
                nativeVideoTsView.a(nativeVideoTsView.E, NativeVideoTsView.u.intValue());
            }
        };
        this.N = true;
        this.O = new AtomicBoolean(false);
        this.P = new ViewTreeObserver.OnScrollChangedListener() {
            public void onScrollChanged() {
                NativeVideoTsView.this.q();
            }
        };
        try {
            if (qVar.aV()) {
                if (Build.VERSION.SDK_INT >= 23) {
                    this.w = CacheDirFactory.getICacheDir(0).b();
                } else {
                    this.w = h.a();
                }
            }
        } catch (Throwable unused) {
        }
        if (gVar != null) {
            this.f = gVar;
        }
        this.l = str;
        this.p = context;
        this.a = qVar;
        this.s = z2;
        setContentDescription("NativeVideoTsView");
        this.y = z3;
        this.z = z4;
        b();
        e();
    }

    /* access modifiers changed from: protected */
    public void b() {
        q qVar = this.a;
        if (qVar != null) {
            int aZ = qVar.aZ();
            int b2 = o.d().b(aZ);
            int c2 = com.bytedance.sdk.component.utils.o.c(o.a());
            if (b2 == 1) {
                this.r = ac.d(c2);
            } else if (b2 == 2) {
                this.r = ac.e(c2) || ac.d(c2) || ac.f(c2);
            } else if (b2 == 3) {
                this.r = false;
            } else if (b2 == 4) {
                this.n = true;
            } else if (b2 == 5) {
                this.r = ac.d(c2) || ac.f(c2);
            }
            if (this.s) {
                this.d = false;
            } else if (!this.e || !p.b(this.l)) {
                this.d = o.d().c(String.valueOf(aZ));
            }
            if ("open_ad".equals(this.l)) {
                this.r = true;
                this.d = true;
            }
            com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
            if (cVar != null) {
                cVar.d(this.r);
            }
            this.e = true;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        b bVar;
        com.bykv.vk.openvk.component.video.api.d.c cVar;
        if (!(this.s || (bVar = this.o) == null || (cVar = this.b) == null)) {
            bVar.a(cVar.o(), this.b.h(), this.b.i(), this.b.e(), this.r);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private View a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        new FrameLayout.LayoutParams(-1, -1).gravity = 17;
        frameLayout.setVisibility(8);
        this.q = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams);
        frameLayout.addView(frameLayout2);
        this.c = frameLayout2;
        View view = new View(context);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(view);
        this.I = view;
        return frameLayout;
    }

    private RelativeLayout b(Context context) {
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        pAGRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        pAGRelativeLayout.setVisibility(8);
        PAGImageView pAGImageView = new PAGImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        pAGImageView.setLayoutParams(layoutParams);
        pAGImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.h = pAGImageView;
        PAGImageView pAGImageView2 = new PAGImageView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        pAGImageView2.setLayoutParams(layoutParams2);
        pAGImageView2.setVisibility(8);
        pAGImageView2.setBackground(s.c(context, "tt_new_play_video"));
        this.j = pAGImageView2;
        pAGRelativeLayout.addView(pAGImageView);
        pAGRelativeLayout.addView(pAGImageView2);
        return pAGRelativeLayout;
    }

    private void e() {
        addView(a(this.p));
        r();
        addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            public void onViewAttachedToWindow(View view) {
                NativeVideoTsView.this.q();
            }

            public void onViewDetachedFromWindow(View view) {
                NativeVideoTsView.this.q();
            }
        });
    }

    /* access modifiers changed from: private */
    public void q() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Handler handler = this.D;
        if (handler != null && elapsedRealtime - this.F > 500) {
            this.F = elapsedRealtime;
            handler.sendEmptyMessageDelayed(1, 500);
        }
    }

    public void setVideoAdClickListenerTTNativeAd(PAGNativeAd pAGNativeAd) {
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
        if (cVar != null) {
            ((c) cVar).a(pAGNativeAd);
        }
    }

    public void g() {
        View view;
        if (this.p != null && (view = this.I) != null && view.getParent() != null && this.a != null && this.g == null) {
            ViewParent parent = this.I.getParent();
            RelativeLayout b2 = b(this.p);
            if (parent != null && (parent instanceof ViewGroup)) {
                a((View) b2, (ViewGroup) parent, this.I);
            }
            this.g = b2;
            if (this.k) {
                ad.a((View) this.j, 0);
            }
            if (!(this.a.K() == null || this.a.K().j() == null)) {
                com.bytedance.sdk.openadsdk.k.c.a().a(this.a.K().j(), this.a.K().c(), this.a.K().b(), this.h, this.a);
            }
            ImageView imageView = this.j;
            if (imageView != null) {
                imageView.setClickable(true);
                this.j.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        NativeVideoTsView.this.c();
                    }
                });
            }
        }
    }

    private void a(View view, ViewGroup viewGroup, View view2) {
        int indexOfChild = viewGroup.indexOfChild(view2);
        viewGroup.removeViewInLayout(view2);
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, indexOfChild);
        }
    }

    private void r() {
        this.b = new c(this.p, this.c, this.a, this.l, !E(), this.y, this.z, this.f);
        s();
        if (this.K == null) {
            this.K = new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (NativeVideoTsView.this.q != null && NativeVideoTsView.this.q.getViewTreeObserver() != null && NativeVideoTsView.this.b != null) {
                        ((c) NativeVideoTsView.this.b).a(NativeVideoTsView.this.q.getWidth(), NativeVideoTsView.this.q.getHeight());
                        NativeVideoTsView.this.q.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        ViewTreeObserver.OnGlobalLayoutListener unused = NativeVideoTsView.this.K = null;
                    }
                }
            };
            this.q.getViewTreeObserver().addOnGlobalLayoutListener(this.K);
        }
    }

    public void setVideoAdLoadListener(c.d dVar) {
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
        if (cVar != null) {
            cVar.a(dVar);
        }
    }

    public boolean a(long j2, boolean z2, boolean z3) {
        boolean z4 = false;
        this.q.setVisibility(0);
        this.B = j2;
        if (!E()) {
            return true;
        }
        this.b.a(false);
        q qVar = this.a;
        if (!(qVar == null || qVar.K() == null)) {
            com.bytedance.sdk.openadsdk.core.video.a.b a2 = q.a(CacheDirFactory.getICacheDir(this.a.aK()).c(), this.a);
            a2.b(this.a.Y());
            a2.a(this.q.getWidth());
            a2.b(this.q.getHeight());
            a2.c(this.a.ac());
            a2.a(j2);
            a2.a(i());
            a((com.bykv.vk.openvk.component.video.api.c.c) a2);
            if (z3) {
                this.b.b((com.bykv.vk.openvk.component.video.api.c.c) a2);
                return true;
            }
            z4 = this.b.a((com.bykv.vk.openvk.component.video.api.c.c) a2);
        }
        if (((j2 > 0 && !z2 && !z3) || (j2 > 0 && z2)) && this.b != null) {
            o.a aVar = new o.a();
            aVar.a(this.b.e());
            aVar.c(this.b.h());
            aVar.b(this.b.f());
            com.bytedance.sdk.openadsdk.b.d.a.a.b(this.b.m(), aVar);
        }
        return z4;
    }

    private void s() {
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
        if (cVar != null) {
            cVar.d(this.r);
            ((c) this.b).a((c.a) this);
            this.b.a((c.a) this);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        t();
        getViewTreeObserver().addOnScrollChangedListener(this.P);
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        t();
    }

    private void t() {
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
        if (cVar == null) {
            r();
        } else if ((cVar instanceof c) && !E()) {
            ((c) this.b).r();
        }
        if (this.b != null && this.L.get()) {
            this.L.set(false);
            b();
            if (h()) {
                ad.a((View) this.g, 8);
                ImageView imageView = this.i;
                if (imageView != null) {
                    ad.a((View) imageView, 8);
                }
                q qVar = this.a;
                if (qVar == null || qVar.K() == null) {
                    l.e("NativeVideoTsView", "attachTask materialMeta.getVideo() is null !!");
                    return;
                }
                com.bytedance.sdk.openadsdk.core.video.a.b a2 = q.a(CacheDirFactory.getICacheDir(this.a.aK()).c(), this.a);
                a2.b(this.a.Y());
                a2.a(this.q.getWidth());
                a2.b(this.q.getHeight());
                a2.c(this.a.ac());
                a2.a(0);
                a2.a(i());
                a((com.bykv.vk.openvk.component.video.api.c.c) a2);
                this.b.a((com.bykv.vk.openvk.component.video.api.c.c) a2);
                this.b.c(false);
            } else if (this.b.o()) {
                l.b("NativeVideoTsView", "attachTask-mNativeVideoController.isPlayComplete()=" + this.b.o());
                b(true);
            } else {
                l.c("NativeVideoTsView", "attachTask.......mRlImgCover.....VISIBLE");
                g();
                ad.a((View) this.g, 0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.P);
        }
        ViewGroup viewGroup = this.q;
        if (viewGroup != null && this.K != null) {
            ViewTreeObserver viewTreeObserver2 = viewGroup.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnGlobalLayoutListener(this.K);
                this.K = null;
            }
        }
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        u();
    }

    private void u() {
        this.o = null;
        if ((this.b instanceof c) && !E()) {
            ((c) this.b).F();
        }
        j();
        a(false);
        v();
    }

    private void v() {
        if (!this.L.get()) {
            this.L.set(true);
            com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
            if (cVar != null) {
                cVar.a(true, 3);
            }
        }
        this.O.set(false);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 == 4 || i2 == 8) {
            v();
        }
    }

    public void a(Message message) {
        if (message.what == 1) {
            w();
        }
    }

    private void w() {
        this.E = k();
        aa.a(this.M);
    }

    private boolean x() {
        q qVar = this.a;
        if (qVar == null) {
            return false;
        }
        return qVar.bf();
    }

    private boolean y() {
        if (E() || !x()) {
            return false;
        }
        boolean a2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", false);
        if (com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_from_detail_page", false) || a2) {
            return true;
        }
        return false;
    }

    private void z() {
        if (!E() && x()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", (Boolean) false);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_from_detail_page", (Boolean) false);
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2, int i2) {
        if (this.a != null && this.b != null) {
            boolean y2 = y();
            z();
            if (y2 && this.b.o()) {
                l.b("NativeVideoTsView", "changeVideoStatus---isFromDetailPage()=" + y2 + "，mNativeVideoController.isPlayComplete()=" + this.b.o());
                b(true);
                d();
            } else if (!z2 || !this.x || this.b.o() || this.b.k()) {
                if (this.b.l() != null && this.b.l().f()) {
                    this.b.a();
                    a(true);
                    c.C0035c cVar = this.J;
                    if (cVar != null) {
                        cVar.d_();
                    }
                }
            } else if (this.b.l() == null || !this.b.l().g()) {
                if (this.r && this.b.l() == null) {
                    if (!this.L.get()) {
                        this.L.set(true);
                    }
                    this.O.set(false);
                    t();
                }
            } else if (this.r || i2 == 1) {
                com.bykv.vk.openvk.component.video.api.d.c cVar2 = this.b;
                if (cVar2 != null) {
                    setIsQuiet(cVar2.n());
                }
                if ("ALP-AL00".equals(this.H)) {
                    this.b.b();
                } else {
                    if (!com.bytedance.sdk.openadsdk.core.h.b().o()) {
                        y2 = true;
                    }
                    ((c) this.b).h(y2);
                }
                a(false);
                c.C0035c cVar3 = this.J;
                if (cVar3 != null) {
                    cVar3.e_();
                }
            }
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        com.bykv.vk.openvk.component.video.api.d.c cVar;
        com.bykv.vk.openvk.component.video.api.d.c cVar2;
        com.bykv.vk.openvk.component.video.api.d.c cVar3;
        com.bykv.vk.openvk.component.video.api.d.c cVar4;
        if (!"open_ad".equals(this.l)) {
            this.x = z2;
            super.onWindowFocusChanged(z2);
            B();
            if (!y() || (cVar4 = this.b) == null || !cVar4.o()) {
                b();
                if (E() || !h() || (cVar2 = this.b) == null || cVar2.k()) {
                    if (h()) {
                        return;
                    }
                    if (!z2 && (cVar = this.b) != null && cVar.l() != null && this.b.l().f()) {
                        A();
                        a(false, u.intValue());
                    } else if (z2) {
                        this.D.obtainMessage(1).sendToTarget();
                    }
                } else if (this.D == null) {
                } else {
                    if (!z2 || (cVar3 = this.b) == null || cVar3.o()) {
                        A();
                        a(false, u.intValue());
                        return;
                    }
                    this.D.obtainMessage(1).sendToTarget();
                }
            } else {
                z();
                ad.a((View) this.g, 8);
                b(true);
                d();
            }
        } else {
            A();
        }
    }

    private void A() {
        this.D.removeMessages(1);
        com.bytedance.sdk.openadsdk.core.l.c().removeCallbacks(this.M);
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i2) {
        com.bykv.vk.openvk.component.video.api.d.c cVar;
        q qVar;
        com.bykv.vk.openvk.component.video.api.d.c cVar2;
        com.bykv.vk.openvk.component.video.api.d.c cVar3;
        super.onWindowVisibilityChanged(i2);
        B();
        if (this.N) {
            this.N = i2 == 0;
        }
        if (!y() || (cVar3 = this.b) == null || !cVar3.o()) {
            b();
            if (!E() && h() && (cVar = this.b) != null && !cVar.k() && (qVar = this.a) != null) {
                if (!this.A || qVar.K() == null) {
                    l.e("NativeVideoTsView", "attachTask materialMeta.getVideo() is null !!");
                } else {
                    this.a.K();
                    com.bytedance.sdk.openadsdk.core.video.a.b a2 = q.a(CacheDirFactory.getICacheDir(this.a.aK()).c(), this.a);
                    a2.b(this.a.Y());
                    a2.a(this.q.getWidth());
                    a2.b(this.q.getHeight());
                    a2.c(this.a.ac());
                    a2.a(this.B);
                    a2.a(i());
                    a((com.bykv.vk.openvk.component.video.api.c.c) a2);
                    this.b.a((com.bykv.vk.openvk.component.video.api.c.c) a2);
                    this.A = false;
                    ad.a((View) this.g, 8);
                }
                if (i2 == 0 && this.D != null && (cVar2 = this.b) != null && !cVar2.o()) {
                    this.D.obtainMessage(1).sendToTarget();
                    return;
                }
                return;
            }
            return;
        }
        z();
        ad.a((View) this.g, 8);
        b(true);
        d();
    }

    private void B() {
        boolean z2 = false;
        if (!(this.b == null || E() || (x() && !com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", false)))) {
            long h2 = this.b.h() + this.b.f();
            long h3 = this.b.h();
            long j2 = 0;
            if (x()) {
                boolean a2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", false);
                j2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_current_play_position", 0);
                h2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_total_play_duration", this.b.h() + this.b.f());
                h3 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_duration", this.b.h());
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", (Boolean) false);
                this.b.c(a2);
                this.b.a(j2);
                this.b.b(h2);
                this.b.c(h3);
                z2 = a2;
            }
            l.e("MultiProcess", "onResumeFeedNativeVideoControllerData-isComplete=" + z2 + ",position=" + j2 + ",totalPlayDuration=" + h2 + ",duration=" + h3);
        }
    }

    public com.bykv.vk.openvk.component.video.api.d.c getNativeVideoController() {
        return this.b;
    }

    public boolean h() {
        return this.r;
    }

    public void setIsAutoPlay(boolean z2) {
        if (!this.G) {
            int b2 = com.bytedance.sdk.openadsdk.core.o.d().b(this.a.aZ());
            if (z2 && b2 != 4 && (!com.bytedance.sdk.component.utils.o.e(this.p) ? !(!com.bytedance.sdk.component.utils.o.f(this.p) ? com.bytedance.sdk.component.utils.o.d(this.p) : C() || D()) : !C())) {
                z2 = false;
            }
            this.r = z2;
            com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
            if (cVar != null) {
                cVar.d(z2);
            }
            if (!this.r) {
                g();
                RelativeLayout relativeLayout = this.g;
                if (relativeLayout != null) {
                    ad.a((View) relativeLayout, 0);
                    q qVar = this.a;
                    if (!(qVar == null || qVar.K() == null)) {
                        com.bytedance.sdk.openadsdk.k.c.a().a(this.a.K().j(), this.a.K().c(), this.a.K().b(), this.h, this.a);
                    }
                }
            } else {
                ad.a((View) this.g, 8);
            }
            this.G = true;
        }
    }

    private boolean C() {
        return 2 == com.bytedance.sdk.openadsdk.core.o.d().b(this.a.aZ());
    }

    private boolean D() {
        return 5 == com.bytedance.sdk.openadsdk.core.o.d().b(this.a.aZ());
    }

    public boolean i() {
        return this.d;
    }

    public void setIsQuiet(boolean z2) {
        this.d = z2;
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
        if (cVar != null) {
            cVar.b(z2);
        }
    }

    private boolean E() {
        return this.s;
    }

    public void setVideoAdInteractionListener(c.C0035c cVar) {
        this.J = cVar;
    }

    public void f() {
        c.C0035c cVar = this.J;
        if (cVar != null) {
            cVar.a_();
        }
    }

    public void setNeedNativeVideoPlayBtnVisible(boolean z2) {
        this.k = z2;
    }

    public void a(int i2) {
        b();
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (!l()) {
            n();
        }
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2) {
        if (this.i == null) {
            this.i = new ImageView(getContext());
            if (com.bytedance.sdk.openadsdk.core.h.b().p() != null) {
                this.i.setImageBitmap(com.bytedance.sdk.openadsdk.core.h.b().p());
            } else {
                this.i.setImageResource(s.d(com.bytedance.sdk.openadsdk.core.o.a(), "tt_new_play_video"));
            }
            this.i.setScaleType(ImageView.ScaleType.FIT_XY);
            int b2 = ad.b(getContext(), (float) this.m);
            int b3 = ad.b(getContext(), 10.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b2, b2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = b3;
            layoutParams.bottomMargin = b3;
            this.q.addView(this.i, layoutParams);
            this.i.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    NativeVideoTsView.this.n();
                }
            });
        }
        if (z2) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
    }

    public void b(boolean z2) {
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
        if (cVar != null) {
            cVar.c(z2);
            com.bykv.vk.openvk.component.video.api.d.b m2 = this.b.m();
            if (m2 != null) {
                m2.b();
                View c2 = m2.c();
                if (c2 != null) {
                    if (c2.getParent() != null) {
                        ((ViewGroup) c2.getParent()).removeView(c2);
                    }
                    c2.setVisibility(0);
                    addView(c2);
                    m2.a(this.a, new WeakReference(this.p), false);
                }
            }
        }
    }

    public void j() {
        com.bykv.vk.openvk.component.video.api.d.b m2;
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
        if (cVar != null && (m2 = cVar.m()) != null) {
            m2.a();
            View c2 = m2.c();
            if (c2 != null) {
                c2.setVisibility(8);
                if (c2.getParent() != null) {
                    ((ViewGroup) c2.getParent()).removeView(c2);
                }
            }
        }
    }

    private void F() {
        ad.e((View) this.i);
        ad.e((View) this.g);
    }

    public void setVideoCacheUrl(String str) {
        this.t = str;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return y.a(this, 50, p.b(this.l) ? 1 : 5);
    }

    public boolean l() {
        boolean z2 = false;
        if (com.bytedance.sdk.component.utils.o.c(com.bytedance.sdk.openadsdk.core.o.a()) == 0) {
            return false;
        }
        if (this.b.l() != null && this.b.l().f()) {
            a(false, u.intValue());
            Handler handler = this.D;
            z2 = true;
            if (handler != null) {
                handler.removeMessages(1);
            }
        }
        return z2;
    }

    public void m() {
        if (getNativeVideoController() != null && (getNativeVideoController() instanceof c)) {
            c cVar = (c) getNativeVideoController();
            cVar.a((com.bykv.vk.openvk.component.video.api.d.b) cVar.m(), (View) this);
        }
    }

    public void n() {
        if (com.bytedance.sdk.component.utils.o.c(com.bytedance.sdk.openadsdk.core.o.a()) == 0 || !k()) {
            return;
        }
        if (this.b.l() != null && this.b.l().g()) {
            a(true, v.intValue());
            b();
            Handler handler = this.D;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(1, 500);
            }
        } else if (!h() && !this.O.get()) {
            this.O.set(true);
            F();
            q qVar = this.a;
            if (!(qVar == null || qVar.K() == null)) {
                F();
                this.a.K();
                com.bytedance.sdk.openadsdk.core.video.a.b a2 = q.a(CacheDirFactory.getICacheDir(this.a.aK()).c(), this.a);
                a2.b(this.a.Y());
                a2.a(this.q.getWidth());
                a2.b(this.q.getHeight());
                a2.c(this.a.ac());
                a2.a(this.B);
                a2.a(i());
                a2.a(CacheDirFactory.getICacheDir(this.a.aK()).c());
                a((com.bykv.vk.openvk.component.video.api.c.c) a2);
                this.b.a((com.bykv.vk.openvk.component.video.api.c.c) a2);
            }
            Handler handler2 = this.D;
            if (handler2 != null) {
                handler2.sendEmptyMessageDelayed(1, 500);
            }
            a(false);
        }
    }

    public double getCurrentPlayTime() {
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
        if (cVar == null) {
            return 0.0d;
        }
        double e2 = (double) cVar.e();
        Double.isNaN(e2);
        return (e2 * 1.0d) / 1000.0d;
    }

    public void o() {
        q qVar = this.a;
        if (qVar != null && qVar.au() != null) {
            this.a.au().o();
            this.a.au().a().e(this.B);
        }
    }

    public f a(List<Pair<View, FriendlyObstructionPurpose>> list) {
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
        if (cVar instanceof c) {
            return ((c) cVar).a((View) this, list);
        }
        return null;
    }

    private void a(com.bykv.vk.openvk.component.video.api.c.c cVar) {
        try {
            if (this.a.aV()) {
                cVar.a(this.w);
            }
        } catch (Throwable unused) {
        }
    }
}
