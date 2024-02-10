package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.apm.insight.AttachUserData;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.MonitorCrash;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.b.g;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.settings.e;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApmHelper {
    /* access modifiers changed from: private */
    public static boolean a = false;
    /* access modifiers changed from: private */
    public static String b = null;
    /* access modifiers changed from: private */
    public static boolean c = false;
    /* access modifiers changed from: private */
    public static boolean d = false;
    /* access modifiers changed from: private */
    public static b e;
    /* access modifiers changed from: private */
    public static a f;

    private interface b {
        void a(String str, String str2, Throwable th);
    }

    public static void initApm(final Context context, final InitConfig initConfig) {
        aa.b(new h("init-apm") {
            public void run() {
                if (!ApmHelper.a) {
                    e d = o.d();
                    boolean unused = ApmHelper.c = d.R();
                    if (ApmHelper.c && !TextUtils.isEmpty(d.I())) {
                        String unused2 = ApmHelper.b = initConfig.getAppId();
                        String[] strArr = {"com.bytedance.sdk.component", "com.bytedance.sdk.mediation", BuildConfig.LIBRARY_PACKAGE_NAME, "com.com.bytedance.overseas.sdk", "com.pgl.ssdk.ces", "com.bykv.vk"};
                        String a2 = j.a(context);
                        String I = d.I();
                        try {
                            final MonitorCrash initSDK = MonitorCrash.initSDK(context, "10000001", 5509, BuildConfig.VERSION_NAME, strArr);
                            initSDK.setCustomDataCallback(new AttachUserData() {
                                public Map<? extends String, ? extends String> getUserData(CrashType crashType) {
                                    Map<? extends String, ? extends String> c = ApmHelper.i();
                                    if (c.containsKey("render_type")) {
                                        initSDK.addTags("render_type", (String) c.get("render_type"));
                                    } else {
                                        initSDK.addTags("render_type", "-2");
                                    }
                                    return c;
                                }
                            });
                            if (d.ag()) {
                                initSDK.config().setSoList(new String[]{"libnms.so", "libtobEmbedPagEncrypt.so"});
                            }
                            initSDK.config().setDeviceId(a2);
                            initSDK.setReportUrl(I);
                            initSDK.addTags("host_appid", ApmHelper.b);
                            initSDK.addTags("sdk_version", BuildConfig.VERSION_NAME);
                            initSDK.config().setChannel(ApmHelper.j());
                            b unused3 = ApmHelper.e = new b() {
                                public void a(String str, String str2, Throwable th) {
                                    initSDK.reportCustomErr(str, str2, th);
                                }
                            };
                            boolean unused4 = ApmHelper.a = true;
                            ApmHelper.c(a2, I);
                            initSDK.registerCrashCallback(new ICrashCallback() {
                                public void onCrash(CrashType crashType, String str, Thread thread) {
                                    if (!ApmHelper.d) {
                                        ApmHelper.d(crashType.getName());
                                    }
                                    boolean unused = ApmHelper.d = true;
                                }
                            }, CrashType.ALL);
                            a g = ApmHelper.f;
                            a unused5 = ApmHelper.f = null;
                            if (g != null) {
                                ApmHelper.e.a(g.a, g.b, g.c);
                            }
                        } catch (Throwable unused6) {
                            l.d("ApmHelper", "init Apm fail or not include Apm module");
                            boolean unused7 = ApmHelper.a = false;
                        }
                    }
                }
            }
        });
    }

    public static void reportCustomError(String str, String str2, Throwable th) {
        b bVar = e;
        if (bVar != null) {
            bVar.a(str, str2, th);
        } else {
            f = new a(str, str2, th);
        }
    }

    private static class a {
        public final String a;
        public final String b;
        public final Throwable c;

        public a(String str, String str2, Throwable th) {
            this.a = str;
            this.b = str2;
            this.c = th;
        }
    }

    /* access modifiers changed from: private */
    public static Map<String, String> i() {
        HashMap hashMap = new HashMap();
        q a2 = com.bytedance.sdk.openadsdk.utils.b.a();
        if (a2 != null) {
            hashMap.put("adType", String.valueOf(a2.aT()));
            hashMap.put("aid", String.valueOf(a2.aU()));
            hashMap.put(CmcdConfiguration.KEY_CONTENT_ID, a2.Y());
            hashMap.put("reqId", a2.bc());
            hashMap.put("rit", a2.x("-1"));
            int x = a2.x();
            if (a2.u() != 2) {
                x = -1;
            }
            hashMap.put("render_type", String.valueOf(x));
        }
        return hashMap;
    }

    private static void b(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            o.c().a(c(str), "https://" + str2 + "/monitor/collect/c/session?version_code=5509&device_platform=android&aid=10000001");
        }
    }

    /* access modifiers changed from: private */
    public static void c(String str, String str2) {
        b(str, str2);
    }

    public static void reportPvFromBackGround() {
        if (c) {
            b(j.a(o.a()), o.d().I());
        }
    }

    private static JSONObject c(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("sdk_version", BuildConfig.VERSION_NAME);
            jSONObject3.put("host_app_id", b);
            jSONObject2.putOpt("custom", jSONObject3);
            jSONObject2.put("os", "Android");
            jSONObject2.put("os_version", Build.VERSION.RELEASE);
            jSONObject2.put("device_model", Build.MODEL);
            jSONObject2.put("device_brand", Build.BRAND);
            jSONObject2.put("sdk_version_name", "0.0.5");
            jSONObject2.put("channel", j());
            jSONObject2.put("aid", "10000001");
            jSONObject2.put("update_version_code", BuildConfig.VERSION_CODE);
            jSONObject2.put("bd_did", str);
            jSONObject.putOpt("header", jSONObject2);
            jSONObject.putOpt("local_time", Long.valueOf(System.currentTimeMillis()));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("local_time_ms", System.currentTimeMillis()));
            jSONObject.putOpt("launch", jSONArray);
        } catch (JSONException e2) {
            l.e("ApmHelper", e2.getMessage());
        }
        return jSONObject;
    }

    public static boolean isIsInit() {
        return a;
    }

    /* access modifiers changed from: private */
    public static void d(final String str) {
        final q a2 = com.bytedance.sdk.openadsdk.utils.b.a();
        if (a2 != null) {
            String a3 = ac.a(a2);
            if (!TextUtils.isEmpty(a3)) {
                c.a(System.currentTimeMillis(), a2, a3, "sdk_crash_info", new JSONObject(), (g) null, (com.bytedance.sdk.openadsdk.b.b.a) new com.bytedance.sdk.openadsdk.b.b.a() {
                    public void a(JSONObject jSONObject) throws JSONException {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("type", str);
                        jSONObject2.put("material", com.bytedance.sdk.component.utils.a.a(a2.ao()).toString());
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public static String j() {
        e d2 = o.d();
        if (d2 != null) {
            return d2.l() ? "support_mem_dynamic_1" : "support_mem_dynamic_0";
        }
        return "release";
    }
}
