package com.apm.insight.h;

import androidx.media3.common.C;
import com.apm.insight.c;
import com.apm.insight.i;
import com.apm.insight.l.q;
import com.apm.insight.runtime.p;
import com.apm.insight.runtime.r;
import java.io.File;
import java.util.HashMap;

public class b {
    /* access modifiers changed from: private */
    public static HashMap<String, String> a;

    public static String a() {
        return i.g().getFilesDir() + "/apminsight/selflib/";
    }

    public static String a(String str) {
        return i.g().getFilesDir() + "/apminsight/selflib/lib" + str + ".so";
    }

    public static void b(final String str) {
        p.b().a((Runnable) new Runnable() {
            boolean a = false;

            public void run() {
                String str;
                String str2;
                b.d();
                if (!b.f(str)) {
                    r.a("updateSo", str);
                    File file = new File(b.a(str));
                    file.getParentFile().mkdirs();
                    if (file.exists()) {
                        file.delete();
                    }
                    q.a("doUnpackLibrary: " + str);
                    try {
                        str = c.a(i.g(), str, file);
                    } catch (Throwable th) {
                        r.a("updateSoError", str);
                        c.a().a("NPTH_CATCH", th);
                        str = null;
                    }
                    if (str == null) {
                        b.a.put(file.getName(), "1.3.8.nourl-alpha.18");
                        try {
                            com.apm.insight.l.i.a(new File(b.e(str)), "1.3.8.nourl-alpha.18", false);
                        } catch (Throwable unused) {
                        }
                        str2 = "updateSoSuccess";
                    } else if (!this.a) {
                        this.a = true;
                        r.a("updateSoPostRetry", str);
                        p.b().a((Runnable) this, (long) C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                        return;
                    } else {
                        str2 = "updateSoFailed";
                    }
                    r.a(str2, str);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static void d() {
        if (a == null) {
            a = new HashMap<>();
            File file = new File(i.g().getFilesDir(), "/apminsight/selflib/");
            String[] list = file.list();
            if (list != null) {
                for (String str : list) {
                    if (str.endsWith(".ver")) {
                        String substring = str.substring(0, str.length() - 4);
                        try {
                            a.put(substring, com.apm.insight.l.i.c(file.getAbsolutePath() + "/" + str));
                        } catch (Throwable th) {
                            c.a().a("NPTH_CATCH", th);
                        }
                    } else if (!str.endsWith(".so")) {
                        com.apm.insight.l.i.a(new File(file, str));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static String e(String str) {
        return i.g().getFilesDir() + "/apminsight/selflib/" + str + ".ver";
    }

    /* access modifiers changed from: private */
    public static boolean f(String str) {
        return "1.3.8.nourl-alpha.18".equals(a.get(str)) && new File(a(str)).exists();
    }
}
