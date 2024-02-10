package com.mbridge.msdk.interstitialvideo.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.r;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.reward.b.a;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import java.util.HashMap;
import java.util.Map;

public class MBInterstitialVideoHandler {
    private a a;
    private String b;

    public MBInterstitialVideoHandler(Context context, String str, String str2) {
        if (b.d().g() == null && context != null) {
            b.d().b(context);
        }
        String g = af.g(str2);
        if (!TextUtils.isEmpty(g)) {
            af.a(str2, g);
        }
        a(str, str2);
    }

    public MBInterstitialVideoHandler(String str, String str2) {
        a(str, str2);
    }

    private void a(String str, String str2) {
        this.b = str2;
        try {
            if (this.a == null) {
                a aVar = new a();
                this.a = aVar;
                aVar.a(true);
            }
            this.a.b(str, str2);
            f.a().e(str2);
        } catch (Throwable th) {
            aa.b("MBRewardVideoHandler", th.getMessage(), th);
        }
    }

    public String getRequestId() {
        a aVar = this.a;
        return aVar != null ? aVar.a() : "";
    }

    public String getCreativeIdWithUnitId() {
        a aVar = this.a;
        return aVar != null ? aVar.b() : "";
    }

    public void load() {
        HashMap hashMap = new HashMap();
        try {
            String md5 = SameMD5.getMD5(af.c());
            hashMap.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, md5);
            r.a("2000123", this.b, md5, "Interstitial_load", 287);
        } catch (Exception unused) {
        }
        r.a().a(this.b, "iv", false);
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(true, (Map<String, String>) hashMap);
        }
    }

    public void loadFormSelfFilling() {
        HashMap hashMap = new HashMap();
        try {
            String md5 = SameMD5.getMD5(af.c());
            hashMap.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, md5);
            r.a("2000123", this.b, md5, "self_load", 287);
        } catch (Exception unused) {
        }
        r.a().a(this.b, "iv", false);
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(false, (Map<String, String>) hashMap);
        }
    }

    public boolean isReady() {
        a aVar = this.a;
        if (aVar != null) {
            boolean d = aVar.d(true);
            if (d) {
                r.a().d(this.b, "iv", false);
            } else {
                r.a().e(this.b, "iv", false);
            }
            return d;
        }
        r.a().e(this.b, "iv", false);
        return false;
    }

    public void show() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(CampaignEx.JSON_KEY_HB, "0");
            m.a().b("2000128", "interstitial_show", this.b, "287", hashMap);
        } catch (Exception unused) {
        }
        r.a().f(this.b, "iv", false);
        a aVar = this.a;
        if (aVar != null) {
            aVar.a((String) null, (String) null, (String) null);
        }
    }

    public void setRewardVideoListener(InterstitialVideoListener interstitialVideoListener) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a((InterVideoOutListener) new com.mbridge.msdk.interstitialvideo.a.a(interstitialVideoListener));
        }
    }

    public void setInterstitialVideoListener(InterstitialVideoListener interstitialVideoListener) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a((InterVideoOutListener) new com.mbridge.msdk.interstitialvideo.a.a(interstitialVideoListener));
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
}
