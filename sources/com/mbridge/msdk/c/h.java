package com.mbridge.msdk.c;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: UnitSetting */
public final class h {
    private int A;
    private int B;
    private int C;
    private String D = "";
    private int E = 10;
    private int F = 60;
    private String G = "";
    private String H = "";
    private String I = "";
    private int J = 1;
    private int K = 100;
    private int L = 0;
    private int M;
    private int N;
    private int a;
    private int b;
    private int c;
    private int d = 30;
    private String e;
    private String f;
    private List<Integer> g;
    private long h;
    private int i = 1;
    private List<Integer> j;
    private int k;
    private int l;
    private int m;
    private int n;
    private String o;
    private int p;
    private int q = 1;
    private int r = 5000;
    private int s;
    private int t;
    private long u;
    private String v;
    private int w;
    private long x;
    private long y;
    private int z = 60;

    public final String a() {
        return this.G;
    }

    public final String b() {
        return this.I;
    }

    public final void a(int i2) {
        this.B = i2;
    }

    public final void b(int i2) {
        this.C = i2;
    }

    public final int c() {
        return this.z;
    }

    public final int d() {
        return this.A;
    }

    public final int e() {
        return this.N;
    }

    public final int f() {
        return this.K;
    }

    public final int g() {
        return this.L;
    }

    public final int h() {
        return this.M;
    }

    public final long i() {
        return this.u;
    }

    public final int j() {
        return this.s;
    }

    public final void c(int i2) {
        this.s = i2;
    }

    public final int k() {
        return this.t;
    }

    public static h l() {
        return new h();
    }

    public final int m() {
        return this.n;
    }

    public final int n() {
        return this.q;
    }

    public final int o() {
        return this.r;
    }

    public final int p() {
        return this.l;
    }

    public final int q() {
        return this.m;
    }

    public final String toString() {
        List<Integer> list = this.g;
        String str = "";
        if (list != null && list.size() > 0) {
            for (Integer num : this.g) {
                str = str + num + ",";
            }
        }
        return "offset = " + this.i + " unitId = " + this.e + " fbPlacementId = " + this.f + str;
    }

    public final void a(String str) {
        this.e = str;
    }

    public final List<Integer> r() {
        return this.g;
    }

    public final List<Integer> s() {
        return this.j;
    }

