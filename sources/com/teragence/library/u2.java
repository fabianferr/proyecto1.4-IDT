package com.teragence.library;

import com.teragence.library.w2;
import java.util.concurrent.ExecutorService;

public class u2 implements w2 {
    /* access modifiers changed from: private */
    public final w2 a;
    private final ExecutorService b;

    class a implements Runnable {
        final /* synthetic */ w2.a b;
        final /* synthetic */ d2 c;

        a(w2.a aVar, d2 d2Var) {
            this.b = aVar;
            this.c = d2Var;
        }

        public void run() {
            u2.this.a.a(this.b, this.c);
        }
    }

    public u2(w2 w2Var, ExecutorService executorService) {
        this.a = w2Var;
        this.b = executorService;
    }

    public void a(w2.a aVar, d2 d2Var) {
        this.b.execute(new a(aVar, d2Var));
    }
}
