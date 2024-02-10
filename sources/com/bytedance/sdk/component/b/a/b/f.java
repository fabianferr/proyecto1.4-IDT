package com.bytedance.sdk.component.b.a.b;

/* compiled from: SegmentPool */
final class f {
    static e a;
    static long b;

    private f() {
    }

    static e a() {
        synchronized (f.class) {
            e eVar = a;
            if (eVar == null) {
                return new e();
            }
            a = eVar.f;
            eVar.f = null;
            b -= 8192;
            return eVar;
        }
    }

    static void a(e eVar) {
        if (eVar.f != null || eVar.g != null) {
            throw new IllegalArgumentException();
        } else if (!eVar.d) {
            synchronized (f.class) {
                long j = b;
                if (j + 8192 <= 65536) {
                    b = j + 8192;
                    eVar.f = a;
                    eVar.c = 0;
                    eVar.b = 0;
                    a = eVar;
                }
            }
        }
    }
}
