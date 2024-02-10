package com.umlaut.crowd.internal;

import com.umlaut.crowd.utils.JsonUtils;

public class yd extends RBR {
    public boolean Bookmarked;
    public long Duration;
    public long FkAusDelta;
    public String FkAusId = "";
    public ub TimeInfoOnEnd = new ub();
    public ub TimeInfoOnStart = new ub();
    public String Url = "";
    public int Visits;
    public String WebId = "";

    public yd(String str, String str2) {
        super(str, str2);
    }

    public String a() {
        return JsonUtils.toJson(w2.WEB, (RBR) this);
    }
}
