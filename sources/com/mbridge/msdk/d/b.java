package com.mbridge.msdk.d;

import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.d.a;
import com.mbridge.msdk.foundation.tools.aa;

/* compiled from: TimerController */
public class b {

    /* compiled from: TimerController */
    static class a {
        static b a = new b();
    }

    private b() {
    }

    public static b getInstance() {
        return a.a;
    }

    public void start() {
        e b = f.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
        if (b == null) {
            b = f.a().b();
        }
        int e = b.e();
        if (e > 0) {
            a.C0130a.a.a((long) (e * 1000));
        }
    }

    public void addRewardList(String str, String str2) {
        try {
            a.C0130a.a.a(str, str2);
        } catch (Exception e) {
            aa.d("TimerController", "addRewardList error:" + e.getMessage());
        }
    }

    public void addInterstitialList(String str, String str2) {
        try {
            a.C0130a.a.b(str, str2);
        } catch (Exception e) {
            aa.d("TimerController", "addInterstitialList error:" + e.getMessage());
        }
    }
}
