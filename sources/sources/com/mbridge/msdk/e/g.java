package com.mbridge.msdk.e;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: EventProcessor */
final class g implements l {
    /* access modifiers changed from: private */
    public final c a;
    /* access modifiers changed from: private */
    public final r b;
    private final j c;
    private final AtomicLong d = new AtomicLong(0);
    private final long[] e = new long[2];

    public g(c cVar, r rVar, j jVar) {
        this.a = cVar;
        this.b = rVar;
        this.c = jVar;
    }

    public final void a(e eVar) {
        long incrementAndGet = this.d.incrementAndGet();
        this.e[0] = System.currentTimeMillis();
        this.e[1] = incrementAndGet;
    }

    public final void b(final e eVar) {
        this.c.b(new Runnable() {
            public final void run() {
                i iVar = new i(eVar);
                iVar.a(1);
                iVar.b(0);
                iVar.a(System.currentTimeMillis() + eVar.h());
                g.this.b.c();
                if (g.this.a.a(iVar) > 0) {
                    g.this.b.a(eVar);
                }
            }
        });
    }

    public final long[] a() {
        long[] jArr = this.e;
        if (jArr.length == 0) {
            return new long[]{0, 0};
        }
        return jArr;
    }
}
