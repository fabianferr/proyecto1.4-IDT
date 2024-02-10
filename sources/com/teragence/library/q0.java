package com.teragence.library;

import com.teragence.client.b;
import com.teragence.client.i;

public class q0 implements p0 {
    private final p0 a;

    public q0(p0 p0Var) {
        this.a = p0Var;
    }

    public void a(b bVar) {
        i.a("LoggableStatsRepository", "saveReceivedStats() called with: dataCount = [" + bVar + "]");
        this.a.a(bVar);
    }

    public void b(b bVar) {
        i.a("LoggableStatsRepository", "saveTransmittedStats() called with: dataCount = [" + bVar + "]");
        this.a.b(bVar);
    }
}
