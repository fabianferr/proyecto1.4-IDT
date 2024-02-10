package com.startapp;

import android.app.Activity;
import java.util.Map;
import org.json.JSONArray;

/* compiled from: Sta */
public class z3 implements e9<int[]> {
    public Object parse(Class cls, Object obj) {
        int[] iArr;
        int i;
        int i2 = 0;
        if (obj instanceof Number) {
            return new int[]{((Number) obj).intValue()};
        }
        if (obj instanceof String) {
            Map<Activity, Integer> map = k9.a;
            String[] split = ((String) obj).split(",");
            int length = split.length;
            iArr = new int[length];
            while (i2 < length) {
                try {
                    iArr[i2] = Integer.parseInt(split[i2].trim());
                    i2++;
                } catch (NumberFormatException unused) {
                }
            }
        } else {
            if (obj instanceof JSONArray) {
                JSONArray jSONArray = new JSONArray();
                int length2 = jSONArray.length();
                iArr = new int[length2];
                for (int i3 = 0; i3 < length2; i3++) {
                    Object opt = jSONArray.opt(i3);
                    if (opt instanceof Number) {
                        iArr[i3] = ((Number) opt).intValue();
                    } else if (opt instanceof String) {
                        String str = (String) opt;
                        Map<Activity, Integer> map2 = k9.a;
                        if (str != null) {
                            try {
                                i = Integer.parseInt(str);
                            } catch (NumberFormatException unused2) {
                            }
                            iArr[i3] = i;
                        }
                        i = 0;
                        iArr[i3] = i;
                    }
                }
            }
            return null;
        }
        return iArr;
    }
}
