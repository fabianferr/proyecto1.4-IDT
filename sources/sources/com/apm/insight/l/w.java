package com.apm.insight.l;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.apm.insight.i;
import java.io.File;
import org.json.JSONObject;

public class w {
    public static long a(File file) {
        try {
            return new StatFs(file.getPath()).getTotalBytes();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("inner_free", b());
            jSONObject.put("inner_total", c());
            jSONObject.put("sdcard_free", f());
            jSONObject.put("sdcard_total", g());
            jSONObject.put("inner_free_real", d());
            jSONObject.put("inner_total_real", e());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static boolean a() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    private static long b() {
        try {
            return b(Environment.getRootDirectory());
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static long b(File file) {
        try {
            return new StatFs(file.getPath()).getFreeBytes();
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static long c() {
        try {
            return a(Environment.getRootDirectory());
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static long d() {
        try {
            return b(i.g().getFilesDir());
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static long e() {
        try {
            return a(i.g().getFilesDir());
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static long f() {
        try {
            if (a()) {
                return Environment.getExternalStorageDirectory().getFreeSpace();
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static long g() {
        try {
            if (a()) {
                return Environment.getExternalStorageDirectory().getTotalSpace();
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }
}
