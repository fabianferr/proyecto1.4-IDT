package com.appnext.core.result;

public final class d {
    private static d eG;
    private c eA;

    private d() {
    }

    public static synchronized d ay() {
        d dVar;
        synchronized (d.class) {
            if (eG == null) {
                eG = new d();
            }
            dVar = eG;
        }
        return dVar;
    }

    public final c az() {
        return this.eA;
    }

    public final void a(c cVar) {
        this.eA = cVar;
    }
}
