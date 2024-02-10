package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.b.f;
import com.bytedance.sdk.component.adexpress.b.h;
import com.bytedance.sdk.component.adexpress.b.i;
import com.bytedance.sdk.component.adexpress.b.j;
import com.bytedance.sdk.component.adexpress.b.l;
import com.bytedance.sdk.component.adexpress.b.m;
import com.bytedance.sdk.component.adexpress.b.n;
import com.bytedance.sdk.component.adexpress.b.o;
import com.bytedance.sdk.component.adexpress.b.p;
import com.bytedance.sdk.component.adexpress.dynamic.d;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.b.c.e;
import com.bytedance.sdk.openadsdk.b.g;
import com.bytedance.sdk.openadsdk.core.b.a;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.bannerexpress.VastBannerBackupView;
import com.bytedance.sdk.openadsdk.core.bannerexpress.a;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.dislike.b;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class NativeExpressView extends PAGFrameLayout implements h, o, d, a.C0061a, l {
    public static int p = 500;
    /* access modifiers changed from: private */
    public float A;
    private e B;
    private String C;
    private a.C0062a D;
    private final AtomicBoolean E = new AtomicBoolean(false);
    private b F;
    private final ViewTreeObserver.OnScrollChangedListener G = new ViewTreeObserver.OnScrollChangedListener() {
        public void onScrollChanged() {
            NativeExpressView.this.v();
            NativeExpressView nativeExpressView = NativeExpressView.this;
            nativeExpressView.removeCallbacks(nativeExpressView.H);
            NativeExpressView nativeExpressView2 = NativeExpressView.this;
            nativeExpressView2.postDelayed(nativeExpressView2.H, 500);
        }
    };
    /* access modifiers changed from: private */
    public final Runnable H = new Runnable() {
        public void run() {
            if (y.a(NativeExpressView.this, 0, 5)) {
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.d(nativeExpressView.getVisibility());
                return;
            }
            NativeExpressView.this.d(8);
        }
    };
    private final Runnable I = new Runnable() {
        public void run() {
            NativeExpressView.this.d(0);
        }
    };
    private final Runnable J = new Runnable() {
        public void run() {
            NativeExpressView.this.d(8);
        }
    };
    private ThemeStatusBroadcastReceiver K;
    private p L;
    private j.a M;
    private List<j> N;
    private p O;
    private f P;
    private i Q;
    private m R;
    private int S = 8;
    private final SparseArray<c.a> T = new SparseArray<>();
    private float U = -1.0f;
    private float V = -1.0f;
    private float W = -1.0f;
    private boolean a = true;
    private float aa = -1.0f;
    private long ab = 0;
    private VastBannerBackupView ac;
    private int b = 0;
    private b c;
    private TTDislikeDialogAbstract d;
    private PAGBannerAdWrapperListener e;
    private f f;
    protected final Context g;
    protected String h = "embeded_ad";
    protected AdSlot i;
    /* access modifiers changed from: protected */
    public q j;
    public FrameLayout k;
    protected boolean l;
    protected boolean m = false;
    protected com.bytedance.sdk.component.adexpress.b.c n;
    protected boolean o = false;
    public boolean q = false;
    int r = -1;
    boolean s;
    public g t = new g();
    long u = 0;
    protected com.bytedance.sdk.component.adexpress.b.b v;
    public com.bytedance.sdk.component.adexpress.b.d<? extends View> w;
    private g x;
    private String y = null;
    /* access modifiers changed from: private */
    public float z;

    public void a() {
    }

    public void a(int i2) {
    }

    /* access modifiers changed from: protected */
    public void a(m.a aVar) {
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject) {
    }

    public void a(boolean z2) {
    }

    /* access modifiers changed from: protected */
    public boolean a(n nVar) {
        return true;
    }

    public void b() {
    }

    public void b(int i2) {
    }

    public long c() {
        return 0;
    }

    public int d() {
        return 0;
    }

    public void e() {
    }

    public void f() {
    }

    public void setTimeUpdate(int i2) {
    }

    public g getAdShowTime() {
        return this.t;
    }

    public void setClosedListenerKey(String str) {
        this.C = str;
        b bVar = this.F;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    public String getClosedListenerKey() {
        return this.C;
    }

    public void setBannerClickClosedListener(a.C0062a aVar) {
        this.D = aVar;
    }

    public NativeExpressView(Context context, q qVar, AdSlot adSlot, String str) {
        super(context);
        this.h = str;
        this.g = context;
        this.j = qVar;
        this.i = adSlot;
        this.q = false;
        g();
    }

    public NativeExpressView(Context context, q qVar, AdSlot adSlot, String str, boolean z2) {
        super(context);
        this.h = str;
        this.g = context;
        this.j = qVar;
        this.i = adSlot;
        this.q = z2;
        g();
    }

    /* access modifiers changed from: protected */
    public void g() {
        this.K = new ThemeStatusBroadcastReceiver();
        AdSlot adSlot = this.i;
        if (adSlot != null) {
            this.z = adSlot.getExpressViewAcceptedWidth();
            this.A = this.i.getExpressViewAcceptedHeight();
            h();
            this.y = this.i.getCodeId();
            if (TextUtils.equals(this.h, "fullscreen_interstitial_ad")) {
                this.r = com.bytedance.sdk.openadsdk.core.o.d().q(this.y);
            } else if (TextUtils.equals(this.h, "rewarded_video")) {
                this.r = com.bytedance.sdk.openadsdk.core.o.d().j(this.y);
            } else if (TextUtils.equals(this.h, "open_ad")) {
                int t2 = com.bytedance.sdk.openadsdk.core.o.d().t(this.y);
                this.r = t2;
                if (t2 < 0) {
                    this.r = 5;
                }
            }
        }
        setBackgroundColor(0);
        if (this.j.av()) {
            this.F = new b(this.g, this, this.j, this.h);
            return;
        }
        q();
        this.N = new ArrayList();
        r();
        p pVar = this.O;
        if (pVar != null) {
            this.L = (p) pVar.d();
        }
        x jsObject = getJsObject();
        if (jsObject != null) {
            jsObject.g(this.h);
        }
    }

    private void h() {
        q.a I2 = this.j.I();
        if (TextUtils.equals(this.h, "embeded_ad") && I2 != null) {
            String k2 = I2.k();
            if (!TextUtils.isEmpty(k2)) {
                try {
                    JSONObject jSONObject = new JSONObject(k2);
                    int optInt = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                    int optInt2 = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                    if (optInt != 0 && optInt2 != 0) {
                        this.A = (float) optInt2;
                        this.z = (float) optInt;
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public SSWebView getWebView() {
        p pVar = this.L;
        if (pVar == null) {
            return null;
        }
        return pVar.a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void q() {
        /*
            r11 = this;
            com.bytedance.sdk.openadsdk.b.o r0 = new com.bytedance.sdk.openadsdk.b.o
            java.lang.String r1 = r11.h
            com.bytedance.sdk.openadsdk.core.model.q r2 = r11.j
            r3 = 1
            r0.<init>(r3, r1, r2)
            r11.B = r0
            com.bytedance.sdk.openadsdk.core.nativeexpress.k r1 = new com.bytedance.sdk.openadsdk.core.nativeexpress.k
            java.lang.String r2 = r11.h
            com.bytedance.sdk.openadsdk.core.model.q r4 = r11.j
            java.lang.String r5 = r11.y
            r1.<init>(r0, r2, r4, r5)
            r11.Q = r1
            r0 = 0
            r2 = 0
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0049 }
            com.bytedance.sdk.openadsdk.core.model.q r5 = r11.j     // Catch:{ Exception -> 0x0049 }
            com.bytedance.sdk.openadsdk.core.model.q$a r5 = r5.I()     // Catch:{ Exception -> 0x0049 }
            java.lang.String r5 = r5.j()     // Catch:{ Exception -> 0x0049 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r5 = "render_delay_time"
            long r4 = r4.optLong(r5)     // Catch:{ Exception -> 0x0049 }
            com.bytedance.sdk.openadsdk.core.model.q r6 = r11.j     // Catch:{ Exception -> 0x0047 }
            boolean r6 = com.bytedance.sdk.openadsdk.core.model.q.c((com.bytedance.sdk.openadsdk.core.model.q) r6)     // Catch:{ Exception -> 0x0047 }
            if (r6 != 0) goto L_0x004b
            com.bytedance.sdk.openadsdk.core.settings.e r6 = com.bytedance.sdk.openadsdk.core.o.d()     // Catch:{ Exception -> 0x0047 }
            java.lang.String r7 = r11.y     // Catch:{ Exception -> 0x0047 }
            int r6 = r6.l(r7)     // Catch:{ Exception -> 0x0047 }
            if (r6 != r3) goto L_0x004b
            r6 = 1
            goto L_0x004c
        L_0x0047:
            goto L_0x004b
        L_0x0049:
            r4 = r0
        L_0x004b:
            r6 = 0
        L_0x004c:
            long r0 = java.lang.Math.max(r4, r0)
            r4 = 10000(0x2710, double:4.9407E-320)
            long r0 = java.lang.Math.min(r0, r4)
            int r4 = r11.getRenderTimeout()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "initRenderRequest: renderTimeout="
            r5.<init>(r7)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            java.lang.String r7 = "NativeExpressView"
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r7, (java.lang.String) r5)
            com.bytedance.sdk.openadsdk.core.model.q r5 = r11.j
            com.bykv.vk.openvk.component.video.api.c.b r5 = r5.K()
            if (r5 == 0) goto L_0x0090
            com.bytedance.sdk.openadsdk.core.model.q r5 = r11.j
            com.bykv.vk.openvk.component.video.api.c.b r5 = r5.K()
            double r7 = r5.f()
            com.bytedance.sdk.openadsdk.core.model.q r5 = r11.j
            com.bykv.vk.openvk.component.video.api.c.b r5 = r5.K()
            int r5 = r5.w()
            double r9 = (double) r5
            java.lang.Double.isNaN(r9)
            double r7 = r7 * r9
            goto L_0x0092
        L_0x0090:
            r7 = 0
        L_0x0092:
            int r5 = r11.r
            r9 = -1
            if (r5 == r9) goto L_0x009b
            int r9 = (int) r7
            if (r5 >= r9) goto L_0x009b
            goto L_0x009c
        L_0x009b:
            r3 = 0
        L_0x009c:
            r11.s = r3
            com.bytedance.sdk.component.adexpress.b.m$a r2 = new com.bytedance.sdk.component.adexpress.b.m$a
            r2.<init>()
            java.lang.String r3 = r11.h
            com.bytedance.sdk.component.adexpress.b.m$a r2 = r2.a((java.lang.String) r3)
            com.bytedance.sdk.openadsdk.core.model.q r3 = r11.j
            java.lang.String r3 = r3.Y()
            com.bytedance.sdk.component.adexpress.b.m$a r2 = r2.b((java.lang.String) r3)
            com.bytedance.sdk.openadsdk.core.model.q r3 = r11.j
            java.lang.String r3 = r3.bb()
            com.bytedance.sdk.component.adexpress.b.m$a r2 = r2.c((java.lang.String) r3)
            com.bytedance.sdk.openadsdk.core.model.q r3 = r11.j
            java.lang.String r3 = r3.ac()
            com.bytedance.sdk.component.adexpress.b.m$a r2 = r2.d((java.lang.String) r3)
            com.bytedance.sdk.component.adexpress.b.i r3 = r11.Q
            com.bytedance.sdk.component.adexpress.b.m$a r2 = r2.a((com.bytedance.sdk.component.adexpress.b.i) r3)
            com.bytedance.sdk.openadsdk.core.model.q r3 = r11.j
            int r3 = r3.aD()
            com.bytedance.sdk.component.adexpress.b.m$a r2 = r2.d((int) r3)
            com.bytedance.sdk.component.adexpress.b.m$a r2 = r2.a((int) r4)
            com.bytedance.sdk.openadsdk.core.model.q r3 = r11.j
            boolean r3 = r3.an()
            com.bytedance.sdk.component.adexpress.b.m$a r2 = r2.b((boolean) r3)
            com.bytedance.sdk.openadsdk.core.model.q r3 = r11.j
            int r3 = r3.A()
            com.bytedance.sdk.component.adexpress.b.m$a r2 = r2.b((int) r3)
            com.bytedance.sdk.component.adexpress.b.m$a r0 = r2.a((long) r0)
            com.bytedance.sdk.openadsdk.core.model.q r1 = r11.j
            int r1 = r1.M()
            com.bytedance.sdk.component.adexpress.b.m$a r0 = r0.c((int) r1)
            com.bytedance.sdk.openadsdk.core.model.q r1 = r11.j
            java.util.Map r1 = com.bytedance.sdk.openadsdk.core.nativeexpress.a.b.a((com.bytedance.sdk.openadsdk.core.model.q) r1)
            com.bytedance.sdk.component.adexpress.b.m$a r0 = r0.a((java.util.Map<java.lang.String, java.lang.String>) r1)
            com.bytedance.sdk.component.adexpress.b.m$a r0 = r0.c((boolean) r6)
            int r1 = r11.r
            com.bytedance.sdk.component.adexpress.b.m$a r0 = r0.e((int) r1)
            boolean r1 = r11.s
            com.bytedance.sdk.component.adexpress.b.m$a r0 = r0.a((boolean) r1)
            com.bytedance.sdk.component.adexpress.b.m$a r0 = r0.a((double) r7)
            com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView$5 r1 = new com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView$5
            r1.<init>()
            com.bytedance.sdk.component.adexpress.b.m$a r0 = r0.a((com.bytedance.sdk.component.adexpress.b.e) r1)
            r11.a((com.bytedance.sdk.component.adexpress.b.m.a) r0)
            com.bytedance.sdk.component.adexpress.b.m r0 = r0.a()
            r11.R = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.q():void");
    }

    /* access modifiers changed from: protected */
    public int getRenderTimeout() {
        return com.bytedance.sdk.openadsdk.core.o.d().B();
    }

    private void r() {
        if (this.j.aS() == 1 && this.j.at()) {
            f fVar = new f(this.g, this.R, new n(this, this.K, this.R));
            this.P = fVar;
            this.N.add(fVar);
            this.M = new l(this.N, this.Q);
        } else if (z()) {
            s();
        } else {
            try {
                t();
                p pVar = new p(this.g, this.R, this.K, this.B, this.j);
                this.L = pVar;
                p pVar2 = new p(this.g, this.R, pVar, this);
                this.O = pVar2;
                this.N.add(pVar2);
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.l.c("NativeExpressView", "NativeExpressView dynamicRender fail", e2);
            }
            f fVar2 = new f(this.g, this.R, new n(this, this.K, this.R));
            this.P = fVar2;
            this.N.add(fVar2);
            this.M = new l(this.N, this.Q);
        }
    }

    private void s() {
        this.b = this.j.x();
        try {
            t();
            u();
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.l.c("NativeExpressView", "NativeExpressView dynamicRender fail", e2);
        }
        boolean z2 = true;
        if (this.j.y() != 1) {
            z2 = false;
        }
        this.a = z2;
        if (z2) {
            f fVar = new f(this.g, this.R, new n(this, this.K, this.R));
            this.P = fVar;
            this.N.add(fVar);
        }
        com.bytedance.sdk.component.utils.l.b("NativeExpressView", "initRender: mRenderSequenceType is " + this.b + ", mInterceptors is " + this.N);
        this.M = new l(this.N, this.Q);
    }

    private void t() {
        if (!com.bytedance.sdk.openadsdk.core.l.e()) {
            j.a();
        }
    }

    private void u() {
        com.bytedance.sdk.openadsdk.core.c.a.a aVar = new com.bytedance.sdk.openadsdk.core.c.a.a();
        if (this.b != 3) {
            p pVar = new p(this.g, this.R, this.K, this.B, this.j);
            this.L = pVar;
            p pVar2 = new p(this.g, this.R, pVar, this);
            this.O = pVar2;
            this.N.add(pVar2);
            return;
        }
        com.bytedance.sdk.component.adexpress.dynamic.c.f fVar = new com.bytedance.sdk.component.adexpress.dynamic.c.f();
        Context applicationContext = this.g.getApplicationContext();
        m mVar = this.R;
        ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver = this.K;
        boolean z2 = this.q;
        com.bytedance.sdk.component.adexpress.b.b bVar = new com.bytedance.sdk.component.adexpress.b.b(applicationContext, mVar, themeStatusBroadcastReceiver, z2, fVar, this, aVar, new d(this.g, themeStatusBroadcastReceiver, z2, fVar, mVar, aVar));
        this.v = bVar;
        this.N.add(bVar);
    }

    public void setOuterDislike(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        BackupView backupView;
        com.bytedance.sdk.component.adexpress.b.d<? extends View> dVar = this.w;
        if (!(dVar == null || !(dVar instanceof n) || (backupView = (BackupView) dVar.e()) == null)) {
            backupView.setDislikeOuter(tTDislikeDialogAbstract);
        }
        b bVar = this.F;
        if (bVar != null) {
            bVar.a(tTDislikeDialogAbstract);
        }
        this.d = tTDislikeDialogAbstract;
    }

    public void setDislike(b bVar) {
        BackupView backupView;
        com.bytedance.sdk.component.adexpress.b.d<? extends View> dVar = this.w;
        if (!(dVar == null || !(dVar instanceof n) || (backupView = (BackupView) dVar.e()) == null)) {
            backupView.setDislikeInner(bVar);
        }
        b bVar2 = this.F;
        if (bVar2 != null) {
            bVar2.a((t) bVar);
        }
        this.c = bVar;
    }

    public void setExpressInteractionListener(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        this.e = pAGBannerAdWrapperListener;
        b bVar = this.F;
        if (bVar != null) {
            bVar.a(pAGBannerAdWrapperListener);
        }
    }

    public void setClickCreativeListener(f fVar) {
        this.f = fVar;
        if (fVar != null) {
            fVar.a((a.C0061a) this);
        }
    }

    public f getClickCreativeListener() {
        return this.f;
    }

    public g getClickListener() {
        return this.x;
    }

    public void setClickListener(g gVar) {
        this.x = gVar;
    }

    public void setBackupListener(com.bytedance.sdk.component.adexpress.b.c cVar) {
        this.n = cVar;
        f fVar = this.P;
        if (fVar != null) {
            fVar.a(cVar);
        }
    }

    public void i() {
        com.bytedance.sdk.component.adexpress.b.d<? extends View> dVar = this.w;
        if (dVar instanceof p) {
            if (dVar != null) {
                ((p) dVar).j();
            } else {
                return;
            }
        }
        q qVar = this.j;
        if (qVar != null && qVar.au() != null && this.j.au().a() != null) {
            this.j.au().a().a(0);
        }
    }

    public void d(int i2) {
        com.bytedance.sdk.component.adexpress.b.d<? extends View> dVar = this.w;
        if (dVar != null && (dVar instanceof p)) {
            ((p) dVar).a(i2);
            this.S = i2;
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        removeCallbacks(this.J);
        removeCallbacks(this.I);
        if (i2 == 0) {
            postDelayed(this.I, 50);
        } else {
            postDelayed(this.J, 50);
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (Build.VERSION.SDK_INT < 28) {
            onWindowVisibilityChanged(z2 ? getVisibility() : 8);
        }
        v();
        if (z2) {
            com.bytedance.sdk.openadsdk.n.a.e.a(this.j, 4);
        } else {
            com.bytedance.sdk.openadsdk.n.a.e.a(this.j, 8);
        }
    }

    /* access modifiers changed from: private */
    public void v() {
        if (this.E.get()) {
            this.t.a(System.currentTimeMillis(), y.a(this));
        }
    }

    public void j() {
        this.u = SystemClock.elapsedRealtime();
        if (this.j.av()) {
            b bVar = this.F;
            if (bVar == null) {
                a_(106);
                return;
            }
            bVar.a((o) this);
            this.F.a();
            return;
        }
        this.B.a();
        j.a aVar = this.M;
        if (aVar != null) {
            aVar.a((o) this);
        }
        try {
            this.M.a();
        } catch (Throwable unused) {
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i2;
        f fVar = this.f;
        if (fVar != null) {
            fVar.b(motionEvent.getDeviceId());
            this.f.a(motionEvent.getSource());
            this.f.c(motionEvent.getToolType(0));
        }
        g gVar = this.x;
        if (gVar != null) {
            gVar.b(motionEvent.getDeviceId());
            this.x.a(motionEvent.getSource());
            this.x.c(motionEvent.getToolType(0));
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.U = motionEvent.getRawX();
            this.V = motionEvent.getRawY();
            this.ab = System.currentTimeMillis();
            i2 = 0;
        } else if (actionMasked == 1) {
            i2 = 3;
        } else if (actionMasked != 2) {
            i2 = actionMasked != 3 ? -1 : 4;
        } else {
            this.W += Math.abs(motionEvent.getX() - this.U);
            this.aa += Math.abs(motionEvent.getY() - this.V);
            this.U = motionEvent.getX();
            this.V = motionEvent.getY();
            i2 = (System.currentTimeMillis() - this.ab <= 200 || (this.W <= 8.0f && this.aa <= 8.0f)) ? 2 : 1;
        }
        SparseArray<c.a> sparseArray = this.T;
        if (sparseArray != null) {
            sparseArray.put(motionEvent.getActionMasked(), new c.a(i2, (double) motionEvent.getSize(), (double) motionEvent.getPressure(), System.currentTimeMillis()));
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARNING: type inference failed for: r24v0, types: [android.view.View] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.view.View r24, int r25, com.bytedance.sdk.component.adexpress.c r26) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            r3 = -1
            if (r2 == r3) goto L_0x01d7
            if (r26 != 0) goto L_0x000d
            goto L_0x01d7
        L_0x000d:
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            com.bytedance.sdk.openadsdk.core.model.q r4 = r0.j
            boolean r4 = com.bytedance.sdk.openadsdk.core.model.t.k(r4)
            java.lang.String r5 = "click_scence"
            r6 = 1
            if (r4 == 0) goto L_0x0026
            r4 = 3
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.put(r5, r4)
            goto L_0x002d
        L_0x0026:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
            r3.put(r5, r4)
        L_0x002d:
            r4 = r26
            com.bytedance.sdk.openadsdk.core.model.m r4 = (com.bytedance.sdk.openadsdk.core.model.m) r4
            com.bytedance.sdk.openadsdk.core.nativeexpress.f r5 = r0.f
            if (r5 == 0) goto L_0x0041
            int r7 = r23.getDynamicShowType()
            r5.d((int) r7)
            com.bytedance.sdk.openadsdk.core.nativeexpress.f r5 = r0.f
            r5.a((java.util.Map<java.lang.String, java.lang.Object>) r3)
        L_0x0041:
            com.bytedance.sdk.openadsdk.core.nativeexpress.g r5 = r0.x
            if (r5 == 0) goto L_0x0051
            int r7 = r23.getDynamicShowType()
            r5.d((int) r7)
            com.bytedance.sdk.openadsdk.core.nativeexpress.g r5 = r0.x
            r5.a((java.util.Map<java.lang.String, java.lang.Object>) r3)
        L_0x0051:
            float r9 = r4.a
            float r10 = r4.b
            float r11 = r4.c
            float r12 = r4.d
            boolean r14 = r4.o
            android.util.SparseArray<com.bytedance.sdk.openadsdk.core.b.c$a> r3 = r4.n
            if (r3 == 0) goto L_0x0065
            int r5 = r3.size()
            if (r5 != 0) goto L_0x0067
        L_0x0065:
            android.util.SparseArray<com.bytedance.sdk.openadsdk.core.b.c$a> r3 = r0.T
        L_0x0067:
            r13 = r3
            java.lang.String r3 = r4.k
            r5 = 0
            if (r1 != 0) goto L_0x006f
            r8 = r0
            goto L_0x0076
        L_0x006f:
            if (r1 == r0) goto L_0x0075
            org.json.JSONObject r5 = a((android.view.View) r24)
        L_0x0075:
            r8 = r1
        L_0x0076:
            if (r4 == 0) goto L_0x0082
            r4.l = r2
            if (r5 == 0) goto L_0x0082
            org.json.JSONObject r1 = r4.m
            if (r1 != 0) goto L_0x0082
            r4.m = r5
        L_0x0082:
            switch(r2) {
                case 1: goto L_0x0195;
                case 2: goto L_0x0164;
                case 3: goto L_0x0149;
                case 4: goto L_0x009f;
                case 5: goto L_0x0097;
                case 6: goto L_0x0092;
                case 7: goto L_0x0087;
                default: goto L_0x0085;
            }
        L_0x0085:
            goto L_0x01d7
        L_0x0087:
            android.content.Context r1 = r0.g
            com.bytedance.sdk.openadsdk.core.model.q r2 = r0.j
            java.lang.String r3 = r0.h
            com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.a(r1, r2, r3)
            goto L_0x01d7
        L_0x0092:
            r23.a()
            goto L_0x01d7
        L_0x0097:
            boolean r1 = r0.q
            r1 = r1 ^ r6
            r0.a((boolean) r1)
            goto L_0x01d7
        L_0x009f:
            android.widget.FrameLayout r1 = r0.k
            if (r1 == 0) goto L_0x00b6
            r15 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            android.view.MotionEvent r2 = android.view.MotionEvent.obtain(r15, r17, r19, r20, r21, r22)
            r1.dispatchTouchEvent(r2)
        L_0x00b6:
            com.bytedance.sdk.openadsdk.core.model.q r1 = r0.j
            if (r1 == 0) goto L_0x00c3
            int r1 = r1.q()
            if (r1 != r6) goto L_0x00c3
            if (r14 != 0) goto L_0x00c3
            return
        L_0x00c3:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Creativity....mAdType="
            r1.<init>(r2)
            java.lang.String r2 = r0.h
            r1.append(r2)
            java.lang.String r2 = ",!mVideoPause="
            r1.append(r2)
            boolean r2 = r0.l
            r2 = r2 ^ r6
            r1.append(r2)
            java.lang.String r2 = "，isAutoPlay="
            r1.append(r2)
            com.bytedance.sdk.openadsdk.core.model.q r2 = r0.j
            boolean r2 = com.bytedance.sdk.openadsdk.utils.ac.b((com.bytedance.sdk.openadsdk.core.model.q) r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "ClickCreativeListener"
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r2, (java.lang.String) r1)
            java.lang.String r1 = "embeded_ad"
            java.lang.String r5 = r0.h
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x0124
            boolean r1 = r23.w()
            if (r1 == 0) goto L_0x0124
            boolean r1 = r0.l
            if (r1 != 0) goto L_0x0124
            com.bytedance.sdk.openadsdk.core.model.q r1 = r0.j
            boolean r1 = com.bytedance.sdk.openadsdk.utils.ac.b((com.bytedance.sdk.openadsdk.core.model.q) r1)
            if (r1 == 0) goto L_0x0124
            java.lang.String r1 = "Creative...."
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r2, (java.lang.String) r1)
            com.bytedance.sdk.openadsdk.core.nativeexpress.f r1 = r0.f
            if (r1 == 0) goto L_0x013a
            r1.a(r4)
            com.bytedance.sdk.openadsdk.core.nativeexpress.f r1 = r0.f
            r1.a((java.lang.String) r3)
            com.bytedance.sdk.openadsdk.core.nativeexpress.f r7 = r0.f
            r7.a(r8, r9, r10, r11, r12, r13, r14)
            goto L_0x013a
        L_0x0124:
            java.lang.String r1 = "normal...."
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r2, (java.lang.String) r1)
            com.bytedance.sdk.openadsdk.core.nativeexpress.g r1 = r0.x
            if (r1 == 0) goto L_0x013a
            r1.a(r4)
            com.bytedance.sdk.openadsdk.core.nativeexpress.g r1 = r0.x
            r1.a((java.lang.String) r3)
            com.bytedance.sdk.openadsdk.core.nativeexpress.g r7 = r0.x
            r7.a(r8, r9, r10, r11, r12, r13, r14)
        L_0x013a:
            com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener r1 = r0.e
            if (r1 == 0) goto L_0x01d7
            com.bytedance.sdk.openadsdk.core.model.q r2 = r0.j
            int r2 = r2.M()
            r1.onAdClicked(r0, r2)
            goto L_0x01d7
        L_0x0149:
            com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract r1 = r0.d
            if (r1 == 0) goto L_0x0152
            r1.show()
            goto L_0x01d7
        L_0x0152:
            com.bytedance.sdk.openadsdk.dislike.b r1 = r0.c
            if (r1 == 0) goto L_0x015b
            r1.a()
            goto L_0x01d7
        L_0x015b:
            com.bytedance.sdk.openadsdk.core.model.q r1 = r0.j
            java.lang.String r2 = r0.C
            com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.a((com.bytedance.sdk.openadsdk.core.model.q) r1, (java.lang.String) r2)
            goto L_0x01d7
        L_0x0164:
            int r1 = r4.p
            if (r1 <= 0) goto L_0x016b
            com.bytedance.sdk.openadsdk.core.z.a((boolean) r6)
        L_0x016b:
            com.bytedance.sdk.openadsdk.core.nativeexpress.f r1 = r0.f
            if (r1 == 0) goto L_0x017c
            r1.a(r4)
            com.bytedance.sdk.openadsdk.core.nativeexpress.f r1 = r0.f
            r1.a((java.lang.String) r3)
            com.bytedance.sdk.openadsdk.core.nativeexpress.f r7 = r0.f
            r7.a(r8, r9, r10, r11, r12, r13, r14)
        L_0x017c:
            com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener r1 = r0.e
            if (r1 == 0) goto L_0x0189
            com.bytedance.sdk.openadsdk.core.model.q r2 = r0.j
            int r2 = r2.M()
            r1.onAdClicked(r0, r2)
        L_0x0189:
            r1 = 0
            com.bytedance.sdk.openadsdk.core.z.a((boolean) r1)
            com.bytedance.sdk.openadsdk.core.model.q r1 = r0.j
            r2 = 9
            com.bytedance.sdk.openadsdk.n.a.e.a((com.bytedance.sdk.openadsdk.core.model.q) r1, (int) r2)
            goto L_0x01d7
        L_0x0195:
            android.widget.FrameLayout r1 = r0.k
            if (r1 == 0) goto L_0x01ac
            r15 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            android.view.MotionEvent r2 = android.view.MotionEvent.obtain(r15, r17, r19, r20, r21, r22)
            r1.dispatchTouchEvent(r2)
        L_0x01ac:
            com.bytedance.sdk.openadsdk.core.model.q r1 = r0.j
            if (r1 == 0) goto L_0x01b9
            int r1 = r1.q()
            if (r1 != r6) goto L_0x01b9
            if (r14 != 0) goto L_0x01b9
            return
        L_0x01b9:
            com.bytedance.sdk.openadsdk.core.nativeexpress.g r1 = r0.x
            if (r1 == 0) goto L_0x01ca
            r1.a(r4)
            com.bytedance.sdk.openadsdk.core.nativeexpress.g r1 = r0.x
            r1.a((java.lang.String) r3)
            com.bytedance.sdk.openadsdk.core.nativeexpress.g r7 = r0.x
            r7.a(r8, r9, r10, r11, r12, r13, r14)
        L_0x01ca:
            com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener r1 = r0.e
            if (r1 == 0) goto L_0x01d7
            com.bytedance.sdk.openadsdk.core.model.q r2 = r0.j
            int r2 = r2.M()
            r1.onAdClicked(r0, r2)
        L_0x01d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.a(android.view.View, int, com.bytedance.sdk.component.adexpress.c):void");
    }

    public long getVideoProgress() {
        VastBannerBackupView vastBannerBackupView = this.ac;
        if (vastBannerBackupView != null) {
            return vastBannerBackupView.getVideoProgress();
        }
        return 0;
    }

    public static JSONObject a(View view) {
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, view.getWidth());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, view.getHeight());
            jSONObject.put("left", iArr[0]);
            jSONObject.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, iArr[1]);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean w() {
        return q.c(this.j);
    }

    private int getAdSlotType() {
        String str = this.h;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1695837674:
                if (str.equals("banner_ad")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1364000502:
                if (str.equals("rewarded_video")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1263194568:
                if (str.equals("open_ad")) {
                    c2 = 2;
                    break;
                }
                break;
            case -764631662:
                if (str.equals("fullscreen_interstitial_ad")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1844104722:
                if (str.equals("interaction")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 1;
            case 1:
                return 7;
            case 2:
                return 3;
            case 3:
                return 8;
            case 4:
                return 2;
            default:
                return 5;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        v();
        x();
        com.bytedance.sdk.component.utils.l.e("webviewpool", "onAttachedToWindow+++");
        getViewTreeObserver().addOnScrollChangedListener(this.G);
        com.bytedance.sdk.openadsdk.core.h.b().a(this.C, this.D);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        v();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.bytedance.sdk.component.utils.l.e("webviewpool", "onFinishTemporaryDetach+++");
    }

    private void x() {
        List<j> list = this.N;
        if (list != null) {
            for (j next : list) {
                if (next != null) {
                    next.b();
                }
            }
        }
    }

    private void y() {
        List<j> list = this.N;
        if (list != null) {
            for (j next : list) {
                if (next != null) {
                    next.c();
                }
            }
        }
    }

    public void k() {
        p pVar = this.L;
        if (pVar != null && pVar.e() != null) {
            this.L.f();
        }
    }

    public void l() {
        try {
            b bVar = this.F;
            if (bVar != null) {
                bVar.b();
            }
            o();
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            List<j> list = this.N;
            if (list != null) {
                for (j a2 : list) {
                    a2.a();
                }
            }
            com.bytedance.sdk.openadsdk.n.a.e.a(this.j);
            this.c = null;
            this.d = null;
            this.i = null;
            this.j = null;
            this.e = null;
            this.f = null;
            this.n = null;
            this.x = null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.l.c("NativeExpressView", "detach error", th);
        }
    }

    public void m() {
        try {
            FrameLayout frameLayout = this.k;
            if (frameLayout != null && frameLayout.getParent() != null) {
                removeView(this.k);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.l.a("NativeExpressView", "backupDestroy remove video container error", th);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnScrollChangedListener(this.G);
        com.bytedance.sdk.openadsdk.core.h.b().d(this.C);
        y();
        com.bytedance.sdk.component.utils.l.e("webviewpool", "onDetachedFromWindow===");
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.bytedance.sdk.component.utils.l.e("webviewpool", "onStartTemporaryDetach===");
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [com.bytedance.sdk.component.adexpress.b.d, com.bytedance.sdk.component.adexpress.b.d<? extends android.view.View>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.bytedance.sdk.component.adexpress.b.d<? extends android.view.View> r8, com.bytedance.sdk.component.adexpress.b.n r9) {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.E
            r1 = 1
            r0.set(r1)
            r7.w = r8
            int r0 = r7.S
            int r2 = r7.getWindowVisibility()
            if (r0 == r2) goto L_0x0017
            int r0 = r7.getWindowVisibility()
            r7.d((int) r0)
        L_0x0017:
            r0 = 2
            java.lang.Object[] r2 = new java.lang.Object[r0]
            java.lang.String r3 = "render type is  "
            r4 = 0
            r2[r4] = r3
            int r3 = r8.c()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2[r1] = r3
            java.lang.String r3 = "NativeExpressView"
            com.bytedance.sdk.component.utils.l.a((java.lang.String) r3, (java.lang.Object[]) r2)
            int r2 = r8.c()
            r3 = 3
            if (r2 != r3) goto L_0x0044
            com.bytedance.sdk.openadsdk.core.model.q r2 = r7.j
            if (r2 == 0) goto L_0x0044
            int r2 = r2.o()
            if (r2 != r1) goto L_0x0044
            com.bytedance.sdk.openadsdk.core.model.q r1 = r7.j
            r1.b((int) r4)
        L_0x0044:
            int r1 = r8.c()
            if (r1 == r0) goto L_0x0056
            int r0 = r8.c()
            if (r0 == 0) goto L_0x0056
            int r0 = r8.c()
            if (r0 != r3) goto L_0x00a0
        L_0x0056:
            android.view.View r0 = r8.e()
            android.view.ViewParent r1 = r0.getParent()
            if (r1 == 0) goto L_0x0069
            android.view.ViewParent r1 = r0.getParent()
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r1.removeView(r0)
        L_0x0069:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
        L_0x006f:
            int r2 = r7.getChildCount()
            if (r1 >= r2) goto L_0x007f
            android.view.View r2 = r7.getChildAt(r1)
            r0.add(r2)
            int r1 = r1 + 1
            goto L_0x006f
        L_0x007f:
            int r1 = r0.size()
            if (r4 >= r1) goto L_0x0099
            java.lang.Object r1 = r0.get(r4)
            boolean r1 = r1 instanceof com.bytedance.sdk.component.widget.SSWebView
            if (r1 == 0) goto L_0x0096
            java.lang.Object r1 = r0.get(r4)
            android.view.View r1 = (android.view.View) r1
            r7.removeView(r1)
        L_0x0096:
            int r4 = r4 + 1
            goto L_0x007f
        L_0x0099:
            android.view.View r0 = r8.e()
            r7.addView(r0)
        L_0x00a0:
            com.bytedance.sdk.openadsdk.core.model.q r0 = r7.j
            if (r0 == 0) goto L_0x00b3
            long r1 = r0.a()
            long r3 = r7.u
            java.lang.String r5 = r7.h
            int r6 = r8.c()
            com.bytedance.sdk.openadsdk.j.b.a(r1, r3, r5, r6)
        L_0x00b3:
            com.bytedance.sdk.component.adexpress.b.i r8 = r7.Q
            if (r8 == 0) goto L_0x00bc
            com.bytedance.sdk.openadsdk.core.nativeexpress.k r8 = (com.bytedance.sdk.openadsdk.core.nativeexpress.k) r8
            r8.i()
        L_0x00bc:
            com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener r8 = r7.e
            if (r8 == 0) goto L_0x00cd
            double r0 = r9.d()
            float r0 = (float) r0
            double r1 = r9.e()
            float r1 = (float) r1
            r8.onRenderSuccess(r7, r0, r1)
        L_0x00cd:
            boolean r8 = r7.a((com.bytedance.sdk.component.adexpress.b.n) r9)
            if (r8 == 0) goto L_0x00dc
            com.bytedance.sdk.openadsdk.core.model.q r8 = r7.j
            int r9 = r7.getDynamicShowType()
            com.bytedance.sdk.openadsdk.n.a.e.a(r7, r8, r9)
        L_0x00dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.a(com.bytedance.sdk.component.adexpress.b.d, com.bytedance.sdk.component.adexpress.b.n):void");
    }

    public void a_(int i2) {
        i iVar = this.Q;
        if (iVar != null) {
            if (!this.a) {
                iVar.f();
            }
            this.Q.g();
            ((k) this.Q).i();
        }
        PAGBannerAdWrapperListener pAGBannerAdWrapperListener = this.e;
        if (pAGBannerAdWrapperListener != null) {
            pAGBannerAdWrapperListener.onRenderFail(this, com.bytedance.sdk.openadsdk.core.g.a(i2), i2);
        }
    }

    public boolean n() {
        com.bytedance.sdk.component.adexpress.b.d<? extends View> dVar = this.w;
        return dVar != null && dVar.c() == 1;
    }

    public int getDynamicShowType() {
        com.bytedance.sdk.component.adexpress.b.d<? extends View> dVar = this.w;
        if (dVar != null) {
            return dVar.c();
        }
        return 0;
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.z).intValue();
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.A).intValue();
    }

    public x getJsObject() {
        p pVar = this.L;
        if (pVar != null) {
            return pVar.q();
        }
        return null;
    }

    private boolean z() {
        return TextUtils.equals(this.h, "fullscreen_interstitial_ad") || TextUtils.equals(this.h, "rewarded_video") || TextUtils.equals("open_ad", this.h) || p.b(this.h) || TextUtils.equals(this.h, "embeded_ad");
    }

    public void a(CharSequence charSequence, int i2, int i3, boolean z2) {
        b(Integer.parseInt(String.valueOf(charSequence)), i2);
    }

    public void setSoundMute(boolean z2) {
        this.q = z2;
        com.bytedance.sdk.component.adexpress.b.b bVar = this.v;
        if (bVar != null && bVar.d() != null) {
            this.v.d().setSoundMute(z2);
        }
    }

    /* access modifiers changed from: protected */
    public void b(int i2, int i3) {
        int i4;
        if (!TextUtils.equals(this.h, "banner_ad")) {
            int i5 = this.r;
            int i6 = ((i3 < i5 || i5 < 0 || (!this.s && !TextUtils.equals(this.h, "open_ad"))) && d() != 5) ? 0 : 1;
            if (i3 > this.r) {
                i4 = 0;
            } else if (this.j.K() != null) {
                double f2 = this.j.K().f();
                double w2 = (double) this.j.K().w();
                Double.isNaN(w2);
                double min = Math.min((double) this.r, f2 * w2);
                double d2 = (double) i3;
                Double.isNaN(d2);
                i4 = (int) (min - d2);
            } else {
                i4 = this.r - i3;
            }
            com.bytedance.sdk.component.adexpress.b.b bVar = this.v;
            if (bVar != null && bVar.d() != null) {
                this.v.d().a(String.valueOf(i2), i6, i4, false);
            }
        }
    }

    public void o() {
        q qVar = this.j;
        if (qVar != null && qVar.au() != null && this.j.au().a() != null) {
            this.j.au().a().e(getVideoProgress());
        }
    }

    public void setVastVideoHelper(VastBannerBackupView vastBannerBackupView) {
        this.ac = vastBannerBackupView;
    }

    public boolean p() {
        return this.E.get();
    }
}
