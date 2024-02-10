package com.teragence.library;

import com.teragence.client.i;

public class n implements m {
    private final m a;

    public n(m mVar) {
        this.a = mVar;
    }

    public i a(i iVar) {
        i.a("LoggableConfigRepositor", "save() called with: testConfig = [" + iVar + "]");
        return this.a.a(iVar);
    }

    public void a() {
        i.a("LoggableConfigRepositor", "clear() called");
        this.a.a();
    }

    public i b() {
        i.a("LoggableConfigRepositor", "load() called");
        return this.a.b();
    }
}
