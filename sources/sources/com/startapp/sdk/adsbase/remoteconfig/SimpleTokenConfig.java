package com.startapp.sdk.adsbase.remoteconfig;

import android.content.Context;
import com.startapp.sdk.adsbase.e;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.u1;
import java.io.Serializable;

/* compiled from: Sta */
public class SimpleTokenConfig implements Serializable {
    private static final long serialVersionUID = 2058698844345650499L;
    private boolean enabled = false;

    public boolean a(Context context) {
        ComponentLocator a = ComponentLocator.a(context);
        e e = a.e();
        u1 g = a.g();
        if (e.getBoolean("userDisabledSimpleToken", false) || !this.enabled || !g.c()) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.enabled == ((SimpleTokenConfig) obj).enabled) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Boolean.valueOf(this.enabled).hashCode();
    }
}
