package com.startapp.sdk.components;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.facebook.appevents.UserDataStore;
import com.startapp.a3;
import com.startapp.b5;
import com.startapp.b8;
import com.startapp.bb;
import com.startapp.c7;
import com.startapp.f1;
import com.startapp.g7;
import com.startapp.h2;
import com.startapp.h3;
import com.startapp.h8;
import com.startapp.i2;
import com.startapp.i4;
import com.startapp.k8;
import com.startapp.k9;
import com.startapp.l3;
import com.startapp.l7;
import com.startapp.n4;
import com.startapp.o3;
import com.startapp.q1;
import com.startapp.q7;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.crashreport.ANRRemoteConfig;
import com.startapp.sdk.adsbase.e;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.TelephonyMetadata;
import com.startapp.sdk.adsbase.remoteconfig.WvfMetadata;
import com.startapp.sdk.common.advertisingid.AdvertisingIdResolver;
import com.startapp.sdk.jobs.SchedulerService;
import com.startapp.t1;
import com.startapp.u1;
import com.startapp.u3;
import com.startapp.u7;
import com.startapp.ua;
import com.startapp.v2;
import com.startapp.v5;
import com.startapp.va;
import com.startapp.w2;
import com.startapp.wa;
import com.startapp.x2;
import com.startapp.x3;
import com.startapp.x5;
import com.startapp.y3;
import com.startapp.y4;
import com.startapp.z8;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Sta */
public class ComponentLocator {
    public static final q1<ComponentLocator, Context> N = new k();
    public final n4<Executor> A;
    public final n4<Executor> B;
    public final n4<v2> C;
    public final n4<v2> D;
    public final n4<com.startapp.sdk.adsbase.e> E;
    public final n4<com.startapp.sdk.adsbase.e> F;
    public final n4<com.startapp.t> G;
    public final n4<com.startapp.m> H;
    public final n4<com.startapp.sdk.adsbase.crashreport.b> I;
    public final n4<com.startapp.sdk.ads.video.h> J;
    public final n4<h2<Context, List<String>, TrackingParams, h3>> K;
    public final n4<com.startapp.d> L;
    public final n4<com.startapp.e0> M;
    public final n4<va> a;
    public final n4<ua> b;
    public final n4<y4> c;
    public final n4<x3> d;
    public final n4<h8> e;
    public final n4<k8> f;
    public final n4<AdvertisingIdResolver> g;
    public final n4<c7> h;
    public final n4<u1> i;
    public final n4<y3> j;
    public final n4<u7> k = new n4<>(new g(this));
    public final n4<z8> l;
    public final n4<com.startapp.b0> m;
    public final n4<a3> n;
    public final n4<b8> o;
    public final n4<com.startapp.y> p;
    public final n4<o3> q;
    public final n4<f1> r;
    public final n4<q7> s;
    public final n4<t1> t;
    public final n4<g7> u;
    public final n4<i4> v;
    public final n4<b5> w;
    public final n4<v2> x;
    public final n4<Executor> y;
    public final n4<Executor> z;

    /* compiled from: Sta */
    public class a implements i2<h8> {
        public final /* synthetic */ Context a;
        public final /* synthetic */ i2 b;

        public a(Context context, i2 i2Var) {
            this.a = context;
            this.b = i2Var;
        }

        public Object a() {
            return new h8(this.a, new com.startapp.sdk.adsbase.e(this.a.getSharedPreferences("StartApp-6d5362e8ecc8a910", 0), (e.b) null), ComponentLocator.this.i(), ComponentLocator.this.g(), this.b, new a(this));
        }
    }

    /* compiled from: Sta */
    public class a0 implements i2<v2> {
        public a0(ComponentLocator componentLocator) {
        }

        public Object a() {
            return ComponentLocator.a("dc");
        }
    }

    /* compiled from: Sta */
    public class b implements i2<k8> {
        public final /* synthetic */ Context a;
        public final /* synthetic */ i2 b;

