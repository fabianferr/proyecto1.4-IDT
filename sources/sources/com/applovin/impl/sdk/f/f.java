package com.applovin.impl.sdk.f;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.o;

public class f extends a {
    private final a a;

    public interface a {
        void a(o.a aVar);
    }

    public f(m mVar, a aVar) {
        super("TaskCollectAdvertisingId", mVar, true);
        this.a = aVar;
    }

    public void run() {
        this.a.a(this.b.V().k());
    }
}
