package com.appnext.core.ra.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.appnext.base.a;
import com.appnext.core.g;
import com.appnext.core.ra.database.RecentAppsDatabase;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class d extends b {
    /* access modifiers changed from: protected */
    public final boolean ao() {
        return true;
    }

    public d(Context context, Bundle bundle) {
        super(context, bundle);
    }

    private void a(JSONObject jSONObject) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            g.a(getContext(), "https://global.appnext.com/AdminService.asmx/ra?", (HashMap<String, String>) hashMap, false, 10000);
        } catch (Throwable th) {
            a.a("SendRecentAppsAction$sendToServer", th);
        }
    }

    /* access modifiers changed from: protected */
    public final void an() {
        try {
            JSONObject jSONObject = new JSONObject();
            List<com.appnext.core.ra.database.a> at = RecentAppsDatabase.getInstance(getContext()).recentAppDao().at();
            if (!at.isEmpty()) {
                String b = g.b(getContext(), true);
                if (!TextUtils.isEmpty(b)) {
                    jSONObject.put("did", b);
                    jSONObject.put("publisher_packagename", getContext().getPackageName());
                    JSONArray jSONArray = new JSONArray();
                    ArrayList arrayList = new ArrayList();
                    for (com.appnext.core.ra.database.a next : at) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(CampaignEx.JSON_KEY_PACKAGE_NAME, next.eh);
                        jSONObject2.put("date", next.ei);
                        jSONArray.put(jSONObject2);
                        next.ej = true;
                        arrayList.add(next);
                    }
                    jSONObject.put("apps", jSONArray);
                    a(jSONObject);
                    RecentAppsDatabase.getInstance(getContext()).recentAppDao().b(arrayList);
                    jSONObject.toString();
                }
            }
        } catch (Throwable th) {
            a.a("SendRecentAppsAction$doUniqueAction", th);
            return;
        }
        try {
            RecentAppsDatabase.getInstance(getContext()).recentAppDao().z(ar().format(new Date()));
        } catch (Throwable unused) {
        }
    }
}
