package com.bytedance.sdk.openadsdk.n.a;

import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.openadsdk.core.g.b.c;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ac;
import org.json.JSONObject;

/* compiled from: PAGMRCEventManager */
public class d {
    public static void a(final q qVar, final a aVar, final int i) {
        qVar.aA();
        aa.c(new h("mrc_report") {
            public void run() {
                if (qVar.az()) {
                    if (qVar.bd()) {
                        c.a(qVar.S(), new c.b("show_urls", qVar));
                    } else {
                        com.bytedance.sdk.openadsdk.b.c.a(qVar);
                    }
                }
                String a2 = ac.a(qVar);
                JSONObject jSONObject = new JSONObject();
                a aVar = aVar;
                if (aVar != null) {
                    try {
                        jSONObject.put("root_view", a.a(aVar));
                        int i = i;
                        if (i != -1) {
                            jSONObject.put("dynamic_show_type", i);
                        }
                    } catch (Throwable unused) {
                    }
                }
                com.bytedance.sdk.openadsdk.b.c.b(qVar, a2, "mrc_show", jSONObject);
            }
        });
    }
}
