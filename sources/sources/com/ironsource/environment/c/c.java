package com.ironsource.environment.c;

import android.content.Context;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.c.a;
import com.ironsource.environment.c.b;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class c {
    private JSONObject a(Context context, List<String> list) {
        return a(a(b.a.a.a(context)), (String[]) list.toArray(new String[list.size()]));
    }

    private static JSONObject a(JSONObject jSONObject) {
        jSONObject.remove("adunit_data");
        return jSONObject;
    }

    public static JSONObject a(JSONObject jSONObject, String[] strArr) {
        JSONObject jSONObject2 = new JSONObject();
        for (String str : strArr) {
            if (jSONObject.has(str)) {
                jSONObject2.put(str, jSONObject.opt(str));
            }
        }
        return jSONObject2;
    }

    public JSONObject a(Context context, a.C0105a aVar) {
        String name = aVar.name();
        JSONObject a = b.a.a.a(context);
        JSONObject optJSONObject = a.optJSONObject("adunit_data");
        JSONObject a2 = a(a);
        if (!(optJSONObject == null || optJSONObject.optJSONObject(name) == null)) {
            JSONObject jSONObject = optJSONObject.getJSONObject(name);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                a2.putOpt(next, jSONObject.opt(next));
            }
        }
        return a2;
    }

    public final JSONObject a(Context context, String[] strArr) {
        return a(a(b.a.a.a(context)), strArr);
    }

    public final JSONObject a(List<String> list) {
        return a(ContextProvider.getInstance().getApplicationContext(), list);
    }

    public final JSONObject a(String[] strArr) {
        return a(a(b.a.a.a(ContextProvider.getInstance().getApplicationContext())), strArr);
    }
}
