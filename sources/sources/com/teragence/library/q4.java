package com.teragence.library;

import com.teragence.library.s4;
import java.util.concurrent.ExecutorService;

public class q4 implements s4 {
    private final ExecutorService a;
    /* access modifiers changed from: private */
    public final s4 b;

    class a implements Runnable {
        final /* synthetic */ s4.a b;

        a(s4.a aVar) {
            this.b = aVar;
        }

        public void run() {
            q4.this.b.a(this.b);
        }
    }

    public q4(s4 s4Var, ExecutorService executorService) {
        this.a = executorService;
        this.b = s4Var;
    }

    public void a(s4.a aVar) {
        this.a.execute(new a(aVar));
    }
}
