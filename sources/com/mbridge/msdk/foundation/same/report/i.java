package com.mbridge.msdk.foundation.same.report;

import android.util.Log;
import com.mbridge.msdk.e.a;
import com.mbridge.msdk.e.d;
import com.mbridge.msdk.e.e;
import com.mbridge.msdk.e.m;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: EventLibraryDecorate */
public final class i implements d {
    public final Map<String, String> a(m mVar, List<com.mbridge.msdk.e.i> list, JSONObject jSONObject) {
        HashMap hashMap;
        if (!(list == null || list.size() == 0)) {
            h.a(jSONObject);
            if (jSONObject == null) {
                hashMap = null;
            } else {
                hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, String.valueOf(jSONObject.opt(next)));
                }
            }
            if (hashMap == null) {
                hashMap = new HashMap();
            }
            try {
                hashMap.put("data", URLEncoder.encode(a(list).toString(), "utf-8"));
                return hashMap;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static StringBuilder a(List<com.mbridge.msdk.e.i> list) {
        e c;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            com.mbridge.msdk.e.i iVar = list.get(i);
            if (!(iVar == null || (c = iVar.c()) == null)) {
                JSONObject d = c.d();
                h.a(d);
                if (d == null) {
                    d = new JSONObject();
                }
                try {
                    d.put("ts", c.f());
                    int d2 = iVar.d() - 1;
                    if (d2 >= 1) {
                        d.put("retryed", d2);
                    }
                    long g = c.g();
                    if (g > 0) {
                        d.put("duration", g);
                    }
                } catch (Exception e) {
                    if (a.a) {
                        Log.e("TrackManager", "decorateRequestParams: ", e);
                    }
                } catch (Throwable th) {
                    sb.append(a(d));
                    throw th;
                }
                sb.append(a(d));
                if (i < list.size() - 1) {
                    sb.append("\n");
                }
            }
        }
        return sb;
    }

    private static String a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> keys = jSONObject.keys();
        int i = 0;
        while (keys.hasNext()) {
            String next = keys.next();
            i++;
            if (i <= jSONObject.length() - 1) {
                sb.append(next);
                sb.append("=");
                sb.append(jSONObject.opt(next));
                sb.append("&");
            } else {
                sb.append(next);
                sb.append("=");
                sb.append(jSONObject.opt(next));
            }
        }
        return sb.toString();
    }
}
