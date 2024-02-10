package com.pgl.ssdk;

import android.os.HandlerThread;

public class u {
    private final x a;
    private r b;

    private u() {
        this.a = x.a(1);
    }

    public static u a() {
        return t.a;
    }

    public r b() {
        if (this.b == null) {
            synchronized (u.class) {
                if (this.b == null) {
                    v vVar = (v) this.a.a();
                    if (vVar != null) {
                        vVar.a((q) null);
                        vVar.a("ssdk_io_handler");
                    } else if (!m.b().a()) {
                        HandlerThread handlerThread = new HandlerThread("ssdk_io_handler");
                        handlerThread.start();
                        vVar = new v(handlerThread, (q) null);
                    } else {
                        vVar = null;
                    }
                    this.b = vVar;
                }
            }
        }
        return this.b;
    }
}
