package com.ironsource.sdk.service;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.environment.c.e;
import com.ironsource.environment.h;
import com.ironsource.environment.k;
import com.ironsource.sdk.e.a.a;
import com.ironsource.sdk.utils.IronSourceQaProperties;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    private e a = new e();

    public final void a() {
        HashMap hashMap = new HashMap();
        hashMap.put("omv", a.a);
        hashMap.put("ompv", "7");
        e.a((Map<String, Object>) hashMap);
    }

    public final void a(Context context) {
        if (context instanceof Activity) {
            e.a("imm", (Object) Boolean.valueOf(h.a((Activity) context)));
        }
    }

    public final void b() {
        String controllerConfig = SDKUtils.getControllerConfig();
        if (!TextUtils.isEmpty(controllerConfig)) {
            try {
                e.a("cncdn", new JSONObject(controllerConfig).opt("chinaCDN"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final void b(Context context) {
        e.a("gpi", (Object) Boolean.valueOf(k.a(context)));
    }

    public final void c() {
        JSONObject jSONObject = new JSONObject(IronSourceQaProperties.getInstance().getParameters());
        if (jSONObject.length() > 0) {
            e.a("debug", jSONObject);
        }
    }

    public final void d() {
        e.a("uxt", (Object) Boolean.valueOf(IronSourceStorageUtils.isUxt()));
    }
}
