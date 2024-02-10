package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.sdk.g.d;
import com.ironsource.sdk.service.d;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class B {
    final String a;
    Context b;
    d c;
    C0236c d;
    k e;
    int f;
    com.ironsource.sdk.l.d g;
    int h;
    final String i = "B";
    int j;
    private int k = FeaturesManager.getInstance().getInitRecoverTrials();

    public enum a {
        ;
        
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;

        static {
            e = new int[]{1, 2, 3, 4};
        }
    }

    public B(Context context, C0236c cVar, d dVar, k kVar, int i2, com.ironsource.sdk.l.d dVar2, String str) {
        int i3;
        Logger.i("B", "getInitialState mMaxAllowedTrials: " + this.k);
        if (this.k <= 0) {
            Logger.i("B", "recovery is not allowed by config");
            i3 = a.d;
        } else {
            i3 = a.a;
        }
        this.j = i3;
        if (i3 != a.d) {
            this.b = context;
            this.d = cVar;
            this.c = dVar;
            this.e = kVar;
            this.f = i2;
            this.g = dVar2;
            this.h = 0;
        }
        this.a = str;
    }

    private void c() {
        this.b = null;
        this.d = null;
        this.c = null;
        this.e = null;
        this.g = null;
    }

    private void d() {
        c();
        this.j = a.b;
    }

    private void e() {
        if (this.h == this.k) {
            Logger.i(this.i, "handleRecoveringEndedFailed | Reached max trials");
            this.j = a.d;
            c();
            return;
        }
        this.j = a.a;
    }

    public final void a(boolean z) {
        if (this.j == a.c) {
            if (z) {
                d();
            } else {
                e();
            }
        }
    }

    public final boolean a() {
        return this.j == a.c;
    }

    public final boolean a(d.c cVar, d.b bVar) {
        Logger.i(this.i, "shouldRecoverWebController: ");
        if (this.j == a.d) {
            Logger.i(this.i, "shouldRecoverWebController: false | recover is not allowed");
            return false;
        } else if (cVar != d.c.Native) {
            String str = this.i;
            Logger.i(str, "shouldRecoverWebController: false | current controller type is: " + cVar);
            return false;
        } else if (bVar == d.b.Loading || bVar == d.b.None) {
            Logger.i(this.i, "shouldRecoverWebController: false | a Controller is currently loading");
            return false;
        } else if (this.j == a.b) {
            Logger.i(this.i, "shouldRecoverWebController: false | already recovered");
            return false;
        } else if (this.j == a.c) {
            Logger.i(this.i, "shouldRecoverWebController: false | currently in recovering");
            return false;
        } else if (this.b == null || this.d == null || this.c == null || this.e == null) {
            Logger.i(this.i, "shouldRecoverWebController: false | missing mandatory param");
            return false;
        } else {
            Logger.i(this.i, "shouldRecoverWebController: true | allow recovering ");
            return true;
        }
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isRecovered", this.j == a.b);
            jSONObject.put("trialNumber", this.h);
            jSONObject.put("maxAllowedTrials", this.k);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
