package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.b.a.i;
import com.bykv.vk.openvk.preload.a.d.a;
import com.bykv.vk.openvk.preload.a.d.c;
import com.bykv.vk.openvk.preload.a.f;
import com.bykv.vk.openvk.preload.a.t;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: TypeAdapterRuntimeTypeWrapper */
final class m<T> extends t<T> {
    private final f a;
    private final t<T> b;
    private final Type c;

    m(f fVar, t<T> tVar, Type type) {
        this.a = fVar;
        this.b = tVar;
        this.c = type;
    }

    public final T a(a aVar) throws IOException {
        return this.b.a(aVar);
    }

    public final void a(c cVar, T t) throws IOException {
        t<T> tVar = this.b;
        Type type = this.c;
        if (t != null && (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class))) {
            type = t.getClass();
        }
        if (type != this.c) {
            tVar = this.a.a(com.bykv.vk.openvk.preload.a.c.a.a(type));
            if (tVar instanceof i.a) {
                t<T> tVar2 = this.b;
                if (!(tVar2 instanceof i.a)) {
                    tVar = tVar2;
                }
            }
        }
        tVar.a(cVar, t);
    }
}