        public b(Context context, i2 i2Var) {
            this.a = context;
            this.b = i2Var;
        }

        public Object a() {
            return new k8(this.a, ComponentLocator.this.i(), new com.startapp.sdk.adsbase.e(this.a.getSharedPreferences("StartApp-c5f5846c2a728b2a", 0), (e.b) null), ComponentLocator.this.g(), this.b);
        }
    }

    /* compiled from: Sta */
    public class b0 implements i2<v2> {
        public b0(ComponentLocator componentLocator) {
        }

        public Object a() {
            return new w2(new Handler(Looper.getMainLooper()));
        }
    }

    /* compiled from: Sta */
    public class c implements i2<AdvertisingIdResolver> {
        public final /* synthetic */ Context a;

        public c(ComponentLocator componentLocator, Context context) {
            this.a = context;
        }

        public Object a() {
            return new AdvertisingIdResolver(this.a, new m0("air"), new b(this));
        }
    }

    /* compiled from: Sta */
    public class c0 implements i2<com.startapp.sdk.adsbase.e> {
        public final /* synthetic */ Context a;

        public c0(ComponentLocator componentLocator, Context context) {
            this.a = context;
        }

        public Object a() {
            return new com.startapp.sdk.adsbase.e(this.a.getSharedPreferences("com.startapp.sdk", 0), (e.b) null);
        }
    }

    /* compiled from: Sta */
    public class d implements i2<c7> {
        public final /* synthetic */ Context a;

        public d(ComponentLocator componentLocator, Context context) {
            this.a = context;
        }

        public Object a() {
            return new c7(this.a, new c(this));
        }
    }

    /* compiled from: Sta */
    public class d0 implements i2<com.startapp.sdk.adsbase.e> {
        public final /* synthetic */ Context a;

        public d0(ComponentLocator componentLocator, Context context) {
            this.a = context;
        }

        public Object a() {
            return new com.startapp.sdk.adsbase.e(this.a.getSharedPreferences("com.startapp.sdk.extras", 0), new s(this));
        }
    }

    /* compiled from: Sta */
    public class e implements i2<u1> {
        public final /* synthetic */ Context a;

        public e(Context context) {
            this.a = context;
        }

        public Object a() {
            return new u1(this.a, ComponentLocator.this.e());
        }
    }

    /* compiled from: Sta */
    public class e0 implements i2<com.startapp.t> {
        public final /* synthetic */ Context a;

        public e0(ComponentLocator componentLocator, Context context) {
            this.a = context;
        }

        public Object a() {
            return new com.startapp.t(this.a);
        }
    }

    /* compiled from: Sta */
    public class f implements i2<y3> {
        public final /* synthetic */ Context a;

        public f(ComponentLocator componentLocator, Context context) {
            this.a = context;
        }

        public Object a() {
            return new y3(new com.startapp.sdk.adsbase.e(this.a.getSharedPreferences("StartApp-54ff24db2aee60b9", 0), (e.b) null));
        }
    }

    /* compiled from: Sta */
    public class f0 implements i2<com.startapp.m> {
        public final /* synthetic */ Context a;

        public f0(ComponentLocator componentLocator, Context context) {
            this.a = context;
        }

        public Object a() {
            return new com.startapp.m(this.a, new t(this));
        }
    }

    /* compiled from: Sta */
    public class g implements i2<u7> {
        public g(ComponentLocator componentLocator) {
        }

        public Object a() {
            return new u7();
        }
    }

    /* compiled from: Sta */
    public class g0 implements i2<WvfMetadata> {
        public g0(ComponentLocator componentLocator) {
        }

        public Object a() {
            return MetaData.k.R();
        }
    }

    /* compiled from: Sta */
    public class h implements i2<z8> {
        public final /* synthetic */ Context a;

        public h(Context context) {
            this.a = context;
        }

