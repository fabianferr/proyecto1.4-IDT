package com.bykv.vk.openvk.preload.geckox.h;

/* compiled from: GeckoLogger */
public final class b {
    private static boolean a = false;
    private static c b = new a();

    public static void a(String str, Object... objArr) {
        c cVar;
        if (a && (cVar = b) != null) {
            cVar.a(str, objArr);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        c cVar;
        if (a && (cVar = b) != null) {
            cVar.a(str, str2, th);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        c cVar;
        if (a && (cVar = b) != null) {
            cVar.b(str, str2, th);
        }
    }
}
