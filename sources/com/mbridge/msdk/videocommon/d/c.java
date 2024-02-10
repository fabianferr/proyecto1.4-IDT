package com.mbridge.msdk.videocommon.d;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.videocommon.b.b;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RewardUnitSetting */
public final class c {
    private static h H;
    public static String a;
    private int A = 70;
    private int B = 0;
    private int C = -1;
    private int D = -1;
    private int E = -1;
    private int F;
    private int G = 20;
    private int I;
    private int J = 0;
    private int K = 1;
    private String L = "";
    private int M = 1;
    private String N = "";
    private int O = 1;
    private String P = "Virtual Item";
    private String Q = "";
    private String R = "";
    private int S = 0;
    private int T = 1;
    private int U = 60;
    private String V = "";
    private JSONArray W;
    private String b;
    private String c;
    private List<b> d;
    private long e;
    private int f = -1;
    private int g = 0;
    private int h = 0;
    private int i = 1;
    private int j = 1;
    private int k = 1;
    private int l = 1;
    private int m = 5;
    private int n = 1;
    private int o = 3;
    private int p = 80;
    private int q = 100;
    private int r = 0;
    private double s = 1.0d;
    private int t = -1;
    private ArrayList<Integer> u;
    private int v = 3;
    private int w = 1;
    private int x = 10;
    private int y = 60;
    private int z = 0;

    public final int a() {
        return this.x;
    }

    public final int b() {
        return this.y;
    }

    public final void a(ArrayList<Integer> arrayList) {
        this.u = arrayList;
    }

    public final int c() {
        return this.z;
    }

    public final void a(int i2) {
        this.z = i2;
    }

    public final int d() {
        return this.B;
    }

    public final void b(int i2) {
        this.B = i2;
    }

    public final int e() {
        return this.C;
    }

    public final void c(int i2) {
        this.C = i2;
    }

    public final int f() {
        return this.D;
    }

    public final void d(int i2) {
        this.D = i2;
    }

    public final int g() {
        return this.E;
    }

    public final void e(int i2) {
        this.E = i2;
    }

    public final int h() {
        return this.f;
    }

    public final int i() {
        return this.h;
    }

    public final String j() {
        return this.V;
    }

    public final String k() {
        return this.Q;
    }

    private void d(String str) {
        this.Q = str;
        com.mbridge.msdk.foundation.controller.b.c.put(this.b, str);
    }

    public final String l() {
        return this.R;
    }

    public final int m() {
        return this.M;
    }

    private void y(int i2) {
        if (i2 <= 0) {
            this.M = 1;
        } else {
            this.M = i2;
        }
    }

    public final String n() {
        return this.P;
    }

    private void e(String str) {
        if (TextUtils.isEmpty(str)) {
            this.P = this.L;
        } else {
            this.P = str;
        }
    }

    public final int o() {
        return this.G;
    }

    public final int p() {
        return this.F;
    }

    public final void f(int i2) {
        this.F = i2;
    }

    public final int q() {
        return this.I;
    }

    public final void g(int i2) {
        this.I = i2;
    }

    public final void h(int i2) {
        this.o = i2;
    }

    public final void i(int i2) {
        this.p = i2;
    }

    public final int r() {
        return this.q;
    }

    public final void j(int i2) {
        this.q = i2;
    }

    public final int s() {
        return this.r;
    }

    public final void k(int i2) {
        this.r = i2;
    }

    public final int t() {
        return this.j;
    }

    public final void l(int i2) {
        this.j = i2;
    }

    public final int u() {
        return this.k;
    }

    public final void m(int i2) {
        this.k = i2;
    }

    public final void n(int i2) {
        this.l = i2;
    }

    public final int v() {
        return this.m;
    }

    public final void o(int i2) {
        this.m = i2;
    }

    public final int w() {
        return this.n;
    }

    public final void p(int i2) {
        this.n = i2;
    }

    public final void q(int i2) {
        this.i = i2;
    }

