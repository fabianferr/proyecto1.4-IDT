package com.teragence.library;

import com.teragence.client.i;

public class f0 implements e0 {
    private final e0 a;

    public f0(e0 e0Var) {
        this.a = e0Var;
    }

    public d a(d dVar) {
        i.a("LoggableDeviceRepositor", "save() called with: device = [" + dVar + "]");
        return this.a.a(dVar);
    }

    public void a() {
        i.a("LoggableDeviceRepositor", "clear() called");
        this.a.a();
    }

    public d b() {
        i.a("LoggableDeviceRepositor", "load() called");
        return this.a.b();
    }
}
