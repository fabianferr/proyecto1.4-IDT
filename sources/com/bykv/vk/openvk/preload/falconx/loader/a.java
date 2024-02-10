package com.bykv.vk.openvk.preload.falconx.loader;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.preload.geckox.f.b;
import com.bykv.vk.openvk.preload.geckox.g.c;
import java.io.File;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: GeckoResLoader */
public final class a implements ILoader {
    public b a;
    public AtomicBoolean b = new AtomicBoolean(false);

    public a(Context context, String str, File file) {
        if (context == null) {
            throw new RuntimeException("context == null");
        } else if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("access key empty");
        } else if (file != null) {
            this.a = new b(context, str, file);
        } else {
            throw new RuntimeException("resRootDir == null");
        }
    }

    public final InputStream getInputStream(String str) throws Exception {
        if (!this.b.get()) {
            com.bykv.vk.openvk.preload.geckox.h.b.a("WebOffline-falcon", "GeckoResLoader ready to load, file:", str);
            b bVar = this.a;
            if (bVar.b.get()) {
                throw new RuntimeException("released");
            } else if (!TextUtils.isEmpty(str)) {
                com.bykv.vk.openvk.preload.geckox.f.a a2 = bVar.a(str.trim());
                return a2.a(a2.b).a(com.bykv.vk.openvk.preload.geckox.f.a.a(a2.b, str));
            } else {
                throw new RuntimeException("relativePath empty");
            }
        } else {
            throw new RuntimeException("released!");
        }
    }

    public final boolean exist(String str) throws Exception {
        if (!this.b.get()) {
            b bVar = this.a;
            if (bVar.b.get()) {
                throw new RuntimeException("released");
            } else if (!TextUtils.isEmpty(str)) {
                com.bykv.vk.openvk.preload.geckox.f.a a2 = bVar.a(str.trim());
                return a2.a(a2.b).b(com.bykv.vk.openvk.preload.geckox.f.a.a(a2.b, str));
            } else {
                throw new RuntimeException("relativePath empty");
            }
        } else {
            throw new RuntimeException("released!");
        }
    }

    public final String getResRootDir() {
        return this.a.c;
    }

    public final Map<String, Long> getChannelVersion() {
        return this.a.a();
    }

    public final void release() throws Exception {
        if (!this.b.getAndSet(true)) {
            b bVar = this.a;
            if (!bVar.b.getAndSet(true)) {
                com.bykv.vk.openvk.preload.geckox.h.b.a("Loader", "release version res loader");
                synchronized (bVar.a) {
                    for (com.bykv.vk.openvk.preload.geckox.f.a next : bVar.a.values()) {
                        if (!next.e.getAndSet(true)) {
                            com.bykv.vk.openvk.preload.geckox.g.b a2 = com.bykv.vk.openvk.preload.geckox.g.b.a(next.a + File.separator + next.b + File.separator + "select.lock");
                            com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-file-lock", "channel version loader clean");
                            try {
                                if (next.c != null) {
                                    c.b(next.c.getAbsolutePath() + File.separator + "using.lock");
                                    a2.a();
                                    com.bykv.vk.openvk.preload.geckox.a.c.a(next.a + File.separator + next.b);
                                }
                            } finally {
                                a2.a();
                            }
                        }
                    }
                    bVar.a.clear();
                }
            }
        }
    }
}
