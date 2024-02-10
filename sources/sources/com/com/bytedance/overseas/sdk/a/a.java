package com.com.bytedance.overseas.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.b.l;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: AndroidRGPDownLoader */
public class a extends b {
    public a(Context context, q qVar, String str) {
        super(context, qVar, str);
    }

    public boolean a() {
        HashMap hashMap;
        boolean z = false;
        if (this.a == null) {
            return false;
        }
        if (this.b == null || this.b.be() != 0) {
            hashMap = null;
        } else {
            hashMap = new HashMap();
            if (this.g >= 11) {
                z = true;
            }
            hashMap.put("dpl_probability_jump", Boolean.valueOf(z));
        }
        return a(this.b, this.a.c(), c(), this.c, (Map<String, Object>) hashMap);
    }

    public static boolean a(q qVar, String str, Context context, String str2, Map<String, Object> map) {
        Intent a;
        if (qVar != null && qVar.ap() == 0) {
            return false;
        }
        try {
            if (TextUtils.isEmpty(str) || (a = ac.a(context, str)) == null) {
                return false;
            }
            a.putExtra("START_ONLY_FOR_ANDROID", true);
            if (!(context instanceof Activity)) {
                a.addFlags(268435456);
            }
            context.startActivity(a);
            if (map == null) {
                map = new HashMap<>();
            }
            a(qVar, map);
            c.a(qVar, str2, "click_open", map);
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    private static void a(q qVar, Map<String, Object> map) {
        if (map != null) {
            if (qVar != null && qVar.be() == 0) {
                map.put("auto_click", Boolean.valueOf(qVar != null && !qVar.c()));
            }
            map.put("can_query_install", 0);
        }
    }

    public boolean b() {
        d.a(this.b, this.c, 1, (JSONObject) null);
        if (this.b.ab() != null) {
            HashMap hashMap = new HashMap();
            if (this.b != null && this.b.be() == 0) {
                hashMap.put("dpl_probability_jump", Boolean.valueOf(this.g >= 11));
            }
            if (a(this.b.ab().a(), c(), this.c, this.b, (Map<String, Object>) hashMap)) {
                return true;
            }
            if (!this.d || this.f.get()) {
                this.d = true;
                a(this.b, hashMap);
                c.a(this.b, this.c, "open_fallback_url", (Map<String, Object>) hashMap);
            }
        } else {
            d.a(this.b, this.c, -1, (JSONObject) null);
        }
        return false;
    }

    public static boolean a(String str, Context context, String str2, q qVar, Map<String, Object> map) {
        Intent intent = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                Uri parse = Uri.parse(str);
                Intent intent2 = new Intent("android.intent.action.VIEW");
                try {
                    intent2.setData(parse);
                    if (!(context instanceof Activity)) {
                        intent2.addFlags(268435456);
                    }
                    if (map == null) {
                        map = new HashMap<>();
                    }
                    a(qVar, map);
                    map.put("url", str);
                    c.a(qVar, str2, "open_url_app", map);
                    context.startActivity(intent2);
                    l.a().a(map).a(qVar, str2);
                    c.a("dp_start_act_success", qVar, str2, map);
                    return true;
                } catch (Throwable th) {
                    th = th;
                    intent = intent2;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("exception", th.getMessage());
                        if (intent != null) {
                            jSONObject.put("intent", intent.toString());
                        }
                        jSONObject.put("can_query_install", 0);
                    } catch (Exception unused) {
                    }
                    d.a(qVar, str2, -4, jSONObject);
                    return false;
                }
            } else {
                d.a(qVar, str2, -2, (JSONObject) null);
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
