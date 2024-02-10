package com.startapp.sdk.adsbase.remoteconfig;

import android.app.Activity;
import com.startapp.k9;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

/* compiled from: Sta */
public final class ComponentInfoEventConfig implements Serializable {
    public static final ComponentInfoEventConfig a = new ComponentInfoEventConfig();
    private static final long serialVersionUID = -5359772055016698271L;
    private double chance = 0.0d;
    private long flags = 0;

    public boolean a(long j) {
        return (this.flags & j) == j && k9.a(this.chance);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ComponentInfoEventConfig.class != obj.getClass()) {
            return false;
        }
        ComponentInfoEventConfig componentInfoEventConfig = (ComponentInfoEventConfig) obj;
        if (this.flags == componentInfoEventConfig.flags && Double.compare(this.chance, componentInfoEventConfig.chance) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        Object[] objArr = {Long.valueOf(this.flags), Double.valueOf(this.chance)};
        Map<Activity, Integer> map = k9.a;
        return Arrays.deepHashCode(objArr);
    }
}
