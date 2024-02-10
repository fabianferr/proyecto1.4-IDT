package com.bytedance.sdk.openadsdk.b.a;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.JProtect;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.b.a;
import com.bytedance.sdk.openadsdk.b.f;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.settings.e;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.u;
import com.facebook.internal.NativeProtocol;
import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdLogParamsGenerate */
public class c {
    private long a;
    private int b;
    private final Context c = o.a();
    private final boolean d = b();
    private final String e = d();

    private String a(int i) {
        return i != 120 ? i != 160 ? i != 240 ? i != 320 ? i != 480 ? i != 640 ? "mdpi" : "xxxhdpi" : "xxhdpi" : "xhdpi" : "hdpi" : "mdpi" : "ldpi";
    }

    private String a(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Throwable unused) {
            return "";
        }
    }

    private void a(a aVar, boolean z) {
        JSONObject c2;
        if (aVar != null) {
            if (z) {
                try {
                    c2 = aVar.c().optJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
                } catch (Exception e2) {
                    l.d("AdLogParamsGenerate", "getInfoFromLogExtra exception", e2.getMessage());
                    return;
                }
            } else {
                c2 = aVar.c();
            }
            String optString = c2.optString("log_extra", "");
            long a2 = q.a(optString);
            int d2 = q.d(optString);
            if (a2 == 0) {
                a2 = this.a;
            }
            this.a = a2;
            if (d2 == 0) {
                d2 = this.b;
            }
            this.b = d2;
        }
    }

    private boolean b() {
        try {
            return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        } catch (Exception unused) {
            return false;
        }
    }

    private int c() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    private String d() {
        return DeviceUtils.b(this.c) ? "tv" : DeviceUtils.a(this.c) ? "android_pad" : "android";
    }

    @JProtect
    private String e() {
        String str;
        StringBuilder sb = new StringBuilder();
        try {
            if (t.e()) {
                str = "MIUI-";
            } else if (t.b()) {
                str = "FLYME-";
            } else {
                String n = t.n();
                if (t.a(n)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(n)) {
                    sb.append(n);
                    str = "-";
                }
                sb.append(Build.VERSION.INCREMENTAL);
                return sb.toString();
            }
            sb.append(str);
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public String a(List<a> list) {
        return ac.e((list.size() <= 0 || list.get(0) == null || list.get(0).c() == null) ? "" : list.get(0).c().optString("app_log_url"));
    }

    public List<a> a(List<a> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (a next : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject c2 = next.c();
                jSONObject.putOpt("event", c2.optString("label"));
                long optLong = c2.optLong("event_ts", System.currentTimeMillis());
                jSONObject.putOpt("local_time_ms", Long.valueOf(optLong));
                jSONObject.putOpt("datetime", f.c.format(new Date(optLong)));
                JSONObject jSONObject2 = new JSONObject();
                Iterator<String> keys = c2.keys();
                while (keys.hasNext()) {
                    String next2 = keys.next();
                    if (!TextUtils.equals(next2, "label")) {
                        jSONObject2.putOpt(next2, c2.opt(next2));
                    }
                }
                if (z) {
                    jSONObject2.putOpt("_ad_staging_flag", 3);
                }
                jSONObject.putOpt(NativeProtocol.WEB_DIALOG_PARAMS, jSONObject2);
                arrayList.add(new f(next.a, jSONObject));
            } catch (Exception e2) {
                l.e("AdLogParamsGenerate", e2.getMessage());
            }
        }
        return arrayList;
    }

    @JProtect
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ua", ac.c());
            jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put("app_version", ac.g());
            jSONObject.put("sim_op", a(this.c));
            int i = 1;
            jSONObject.put("root", this.d ? 1 : 0);
            jSONObject.put("timezone", c());
            jSONObject.put("access", com.bytedance.sdk.openadsdk.utils.q.a(this.c));
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("device_type", this.e);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("resolution", ad.d(this.c) + "x" + ad.c(this.c));
            jSONObject.put("display_density", a(ad.g(this.c)));
            jSONObject.put("density_dpi", ad.g(this.c));
            jSONObject.put("aid", "1371");
            jSONObject.put("device_id", j.a(this.c));
            jSONObject.put("rom", e());
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("ut", this.b);
            jSONObject.put("uid", this.a);
            jSONObject.put("google_aid", com.com.bytedance.overseas.sdk.b.a.a().b());
            jSONObject.put("locale_language", DeviceUtils.c());
            jSONObject.put("screen_bright", Math.ceil((double) (DeviceUtils.d() * 10.0f)) / 10.0d);
            if (DeviceUtils.a()) {
                i = 0;
            }
            jSONObject.put("is_screen_off", i);
            e d2 = o.d();
            jSONObject.put("force_language", s.a(this.c, "tt_choose_language"));
            if (d2.A(ThroughputConfigUtil.SHARED_PREFS_KEY_MNC)) {
                jSONObject.put(ThroughputConfigUtil.SHARED_PREFS_KEY_MNC, u.c());
            }
            if (d2.A(ThroughputConfigUtil.SHARED_PREFS_KEY_MCC)) {
                jSONObject.put(ThroughputConfigUtil.SHARED_PREFS_KEY_MCC, u.b());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public JSONObject a(List<a> list, long j, JSONObject jSONObject, boolean z) {
        String str;
        Object obj;
        JSONObject jSONObject2 = new JSONObject();
        try {
            a(list.get(0), z);
            jSONObject2.put("header", jSONObject);
            JSONArray jSONArray = new JSONArray();
            for (a a2 : list) {
                jSONArray.put(a2.a(z));
            }
            if (z) {
                jSONObject2.put("event_v3", jSONArray);
                str = "magic_tag";
                obj = "ss_app_log";
            } else {
                str = "event";
                obj = jSONArray;
            }
            jSONObject2.put(str, obj);
            jSONObject2.put("_gen_time", j);
            jSONObject2.put("local_time", j / 1000);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public List<a> b(List<a> list) {
        ArrayList arrayList = new ArrayList();
        for (a next : list) {
            try {
                JSONObject c2 = next.c();
                c2.putOpt("_ad_staging_flag", 1);
                arrayList.add(new a(next.a, c2));
            } catch (Exception e2) {
                l.e("AdLogParamsGenerate", e2.getMessage());
            }
        }
        return arrayList;
    }
}
