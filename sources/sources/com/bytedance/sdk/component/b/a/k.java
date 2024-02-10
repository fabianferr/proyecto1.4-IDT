package com.bytedance.sdk.component.b.a;

import com.umlaut.crowd.internal.h2;

/* compiled from: Protocol */
public enum k {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2(h2.a);
    
    private final String e;

    private k(String str) {
        this.e = str;
    }

    public String toString() {
        return this.e;
    }
}
