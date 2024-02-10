package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.a.b;
import com.bykv.vk.openvk.preload.a.b.c;
import com.bykv.vk.openvk.preload.a.c.a;
import com.bykv.vk.openvk.preload.a.f;
import com.bykv.vk.openvk.preload.a.j;
import com.bykv.vk.openvk.preload.a.q;
import com.bykv.vk.openvk.preload.a.t;
import com.bykv.vk.openvk.preload.a.u;

/* compiled from: JsonAdapterAnnotationTypeAdapterFactory */
public final class d implements u {
    private final c a;

    public d(c cVar) {
        this.a = cVar;
    }

    static t<?> a(c cVar, f fVar, a<?> aVar, b bVar) {
        t<?> tVar;
        Object a2 = cVar.a(a.a(bVar.a())).a();
        if (a2 instanceof t) {
            tVar = (t) a2;
        } else if (a2 instanceof u) {
            tVar = ((u) a2).a(fVar, aVar);
        } else {
            boolean z = a2 instanceof q;
            if (z || (a2 instanceof j)) {
                j jVar = null;
                q qVar = z ? (q) a2 : null;
                if (a2 instanceof j) {
                    jVar = (j) a2;
                }
                tVar = new l<>(qVar, jVar, fVar, aVar);
            } else {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a2.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
        }
        return (tVar == null || !bVar.b()) ? tVar : tVar.a();
    }

    public final <T> t<T> a(f fVar, a<T> aVar) {
        b bVar = (b) aVar.b.getAnnotation(b.class);
        if (bVar == null) {
            return null;
        }
        return a(this.a, fVar, aVar, bVar);
    }
}
