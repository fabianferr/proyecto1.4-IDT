package com.bytedance.sdk.openadsdk.j;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.j.a.a;
import com.bytedance.sdk.openadsdk.j.a.c;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import java.io.File;
import org.json.JSONObject;

/* compiled from: StatsLogManager */
public class b {
    private static volatile b a;

    private boolean d(com.bytedance.sdk.openadsdk.j.a.b bVar) {
        return bVar == null;
    }

    private b() {
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public void a(final com.bytedance.sdk.openadsdk.j.a.b bVar) {
        if (!d(bVar)) {
            bVar.a("express_ad_render");
            o.e().a(new a() {
                public a getLogStats() throws Exception {
                    return bVar;
                }
            });
        }
    }

    public void b(final com.bytedance.sdk.openadsdk.j.a.b bVar) {
        if (!d(bVar)) {
            bVar.a("tpl_update_fail");
            o.e().a(new a() {
                public a getLogStats() throws Exception {
                    return bVar;
                }
            });
        }
    }

    public void c(final com.bytedance.sdk.openadsdk.j.a.b bVar) {
        if (!d(bVar)) {
            bVar.a("show_backup_endcard");
            o.e().a(new a() {
                public a getLogStats() throws Exception {
                    return bVar;
                }
            });
        }
    }

    public void a(final String str) {
        a("click_playable_test_tool", false, (a) new a() {
            public a getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("playable_url", str);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.j.a.b.b().a("click_playable_test_tool").b(jSONObject.toString());
            }
        });
    }

    public void b(final String str) {
        a("close_playable_test_tool", false, (a) new a() {
            public a getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("playable_url", str);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.j.a.b.b().a("close_playable_test_tool").b(jSONObject.toString());
            }
        });
    }

    public void a(final String str, final int i, final String str2) {
        a("use_playable_test_tool_error", false, (a) new a() {
            public a getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("playable_url", str);
                    jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, i);
                    jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str2);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.j.a.b.b().a("use_playable_test_tool_error").b(jSONObject.toString());
            }
        });
    }

    public void a(long j, long j2) {
        final long j3 = j2 - j;
        final long j4 = j;
        final long j5 = j2;
        a("general_label", false, (a) new a() {
            public a getLogStats() throws Exception {
                boolean z = !l.b.get();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("starttime", j4);
                    jSONObject.put("endtime", j5);
                    jSONObject.put("start_type", z ? 1 : 0);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.j.a.b.b().a("general_label").h(String.valueOf(j3)).b(jSONObject.toString());
            }
        });
    }

    public void a(final String str, final JSONObject jSONObject) {
        if (str != null && jSONObject != null) {
            a(str, false, (a) new a() {
                public a getLogStats() throws Exception {
                    return com.bytedance.sdk.openadsdk.j.a.b.b().a(str).b(jSONObject.toString());
                }
            });
        }
    }

    public void a(final String str, final String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            a(str, false, (a) new a() {
                public a getLogStats() throws Exception {
                    return com.bytedance.sdk.openadsdk.j.a.b.b().a(str).b(str2);
                }
            });
        }
    }

    public void b() {
        a("blind_mode_status", true, (a) new a() {
            public a getLogStats() throws Exception {
                return com.bytedance.sdk.openadsdk.j.a.b.b().a("blind_mode_status");
            }
        });
    }

    public void a(final JSONObject jSONObject) {
        if (jSONObject != null) {
            Object opt = jSONObject.opt("device_ad_mediation_platform");
            if ((opt instanceof String) && !TextUtils.isEmpty((String) opt)) {
                a("ad_revenue", true, (a) new a() {
                    public a getLogStats() throws Exception {
                        String str;
                        try {
                            jSONObject.put("event", 272);
                            jSONObject.put("uuid", j.c(o.a()));
                            str = "";
                            if (j.a(o.a()) != null) {
                                str = j.a(o.a());
                            }
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.l.b("StatsLogManager", th.getMessage());
                        }
                        jSONObject.put("device_id", str);
                        jSONObject.put("platform", "android");
                        jSONObject.put("partner", "PangleSDK");
                        return com.bytedance.sdk.openadsdk.j.a.b.b().a("ad_revenue").b(jSONObject.toString());
                    }
                });
            }
        }
    }

    public static void c() {
        a("disk_log", false, (a) new a() {
            public a getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                File file = new File(CacheDirFactory.getRootDir());
                long j = 0;
                if (file.exists() && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        long a = b.a(file2);
                        j += a;
                        jSONObject.put(file2.getName(), a);
                    }
                }
                if (j < 524288000) {
                    return null;
                }
                return com.bytedance.sdk.openadsdk.j.a.b.b().a("disk_log").b(jSONObject.toString());
            }
        });
    }

    public static long a(File file) {
        if (file.isFile()) {
            return file.length();
        }
        long j = 0;
        for (File a2 : file.listFiles()) {
            j += a(a2);
        }
        return j;
    }

    public static void b(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                final com.bytedance.sdk.openadsdk.j.a.b b = com.bytedance.sdk.openadsdk.j.a.b.b().a(str).b(str2);
                o.e().a(new a() {
                    public a getLogStats() throws Exception {
                        return b;
                    }
                }, false);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.l.e("StatsLogManager", th.getMessage());
        }
    }

    public static void a(String str, boolean z, a aVar) {
        int b = com.bytedance.sdk.openadsdk.core.settings.o.ai().b(str);
        boolean z2 = false;
        com.bytedance.sdk.component.utils.l.b("StatsLogManager", "type=", str, "  ", Integer.valueOf(b));
        if (!TextUtils.isEmpty(str) && b != 0 && aVar != null) {
            boolean z3 = b == 100;
            if (!z3) {
                if (((int) ((Math.random() * 100.0d) + 1.0d)) <= b) {
                    z2 = true;
                }
                z3 = z2;
            }
            if (z3) {
                o.e().a(aVar, z);
            }
        }
    }

    public static void a(long j, long j2, String str, int i) {
        if (j != 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            final long j3 = elapsedRealtime - j;
            final long j4 = elapsedRealtime - j2;
            final long j5 = j2 - j;
            final String str2 = str;
            final int i2 = i;
            a("ad_show_cost_time", false, (a) new a() {
                public a getLogStats() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", j3);
                    jSONObject.put("renderDuration", j4);
                    jSONObject.put("showToRenderDuration", j5);
                    jSONObject.put(ViewHierarchyConstants.TAG_KEY, str2);
                    jSONObject.put("renderType", i2);
                    return com.bytedance.sdk.openadsdk.j.a.b.b().a("ad_show_cost_time").b(jSONObject.toString());
                }
            });
        }
    }

    public static void a(final c cVar) {
        a("request_monitor", false, (a) new a() {
            public a getLogStats() throws Exception {
                return com.bytedance.sdk.openadsdk.j.a.b.b().a("request_monitor").b(cVar.toString());
            }
        });
    }

    public void a(final long j, final String str) {
        a("ivrv_activity_finish", false, (a) new a() {
            public a getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", j);
                jSONObject.put("activity_name", str);
                return com.bytedance.sdk.openadsdk.j.a.b.b().a("ivrv_activity_finish").b(jSONObject.toString());
            }
        });
    }
}
