package com.mbridge.msdk.reward.a;

import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.b.a;
import com.mbridge.msdk.foundation.b.d;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.e;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.reward.adapter.c;
import com.mbridge.msdk.videocommon.d.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RewardCandidateController */
public final class a {
    private static String a = "RewardCandidateController";
    private d b;

    public a(String str, boolean z) {
        try {
            this.b = com.mbridge.msdk.foundation.controller.a.a().a(str, b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), str, z).H());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(List<CampaignEx> list, String str, c cVar, String str2) {
        String str3 = str;
        try {
            if (this.b != null && !TextUtils.isEmpty(str)) {
                List<CampaignEx> list2 = list;
                this.b.a(com.mbridge.msdk.foundation.b.a.b, 2, list, this.b.a(list, str) > 0, "", "", -1, str2);
                d dVar = this.b;
                JSONObject e = dVar.e(dVar.b(str));
                if (e != null && this.b.c(str) > 0.0d) {
                    int optInt = e.optInt("max_usage_limit", 10);
                    a(this.b.a(optInt), e, e.optInt("max_cache_num", 20), -1.0d, cVar, "", str, false, 0);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final com.mbridge.msdk.foundation.b.c a(String str, String str2, CampaignEx campaignEx, e eVar, int i, c cVar) {
        String str3;
        String str4;
        int i2;
        com.mbridge.msdk.foundation.b.c cVar2;
        String str5 = str;
        com.mbridge.msdk.foundation.b.c cVar3 = new com.mbridge.msdk.foundation.b.c();
        String str6 = "";
        if (campaignEx == null) {
            str3 = str6;
        } else {
            try {
                str3 = campaignEx.getRequestId();
            } catch (Exception unused) {
                try {
                    cVar3.e("getRewardCandidateCampaignList result exception");
                    cVar3.a(com.mbridge.msdk.foundation.b.c.d);
                    return cVar3;
                } catch (Exception unused2) {
                    cVar3.e("getCandidateCampaignList result exception");
                    cVar3.a(com.mbridge.msdk.foundation.b.c.d);
                    return cVar3;
                }
            }
        }
        if (eVar != null) {
            i2 = eVar.d();
            str4 = eVar.e();
        } else {
            str4 = null;
            i2 = 0;
        }
        d dVar = this.b;
        if (dVar == null) {
            cVar2 = new com.mbridge.msdk.foundation.b.c();
            cVar2.e("can not get manager");
            cVar2.a(com.mbridge.msdk.foundation.b.c.d);
        } else {
            com.mbridge.msdk.foundation.b.c d = dVar.d(str5);
            if (d.e() > com.mbridge.msdk.foundation.b.c.a) {
                cVar2 = d;
            } else {
                String[] split = u.b(str5.split("_")[3]).split("\\|");
                double parseDouble = Double.parseDouble(split[0]);
                if (split.length > 1) {
                    str6 = split[1];
                }
                cVar2 = a(parseDouble, str6, cVar, str2, str, i);
                this.b.a(cVar2.g(), str2, str3, i2, str4, i, parseDouble);
            }
        }
        return cVar2;
    }

    private com.mbridge.msdk.foundation.b.c a(double d, String str, c cVar, String str2, String str3, int i) {
        com.mbridge.msdk.foundation.b.c a2 = this.b.a();
        try {
            if (a2.e() > 0) {
                return a2;
            }
            JSONObject e = this.b.e(str);
            if (e != null) {
                int optInt = e.optInt("max_usage_limit", 10);
                int optInt2 = e.optInt("max_cache_num", 20);
                if (optInt2 > 0) {
                    List<com.mbridge.msdk.foundation.b.b> a3 = this.b.a(optInt);
                    if (a3 != null && a3.size() > 0) {
                        return a(a3, e, optInt2, d, cVar, str2, str3, true, i);
                    }
                    a2.e("no cache");
                    a2.a(com.mbridge.msdk.foundation.b.c.d);
                    a(str2, str3, a2, (List<a.C0135a>) null, e, 2);
                } else {
                    a2.e("max cache num error");
                    a2.a(com.mbridge.msdk.foundation.b.c.d);
                }
            } else {
                a2.e("setting config not mapping");
                a2.a(com.mbridge.msdk.foundation.b.c.d);
            }
            return a2;
        } catch (Exception unused) {
            a2.e("getHighestCampaigns exception");
            a2.a(com.mbridge.msdk.foundation.b.c.d);
        }
    }

    private com.mbridge.msdk.foundation.b.c a(List<com.mbridge.msdk.foundation.b.b> list, JSONObject jSONObject, int i, double d, c cVar, String str, String str2, boolean z, int i2) {
        ArrayList arrayList;
        int i3;
        com.mbridge.msdk.foundation.b.c cVar2;
        a aVar = this;
        List<com.mbridge.msdk.foundation.b.b> list2 = list;
        JSONObject jSONObject2 = jSONObject;
        c cVar3 = cVar;
        com.mbridge.msdk.foundation.b.c cVar4 = new com.mbridge.msdk.foundation.b.c();
        if (jSONObject2 == null) {
            cVar4.e("config is null");
            cVar4.a(com.mbridge.msdk.foundation.b.c.d);
            return cVar4;
        } else if (list2 == null || list.size() == 0) {
            cVar4.e("candidate is null");
            cVar4.a(com.mbridge.msdk.foundation.b.c.d);
            return cVar4;
        } else {
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                com.mbridge.msdk.foundation.b.b bVar = list2.get(i5);
                if (bVar != null) {
                    cVar4.a(bVar.b());
                }
            }
            if (list.size() > 0 && ((list2 = aVar.a(list2, cVar4)) == null || list2.size() == 0)) {
                cVar4.e("existed");
                cVar4.a(com.mbridge.msdk.foundation.b.c.d);
            }
            if (list2.size() > 0 && ((list2 = aVar.a(list2, cVar3, cVar4)) == null || list2.size() == 0)) {
                cVar4.e("not ready");
                cVar4.a(com.mbridge.msdk.foundation.b.c.d);
            }
            if (list2.size() > 0 && ((list2 = aVar.b(list2, cVar3, cVar4)) == null || list2.size() == 0)) {
                cVar4.e("had in cache");
                cVar4.a(com.mbridge.msdk.foundation.b.c.d);
            }
            com.mbridge.msdk.foundation.b.b bVar2 = null;
            if (list2 == null || list2.size() <= 0) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                double optDouble = jSONObject2.optDouble("t_disc", 0.8d);
                double optDouble2 = jSONObject2.optDouble("u_disc", 0.95d);
                double d2 = 0.0d;
                double optDouble3 = jSONObject2.optDouble("max_ecppv_diff", 0.0d);
                int optInt = jSONObject2.optInt("time_interval", 1800);
                int size = list2.size();
                while (i4 < size) {
                    List<com.mbridge.msdk.foundation.b.b> list3 = list2;
                    com.mbridge.msdk.foundation.b.b bVar3 = list2.get(i4);
                    if (bVar3 != null) {
                        double g = bVar3.g();
                        i3 = size;
                        double currentTimeMillis = (double) (System.currentTimeMillis() - bVar3.f());
                        cVar2 = cVar4;
                        double d3 = (double) optInt;
                        Double.isNaN(d3);
                        Double.isNaN(currentTimeMillis);
                        double pow = Math.pow(optDouble2, (double) bVar3.h()) * g * Math.pow(optDouble, currentTimeMillis / (d3 * 1000.0d));
                        arrayList2.add(new a.C0135a(pow, bVar3));
                        if (pow >= d - optDouble3 && pow > d2) {
                            bVar2 = bVar3;
                            d2 = pow;
                        }
                    } else {
                        i3 = size;
                        cVar2 = cVar4;
                    }
                    i4++;
                    aVar = this;
                    list2 = list3;
                    JSONObject jSONObject3 = jSONObject;
                    size = i3;
                    cVar4 = cVar2;
                }
                com.mbridge.msdk.foundation.b.c cVar5 = cVar4;
                d dVar = aVar.b;
                if (dVar != null) {
                    dVar.a((List<a.C0135a>) arrayList2, i);
                }
                if (bVar2 != null) {
                    cVar4 = cVar5;
                    cVar4.a(bVar2.e());
                    cVar4.a(com.mbridge.msdk.foundation.b.c.c);
                } else {
                    cVar4 = cVar5;
                    cVar4.e("no match campaign");
                    cVar4.a(com.mbridge.msdk.foundation.b.c.d);
                }
                arrayList = arrayList2;
            }
            if (z) {
                a(str, str2, cVar4, (List<a.C0135a>) arrayList, jSONObject, i2);
            }
            return cVar4;
        }
    }

    private List<com.mbridge.msdk.foundation.b.b> a(List<com.mbridge.msdk.foundation.b.b> list, com.mbridge.msdk.foundation.b.c cVar) {
        CopyOnWriteArrayList<CampaignEx> e;
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            com.mbridge.msdk.foundation.b.b bVar = list.get(i);
            if (!(bVar == null || (e = bVar.e()) == null || e.size() == 0)) {
                int i2 = 0;
                boolean z = false;
                while (true) {
                    if (i2 >= e.size()) {
                        break;
                    }
                    CampaignEx campaignEx = e.get(i2);
                    boolean c = af.c(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx.getPackageName());
                    if (c) {
                        cVar.c(bVar.b());
                        d dVar = this.b;
                        if (dVar != null) {
                            dVar.a(bVar.c(), bVar.b(), 2, campaignEx.getEcppv());
                        }
                        z = c;
                    } else {
                        i2++;
                        z = c;
                    }
                }
                if (!z) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        r6 = r12.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r4, !android.text.TextUtils.isEmpty(r7.getCMPTEntryUrl()));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.mbridge.msdk.foundation.b.b> a(java.util.List<com.mbridge.msdk.foundation.b.b> r11, com.mbridge.msdk.reward.adapter.c r12, com.mbridge.msdk.foundation.b.c r13) {
        /*
            r10 = this;
            if (r11 == 0) goto L_0x0075
            int r0 = r11.size()
            if (r0 != 0) goto L_0x000a
            goto L_0x0075
        L_0x000a:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = 0
        L_0x0011:
            int r3 = r11.size()
            if (r2 >= r3) goto L_0x0074
            java.lang.Object r3 = r11.get(r2)
            com.mbridge.msdk.foundation.b.b r3 = (com.mbridge.msdk.foundation.b.b) r3
            if (r3 != 0) goto L_0x0020
            goto L_0x0071
        L_0x0020:
            java.util.concurrent.CopyOnWriteArrayList r4 = r3.e()
            if (r4 == 0) goto L_0x0071
            int r5 = r4.size()
            if (r5 != 0) goto L_0x002d
            goto L_0x0071
        L_0x002d:
            r5 = 0
            r6 = 0
        L_0x002f:
            int r7 = r4.size()
            if (r5 >= r7) goto L_0x006c
            java.lang.Object r7 = r4.get(r5)
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = (com.mbridge.msdk.foundation.entity.CampaignEx) r7
            if (r12 == 0) goto L_0x0069
            java.lang.String r6 = r7.getCMPTEntryUrl()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            r6 = r6 ^ 1
            boolean r6 = r12.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r4, (boolean) r6)
            if (r6 != 0) goto L_0x0069
            java.lang.String r4 = r3.b()
            r13.b(r4)
            com.mbridge.msdk.foundation.b.d r4 = r10.b
            if (r4 == 0) goto L_0x006c
            java.lang.String r5 = r3.c()
            java.lang.String r8 = r3.b()
            r9 = 2
            java.lang.String r7 = r7.getEcppv()
            r4.a((java.lang.String) r5, (java.lang.String) r8, (int) r9, (java.lang.String) r7)
            goto L_0x006c
        L_0x0069:
            int r5 = r5 + 1
            goto L_0x002f
        L_0x006c:
            if (r6 == 0) goto L_0x0071
            r0.add(r3)
        L_0x0071:
            int r2 = r2 + 1
            goto L_0x0011
        L_0x0074:
            return r0
        L_0x0075:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.a.a.a(java.util.List, com.mbridge.msdk.reward.adapter.c, com.mbridge.msdk.foundation.b.c):java.util.List");
    }

    private List<com.mbridge.msdk.foundation.b.b> b(List<com.mbridge.msdk.foundation.b.b> list, c cVar, com.mbridge.msdk.foundation.b.c cVar2) {
        CopyOnWriteArrayList<CampaignEx> e;
        if (list == null || list.size() == 0) {
            return list;
        }
        List<String> c = com.mbridge.msdk.videocommon.a.a.a().c(list.get(0).d());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            com.mbridge.msdk.foundation.b.b bVar = list.get(i);
            if (!(bVar == null || (e = bVar.e()) == null || e.size() == 0)) {
                if (c == null || c.size() <= 0 || !c.contains(bVar.b())) {
                    arrayList.add(bVar);
                } else {
                    cVar2.d(bVar.b());
                }
            }
        }
        return arrayList;
    }

    public final boolean a(String str) {
        JSONObject e;
        try {
            d dVar = this.b;
            if (dVar == null || (e = dVar.e(dVar.b(str))) == null || e.optInt("c_cb", 0) != 1) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public final void a(String str, String str2, int i, String str3) {
        d dVar = this.b;
        if (dVar != null) {
            dVar.a(str, str2, i, str3);
        }
    }

    public final void a(String str, String str2, com.mbridge.msdk.foundation.b.c cVar, List<a.C0135a> list, JSONObject jSONObject, int i) {
        try {
            if (TextUtils.isEmpty(str)) {
                aa.d(a, "report lrid is null");
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("scene", (i != 1 ? i != 2 ? i != 3 ? "unknown" : "track" : "candidate" : "cb").concat(""));
            d dVar = this.b;
            if (dVar != null) {
                double c = dVar.c(str2);
                if (c >= 0.0d) {
                    hashMap.put("bp", u.a(c + ""));
                }
                hashMap.put("cb_state", a(str2) ? "open" : "close");
                try {
                    d dVar2 = this.b;
                    JSONObject e = dVar2.e(dVar2.b(str2));
                    if (e != null) {
                        hashMap.put("config", e.toString());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (cVar != null) {
                if (cVar.e() == com.mbridge.msdk.foundation.b.c.c) {
                    hashMap.put(IronSourceConstants.EVENTS_RESULT, "1");
                } else {
                    hashMap.put(IronSourceConstants.EVENTS_RESULT, "2");
                    hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, cVar.f());
                }
                hashMap.put("acr", cVar.a());
                hashMap.put("her", cVar.c());
                hashMap.put("nrr", cVar.b());
                hashMap.put("cer", cVar.d());
            } else {
                hashMap.put(IronSourceConstants.EVENTS_RESULT, "2");
                hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, "candidate result is null");
            }
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    com.mbridge.msdk.foundation.b.b a2 = list.get(i2).a();
                    if (a2 != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("ecppv", u.a(a2.g() + ""));
                        jSONObject2.put("showCount", a2.h());
                        jSONObject2.put("intervalTime", System.currentTimeMillis() - a2.f());
                        jSONArray.put(jSONObject2);
                    }
                }
                hashMap.put("data", jSONArray.toString());
            }
            m.a().a("m_candidate_data", str, (Map<String, String>) hashMap);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
