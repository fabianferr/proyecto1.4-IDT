package com.teragence.library;

import com.teragence.client.i;
import com.teragence.library.h3;

public class j3 implements h3 {
    private final h3 a;

    public j3(h3 h3Var) {
        this.a = h3Var;
    }

    public void a(h3.a aVar) {
        i.a("LoggableCollectTestData", "execute() called with: callback = [" + aVar + "]");
        this.a.a(aVar);
    }
}
