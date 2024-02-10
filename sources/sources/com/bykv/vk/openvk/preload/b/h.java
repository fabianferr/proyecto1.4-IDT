package com.bykv.vk.openvk.preload.b;

/* compiled from: Pipe */
public final class h {
    Class<? extends d> a;
    com.bykv.vk.openvk.preload.b.b.a b;
    Object[] c;

    /* synthetic */ h(a aVar, byte b2) {
        this(aVar);
    }

    private h(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        if (this.a == null) {
            throw new IllegalArgumentException("Interceptor class == null");
        }
    }

    /* compiled from: Pipe */
    public static final class a {
        Class<? extends d> a;
        public com.bykv.vk.openvk.preload.b.b.a b;
        public Object[] c;

        public final a a(Class<? extends d> cls) {
            if (cls != null) {
                this.a = cls;
                return this;
            }
            throw new IllegalArgumentException("interceptor class == null");
        }

        public final h a() {
            return new h(this, (byte) 0);
        }
    }
}
