package com.mbridge.msdk.video.module.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.h.b;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.out.MBConfiguration;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import org.json.JSONObject;

/* compiled from: VideoViewRequest */
public final class a extends b {
    public a(Context context) {
        super(context);
    }

    public final void addExtraParams(String str, d dVar) {
        super.addExtraParams(str, dVar);
        dVar.a("platform", "1");
        dVar.a("os_version", Build.VERSION.RELEASE);
        dVar.a(CampaignEx.JSON_KEY_PACKAGE_NAME, w.o(this.mContext));
        dVar.a("app_version_name", w.j(this.mContext));
        dVar.a("app_version_code", w.i(this.mContext) + "");
        dVar.a(AdUnitActivity.EXTRA_ORIENTATION, w.h(this.mContext) + "");
        dVar.a("model", w.i());
        dVar.a("brand", w.k());
        dVar.a(ThroughputConfigUtil.SHARED_PREFS_KEY_MNC, w.e(this.mContext));
        dVar.a(ThroughputConfigUtil.SHARED_PREFS_KEY_MCC, w.d(this.mContext));
        dVar.a("gaid", "");
        dVar.a("gaid2", w.c());
        int r = w.r(this.mContext);
        dVar.a("network_type", r + "");
        dVar.a("network_str", w.a(this.mContext, r) + "");
        dVar.a("language", w.g(this.mContext));
        dVar.a("timezone", w.m());
        dVar.a("useragent", w.l());
        dVar.a("sdk_version", MBConfiguration.SDK_VERSION);
        dVar.a("screen_size", w.l(this.mContext) + "x" + w.m(this.mContext));
        if (f.a().b(com.mbridge.msdk.foundation.controller.b.d().h()) != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(jSONObject.toString())) {
                    String a = u.a(jSONObject.toString());
                    if (!TextUtils.isEmpty(a)) {
                        dVar.a("dvi", a);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
