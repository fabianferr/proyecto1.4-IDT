package com.teragence.library;

import com.teragence.library.b3;
import java.util.concurrent.ExecutorService;

public class z2 implements b3 {
    /* access modifiers changed from: private */
    public final b3 a;
    private final ExecutorService b;

    class a implements Runnable {
        final /* synthetic */ b3.a b;

        a(b3.a aVar) {
            this.b = aVar;
        }

        public void run() {
            z2.this.a.a(this.b);
        }
    }

    public z2(b3 b3Var, ExecutorService executorService) {
        this.a = b3Var;
        this.b = executorService;
    }

    public void a(b3.a aVar) {
        this.b.execute(new a(aVar));
    }
}
