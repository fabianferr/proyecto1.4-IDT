package com.bytedance.sdk.openadsdk.api;

import android.os.Bundle;
import java.util.Map;

public class PAGRequest {
    private String a;
    private Map<String, Object> b;
    private Bundle c = null;

    public String getAdString() {
        return this.a;
    }

    public void setAdString(String str) {
        this.a = str;
    }

    public Map<String, Object> getExtraInfo() {
        return this.b;
    }

    public void setExtraInfo(Map<String, Object> map) {
        this.b = map;
    }

    public final void addNetworkExtrasBundle(Class<?> cls, Bundle bundle) {
        if (this.c == null) {
            this.c = new Bundle();
        }
        this.c.putBundle(cls.getName(), bundle);
    }

    public Bundle getNetworkExtrasBundle() {
        return this.c;
    }
}
