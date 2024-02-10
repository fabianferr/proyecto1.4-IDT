package com.bytedance.sdk.openadsdk.g;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.video.c.b;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.com.bytedance.overseas.sdk.a.c;
import com.facebook.share.internal.ShareConstants;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JsAppAdDownloadManager */
public class a implements c {
    private final q a;
    private final b b;
    private final Map<String, c> c = new HashMap();

    public void a() {
    }

    public void b() {
    }

    public void b(JSONObject jSONObject) {
    }

    private a(b bVar, q qVar) {
        this.b = bVar;
        this.a = qVar;
    }

    public static a a(b bVar, q qVar) {
        return new a(bVar, qVar);
    }

    public void c() {
        this.c.clear();
    }

    private q a(JSONObject jSONObject, String str) {
        String str2;
        String str3 = null;
        if (jSONObject == null) {
            return null;
        }
        q b2 = q.b();
        b2.c(jSONObject);
        if (!TextUtils.isEmpty(str)) {
            b2.s(str);
        }
        if (this.a == null) {
            return b2;
        }
        if (b2.aa() != null) {
            str3 = b2.aa().a();
        }
        if (TextUtils.isEmpty(str3)) {
            return this.a;
        }
        com.bytedance.sdk.openadsdk.core.model.c aa = this.a.aa();
        if (aa != null && str3.equals(aa.a())) {
            return this.a;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (aa != null) {
            try {
                str2 = aa.a();
            } catch (JSONException unused) {
            }
        } else {
            str2 = AbstractJsonLexerKt.NULL;
        }
        jSONObject2.put("lu", str2);
        jSONObject2.put("ju", str3);
        q qVar = this.a;
        d.a(qVar, ac.a(qVar), -5, jSONObject2);
        if (aa != null && str3.contains("play.google.com/store") && !str3.contains("referrer")) {
            b2.aa().a(aa.a());
        }
        return b2;
    }

    public void a(Context context, JSONObject jSONObject, String str, int i, boolean z) {
        JSONObject optJSONObject;
        if (context != null && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            a(context, a(optJSONObject, str), optJSONObject, i, z);
        }
    }

    private void a(Context context, q qVar, JSONObject jSONObject, int i, boolean z) {
        if (context != null && qVar != null && qVar.aa() != null && jSONObject != null && this.b != null && this.c.get(qVar.aa().a()) == null) {
            String b2 = ac.b(i);
            if (!TextUtils.isEmpty(b2)) {
                this.c.put(qVar.aa().a(), a(context, qVar, jSONObject, b2, z));
            }
        }
    }

    public void a(Context context, JSONObject jSONObject, String str) {
        a(context, this.a, str);
    }

    private void a(Context context, q qVar, String str) {
        if (context != null && qVar != null) {
            com.com.bytedance.overseas.sdk.a.d.a(context, qVar, str).d();
            if (context instanceof b) {
                ((b) context).r();
            }
        }
    }

    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            a(a(optJSONObject, (String) null), optJSONObject);
        }
    }

    private void a(q qVar, JSONObject jSONObject) {
        if (this.b != null && qVar != null && qVar.aa() != null) {
            String a2 = qVar.aa().a();
            if (this.c.containsKey(a2)) {
                this.c.remove(a2);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "success");
                    jSONObject2.put("status", "unsubscribed");
                    jSONObject2.put("appad", jSONObject);
                    this.b.a("app_ad_event", jSONObject2);
                } catch (JSONException e) {
                    l.e("JsAppAdDownloadManager", e.getMessage());
                }
            }
        }
    }

    private c a(Context context, q qVar, JSONObject jSONObject, String str, boolean z) {
        c a2 = com.com.bytedance.overseas.sdk.a.d.a(context, qVar, str);
        a2.a(true);
        return a2;
    }
}
