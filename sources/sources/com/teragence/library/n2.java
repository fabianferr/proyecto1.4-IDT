package com.teragence.library;

import com.teragence.client.i;

public class n2 implements l2 {
    private final l2 a;

    public n2(l2 l2Var) {
        this.a = l2Var;
    }

    public void a() {
        i.a("LoggableTestScheduler", "cancel() called");
        this.a.a();
    }

    public void a(int i) {
        i.a("LoggableTestScheduler", "setUp() called with: interval = [" + i + "]");
        this.a.a(i);
    }

    public void b(int i) {
        i.a("LoggableTestScheduler", "reschedule() called with: newInterval = [" + i + "]");
        this.a.b(i);
    }
}
