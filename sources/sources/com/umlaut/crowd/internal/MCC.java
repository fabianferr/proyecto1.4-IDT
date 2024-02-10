package com.umlaut.crowd.internal;

import com.umlaut.crowd.utils.JsonUtils;

public class MCC {
    public String[] cdn = null;
    public String criteria = "";

    public String toString() {
        return JsonUtils.toJson(this);
    }
}
