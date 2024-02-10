package com.ironsource.mediationsdk.d;

import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    private static c a;
    private final HashSet<ImpressionDataListener> b = new HashSet<>();
    private ConcurrentHashMap<String, List<String>> c = new ConcurrentHashMap<>();

    c() {
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (a == null) {
                a = new c();
            }
            cVar = a;
        }
        return cVar;
    }

    private static Object a(Object obj) {
        return obj instanceof JSONObject ? a((JSONObject) obj) : obj instanceof JSONArray ? b((JSONArray) obj) : obj;
    }

    public static List<String> a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    public static Map<String, Object> a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                hashMap.put(next, a(jSONObject.get(next)));
            } catch (JSONException e) {
                IronLog.INTERNAL.error(String.format("Could not put value in map: %s, %s", new Object[]{next, e.getMessage()}));
            }
        }
        return hashMap;
    }

    public static JSONObject a(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                try {
                    jSONObject.put((String) next.getKey(), b(next.getValue()));
                } catch (JSONException unused) {
                    IronLog.INTERNAL.error(String.format("Could not map entry to object: %s, %s", new Object[]{next.getKey(), next.getValue()}));
                }
            }
        }
        return jSONObject;
    }

    public static JSONObject a(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < 2; i++) {
            JSONObject jSONObject2 = jSONObjectArr[i];
            if (jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        jSONObject.put(next, jSONObject2.get(next));
                    } catch (JSONException e) {
                        IronLog.INTERNAL.error(e.getMessage());
                    }
                }
            }
        }
        return jSONObject;
    }

    public static boolean a(String str) {
        try {
            new JSONObject(str);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    private static Object b(Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject) || obj.equals(JSONObject.NULL)) {
            return obj;
        }
        try {
            if (obj instanceof Collection) {
                return new JSONArray((Collection) obj);
            }
            if (!obj.getClass().isArray()) {
                return obj instanceof Map ? new JSONObject((Map) obj) : ((obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof String)) ? obj : obj instanceof Enum ? obj.toString() : obj.getClass().getPackage().getName().startsWith("java.") ? obj.toString() : obj;
            }
            return new JSONArray(Arrays.asList(new Object[]{obj}));
        } catch (Exception unused) {
            return null;
        }
    }

    private static List<Object> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(a(jSONArray.get(i)));
            } catch (JSONException e) {
                IronLog.INTERNAL.error(String.format("Could not put value into list: %s", new Object[]{e.getMessage()}));
            }
        }
        return arrayList;
    }

    public void a(ImpressionDataListener impressionDataListener) {
        synchronized (this) {
            this.b.add(impressionDataListener);
        }
    }

    public void a(String str, List<String> list) {
        this.c.put(str, list);
    }

    public HashSet<ImpressionDataListener> b() {
        return this.b;
    }

    public void b(ImpressionDataListener impressionDataListener) {
        synchronized (this) {
            this.b.remove(impressionDataListener);
        }
    }

    public ConcurrentHashMap<String, List<String>> c() {
        return this.c;
    }
}
