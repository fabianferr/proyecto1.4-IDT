package com.mbridge.msdk.foundation.same.net.h;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.same.net.b.a;
import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.l;
import org.json.JSONObject;

/* compiled from: CommonMBListener */
public abstract class c extends f<JSONObject> {
    private static final String a = "c";

    public abstract void a(String str);

    public abstract void a(JSONObject jSONObject);

    public void onSuccess(l<JSONObject> lVar) {
        if (lVar == null) {
            a("response is null");
        } else if (lVar.c == null) {
            a(lVar);
        } else if (lVar.c.a == 204) {
            a(new JSONObject());
        } else {
            a(lVar);
        }
    }

    private void a(l<JSONObject> lVar) {
        if (lVar.a == null) {
            a("response result is null");
            return;
        }
        int optInt = ((JSONObject) lVar.a).optInt("status", -9999);
        if (optInt == -9999) {
            a((JSONObject) lVar.a);
        } else if (optInt == 1 || optInt == 200) {
            a(((JSONObject) lVar.a).optJSONObject("data"));
        } else {
            String optString = ((JSONObject) lVar.a).optString(NotificationCompat.CATEGORY_MESSAGE);
            if (TextUtils.isEmpty(optString)) {
                optString = "error message is null";
            }
            a(optString);
        }
    }

    public void onError(a aVar) {
        a(com.mbridge.msdk.foundation.same.net.g.a.a(aVar));
    }
}
