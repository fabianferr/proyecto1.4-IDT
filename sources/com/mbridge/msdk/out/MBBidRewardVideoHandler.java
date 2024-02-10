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

public class MBBidRewardVideoHandler implements BaseExtraInterfaceForHandler {
    private static final String AD_TYPE = "rv";
    private static final String TAG = "MBBidRewardVideoHandler";
    private a controller;
    private String unitId;

    public MBBidRewardVideoHandler(Context context, String str, String str2) {
        if (b.d().g() == null && context != null) {
            b.d().b(context);
        }
        String g = af.g(str2);
        if (!TextUtils.isEmpty(g)) {
            af.a(str2, g);
        }
        initMBBidRewardVideoHandler(str, str2);
    }

    public MBBidRewardVideoHandler(String str, String str2) {
        String g = af.g(str2);
        if (!TextUtils.isEmpty(g)) {
            af.a(str2, g);
        }
        initMBBidRewardVideoHandler(str, str2);
    }

    private void initMBBidRewardVideoHandler(String str, String str2) {
        this.unitId = str2;
        try {
            if (this.controller == null) {
                a aVar = new a();
                this.controller = aVar;
                aVar.a(false);
                this.controller.b(true);
            }
            this.controller.b(str, str2);
        } catch (Throwable th) {
            aa.b(TAG, th.getMessage(), th);
        }
    }

    public void loadFromBid(String str) {
        HashMap hashMap = new HashMap();
        reportLoadEvent(str, hashMap);
        r.a().a(this.unitId, "rv", true);
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(true, str, (Map<String, String>) hashMap);
        }
    }

    private void reportLoadEvent(String str, Map<String, String> map) {
        String str2;
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("_");
                str2 = (split == null || split.length < 3) ? str : split[2];
            } else {
                str2 = SameMD5.getMD5(af.c());
            }
            String str3 = str2;
            map.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, str3);
            r.a(str, "2000123", this.unitId, str3, "hb_reward_load", 94);
        } catch (Exception unused) {
        }
    }

    public boolean isBidReady() {
        a aVar = this.controller;
        if (aVar != null) {
            boolean d = aVar.d(false);
            if (d) {
                r.a().d(this.unitId, "rv", true);
            } else {
                r.a().e(this.unitId, "rv", true);
            }
            return d;
        }
        r.a().e(this.unitId, "rv", true);
        return false;
    }

    public String getRequestId() {
        a aVar = this.controller;
        return aVar != null ? aVar.a() : "";
    }

    public String getCreativeIdWithUnitId() {
        a aVar = this.controller;
        return aVar != null ? aVar.b() : "";
    }

    public void showFromBid() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(CampaignEx.JSON_KEY_HB, "1");
            m.a().b("2000128", "hb_reward_show", this.unitId, "94", hashMap);
        } catch (Exception unused) {
        }
        r.a().f(this.unitId, "rv", true);
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a((String) null, (String) null, (String) null);
        }
    }

    public void showFromBid(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(CampaignEx.JSON_KEY_HB, "1");
            m.a().b("2000128", "hb_reward_show", this.unitId, "94", hashMap);
        } catch (Exception unused) {
        }
        r.a().f(this.unitId, "rv", true);
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a((String) null, str, (String) null);
        }
    }

    public void showFromBid(String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(CampaignEx.JSON_KEY_HB, "1");
            m.a().b("2000128", "hb_reward_show", this.unitId, "94", hashMap);
        } catch (Exception unused) {
        }
        r.a().f(this.unitId, "rv", true);
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

    public void setExtraInfo(JSONObject jSONObject) {
        b.d().a(this.unitId, jSONObject);
    }
}
