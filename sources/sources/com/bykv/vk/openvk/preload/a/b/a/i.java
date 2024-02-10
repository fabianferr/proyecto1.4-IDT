package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.b.c;
import com.bykv.vk.openvk.preload.a.b.d;
import com.bykv.vk.openvk.preload.a.e;
import com.bykv.vk.openvk.preload.a.f;
import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.t;
import com.bykv.vk.openvk.preload.a.u;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: ReflectiveTypeAdapterFactory */
public final class i implements u {
    private final c a;
    private final e b;
    private final d c;
    private final d d;
    private final com.bykv.vk.openvk.preload.a.b.b.b e = com.bykv.vk.openvk.preload.a.b.b.b.a();

    public i(c cVar, e eVar, d dVar, d dVar2) {
        this.a = cVar;
        this.b = eVar;
        this.c = dVar;
        this.d = dVar2;
    }

    private boolean a(Field field, boolean z) {
        boolean z2;
        com.bykv.vk.openvk.preload.a.a.a aVar;
        d dVar = this.c;
        if (!(dVar.a(field.getType()) || dVar.a(z))) {
            if ((dVar.c & field.getModifiers()) == 0 && ((dVar.b == -1.0d || dVar.a((com.bykv.vk.openvk.preload.a.a.d) field.getAnnotation(com.bykv.vk.openvk.preload.a.a.d.class), (com.bykv.vk.openvk.preload.a.a.e) field.getAnnotation(com.bykv.vk.openvk.preload.a.a.e.class))) && !field.isSynthetic() && ((!dVar.e || ((aVar = (com.bykv.vk.openvk.preload.a.a.a) field.getAnnotation(com.bykv.vk.openvk.preload.a.a.a.class)) != null && (!z ? aVar.b() : aVar.a()))) && ((dVar.d || !d.c(field.getType())) && !d.b(field.getType()))))) {
                List<com.bykv.vk.openvk.preload.a.b> list = z ? dVar.f : dVar.g;
                if (!list.isEmpty()) {
                    new com.bykv.vk.openvk.preload.a.c(field);
                    Iterator<com.bykv.vk.openvk.preload.a.b> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().a()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                return true;
            }
        }
        return false;
    }

    private List<String> a(Field field) {
        com.bykv.vk.openvk.preload.a.a.c cVar = (com.bykv.vk.openvk.preload.a.a.c) field.getAnnotation(com.bykv.vk.openvk.preload.a.a.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.b.a(field));
        }
        String a2 = cVar.a();
        String[] b2 = cVar.b();
        if (b2.length == 0) {
            return Collections.singletonList(a2);
        }
        ArrayList arrayList = new ArrayList(b2.length + 1);
        arrayList.add(a2);
        for (String add : b2) {
            arrayList.add(add);
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e3 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<java.lang.String, com.bykv.vk.openvk.preload.a.b.a.i.b> a(com.bykv.vk.openvk.preload.a.f r33, com.bykv.vk.openvk.preload.a.c.a<?> r34, java.lang.Class<?> r35) {
        /*
            r32 = this;
            r11 = r32
            r12 = r33
            java.util.LinkedHashMap r13 = new java.util.LinkedHashMap
            r13.<init>()
            boolean r0 = r35.isInterface()
            if (r0 == 0) goto L_0x0010
            return r13
        L_0x0010:
            r0 = r34
            java.lang.reflect.Type r14 = r0.c
            r10 = r35
            r15 = r0
        L_0x0017:
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            if (r10 == r0) goto L_0x0154
            java.lang.reflect.Field[] r9 = r10.getDeclaredFields()
            int r8 = r9.length
            r7 = 0
            r6 = 0
        L_0x0022:
            if (r6 >= r8) goto L_0x013a
            r5 = r9[r6]
            r4 = 1
            boolean r0 = r11.a((java.lang.reflect.Field) r5, (boolean) r4)
            boolean r16 = r11.a((java.lang.reflect.Field) r5, (boolean) r7)
            if (r0 != 0) goto L_0x0044
            if (r16 == 0) goto L_0x0034
            goto L_0x0044
        L_0x0034:
            r30 = r6
            r23 = r8
            r31 = r9
            r35 = r10
            r20 = r14
            r34 = r15
            r21 = 0
            goto L_0x010b
        L_0x0044:
            com.bykv.vk.openvk.preload.a.b.b.b r1 = r11.e
            r1.a(r5)
            java.lang.reflect.Type r1 = r15.c
            java.lang.reflect.Type r2 = r5.getGenericType()
            java.lang.reflect.Type r17 = com.bykv.vk.openvk.preload.a.b.b.a((java.lang.reflect.Type) r1, (java.lang.Class<?>) r10, (java.lang.reflect.Type) r2)
            java.util.List r3 = r11.a(r5)
            int r2 = r3.size()
            r18 = 0
            r34 = r15
            r15 = r18
            r1 = 0
        L_0x0062:
            if (r1 >= r2) goto L_0x00fd
            java.lang.Object r19 = r3.get(r1)
            r20 = r14
            r14 = r19
            java.lang.String r14 = (java.lang.String) r14
            if (r1 == 0) goto L_0x0073
            r19 = 0
            goto L_0x0075
        L_0x0073:
            r19 = r0
        L_0x0075:
            com.bykv.vk.openvk.preload.a.c.a r0 = com.bykv.vk.openvk.preload.a.c.a.a((java.lang.reflect.Type) r17)
            java.lang.Class<? super T> r4 = r0.b
            boolean r7 = r4 instanceof java.lang.Class
            if (r7 == 0) goto L_0x008b
            r7 = r4
            java.lang.Class r7 = (java.lang.Class) r7
            boolean r4 = r4.isPrimitive()
            if (r4 == 0) goto L_0x008b
            r22 = 1
            goto L_0x008d
        L_0x008b:
            r22 = 0
        L_0x008d:
            java.lang.Class<com.bykv.vk.openvk.preload.a.a.b> r4 = com.bykv.vk.openvk.preload.a.a.b.class
            java.lang.annotation.Annotation r4 = r5.getAnnotation(r4)
            com.bykv.vk.openvk.preload.a.a.b r4 = (com.bykv.vk.openvk.preload.a.a.b) r4
            if (r4 == 0) goto L_0x009e
            com.bykv.vk.openvk.preload.a.b.c r7 = r11.a
            com.bykv.vk.openvk.preload.a.t r4 = com.bykv.vk.openvk.preload.a.b.a.d.a(r7, r12, r0, r4)
            goto L_0x00a0
        L_0x009e:
            r4 = r18
        L_0x00a0:
            if (r4 == 0) goto L_0x00a4
            r7 = 1
            goto L_0x00a5
        L_0x00a4:
            r7 = 0
        L_0x00a5:
            if (r4 != 0) goto L_0x00ab
            com.bykv.vk.openvk.preload.a.t r4 = r12.a(r0)
        L_0x00ab:
            r23 = r4
            com.bykv.vk.openvk.preload.a.b.a.i$1 r4 = new com.bykv.vk.openvk.preload.a.b.a.i$1
            r24 = r0
            r0 = r4
            r25 = r1
            r1 = r32
            r26 = r2
            r2 = r14
            r27 = r3
            r3 = r19
            r11 = r4
            r28 = 1
            r4 = r16
            r29 = r5
            r30 = r6
            r6 = r7
            r21 = 0
            r7 = r23
            r23 = r8
            r8 = r33
            r31 = r9
            r9 = r24
            r35 = r10
            r10 = r22
            r0.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            java.lang.Object r0 = r13.put(r14, r11)
            com.bykv.vk.openvk.preload.a.b.a.i$b r0 = (com.bykv.vk.openvk.preload.a.b.a.i.b) r0
            if (r15 != 0) goto L_0x00e3
            r15 = r0
        L_0x00e3:
            int r1 = r25 + 1
            r11 = r32
            r10 = r35
            r0 = r19
            r14 = r20
            r8 = r23
            r2 = r26
            r3 = r27
            r5 = r29
            r6 = r30
            r9 = r31
            r4 = 1
            r7 = 0
            goto L_0x0062
        L_0x00fd:
            r30 = r6
            r23 = r8
            r31 = r9
            r35 = r10
            r20 = r14
            r21 = 0
            if (r15 != 0) goto L_0x011c
        L_0x010b:
            int r6 = r30 + 1
            r11 = r32
            r15 = r34
            r10 = r35
            r14 = r20
            r8 = r23
            r9 = r31
            r7 = 0
            goto L_0x0022
        L_0x011c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = r20
            r1.append(r2)
            java.lang.String r2 = " declares multiple JSON fields named "
            r1.append(r2)
            java.lang.String r2 = r15.h
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x013a:
            r35 = r10
            r2 = r14
            r0 = r15
            java.lang.reflect.Type r0 = r0.c
            java.lang.reflect.Type r1 = r35.getGenericSuperclass()
            r3 = r35
            java.lang.reflect.Type r0 = com.bykv.vk.openvk.preload.a.b.b.a((java.lang.reflect.Type) r0, (java.lang.Class<?>) r3, (java.lang.reflect.Type) r1)
            com.bykv.vk.openvk.preload.a.c.a r15 = com.bykv.vk.openvk.preload.a.c.a.a((java.lang.reflect.Type) r0)
            java.lang.Class<? super T> r10 = r15.b
            r11 = r32
            goto L_0x0017
        L_0x0154:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.a.b.a.i.a(com.bykv.vk.openvk.preload.a.f, com.bykv.vk.openvk.preload.a.c.a, java.lang.Class):java.util.Map");
    }

    /* compiled from: ReflectiveTypeAdapterFactory */
    static abstract class b {
        final String h;
        final boolean i;
        final boolean j;

        /* access modifiers changed from: package-private */
        public abstract void a(com.bykv.vk.openvk.preload.a.d.a aVar, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: package-private */
        public abstract void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: package-private */
        public abstract boolean a(Object obj) throws IOException, IllegalAccessException;

        protected b(String str, boolean z, boolean z2) {
            this.h = str;
            this.i = z;
            this.j = z2;
        }
    }

    /* compiled from: ReflectiveTypeAdapterFactory */
    public static final class a<T> extends t<T> {
        private final com.bykv.vk.openvk.preload.a.b.i<T> a;
        private final Map<String, b> b;

        a(com.bykv.vk.openvk.preload.a.b.i<T> iVar, Map<String, b> map) {
            this.a = iVar;
            this.b = map;
        }

        public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                aVar.k();
                return null;
            }
            T a2 = this.a.a();
            try {
                aVar.c();
                while (aVar.e()) {
                    b bVar = this.b.get(aVar.h());
                    if (bVar != null) {
                        if (bVar.j) {
                            bVar.a(aVar, (Object) a2);
                        }
                    }
                    aVar.o();
                }
                aVar.d();
                return a2;
            } catch (IllegalStateException e) {
                throw new r((Throwable) e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t) throws IOException {
            if (t == null) {
                cVar.e();
                return;
            }
            cVar.c();
            try {
                for (b next : this.b.values()) {
                    if (next.a(t)) {
                        cVar.a(next.h);
                        next.a(cVar, (Object) t);
                    }
                }
                cVar.d();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    public final <T> t<T> a(f fVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        Class<? super T> cls = aVar.b;
        if (!Object.class.isAssignableFrom(cls)) {
            return null;
        }
        return new a(this.a.a(aVar), a(fVar, aVar, cls));
    }
}
