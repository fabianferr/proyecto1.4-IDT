package com.bykv.vk.openvk.preload.geckox.a.a;

import com.bykv.vk.openvk.preload.geckox.a.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: FIFOCachePolicy */
final class e extends b {
    e() {
    }

    public final void a(a aVar, File file, List<String> list) {
        super.a(aVar, file, list);
    }

    public final void a() {
        List list;
        for (String file : this.f) {
            File file2 = new File(this.e, file);
            if (!file2.exists() || !file2.isDirectory()) {
                list = null;
            } else {
                File[] listFiles = file2.listFiles();
                list = (listFiles == null || listFiles.length <= 0) ? new ArrayList() : Arrays.asList(listFiles);
                if (list != null && list.size() > 0) {
                    Collections.sort(list, new Comparator<File>() {
                        public final /* synthetic */ int compare(Object obj, Object obj2) {
                            return Long.compare(((File) obj).lastModified(), ((File) obj2).lastModified());
                        }
                    });
                }
            }
            if (list != null && list.size() > this.d.a) {
                for (File file3 : list.subList(0, list.size() - this.d.a)) {
                    c.b(file3.getAbsolutePath());
                    if (this.d.c != null) {
                        file3.getName();
                    }
                }
            }
        }
    }
}
