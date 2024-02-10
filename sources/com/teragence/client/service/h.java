package com.teragence.client.service;

import com.teragence.client.i;
import com.teragence.library.d2;

public class h implements f {
    private static final String b = "h";
    private final f a;

    public h(f fVar) {
        this.a = fVar;
    }

    public void a() {
        i.a(b, "onCreate() called");
        this.a.a();
    }

    public void a(d2 d2Var) {
        String str = b;
        i.a(str, "onAlarm() called with: resourceLock = [" + d2Var + "]");
        this.a.a(d2Var);
    }

    public void b() {
        i.a(b, "onFinish() called");
        this.a.b();
    }
}
