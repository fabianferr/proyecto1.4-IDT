package com.bytedance.sdk.component.g;

/* compiled from: TTBaseExecutor */
public class e {
    private static j a = new j() {
        public i createThreadFactory(int i, String str) {
            return new i(i, str);
        }
    };

    public static void a(j jVar) {
        a = jVar;
    }

    public static j a() {
        return a;
    }
}
