package com.startapp.sdk.adsbase;

import com.startapp.p0;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Sta */
public abstract class BaseResponse implements Serializable {
    private static final long serialVersionUID = 3276484898993249723L;
    private String errorMessage = null;
    public Map<String, String> parameters = new HashMap();
    private boolean validResponse = true;

    public String a() {
        return this.errorMessage;
    }

    public boolean b() {
        return this.validResponse;
    }

    public String toString() {
        StringBuilder a = p0.a("BaseResponse [parameters=");
        a.append(this.parameters);
        a.append(", validResponse=");
        a.append(this.validResponse);
        a.append(", errorMessage=");
        a.append(this.errorMessage);
        a.append("]");
        return a.toString();
    }
}
