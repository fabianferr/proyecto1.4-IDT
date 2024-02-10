package com.teragence.library;

import com.teragence.client.i;
import com.teragence.library.b3;

public class c3 implements b3 {
    private final b3 a;
    private final String b = "c3";

    public c3(b3 b3Var) {
        this.a = b3Var;
    }

    public void a(b3.a aVar) {
        String str = this.b;
        i.a(str, "execute() called with: callback = [" + aVar + "]");
        this.a.a(aVar);
    }
}
