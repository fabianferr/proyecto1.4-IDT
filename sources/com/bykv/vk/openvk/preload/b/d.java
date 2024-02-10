package com.bykv.vk.openvk.preload.b;

import com.bykv.vk.openvk.preload.b.b.a;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Interceptor */
public abstract class d<IN, OUT> {
    private static AtomicLong g = new AtomicLong();
    d a;
    IN b;
    public OUT c;
    a d;
    b e;
    public long f;

    public abstract Object a(b<OUT> bVar, IN in) throws Throwable;

    /* access modifiers changed from: protected */
    public void a(Object... objArr) {
    }

    /* access modifiers changed from: package-private */
    public final void a(b bVar, d dVar, IN in, a aVar, Object[] objArr) {
        this.e = new m(bVar);
        this.a = dVar;
        this.b = in;
        this.d = aVar;
        if (dVar != null) {
            this.f = dVar.f;
        } else {
            long andIncrement = g.getAndIncrement();
            this.f = andIncrement;
            if (andIncrement < 0) {
                throw new RuntimeException("Pipeline ID use up!");
            }
        }
        a(objArr);
    }

    /* access modifiers changed from: protected */
    public final void b(Throwable th) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.c(this.e, this, th);
        }
    }
}
