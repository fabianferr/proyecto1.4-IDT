package com.bykv.vk.openvk.preload.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: JsonArray */
public final class i extends k implements Iterable<k> {
    private final List<k> a = new ArrayList();

    public final void a(k kVar) {
        if (kVar == null) {
            kVar = m.a;
        }
        this.a.add(kVar);
    }

    public final Iterator<k> iterator() {
        return this.a.iterator();
    }

    public final Number a() {
        if (this.a.size() == 1) {
            return this.a.get(0).a();
        }
        throw new IllegalStateException();
    }

    public final String b() {
        if (this.a.size() == 1) {
            return this.a.get(0).b();
        }
        throw new IllegalStateException();
    }

    public final double c() {
        if (this.a.size() == 1) {
            return this.a.get(0).c();
        }
        throw new IllegalStateException();
    }

    public final long d() {
        if (this.a.size() == 1) {
            return this.a.get(0).d();
        }
        throw new IllegalStateException();
    }

    public final int e() {
        if (this.a.size() == 1) {
            return this.a.get(0).e();
        }
        throw new IllegalStateException();
    }

    public final boolean f() {
        if (this.a.size() == 1) {
            return this.a.get(0).f();
        }
        throw new IllegalStateException();
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof i) && ((i) obj).a.equals(this.a);
        }
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
