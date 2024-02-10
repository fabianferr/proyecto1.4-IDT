package com.mbridge.msdk.mbsignalcommon.windvane;

import android.text.TextUtils;
import android.util.Base64;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.mbridge.msdk.foundation.c.a;
import com.mbridge.msdk.foundation.c.b;
import com.mbridge.msdk.foundation.tools.aa;
import org.json.JSONObject;

public abstract class AbsFeedBackForH5 extends h {
    private static int e = 0;
    private static int f = 1;
    /* access modifiers changed from: private */
    public String d = "AbsFeedBackForH5";

    public void feedbackOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                a aVar = (a) obj;
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("view_visible", 1);
                b.a().a(jSONObject.optString("key", ""), optInt == 1 ? 8 : 0, (ViewGroup) aVar.a);
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void feedbackLayoutOperate(Object obj, String str) {
        Object obj2 = obj;
        try {
            if (!TextUtils.isEmpty(str)) {
                a aVar = (a) obj2;
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, -1);
                int optInt2 = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, -1);
                int optInt3 = jSONObject.optInt("left", -1);
                int optInt4 = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_TOP_KEY, -1);
                double optDouble = jSONObject.optDouble("opacity", 1.0d);
                int optInt5 = jSONObject.optInt("radius", 20);
                String optString = jSONObject.optString("fontColor", "");
                String optString2 = jSONObject.optString("bgColor", "");
                String optString3 = jSONObject.optString("key", "");
                double optDouble2 = jSONObject.optDouble("fontSize", -1.0d);
                float f2 = (float) optDouble;
                float f3 = (float) optDouble2;
                b.a().a(optString3, optInt, optInt2, optInt5, (float) optInt3, (float) optInt4, f2, optString, optString2, f3, jSONObject.optJSONArray("padding"));
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj2, th.getMessage());
            th.printStackTrace();
        }
    }

    public void feedbackPopupOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("view_visible", 1);
                String optString = jSONObject.optString("key", "");
                final WindVaneWebView windVaneWebView = ((a) obj).a;
                b.a().a(optString, optInt, (a) new a() {
                    public final void a() {
                        String str;
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                                jSONObject.put("status", 1);
                            }
                            str = jSONObject.toString();
                        } catch (Throwable th) {
                            aa.b(AbsFeedBackForH5.this.d, th.getMessage(), th);
                            str = "";
                        }
                        g.a().a((WebView) windVaneWebView, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
                    }

                    public final void b() {
                        String str;
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                                jSONObject.put("status", 2);
                            }
                            str = jSONObject.toString();
                        } catch (Throwable th) {
                            aa.b(AbsFeedBackForH5.this.d, th.getMessage(), th);
                            str = "";
                        }
                        g.a().a((WebView) windVaneWebView, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
                    }

                    public final void a(String str) {
                        String str2;
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                                jSONObject.put("status", 2);
                            }
                            str2 = jSONObject.toString();
                        } catch (Throwable th) {
                            aa.b(AbsFeedBackForH5.this.d, th.getMessage(), th);
                            str2 = "";
                        }
                        g.a().a((WebView) windVaneWebView, "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
                    }
                });
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void callbackSuccess(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", e);
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "");
            jSONObject.put("data", new JSONObject());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            callbackExcep(obj, e2.getMessage());
            aa.a(this.d, e2.getMessage());
        }
    }

    public void callbackExcep(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f);
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str);
            jSONObject.put("data", new JSONObject());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            aa.a(this.d, e2.getMessage());
        }
    }

    public void callbackSuccessWithData(Object obj, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", e);
            jSONObject2.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "");
            jSONObject2.put("data", jSONObject);
            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Exception e2) {
            callbackExcep(obj, e2.getMessage());
            aa.a(this.d, e2.getMessage());
        }
    }
}
