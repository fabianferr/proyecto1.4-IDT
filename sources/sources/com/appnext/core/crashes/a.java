package com.appnext.core.crashes;

import android.content.Context;
import android.text.TextUtils;
import com.appnext.core.g;
import java.util.HashMap;
import org.json.JSONObject;

public final class a {
    private Context aM;
    private String dS;
    private String dT;

    public a(Context context, String str, String str2) {
        this.aM = context;
        this.dS = str;
        this.dT = str2;
    }

    public final void af() {
        try {
            if (TextUtils.isEmpty(this.dS)) {
                return;
            }
            if (!TextUtils.isEmpty(this.dT)) {
                JSONObject jSONObject = new JSONObject();
                Context context = this.aM;
                if (context != null) {
                    jSONObject.put("did", g.b(context, false));
                }
                jSONObject.put("api_Call", this.dS);
                jSONObject.put("ex", this.dT);
                jSONObject.put("ver", "2.7.0.473");
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                g.a(this.aM, "https://global.appnext.com/AdminService.asmx/ex?data=", (HashMap<String, String>) hashMap, false, 10000);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
