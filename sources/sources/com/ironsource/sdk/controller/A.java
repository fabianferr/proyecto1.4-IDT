package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.security.CertificateUtil;
import com.facebook.share.internal.ShareInternalUtility;
import com.ironsource.environment.a;
import com.ironsource.environment.k;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.controller.f;
import com.ironsource.sdk.controller.h;
import com.ironsource.sdk.controller.l;
import com.ironsource.sdk.controller.n;
import com.ironsource.sdk.controller.q;
import com.ironsource.sdk.controller.u;
import com.ironsource.sdk.controller.y;
import com.ironsource.sdk.f.a;
import com.ironsource.sdk.g.d;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class A extends WebView implements DownloadListener, n, com.ironsource.sdk.l.f {
    /* access modifiers changed from: private */
    public static String ae = "success";
    /* access modifiers changed from: private */
    public static String af = "fail";
    public static String b = "is_store";
    public static String c = "external_url";
    public static String d = "secondary_web_view";
    private static int y;
    /* access modifiers changed from: private */
    public String A;
    /* access modifiers changed from: private */
    public String B;
    private Map<String, String> C;
    /* access modifiers changed from: private */
    public final com.ironsource.sdk.l.d D;
    /* access modifiers changed from: private */
    public boolean E;
    /* access modifiers changed from: private */
    public boolean F;
    /* access modifiers changed from: private */
    public CountDownTimer G;
    /* access modifiers changed from: private */
    public int H = 50;
    /* access modifiers changed from: private */
    public int I = 50;
    /* access modifiers changed from: private */
    public String J = "top-right";
    /* access modifiers changed from: private */
    public FrameLayout K;
    /* access modifiers changed from: private */
    public WebChromeClient.CustomViewCallback L;
    /* access modifiers changed from: private */
    public com.ironsource.sdk.j.a.d M;
    /* access modifiers changed from: private */
    public com.ironsource.sdk.j.a.c N;
    /* access modifiers changed from: private */
    public com.ironsource.sdk.j.e O;
    /* access modifiers changed from: private */
    public com.ironsource.sdk.j.a.b P;
    /* access modifiers changed from: private */
    public Boolean Q = null;
    /* access modifiers changed from: private */
    public String R;
    /* access modifiers changed from: private */
    public f S;
    private Object T = new Object();
    /* access modifiers changed from: private */
    public boolean U = false;
    /* access modifiers changed from: private */
    public k V;
    /* access modifiers changed from: private */
    public e W;
    /* access modifiers changed from: package-private */
    public String a = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
    /* access modifiers changed from: private */
    public com.ironsource.sdk.service.Connectivity.b aa;
    /* access modifiers changed from: private */
    public JSONObject ab;
    /* access modifiers changed from: private */
    public n.a ac;
    /* access modifiers changed from: private */
    public n.b ad;
    /* access modifiers changed from: package-private */
    public b e;
    public CountDownTimer f;
    final a g;
    /* access modifiers changed from: package-private */
    public View h;
    /* access modifiers changed from: package-private */
    public FrameLayout i;
    /* access modifiers changed from: package-private */
    public g j;
    String k;
    /* access modifiers changed from: package-private */
    public z l;
    /* access modifiers changed from: package-private */
    public com.ironsource.sdk.g.b m;
    /* access modifiers changed from: package-private */
    public t n;
    /* access modifiers changed from: package-private */
    public u o;
    /* access modifiers changed from: package-private */
    public y p;
    /* access modifiers changed from: package-private */
    public l q;
    /* access modifiers changed from: package-private */
    public C0234a r;
    /* access modifiers changed from: package-private */
    public m s;
    C t;
    C0236c u;
    /* access modifiers changed from: package-private */
    public com.ironsource.sdk.j.f v;
    private final com.ironsource.environment.thread.a w;
    /* access modifiers changed from: private */
    public String x = IronSourceConstants.IRONSOURCE_CONFIG_NAME;
    private final String z = "We're sorry, some error occurred. we will investigate it";

    class a extends WebChromeClient {
        private a() {
        }

        /* synthetic */ a(A a2, byte b) {
            this();
        }

        public final View getVideoLoadingProgressView() {
            FrameLayout frameLayout = new FrameLayout(A.this.getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return frameLayout;
        }

        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            Logger.i("MyApplication", consoleMessage.message() + " -- From line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
            return true;
        }

        public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            WebView webView2 = new WebView(webView.getContext());
            webView2.setWebChromeClient(this);
            webView2.setWebViewClient(new c(A.this, (byte) 0));
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            Logger.i("onCreateWindow", "onCreateWindow");
            return true;
        }

        public final void onHideCustomView() {
            Logger.i("Test", "onHideCustomView");
            if (A.this.h != null) {
                A.this.h.setVisibility(8);
                A.this.K.removeView(A.this.h);
                View unused = A.this.h = null;
                A.this.K.setVisibility(8);
                A.this.L.onCustomViewHidden();
                A.this.setVisibility(0);
            }
        }

        public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            Logger.i("Test", "onShowCustomView");
            A.this.setVisibility(8);
            if (A.this.h != null) {
                Logger.i("Test", "mCustomView != null");
                customViewCallback.onCustomViewHidden();
                return;
            }
            Logger.i("Test", "mCustomView == null");
            A.this.K.addView(view);
            View unused = A.this.h = view;
            WebChromeClient.CustomViewCallback unused2 = A.this.L = customViewCallback;
            A.this.K.setVisibility(0);
        }
    }

    static class b {
        d.e a;
        String b;

        public b(d.e eVar, String str) {
            this.a = eVar;
            this.b = str;
        }
    }

    class c extends WebViewClient {
        private c() {
        }

        /* synthetic */ c(A a2, byte b) {
            this();
        }

        public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            String b = A.this.a;
            Logger.e(b, "Chromium process crashed - detail.didCrash(): " + renderProcessGoneDetail.didCrash());
            return true;
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Activity a2 = A.this.u.a();
            Intent intent = new Intent(a2, OpenUrlActivity.class);
            intent.putExtra(A.c, str);
            intent.putExtra(A.d, false);
            a2.startActivity(intent);
            return true;
        }
    }

    public class d {

        public class a {
            public a() {
            }

            /* access modifiers changed from: package-private */
            public final void a(boolean z, String str, com.ironsource.sdk.g.f fVar) {
                fVar.a(z ? A.ae : A.af, str);
                A.a(A.this, fVar.toString(), z, (String) null, (String) null);
            }

            public final void a(boolean z, String str, JSONObject jSONObject) {
                String str2;
                if (z) {
                    try {
                        str2 = A.ae;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        e.getMessage();
                        return;
                    }
                } else {
                    str2 = A.af;
                }
                jSONObject.put(str2, str);
                A.a(A.this, jSONObject.toString(), z, (String) null, (String) null);
            }
        }

        public d() {
        }

        private void a(String str, boolean z) {
            com.ironsource.sdk.g.c a2 = A.this.V.a(d.e.c, str);
            if (a2 != null) {
                a2.f = z;
            }
        }

        private void a(JSONObject jSONObject) {
            try {
                FeaturesManager instance = FeaturesManager.getInstance();
                if (!instance.a().isEmpty()) {
                    jSONObject.put("nativeFeatures", new JSONArray(instance.a()));
                }
            } catch (Exception e) {
                com.ironsource.sdk.a.f.a(com.ironsource.sdk.a.h.p, (Map<String, Object>) new com.ironsource.sdk.a.a().a("callfailreason", e.getMessage()).a);
                Logger.d(A.this.a, "getControllerConfig Error while adding supported features data from FeaturesManager");
            }
        }

        private void a(JSONObject jSONObject, String str) {
            if (a(str)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    jSONObject.putOpt("testerABGroup", jSONObject2.get("testerABGroup"));
                    jSONObject.putOpt("testFriendlyName", jSONObject2.get("testFriendlyName"));
                } catch (JSONException unused) {
                    Logger.d(A.this.a, "getControllerConfig Error while parsing Tester AB Group parameters");
                }
            }
        }

        private static boolean a(String str) {
            if (TextUtils.isEmpty(str) || str.contains("-1")) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return !jSONObject.getString("testerABGroup").isEmpty() && !jSONObject.getString("testFriendlyName").isEmpty();
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }

        private void b(JSONObject jSONObject) {
            try {
                jSONObject.put("controllerSourceData", A.this.S.f());
            } catch (Exception unused) {
            }
        }

        @JavascriptInterface
        public void adClicked(String str) {
            String b = A.this.a;
            Logger.i(b, "adClicked(" + str + ")");
            com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
            String d = fVar.d("productType");
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(fVar);
            if (!TextUtils.isEmpty(fetchDemandSourceId)) {
                final d.e e = A.g(d);
                final com.ironsource.sdk.j.a.a a2 = A.this.b(e);
                if (e != null && a2 != null) {
                    A.this.c((Runnable) new Runnable() {
                        public final void run() {
                            a2.b(e, fetchDemandSourceId);
                        }
                    });
                }
            }
        }

        @JavascriptInterface
        public void adCredited(String str) {
            final String str2;
            final boolean z;
            final boolean z2;
            com.ironsource.sdk.g.c a2;
            Log.d(A.this.x, "adCredited(" + str + ")");
            com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
            String d = fVar.d("credits");
            boolean z3 = false;
            final int parseInt = d != null ? Integer.parseInt(d) : 0;
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(fVar);
            final String d2 = fVar.d("productType");
            if (TextUtils.isEmpty(d2)) {
                Log.d(A.this.x, "adCredited | product type is missing");
            }
            if (!d.e.c.toString().equalsIgnoreCase(d2)) {
                String d3 = fVar.d("total");
                final int parseInt2 = d3 != null ? Integer.parseInt(d3) : 0;
                if (!d.e.OfferWall.toString().equalsIgnoreCase(d2)) {
                    str2 = null;
                    z2 = false;
                    z = false;
                } else if (fVar.b(InAppPurchaseMetaData.KEY_SIGNATURE) || fVar.b(CampaignEx.JSON_KEY_TIMESTAMP) || fVar.b("totalCreditsFlag")) {
                    A.a(A.this, str, false, "One of the keys are missing: signature/timestamp/totalCreditsFlag", (String) null);
                    return;
                } else {
                    if (fVar.d(InAppPurchaseMetaData.KEY_SIGNATURE).equalsIgnoreCase(SDKUtils.getMD5(d3 + A.this.A + A.this.B))) {
                        z3 = true;
                    } else {
                        A.a(A.this, str, false, "Controller signature is not equal to SDK signature", (String) null);
                    }
                    boolean e = fVar.e("totalCreditsFlag");
                    str2 = fVar.d(CampaignEx.JSON_KEY_TIMESTAMP);
                    z = e;
                    z2 = z3;
                }
                if (A.this.a(d2)) {
                    final String str3 = str;
                    A.this.c((Runnable) new Runnable() {
                        public final void run() {
                            if (d2.equalsIgnoreCase(d.e.RewardedVideo.toString())) {
                                A.this.M.a(fetchDemandSourceId, parseInt);
                            } else if (d2.equalsIgnoreCase(d.e.OfferWall.toString()) && z2 && A.this.O.onOWAdCredited(parseInt, parseInt2, z) && !TextUtils.isEmpty(str2)) {
                                if (com.ironsource.sdk.utils.b.a().a(str2, A.this.A, A.this.B)) {
                                    A.a(A.this, str3, true, (String) null, (String) null);
                                } else {
                                    A.a(A.this, str3, false, "Time Stamp could not be stored", (String) null);
                                }
                            }
                        }
                    });
                }
            } else if (A.this.a(d.e.c.toString()) && (a2 = A.this.V.a(d.e.c, fetchDemandSourceId)) != null) {
                if (a2.d != null && a2.d.containsKey("rewarded")) {
                    z3 = Boolean.parseBoolean(a2.d.get("rewarded"));
                }
                if (z3) {
                    A.this.c((Runnable) new Runnable() {
                        public final void run() {
                            A.this.N.b(fetchDemandSourceId, parseInt);
                        }
                    });
                }
            }
        }

        @JavascriptInterface
        public void adUnitsReady(String str) {
            String b = A.this.a;
            Logger.i(b, "adUnitsReady(" + str + ")");
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(new com.ironsource.sdk.g.f(str));
            final com.ironsource.sdk.g.a aVar = new com.ironsource.sdk.g.a(str);
            if (!aVar.c) {
                A.a(A.this, str, false, "Num Of Ad Units Do Not Exist", (String) null);
                return;
            }
            A.a(A.this, str, true, (String) null, (String) null);
            String str2 = aVar.a;
            if (d.e.RewardedVideo.toString().equalsIgnoreCase(str2) && A.this.a(str2)) {
                final int parseInt = Integer.parseInt(aVar.b);
                A.this.c((Runnable) new Runnable() {
                    public final void run() {
                        if (parseInt > 0) {
                            Log.d(A.this.a, "onRVInitSuccess()");
                            A.this.M.a(d.e.RewardedVideo, fetchDemandSourceId, aVar);
                            return;
                        }
                        A.this.M.a(fetchDemandSourceId);
                    }
                });
            }
        }

        @JavascriptInterface
        public void adViewAPI(String str) {
            try {
                String b = A.this.a;
                Logger.i(b, "adViewAPI(" + str + ")");
                A.this.r.a(new com.ironsource.sdk.g.f(str).toString(), new a());
            } catch (Exception e) {
                e.printStackTrace();
                String b2 = A.this.a;
                Logger.i(b2, "adViewAPI failed with exception " + e.getMessage());
            }
        }

        @JavascriptInterface
        public void bannerViewAPI(String str) {
            Logger.i(A.this.a, "bannerViewAPI is not supported in this native version, only adview API");
        }

        @JavascriptInterface
        public void cleanAdInstance(String str) {
            d.e e;
            Map<String, com.ironsource.sdk.g.c> a2;
            com.ironsource.sdk.g.c remove;
            try {
                String b = A.this.a;
                Logger.i(b, "cleanAdInstance(" + str + ")");
                com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
                String d = fVar.d("productType");
                String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(fVar);
                if (!TextUtils.isEmpty(fetchDemandSourceId) && (e = A.g(d)) != null) {
                    k y = A.this.V;
                    if (!TextUtils.isEmpty(fetchDemandSourceId) && (a2 = y.a(e)) != null && (remove = a2.remove(fetchDemandSourceId)) != null) {
                        remove.g = null;
                        if (remove.d != null) {
                            remove.d.clear();
                        }
                        remove.d = null;
                    }
                }
            } catch (Exception e2) {
                A.a(A.this, str, false, e2.getMessage(), (String) null);
                e2.printStackTrace();
            }
        }

        @JavascriptInterface
        public void clearLastUpdateTimeData(String str) {
            try {
                com.ironsource.sdk.utils.b a2 = com.ironsource.sdk.utils.b.a();
                ArrayList arrayList = new ArrayList();
                String[] strArr = (String[]) a2.a.getAll().keySet().toArray(new String[0]);
                SharedPreferences.Editor edit = a2.a.edit();
                for (String str2 : strArr) {
                    if (com.ironsource.sdk.utils.b.b(str2)) {
                        arrayList.add(str2);
                        edit.remove(str2);
                    }
                }
                edit.apply();
                com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
                if (!arrayList.isEmpty()) {
                    fVar.a("removedAdsLastUpdateTime", arrayList.toString());
                }
                A.a(A.this, fVar.toString(), true, (String) null, (String) null);
            } catch (Exception e) {
                A.a(A.this, str, false, e.getMessage(), (String) null);
                e.printStackTrace();
            }
        }

        @JavascriptInterface
        public void deleteFile(String str) {
            try {
                String b = A.this.a;
                Logger.i(b, "deleteFile(" + str + ")");
                com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
                String d = fVar.d(ShareInternalUtility.STAGING_PARAM);
                String d2 = fVar.d("path");
                if (d2 != null) {
                    if (!TextUtils.isEmpty(d)) {
                        com.ironsource.sdk.h.c cVar = new com.ironsource.sdk.h.c(IronSourceStorageUtils.buildAbsolutePathToDirInCache(A.this.R, d2), d);
                        IronSourceStorageUtils.ensurePathSafety(cVar, A.this.R);
                        if (!cVar.exists()) {
                            A.a(A.this, str, false, "File not exist", "1");
                            return;
                        }
                        A.a(A.this, str, IronSourceStorageUtils.deleteFile(cVar), (String) null, (String) null);
                        return;
                    }
                }
                A.a(A.this, str, false, "Missing parameters for file", "1");
            } catch (Exception e) {
                A.a(A.this, str, false, e.getMessage(), (String) null);
                e.printStackTrace();
            }
        }

        @JavascriptInterface
        public void deleteFolder(String str) {
            try {
                String b = A.this.a;
                Logger.i(b, "deleteFolder(" + str + ")");
                String d = new com.ironsource.sdk.g.f(str).d("path");
                if (d == null) {
                    A.a(A.this, str, false, "Missing parameters for file", "1");
                    return;
                }
                com.ironsource.sdk.h.c cVar = new com.ironsource.sdk.h.c(IronSourceStorageUtils.buildAbsolutePathToDirInCache(A.this.R, d));
                IronSourceStorageUtils.ensurePathSafety(cVar, A.this.R);
                if (!cVar.exists()) {
                    A.a(A.this, str, false, "Folder not exist", "1");
                    return;
                }
                A.a(A.this, str, IronSourceStorageUtils.deleteFolder(cVar.getPath()), (String) null, (String) null);
            } catch (Exception e) {
                A.a(A.this, str, false, e.getMessage(), (String) null);
                e.printStackTrace();
            }
        }

        @JavascriptInterface
        public void deviceDataAPI(String str) {
            try {
                String b = A.this.a;
                Logger.i(b, "deviceDataAPI(" + str + ")");
                com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
                l K = A.this.q;
                String fVar2 = fVar.toString();
                a aVar = new a();
                JSONObject jSONObject = new JSONObject(fVar2);
                l.a aVar2 = new l.a((byte) 0);
                aVar2.a = jSONObject.optString("deviceDataFunction");
                aVar2.b = jSONObject.optJSONObject("deviceDataParams");
                aVar2.c = jSONObject.optString("success");
                aVar2.d = jSONObject.optString("fail");
                if ("getDeviceData".equals(aVar2.a)) {
                    String str2 = aVar2.c;
                    com.ironsource.sdk.g.f fVar3 = new com.ironsource.sdk.g.f();
                    fVar3.a(SDKUtils.encodeString("sdCardAvailable"), SDKUtils.encodeString(String.valueOf(com.ironsource.environment.h.d())));
                    fVar3.a(SDKUtils.encodeString("totalDeviceRAM"), SDKUtils.encodeString(String.valueOf(com.ironsource.environment.h.d(K.a))));
                    fVar3.a(SDKUtils.encodeString("isCharging"), SDKUtils.encodeString(String.valueOf(com.ironsource.environment.h.e(K.a))));
                    fVar3.a(SDKUtils.encodeString("chargingType"), SDKUtils.encodeString(String.valueOf(com.ironsource.environment.h.f(K.a))));
                    fVar3.a(SDKUtils.encodeString("airplaneMode"), SDKUtils.encodeString(String.valueOf(com.ironsource.environment.h.g(K.a))));
                    fVar3.a(SDKUtils.encodeString("stayOnWhenPluggedIn"), SDKUtils.encodeString(String.valueOf(com.ironsource.environment.h.h(K.a))));
                    aVar.a(true, str2, fVar3);
                    return;
                }
                String str3 = l.b;
                Logger.i(str3, "unhandled API request " + fVar2);
            } catch (Exception e) {
                e.printStackTrace();
                String b2 = A.this.a;
                Logger.i(b2, "deviceDataAPI failed with exception " + e.getMessage());
            }
        }

        @JavascriptInterface
        public void displayWebView(String str) {
            int i;
            String b = A.this.a;
            Logger.i(b, "displayWebView(" + str + ")");
            A.a(A.this, str, true, (String) null, (String) null);
            com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
            boolean booleanValue = ((Boolean) fVar.c(ServerProtocol.DIALOG_PARAM_DISPLAY)).booleanValue();
            String d = fVar.d("productType");
            boolean e = fVar.e("standaloneView");
            String d2 = fVar.d("adViewId");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(fVar);
            boolean e2 = fVar.e("ctrWVPauseResume");
            if (booleanValue) {
                boolean unused = A.this.U = fVar.e("immersive");
                boolean e3 = fVar.e("activityThemeTranslucent");
                if (A.this.j != g.Display) {
                    A.this.j = g.Display;
                    String b2 = A.this.a;
                    Logger.i(b2, "State: " + A.this.j);
                    Activity a2 = A.this.u.a();
                    String str2 = A.this.k;
                    int k = com.ironsource.environment.h.k(a2);
                    if (e) {
                        j jVar = new j(a2);
                        jVar.addView(A.this.i);
                        jVar.b = A.this;
                        jVar.b.v = jVar;
                        jVar.b.requestFocus();
                        jVar.a = jVar.b.u.a();
                        if (((((Activity) jVar.a).getWindow().getAttributes().flags & 1024) != 0) || (i = jVar.a()) <= 0) {
                            i = 0;
                        }
                        int b3 = jVar.b();
                        try {
                            if (jVar.a != null) {
                                int o = com.ironsource.environment.h.o(jVar.a);
                                if (o == 1) {
                                    jVar.setPadding(0, i, 0, b3);
                                } else if (o == 2) {
                                    jVar.setPadding(0, i, b3, 0);
                                }
                            }
                        } catch (Exception unused2) {
                        }
                        ((Activity) jVar.a).runOnUiThread(new Runnable() {
                            public final void run(
/*
Method generation error in method: com.ironsource.sdk.controller.j.1.run():void, dex: classes5.dex
                            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ironsource.sdk.controller.j.1.run():void, class status: UNLOADED
                            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                            
*/
                        });
                        return;
                    }
                    Intent intent = e3 ? new Intent(a2, InterstitialActivity.class) : new Intent(a2, ControllerActivity.class);
                    if (d.e.RewardedVideo.toString().equalsIgnoreCase(d)) {
                        if ("application".equals(str2)) {
                            str2 = SDKUtils.translateRequestedOrientation(com.ironsource.environment.h.m(a2));
                        }
                        intent.putExtra("productType", d.e.RewardedVideo.toString());
                        A.this.m.e = d.e.RewardedVideo.ordinal();
                        A.this.m.c = fetchDemandSourceId;
                        if (A.this.a(d.e.RewardedVideo.toString())) {
                            A.this.M.c(d.e.RewardedVideo, fetchDemandSourceId);
                        }
                    } else if (d.e.OfferWall.toString().equalsIgnoreCase(d)) {
                        intent.putExtra("productType", d.e.OfferWall.toString());
                        A.this.m.e = d.e.OfferWall.ordinal();
                    } else if (d.e.c.toString().equalsIgnoreCase(d)) {
                        if ("application".equals(str2)) {
                            str2 = SDKUtils.translateRequestedOrientation(com.ironsource.environment.h.m(a2));
                        }
                        intent.putExtra("productType", d.e.c.toString());
                    }
                    if (d2 != null) {
                        intent.putExtra("adViewId", d2);
                    }
                    intent.putExtra("ctrWVPauseResume", e2);
                    intent.setFlags(536870912);
                    intent.putExtra("immersive", A.this.U);
                    intent.putExtra("orientation_set_flag", str2);
                    intent.putExtra("rotation_set_flag", k);
                    A a3 = A.this;
                    b unused3 = a3.e = new b(A.g(d), fetchDemandSourceId);
                    a2.startActivity(intent);
                    return;
                }
                String b4 = A.this.a;
                Logger.i(b4, "State: " + A.this.j);
                return;
            }
            A.this.j = g.Gone;
            A.this.h();
        }

        @JavascriptInterface
        public void fileSystemAPI(final String str) {
            String b = A.this.a;
            Logger.i(b, "fileSystemAPI(" + str + ")");
            A.this.b((Runnable) new Runnable() {
                public final void run() {
                    try {
                        A.this.s.a(new JSONObject(str), new a());
                    } catch (Exception e) {
                        e.printStackTrace();
                        String b2 = A.this.a;
                        Logger.i(b2, "fileSystemAPI failed with exception " + e.getMessage());
                    }
                }
            });
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0059, code lost:
            if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x005d;
         */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x0063  */
        /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
        @android.webkit.JavascriptInterface
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void getApplicationInfo(java.lang.String r5) {
            /*
                r4 = this;
                com.ironsource.sdk.controller.A r0 = com.ironsource.sdk.controller.A.this
                java.lang.String r0 = r0.a
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "getApplicationInfo("
                r1.<init>(r2)
                r1.append(r5)
                java.lang.String r2 = ")"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.ironsource.sdk.utils.Logger.i(r0, r1)
                com.ironsource.sdk.controller.A r0 = com.ironsource.sdk.controller.A.this
                java.lang.String r0 = new com.ironsource.sdk.g.f(r5).d(com.ironsource.sdk.controller.A.ae)
                com.ironsource.sdk.controller.A r1 = com.ironsource.sdk.controller.A.this
                java.lang.String r1 = new com.ironsource.sdk.g.f(r5).d(com.ironsource.sdk.controller.A.af)
                com.ironsource.sdk.g.f r2 = new com.ironsource.sdk.g.f
                r2.<init>(r5)
                java.lang.String r5 = "productType"
                java.lang.String r5 = r2.d(r5)
                java.lang.String r2 = com.ironsource.sdk.utils.SDKUtils.fetchDemandSourceId((com.ironsource.sdk.g.f) r2)
                com.ironsource.sdk.controller.A r3 = com.ironsource.sdk.controller.A.this
                java.lang.Object[] r5 = r3.c((java.lang.String) r5, (java.lang.String) r2)
                r2 = 0
                r2 = r5[r2]
                java.lang.String r2 = (java.lang.String) r2
                r3 = 1
                r5 = r5[r3]
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                if (r5 == 0) goto L_0x0055
                boolean r5 = android.text.TextUtils.isEmpty(r1)
                if (r5 != 0) goto L_0x005c
                r0 = r1
                goto L_0x005d
            L_0x0055:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L_0x005c
                goto L_0x005d
            L_0x005c:
                r0 = 0
            L_0x005d:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L_0x0072
                com.ironsource.sdk.controller.A r5 = com.ironsource.sdk.controller.A.this
                java.lang.String r1 = "onGetApplicationInfoSuccess"
                java.lang.String r3 = "onGetApplicationInfoFail"
                java.lang.String r5 = com.ironsource.sdk.controller.A.a((java.lang.String) r0, (java.lang.String) r2, (java.lang.String) r1, (java.lang.String) r3)
                com.ironsource.sdk.controller.A r0 = com.ironsource.sdk.controller.A.this
                r0.b((java.lang.String) r5)
            L_0x0072:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.A.d.getApplicationInfo(java.lang.String):void");
        }

        @JavascriptInterface
        public void getCachedFilesMap(String str) {
            A a2;
            String str2;
            String b = A.this.a;
            Logger.i(b, "getCachedFilesMap(" + str + ")");
            String b2 = new com.ironsource.sdk.g.f(str).d(A.ae);
            if (!TextUtils.isEmpty(b2)) {
                com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
                if (!fVar.a("path")) {
                    a2 = A.this;
                    str2 = "path key does not exist";
                } else {
                    String str3 = (String) fVar.c("path");
                    if (!IronSourceStorageUtils.isPathExist(A.this.R, str3)) {
                        a2 = A.this;
                        str2 = "path file does not exist on disk";
                    } else {
                        A.this.b(A.a(b2, IronSourceStorageUtils.getCachedFilesMap(A.this.R, str3), "onGetCachedFilesMapSuccess", "onGetCachedFilesMapFail"));
                        return;
                    }
                }
                A.a(a2, str, false, str2, (String) null);
            }
        }

        @JavascriptInterface
        public void getConnectivityInfo(String str) {
            String str2;
            String b = A.this.a;
            Logger.i(b, "getConnectivityInfo(" + str + ")");
            com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
            String d = fVar.d(A.ae);
            String d2 = fVar.d(A.af);
            JSONObject jSONObject = new JSONObject();
            if (A.this.aa != null) {
                com.ironsource.sdk.service.Connectivity.b m = A.this.aa;
                jSONObject = m.a.c(A.this.getContext());
            }
            if (jSONObject.length() > 0) {
                str2 = A.b(d, jSONObject.toString());
            } else {
                str2 = A.b(d2, A.a("errMsg", "failed to retrieve connection info", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false));
            }
            A.this.b(str2);
        }

        @JavascriptInterface
        public void getControllerConfig(String str) {
            String b = A.this.a;
            Logger.i(b, "getControllerConfig(" + str + ")");
            String d = new com.ironsource.sdk.g.f(str).d(A.ae);
            if (!TextUtils.isEmpty(d)) {
                JSONObject controllerConfigAsJSONObject = SDKUtils.getControllerConfigAsJSONObject();
                a(controllerConfigAsJSONObject);
                a(controllerConfigAsJSONObject, SDKUtils.getTesterParameters());
                b(controllerConfigAsJSONObject);
                A.this.b(A.b(d, controllerConfigAsJSONObject.toString()));
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0081 A[Catch:{ Exception -> 0x008d }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        @android.webkit.JavascriptInterface
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void getDemandSourceState(java.lang.String r9) {
            /*
                r8 = this;
                com.ironsource.sdk.controller.A r0 = com.ironsource.sdk.controller.A.this
                java.lang.String r0 = r0.a
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "getMediationState("
                r1.<init>(r2)
                r1.append(r9)
                java.lang.String r2 = ")"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.ironsource.sdk.utils.Logger.i(r0, r1)
                com.ironsource.sdk.g.f r0 = new com.ironsource.sdk.g.f
                r0.<init>(r9)
                java.lang.String r1 = "demandSourceName"
                java.lang.String r2 = r0.d(r1)
                java.lang.String r3 = com.ironsource.sdk.utils.SDKUtils.fetchDemandSourceId((com.ironsource.sdk.g.f) r0)
                java.lang.String r4 = "productType"
                java.lang.String r0 = r0.d(r4)
                if (r0 == 0) goto L_0x009b
                if (r2 == 0) goto L_0x009b
                r5 = 0
                com.ironsource.sdk.g.d$e r6 = com.ironsource.sdk.utils.SDKUtils.getProductType(r0)     // Catch:{ Exception -> 0x008d }
                if (r6 == 0) goto L_0x009b
                com.ironsource.sdk.controller.A r7 = com.ironsource.sdk.controller.A.this     // Catch:{ Exception -> 0x008d }
                com.ironsource.sdk.controller.k r7 = r7.V     // Catch:{ Exception -> 0x008d }
                com.ironsource.sdk.g.c r6 = r7.a((com.ironsource.sdk.g.d.e) r6, (java.lang.String) r3)     // Catch:{ Exception -> 0x008d }
                org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x008d }
                r7.<init>()     // Catch:{ Exception -> 0x008d }
                r7.put(r4, r0)     // Catch:{ Exception -> 0x008d }
                r7.put(r1, r2)     // Catch:{ Exception -> 0x008d }
                java.lang.String r0 = "demandSourceId"
                r7.put(r0, r3)     // Catch:{ Exception -> 0x008d }
                if (r6 == 0) goto L_0x0071
                int r0 = r6.c     // Catch:{ Exception -> 0x008d }
                r1 = -1
                if (r0 != r1) goto L_0x005f
                r0 = 1
                goto L_0x0060
            L_0x005f:
                r0 = 0
            L_0x0060:
                if (r0 != 0) goto L_0x0071
                com.ironsource.sdk.controller.A r0 = com.ironsource.sdk.controller.A.this     // Catch:{ Exception -> 0x008d }
                java.lang.String r0 = new com.ironsource.sdk.g.f(r9).d(com.ironsource.sdk.controller.A.ae)     // Catch:{ Exception -> 0x008d }
                java.lang.String r1 = "state"
                int r2 = r6.c     // Catch:{ Exception -> 0x008d }
                r7.put(r1, r2)     // Catch:{ Exception -> 0x008d }
                goto L_0x0077
            L_0x0071:
                com.ironsource.sdk.controller.A r0 = com.ironsource.sdk.controller.A.this     // Catch:{ Exception -> 0x008d }
                java.lang.String r0 = new com.ironsource.sdk.g.f(r9).d(com.ironsource.sdk.controller.A.af)     // Catch:{ Exception -> 0x008d }
            L_0x0077:
                java.lang.String r1 = r7.toString()     // Catch:{ Exception -> 0x008d }
                boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x008d }
                if (r2 != 0) goto L_0x009b
                com.ironsource.sdk.controller.A r2 = com.ironsource.sdk.controller.A.this     // Catch:{ Exception -> 0x008d }
                java.lang.String r0 = com.ironsource.sdk.controller.A.b((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x008d }
                com.ironsource.sdk.controller.A r1 = com.ironsource.sdk.controller.A.this     // Catch:{ Exception -> 0x008d }
                r1.b((java.lang.String) r0)     // Catch:{ Exception -> 0x008d }
                goto L_0x009b
            L_0x008d:
                r0 = move-exception
                com.ironsource.sdk.controller.A r1 = com.ironsource.sdk.controller.A.this
                java.lang.String r2 = r0.getMessage()
                r3 = 0
                com.ironsource.sdk.controller.A.a((com.ironsource.sdk.controller.A) r1, (java.lang.String) r9, (boolean) r5, (java.lang.String) r2, (java.lang.String) r3)
                r0.printStackTrace()
            L_0x009b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.A.d.getDemandSourceState(java.lang.String):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x004e, code lost:
            if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x0052;
         */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
        @android.webkit.JavascriptInterface
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void getDeviceStatus(java.lang.String r5) {
            /*
                r4 = this;
                com.ironsource.sdk.controller.A r0 = com.ironsource.sdk.controller.A.this
                java.lang.String r0 = r0.a
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "getDeviceStatus("
                r1.<init>(r2)
                r1.append(r5)
                java.lang.String r2 = ")"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.ironsource.sdk.utils.Logger.i(r0, r1)
                com.ironsource.sdk.controller.A r0 = com.ironsource.sdk.controller.A.this
                java.lang.String r0 = new com.ironsource.sdk.g.f(r5).d(com.ironsource.sdk.controller.A.ae)
                com.ironsource.sdk.controller.A r1 = com.ironsource.sdk.controller.A.this
                java.lang.String r5 = new com.ironsource.sdk.g.f(r5).d(com.ironsource.sdk.controller.A.af)
                com.ironsource.sdk.controller.A r1 = com.ironsource.sdk.controller.A.this
                android.content.Context r2 = r1.getContext()
                java.lang.Object[] r1 = r1.c((android.content.Context) r2)
                r2 = 0
                r2 = r1[r2]
                java.lang.String r2 = (java.lang.String) r2
                r3 = 1
                r1 = r1[r3]
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                boolean r1 = r1.booleanValue()
                if (r1 == 0) goto L_0x004a
                boolean r0 = android.text.TextUtils.isEmpty(r5)
                if (r0 != 0) goto L_0x0051
                r0 = r5
                goto L_0x0052
            L_0x004a:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L_0x0051
                goto L_0x0052
            L_0x0051:
                r0 = 0
            L_0x0052:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L_0x0067
                com.ironsource.sdk.controller.A r5 = com.ironsource.sdk.controller.A.this
                java.lang.String r1 = "onGetDeviceStatusSuccess"
                java.lang.String r3 = "onGetDeviceStatusFail"
                java.lang.String r5 = com.ironsource.sdk.controller.A.a((java.lang.String) r0, (java.lang.String) r2, (java.lang.String) r1, (java.lang.String) r3)
                com.ironsource.sdk.controller.A r0 = com.ironsource.sdk.controller.A.this
                r0.b((java.lang.String) r5)
            L_0x0067:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.A.d.getDeviceStatus(java.lang.String):void");
        }

        @JavascriptInterface
        public void getDeviceVolume(String str) {
            String b = A.this.a;
            Logger.i(b, "getDeviceVolume(" + str + ")");
            try {
                Context context = A.this.getContext();
                com.ironsource.sdk.utils.a.a(context);
                float b2 = com.ironsource.sdk.utils.a.b(context);
                com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
                fVar.a("deviceVolume", String.valueOf(b2));
                A.a(A.this, fVar.toString(), true, (String) null, (String) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @JavascriptInterface
        public void getInitSummery(String str) {
            String b = A.this.a;
            Logger.i(b, "getInitSummery(" + str + ")");
            com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
            fVar.a("recoveryInfo", A.this.ab);
            A.a(A.this, fVar.toString(), true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void getOrientation(String str) {
            com.ironsource.sdk.a.f.a(com.ironsource.sdk.a.h.y, (Map<String, Object>) new com.ironsource.sdk.a.a().a("generalmessage", str).a);
            String b = new com.ironsource.sdk.g.f(str).d(A.ae);
            String jSONObject = SDKUtils.getOrientation(A.this.getContext()).toString();
            if (!TextUtils.isEmpty(b)) {
                A.this.b(A.a(b, jSONObject, "onGetOrientationSuccess", "onGetOrientationFail"));
            }
        }

        @JavascriptInterface
        public void getUserData(String str) {
            String str2 = str;
            String b = A.this.a;
            Logger.i(b, "getUserData(" + str2 + ")");
            com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str2);
            if (!fVar.a("key")) {
                A.a(A.this, str2, false, "key does not exist", (String) null);
                return;
            }
            String b2 = new com.ironsource.sdk.g.f(str2).d(A.ae);
            String d = fVar.d("key");
            String string = com.ironsource.sdk.utils.b.a().a.getString(d, (String) null);
            if (string == null) {
                string = JsonUtils.EMPTY_JSON;
            }
            A.this.b(A.b(b2, A.a(d, string, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false)));
        }

        @JavascriptInterface
        public void iabTokenAPI(String str) {
            try {
                String b = A.this.a;
                Logger.i(b, "iabTokenAPI(" + str + ")");
                com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
                y q = A.this.p;
                String fVar2 = fVar.toString();
                a aVar = new a();
                JSONObject jSONObject = new JSONObject(fVar2);
                y.a aVar2 = new y.a((byte) 0);
                aVar2.a = jSONObject.optString("functionName");
                aVar2.b = jSONObject.optJSONObject("functionParams");
                aVar2.c = jSONObject.optString("success");
                aVar2.d = jSONObject.optString("fail");
                if ("updateToken".equals(aVar2.a)) {
                    JSONObject jSONObject2 = aVar2.b;
                    com.ironsource.sdk.g.f fVar3 = new com.ironsource.sdk.g.f();
                    try {
                        com.ironsource.sdk.service.c cVar = q.c;
                        com.ironsource.environment.c.e.a("ctgp", jSONObject2);
                        q.b.a(jSONObject2);
                        aVar.a(true, aVar2.c, fVar3);
                    } catch (Exception e) {
                        e.printStackTrace();
                        String str2 = y.a;
                        Logger.i(str2, "updateToken exception " + e.getMessage());
                        aVar.a(false, aVar2.d, fVar3);
                    }
                } else if ("getToken".equals(aVar2.a)) {
                    try {
                        aVar.a(true, aVar2.c, SDKUtils.getControllerConfigAsJSONObject().optBoolean("oneToken") ? q.a() : q.b.b(q.d));
                    } catch (Exception e2) {
                        String str3 = aVar2.d;
                        String message = e2.getMessage();
                        com.ironsource.sdk.g.f fVar4 = new com.ironsource.sdk.g.f();
                        fVar4.a(A.af, str3);
                        fVar4.a("data", message);
                        A.a(A.this, fVar4.toString(), false, (String) null, (String) null);
                    }
                } else {
                    String str4 = y.a;
                    Logger.i(str4, "unhandled API request " + fVar2);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                String b2 = A.this.a;
                Logger.i(b2, "iabTokenAPI failed with exception " + e3.getMessage());
            }
        }

        @JavascriptInterface
        public void initController(String str) {
            String b = A.this.a;
            Logger.i(b, "initController(" + str + ")");
            com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
            if (A.this.f != null) {
                A.this.f.cancel();
                A.this.f = null;
            }
            if (fVar.a("stage")) {
                String d = fVar.d("stage");
                if ("ready".equalsIgnoreCase(d)) {
                    boolean unused = A.this.E = true;
                    A.this.W.b();
                } else if ("loaded".equalsIgnoreCase(d)) {
                    A.this.W.a();
                } else if ("failed".equalsIgnoreCase(d)) {
                    String d2 = fVar.d("errMsg");
                    e h = A.this.W;
                    h.a("controller js failed to initialize : " + d2);
                } else {
                    Logger.i(A.this.a, "No STAGE mentioned! should not get here!");
                }
            }
        }

        @JavascriptInterface
        public void omidAPI(final String str) {
            A.this.a((Runnable) new Runnable() {
                public final void run() {
                    try {
                        String b2 = A.this.a;
                        Logger.i(b2, "omidAPI(" + str + ")");
                        A.this.n.a(new com.ironsource.sdk.g.f(str).toString(), new a());
                    } catch (Exception e) {
                        e.printStackTrace();
                        String b3 = A.this.a;
                        Logger.i(b3, "omidAPI failed with exception " + e.getMessage());
                    }
                }
            });
        }

        @JavascriptInterface
        public void onAdWindowsClosed(String str) {
            String b = A.this.a;
            Logger.i(b, "onAdWindowsClosed(" + str + ")");
            A.this.m.e = -1;
            A.this.m.c = null;
            b unused = A.this.e = null;
            com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
            String d = fVar.d("productType");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(fVar);
            d.e e = A.g(d);
            String z = A.this.x;
            Log.d(z, "onAdClosed() with type " + e);
            if (A.this.a(d)) {
                A.this.a(e, fetchDemandSourceId);
            }
        }

        @JavascriptInterface
        public void onCleanUpNonDisplayBannersSuccess(String str) {
            String b = A.this.a;
            Logger.i(b, "onCleanUpNonDisplayBannersSuccess() value=" + str);
        }

        @JavascriptInterface
        public void onGetApplicationInfoFail(String str) {
            String b = A.this.a;
            Logger.i(b, "onGetApplicationInfoFail(" + str + ")");
            A.a(A.this, str, true, (String) null, (String) null);
            A.c(A.this, "onGetApplicationInfoFail", str);
        }

        @JavascriptInterface
        public void onGetApplicationInfoSuccess(String str) {
            String b = A.this.a;
            Logger.i(b, "onGetApplicationInfoSuccess(" + str + ")");
            A.a(A.this, str, true, (String) null, (String) null);
            A.c(A.this, "onGetApplicationInfoSuccess", str);
        }

        @JavascriptInterface
        public void onGetCachedFilesMapFail(String str) {
            String b = A.this.a;
            Logger.i(b, "onGetCachedFilesMapFail(" + str + ")");
            A.a(A.this, str, true, (String) null, (String) null);
            A.c(A.this, "onGetCachedFilesMapFail", str);
        }

        @JavascriptInterface
        public void onGetCachedFilesMapSuccess(String str) {
            String b = A.this.a;
            Logger.i(b, "onGetCachedFilesMapSuccess(" + str + ")");
            A.a(A.this, str, true, (String) null, (String) null);
            A.c(A.this, "onGetCachedFilesMapSuccess", str);
        }

        @JavascriptInterface
        public void onGetDeviceStatusFail(String str) {
            String b = A.this.a;
            Logger.i(b, "onGetDeviceStatusFail(" + str + ")");
            A.a(A.this, str, true, (String) null, (String) null);
            A.c(A.this, "onGetDeviceStatusFail", str);
        }

        @JavascriptInterface
        public void onGetDeviceStatusSuccess(String str) {
            String b = A.this.a;
            Logger.i(b, "onGetDeviceStatusSuccess(" + str + ")");
            A.a(A.this, str, true, (String) null, (String) null);
            A.c(A.this, "onGetDeviceStatusSuccess", str);
        }

        @JavascriptInterface
        public void onGetUserCreditsFail(String str) {
            String b = A.this.a;
            Logger.i(b, "onGetUserCreditsFail(" + str + ")");
            final String d = new com.ironsource.sdk.g.f(str).d("errMsg");
            if (A.this.a(d.e.OfferWall.toString())) {
                A.this.c((Runnable) new Runnable() {
                    public final void run() {
                        String str = d;
                        if (str == null) {
                            str = "We're sorry, some error occurred. we will investigate it";
                        }
                        A.this.O.onGetOWCreditsFailed(str);
                    }
                });
            }
            A.a(A.this, str, true, (String) null, (String) null);
            A.c(A.this, "onGetUserCreditsFail", str);
        }

        @JavascriptInterface
        public void onInitBannerFail(String str) {
            String b = A.this.a;
            Logger.i(b, "onInitBannerFail(" + str + ")");
            com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
            final String d = fVar.d("errMsg");
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(fVar);
            if (TextUtils.isEmpty(fetchDemandSourceId)) {
                Logger.i(A.this.a, "onInitBannerFail failed with no demand source");
                return;
            }
            com.ironsource.sdk.g.c a2 = A.this.V.a(d.e.a, fetchDemandSourceId);
            if (a2 != null) {
                a2.a(3);
            }
            if (A.this.a(d.e.a.toString())) {
                A.this.c((Runnable) new Runnable() {
                    public final void run() {
                        String str = d;
                        if (str == null) {
                            str = "We're sorry, some error occurred. we will investigate it";
                        }
                        String b2 = A.this.a;
                        Log.d(b2, "onBannerInitFail(message:" + str + ")");
                        A.this.P.a(d.e.a, fetchDemandSourceId, str);
                    }
                });
            }
            A.a(A.this, str, true, (String) null, (String) null);
            A.c(A.this, "onInitBannerFail", str);
        }

        @JavascriptInterface
        public void onInitBannerSuccess(String str) {
            Logger.i(A.this.a, "onInitBannerSuccess()");
            A.c(A.this, "onInitBannerSuccess", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(new com.ironsource.sdk.g.f(str));
            if (TextUtils.isEmpty(fetchDemandSourceId)) {
                Logger.i(A.this.a, "onInitBannerSuccess failed with no demand source");
            } else if (A.this.a(d.e.a.toString())) {
                A.this.c((Runnable) new Runnable() {
                    public final void run() {
                        Log.d(A.this.a, "onBannerInitSuccess()");
                        A.this.P.a(d.e.a, fetchDemandSourceId, (com.ironsource.sdk.g.a) null);
                    }
                });
            }
        }

        @JavascriptInterface
        public void onInitInterstitialFail(String str) {
            String b = A.this.a;
            Logger.i(b, "onInitInterstitialFail(" + str + ")");
            com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
            final String d = fVar.d("errMsg");
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(fVar);
            if (TextUtils.isEmpty(fetchDemandSourceId)) {
                Logger.i(A.this.a, "onInitInterstitialSuccess failed with no demand source");
                return;
            }
            com.ironsource.sdk.g.c a2 = A.this.V.a(d.e.c, fetchDemandSourceId);
            if (a2 != null) {
                a2.a(3);
            }
            if (A.this.a(d.e.c.toString())) {
                A.this.c((Runnable) new Runnable() {
                    public final void run() {
                        String str = d;
                        if (str == null) {
                            str = "We're sorry, some error occurred. we will investigate it";
                        }
                        String b2 = A.this.a;
                        Log.d(b2, "onInterstitialInitFail(message:" + str + ")");
                        A.this.N.a(d.e.c, fetchDemandSourceId, str);
                    }
                });
            }
            A.a(A.this, str, true, (String) null, (String) null);
            A.c(A.this, "onInitInterstitialFail", str);
        }

        @JavascriptInterface
        public void onInitInterstitialSuccess(String str) {
            Logger.i(A.this.a, "onInitInterstitialSuccess()");
            A.c(A.this, "onInitInterstitialSuccess", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(new com.ironsource.sdk.g.f(str));
            if (TextUtils.isEmpty(fetchDemandSourceId)) {
                Logger.i(A.this.a, "onInitInterstitialSuccess failed with no demand source");
            } else if (A.this.a(d.e.c.toString())) {
                A.this.c((Runnable) new Runnable() {
                    public final void run() {
                        Log.d(A.this.a, "onInterstitialInitSuccess()");
                        A.this.N.a(d.e.c, fetchDemandSourceId, (com.ironsource.sdk.g.a) null);
                    }
                });
            }
        }

        @JavascriptInterface
        public void onInitOfferWallFail(String str) {
            String b = A.this.a;
            Logger.i(b, "onInitOfferWallFail(" + str + ")");
            A.this.m.j = false;
            final String d = new com.ironsource.sdk.g.f(str).d("errMsg");
            if (A.this.m.i) {
                A.this.m.i = false;
                if (A.this.a(d.e.OfferWall.toString())) {
                    A.this.c((Runnable) new Runnable() {
                        public final void run() {
                            String str = d;
                            if (str == null) {
                                str = "We're sorry, some error occurred. we will investigate it";
                            }
                            String b2 = A.this.a;
                            Log.d(b2, "onOfferWallInitFail(message:" + str + ")");
                            A.this.O.onOfferwallInitFail(str);
                        }
                    });
                }
            }
            A.a(A.this, str, true, (String) null, (String) null);
            A.c(A.this, "onInitOfferWallFail", str);
        }

        @JavascriptInterface
        public void onInitOfferWallSuccess(String str) {
            A.c(A.this, "onInitOfferWallSuccess", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            A.this.m.j = true;
            if (A.this.m.i) {
                A.this.m.i = false;
                if (A.this.a(d.e.OfferWall.toString())) {
                    A.this.c((Runnable) new Runnable() {
                        public final void run() {
                            Log.d(A.this.a, "onOfferWallInitSuccess()");
                            A.this.O.onOfferwallInitSuccess();
                        }
                    });
                }
            }
        }

        @JavascriptInterface
        public void onInitRewardedVideoFail(String str) {
            String b = A.this.a;
            Logger.i(b, "onInitRewardedVideoFail(" + str + ")");
            com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
            final String d = fVar.d("errMsg");
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(fVar);
            com.ironsource.sdk.g.c a2 = A.this.V.a(d.e.RewardedVideo, fetchDemandSourceId);
            if (a2 != null) {
                a2.a(3);
            }
            if (A.this.a(d.e.RewardedVideo.toString())) {
                A.this.c((Runnable) new Runnable() {
                    public final void run() {
                        String str = d;
                        if (str == null) {
                            str = "We're sorry, some error occurred. we will investigate it";
                        }
                        String b2 = A.this.a;
                        Log.d(b2, "onRVInitFail(message:" + str + ")");
                        A.this.M.a(d.e.RewardedVideo, fetchDemandSourceId, str);
                    }
                });
            }
            A.a(A.this, str, true, (String) null, (String) null);
            A.c(A.this, "onInitRewardedVideoFail", str);
        }

        @JavascriptInterface
        public void onLoadBannerFail(String str) {
            Logger.i(A.this.a, "onLoadBannerFail()");
            com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
            final String d = fVar.d("errMsg");
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(fVar);
            A.a(A.this, str, true, (String) null, (String) null);
            if (!TextUtils.isEmpty(fetchDemandSourceId) && A.this.a(d.e.a.toString())) {
                A.this.c((Runnable) new Runnable() {
                    public final void run() {
                        Log.d(A.this.a, "onLoadBannerFail()");
                        String str = d;
                        if (str == null) {
                            str = "We're sorry, some error occurred. we will investigate it";
                        }
                        A.this.P.d(fetchDemandSourceId, str);
                    }
                });
            }
        }

        @JavascriptInterface
        public void onLoadBannerSuccess(String str) {
            Logger.i(A.this.a, "onLoadBannerSuccess()");
            com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(fVar);
            String d = fVar.d("adViewId");
            A.a(A.this, str, true, (String) null, (String) null);
            com.ironsource.sdk.c.f a2 = com.ironsource.sdk.c.e.a().a(d);
            if (a2 == null) {
                com.ironsource.sdk.j.a.b E = A.this.P;
                E.d(fetchDemandSourceId, "not found view for the current adViewId= " + d);
            } else if (a2 instanceof com.ironsource.sdk.c.b) {
                final com.ironsource.sdk.c.b bVar = (com.ironsource.sdk.c.b) a2;
                if (A.this.a(d.e.a.toString())) {
                    A.this.c((Runnable) new Runnable() {
                        public final void run() {
                            Log.d(A.this.a, "onBannerLoadSuccess()");
                            A.this.P.a(fetchDemandSourceId, bVar);
                        }
                    });
                }
            }
        }

        @JavascriptInterface
        public void onLoadInterstitialFail(String str) {
            String b = A.this.a;
            Logger.i(b, "onLoadInterstitialFail(" + str + ")");
            com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
            final String d = fVar.d("errMsg");
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(fVar);
            A.a(A.this, str, true, (String) null, (String) null);
            if (!TextUtils.isEmpty(fetchDemandSourceId)) {
                a(fetchDemandSourceId, false);
                if (A.this.a(d.e.c.toString())) {
                    A.this.c((Runnable) new Runnable() {
                        public final void run() {
                            String str = d;
                            if (str == null) {
                                str = "We're sorry, some error occurred. we will investigate it";
                            }
                            A.this.N.b(fetchDemandSourceId, str);
                        }
                    });
                }
                A.c(A.this, "onLoadInterstitialFail", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            }
        }

        @JavascriptInterface
        public void onLoadInterstitialSuccess(String str) {
            String b = A.this.a;
            Logger.i(b, "onLoadInterstitialSuccess(" + str + ")");
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(new com.ironsource.sdk.g.f(str));
            a(fetchDemandSourceId, true);
            A.a(A.this, str, true, (String) null, (String) null);
            if (A.this.a(d.e.c.toString())) {
                A.this.c((Runnable) new Runnable() {
                    public final void run() {
                        A.this.N.b(fetchDemandSourceId);
                    }
                });
            }
            A.c(A.this, "onLoadInterstitialSuccess", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        }

        @JavascriptInterface
        public void onOfferWallGeneric(String str) {
            String b = A.this.a;
            Logger.i(b, "onOfferWallGeneric(" + str + ")");
        }

        @JavascriptInterface
        public void onReceivedMessage(final String str) {
            String b = A.this.a;
            Logger.i(b, "onReceivedMessage(" + str + ")");
            com.ironsource.environment.thread.a.a.b(new Runnable() {
                public final void run() {
                    try {
                        if (new JSONObject(str).has("msgId")) {
                            A.this.ac.onReceive(h.a.a(str));
                            return;
                        }
                        A.this.ad.onReceive(r.a(str));
                    } catch (JSONException e) {
                        Logger.e(A.this.a, "failed to parse received message");
                        e.printStackTrace();
                    }
                }
            });
        }

        @JavascriptInterface
        public void onShowInterstitialFail(String str) {
            String b = A.this.a;
            Logger.i(b, "onShowInterstitialFail(" + str + ")");
            com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
            final String d = fVar.d("errMsg");
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(fVar);
            A.a(A.this, str, true, (String) null, (String) null);
            if (!TextUtils.isEmpty(fetchDemandSourceId)) {
                a(fetchDemandSourceId, false);
                if (A.this.a(d.e.c.toString())) {
                    A.this.c((Runnable) new Runnable() {
                        public final void run() {
                            String str = d;
                            if (str == null) {
                                str = "We're sorry, some error occurred. we will investigate it";
                            }
                            A.this.N.c(fetchDemandSourceId, str);
                        }
                    });
                }
                A.c(A.this, "onShowInterstitialFail", str);
            }
        }

        @JavascriptInterface
        public void onShowInterstitialSuccess(String str) {
            String b = A.this.a;
            Logger.i(b, "onShowInterstitialSuccess(" + str + ")");
            A.a(A.this, str, true, (String) null, (String) null);
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(new com.ironsource.sdk.g.f(str));
            if (TextUtils.isEmpty(fetchDemandSourceId)) {
                Logger.i(A.this.a, "onShowInterstitialSuccess called with no demand");
                return;
            }
            A.this.m.e = d.e.c.ordinal();
            A.this.m.c = fetchDemandSourceId;
            if (A.this.a(d.e.c.toString())) {
                A.this.c((Runnable) new Runnable() {
                    public final void run() {
                        A.this.N.c(d.e.c, fetchDemandSourceId);
                        A.this.N.c(fetchDemandSourceId);
                    }
                });
                A.c(A.this, "onShowInterstitialSuccess", str);
            }
            a(fetchDemandSourceId, false);
        }

        @JavascriptInterface
        public void onShowOfferWallFail(String str) {
            String b = A.this.a;
            Logger.i(b, "onShowOfferWallFail(" + str + ")");
            final String d = new com.ironsource.sdk.g.f(str).d("errMsg");
            if (A.this.a(d.e.OfferWall.toString())) {
                A.this.c((Runnable) new Runnable() {
                    public final void run() {
                        String str = d;
                        if (str == null) {
                            str = "We're sorry, some error occurred. we will investigate it";
                        }
                        A.this.O.onOWShowFail(str);
                    }
                });
            }
            A.a(A.this, str, true, (String) null, (String) null);
            A.c(A.this, "onShowOfferWallFail", str);
        }

        @JavascriptInterface
        public void onShowOfferWallSuccess(String str) {
            String b = A.this.a;
            Logger.i(b, "onShowOfferWallSuccess(" + str + ")");
            A.this.m.e = d.e.OfferWall.ordinal();
            final String valueFromJsonObject = SDKUtils.getValueFromJsonObject(str, "placementId");
            if (A.this.a(d.e.OfferWall.toString())) {
                A.this.c((Runnable) new Runnable() {
                    public final void run() {
                        A.this.O.onOWShowSuccess(valueFromJsonObject);
                    }
                });
            }
            A.a(A.this, str, true, (String) null, (String) null);
            A.c(A.this, "onShowOfferWallSuccess", str);
        }

        @JavascriptInterface
        public void onShowRewardedVideoFail(String str) {
            String b = A.this.a;
            Logger.i(b, "onShowRewardedVideoFail(" + str + ")");
            com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
            final String d = fVar.d("errMsg");
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(fVar);
            if (A.this.a(d.e.RewardedVideo.toString())) {
                A.this.c((Runnable) new Runnable() {
                    public final void run() {
                        String str = d;
                        if (str == null) {
                            str = "We're sorry, some error occurred. we will investigate it";
                        }
                        String b2 = A.this.a;
                        Log.d(b2, "onRVShowFail(message:" + d + ")");
                        A.this.M.a(fetchDemandSourceId, str);
                    }
                });
            }
            A.a(A.this, str, true, (String) null, (String) null);
            A.c(A.this, "onShowRewardedVideoFail", str);
        }

        @JavascriptInterface
        public void onShowRewardedVideoSuccess(String str) {
            String b = A.this.a;
            Logger.i(b, "onShowRewardedVideoSuccess(" + str + ")");
            A.a(A.this, str, true, (String) null, (String) null);
            A.c(A.this, "onShowRewardedVideoSuccess", str);
        }

        @JavascriptInterface
        public void onVideoStatusChanged(String str) {
            String b = A.this.a;
            Log.d(b, "onVideoStatusChanged(" + str + ")");
            com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
            String d = fVar.d("productType");
            if (A.this.l != null && !TextUtils.isEmpty(d)) {
                String d2 = fVar.d("status");
                if ("started".equalsIgnoreCase(d2)) {
                    A.this.l.onVideoStarted();
                } else if ("paused".equalsIgnoreCase(d2)) {
                    A.this.l.onVideoPaused();
                } else if ("playing".equalsIgnoreCase(d2)) {
                    A.this.l.onVideoResumed();
                } else if ("ended".equalsIgnoreCase(d2)) {
                    A.this.l.onVideoEnded();
                } else if ("stopped".equalsIgnoreCase(d2)) {
                    A.this.l.onVideoStopped();
                } else {
                    String b2 = A.this.a;
                    Logger.i(b2, "onVideoStatusChanged: unknown status: " + d2);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x007b A[Catch:{ Exception -> 0x00df }] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00d9 A[Catch:{ Exception -> 0x00df }] */
        @android.webkit.JavascriptInterface
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void openUrl(java.lang.String r12) {
            /*
                r11 = this;
                com.ironsource.sdk.controller.A r0 = com.ironsource.sdk.controller.A.this
                java.lang.String r0 = r0.a
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "openUrl("
                r1.<init>(r2)
                r1.append(r12)
                java.lang.String r2 = ")"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.ironsource.sdk.utils.Logger.i(r0, r1)
                com.ironsource.sdk.g.f r0 = new com.ironsource.sdk.g.f
                r0.<init>(r12)
                java.lang.String r1 = "url"
                java.lang.String r1 = r0.d(r1)
                java.lang.String r2 = "method"
                java.lang.String r2 = r0.d(r2)
                java.lang.String r3 = "package_name"
                java.lang.String r0 = r0.d(r3)
                r3 = 0
                r4 = 0
                com.ironsource.sdk.controller.A r5 = com.ironsource.sdk.controller.A.this     // Catch:{ Exception -> 0x00df }
                com.ironsource.sdk.controller.c r5 = r5.u     // Catch:{ Exception -> 0x00df }
                android.app.Activity r5 = r5.a()     // Catch:{ Exception -> 0x00df }
                java.lang.String r6 = r2.toLowerCase()     // Catch:{ Exception -> 0x00df }
                int r7 = r6.hashCode()     // Catch:{ Exception -> 0x00df }
                r8 = -1455867212(0xffffffffa9393ab4, float:-4.112917E-14)
                r9 = 2
                r10 = 1
                if (r7 == r8) goto L_0x006e
                r8 = 109770977(0x68af8e1, float:5.2275525E-35)
                if (r7 == r8) goto L_0x0063
                r8 = 1224424441(0x48fb3bf9, float:514527.78)
                if (r7 == r8) goto L_0x0058
                goto L_0x0078
            L_0x0058:
                java.lang.String r7 = "webview"
                boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x00df }
                if (r6 == 0) goto L_0x0078
                r6 = 1
                goto L_0x0079
            L_0x0063:
                java.lang.String r7 = "store"
                boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x00df }
                if (r6 == 0) goto L_0x0078
                r6 = 2
                goto L_0x0079
            L_0x006e:
                java.lang.String r7 = "external_browser"
                boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x00df }
                if (r6 == 0) goto L_0x0078
                r6 = 0
                goto L_0x0079
            L_0x0078:
                r6 = -1
            L_0x0079:
                if (r6 == 0) goto L_0x00d9
                if (r6 == r10) goto L_0x00b7
                if (r6 == r9) goto L_0x0098
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00df }
                java.lang.String r1 = "method "
                r0.<init>(r1)     // Catch:{ Exception -> 0x00df }
                r0.append(r2)     // Catch:{ Exception -> 0x00df }
                java.lang.String r1 = " is unsupported"
                r0.append(r1)     // Catch:{ Exception -> 0x00df }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00df }
                com.ironsource.sdk.controller.A r1 = com.ironsource.sdk.controller.A.this     // Catch:{ Exception -> 0x00df }
                com.ironsource.sdk.controller.A.a((com.ironsource.sdk.controller.A) r1, (java.lang.String) r12, (boolean) r3, (java.lang.String) r0, (java.lang.String) r4)     // Catch:{ Exception -> 0x00df }
                return
            L_0x0098:
                android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x00df }
                java.lang.Class<com.ironsource.sdk.controller.OpenUrlActivity> r2 = com.ironsource.sdk.controller.OpenUrlActivity.class
                r0.<init>(r5, r2)     // Catch:{ Exception -> 0x00df }
                java.lang.String r2 = com.ironsource.sdk.controller.A.c     // Catch:{ Exception -> 0x00df }
                r0.putExtra(r2, r1)     // Catch:{ Exception -> 0x00df }
                java.lang.String r1 = com.ironsource.sdk.controller.A.b     // Catch:{ Exception -> 0x00df }
                r0.putExtra(r1, r10)     // Catch:{ Exception -> 0x00df }
                java.lang.String r1 = com.ironsource.sdk.controller.A.d     // Catch:{ Exception -> 0x00df }
                r0.putExtra(r1, r10)     // Catch:{ Exception -> 0x00df }
                r5.startActivity(r0)     // Catch:{ Exception -> 0x00df }
                com.ironsource.sdk.controller.A r0 = com.ironsource.sdk.controller.A.this     // Catch:{ Exception -> 0x00df }
            L_0x00b3:
                com.ironsource.sdk.controller.A.a((com.ironsource.sdk.controller.A) r0, (java.lang.String) r12, (boolean) r10, (java.lang.String) r4, (java.lang.String) r4)     // Catch:{ Exception -> 0x00df }
                goto L_0x00ec
            L_0x00b7:
                android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x00df }
                java.lang.Class<com.ironsource.sdk.controller.OpenUrlActivity> r2 = com.ironsource.sdk.controller.OpenUrlActivity.class
                r0.<init>(r5, r2)     // Catch:{ Exception -> 0x00df }
                java.lang.String r2 = com.ironsource.sdk.controller.A.c     // Catch:{ Exception -> 0x00df }
                r0.putExtra(r2, r1)     // Catch:{ Exception -> 0x00df }
                java.lang.String r1 = com.ironsource.sdk.controller.A.d     // Catch:{ Exception -> 0x00df }
                r0.putExtra(r1, r10)     // Catch:{ Exception -> 0x00df }
                java.lang.String r1 = "immersive"
                com.ironsource.sdk.controller.A r2 = com.ironsource.sdk.controller.A.this     // Catch:{ Exception -> 0x00df }
                boolean r2 = r2.U     // Catch:{ Exception -> 0x00df }
                r0.putExtra(r1, r2)     // Catch:{ Exception -> 0x00df }
                r5.startActivity(r0)     // Catch:{ Exception -> 0x00df }
                com.ironsource.sdk.controller.A r0 = com.ironsource.sdk.controller.A.this     // Catch:{ Exception -> 0x00df }
                goto L_0x00b3
            L_0x00d9:
                com.ironsource.environment.a.AnonymousClass1.a(r5, r1, r0)     // Catch:{ Exception -> 0x00df }
                com.ironsource.sdk.controller.A r0 = com.ironsource.sdk.controller.A.this     // Catch:{ Exception -> 0x00df }
                goto L_0x00b3
            L_0x00df:
                r0 = move-exception
                com.ironsource.sdk.controller.A r1 = com.ironsource.sdk.controller.A.this
                java.lang.String r2 = r0.getMessage()
                com.ironsource.sdk.controller.A.a((com.ironsource.sdk.controller.A) r1, (java.lang.String) r12, (boolean) r3, (java.lang.String) r2, (java.lang.String) r4)
                r0.printStackTrace()
            L_0x00ec:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.A.d.openUrl(java.lang.String):void");
        }

        @JavascriptInterface
        public void pauseControllerWebview() {
            A.this.a((Runnable) new Runnable() {
                public final void run() {
                    A.this.i();
                }
            });
        }

        @JavascriptInterface
        public void permissionsAPI(String str) {
            com.ironsource.sdk.g.f fVar;
            String str2;
            try {
                String b = A.this.a;
                Logger.i(b, "permissionsAPI(" + str + ")");
                com.ironsource.sdk.g.f fVar2 = new com.ironsource.sdk.g.f(str);
                u J = A.this.o;
                String fVar3 = fVar2.toString();
                a aVar = new a();
                JSONObject jSONObject = new JSONObject(fVar3);
                u.a aVar2 = new u.a((byte) 0);
                aVar2.a = jSONObject.optString("functionName");
                aVar2.b = jSONObject.optJSONObject("functionParams");
                aVar2.c = jSONObject.optString("success");
                aVar2.d = jSONObject.optString("fail");
                if ("getPermissions".equals(aVar2.a)) {
                    JSONObject jSONObject2 = aVar2.b;
                    fVar = new com.ironsource.sdk.g.f();
                    try {
                        fVar.a("permissions", com.ironsource.environment.c.a(J.a, jSONObject2.getJSONArray("permissions")));
                        aVar.a(true, aVar2.c, fVar);
                    } catch (Exception e) {
                        e.printStackTrace();
                        String str3 = u.b;
                        Logger.i(str3, "PermissionsJSAdapter getPermissions JSON Exception when getting permissions parameter " + e.getMessage());
                        fVar.a("errMsg", e.getMessage());
                        str2 = aVar2.d;
                        aVar.a(false, str2, fVar);
                    }
                } else if ("isPermissionGranted".equals(aVar2.a)) {
                    JSONObject jSONObject3 = aVar2.b;
                    fVar = new com.ironsource.sdk.g.f();
                    try {
                        String string = jSONObject3.getString("permission");
                        fVar.a("permission", string);
                        if (com.ironsource.environment.c.a(J.a, string)) {
                            fVar.a("status", String.valueOf(com.ironsource.environment.c.b(J.a, string)));
                            aVar.a(true, aVar2.c, fVar);
                            return;
                        }
                        fVar.a("status", "unhandledPermission");
                        aVar.a(false, aVar2.d, fVar);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        fVar.a("errMsg", e2.getMessage());
                        str2 = aVar2.d;
                        aVar.a(false, str2, fVar);
                    }
                } else {
                    String str4 = u.b;
                    Logger.i(str4, "PermissionsJSAdapter unhandled API request " + fVar3);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                String b2 = A.this.a;
                Logger.i(b2, "permissionsAPI failed with exception " + e3.getMessage());
            }
        }

        @JavascriptInterface
        public void postAdEventNotification(String str) {
            String str2 = str;
            try {
                String b = A.this.a;
                Logger.i(b, "postAdEventNotification(" + str2 + ")");
                com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str2);
                final String d = fVar.d("eventName");
                if (TextUtils.isEmpty(d)) {
                    A.a(A.this, str2, false, "eventName does not exist", (String) null);
                    return;
                }
                String d2 = fVar.d("dsName");
                String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(fVar);
                String str3 = !TextUtils.isEmpty(fetchDemandSourceId) ? fetchDemandSourceId : d2;
                JSONObject jSONObject = (JSONObject) fVar.c("extData");
                String d3 = fVar.d("productType");
                d.e e = A.g(d3);
                if (A.this.a(d3)) {
                    String b2 = new com.ironsource.sdk.g.f(str2).d(A.ae);
                    if (!TextUtils.isEmpty(b2)) {
                        A.this.b(A.a(b2, A.a("productType", d3, "eventName", d, "demandSourceName", d2, "demandSourceId", str3, (String) null, false), "postAdEventNotificationSuccess", "postAdEventNotificationFail"));
                    }
                    final d.e eVar = e;
                    final String str4 = str3;
                    final JSONObject jSONObject2 = jSONObject;
                    A.this.c((Runnable) new Runnable() {
                        public final void run() {
                            if (eVar == d.e.c || eVar == d.e.RewardedVideo || eVar == d.e.a) {
                                com.ironsource.sdk.j.a.a a2 = A.this.b(eVar);
                                if (a2 != null) {
                                    a2.a(eVar, str4, d, jSONObject2);
                                }
                            } else if (eVar == d.e.OfferWall) {
                                A.this.O.onOfferwallEventNotificationReceived(d, jSONObject2);
                            }
                        }
                    });
                    return;
                }
                A.a(A.this, str2, false, "productType does not exist", (String) null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @JavascriptInterface
        public void removeCloseEventHandler(String str) {
            String b = A.this.a;
            Logger.i(b, "removeCloseEventHandler(" + str + ")");
            if (A.this.G != null) {
                A.this.G.cancel();
            }
            boolean unused = A.this.F = true;
        }

        @JavascriptInterface
        public void removeMessagingInterface(String str) {
            A.this.a((Runnable) new Runnable() {
                public final void run() {
                    A.this.removeJavascriptInterface("GenerateTokenForMessaging");
                }
            });
        }

        @JavascriptInterface
        public void requestToDestroyBanner(String str) {
            String b = A.this.a;
            Logger.i(b, "onCleanUpNonDisplayBannersFail() value=" + str);
        }

        @JavascriptInterface
        public void resumeControllerWebview() {
            A.this.a((Runnable) new Runnable() {
                public final void run() {
                    A.this.j();
                }
            });
        }

        @JavascriptInterface
        public void saveFile(String str) {
            try {
                String b = A.this.a;
                Logger.i(b, "saveFile(" + str + ")");
                com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
                String d = fVar.d("path");
                String d2 = fVar.d(ShareInternalUtility.STAGING_PARAM);
                if (TextUtils.isEmpty(d2)) {
                    A.a(A.this, str, false, "Missing parameters for file", "1");
                    return;
                }
                com.ironsource.sdk.h.c cVar = new com.ironsource.sdk.h.c(IronSourceStorageUtils.buildAbsolutePathToDirInCache(A.this.R, d), SDKUtils.getFileName(d2));
                IronSourceStorageUtils.ensurePathSafety(cVar, A.this.R);
                if (com.ironsource.environment.h.a(A.this.R) <= 0) {
                    A.a(A.this, str, false, "no_disk_space", (String) null);
                } else if (!SDKUtils.isExternalStorageAvailable()) {
                    A.a(A.this, str, false, "storage_unavailable", (String) null);
                } else if (cVar.exists()) {
                    A.a(A.this, str, false, "file_already_exist", (String) null);
                } else if (!a.AnonymousClass1.b(A.this.getContext())) {
                    A.a(A.this, str, false, "no_network_connection", (String) null);
                } else {
                    A.a(A.this, str, true, (String) null, (String) null);
                    int a2 = fVar.a("connectionTimeout", 0);
                    int a3 = fVar.a("readTimeout", 0);
                    com.ironsource.sdk.l.d o = A.this.D;
                    o.a(cVar, d2, a2, a3, o.a).start();
                }
            } catch (Exception e) {
                A.a(A.this, str, false, e.getMessage(), (String) null);
                e.printStackTrace();
            }
        }

        @JavascriptInterface
        public void setBackButtonState(String str) {
            String b = A.this.a;
            Logger.i(b, "setBackButtonState(" + str + ")");
            String d = new com.ironsource.sdk.g.f(str).d("state");
            SharedPreferences.Editor edit = com.ironsource.sdk.utils.b.a().a.edit();
            edit.putString("back_button_state", d);
            edit.apply();
        }

        @JavascriptInterface
        public void setForceClose(String str) {
            String b = A.this.a;
            Logger.i(b, "setForceClose(" + str + ")");
            com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
            String d = fVar.d(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            String d2 = fVar.d(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            int unused = A.this.H = Integer.parseInt(d);
            int unused2 = A.this.I = Integer.parseInt(d2);
            String unused3 = A.this.J = fVar.d("position");
        }

        @JavascriptInterface
        public void setMixedContentAlwaysAllow(String str) {
            String b = A.this.a;
            Logger.i(b, "setMixedContentAlwaysAllow(" + str + ")");
            A.this.a((Runnable) new Runnable() {
                public final void run() {
                    if (Build.VERSION.SDK_INT >= 21) {
                        A.this.getSettings().setMixedContentMode(0);
                    }
                }
            });
        }

        @JavascriptInterface
        public void setOrientation(String str) {
            String b = A.this.a;
            Logger.i(b, "setOrientation(" + str + ")");
            String d = new com.ironsource.sdk.g.f(str).d(AdUnitActivity.EXTRA_ORIENTATION);
            A.this.k = d;
            if (A.this.v != null) {
                A.this.v.onOrientationChanged(d, com.ironsource.environment.h.k(A.this.getContext()));
            }
        }

        @JavascriptInterface
        public void setStoreSearchKeys(String str) {
            String b = A.this.a;
            Logger.i(b, "setStoreSearchKeys(" + str + ")");
            SharedPreferences.Editor edit = com.ironsource.sdk.utils.b.a().a.edit();
            edit.putString("search_keys", str);
            edit.apply();
        }

        @JavascriptInterface
        public void setTouchListener(String str) {
            String b = A.this.a;
            Logger.i(b, "removeCloseEventHandler(" + str + ")");
            A.this.a((Runnable) new Runnable() {
                public final void run() {
                    A.this.setOnTouchListener(new h(A.this, (byte) 0));
                }
            });
        }

        @JavascriptInterface
        public void setUserData(String str) {
            String str2 = str;
            String b = A.this.a;
            Logger.i(b, "setUserData(" + str2 + ")");
            com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str2);
            if (!fVar.a("key")) {
                A.a(A.this, str2, false, "key does not exist", (String) null);
            } else if (!fVar.a("value")) {
                A.a(A.this, str2, false, "value does not exist", (String) null);
            } else {
                String d = fVar.d("key");
                String d2 = fVar.d("value");
                SharedPreferences.Editor edit = com.ironsource.sdk.utils.b.a().a.edit();
                edit.putString(d, d2);
                edit.apply();
                A.this.b(A.b(new com.ironsource.sdk.g.f(str2).d(A.ae), A.a(d, d2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false)));
            }
        }

        @JavascriptInterface
        public void setWebviewBackgroundColor(String str) {
            String b = A.this.a;
            Logger.i(b, "setWebviewBackgroundColor(" + str + ")");
            A.g(A.this, str);
        }
    }

    interface e {
        void a(String str, d.e eVar, com.ironsource.sdk.g.c cVar);
    }

    static class f {
        String a;
        String b;

        f() {
        }
    }

    public enum g {
        Display,
        Gone
    }

    class h implements View.OnTouchListener {
        private h() {
        }

        /* synthetic */ h(A a2, byte b) {
            this();
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                String b = A.this.a;
                StringBuilder sb = new StringBuilder("X:");
                int i = (int) x;
                sb.append(i);
                sb.append(" Y:");
                int i2 = (int) y;
                sb.append(i2);
                Logger.i(b, sb.toString());
                int m = com.ironsource.environment.h.m();
                int n = com.ironsource.environment.h.n();
                String b2 = A.this.a;
                Logger.i(b2, "Width:" + m + " Height:" + n);
                int dpToPx = SDKUtils.dpToPx((long) A.this.H);
                int dpToPx2 = SDKUtils.dpToPx((long) A.this.I);
                if ("top-right".equalsIgnoreCase(A.this.J)) {
                    i = m - i;
                } else if (!"top-left".equalsIgnoreCase(A.this.J)) {
                    if ("bottom-right".equalsIgnoreCase(A.this.J)) {
                        i = m - i;
                    } else if (!"bottom-left".equalsIgnoreCase(A.this.J)) {
                        i = 0;
                        i2 = 0;
                    }
                    i2 = n - i2;
                }
                if (i <= dpToPx && i2 <= dpToPx2) {
                    boolean unused = A.this.F = false;
                    if (A.this.G != null) {
                        A.this.G.cancel();
                    }
                    CountDownTimer unused2 = A.this.G = new CountDownTimer(2000, 500) {
                        public final void onFinish() {
                            Logger.i(A.this.a, "Close Event Timer Finish");
                            if (A.this.F) {
                                boolean unused = A.this.F = false;
                            } else {
                                A.this.d("forceClose");
                            }
                        }

                        public final void onTick(long j) {
                            String b = A.this.a;
                            Logger.i(b, "Close Event Timer Tick " + j);
                        }
                    }.start();
                }
            }
            return false;
        }
    }

    class i extends WebViewClient {
        private i() {
        }

        /* synthetic */ i(A a2, byte b) {
            this();
        }

        public final void onPageFinished(WebView webView, String str) {
            Logger.i("onPageFinished", str);
            if (str.contains("adUnit") || str.contains("index.html")) {
                A.this.b(A.f("pageFinished"));
            }
            super.onPageFinished(webView, str);
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Logger.i("onPageStarted", str);
            super.onPageStarted(webView, str, bitmap);
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            Logger.i("onReceivedError", str2 + " " + str);
            if (str2.contains("mobileController.html") && A.this.W != null) {
                e h = A.this.W;
                h.a("controller html - web-view receivedError on loading - " + str + " (errorCode: " + i + ")");
            }
            super.onReceivedError(webView, i, str, str2);
        }

        public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            String b = A.this.a;
            Log.e(b, "Chromium process crashed - detail.didCrash(): " + renderProcessGoneDetail.didCrash());
            String str = renderProcessGoneDetail.didCrash() ? "Render process was observed to crash" : "Render process was killed by the system";
            if (A.this.W != null) {
                A.this.W.b(str);
            }
            A a2 = A.this;
            if (a2.e == null) {
                return true;
            }
            a2.h();
            d.e eVar = a2.e.a;
            String str2 = a2.e.b;
            if (!a2.a(eVar.toString())) {
                return true;
            }
            a2.a(eVar, str2);
            return true;
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            boolean z;
            Logger.i("shouldInterceptRequest", str);
            try {
                z = new URL(str).getFile().contains("mraid.js");
            } catch (MalformedURLException unused) {
                z = false;
            }
            if (z) {
                String str2 = AdPayload.FILE_SCHEME + A.this.R + File.separator + "mraid.js";
                try {
                    new FileInputStream(new File(str2));
                    return new WebResourceResponse("text/javascript", "UTF-8", getClass().getResourceAsStream(str2));
                } catch (FileNotFoundException unused2) {
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Logger.i("shouldOverrideUrlLoading", str);
            try {
                if (A.this.e(str)) {
                    A.this.b();
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    public A(Context context, k kVar, C0236c cVar, e eVar, com.ironsource.environment.thread.a aVar, int i2, com.ironsource.sdk.l.d dVar, String str, n.a aVar2, n.b bVar, String str2, String str3) {
        super(context);
        Logger.i(this.a, "C'tor");
        this.u = cVar;
        this.W = eVar;
        this.w = aVar;
        this.V = kVar;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.i = new FrameLayout(context);
        this.K = new FrameLayout(context);
        this.K.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.K.setVisibility(8);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(this);
        this.i.addView(this.K, layoutParams);
        this.i.addView(frameLayout);
        this.R = str;
        this.m = new com.ironsource.sdk.g.b();
        this.ab = new JSONObject();
        this.D = dVar;
        dVar.a.a = this;
        this.ac = aVar2;
        this.ad = bVar;
        this.S = new f(SDKUtils.getNetworkConfiguration(), this.R, SDKUtils.getControllerUrl(), dVar);
        a aVar3 = new a(this, (byte) 0);
        this.g = aVar3;
        setWebViewClient(new i(this, (byte) 0));
        setWebChromeClient(aVar3);
        com.ironsource.sdk.utils.d.a(this);
        w wVar = new w(UUID.randomUUID().toString());
        addJavascriptInterface(new i(new d(new d()), wVar), "Android");
        addJavascriptInterface(new v(wVar), "GenerateTokenForMessaging");
        setDownloadListener(this);
        this.aa = new com.ironsource.sdk.service.Connectivity.b(SDKUtils.getControllerConfigAsJSONObject(), context) {
            public final void a() {
                if (A.this.E) {
                    A.this.c("none");
                }
            }

            public final void a(String str) {
                if (A.this.E) {
                    A.this.c(str);
                }
            }

            public final void a(String str, JSONObject jSONObject) {
                if (jSONObject != null && A.this.E) {
                    try {
                        jSONObject.put("connectionType", str);
                        A a = A.this;
                        String str2 = a.a;
                        Logger.i(str2, "device connection info changed: " + jSONObject.toString());
                        a.b(A.b("connectionInfoChanged", A.a("connectionInfo", jSONObject.toString(), (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false)));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        a(context);
        y = i2;
        this.A = str2;
        this.B = str3;
    }

    public static int a() {
        return y;
    }

    /* access modifiers changed from: private */
    public static String a(String str, String str2, String str3, String str4) {
        return new q.a(str, str2, str3, str4).a();
    }

    public static String a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                jSONObject.put(str, SDKUtils.encodeString(str2));
            }
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                jSONObject.put(str3, SDKUtils.encodeString(str4));
            }
            if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                jSONObject.put(str5, SDKUtils.encodeString(str6));
            }
            if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str8)) {
                jSONObject.put(str7, SDKUtils.encodeString(str8));
            }
            if (!TextUtils.isEmpty(str9)) {
                jSONObject.put(str9, z2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private Map<String, String> a(d.e eVar) {
        if (eVar == d.e.OfferWall) {
            return this.C;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0017, code lost:
        if (android.text.TextUtils.isEmpty(r1) == false) goto L_0x0023;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.ironsource.sdk.controller.A r3, java.lang.String r4, boolean r5, java.lang.String r6, java.lang.String r7) {
        /*
            com.ironsource.sdk.g.f r0 = new com.ironsource.sdk.g.f
            r0.<init>(r4)
            java.lang.String r1 = ae
            java.lang.String r1 = r0.d(r1)
            java.lang.String r2 = af
            java.lang.String r0 = r0.d(r2)
            if (r5 == 0) goto L_0x001a
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto L_0x0022
            goto L_0x0023
        L_0x001a:
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 != 0) goto L_0x0022
            r1 = r0
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto L_0x005c
            boolean r5 = android.text.TextUtils.isEmpty(r6)
            if (r5 != 0) goto L_0x0040
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x003f }
            r5.<init>(r4)     // Catch:{ JSONException -> 0x003f }
            java.lang.String r0 = "errMsg"
            org.json.JSONObject r5 = r5.put(r0, r6)     // Catch:{ JSONException -> 0x003f }
            java.lang.String r4 = r5.toString()     // Catch:{ JSONException -> 0x003f }
            goto L_0x0040
        L_0x003f:
        L_0x0040:
            boolean r5 = android.text.TextUtils.isEmpty(r7)
            if (r5 != 0) goto L_0x0055
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0055 }
            r5.<init>(r4)     // Catch:{ JSONException -> 0x0055 }
            java.lang.String r6 = "errCode"
            org.json.JSONObject r5 = r5.put(r6, r7)     // Catch:{ JSONException -> 0x0055 }
            java.lang.String r4 = r5.toString()     // Catch:{ JSONException -> 0x0055 }
        L_0x0055:
            java.lang.String r4 = b((java.lang.String) r1, (java.lang.String) r4)
            r3.b((java.lang.String) r4)
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.A.a(com.ironsource.sdk.controller.A, java.lang.String, boolean, java.lang.String, java.lang.String):void");
    }

    static /* synthetic */ void a(A a2, JSONObject jSONObject) {
        if (jSONObject.optBoolean("inspectWebview")) {
            setWebContentsDebuggingEnabled(true);
        }
    }

    /* access modifiers changed from: private */
    public void a(final String str, final d.e eVar, final com.ironsource.sdk.g.c cVar) {
        if (a(eVar.toString())) {
            c((Runnable) new Runnable() {
                public final void run() {
                    if (d.e.RewardedVideo == eVar || d.e.c == eVar || d.e.a == eVar) {
                        com.ironsource.sdk.g.c cVar = cVar;
                        if (cVar != null && !TextUtils.isEmpty(cVar.b)) {
                            com.ironsource.sdk.j.a.a a2 = A.this.b(eVar);
                            String b2 = A.this.a;
                            Log.d(b2, "onAdProductInitFailed (message:" + str + ")(" + eVar + ")");
                            if (a2 != null) {
                                a2.a(eVar, cVar.b, str);
                            }
                        }
                    } else if (d.e.OfferWall == eVar) {
                        A.this.O.onOfferwallInitFail(str);
                    } else if (d.e.OfferWallCredits == eVar) {
                        A.this.O.onGetOWCreditsFailed(str);
                    }
                }
            });
        }
    }

    private void a(String str, d.e eVar, com.ironsource.sdk.g.c cVar, e eVar2) {
        String a2;
        String str2;
        if (TextUtils.isEmpty(str)) {
            eVar2.a("Application key are missing", eVar, cVar);
            return;
        }
        f fVar = new f();
        if (eVar == d.e.RewardedVideo || eVar == d.e.c || eVar == d.e.OfferWall || eVar == d.e.a) {
            HashMap hashMap = new HashMap();
            hashMap.put("applicationKey", this.A);
            if (!TextUtils.isEmpty(this.B)) {
                hashMap.put("applicationUserId", this.B);
            }
            if (cVar != null) {
                if (cVar.d != null) {
                    hashMap.putAll(cVar.d);
                    com.ironsource.sdk.service.a aVar = com.ironsource.sdk.service.a.a;
                    hashMap.put("loadStartTime", String.valueOf(com.ironsource.sdk.service.a.a(cVar.b)));
                }
                hashMap.put("demandSourceName", cVar.a);
                hashMap.put("demandSourceId", cVar.b);
            }
            Map<String, String> a3 = a(eVar);
            if (a3 != null) {
                hashMap.putAll(a3);
            }
            String flatMapToJsonAsString = SDKUtils.flatMapToJsonAsString(hashMap);
            a.C0120a aVar2 = new a.C0120a();
            if (eVar == d.e.RewardedVideo) {
                aVar2.a = "initRewardedVideo";
                aVar2.b = "onInitRewardedVideoSuccess";
                str2 = "onInitRewardedVideoFail";
            } else if (eVar == d.e.c) {
                aVar2.a = "initInterstitial";
                aVar2.b = "onInitInterstitialSuccess";
                str2 = "onInitInterstitialFail";
            } else if (eVar == d.e.OfferWall) {
                aVar2.a = "initOfferWall";
                aVar2.b = "onInitOfferWallSuccess";
                str2 = "onInitOfferWallFail";
            } else {
                if (eVar == d.e.a) {
                    aVar2.a = "initBanner";
                    aVar2.b = "onInitBannerSuccess";
                    str2 = "onInitBannerFail";
                }
                a2 = a(aVar2.a, flatMapToJsonAsString, aVar2.b, aVar2.c);
                fVar.a = aVar2.a;
            }
            aVar2.c = str2;
            a2 = a(aVar2.a, flatMapToJsonAsString, aVar2.b, aVar2.c);
            fVar.a = aVar2.a;
        } else {
            if (eVar == d.e.OfferWallCredits) {
                a2 = a("getUserCredits", a("productType", "OfferWall", "applicationKey", this.A, "applicationUserId", this.B, (String) null, (String) null, (String) null, false), AbstractJsonLexerKt.NULL, "onGetUserCreditsFail");
                fVar.a = "getUserCredits";
            }
            b(fVar.b);
        }
        fVar.b = a2;
        b(fVar.b);
    }

    private void a(String str, String str2, com.ironsource.sdk.g.c cVar, com.ironsource.sdk.j.a.d dVar) {
        this.A = str;
        this.B = str2;
        this.M = dVar;
        this.m.a = str;
        this.m.b = str2;
        a(str, d.e.RewardedVideo, cVar, (e) new e() {
            public final void a(String str, d.e eVar, com.ironsource.sdk.g.c cVar) {
                A.this.a(str, eVar, cVar);
            }
        });
    }

    private void a(String str, String str2, String str3) {
        try {
            b(b("assetCachedFailed", a(ShareInternalUtility.STAGING_PARAM, str, "path", h(str2), "errMsg", str3, (String) null, (String) null, (String) null, false)));
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public com.ironsource.sdk.j.a.a b(d.e eVar) {
        if (eVar == d.e.c) {
            return this.N;
        }
        if (eVar == d.e.RewardedVideo) {
            return this.M;
        }
        if (eVar == d.e.a) {
            return this.P;
        }
        return null;
    }

    public static String b(String str, String str2) {
        return new q.a(str, str2).a();
    }

    static /* synthetic */ void b(A a2, Context context) {
        try {
            com.ironsource.sdk.service.Connectivity.b bVar = a2.aa;
            if (bVar != null) {
                bVar.a.a(context);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private String c(JSONObject jSONObject) {
        com.ironsource.sdk.utils.a a2 = com.ironsource.sdk.utils.a.a(getContext());
        StringBuilder sb = new StringBuilder();
        String sDKVersion = SDKUtils.getSDKVersion();
        if (!TextUtils.isEmpty(sDKVersion)) {
            sb.append("SDKVersion=");
            sb.append(sDKVersion);
            sb.append("&");
        }
        String str = a2.c;
        if (!TextUtils.isEmpty(str)) {
            sb.append("deviceOs=");
            sb.append(str);
        }
        Uri parse = Uri.parse(SDKUtils.getControllerUrl());
        if (parse != null) {
            String str2 = parse.getScheme() + CertificateUtil.DELIMITER;
            String host = parse.getHost();
            int port = parse.getPort();
            if (port != -1) {
                host = host + CertificateUtil.DELIMITER + port;
            }
            sb.append("&protocol=");
            sb.append(str2);
            sb.append("&domain=");
            sb.append(host);
            if (jSONObject.keys().hasNext()) {
                try {
                    String jSONObject2 = new JSONObject(jSONObject, new String[]{"isSecured", "applicationKey"}).toString();
                    if (!TextUtils.isEmpty(jSONObject2)) {
                        sb.append("&controllerConfig");
                        sb.append("=");
                        sb.append(jSONObject2);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            sb.append("&debug=");
            sb.append(y);
        }
        return sb.toString();
    }

    static /* synthetic */ void c(A a2, Context context) {
        try {
            com.ironsource.sdk.service.Connectivity.b bVar = a2.aa;
            if (bVar != null) {
                bVar.a.b(context);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    static /* synthetic */ void c(A a2, final String str, String str2) {
        final String d2 = new com.ironsource.sdk.g.f(str2).d("errMsg");
        if (!TextUtils.isEmpty(d2)) {
            a2.a((Runnable) new Runnable() {
                public final void run() {
                    if (A.a() == d.C0121d.MODE_3.d) {
                        Activity a2 = A.this.u.a();
                        Toast.makeText(a2, str + " : " + d2, 1).show();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public Object[] c(Context context) {
        boolean z2;
        com.ironsource.sdk.utils.a a2 = com.ironsource.sdk.utils.a.a(context);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appOrientation", "none");
            jSONObject.put("deviceOrientation", SDKUtils.translateDeviceOrientation(com.ironsource.environment.h.o(context)));
            String str = a2.a;
            if (str != null) {
                jSONObject.put(SDKUtils.encodeString("deviceOEM"), SDKUtils.encodeString(str));
            }
            String str2 = a2.b;
            if (str2 != null) {
                jSONObject.put(SDKUtils.encodeString("deviceModel"), SDKUtils.encodeString(str2));
                z2 = false;
            } else {
                z2 = true;
            }
            try {
                SDKUtils.loadGoogleAdvertiserInfo(context);
                String advertiserId = SDKUtils.getAdvertiserId();
                if (!TextUtils.isEmpty(advertiserId)) {
                    Logger.i(this.a, "add AID");
                    jSONObject.put("deviceIds[AID]", SDKUtils.encodeString(advertiserId));
                }
                String limitAdTracking = SDKUtils.getLimitAdTracking();
                if (!TextUtils.isEmpty(limitAdTracking)) {
                    Logger.i(this.a, "add LAT");
                    jSONObject.put("isLimitAdTrackingEnabled", Boolean.parseBoolean(limitAdTracking));
                }
                String str3 = a2.c;
                if (str3 != null) {
                    jSONObject.put(SDKUtils.encodeString("deviceOs"), SDKUtils.encodeString(str3));
                } else {
                    z2 = true;
                }
                String str4 = a2.d;
                if (str4 != null) {
                    jSONObject.put(SDKUtils.encodeString("deviceOSVersion"), str4.replaceAll("[^0-9/.]", ""));
                } else {
                    z2 = true;
                }
                String str5 = a2.d;
                if (str5 != null) {
                    jSONObject.put(SDKUtils.encodeString("deviceOSVersionFull"), SDKUtils.encodeString(str5));
                }
                String valueOf = String.valueOf(a2.e);
                if (valueOf != null) {
                    jSONObject.put(SDKUtils.encodeString("deviceApiLevel"), valueOf);
                } else {
                    z2 = true;
                }
                String sDKVersion = SDKUtils.getSDKVersion();
                if (sDKVersion != null) {
                    jSONObject.put(SDKUtils.encodeString("SDKVersion"), SDKUtils.encodeString(sDKVersion));
                }
                if (a2.f != null && a2.f.length() > 0) {
                    jSONObject.put(SDKUtils.encodeString("mobileCarrier"), SDKUtils.encodeString(a2.f));
                }
                String a3 = com.ironsource.d.a.a(context);
                if (!a3.equals("none")) {
                    jSONObject.put(SDKUtils.encodeString("connectionType"), SDKUtils.encodeString(a3));
                } else {
                    z2 = true;
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    jSONObject.put(SDKUtils.encodeString("hasVPN"), com.ironsource.d.a.c(context));
                }
                jSONObject.put("uxt", IronSourceStorageUtils.isUxt());
                String language = context.getResources().getConfiguration().locale.getLanguage();
                if (!TextUtils.isEmpty(language)) {
                    jSONObject.put(SDKUtils.encodeString("deviceLanguage"), SDKUtils.encodeString(language.toUpperCase()));
                }
                if (SDKUtils.isExternalStorageAvailable()) {
                    jSONObject.put(SDKUtils.encodeString("diskFreeSize"), SDKUtils.encodeString(String.valueOf(com.ironsource.environment.h.a(this.R))));
                } else {
                    z2 = true;
                }
                String valueOf2 = String.valueOf(com.ironsource.environment.h.m());
                if (!TextUtils.isEmpty(valueOf2)) {
                    jSONObject.put(SDKUtils.encodeString("deviceScreenSize") + "[" + SDKUtils.encodeString(ViewHierarchyConstants.DIMENSION_WIDTH_KEY) + "]", SDKUtils.encodeString(valueOf2));
                } else {
                    z2 = true;
                }
                String valueOf3 = String.valueOf(com.ironsource.environment.h.n());
                jSONObject.put(SDKUtils.encodeString("deviceScreenSize") + "[" + SDKUtils.encodeString(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY) + "]", SDKUtils.encodeString(valueOf3));
                String packageName = getContext().getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    jSONObject.put(SDKUtils.encodeString("bundleId"), SDKUtils.encodeString(packageName));
                }
                String valueOf4 = String.valueOf(com.ironsource.environment.h.o());
                if (!TextUtils.isEmpty(valueOf4)) {
                    jSONObject.put(SDKUtils.encodeString("deviceScreenScale"), SDKUtils.encodeString(valueOf4));
                }
                String valueOf5 = String.valueOf(com.ironsource.environment.h.j());
                if (!TextUtils.isEmpty(valueOf5)) {
                    jSONObject.put(SDKUtils.encodeString("unLocked"), SDKUtils.encodeString(valueOf5));
                }
                com.ironsource.sdk.utils.a.a(context);
                jSONObject.put(SDKUtils.encodeString("deviceVolume"), (double) com.ironsource.sdk.utils.a.b(context));
                jSONObject.put(SDKUtils.encodeString("batteryLevel"), com.ironsource.environment.h.v(context));
                jSONObject.put(SDKUtils.encodeString(ThroughputConfigUtil.SHARED_PREFS_KEY_MCC), a.AnonymousClass1.c(context));
                jSONObject.put(SDKUtils.encodeString(ThroughputConfigUtil.SHARED_PREFS_KEY_MNC), a.AnonymousClass1.d(context));
                jSONObject.put(SDKUtils.encodeString("phoneType"), a.AnonymousClass1.f(context));
                jSONObject.put(SDKUtils.encodeString("simOperator"), SDKUtils.encodeString(a.AnonymousClass1.e(context)));
                jSONObject.put(SDKUtils.encodeString("lastUpdateTime"), com.ironsource.environment.c.b(context));
                jSONObject.put(SDKUtils.encodeString("firstInstallTime"), com.ironsource.environment.c.a(context));
                jSONObject.put(SDKUtils.encodeString("appVersion"), SDKUtils.encodeString(com.ironsource.environment.c.c(context)));
                String d2 = com.ironsource.environment.c.d(context);
                if (!TextUtils.isEmpty(d2)) {
                    jSONObject.put(SDKUtils.encodeString("installerPackageName"), SDKUtils.encodeString(d2));
                }
                jSONObject.put(SDKUtils.encodeString("gpi"), k.a(getContext()));
                jSONObject.put(SDKUtils.encodeString("screenBrightness"), com.ironsource.environment.h.z(context));
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
                return new Object[]{jSONObject.toString(), Boolean.valueOf(z2)};
            }
        } catch (JSONException e3) {
            e = e3;
            z2 = false;
            e.printStackTrace();
            return new Object[]{jSONObject.toString(), Boolean.valueOf(z2)};
        }
        return new Object[]{jSONObject.toString(), Boolean.valueOf(z2)};
    }

    /* access modifiers changed from: private */
    public Object[] c(String str, String str2) {
        boolean z2;
        JSONObject jSONObject = new JSONObject();
        Map<String, String> map = null;
        if (!TextUtils.isEmpty(str)) {
            d.e g2 = g(str);
            if (g2 == d.e.OfferWall) {
                map = this.C;
            } else {
                com.ironsource.sdk.g.c a2 = this.V.a(g2, str2);
                if (a2 != null) {
                    Map<String, String> map2 = a2.d;
                    map2.put("demandSourceName", a2.a);
                    map2.put("demandSourceId", a2.b);
                    map = map2;
                }
            }
            try {
                jSONObject.put("productType", str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            try {
                Map<String, String> initSDKParams = SDKUtils.getInitSDKParams();
                if (initSDKParams != null) {
                    jSONObject = SDKUtils.mergeJSONObjects(jSONObject, new JSONObject(initSDKParams));
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (!TextUtils.isEmpty(this.B)) {
            try {
                jSONObject.put(SDKUtils.encodeString("applicationUserId"), SDKUtils.encodeString(this.B));
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.A)) {
            try {
                jSONObject.put(SDKUtils.encodeString("applicationKey"), SDKUtils.encodeString(this.A));
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        } else {
            z2 = true;
        }
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                if (((String) next.getKey()).equalsIgnoreCase("sdkWebViewCache")) {
                    if (((String) next.getValue()).equalsIgnoreCase("0")) {
                        getSettings().setCacheMode(2);
                    } else {
                        getSettings().setCacheMode(-1);
                    }
                }
                try {
                    jSONObject.put(SDKUtils.encodeString((String) next.getKey()), SDKUtils.encodeString((String) next.getValue()));
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            }
        }
        return new Object[]{jSONObject.toString(), Boolean.valueOf(z2)};
    }

    static String f(String str) {
        return new q.a(str).a();
    }

    /* access modifiers changed from: private */
    public static d.e g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase(d.e.c.toString())) {
            return d.e.c;
        }
        if (str.equalsIgnoreCase(d.e.RewardedVideo.toString())) {
            return d.e.RewardedVideo;
        }
        if (str.equalsIgnoreCase(d.e.OfferWall.toString())) {
            return d.e.OfferWall;
        }
        if (str.equalsIgnoreCase(d.e.a.toString())) {
            return d.e.a;
        }
        return null;
    }

    static /* synthetic */ void g(A a2, String str) {
        com.ironsource.sdk.g.f fVar = new com.ironsource.sdk.g.f(str);
        String d2 = fVar.d("color");
        String d3 = fVar.d("adViewId");
        int parseColor = !"transparent".equalsIgnoreCase(d2) ? Color.parseColor(d2) : 0;
        if (d3 != null) {
            WebView a3 = com.ironsource.sdk.c.e.a().a(d3).a();
            if (a3 != null) {
                a3.setBackgroundColor(parseColor);
                return;
            }
            return;
        }
        a2.setBackgroundColor(parseColor);
    }

    private String h(String str) {
        String str2 = this.R + File.separator;
        return str.contains(str2) ? str.substring(str2.length()) : str;
    }

    static /* synthetic */ void h(A a2, String str) {
        try {
            String str2 = a2.a;
            Logger.i(str2, "load(): " + str);
            a2.loadUrl(str);
        } catch (Throwable th) {
            String str3 = a2.a;
            Logger.e(str3, "WebViewController::load: " + th);
        }
    }

    public final void a(int i2) {
        if (this.S.a()) {
            final JSONObject controllerConfigAsJSONObject = SDKUtils.getControllerConfigAsJSONObject();
            String c2 = c(controllerConfigAsJSONObject);
            Map<String, String> initSDKParams = SDKUtils.getInitSDKParams();
            if (initSDKParams != null && initSDKParams.containsKey("sessionid")) {
                c2 = String.format("%s&sessionid=%s", new Object[]{c2, initSDKParams.get("sessionid")});
            }
            final String str = this.S.d().toURI().toString() + "?" + c2;
            this.w.a(new Runnable() {
                public final void run() {
                    A.a(A.this, controllerConfigAsJSONObject);
                    A.h(A.this, "about:blank");
                    A.h(A.this, str);
                }
            });
            this.f = new CountDownTimer(50000, 1000, i2) {
                private /* synthetic */ int b;

                {
                    this.b = r6;
                }

                public final void onFinish() {
                    Logger.i(A.this.a, "Loading Controller Timer Finish");
                    int i = this.b;
                    if (i == 3) {
                        A.this.c((Runnable) new Runnable() {
                            public final void run() {
                                A.this.W.a("controller html - failed to load into web-view");
                            }
                        });
                    } else {
                        A.this.a(i + 1);
                    }
                }

                public final void onTick(long j) {
                    String b2 = A.this.a;
                    Logger.i(b2, "Loading Controller Timer Tick " + j);
                }
            }.start();
            return;
        }
        Logger.i(this.a, "load(): Mobile Controller HTML Does not exist");
    }

    public final void a(Activity activity) {
        this.u.a(activity);
    }

    public final void a(final Context context) {
        b((Runnable) new Runnable() {
            public final void run() {
                A.b(A.this, context);
            }
        });
    }

    public final void a(h.b bVar, n.a aVar) {
        b(a(bVar.a(), bVar.c(), "onReceivedMessage", "onReceivedMessage"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0045, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.ironsource.sdk.g.b r11) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.T
            monitor-enter(r0)
            boolean r1 = r11.d     // Catch:{ all -> 0x0142 }
            if (r1 == 0) goto L_0x013e
            boolean r1 = r10.E     // Catch:{ all -> 0x0142 }
            if (r1 == 0) goto L_0x013e
            java.lang.String r1 = r10.a     // Catch:{ all -> 0x0142 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            java.lang.String r3 = "restoreState(state:"
            r2.<init>(r3)     // Catch:{ all -> 0x0142 }
            r2.append(r11)     // Catch:{ all -> 0x0142 }
            java.lang.String r3 = ")"
            r2.append(r3)     // Catch:{ all -> 0x0142 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0142 }
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x0142 }
            int r1 = r11.e     // Catch:{ all -> 0x0142 }
            r2 = -1
            if (r1 == r2) goto L_0x0087
            com.ironsource.sdk.g.d$e r3 = com.ironsource.sdk.g.d.e.RewardedVideo     // Catch:{ all -> 0x0142 }
            int r3 = r3.ordinal()     // Catch:{ all -> 0x0142 }
            if (r1 != r3) goto L_0x004b
            java.lang.String r1 = r10.a     // Catch:{ all -> 0x0142 }
            java.lang.String r3 = "onRVAdClosed()"
            android.util.Log.d(r1, r3)     // Catch:{ all -> 0x0142 }
            com.ironsource.sdk.g.d$e r1 = com.ironsource.sdk.g.d.e.RewardedVideo     // Catch:{ all -> 0x0142 }
            java.lang.String r3 = r11.c     // Catch:{ all -> 0x0142 }
            com.ironsource.sdk.j.a.a r4 = r10.b((com.ironsource.sdk.g.d.e) r1)     // Catch:{ all -> 0x0142 }
            if (r4 == 0) goto L_0x0081
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0142 }
            if (r5 != 0) goto L_0x0081
        L_0x0047:
            r4.a(r1, r3)     // Catch:{ all -> 0x0142 }
            goto L_0x0081
        L_0x004b:
            com.ironsource.sdk.g.d$e r3 = com.ironsource.sdk.g.d.e.c     // Catch:{ all -> 0x0142 }
            int r3 = r3.ordinal()     // Catch:{ all -> 0x0142 }
            if (r1 != r3) goto L_0x006b
            java.lang.String r1 = r10.a     // Catch:{ all -> 0x0142 }
            java.lang.String r3 = "onInterstitialAdClosed()"
            android.util.Log.d(r1, r3)     // Catch:{ all -> 0x0142 }
            com.ironsource.sdk.g.d$e r1 = com.ironsource.sdk.g.d.e.c     // Catch:{ all -> 0x0142 }
            java.lang.String r3 = r11.c     // Catch:{ all -> 0x0142 }
            com.ironsource.sdk.j.a.a r4 = r10.b((com.ironsource.sdk.g.d.e) r1)     // Catch:{ all -> 0x0142 }
            if (r4 == 0) goto L_0x0081
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0142 }
            if (r5 != 0) goto L_0x0081
            goto L_0x0047
        L_0x006b:
            com.ironsource.sdk.g.d$e r3 = com.ironsource.sdk.g.d.e.OfferWall     // Catch:{ all -> 0x0142 }
            int r3 = r3.ordinal()     // Catch:{ all -> 0x0142 }
            if (r1 != r3) goto L_0x0081
            java.lang.String r1 = r10.a     // Catch:{ all -> 0x0142 }
            java.lang.String r3 = "onOWAdClosed()"
            android.util.Log.d(r1, r3)     // Catch:{ all -> 0x0142 }
            com.ironsource.sdk.j.e r1 = r10.O     // Catch:{ all -> 0x0142 }
            if (r1 == 0) goto L_0x0081
            r1.onOWAdClosed()     // Catch:{ all -> 0x0142 }
        L_0x0081:
            r11.e = r2     // Catch:{ all -> 0x0142 }
            r1 = 0
            r11.c = r1     // Catch:{ all -> 0x0142 }
            goto L_0x008e
        L_0x0087:
            java.lang.String r1 = r10.a     // Catch:{ all -> 0x0142 }
            java.lang.String r2 = "No ad was opened"
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x0142 }
        L_0x008e:
            java.lang.String r1 = r11.g     // Catch:{ all -> 0x0142 }
            java.lang.String r2 = r11.h     // Catch:{ all -> 0x0142 }
            com.ironsource.sdk.controller.k r3 = r10.V     // Catch:{ all -> 0x0142 }
            com.ironsource.sdk.g.d$e r4 = com.ironsource.sdk.g.d.e.c     // Catch:{ all -> 0x0142 }
            java.util.Collection r3 = r3.b(r4)     // Catch:{ all -> 0x0142 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0142 }
        L_0x009e:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0142 }
            r5 = 2
            if (r4 == 0) goto L_0x00df
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0142 }
            com.ironsource.sdk.g.c r4 = (com.ironsource.sdk.g.c) r4     // Catch:{ all -> 0x0142 }
            int r6 = r4.e     // Catch:{ all -> 0x0142 }
            if (r6 != r5) goto L_0x009e
            java.lang.String r5 = r10.a     // Catch:{ all -> 0x0142 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            java.lang.String r7 = "initInterstitial(appKey:"
            r6.<init>(r7)     // Catch:{ all -> 0x0142 }
            r6.append(r1)     // Catch:{ all -> 0x0142 }
            java.lang.String r7 = ", userId:"
            r6.append(r7)     // Catch:{ all -> 0x0142 }
            r6.append(r2)     // Catch:{ all -> 0x0142 }
            java.lang.String r7 = ", demandSource:"
            r6.append(r7)     // Catch:{ all -> 0x0142 }
            java.lang.String r7 = r4.a     // Catch:{ all -> 0x0142 }
            r6.append(r7)     // Catch:{ all -> 0x0142 }
            java.lang.String r7 = ")"
            r6.append(r7)     // Catch:{ all -> 0x0142 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0142 }
            android.util.Log.d(r5, r6)     // Catch:{ all -> 0x0142 }
            com.ironsource.sdk.j.a.c r5 = r10.N     // Catch:{ all -> 0x0142 }
            r10.a((java.lang.String) r1, (java.lang.String) r2, (com.ironsource.sdk.g.c) r4, (com.ironsource.sdk.j.a.c) r5)     // Catch:{ all -> 0x0142 }
            goto L_0x009e
        L_0x00df:
            java.lang.String r1 = r11.a     // Catch:{ all -> 0x0142 }
            java.lang.String r2 = r11.b     // Catch:{ all -> 0x0142 }
            com.ironsource.sdk.controller.k r3 = r10.V     // Catch:{ all -> 0x0142 }
            com.ironsource.sdk.g.d$e r4 = com.ironsource.sdk.g.d.e.RewardedVideo     // Catch:{ all -> 0x0142 }
            java.util.Collection r3 = r3.b(r4)     // Catch:{ all -> 0x0142 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0142 }
        L_0x00ef:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0142 }
            if (r4 == 0) goto L_0x013b
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0142 }
            com.ironsource.sdk.g.c r4 = (com.ironsource.sdk.g.c) r4     // Catch:{ all -> 0x0142 }
            int r6 = r4.e     // Catch:{ all -> 0x0142 }
            if (r6 != r5) goto L_0x00ef
            java.lang.String r6 = r4.a     // Catch:{ all -> 0x0142 }
            java.lang.String r7 = r10.a     // Catch:{ all -> 0x0142 }
            java.lang.String r8 = "onRVNoMoreOffers()"
            android.util.Log.d(r7, r8)     // Catch:{ all -> 0x0142 }
            com.ironsource.sdk.j.a.d r7 = r10.M     // Catch:{ all -> 0x0142 }
            r7.a(r6)     // Catch:{ all -> 0x0142 }
            java.lang.String r7 = r10.a     // Catch:{ all -> 0x0142 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            java.lang.String r9 = "initRewardedVideo(appKey:"
            r8.<init>(r9)     // Catch:{ all -> 0x0142 }
            r8.append(r1)     // Catch:{ all -> 0x0142 }
            java.lang.String r9 = ", userId:"
            r8.append(r9)     // Catch:{ all -> 0x0142 }
            r8.append(r2)     // Catch:{ all -> 0x0142 }
            java.lang.String r9 = ", demandSource:"
            r8.append(r9)     // Catch:{ all -> 0x0142 }
            r8.append(r6)     // Catch:{ all -> 0x0142 }
            java.lang.String r6 = ")"
            r8.append(r6)     // Catch:{ all -> 0x0142 }
            java.lang.String r6 = r8.toString()     // Catch:{ all -> 0x0142 }
            android.util.Log.d(r7, r6)     // Catch:{ all -> 0x0142 }
            com.ironsource.sdk.j.a.d r6 = r10.M     // Catch:{ all -> 0x0142 }
            r10.a((java.lang.String) r1, (java.lang.String) r2, (com.ironsource.sdk.g.c) r4, (com.ironsource.sdk.j.a.d) r6)     // Catch:{ all -> 0x0142 }
            goto L_0x00ef
        L_0x013b:
            r1 = 0
            r11.d = r1     // Catch:{ all -> 0x0142 }
        L_0x013e:
            r10.m = r11     // Catch:{ all -> 0x0142 }
            monitor-exit(r0)     // Catch:{ all -> 0x0142 }
            return
        L_0x0142:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0142 }
            goto L_0x0146
        L_0x0145:
            throw r11
        L_0x0146:
            goto L_0x0145
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.A.a(com.ironsource.sdk.g.b):void");
    }

    public final void a(com.ironsource.sdk.g.c cVar) {
        b(a("destroyBanner", SDKUtils.flatMapToJsonAsString(cVar.a()), "onDestroyBannersSuccess", "onDestroyBannersFail"));
    }

    public final void a(com.ironsource.sdk.g.c cVar, Map<String, String> map, com.ironsource.sdk.j.a.b bVar) {
        Map<String, String> mergeHashMaps = SDKUtils.mergeHashMaps(new Map[]{map, cVar.a()});
        if (map != null) {
            b(a("loadBanner", SDKUtils.flatMapToJsonAsString(mergeHashMaps), "onLoadBannerSuccess", "onLoadBannerFail"));
        }
    }

    public final void a(com.ironsource.sdk.g.c cVar, Map<String, String> map, com.ironsource.sdk.j.a.c cVar2) {
        Map<String, String> mergeHashMaps = SDKUtils.mergeHashMaps(new Map[]{map, cVar.a()});
        com.ironsource.sdk.g.b bVar = this.m;
        String str = cVar.b;
        if (!TextUtils.isEmpty(str) && bVar.f.indexOf(str) == -1) {
            bVar.f.add(str);
        }
        b(a("loadInterstitial", SDKUtils.flatMapToJsonAsString(mergeHashMaps), "onLoadInterstitialSuccess", "onLoadInterstitialFail"));
    }

    /* access modifiers changed from: package-private */
    public final void a(final d.e eVar, final String str) {
        c((Runnable) new Runnable() {
            public final void run() {
                if (eVar == d.e.RewardedVideo || eVar == d.e.c) {
                    com.ironsource.sdk.j.a.a a2 = A.this.b(eVar);
                    if (a2 != null) {
                        a2.a(eVar, str);
                    }
                } else if (eVar == d.e.OfferWall) {
                    A.this.O.onOWAdClosed();
                }
            }
        });
    }

    public final void a(com.ironsource.sdk.h.c cVar) {
        if (cVar.getName().contains("mobileController.html")) {
            f fVar = this.S;
            AnonymousClass4 r0 = new Runnable() {
                public final void run() {
                    A.this.a(1);
                }
            };
            if (!fVar.a()) {
                if (fVar.c == f.a.b) {
                    fVar.c();
                }
                fVar.d = f.b.CONTROLLER_FROM_SERVER;
                fVar.a(fVar.d);
                r0.run();
                return;
            }
            return;
        }
        String name = cVar.getName();
        String parent = cVar.getParent();
        try {
            b(b("assetCached", a(ShareInternalUtility.STAGING_PARAM, name, "path", h(parent), (String) null, (String) null, (String) null, (String) null, (String) null, false)));
        } catch (Exception e2) {
            a(name, parent, e2.getMessage());
        }
    }

    public final void a(com.ironsource.sdk.h.c cVar, final com.ironsource.sdk.g.e eVar) {
        if (cVar.getName().contains("mobileController.html")) {
            f fVar = this.S;
            AnonymousClass5 r0 = new Runnable() {
                public final void run() {
                    A.this.a(1);
                }
            };
            AnonymousClass6 r1 = new Runnable() {
                public final void run() {
                    e h = A.this.W;
                    h.a("controller html - failed to download - " + eVar.a);
                }
            };
            if (fVar.a()) {
                return;
            }
            if (fVar.c != f.a.b || !fVar.e()) {
                com.ironsource.sdk.a.a a2 = new com.ironsource.sdk.a.a().a("generalmessage", Integer.valueOf(fVar.b));
                if (fVar.a > 0) {
                    a2.a("timingvalue", Long.valueOf(System.currentTimeMillis() - fVar.a));
                }
                com.ironsource.sdk.a.f.a(com.ironsource.sdk.a.h.w, (Map<String, Object>) a2.a);
                r1.run();
                return;
            }
            fVar.d = f.b.FALLBACK_CONTROLLER_RECOVERY;
            fVar.a(fVar.d);
            r0.run();
            return;
        }
        a(cVar.getName(), cVar.getParent(), eVar.a);
    }

    /* access modifiers changed from: package-private */
    public final void a(Runnable runnable) {
        com.ironsource.environment.thread.a aVar = this.w;
        if (aVar != null) {
            aVar.a(runnable);
        }
    }

    public final void a(String str, String str2) {
        b(b("onNativeLifeCycleEvent", a("lifeCycleEvent", str2, "productType", str, (String) null, (String) null, (String) null, (String) null, (String) null, false)));
    }

    public final void a(String str, String str2, com.ironsource.sdk.g.c cVar, com.ironsource.sdk.j.a.b bVar) {
        this.A = str;
        this.B = str2;
        this.P = bVar;
        a(str, d.e.a, cVar, (e) new e() {
            public final void a(String str, d.e eVar, com.ironsource.sdk.g.c cVar) {
                A.this.a(str, eVar, cVar);
            }
        });
    }

    public final void a(String str, String str2, com.ironsource.sdk.g.c cVar, com.ironsource.sdk.j.a.c cVar2) {
        this.A = str;
        this.B = str2;
        this.N = cVar2;
        this.m.g = str;
        this.m.h = this.B;
        a(this.A, d.e.c, cVar, (e) new e() {
            public final void a(String str, d.e eVar, com.ironsource.sdk.g.c cVar) {
                A.this.a(str, eVar, cVar);
            }
        });
    }

    public final void a(String str, String str2, com.ironsource.sdk.j.e eVar) {
        this.A = str;
        this.B = str2;
        this.O = eVar;
        if (TextUtils.isEmpty(str2)) {
            a("UserId missing", d.e.OfferWallCredits, (com.ironsource.sdk.g.c) null);
        } else {
            a(this.A, d.e.OfferWallCredits, (com.ironsource.sdk.g.c) null, (e) new e() {
                public final void a(String str, d.e eVar, com.ironsource.sdk.g.c cVar) {
                    A.this.a(str, eVar, cVar);
                }
            });
        }
    }

    public final void a(String str, String str2, Map<String, String> map, com.ironsource.sdk.j.e eVar) {
        this.A = str;
        this.B = str2;
        this.C = map;
        this.O = eVar;
        this.m.k = map;
        this.m.i = true;
        if (TextUtils.isEmpty(str2)) {
            a("UserId missing", d.e.OfferWall, (com.ironsource.sdk.g.c) null);
        } else {
            a(this.A, d.e.OfferWall, (com.ironsource.sdk.g.c) null, (e) new e() {
                public final void a(String str, d.e eVar, com.ironsource.sdk.g.c cVar) {
                    A.this.a(str, eVar, cVar);
                }
            });
        }
    }

    public final void a(Map<String, String> map, com.ironsource.sdk.j.e eVar) {
        this.C = map;
        b(new q.a("showOfferWall", (String) null, "onShowOfferWallSuccess", "onShowOfferWallFail").a());
    }

    public final void a(JSONObject jSONObject) {
        b(b("updateConsentInfo", jSONObject != null ? jSONObject.toString() : null));
    }

    public final void a(boolean z2, String str) {
        b(b("viewableChange", a("webview", str, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "isViewable", z2)));
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str) {
        boolean z2 = false;
        if (TextUtils.isEmpty(str)) {
            Logger.d(this.a, "Trying to trigger a listener - no product was found");
            return false;
        }
        if (!str.equalsIgnoreCase(d.e.c.toString()) ? !str.equalsIgnoreCase(d.e.RewardedVideo.toString()) ? !str.equalsIgnoreCase(d.e.a.toString()) ? (str.equalsIgnoreCase(d.e.OfferWall.toString()) || str.equalsIgnoreCase(d.e.OfferWallCredits.toString())) && this.O != null : this.P != null : this.M != null : this.N != null) {
            z2 = true;
        }
        if (!z2) {
            String str2 = this.a;
            Logger.d(str2, "Trying to trigger a listener - no listener was found for product " + str);
        }
        return z2;
    }

    public final void b() {
        b(f("interceptedUrlToStore"));
    }

    public final void b(final Context context) {
        b((Runnable) new Runnable() {
            public final void run() {
                A.c(A.this, context);
            }
        });
    }

    public final void b(com.ironsource.sdk.g.c cVar, Map<String, String> map, com.ironsource.sdk.j.a.c cVar2) {
        String str;
        Map<String, String> mergeHashMaps = SDKUtils.mergeHashMaps(new Map[]{map, cVar.a()});
        d.e eVar = d.e.c;
        JSONObject jSONObject = new JSONObject(mergeHashMaps);
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.KEY_SESSION_DEPTH, Integer.toString(jSONObject.optInt(IronSourceConstants.KEY_SESSION_DEPTH)));
        String optString = jSONObject.optString("demandSourceName");
        String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(jSONObject);
        com.ironsource.sdk.g.c a2 = this.V.a(eVar, fetchDemandSourceId);
        if (a2 != null) {
            if (a2.d != null) {
                hashMap.putAll(a2.d);
            }
            if (!TextUtils.isEmpty(optString)) {
                hashMap.put("demandSourceName", optString);
            }
            if (!TextUtils.isEmpty(fetchDemandSourceId)) {
                hashMap.put("demandSourceId", fetchDemandSourceId);
            }
        }
        Map<String, String> a3 = a(eVar);
        if (a3 != null) {
            hashMap.putAll(a3);
        }
        String flatMapToJsonAsString = SDKUtils.flatMapToJsonAsString(hashMap);
        a.C0120a aVar = new a.C0120a();
        if (eVar == d.e.RewardedVideo) {
            aVar.a = "showRewardedVideo";
            aVar.b = "onShowRewardedVideoSuccess";
            str = "onShowRewardedVideoFail";
        } else if (eVar == d.e.c) {
            aVar.a = "showInterstitial";
            aVar.b = "onShowInterstitialSuccess";
            str = "onShowInterstitialFail";
        } else {
            if (eVar == d.e.OfferWall) {
                aVar.a = "showOfferWall";
                aVar.b = "onShowOfferWallSuccess";
                str = "onInitOfferWallFail";
            }
            b(a(aVar.a, flatMapToJsonAsString, aVar.b, aVar.c));
        }
        aVar.c = str;
        b(a(aVar.a, flatMapToJsonAsString, aVar.b, aVar.c));
    }

    /* access modifiers changed from: package-private */
    public final void b(Runnable runnable) {
        com.ironsource.environment.thread.a aVar = this.w;
        if (aVar != null) {
            aVar.b(runnable);
        }
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = "console.log(\"JS exeption: \" + JSON.stringify(e));";
            if (y != d.C0121d.MODE_0.d && (y < d.C0121d.MODE_1.d || y > d.C0121d.MODE_3.d)) {
                str2 = "empty";
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("try{");
            sb.append(str);
            sb.append("}catch(e){");
            sb.append(str2);
            sb.append("}");
            final String str3 = "javascript:" + sb.toString();
            Logger.i(this.a, str3);
            a((Runnable) new Runnable() {
                public final void run() {
                    try {
                        if (A.this.Q == null) {
                            A.this.evaluateJavascript(sb.toString(), (ValueCallback) null);
                            Boolean unused = A.this.Q = Boolean.TRUE;
                        } else if (A.this.Q.booleanValue()) {
                            A.this.evaluateJavascript(sb.toString(), (ValueCallback) null);
                        } else {
                            A.this.loadUrl(str3);
                        }
                    } catch (Throwable th) {
                        String b2 = A.this.a;
                        Logger.e(b2, "injectJavascript: " + th.toString());
                    }
                }
            });
        }
    }

    public final void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ab = jSONObject;
        }
    }

    public final d.c c() {
        return d.c.Web;
    }

    /* access modifiers changed from: package-private */
    public final void c(Runnable runnable) {
        com.ironsource.environment.thread.a aVar = this.w;
        if (aVar != null) {
            aVar.c(runnable);
        }
    }

    public final void c(String str) {
        String str2 = this.a;
        Logger.i(str2, "device status changed, connection type " + str);
        com.ironsource.sdk.a.d.a(str);
        b(b("deviceStatusChanged", a("connectionType", str, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false)));
    }

    public final void d() {
        b(f("enterForeground"));
    }

    public final void d(String str) {
        if (str.equals("forceClose")) {
            h();
        }
        b(b("engageEnd", a(NativeProtocol.WEB_DIALOG_ACTION, str, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false)));
    }

    public void destroy() {
        super.destroy();
        com.ironsource.sdk.l.d dVar = this.D;
        if (dVar != null) {
            dVar.a();
        }
        com.ironsource.sdk.service.Connectivity.b bVar = this.aa;
        if (bVar != null) {
            bVar.a.a();
        }
        CountDownTimer countDownTimer = this.f;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public final void e() {
        b(f("enterBackground"));
    }

    public final boolean e(String str) {
        List<String> b2 = com.ironsource.sdk.utils.b.a().b();
        try {
            if (b2.isEmpty()) {
                return false;
            }
            for (String contains : b2) {
                if (str.contains(contains)) {
                    a.AnonymousClass1.a(this.u.a(), str, (String) null);
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final void f() {
        a(this.m);
    }

    public final void g() {
        com.ironsource.sdk.a.a aVar = new com.ironsource.sdk.a.a();
        f fVar = this.S;
        aVar.a("generalmessage", Integer.valueOf(fVar.b));
        com.ironsource.sdk.a.f.a(com.ironsource.sdk.a.h.u, (Map<String, Object>) aVar.a);
        fVar.a = System.currentTimeMillis();
        if (this.S.b()) {
            a(1);
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        com.ironsource.sdk.j.f fVar = this.v;
        if (fVar != null) {
            fVar.onCloseRequested();
        }
    }

    public final void i() {
        try {
            onPause();
        } catch (Throwable th) {
            String str = this.a;
            Logger.i(str, "WebViewController: onPause() - " + th);
        }
    }

    public final void j() {
        try {
            onResume();
        } catch (Throwable th) {
            String str = this.a;
            Logger.i(str, "WebViewController: onResume() - " + th);
        }
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
        String str5 = this.a;
        Logger.i(str5, str + " " + str4);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        com.ironsource.sdk.j.f fVar;
        if (i2 != 4 || (fVar = this.v) == null || !fVar.onBackButtonPressed()) {
            return super.onKeyDown(i2, keyEvent);
        }
        return true;
    }

    public WebBackForwardList saveState(Bundle bundle) {
        return super.saveState(bundle);
    }
}
