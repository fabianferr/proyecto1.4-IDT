package com.mbridge.msdk.video.module.b;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.mbridge.msdk.foundation.same.report.d.a;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.videocommon.b.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: VideoViewReport */
public final class b {
    public static HashMap<String, ArrayList<String>> a = new HashMap<>();

    public static void a(String str) {
        a.remove(str);
    }

    public static void a(String str, String str2) {
        try {
            if (com.mbridge.msdk.foundation.controller.b.d().g() != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                a aVar = new a(com.mbridge.msdk.foundation.controller.b.d().g());
                d a2 = q.a(str, com.mbridge.msdk.foundation.controller.b.d().g(), str2);
                a2.a("r_stid", com.mbridge.msdk.videocommon.d.b.a().b().b());
                aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.a().a, a2, new com.mbridge.msdk.foundation.same.report.d.b() {
                    public final void onSuccess(String str) {
                        aa.d("VideoViewReport", str);
                    }

                    public final void onFailed(String str) {
                        aa.d("VideoViewReport", str);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            aa.d("VideoViewReport", e.getMessage());
        }
    }

    public static void a(Context context, CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().p() != null) {
            m.a().a("2000141", campaignEx, (Map<String, String>) new HashMap());
            com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().p(), false, false);
        }
    }

    public static void b(Context context, CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().j() != null) {
            com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().j(), false, false);
        }
    }

    public static void c(Context context, CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().k() != null) {
            com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().k(), false, false);
        }
    }

    public static void d(Context context, CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().l() != null) {
            String campaignUnitId = campaignEx.getCampaignUnitId();
            ArrayList arrayList = a.get(campaignUnitId);
            if (arrayList == null) {
                arrayList = new ArrayList();
                a.put(campaignUnitId, arrayList);
            }
            if (!arrayList.contains(campaignEx.getId())) {
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("update", "1");
                    m.a().a("2000142", campaignEx, (Map<String, String>) hashMap);
                } catch (Exception unused) {
                }
                com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().l(), false, false);
                arrayList.add(campaignEx.getId());
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00d5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r8, com.mbridge.msdk.foundation.entity.CampaignEx r9, int r10, int r11) {
        /*
            com.mbridge.msdk.foundation.entity.j r0 = r9.getNativeVideoTracking()     // Catch:{ all -> 0x00df }
            java.lang.String[] r0 = r0.r()     // Catch:{ all -> 0x00df }
            if (r9 == 0) goto L_0x00e6
            com.mbridge.msdk.foundation.entity.j r1 = r9.getNativeVideoTracking()     // Catch:{ all -> 0x00df }
            if (r1 == 0) goto L_0x00e6
            if (r0 == 0) goto L_0x00e6
            int r1 = r0.length     // Catch:{ all -> 0x00df }
            java.lang.String[] r5 = new java.lang.String[r1]     // Catch:{ all -> 0x00df }
            r1 = 0
        L_0x0016:
            int r2 = r0.length     // Catch:{ all -> 0x00df }
            if (r1 >= r2) goto L_0x009d
            r2 = r0[r1]     // Catch:{ all -> 0x00df }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x00df }
            r3.<init>()     // Catch:{ all -> 0x00df }
            java.lang.String r4 = "endscreen_type"
            r3.put(r4, r10)     // Catch:{ all -> 0x00df }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00df }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00df }
            if (r4 != 0) goto L_0x0033
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.u.a(r3)     // Catch:{ all -> 0x00df }
        L_0x0033:
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00df }
            if (r4 != 0) goto L_0x0051
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00df }
            r4.<init>()     // Catch:{ all -> 0x00df }
            r4.append(r2)     // Catch:{ all -> 0x00df }
            java.lang.String r2 = "&value="
            r4.append(r2)     // Catch:{ all -> 0x00df }
            java.lang.String r2 = java.net.URLEncoder.encode(r3)     // Catch:{ all -> 0x00df }
            r4.append(r2)     // Catch:{ all -> 0x00df }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x00df }
        L_0x0051:
            int r3 = r9.getSpareOfferFlag()     // Catch:{ all -> 0x00df }
            java.lang.String r4 = "&tmorl="
            r6 = 1
            if (r3 != r6) goto L_0x0079
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00df }
            r3.<init>()     // Catch:{ all -> 0x00df }
            r3.append(r2)     // Catch:{ all -> 0x00df }
            java.lang.String r2 = "&to=1&cbt="
            r3.append(r2)     // Catch:{ all -> 0x00df }
            int r2 = r9.getCbt()     // Catch:{ all -> 0x00df }
            r3.append(r2)     // Catch:{ all -> 0x00df }
            r3.append(r4)     // Catch:{ all -> 0x00df }
            r3.append(r11)     // Catch:{ all -> 0x00df }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x00df }
            goto L_0x0097
        L_0x0079:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00df }
            r3.<init>()     // Catch:{ all -> 0x00df }
            r3.append(r2)     // Catch:{ all -> 0x00df }
            java.lang.String r2 = "&to=0&cbt="
            r3.append(r2)     // Catch:{ all -> 0x00df }
            int r2 = r9.getCbt()     // Catch:{ all -> 0x00df }
            r3.append(r2)     // Catch:{ all -> 0x00df }
            r3.append(r4)     // Catch:{ all -> 0x00df }
            r3.append(r11)     // Catch:{ all -> 0x00df }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x00df }
        L_0x0097:
            r5[r1] = r2     // Catch:{ all -> 0x00df }
            int r1 = r1 + 1
            goto L_0x0016
        L_0x009d:
            r6 = 0
            r7 = 1
            java.util.HashMap r11 = new java.util.HashMap     // Catch:{ Exception -> 0x00d5 }
            r11.<init>()     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r0 = "type"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d5 }
            r1.<init>()     // Catch:{ Exception -> 0x00d5 }
            r1.append(r10)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r10 = ""
            r1.append(r10)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r10 = r1.toString()     // Catch:{ Exception -> 0x00d5 }
            r11.put(r0, r10)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r10 = "update"
            java.lang.String r0 = "1"
            r11.put(r10, r0)     // Catch:{ Exception -> 0x00d5 }
            com.mbridge.msdk.foundation.same.report.m r10 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r0 = "2000144"
            r10.a((java.lang.String) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r9, (java.util.Map<java.lang.String, java.lang.String>) r11)     // Catch:{ Exception -> 0x00d5 }
            com.mbridge.msdk.foundation.same.report.m r10 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r0 = "2000147"
            r10.a((java.lang.String) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r9, (java.util.Map<java.lang.String, java.lang.String>) r11)     // Catch:{ Exception -> 0x00d5 }
        L_0x00d5:
            java.lang.String r4 = r9.getCampaignUnitId()     // Catch:{ all -> 0x00df }
            r2 = r8
            r3 = r9
            com.mbridge.msdk.click.a.a((android.content.Context) r2, (com.mbridge.msdk.foundation.entity.CampaignEx) r3, (java.lang.String) r4, (java.lang.String[]) r5, (boolean) r6, (boolean) r7)     // Catch:{ all -> 0x00df }
            goto L_0x00e6
        L_0x00df:
            java.lang.String r8 = "VideoViewReport"
            java.lang.String r9 = "reportEndcardshowData error"
            com.mbridge.msdk.foundation.tools.aa.d(r8, r9)
        L_0x00e6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.b.b.a(android.content.Context, com.mbridge.msdk.foundation.entity.CampaignEx, int, int):void");
    }

    public static void e(Context context, CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().s() != null) {
            m.a().a("2000143", campaignEx, (Map<String, String>) new HashMap());
            com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().s(), false, false);
        }
    }

    public static void f(Context context, CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().m() != null) {
            com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().m(), false, false);
        }
    }

    public static void a(Context context, CampaignEx campaignEx, int i, int i2, int i3) {
        String str;
        CampaignEx campaignEx2 = campaignEx;
        int i4 = i3;
        if (i2 != 0 && context != null && campaignEx2 != null) {
            try {
                List<Map<Integer, String>> i5 = campaignEx.getNativeVideoTracking().i();
                int i6 = ((i + 1) * 100) / i2;
                if (i5 != null) {
                    int i7 = 0;
                    int i8 = 0;
                    while (i7 < i5.size()) {
                        Map map = i5.get(i7);
                        if (map != null && map.size() > 0) {
                            Iterator it = map.entrySet().iterator();
                            int i9 = i7;
                            while (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                int intValue = ((Integer) entry.getKey()).intValue();
                                String str2 = (String) entry.getValue();
                                if (campaignEx.getSpareOfferFlag() == 1) {
                                    str = str2 + "&to=1&cbt=" + campaignEx.getCbt() + "&tmorl=" + i4;
                                } else {
                                    str = str2 + "&to=0&cbt=" + campaignEx.getCbt() + "&tmorl=" + i4;
                                }
                                if (intValue <= i6 && !TextUtils.isEmpty(str)) {
                                    String[] strArr = {str};
                                    if (i8 < 1) {
                                        i8++;
                                        try {
                                            HashMap hashMap = new HashMap();
                                            hashMap.put("percent", intValue + "");
                                            m.a().a("2000140", campaignEx2, (Map<String, String>) hashMap);
                                        } catch (Exception unused) {
                                        }
                                    }
                                    int i10 = i8;
                                    com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), strArr, false, true);
                                    it.remove();
                                    i5.remove(i9);
                                    i9--;
                                    i8 = i10;
                                }
                            }
                            i7 = i9;
                        }
                        i7++;
                    }
                }
            } catch (Throwable unused2) {
                aa.d("VideoViewReport", "reportPlayPercentageData error");
            }
        }
    }

    public static void a(CampaignEx campaignEx, Map<Integer, String> map, String str, int i) {
        if (campaignEx != null && map != null) {
            try {
                if (map.size() > 0) {
                    Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry next = it.next();
                        String str2 = (String) next.getValue();
                        if (i == ((Integer) next.getKey()).intValue() && !TextUtils.isEmpty(str2)) {
                            com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx, str, str2, false, false);
                            it.remove();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(CampaignEx campaignEx, String str) {
        if (campaignEx != null) {
            try {
                if (campaignEx.getAdUrlList() != null && campaignEx.getAdUrlList().size() > 0) {
                    for (String next : campaignEx.getAdUrlList()) {
                        if (!TextUtils.isEmpty(next)) {
                            com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx, str, next, false, false);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(CampaignEx campaignEx, c cVar, String str, String str2, String str3) {
        String str4 = "&";
        String str5 = "";
        if (campaignEx != null && cVar != null) {
            try {
                com.mbridge.msdk.video.module.c.a aVar = new com.mbridge.msdk.video.module.c.a(com.mbridge.msdk.foundation.controller.b.d().g());
                d dVar = new d();
                dVar.a(AccessToken.USER_ID_KEY, u.a(str2));
                dVar.a("cb_type", "1");
                dVar.a(CampaignEx.JSON_KEY_REWARD_NAME, cVar.a());
                dVar.a(CampaignEx.JSON_KEY_REWARD_AMOUNT, cVar.b() + str5);
                dVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                dVar.a("click_id", campaignEx.getRequestIdNotice());
                if (!TextUtils.isEmpty(str3)) {
                    dVar.a("extra", str3);
                }
                aVar.addExtraParams(str5, dVar);
                String str6 = campaignEx.getHost() + "/addReward?";
                String trim = dVar.a().trim();
                if (!TextUtils.isEmpty(trim)) {
                    if (!str6.endsWith("?") && !str6.endsWith(str4)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str6);
                        if (!str6.contains("?")) {
                            str4 = "?";
                        }
                        sb.append(str4);
                        str6 = sb.toString();
                    }
                    str5 = str6 + trim;
                }
                String str7 = str5;
                aa.d("VideoViewReport", "rewardUrl:" + str7);
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx, campaignEx.getCampaignUnitId(), str7, false, false);
            } catch (Throwable th) {
                aa.b("VideoViewReport", th.getMessage(), th);
            }
        }
    }
}
