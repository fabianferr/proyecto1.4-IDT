package com.mbridge.msdk.video.bt.module.b;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.mbridge.msdk.foundation.same.report.d.a;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.w;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RewardReport */
public class f {
    /* access modifiers changed from: private */
    public static final String a = "com.mbridge.msdk.video.bt.module.b.f";

    private static void a(final Context context, final String str, String str2) {
        if (b.d().g() != null) {
            context = b.d().g();
        }
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                a aVar = new a(context);
                d a2 = q.a(str, context, str2);
                a2.a("r_stid", com.mbridge.msdk.videocommon.d.b.a().b().b());
                aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.a().a, a2, new com.mbridge.msdk.foundation.same.report.d.b() {
                    public final void onSuccess(String str) {
                        aa.d(f.a, str);
                    }

                    public final void onFailed(final String str) {
                        com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() {
                            public final void run() {
                                l lVar = new l();
                                lVar.c(str);
                                lVar.a(System.currentTimeMillis());
                                lVar.a(0);
                                lVar.b("POST");
                                lVar.a(com.mbridge.msdk.foundation.same.net.g.d.a().a);
                                n.a((g) h.a(context)).a(lVar);
                                aa.d(f.a, str);
                            }
                        });
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aa.d(a, e.getMessage());
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, int i) {
        if (context != null && campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    StringBuffer append = new StringBuffer().append("key=2000054&");
                    append.append("network_type=" + w.r(context) + "&");
                    append.append("unit_id=" + str + "&");
                    append.append("cid=" + campaignEx.getId() + "&");
                    append.append("reason=&");
                    append.append("templateshowtype=" + i + " offer show success&");
                    append.append("result=2&");
                    if (campaignEx == null || campaignEx.getAdType() != 287) {
                        if (campaignEx != null) {
                            if (campaignEx.getAdType() == 94) {
                                append.append("ad_type=1&");
                            }
                        }
                        append.append("ad_type=1&");
                    } else {
                        append.append("ad_type=3&");
                    }
                    String str2 = campaignEx.getendcard_url();
                    if (!TextUtils.isEmpty(str2)) {
                        append.append("creative=" + URLEncoder.encode(str2) + "&");
                    }
                    append.append("devid=" + w.a() + "&");
                    if (campaignEx != null) {
                        StringBuffer append2 = append.append("rid=").append(campaignEx.getRequestId()).append("&");
                        append = append2.append("rid_n=" + campaignEx.getRequestIdNotice()).append("&adspace_t=");
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

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i) {
        Context context2 = context;
        String str3 = str;
        String str4 = str2;
        if (context2 != null && campaignEx != null) {
            try {
                if ((!TextUtils.isEmpty(str)) && (true ^ TextUtils.isEmpty(str2))) {
                    StringBuffer append = new StringBuffer().append("key=2000054&");
                    append.append("network_type=" + w.r(context) + "&");
                    append.append("unit_id=" + str3 + "&");
                    append.append("cid=" + campaignEx.getId() + "&");
                    append.append("reason=" + str4 + "&");
                    append.append("templateshowtype=" + i + "&");
                    append.append("reason=" + str4 + "&");
                    append.append("result=1&");
                    if (!TextUtils.isEmpty(campaignEx.getendcard_url())) {
                        append.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                    }
                    append.append("devid=" + w.a() + "&");
                    if (campaignEx == null || campaignEx.getAdType() != 287) {
                        if (campaignEx != null) {
                            if (campaignEx.getAdType() == 94) {
                                append.append("ad_type=1&");
                            }
                        }
                        append.append("ad_type=1&");
                    } else {
                        append.append("ad_type=3&");
                    }
                    if (campaignEx != null) {
                        StringBuffer append2 = append.append("rid=").append(campaignEx.getRequestId()).append("&");
                        StringBuffer append3 = append2.append("rid_n=" + campaignEx.getRequestIdNotice()).append("&");
                        append = append3.append("adspace_t=" + campaignEx.getAdSpaceT());
                    }
                    if (k.a().c()) {
                        k.a().a(append.toString());
                    } else {
                        a(context2, append.toString(), str3);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, List<CampaignEx> list, String str) {
        if (context != null && list != null) {
            try {
                if (list.size() > 0 && !TextUtils.isEmpty(str)) {
                    StringBuffer append = new StringBuffer().append("key=2000054&");
                    append.append("network_type=" + w.r(context) + "&");
                    append.append("unit_id=" + str + "&");
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < list.size(); i++) {
                        arrayList.add(list.get(i).getId());
                    }
                    append.append("cid=" + arrayList.toString() + "&");
                    append.append("result=2&");
                    if (list.get(0) != null) {
                        CampaignEx campaignEx = list.get(0);
                        append.append("reason=&");
                        append.append("templateshowtype=two offer ec show success&");
                        append.append("ad_type=" + campaignEx.getAdType() + "&");
                        append.append("devid=" + w.a() + "&");
                        StringBuffer append2 = append.append("rid=").append(campaignEx.getRequestId()).append("&");
                        append = append2.append("rid_n=" + campaignEx.getRequestIdNotice()).append("&");
                        append.append("&adspace_t=").append(campaignEx.getAdSpaceT());
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

    public static void a(Context context, List<CampaignEx> list, String str, String str2) {
        if (context != null && list != null) {
            try {
                if ((!TextUtils.isEmpty(str)) && (true ^ TextUtils.isEmpty(str2))) {
                    StringBuffer append = new StringBuffer().append("key=2000054&");
                    append.append("network_type=" + w.r(context) + "&");
                    append.append("unit_id=" + str + "&");
                    String[] strArr = new String[list.size()];
                    for (int i = 0; i < list.size(); i++) {
                        strArr[i] = list.get(i).getId();
                    }
                    append.append("cid=" + strArr + "&");
                    append.append("reason=" + str2 + "&");
                    append.append("result=1&");
                    append.append("devid=" + w.a() + "&");
                    if (list.get(0) != null) {
                        CampaignEx campaignEx = list.get(0);
                        append.append("ad_type=" + campaignEx.getAdType() + "&");
                        StringBuffer append2 = append.append("rid=").append(campaignEx.getRequestId()).append("&");
                        StringBuffer append3 = append2.append("rid_n=" + campaignEx.getRequestIdNotice()).append("&");
                        StringBuffer append4 = append3.append("templateshowtype=" + campaignEx.getMof_tplid()).append("&");
                        append = append4.append("adspace_t=" + campaignEx.getAdSpaceT());
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

    public static void a(CampaignEx campaignEx, String str, int i) {
        try {
            Context g = b.d().g();
            if (g != null && campaignEx != null && !TextUtils.isEmpty(str)) {
                StringBuffer stringBuffer = new StringBuffer("key=2000115&");
                stringBuffer.append("network_type=" + w.r(g) + "&");
                stringBuffer.append("unit_id=" + str + "&");
                stringBuffer.append("cid=" + campaignEx.getId() + "&");
                stringBuffer.append("play_cur_time=" + i + "&");
                stringBuffer.append("reason=close ad in advance " + campaignEx.getMof_tplid() + "&");
                stringBuffer.append("result=1&");
                stringBuffer.append("devid=" + w.a() + "&");
                stringBuffer.append("ad_type=" + campaignEx.getAdType() + "&");
                StringBuffer append = stringBuffer.append("rid=").append(campaignEx.getRequestId()).append("&");
                StringBuffer append2 = append.append("rid_n=" + campaignEx.getRequestIdNotice()).append("&");
                StringBuffer append3 = append2.append("adspace_t=" + campaignEx.getAdSpaceT());
                if (k.a().c()) {
                    k.a().a(append3.toString());
                } else {
                    a(g, append3.toString(), str);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
