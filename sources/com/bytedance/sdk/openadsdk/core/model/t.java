package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.c.b;
import com.bytedance.sdk.component.utils.l;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PlayableModel */
public class t {
    private int a;
    private int b;
    private boolean c;
    private int d;
    private String e;
    private String f;
    private int g;

    public static boolean g(q qVar) {
        return false;
    }

    public t(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("playable");
            if (optJSONObject != null) {
                this.f = optJSONObject.optString("playable_url", "");
                this.g = optJSONObject.optInt("playable_orientation", 0);
                this.b = optJSONObject.optInt("new_style", 0);
                this.a = optJSONObject.optInt("close_2_app", 0);
            }
            this.c = jSONObject.optBoolean("is_playable");
            this.d = jSONObject.optInt("playable_type", 0);
            this.e = jSONObject.optString("playable_style");
        }
    }

    public static int a(q qVar) {
        int i;
        t n = qVar.n();
        if (n != null && (i = n.a) >= 0 && i <= 100) {
            return i;
        }
        return 0;
    }

    public void a(JSONObject jSONObject) {
        try {
            jSONObject.put("is_playable", this.c);
        } catch (JSONException e2) {
            l.e("PlayableModel", e2.getMessage());
        }
        if (!TextUtils.isEmpty(this.f)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("playable_url", this.f);
                jSONObject2.put("playable_orientation", this.g);
                jSONObject2.put("new_style", this.b);
                jSONObject2.put("close_2_app", this.a);
                jSONObject.put("playable", jSONObject2);
            } catch (Exception e3) {
                l.e("PlayableModel", e3.getMessage());
            }
        }
        try {
            jSONObject.put("playable_type", this.d);
        } catch (JSONException e4) {
            l.e("PlayableModel", e4.getMessage());
        }
        try {
            jSONObject.put("playable_style", this.e);
        } catch (JSONException e5) {
            l.e("PlayableModel", e5.getMessage());
        }
    }

    private static t m(q qVar) {
        if (qVar == null) {
            return null;
        }
        return qVar.n();
    }

    public static boolean b(q qVar) {
        t m = m(qVar);
        if (m != null && m.c && !TextUtils.isEmpty(f(qVar))) {
            return true;
        }
        return false;
    }

    public static boolean c(q qVar) {
        t n = qVar.n();
        if (n != null && n.c && n.b == 1) {
            return true;
        }
        return false;
    }

    private static int n(q qVar) {
        t m = m(qVar);
        if (m == null) {
            return 0;
        }
        return m.d;
    }

    public static String d(q qVar) {
        t m = m(qVar);
        if (m == null) {
            return null;
        }
        return m.e;
    }

    public static String e(q qVar) {
        t m = m(qVar);
        if (m == null) {
            return null;
        }
        return m.f;
    }

    public static String f(q qVar) {
        if (qVar == null) {
            return null;
        }
        t n = qVar.n();
        if (n != null && n.c) {
            String str = n.f;
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        if (qVar.o() == 20) {
            return qVar.P();
        }
        if (qVar.K() != null) {
            return qVar.K().l();
        }
        return null;
    }

    public static boolean h(q qVar) {
        if (((qVar == null || qVar.K() == null) ? 0 : qVar.K().t()) != 1) {
            return true;
        }
        return false;
    }

    public static boolean i(q qVar) {
        b K = qVar.K();
        if (K != null && K.t() == 1) {
            return true;
        }
        return false;
    }

    public static int j(q qVar) {
        t m = m(qVar);
        if (m == null) {
            return 0;
        }
        return m.g;
    }

    public static boolean k(q qVar) {
        return b(qVar) && n(qVar) == 1;
    }

    public static boolean l(q qVar) {
        return b(qVar) && n(qVar) == 0;
    }
}
