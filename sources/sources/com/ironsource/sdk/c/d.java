package com.ironsource.sdk.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.sdk.a;
import com.ironsource.sdk.a.h;
import com.ironsource.sdk.b.b;
import com.ironsource.sdk.b.c;
import com.ironsource.sdk.c.f;
import com.ironsource.sdk.utils.Logger;
import com.vungle.ads.internal.model.AdPayload;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class d implements f {
    /* access modifiers changed from: private */
    public static final String e = "d";
    public String a;
    /* access modifiers changed from: package-private */
    public WebView b;
    /* access modifiers changed from: package-private */
    public b c;
    public a d;
    /* access modifiers changed from: private */
    public final String f;
    /* access modifiers changed from: private */
    public Context g;

    public d(com.ironsource.sdk.b.a aVar, Context context, String str, a aVar2) {
        this.g = context;
        b bVar = new b();
        this.c = bVar;
        bVar.d = str;
        this.f = str;
        this.c.a = aVar;
        this.d = aVar2;
    }

    static /* synthetic */ void a(d dVar, final String str) {
        Logger.i(e, "ISNAdViewWebPresenter | createWebView");
        WebView webView = new WebView(dVar.g);
        dVar.b = webView;
        webView.addJavascriptInterface(new c(dVar), "containerMsgHandler");
        dVar.b.setWebViewClient(new c(new f.a() {
            public final void a(String str) {
                String b2 = d.e;
                Logger.i(b2, "ISNAdViewWebPresenter | WebViewClient | reportOnError: " + str);
                d.this.b(str, str);
            }

            public final void b(String str) {
                String b2 = d.e;
                Logger.i(b2, "ISNAdViewWebPresenter | WebViewClient | onRenderProcessGone: " + str);
                try {
                    ((ViewGroup) d.this.b.getParent()).removeView(d.this.b);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                d.this.c();
            }
        }));
        com.ironsource.sdk.utils.d.a(dVar.b);
        dVar.c.c = dVar.b;
    }

    static /* synthetic */ String b(d dVar, String str) {
        if (!str.startsWith(".")) {
            return str;
        }
        StringBuilder sb = new StringBuilder(AdPayload.FILE_SCHEME);
        sb.append(dVar.a);
        String substring = str.substring(str.indexOf("/") + 1);
        sb.append(substring.substring(substring.indexOf("/")));
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public synchronized void c() {
        a("", "");
    }

    public final WebView a() {
        return this.b;
    }

    public final synchronized void a(final String str, final String str2) {
        if (this.g != null) {
            Logger.i(e, "performCleanup");
            com.ironsource.environment.thread.a.a.a(new Runnable() {
                public final void run() {
                    try {
                        if (d.this.b != null) {
                            d.this.b.destroy();
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("adViewId", d.this.f);
                        if (d.this.c != null) {
                            d.this.c.a(str, jSONObject);
                            b c2 = d.this.c;
                            c2.a = null;
                            c2.b = null;
                        }
                        b unused = d.this.c = null;
                        Context unused2 = d.this.g = null;
                    } catch (Exception e) {
                        String b2 = d.e;
                        Log.e(b2, "performCleanup | could not destroy ISNAdView webView ID: " + d.this.f);
                        com.ironsource.sdk.a.f.a(h.r, (Map<String, Object>) new com.ironsource.sdk.a.a().a("callfailreason", e.getMessage()).a);
                        d.this.b(str2, e.getMessage());
                    }
                }
            });
        }
    }

    public final void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            b(str3, "action parameter empty");
            return;
        }
        String str4 = e;
        Logger.i(str4, "trying to perform WebView Action: " + str);
        try {
            if (str.equals("onPause")) {
                this.b.onPause();
            } else if (str.equals("onResume")) {
                this.b.onResume();
            } else {
                b(str3, "action not supported");
                return;
            }
            this.c.a(str2);
        } catch (Exception unused) {
            b(str3, "failed to perform action");
        }
    }

    public final void a(JSONObject jSONObject, String str, String str2) {
        try {
            this.c.b(str);
        } catch (Exception e2) {
            String str3 = e;
            Logger.i(str3, "sendHandleGetViewVisibility fail with reason: " + e2.getMessage());
        }
    }

    public final void b(String str, String str2) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.a(str, str2);
        }
    }

    public final void b(JSONObject jSONObject, String str, String str2) {
        try {
            this.c.a(jSONObject.getString(NativeProtocol.WEB_DIALOG_PARAMS), str, str2);
        } catch (Exception e2) {
            String str3 = e;
            Logger.i(str3, "sendMessageToAd fail message: " + e2.getMessage());
            throw e2;
        }
    }

    @JavascriptInterface
    public void handleMessageFromAd(String str) {
        b bVar = this.c;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(FirebaseAnalytics.Param.METHOD);
            if (TextUtils.isEmpty(optString) || !bVar.c(optString)) {
                bVar.a(jSONObject.optString("controllerMsgTopic", "containerSendMessage"), jSONObject);
            } else if (optString.equalsIgnoreCase("handleGetViewVisibility")) {
                bVar.a(bVar.a(jSONObject).toString(), (String) null, (String) null);
            }
        } catch (JSONException e2) {
            String str2 = bVar.e;
            Log.e(str2, "ISNAdViewLogic | receiveMessageFromExternal | Error while trying handle message: " + str);
            e2.printStackTrace();
        }
    }
}
