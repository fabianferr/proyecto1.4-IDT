package com.mbridge.msdk.e.a;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: ExecutorDelivery */
public final class f implements q {
    private final Executor a;

    public f(final Handler handler) {
        this.a = new Executor() {
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public f(Executor executor) {
        this.a = executor;
    }

    public final void a(m<?> mVar, o<?> oVar) {
        a(mVar, oVar, (Runnable) null);
    }

    public final void a(m<?> mVar, o<?> oVar, Runnable runnable) {
        mVar.s();
        this.a.execute(new a(mVar, oVar, runnable));
    }

    public final void a(m<?> mVar, u uVar) {
        this.a.execute(new a(mVar, o.a(uVar), (Runnable) null));
    }

    /* compiled from: ExecutorDelivery */
    private static class a implements Runnable {
        private final m a;
        private final o b;
        private final Runnable c;

        public a(m mVar, o oVar, Runnable runnable) {
            this.a = mVar;
            this.b = oVar;
            this.c = runnable;
        }

        public final void run() {
            if (this.a.l()) {
                this.a.a("canceled-at-delivery");
                return;
            }
            if (this.b.a()) {
                this.a.a(this.b.a);
            } else {
                this.a.a(this.b.c);
            }
            if (!this.b.d) {
                this.a.a("done");
            }
            Runnable runnable = this.c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}
