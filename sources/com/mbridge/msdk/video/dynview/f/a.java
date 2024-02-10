package com.mbridge.msdk.video.dynview.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.click.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.d.b;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.out.Campaign;

/* compiled from: MOfferReport */
public class a {
    /* access modifiers changed from: private */
    public static final String a = "com.mbridge.msdk.video.dynview.f.a";

    public static void a(CampaignEx campaignEx, Context context, String str, String str2, String str3) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    StringBuffer stringBuffer = new StringBuffer("key=2000091&");
                    stringBuffer.append("network_type=" + w.r(context) + "&");
                    stringBuffer.append("unit_id=" + str2 + "&");
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l)) {
                        stringBuffer.append("b=" + com.mbridge.msdk.foundation.same.a.l + "&");
                    }
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.m)) {
                        stringBuffer.append("c=" + com.mbridge.msdk.foundation.same.a.m + "&");
                    }
                    stringBuffer.append("hb=0&");
                    if (!TextUtils.isEmpty(str3)) {
                        stringBuffer.append("rid_n=").append(str3).append("&");
                    }
                    stringBuffer.append("reason=" + str);
                    if (!(campaignEx == null || campaignEx.getRewardTemplateMode() == null)) {
                        stringBuffer.append("&dyview=").append(af.l(campaignEx.getRewardTemplateMode().e()));
                    }
                    if (k.a().c()) {
                        k.a().a(stringBuffer.toString());
                        return;
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    if (context != null && !TextUtils.isEmpty(stringBuffer2)) {
                        new com.mbridge.msdk.foundation.same.report.d.a(context).post(0, d.a().a, q.a(stringBuffer2, context), new b() {
                            public final void onSuccess(String str) {
                                aa.d(a.a, str);
                            }

                            public final void onFailed(String str) {
                                aa.d(a.a, str);
                            }
                        });
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                aa.d(a, e.getMessage());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.mbridge.msdk.foundation.entity.CampaignUnit r9, int r10, int r11, java.lang.String r12) {
        /*
            if (r9 == 0) goto L_0x00b0
            java.util.ArrayList r0 = r9.getAds()
            if (r0 == 0) goto L_0x00b0
            java.util.ArrayList r0 = r9.getAds()
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x00b0
            java.util.ArrayList r0 = r9.getAds()
            java.lang.Object r0 = r0.get(r10)
            if (r0 == 0) goto L_0x00b0
            if (r11 != 0) goto L_0x002d
            java.util.ArrayList r0 = r9.getAds()
            java.lang.Object r0 = r0.get(r10)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            boolean r0 = r0.mMoreOfferImpShow
            if (r0 == 0) goto L_0x002d
            return
        L_0x002d:
            java.util.ArrayList r0 = r9.getAds()
            java.lang.Object r0 = r0.get(r10)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            java.lang.String r0 = r0.getendcard_url()
            java.lang.String r1 = "mof_testuid"
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.al.a(r0, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x005b
            java.util.ArrayList r0 = r9.getAds()
            java.lang.Object r0 = r0.get(r10)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            java.lang.String r0 = r0.getendcard_url()
            java.lang.String r1 = "mof_uid"
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.al.a(r0, r1)
        L_0x005b:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0063
            r4 = r12
            goto L_0x0064
        L_0x0063:
            r4 = r0
        L_0x0064:
            if (r11 == 0) goto L_0x0080
            r12 = 1
            if (r11 == r12) goto L_0x006f
            java.lang.String r11 = ""
            r12 = 0
            r5 = r11
            r8 = 0
            goto L_0x0092
        L_0x006f:
            int r11 = com.mbridge.msdk.click.a.a.h
            java.util.ArrayList r12 = r9.getAds()
            java.lang.Object r12 = r12.get(r10)
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = (com.mbridge.msdk.foundation.entity.CampaignEx) r12
            java.lang.String r12 = r12.getOnlyImpressionURL()
            goto L_0x0090
        L_0x0080:
            int r11 = com.mbridge.msdk.click.a.a.g
            java.util.ArrayList r12 = r9.getAds()
            java.lang.Object r12 = r12.get(r10)
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = (com.mbridge.msdk.foundation.entity.CampaignEx) r12
            java.lang.String r12 = r12.getImpressionURL()
        L_0x0090:
            r8 = r11
            r5 = r12
        L_0x0092:
            r6 = 0
            r7 = 1
            boolean r11 = android.text.TextUtils.isEmpty(r5)
            if (r11 != 0) goto L_0x00b0
            com.mbridge.msdk.foundation.controller.b r11 = com.mbridge.msdk.foundation.controller.b.d()
            android.content.Context r2 = r11.g()
            java.util.ArrayList r9 = r9.getAds()
            java.lang.Object r9 = r9.get(r10)
            r3 = r9
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = (com.mbridge.msdk.foundation.entity.CampaignEx) r3
            com.mbridge.msdk.click.a.a(r2, r3, r4, r5, r6, r7, r8)
        L_0x00b0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.f.a.a(com.mbridge.msdk.foundation.entity.CampaignUnit, int, int, java.lang.String):void");
    }

    public static void a(Context context, CampaignEx campaignEx, String str, View view) {
        if (context != null && campaignEx != null) {
            if (!(campaignEx == null || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().l() == null)) {
                com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().l(), false, false);
            }
            com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(context, str);
            if (view instanceof ViewGroup) {
                final ViewGroup viewGroup = (ViewGroup) view;
                aVar.a((h) new h() {
                    public final void onStartRedirection(Campaign campaign, String str) {
                        if (campaign != null) {
                            ae.a(campaign, viewGroup);
                        }
                    }

                    public final void onFinishRedirection(Campaign campaign, String str) {
                        if (campaign != null) {
                            ae.b(campaign, viewGroup);
                        }
                    }

                    public final void onRedirectionFailed(Campaign campaign, String str) {
                        if (campaign != null) {
                            ae.b(campaign, viewGroup);
                        }
                    }
                });
            }
            aVar.a(campaignEx);
        }
    }
}
