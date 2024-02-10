package com.teragence.library;

import com.teragence.library.o3;

public class t3 implements o3.a {
    private final o3.a a;

    public t3(o3.a aVar) {
        this.a = aVar;
    }

    public void a() {
        try {
            this.a.a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(float f) {
        try {
            this.a.a(f);
        } catch (Exception unused) {
            a();
        }
    }
}
