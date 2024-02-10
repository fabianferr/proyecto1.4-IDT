package com.startapp.sdk.components;

import com.startapp.i2;
import com.startapp.sdk.components.ComponentLocator;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: Sta */
public class l implements i2<Integer> {
    public final /* synthetic */ ThreadPoolExecutor a;

    public l(ComponentLocator.n nVar, ThreadPoolExecutor threadPoolExecutor) {
        this.a = threadPoolExecutor;
    }

    public Object a() {
        return Integer.valueOf(this.a.getMaximumPoolSize() - this.a.getActiveCount());
    }
}
