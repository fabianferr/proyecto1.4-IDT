package com.startapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.SystemClock;
import android.util.Pair;
import com.startapp.sdk.adsbase.remoteconfig.AnalyticsCategoryConfig;
import com.startapp.sdk.adsbase.remoteconfig.AnalyticsConfig;
import com.startapp.sdk.adsbase.remoteconfig.ConnectivityHelperMetadata;
import com.startapp.t1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Sta */
public class o3 {
    public final l3 a;
    public final v2 b;
    public final Executor c;
    public final i2<Integer> d;
    public final t1 e;
    public final h2<i3, k3, n3, t3> f;
    public final i2<AnalyticsConfig> g;
    public final Map<String, Pair<k3, Long>> h = new HashMap();
    public final AtomicLong i = new AtomicLong();
    public final i2<Void> j = new a();
    public final Runnable k = new b();
    public final i2<Void> l = new c();
    public final n3 m = new d();
    public final g2<i3, Void> n = new g();

    /* compiled from: Sta */
    public class a implements i2<Void> {
        public a() {
        }

        public Object a() {
            try {
                o3 o3Var = o3.this;
                o3Var.b.execute(new q3(o3Var));
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* compiled from: Sta */
    public class b implements Runnable {
        public b() {
        }

        public void run() {
            try {
                o3.this.b();
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: Sta */
    public class c implements i2<Void> {
        public c() {
        }

        public Object a() {
            try {
                o3.this.a(0);
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* compiled from: Sta */
    public class d implements n3 {
        public d() {
        }

        public void a(i3 i3Var, int i) {
            try {
                o3 o3Var = o3.this;
                o3Var.getClass();
                o3Var.b.execute(new p3(o3Var, i3Var, i, System.currentTimeMillis()));
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: Sta */
    public class e implements Runnable {
        public final /* synthetic */ i3 a;
        public final /* synthetic */ k3 b;
        public final /* synthetic */ n3 c;

        public e(i3 i3Var, k3 k3Var, n3 n3Var) {
            this.a = i3Var;
            this.b = k3Var;
            this.c = n3Var;
        }

        public void run() {
            int i;
            o3 o3Var = o3.this;
            i3 i3Var = this.a;
            k3 k3Var = this.b;
            n3 n3Var = this.c;
            o3Var.getClass();
            try {
                i = o3Var.a.a(i3Var, k3Var) ? 2 : 3;
                if (n3Var == null) {
                    return;
                }
            } catch (Throwable unused) {
                if (n3Var != null) {
                    i = 0;
                } else {
                    return;
                }
            }
            n3Var.a(i3Var, i);
        }
    }

    /* compiled from: Sta */
    public class f implements Runnable {
        public final /* synthetic */ i3 a;
        public final /* synthetic */ k3 b;
        public final /* synthetic */ n3 c;

        public f(long j, i3 i3Var, k3 k3Var, n3 n3Var) {
            this.a = i3Var;
            this.b = k3Var;
            this.c = n3Var;
        }

        public void run() {
            o3.this.a(this.a, this.b, this.c);
        }
    }

    /* compiled from: Sta */
    public class g implements g2<i3, Void> {
        public g() {
        }

        public Object a(Object obj) {
            i3 i3Var = (i3) obj;
            if (i3Var == null) {
                return null;
            }
            try {
                o3.this.a(i3Var);
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public o3(l3 l3Var, v2 v2Var, Executor executor, i2<Integer> i2Var, t1 t1Var, h2<i3, k3, n3, t3> h2Var, i2<AnalyticsConfig> i2Var2) {
        this.a = l3Var;
        this.b = v2Var;
        this.c = executor;
        this.d = i2Var;
        this.e = t1Var;
        this.f = h2Var;
        this.g = i2Var2;
    }

    /* JADX INFO: finally extract failed */
    public void a(i3 i3Var) {
        k3 a2 = a(i3Var.a);
        long uptimeMillis = (this.i.get() + a2.f) - SystemClock.uptimeMillis();
        if (uptimeMillis > 0) {
            a(uptimeMillis);
            return;
        }
        l3 l3Var = this.a;
        long currentTimeMillis = System.currentTimeMillis();
        l3Var.getClass();
        long j2 = i3Var.b;
        l3.a(j2, currentTimeMillis);
        SQLiteDatabase a3 = l3Var.a();
        a3.beginTransaction();
        try {
            int a4 = l3.a(a3, j2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("send", Long.valueOf(currentTimeMillis));
            contentValues.put("attempt", Integer.valueOf(a4 + 1));
            a3.update("events", contentValues, "rowid = ?", new String[]{String.valueOf(j2)});
            a3.setTransactionSuccessful();
            a3.endTransaction();
            a(i3Var, a2, this.m);
        } catch (Throwable th) {
            a3.endTransaction();
            throw th;
        }
    }

    public void b() {
        this.b.a(this.k);
        if (!this.e.a()) {
            AnalyticsConfig a2 = this.g.a();
            long j2 = 300000;
            if (a2 != null) {
                j2 = Math.max(300000, k9.e(a2.f()));
            }
            a(j2);
            return;
        }
        Integer a3 = this.d.a();
        int i2 = 1;
        int max = a3 != null ? Math.max(1, a3.intValue()) : 1;
        AnalyticsConfig a4 = this.g.a();
        if (a4 != null) {
            i2 = Math.max(1, a4.g());
        }
        try {
            this.a.a(this.n, i2, max);
        } catch (Throwable unused) {
        }
    }

    public void a() {
        ConnectivityManager connectivityManager;
        if (this.i.compareAndSet(0, SystemClock.uptimeMillis())) {
            l3 l3Var = this.a;
            i2<Void> i2Var = this.l;
            synchronized (l3Var) {
                l3Var.c.add(i2Var);
            }
            t1 t1Var = this.e;
            i2<Void> i2Var2 = this.j;
            synchronized (t1Var.c) {
                if (!t1Var.c.contains(i2Var2)) {
                    t1Var.c.add(i2Var2);
                }
            }
            t1 t1Var2 = this.e;
            if (!t1Var2.d.getAndSet(true)) {
                try {
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 21 && (connectivityManager = (ConnectivityManager) t1Var2.a.getSystemService("connectivity")) != null) {
                        connectivityManager.addDefaultNetworkActiveListener(new s1(t1Var2));
                        ConnectivityHelperMetadata a2 = t1Var2.b.a();
                        t1.a aVar = null;
                        ConnectivityHelperMetadata.Transport a3 = a2 != null ? a2.a() : null;
                        if (a3 != null) {
                            if (i2 >= 24 && k9.a(i2, a3.a())) {
                                aVar = new b(t1Var2.a, connectivityManager);
                            } else if (k9.a(i2, a3.b())) {
                                aVar = new w(t1Var2.a, connectivityManager);
                            }
                            if (aVar != null) {
                                aVar.b();
                                t1Var2.e = aVar;
                            }
                        }
                    }
                } catch (Throwable th) {
                    i3.a(th);
                }
            }
            this.b.execute(new q3(this));
        }
    }

    public final k3 a(j3 j3Var) {
        k3 k3Var;
        Map<String, AnalyticsCategoryConfig> d2;
        AnalyticsCategoryConfig analyticsCategoryConfig;
        synchronized (this.h) {
            Pair pair = this.h.get(j3Var.a);
            k3Var = (pair == null || SystemClock.uptimeMillis() >= ((Long) pair.second).longValue()) ? null : (k3) pair.first;
        }
        if (k3Var != null) {
            return k3Var;
        }
        AnalyticsConfig a2 = this.g.a();
        if (!(a2 == null || (d2 = a2.d()) == null || (analyticsCategoryConfig = d2.get(j3Var.a)) == null)) {
            k3Var = new k3(j3Var.b, analyticsCategoryConfig);
        }
        if (k3Var == null) {
            k3Var = j3Var.b;
        }
        synchronized (this.h) {
            this.h.put(j3Var.a, new Pair(k3Var, Long.valueOf(SystemClock.uptimeMillis() + 30000)));
        }
        return k3Var;
    }

    public void a(i3 i3Var, n3 n3Var) {
        AnalyticsConfig a2 = this.g.a();
        if (a2 != null && !a2.dns) {
            k3 a3 = a(i3Var.a);
            if (Math.random() < a3.a) {
                if (a3.d) {
                    this.b.execute(new e(i3Var, a3, (n3) null));
                } else if (this.e.a()) {
                    long uptimeMillis = (this.i.get() + a3.f) - SystemClock.uptimeMillis();
                    if (uptimeMillis > 0) {
                        this.b.a(new f(uptimeMillis, i3Var, a3, (n3) null), uptimeMillis);
                    } else {
                        a(i3Var, a3, (n3) null);
                    }
                }
            }
        }
    }

    public void a(long j2) {
        if (j2 < 0) {
            j2 = 0;
        }
        this.b.a(this.k, j2);
    }

    /* JADX INFO: finally extract failed */
    public void a(i3 i3Var, int i2, long j2) {
        if (i2 == 1) {
            l3 l3Var = this.a;
            l3Var.getClass();
            long j3 = i3Var.b;
            l3.a(j3, j2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("sendSuccess", Long.valueOf(j2));
            l3Var.a().update("events", contentValues, "rowid = ?", new String[]{String.valueOf(j3)});
            a(0);
            return;
        }
        AnalyticsConfig a2 = this.g.a();
        int max = a2 != null ? Math.max(1, a2.g()) : 1;
        l3 l3Var2 = this.a;
        l3Var2.getClass();
        long j4 = i3Var.b;
        l3.a(j4, j2);
        SQLiteDatabase a3 = l3Var2.a();
        a3.beginTransaction();
        try {
            if (l3.a(a3, j4) >= max) {
                a3.delete("events", "rowid = ?", new String[]{String.valueOf(j4)});
            } else {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("sendFailure", Long.valueOf(j2));
                a3.update("events", contentValues2, "rowid = ?", new String[]{String.valueOf(j4)});
            }
            a3.setTransactionSuccessful();
            a3.endTransaction();
            AnalyticsConfig a4 = this.g.a();
            long j5 = 1000;
            if (a4 != null) {
                j5 = Math.max(1000, a4.h());
            }
            a(j5);
        } catch (Throwable th) {
            a3.endTransaction();
            throw th;
        }
    }

    public void a(i3 i3Var, k3 k3Var, n3 n3Var) {
        Runnable a2 = this.f.a(i3Var, k3Var, n3Var);
        if (a2 != null) {
            this.c.execute(a2);
        } else if (n3Var != null) {
            n3Var.a(i3Var, 0);
        }
    }
}
