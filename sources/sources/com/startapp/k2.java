package com.startapp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adinformation.AdInformationObject;
import com.startapp.sdk.adsbase.adinformation.AdInformationOverrides;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: Sta */
public abstract class k2 {
    public Intent a;
    public Activity b;
    public AdInformationObject c = null;
    public BroadcastReceiver d = new a();
    public String[] e;
    public boolean[] f;
    public boolean[] g = {true};
    public String h;
    public String[] i;
    public String[] j;
    public String[] k;
    public Ad l;
    public String m;
    public AdPreferences.Placement n;
    public AdInformationOverrides o;
    public String p;
    public Long q;
    public Boolean[] r = null;
    public int s = 0;
    public boolean t = false;
    public Long u;
    public boolean v = false;

    /* compiled from: Sta */
    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            k2.this.b();
        }
    }

    /* compiled from: Sta */
    public class b implements Runnable {
        public b() {
        }

        public void run() {
            k2.this.b.finish();
        }
    }

    public void a(Configuration configuration) {
    }

    public abstract void a(Bundle bundle);

    public boolean a(int i2) {
        boolean[] zArr = this.g;
        if (zArr == null || i2 < 0 || i2 >= zArr.length) {
            return true;
        }
        return zArr[i2];
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        return false;
    }

    public void b() {
        this.b.runOnUiThread(new b());
    }

    public void b(Bundle bundle) {
    }

    public boolean c() {
        return false;
    }

    public void d() {
        if (this.d != null) {
            w4.a((Context) this.b).a(this.d);
        }
        this.d = null;
    }

    public abstract void e();

    public abstract void f();

    public void g() {
    }

    public void h() {
        w4.a((Context) this.b).a(new Intent("com.startapp.android.HideDisplayBroadcastListener"));
    }

    public String a() {
        try {
            String[] strArr = this.i;
            if (strArr == null || strArr.length <= 0) {
                return "";
            }
            return com.startapp.sdk.adsbase.a.a(strArr[0], (String) null);
        } catch (Throwable th) {
            i3.a(th);
            return "";
        }
    }

    public void a(String str) {
        String str2;
        if (str == null || (str2 = this.p) == null || str2.length() <= 0) {
            this.m = str;
        } else {
            this.m = str.replaceAll("startapp_adtag_placeholder", this.p);
        }
    }
}
