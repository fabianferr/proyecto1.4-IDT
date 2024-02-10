package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import com.appnext.core.Ad;
import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DomainDeviceInfo */
public class f {
    public String a = w.j();
    public String b = w.n();
    public String c = "android";
    public String d = w.a();
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public int s;
    public int t;
    public int u;
    public String v;
    public int w;
    public int x;

    public f(Context context) {
        int r2 = w.r(context);
        this.e = String.valueOf(r2);
        this.f = w.a(context, r2);
        this.g = w.q(context);
        this.h = b.d().j();
        this.i = b.d().h();
        this.j = String.valueOf(af.i(context));
        this.k = String.valueOf(af.h(context));
        this.o = String.valueOf(af.e(context));
        this.p = b.d().l().toString();
        this.r = w.k();
        this.s = af.f();
        if (context.getResources().getConfiguration().orientation == 2) {
            this.l = Ad.ORIENTATION_LANDSCAPE;
        } else {
            this.l = Ad.ORIENTATION_PORTRAIT;
        }
        this.m = a.l;
        this.n = a.m;
        this.q = w.s();
        this.t = w.v();
        this.u = w.t();
        this.v = w.e();
        this.w = w.b();
        this.x = com.mbridge.msdk.foundation.controller.authoritycontroller.a.h() ? 1 : 0;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put("device", this.a);
                jSONObject.put("system_version", this.b);
                jSONObject.put("network_type", this.e);
                jSONObject.put("network_type_str", this.f);
                jSONObject.put("device_ua", this.g);
                jSONObject.put("has_wx", w.f(b.d().g()));
                jSONObject.put("integrated_wx", w.g());
                jSONObject.put("opensdk_ver", w.h() + "");
                jSONObject.put("wx_api_ver", w.c(b.d().i()) + "");
                jSONObject.put("brand", this.r);
                jSONObject.put(ThroughputConfigUtil.SHARED_PREFS_KEY_MNC, w.e(b.d().g()));
                jSONObject.put(ThroughputConfigUtil.SHARED_PREFS_KEY_MCC, w.d(b.d().g()));
                jSONObject.put("adid_limit", this.w);
                jSONObject.put("adid_limit_dev", this.x);
            }
            jSONObject.put("plantform", this.c);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.put("google_ad_id", this.d);
                jSONObject.put("az_aid_info", this.v);
            }
            jSONObject.put("appkey", this.h);
            jSONObject.put("appId", this.i);
            jSONObject.put("screen_width", this.j);
            jSONObject.put("screen_height", this.k);
            jSONObject.put(AdUnitActivity.EXTRA_ORIENTATION, this.l);
            jSONObject.put("scale", this.o);
            jSONObject.put("b", this.m);
            jSONObject.put("c", this.n);
            jSONObject.put("web_env", this.p);
            jSONObject.put(com.mbridge.msdk.c.f.a, this.q);
            jSONObject.put("misk_spt", this.s);
            if (w.y() != 0) {
                jSONObject.put("tun", w.y());
            }
            String str = d.h;
            jSONObject.put(str, com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().e() + "");
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("dmt", this.t + "");
                jSONObject2.put("dmf", this.u);
                jSONObject2.put("adid_limit", this.w);
                jSONObject2.put("adid_limit_dev", this.x);
                jSONObject.put("dvi", u.a(jSONObject2.toString()));
            }
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.g()) {
                jSONObject.put("dev_source", "2");
            }
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                jSONObject.put("re_domain", "1");
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
