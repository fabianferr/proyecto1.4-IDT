package com.bytedance.sdk.openadsdk.multipro.d;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.e.a.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.d;
import java.util.HashSet;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: SPMultiHelper */
public class a {
    public static HashSet<String> a = new HashSet<String>() {
        {
            add("did");
            add("app_id");
            add("global_coppa");
            add("tt_gdpr");
            add("global_ccpa");
            add("keywords");
            add("extra_data");
            add("gaid");
            add("sdk_app_sha1");
            add("uuid");
            add("android_system_ua");
            add("sdk_local_web_ua");
            add("sdk_local_rom_info");
        }
    };

    public static boolean a() {
        if (o.a() != null) {
            return true;
        }
        l.d("The context of SPHelper is null, please initialize sdk in main process");
        return false;
    }

    private static g b() {
        try {
            if (a()) {
                return com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Context c() {
        return o.a();
    }

    private static String d() {
        return d.b + "/t_sp/";
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "?sp_file_name=" + str;
    }

    public static synchronized void a(String str, String str2, Boolean bool) {
        synchronized (a.class) {
            if (a()) {
                try {
                    if (!b.c()) {
                        b.a(c(), str, str2, bool);
                        return;
                    }
                    g b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + "boolean/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", bool);
                        b.a(parse, contentValues, (String) null, (String[]) null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(String str, String str2, String str3) {
        synchronized (a.class) {
            if (a()) {
                try {
                    if (!b.c()) {
                        b.a(c(), str, str2, str3);
                        return;
                    }
                    g b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + "string/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", str3);
                        b.a(parse, contentValues, (String) null, (String[]) null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(String str, String str2, Integer num) {
        synchronized (a.class) {
            if (a()) {
                try {
                    if (!b.c()) {
                        b.a(c(), str, str2, num);
                        return;
                    }
                    g b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + "int/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", num);
                        b.a(parse, contentValues, (String) null, (String[]) null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(String str, String str2, Long l) {
        synchronized (a.class) {
            if (a()) {
                try {
                    if (!b.c()) {
                        b.a(c(), str, str2, l);
                        return;
                    }
                    g b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + "long/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", l);
                        b.a(parse, contentValues, (String) null, (String[]) null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(String str, String str2, Float f) {
        synchronized (a.class) {
            if (a()) {
                try {
                    if (!b.c()) {
                        b.a(c(), str, str2, f);
                        return;
                    }
                    g b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + "float/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", f);
                        b.a(parse, contentValues, (String) null, (String[]) null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static String b(String str, String str2, String str3) {
        if (!a()) {
            return str3;
        }
        try {
            if (!b.c()) {
                return a(c(), str, str2, str3);
            }
            g b = b();
            if (b != null) {
                String a2 = b.a(Uri.parse(d() + "string/" + str2 + b(str)));
                return (a2 == null || a2.equals(AbstractJsonLexerKt.NULL)) ? str3 : a2;
            }
        } catch (Throwable unused) {
        }
    }

    protected static String a(Context context, String str, String str2, String str3) {
        String a2 = a(str, str2);
        if (h.e(a2)) {
            return com.bytedance.sdk.component.b.a(context, a2).a(str2, str3);
        }
        SharedPreferences a3 = b.a(context, a2);
        if (a3 == null) {
            return str3;
        }
        return a3.getString(str2, str3);
    }

    public static String a(String str, String str2) {
        return a.contains(str2) ? "pag_sp_bad_par" : str;
    }

    public static int a(String str, String str2, int i) {
        if (!a()) {
            return i;
        }
        try {
            if (!b.c()) {
                return a(c(), str, str2, i);
            }
            g b = b();
            if (b != null) {
                String a2 = b.a(Uri.parse(d() + "int/" + str2 + b(str)));
                if (a2 != null) {
                    if (!a2.equals(AbstractJsonLexerKt.NULL)) {
                        return Integer.parseInt(a2);
                    }
                }
            }
            return i;
        } catch (Throwable unused) {
        }
    }

    protected static int a(Context context, String str, String str2, int i) {
        String a2 = a(str, str2);
        if (h.e(a2)) {
            return com.bytedance.sdk.component.b.a(context, a2).a(str2, i);
        }
        SharedPreferences a3 = b.a(context, a2);
        if (a3 == null) {
            return i;
        }
        return a3.getInt(str2, i);
    }

    protected static float a(Context context, String str, String str2, float f) {
        String a2 = a(str, str2);
        if (h.e(a2)) {
            return com.bytedance.sdk.component.b.a(context, a2).a(str2, f);
        }
        SharedPreferences a3 = b.a(context, a2);
        if (a3 == null) {
            return f;
        }
        return a3.getFloat(str2, f);
    }

    public static boolean a(String str, String str2, boolean z) {
        if (!a()) {
            return z;
        }
        try {
            if (!b.c()) {
                return a(c(), str, str2, z);
            }
            g b = b();
            if (b != null) {
                String a2 = b.a(Uri.parse(d() + "boolean/" + str2 + b(str)));
                if (a2 != null) {
                    if (!a2.equals(AbstractJsonLexerKt.NULL)) {
                        return Boolean.parseBoolean(a2);
                    }
                }
            }
            return z;
        } catch (Throwable unused) {
        }
    }

    protected static boolean a(Context context, String str, String str2, boolean z) {
        String a2 = a(str, str2);
        if (h.e(a2)) {
            return com.bytedance.sdk.component.b.a(context, a2).a(str2, z);
        }
        SharedPreferences a3 = b.a(context, a2);
        if (a3 == null) {
            return z;
        }
        return a3.getBoolean(str2, z);
    }

    public static long a(String str, String str2, long j) {
        if (!a()) {
            return j;
        }
        try {
            if (!b.c()) {
                return a(c(), str, str2, j);
            }
            g b = b();
            if (b != null) {
                String a2 = b.a(Uri.parse(d() + "long/" + str2 + b(str)));
                if (a2 != null) {
                    if (!a2.equals(AbstractJsonLexerKt.NULL)) {
                        return Long.parseLong(a2);
                    }
                }
            }
            return j;
        } catch (Throwable unused) {
        }
    }

    protected static long a(Context context, String str, String str2, long j) {
        String a2 = a(str, str2);
        if (h.e(a2)) {
            return com.bytedance.sdk.component.b.a(context, a2).a(str2, j);
        }
        SharedPreferences a3 = b.a(context, a2);
        if (a3 == null) {
            return j;
        }
        return a3.getLong(str2, j);
    }

    public static void b(String str, String str2) {
        if (a()) {
            try {
                if (!b.c()) {
                    b.b(c(), str, str2);
                    return;
                }
                g b = b();
                if (b != null) {
                    b.a(Uri.parse(d() + "long/" + str2 + b(str)), (String) null, (String[]) null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str) {
        if (a()) {
            try {
                if (!b.c()) {
                    b.b(c(), str);
                    return;
                }
                g b = b();
                if (b != null) {
                    b.a(Uri.parse(d() + "clean" + b(str)), (String) null, (String[]) null);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
