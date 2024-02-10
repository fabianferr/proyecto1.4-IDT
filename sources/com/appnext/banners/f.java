package com.appnext.banners;

import com.appnext.base.a;
import java.util.Random;
import org.json.JSONArray;

public final class f {
    public static String a(String str) {
        if (str == null) {
            return "";
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int nextInt = new Random(System.nanoTime()).nextInt(100);
            int i = 0;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                i += jSONArray.getJSONObject(i2).getInt("p");
                if (nextInt < i) {
                    return jSONArray.getJSONObject(i2).getString("id");
                }
            }
        } catch (Throwable th) {
            a.a("TemplateRandomizer$getTemplate", th);
        }
        return "";
    }
}
