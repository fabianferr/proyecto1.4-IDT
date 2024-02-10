package com.bykv.vk.openvk.preload.a;

import com.bykv.vk.openvk.preload.a.b.a.g;
import com.bykv.vk.openvk.preload.a.b.a.h;
import com.bykv.vk.openvk.preload.a.b.a.i;
import com.bykv.vk.openvk.preload.a.b.a.j;
import com.bykv.vk.openvk.preload.a.b.a.k;
import com.bykv.vk.openvk.preload.a.b.a.n;
import com.bykv.vk.openvk.preload.a.b.c;
import com.bykv.vk.openvk.preload.a.b.d;
import com.bykv.vk.openvk.preload.a.d.b;
import java.io.EOFException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: Gson */
public final class f {
    private static final com.bykv.vk.openvk.preload.a.c.a<?> r = com.bykv.vk.openvk.preload.a.c.a.a(Object.class);
    final List<u> a;
    final d b;
    final e c;
    final Map<Type, h<?>> d;
    final boolean e;
    final boolean f;
    final boolean g;
    final boolean h;
    final boolean i;
    public final boolean j;
    final boolean k;
    final String l;
    final int m;
    final int n;
    final s o;
    final List<u> p;
    final List<u> q;
    private final ThreadLocal<Map<com.bykv.vk.openvk.preload.a.c.a<?>, a<?>>> s;
    private final Map<com.bykv.vk.openvk.preload.a.c.a<?>, t<?>> t;
    private final c u;
    private final com.bykv.vk.openvk.preload.a.b.a.d v;

