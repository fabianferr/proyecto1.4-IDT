package com.mbridge.msdk.newinterstitial.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.r;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.out.BaseExtraInterfaceForHandler;
import com.mbridge.msdk.reward.b.a;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class MBBidInterstitialVideoHandler implements BaseExtraInterfaceForHandler {
    private a a;
    private String b;

    public MBBidInterstitialVideoHandler(Context context, String str, String str2) {
        if (b.d().g() == null && context != null) {
            b.d().b(context);
        }
        String g = af.g(str2);
        if (!TextUtils.isEmpty(g)) {
            af.a(str2, g);
        }
        a(str, str2);
    }

    public MBBidInterstitialVideoHandler(String str, String str2) {
        a(str, str2);
    }

    private void a(String str, String str2) {
        try {
            this.b = str2;
            if (this.a == null) {
                a aVar = new a();
                this.a = aVar;
                aVar.a(true);
                this.a.b(true);
            }
            this.a.b(str, str2);
        } catch (Throwable th) {
            aa.b("MBBidInterstitialVideoHandler", th.getMessage(), th);
        }
    }

    public void loadFromBid(String str) {
        String str2;
        HashMap hashMap = new HashMap();
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("_");
                str2 = (split == null || split.length < 3) ? str : split[2];
            } else {
                str2 = SameMD5.getMD5(af.c());
            }
            String str3 = str2;
            hashMap.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, str3);
            r.a(str, "2000123", "", str3, "hb_Interstitial_load", 287);
        } catch (Exception unused) {
        }
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(true, str, (Map<String, String>) hashMap);
        }
    }

    public void loadFormSelfFilling() {
        HashMap hashMap = new HashMap();
        try {
            String md5 = SameMD5.getMD5(af.c());
            hashMap.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, md5);
            r.a("2000123", "", md5, "self_load", 287);
        } catch (Exception unused) {
        }
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(false, (Map<String, String>) hashMap);
        }
    }

    public boolean isBidReady() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.d(true);
        }
        return false;
    }

    public String getRequestId() {
        a aVar = this.a;
        return aVar != null ? aVar.a() : "";
    }

    public String getCreativeIdWithUnitId() {
        a aVar = this.a;
        return aVar != null ? aVar.b() : "";
    }

    public void showFromBid() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a((String) null, (String) null, (String) null);
        }
    }

    public void setRewardVideoListener(NewInterstitialListener newInterstitialListener) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a((InterVideoOutListener) new com.mbridge.msdk.newinterstitial.a.a(newInterstitialListener));
        }
    }

    public void setInterstitialVideoListener(NewInterstitialListener newInterstitialListener) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a((InterVideoOutListener) new com.mbridge.msdk.newinterstitial.a.a(newInterstitialListener));
        }
    }

    public void clearVideoCache() {
        try {
            if (this.a != null) {
                y.a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playVideoMute(int i) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void setIVRewardEnable(int i, int i2) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(i, com.mbridge.msdk.foundation.same.a.r, i2);
        }
    }

    public void setIVRewardEnable(int i, double d) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(i, com.mbridge.msdk.foundation.same.a.q, (int) (d * 100.0d));
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(str, str2, str3, str4);
        }
    }

    public void setExtraInfo(JSONObject jSONObject) {
        b.d().a(this.b, jSONObject);
    }
}