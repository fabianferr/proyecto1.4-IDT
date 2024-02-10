package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.d.c;
import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.d.e;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class h {
    private static final int[] a = {7, 4, 2, 1, 11};
    private static final int[] b = {5, 6, 12, 10, 3, 9, 8, 14};
    private static final int[] c = {15, 13};
    private static final int[] d = {20};

    public static String a(InputStream inputStream, m mVar) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[((Integer) mVar.a(b.cX)).intValue()];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return byteArrayOutputStream.toString("UTF-8");
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static String a(String str, m mVar) {
        return a((String) mVar.a(b.aV), str, mVar);
    }

    public static String a(String str, String str2, m mVar) {
        if (str == null || str.length() < 4) {
            throw new IllegalArgumentException("Invalid domain specified");
        } else if (str2 == null) {
            throw new IllegalArgumentException("No endpoint specified");
        } else if (mVar != null) {
            return str + str2;
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    public static JSONObject a(JSONObject jSONObject) throws JSONException {
        return (JSONObject) jSONObject.getJSONArray("results").get(0);
    }

    public static void a(int i, m mVar) {
        if (i == 401 && u.a()) {
            u.i("AppLovinSdk", "SDK key \"" + mVar.z() + "\" is rejected by AppLovin. Please make sure the SDK key is correct.");
        } else if (i == 418) {
            mVar.K().a((b<?>) b.U, (Object) true);
            mVar.K().a();
        } else {
            if (i < 400 || i >= 500) {
                if (i != -1 || !((Boolean) mVar.a(b.W)).booleanValue()) {
                    return;
                }
            } else if (!((Boolean) mVar.a(b.W)).booleanValue()) {
                return;
            }
            mVar.k();
        }
    }

    public static void a(JSONObject jSONObject, boolean z, m mVar) {
        mVar.ag().a(jSONObject, z);
    }

    public static boolean a() {
        return a((String) null);
    }

    private static boolean a(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(Context context) {
        if (context.getSystemService("connectivity") == null) {
            return true;
        }
        NetworkInfo b2 = b(context);
        if (b2 != null) {
            return b2.isConnected();
        }
        return false;
    }

    public static boolean a(String str) {
        if (g.e()) {
            return (!g.f() || TextUtils.isEmpty(str)) ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() : NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
        }
        return true;
    }

    private static NetworkInfo b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static String b(String str, m mVar) {
        return a((String) mVar.a(b.aW), str, mVar);
    }

    public static void c(JSONObject jSONObject, m mVar) {
        String string = JsonUtils.getString(jSONObject, "persisted_data", (String) null);
        if (StringUtils.isValidString(string)) {
            mVar.a(d.z, string);
            if (u.a()) {
                mVar.A().c("ConnectionUtils", "Updated persisted data");
            }
        }
    }

    public static void d(JSONObject jSONObject, m mVar) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (mVar != null) {
            try {
                if (jSONObject.has("settings")) {
                    c K = mVar.K();
                    if (!jSONObject.isNull("settings")) {
                        K.a(jSONObject.getJSONObject("settings"));
                        K.a();
                    }
                }
            } catch (JSONException e) {
                if (u.a()) {
                    mVar.A().b("ConnectionUtils", "Unable to parse settings out of API response", e);
                }
            }
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    public static Map<String, String> e(m mVar) {
        Map<String, String> map = CollectionUtils.map();
        String str = (String) mVar.a(b.X);
        if (StringUtils.isValidString(str)) {
            map.put("device_token", str);
        } else if (!((Boolean) mVar.a(b.es)).booleanValue()) {
            map.put("api_key", mVar.z());
        }
        map.putAll(Utils.stringifyObjectMap(mVar.V().i()));
        return map;
    }

    public static void e(JSONObject jSONObject, m mVar) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "filesystem_values", (JSONObject) null);
        if (jSONObject2 != null) {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(mVar.L()).edit();
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object object = JsonUtils.getObject(jSONObject2, next, (Object) null);
                if (object != null) {
                    e.a(next, object, (SharedPreferences) null, edit);
                }
            }
            edit.apply();
        }
    }

    public static String f(m mVar) {
        NetworkInfo b2 = b(mVar.L());
        if (b2 == null) {
            return "unknown";
        }
        int type = b2.getType();
        int subtype = b2.getSubtype();
        return type == 1 ? "wifi" : type == 0 ? a(subtype, a) ? "2g" : a(subtype, b) ? "3g" : a(subtype, c) ? "4g" : a(subtype, d) ? "5g" : "mobile" : "unknown";
    }

    public static void f(JSONObject jSONObject, m mVar) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "variables", (JSONObject) null);
        if (jSONObject2 != null) {
            mVar.y().updateVariables(jSONObject2);
        }
    }

    public static String g(m mVar) {
        return a((String) mVar.a(b.aT), ((Boolean) mVar.a(b.df)).booleanValue() ? "5.0/ad" : "4.0/ad", mVar);
    }

    public static String h(m mVar) {
        return a((String) mVar.a(b.aU), ((Boolean) mVar.a(b.df)).booleanValue() ? "5.0/ad" : "4.0/ad", mVar);
    }

    public static String i(m mVar) {
        return a((String) mVar.a(b.aT), "4.0/ad", mVar);
    }

    public static String j(m mVar) {
        return a((String) mVar.a(b.aU), "4.0/ad", mVar);
    }

    public static String k(m mVar) {
        return a((String) mVar.a(b.aZ), "1.0/variable_config", mVar);
    }

    public static String l(m mVar) {
        return a((String) mVar.a(b.ba), "1.0/variable_config", mVar);
    }
}
