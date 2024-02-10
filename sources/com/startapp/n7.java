package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.SimpleTokenUtils;
import com.startapp.sdk.common.SDKException;

/* compiled from: Sta */
public class n7 extends w0 {
    public q6 j0;
    public String k0;

    public n7(Context context) {
        super(1);
        this.j0 = n6.a(context);
        this.k0 = a0.a(context);
    }

    public void a(r6 r6Var) throws SDKException {
        super.a(r6Var);
        r6Var.a("placement", (Object) "INAPP_DOWNLOAD", true, true);
        q6 q6Var = this.j0;
        if (q6Var != null) {
            r6Var.a("install_referrer", (Object) q6Var.a.getString("install_referrer"), true, true);
            r6Var.a("referrer_click_timestamp_seconds", (Object) Long.valueOf(this.j0.a.getLong("referrer_click_timestamp_seconds")), true, true);
            r6Var.a("install_begin_timestamp_seconds", (Object) Long.valueOf(this.j0.a.getLong("install_begin_timestamp_seconds")), true, true);
        }
        r6Var.a("apkSig", (Object) this.k0, true, true);
        long j = SimpleTokenUtils.c;
        if (j != 0) {
            r6Var.a("firstInstalledAppTS", (Object) Long.valueOf(j), false, true);
        }
    }
}
