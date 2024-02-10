package com.umlaut.crowd.internal;

public enum t8 {
    TRUE("TRUE", m8.class),
    FALSE("FALSE", l8.class),
    EQ("EQ", g8.class),
    GT("GT", h8.class),
    LT("LT", i8.class),
    NOT("NOT", q8.class),
    AND("AND", o8.class),
    OR("OR", p8.class),
    PIR("PIR", s8.class),
    ISNULL("ISNULL", r8.class),
    STREQ("STREQ", k8.class);
    
    String a;
    Class<?> b;

    private t8(String str, Class<?> cls) {
        this.a = str;
        this.b = cls;
        if (!d8.class.isAssignableFrom(cls)) {
            throw new RuntimeException("Cannot apply gerneric Rule interface for class: " + name());
        }
    }

    public static t8 a(String str) {
        for (t8 t8Var : values()) {
            if (t8Var.a.equals(str)) {
                return t8Var;
            }
        }
        return null;
    }
}
