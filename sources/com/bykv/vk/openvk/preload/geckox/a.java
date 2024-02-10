package com.bykv.vk.openvk.preload.geckox;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.openvk.preload.geckox.d.a.b.c;
import com.bykv.vk.openvk.preload.geckox.d.b.b.f;
import com.bykv.vk.openvk.preload.geckox.d.d;
import com.bykv.vk.openvk.preload.geckox.d.e;
import com.bykv.vk.openvk.preload.geckox.d.g;
import com.bykv.vk.openvk.preload.geckox.d.h;
import com.bykv.vk.openvk.preload.geckox.e.b;
import com.bykv.vk.openvk.preload.geckox.model.CheckRequestBodyModel;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import com.bykv.vk.openvk.preload.geckox.statistic.model.a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: GeckoClient */
public final class a {
    b a = new b();
    Queue<String> b = new LinkedBlockingQueue();
    b c;
    File d;
    private final List<String> e = new ArrayList();

    a(b bVar) {
        this.c = bVar;
        File file = bVar.p;
        this.d = file;
        file.mkdirs();
        b bVar2 = this.c;
        a(e.class, com.bykv.vk.openvk.preload.geckox.statistic.b.a(bVar2));
        a(d.class, com.bykv.vk.openvk.preload.geckox.statistic.b.a(bVar2));
        a(c.class, com.bykv.vk.openvk.preload.geckox.statistic.b.b(bVar2.a));
        a(com.bykv.vk.openvk.preload.geckox.d.a.b.b.class, new com.bykv.vk.openvk.preload.b.b.a() {
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar) {
                super.b(bVar, dVar);
                a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel()).i = true;
            }

            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.i = false;
                a.l = SystemClock.uptimeMillis();
                a.s = th.getMessage();
            }
        });
        a(com.bykv.vk.openvk.preload.geckox.d.a.b.d.class, new com.bykv.vk.openvk.preload.b.b.a() {
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar) {
                super.b(bVar, dVar);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.j = true;
                a.m = SystemClock.uptimeMillis();
            }

            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.j = false;
                a.m = SystemClock.uptimeMillis();
                a.t = th.getMessage();
            }
        });
        a(com.bykv.vk.openvk.preload.geckox.d.a.b.a.class, new com.bykv.vk.openvk.preload.b.b.a() {
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar) {
                super.b(bVar, dVar);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.j = true;
                a.n = SystemClock.uptimeMillis();
            }

            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.j = false;
                a.n = SystemClock.uptimeMillis();
                a.t = th.getMessage();
            }
        });
        a(com.bykv.vk.openvk.preload.geckox.d.a.b.e.class, new com.bykv.vk.openvk.preload.b.b.a() {
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar) {
                super.b(bVar, dVar);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.k = true;
                a.o = SystemClock.uptimeMillis();
            }

            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.k = false;
                a.u = th.getMessage();
                a.o = SystemClock.uptimeMillis();
            }
        });
        a(com.bykv.vk.openvk.preload.geckox.d.a.a.b.class, com.bykv.vk.openvk.preload.geckox.statistic.b.a(bVar2.a));
        a(com.bykv.vk.openvk.preload.geckox.d.a.a.a.class, new com.bykv.vk.openvk.preload.b.b.a() {
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar) {
                super.b(bVar, dVar);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a.C = true;
                a.z = SystemClock.uptimeMillis();
            }

            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a.C = false;
                a.z = SystemClock.uptimeMillis();
                a.E = th.getMessage();
            }
        });
        a(com.bykv.vk.openvk.preload.geckox.d.a.a.c.class, new com.bykv.vk.openvk.preload.b.b.a() {
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar) {
                super.b(bVar, dVar);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a.D = true;
                a.A = SystemClock.uptimeMillis();
            }

            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a.D = false;
                a.A = SystemClock.uptimeMillis();
                a.F = th.getMessage();
            }
        });
        a(com.bykv.vk.openvk.preload.geckox.d.b.b.c.class, com.bykv.vk.openvk.preload.geckox.statistic.b.b(bVar2.a));
        a(com.bykv.vk.openvk.preload.geckox.d.b.b.b.class, new com.bykv.vk.openvk.preload.b.b.a() {
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar) {
                super.b(bVar, dVar);
                a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel()).i = true;
            }

            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.i = false;
                a.l = SystemClock.uptimeMillis();
                a.s = th.getMessage();
            }
        });
        a(com.bykv.vk.openvk.preload.geckox.d.b.b.d.class, new com.bykv.vk.openvk.preload.b.b.a() {
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar) {
                super.b(bVar, dVar);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.j = true;
                a.m = SystemClock.uptimeMillis();
            }

            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.j = false;
                a.m = SystemClock.uptimeMillis();
                a.t = th.getMessage();
            }
        });
        a(com.bykv.vk.openvk.preload.geckox.d.b.b.a.class, new com.bykv.vk.openvk.preload.b.b.a() {
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar) {
                super.b(bVar, dVar);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.j = true;
                a.n = SystemClock.uptimeMillis();
            }

            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.j = false;
                a.n = SystemClock.uptimeMillis();
                a.t = th.getMessage();
            }
        });
        a(f.class, new com.bykv.vk.openvk.preload.b.b.a() {
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar) {
                super.b(bVar, dVar);
            }

            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.k = false;
                a.o = SystemClock.uptimeMillis();
                a.u = th.getMessage();
            }

            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar, Throwable th) {
                super.b(bVar, dVar, th);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.k = false;
                a.o = SystemClock.uptimeMillis();
                a.F = th.getMessage();
            }

            public final <T> void c(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar) {
                super.c(bVar, dVar);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.k = true;
                a.o = SystemClock.uptimeMillis();
            }
        });
        a(com.bykv.vk.openvk.preload.geckox.d.b.a.b.class, com.bykv.vk.openvk.preload.geckox.statistic.b.a(bVar2.a));
        a(com.bykv.vk.openvk.preload.geckox.d.b.a.a.class, new com.bykv.vk.openvk.preload.b.b.a() {
            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar) {
                super.b(bVar, dVar);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a.C = true;
                a.z = SystemClock.uptimeMillis();
            }

            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a.C = false;
                a.z = SystemClock.uptimeMillis();
                a.E = th.getMessage();
            }
        });
        a(com.bykv.vk.openvk.preload.geckox.d.b.a.d.class, new com.bykv.vk.openvk.preload.b.b.a() {
            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a.D = false;
                a.A = SystemClock.uptimeMillis();
                a.F = th.getMessage();
            }

            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar, Throwable th) {
                super.b(bVar, dVar, th);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a.D = false;
                a.A = SystemClock.uptimeMillis();
                a.F = th.getMessage();
            }

            public final <T> void c(com.bykv.vk.openvk.preload.b.b<T> bVar, com.bykv.vk.openvk.preload.b.d dVar) {
                super.c(bVar, dVar);
                a a = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a.D = true;
                a.A = SystemClock.uptimeMillis();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final boolean a(Map<String, List<CheckRequestBodyModel.TargetChannel>> map) {
        if (map.isEmpty()) {
            return true;
        }
        List<String> list = this.c.g;
        for (Map.Entry next : map.entrySet()) {
            boolean z = false;
            for (String equals : list) {
                if (TextUtils.equals(equals, (CharSequence) next.getKey())) {
                    z = true;
                }
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        List<String> list = this.c.h;
        List<String> list2 = this.c.g;
        if (list == null || list.isEmpty() || list2 == null || list2.isEmpty()) {
            return false;
        }
        for (String next : list2) {
            boolean z = false;
            for (String equals : list) {
                if (TextUtils.equals(next, equals)) {
                    z = true;
                }
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    private void a(Class<? extends com.bykv.vk.openvk.preload.b.d<?, ?>> cls, com.bykv.vk.openvk.preload.b.b.a aVar) {
        this.a.a(cls, aVar);
    }
}
