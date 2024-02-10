package com.applovin.impl.sdk.f;

import com.applovin.impl.sdk.m;

public class z extends a {
    private final Runnable a;

    public z(m mVar, Runnable runnable) {
        this(mVar, false, runnable);
    }

    public z(m mVar, boolean z, Runnable runnable) {
        super("TaskRunnable", mVar, z);
        this.a = runnable;
    }

    public void run() {
        this.a.run();
    }
}