        public Object a() {
            return new z8(this.a.getPackageName(), new com.startapp.sdk.adsbase.e(this.a.getSharedPreferences("StartApp-fba1a5307d96ef31", 0), (e.b) null), ComponentLocator.a(0, 1, "tlp", 5), ComponentLocator.this.o(), ComponentLocator.this.a(), new d(this), new e(this));
        }
    }

    /* compiled from: Sta */
    public class h0 implements i2<com.startapp.sdk.ads.video.h> {
        public final /* synthetic */ Context a;

        public h0(Context context) {
            this.a = context;
        }

        public Object a() {
            return new com.startapp.sdk.ads.video.h(this.a, ComponentLocator.this.z.a(), com.startapp.sdk.adsbase.cache.d.h);
        }
    }

    /* compiled from: Sta */
    public class i implements i2<com.startapp.b0> {
        public final /* synthetic */ Context a;

        public i(ComponentLocator componentLocator, Context context) {
            this.a = context;
        }

        public Object a() {
            return new com.startapp.b0(new com.startapp.sdk.adsbase.e(this.a.getSharedPreferences("StartApp-790ba54ab8e69f2f", 0), (e.b) null));
        }
    }

    /* compiled from: Sta */
    public class i0 implements i2<h2<Context, List<String>, TrackingParams, h3>> {
        public i0(ComponentLocator componentLocator) {
        }

        public Object a() {
            return new v(this);
        }
    }

    /* compiled from: Sta */
    public class j implements i2<a3> {
        public final /* synthetic */ Context a;
        public final /* synthetic */ n4 b;

        public j(Context context, n4 n4Var) {
            this.a = context;
            this.b = n4Var;
        }

        public Object a() {
            return new a3(ComponentLocator.this.a(), new f(this), ComponentLocator.this.p(), new v5(this.a, new com.startapp.sdk.adsbase.e(this.a.getSharedPreferences("StartApp-770c613f81fb5b52", 0), (e.b) null), new x5(this.a, "StartApp-ac51a09f00e0f80c"), (Executor) this.b.a(), new g(this)), new h(this));
        }
    }

    /* compiled from: Sta */
    public class j0 implements i2<com.startapp.d> {
        public final /* synthetic */ Context a;

        public j0(Context context) {
            this.a = context;
        }

        public Object a() {
            return new com.startapp.d(this.a, ComponentLocator.this.g, new w(this));
        }
    }

    /* compiled from: Sta */
    public class k extends q1<ComponentLocator, Context> {
    }

    /* compiled from: Sta */
    public class k0 implements i2<com.startapp.e0> {
        public k0(ComponentLocator componentLocator) {
        }

        public Object a() {
            return new com.startapp.e0(new x(this), new y(this));
        }
    }

    /* compiled from: Sta */
    public class l implements i2<b8> {
        public final /* synthetic */ Context a;

        public l(ComponentLocator componentLocator, Context context) {
            this.a = context;
        }

        public Object a() {
            return new b8(this.a, new com.startapp.sdk.adsbase.e(this.a.getSharedPreferences("StartApp-9b9bfdb86df82dad", 0), (e.b) null), new k(this));
        }
    }

    /* compiled from: Sta */
    public class l0 implements RejectedExecutionHandler {
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            try {
                threadPoolExecutor.getQueue().put(runnable);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* compiled from: Sta */
    public class m implements i2<com.startapp.y> {
        public final /* synthetic */ Context a;

        public m(ComponentLocator componentLocator, Context context) {
            this.a = context;
        }

        public Object a() {
            return new com.startapp.y(this.a);
        }
    }

    /* compiled from: Sta */
    public class m0 implements ThreadFactory {
        public final AtomicInteger a = new AtomicInteger();
        public final /* synthetic */ String b;

        public m0(String str) {
            this.b = str;
        }

        public Thread newThread(Runnable runnable) {
            StringBuilder a2 = com.startapp.p0.a("startapp-");
            a2.append(this.b);
            a2.append("-");
            a2.append(this.a.incrementAndGet());
            return new Thread(runnable, a2.toString());
        }
    }

    /* compiled from: Sta */
    public class n implements i2<o3> {
        public final /* synthetic */ Context a;
        public final /* synthetic */ n4 b;

        public n(Context context, n4 n4Var) {
            this.a = context;
            this.b = n4Var;
        }

        public Object a() {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 2, 5, TimeUnit.SECONDS, new PriorityBlockingQueue(), new m0("info"));
            l lVar = new l(this, threadPoolExecutor);
            t1 f = ComponentLocator.this.f();
            Context context = this.a;
            ComponentLocator componentLocator = ComponentLocator.this;
            return new o3(new l3(this.a, "StartApp-d6864f2502af7851"), (v2) this.b.a(), threadPoolExecutor, lVar, f, new u3(context, componentLocator.n, componentLocator.h), new m(this));
        }
    }

