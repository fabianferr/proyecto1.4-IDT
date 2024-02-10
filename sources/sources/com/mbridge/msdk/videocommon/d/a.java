package com.mbridge.msdk.videocommon.d;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.videocommon.b.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RewardSetting */
public class a {
    private Map<String, Integer> a;
    private Map<String, c> b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private String i;
    private int j = 0;
    private String k = "";
    private String l = "";

    public final String a() {
        return this.k;
    }

    public final String b() {
        return this.i;
    }

    public final String c() {
        return this.l;
    }

    public final long d() {
        return this.c * 1000;
    }

    public final void a(long j2) {
        this.c = j2;
    }

    public final long e() {
        return this.d * 1000;
    }

    public final void b(long j2) {
        this.d = j2;
    }

    public final long f() {
        return this.e * 1000;
    }

    public final void c(long j2) {
        this.e = j2;
    }

    public final long g() {
        return this.f;
    }

    public final void d(long j2) {
        this.f = j2;
    }

    public final long h() {
        return this.g;
    }

    public final void e(long j2) {
        this.g = j2;
    }

    public final void a(int i2) {
        this.j = i2;
    }

    public final long i() {
        return this.h;
    }

    public final Map<String, Integer> j() {
        if (this.a == null) {
            HashMap hashMap = new HashMap();
            this.a = hashMap;
            hashMap.put("1", 1000);
            this.a.put("9", 1000);
            this.a.put("8", 1000);
        }
        return this.a;
    }

    public final void a(Map<String, Integer> map) {
        this.a = map;
    }

    public final Map<String, c> k() {
        return this.b;
    }

    public final void b(Map<String, c> map) {
        this.b = map;
    }

    public static a a(String str) {
        a aVar = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                a aVar2 = new a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject optJSONObject = jSONObject.optJSONObject("caplist");
                    aVar2.i = jSONObject.optString("ab_id", "");
                    aVar2.l = jSONObject.optString("rid", "");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        HashMap hashMap = new HashMap();
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            int intValue = Integer.valueOf(optJSONObject.optInt(next, 1000)).intValue();
                            if (!TextUtils.isEmpty(next)) {
                                if (TextUtils.isEmpty(next) || intValue != 0) {
                                    hashMap.put(next, Integer.valueOf(intValue));
                                } else {
                                    hashMap.put(next, 1000);
                                }
                            }
                        }
                        aVar2.a = hashMap;
                    }
                    aVar2.b = c.a(jSONObject.optJSONArray(com.wortise.ads.events.modules.c.EXTRA_REWARD));
                    aVar2.c = jSONObject.optLong("getpf", 43200);
                    aVar2.d = jSONObject.optLong("ruct", 5400);
                    aVar2.e = jSONObject.optLong(CampaignEx.JSON_KEY_PLCT, 3600);
                    aVar2.f = jSONObject.optLong("dlct", 3600);
                    aVar2.g = jSONObject.optLong("vcct", 5);
                    aVar2.h = jSONObject.optLong("current_time");
                    aVar2.k = jSONObject.optString("vtag", "");
                    return aVar2;
                } catch (Exception e2) {
                    e = e2;
                    aVar = aVar2;
                    e.printStackTrace();
                    return aVar;
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                return aVar;
            }
        }
        return aVar;
    }

    public final JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            Map<String, Integer> map = this.a;
            if (map != null && map.size() > 0) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry next : this.a.entrySet()) {
                        jSONObject2.put((String) next.getKey(), ((Integer) next.getValue()).intValue());
                    }
                    jSONObject.put("caplist", jSONObject2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            Map<String, c> map2 = this.b;
            if (map2 != null && map2.size() > 0) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry next2 : this.b.entrySet()) {
                        JSONObject jSONObject3 = new JSONObject();
                        String str = (String) next2.getKey();
                        c cVar = (c) next2.getValue();
                        if (cVar != null) {
                            jSONObject3.put("name", cVar.a());
                            jSONObject3.put("amount", cVar.b());
                            jSONObject3.put("id", str);
                        }
                        jSONArray.put(jSONObject3);
                    }
                    jSONObject.put(com.wortise.ads.events.modules.c.EXTRA_REWARD, jSONArray);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            jSONObject.put("getpf", this.c);
            jSONObject.put("ruct", this.d);
            jSONObject.put(CampaignEx.JSON_KEY_PLCT, this.e);
            jSONObject.put("dlct", this.f);
            jSONObject.put("vcct", this.g);
            jSONObject.put("current_time", this.h);
            jSONObject.put("vtag", this.k);
            jSONObject.put("isDefault", this.j);
            return jSONObject;
        } catch (Exception e4) {
            e4.printStackTrace();
            return jSONObject;
        }
    }
}
