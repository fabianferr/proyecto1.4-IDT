package com.umlaut.crowd.internal;

import java.util.ArrayList;
import java.util.List;

public enum n4 {
    JSON_TOKEN_UNKNOWN(0),
    JSON_TOKEN_ARRAY_START(1),
    JSON_TOKEN_ARRAY_END(2),
    JSON_TOKEN_OBJECT_START(4),
    JSON_TOKEN_OBJECT_END(8),
    JSON_TOKEN_OBJECT_KEY(16),
    JSON_TOKEN_VALUE(C),
    JSON_TOKEN_VALUE_NUMBER_DOUBLE(32),
    JSON_TOKEN_VALUE_NUMBER_LONG(64),
    JSON_TOKEN_VALUE_STRING(128),
    MODE_VALUE_STREAM(256),
    JSON_TOKEN_VALUE_BOOLEAN(512),
    JSON_TOKEN_VALUE_NULL(1024),
    JSON_TOKEN_VALUE_BYTES(2048);
    
    static final int A = 1024;
    static final int B = 2048;
    static final int C = 3813;
    static final int p = 0;
    static final int q = 1;
    static final int r = 2;
    static final int s = 4;
    static final int t = 8;
    static final int u = 16;
    static final int v = 32;
    static final int w = 64;
    static final int x = 128;
    static final int y = 256;
    static final int z = 512;
    private int a;

    private n4(int i) {
        this.a = i;
    }

    static n4 a(int i) {
        for (n4 n4Var : values()) {
            if (n4Var.a == i) {
                return n4Var;
            }
        }
        return null;
    }

    static List<n4> b(int i) {
        ArrayList arrayList = new ArrayList();
        for (n4 n4Var : values()) {
            if ((n4Var.a & i) != 0) {
                arrayList.add(n4Var);
            }
        }
        return arrayList;
    }
}
