package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity;
import com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity;
import com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.b.l;
import com.bytedance.sdk.openadsdk.core.model.j;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.t;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.com.bytedance.overseas.sdk.a.b;
import com.com.bytedance.overseas.sdk.a.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: WebHelper */
public class z {
    private static boolean a = false;

    public static void a(boolean z) {
        a = z;
    }

    public static boolean a(Context context, q qVar, int i, PAGNativeAd pAGNativeAd, PangleAd pangleAd, String str, c cVar, boolean z, int i2) {
        String str2;
        q qVar2 = qVar;
        String str3 = str;
        int i3 = i2;
        if (context == null || qVar2 == null || i == -1) {
            com.bytedance.sdk.openadsdk.b.c.a(qVar, str3, 0, 1, false);
            return false;
        }
        j ab = qVar.ab();
        HashMap hashMap = new HashMap();
        if (qVar.be() == 0) {
            hashMap.put("dpl_probability_jump", Boolean.valueOf(i3 >= 11));
        }
        if (i3 != 0 && qVar.at()) {
            hashMap.put("dsp_click_type", Integer.valueOf(i2));
        }
        if (ab == null || TextUtils.isEmpty(ab.a())) {
            str2 = a(qVar);
        } else if (a(context, qVar, i, str, z, (Map<String, Object>) hashMap)) {
            com.bytedance.sdk.openadsdk.b.c.a(qVar, str3, 0, 2, false);
            return true;
        } else {
            if (ab.c() != 2 || qVar.ad() == 5 || qVar.ad() == 15) {
                if (ab.c() != 1 || TextUtils.isEmpty(ab.b())) {
                    str2 = a(qVar);
                } else {
                    str2 = ab.b();
                }
            } else if (cVar == null) {
                str2 = null;
            } else if (cVar.a()) {
                com.bytedance.sdk.openadsdk.b.c.a(qVar, str3, "open_fallback_url", (Map<String, Object>) hashMap);
                com.bytedance.sdk.openadsdk.b.c.a(qVar, str3, 0, 3, false);
                return true;
            } else if (cVar.e()) {
                com.bytedance.sdk.openadsdk.b.c.a(qVar, str3, "open_fallback_url", (Map<String, Object>) hashMap);
                com.bytedance.sdk.openadsdk.b.c.a(qVar, str3, 0, 3, false);
                return true;
            } else {
                com.bytedance.sdk.openadsdk.b.c.a(qVar, str3, "open_fallback_url", (Map<String, Object>) hashMap);
                com.bytedance.sdk.openadsdk.b.c.a(qVar, str3, 0, 3, false);
                return false;
            }
            com.bytedance.sdk.openadsdk.b.c.a(qVar, str3, "open_fallback_url", (Map<String, Object>) hashMap);
        }
        String str4 = str2;
        if (qVar.be() != 0 || TextUtils.isEmpty(str4) || !str4.contains("play.google.com/store")) {
            return a(context, qVar, i, pAGNativeAd, pangleAd, str, z, str4);
        }
        String substring = str4.substring(str4.indexOf("?id=") + 4);
        com.bytedance.sdk.openadsdk.b.c.a(qVar, str3, 0, 4, false);
        return b.a(context, str4, substring, str3, qVar);
    }

    private static String a(q qVar) {
        if (!qVar.at() || qVar.au() == null) {
            return qVar.P();
        }
        return qVar.au().i();
    }

