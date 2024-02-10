package com.mbridge.msdk.foundation.same.net;

import android.os.Process;
import com.mbridge.msdk.foundation.same.net.f.a;
import com.mbridge.msdk.foundation.same.net.f.c;
import com.mbridge.msdk.foundation.same.net.stack.OkHttpStack;
import com.mbridge.msdk.foundation.same.net.stack.b;
import com.mbridge.msdk.foundation.tools.aa;

/* compiled from: NetworkDispatcher */
public class i {
    private static final String a = "i";
    private b b;
    private h c;
    private c d;

    public i(c cVar) {
        a();
        this.c = new a(this.b, cVar);
        this.d = cVar;
    }

    public i(c cVar, b bVar) {
        if (bVar == null) {
            a();
        } else {
            this.b = bVar;
        }
        this.c = new a(this.b, cVar);
        this.d = cVar;
    }

    public final void a(j jVar) {
        Process.setThreadPriority(10);
        try {
            this.d.c(jVar);
            if (jVar.d()) {
                jVar.a("network-discard-cancelled");
                this.d.b(jVar);
                this.d.a(jVar);
                return;
            }
            this.d.d(jVar);
            this.d.a((j<?>) jVar, (l<?>) jVar.a(this.c.a(jVar)));
        } catch (com.mbridge.msdk.foundation.same.net.b.a e) {
            this.d.a((j<?>) jVar, e);
        } catch (Exception e2) {
            String str = a;
            aa.d(str, "Unhandled exception " + e2.getMessage());
            this.d.a((j<?>) jVar, new com.mbridge.msdk.foundation.same.net.b.a(4, (c) null));
        }
    }

    private void a() {
        try {
            if (com.mbridge.msdk.f.b.b()) {
                this.b = new com.mbridge.msdk.foundation.same.net.stack.a();
                return;
            }
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
        }
        this.b = new OkHttpStack();
    }
}
