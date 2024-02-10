package com.mbridge.msdk.foundation.b;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.j;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.foundation.tools.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: BaseCandidateCache */
public class a {
    public static int b = 4;
    private static String c = "BaseCandidateCache";
    protected c a;
    private String d;
    private JSONArray e;
    private JSONObject f;

    public final void a(JSONArray jSONArray) {
        this.e = jSONArray;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final long a(List<CampaignEx> list, String str) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        String ecppv = list.get(0).getEcppv();
        if (TextUtils.isEmpty(ecppv)) {
            return 0;
        }
        String b2 = u.b(ecppv);
        if (TextUtils.isEmpty(b2)) {
            return 0;
        }
        try {
            if (Double.parseDouble(b2) <= 0.0d) {
                return 0;
            }
            JSONObject e2 = e(b(str));
            int i = 20;
            if (e2 != null) {
                i = e2.optInt("max_cache_num", 20);
            }
            c cVar = this.a;
            if (cVar == null || i <= 0) {
                return -1;
            }
            return cVar.a(list, this.d);
        } catch (Exception e3) {
            e3.printStackTrace();
            return -1;
        }
    }

    public final void a(String str, String str2, int i, String str3) {
        try {
            if (this.a == null || TextUtils.isEmpty(str3)) {
                return;
            }
            if (i == 1) {
                this.a.a(str2, str, this.d, i);
                a(b, 3, (List<CampaignEx>) null, true, str2, str, -1, this.d);
            } else if (i == 2) {
                this.a.a(this.d, str2, str);
                a(b, 1, (List<CampaignEx>) null, true, str2, str, -1, this.d);
            } else if (i == 3) {
                this.a.b(str2, str, this.d);
                a(b, 4, (List<CampaignEx>) null, true, str2, str, -1, this.d);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final String b(String str) {
        c d2 = d(str);
        if (!(d2 == null || d2.e() == c.d || d2.e() == c.b)) {
            String[] split = u.b(str.split("_")[3]).split("\\|");
            if (split.length > 1) {
                return split[1];
            }
        }
        return "";
    }

    public final double c(String str) {
        c d2 = d(str);
        if (!(d2 == null || d2.e() == c.d || d2.e() == c.b)) {
            try {
                String[] split = u.b(str.split("_")[3]).split("\\|");
                if (split.length > 0) {
                    return Double.parseDouble(split[0]);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return -1.0d;
    }

    public final c d(String str) {
        c cVar = new c();
        if (TextUtils.isEmpty(str) || str.split("_").length <= 3 || TextUtils.isEmpty(str.split("_")[3])) {
            cVar.e("bid token exception");
            cVar.a(c.b);
            return cVar;
        }
        JSONArray jSONArray = this.e;
        if (jSONArray == null || jSONArray.length() == 0) {
            cVar.e("config is empty");
            cVar.a(c.b);
            return cVar;
        }
        String b2 = u.b(str.split("_")[3]);
        if (TextUtils.isEmpty(b2)) {
            cVar.e("bid token exception:decode error");
            cVar.a(c.b);
            return cVar;
        }
        String[] split = b2.split("\\|");
        if (split.length == 0) {
            cVar.e("bid token can not get bid price");
            cVar.a(c.b);
            return cVar;
        }
        if (split.length > 0) {
            try {
                Double.parseDouble(split[0]);
            } catch (Exception unused) {
                cVar.e("bid token can not cast bid price");
                cVar.a(c.b);
                return cVar;
            }
        }
        if (TextUtils.isEmpty(this.d)) {
            cVar.e("unitId is empty");
            cVar.a(c.d);
        }
        return cVar;
    }

    public final void a(List<CampaignEx> list, String str, String str2, int i, String str3, int i2, double d2) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        CampaignEx campaignEx = list.get(i3);
                        campaignEx.setReadyState(0);
                        campaignEx.setNLRid(str);
                        campaignEx.setNRid(str2);
                        campaignEx.setErrReasonByDefaultAd(str3);
                        campaignEx.setErrTypeByDefaultAd(i);
                        String a2 = u.a(d2 + "");
                        campaignEx.setNoticeUrl(a(campaignEx.getNoticeUrl(), i2, str2, a2));
                        campaignEx.setClickURL(a(campaignEx.getClickURL(), i2, str2, a2));
                        campaignEx.setImpressionURL(a(campaignEx.getImpressionURL(), i2, str2, a2));
                        campaignEx.setOnlyImpressionURL(a(campaignEx.getOnlyImpressionURL(), i2, str2, a2));
                        campaignEx.setAdvImp(a(campaignEx.getAdvImpList(), i2, str2, a2));
                        j nativeVideoTracking = campaignEx.getNativeVideoTracking();
                        if (nativeVideoTracking != null) {
                            nativeVideoTracking.k(a(nativeVideoTracking.l(), i2, str2, a2));
                            nativeVideoTracking.c(a(nativeVideoTracking.c(), i2, str2, a2));
                            nativeVideoTracking.o(a(nativeVideoTracking.p(), i2, str2, a2));
                            nativeVideoTracking.s(a(nativeVideoTracking.t(), i2, str2, a2));
                            nativeVideoTracking.a(a(nativeVideoTracking.a(), i2, str2, a2));
                            nativeVideoTracking.b(a(nativeVideoTracking.b(), i2, str2, a2));
                            nativeVideoTracking.r(a(nativeVideoTracking.s(), i2, str2, a2));
                            nativeVideoTracking.u(a(nativeVideoTracking.v(), i2, str2, a2));
                            nativeVideoTracking.t(a(nativeVideoTracking.v(), i2, str2, a2));
                            nativeVideoTracking.v(a(nativeVideoTracking.w(), i2, str2, a2));
                            nativeVideoTracking.h(a(nativeVideoTracking.h(), i2, str2, a2));
                            nativeVideoTracking.p(a(nativeVideoTracking.q(), i2, str2, a2));
                            nativeVideoTracking.q(a(nativeVideoTracking.r(), i2, str2, a2));
                            nativeVideoTracking.n(a(nativeVideoTracking.o(), i2, str2, a2));
                            nativeVideoTracking.e(a(nativeVideoTracking.e(), i2, str2, a2));
                            nativeVideoTracking.f(a(nativeVideoTracking.f(), i2, str2, a2));
                            nativeVideoTracking.g(a(nativeVideoTracking.g(), i2, str2, a2));
                            nativeVideoTracking.i(a(nativeVideoTracking.j(), i2, str2, a2));
                            nativeVideoTracking.j(a(nativeVideoTracking.k(), i2, str2, a2));
                            nativeVideoTracking.l(a(nativeVideoTracking.m(), i2, str2, a2));
                            nativeVideoTracking.a(a(nativeVideoTracking.i(), i2, str2, a2));
                            nativeVideoTracking.d(a(nativeVideoTracking.d(), i2, str2, a2));
                            nativeVideoTracking.m(a(nativeVideoTracking.n(), i2, str2, a2));
                            campaignEx.setNativeVideoTracking(nativeVideoTracking);
                            campaignEx.setNativeVideoTrackingString(CampaignEx.object2TrackingStr(nativeVideoTracking));
                        }
                        campaignEx.setPv_urls(b(campaignEx.getPv_urls(), i2, str2, a2));
                    }
                    if (list.size() == 1) {
                        m.a().a(list.get(0));
                    } else {
                        m.a().b(list);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private String a(Map<Integer, String> map, int i, String str, String str2) {
        if (map == null || map.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (Map.Entry next : map.entrySet()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CampaignEx.JSON_AD_IMP_KEY, next.getKey());
                jSONObject.put("url", a((String) next.getValue(), i, str, str2));
                jSONArray.put(jSONObject);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return jSONArray.toString();
    }

    private List<Map<Integer, String>> a(List<Map<Integer, String>> list, int i, String str, String str2) {
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            Map map = list.get(i2);
            if (map != null && map.size() > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    map.put(entry.getKey(), a((String) entry.getValue(), i, str, str2));
                }
                arrayList.add(map);
            }
        }
        return arrayList;
    }

    private List<String> b(List<String> list, int i, String str, String str2) {
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(a(list.get(i2), i, str, str2));
        }
        return arrayList;
    }

    private String[] a(String[] strArr, int i, String str, String str2) {
        if (strArr == null || strArr.length == 0) {
            return strArr;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr2[i2] = a(strArr[i2], i, str, str2);
        }
        return strArr2;
    }

    private String a(String str, int i, String str2, String str3) {
        if (TextUtils.isEmpty(str) || str.contains("ca_sce") || str.contains("real_rid") || str.contains("real_bp")) {
            return str;
        }
        if (al.c(str) > 0) {
            return str + "&ca_sce=" + i + "&real_rid=" + str2 + "&real_bp=" + str3;
        }
        return str + "?ca_sce=" + i + "&real_rid=" + str2 + "&real_bp=" + str3;
    }

    public final c a() {
        c cVar = new c();
        try {
            JSONArray jSONArray = this.e;
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    if (this.a == null) {
                        cVar.e("db error");
                        cVar.a(c.d);
                        return cVar;
                    }
                    return cVar;
                }
            }
            cVar.e("setting config is null");
            cVar.a(c.b);
            return cVar;
        } catch (Exception unused) {
            cVar.e("checkConfigAndDB exception");
            cVar.a(c.d);
        }
    }

    public final JSONObject e(String str) {
        JSONArray jSONArray = this.e;
        if (jSONArray == null) {
            return null;
        }
        if (jSONArray.length() <= 1) {
            return this.e.optJSONObject(0);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i = 0; i < this.e.length(); i++) {
            try {
                JSONObject optJSONObject = this.e.optJSONObject(i);
                if (optJSONObject != null && str.equals(optJSONObject.getString("g"))) {
                    this.f = optJSONObject;
                    return optJSONObject;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public final void a(List<C0135a> list, int i) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    Collections.sort(list, new Comparator<C0135a>() {
                        public final /* synthetic */ int compare(Object obj, Object obj2) {
                            return Double.compare(((C0135a) obj).a, ((C0135a) obj2).a);
                        }
                    });
                    int size = list.size() - i;
                    if (size > 0) {
                        List<C0135a> subList = list.subList(0, size);
                        if (this.a != null && subList.size() > 0) {
                            for (int i2 = 0; i2 < subList.size(); i2++) {
                                b b2 = subList.get(i2).b;
                                this.a.a(this.d, b2.b(), b2.c());
                                a(b, 1, (List<CampaignEx>) null, true, b2.b(), b2.c(), -1, this.d);
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                aa.a(c, (Throwable) e2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0122 A[SYNTHETIC, Splitter:B:43:0x0122] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0182 A[Catch:{ Exception -> 0x01a8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r17, int r18, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r19, boolean r20, java.lang.String r21, java.lang.String r22, int r23, java.lang.String r24) {
        /*
            r16 = this;
            r1 = r16
            r0 = r18
            r2 = r19
            r3 = r24
            java.lang.String r4 = ""
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.lang.String r6 = "type"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a8 }
            r7.<init>()     // Catch:{ Exception -> 0x01a8 }
            r7.append(r0)     // Catch:{ Exception -> 0x01a8 }
            r7.append(r4)     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x01a8 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r6 = "result"
            if (r20 == 0) goto L_0x002b
            java.lang.String r7 = "1"
            goto L_0x002d
        L_0x002b:
            java.lang.String r7 = "2"
        L_0x002d:
            r5.put(r6, r7)     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r6 = "max_usage_limit"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a8 }
            r7.<init>()     // Catch:{ Exception -> 0x01a8 }
            r8 = r23
            r7.append(r8)     // Catch:{ Exception -> 0x01a8 }
            r7.append(r4)     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x01a8 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r6 = "unit_id"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a8 }
            r7.<init>()     // Catch:{ Exception -> 0x01a8 }
            r7.append(r3)     // Catch:{ Exception -> 0x01a8 }
            r7.append(r4)     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x01a8 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r6 = "scene"
            java.lang.String r7 = "db"
            r5.put(r6, r7)     // Catch:{ Exception -> 0x01a8 }
            org.json.JSONObject r6 = r1.f     // Catch:{ Exception -> 0x01a8 }
            if (r6 == 0) goto L_0x006f
            java.lang.String r7 = "config"
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x01a8 }
            r5.put(r7, r6)     // Catch:{ Exception -> 0x01a8 }
        L_0x006f:
            java.lang.String r6 = "lrid"
            java.lang.String r8 = "rid"
            r9 = 1
            if (r0 != r9) goto L_0x0118
            boolean r0 = android.text.TextUtils.isEmpty(r22)     // Catch:{ Exception -> 0x01a8 }
            if (r0 == 0) goto L_0x0118
            com.mbridge.msdk.foundation.db.c r0 = r1.a     // Catch:{ Exception -> 0x01a8 }
            if (r0 == 0) goto L_0x0118
            r9 = -1
            java.util.List r0 = r0.b(r3, r9)     // Catch:{ JSONException -> 0x0111 }
            org.json.JSONArray r9 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0111 }
            r9.<init>()     // Catch:{ JSONException -> 0x0111 }
            if (r0 == 0) goto L_0x0103
            int r10 = r0.size()     // Catch:{ JSONException -> 0x0111 }
            if (r10 <= 0) goto L_0x0103
            r10 = 0
        L_0x0093:
            int r11 = r0.size()     // Catch:{ JSONException -> 0x0111 }
            if (r10 >= r11) goto L_0x0103
            java.lang.Object r11 = r0.get(r10)     // Catch:{ JSONException -> 0x0111 }
            com.mbridge.msdk.foundation.b.b r11 = (com.mbridge.msdk.foundation.b.b) r11     // Catch:{ JSONException -> 0x0111 }
            if (r11 == 0) goto L_0x00fc
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0111 }
            r12.<init>()     // Catch:{ JSONException -> 0x0111 }
            java.lang.String r13 = r11.b()     // Catch:{ JSONException -> 0x0111 }
            r12.put(r8, r13)     // Catch:{ JSONException -> 0x0111 }
            java.lang.String r13 = "ts"
            long r14 = r11.f()     // Catch:{ JSONException -> 0x0111 }
            r12.put(r13, r14)     // Catch:{ JSONException -> 0x0111 }
            java.lang.String r13 = r11.c()     // Catch:{ JSONException -> 0x0111 }
            r12.put(r6, r13)     // Catch:{ JSONException -> 0x0111 }
            java.lang.String r13 = "ecppv"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0111 }
            r14.<init>()     // Catch:{ JSONException -> 0x0111 }
            r20 = r8
            double r7 = r11.g()     // Catch:{ JSONException -> 0x010f }
            r14.append(r7)     // Catch:{ JSONException -> 0x010f }
            r14.append(r4)     // Catch:{ JSONException -> 0x010f }
            java.lang.String r7 = r14.toString()     // Catch:{ JSONException -> 0x010f }
            java.lang.String r7 = com.mbridge.msdk.foundation.tools.u.a(r7)     // Catch:{ JSONException -> 0x010f }
            r12.put(r13, r7)     // Catch:{ JSONException -> 0x010f }
            java.lang.String r7 = "state"
            int r8 = r11.i()     // Catch:{ JSONException -> 0x010f }
            r12.put(r7, r8)     // Catch:{ JSONException -> 0x010f }
            java.lang.String r7 = "showCount"
            int r8 = r11.h()     // Catch:{ JSONException -> 0x010f }
            r12.put(r7, r8)     // Catch:{ JSONException -> 0x010f }
            java.lang.String r7 = "interval_ts"
            long r13 = r11.a()     // Catch:{ JSONException -> 0x010f }
            r12.put(r7, r13)     // Catch:{ JSONException -> 0x010f }
            r9.put(r12)     // Catch:{ JSONException -> 0x010f }
            goto L_0x00fe
        L_0x00fc:
            r20 = r8
        L_0x00fe:
            int r10 = r10 + 1
            r8 = r20
            goto L_0x0093
        L_0x0103:
            r20 = r8
            java.lang.String r0 = "cache"
            java.lang.String r4 = r9.toString()     // Catch:{ JSONException -> 0x010f }
            r5.put(r0, r4)     // Catch:{ JSONException -> 0x010f }
            goto L_0x011a
        L_0x010f:
            r0 = move-exception
            goto L_0x0114
        L_0x0111:
            r0 = move-exception
            r20 = r8
        L_0x0114:
            r0.printStackTrace()     // Catch:{ Exception -> 0x01a8 }
            goto L_0x011a
        L_0x0118:
            r20 = r8
        L_0x011a:
            if (r2 == 0) goto L_0x0182
            int r0 = r19.size()     // Catch:{ Exception -> 0x01a8 }
            if (r0 <= 0) goto L_0x0182
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0179 }
            r0.<init>()     // Catch:{ JSONException -> 0x0179 }
            r4 = 0
            java.lang.Object r7 = r2.get(r4)     // Catch:{ JSONException -> 0x0179 }
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = (com.mbridge.msdk.foundation.entity.CampaignEx) r7     // Catch:{ JSONException -> 0x0179 }
            if (r7 == 0) goto L_0x0135
            java.lang.String r7 = r7.getLocalRequestId()     // Catch:{ JSONException -> 0x0179 }
            goto L_0x0137
        L_0x0135:
            r7 = r22
        L_0x0137:
            int r8 = r19.size()     // Catch:{ JSONException -> 0x0175 }
            if (r4 >= r8) goto L_0x0167
            java.lang.Object r8 = r2.get(r4)     // Catch:{ JSONException -> 0x0175 }
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = (com.mbridge.msdk.foundation.entity.CampaignEx) r8     // Catch:{ JSONException -> 0x0175 }
            if (r8 == 0) goto L_0x0160
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0175 }
            r9.<init>()     // Catch:{ JSONException -> 0x0175 }
            java.lang.String r10 = r8.getRequestId()     // Catch:{ JSONException -> 0x0175 }
            r11 = r20
            r9.put(r11, r10)     // Catch:{ JSONException -> 0x0173 }
            java.lang.String r10 = "rid_n"
            java.lang.String r8 = r8.getRequestIdNotice()     // Catch:{ JSONException -> 0x0173 }
            r9.put(r10, r8)     // Catch:{ JSONException -> 0x0173 }
            r0.put(r9)     // Catch:{ JSONException -> 0x0173 }
            goto L_0x0162
        L_0x0160:
            r11 = r20
        L_0x0162:
            int r4 = r4 + 1
            r20 = r11
            goto L_0x0137
        L_0x0167:
            r11 = r20
            java.lang.String r2 = "c_info"
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0173 }
            r5.put(r2, r0)     // Catch:{ JSONException -> 0x0173 }
            goto L_0x0186
        L_0x0173:
            r0 = move-exception
            goto L_0x017e
        L_0x0175:
            r0 = move-exception
            r11 = r20
            goto L_0x017e
        L_0x0179:
            r0 = move-exception
            r11 = r20
            r7 = r22
        L_0x017e:
            r0.printStackTrace()     // Catch:{ Exception -> 0x01a8 }
            goto L_0x0186
        L_0x0182:
            r11 = r20
            r7 = r22
        L_0x0186:
            r2 = r21
            r5.put(r11, r2)     // Catch:{ Exception -> 0x01a8 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x01a8 }
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r2 = "m_candidate_db"
            java.lang.String r4 = "report candidate db opt"
            java.lang.String r6 = ""
            r17 = r0
            r18 = r2
            r19 = r4
            r20 = r24
            r21 = r6
            r22 = r5
            r17.a((java.lang.String) r18, (java.lang.String) r19, (java.lang.String) r20, (java.lang.String) r21, (java.util.Map<java.lang.String, java.lang.String>) r22)     // Catch:{ Exception -> 0x01a8 }
            goto L_0x01ac
        L_0x01a8:
            r0 = move-exception
            r0.printStackTrace()
        L_0x01ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.b.a.a(int, int, java.util.List, boolean, java.lang.String, java.lang.String, int, java.lang.String):void");
    }

    /* renamed from: com.mbridge.msdk.foundation.b.a$a  reason: collision with other inner class name */
    /* compiled from: BaseCandidateCache */
    public static class C0135a {
        /* access modifiers changed from: private */
        public double a;
        /* access modifiers changed from: private */
        public b b;

        public C0135a(double d, b bVar) {
            this.a = d;
            this.b = bVar;
        }

        public final b a() {
            return this.b;
        }
    }

    public final List<b> a(int i) {
        c cVar;
        if (i >= 0 && (cVar = this.a) != null) {
            cVar.a(this.d, i);
            a(b, 1, (List<CampaignEx>) null, true, "", "", i, this.d);
        }
        c cVar2 = this.a;
        if (cVar2 != null) {
            return cVar2.b(this.d, 0);
        }
        return null;
    }
}
