package com.umlaut.crowd.internal;

import com.umlaut.crowd.utils.JsonUtils;

public class LC {
    public String address;
    public int successfulTests;
    public int totalTests;

    public String toString() {
        return JsonUtils.toJson(this);
    }
}
