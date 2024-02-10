package com.bytedance.sdk.openadsdk.f;

import android.content.Context;
import com.bytedance.sdk.component.b.a.f;
import com.bytedance.sdk.component.d.c.b;
import com.bytedance.sdk.component.d.c.e;
import com.bytedance.sdk.component.d.j;
import com.bytedance.sdk.component.d.m;
import com.bytedance.sdk.component.d.s;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.z;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ImageLoaderWrapper */
public class d {
    public static j a(String str) {
        return a.b(str);
    }

    public static j a(n nVar) {
        return a.b(nVar);
    }

    public static InputStream a(String str, String str2) {
        return a.b(str, str2);
    }

    public static boolean a(String str, String str2, String str3) {
        return a.b(str, str2, str3);
    }

    public static com.bytedance.sdk.component.d.n a() {
        return a.a;
    }

    /* compiled from: ImageLoaderWrapper */
    private static final class a {
        /* access modifiers changed from: private */
        public static final com.bytedance.sdk.component.d.n a = a(o.a());

        private static com.bytedance.sdk.component.d.n a(Context context) {
            return b.a(context, (m) new e.a().a((com.bytedance.sdk.component.d.b) new com.bytedance.sdk.component.d.c.a.a(Math.max(Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 83886080), 10485760), 41943040, new File(CacheDirFactory.getImageCacheDir()))).a(aa.b()).a((com.bytedance.sdk.component.d.d) new com.bytedance.sdk.component.d.d() {
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.Closeable} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.bytedance.sdk.component.d.b.e} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.bytedance.sdk.component.d.b.e} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.bytedance.sdk.component.d.b.e} */
                /* JADX WARNING: Multi-variable type inference failed */
                /* renamed from: b */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public com.bytedance.sdk.component.d.b.d a(com.bytedance.sdk.component.d.e r7) {
                    /*
                        r6 = this;
                        com.bytedance.sdk.openadsdk.k.c r0 = com.bytedance.sdk.openadsdk.k.c.a()
                        com.bytedance.sdk.component.f.a r0 = r0.b()
                        com.bytedance.sdk.component.b.a.j r0 = r0.e()
                        com.bytedance.sdk.component.b.a.l$a r1 = new com.bytedance.sdk.component.b.a.l$a
                        r1.<init>()
                        java.lang.String r2 = r7.a()
                        com.bytedance.sdk.component.b.a.l$a r1 = r1.a((java.lang.String) r2)
                        com.bytedance.sdk.component.b.a.l$a r1 = r1.a()
                        com.bytedance.sdk.component.b.a.l r1 = r1.b()
                        boolean r2 = r7.c()
                        r3 = 0
                        if (r2 == 0) goto L_0x002e
                        com.bytedance.sdk.component.d.b.e r2 = new com.bytedance.sdk.component.d.b.e
                        r2.<init>()
                        goto L_0x002f
                    L_0x002e:
                        r2 = r3
                    L_0x002f:
                        if (r2 == 0) goto L_0x0038
                        long r4 = java.lang.System.currentTimeMillis()
                        r2.a(r4)
                    L_0x0038:
                        com.bytedance.sdk.component.b.a.b r0 = r0.a(r1)     // Catch:{ all -> 0x0070 }
                        com.bytedance.sdk.component.b.a.n r3 = r0.a()     // Catch:{ all -> 0x0070 }
                        if (r2 == 0) goto L_0x0049
                        long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0070 }
                        r2.b(r0)     // Catch:{ all -> 0x0070 }
                    L_0x0049:
                        java.util.Map r7 = r6.a((com.bytedance.sdk.component.d.e) r7, (com.bytedance.sdk.component.b.a.n) r3)     // Catch:{ all -> 0x0070 }
                        com.bytedance.sdk.component.b.a.o r0 = r3.f()     // Catch:{ all -> 0x0070 }
                        byte[] r0 = r0.d()     // Catch:{ all -> 0x0070 }
                        if (r2 == 0) goto L_0x005e
                        long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0070 }
                        r2.c(r4)     // Catch:{ all -> 0x0070 }
                    L_0x005e:
                        com.bytedance.sdk.component.d.b.d r1 = new com.bytedance.sdk.component.d.b.d     // Catch:{ all -> 0x0070 }
                        int r4 = r3.c()     // Catch:{ all -> 0x0070 }
                        java.lang.String r5 = ""
                        r1.<init>(r4, r0, r5, r7)     // Catch:{ all -> 0x0070 }
                        r1.a(r2)     // Catch:{ all -> 0x0070 }
                        com.bytedance.sdk.component.d.c.c.b.a(r3)
                        return r1
                    L_0x0070:
                        r7 = move-exception
                        com.bytedance.sdk.component.d.b.d r7 = r6.a((com.bytedance.sdk.component.d.b.e) r2, (java.lang.Throwable) r7)     // Catch:{ all -> 0x0079 }
                        com.bytedance.sdk.component.d.c.c.b.a(r3)
                        return r7
                    L_0x0079:
                        r7 = move-exception
                        com.bytedance.sdk.component.d.c.c.b.a(r3)
                        throw r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.f.d.a.AnonymousClass1.a(com.bytedance.sdk.component.d.e):com.bytedance.sdk.component.d.b.d");
                }

                private Map<String, String> a(com.bytedance.sdk.component.d.e eVar, com.bytedance.sdk.component.b.a.n nVar) {
                    if (!eVar.b()) {
                        return null;
                    }
                    f g = nVar.g();
                    HashMap hashMap = new HashMap();
                    int a = g.a();
                    for (int i = 0; i < a; i++) {
                        String a2 = g.a(i);
                        String b = g.b(i);
                        if (a2 != null) {
                            hashMap.put(a2, b);
                        }
                    }
                    return hashMap;
                }

                private com.bytedance.sdk.component.d.b.d a(com.bytedance.sdk.component.d.b.e eVar, Throwable th) {
                    l.d("ImageLoaderWrapper", th.getMessage());
                    if (eVar != null) {
                        eVar.c(System.currentTimeMillis());
                    }
                    com.bytedance.sdk.component.d.b.d dVar = new com.bytedance.sdk.component.d.b.d(98765, th, "net failed");
                    dVar.a(eVar);
                    return dVar;
                }
            }).a());
        }

        /* access modifiers changed from: private */
        public static j b(String str) {
            return a(a.a(str).d(ad.d(o.a())).c(ad.c(o.a())));
        }

        /* access modifiers changed from: private */
        public static j b(n nVar) {
            return a(a.a(nVar.a()).a(nVar.b()).b(nVar.c()).d(ad.d(o.a())).c(ad.c(o.a())).a(nVar.g()));
        }

        private static j a(j jVar) {
            return z.a() ? jVar.a((s) new e()) : jVar;
        }

        /* access modifiers changed from: private */
        public static InputStream b(String str, String str2) {
            return a.a(str, str2);
        }

        /* access modifiers changed from: private */
        public static boolean b(String str, String str2, String str3) {
            return a.a(str, str2, str3);
        }
    }
}
