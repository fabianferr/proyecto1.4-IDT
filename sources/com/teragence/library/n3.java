package com.teragence.library;

import com.teragence.library.o3;
import java.util.concurrent.ExecutorService;

public class n3 implements o3.a {
    /* access modifiers changed from: private */
    public final o3.a a;
    private final ExecutorService b;

    class a implements Runnable {
        final /* synthetic */ float b;

        a(float f) {
            this.b = f;
        }

        public void run() {
            n3.this.a.a(this.b);
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            n3.this.a.a();
        }
    }

    public n3(o3.a aVar, ExecutorService executorService) {
        this.a = aVar;
        this.b = executorService;
    }

    public void a() {
        this.b.execute(new b());
    }

    public void a(float f) {
        this.b.execute(new a(f));
    }
}
