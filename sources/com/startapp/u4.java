package com.startapp;

import com.startapp.sdk.adsbase.model.AdDetails;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* compiled from: Sta */
public class u4 {
    public g3 a = new g3();
    public List<s4> b;
    public String c = "";

    public void a(AdDetails adDetails) {
        s4 s4Var = new s4(adDetails);
        this.b.add(s4Var);
        this.a.a(this.b.size() - 1, s4Var.a, s4Var.i);
    }

    public void a() {
        for (k7 next : this.a.a.values()) {
            if (next != null) {
                next.a("AD_CLOSED_TOO_QUICKLY", (JSONObject) null);
            }
        }
    }

    public void a(c6 c6Var, boolean z) {
        g3 g3Var = this.a;
        g3Var.d = c6Var;
        if (z) {
            g3Var.c.clear();
            g3Var.e = 0;
            g3Var.f.clear();
            HashMap<String, k7> hashMap = g3Var.a;
            if (hashMap != null) {
                for (k7 next : hashMap.values()) {
                    if (next != null) {
                        next.a("AD_CLOSED_TOO_QUICKLY", (JSONObject) null);
                    }
                }
                g3Var.a.clear();
            }
        }
    }
}
