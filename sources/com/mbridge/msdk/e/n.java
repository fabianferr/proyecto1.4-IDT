package com.mbridge.msdk.e;

import android.util.Log;
import com.mbridge.msdk.e.a.a.i;
import com.mbridge.msdk.e.a.f;
import com.mbridge.msdk.e.a.m;
import com.mbridge.msdk.e.a.o;
import com.mbridge.msdk.e.a.u;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Network */
final class n {
    private q a;
    private final int b;
    private final o c;
    private final v d;
    private final int e;
    private com.mbridge.msdk.e.a.n f;
    private final Executor g;

    public n(int i, o oVar, v vVar, int i2) {
        this.b = i;
        this.c = oVar;
        this.d = vVar;
        this.e = i2;
        this.g = new ThreadPoolExecutor(1, i, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "MBridgeReportResponseThread");
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
    }

    public final void a(q qVar) {
        this.a = qVar;
    }

    public final void a(s sVar, Map<String, String> map, boolean z) {
        u uVar;
        if (y.a((Object) map)) {
            q qVar = this.a;
            if (qVar != null) {
                try {
                    qVar.a(sVar, 0, "params is null");
                } catch (Exception e2) {
                    if (a.a) {
                        Log.e("TrackManager", "send error", e2);
                    }
                }
            }
        } else {
            try {
                if (!y.b((Object) this.f)) {
                    com.mbridge.msdk.e.a.a.b bVar = new com.mbridge.msdk.e.a.a.b(this.c.c());
                    f fVar = new f(this.g);
                    int i = this.b;
                    if (i <= 0) {
                        i = 4;
                    }
                    com.mbridge.msdk.e.a.n nVar = new com.mbridge.msdk.e.a.n(bVar, fVar, i, new i());
                    this.f = nVar;
                    nVar.a();
                }
                if (this.e == 1) {
                    uVar = new u(this.c.b(), 1, this.c.a());
                } else {
                    uVar = new u(this.c.b(), 1);
                }
                uVar.a(map);
                uVar.a(false);
                uVar.b(true);
                uVar.c(true);
                uVar.a(this.d);
                uVar.a(z ? m.b.HIGH : m.b.NORMAL);
                uVar.a(new b(this.a, sVar));
                uVar.a((o.a) new a(this.a, sVar));
                this.f.a(uVar);
            } catch (Exception e3) {
                if (a.a) {
                    Log.e("TrackManager", "send error", e3);
                }
                if (y.b((Object) this.a)) {
                    this.a.a(sVar, 0, e3.getMessage());
                }
            }
        }
    }

    /* compiled from: Network */
    private static final class b implements o.b {
        private final q a;
        private final s b;

        public b(q qVar, s sVar) {
            this.a = qVar;
            this.b = sVar;
        }

        public final void a(Object obj) {
            if (y.b((Object) this.a)) {
                try {
                    this.a.a(this.b);
                } catch (Exception e) {
                    if (a.a) {
                        Log.e("TrackManager", "onResponse error", e);
                    }
                }
            }
        }
    }

    /* compiled from: Network */
    private static final class a implements o.a {
        private final q a;
        private final s b;

        public a(q qVar, s sVar) {
            this.a = qVar;
            this.b = sVar;
        }

        public final void a(u uVar) {
            if (y.b((Object) this.a)) {
                try {
                    this.a.a(this.b, 0, uVar.getMessage());
                } catch (Exception e) {
                    if (a.a) {
                        Log.e("TrackManager", "onErrorResponse error", e);
                    }
                }
            }
        }
    }
}
