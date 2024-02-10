package com.bykv.vk.openvk.preload.a;

import com.bykv.vk.openvk.preload.a.b.a.f;
import com.bykv.vk.openvk.preload.a.d.a;
import com.bykv.vk.openvk.preload.a.d.b;
import com.bykv.vk.openvk.preload.a.d.c;
import java.io.IOException;

/* compiled from: TypeAdapter */
public abstract class t<T> {
    public abstract T a(a aVar) throws IOException;

    public abstract void a(c cVar, T t) throws IOException;

    public final t<T> a() {
        return new t<T>() {
            public final void a(c cVar, T t) throws IOException {
                if (t == null) {
                    cVar.e();
                } else {
                    t.this.a(cVar, t);
                }
            }

            public final T a(a aVar) throws IOException {
                if (aVar.f() != b.NULL) {
                    return t.this.a(aVar);
                }
                aVar.k();
                return null;
            }
        };
    }

    public final k a(T t) {
        try {
            f fVar = new f();
            a(fVar, t);
            if (fVar.a.isEmpty()) {
                return fVar.b;
            }
            throw new IllegalStateException("Expected one JSON element but was " + fVar.a);
        } catch (IOException e) {
            throw new l((Throwable) e);
        }
    }
}
