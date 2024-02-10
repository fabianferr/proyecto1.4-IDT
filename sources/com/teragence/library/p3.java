package com.teragence.library;

import com.teragence.client.i;
import com.teragence.library.o3;

public class p3 implements o3.a {
    private static final String b = "p3";
    private final o3.a a;

    public p3(o3.a aVar) {
        this.a = aVar;
    }

    public void a() {
        i.a(b, "onNotAvailable() called");
        this.a.a();
    }

    public void a(float f) {
        String str = b;
        i.a(str, "onSuccess() called with: millibarsOfPressure = [" + f + "]");
        this.a.a(f);
    }
}
