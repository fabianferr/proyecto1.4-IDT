package com.bytedance.sdk.component.g;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: TTFutureTask */
public class g<V> extends FutureTask<V> implements Comparable<g<V>> {
    private int a;
    private int b;

    public g(Callable<V> callable, int i, int i2) {
        super(callable);
        this.a = i == -1 ? 5 : i;
        this.b = i2;
    }

    public g(Runnable runnable, V v, int i, int i2) {
        super(runnable, v);
        this.a = i == -1 ? 5 : i;
        this.b = i2;
    }

    /* renamed from: a */
    public int compareTo(g gVar) {
        if (a() < gVar.a()) {
            return 1;
        }
        return a() > gVar.a() ? -1 : 0;
    }

    public int a() {
        return this.a;
    }
}
