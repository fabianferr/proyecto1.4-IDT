package com.teragence.library;

import com.teragence.library.i5;
import java.util.concurrent.ExecutorService;

public class g5 implements i5 {
    /* access modifiers changed from: private */
    public final i5 a;
    private final ExecutorService b;

    class a implements Runnable {
        final /* synthetic */ i5.a b;

        a(i5.a aVar) {
            this.b = aVar;
        }

        public void run() {
            g5.this.a.a(this.b);
        }
    }

    public g5(i5 i5Var, ExecutorService executorService) {
        this.a = i5Var;
        this.b = executorService;
    }

    public void a(i5.a aVar) {
        this.b.execute(new a(aVar));
    }
}
