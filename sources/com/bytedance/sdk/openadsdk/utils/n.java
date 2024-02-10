package com.bytedance.sdk.openadsdk.utils;

import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.j.b;
import org.json.JSONObject;

/* compiled from: MemoryUtils */
public class n {
    public static final long a = a(0.05f);

    public static long a(float f) {
        return Double.valueOf((double) (f * ((float) Runtime.getRuntime().maxMemory()))).longValue();
    }

    public static boolean a(long j, String str) {
        if (!o.d().l() || Runtime.getRuntime().maxMemory() - (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) >= j) {
            return true;
        }
        b(j, str);
        return false;
    }

    private static void b(final long j, final String str) {
        aa.b(new h("isMemoryEnough") {
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("scene", str);
                    jSONObject.put("mem_size", j);
                    b.a().a("dynamic_mem_not_enough", jSONObject);
                    l.b("MemoryUtils", "dynamic_mem_not_enough", jSONObject);
                } catch (Exception e) {
                    l.c("MemoryUtils", "run: ", e);
                }
            }
        }, 5);
    }

    public static int a() {
        try {
            int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 33554432);
            if (maxMemory <= 2) {
                return 2;
            }
            if (maxMemory >= 5) {
                return 5;
            }
            return maxMemory;
        } catch (Throwable unused) {
            return 2;
        }
    }
}