    public static boolean a(Context context, q qVar, int i, String str, boolean z, Map<String, Object> map) {
        Context context2 = context;
        q qVar2 = qVar;
        String str2 = str;
        if (qVar2 == null) {
            return false;
        }
        j ab = qVar.ab();
        if (ab == null || TextUtils.isEmpty(ab.a())) {
            d.a(qVar2, str2, ab == null ? -1 : -2, ab != null ? ab.d() : null);
            return false;
        }
        Map<String, Object> hashMap = map == null ? new HashMap<>() : map;
        String a2 = ab.a();
        Uri parse = Uri.parse(a2);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        if (ac.i(context)) {
            ac.b a3 = ac.a(context2, intent);
            if (a3.b > 0) {
                if (o.d().h()) {
                    ac.a(qVar2, str2);
                }
                ComponentName resolveActivity = intent.resolveActivity(context.getPackageManager());
                if (!(context2 instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                hashMap.put("can_query_install", 1);
                if (resolveActivity != null) {
                    hashMap.put("resolved_activity", resolveActivity.getPackageName() + "/" + resolveActivity.getClassName());
                }
                hashMap.put("matched_count", Integer.valueOf(a3.b));
                hashMap.put("url", a2);
                if (a3.a != null) {
                    hashMap.put("target_component", a3.a.getPackageName() + "/" + a3.a.getClassName());
                    intent.setComponent(a3.a);
                }
                com.bytedance.sdk.openadsdk.b.c.a(qVar2, str2, "open_url_app", hashMap);
                try {
                    context2.startActivity(intent);
                    l.a().a(hashMap).a(qVar2, str2);
                    com.bytedance.sdk.openadsdk.b.c.a("dp_start_act_success", qVar2, str2, hashMap);
                    return true;
                } catch (Exception e) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("exception", e.getMessage());
                        jSONObject.put("intent", intent.toString());
                        jSONObject.put("can_query_install", 1);
                    } catch (Exception unused) {
                    }
                    d.a(qVar2, str2, -4, jSONObject);
                    if (!o.d().h()) {
                        a(context, qVar.P(), qVar, i, str, z);
                        com.bytedance.sdk.component.utils.l.c("WebHelper", "openDetailPage() -> context.startActivity(intent) fail :", e);
                    }
                    return false;
                }
            } else {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("intent", intent.toString());
                    jSONObject2.put("can_query_install", 1);
                } catch (Exception unused2) {
                }
                d.a(qVar2, str2, -3, jSONObject2);
            }
        } else {
            try {
                if (o.d().h()) {
                    ac.a(qVar2, str2);
                }
                if (!(context2 instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                hashMap.put("can_query_install", 0);
                com.bytedance.sdk.openadsdk.b.c.a(qVar2, str2, "open_url_app", hashMap);
                context2.startActivity(intent);
                l.a().a(hashMap).a(qVar2, str2);
                return true;
            } catch (Throwable unused3) {
            }
        }
        return false;
    }

    public static boolean a(Context context, final q qVar, int i, PAGNativeAd pAGNativeAd, PangleAd pangleAd, final String str, boolean z, String str2) {
        Context context2 = context;
        q qVar2 = qVar;
        String str3 = str;
        if (TextUtils.isEmpty(str2) && !t.b(qVar)) {
            com.bytedance.sdk.openadsdk.b.c.a(qVar, str, 0, 5, false);
            return false;
        } else if (qVar.M() != 2) {
            com.bytedance.sdk.component.utils.b.a(context, a(context, str2, qVar, i, pAGNativeAd, pangleAd, str, z), (b.a) null);
            a = false;
            return true;
        } else if (!o.a(str2)) {
            com.bytedance.sdk.openadsdk.b.c.a(qVar, str, 0, 5, false);
            return false;
        } else {
            Intent intent = new Intent("android.intent.action.VIEW");
            try {
                intent.setData(Uri.parse(str2));
                if (!(context2 instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                final int b = ac.b(o.a(), intent);
                com.bytedance.sdk.component.utils.b.a(context, intent, new b.a() {
                    public void a() {
                        com.bytedance.sdk.openadsdk.b.c.a(qVar, str, b, 0, true);
                    }

                    public void a(Throwable th) {
                        com.bytedance.sdk.openadsdk.b.c.a(qVar, str, b, 6, false, th.toString());
                    }
                });
                return true;
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.b.c.a(qVar, str, 0, 6, false, e.toString());
                return false;
            }
        }
    }

    public static boolean a(Context context, String str, q qVar, int i, String str2, boolean z) {
        try {
            context.startActivity(a(context, str, qVar, i, (PAGNativeAd) null, (PangleAd) null, str2, z));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(Context context, String str, q qVar, int i, String str2, boolean z) {
        try {
            context.startActivity(a(context, str, qVar, i, (PAGNativeAd) null, (PangleAd) null, str2, z, true));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Intent a(Context context, String str, q qVar, int i, PAGNativeAd pAGNativeAd, PangleAd pangleAd, String str2, boolean z) {
        return a(context, str, qVar, i, pAGNativeAd, pangleAd, str2, z, false);
    }

    private static Intent a(Context context, String str, q qVar, int i, PAGNativeAd pAGNativeAd, PangleAd pangleAd, String str2, boolean z, boolean z2) {
        Intent intent;
        if (z2 || !t.b(qVar) || (pAGNativeAd == null && pangleAd == null)) {
            intent = (z2 || qVar.M() != 3 || (qVar.o() != 2 && (qVar.o() != 1 || !a)) || qVar.bn()) ? new Intent(context, TTLandingPageActivity.class) : new Intent(context, TTVideoLandingPageLink2Activity.class);
        } else {
            intent = new Intent(context, TTPlayableLandingPageActivity.class);
            intent.putExtra("ad_pending_download", a(qVar, z));
            String e = t.e(qVar);
            if (!TextUtils.isEmpty(e)) {
                if (e.contains("?")) {
                    str = e + "&orientation=portrait";
                } else {
                    str = e + "?orientation=portrait";
                }
            }
        }
        intent.putExtra("url", str);
        intent.putExtra("gecko_id", qVar.af());
        intent.putExtra("web_title", qVar.V());
        intent.putExtra("sdk_version", BuildConfig.VERSION_CODE);
        intent.putExtra("adid", qVar.Y());
        intent.putExtra("log_extra", qVar.ac());
        a aVar = null;
        intent.putExtra(CampaignEx.JSON_KEY_ICON_URL, qVar.N() == null ? null : qVar.N().a());
        intent.putExtra("event_tag", str2);
        intent.putExtra("source", i);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, qVar.ao().toString());
        } else {
            s.a().f();
            s.a().a(qVar);
        }
        if (qVar.ad() == 5 || qVar.ad() == 15 || qVar.ad() == 50) {
            if (pAGNativeAd != null) {
                if (pAGNativeAd instanceof a.C0073a) {
                    aVar = ((a.C0073a) pAGNativeAd).g();
                } else if (pAGNativeAd instanceof com.bytedance.sdk.openadsdk.apiImpl.feed.feedexpress.a) {
                    aVar = ((com.bytedance.sdk.openadsdk.apiImpl.feed.feedexpress.a) pAGNativeAd).b();
                }
                if (aVar != null) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, aVar.a().toString());
                }
            }
            if ((pangleAd instanceof com.bytedance.sdk.openadsdk.core.bannerexpress.c) && (aVar = ((com.bytedance.sdk.openadsdk.core.bannerexpress.c) pangleAd).c()) != null) {
                intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, aVar.a().toString());
            }
            if (aVar != null) {
                intent.putExtra("video_is_auto_play", aVar.d);
                if (com.bytedance.sdk.component.utils.l.d()) {
                    com.bytedance.sdk.component.utils.l.c("videoDataModel", "videoDataModel=" + aVar.a().toString());
                }
            }
        }
        return intent;
    }

    private static boolean a(q qVar, boolean z) {
        if (z && qVar != null && qVar.M() == 4) {
            return t.b(qVar);
        }
        return false;
    }
}
