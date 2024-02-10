package com.startapp;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Sta */
public class v4 {
    public static v4 b = new v4();
    public Map<String, u4> a = new ConcurrentHashMap();

    public u4 a(String str) {
        if (this.a.containsKey(str)) {
            return this.a.get(str);
        }
        u4 u4Var = new u4();
        this.a.put(str, u4Var);
        return u4Var;
    }
}
