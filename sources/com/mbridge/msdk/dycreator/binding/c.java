package com.mbridge.msdk.dycreator.binding;

/* compiled from: ViewDataFactory */
public final class c {
    private static volatile c a;

    private c() {
    }

    public static c a() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }
}
