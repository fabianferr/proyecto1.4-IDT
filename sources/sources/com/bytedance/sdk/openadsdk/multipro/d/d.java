package com.bytedance.sdk.openadsdk.multipro.d;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.b;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.b;

/* compiled from: TTSaveHelper */
public class d {
    private static boolean a() {
        return o.a() == null;
    }

    private static String b(String str) {
        return TextUtils.isEmpty(str) ? "tt_sp" : str;
    }

    public static void a(String str, String str2, Boolean bool) {
        if (!a()) {
            if (b.c()) {
                a.a(b(str), str2, bool);
            } else {
                a(b(str), str2, bool);
            }
        }
    }

    public static void a(String str, String str2, Long l) {
        if (!a()) {
            if (b.c()) {
                a.a(b(str), str2, l);
            } else {
                a(b(str), str2, l);
            }
        }
    }

    public static void a(String str, String str2, String str3) {
        if (!a()) {
            if (b.c()) {
                a.a(b(str), str2, str3);
            } else {
                a(b(str), str2, str3);
            }
        }
    }

    public static void a(String str, String str2, Integer num) {
        if (!a()) {
            if (b.c()) {
                a.a(b(str), str2, num);
            } else {
                a(b(str), str2, num);
            }
        }
    }

    public static int a(String str, String str2, int i) {
        if (a()) {
            return i;
        }
        if (b.c()) {
            return a.a(b(str), str2, i);
        }
        return a.a(o.a(), b(str), str2, i);
    }

    public static boolean a(String str, String str2, boolean z) {
        if (a()) {
            return z;
        }
        if (b.c()) {
            return a.a(b(str), str2, z);
        }
        return a.a(o.a(), b(str), str2, z);
    }

    public static long a(String str, String str2, long j) {
        if (a()) {
            return j;
        }
        if (b.c()) {
            return a.a(b(str), str2, j);
        }
        return a.a(o.a(), b(str), str2, j);
    }

    public static String b(String str, String str2, String str3) {
        if (a()) {
            return str3;
        }
        if (b.c()) {
            return a.b(b(str), str2, str3);
        }
        return a.a(o.a(), b(str), str2, str3);
    }

    public static void a(String str, String str2) {
        if (!a()) {
            try {
                if (b.c()) {
                    a.b(b(str), str2);
                } else {
                    b.b(o.a(), b(str), str2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str) {
        if (!a()) {
            if (b.c()) {
                a.a(b(str));
            } else {
                b.b(o.a(), b(str));
            }
        }
    }

    private static <T> void a(String str, String str2, T t) {
        String a = a.a(str, str2);
        if (h.e(a)) {
            b.c b = com.bytedance.sdk.component.b.a(o.a(), b(a)).b();
            b.a(b, str2, t);
            b.apply();
            return;
        }
        SharedPreferences a2 = b.a(o.a(), b(a));
        if (a2 != null) {
            SharedPreferences.Editor edit = a2.edit();
            b.a(edit, str2, t);
            edit.apply();
        }
    }
}
