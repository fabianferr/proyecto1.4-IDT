package com.teragence.library;

import com.teragence.library.h3;
import java.util.concurrent.ExecutorService;

public class e3 implements h3 {
    /* access modifiers changed from: private */
    public final h3 a;
    private final ExecutorService b;

    class a implements Runnable {
        final /* synthetic */ h3.a b;

        a(h3.a aVar) {
            this.b = aVar;
        }

        public void run() {
            e3.this.a.a(this.b);
        }
    }

    public e3(h3 h3Var, ExecutorService executorService) {
        this.a = h3Var;
        this.b = executorService;
    }

    public void a(h3.a aVar) {
        this.b.execute(new a(aVar));
    }
}
