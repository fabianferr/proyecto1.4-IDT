package com.umlaut.crowd.internal;

import com.umlaut.crowd.utils.JsonUtils;

public class f6 extends RBR {
    public z BatteryInfoOnEnd = new z();
    public z BatteryInfoOnStart = new z();
    public a2 DeviceInfo = new a2();
    public String FeedbackName = "";
    public q4 LocationInfoOnEnd = new q4();
    public q4 LocationInfoOnStart = new q4();
    public n5 MemoryInfoOnEnd = new n5();
    public n5 MemoryInfoOnStart = new n5();
    public k7[] QuestionAnswerList = new k7[0];
    public DRI RadioInfoOnEnd = new DRI();
    public DRI RadioInfoOnStart = new DRI();
    public y9 StorageInfo = new y9();
    public ub TimeInfoOnEnd = new ub();
    public ub TimeInfoOnStart = new ub();
    public String TimestampOnEnd = "";
    public String TimestampOnStart = "";
    public nc TrafficInfoOnEnd = new nc();
    public nc TrafficInfoOnStart = new nc();
    public DWI WifiInfoOnEnd = new DWI();
    public DWI WifiInfoOnStart = new DWI();

    public f6(String str, String str2) {
        super(str, str2);
    }

    public String a() {
        return JsonUtils.toJson(w2.NF, (RBR) this);
    }
}
