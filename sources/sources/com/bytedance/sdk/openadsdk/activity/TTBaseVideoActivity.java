package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.b.b;
import com.bytedance.sdk.openadsdk.component.reward.a.a;
import com.bytedance.sdk.openadsdk.component.reward.b.f;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.t;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.c.b;
import com.bytedance.sdk.openadsdk.core.video.c.c;
import com.bytedance.sdk.openadsdk.i.e;
import com.bytedance.sdk.openadsdk.utils.ad;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class TTBaseVideoActivity extends TTBaseActivity implements x.a, b, c {
    public final String a;
    a b;
    protected com.bytedance.sdk.openadsdk.component.reward.b.b c;
    final x d;
    protected IListenerManager e;
    int f;
    boolean g;
    int h;
    public boolean i;
    protected e j;
    private boolean k;
    private int l;
    private long m;
    private final AtomicBoolean n;

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public void a(Intent intent) {
    }

    public void a(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public abstract void h();

    public void i() {
    }

    public void j() {
    }

    /* access modifiers changed from: protected */
    public abstract void n();

    public abstract boolean o();

    public boolean p() {
        return false;
    }

    public boolean q() {
        return false;
    }

    public TTBaseVideoActivity() {
        this.a = o() ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.d = new x(Looper.getMainLooper(), this);
        this.k = false;
        this.l = 0;
        this.h = 1;
        this.i = true;
        this.n = new AtomicBoolean(false);
        this.j = new e() {
            public void a() {
                TTBaseVideoActivity.this.j();
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o.a(getApplicationContext());
        if (!l.e()) {
            finish();
            return;
        }
        q a2 = com.bytedance.sdk.openadsdk.component.reward.a.b.a(getIntent(), bundle, (b) this);
        if (a2 == null) {
            finish();
            return;
        }
        com.bytedance.sdk.openadsdk.utils.b.a(a2);
        this.h = a2.ak();
        a(a2, bundle);
        try {
            s();
            t();
            this.m = SystemClock.elapsedRealtime();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.l.c("TTAD.BVA", "onCreate: ", th);
            this.i = false;
            com.bytedance.sdk.openadsdk.b.c.b();
            finish();
        }
    }

    private void a(q qVar, Bundle bundle) {
        a aVar = new a(this, this.d, qVar);
        this.b = aVar;
        com.bytedance.sdk.openadsdk.component.reward.a.b.a(aVar, getIntent(), bundle);
        Intent intent = getIntent();
        if (intent != null) {
            a(intent);
            qVar.a(intent.getLongExtra("start_show_time", 0));
        }
        if (bundle != null && this.b.p) {
            a();
        }
        com.bytedance.sdk.openadsdk.component.reward.b.b a2 = f.a(this.b);
        this.c = a2;
        this.b.Y = a2;
        com.bytedance.sdk.component.utils.l.b("TTAD.BVA", "init: mAdType = " + this.c);
    }

    private void s() {
        setContentView(this.b.U);
        this.b.U.a(this.c);
        this.c.a(this, this.d);
        this.c.l();
    }

    private void t() {
        this.c.a(this.j);
        this.f = (int) this.b.G.A();
        n();
        f();
        if (this.b.a.au() != null && this.b.a.au().a() != null) {
            this.b.a.au().a().a(0);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        a aVar = this.b;
        if (!(aVar == null || aVar.L == null)) {
            this.b.L.b(z);
            this.b.L.c(z);
        }
        a aVar2 = this.b;
        if (aVar2 != null && (aVar2.Y instanceof com.bytedance.sdk.openadsdk.component.reward.b.e)) {
            ((com.bytedance.sdk.openadsdk.component.reward.b.e) this.b.Y).b(z);
        }
    }

    public void b() {
        if (!this.b.y.getAndSet(true) || t.k(this.b.a)) {
            this.b.L.a();
        }
    }

    public void c() {
        com.bytedance.sdk.openadsdk.component.reward.b.b bVar = this.c;
        if (bVar != null) {
            bVar.n();
        }
    }

    public void a(boolean z, int i2) {
        a(z, false, i2);
    }

    public void a(boolean z, boolean z2, int i2) {
        com.bytedance.sdk.openadsdk.component.reward.b.b bVar = this.c;
        if (bVar != null) {
            bVar.a(z, z2, false, i2);
        }
    }

    public void d() {
        this.b.G.B();
    }

    public View e() {
        return this.b.G.C();
    }

    /* access modifiers changed from: protected */
    public void f() {
        if (t.k(this.b.a)) {
            a(false, b.a.c);
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.b.b bVar = this.c;
        if (bVar != null) {
            bVar.a(this.b.T.f());
            this.c.z();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        a aVar = this.b;
        if (aVar != null) {
            aVar.Q.D();
            com.bytedance.sdk.openadsdk.utils.c.a((Activity) this, this.b.a);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        com.bytedance.sdk.openadsdk.component.reward.b.b bVar;
        com.bytedance.sdk.component.utils.l.b("TTAD.BVA", "onResume: ");
        super.onResume();
        if (this.b != null && (bVar = this.c) != null) {
            bVar.r();
            this.b.e = true;
            this.b.K.b(this.d);
            if (u()) {
                this.b.R.a(this.b.a.an());
            }
            this.b.T.o();
            this.b.Q.s();
            this.b.I.l();
            if (this.c.b()) {
                this.b.G.a(this.c);
                this.b.G.a(false, this, this.l != 0);
            }
            this.l++;
            k();
            if (this.b.J != null) {
                this.b.J.g();
            }
            this.b.K.a(this.d);
            this.c.s();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        com.bytedance.sdk.openadsdk.component.reward.b.b bVar = this.c;
        if (bVar != null) {
            bVar.t();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.component.reward.b.b bVar = this.c;
        if (bVar != null) {
            bVar.u();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        a aVar = this.b;
        if (aVar != null && this.c != null) {
            if (aVar.r > 0 && this.b.x.get()) {
                com.bytedance.sdk.openadsdk.b.c.a(String.valueOf(SystemClock.elapsedRealtime() - this.b.r), this.b.a, this.a, this.b.G.a());
                this.b.r = 0;
            }
            this.b.N.b();
            this.d.removeCallbacksAndMessages((Object) null);
            this.c.v();
            com.bytedance.sdk.openadsdk.n.a.e.a(this.b.a);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        a aVar = this.b;
        if (aVar == null) {
            super.onSaveInstanceState(bundle);
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.a.b.a(aVar, bundle);
        super.onSaveInstanceState(bundle);
    }

    public void onBackPressed() {
        com.bytedance.sdk.openadsdk.component.reward.b.b bVar;
        if (this.b == null || (bVar = this.c) == null) {
            super.onBackPressed();
        } else {
            bVar.w();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.b;
        if (aVar != null) {
            aVar.K.a();
        }
    }

    public void a(Message message) {
        com.bytedance.sdk.openadsdk.component.reward.b.b bVar = this.c;
        if (bVar != null) {
            bVar.a(message);
        }
    }

    public final void g() {
        if (this.n.compareAndSet(false, true)) {
            h();
        }
    }

    /* access modifiers changed from: protected */
    public IListenerManager a(int i2) {
        if (this.e == null) {
            this.e = com.bytedance.sdk.openadsdk.multipro.aidl.a.a.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a().a(i2));
        }
        return this.e;
    }

    /* access modifiers changed from: protected */
    public void k() {
        if (p() && !this.k) {
            this.k = true;
            getWindow().getDecorView().post(new Runnable() {
                public void run() {
                    com.bytedance.sdk.openadsdk.component.reward.a.f fVar = TTBaseVideoActivity.this.b.M;
                    float[] a2 = TTBaseVideoActivity.this.b.K.a(TTBaseVideoActivity.this.h);
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    fVar.a(a2, tTBaseVideoActivity, tTBaseVideoActivity.c);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void l() {
        Message message = new Message();
        message.what = 400;
        if (o()) {
            c(10000);
        }
        this.d.sendMessageDelayed(message, 2000);
    }

    /* access modifiers changed from: protected */
    public void m() {
        this.d.removeMessages(400);
    }

    private boolean u() {
        if (this.b.u.get() && this.b.s) {
            return false;
        }
        if ((this instanceof TTFullScreenExpressVideoActivity) || (this instanceof TTRewardExpressVideoActivity)) {
            return this.b.u.get();
        }
        return true;
    }

    public void finish() {
        super.finish();
        if (this.m > 0) {
            com.bytedance.sdk.openadsdk.j.b.a().a(SystemClock.elapsedRealtime() - this.m, getLocalClassName());
        }
        if (this.b != null) {
            if (com.bytedance.sdk.openadsdk.utils.t.e()) {
                ad.b((Activity) this);
            }
            if (t.b(this.b.a) && !this.b.u.get()) {
                ApmHelper.reportCustomError("invalid finish", "playable", new RuntimeException());
            }
        }
    }
}
