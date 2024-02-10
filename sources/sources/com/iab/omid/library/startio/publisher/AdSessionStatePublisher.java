package com.iab.omid.library.startio.publisher;

import android.os.Build;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import com.startapp.a5;
import com.startapp.ac;
import com.startapp.fb;
import com.startapp.fc;
import com.startapp.l;
import com.startapp.p;
import com.startapp.q;
import com.startapp.rb;
import com.startapp.tb;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Sta */
public abstract class AdSessionStatePublisher {
    public tb a = new tb((WebView) null);
    public l b;
    public a5 c;
    public a d;
    public long e;

    /* compiled from: Sta */
    public enum a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher() {
        a();
    }

    public void a() {
        this.e = System.nanoTime();
        this.d = a.AD_STATE_IDLE;
    }

    public void a(WebView webView) {
        this.a = new tb(webView);
    }

    public void a(fb fbVar, q qVar) {
        a(fbVar, qVar, (JSONObject) null);
    }

    public void b() {
        this.a.clear();
    }

    public void b(String str, long j) {
        if (j >= this.e) {
            this.d = a.AD_STATE_VISIBLE;
            fc.a.a(c(), "setNativeViewHierarchy", str);
        }
    }

    public WebView c() {
        return (WebView) this.a.get();
    }

    public void d() {
    }

    public void a(p pVar) {
        fc fcVar = fc.a;
        WebView c2 = c();
        pVar.getClass();
        JSONObject jSONObject = new JSONObject();
        rb.a(jSONObject, "impressionOwner", pVar.a);
        rb.a(jSONObject, "mediaEventsOwner", pVar.b);
        rb.a(jSONObject, "creativeType", pVar.d);
        rb.a(jSONObject, "impressionType", pVar.e);
        rb.a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(pVar.c));
        fcVar.a(c2, "init", jSONObject);
    }

    public void a(fb fbVar, q qVar, JSONObject jSONObject) {
        String str = fbVar.h;
        JSONObject jSONObject2 = new JSONObject();
        rb.a(jSONObject2, "environment", MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        rb.a(jSONObject2, "adSessionType", qVar.h);
        JSONObject jSONObject3 = new JSONObject();
        rb.a(jSONObject3, "deviceType", Build.MANUFACTURER + "; " + Build.MODEL);
        rb.a(jSONObject3, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        rb.a(jSONObject3, "os", "Android");
        rb.a(jSONObject2, "deviceInfo", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        rb.a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        rb.a(jSONObject4, "partnerName", qVar.a.a);
        rb.a(jSONObject4, "partnerVersion", qVar.a.b);
        rb.a(jSONObject2, "omidNativeInfo", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        rb.a(jSONObject5, "libraryVersion", "1.3.31-Startio");
        rb.a(jSONObject5, "appId", ac.b.a.getApplicationContext().getPackageName());
        rb.a(jSONObject2, MBridgeConstans.DYNAMIC_VIEW_WX_APP, jSONObject5);
        String str2 = qVar.g;
        if (str2 != null) {
            rb.a(jSONObject2, "contentUrl", str2);
        }
        String str3 = qVar.f;
        if (str3 != null) {
            rb.a(jSONObject2, "customReferenceData", str3);
        }
        JSONObject jSONObject6 = new JSONObject();
        for (T t : Collections.unmodifiableList(qVar.c)) {
            rb.a(jSONObject6, t.a, t.c);
        }
        fc.a.a(c(), "startSession", str, jSONObject2, jSONObject6, jSONObject);
    }

    public void a(String str, long j) {
        a aVar;
        if (j >= this.e && this.d != (aVar = a.AD_STATE_NOTVISIBLE)) {
            this.d = aVar;
            fc.a.a(c(), "setNativeViewHierarchy", str);
        }
    }
}