    public f() {
        this(d.a, d.a, Collections.emptyMap(), false, false, false, true, false, false, false, s.a, (String) null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    public f(d dVar, e eVar, Map<Type, h<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, s sVar, String str, int i2, int i3, List<u> list, List<u> list2, List<u> list3) {
        final t tVar;
        t tVar2;
        t tVar3;
        boolean z8 = z2;
        boolean z9 = z7;
        s sVar2 = sVar;
        this.s = new ThreadLocal<>();
        this.t = new ConcurrentHashMap();
        this.b = dVar;
        this.c = eVar;
        this.d = map;
        c cVar = new c(map);
        this.u = cVar;
        this.e = z;
        this.f = z8;
        this.g = z3;
        this.h = z4;
        this.i = z5;
        this.j = z6;
        this.k = z9;
        this.o = sVar2;
        this.l = str;
        this.m = i2;
        this.n = i3;
        this.p = list;
        this.q = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(n.Y);
        arrayList.add(h.a);
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(n.D);
        arrayList.add(n.m);
        arrayList.add(n.g);
        arrayList.add(n.i);
        arrayList.add(n.k);
        if (sVar2 == s.a) {
            tVar = n.t;
        } else {
            tVar = new t<Number>() {
                public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IOException {
                    Number number = (Number) obj;
                    if (number == null) {
                        cVar.e();
                    } else {
                        cVar.b(number.toString());
                    }
                }

                public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                    if (aVar.f() != b.NULL) {
                        return Long.valueOf(aVar.m());
                    }
                    aVar.k();
                    return null;
                }
            };
        }
        arrayList.add(n.a(Long.TYPE, Long.class, tVar));
        Class cls = Double.TYPE;
        Class<Double> cls2 = Double.class;
        if (z9) {
            tVar2 = n.v;
        } else {
            tVar2 = new t<Number>() {
                public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IOException {
                    Number number = (Number) obj;
                    if (number == null) {
                        cVar.e();
                        return;
                    }
                    f.a(number.doubleValue());
                    cVar.a(number);
                }

                public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                    if (aVar.f() != b.NULL) {
                        return Double.valueOf(aVar.l());
                    }
                    aVar.k();
                    return null;
                }
            };
        }
        arrayList.add(n.a(cls, cls2, tVar2));
        Class cls3 = Float.TYPE;
        Class<Float> cls4 = Float.class;
        if (z9) {
            tVar3 = n.u;
        } else {
            tVar3 = new t<Number>() {
                public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IOException {
                    Number number = (Number) obj;
                    if (number == null) {
                        cVar.e();
                        return;
                    }
                    f.a((double) number.floatValue());
                    cVar.a(number);
                }

                public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                    if (aVar.f() != b.NULL) {
                        return Float.valueOf((float) aVar.l());
                    }
                    aVar.k();
                    return null;
                }
            };
        }
        arrayList.add(n.a(cls3, cls4, tVar3));
        arrayList.add(n.x);
        arrayList.add(n.o);
        arrayList.add(n.q);
        arrayList.add(n.a(AtomicLong.class, new t<AtomicLong>() {
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IOException {
                tVar.a(cVar, Long.valueOf(((AtomicLong) obj).get()));
            }

            public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return new AtomicLong(((Number) tVar.a(aVar)).longValue());
            }
        }.a()));
        arrayList.add(n.a(AtomicLongArray.class, new t<AtomicLongArray>() {
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IOException {
                AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                cVar.a();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    tVar.a(cVar, Long.valueOf(atomicLongArray.get(i)));
                }
                cVar.b();
            }

            public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(Long.valueOf(((Number) tVar.a(aVar)).longValue()));
                }
                aVar.b();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i = 0; i < size; i++) {
                    atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
            }
        }.a()));
        arrayList.add(n.s);
        arrayList.add(n.z);
        arrayList.add(n.F);
        arrayList.add(n.H);
        arrayList.add(n.a(BigDecimal.class, n.B));
        arrayList.add(n.a(BigInteger.class, n.C));
        arrayList.add(n.J);
        arrayList.add(n.L);
        arrayList.add(n.P);
        arrayList.add(n.R);
        arrayList.add(n.W);
        arrayList.add(n.N);
        arrayList.add(n.d);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.c.a);
        arrayList.add(n.U);
        arrayList.add(k.a);
        arrayList.add(j.a);
        arrayList.add(n.S);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.a.a);
        arrayList.add(n.b);
        arrayList.add(new com.bykv.vk.openvk.preload.a.b.a.b(cVar));
        arrayList.add(new g(cVar, z8));
        com.bykv.vk.openvk.preload.a.b.a.d dVar2 = new com.bykv.vk.openvk.preload.a.b.a.d(cVar);
        this.v = dVar2;
        arrayList.add(dVar2);
        arrayList.add(n.Z);
        arrayList.add(new i(cVar, eVar, dVar, dVar2));
        this.a = Collections.unmodifiableList(arrayList);
    }

    static void a(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public final <T> t<T> a(com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        boolean z;
        t<T> tVar = this.t.get(aVar == null ? r : aVar);
        if (tVar != null) {
            return tVar;
        }
        Map map = this.s.get();
        if (map == null) {
            map = new HashMap();
            this.s.set(map);
            z = true;
        } else {
            z = false;
        }
        a aVar2 = (a) map.get(aVar);
        if (aVar2 != null) {
            return aVar2;
        }
        try {
            a aVar3 = new a();
            map.put(aVar, aVar3);
            for (u a2 : this.a) {
                t<T> a3 = a2.a(this, aVar);
                if (a3 != null) {
                    if (aVar3.a == null) {
                        aVar3.a = a3;
                        this.t.put(aVar, a3);
                        return a3;
                    }
                    throw new AssertionError();
                }
            }
            throw new IllegalArgumentException("GSON (pangle-v3200) cannot handle ".concat(String.valueOf(aVar)));
        } finally {
            map.remove(aVar);
            if (z) {
                this.s.remove();
            }
        }
    }

    public final <T> t<T> a(u uVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        if (!this.a.contains(uVar)) {
            uVar = this.v;
        }
        boolean z = false;
        for (u next : this.a) {
            if (z) {
                t<T> a2 = next.a(this, aVar);
                if (a2 != null) {
                    return a2;
                }
            } else if (next == uVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize ".concat(String.valueOf(aVar)));
    }

    public final <T> t<T> a(Class<T> cls) {
        return a(com.bykv.vk.openvk.preload.a.c.a.a(cls));
    }

    public final String a(Object obj) {
        if (obj == null) {
            return a((k) m.a);
        }
        return a(obj, (Type) obj.getClass());
    }

    private String a(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        a(obj, type, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    private void a(Object obj, Type type, Appendable appendable) throws l {
        try {
            a(obj, type, a(com.bykv.vk.openvk.preload.a.b.k.a(appendable)));
        } catch (IOException e2) {
            throw new l((Throwable) e2);
        }
    }

    private void a(Object obj, Type type, com.bykv.vk.openvk.preload.a.d.c cVar) throws l {
        t<?> a2 = a(com.bykv.vk.openvk.preload.a.c.a.a(type));
        boolean z = cVar.c;
        cVar.c = true;
        boolean z2 = cVar.d;
        cVar.d = this.h;
        boolean z3 = cVar.e;
        cVar.e = this.e;
        try {
            a2.a(cVar, obj);
            cVar.c = z;
            cVar.d = z2;
            cVar.e = z3;
        } catch (IOException e2) {
            throw new l((Throwable) e2);
        } catch (AssertionError e3) {
            AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e3.getMessage());
            assertionError.initCause(e3);
            throw assertionError;
        } catch (Throwable th) {
            cVar.c = z;
            cVar.d = z2;
            cVar.e = z3;
            throw th;
        }
    }

    private String a(k kVar) {
        StringWriter stringWriter = new StringWriter();
        a(kVar, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    private void a(k kVar, Appendable appendable) throws l {
        try {
            a(kVar, a(com.bykv.vk.openvk.preload.a.b.k.a(appendable)));
        } catch (IOException e2) {
            throw new l((Throwable) e2);
        }
    }

    private com.bykv.vk.openvk.preload.a.d.c a(Writer writer) throws IOException {
        if (this.g) {
            writer.write(")]}'\n");
        }
        com.bykv.vk.openvk.preload.a.d.c cVar = new com.bykv.vk.openvk.preload.a.d.c(writer);
        if (this.i) {
            cVar.c("  ");
        }
        cVar.e = this.e;
        return cVar;
    }

    public static void a(Object obj, com.bykv.vk.openvk.preload.a.d.a aVar) {
        if (obj != null) {
            try {
                if (aVar.f() != b.END_DOCUMENT) {
                    throw new l("JSON document was not fully consumed.");
                }
            } catch (com.bykv.vk.openvk.preload.a.d.d e2) {
                throw new r((Throwable) e2);
            } catch (IOException e3) {
                throw new l((Throwable) e3);
            }
        }
    }

    /* compiled from: Gson */
    static class a<T> extends t<T> {
        t<T> a;

        a() {
        }

        public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            t<T> tVar = this.a;
            if (tVar != null) {
                return tVar.a(aVar);
            }
            throw new IllegalStateException();
        }

        public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t) throws IOException {
            t<T> tVar = this.a;
            if (tVar != null) {
                tVar.a(cVar, t);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public final String toString() {
        return "{serializeNulls:" + this.e + ",factories:" + this.a + ",instanceCreators:" + this.u + "}";
    }

    private void a(k kVar, com.bykv.vk.openvk.preload.a.d.c cVar) throws l {
        boolean z = cVar.c;
        cVar.c = true;
        boolean z2 = cVar.d;
        cVar.d = this.h;
        boolean z3 = cVar.e;
        cVar.e = this.e;
        try {
            com.bykv.vk.openvk.preload.a.b.k.a(kVar, cVar);
            cVar.c = z;
            cVar.d = z2;
            cVar.e = z3;
        } catch (IOException e2) {
            throw new l((Throwable) e2);
        } catch (AssertionError e3) {
            AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e3.getMessage());
            assertionError.initCause(e3);
            throw assertionError;
        } catch (Throwable th) {
            cVar.c = z;
            cVar.d = z2;
            cVar.e = z3;
            throw th;
        }
    }

    public final <T> T a(com.bykv.vk.openvk.preload.a.d.a aVar, Type type) throws l, r {
        boolean z = aVar.a;
        aVar.a = true;
        try {
            aVar.f();
            T a2 = a(com.bykv.vk.openvk.preload.a.c.a.a(type)).a(aVar);
            aVar.a = z;
            return a2;
        } catch (EOFException e2) {
            if (1 != 0) {
                aVar.a = z;
                return null;
            }
            throw new r((Throwable) e2);
        } catch (IllegalStateException e3) {
            throw new r((Throwable) e3);
        } catch (IOException e4) {
            throw new r((Throwable) e4);
        } catch (AssertionError e5) {
            AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e5.getMessage());
            assertionError.initCause(e5);
            throw assertionError;
        } catch (Throwable th) {
            aVar.a = z;
            throw th;
        }
    }
}
