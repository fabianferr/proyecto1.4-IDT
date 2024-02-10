package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.l;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MediationInitConfigs */
public class h {
    public static final h a = new h("");
    private final HashMap<String, a> b = new HashMap<>();

    public h(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        a aVar = new a(optJSONObject);
                        this.b.put(aVar.a, aVar);
                    }
                }
            } catch (JSONException e) {
                l.e("MediationInitConfigs", e.getMessage());
            }
        }
    }

    /* compiled from: MediationInitConfigs */
    public static class a {
        public final String a;
        public String b;
        public int c;
        public int d;
        public String e;

        public a(JSONObject jSONObject) {
            this.a = jSONObject.optString("name");
            this.b = jSONObject.optString("app_id");
            this.c = jSONObject.optInt("init_thread", 2);
            this.d = jSONObject.optInt("request_after_init", 2);
            this.e = jSONObject.optString("class_name");
        }
    }
}
