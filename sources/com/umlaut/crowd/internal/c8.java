package com.umlaut.crowd.internal;

import java.text.ParseException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class c8 {
    d8 a;
    Set<String> b;

    c8() {
    }

    public Set<String> a() {
        Set<String> set = this.b;
        if (set != null) {
            return set;
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(this.a.a((Set<String>) new HashSet()));
        this.b = unmodifiableSet;
        return unmodifiableSet;
    }

    public static c8 a(String str) throws IllegalAccessException, ParseException, xb {
        c8 c8Var = new c8();
        c8Var.a = u8.b(str);
        return c8Var;
    }

    public boolean a(Map<String, String> map) {
        return this.a.a(map);
    }
}
