package com.bykv.vk.openvk.preload.geckox.f;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: VersionedResLoader */
public final class b {
    public final Map<String, a> a = new HashMap();
    public AtomicBoolean b = new AtomicBoolean(false);
    public String c;
    private String d;

    public b(Context context, String str, File file) {
        if (!TextUtils.isEmpty(str)) {
            this.d = str;
            if (file == null) {
                File filesDir = context.getFilesDir();
                this.c = new File(filesDir, "gecko_offline_res_x" + File.separator + str).getAbsolutePath();
                return;
            }
            this.c = new File(file, str).getAbsolutePath();
            return;
        }
        throw new RuntimeException("access key empty");
    }

    public final a a(String str) {
        a aVar;
        int indexOf = str.indexOf("/");
        if (indexOf == -1) {
            new RuntimeException("channel：".concat(String.valueOf(str)));
        }
        String substring = str.substring(0, indexOf);
        synchronized (this.a) {
            aVar = this.a.get(substring);
            if (aVar == null) {
                aVar = new a(this.c, substring);
                this.a.put(substring, aVar);
            }
        }
        return aVar;
    }

    public final Map<String, Long> a() {
        HashMap hashMap = new HashMap();
        synchronized (this.a) {
            Collection<a> values = this.a.values();
            if (values == null) {
                return hashMap;
            }
            for (a next : values) {
                hashMap.put(next.b, next.d);
            }
            return hashMap;
        }
    }
}
