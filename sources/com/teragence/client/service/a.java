package com.teragence.client.service;

import java.util.concurrent.atomic.AtomicBoolean;

public class a implements g {
    private final AtomicBoolean a;

    public a(AtomicBoolean atomicBoolean) {
        this.a = atomicBoolean;
    }

    public void a(boolean z) {
        this.a.set(z);
    }

    public boolean a() {
        return this.a.get();
    }
}
