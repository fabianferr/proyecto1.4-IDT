package com.teragence.library;

import android.content.Context;
import android.telephony.TelephonyManager;

public class y3 implements w3 {
    private final Context a;

    public y3(Context context) {
        this.a = context;
    }

    public f1 a(boolean z, int i) {
        return c1.a(z, i);
    }

    public String a() {
        return ((TelephonyManager) this.a.getSystemService("phone")).getNetworkOperatorName();
    }

    public String b() {
        return new s1(((TelephonyManager) this.a.getSystemService("phone")).getNetworkType(), this.a).toString();
    }

    public String c() {
        return ((TelephonyManager) this.a.getSystemService("phone")).getNetworkOperator();
    }

    public boolean d() {
        return d1.c(this.a);
    }

    public String e() {
        return ((TelephonyManager) this.a.getSystemService("phone")).getNetworkCountryIso();
    }
}
