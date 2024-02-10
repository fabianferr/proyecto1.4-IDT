package com.umlaut.crowd.internal;

import java.util.Map;

public class p8 extends n8 {
    public p8() {
        super("OR");
    }

    public boolean a(Map<String, String> map) {
        if (this.a != null) {
            int i = 0;
            while (true) {
                d8[] d8VarArr = this.a;
                if (i >= d8VarArr.length) {
                    return false;
                }
                if (d8VarArr[i].a(map)) {
                    return true;
                }
                i++;
            }
        } else {
            throw new IllegalStateException("no rule was parsed yet");
        }
    }
}
