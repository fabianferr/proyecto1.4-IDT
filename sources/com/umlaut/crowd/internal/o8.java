package com.umlaut.crowd.internal;

import java.util.Map;

public class o8 extends n8 {
    public o8() {
        super("AND");
    }

    public boolean a(Map<String, String> map) {
        if (this.a != null) {
            int i = 0;
            while (true) {
                d8[] d8VarArr = this.a;
                if (i >= d8VarArr.length) {
                    return true;
                }
                if (!d8VarArr[i].a(map)) {
                    return false;
                }
                i++;
            }
        } else {
            throw new IllegalStateException("No rule parsed yet");
        }
    }
}
