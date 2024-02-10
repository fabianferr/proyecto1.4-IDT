package com.umlaut.crowd.internal;

import com.umlaut.crowd.utils.JsonUtils;

public class CCI {
    public MCC ct = null;
    public MCC ltr = null;

    public String toString() {
        return JsonUtils.toJson(this);
    }
}
