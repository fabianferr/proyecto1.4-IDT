package com.mbridge.msdk.videocommon.c;

import android.content.Context;
import android.os.Build;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.mbridge.msdk.foundation.same.net.h.e;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.out.MBConfiguration;
import com.unity3d.services.ads.adunit.AdUnitActivity;

/* compiled from: RewardSettingRequest */
public final class b extends com.mbridge.msdk.foundation.same.net.h.b {
    public b(Context context) {
        super(context);
    }

    public final void addExtraParams(String str, d dVar) {
        try {
            super.addExtraParams(str, dVar);
            dVar.a("platform", "1");
            dVar.a("os_version", Build.VERSION.RELEASE);
            dVar.a(CampaignEx.JSON_KEY_PACKAGE_NAME, w.o(this.mContext));
            dVar.a("app_version_name", w.j(this.mContext));
            dVar.a("app_version_code", w.i(this.mContext) + "");
            dVar.a(AdUnitActivity.EXTRA_ORIENTATION, w.h(this.mContext) + "");
            dVar.a("model", w.i());
            dVar.a("brand", w.k());
            dVar.a("gaid", w.a());
            int r = w.r(this.mContext);
            dVar.a("network_type", r + "");
            dVar.a("network_str", w.a(this.mContext, r) + "");
            dVar.a("language", w.g(this.mContext));
            dVar.a("timezone", w.m());
            dVar.a("useragent", w.l());
            dVar.a("sdk_version", MBConfiguration.SDK_VERSION);
            dVar.a("screen_size", w.l(this.mContext) + "x" + w.m(this.mContext));
            e.d(dVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
