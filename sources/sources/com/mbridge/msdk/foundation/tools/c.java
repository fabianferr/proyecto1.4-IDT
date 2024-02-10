package com.mbridge.msdk.foundation.tools;

/* compiled from: Container */
final class c {

    /* compiled from: Container */
    static abstract class b {
        int a;

        /* access modifiers changed from: package-private */
        public abstract byte a();

        b() {
        }
    }

    /* renamed from: com.mbridge.msdk.foundation.tools.c$c  reason: collision with other inner class name */
    /* compiled from: Container */
    static class C0145c extends b {
        boolean b;

        /* access modifiers changed from: package-private */
        public final byte a() {
            return 1;
        }

        C0145c(int i, boolean z) {
            this.a = i;
            this.b = z;
        }
    }

    /* compiled from: Container */
    static class f extends b {
        int b;

        /* access modifiers changed from: package-private */
        public final byte a() {
            return 2;
        }

        f(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    /* compiled from: Container */
    static class e extends b {
        float b;

        /* access modifiers changed from: package-private */
        public final byte a() {
            return 3;
        }

        e(int i, float f) {
            this.a = i;
            this.b = f;
        }
    }

    /* compiled from: Container */
    static class g extends b {
        long b;

        /* access modifiers changed from: package-private */
        public final byte a() {
            return 4;
        }

        g(int i, long j) {
            this.a = i;
            this.b = j;
        }
    }

    /* compiled from: Container */
    static class d extends b {
        double b;

        /* access modifiers changed from: package-private */
        public final byte a() {
            return 5;
        }

        d(int i, double d) {
            this.a = i;
            this.b = d;
        }
    }

    /* compiled from: Container */
    static abstract class j extends b {
        Object b;
        int c;
        int d;
        boolean e;

        j(int i, int i2, Object obj, int i3, boolean z) {
            this.c = i;
            this.a = i2;
            this.b = obj;
            this.d = i3;
            this.e = z;
        }
    }

    /* compiled from: Container */
    static class i extends j {
        /* access modifiers changed from: package-private */
        public final byte a() {
            return 6;
        }

        i(int i, int i2, String str, int i3, boolean z) {
            super(i, i2, str, i3, z);
        }
    }

    /* compiled from: Container */
    static class a extends j {
        /* access modifiers changed from: package-private */
        public final byte a() {
            return 7;
        }

        a(int i, int i2, Object obj, int i3, boolean z) {
            super(i, i2, obj, i3, z);
        }
    }

    /* compiled from: Container */
    static class h extends j {
        /* access modifiers changed from: package-private */
        public final byte a() {
            return 8;
        }

        h(int i, int i2, Object obj, int i3, boolean z) {
            super(i, i2, obj, i3, z);
        }
    }
}
