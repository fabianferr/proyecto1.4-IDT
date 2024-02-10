package com.mbridge.msdk.e.a;

/* compiled from: VolleyError */
public class u extends Exception {
    public final k a;
    private long b;

    public u() {
        this.a = null;
    }

    public u(k kVar) {
        this.a = kVar;
    }

    public u(Throwable th) {
        super(th);
        this.a = null;
    }

    /* access modifiers changed from: package-private */
    public final void a(long j) {
        this.b = j;
    }
}
