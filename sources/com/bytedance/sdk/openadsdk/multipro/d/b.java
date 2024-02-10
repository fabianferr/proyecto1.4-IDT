package com.bytedance.sdk.openadsdk.multipro.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.component.b;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.h;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: SPMultiHelperImpl */
class b {
    private static SoftReference<ConcurrentHashMap<String, Map<String, Object>>> a;

    public static SharedPreferences a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(a(str), 0);
        } catch (Throwable th) {
            l.d("SPMultiHelperImpl", "getSharedPreferences error ", th.getMessage());
            return null;
        }
    }

    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str;
    }

    private static Object a(String str, String str2) {
        ConcurrentHashMap concurrentHashMap;
        Map map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = a;
        if (softReference == null || (concurrentHashMap = softReference.get()) == null || (map = (Map) concurrentHashMap.get(a(str))) == null) {
            return null;
        }
        return map.get(str2);
    }

    private static void a(String str, String str2, Object obj) {
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = a;
        if (softReference == null || softReference.get() == null) {
            a = new SoftReference<>(new ConcurrentHashMap());
        }
        String a2 = a(str);
        ConcurrentHashMap concurrentHashMap = a.get();
        if (concurrentHashMap.get(a2) == null) {
            concurrentHashMap.put(a2, new HashMap());
        }
        ((Map) concurrentHashMap.get(a2)).put(str2, obj);
    }

    private static void b(String str) {
        Map map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = a;
        if (softReference != null && softReference.get() != null && (map = (Map) a.get().get(a(str))) != null) {
            map.clear();
        }
    }

    static synchronized <T> void a(Context context, String str, String str2, T t) {
        synchronized (b.class) {
            String a2 = a.a(str, str2);
            if (h.e(a2)) {
                com.bytedance.sdk.component.b a3 = com.bytedance.sdk.component.b.a(context, a2);
                if (!t.equals(a(a2, str2))) {
                    b.c b = a3.b();
                    a(b, str2, t);
                    b.apply();
                    return;
                }
                return;
            }
            SharedPreferences a4 = a(context, a2);
            if (a4 != null) {
                if (!t.equals(a(a2, str2))) {
                    SharedPreferences.Editor edit = a4.edit();
                    a(edit, str2, t);
                    edit.apply();
                    a(a2, str2, (Object) t);
                }
            }
        }
    }

    protected static <T> void a(SharedPreferences.Editor editor, String str, T t) {
        if (t instanceof Integer) {
            editor.putInt(str, ((Integer) t).intValue());
        }
        if (t instanceof Long) {
            editor.putLong(str, ((Long) t).longValue());
        }
        if (t instanceof Float) {
            editor.putFloat(str, ((Float) t).floatValue());
        }
        if (t instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) t).booleanValue());
        }
        if (t instanceof String) {
            editor.putString(str, (String) t);
        }
    }

    protected static <T> void a(b.c cVar, String str, T t) {
        if (t instanceof Integer) {
            cVar.putInt(str, ((Integer) t).intValue());
        }
        if (t instanceof Long) {
            cVar.putLong(str, ((Long) t).longValue());
        }
        if (t instanceof Float) {
            cVar.putFloat(str, ((Float) t).floatValue());
        }
        if (t instanceof Boolean) {
            cVar.putBoolean(str, ((Boolean) t).booleanValue());
        }
        if (t instanceof String) {
            cVar.putString(str, (String) t);
        }
    }

    static String a(Context context, String str, String str2, String str3) {
        Object a2 = a(str, str2);
        if (a2 != null) {
            return String.valueOf(a2);
        }
        Object b = b(context, str, str2, str3);
        a(str, str2, b);
        return String.valueOf(b);
    }

    private static Object b(Context context, String str, String str2, String str3) {
        String a2 = a(str);
        if (!a(context, a2, str2)) {
            return null;
        }
        if (str3.equalsIgnoreCase(TypedValues.Custom.S_STRING)) {
            return a.a(context, a2, str2, (String) null);
        }
        if (str3.equalsIgnoreCase(TypedValues.Custom.S_BOOLEAN)) {
            return Boolean.valueOf(a.a(context, a2, str2, false));
        }
        if (str3.equalsIgnoreCase("int")) {
            return Integer.valueOf(a.a(context, a2, str2, 0));
        }
        if (str3.equalsIgnoreCase("long")) {
            return Long.valueOf(a.a(context, a2, str2, 0));
        }
        if (str3.equalsIgnoreCase(TypedValues.Custom.S_FLOAT)) {
            return Float.valueOf(a.a(context, a2, str2, 0.0f));
        }
        if (str3.equalsIgnoreCase("string_set")) {
            return a.a(context, a2, str2, (String) null);
        }
        return null;
    }

    static boolean a(Context context, String str, String str2) {
        String a2 = a.a(str, str2);
        if (h.e(a2)) {
            return com.bytedance.sdk.component.b.a(context, a2).a(str2);
        }
        SharedPreferences a3 = a(context, a2);
        return a3 != null && a3.contains(str2);
    }

    public static void b(Context context, String str, String str2) {
        try {
            String a2 = a.a(str, str2);
            if (h.e(a2)) {
                com.bytedance.sdk.component.b.a(context, a2).b().remove(str2).apply();
                return;
            }
            SharedPreferences a3 = a(context, a2);
            if (a3 != null) {
                SharedPreferences.Editor edit = a3.edit();
                edit.remove(str2);
                edit.apply();
                SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = a;
                if (softReference != null && softReference.get() != null) {
                    Map map = (Map) a.get().get(a(a2));
                    if (map == null) {
                        return;
                    }
                    if (map.size() != 0) {
                        map.remove(str2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    static void b(Context context, String str) {
        if (h.e(str)) {
            com.bytedance.sdk.component.b.a(context, str).b().clear().apply();
            b(str);
            return;
        }
        SharedPreferences a2 = a(context, str);
        if (a2 != null) {
            SharedPreferences.Editor edit = a2.edit();
            edit.clear();
            edit.apply();
            b(str);
        }
    }

    static Map<String, ?> c(Context context, String str) {
        SharedPreferences a2 = a(context, str);
        if (a2 == null) {
            return null;
        }
        return a2.getAll();
    }
}
