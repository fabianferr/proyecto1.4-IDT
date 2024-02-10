package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import com.facebook.internal.NativeProtocol;
import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.controller.authoritycontroller.a;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.MBConfiguration;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ReportUtil */
public class q extends g {
    public static final String a = "q";

    private static String c(Context context, String str) {
        String str2 = "1";
        if (context == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pf", str2);
            jSONObject.put("ov", w.n());
            jSONObject.put("pn", w.o(context));
            jSONObject.put("vn", w.j(context));
            jSONObject.put("vc", w.i(context));
            jSONObject.put(CmcdConfiguration.KEY_OBJECT_TYPE, w.h(context));
            jSONObject.put("dm", w.i());
            jSONObject.put("bd", w.k());
            jSONObject.put("gaid", w.a());
            jSONObject.put(ThroughputConfigUtil.SHARED_PREFS_KEY_MNC, w.e(context));
            jSONObject.put(ThroughputConfigUtil.SHARED_PREFS_KEY_MCC, w.d(context));
            int r = w.r(context);
            jSONObject.put("nt", r);
            jSONObject.put("nts", w.a(context, r));
            jSONObject.put(CmcdHeadersFactory.STREAM_TYPE_LIVE, w.g(context));
            jSONObject.put("tz", w.m());
            jSONObject.put("ua", w.l());
            jSONObject.put("app_id", b.d().h());
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            jSONObject.put("sv", MBConfiguration.SDK_VERSION);
            jSONObject.put("ss", w.l(context) + "x" + w.m(context));
            jSONObject.put("adid_limit", w.b());
            if (!a.h()) {
                str2 = "0";
            }
            jSONObject.put("adid_limit_dev", str2);
            if (f.a().b(b.d().h()) != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    String q = w.q();
                    if (!TextUtils.isEmpty(q)) {
                        jSONObject2.put("manufacturer", q);
                    }
                    int p = w.p();
                    if (p != -1) {
                        jSONObject2.put("sdkint", p);
                    }
                    String t = w.t(context);
                    if (!TextUtils.isEmpty(t)) {
                        jSONObject2.put("is24H", t);
                    }
                    String r2 = w.r();
                    if (!TextUtils.isEmpty(r2)) {
                        jSONObject2.put("totalram", r2);
                    }
                    String u = w.u(context);
                    if (!TextUtils.isEmpty(u)) {
                        jSONObject2.put("totalmemory", u);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(jSONObject2.toString())) {
                    String a2 = u.a(jSONObject2.toString());
                    if (!TextUtils.isEmpty(a2)) {
                        jSONObject.put("dvi", URLEncoder.encode(a2, "utf-8"));
                    }
                }
            }
            return jSONObject.toString();
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public static String a(Campaign campaign, int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", "adtrack");
            jSONObject.put(NativeProtocol.WEB_DIALOG_ACTION, str);
            jSONObject.put("label", i);
            if (campaign != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", campaign.getId());
                jSONObject2.put("title", campaign.getAppName());
                jSONObject.put("value", jSONObject2);
            } else {
                jSONObject.put("value", "");
            }
        } catch (Exception e) {
            aa.d(a, e.getMessage());
        }
        return jSONObject.toString();
    }

    public static d a(String str, String str2, Context context, String str3) {
        String str4;
        if (context != null) {
            context = context.getApplicationContext();
        }
        d dVar = new d();
        dVar.a("m_device_info", c(context, str3));
        dVar.a("m_action", str);
        try {
            if (!TextUtils.isEmpty(str2)) {
                String a2 = Aa.a();
                String str5 = "";
                if (a2 == null) {
                    a2 = str5;
                }
                JSONObject jSONObject = new JSONObject(str2);
                jSONObject.put("channel", a2);
                String str6 = b.c.get(str3);
                if (!TextUtils.isEmpty(str6)) {
                    if (str6 != null) {
                        str5 = str6;
                    }
                    jSONObject.put("u_stid", str5);
                }
                str4 = jSONObject.toString();
            } else {
                JSONObject jSONObject2 = new JSONObject();
                String str7 = b.c.get(str3);
                if (!TextUtils.isEmpty(str7)) {
                    jSONObject2.put("u_stid", str7);
                }
                str4 = jSONObject2.toString();
            }
            str2 = str4;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        dVar.a("m_data", str2);
        dVar.a("m_sdk", "msdk");
        return dVar;
    }

    public static d a(Context context) {
        String str = "1";
        d dVar = new d();
        try {
            dVar.a("platform", str);
            dVar.a(CampaignEx.JSON_KEY_PACKAGE_NAME, URLEncoder.encode(w.o(context)));
            if (a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                dVar.a("os_version", Build.VERSION.RELEASE);
                dVar.a("brand", URLEncoder.encode(w.k()));
                dVar.a("model", URLEncoder.encode(w.i()));
                dVar.a("gaid", w.a());
                dVar.a(ThroughputConfigUtil.SHARED_PREFS_KEY_MNC, w.e(context));
                dVar.a(ThroughputConfigUtil.SHARED_PREFS_KEY_MCC, w.d(context));
                int r = w.r(context);
                dVar.a("network_type", r + "");
                dVar.a("network_str", w.a(context, r));
                dVar.a("language", URLEncoder.encode(w.g(context)));
                dVar.a("timezone", URLEncoder.encode(w.m()));
                dVar.a("ua", URLEncoder.encode(w.l()));
                dVar.a("adid_limit", w.b() + "");
                if (!a.h()) {
                    str = "0";
                }
                dVar.a("adid_limit_dev", str);
            }
            dVar.a("sdk_version", MBConfiguration.SDK_VERSION);
            dVar.a("app_version_name", URLEncoder.encode(w.j(context)));
            dVar.a(AdUnitActivity.EXTRA_ORIENTATION, URLEncoder.encode(w.h(context) + ""));
            dVar.a("screen_size", w.l(context) + "x" + w.m(context));
            e b = f.a().b(b.d().h());
            if (b == null) {
                b = f.a().b();
            }
            if (b != null) {
                JSONObject a2 = a(context, b);
                if (!TextUtils.isEmpty(a2.toString())) {
                    String a3 = u.a(a2.toString());
                    if (!TextUtils.isEmpty(a3)) {
                        dVar.a("dvi", a3);
                    }
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return dVar;
    }

    public static JSONObject a(Context context, e eVar) throws Exception {
        JSONObject jSONObject = new JSONObject();
        if (a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            String q = w.q();
            if (!TextUtils.isEmpty(q)) {
                jSONObject.put("manufacturer", q);
            }
            int p = w.p();
            if (p != -1) {
                jSONObject.put("sdkint", p);
            }
            String t = w.t(context);
            if (!TextUtils.isEmpty(t)) {
                jSONObject.put("is24H", t);
            }
            String r = w.r();
            if (!TextUtils.isEmpty(r)) {
                jSONObject.put("totalram", r);
            }
            String u = w.u(context);
            if (!TextUtils.isEmpty(u)) {
                jSONObject.put("totalmemory", u);
            }
            jSONObject.put("adid_limit", w.b() + "");
            jSONObject.put("adid_limit_dev", a.h() ? "1" : "0");
        }
        if (eVar.I() == 1 && !TextUtils.isEmpty(w.e()) && a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            jSONObject.put("az_aid_info", w.e());
        }
        return jSONObject;
    }

    public static d a(Context context, String str) {
        d a2 = a(context);
        a2.a("app_id", b.d().h() + "");
        if (!TextUtils.isEmpty(str)) {
            try {
                a2.a("data", URLEncoder.encode(str, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return a2;
    }

    public static d a(String str, Context context, String str2) {
        d a2 = a(context);
        StringBuilder sb = new StringBuilder();
        sb.append(b.d().h());
        String str3 = "";
        sb.append(str3);
        a2.a("app_id", sb.toString());
        a2.a(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
        try {
            if (!TextUtils.isEmpty(str2)) {
                String str4 = b.c.get(str2);
                if (!TextUtils.isEmpty(str)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append("&u_stid=");
                    if (str4 != null) {
                        str3 = str4;
                    }
                    sb2.append(str3);
                    str = sb2.toString();
                } else {
                    StringBuilder sb3 = new StringBuilder("u_stid=");
                    if (str4 != null) {
                        str3 = str4;
                    }
                    sb3.append(str3);
                    str = sb3.toString();
                }
            }
            a2.a("data", URLEncoder.encode(str, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        a2.a("m_sdk", "msdk");
        return a2;
    }

    public static d a(String str, Context context) {
        d a2 = a(context);
        a2.a("app_id", b.d().h() + "");
        if (!TextUtils.isEmpty(str)) {
            try {
                a2.a("data", URLEncoder.encode(str, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        a2.a("m_sdk", "msdk");
        return a2;
    }

    public static String a(String str, Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("key=" + str);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                sb.append("&" + ((String) next.getKey()) + "=" + next.getValue());
            }
        }
        sb.append("\n");
        return sb.toString();
    }

    public static boolean a() {
        try {
            if (System.currentTimeMillis() - 86400000 > ((Long) ai.b(b.d().g(), "privateAuthorityTimesTamp", 0L)).longValue()) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static void b() {
        try {
            ai.a(b.d().g(), "privateAuthorityTimesTamp", Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, com.mbridge.msdk.foundation.entity.e eVar, String str, boolean z, CampaignEx campaignEx) {
        String str2;
        Context context2 = context;
        String str3 = str;
        if (eVar != null) {
            try {
                str2 = eVar.e();
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        } else {
            str2 = "";
        }
        if (context2 != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            StringBuffer stringBuffer = new StringBuffer("key=2000047&");
            if (!TextUtils.isEmpty(str)) {
                String str4 = b.c.get(str3);
                String str5 = "";
                StringBuilder sb = new StringBuilder("u_stid=");
                if (str4 == null) {
                    str4 = str5;
                }
                sb.append(str4);
                sb.append("&");
                stringBuffer.append(sb.toString());
            }
            if (campaignEx != null) {
                stringBuffer.append("cid=" + campaignEx.getId() + "&");
                stringBuffer.append("adtp=" + campaignEx.getAdType() + "&");
                String requestId = campaignEx.getRequestId();
                stringBuffer.append("rid=" + requestId).append("&");
                String requestIdNotice = campaignEx.getRequestIdNotice();
                stringBuffer.append("rid_n=" + requestIdNotice + "&");
            }
            stringBuffer.append("st=" + System.currentTimeMillis() + "&");
            stringBuffer.append("network_type=" + w.r(context) + "&");
            stringBuffer.append("unit_id=" + str3 + "&").append("hb=").append(z ? 1 : 0).append("&");
            stringBuffer.append("reason=" + str2);
            if (k.a().c()) {
                k.a().a(stringBuffer.toString());
            } else {
                d(context2, stringBuffer.toString());
            }
        }
    }

    public static void a(Context context, String str, String str2, boolean z, String str3, String str4, String str5, String str6) {
        String str7 = str2;
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    StringBuffer stringBuffer = new StringBuffer("key=2000104&");
                    if (!TextUtils.isEmpty(str2)) {
                        String str8 = b.c.get(str7);
                        StringBuilder sb = new StringBuilder("u_stid=");
                        if (str8 == null) {
                            str8 = "";
                        }
                        sb.append(str8);
                        sb.append("&");
                        stringBuffer.append(sb.toString());
                    }
                    stringBuffer.append("network_type=" + w.r(context) + "&");
                    if (!TextUtils.isEmpty(str3)) {
                        stringBuffer.append("rid=" + str3 + "&");
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        stringBuffer.append("rid_n=" + str4 + "&");
                    }
                    if (!TextUtils.isEmpty(str5)) {
                        stringBuffer.append("cid=" + str5 + "&");
                    }
                    if (!TextUtils.isEmpty(str6)) {
                        stringBuffer.append("template_id=" + str6 + "&");
                    }
                    stringBuffer.append("unit_id=" + str7 + "&").append("hb=").append(z ? 1 : 0).append("&");
                    StringBuilder sb2 = new StringBuilder("reason=");
                    String str9 = str;
                    sb2.append(str);
                    stringBuffer.append(sb2.toString());
                    if (k.a().c()) {
                        k.a().a(stringBuffer.toString());
                    } else {
                        d(context, stringBuffer.toString());
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, List<CampaignEx> list, String str, boolean z) {
        if (context != null && list != null) {
            try {
                if (list.size() > 0 && !TextUtils.isEmpty(str)) {
                    StringBuffer append = new StringBuffer().append("key=2000048&");
                    append.append("st=" + System.currentTimeMillis() + "&");
                    append.append("network_type=" + w.r(context) + "&");
                    append.append("unit_id=" + str + "&");
                    CampaignEx campaignEx = list.get(0);
                    StringBuffer append2 = append.append("cid=" + campaignEx.getId() + "&");
                    if (z) {
                        append2.append("hb=").append(1).append("&");
                    }
                    String requestId = campaignEx.getRequestId();
                    if (!TextUtils.isEmpty(requestId)) {
                        append2.append("rid=").append(requestId).append("&");
                    }
                    String requestIdNotice = campaignEx.getRequestIdNotice();
                    if (!TextUtils.isEmpty(requestIdNotice)) {
                        append2 = append2.append("rid_n=").append(requestIdNotice).append("&");
                    }
                    StringBuilder sb = new StringBuilder("rtins_type=");
                    for (int i = 0; i < list.size(); i++) {
                        CampaignEx campaignEx2 = list.get(i);
                        if (i < list.size() - 1) {
                            sb.append(campaignEx2.getRtinsType());
                            sb.append(",");
                        } else {
                            sb.append(campaignEx2.getRtinsType());
                        }
                    }
                    append2.append(sb);
                    if (k.a().c()) {
                        k.a().a(append2.toString());
                    } else {
                        a(context, append2.toString(), str);
                    }
                }
            } catch (Throwable th) {
                aa.d(a, th.getMessage());
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, int i, String str, String str2) {
        String str3 = str2;
        if (context != null && campaignEx != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer("key=2000114&");
                stringBuffer.append("network_type=" + w.r(context) + "&");
                StringBuilder sb = new StringBuilder("gh_id=");
                String str4 = "";
                sb.append(TextUtils.isEmpty(campaignEx.getGhId()) ? str4 : URLEncoder.encode(campaignEx.getGhId(), "utf-8"));
                sb.append("&");
                stringBuffer.append(sb.toString());
                StringBuilder sb2 = new StringBuilder("gh_path=");
                sb2.append(TextUtils.isEmpty(campaignEx.getGhPath()) ? str4 : URLEncoder.encode(campaignEx.getGhPath(), "utf-8"));
                sb2.append("&");
                stringBuffer.append(sb2.toString());
                stringBuffer.append("unit_id=" + str3 + "&");
                stringBuffer.append("rid=").append(campaignEx.getRequestId()).append("&");
                stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
                stringBuffer.append("result=" + i + "&");
                StringBuilder sb3 = new StringBuilder("reason=");
                if (!TextUtils.isEmpty(str)) {
                    str4 = URLEncoder.encode(str, "utf-8");
                }
                sb3.append(str4);
                sb3.append("&");
                stringBuffer.append(sb3.toString());
                stringBuffer.append("cid=" + campaignEx.getId());
                if (k.a().c()) {
                    k.a().a(stringBuffer.toString());
                } else {
                    a(context, stringBuffer.toString(), str3);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2) {
        if (context != null && campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    StringBuffer append = new StringBuffer().append("key=2000054&network_type=");
                    append.append(w.r(context)).append("&unit_id=");
                    append.append(str).append("&cid=");
                    append.append(campaignEx.getId()).append("&reason=&result=2&");
                    if (!TextUtils.isEmpty(str2)) {
                        append = append.append(str2);
                    }
                    if (campaignEx.getAdType() == 287) {
                        append.append("creative=").append(URLEncoder.encode(campaignEx.getendcard_url())).append("&ad_type=3&");
                    } else if (campaignEx.getAdType() == 94) {
                        append.append("creative=").append(URLEncoder.encode(campaignEx.getendcard_url())).append("&ad_type=1&");
                    } else if (campaignEx.getAdType() == 296) {
                        append.append("ad_type=5&creative=");
                        append.append(campaignEx.getCreativeId()).append("&");
                    } else if (campaignEx.getAdType() == 297) {
                        append.append("ad_type=6&creative=");
                        append.append(campaignEx.getCreativeId()).append("&");
                    } else if (campaignEx.getAdType() == 298) {
                        append.append("ad_type=7&creative=");
                        append.append(campaignEx.getCreativeId()).append("&");
                    } else {
                        append.append("creative=").append(URLEncoder.encode(campaignEx.getendcard_url())).append("&ad_type=1&");
                    }
                    append.append("devid=").append(w.a()).append("&");
                    if (campaignEx != null) {
                        if (campaignEx.isBidCampaign()) {
                            append = append.append("hb=1&");
                        }
                        append.append("rid=").append(campaignEx.getRequestId()).append("&rid_n=");
                        append.append(campaignEx.getRequestIdNotice()).append("&adspace_t=");
                        append.append(campaignEx.getAdSpaceT());
                    }
                    if (k.a().c()) {
                        k.a().a(append.toString());
                    } else {
                        a(context, append.toString(), str);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void b(Context context, CampaignEx campaignEx, String str, String str2) {
        if (context != null) {
            try {
                if ((!TextUtils.isEmpty(str)) && (true ^ TextUtils.isEmpty(str2))) {
                    StringBuffer append = new StringBuffer().append("key=2000054&");
                    append.append("network_type=" + w.r(context) + "&");
                    append.append("unit_id=" + str + "&");
                    append.append("reason=" + str2 + "&");
                    append.append("result=1&");
                    append.append("devid=" + w.a() + "&");
                    if (campaignEx != null) {
                        append.append("cid=" + campaignEx.getId() + "&");
                        if (campaignEx.getAdType() == 287) {
                            append.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                            append.append("ad_type=3&");
                        } else if (campaignEx.getAdType() == 94) {
                            append.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                            append.append("ad_type=1&");
                        } else if (campaignEx.getAdType() == 296) {
                            append.append("ad_type=5&");
                            append.append("creative=" + campaignEx.getCreativeId() + "&");
                        } else if (campaignEx.getAdType() == 297) {
                            append.append("ad_type=6&");
                            append.append("ad_html=" + campaignEx.getAdHtml() + "&");
                            append.append("ad_tpl_url=" + URLEncoder.encode(campaignEx.getAdZip()) + "&");
                        } else if (campaignEx.getAdType() == 298) {
                            append.append("ad_type=7&");
                            append.append("ad_html=" + campaignEx.getAdHtml() + "&");
                            append.append("ad_tpl_url=" + URLEncoder.encode(campaignEx.getAdZip()) + "&");
                        } else {
                            append.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                            append.append("ad_type=1&");
                        }
                        StringBuffer append2 = append.append("rid=").append(campaignEx.getRequestId()).append("&");
                        append = append2.append("rid_n=" + campaignEx.getRequestIdNotice());
                    }
                    if (k.a().c()) {
                        k.a().a(append.toString());
                    } else {
                        a(context, append.toString(), str);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str, int i, String str2, String str3, CampaignEx campaignEx) {
        Context context2 = context;
        if (campaignEx != null && context2 != null) {
            try {
                String campaignUnitId = campaignEx.getCampaignUnitId();
                boolean isBidCampaign = campaignEx.isBidCampaign();
                String requestId = campaignEx.getRequestId();
                String id = campaignEx.getId();
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(campaignUnitId)) {
                    StringBuffer stringBuffer = new StringBuffer("key=2000108&");
                    if (!TextUtils.isEmpty(campaignUnitId)) {
                        String str4 = b.c.get(campaignUnitId);
                        StringBuilder sb = new StringBuilder("u_stid=");
                        if (str4 == null) {
                            str4 = "";
                        }
                        sb.append(str4);
                        sb.append("&");
                        stringBuffer.append(sb.toString());
                    }
                    if (!TextUtils.isEmpty(requestId)) {
                        stringBuffer.append("rid=" + requestId + "&");
                    }
                    if (!TextUtils.isEmpty(id)) {
                        stringBuffer.append("cid=" + id + "&");
                    }
                    stringBuffer.append("template_id=" + i + "&");
                    if (!TextUtils.isEmpty(str)) {
                        stringBuffer.append("ad_type=" + str + "&");
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        stringBuffer.append("process=" + str3 + "&");
                    }
                    stringBuffer.append("unit_id=" + campaignUnitId + "&").append("hb=").append(isBidCampaign ? 1 : 0).append("&");
                    stringBuffer.append("reason=" + str2);
                    if (k.a().c()) {
                        k.a().a(stringBuffer.toString());
                    } else {
                        d(context, stringBuffer.toString());
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i, String str3) {
        if (context != null && campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    StringBuffer stringBuffer = new StringBuffer("key=2000073&");
                    stringBuffer.append("network_type=" + w.r(context) + "&");
                    stringBuffer.append("unit_id=" + str2 + "&");
                    stringBuffer.append("cid=" + campaignEx.getId() + "&");
                    stringBuffer.append("reason=" + str3 + "&");
                    stringBuffer.append("result=" + i + "&");
                    stringBuffer.append("rid=").append(campaignEx.getRequestId()).append("&");
                    stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
                    StringBuilder sb = new StringBuilder("url=");
                    sb.append(URLEncoder.encode(str, "utf-8"));
                    stringBuffer.append(sb.toString());
                    if (k.a().c()) {
                        k.a().a(stringBuffer.toString());
                    } else {
                        a(context, stringBuffer.toString(), str2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i) {
        if (context != null && campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    StringBuffer stringBuffer = new StringBuffer("key=2000074&");
                    stringBuffer.append("network_type=" + w.r(context) + "&");
                    stringBuffer.append("unit_id=" + str2 + "&");
                    stringBuffer.append("cid=" + campaignEx.getId() + "&");
                    stringBuffer.append("type=" + i + "&");
                    stringBuffer.append("rid=").append(campaignEx.getRequestId()).append("&");
                    stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
                    StringBuilder sb = new StringBuilder("url=");
                    sb.append(URLEncoder.encode(str, "utf-8"));
                    stringBuffer.append(sb.toString());
                    if (k.a().c()) {
                        k.a().a(stringBuffer.toString());
                    } else {
                        a(context, stringBuffer.toString(), str2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i, int i2) {
        if (context != null && campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    StringBuffer stringBuffer = new StringBuffer("key=2000075&");
                    stringBuffer.append("network_type=" + w.r(context) + "&");
                    stringBuffer.append("unit_id=" + str2 + "&");
                    stringBuffer.append("cid=" + campaignEx.getId() + "&");
                    stringBuffer.append("type=" + i + "&");
                    stringBuffer.append("rid=").append(campaignEx.getRequestId()).append("&");
                    stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
                    stringBuffer.append("statue=" + i2 + "&");
                    StringBuilder sb = new StringBuilder("url=");
                    sb.append(URLEncoder.encode(str, "utf-8"));
                    stringBuffer.append(sb.toString());
                    if (k.a().c()) {
                        k.a().a(stringBuffer.toString());
                    } else {
                        a(context, stringBuffer.toString(), str2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str, String str2, int i, String str3) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    StringBuffer stringBuffer = new StringBuffer("key=2000076&");
                    stringBuffer.append("network_type=" + w.r(context) + "&");
                    stringBuffer.append("unit_id=" + str2 + "&");
                    stringBuffer.append("reason=" + str3 + "&");
                    stringBuffer.append("result=" + i + "&");
                    StringBuilder sb = new StringBuilder("url=");
                    sb.append(URLEncoder.encode(str, "utf-8"));
                    stringBuffer.append(sb.toString());
                    if (k.a().c()) {
                        k.a().a(stringBuffer.toString());
                    } else {
                        a(context, stringBuffer.toString(), str2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void a(final Context context, final String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                new com.mbridge.msdk.foundation.same.report.d.a(context).post(0, com.mbridge.msdk.foundation.same.net.g.d.a().a, a(str, context, str2), new com.mbridge.msdk.foundation.same.report.d.b() {
                    public final void onSuccess(String str) {
                        aa.d(q.a, str);
                    }

                    public final void onFailed(String str) {
                        l lVar = new l();
                        lVar.c(str);
                        lVar.a(System.currentTimeMillis());
                        lVar.a(0);
                        lVar.b("POST");
                        lVar.a(com.mbridge.msdk.foundation.same.net.g.d.a().a);
                        n.a((g) h.a(context)).a(lVar);
                        aa.d(q.a, str);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aa.d(a, e.getMessage());
            }
        }
    }

    private static void d(final Context context, final String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                new com.mbridge.msdk.foundation.same.report.d.a(context).post(0, com.mbridge.msdk.foundation.same.net.g.d.a().a, a(str, context), new com.mbridge.msdk.foundation.same.report.d.b() {
                    public final void onSuccess(String str) {
                        aa.d(q.a, str);
                    }

                    public final void onFailed(String str) {
                        l lVar = new l();
                        lVar.c(str);
                        lVar.a(System.currentTimeMillis());
                        lVar.a(0);
                        lVar.b("POST");
                        lVar.a(com.mbridge.msdk.foundation.same.net.g.d.a().a);
                        n.a((g) h.a(context)).a(lVar);
                        aa.d(q.a, str);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aa.d(a, e.getMessage());
            }
        }
    }

    public static void a(String str) {
        com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(b.d().g());
        String str2 = "key=2000088&state=" + str;
        aa.d(a, str2);
        e b = f.a().b(b.d().h());
        if (b == null || a(b, str2)) {
            aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.a().a, a(str2, b.d().g(), ""), (com.mbridge.msdk.foundation.same.net.e) null);
        }
    }

    public static void a(int i, String str, String str2) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(b.d().g());
            aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.a().a, a("key=2000080&reason=" + str2 + "&ad_type=" + i + "&url=" + URLEncoder.encode(str, "utf-8"), b.d().g(), ""), (com.mbridge.msdk.foundation.same.net.e) null);
        } catch (Exception e) {
            aa.d(a, e.getMessage());
        }
    }

    public static void b(String str) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(b.d().g());
            StringBuilder sb = new StringBuilder("key=2000090&reason=");
            sb.append(TextUtils.isEmpty(str) ? "" : str);
            sb.append("&result=");
            sb.append(!TextUtils.isEmpty(str));
            aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.a().a, a(sb.toString(), b.d().g(), ""), (com.mbridge.msdk.foundation.same.net.e) null);
        } catch (Exception e) {
            aa.d(a, e.getMessage());
        }
    }

    public static void a(String str, int i, int i2, String str2, int i3, String str3) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("key", URLEncoder.encode("m_water_mark_result", "utf-8"));
            hashMap.put("water_mark_result", i2 + "");
            hashMap.put("water_mark_error_msg", URLEncoder.encode(str2, "utf-8"));
            hashMap.put("render_result", i3 + "");
            hashMap.put("water_mark_str", URLEncoder.encode(str3, "utf-8"));
            m a2 = m.a();
            a2.a("m_water_mark_result", "", str, i + "", (Map<String, String>) hashMap);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(CampaignEx campaignEx, String str, int i, int i2, String str2, int i3, int i4, int i5, String str3) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("key", URLEncoder.encode("2000094", "utf-8"));
            if (campaignEx != null) {
                hashMap.put("rid", URLEncoder.encode(campaignEx.getRequestId(), "utf-8"));
                hashMap.put("rid_n", URLEncoder.encode(campaignEx.getRequestIdNotice(), "utf-8"));
                hashMap.put(CmcdConfiguration.KEY_CONTENT_ID, URLEncoder.encode(campaignEx.getId(), "utf-8"));
                hashMap.put("lrid", campaignEx.getCurrentLRid());
                ArrayList arrayList = new ArrayList();
                arrayList.add(campaignEx);
                hashMap.putAll(m.a().a((List<CampaignEx>) arrayList));
            }
            hashMap.put(MBridgeConstans.PROPERTIES_UNIT_ID, URLEncoder.encode(str, "utf-8"));
            if (i == 0) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = "0";
                }
                hashMap.put("video_prg", str3 + "");
            } else {
                hashMap.put("video_prg", i + "");
            }
            hashMap.put(TypedValues.CycleType.S_WAVE_PHASE, i2 + "");
            hashMap.put("feedback_content", URLEncoder.encode(str2, "utf-8"));
            hashMap.put("feedback_close", i3 + "");
            hashMap.put("type", i5 + "");
            hashMap.put("ad_type", i4 + "");
            hashMap.put("network_type", URLEncoder.encode(String.valueOf(w.r(b.d().g())), "utf-8"));
            m a2 = m.a();
            a2.a("2000094", "", str, i4 + "", (Map<String, String>) hashMap);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public static void a(CampaignEx campaignEx, String str, int i, int i2, String str2) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(b.d().g());
            StringBuilder sb = new StringBuilder("key=");
            sb.append(URLEncoder.encode("2000121", "utf-8"));
            sb.append("&rid=");
            sb.append(URLEncoder.encode(campaignEx.getRequestId(), "utf-8"));
            sb.append("&rid_n=");
            sb.append(URLEncoder.encode(campaignEx.getRequestIdNotice(), "utf-8"));
            sb.append("&cid=");
            sb.append(URLEncoder.encode(campaignEx.getId(), "utf-8"));
            sb.append("&unit_id=");
            sb.append(URLEncoder.encode(str, "utf-8"));
            sb.append("&type=");
            sb.append(i);
            sb.append("&result=");
            sb.append(i2);
            sb.append("&reason=");
            sb.append(URLEncoder.encode(str2, "utf-8"));
            if (k.a().c()) {
                k.a().a(sb.toString());
                return;
            }
            aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.a().a, a(sb.toString(), b.d().g(), str), new com.mbridge.msdk.foundation.same.report.d.b() {
                public final void onFailed(String str) {
                }

                public final void onSuccess(String str) {
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public static void b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                new com.mbridge.msdk.foundation.same.report.d.a(context).post(0, com.mbridge.msdk.foundation.same.net.g.d.a().a, a(str, context), new com.mbridge.msdk.foundation.same.report.d.b() {
                    public final void onSuccess(String str) {
                        aa.d(q.a, str);
                    }

                    public final void onFailed(String str) {
                        aa.d(q.a, str);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aa.d(a, e.getMessage());
            }
        }
    }

    public static void a(Context context, com.mbridge.msdk.foundation.entity.e eVar, String str, boolean z, CampaignUnit campaignUnit) {
        String str2;
        boolean z2;
        CampaignEx campaignEx;
        Context context2 = context;
        String str3 = str;
        if (eVar != null) {
            try {
                str2 = eVar.e();
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        } else {
            str2 = "";
        }
        if (context2 != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            StringBuffer append = new StringBuffer().append("key=m_campaign_filtered&");
            if (!TextUtils.isEmpty(str)) {
                String str4 = b.c.get(str3);
                String str5 = "";
                StringBuilder sb = new StringBuilder("u_stid=");
                if (str4 == null) {
                    str4 = str5;
                }
                sb.append(str4);
                sb.append("&");
                append.append(sb.toString());
            }
            if (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() <= 0 || (campaignEx = campaignUnit.getAds().get(0)) == null) {
                z2 = z;
            } else {
                z2 = campaignEx.isBidCampaign();
                append.append("cid=" + campaignEx.getId() + "&");
                append.append("adtp=" + campaignEx.getAdType() + "&");
                String requestId = campaignEx.getRequestId();
                StringBuffer append2 = append.append("rid=" + requestId).append("&");
                String requestIdNotice = campaignEx.getRequestIdNotice();
                append = append2.append("rid_n=" + requestIdNotice + "&");
            }
            append.append("st=" + System.currentTimeMillis() + "&");
            append.append("network_type=" + w.r(context) + "&");
            append.append("unit_id=" + str3 + "&");
            append.append("hb=").append(z2 ? 1 : 0).append("&");
            append.append("reason=" + str2);
            aa.d("CommonReport", append.toString());
            if (k.a().c()) {
                k.a().a(append.toString());
            } else {
                d(context2, append.toString());
            }
        }
    }
}
