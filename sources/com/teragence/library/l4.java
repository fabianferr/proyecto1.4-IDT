package com.teragence.library;

import com.teragence.library.n4;
import java.util.concurrent.ExecutorService;

public class l4 implements n4 {
    /* access modifiers changed from: private */
    public final n4 a;
    private final ExecutorService b;

    class a implements Runnable {
        final /* synthetic */ n4.a b;

        a(n4.a aVar) {
            this.b = aVar;
        }

        public void run() {
            l4.this.a.a(this.b);
        }
    }

    public l4(n4 n4Var, ExecutorService executorService) {
        this.a = n4Var;
        this.b = executorService;
    }

    public void a(n4.a aVar) {
        this.b.execute(new a(aVar));
    }
}
