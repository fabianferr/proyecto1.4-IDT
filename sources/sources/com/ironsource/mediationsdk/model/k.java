package com.ironsource.mediationsdk.model;

import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.controller.x;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public final class k {
    public ArrayList<l> a = new ArrayList<>();
    public l b;
    public x c;
    public JSONObject d;

    public k(x xVar) {
        this.c = xVar;
    }

    public final l a() {
        Iterator<l> it = this.a.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.isDefault()) {
                return next;
            }
        }
        return this.b;
    }

    public final l a(String str) {
        Iterator<l> it = this.a.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getPlacementName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public final String b() {
        JSONObject jSONObject = this.d;
        return (jSONObject == null || TextUtils.isEmpty(jSONObject.optString("adapterName"))) ? IronSourceConstants.SUPERSONIC_CONFIG_NAME : this.d.optString("adapterName");
    }
}
