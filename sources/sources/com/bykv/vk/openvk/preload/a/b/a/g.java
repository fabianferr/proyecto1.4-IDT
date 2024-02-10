package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.b.c;
import com.bykv.vk.openvk.preload.a.b.i;
import com.bykv.vk.openvk.preload.a.d.b;
import com.bykv.vk.openvk.preload.a.f;
import com.bykv.vk.openvk.preload.a.k;
import com.bykv.vk.openvk.preload.a.m;
import com.bykv.vk.openvk.preload.a.n;
import com.bykv.vk.openvk.preload.a.p;
import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.t;
import com.bykv.vk.openvk.preload.a.u;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: MapTypeAdapterFactory */
public final class g implements u {
    final boolean a;
    private final c b;

    public g(c cVar, boolean z) {
        this.b = cVar;
        this.a = z;
    }

    /* compiled from: MapTypeAdapterFactory */
    final class a<K, V> extends t<Map<K, V>> {
        private final t<K> b;
        private final t<V> c;
        private final i<? extends Map<K, V>> d;

        public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IOException {
            String str;
            Map map = (Map) obj;
            if (map == null) {
                cVar.e();
            } else if (!g.this.a) {
                cVar.c();
                for (Map.Entry entry : map.entrySet()) {
                    cVar.a(String.valueOf(entry.getKey()));
                    this.c.a(cVar, entry.getValue());
                }
                cVar.d();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i = 0;
                boolean z = false;
                for (Map.Entry entry2 : map.entrySet()) {
                    k a2 = this.b.a(entry2.getKey());
                    arrayList.add(a2);
                    arrayList2.add(entry2.getValue());
                    z |= (a2 instanceof com.bykv.vk.openvk.preload.a.i) || (a2 instanceof n);
                }
                if (z) {
                    cVar.a();
                    int size = arrayList.size();
                    while (i < size) {
                        cVar.a();
                        com.bykv.vk.openvk.preload.a.b.k.a((k) arrayList.get(i), cVar);
                        this.c.a(cVar, arrayList2.get(i));
                        cVar.b();
                        i++;
                    }
                    cVar.b();
                    return;
                }
                cVar.c();
                int size2 = arrayList.size();
                while (i < size2) {
                    k kVar = (k) arrayList.get(i);
                    if (kVar instanceof p) {
                        p g = kVar.g();
                        if (g.a instanceof Number) {
                            str = String.valueOf(g.a());
                        } else if (g.a instanceof Boolean) {
                            str = Boolean.toString(g.f());
                        } else if (g.a instanceof String) {
                            str = g.b();
                        } else {
                            throw new AssertionError();
                        }
                    } else if (kVar instanceof m) {
                        str = AbstractJsonLexerKt.NULL;
                    } else {
                        throw new AssertionError();
                    }
                    cVar.a(str);
                    this.c.a(cVar, arrayList2.get(i));
                    i++;
                }
                cVar.d();
            }
        }

        public a(f fVar, Type type, t<K> tVar, Type type2, t<V> tVar2, i<? extends Map<K, V>> iVar) {
            this.b = new m(fVar, tVar, type);
            this.c = new m(fVar, tVar2, type2);
            this.d = iVar;
        }

        public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            b f = aVar.f();
            if (f == b.NULL) {
                aVar.k();
                return null;
            }
            Map map = (Map) this.d.a();
            if (f == b.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.e()) {
                    aVar.a();
                    K a2 = this.b.a(aVar);
                    if (map.put(a2, this.c.a(aVar)) == null) {
                        aVar.b();
                    } else {
                        throw new r("duplicate key: ".concat(String.valueOf(a2)));
                    }
                }
                aVar.b();
            } else {
                aVar.c();
                while (aVar.e()) {
                    com.bykv.vk.openvk.preload.a.b.f.a.a(aVar);
                    K a3 = this.b.a(aVar);
                    if (map.put(a3, this.c.a(aVar)) != null) {
                        throw new r("duplicate key: ".concat(String.valueOf(a3)));
                    }
                }
                aVar.d();
            }
            return map;
        }
    }

    public final <T> t<T> a(f fVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        t<Boolean> tVar;
        Type type = aVar.c;
        if (!Map.class.isAssignableFrom(aVar.b)) {
            return null;
        }
        Type[] b2 = com.bykv.vk.openvk.preload.a.b.b.b(type, com.bykv.vk.openvk.preload.a.b.b.b(type));
        Type type2 = b2[0];
        if (type2 == Boolean.TYPE || type2 == Boolean.class) {
            tVar = n.f;
        } else {
            tVar = fVar.a(com.bykv.vk.openvk.preload.a.c.a.a(type2));
        }
        t<?> a2 = fVar.a(com.bykv.vk.openvk.preload.a.c.a.a(b2[1]));
        i<T> a3 = this.b.a(aVar);
        return new a(fVar, b2[0], tVar, b2[1], a2, a3);
    }
}