    public final long x() {
        return this.e;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final List<b> y() {
        return this.d;
    }

    public final void a(List<b> list) {
        this.d = list;
    }

    public final int z() {
        return this.w;
    }

    public final void r(int i2) {
        this.w = i2;
    }

    public final boolean s(int i2) {
        ArrayList<Integer> arrayList = this.u;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return this.u.contains(Integer.valueOf(i2));
    }

    public final String A() {
        return this.c;
    }

    public final void b(String str) {
        this.c = str;
    }

    public final int B() {
        return this.v;
    }

    public final void t(int i2) {
        this.v = i2;
    }

    public final Queue<Integer> C() {
        LinkedList linkedList;
        Exception e2;
        try {
            List<b> list = this.d;
            if (list == null || list.size() <= 0) {
                return null;
            }
            linkedList = new LinkedList();
            int i2 = 0;
            while (i2 < this.d.size()) {
                try {
                    linkedList.add(Integer.valueOf(this.d.get(i2).b()));
                    i2++;
                } catch (Exception e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    return linkedList;
                }
            }
            return linkedList;
        } catch (Exception e4) {
            Exception exc = e4;
            linkedList = null;
            e2 = exc;
            e2.printStackTrace();
            return linkedList;
        }
    }

    public final void u(int i2) {
        this.S = i2;
    }

    public final int D() {
        return this.T;
    }

    public final void v(int i2) {
        this.T = i2;
    }

    public final int E() {
        return this.U;
    }

    public final void w(int i2) {
        this.U = i2;
    }

    public static c c(String str) {
        JSONObject optJSONObject;
        if (H == null) {
            H = h.a(com.mbridge.msdk.foundation.controller.b.d().g());
        }
        c cVar = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("vtag", "");
                String optString2 = jSONObject.optString("rid", "");
                JSONArray optJSONArray = jSONObject.optJSONArray("unitSetting");
                if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                    return null;
                }
                String optString3 = optJSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                if (TextUtils.isEmpty(optString3)) {
                    return null;
                }
                c cVar2 = new c();
                try {
                    cVar2.V = optString;
                    cVar2.R = optString2;
                    List<b> a2 = b.a(optJSONObject.optJSONArray("adSourceList"));
                    cVar2.b = optString3;
                    cVar2.d = a2;
                    cVar2.i = optJSONObject.optInt("callbackType");
                    int optInt = optJSONObject.optInt("aqn", 1);
                    if (optInt <= 0) {
                        optInt = 1;
                    }
                    cVar2.j = optInt;
                    int optInt2 = optJSONObject.optInt("acn", 1);
                    if (optInt2 < 0) {
                        optInt2 = 1;
                    }
                    cVar2.k = optInt2;
                    cVar2.l = optJSONObject.optInt("vcn", 5);
                    cVar2.m = optJSONObject.optInt(TypedValues.CycleType.S_WAVE_OFFSET, 5);
                    cVar2.n = optJSONObject.optInt("dlnet", 1);
                    cVar2.I = optJSONObject.optInt("endscreen_type", 2);
                    int i2 = 3;
                    cVar2.o = optJSONObject.optInt("tv_start", 3);
                    cVar2.p = optJSONObject.optInt("tv_end", 80);
                    cVar2.q = optJSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                    cVar2.r = optJSONObject.optInt("cd_rate", 0);
                    cVar2.e = jSONObject.optLong("current_time");
                    cVar2.z = optJSONObject.optInt(AdUnitActivity.EXTRA_ORIENTATION, 0);
                    cVar2.B = optJSONObject.optInt("daily_play_cap", 0);
                    cVar2.C = optJSONObject.optInt("video_skip_time", -1);
                    cVar2.D = optJSONObject.optInt("video_skip_result", 2);
                    cVar2.E = optJSONObject.optInt("video_interactive_type", -1);
                    cVar2.F = optJSONObject.optInt("close_button_delay", 1);
                    cVar2.f = optJSONObject.optInt("playclosebtn_tm", -1);
                    cVar2.g = optJSONObject.optInt("play_ctdown", 0);
                    cVar2.h = optJSONObject.optInt("close_alert", 0);
                    cVar2.G = optJSONObject.optInt("rdrct", 20);
                    cVar2.A = optJSONObject.optInt("load_global_timeout", 70);
                    cVar2.t = optJSONObject.optInt("rfpv", -1);
                    cVar2.s = optJSONObject.optDouble("vdcmp", 1.0d);
                    a = optJSONObject.optString("atzu");
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("atl_type");
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    if (optJSONArray2 != null) {
                        int i3 = 0;
                        while (i3 < optJSONArray2.length()) {
                            try {
                                arrayList.add(Integer.valueOf(optJSONArray2.getInt(i3)));
                                i3++;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    } else {
                        arrayList.add(4);
                        arrayList.add(6);
                    }
                    cVar2.u = arrayList;
                    int optInt3 = optJSONObject.optInt("atl_dyt", 0);
                    if (optInt3 > 0) {
                        i2 = optInt3;
                    }
                    cVar2.v = i2;
                    int optInt4 = optJSONObject.optInt("tmorl", 1);
                    if (optInt4 > 2 || optInt4 <= 0) {
                        optInt4 = 1;
                    }
                    cVar2.w = optInt4;
                    cVar2.c = optJSONObject.optString("placementid");
                    cVar2.x = optJSONObject.optInt("ltafemty", 10);
                    cVar2.y = optJSONObject.optInt("ltorwc", 60);
                    cVar2.d(optJSONObject.optString("ab_id"));
                    cVar2.J = optJSONObject.optInt(RewardPlus.AMOUNT_MAX, 0);
                    cVar2.K = optJSONObject.optInt(RewardPlus.CALLBACK_RULE, 1);
                    cVar2.L = optJSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, "");
                    cVar2.y(optJSONObject.optInt("amount", 1));
                    cVar2.N = optJSONObject.optString(RewardPlus.ICON, "");
                    cVar2.O = optJSONObject.optInt(RewardPlus.CURRENCY_ID, 1);
                    cVar2.e(optJSONObject.optString("name", "Virtual Item"));
                    cVar2.T = optJSONObject.optInt("video_error_rule", 1);
                    cVar2.U = optJSONObject.optInt("loadtmo", 60);
                    cVar2.W = optJSONObject.optJSONArray("local_cache_info");
                    return cVar2;
                } catch (Exception e3) {
                    e = e3;
                    cVar = cVar2;
                    e.printStackTrace();
                    return cVar;
                }
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                return cVar;
            }
        }
        return cVar;
    }

    public final JSONObject F() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.b);
            jSONObject.put("callbackType", this.i);
            List<b> list = this.d;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (b next : this.d) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", next.a());
                    jSONObject2.put("timeout", next.b());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            jSONObject.put("aqn", this.j);
            jSONObject.put("acn", this.k);
            jSONObject.put("vcn", this.l);
            jSONObject.put(TypedValues.CycleType.S_WAVE_OFFSET, this.m);
            jSONObject.put("dlnet", this.n);
            jSONObject.put("tv_start", this.o);
            jSONObject.put("tv_end", this.p);
            jSONObject.put(CampaignEx.JSON_KEY_READY_RATE, this.q);
            jSONObject.put("endscreen_type", this.I);
            jSONObject.put("daily_play_cap", this.B);
            jSONObject.put("video_skip_time", this.C);
            jSONObject.put("video_skip_result", this.D);
            jSONObject.put("video_interactive_type", this.E);
            jSONObject.put(AdUnitActivity.EXTRA_ORIENTATION, this.z);
            jSONObject.put("close_button_delay", this.F);
            jSONObject.put("playclosebtn_tm", this.f);
            jSONObject.put("play_ctdown", this.g);
            jSONObject.put("close_alert", this.h);
            jSONObject.put("rfpv", this.t);
            jSONObject.put("vdcmp", this.s);
            JSONArray jSONArray2 = new JSONArray();
            ArrayList<Integer> arrayList = this.u;
            if (arrayList != null) {
                if (arrayList.size() > 0) {
                    Iterator<Integer> it = this.u.iterator();
                    while (it.hasNext()) {
                        jSONArray2.put(it.next());
                    }
                }
                jSONObject.put("atl_type", jSONArray2);
            }
            jSONObject.put("atl_dyt", this.v);
            jSONObject.put("tmorl", this.w);
            jSONObject.put("placementid", this.c);
            jSONObject.put("ltafemty", this.x);
            jSONObject.put("ltorwc", this.y);
            jSONObject.put(RewardPlus.AMOUNT_MAX, this.J);
            jSONObject.put(RewardPlus.CALLBACK_RULE, this.K);
            jSONObject.put(RewardPlus.VIRTUAL_CURRENCY, this.L);
            jSONObject.put("amount", this.M);
            jSONObject.put(RewardPlus.ICON, this.N);
            jSONObject.put(RewardPlus.CURRENCY_ID, this.O);
            jSONObject.put("name", this.P);
            jSONObject.put("isDefault", this.S);
            jSONObject.put("video_error_rule", this.T);
            jSONObject.put("loadtmo", this.U);
            jSONObject.put("vtag", this.V);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static c a(JSONObject jSONObject) {
        c cVar = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            c cVar2 = new c();
            try {
                cVar2.d = b.a(jSONObject.optJSONArray("adSourceList"));
                cVar2.i = jSONObject.optInt("callbackType");
                int optInt = jSONObject.optInt("aqn", 1);
                if (optInt <= 0) {
                    optInt = 1;
                }
                cVar2.j = optInt;
                int optInt2 = jSONObject.optInt("acn", 1);
                if (optInt2 < 0) {
                    optInt2 = 1;
                }
                cVar2.k = optInt2;
                cVar2.l = jSONObject.optInt("vcn", 5);
                cVar2.m = jSONObject.optInt(TypedValues.CycleType.S_WAVE_OFFSET, 5);
                cVar2.n = jSONObject.optInt("dlnet", 1);
                cVar2.I = jSONObject.optInt("endscreen_type", 2);
                cVar2.o = jSONObject.optInt("tv_start", 3);
                cVar2.p = jSONObject.optInt("tv_end", 80);
                cVar2.q = jSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                cVar2.e = jSONObject.optLong("current_time");
                cVar2.z = jSONObject.optInt(AdUnitActivity.EXTRA_ORIENTATION, 0);
                cVar2.B = jSONObject.optInt("daily_play_cap", 0);
                cVar2.C = jSONObject.optInt("video_skip_time", -1);
                cVar2.D = jSONObject.optInt("video_skip_result", 2);
                cVar2.E = jSONObject.optInt("video_interactive_type", -1);
                cVar2.F = jSONObject.optInt("close_button_delay", 1);
                cVar2.f = jSONObject.optInt("playclosebtn_tm", -1);
                cVar2.g = jSONObject.optInt("play_ctdown", 0);
                cVar2.h = jSONObject.optInt("close_alert", 0);
                cVar2.G = jSONObject.optInt("rdrct", 20);
                cVar2.t = jSONObject.optInt("rfpv", -1);
                cVar2.s = jSONObject.optDouble("vdcmp", 1.0d);
                cVar2.A = jSONObject.optInt("load_global_timeout", 70);
                JSONArray optJSONArray = jSONObject.optJSONArray("atl_type");
                ArrayList<Integer> arrayList = new ArrayList<>();
                if (optJSONArray != null) {
                    int i2 = 0;
                    while (i2 < optJSONArray.length()) {
                        try {
                            arrayList.add(Integer.valueOf(optJSONArray.getInt(i2)));
                            i2++;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } else {
                    arrayList.add(4);
                    arrayList.add(6);
                }
                cVar2.u = arrayList;
                cVar2.v = jSONObject.optInt("atl_dyt", 3);
                int optInt3 = jSONObject.optInt("tmorl", 1);
                if (optInt3 > 2 || optInt3 <= 0) {
                    optInt3 = 1;
                }
                cVar2.w = optInt3;
                cVar2.c = jSONObject.optString("placementid");
                cVar2.x = jSONObject.optInt("ltafemty", 10);
                cVar2.y = jSONObject.optInt("ltorwc", 60);
                cVar2.d(jSONObject.optString("ab_id"));
                cVar2.J = jSONObject.optInt(RewardPlus.AMOUNT_MAX, 0);
                cVar2.K = jSONObject.optInt(RewardPlus.CALLBACK_RULE, 1);
                cVar2.L = jSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, "");
                cVar2.y(jSONObject.optInt("amount", 1));
                cVar2.N = jSONObject.optString(RewardPlus.ICON, "");
                cVar2.O = jSONObject.optInt(RewardPlus.CURRENCY_ID, 1);
                cVar2.e(jSONObject.optString("name", "Virtual Item"));
                cVar2.T = jSONObject.optInt("video_error_rule", 1);
                cVar2.U = jSONObject.optInt("loadtmo", 60);
                cVar2.V = jSONObject.optString("vtag", "");
                cVar2.R = jSONObject.optString("rid", "");
                cVar2.W = jSONObject.optJSONArray("local_cache_info");
                return cVar2;
            } catch (Exception e3) {
                e = e3;
                cVar = cVar2;
                e.printStackTrace();
                return cVar;
            }
        } catch (Exception e4) {
            e = e4;
            e.printStackTrace();
            return cVar;
        }
    }

    public final int G() {
        return this.A;
    }

    public final void x(int i2) {
        this.A = i2;
    }

    public final JSONArray H() {
        return this.W;
    }
}
