package com.mbridge.msdk.reward.c;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.q;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.c;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.videocommon.d.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: RewardReport */
public class a {
    /* access modifiers changed from: private */
    public static final String a = "com.mbridge.msdk.reward.c.a";
    private static String b = "";

    public static void a(Context context, String str) {
        if (context != null) {
            try {
                q a2 = q.a((g) h.a(context));
                if (!TextUtils.isEmpty(str) && a2 != null && a2.a() > 0) {
                    List<n> a3 = a2.a("2000022");
                    List<n> a4 = a2.a("2000021");
                    List<n> a5 = a2.a("2000039");
                    List<n> a6 = a2.a("2000043");
                    List<n> a7 = a2.a("2000045");
                    List<n> a8 = a2.a("2000044");
                    String a9 = n.a(a4);
                    String b2 = n.b(a3);
                    String f = n.f(a5);
                    String c = n.c(a6);
                    String d = n.d(a7);
                    String e = n.e(a8);
                    StringBuilder sb = new StringBuilder();
                    if (!TextUtils.isEmpty(a9)) {
                        sb.append(a9);
                    }
                    if (!TextUtils.isEmpty(b2)) {
                        sb.append(b2);
                    }
                    if (!TextUtils.isEmpty(f)) {
                        sb.append(f);
                    }
                    if (!TextUtils.isEmpty(c)) {
                        sb.append(c);
                    }
                    if (!TextUtils.isEmpty(d)) {
                        sb.append(d);
                    }
                    if (!TextUtils.isEmpty(e)) {
                        sb.append(e);
                    }
                    if (!TextUtils.isEmpty(sb.toString())) {
                        String sb2 = sb.toString();
                        if (context != null && !TextUtils.isEmpty(sb2) && !TextUtils.isEmpty(str)) {
                            try {
                                com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(context);
                                d a10 = com.mbridge.msdk.foundation.same.report.q.a(sb2, context, str);
                                a10.a("r_stid", b.a().b().b());
                                aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.a().a, a10, new com.mbridge.msdk.foundation.same.report.d.b() {
                                    public final void onSuccess(String str) {
                                        aa.d(a.a, str);
                                    }

                                    public final void onFailed(String str) {
                                        aa.d(a.a, str);
                                    }
                                });
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                aa.d(a, e2.getMessage());
                            }
                        }
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private static void a(final Context context, final String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(context);
                d a2 = com.mbridge.msdk.foundation.same.report.q.a(str, context, str2);
                a2.a("r_stid", b.a().b().b());
                aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.a().a, a2, new com.mbridge.msdk.foundation.same.report.d.b() {
                    public final void onSuccess(String str) {
                        aa.d(a.a, str);
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
                                com.mbridge.msdk.foundation.db.n.a((g) h.a(context)).a(lVar);
                                aa.d(a.a, str);
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

    private static void b(final Context context, final String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(context);
                d a2 = com.mbridge.msdk.foundation.same.report.q.a(str, context);
                a2.a("r_stid", b.a().b().b());
                aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.a().a, a2, new com.mbridge.msdk.foundation.same.report.d.b() {
                    public final void onSuccess(String str) {
                        aa.d(a.a, str);
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
                                com.mbridge.msdk.foundation.db.n.a((g) h.a(context)).a(lVar);
                                aa.d(a.a, str);
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

    public static void a(Context context, List<CampaignEx> list, String str, long j) {
        int a2;
        aa.a("test_load_time", "time: " + j);
        if (context != null && list != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (list.size() > 0) {
                        String requestId = list.get(0).getRequestId();
                        if (TextUtils.isEmpty(b) || !requestId.equals(b)) {
                            b = requestId;
                        } else {
                            return;
                        }
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=").append("2000048").append("&");
                    stringBuffer.append("st=" + System.currentTimeMillis() + "&");
                    stringBuffer.append("network_type=").append(w.r(context)).append("&");
                    stringBuffer.append("unit_id=").append(str).append("&");
                    stringBuffer.append("load_time=").append(j).append("&");
                    if (list != null && list.size() > 0) {
                        stringBuffer.append("cid=");
                        StringBuilder sb = new StringBuilder("rtins_type=");
                        for (int i = 0; i < list.size(); i++) {
                            CampaignEx campaignEx = list.get(i);
                            if (i < list.size() - 1) {
                                stringBuffer.append(campaignEx.getId()).append(",");
                                sb.append(campaignEx.getRtinsType());
                                sb.append(",");
                            } else {
                                stringBuffer.append(campaignEx.getId()).append("&");
                                sb.append(campaignEx.getRtinsType());
                                sb.append("&");
                                if (campaignEx.isBidCampaign()) {
                                    stringBuffer.append("hb=1&");
                                } else {
                                    stringBuffer.append("hb=0&");
                                }
                            }
                        }
                        stringBuffer.append(sb);
                        CampaignEx campaignEx2 = list.get(0);
                        if (campaignEx2 != null) {
                            stringBuffer.append("rid=").append(campaignEx2.getRequestId()).append("&");
                            if (!(campaignEx2.getRewardTemplateMode() == null || (a2 = c.a(campaignEx2, campaignEx2.getRewardTemplateMode().e())) == -1)) {
                                stringBuffer.append("dyview=").append(a2).append("&");
                            }
                        }
                        String str2 = "";
                        String str3 = str2;
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            str2 = str2 + list.get(i2).getRequestIdNotice();
                            str3 = str3 + list.get(i2).getAdSpaceT();
                            if (i2 < list.size() - 1) {
                                str2 = str2 + ",";
                                str3 = str3 + ",";
                            }
                        }
                        stringBuffer.append("rid_n=").append(str2).append("&");
                        stringBuffer.append("adspace_t=").append(str3);
                        if (k.a().c()) {
                            k.a().a(stringBuffer.toString());
                        } else {
                            a(context, stringBuffer.toString(), str);
                        }
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(25:16|17|18|19|20|21|24|25|(1:27)|28|(3:30|(1:32)(1:33)|34)|35|(1:37)|38|(1:40)|(1:42)(1:43)|44|(1:46)(1:47)|48|(1:50)|51|(1:57)|(1:59)|60|(2:62|70)(2:63|71)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x007d */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0095 A[Catch:{ all -> 0x01e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ef A[Catch:{ all -> 0x01e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0116 A[Catch:{ all -> 0x01e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0132 A[Catch:{ all -> 0x01e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x014a A[Catch:{ all -> 0x01e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0150 A[Catch:{ all -> 0x01e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x015b A[Catch:{ all -> 0x01e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x016b A[Catch:{ all -> 0x01e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0173 A[Catch:{ all -> 0x01e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01b5 A[Catch:{ all -> 0x01e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01cc A[Catch:{ all -> 0x01e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01d8 A[Catch:{ all -> 0x01e0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.mbridge.msdk.foundation.entity.CampaignEx r19, android.content.Context r20, com.mbridge.msdk.foundation.entity.e r21, java.lang.String r22, boolean r23, java.lang.String r24, java.lang.String r25) {
        /*
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            java.lang.String r4 = "&"
            java.lang.String r5 = "reason="
            java.lang.String r6 = "c="
            java.lang.String r7 = "u_stid="
            java.lang.String r8 = "b="
            java.lang.String r9 = "adtp="
            java.lang.String r10 = "unit_id="
            java.lang.String r11 = "cid="
            java.lang.String r12 = "network_type="
            java.lang.String r13 = "st="
            java.lang.String r14 = "network_available="
            com.mbridge.msdk.foundation.tools.ac r15 = com.mbridge.msdk.foundation.tools.ac.a()     // Catch:{ all -> 0x01e0 }
            r16 = r5
            java.lang.String r5 = "r_l_b_m_t_r_i"
            r17 = r6
            r6 = 1
            boolean r5 = r15.a((java.lang.String) r5, (boolean) r6)     // Catch:{ all -> 0x01e0 }
            if (r5 == 0) goto L_0x003a
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ all -> 0x01e0 }
            r0.a((java.lang.String) r3, (com.mbridge.msdk.foundation.entity.e) r2)     // Catch:{ all -> 0x01e0 }
            return
        L_0x003a:
            java.lang.String r5 = ""
            if (r2 == 0) goto L_0x0043
            java.lang.String r2 = r21.e()     // Catch:{ all -> 0x01e0 }
            goto L_0x0044
        L_0x0043:
            r2 = r5
        L_0x0044:
            if (r1 == 0) goto L_0x01e4
            boolean r6 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x01e0 }
            if (r6 != 0) goto L_0x01e4
            boolean r6 = android.text.TextUtils.isEmpty(r22)     // Catch:{ all -> 0x01e0 }
            if (r6 != 0) goto L_0x01e4
            java.lang.StringBuffer r6 = new java.lang.StringBuffer     // Catch:{ all -> 0x01e0 }
            r6.<init>()     // Catch:{ all -> 0x01e0 }
            java.lang.String r15 = "key=2000047&"
            java.lang.StringBuffer r6 = r6.append(r15)     // Catch:{ all -> 0x01e0 }
            boolean r15 = com.mbridge.msdk.foundation.tools.af.d((android.content.Context) r20)     // Catch:{ Exception -> 0x007b }
            r18 = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007d }
            r5.<init>(r14)     // Catch:{ Exception -> 0x007d }
            java.lang.String r14 = java.lang.String.valueOf(r15)     // Catch:{ Exception -> 0x007d }
            r5.append(r14)     // Catch:{ Exception -> 0x007d }
            r5.append(r4)     // Catch:{ Exception -> 0x007d }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x007d }
            java.lang.StringBuffer r6 = r6.append(r5)     // Catch:{ Exception -> 0x007d }
            goto L_0x007d
        L_0x007b:
            r18 = r5
        L_0x007d:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e0 }
            r5.<init>(r13)     // Catch:{ all -> 0x01e0 }
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01e0 }
            r5.append(r13)     // Catch:{ all -> 0x01e0 }
            r5.append(r4)     // Catch:{ all -> 0x01e0 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01e0 }
            r6.append(r5)     // Catch:{ all -> 0x01e0 }
            if (r0 == 0) goto L_0x00c1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e0 }
            r5.<init>(r11)     // Catch:{ all -> 0x01e0 }
            java.lang.String r11 = r19.getId()     // Catch:{ all -> 0x01e0 }
            r5.append(r11)     // Catch:{ all -> 0x01e0 }
            r5.append(r4)     // Catch:{ all -> 0x01e0 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01e0 }
            r6.append(r5)     // Catch:{ all -> 0x01e0 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e0 }
            r5.<init>(r9)     // Catch:{ all -> 0x01e0 }
            int r9 = r19.getAdType()     // Catch:{ all -> 0x01e0 }
            r5.append(r9)     // Catch:{ all -> 0x01e0 }
            r5.append(r4)     // Catch:{ all -> 0x01e0 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01e0 }
            r6.append(r5)     // Catch:{ all -> 0x01e0 }
        L_0x00c1:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e0 }
            r5.<init>(r12)     // Catch:{ all -> 0x01e0 }
            int r9 = com.mbridge.msdk.foundation.tools.w.r(r20)     // Catch:{ all -> 0x01e0 }
            r5.append(r9)     // Catch:{ all -> 0x01e0 }
            r5.append(r4)     // Catch:{ all -> 0x01e0 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01e0 }
            r6.append(r5)     // Catch:{ all -> 0x01e0 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e0 }
            r5.<init>(r10)     // Catch:{ all -> 0x01e0 }
            r5.append(r3)     // Catch:{ all -> 0x01e0 }
            r5.append(r4)     // Catch:{ all -> 0x01e0 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01e0 }
            r6.append(r5)     // Catch:{ all -> 0x01e0 }
            boolean r5 = android.text.TextUtils.isEmpty(r22)     // Catch:{ all -> 0x01e0 }
            if (r5 != 0) goto L_0x010e
            java.util.HashMap<java.lang.String, java.lang.String> r5 = com.mbridge.msdk.foundation.controller.b.c     // Catch:{ all -> 0x01e0 }
            java.lang.Object r3 = r5.get(r3)     // Catch:{ all -> 0x01e0 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x01e0 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e0 }
            r5.<init>(r7)     // Catch:{ all -> 0x01e0 }
            if (r3 == 0) goto L_0x00ff
            goto L_0x0101
        L_0x00ff:
            r3 = r18
        L_0x0101:
            r5.append(r3)     // Catch:{ all -> 0x01e0 }
            r5.append(r4)     // Catch:{ all -> 0x01e0 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x01e0 }
            r6.append(r3)     // Catch:{ all -> 0x01e0 }
        L_0x010e:
            java.lang.String r3 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ all -> 0x01e0 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x01e0 }
            if (r3 != 0) goto L_0x012a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e0 }
            r3.<init>(r8)     // Catch:{ all -> 0x01e0 }
            java.lang.String r5 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ all -> 0x01e0 }
            r3.append(r5)     // Catch:{ all -> 0x01e0 }
            r3.append(r4)     // Catch:{ all -> 0x01e0 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01e0 }
            r6.append(r3)     // Catch:{ all -> 0x01e0 }
        L_0x012a:
            java.lang.String r3 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ all -> 0x01e0 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x01e0 }
            if (r3 != 0) goto L_0x0148
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e0 }
            r5 = r17
            r3.<init>(r5)     // Catch:{ all -> 0x01e0 }
            java.lang.String r5 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ all -> 0x01e0 }
            r3.append(r5)     // Catch:{ all -> 0x01e0 }
            r3.append(r4)     // Catch:{ all -> 0x01e0 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01e0 }
            r6.append(r3)     // Catch:{ all -> 0x01e0 }
        L_0x0148:
            if (r23 == 0) goto L_0x0150
            java.lang.String r3 = "hb=1&"
            r6.append(r3)     // Catch:{ all -> 0x01e0 }
            goto L_0x0155
        L_0x0150:
            java.lang.String r3 = "hb=0&"
            r6.append(r3)     // Catch:{ all -> 0x01e0 }
        L_0x0155:
            boolean r3 = android.text.TextUtils.isEmpty(r24)     // Catch:{ all -> 0x01e0 }
            if (r3 != 0) goto L_0x016b
            java.lang.String r3 = "rid="
            java.lang.StringBuffer r3 = r6.append(r3)     // Catch:{ all -> 0x01e0 }
            r5 = r24
            java.lang.StringBuffer r3 = r3.append(r5)     // Catch:{ all -> 0x01e0 }
            r3.append(r4)     // Catch:{ all -> 0x01e0 }
            goto L_0x016d
        L_0x016b:
            r5 = r24
        L_0x016d:
            boolean r3 = android.text.TextUtils.isEmpty(r24)     // Catch:{ all -> 0x01e0 }
            if (r3 != 0) goto L_0x0182
            java.lang.String r3 = "rid_n="
            java.lang.StringBuffer r3 = r6.append(r3)     // Catch:{ all -> 0x01e0 }
            r5 = r25
            java.lang.StringBuffer r3 = r3.append(r5)     // Catch:{ all -> 0x01e0 }
            r3.append(r4)     // Catch:{ all -> 0x01e0 }
        L_0x0182:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e0 }
            r4 = r16
            r3.<init>(r4)     // Catch:{ all -> 0x01e0 }
            r3.append(r2)     // Catch:{ all -> 0x01e0 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x01e0 }
            r6.append(r2)     // Catch:{ all -> 0x01e0 }
            if (r0 == 0) goto L_0x01b3
            com.mbridge.msdk.foundation.entity.CampaignEx$c r2 = r19.getRewardTemplateMode()     // Catch:{ all -> 0x01e0 }
            if (r2 == 0) goto L_0x01b3
            com.mbridge.msdk.foundation.entity.CampaignEx$c r2 = r19.getRewardTemplateMode()     // Catch:{ all -> 0x01e0 }
            java.lang.String r2 = r2.e()     // Catch:{ all -> 0x01e0 }
            int r2 = com.mbridge.msdk.foundation.same.c.a(r0, r2)     // Catch:{ all -> 0x01e0 }
            r3 = -1
            if (r2 == r3) goto L_0x01b3
            java.lang.String r3 = "&dyview="
            java.lang.StringBuffer r3 = r6.append(r3)     // Catch:{ all -> 0x01e0 }
            r3.append(r2)     // Catch:{ all -> 0x01e0 }
        L_0x01b3:
            if (r0 == 0) goto L_0x01c2
            java.lang.String r2 = "&adspace_t="
            java.lang.StringBuffer r2 = r6.append(r2)     // Catch:{ all -> 0x01e0 }
            int r0 = r19.getAdSpaceT()     // Catch:{ all -> 0x01e0 }
            r2.append(r0)     // Catch:{ all -> 0x01e0 }
        L_0x01c2:
            com.mbridge.msdk.foundation.same.report.k r0 = com.mbridge.msdk.foundation.same.report.k.a()     // Catch:{ all -> 0x01e0 }
            boolean r0 = r0.c()     // Catch:{ all -> 0x01e0 }
            if (r0 == 0) goto L_0x01d8
            com.mbridge.msdk.foundation.same.report.k r0 = com.mbridge.msdk.foundation.same.report.k.a()     // Catch:{ all -> 0x01e0 }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x01e0 }
            r0.a((java.lang.String) r1)     // Catch:{ all -> 0x01e0 }
            goto L_0x01e4
        L_0x01d8:
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x01e0 }
            b(r1, r0)     // Catch:{ all -> 0x01e0 }
            goto L_0x01e4
        L_0x01e0:
            r0 = move-exception
            r0.printStackTrace()
        L_0x01e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.c.a.a(com.mbridge.msdk.foundation.entity.CampaignEx, android.content.Context, com.mbridge.msdk.foundation.entity.e, java.lang.String, boolean, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:6|(1:8)|9|(1:11)|12|(1:14)(1:15)|(1:17)|(3:21|22|(1:24))|25|26|(2:28|36)(2:29|37)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x010a */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0114 A[Catch:{ all -> 0x0128 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0120 A[Catch:{ all -> 0x0128 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r12, com.mbridge.msdk.foundation.entity.CampaignEx r13, java.lang.String r14) {
        /*
            java.lang.String r0 = "&"
            java.lang.String r1 = "adspace_t="
            java.lang.String r2 = "rid_n="
            java.lang.String r3 = "rid="
            java.lang.String r4 = "unit_id="
            java.lang.String r5 = "cid="
            java.lang.String r6 = "network_type="
            java.lang.String r7 = "st="
            if (r12 == 0) goto L_0x012c
            if (r13 == 0) goto L_0x012c
            boolean r8 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x0128 }
            if (r8 != 0) goto L_0x012c
            java.lang.StringBuffer r8 = new java.lang.StringBuffer     // Catch:{ all -> 0x0128 }
            r8.<init>()     // Catch:{ all -> 0x0128 }
            java.lang.String r9 = "key=2000048&"
            java.lang.StringBuffer r8 = r8.append(r9)     // Catch:{ all -> 0x0128 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0128 }
            r9.<init>(r7)     // Catch:{ all -> 0x0128 }
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0128 }
            r9.append(r10)     // Catch:{ all -> 0x0128 }
            r9.append(r0)     // Catch:{ all -> 0x0128 }
            java.lang.String r7 = r9.toString()     // Catch:{ all -> 0x0128 }
            r8.append(r7)     // Catch:{ all -> 0x0128 }
            if (r13 == 0) goto L_0x0056
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0128 }
            r7.<init>(r5)     // Catch:{ all -> 0x0128 }
            java.lang.String r5 = r13.getId()     // Catch:{ all -> 0x0128 }
            r7.append(r5)     // Catch:{ all -> 0x0128 }
            r7.append(r0)     // Catch:{ all -> 0x0128 }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x0128 }
            java.lang.StringBuffer r8 = r8.append(r5)     // Catch:{ all -> 0x0128 }
        L_0x0056:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0128 }
            r5.<init>(r6)     // Catch:{ all -> 0x0128 }
            int r6 = com.mbridge.msdk.foundation.tools.w.r(r12)     // Catch:{ all -> 0x0128 }
            r5.append(r6)     // Catch:{ all -> 0x0128 }
            r5.append(r0)     // Catch:{ all -> 0x0128 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0128 }
            r8.append(r5)     // Catch:{ all -> 0x0128 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0128 }
            r5.<init>(r4)     // Catch:{ all -> 0x0128 }
            r5.append(r14)     // Catch:{ all -> 0x0128 }
            r5.append(r0)     // Catch:{ all -> 0x0128 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0128 }
            r8.append(r4)     // Catch:{ all -> 0x0128 }
            boolean r4 = com.mbridge.msdk.foundation.tools.af.b((com.mbridge.msdk.foundation.entity.CampaignEx) r13)     // Catch:{ all -> 0x0128 }
            if (r4 == 0) goto L_0x0095
            java.lang.String r4 = "rtins_type="
            java.lang.StringBuffer r4 = r8.append(r4)     // Catch:{ all -> 0x0128 }
            int r5 = r13.getRtinsType()     // Catch:{ all -> 0x0128 }
            java.lang.StringBuffer r4 = r4.append(r5)     // Catch:{ all -> 0x0128 }
            r4.append(r0)     // Catch:{ all -> 0x0128 }
        L_0x0095:
            boolean r4 = r13.isBidCampaign()     // Catch:{ all -> 0x0128 }
            if (r4 == 0) goto L_0x00a1
            java.lang.String r4 = "hb=1&"
            r8.append(r4)     // Catch:{ all -> 0x0128 }
            goto L_0x00a6
        L_0x00a1:
            java.lang.String r4 = "hb=0&"
            r8.append(r4)     // Catch:{ all -> 0x0128 }
        L_0x00a6:
            if (r13 == 0) goto L_0x00ea
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0128 }
            r4.<init>(r3)     // Catch:{ all -> 0x0128 }
            java.lang.String r3 = r13.getRequestId()     // Catch:{ all -> 0x0128 }
            r4.append(r3)     // Catch:{ all -> 0x0128 }
            r4.append(r0)     // Catch:{ all -> 0x0128 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0128 }
            java.lang.StringBuffer r3 = r8.append(r3)     // Catch:{ all -> 0x0128 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0128 }
            r4.<init>(r2)     // Catch:{ all -> 0x0128 }
            java.lang.String r2 = r13.getRequestIdNotice()     // Catch:{ all -> 0x0128 }
            r4.append(r2)     // Catch:{ all -> 0x0128 }
            r4.append(r0)     // Catch:{ all -> 0x0128 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0128 }
            java.lang.StringBuffer r0 = r3.append(r0)     // Catch:{ all -> 0x0128 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0128 }
            r2.<init>(r1)     // Catch:{ all -> 0x0128 }
            int r1 = r13.getAdSpaceT()     // Catch:{ all -> 0x0128 }
            r2.append(r1)     // Catch:{ all -> 0x0128 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0128 }
            java.lang.StringBuffer r8 = r0.append(r1)     // Catch:{ all -> 0x0128 }
        L_0x00ea:
            if (r13 == 0) goto L_0x010a
            com.mbridge.msdk.foundation.entity.CampaignEx$c r0 = r13.getRewardTemplateMode()     // Catch:{ all -> 0x0128 }
            if (r0 == 0) goto L_0x010a
            com.mbridge.msdk.foundation.entity.CampaignEx$c r0 = r13.getRewardTemplateMode()     // Catch:{ Exception -> 0x010a }
            java.lang.String r0 = r0.e()     // Catch:{ Exception -> 0x010a }
            int r13 = com.mbridge.msdk.foundation.same.c.a(r13, r0)     // Catch:{ Exception -> 0x010a }
            r0 = -1
            if (r13 == r0) goto L_0x010a
            java.lang.String r0 = "&dyview="
            java.lang.StringBuffer r0 = r8.append(r0)     // Catch:{ Exception -> 0x010a }
            r0.append(r13)     // Catch:{ Exception -> 0x010a }
        L_0x010a:
            com.mbridge.msdk.foundation.same.report.k r13 = com.mbridge.msdk.foundation.same.report.k.a()     // Catch:{ all -> 0x0128 }
            boolean r13 = r13.c()     // Catch:{ all -> 0x0128 }
            if (r13 == 0) goto L_0x0120
            com.mbridge.msdk.foundation.same.report.k r12 = com.mbridge.msdk.foundation.same.report.k.a()     // Catch:{ all -> 0x0128 }
            java.lang.String r13 = r8.toString()     // Catch:{ all -> 0x0128 }
            r12.a((java.lang.String) r13)     // Catch:{ all -> 0x0128 }
            goto L_0x012c
        L_0x0120:
            java.lang.String r13 = r8.toString()     // Catch:{ all -> 0x0128 }
            a((android.content.Context) r12, (java.lang.String) r13, (java.lang.String) r14)     // Catch:{ all -> 0x0128 }
            goto L_0x012c
        L_0x0128:
            r12 = move-exception
            r12.printStackTrace()
        L_0x012c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.c.a.a(android.content.Context, com.mbridge.msdk.foundation.entity.CampaignEx, java.lang.String):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(20:17|(1:19)|20|(3:22|(1:24)(1:25)|26)|27|(1:29)|30|(1:32)|(1:34)(1:35)|36|37|(2:39|40)(1:(1:44))|45|46|(2:48|49)(1:(1:53))|54|(3:58|59|(1:61))|62|63|(2:65|73)(2:66|74)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x01d7 */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01e1 A[Catch:{ all -> 0x01f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01ed A[Catch:{ all -> 0x01f5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.mbridge.msdk.foundation.entity.CampaignEx r17, android.content.Context r18, java.lang.String r19, java.lang.String r20, boolean r21, java.lang.String r22, java.lang.String r23, long r24) {
        /*
            r0 = r17
            r3 = r18
            r5 = r20
            java.lang.String r1 = "&"
            java.lang.String r2 = "&reason="
            java.lang.String r4 = "adtp="
            java.lang.String r6 = "c="
            java.lang.String r7 = "u_stid="
            java.lang.String r8 = "b="
            java.lang.String r9 = "cid="
            java.lang.String r10 = "unit_id="
            java.lang.String r11 = "network_type="
            java.lang.String r12 = "key=2000078&"
            com.mbridge.msdk.foundation.tools.ac r13 = com.mbridge.msdk.foundation.tools.ac.a()
            java.lang.String r14 = "e_t_l"
            r15 = 0
            int r13 = r13.a((java.lang.String) r14, (int) r15)
            com.mbridge.msdk.foundation.tools.ac r15 = com.mbridge.msdk.foundation.tools.ac.a()
            r16 = r2
            java.lang.String r2 = "metrics"
            int r2 = r15.a(r2, r14, r13)
            r13 = 1
            if (r2 != r13) goto L_0x0038
            r15 = 1
            goto L_0x0039
        L_0x0038:
            r15 = 0
        L_0x0039:
            if (r15 == 0) goto L_0x0064
            com.mbridge.msdk.videocommon.d.b r1 = com.mbridge.msdk.videocommon.d.b.a()
            com.mbridge.msdk.videocommon.d.a r1 = r1.b()
            if (r1 == 0) goto L_0x004a
            java.lang.String r1 = r1.b()
            goto L_0x004b
        L_0x004a:
            r1 = 0
        L_0x004b:
            r11 = r1
            com.mbridge.msdk.foundation.same.report.m r1 = com.mbridge.msdk.foundation.same.report.m.a()
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r21
            r7 = r22
            r8 = r23
            r9 = r24
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9, r11)
            return
        L_0x0064:
            if (r3 == 0) goto L_0x01f9
            boolean r2 = android.text.TextUtils.isEmpty(r19)     // Catch:{ all -> 0x01f5 }
            if (r2 != 0) goto L_0x01f9
            boolean r2 = android.text.TextUtils.isEmpty(r20)     // Catch:{ all -> 0x01f5 }
            if (r2 != 0) goto L_0x01f9
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch:{ all -> 0x01f5 }
            r2.<init>(r12)     // Catch:{ all -> 0x01f5 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f5 }
            r12.<init>(r11)     // Catch:{ all -> 0x01f5 }
            int r11 = com.mbridge.msdk.foundation.tools.w.r(r18)     // Catch:{ all -> 0x01f5 }
            r12.append(r11)     // Catch:{ all -> 0x01f5 }
            r12.append(r1)     // Catch:{ all -> 0x01f5 }
            java.lang.String r11 = r12.toString()     // Catch:{ all -> 0x01f5 }
            r2.append(r11)     // Catch:{ all -> 0x01f5 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f5 }
            r11.<init>(r10)     // Catch:{ all -> 0x01f5 }
            r11.append(r5)     // Catch:{ all -> 0x01f5 }
            r11.append(r1)     // Catch:{ all -> 0x01f5 }
            java.lang.String r10 = r11.toString()     // Catch:{ all -> 0x01f5 }
            r2.append(r10)     // Catch:{ all -> 0x01f5 }
            if (r0 == 0) goto L_0x00cd
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f5 }
            r10.<init>(r9)     // Catch:{ all -> 0x01f5 }
            java.lang.String r9 = r17.getId()     // Catch:{ all -> 0x01f5 }
            r10.append(r9)     // Catch:{ all -> 0x01f5 }
            r10.append(r1)     // Catch:{ all -> 0x01f5 }
            java.lang.String r9 = r10.toString()     // Catch:{ all -> 0x01f5 }
            r2.append(r9)     // Catch:{ all -> 0x01f5 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f5 }
            r9.<init>(r4)     // Catch:{ all -> 0x01f5 }
            int r4 = r17.getAdType()     // Catch:{ all -> 0x01f5 }
            r9.append(r4)     // Catch:{ all -> 0x01f5 }
            r9.append(r1)     // Catch:{ all -> 0x01f5 }
            java.lang.String r4 = r9.toString()     // Catch:{ all -> 0x01f5 }
            r2.append(r4)     // Catch:{ all -> 0x01f5 }
        L_0x00cd:
            boolean r4 = android.text.TextUtils.isEmpty(r20)     // Catch:{ all -> 0x01f5 }
            if (r4 != 0) goto L_0x00f2
            java.util.HashMap<java.lang.String, java.lang.String> r4 = com.mbridge.msdk.foundation.controller.b.c     // Catch:{ all -> 0x01f5 }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x01f5 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x01f5 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f5 }
            r5.<init>(r7)     // Catch:{ all -> 0x01f5 }
            if (r4 == 0) goto L_0x00e3
            goto L_0x00e5
        L_0x00e3:
            java.lang.String r4 = ""
        L_0x00e5:
            r5.append(r4)     // Catch:{ all -> 0x01f5 }
            r5.append(r1)     // Catch:{ all -> 0x01f5 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x01f5 }
            r2.append(r4)     // Catch:{ all -> 0x01f5 }
        L_0x00f2:
            java.lang.String r4 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ all -> 0x01f5 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x01f5 }
            if (r4 != 0) goto L_0x010e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f5 }
            r4.<init>(r8)     // Catch:{ all -> 0x01f5 }
            java.lang.String r5 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ all -> 0x01f5 }
            r4.append(r5)     // Catch:{ all -> 0x01f5 }
            r4.append(r1)     // Catch:{ all -> 0x01f5 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01f5 }
            r2.append(r4)     // Catch:{ all -> 0x01f5 }
        L_0x010e:
            java.lang.String r4 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ all -> 0x01f5 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x01f5 }
            if (r4 != 0) goto L_0x012a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f5 }
            r4.<init>(r6)     // Catch:{ all -> 0x01f5 }
            java.lang.String r5 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ all -> 0x01f5 }
            r4.append(r5)     // Catch:{ all -> 0x01f5 }
            r4.append(r1)     // Catch:{ all -> 0x01f5 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01f5 }
            r2.append(r4)     // Catch:{ all -> 0x01f5 }
        L_0x012a:
            if (r21 == 0) goto L_0x0132
            java.lang.String r4 = "hb=1&"
            r2.append(r4)     // Catch:{ all -> 0x01f5 }
            goto L_0x0137
        L_0x0132:
            java.lang.String r4 = "hb=0&"
            r2.append(r4)     // Catch:{ all -> 0x01f5 }
        L_0x0137:
            boolean r4 = android.text.TextUtils.isEmpty(r22)     // Catch:{ all -> 0x01f5 }
            java.lang.String r5 = "rid="
            if (r4 != 0) goto L_0x014d
            java.lang.StringBuffer r4 = r2.append(r5)     // Catch:{ all -> 0x01f5 }
            r5 = r22
            java.lang.StringBuffer r4 = r4.append(r5)     // Catch:{ all -> 0x01f5 }
            r4.append(r1)     // Catch:{ all -> 0x01f5 }
            goto L_0x0168
        L_0x014d:
            if (r0 == 0) goto L_0x0168
            java.lang.String r4 = r17.getRequestId()     // Catch:{ all -> 0x01f5 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x01f5 }
            if (r4 != 0) goto L_0x0168
            java.lang.StringBuffer r4 = r2.append(r5)     // Catch:{ all -> 0x01f5 }
            java.lang.String r5 = r17.getRequestId()     // Catch:{ all -> 0x01f5 }
            java.lang.StringBuffer r4 = r4.append(r5)     // Catch:{ all -> 0x01f5 }
            r4.append(r1)     // Catch:{ all -> 0x01f5 }
        L_0x0168:
            boolean r4 = android.text.TextUtils.isEmpty(r23)     // Catch:{ all -> 0x01f5 }
            java.lang.String r5 = "rid_n="
            if (r4 != 0) goto L_0x017e
            java.lang.StringBuffer r4 = r2.append(r5)     // Catch:{ all -> 0x01f5 }
            r5 = r23
            java.lang.StringBuffer r4 = r4.append(r5)     // Catch:{ all -> 0x01f5 }
            r4.append(r1)     // Catch:{ all -> 0x01f5 }
            goto L_0x0199
        L_0x017e:
            if (r0 == 0) goto L_0x0199
            java.lang.String r4 = r17.getRequestIdNotice()     // Catch:{ all -> 0x01f5 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x01f5 }
            if (r4 != 0) goto L_0x0199
            java.lang.StringBuffer r4 = r2.append(r5)     // Catch:{ all -> 0x01f5 }
            java.lang.String r5 = r17.getRequestIdNotice()     // Catch:{ all -> 0x01f5 }
            java.lang.StringBuffer r4 = r4.append(r5)     // Catch:{ all -> 0x01f5 }
            r4.append(r1)     // Catch:{ all -> 0x01f5 }
        L_0x0199:
            java.lang.String r1 = "during="
            java.lang.StringBuffer r1 = r2.append(r1)     // Catch:{ all -> 0x01f5 }
            r4 = r24
            r1.append(r4)     // Catch:{ all -> 0x01f5 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f5 }
            r4 = r16
            r1.<init>(r4)     // Catch:{ all -> 0x01f5 }
            r4 = r19
            r1.append(r4)     // Catch:{ all -> 0x01f5 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01f5 }
            r2.append(r1)     // Catch:{ all -> 0x01f5 }
            if (r0 == 0) goto L_0x01d7
            com.mbridge.msdk.foundation.entity.CampaignEx$c r1 = r17.getRewardTemplateMode()     // Catch:{ all -> 0x01f5 }
            if (r1 == 0) goto L_0x01d7
            com.mbridge.msdk.foundation.entity.CampaignEx$c r1 = r17.getRewardTemplateMode()     // Catch:{ Exception -> 0x01d7 }
            java.lang.String r1 = r1.e()     // Catch:{ Exception -> 0x01d7 }
            int r0 = com.mbridge.msdk.foundation.same.c.a(r0, r1)     // Catch:{ Exception -> 0x01d7 }
            r1 = -1
            if (r0 == r1) goto L_0x01d7
            java.lang.String r1 = "&dyview="
            java.lang.StringBuffer r1 = r2.append(r1)     // Catch:{ Exception -> 0x01d7 }
            r1.append(r0)     // Catch:{ Exception -> 0x01d7 }
        L_0x01d7:
            com.mbridge.msdk.foundation.same.report.k r0 = com.mbridge.msdk.foundation.same.report.k.a()     // Catch:{ all -> 0x01f5 }
            boolean r0 = r0.c()     // Catch:{ all -> 0x01f5 }
            if (r0 == 0) goto L_0x01ed
            com.mbridge.msdk.foundation.same.report.k r0 = com.mbridge.msdk.foundation.same.report.k.a()     // Catch:{ all -> 0x01f5 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x01f5 }
            r0.a((java.lang.String) r1)     // Catch:{ all -> 0x01f5 }
            goto L_0x01f9
        L_0x01ed:
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x01f5 }
            b(r3, r0)     // Catch:{ all -> 0x01f5 }
            goto L_0x01f9
        L_0x01f5:
            r0 = move-exception
            r0.printStackTrace()
        L_0x01f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.c.a.a(com.mbridge.msdk.foundation.entity.CampaignEx, android.content.Context, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, long):void");
    }

    public static void a(String str, String str2, String str3, String str4, int i, boolean z) {
        if (TextUtils.isEmpty(str3)) {
            str3 = SameMD5.getMD5(af.c());
        }
        String str5 = str3;
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("auto_load", "2");
        } else {
            hashMap.put("auto_load", "1");
        }
        m a2 = m.a();
        a2.a(str, str5, str4, str2, i + "", (Map<String, String>) hashMap);
    }
}
