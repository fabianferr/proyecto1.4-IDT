package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.b.c;
import com.bykv.vk.openvk.preload.a.b.i;
import com.bykv.vk.openvk.preload.a.f;
import com.bykv.vk.openvk.preload.a.t;
import com.bykv.vk.openvk.preload.a.u;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

/* compiled from: CollectionTypeAdapterFactory */
public final class b implements u {
    private final c a;

    public b(c cVar) {
        this.a = cVar;
    }

    /* compiled from: CollectionTypeAdapterFactory */
    static final class a<E> extends t<Collection<E>> {
        private final t<E> a;
        private final i<? extends Collection<E>> b;

        public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IOException {
            Collection<Object> collection = (Collection) obj;
            if (collection == null) {
                cVar.e();
                return;
            }
            cVar.a();
            for (Object a2 : collection) {
                this.a.a(cVar, a2);
            }
            cVar.b();
        }

        public a(f fVar, Type type, t<E> tVar, i<? extends Collection<E>> iVar) {
            this.a = new m(fVar, tVar, type);
            this.b = iVar;
        }

        public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                aVar.k();
                return null;
            }
            Collection collection = (Collection) this.b.a();
            aVar.a();
            while (aVar.e()) {
                collection.add(this.a.a(aVar));
            }
            aVar.b();
            return collection;
        }
    }

    public final <T> t<T> a(f fVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        Type type = aVar.c;
        Class<? super T> cls = aVar.b;
        if (!Collection.class.isAssignableFrom(cls)) {
            return null;
        }
        Type a2 = com.bykv.vk.openvk.preload.a.b.b.a(type, (Class<?>) cls);
        return new a(fVar, a2, fVar.a(com.bykv.vk.openvk.preload.a.c.a.a(a2)), this.a.a(aVar));
    }
}
