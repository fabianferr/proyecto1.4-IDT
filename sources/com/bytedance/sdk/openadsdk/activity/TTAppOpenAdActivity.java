package com.bytedance.sdk.openadsdk.activity;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.apiImpl.c.b;
import com.bytedance.sdk.openadsdk.b.g;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.component.a;
import com.bytedance.sdk.openadsdk.component.c;
import com.bytedance.sdk.openadsdk.component.f;
import com.bytedance.sdk.openadsdk.core.g.d;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.n.a.e;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class TTAppOpenAdActivity extends TTBaseActivity implements x.a {
    private static b g;
    /* access modifiers changed from: private */
    public FrameLayout A;
    /* access modifiers changed from: private */
    public boolean B;
    /* access modifiers changed from: private */
    public c C;
    /* access modifiers changed from: private */
    public final a D = new a() {
        public void b(long j, int i) {
            l.a("TTAppOpenAdActivity", "open_ad", "onError() called with: totalPlayTime = [" + j + "], percent = [" + i + "]");
            TTAppOpenAdActivity.this.s();
            TTAppOpenAdActivity.this.finish();
        }

        public void a() {
            l.a("TTAppOpenAdActivity", "open_ad", "onTimeOut");
            TTAppOpenAdActivity.this.s();
            TTAppOpenAdActivity.this.finish();
        }

        public void a(long j, long j2) {
            TTAppOpenAdActivity.this.h.a(j);
            if (!TTAppOpenAdActivity.this.e && TTAppOpenAdActivity.this.C != null && TTAppOpenAdActivity.this.C.e() != null && TTAppOpenAdActivity.this.C.e().b()) {
                TTAppOpenAdActivity.this.C.e().d();
            }
            TTAppOpenAdActivity.this.l();
        }

        public void a(View view) {
            TTAppOpenAdActivity.this.t();
        }

        public void b(View view) {
            TTAppOpenAdActivity.this.a();
        }

        public void b() {
            l.a("TTAppOpenAdActivity", "open_ad", "onCountDownFinish() called");
            if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                TTAppOpenAdActivity.this.a("onAdTimeOver");
            } else if (TTAppOpenAdActivity.this.w != null) {
                TTAppOpenAdActivity.this.w.d();
            }
            TTAppOpenAdActivity.this.finish();
        }

        public void a(int i, int i2, boolean z) {
            if (TTAppOpenAdActivity.this.C != null) {
                TTAppOpenAdActivity.this.C.a(i, i2, z);
            }
        }

        public void c() {
            TTAppOpenAdActivity.this.f();
            TTAppOpenAdActivity.this.n.d();
            TTAppOpenAdActivity.this.p();
            if (TTAppOpenAdActivity.this.r) {
                TTAppOpenAdActivity.this.k();
            }
        }

        public void d() {
            TTAppOpenAdActivity.this.finish();
        }

        public void e() {
            TTAppOpenAdActivity.this.r();
        }

        public void f() {
            TTAppOpenAdActivity.this.h();
        }
    };
    private final Runnable E = new Runnable() {
        public void run() {
            if (!TTAppOpenAdActivity.this.m.get()) {
                if (!(TTAppOpenAdActivity.this.u == null || !TTAppOpenAdActivity.this.u.at() || TTAppOpenAdActivity.this.u.au() == null || TTAppOpenAdActivity.this.u.au().a() == null)) {
                    TTAppOpenAdActivity.this.u.au().a().a(0);
                }
                g unused = TTAppOpenAdActivity.this.o = new g();
                TTAppOpenAdActivity.this.o.a(System.currentTimeMillis(), 1.0f);
                TTAppOpenAdActivity.this.n.d();
                if (TTAppOpenAdActivity.this.j != null && !TTAppOpenAdActivity.this.j.isStarted()) {
                    TTAppOpenAdActivity.this.j.start();
                }
                TTAppOpenAdActivity.this.q();
                View findViewById = TTAppOpenAdActivity.this.findViewById(16908290);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, findViewById.getWidth());
                    jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, findViewById.getHeight());
                    jSONObject.put("alpha", (double) findViewById.getAlpha());
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("root_view", jSONObject.toString());
                    jSONObject2.put("ad_root", TTAppOpenAdActivity.this.y);
                    jSONObject2.put("openad_creative_type", TTAppOpenAdActivity.this.r ? "video_normal_ad" : "image_normal_ad");
                    if (com.bytedance.sdk.openadsdk.component.view.a.c() == null) {
                        jSONObject2.put("appicon_acquirefail", "1");
                    }
                    if (TTAppOpenAdActivity.this.B || TTAppOpenAdActivity.this.u.av()) {
                        jSONObject2.put("dynamic_show_type", TTAppOpenAdActivity.this.o());
                    }
                    jSONObject2.put("is_icon_only", TTAppOpenAdActivity.this.u.br() ? 1 : 0);
                    com.bytedance.sdk.openadsdk.b.c.a(TTAppOpenAdActivity.this.u, "open_ad", jSONObject2);
                    e.a(TTAppOpenAdActivity.this.findViewById(16908290), TTAppOpenAdActivity.this.u, TTAppOpenAdActivity.this.o());
                    TTAppOpenAdActivity.this.m.set(true);
                } catch (JSONException e) {
                    Log.e("TTAppOpenAdActivity", "run: ", e);
                    TTAppOpenAdActivity.this.finish();
                }
            }
        }
    };
    protected final AtomicBoolean a = new AtomicBoolean(false);
    protected final x b = new x(Looper.getMainLooper(), this);
    final AtomicBoolean c = new AtomicBoolean(false);
    final AtomicBoolean d = new AtomicBoolean(false);
    protected boolean e = false;
    long f = 0;
    /* access modifiers changed from: private */
    public final com.bytedance.sdk.openadsdk.component.h.a h = new com.bytedance.sdk.openadsdk.component.h.a();
    private com.bytedance.sdk.openadsdk.component.f.b i;
    /* access modifiers changed from: private */
    public ValueAnimator j;
    private TTAdDislikeDialog k;
    private TTAdDislikeToast l;
    /* access modifiers changed from: private */
    public final AtomicBoolean m = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public ab n = ab.b();
    /* access modifiers changed from: private */
    public g o;
    /* access modifiers changed from: private */
    public float p;
    /* access modifiers changed from: private */
    public float q;
    /* access modifiers changed from: private */
    public boolean r;
    private int s;
    /* access modifiers changed from: private */
    public String t;
    /* access modifiers changed from: private */
    public q u;
    private IListenerManager v;
    /* access modifiers changed from: private */
    public b w;
    private final AtomicBoolean x = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public int y;
    /* access modifiers changed from: private */
    public int z;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o.a(getApplicationContext());
        if (!b(bundle)) {
            finish();
        } else if (!com.bytedance.sdk.openadsdk.core.l.e()) {
            finish();
        } else {
            this.r = q.c(this.u);
            l.a("TTAppOpenAdActivity", "open_ad", "onCreate: isVideo is " + this.r);
            if (this.r) {
                this.h.a((float) this.u.K().f());
            } else {
                this.h.a((float) o.d().u(String.valueOf(this.s)));
            }
            com.bytedance.sdk.openadsdk.component.f.b bVar = new com.bytedance.sdk.openadsdk.component.f.b(this.h);
            this.i = bVar;
            bVar.a((com.bytedance.sdk.openadsdk.component.f.a) this.D);
            g();
            FrameLayout frameLayout = new FrameLayout(this);
            this.A = frameLayout;
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            try {
                setContentView(this.A);
                this.A.post(new Runnable() {
                    public void run() {
                        try {
                            int x = TTAppOpenAdActivity.this.u.x();
                            TTAppOpenAdActivity tTAppOpenAdActivity = TTAppOpenAdActivity.this;
                            boolean unused = tTAppOpenAdActivity.B = tTAppOpenAdActivity.u != null && TTAppOpenAdActivity.this.u.u() == 2 && x == 3;
                            if (TTAppOpenAdActivity.this.B) {
                                TTAppOpenAdActivity tTAppOpenAdActivity2 = TTAppOpenAdActivity.this;
                                TTAppOpenAdActivity tTAppOpenAdActivity3 = TTAppOpenAdActivity.this;
                                c unused2 = tTAppOpenAdActivity2.C = new com.bytedance.sdk.openadsdk.component.b(tTAppOpenAdActivity3, tTAppOpenAdActivity3.u, TTAppOpenAdActivity.this.A, TTAppOpenAdActivity.this.D, TTAppOpenAdActivity.this.z, TTAppOpenAdActivity.this.r, TTAppOpenAdActivity.this.h);
                            } else {
                                TTAppOpenAdActivity tTAppOpenAdActivity4 = TTAppOpenAdActivity.this;
                                TTAppOpenAdActivity tTAppOpenAdActivity5 = TTAppOpenAdActivity.this;
                                c unused3 = tTAppOpenAdActivity4.C = new c(tTAppOpenAdActivity5, tTAppOpenAdActivity5.u, TTAppOpenAdActivity.this.A, TTAppOpenAdActivity.this.D, TTAppOpenAdActivity.this.z, TTAppOpenAdActivity.this.r, TTAppOpenAdActivity.this.h);
                                TTAppOpenAdActivity.this.C.a(TTAppOpenAdActivity.this.q, TTAppOpenAdActivity.this.p);
                            }
                            TTAppOpenAdActivity.this.C.a((ViewGroup) TTAppOpenAdActivity.this.A);
                            TTAppOpenAdActivity.this.C.a();
                            TTAppOpenAdActivity.this.C.b();
                        } catch (Throwable th) {
                            TTAppOpenAdActivity.this.finish();
                            l.e("TTAppOpenAdActivity", th.getMessage());
                        }
                    }
                });
            } catch (Throwable unused) {
                com.bytedance.sdk.openadsdk.b.c.b();
                finish();
            }
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        Log.d("TTAppOpenAdActivity", "startCountDownTimer() called");
        this.i.b(o.d().t(String.valueOf(this.s)));
        this.i.a(this.h.a());
        this.j = this.i.b();
        this.i.a(0);
    }

    private void g() {
        if (26 != Build.VERSION.SDK_INT) {
            this.z = this.u.ak();
        } else if (getResources().getConfiguration().orientation == 1) {
            this.z = 1;
        } else {
            this.z = 2;
        }
        h();
    }

    /* access modifiers changed from: private */
    public void h() {
        int i2;
        int i3;
        l.a("TTAppOpenAdActivity", "open_ad", "changeScreenOrientation: mOrientation=" + this.z);
        if (Build.VERSION.SDK_INT != 26) {
            if (Build.VERSION.SDK_INT == 27) {
                try {
                    i();
                } catch (Throwable th) {
                    l.e("TTAppOpenAdActivity", th.getMessage());
                    return;
                }
            } else {
                i();
            }
        }
        Pair<Integer, Integer> h2 = ad.h(getApplicationContext());
        if (this.z == 2) {
            i2 = Math.max(((Integer) h2.first).intValue(), ((Integer) h2.second).intValue());
            i3 = Math.min(((Integer) h2.first).intValue(), ((Integer) h2.second).intValue());
        } else {
            i2 = Math.min(((Integer) h2.first).intValue(), ((Integer) h2.second).intValue());
            i3 = Math.max(((Integer) h2.first).intValue(), ((Integer) h2.second).intValue());
        }
        this.p = (float) i3;
        this.q = (float) i2;
        float a2 = ad.a();
        if (ad.c((Activity) this)) {
            int i4 = this.z;
            if (i4 == 1) {
                this.p -= a2;
            } else if (i4 == 2) {
                this.q -= a2;
            }
        }
        c cVar = this.C;
        if (cVar != null) {
            cVar.a(this.q, this.p);
        }
    }

    private void i() {
        if (this.z != 2) {
            setRequestedOrientation(1);
        } else if (e()) {
            setRequestedOrientation(8);
        } else {
            setRequestedOrientation(0);
        }
        if (this.z == 2 || !ad.c((Activity) this)) {
            getWindow().addFlags(1024);
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        if (!isFinishing()) {
            if (this.d.get()) {
                m();
                return;
            }
            if (this.k == null) {
                j();
            }
            this.k.a();
        }
    }

    private void j() {
        if (this.k == null) {
            TTAdDislikeDialog tTAdDislikeDialog = new TTAdDislikeDialog((Context) this, this.u);
            this.k = tTAdDislikeDialog;
            tTAdDislikeDialog.setCallback(new TTAdDislikeDialog.a() {
                public void c(View view) {
                }

                public void a(View view) {
                    TTAppOpenAdActivity.this.c.set(true);
                    TTAppOpenAdActivity.this.c();
                }

                public void b(View view) {
                    TTAppOpenAdActivity.this.c.set(false);
                    TTAppOpenAdActivity.this.b();
                }

                public void a(int i, FilterWord filterWord) {
                    if (!TTAppOpenAdActivity.this.d.get() && filterWord != null && !filterWord.hasSecondOptions()) {
                        TTAppOpenAdActivity.this.d.set(true);
                        TTAppOpenAdActivity.this.n();
                    }
                }
            });
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
        frameLayout.addView(this.k);
        if (this.l == null) {
            TTAdDislikeToast tTAdDislikeToast = new TTAdDislikeToast(this);
            this.l = tTAdDislikeToast;
            frameLayout.addView(tTAdDislikeToast);
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        if (this.r && !this.u.br()) {
            this.b.sendEmptyMessageDelayed(100, 5000);
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        if (this.r && !this.u.br()) {
            this.b.removeMessages(100);
        }
    }

    private void m() {
        this.l.a(TTAdDislikeToast.getDislikeTip());
    }

    /* access modifiers changed from: private */
    public void n() {
        this.l.a(TTAdDislikeToast.getDislikeSendTip());
    }

    public void onBackPressed() {
        if (o.d().s(String.valueOf(this.s)) == 1) {
            if (this.h.b() >= ((long) o.d().t(String.valueOf(this.s))) * 1000) {
                t();
            }
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            if (!this.B) {
                this.n.d();
            }
            q qVar = this.u;
            if (qVar != null && qVar.bj() && !this.u.bo()) {
                this.u.f(true);
                q qVar2 = this.u;
                com.bytedance.sdk.openadsdk.b.c.a(qVar2, "open_ad", qVar2.bk());
            }
        } else if (this.m.get()) {
            if (this.n.e()) {
                com.bytedance.sdk.openadsdk.b.c.a(String.valueOf(this.n.c()), this.u, "open_ad", this.o);
            }
            this.n = ab.b();
        }
        e.a(this.u, z2 ? 4 : 8);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        c cVar;
        super.onResume();
        this.e = true;
        if (!this.a.getAndSet(true)) {
            return;
        }
        if (this.x.get()) {
            s();
            if (!(!this.r || (cVar = this.C) == null || cVar.e() == null)) {
                this.C.e().a(3);
            }
            finish();
            return;
        }
        b();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.e = false;
        c();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.b.removeCallbacksAndMessages((Object) null);
        e.a(this.u);
        if (this.r) {
            com.bytedance.sdk.openadsdk.component.d.a.a(this.u, this.h.b(), this.h.a(), true);
        } else {
            com.bytedance.sdk.openadsdk.component.d.a.a(this.u, -1, this.h.a(), false);
        }
        if (this.n.e() && this.m.get()) {
            com.bytedance.sdk.openadsdk.b.c.a(String.valueOf(this.n.c()), this.u, "open_ad", this.o);
            this.n = ab.b();
        }
        c cVar = this.C;
        if (cVar != null) {
            cVar.c();
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            a("recycleRes");
        }
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.j.removeAllUpdateListeners();
        }
        g = null;
        this.w = null;
        TTAdDislikeDialog tTAdDislikeDialog = this.k;
        if (tTAdDislikeDialog != null) {
            tTAdDislikeDialog.setCallback((TTAdDislikeDialog.a) null);
        }
        if (com.bytedance.sdk.openadsdk.core.settings.o.ai().x(String.valueOf(this.s)) == 1) {
            f.a(o.a()).a(new AdSlot.Builder().setCodeId(String.valueOf(this.s)).build());
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!this.c.get()) {
            if (this.r) {
                c cVar = this.C;
                if (!(cVar == null || cVar.e() == null || !this.C.e().c())) {
                    this.C.e().e();
                }
                k();
            }
            if (this.j != null) {
                this.j.resume();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.r) {
            c cVar = this.C;
            if (!(cVar == null || cVar.e() == null || !this.C.e().b())) {
                this.C.e().d();
            }
            l();
        }
        if (this.j != null) {
            this.j.pause();
        }
    }

    /* access modifiers changed from: private */
    public int o() {
        if (this.u.av()) {
            return 5;
        }
        if (this.B) {
            return this.C.d();
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public void p() {
        if (!this.m.get()) {
            try {
                getWindow().getDecorView().post(this.E);
            } catch (Throwable unused) {
                finish();
            }
        }
    }

    /* access modifiers changed from: private */
    public void q() {
        l.a("TTAppOpenAdActivity", "open_ad", "callbackAdShow() called");
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            a("onAdShow");
            return;
        }
        b bVar = this.w;
        if (bVar != null) {
            bVar.a();
        }
    }

    /* access modifiers changed from: private */
    public void r() {
        l.a("TTAppOpenAdActivity", "open_ad", "callbackAdClick() called");
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            a("onAdClicked");
        } else {
            b bVar = this.w;
            if (bVar != null) {
                bVar.b();
            }
        }
        if (com.bytedance.sdk.openadsdk.core.settings.o.ai().w(String.valueOf(this.s))) {
            this.x.set(true);
        }
    }

    /* access modifiers changed from: private */
    public void s() {
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            a("onAdSkip");
            return;
        }
        b bVar = this.w;
        if (bVar != null) {
            bVar.c();
        }
    }

    /* access modifiers changed from: private */
    public void t() {
        c cVar;
        l.a("TTAppOpenAdActivity", "open_ad", "onUserWantSkip() called");
        r.c(this.s);
        s();
        if (!(!this.r || (cVar = this.C) == null || cVar.e() == null)) {
            this.C.e().a(4);
        }
        com.bytedance.sdk.openadsdk.component.d.a.a(this.u, (int) this.h.b(), this.i.c(), this.h.a());
        q qVar = this.u;
        if (!(qVar == null || !qVar.at() || this.u.au() == null || this.u.au().a() == null)) {
            d a2 = this.u.au().a();
            c cVar2 = this.C;
            long g2 = (cVar2 == null || cVar2.e() == null) ? 0 : this.C.e().g();
            a2.f(g2);
            a2.e(g2);
        }
        finish();
    }

    /* access modifiers changed from: private */
    public void a(final String str) {
        aa.c(new h("AppOpenAd_executeMultiProcessCallback") {
            public void run() {
                try {
                    TTAppOpenAdActivity.this.d().executeAppOpenAdCallback(TTAppOpenAdActivity.this.t, str);
                } catch (Throwable th) {
                    l.a("TTAppOpenAdActivity", "open_ad", "executeAppOpenAdCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    /* access modifiers changed from: protected */
    public IListenerManager d() {
        if (this.v == null) {
            this.v = com.bytedance.sdk.openadsdk.multipro.aidl.a.a.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a().a(7));
        }
        return this.v;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ad.a((Activity) this);
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            public void onSystemUiVisibilityChange(int i) {
                if (i == 0) {
                    try {
                        if (!TTAppOpenAdActivity.this.isFinishing()) {
                            TTAppOpenAdActivity.this.getWindow().getDecorView().postDelayed(new Runnable() {
                                public void run() {
                                    ad.a((Activity) TTAppOpenAdActivity.this);
                                }
                            }, 2500);
                        }
                    } catch (Exception e) {
                        l.e("TTAppOpenAdActivity", e.getMessage());
                    }
                }
            }
        });
    }

    private boolean b(Bundle bundle) {
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            Intent intent = getIntent();
            if (intent != null) {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra != null) {
                    try {
                        this.u = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(stringExtra));
                    } catch (Exception e2) {
                        l.a("TTAppOpenAdActivity", "open_ad", "initData MultiGlobalInfo throws ", e2);
                    }
                }
                this.t = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_META_MD5);
            }
        } else {
            this.u = s.a().b();
            this.w = s.a().e();
            s.a().f();
        }
        a(getIntent());
        a(bundle);
        q qVar = this.u;
        if (qVar == null) {
            l.a("TTAppOpenAdActivity", "open_ad", "mMaterialMeta is null , no data to display ,the TTOpenAdActivity finished !!");
            finish();
            return false;
        }
        qVar.a(this.f);
        this.s = this.u.aZ();
        com.bytedance.sdk.openadsdk.utils.b.a(this.u);
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(Intent intent) {
        if (intent != null) {
            this.y = intent.getIntExtra("ad_source", 0);
            this.f = intent.getLongExtra("start_show_time", 0);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        if (bundle != null) {
            if (this.w == null) {
                this.w = g;
                g = null;
            }
            try {
                String string = bundle.getString("material_meta");
                this.t = bundle.getString(TTAdConstant.MULTI_PROCESS_META_MD5);
                this.y = bundle.getInt("ad_source", 0);
                this.f = bundle.getLong("start_show_time", 0);
                this.u = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(string));
            } catch (Throwable th) {
                l.e("TTAppOpenAdActivity", th.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            q qVar = this.u;
            bundle.putString("material_meta", qVar != null ? qVar.ao().toString() : null);
            bundle.putString(TTAdConstant.MULTI_PROCESS_META_MD5, this.t);
            bundle.putInt("ad_source", this.y);
            bundle.putLong("start_show_time", this.f);
        } catch (Throwable th) {
            l.e("TTAppOpenAdActivity", th.getMessage());
        }
        g = this.w;
        super.onSaveInstanceState(bundle);
    }

    public void a(Message message) {
        c cVar;
        if (message.what == 100) {
            if (!(!this.r || (cVar = this.C) == null || cVar.e() == null)) {
                this.C.e().a(1);
            }
            s();
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public boolean e() {
        try {
            if (getIntent().getIntExtra("orientation_angle", 0) == 3) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            l.e("TTAppOpenAdActivity", e2.getMessage());
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        com.bytedance.sdk.openadsdk.utils.c.a((Activity) this, this.u);
    }
}
