package com.teragence.library;

import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class o6 {
    static String a(m5[] m5VarArr) {
        JSONObject jSONObject = new JSONObject();
        for (m5 m5Var : m5VarArr) {
            try {
                jSONObject.put(m5Var.a, m5Var.b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public static m5[] a(Map<String, Object> map) {
        ArrayList arrayList = new ArrayList();
        for (String next : map.keySet()) {
            if ((map.get(next) instanceof JSONObject) || (map.get(next) instanceof JSONArray) || (map.get(next) instanceof String)) {
                arrayList.add(new m5(next, map.get(next)));
            }
        }
        return (m5[]) arrayList.toArray(new m5[0]);
    }
}
