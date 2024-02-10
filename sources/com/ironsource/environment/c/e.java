package com.ironsource.environment.c;

import android.content.Context;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.c.a;
import com.ironsource.environment.c.b;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    public static void a(Context context) {
        b.a.a.b(context);
    }

    public static void a(String str, a.C0105a aVar) {
        JSONObject optJSONObject;
        try {
            String name = aVar.name();
            b bVar = b.a.a;
            JSONObject optJSONObject2 = bVar.a(ContextProvider.getInstance().getApplicationContext()).optJSONObject("adunit_data");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject(name)) != null && optJSONObject.remove(str) != null) {
                bVar.a("adunit_data", optJSONObject2.put(name, optJSONObject));
            }
        } catch (JSONException unused) {
        }
    }

    public static void a(String str, Object obj) {
        b.a.a.a(str, obj);
    }

    public static void a(String str, Object obj, a.C0105a aVar) {
        try {
            String name = aVar.name();
            b bVar = b.a.a;
            JSONObject optJSONObject = bVar.a(ContextProvider.getInstance().getApplicationContext()).optJSONObject("adunit_data");
            if (optJSONObject == null) {
                bVar.a("adunit_data", new JSONObject().put(name, new JSONObject().put(str, obj)));
                return;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(name);
            if (optJSONObject2 == null) {
                bVar.a("adunit_data", optJSONObject.put(name, new JSONObject().put(str, obj)));
            } else {
                bVar.a("adunit_data", optJSONObject.put(name, optJSONObject2.put(str, obj)));
            }
        } catch (JSONException unused) {
        }
    }

    public static void a(String str, JSONObject jSONObject) {
        b bVar = b.a.a;
        if (jSONObject != null) {
            try {
                Object obj = bVar.a.get(str);
                if (!(obj instanceof JSONObject)) {
                    bVar.a(str, jSONObject);
                    return;
                }
                JSONObject jSONObject2 = (JSONObject) obj;
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.putOpt(next, jSONObject.opt(next));
                }
                bVar.a(str, jSONObject2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(Map<String, Object> map) {
        b bVar = b.a.a;
        if (map != null) {
            try {
                for (String next : map.keySet()) {
                    if (map.containsKey(next)) {
                        bVar.a(next, map.get(next));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
