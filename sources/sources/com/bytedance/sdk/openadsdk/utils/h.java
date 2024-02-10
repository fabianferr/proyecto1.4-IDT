package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.c;
import com.bytedance.sdk.component.utils.l;
import java.io.Closeable;
import java.io.File;

/* compiled from: FileCacheUtils */
public class h {
    private static String a;

    public static String a() {
        if (TextUtils.isEmpty(a)) {
            a = c.a().getCacheDir() + File.separator + "proxy_cache";
        }
        return a;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                l.c(th.getMessage());
            }
        }
    }
}
