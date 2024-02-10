package com.teragence.library;

import com.teragence.library.h4;
import java.util.concurrent.ExecutorService;

public class f4 implements h4 {
    /* access modifiers changed from: private */
    public final h4 a;
    private final ExecutorService b;

    class a implements Runnable {
        final /* synthetic */ h4.a b;

        a(h4.a aVar) {
            this.b = aVar;
        }

        public void run() {
            f4.this.a.a(this.b);
        }
    }

    public f4(h4 h4Var, ExecutorService executorService) {
        this.a = h4Var;
        this.b = executorService;
    }

    public void a(h4.a aVar) {
        this.b.execute(new a(aVar));
    }
}
