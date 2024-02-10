package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.b.k;
import com.bykv.vk.openvk.preload.a.d.c;
import com.bykv.vk.openvk.preload.a.f;
import com.bykv.vk.openvk.preload.a.j;
import com.bykv.vk.openvk.preload.a.m;
import com.bykv.vk.openvk.preload.a.q;
import com.bykv.vk.openvk.preload.a.t;
import com.bykv.vk.openvk.preload.a.u;
import java.io.IOException;

/* compiled from: TreeTypeAdapter */
public final class l<T> extends t<T> {
    final f a;
    private final q<T> b;
    private final j<T> c;
    private final com.bykv.vk.openvk.preload.a.c.a<T> d;
    private final u e;
    private final l<T>.a f = new a(this, (byte) 0);
    private t<T> g;

    public l(q<T> qVar, j<T> jVar, f fVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        this.b = qVar;
        this.c = jVar;
        this.a = fVar;
        this.d = aVar;
        this.e = null;
    }

    public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
        if (this.c == null) {
            return b().a(aVar);
        }
        if (k.a(aVar) instanceof m) {
            return null;
        }
        return this.c.a();
    }

    public final void a(c cVar, T t) throws IOException {
        q<T> qVar = this.b;
        if (qVar == null) {
            b().a(cVar, t);
        } else if (t == null) {
            cVar.e();
        } else {
            k.a(qVar.a(), cVar);
        }
    }

    private t<T> b() {
        t<T> tVar = this.g;
        if (tVar != null) {
            return tVar;
        }
        t<T> a2 = this.a.a(this.e, this.d);
        this.g = a2;
        return a2;
    }

    /* compiled from: TreeTypeAdapter */
    final class a {
        private a() {
        }

        /* synthetic */ a(l lVar, byte b) {
            this();
        }
    }
}
