package com.umlaut.crowd.internal;

import com.umlaut.crowd.utils.JsonUtils;

public class RMR extends RBR {
    public String BMSISDN = "";
    public q4 LocationInfo = new q4();
    public p5 MessageDirection = p5.Unknown;
    public int MessageLength = -1;
    public DRI RadioInfo = new DRI();
    public ub TimeInfo = new ub();
    public String TimestampMessage = "";

    public RMR(String str, String str2) {
        super(str, str2);
    }

    public String a() {
        return JsonUtils.toJson(w2.MSG, (RBR) this);
    }

    public Object clone() throws CloneNotSupportedException {
        RMR rmr = (RMR) super.clone();
        rmr.LocationInfo = (q4) this.LocationInfo.clone();
        rmr.RadioInfo = (DRI) this.RadioInfo.clone();
        rmr.TimeInfo = (ub) this.TimeInfo.clone();
        return rmr;
    }
}
