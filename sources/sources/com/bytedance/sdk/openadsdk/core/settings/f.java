package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JsConfiglInfo */
public class f {
    public static final f a = new f((String) null);
    public static String b = "";
    public String c = "https://lf3-cdn-tos.bytegoofy.com/obj/goofy/bytecom/resource/tetrisIAB/3p_monitor.2424fa46.js";
    public boolean d = true;
    public boolean e = true;
    public boolean f = true;

    public f(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("performance_js");
            String optString = optJSONObject.optString("url", "https://lf3-cdn-tos.bytegoofy.com/obj/goofy/bytecom/resource/tetrisIAB/3p_monitor.2424fa46.js");
            if (!TextUtils.isEmpty(optString)) {
                this.c = optString;
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("execute_time");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.optString(i));
            }
            this.d = arrayList.contains("load_finish");
            this.f = arrayList.contains("load_fail");
            this.e = arrayList.contains("load");
        } catch (Exception unused) {
        }
    }
}
