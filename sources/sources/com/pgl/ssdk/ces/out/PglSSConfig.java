package com.pgl.ssdk.ces.out;

import android.text.TextUtils;
import java.util.Map;

public final class PglSSConfig {
    public static final int OVREGION_TYPE_SG = 0;
    public static final int OVREGION_TYPE_UNKNOWN = -1;
    public static final int OVREGION_TYPE_VA = 1;
    private String a;
    private String b;
    private final int c;
    private Map d;

    public class Builder {
        private String a;
        private int b = -1;

        public PglSSConfig build() {
            int i;
            if (TextUtils.isEmpty(this.a) || (i = this.b) == -1) {
                return null;
            }
            return new PglSSConfig(this.a, i);
        }

        public Builder setAppId(String str) {
            this.a = str;
            return this;
        }

        public Builder setOVRegionType(int i) {
            this.b = i;
            return this;
        }
    }

    private PglSSConfig(String str, int i) {
        this.a = str;
        this.c = i;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getAppId() {
        return this.a;
    }

    public Map getCustomInfo() {
        return this.d;
    }

    public String getDeviceId() {
        return this.b;
    }

    public int getOVRegionType() {
        return this.c;
    }

    public void setCustomInfo(Map map) {
        this.d = map;
    }

    public void setDeviceId(String str) {
        this.b = str;
    }
}
