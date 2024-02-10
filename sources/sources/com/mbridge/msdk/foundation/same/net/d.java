package com.mbridge.msdk.foundation.same.net;

import android.os.Handler;
import com.mbridge.msdk.foundation.tools.aa;
import java.util.concurrent.Executor;

/* compiled from: ExecutorDelivery */
public class d implements c {
    private final String a = "d";
    private final Executor b;

    public d(final Handler handler) {
        this.b = new Executor() {
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public final void a(j<?> jVar, l<?> lVar) {
        String str = this.a;
        aa.b(str, "postResponse response=" + lVar.a);
        Executor executor = this.b;
        if (executor != null) {
            executor.execute(new a(jVar, lVar));
        }
    }

    public final void a(j<?> jVar, com.mbridge.msdk.foundation.same.net.b.a aVar) {
        String str = this.a;
        aa.b(str, "postError error=" + aVar.a);
        if (this.b != null) {
            this.b.execute(new a(jVar, l.a(aVar)));
        }
    }

    public final void a(final j<?> jVar) {
        String str = this.a;
        aa.b(str, "postFinish request=" + jVar.b());
        Executor executor = this.b;
        if (executor != null) {
            executor.execute(new Runnable() {
                public final void run() {
                    jVar.q();
                }
            });
        }
    }

    public final void b(final j<?> jVar) {
        String str = this.a;
        aa.b(str, "postCancel request=" + jVar.b());
        Executor executor = this.b;
        if (executor != null) {
            executor.execute(new Runnable() {
                public final void run() {
                    jVar.o();
                }
            });
        }
    }

    public final void c(final j<?> jVar) {
        String str = this.a;
        aa.b(str, "postPreExecute request=" + jVar.b());
        Executor executor = this.b;
        if (executor != null) {
            executor.execute(new Runnable() {
                public final void run() {
                    jVar.p();
                }
            });
        }
    }

    public final void d(final j<?> jVar) {
        String str = this.a;
        aa.b(str, "postNetworking request=" + jVar.b());
        Executor executor = this.b;
        if (executor != null) {
            executor.execute(new Runnable() {
                public final void run() {
                    jVar.s();
                }
            });
        }
    }

    public final void e(final j<?> jVar) {
        String str = this.a;
        aa.b(str, "postRetry request=" + jVar.b());
        Executor executor = this.b;
        if (executor != null) {
            executor.execute(new Runnable() {
                public final void run() {
                    jVar.r();
                }
            });
        }
    }

    public final void a(j<?> jVar, long j, long j2) {
        String str = this.a;
        aa.b(str, "postDownloadProgress downloadedSize=" + j2 + "/ fileSize=" + j);
        Executor executor = this.b;
        if (executor != null) {
            final j<?> jVar2 = jVar;
            final long j3 = j;
            final long j4 = j2;
            executor.execute(new Runnable() {
                public final void run() {
                    jVar2.a(j3, j4);
                }
            });
        }
    }

    /* compiled from: ExecutorDelivery */
    private class a implements Runnable {
        private final j b;
        private final l c;

        public a(j jVar, l lVar) {
            this.b = jVar;
            this.c = lVar;
        }

        public final void run() {
            if (this.b.d()) {
                this.b.a("canceled-at-delivery");
                this.b.o();
                return;
            }
            if (this.c.b == null) {
                this.b.a(this.c);
            } else {
                this.b.a(this.c.b);
            }
            this.b.a("done");
            this.b.q();
        }
    }
}
