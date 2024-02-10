package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.c.a;
import com.bykv.vk.openvk.preload.a.d.c;
import com.bykv.vk.openvk.preload.a.f;
import com.bykv.vk.openvk.preload.a.t;
import com.bykv.vk.openvk.preload.a.u;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: ObjectTypeAdapter */
public final class h extends t<Object> {
    public static final u a = new u() {
        public final <T> t<T> a(f fVar, a<T> aVar) {
            if (aVar.b == Object.class) {
                return new h(fVar);
            }
            return null;
        }
    };
    private final f b;

    h(f fVar) {
        this.b = fVar;
    }

    /* renamed from: com.bykv.vk.openvk.preload.a.b.a.h$2  reason: invalid class name */
    /* compiled from: ObjectTypeAdapter */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.bykv.vk.openvk.preload.a.d.b[] r0 = com.bykv.vk.openvk.preload.a.d.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.bykv.vk.openvk.preload.a.d.b r1 = com.bykv.vk.openvk.preload.a.d.b.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bykv.vk.openvk.preload.a.d.b r1 = com.bykv.vk.openvk.preload.a.d.b.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.bykv.vk.openvk.preload.a.d.b r1 = com.bykv.vk.openvk.preload.a.d.b.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.bykv.vk.openvk.preload.a.d.b r1 = com.bykv.vk.openvk.preload.a.d.b.NUMBER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.bykv.vk.openvk.preload.a.d.b r1 = com.bykv.vk.openvk.preload.a.d.b.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.bykv.vk.openvk.preload.a.d.b r1 = com.bykv.vk.openvk.preload.a.d.b.NULL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.a.b.a.h.AnonymousClass2.<clinit>():void");
        }
    }

    public final Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
        switch (AnonymousClass2.a[aVar.f().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(a(aVar));
                }
                aVar.b();
                return arrayList;
            case 2:
                com.bykv.vk.openvk.preload.a.b.h hVar = new com.bykv.vk.openvk.preload.a.b.h();
                aVar.c();
                while (aVar.e()) {
                    hVar.put(aVar.h(), a(aVar));
                }
                aVar.d();
                return hVar;
            case 3:
                return aVar.i();
            case 4:
                return Double.valueOf(aVar.l());
            case 5:
                return Boolean.valueOf(aVar.j());
            case 6:
                aVar.k();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    public final void a(c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.e();
            return;
        }
        t<?> a2 = this.b.a(obj.getClass());
        if (a2 instanceof h) {
            cVar.c();
            cVar.d();
            return;
        }
        a2.a(cVar, obj);
    }
}
