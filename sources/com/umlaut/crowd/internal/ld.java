package com.umlaut.crowd.internal;

import android.util.Base64;

public class ld {
    public static String a(kd[] kdVarArr) {
        String str = "";
        for (kd kdVar : kdVarArr) {
            str = str + new String(Base64.encode(kdVar.Key.getBytes(), 0)) + "-" + new String(Base64.encode(kdVar.Value.getBytes(), 0)) + ",";
        }
        return str.substring(0, str.length() - 1);
    }

    public static kd[] a(String str) {
        String[] split = str.split(",");
        kd[] kdVarArr = new kd[split.length];
        if (str.length() <= 0) {
            return null;
        }
        int i = 0;
        while (i < split.length) {
            try {
                String[] split2 = split[i].split("-");
                kdVarArr[i] = new kd(new String(Base64.decode(split2[0].getBytes(), 0)), new String(Base64.decode(split2[1].getBytes(), 0)));
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return kdVarArr;
    }
}
