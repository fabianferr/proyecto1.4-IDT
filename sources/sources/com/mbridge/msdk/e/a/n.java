package com.mbridge.msdk.e.a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: RequestQueue */
public final class n {
    private final AtomicInteger a = new AtomicInteger();
    private final Set<m<?>> b = new HashSet();
    private final PriorityBlockingQueue<m<?>> c = new PriorityBlockingQueue<>();
    private final PriorityBlockingQueue<m<?>> d = new PriorityBlockingQueue<>();
    private final a e;
    private final h f;
    private final q g;
    private final i[] h;
    private b i;
    private final List<a> j = new ArrayList();

    /* compiled from: RequestQueue */
    public interface a {
        void a(m<?> mVar, int i);
    }

    public n(h hVar, q qVar, int i2, a aVar) {
        this.e = aVar;
        this.f = hVar;
        this.h = new i[i2];
        this.g = qVar;
    }

    public final <T> m<T> a(m<T> mVar) {
        mVar.a(this);
        synchronized (this.b) {
            this.b.add(mVar);
        }
        mVar.b(this.a.incrementAndGet());
        a(mVar, 0);
        if (!mVar.o()) {
            c(mVar);
        } else {
            this.c.add(mVar);
        }
        return mVar;
    }

    /* access modifiers changed from: package-private */
    public final <T> void b(m<T> mVar) {
        synchronized (this.b) {
            this.b.remove(mVar);
        }
        a(mVar, 5);
    }

    /* access modifiers changed from: package-private */
    public final void a(m<?> mVar, int i2) {
        synchronized (this.j) {
            for (a a2 : this.j) {
                a2.a(mVar, i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final <T> void c(m<T> mVar) {
        this.d.add(mVar);
    }

    public final void a() {
        b bVar = this.i;
        if (bVar != null) {
            bVar.a();
        }
        for (i iVar : this.h) {
            if (iVar != null) {
                iVar.a();
            }
        }
        b bVar2 = new b(this.c, this.d, this.e, this.g);
        this.i = bVar2;
        bVar2.start();
        for (int i2 = 0; i2 < this.h.length; i2++) {
            i iVar2 = new i(this.d, this.f, this.e, this.g);
            this.h[i2] = iVar2;
            iVar2.start();
        }
    }
}
