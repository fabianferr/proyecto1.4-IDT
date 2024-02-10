package com.mbridge.msdk.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.iab.omid.library.mmadbridge.Omid;
import com.iab.omid.library.mmadbridge.adsession.AdSession;
import com.iab.omid.library.mmadbridge.adsession.AdSessionConfiguration;
import com.iab.omid.library.mmadbridge.adsession.AdSessionContext;
import com.iab.omid.library.mmadbridge.adsession.CreativeType;
import com.iab.omid.library.mmadbridge.adsession.ImpressionType;
import com.iab.omid.library.mmadbridge.adsession.Owner;
import com.iab.omid.library.mmadbridge.adsession.Partner;
import com.iab.omid.library.mmadbridge.adsession.VerificationScriptResource;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.net.c.a;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.mbridge.msdk.foundation.same.report.p;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.out.MBConfiguration;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OmsdkUtils */
public final class b {
    public static final String a = DomainNameUtils.VERIFICATION_URL;

    public static void a(final Context context) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_URL)) {
            MBridgeConstans.OMID_JS_SERVICE_CONTENT = "";
            new p(context).a("", "", "", "", "fetch OM failed, OMID_JS_SERVICE_URL null");
        } else if (context != null) {
            try {
                new a(context.getApplicationContext()).get(0, MBridgeConstans.OMID_JS_SERVICE_URL, (d) null, new a() {
                    public final void a(String str) {
                        MBridgeConstans.OMID_JS_SERVICE_CONTENT = str;
                        aa.a("OMSDK", "fetch OMJSContent success, content = " + str);
                        b.a(str);
                    }

                    public final void b(String str) {
                        aa.a("OMSDK", "fetch OMJSContent failed, errorCode = " + str);
                        new p(context).a("", "", "", "", "fetch OM failed, request failed");
                    }
                });
            } catch (Exception e) {
                aa.d("OMSDK", e.getMessage());
            }
        }
    }

    public static void b(final Context context) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_H5_URL)) {
            MBridgeConstans.OMID_JS_H5_CONTENT = "";
            new p(context).a("", "", "", "", "fetch OM failed, OMID_JS_H5_URL null");
        } else if (context != null) {
            try {
                new a(context.getApplicationContext()).get(0, MBridgeConstans.OMID_JS_H5_URL, (d) null, new a() {
                    public final void a(String str) {
                        MBridgeConstans.OMID_JS_H5_CONTENT = str;
                        aa.a("OMSDK", "fetch OMJSH5Content success, content = " + str);
                        b.b(str);
                    }

                    public final void b(String str) {
                        aa.a("OMSDK", "fetch OMJSH5Content failed, errorCode = " + str);
                        new p(context).a("", "", "", "", "fetch OM H5 failed, request failed");
                    }
                });
            } catch (Exception e) {
                aa.d("OMSDK", e.getMessage());
            }
        }
    }

    private static void c(Context context) {
        if (!Omid.isActive()) {
            Omid.activate(context);
        }
    }

    private static List<VerificationScriptResource> a(String str, Context context, String str2, String str3, String str4, String str5) {
        VerificationScriptResource verificationScriptResource;
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (str != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("vkey", "");
                    URL url = new URL(optJSONObject.optString("et_url", ""));
                    String optString2 = optJSONObject.optString("verification_p", "");
                    if (!TextUtils.isEmpty(optString2)) {
                        verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithParameters(optString, url, optString2);
                    } else if (TextUtils.isEmpty(optString)) {
                        verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url);
                    } else {
                        verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url);
                    }
                    arrayList.add(verificationScriptResource);
                }
            }
        } catch (IllegalArgumentException e) {
            aa.d("OMSDK", e.getMessage());
            p pVar = new p(context);
            pVar.a(str2, str5, str3, str4, "failed, exception " + e.getMessage());
        } catch (MalformedURLException e2) {
            aa.d("OMSDK", e2.getMessage());
            p pVar2 = new p(context);
            pVar2.a(str2, str5, str3, str4, "failed, exception " + e2.getMessage());
        } catch (JSONException e3) {
            aa.d("OMSDK", e3.getMessage());
            p pVar3 = new p(context);
            pVar3.a(str2, str5, str3, str4, "failed, exception " + e3.getMessage());
        }
        return arrayList;
    }

    public static AdSession a(Context context, WebView webView, String str, CampaignEx campaignEx) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT)) {
            MBridgeConstans.OMID_JS_SERVICE_CONTENT = a();
        }
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_H5_CONTENT)) {
            MBridgeConstans.OMID_JS_H5_CONTENT = b();
        }
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT) || TextUtils.isEmpty(campaignEx.getOmid())) {
            aa.a("OMSDK", "createNativeAdSession: TextUtils.isEmpty(omid) = " + TextUtils.isEmpty(campaignEx.getOmid()) + " TextUtils.isEmpty(MIntegralConstans.OMID_JS_SERVICE_CONTENT) = " + TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT));
            new p(context).a(campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), campaignEx.getId(), campaignEx.getCampaignUnitId(), "failed, OMID_JS_SERVICE_CONTENT null or omid null");
            return null;
        }
        CreativeType creativeType = CreativeType.DEFINED_BY_JAVASCRIPT;
        c(context);
        AdSession createAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(creativeType, ImpressionType.BEGIN_TO_RENDER, Owner.JAVASCRIPT, (creativeType == CreativeType.HTML_DISPLAY || creativeType == CreativeType.DEFINED_BY_JAVASCRIPT) ? Owner.NONE : Owner.NATIVE, false), AdSessionContext.createHtmlAdSessionContext(Partner.createPartner("Mintegral", MBConfiguration.SDK_VERSION), webView, (String) null, (String) null));
        createAdSession.registerAdView(webView);
        return createAdSession;
    }

    public static AdSession a(Context context, boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        Context context2 = context;
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT)) {
            MBridgeConstans.OMID_JS_SERVICE_CONTENT = a();
        }
        AdSession adSession = null;
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT) || TextUtils.isEmpty(str)) {
            String str7 = str2;
            aa.a("OMSDK", "createNativeAdSession: TextUtils.isEmpty(omid) = " + TextUtils.isEmpty(str) + " TextUtils.isEmpty(MIntegralConstans.OMID_JS_SERVICE_CONTENT) = " + TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT));
            new p(context2).a(str2, str6, str3, str4, "failed, OMID_JS_SERVICE_CONTENT null or omid null");
            return null;
        }
        try {
            c(context);
            try {
                adSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.NATIVE_DISPLAY, ImpressionType.LOADED, Owner.NATIVE, z ? Owner.NONE : Owner.NATIVE, false), AdSessionContext.createNativeAdSessionContext(Partner.createPartner("Mintegral", MBConfiguration.SDK_VERSION), MBridgeConstans.OMID_JS_SERVICE_CONTENT, a(str, context, str2, str3, str4, str6), str5, str2));
                aa.a("OMSDK", "adSession create success");
                return adSession;
            } catch (IllegalArgumentException e) {
                e = e;
            } catch (Exception e2) {
                e = e2;
                aa.d("OMSDK", e.getMessage());
                p pVar = new p(context2);
                pVar.a(str2, str6, str3, str4, "failed, exception " + e.getMessage());
                return adSession;
            }
        } catch (IllegalArgumentException e3) {
            e = e3;
            String str8 = str2;
            aa.d("OMSDK", e.getMessage());
            p pVar2 = new p(context2);
            pVar2.a(str2, str6, str3, str4, "failed, exception " + e.getMessage());
            return adSession;
        } catch (Exception e4) {
            e = e4;
            String str9 = str2;
            aa.d("OMSDK", e.getMessage());
            p pVar3 = new p(context2);
            pVar3.a(str2, str6, str3, str4, "failed, exception " + e.getMessage());
            return adSession;
        }
    }

    public static void a(final String str) {
        new Thread(new Runnable() {
            public final void run() {
                try {
                    File file = new File(e.b(c.MBRIDGE_OTHER), "/omsdk/om_js_content.txt");
                    if (file.exists()) {
                        file.delete();
                    }
                    y.a(str.getBytes(), file);
                } catch (Exception e) {
                    aa.a("OMSDK", e.getMessage());
                }
            }
        }).start();
    }

    private static String a() {
        try {
            return y.a(new File(e.b(c.MBRIDGE_OTHER), "/omsdk/om_js_content.txt"));
        } catch (Exception e) {
            aa.a("OMSDK", e.getMessage());
            return "";
        }
    }

    public static void b(final String str) {
        new Thread(new Runnable() {
            public final void run() {
                try {
                    File file = new File(e.b(c.MBRIDGE_OTHER), "/omsdk/om_js_h5_content.txt");
                    if (file.exists()) {
                        file.delete();
                    }
                    y.a(str.getBytes(), file);
                } catch (Exception e) {
                    aa.a("OMSDK", e.getMessage());
                }
            }
        }).start();
    }

    private static String b() {
        try {
            File file = new File(e.b(c.MBRIDGE_OTHER), "/omsdk/om_js_h5_content.txt");
            if (file.exists()) {
                return y.a(file);
            }
            return "";
        } catch (Exception e) {
            aa.a("OMSDK", e.getMessage());
            return "";
        }
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_H5_CONTENT)) {
            MBridgeConstans.OMID_JS_H5_CONTENT = b();
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.replace("/*OMSDK_INSERT_HERE*/", MBridgeConstans.OMID_JS_H5_CONTENT).replace("[INSERT RESOURCE URL]", a);
    }
}
