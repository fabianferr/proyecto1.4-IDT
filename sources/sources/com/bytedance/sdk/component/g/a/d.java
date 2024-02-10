package com.bytedance.sdk.component.g.a;

import com.bytedance.sdk.component.g.a.c;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: RecyclePool */
public class d<T extends c> {
    private int a;
    private BlockingQueue<T> b = new LinkedBlockingQueue();

    public static d a(int i) {
        return new d(i);
    }

    private d(int i) {
        this.a = i;
    }

    public T a() {
        return (c) this.b.poll();
    }

    public boolean a(T t) {
        if (t == null) {
            return false;
        }
        t.a();
        if (this.b.size() >= this.a) {
            return false;
        }
        return this.b.offer(t);
    }
}
