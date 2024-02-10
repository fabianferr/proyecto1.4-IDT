package com.applovin.impl.mediation;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.e;

public class c {
    private final m a;
    /* access modifiers changed from: private */
    public final u b;
    /* access modifiers changed from: private */
    public final a c;
    private e d;

    public interface a {
        void c(com.applovin.impl.mediation.a.c cVar);
    }

    c(m mVar, a aVar) {
        this.a = mVar;
        this.b = mVar.A();
        this.c = aVar;
    }

    public void a() {
        if (u.a()) {
            this.b.b("AdHiddenCallbackTimeoutManager", "Cancelling timeout");
        }
        e eVar = this.d;
        if (eVar != null) {
            eVar.a();
            this.d = null;
        }
    }

    public void a(final com.applovin.impl.mediation.a.c cVar, long j) {
        if (u.a()) {
            u uVar = this.b;
            uVar.b("AdHiddenCallbackTimeoutManager", "Scheduling in " + j + "ms...");
        }
        this.d = e.a(j, this.a, new Runnable() {
            public void run() {
                if (u.a()) {
                    c.this.b.b("AdHiddenCallbackTimeoutManager", "Timing out...");
                }
                c.this.c.c(cVar);
            }
        });
    }
}
