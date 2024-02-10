package com.bykv.vk.openvk.preload.geckox.f;

import com.bykv.vk.openvk.preload.geckox.f.a.b;
import com.bykv.vk.openvk.preload.geckox.f.a.c;
import com.bykv.vk.openvk.preload.geckox.utils.j;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ChannelVerLoader */
public final class a {
    public String a;
    public String b;
    public volatile File c;
    volatile Long d;
    public AtomicBoolean e = new AtomicBoolean(false);
    private volatile com.bykv.vk.openvk.preload.geckox.f.a.a f;

    a(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final synchronized com.bykv.vk.openvk.preload.geckox.f.a.a a(String str) throws Exception {
        if (this.f != null) {
            return this.f;
        }
        File c2 = c(str);
        if (c2 != null) {
            File file = new File(c2, "res.macv");
            File file2 = new File(c2, "res");
            if (file2.exists() && file2.isDirectory()) {
                this.f = new c(c2);
            } else if (!file.exists() || !file.isFile()) {
                throw new RuntimeException("can not find res, dir:" + c2.getAbsolutePath());
            } else {
                this.f = new b(c2);
            }
            return this.f;
        }
        throw new FileNotFoundException("channel no exist，channel:".concat(String.valueOf(str)));
    }

    public static String a(String str, String str2) {
        return str2.substring(str.length() + 1);
    }

    private synchronized File c(String str) throws Exception {
        if (this.c != null) {
            return this.c;
        } else if (this.d != null && this.d.longValue() == -1) {
            return null;
        } else {
            com.bykv.vk.openvk.preload.geckox.g.b a2 = com.bykv.vk.openvk.preload.geckox.g.b.a(this.a + File.separator + str + File.separator + "select.lock");
            try {
                if (this.d == null) {
                    this.d = j.a(new File(this.a, str));
                }
                if (this.d == null) {
                    this.d = -1L;
                    return null;
                }
                String str2 = this.a;
                File file = new File(str2, File.separator + str + File.separator + this.d + File.separator + "using.lock");
                this.c = file.getParentFile();
                com.bykv.vk.openvk.preload.geckox.g.c.a(file.getAbsolutePath());
                File file2 = this.c;
                a2.a();
                return file2;
            } finally {
                a2.a();
            }
        }
    }

    public final int b(String str) {
        int length;
        try {
            File file = new File(c(str), "res");
            if (!file.exists() || !file.isDirectory() || (length = file.listFiles().length) <= 0) {
                return 0;
            }
            return length - 1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
