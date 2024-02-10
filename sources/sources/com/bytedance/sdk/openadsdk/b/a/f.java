package com.bytedance.sdk.openadsdk.b.a;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.j.b;
import com.bytedance.sdk.openadsdk.multipro.d.a;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: GetAdEventMonitor */
public class f {
    public static AtomicInteger a = new AtomicInteger(0);
    public static AtomicInteger b = new AtomicInteger(0);
    public static AtomicInteger c = new AtomicInteger(0);
    public static AtomicInteger d = new AtomicInteger(0);
    public static AtomicInteger e = new AtomicInteger(0);
    public static AtomicInteger f = new AtomicInteger(0);
    public static AtomicInteger g = new AtomicInteger(0);
    public static AtomicInteger h = new AtomicInteger(0);

    public static void a() {
        try {
            long a2 = a.a("tt_sdk_event_get_ad", "get_ad_event_time_key", 0);
            if (a2 <= 0 || System.currentTimeMillis() - a2 < 86400000) {
                if (a2 <= 0 || a2 > System.currentTimeMillis()) {
                    a.a("tt_sdk_event_get_ad", "get_ad_event_time_key", Long.valueOf(System.currentTimeMillis()));
                }
                JSONObject jSONObject = new JSONObject(a.b("tt_sdk_event_get_ad", "get_ad_event_key", ""));
                a.addAndGet(jSONObject.optInt("load_times"));
                b.addAndGet(jSONObject.optInt("load_success"));
                c.addAndGet(jSONObject.optInt("load_fail"));
                d.addAndGet(jSONObject.optInt("load_success_and_parse_success"));
                e.addAndGet(jSONObject.optInt("load_success_and_parse_fail"));
                f.addAndGet(jSONObject.optInt("load_success_and_no_ad"));
                g.addAndGet(jSONObject.optInt("load_fail_by_no_net"));
                h.addAndGet(jSONObject.optInt("load_fail_by_io"));
                return;
            }
            b();
            a.a("tt_sdk_event_get_ad", "get_ad_event_time_key", Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable unused) {
        }
    }

    public static void b() {
        try {
            b.a().a("pangle_sdk_get_ad_track", a.b("tt_sdk_event_get_ad", "get_ad_event_key", ""));
            a.a("tt_sdk_event_get_ad");
        } catch (Throwable unused) {
        }
    }

    public static void c() {
        try {
            a.a("tt_sdk_event_get_ad", "get_ad_event_key", d().toString());
        } catch (Throwable unused) {
        }
    }

    public static JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("load_times", a.get());
            jSONObject.put("load_success", b.get());
            jSONObject.put("load_fail", c.get());
            jSONObject.put("load_success_and_parse_success", d.get());
            jSONObject.put("load_success_and_parse_fail", e.get());
            jSONObject.put("load_success_and_no_ad", f.get());
            jSONObject.put("load_fail_by_no_net", g.get());
            jSONObject.put("load_fail_by_io", h.get());
            return jSONObject;
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static void a(int i, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
            b.a().a("pangle_sdk_client_load_error", jSONObject);
        } catch (Throwable unused) {
        }
    }
}
