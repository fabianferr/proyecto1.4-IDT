package com.teragence.library;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

public class f2 implements d2 {
    private final AtomicBoolean a = new AtomicBoolean(false);
    private final Context b;

    public f2(Context context) {
        this.b = context;
    }

    public AtomicBoolean a() {
        return this.a;
    }

    public void b() {
        if (this.a.get()) {
            v0.a(this.b);
        }
    }
}
