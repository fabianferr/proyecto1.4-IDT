package com.bykv.vk.openvk.component.video.api;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.b.a.j;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* compiled from: VideoConfig */
public class c {
    public static boolean a = false;
    private static Context b = null;
    private static String c = null;
    private static boolean d = false;
    private static j e = null;
    private static int f = 1;

    public static Context a() {
        return b;
    }

    public static void a(int i) {
        f = i;
    }

    public static void a(Context context, String str) {
        b = context;
        c = str;
    }

    public static void a(j jVar) {
        e = jVar;
    }

    public static void a(boolean z) {
        d = z;
    }

    public static String b() {
        if (TextUtils.isEmpty(c)) {
            try {
                File file = new File(a().getFilesDir(), "ttad_dir");
                if (!file.exists()) {
                    file.mkdirs();
                }
                c = file.getAbsolutePath();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return c;
    }

    public static boolean c() {
        return d;
    }

    public static j d() {
        if (e == null) {
            e = new j.a("v_config").a(10000, TimeUnit.MILLISECONDS).b(10000, TimeUnit.MILLISECONDS).c(10000, TimeUnit.MILLISECONDS).a();
        }
        return e;
    }

    public static boolean e() {
        return a;
    }

    public static int f() {
        return f;
    }
}
