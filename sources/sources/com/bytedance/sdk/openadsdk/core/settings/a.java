package com.bytedance.sdk.openadsdk.core.settings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AdSlotSetter */
public class a {
    public int A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public int F;
    public boolean G;
    public int H;
    public int I;
    public int J;
    public int K;
    public long L;
    public String M;
    public String N;
    public List<g> O;
    public List<g> P;
    public String a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    public int u;
    public List<String> v;
    public int w;
    public int x;
    public int y;
    public int z;

    private static boolean a(int i2) {
        return i2 == 1 || i2 == 2;
    }

    public a(JSONObject jSONObject) {
        String str;
        Object obj;
        String str2;
        Object obj2;
        JSONObject jSONObject2 = jSONObject;
        this.b = 1;
        this.c = 1;
        this.d = 2;
        this.e = 1;
        this.f = 100;
        this.g = 0;
        this.h = 2;
        this.i = 1;
        this.j = 3;
        this.k = 30;
        this.l = 1;
        this.m = 1;
        this.n = 2;
        this.o = 1500;
        this.p = 2;
        this.q = -1;
        this.r = 0;
        this.s = 5;
        this.t = false;
        this.u = 0;
        this.w = 2;
        this.x = -1;
        this.y = 0;
        this.z = 0;
        this.A = 5;
        this.B = true;
        this.C = false;
        this.D = false;
        this.E = 0;
        this.F = -1;
        this.G = false;
        this.H = 60000;
        this.I = 2;
        this.J = 1000;
        this.K = 1;
        this.O = new ArrayList();
        this.P = new ArrayList();
        if (jSONObject2 != null) {
            this.a = jSONObject2.optString("code_id");
            this.b = jSONObject2.optInt("auto_play", 1);
            this.F = jSONObject2.optInt("endcard_close_time", -1);
            this.c = jSONObject2.optInt("voice_control", 1);
            this.d = jSONObject2.optInt("rv_preload", 2);
            this.e = jSONObject2.optInt("nv_preload", 1);
            this.f = jSONObject2.optInt("proportion_watching", 100);
            this.g = jSONObject2.optInt("skip_time_displayed", 0);
            this.h = jSONObject2.optInt("video_skip_result", 2);
            this.i = jSONObject2.optInt("reg_creative_control", 1);
            this.j = jSONObject2.optInt("play_bar_show_time", 3);
            int optInt = jSONObject2.optInt("rv_skip_time", 30);
            this.k = optInt;
            if (optInt < 0) {
                this.k = 30;
            }
            this.l = jSONObject2.optInt("voice_control", 2);
            this.m = jSONObject2.optInt("if_show_win", 1);
            this.n = jSONObject2.optInt("sp_preload", 2);
            this.o = jSONObject2.optInt("stop_time", 1500);
            this.p = jSONObject2.optInt("native_playable_delay", 2);
            this.q = jSONObject2.optInt("time_out_control", -1);
            this.x = jSONObject2.optInt("playable_close_time", -1);
            this.r = jSONObject2.optInt("playable_reward_type", 0);
            this.u = jSONObject2.optInt("reward_is_callback", 0);
            int optInt2 = jSONObject2.optInt("iv_skip_time", 5);
            this.s = optInt2;
            if (optInt2 < 0) {
                this.s = 5;
            }
            a(jSONObject2.optJSONArray("parent_tpl_ids"));
            this.w = jSONObject2.optInt("slot_type", 2);
            this.t = jSONObject2.optBoolean("close_on_click", false);
            this.y = jSONObject2.optInt("allow_system_back", 0);
            this.z = jSONObject2.optInt("splash_skip_time", 0);
            this.A = jSONObject2.optInt("splash_image_count_down_time", 5);
            this.C = jSONObject2.optBoolean("splash_count_down_time_off", false);
            this.D = jSONObject2.optBoolean("splash_close_on_click", false);
            int optInt3 = jSONObject2.optInt("splash_load_strategy", 0);
            this.E = optInt3;
            if (optInt3 < 0 || optInt3 > 1) {
                this.E = 0;
            }
            this.B = jSONObject2.optBoolean("allow_mediaview_click", true);
            int optInt4 = jSONObject2.optInt("total_time_out", 60000);
            this.H = optInt4;
            if (optInt4 <= 0 || optInt4 > 1800000) {
                this.H = 60000;
            }
            int optInt5 = jSONObject2.optInt("req_parallel_num", 2);
            this.I = optInt5;
            if (optInt5 < 1 || optInt5 > 4) {
                this.I = 2;
            }
            this.J = jSONObject2.optInt("bidding_token_tmax", 1000);
            int optInt6 = jSONObject2.optInt("ad_load_type", 1);
            this.K = optInt6;
            if (optInt6 < 1 || optInt6 > 2) {
                this.K = 1;
            }
            boolean optBoolean = jSONObject2.optBoolean("is_mediation", false);
            this.G = optBoolean;
            if (optBoolean) {
                o.ai().ad();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                JSONArray optJSONArray = jSONObject2.optJSONArray("mediation_config");
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    String optString = optJSONObject.optString("adn_name");
                    String optString2 = optJSONObject.optString("adn_slot_id");
                    int optInt7 = optJSONObject.optInt("ad_expired_time", 3600000);
                    int optInt8 = optJSONObject.optInt("req_bidding_type", 2);
                    String optString3 = optJSONObject.optString("rit_cpm");
                    int optInt9 = optJSONObject.optInt("show_sort");
                    int optInt10 = optJSONObject.optInt("layer_time_out", 2000);
                    int i3 = (optInt10 <= 0 || optInt10 > 60000) ? 2000 : optInt10;
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("server_params");
                    if (optInt8 == 2) {
                        if (optJSONObject2 == null) {
                            str2 = "";
                        } else {
                            str2 = optJSONObject2.toString();
                        }
                        new g(optString, optString2, optInt7, optInt8, optString3, optInt9, i3, str2);
                        arrayList.add(obj2);
                    } else if (optInt8 == 0) {
                        if (optJSONObject2 == null) {
                            str = "";
                        } else {
                            str = optJSONObject2.toString();
                        }
                        new g(optString, optString2, optInt7, optInt8, optString3, optInt9, i3, str);
                        arrayList2.add(obj);
                    }
                }
                this.O = arrayList;
                this.P = arrayList2;
                Collections.sort(arrayList);
                Collections.sort(this.P);
            }
            if (!a(this.c)) {
                this.c = 1;
            }
            if (!a(this.l)) {
                this.l = 1;
            }
            this.L = jSONObject2.optLong("waterfall_id");
            String optString4 = jSONObject2.optString("waterfall_version");
            this.M = optString4;
            this.N = optString4;
        }
    }

    public a(String str, int i2) {
        this.b = 1;
        this.c = 1;
        this.d = 2;
        this.e = 1;
        this.f = 100;
        this.g = 0;
        this.h = 2;
        this.i = 1;
        this.j = 3;
        this.k = 30;
        this.l = 1;
        this.m = 1;
        this.n = 2;
        this.o = 1500;
        this.p = 2;
        this.q = -1;
        this.r = 0;
        this.s = 5;
        this.t = false;
        this.u = 0;
        this.w = 2;
        this.x = -1;
        this.y = 0;
        this.z = 0;
        this.A = 5;
        this.B = true;
        this.C = false;
        this.D = false;
        this.E = 0;
        this.F = -1;
        this.G = false;
        this.H = 60000;
        this.I = 2;
        this.J = 1000;
        this.K = 1;
        this.O = new ArrayList();
        this.P = new ArrayList();
        this.a = str;
        this.c = i2;
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            this.v = new ArrayList();
            int i2 = 0;
            while (i2 < jSONArray.length()) {
                try {
                    this.v.add(jSONArray.get(i2).toString());
                    i2++;
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }
}
