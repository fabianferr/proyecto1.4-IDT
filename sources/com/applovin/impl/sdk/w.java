package com.applovin.impl.sdk;

import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import java.util.LinkedList;
import java.util.Queue;

class w {
    private final Queue<AppLovinAdImpl> a = new LinkedList();
    private final Object b = new Object();

    w() {
    }

    /* access modifiers changed from: package-private */
    public int a() {
        int size;
        synchronized (this.b) {
            size = this.a.size();
        }
        return size;
    }

    /* access modifiers changed from: package-private */
    public void a(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.b) {
            if (a() <= 25) {
                this.a.offer(appLovinAdImpl);
            } else if (u.a()) {
                u.i("AppLovinSdk", "Maximum queue capacity reached - discarding ad...");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        boolean z;
        synchronized (this.b) {
            z = a() == 0;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public AppLovinAdImpl c() {
        AppLovinAdImpl poll;
        synchronized (this.b) {
            poll = !b() ? this.a.poll() : null;
        }
        return poll;
    }

    /* access modifiers changed from: package-private */
    public AppLovinAdImpl d() {
        AppLovinAdImpl peek;
        synchronized (this.b) {
            peek = this.a.peek();
        }
        return peek;
    }
}
