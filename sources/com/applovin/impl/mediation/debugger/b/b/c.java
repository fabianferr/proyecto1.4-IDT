package com.applovin.impl.mediation.debugger.b.b;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.d;
import com.applovin.impl.sdk.utils.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class c {
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final String d;

    public c(JSONObject jSONObject, m mVar) {
        this.a = d.a(mVar.L()).a();
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "cleartext_traffic", (JSONObject) null);
        boolean z = false;
        if (jSONObject2 != null) {
            this.b = true;
            this.d = JsonUtils.getString(jSONObject2, "description", "");
            if (h.a()) {
                this.c = true;
                return;
            }
            List list = JsonUtils.getList(jSONObject2, "domains", new ArrayList());
            if (list.size() > 0) {
                Iterator it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!h.a((String) it.next())) {
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
            }
            this.c = z;
            return;
        }
        this.b = false;
        this.d = "";
        this.c = h.a();
    }

    public boolean a() {
        return this.b;
    }

    public boolean b() {
        boolean z = this.c;
        return z && (this.a || z);
    }

    public String c() {
        return this.a ? this.d : "You must include an entry in your AndroidManifest.xml to point to your network_security_config.xml.\n\nFor more information, visit: https://developer.android.com/training/articles/security-config";
    }
}
