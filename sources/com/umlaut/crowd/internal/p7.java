package com.umlaut.crowd.internal;

import com.umlaut.crowd.utils.JsonUtils;

public class p7 extends RBR {
    public boolean AcceptedTerms;
    public a2 DeviceInfo = new a2();
    public boolean RecurringRegistration;
    public ub TimeInfoOnRegistration = new ub();

    public p7(String str, String str2) {
        super(str, str2);
    }

    public String a() {
        return JsonUtils.toJson(w2.REG, (RBR) this);
    }
}
