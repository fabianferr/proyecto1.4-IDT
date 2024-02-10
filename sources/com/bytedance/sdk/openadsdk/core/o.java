package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import android.view.ViewConfiguration;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.b.a.d;
import com.bytedance.sdk.openadsdk.core.settings.e;
import com.bytedance.sdk.openadsdk.core.settings.k;
import com.bytedance.sdk.openadsdk.j.c.b;
import java.lang.reflect.Method;

/* compiled from: InternalContainer */
public class o {
    private static volatile Context a = null;
    private static volatile p<com.bytedance.sdk.openadsdk.b.a> b = null;
    private static int c = -1;

    public static Context a() {
        if (a == null) {
            a((Context) null);
        }
        return a;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:4|5|(1:(2:8|(1:10))(3:13|14|(1:16)))|17|18|19|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r2) {
        /*
            android.content.Context r0 = a
            if (r0 != 0) goto L_0x0026
            java.lang.Class<com.bytedance.sdk.openadsdk.core.o> r0 = com.bytedance.sdk.openadsdk.core.o.class
            monitor-enter(r0)
            android.content.Context r1 = a     // Catch:{ all -> 0x0023 }
            if (r1 != 0) goto L_0x0021
            if (r2 == 0) goto L_0x0019
            a = r2     // Catch:{ all -> 0x0023 }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x0023 }
            if (r2 == 0) goto L_0x0017
            a = r2     // Catch:{ all -> 0x0023 }
        L_0x0017:
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return
        L_0x0019:
            android.app.Application r2 = com.bytedance.sdk.openadsdk.core.o.a.a()     // Catch:{ all -> 0x0021 }
            if (r2 == 0) goto L_0x0021
            a = r2     // Catch:{ all -> 0x0021 }
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            goto L_0x0026
        L_0x0023:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            throw r2
        L_0x0026:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.a(android.content.Context):void");
    }

    public static int b() {
        Context a2;
        if (c < 0 && (a2 = a()) != null) {
            c = ViewConfiguration.get(a2).getScaledTouchSlop();
        }
        return c;
    }

    public static p<com.bytedance.sdk.openadsdk.b.a> c() {
        if (b == null) {
            synchronized (o.class) {
                if (b == null) {
                    b = new q(a);
                }
            }
        }
        return b;
    }

    public static e d() {
        return com.bytedance.sdk.openadsdk.core.settings.o.ai();
    }

    public static com.bytedance.sdk.openadsdk.j.c.a e() {
        if (!k.a()) {
            return b.a();
        }
        return d.a();
    }

    /* compiled from: InternalContainer */
    private static class a {
        private static volatile Application a;

        public static Application a() {
            return a;
        }

        static {
            try {
                Object b = b();
                a = (Application) b.getClass().getMethod("getApplication", new Class[0]).invoke(b, new Object[0]);
                l.e("MyApplication", "application get success");
            } catch (Throwable th) {
                l.c("MyApplication", "application get failed", th);
            }
        }

        private static Object b() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke((Object) null, new Object[0]);
            } catch (Throwable th) {
                l.c("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }
}
