package com.bytedance.sdk.openadsdk.core.settings;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.openvk.component.video.api.f.b;
import com.bytedance.sdk.component.f.b.d;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.e;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.j.a.c;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.u;
import com.google.android.gms.cast.MediaTrack;
import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: SettingsFetchTask */
public class m extends h {
    /* access modifiers changed from: private */
    public final a a;
    private final l b;
    private final d c;

    /* compiled from: SettingsFetchTask */
    public interface a {
        void a(boolean z);
    }

    public m(a aVar, l lVar, d dVar) {
        super("SetF");
        this.a = aVar;
        this.b = lVar;
        this.c = dVar;
    }

    public void run() {
        Log.d("TTAD.SdkSettingsFetch", "Start Try");
        int a2 = v.a(o.a(), 0);
        if (a2 == 0) {
            Log.d("TTAD.SdkSettingsFetch", "No net");
            this.a.a(false);
            return;
        }
        final c cVar = new c();
        JSONObject a3 = a(a2);
        d b2 = com.bytedance.sdk.openadsdk.k.c.a().b().b();
        try {
            String a4 = com.bytedance.sdk.openadsdk.e.d.a(b2, ac.d("/api/ad/union/mediation/settings/"));
            b2.a(a4);
            b2.b("User-Agent", ac.c());
            cVar.a(a4);
        } catch (Exception unused) {
        }
        String jSONObject = b(a3).toString();
        if (o.d().U() && com.bytedance.sdk.openadsdk.core.v.a().g() == 1) {
            ac.a("Pangle_Debug_Mode", jSONObject, o.a());
        }
        b2.a(jSONObject, o.d().q());
        cVar.a(b2.c()).a();
        b2.a((com.bytedance.sdk.component.f.a.a) new com.bytedance.sdk.component.f.a.a() {
            /* JADX WARNING: Can't wrap try/catch for region: R(8:17|(2:19|(3:21|22|23))|24|25|26|27|28|30) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0072 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x007b */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void a(com.bytedance.sdk.component.f.b.c r7, com.bytedance.sdk.component.f.b r8) {
                /*
                    r6 = this;
                    int r7 = r8.a()
                    java.lang.String r0 = r8.d()
                    com.bytedance.sdk.openadsdk.core.settings.e r1 = com.bytedance.sdk.openadsdk.core.o.d()
                    boolean r1 = r1.U()
                    r2 = 1
                    if (r1 == 0) goto L_0x0026
                    com.bytedance.sdk.openadsdk.core.u r1 = com.bytedance.sdk.openadsdk.core.v.a()
                    int r1 = r1.g()
                    if (r1 != r2) goto L_0x0026
                    java.lang.String r1 = "Pangle_Debug_Mode"
                    android.content.Context r3 = com.bytedance.sdk.openadsdk.core.o.a()
                    com.bytedance.sdk.openadsdk.utils.ac.a((java.lang.String) r1, (java.lang.String) r0, (android.content.Context) r3)
                L_0x0026:
                    boolean r1 = r8.f()
                    if (r1 == 0) goto L_0x0098
                    boolean r1 = android.text.TextUtils.isEmpty(r0)
                    if (r1 != 0) goto L_0x0098
                    com.bytedance.sdk.openadsdk.j.a.c r1 = r1
                    com.bytedance.sdk.openadsdk.j.a.c r1 = r1.c(r0)
                    com.bytedance.sdk.openadsdk.j.a.c r1 = r1.a((int) r7)
                    com.bytedance.sdk.openadsdk.j.a.c r1 = r1.a((boolean) r2)
                    r1.c()
                    r1 = 0
                    org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x004a }
                    r3.<init>(r0)     // Catch:{ JSONException -> 0x004a }
                    goto L_0x004c
                L_0x004a:
                    r3 = r1
                L_0x004c:
                    if (r3 != 0) goto L_0x004f
                    goto L_0x0098
                L_0x004f:
                    java.lang.String r4 = "cypher"
                    r5 = -1
                    int r4 = r3.optInt(r4, r5)
                    if (r4 != r5) goto L_0x0059
                    goto L_0x0098
                L_0x0059:
                    r7 = 3
                    if (r4 != r7) goto L_0x0072
                    java.lang.String r7 = "message"
                    java.lang.String r7 = r3.optString(r7)
                    java.lang.String r1 = com.bytedance.sdk.component.utils.a.c(r7)
                    boolean r7 = android.text.TextUtils.isEmpty(r1)
                    if (r7 != 0) goto L_0x0072
                    org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ all -> 0x0072 }
                    r7.<init>(r1)     // Catch:{ all -> 0x0072 }
                    r3 = r7
                L_0x0072:
                    java.util.Map r7 = r8.c()     // Catch:{ all -> 0x007b }
                    com.bytedance.sdk.openadsdk.core.settings.m r8 = com.bytedance.sdk.openadsdk.core.settings.m.this     // Catch:{ all -> 0x007b }
                    r8.a(r1, r7)     // Catch:{ all -> 0x007b }
                L_0x007b:
                    com.bytedance.sdk.openadsdk.core.settings.m r7 = com.bytedance.sdk.openadsdk.core.settings.m.this     // Catch:{ all -> 0x008b }
                    r7.a((org.json.JSONObject) r3)     // Catch:{ all -> 0x008b }
                    com.bytedance.sdk.openadsdk.core.settings.e r7 = com.bytedance.sdk.openadsdk.core.o.d()     // Catch:{ all -> 0x008b }
                    long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x008b }
                    r7.a((long) r0)     // Catch:{ all -> 0x008b }
                L_0x008b:
                    com.bytedance.sdk.openadsdk.core.settings.m r7 = com.bytedance.sdk.openadsdk.core.settings.m.this
                    com.bytedance.sdk.openadsdk.core.settings.m$a r7 = r7.a
                    r7.a(r2)
                    com.bytedance.sdk.openadsdk.core.f.a.a()
                    return
                L_0x0098:
                    com.bytedance.sdk.openadsdk.j.a.c r1 = r1
                    com.bytedance.sdk.openadsdk.j.a.c r0 = r1.c(r0)
                    com.bytedance.sdk.openadsdk.j.a.c r7 = r0.a((int) r7)
                    java.lang.String r0 = r8.b()
                    com.bytedance.sdk.openadsdk.j.a.c r7 = r7.d(r0)
                    boolean r8 = r8.f()
                    com.bytedance.sdk.openadsdk.j.a.c r7 = r7.a((boolean) r8)
                    r7.c()
                    com.bytedance.sdk.openadsdk.core.settings.m r7 = com.bytedance.sdk.openadsdk.core.settings.m.this
                    com.bytedance.sdk.openadsdk.core.settings.m$a r7 = r7.a
                    r8 = 0
                    r7.a(r8)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.settings.m.AnonymousClass1.a(com.bytedance.sdk.component.f.b.c, com.bytedance.sdk.component.f.b):void");
            }

            public void a(com.bytedance.sdk.component.f.b.c cVar, IOException iOException) {
                cVar.d(iOException != null ? iOException.getMessage() : null).a(false).c();
                m.this.a.a(false);
                com.bytedance.sdk.openadsdk.core.f.a.a();
            }
        });
        DeviceUtils.j();
    }

    /* access modifiers changed from: private */
    public void a(String str, Map<String, String> map) {
        int i = 1;
        try {
            if (!TextUtils.isEmpty(str) && map != null) {
                HashMap hashMap = new HashMap();
                for (Map.Entry next : map.entrySet()) {
                    String str2 = (String) next.getKey();
                    if (str2 != null) {
                        hashMap.put(str2.toLowerCase(Locale.US), next.getValue());
                    }
                }
                int parseInt = Integer.parseInt((String) hashMap.get("active-control"));
                long parseLong = Long.parseLong((String) hashMap.get("ts"));
                String str3 = (String) hashMap.get("pst");
                String a2 = b.a(str + parseInt + parseLong);
                if (a2 != null && a2.equalsIgnoreCase(str3)) {
                    i = parseInt;
                }
            }
        } catch (Throwable unused) {
        }
        k.a(i);
    }

    private JSONObject a(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            e d = o.d();
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("device_city", ac.o());
            if (d.A("gaid")) {
                jSONObject.put("gaid", com.com.bytedance.overseas.sdk.b.a.a().b());
            }
            jSONObject.put("gdpr", com.bytedance.sdk.openadsdk.core.h.b().h());
            jSONObject.put("coppa", com.bytedance.sdk.openadsdk.core.h.b().g());
            jSONObject.put("ccpa", com.bytedance.sdk.openadsdk.core.h.b().t());
            if (d.A(ThroughputConfigUtil.SHARED_PREFS_KEY_MCC)) {
                jSONObject.put(ThroughputConfigUtil.SHARED_PREFS_KEY_MCC, u.b());
            }
            Context a2 = o.a();
            jSONObject.put("conn_type", ac.g(i));
            int i2 = 1;
            jSONObject.put("os", 1);
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put("language", j.a());
            jSONObject.put("time_zone", ac.r());
            jSONObject.put(CampaignEx.JSON_KEY_PACKAGE_NAME, ac.e());
            if (!ac.a()) {
                i2 = 2;
            }
            jSONObject.put("position", i2);
            jSONObject.put("app_version", ac.g());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("uuid", j.c(a2));
            String d2 = com.bytedance.sdk.openadsdk.core.h.b().d();
            if (d2 != null) {
                jSONObject.put("app_id", d2);
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", currentTimeMillis);
            String str = "";
            if (d2 != null) {
                str = d2.concat(String.valueOf(currentTimeMillis)).concat(BuildConfig.VERSION_NAME);
            }
            jSONObject.put("req_sign", e.a(str));
            jSONObject.put("tcstring", o.c(a2));
            jSONObject.put("tcf_gdpr", o.b(a2));
            jSONObject.put("lmt", DeviceUtils.b());
            jSONObject.put("locale_language", DeviceUtils.c());
            jSONObject.put("channel", MediaTrack.ROLE_MAIN);
            JSONObject e = d.e();
            if (e != null) {
                jSONObject.put("digest", e);
            }
            jSONObject.put("data_time", d.f());
            jSONObject.put("app_set_id_scope", c.b());
            jSONObject.put("app_set_id", c.c());
            jSONObject.put("installed_source", c.d());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject b(JSONObject jSONObject) {
        return com.bytedance.sdk.component.utils.a.a(jSONObject);
    }

    public boolean a(JSONObject jSONObject) {
        this.b.a(jSONObject);
        this.c.a(jSONObject);
        return this.b.c;
    }

    public static boolean a() {
        return BinderPoolService.a;
    }
}
