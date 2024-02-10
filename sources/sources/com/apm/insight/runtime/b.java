package com.apm.insight.runtime;

import com.apm.insight.i;
import com.apm.insight.l.o;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class b {
    private static long a = -30000;
    private static File b;

    public static String a(long j, String str) {
        try {
            String j2 = o.j(i.g());
            return com.apm.insight.l.i.c(new File(j2, "apminsight/TrackInfo/" + ((j - (j % 86400000)) / 86400000) + "/" + str));
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    public static void a() {
        File file = new File(o.j(i.g()), "apminsight/TrackInfo/");
        String[] list = file.list();
        if (list != null && list.length > 5) {
            Arrays.sort(list);
            for (int i = 0; i < list.length - 5; i++) {
                com.apm.insight.l.i.a(new File(file, list[i]));
            }
        }
    }

    public static void a(long j) {
        if (j - a >= 30000) {
            a = j;
            try {
                com.apm.insight.l.i.a(b(), String.valueOf(System.currentTimeMillis()), false);
            } catch (IOException unused) {
            }
        }
    }

    private static File b() {
        if (b == null) {
            long currentTimeMillis = System.currentTimeMillis();
            String j = o.j(i.g());
            b = new File(j, "apminsight/TrackInfo/" + ((currentTimeMillis - (currentTimeMillis % 86400000)) / 86400000) + "/" + i.f());
        }
        return b;
    }
}
