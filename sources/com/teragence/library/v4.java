package com.teragence.library;

import com.teragence.library.z4;
import java.util.concurrent.ExecutorService;

public class v4 implements z4 {
    /* access modifiers changed from: private */
    public final z4 a;
    private final ExecutorService b;

    class a implements Runnable {
        final /* synthetic */ z4.a b;
        final /* synthetic */ i3 c;

        a(z4.a aVar, i3 i3Var) {
            this.b = aVar;
            this.c = i3Var;
        }

        public void run() {
            v4.this.a.a(this.b, this.c);
        }
    }

    public v4(z4 z4Var, ExecutorService executorService) {
        this.a = z4Var;
        this.b = executorService;
    }

    public void a(z4.a aVar, i3 i3Var) {
        this.b.execute(new a(aVar, i3Var));
    }
}
