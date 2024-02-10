package com.bykv.vk.openvk.preload.geckox.utils;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ResVersionUtils */
public final class j {
    public static Long a(File file) {
        File[] listFiles = file.listFiles(new FileFilter() {
            public final boolean accept(File file) {
                return file.isDirectory();
            }
        });
        Long l = null;
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File name : listFiles) {
                try {
                    long longValue = Long.valueOf(name.getName()).longValue();
                    if (l == null) {
                        l = Long.valueOf(longValue);
                    } else if (longValue > l.longValue()) {
                        l = Long.valueOf(longValue);
                    }
                } catch (Exception unused) {
                }
            }
        }
        return l;
    }

    public static List<Long> b(File file) {
        File[] listFiles = file.listFiles(new FileFilter() {
            public final boolean accept(File file) {
                return file.isDirectory();
            }
        });
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File name : listFiles) {
            try {
                arrayList.add(Long.valueOf(Long.valueOf(name.getName()).longValue()));
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }
}
