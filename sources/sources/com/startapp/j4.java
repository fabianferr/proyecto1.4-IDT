package com.startapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.startapp.sdk.adsbase.a;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Sta */
public class j4 {
    public boolean a;
    public boolean b;
    public Runnable c;
    public Runnable d;
    public Runnable e;
    public Context f;
    public TrackingParams g;

    public j4(Context context, Runnable runnable, TrackingParams trackingParams, boolean z) {
        this(context, runnable, trackingParams);
        this.b = z;
    }

    @JavascriptInterface
    public void closeAd() {
        if (!this.a) {
            this.a = true;
            this.c.run();
        }
    }

    @JavascriptInterface
    public void enableScroll(String str) {
        Runnable runnable = this.e;
        if (runnable != null) {
            runnable.run();
        }
    }

    @JavascriptInterface
    public void externalLinks(String str) {
        if (this.b) {
            Map<Activity, Integer> map = k9.a;
            a.a(this.f, str, (String) null);
            return;
        }
        a.b(this.f, str, (String) null);
    }

    @JavascriptInterface
    public void openApp(String str, String str2, String str3) {
        if (str != null && !TextUtils.isEmpty(str)) {
            a.a(this.f, str, this.g);
        }
        Intent a2 = k9.a(this.f, str2);
        if (!(a2 == null || str3 == null)) {
            try {
                JSONObject jSONObject = new JSONObject(str3);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    a2.putExtra(valueOf, String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (JSONException unused) {
            }
        }
        if (a2 != null) {
            try {
                this.f.startActivity(a2);
            } catch (Throwable th) {
                i3.a(th);
            }
        }
        Runnable runnable = this.d;
        if (runnable != null) {
            runnable.run();
        }
    }

    public j4(Context context, Runnable runnable, TrackingParams trackingParams) {
        this.a = false;
        this.b = true;
        this.d = null;
        this.e = null;
        this.c = runnable;
        this.f = context;
        this.g = trackingParams;
    }

    public j4(Context context, Runnable runnable, Runnable runnable2, TrackingParams trackingParams) {
        this(context, runnable, trackingParams);
        this.d = runnable2;
    }
}
