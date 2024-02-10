package com.appnext.ads;

import android.text.TextUtils;
import java.util.Random;
import org.json.JSONArray;

public final class a {
    public static String a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            JSONArray jSONArray = new JSONArray(str);
            int nextInt = new Random(System.nanoTime()).nextInt(100);
            int i = 0;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                i += jSONArray.getJSONObject(i2).getInt("p");
                if (nextInt < i) {
                    return jSONArray.getJSONObject(i2).getString("id");
                }
            }
            return "";
        } catch (Throwable th) {
            com.appnext.base.a.a("TemplateRandomizer$getTemplate", th);
            return "";
        }
    }
}
