package com.ironsource.mediationsdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.StringUtils;
import com.ironsource.environment.c;
import com.ironsource.environment.h;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.services.MediationServices;
import com.ironsource.mediationsdk.services.a;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class V {
    private static V b;
    public JSONObject a = new JSONObject();
    private final a c = MediationServices.getProvider().getSessionDepthService();

    private V() {
    }

    public static synchronized V a() {
        V v;
        synchronized (V.class) {
            if (b == null) {
                b = new V();
            }
            v = b;
        }
        return v;
    }

    private synchronized void a(String str, Object obj) {
        try {
            this.a.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        if (applicationContext != null) {
            try {
                String language = applicationContext.getResources().getConfiguration().locale.getLanguage();
                if (!TextUtils.isEmpty(language)) {
                    jSONObject.put("dLang", StringUtils.toUpperCase(language));
                }
                String pluginType = ConfigFile.getConfigFile().getPluginType();
                if (!TextUtils.isEmpty(pluginType)) {
                    jSONObject.put("plType", pluginType);
                }
                String e = h.e();
                if (e != null) {
                    jSONObject.put("dOSVF", e);
                    jSONObject.put("dOSV", e.replaceAll("[^0-9/.]", ""));
                }
                String y = h.y(applicationContext);
                if (y != null) {
                    jSONObject.put(JsonStorageKeyNames.AUID_ID_KEY, y);
                }
                jSONObject.put("sId", IronSourceUtils.getSessionId());
                jSONObject.put("appKey", z.a().g);
                jSONObject.put("mCar", h.i(applicationContext));
                jSONObject.put("medV", IronSourceUtils.getSDKVersion());
                jSONObject.put("dModel", Build.MODEL);
                jSONObject.put("dOS", "android");
                jSONObject.put("dMake", Build.MANUFACTURER);
                jSONObject.put("dAPI", String.valueOf(Build.VERSION.SDK_INT));
                jSONObject.put("bId", applicationContext.getPackageName());
                jSONObject.put("appV", c.c(applicationContext, applicationContext.getPackageName()));
                String str = z.a().h;
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("usId", str);
                }
            } catch (JSONException e2) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("got the following error " + e2.getMessage());
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static JSONObject d() {
        String str;
        JSONObject jSONObject = new JSONObject();
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        if (applicationContext != null) {
            try {
                String C = h.C(applicationContext);
                String D = h.D(applicationContext);
                if (!TextUtils.isEmpty(C)) {
                    str = IronSourceConstants.TYPE_GAID;
                } else {
                    C = h.x(applicationContext);
                    str = !TextUtils.isEmpty(C) ? IronSourceConstants.TYPE_UUID : "";
                }
                if (!TextUtils.isEmpty(C)) {
                    jSONObject.put("advId", C);
                    jSONObject.put("advType", str);
                }
                if (!TextUtils.isEmpty(D)) {
                    jSONObject.put("isLAT", Boolean.parseBoolean(D));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public void a(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            a(next, jSONObject.opt(next));
        }
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        int k = h.k();
        int l = h.l();
        float o = h.o();
        if (applicationContext != null) {
            try {
                ConcurrentHashMap<String, List<String>> concurrentHashMap = C0213c.a().d;
                concurrentHashMap.putAll(com.ironsource.mediationsdk.d.c.a().c());
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry next : concurrentHashMap.entrySet()) {
                    jSONObject2.put((String) next.getKey(), next.getValue());
                }
                Boolean bool = z.a().w;
                if (bool != null) {
                    jSONObject.put("consent", bool.booleanValue());
                }
                String B = h.B(applicationContext);
                if (!TextUtils.isEmpty(B)) {
                    jSONObject.put("asid", B);
                }
                jSONObject.put("connT", IronSourceUtils.getConnectionType(applicationContext));
                jSONObject.put("dVol", (double) h.l(applicationContext));
                jSONObject.put("root", h.j());
                jSONObject.put("bat", h.v(applicationContext));
                jSONObject.put("diskFS", h.p());
                jSONObject.put("MD", jSONObject2);
                jSONObject.put("cTime", new Date().getTime());
                jSONObject.put("dWidth", k);
                jSONObject.put("dHeight", l);
                jSONObject.put("dScrenScle", String.valueOf(o));
                jSONObject.put("sDepIS", this.c.a(IronSource.AD_UNIT.INTERSTITIAL));
                jSONObject.put("sDepRV", this.c.a(IronSource.AD_UNIT.REWARDED_VIDEO));
                jSONObject.put("UA", h.q());
            } catch (JSONException e) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("got the following error " + e.getMessage());
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
