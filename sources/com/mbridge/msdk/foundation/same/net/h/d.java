package com.mbridge.msdk.foundation.same.net.h;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.d.a;
import com.mbridge.msdk.foundation.tools.aa;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.text.Typography;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CommonRequestParams */
public final class d {
    public static String a = "a";
    public static String b = "d";
    public static String c = "e";
    public static String d = "f";
    public static String e = "g";
    public static String f = "h";
    public static String g = "i";
    public static String h = "coppa";
    private static final String i = "d";
    private Map<String, String> j = new LinkedHashMap();
    private Map<String, a> k = new LinkedHashMap();

    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str2 != null) {
            this.j.put(str, str2);
        }
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry next : this.j.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(Typography.amp);
                }
                sb.append(URLEncoder.encode((String) next.getKey(), "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode((String) next.getValue(), "UTF-8"));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return sb.toString();
    }

    public final void a(String str) {
        this.j.remove(str);
        this.k.remove(str);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(28);
        try {
            for (Map.Entry next : this.j.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(Typography.amp);
                }
                sb.append(URLEncoder.encode((String) next.getKey(), "UTF-8"));
                sb.append('=');
                sb.append(URLEncoder.encode((String) next.getValue(), "UTF-8"));
            }
            for (Map.Entry next2 : this.k.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(Typography.amp);
                }
                sb.append(URLEncoder.encode((String) next2.getKey(), "UTF-8"));
                sb.append('=');
                sb.append(URLEncoder.encode("FILE_NAME_" + ((a) next2.getValue()).a().getName(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException e2) {
            aa.d(i, e2.getMessage());
        }
        return sb.toString();
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry next : this.j.entrySet()) {
                jSONObject.put(URLEncoder.encode((String) next.getKey(), "UTF-8"), URLEncoder.encode((String) next.getValue(), "UTF-8"));
            }
            for (Map.Entry next2 : this.k.entrySet()) {
                jSONObject.put(URLEncoder.encode((String) next2.getKey(), "UTF-8"), URLEncoder.encode("FILE_NAME_" + ((a) next2.getValue()).a().getName(), "UTF-8"));
            }
        } catch (JSONException e2) {
            aa.d(i, e2.getMessage());
        } catch (UnsupportedEncodingException unused) {
        }
        return jSONObject;
    }

    public final Map<String, String> c() {
        return this.j;
    }
}