    /* compiled from: Sta */
    public class n0 implements i2<va> {
        public final /* synthetic */ i2 a;
        public final /* synthetic */ Context b;

        public n0(i2 i2Var, Context context) {
            this.a = i2Var;
            this.b = context;
        }

        public Object a() {
            WvfMetadata wvfMetadata = (WvfMetadata) this.a.a();
            if (wvfMetadata != null && k9.a(wvfMetadata.b())) {
                return new bb(this.b, this.a);
            }
            Context context = this.b;
            ComponentLocator componentLocator = ComponentLocator.this;
            return new wa(context, componentLocator.B, componentLocator.D, this.a);
        }
    }

    /* compiled from: Sta */
    public class o implements i2<f1> {
        public final /* synthetic */ Context a;

        public o(Context context) {
            this.a = context;
        }

        public Object a() {
            return new f1(this.a, ComponentLocator.this.e(), new com.startapp.sdk.adsbase.e(this.a.getSharedPreferences("StartApp-dfeaf103310003d9", 0), (e.b) null), ComponentLocator.this.g(), ComponentLocator.this.i(), new n(this));
        }
    }

    /* compiled from: Sta */
    public class o0 implements i2<ua> {
        public final /* synthetic */ Context a;

        public o0(Context context) {
            this.a = context;
        }

        public Object a() {
            return new ua(this.a, ComponentLocator.this.x());
        }
    }

    /* compiled from: Sta */
    public class p implements i2<q7> {
        public final /* synthetic */ Context a;

        public p(Context context) {
            this.a = context;
        }

        public Object a() {
            return new q7(this.a, new com.startapp.sdk.adsbase.e(this.a.getSharedPreferences("StartApp-6cd3cac226013e8e", 0), (e.b) null), ComponentLocator.this.g(), ComponentLocator.this.i(), new o(this));
        }
    }

    /* compiled from: Sta */
    public class p0 implements i2<v2> {
        public p0(ComponentLocator componentLocator) {
        }

        public Object a() {
            return ComponentLocator.a(UserDataStore.DATE_OF_BIRTH);
        }
    }

    /* compiled from: Sta */
    public class q implements i2<t1> {
        public final /* synthetic */ Context a;

        public q(ComponentLocator componentLocator, Context context) {
            this.a = context;
        }

        public Object a() {
            return new t1(this.a, new p(this));
        }
    }

    /* compiled from: Sta */
    public class q0 implements i2<y4> {
        public final /* synthetic */ Context a;

        public q0(ComponentLocator componentLocator, Context context) {
            this.a = context;
        }

        public Object a() {
            return new y4(this.a);
        }
    }

    /* compiled from: Sta */
    public class r implements i2<g7> {
        public final /* synthetic */ Context a;

        public r(Context context) {
            this.a = context;
        }

        public Object a() {
            return new g7(this.a, ComponentLocator.this.l(), new q(this));
        }
    }

    /* compiled from: Sta */
    public class r0 implements i2<x3> {
        public final /* synthetic */ Context a;

        public r0(ComponentLocator componentLocator, Context context) {
            this.a = context;
        }

        public Object a() {
            return new x3(this.a);
        }
    }

