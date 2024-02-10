package com.bykv.vk.openvk.preload.b;

/* compiled from: InterceptorFactory */
public interface e {
    <T> T a(Class<T> cls);

    /* compiled from: InterceptorFactory */
    public static class a implements e {
        public final <T> T a(Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