    public static h b(String str) {
        h hVar = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            h hVar2 = new h();
            try {
                JSONObject jSONObject = new JSONObject(str);
                hVar2.e = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                String optString = jSONObject.optString("ab_id");
                hVar2.G = optString;
                b.c.put(hVar2.e, optString);
                hVar2.I = jSONObject.optString("rid");
                JSONArray optJSONArray = jSONObject.optJSONArray("adSourceList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        arrayList.add(Integer.valueOf(optJSONArray.optInt(i2)));
                    }
                    hVar2.g = arrayList;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("ad_source_timeout");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        arrayList2.add(Integer.valueOf(optJSONArray2.optInt(i3)));
                    }
                    hVar2.j = arrayList2;
                }
                hVar2.k = jSONObject.optInt("tpqn");
                hVar2.l = jSONObject.optInt("aqn");
                hVar2.m = jSONObject.optInt("acn");
                hVar2.n = jSONObject.optInt("wt");
                int i4 = 1;
                hVar2.q = jSONObject.optInt("iscasf", 1);
                hVar2.r = jSONObject.optInt("spmxrt", 5000);
                hVar2.h = jSONObject.optLong("current_time");
                hVar2.i = jSONObject.optInt(TypedValues.CycleType.S_WAVE_OFFSET);
                hVar2.u = jSONObject.optLong("dlct", 3600);
                hVar2.s = jSONObject.optInt("autoplay", 0);
                hVar2.t = jSONObject.optInt("dlnet", 2);
                hVar2.v = jSONObject.optString("no_offer");
                hVar2.w = jSONObject.optInt("cb_type");
                hVar2.x = jSONObject.optLong("clct", 86400);
                hVar2.y = jSONObject.optLong("clcq", 300);
                hVar2.K = jSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                hVar2.L = jSONObject.optInt("cd_rate", 0);
                hVar2.M = jSONObject.optInt("content", 1);
                hVar2.N = jSONObject.optInt("impt", 0);
                hVar2.p = jSONObject.optInt("icon_type", 1);
                hVar2.o = jSONObject.optString("no_ads_url", "");
                hVar2.a = jSONObject.optInt("playclosebtn_tm", -1);
                hVar2.b = jSONObject.optInt("play_ctdown", 0);
                hVar2.c = jSONObject.optInt("close_alert", 0);
                hVar2.d = jSONObject.optInt("intershowlimit", 30);
                hVar2.z = jSONObject.optInt("refreshFq", 60);
                hVar2.A = jSONObject.optInt("closeBtn", 0);
                int optInt = jSONObject.optInt("tmorl", 1);
                if (optInt <= 2) {
                    if (optInt > 0) {
                        i4 = optInt;
                    }
                }
                hVar2.J = i4;
                hVar2.D = jSONObject.optString("placementid", "");
                hVar2.E = jSONObject.optInt("ltafemty", 10);
                hVar2.F = jSONObject.optInt("ltorwc", 60);
                hVar2.H = jSONObject.optString("vtag", "");
                return hVar2;
            } catch (Exception e2) {
                e = e2;
                hVar = hVar2;
                e.printStackTrace();
                return hVar;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return hVar;
        }
    }

    public final JSONObject t() {
        JSONObject jSONObject = new JSONObject();
        try {
            List<Integer> list = this.g;
            if (list != null && list.size() > 0) {
                int size = this.g.size();
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < size; i2++) {
                    jSONArray.put(this.g.get(i2));
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            List<Integer> list2 = this.j;
            if (list2 != null && list2.size() > 0) {
                int size2 = this.j.size();
                JSONArray jSONArray2 = new JSONArray();
                for (int i3 = 0; i3 < size2; i3++) {
                    jSONArray2.put(this.j.get(i3));
                }
                jSONObject.put("ad_source_timeout", jSONArray2);
            }
            jSONObject.put("tpqn", this.k);
            jSONObject.put("aqn", this.l);
            jSONObject.put("acn", this.m);
            jSONObject.put("wt", this.n);
            jSONObject.put("current_time", this.h);
            jSONObject.put(TypedValues.CycleType.S_WAVE_OFFSET, this.i);
            jSONObject.put("dlct", this.u);
            jSONObject.put("autoplay", this.s);
            jSONObject.put("dlnet", this.t);
            jSONObject.put("no_offer", this.v);
            jSONObject.put("cb_type", this.w);
            jSONObject.put("clct", this.x);
            jSONObject.put("clcq", this.y);
            jSONObject.put(CampaignEx.JSON_KEY_READY_RATE, this.K);
            jSONObject.put("content", this.M);
            jSONObject.put("impt", this.N);
            jSONObject.put("icon_type", this.p);
            jSONObject.put("no_ads_url", this.o);
            jSONObject.put("playclosebtn_tm", this.a);
            jSONObject.put("play_ctdown", this.b);
            jSONObject.put("close_alert", this.c);
            jSONObject.put("closeBtn", this.A);
            jSONObject.put("refreshFq", this.z);
            jSONObject.put("countdown", this.C);
            jSONObject.put("allowSkip", this.B);
            jSONObject.put("tmorl", this.J);
            jSONObject.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.e);
            jSONObject.put("placementid", this.D);
            jSONObject.put("ltafemty", this.E);
            jSONObject.put("ltorwc", this.F);
            jSONObject.put("vtag", this.H);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public final long u() {
        return this.h;
    }

    public final int v() {
        return this.i;
    }

    public static h c(String str) {
        h l2 = l();
        l2.s = 0;
        return l2;
    }

    public static h d(String str) {
        h hVar = new h();
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(8);
        arrayList2.add(8);
        hVar.i = 1;
        hVar.e = str;
        hVar.g = arrayList;
        hVar.j = arrayList2;
        hVar.k = 1;
        hVar.m = -2;
        hVar.l = -2;
        hVar.n = 5;
        hVar.u = 3600;
        hVar.t = 2;
        hVar.s = 1;
        hVar.K = 100;
        hVar.L = 0;
        hVar.M = 1;
        hVar.N = 0;
        hVar.z = 60;
        hVar.E = 10;
        hVar.F = 60;
        return hVar;
    }

    public static h e(String str) {
        h hVar = new h();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(1);
            hVar.g = arrayList;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(30);
            hVar.j = arrayList2;
            hVar.e = str;
            hVar.i = 1;
            hVar.k = 1;
            hVar.m = -2;
            hVar.l = -2;
            hVar.n = 5;
            hVar.u = 3600;
            hVar.t = 2;
            hVar.s = 3;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return hVar;
    }

    public static h f(String str) {
        h hVar = new h();
        try {
            hVar.e = str;
            hVar.i = 1;
            hVar.k = 1;
            hVar.n = 5;
            hVar.m = 1;
            hVar.l = 1;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return hVar;
    }

    public final void g(String str) {
        this.D = str;
    }

    public final int w() {
        return this.E;
    }

    public final int x() {
        return this.F;
    }

    public final String y() {
        return this.H;
    }
}
