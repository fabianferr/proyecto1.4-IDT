package com.mbridge.msdk.e;

import android.util.Log;

/* compiled from: ProcessorWrapper */
final class p implements l {
    private final g a;

    public p(g gVar) {
        this.a = gVar;
    }

    public final void a(e eVar) {
        if (!y.a((Object) this.a)) {
            this.a.a(eVar);
        }
    }

    public final void b(e eVar) {
        if (!y.a((Object) this.a)) {
            try {
                h i = eVar.i();
                if (y.b((Object) i)) {
                    eVar.a(i.a(eVar));
                }
                this.a.b(eVar);
            } catch (Exception e) {
                if (a.a) {
                    Log.e("TrackManager", "process event error", e);
                }
            }
        }
    }

    public final long[] a() {
        if (y.a((Object) this.a)) {
            return new long[]{0, 0};
        }
        return this.a.a();
    }
}
