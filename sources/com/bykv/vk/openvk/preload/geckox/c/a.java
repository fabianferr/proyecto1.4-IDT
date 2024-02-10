package com.bykv.vk.openvk.preload.geckox.c;

import com.bykv.vk.openvk.preload.a.d.b;
import com.bykv.vk.openvk.preload.a.d.c;
import com.bykv.vk.openvk.preload.a.o;
import com.bykv.vk.openvk.preload.a.t;
import java.io.IOException;

/* compiled from: BooleanTypeAdapter */
public final class a extends t<Boolean> {
    public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            cVar.e();
        } else {
            cVar.a(bool);
        }
    }

    /* renamed from: com.bykv.vk.openvk.preload.geckox.c.a$1  reason: invalid class name */
    /* compiled from: BooleanTypeAdapter */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.bykv.vk.openvk.preload.a.d.b[] r0 = com.bykv.vk.openvk.preload.a.d.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.bykv.vk.openvk.preload.a.d.b r1 = com.bykv.vk.openvk.preload.a.d.b.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bykv.vk.openvk.preload.a.d.b r1 = com.bykv.vk.openvk.preload.a.d.b.NULL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.bykv.vk.openvk.preload.a.d.b r1 = com.bykv.vk.openvk.preload.a.d.b.NUMBER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.geckox.c.a.AnonymousClass1.<clinit>():void");
        }
    }

    public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
        b f = aVar.f();
        int i = AnonymousClass1.a[f.ordinal()];
        boolean z = true;
        if (i == 1) {
            return Boolean.valueOf(aVar.j());
        }
        if (i == 2) {
            aVar.k();
            return null;
        } else if (i == 3) {
            if (aVar.n() == 0) {
                z = false;
            }
            return Boolean.valueOf(z);
        } else {
            throw new o("Expected BOOLEAN or NUMBER but was ".concat(String.valueOf(f)));
        }
    }
}
