package com.mbridge.msdk.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.r;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.reward.b.a;
import com.mbridge.msdk.video.bt.module.b.g;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class MBRewardVideoHandler implements BaseExtraInterfaceForHandler {
    private static final String AD_TYPE = "rv";
    private static final String TAG = "MBRewardVideoHandler";
    private a controller;
    private String unitId;

    public MBRewardVideoHandler(Context context, String str, String str2) {
        if (b.d().g() == null && context != null) {
            b.d().b(context);
        }
        String g = af.g(str2);
        if (!TextUtils.isEmpty(g)) {
            af.a(str2, g);
        }
        initMBRewardVideoHandler(str, str2);
    }

    public MBRewardVideoHandler(String str, String str2) {
        String g = af.g(str2);
        if (!TextUtils.isEmpty(g)) {
            af.a(str2, g);
        }
        initMBRewardVideoHandler(str, str2);
    }

    private void initMBRewardVideoHandler(String str, String str2) {
        this.unitId = str2;
        try {
            if (this.controller == null) {
                a aVar = new a();
                this.controller = aVar;
                aVar.a(false);
            }
            this.controller.b(str, str2);
        } catch (Throwable th) {
            aa.b(TAG, th.getMessage(), th);
        }
    }

    public void load() {
        HashMap hashMap = new HashMap();
        try {
            String md5 = SameMD5.getMD5(af.c());
            r.a("2000123", this.unitId, md5, "reward_load", 94);
            hashMap.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, md5);
        } catch (Exception unused) {
        }
        r.a().a(this.unitId, "rv", false);
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(true, (Map<String, String>) hashMap);
        }
    }

    public void loadFormSelfFilling() {
        HashMap hashMap = new HashMap();
        try {
            String md5 = SameMD5.getMD5(af.c());
            hashMap.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, md5);
            r.a("2000123", this.unitId, md5, "self_load", 94);
        } catch (Exception unused) {
        }
        r.a().a(this.unitId, "rv", false);
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(false, (Map<String, String>) hashMap);
        }
    }

    public boolean isReady() {
        a aVar = this.controller;
        if (aVar == null) {
            return false;
        }
        boolean d = aVar.d(false);
        if (d) {
            r.a().d(this.unitId, "rv", false);
        } else {
            r.a().e(this.unitId, "rv", false);
        }
        r.a().e(this.unitId, "rv", false);
        return d;
    }

    public String getRequestId() {
        a aVar = this.controller;
        return aVar != null ? aVar.a() : "";
    }

    public String getCreativeIdWithUnitId() {
        a aVar = this.controller;
        return aVar != null ? aVar.b() : "";
    }

    public void show() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(CampaignEx.JSON_KEY_HB, "0");
            m.a().b("2000128", "reward_show", this.unitId, "94", hashMap);
        } catch (Exception unused) {
        }
        r.a().f(this.unitId, "rv", false);
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a((String) null, (String) null, (String) null);
        }
    }

    public void show(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(CampaignEx.JSON_KEY_HB, "0");
            m.a().b("2000128", "reward_show", this.unitId, "94", hashMap);
        } catch (Exception unused) {
        }
        r.a().f(this.unitId, "rv", false);
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a((String) null, str, (String) null);
        }
    }

    public void show(String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(CampaignEx.JSON_KEY_HB, "0");
            m.a().b("2000128", "reward_show", this.unitId, "94", hashMap);
        } catch (Exception unused) {
        }
        r.a().f(this.unitId, "rv", false);
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a((String) null, str, str2);
        }
    }

    public void setRewardVideoListener(g gVar) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a((InterVideoOutListener) new com.mbridge.msdk.video.bt.module.b.a(gVar));
        }
    }

    public void clearVideoCache() {
        try {
            if (this.controller != null) {
                y.a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playVideoMute(int i) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(str, str2, str3, str4);
        }
    }

    public void setRewardPlus(boolean z) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.c(z);
        }
    }

    public void clearBitmapCache() {
        try {
            com.mbridge.msdk.foundation.same.c.b.a(b.d().g()).a();
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
        }
    }

    public void setExtraInfo(JSONObject jSONObject) {
        b.d().a(this.unitId, jSONObject);
    }
}