    /* compiled from: Sta */
    public class s implements i2<i4> {
        public final /* synthetic */ Context a;

        public s(ComponentLocator componentLocator, Context context) {
            this.a = context;
        }

        public Object a() {
            Pair pair;
            Context context = this.a;
            com.startapp.sdk.jobs.f fVar = new com.startapp.sdk.jobs.f(context);
            if (Build.VERSION.SDK_INT >= 21) {
                pair = new Pair(new com.startapp.sdk.jobs.c(context, SchedulerService.class), fVar);
            } else {
                pair = new Pair(fVar, fVar);
            }
            return new i4((l7) pair.first, (l7) pair.second);
        }
    }

    /* compiled from: Sta */
    public class s0 implements i2<TelephonyMetadata> {
        public s0(ComponentLocator componentLocator) {
        }

        public Object a() {
            return MetaData.k.O();
        }
    }

    /* compiled from: Sta */
    public class t implements i2<b5> {
        public final /* synthetic */ Context a;

        public t(ComponentLocator componentLocator, Context context) {
            this.a = context;
        }

        public Object a() {
            return new b5(this.a, new com.startapp.sdk.adsbase.e(this.a.getSharedPreferences("StartApp-b36110d5cb803404", 0), (e.b) null), new r(this), new Handler(Looper.getMainLooper()));
        }
    }

    /* compiled from: Sta */
    public class u implements i2<v2> {
        public u(ComponentLocator componentLocator) {
        }

        public Object a() {
            return ComponentLocator.a("core");
        }
    }

    /* compiled from: Sta */
    public class v implements i2<com.startapp.sdk.adsbase.crashreport.b> {
        public final /* synthetic */ Context a;

        public v(ComponentLocator componentLocator, Context context) {
            this.a = context;
        }

        public Object a() {
            ANRRemoteConfig f = MetaData.k.f();
            com.startapp.sdk.adsbase.crashreport.b bVar = new com.startapp.sdk.adsbase.crashreport.b(f != null ? f.c() : 2000, f != null && f.g());
            if (f != null && f.e()) {
                bVar.b = new i(this, f);
                bVar.a = new com.startapp.sdk.adsbase.crashreport.a(this.a, "com.startapp.", f.h(), f.a(), f.d());
                if (f.f()) {
                    bVar.d = new j(this);
                }
                bVar.start();
            }
            return bVar;
        }
    }

    /* compiled from: Sta */
    public class w implements i2<Executor> {
        public w(ComponentLocator componentLocator) {
        }

        public Object a() {
            return ComponentLocator.a(0, 4, "net-api", 10);
        }
    }

    /* compiled from: Sta */
    public class x implements i2<Executor> {
        public x(ComponentLocator componentLocator) {
        }

        public Object a() {
            return ComponentLocator.a(0, 2, "net-media", 10);
        }
    }

    /* compiled from: Sta */
    public class y implements i2<Executor> {
        public y(ComponentLocator componentLocator) {
        }

        public Object a() {
            return ComponentLocator.a(0, 2, "disk", 5);
        }
    }

    /* compiled from: Sta */
    public class z implements i2<Executor> {
        public z(ComponentLocator componentLocator) {
        }

        public Object a() {
            return ComponentLocator.a(0, 4, "generic", 5);
        }
    }

