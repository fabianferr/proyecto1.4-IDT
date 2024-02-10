package com.umlaut.crowd.internal;

public enum i4 {
    JSON_MODE_INIT(105),
    JSON_MODE_OBJECT(111),
    JSON_MODE_OBJECT_KEY(107),
    JSON_MODE_VALUE(118),
    JSON_MODE_VALUE_STREAM(114),
    JSON_MODE_ARRAY(97),
    JSON_MODE_DONE(100);
    
    static final char i = 'i';
    static final char j = 'o';
    static final char k = 'k';
    static final char l = 'v';
    static final char m = 'r';
    static final char n = 'a';
    static final char o = 'd';
    private int a;

    private i4(int i2) {
        this.a = i2;
    }

    public int a() {
        return this.a;
    }

    static i4 a(int i2) {
        for (i4 i4Var : values()) {
            if (i4Var.a == i2) {
                return i4Var;
            }
        }
        return null;
    }
}
