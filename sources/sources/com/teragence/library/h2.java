package com.teragence.library;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

public class h2 implements d2 {
    private final AtomicBoolean a = new AtomicBoolean();
    private final Context b;
    private final a c;

    public interface a {
        void a();
    }

    public h2(Context context, a aVar) {
        this.b = context;
        this.c = aVar;
    }

    public AtomicBoolean a() {
        return this.a;
    }

    public void b() {
        if (this.a.get()) {
            v0.a(this.b);
        }
        this.c.a();
    }
}
