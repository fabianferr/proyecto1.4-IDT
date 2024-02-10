package com.apm.insight.c;

import com.apm.insight.i;
import com.apm.insight.runtime.a;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class b {
    private static AtomicBoolean a = new AtomicBoolean(false);

    public static boolean a() {
        synchronized (a) {
            if (a.get()) {
                return false;
            }
            a.set(true);
            return b();
        }
    }

    public static boolean b() {
        if (!a.h()) {
            return false;
        }
        try {
            File file = new File(i.h().getFilesDir(), "apminsight/crashCommand");
            file.mkdirs();
            new File(file, "0_" + System.currentTimeMillis()).createNewFile();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