    public ComponentLocator(Context context) {
        this.I = new n4<>(new v(this, context));
        this.a = new n4<>(new n0(new g0(this), context));
        this.b = new n4<>(new o0(context));
        n4 n4Var = new n4(new p0(this));
        this.c = new n4<>(new q0(this, context));
        this.d = new n4<>(new r0(this, context));
        s0 s0Var = new s0(this);
        this.e = new n4<>(new a(context, s0Var));
        this.f = new n4<>(new b(context, s0Var));
        this.g = new n4<>(new c(this, context));
        this.h = new n4<>(new d(this, context));
        this.i = new n4<>(new e(context));
        this.j = new n4<>(new f(this, context));
        this.l = new n4<>(new h(context));
        this.m = new n4<>(new i(this, context));
        this.n = new n4<>(new j(context, n4Var));
        this.o = new n4<>(new l(this, context));
        this.p = new n4<>(new m(this, context));
        this.q = new n4<>(new n(context, n4Var));
        this.r = new n4<>(new o(context));
        this.s = new n4<>(new p(context));
        this.t = new n4<>(new q(this, context));
        this.u = new n4<>(new r(context));
        this.v = new n4<>(new s(this, context));
        this.w = new n4<>(new t(this, context));
        this.x = new n4<>(new u(this));
        this.y = new n4<>(new w(this));
        this.z = new n4<>(new x(this));
        this.A = new n4<>(new y(this));
        this.B = new n4<>(new z(this));
        this.C = new n4<>(new a0(this));
        this.D = new n4<>(new b0(this));
        this.E = new n4<>(new c0(this, context));
        this.F = new n4<>(new d0(this, context));
        this.G = new n4<>(new e0(this, context));
        this.H = new n4<>(new f0(this, context));
        this.J = new n4<>(new h0(context));
        this.K = new n4<>(new i0(this));
        this.L = new n4<>(new j0(context));
        this.M = new n4<>(new k0(this));
    }

    public static ComponentLocator a(Context context) {
        q1<ComponentLocator, Context> q1Var = N;
        T t2 = q1Var.a;
        if (t2 == null) {
            synchronized (q1Var) {
                t2 = q1Var.a;
                if (t2 == null) {
                    Context a2 = com.startapp.h0.a(context);
                    if (a2 != null) {
                        context = a2;
                    }
                    t2 = new ComponentLocator(context);
                    q1Var.a = t2;
                }
            }
        }
        return (ComponentLocator) t2;
    }

    public com.startapp.y b() {
        return this.p.a();
    }

    public com.startapp.b0 c() {
        return this.m.a();
    }

    public com.startapp.e0 d() {
        return this.M.a();
    }

    public com.startapp.sdk.adsbase.e e() {
        return this.E.a();
    }

    public t1 f() {
        return this.t.a();
    }

    public u1 g() {
        return this.i.a();
    }

    public v2 h() {
        return this.x.a();
    }

    public v2 i() {
        return this.C.a();
    }

    public Executor j() {
        return this.A.a();
    }

    public com.startapp.sdk.adsbase.e k() {
        return this.F.a();
    }

    public Executor l() {
        return this.B.a();
    }

    public a3 m() {
        return this.n.a();
    }

    public o3 n() {
        return this.q.a();
    }

    public i4 o() {
        return this.v.a();
    }

    public y4 p() {
        return this.c.a();
    }

    public b5 q() {
        return this.w.a();
    }

    public Executor r() {
        return this.y.a();
    }

    public c7 s() {
        return this.h.a();
    }

    public g7 t() {
        return this.u.a();
    }

    public u7 u() {
        return this.k.a();
    }

    public h8 v() {
        return this.e.a();
    }

    public k8 w() {
        return this.f.a();
    }

    public va x() {
        return this.a.a();
    }

    public static ThreadFactory b(String str) {
        return new m0(str);
    }

    public AdvertisingIdResolver a() {
        return this.g.a();
    }

    public static Executor a(int i2, int i3, String str, long j2) {
        if (Build.VERSION.SDK_INT >= 21) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i3, j2, TimeUnit.SECONDS, new LinkedTransferQueue<Runnable>() {
                public boolean offer(Object obj) {
                    return tryTransfer((Runnable) obj);
                }
            }, new m0(str), new l0());
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return threadPoolExecutor;
        } else if (i3 < 2) {
            return Executors.newSingleThreadExecutor(new m0(str));
        } else {
            return Executors.newCachedThreadPool(new m0(str));
        }
    }

    public static v2 a(String str) {
        x2 x2Var = new x2("startapp-" + str);
        x2Var.start();
        return new w2(new Handler(x2Var.getLooper()));
    }
}
