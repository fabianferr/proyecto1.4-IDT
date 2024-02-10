package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.a;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.common.utils.Pair;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.z5;

/* compiled from: Sta */
public class t8 implements Runnable, g2<Throwable, Void> {
    public final c7 a;
    public final a3 b;
    public final String c;
    public final h2<String, z5.a, Throwable, Void> d;
    public z5.a e;
    public Throwable f;

    public t8(c7 c7Var, a3 a3Var, String str, h2<String, z5.a, Throwable, Void> h2Var) {
        this.a = c7Var;
        this.b = a3Var;
        this.c = str;
        this.d = h2Var;
    }

    public Object a(Object obj) {
        this.f = (Throwable) obj;
        return null;
    }

    public void run() {
        try {
            z5.a a2 = a(this.a, this.b, this.c, (g2<Throwable, Void>) this);
            this.e = a2;
            h2<String, z5.a, Throwable, Void> h2Var = this.d;
            if (h2Var != null) {
                h2Var.a(this.c, a2, this.f);
            }
        } catch (Throwable th) {
            h2<String, z5.a, Throwable, Void> h2Var2 = this.d;
            if (h2Var2 != null) {
                h2Var2.a(this.c, this.e, this.f);
            }
            throw th;
        }
    }

    public static String a(String str, TrackingParams trackingParams) {
        StringBuilder sb = new StringBuilder(str);
        String a2 = a.a(str, (String) null);
        if (a2 != null) {
            sb.append(a.c(a2));
        }
        if (trackingParams != null && (a2 != null || k9.c(str))) {
            sb.append(trackingParams.e());
        }
        if (trackingParams != null && trackingParams.f()) {
            sb.append("&isPubImp=true");
        }
        return sb.toString();
    }

    public static Pair<String, Boolean> a(Context context, String str, TrackingParams trackingParams, h2<String, z5.a, Throwable, Void> h2Var) {
        String a2 = a(str, trackingParams);
        return new Pair<>(a2, Boolean.valueOf(a(context, a2, h2Var)));
    }

    public static boolean a(Context context, String str, h2<String, z5.a, Throwable, Void> h2Var) {
        try {
            ComponentLocator a2 = ComponentLocator.a(context);
            a2.r().execute(new t8(a2.s(), a2.m(), str, h2Var));
            return true;
        } catch (Throwable th) {
            i3.a(th);
            if (h2Var == null) {
                return false;
            }
            h2Var.a(str, null, th);
            return false;
        }
    }

    public static z5.a a(c7 c7Var, a3 a3Var, String str, g2<Throwable, Void> g2Var) {
        u8 u8Var = new u8();
        try {
            u8Var.J = c7Var.a((Object) u8Var);
        } catch (Throwable th) {
            i3.a(th);
        }
        a3Var.getClass();
        try {
            return a3Var.a(str, u8Var, g2Var);
        } catch (Throwable th2) {
            if (a3Var.a(1)) {
                i3.a(th2);
            }
            return null;
        }
    }
}
