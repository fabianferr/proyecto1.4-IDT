package com.teragence.library;

import com.teragence.client.i;
import com.teragence.client.service.k;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class y1 implements q1 {
    private final q1 a;
    private final long b;

    class a extends com.teragence.client.a<k> {
        final /* synthetic */ ExecutorService a;
        final /* synthetic */ com.teragence.client.a b;

        a(y1 y1Var, ExecutorService executorService, com.teragence.client.a aVar) {
            this.a = executorService;
            this.b = aVar;
        }

        public void a(k kVar) {
            List<Runnable> shutdownNow = this.a.shutdownNow();
            if (shutdownNow.size() > 0) {
                ((b) shutdownNow.get(0)).d = true;
            }
            this.b.a(kVar);
        }
    }

    private static class b implements Runnable {
        private final q1 b;
        private final long c;
        boolean d;

        private b(q1 q1Var, long j) {
            this.b = q1Var;
            this.c = j;
        }

        /* synthetic */ b(q1 q1Var, long j, a aVar) {
            this(q1Var, j);
        }

        public void run() {
            synchronized (this) {
                try {
                    wait(this.c);
                    if (!this.d) {
                        i.a("TimeLimitedPhoneStatePr", "time limit has ended - force phoneStateProvider.finish()");
                        this.b.a();
                    }
                } catch (Exception e) {
                    i.a("TimeLimitedPhoneStatePr", "run: ", (Throwable) e);
                }
            }
        }
    }

    public y1(q1 q1Var, long j) {
        this.a = q1Var;
        this.b = j;
    }

    public void a() {
        this.a.a();
    }

    public void a(com.teragence.client.a<k> aVar, boolean z) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        newSingleThreadExecutor.execute(new b(this, this.b, (a) null));
        this.a.a(new a(this, newSingleThreadExecutor, aVar), z);
    }
}
