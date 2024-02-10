package com.mbridge.msdk.click;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.click.a.a;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.e.b;

/* compiled from: CommonJumpLoader */
public final class c extends d {
    JumpLoaderResult a = null;
    private int b = 0;
    private String c = null;
    private int d;
    private e e = null;
    private boolean f = true;
    private b g;
    private m h;
    private Handler i = new Handler(Looper.getMainLooper());

    public c(Context context) {
        this.g = new b(context);
        this.h = new m(context);
    }

    public final void a(String str, CampaignEx campaignEx, e eVar, String str2, boolean z, boolean z2, int i2) {
        String str3;
        boolean z3;
        this.c = str2;
        this.e = eVar;
        this.a = null;
        this.d = i2;
        boolean z4 = false;
        if (campaignEx != null) {
            if (CampaignEx.CLICKMODE_ON.equals(campaignEx.getClick_mode()) || "6".equals(campaignEx.getClick_mode())) {
                z4 = true;
            }
            str3 = campaignEx.getId();
            z3 = z4;
        } else {
            str3 = "";
            z3 = false;
        }
        this.h.a(str2, eVar, z3, str3, str, campaignEx, z, z2, i2);
    }

    public final void a(String str, CampaignEx campaignEx, e eVar) {
        this.c = new String(campaignEx.getClickURL());
        this.e = eVar;
        this.a = null;
        this.h.a(campaignEx.getClickURL(), eVar, CampaignEx.CLICKMODE_ON.equals(campaignEx.getClick_mode()) || "6".equals(campaignEx.getClick_mode()), campaignEx.getId(), str, campaignEx, true, false, a.j);
    }

    public final void a() {
        this.f = false;
    }
}
