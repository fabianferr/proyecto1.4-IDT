package com.bytedance.sdk.openadsdk.component.reward.a;

import android.content.Context;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.common.f;
import com.bytedance.sdk.openadsdk.component.reward.b.b;
import com.bytedance.sdk.openadsdk.component.reward.view.RewardFullBaseLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.c;
import com.bytedance.sdk.openadsdk.component.reward.view.d;
import com.bytedance.sdk.openadsdk.component.reward.view.e;
import com.bytedance.sdk.openadsdk.core.model.o;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.i.h;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: RewardFullContext */
public class a {
    public final AtomicBoolean A = new AtomicBoolean(false);
    public final AtomicBoolean B = new AtomicBoolean(false);
    public final AtomicBoolean C = new AtomicBoolean(false);
    public final AtomicBoolean D = new AtomicBoolean(false);
    public final AtomicBoolean E = new AtomicBoolean(false);
    public final AtomicBoolean F = new AtomicBoolean(false);
    public final l G;
    public final d H;
    public final g I;
    public final c J;
    public final i K;
    public final h L;
    public final f M;
    public final c N;
    public final h O;
    public f P;
    public final m Q;
    public final j R;
    public final e S;
    public final e T;
    public final RewardFullBaseLayout U;
    public final TTBaseVideoActivity V;
    public final Context W;
    public final x X;
    public b Y;
    public final q a;
    public final boolean b;
    public String c;
    public boolean d;
    public boolean e = false;
    public final boolean f;
    public final String g;
    public int h;
    public boolean i;
    public int j = 1;
    public float k;
    public int l;
    public int m;
    public boolean n;
    public final int o;
    public boolean p;
    public boolean q;
    public long r = 0;
    public final boolean s;
    public int t = 0;
    public final AtomicBoolean u = new AtomicBoolean(false);
    public final AtomicBoolean v = new AtomicBoolean(false);
    public final AtomicBoolean w = new AtomicBoolean(false);
    public final AtomicBoolean x = new AtomicBoolean(false);
    public final AtomicBoolean y = new AtomicBoolean(false);
    public final AtomicBoolean z = new AtomicBoolean(false);

    public a(TTBaseVideoActivity tTBaseVideoActivity, x xVar, q qVar) {
        this.V = tTBaseVideoActivity;
        Context applicationContext = tTBaseVideoActivity.getApplicationContext();
        this.W = applicationContext;
        this.a = qVar;
        this.g = tTBaseVideoActivity.a;
        this.X = xVar;
        this.f = tTBaseVideoActivity.o();
        this.s = o.h(qVar);
        int aZ = qVar.aZ();
        this.o = aZ;
        this.d = com.bytedance.sdk.openadsdk.core.o.d().p(String.valueOf(aZ));
        this.b = com.bytedance.sdk.openadsdk.core.settings.o.ai().m(String.valueOf(aZ));
        this.K = new i(this);
        this.T = tTBaseVideoActivity.p() ? new e(this) : new d(this);
        this.U = new RewardFullBaseLayout(tTBaseVideoActivity);
        this.G = new l(this);
        this.H = new d(this);
        this.I = new g(this);
        this.J = new c(this);
        this.Q = new m(this);
        this.R = new j(this);
        this.S = new e(this);
        this.L = new h(this);
        this.M = new f(this);
        this.N = new c(this);
        this.O = new h(applicationContext);
    }

    public void a(boolean z2) {
        this.p = z2;
        this.R.d(z2);
    }
}
