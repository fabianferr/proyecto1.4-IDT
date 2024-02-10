package com.apm.insight;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.apm.insight.entity.b;
import com.apm.insight.k.k;
import com.apm.insight.l.l;
import com.apm.insight.l.v;
import com.apm.insight.runtime.d;
import com.facebook.AccessToken;
import com.facebook.share.internal.ShareConstants;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h {
    protected static MonitorCrash b;
    protected static volatile ConcurrentHashMap<String, h> c = new ConcurrentHashMap<>();
    protected MonitorCrash a;

    private h(MonitorCrash monitorCrash) {
        this.a = monitorCrash;
        b.a(this);
        com.apm.insight.j.b.d();
        k.e();
    }

    static h a(String str) {
        return c.get(str);
    }

    public static Object a() {
        return b;
    }

    static void a(Context context, final MonitorCrash monitorCrash) {
        b = monitorCrash;
        h hVar = new h(monitorCrash);
        final d a2 = i.a();
        Npth.init(context, new ICommonParams(hVar) {
            final /* synthetic */ h a;

            {
                this.a = r1;
            }

            public Map<String, Object> getCommonParams() {
                return l.b(this.a.e());
            }

            public String getDeviceId() {
                return TextUtils.isEmpty(monitorCrash.mConfig.mDeviceId) ? a2.d() : monitorCrash.mConfig.mDeviceId;
            }

            public List<String> getPatchInfo() {
                return null;
            }

            public Map<String, Integer> getPluginInfo() {
                return null;
            }

            public String getSessionId() {
                return null;
            }

            public long getUserId() {
                return 0;
            }
        });
    }

    static void a(MonitorCrash monitorCrash) {
        h hVar = new h(monitorCrash);
        if (monitorCrash != null && monitorCrash.mConfig != null) {
            c.put(monitorCrash.mConfig.mAid, hVar);
        }
    }

    private JSONObject b(CrashType crashType) {
        Map<? extends String, ? extends String> userData;
        if (this.a.mCustomData == null || (userData = this.a.mCustomData.getUserData(crashType)) == null) {
            return null;
        }
        return new JSONObject(userData);
    }

    private JSONObject c(CrashType crashType) {
        return new JSONObject(this.a.mTagMap);
    }

    /* access modifiers changed from: private */
    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.a.mConfig.mPackageName == null) {
                Context g = i.g();
                PackageInfo packageInfo = g.getPackageManager().getPackageInfo(g.getPackageName(), 128);
                if (packageInfo != null) {
                    if (this.a.mConfig.mVersionInt == -1) {
                        this.a.mConfig.mVersionInt = (long) packageInfo.versionCode;
                    }
                    if (this.a.mConfig.mVersionStr == null) {
                        this.a.mConfig.mVersionStr = packageInfo.versionName;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(this.a.mConfig.mDeviceId) || "0".equals(this.a.mConfig.mDeviceId)) {
            this.a.mConfig.mDeviceId = i.c().a();
        }
        try {
            jSONObject.put("aid", String.valueOf(this.a.mConfig.mAid));
            jSONObject.put("update_version_code", this.a.mConfig.mVersionInt);
            jSONObject.put("version_code", this.a.mConfig.mVersionInt);
            jSONObject.put("app_version", this.a.mConfig.mVersionStr);
            jSONObject.put("channel", this.a.mConfig.mChannel);
            jSONObject.put("package", l.a(this.a.mConfig.mPackageName));
            jSONObject.put("device_id", this.a.mConfig.mDeviceId);
            jSONObject.put(AccessToken.USER_ID_KEY, this.a.mConfig.mUID);
            jSONObject.put("ssid", this.a.mConfig.mSSID);
            jSONObject.put("os", "Android");
            jSONObject.put("so_list", l.a(this.a.mConfig.mSoList));
            jSONObject.put("thread_list", l.a(this.a.mConfig.mThreadList));
            jSONObject.put("single_upload", d() ? 1 : 0);
        } catch (JSONException unused2) {
        }
        return jSONObject;
    }

    public JSONArray a(StackTraceElement[] stackTraceElementArr, Throwable th) {
        return a(stackTraceElementArr, th, (String) null);
    }

    public JSONArray a(StackTraceElement[] stackTraceElementArr, Throwable th, String str) {
        if (this.a.mConfig.mPackageName == null) {
            return new JSONArray().put(new v.a(0, stackTraceElementArr.length).a());
        }
        if (th == null || stackTraceElementArr == null) {
            return null;
        }
        JSONArray a2 = v.a(stackTraceElementArr, this.a.mConfig.mPackageName);
        if (!(str == null || this.a.mConfig.mThreadList == null || !l.a(a2))) {
            for (String equals : this.a.mConfig.mThreadList) {
                if (TextUtils.equals(equals, str)) {
                    a2.put(new v.a(0, stackTraceElementArr.length).a());
                }
            }
        }
        return a2;
    }

    public JSONArray a(String[] strArr) {
        return this.a.config().mPackageName == null ? new JSONArray().put(new v.a(0, strArr.length).a()) : v.a(strArr, this.a.mConfig.mPackageName);
    }

    public JSONObject a(CrashType crashType) {
        return a(crashType, (JSONArray) null);
    }

    public JSONObject a(CrashType crashType, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("header", e());
            if (crashType != null) {
                jSONObject.put("custom", b(crashType));
                jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_FILTERS, c(crashType));
            }
            jSONObject.put("line_num", jSONArray);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public boolean a(Object obj) {
        return this.a == obj;
    }

    public boolean a(String str, String str2) {
        if (this.a.config().mPackageName == null) {
            return true;
        }
        return b.a(str, l.a(this.a.mConfig.mSoList), str2, l.a(this.a.mConfig.mThreadList));
    }

    public String b() {
        return this.a.mConfig.mAid;
    }

    public JSONObject c() {
        return e();
    }

    public boolean d() {
        return false;
    }
}
