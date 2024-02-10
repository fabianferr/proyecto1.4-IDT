package com.teragence.library;

import com.teragence.library.c4;
import java.util.concurrent.ExecutorService;

public class a4 implements c4 {
    /* access modifiers changed from: private */
    public final c4 a;
    private final ExecutorService b;

    class a implements Runnable {
        final /* synthetic */ c4.a b;

        a(c4.a aVar) {
            this.b = aVar;
        }

        public void run() {
            a4.this.a.a(this.b);
        }
    }

    public a4(c4 c4Var, ExecutorService executorService) {
        this.a = c4Var;
        this.b = executorService;
    }

    public void a(c4.a aVar) {
        this.b.execute(new a(aVar));
    }
}
