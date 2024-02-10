package com.mbridge.msdk.video.dynview.j;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.video.dynview.c;
import com.mbridge.msdk.video.dynview.i.a;
import com.mbridge.msdk.videocommon.d.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ViewOptionWrapper */
public final class c {
    private String a(int i) {
        return i != 3 ? i != 302 ? i != 802 ? i != 904 ? "mbridge_reward_layer_floor" : "mbridge_reward_layer_floor_904" : "mbridge_reward_layer_floor_802" : "mbridge_reward_layer_floor_302" : "mbridge_reward_layer_floor_bottom";
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.video.dynview.c a(android.content.Context r13, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r14) {
        /*
            r12 = this;
            java.lang.String r0 = "template_"
            r1 = 0
            if (r14 != 0) goto L_0x0007
            return r1
        L_0x0007:
            com.mbridge.msdk.foundation.controller.b r2 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x00e1 }
            android.content.Context r2 = r2.g()     // Catch:{ Exception -> 0x00e1 }
            int r2 = com.mbridge.msdk.foundation.tools.af.i((android.content.Context) r2)     // Catch:{ Exception -> 0x00e1 }
            float r2 = (float) r2     // Catch:{ Exception -> 0x00e1 }
            com.mbridge.msdk.foundation.controller.b r3 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x00e1 }
            android.content.Context r3 = r3.g()     // Catch:{ Exception -> 0x00e1 }
            int r3 = com.mbridge.msdk.foundation.tools.af.h((android.content.Context) r3)     // Catch:{ Exception -> 0x00e1 }
            float r3 = (float) r3     // Catch:{ Exception -> 0x00e1 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x00e1 }
            r4.<init>()     // Catch:{ Exception -> 0x00e1 }
            int r5 = r14.size()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r6 = ""
            r7 = 1
            r8 = 0
            if (r5 <= 0) goto L_0x0063
            java.lang.Object r5 = r14.get(r8)     // Catch:{ Exception -> 0x00e1 }
            if (r5 == 0) goto L_0x0063
            java.lang.Object r5 = r14.get(r8)     // Catch:{ Exception -> 0x00e1 }
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = (com.mbridge.msdk.foundation.entity.CampaignEx) r5     // Catch:{ Exception -> 0x00e1 }
            if (r5 == 0) goto L_0x004d
            com.mbridge.msdk.foundation.entity.CampaignEx$c r9 = r5.getRewardTemplateMode()     // Catch:{ Exception -> 0x00e1 }
            if (r9 == 0) goto L_0x004d
            com.mbridge.msdk.foundation.entity.CampaignEx$c r5 = r5.getRewardTemplateMode()     // Catch:{ Exception -> 0x00e1 }
            int r5 = r5.c()     // Catch:{ Exception -> 0x00e1 }
            goto L_0x004e
        L_0x004d:
            r5 = 1
        L_0x004e:
            java.lang.Object r9 = r14.get(r8)     // Catch:{ Exception -> 0x00e1 }
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = (com.mbridge.msdk.foundation.entity.CampaignEx) r9     // Catch:{ Exception -> 0x00e1 }
            int r9 = r9.getMof_tplid()     // Catch:{ Exception -> 0x00e1 }
            java.lang.Object r10 = r14.get(r8)     // Catch:{ Exception -> 0x00e1 }
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = (com.mbridge.msdk.foundation.entity.CampaignEx) r10     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r10 = r10.getMof_template_url()     // Catch:{ Exception -> 0x00e1 }
            goto L_0x0066
        L_0x0063:
            r10 = r6
            r5 = 1
            r9 = 0
        L_0x0066:
            if (r9 == 0) goto L_0x0099
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x00e1 }
            if (r11 != 0) goto L_0x0099
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e1 }
            r4.<init>()     // Catch:{ Exception -> 0x00e1 }
            r4.append(r9)     // Catch:{ Exception -> 0x00e1 }
            r4.append(r6)     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r4 = com.mbridge.msdk.foundation.tools.k.a(r8, r4, r10)     // Catch:{ Exception -> 0x00e1 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e1 }
            r6.<init>(r0)     // Catch:{ Exception -> 0x00e1 }
            r6.append(r9)     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r0 = "_"
            r6.append(r0)     // Catch:{ Exception -> 0x00e1 }
            r6.append(r5)     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r0 = r6.toString()     // Catch:{ Exception -> 0x00e1 }
            java.util.List r4 = com.mbridge.msdk.foundation.tools.y.b(r4, r0)     // Catch:{ Exception -> 0x00e1 }
        L_0x0099:
            java.lang.String r0 = "mbridge_same_choice_one_layout_portrait"
            if (r5 == r7) goto L_0x00b7
            java.lang.String r6 = "mbridge_same_choice_one_layout_landscape"
            r9 = 2
            if (r5 == r9) goto L_0x00b6
            android.content.res.Resources r5 = r13.getResources()     // Catch:{ Exception -> 0x00e1 }
            android.content.res.Configuration r5 = r5.getConfiguration()     // Catch:{ Exception -> 0x00e1 }
            int r5 = r5.orientation     // Catch:{ Exception -> 0x00e1 }
            if (r5 != r9) goto L_0x00af
            r8 = 1
        L_0x00af:
            if (r8 == 0) goto L_0x00b4
            r0 = r6
            r5 = 2
            goto L_0x00b7
        L_0x00b4:
            r5 = 1
            goto L_0x00b7
        L_0x00b6:
            r0 = r6
        L_0x00b7:
            com.mbridge.msdk.video.dynview.c$a r6 = new com.mbridge.msdk.video.dynview.c$a     // Catch:{ Exception -> 0x00e1 }
            r6.<init>()     // Catch:{ Exception -> 0x00e1 }
            com.mbridge.msdk.video.dynview.c$b r13 = r6.a((android.content.Context) r13)     // Catch:{ Exception -> 0x00e1 }
            com.mbridge.msdk.video.dynview.c$b r13 = r13.a((java.lang.String) r0)     // Catch:{ Exception -> 0x00e1 }
            com.mbridge.msdk.video.dynview.c$b r13 = r13.a((int) r7)     // Catch:{ Exception -> 0x00e1 }
            com.mbridge.msdk.video.dynview.c$b r13 = r13.a((float) r3)     // Catch:{ Exception -> 0x00e1 }
            com.mbridge.msdk.video.dynview.c$b r13 = r13.b((float) r2)     // Catch:{ Exception -> 0x00e1 }
            com.mbridge.msdk.video.dynview.c$b r13 = r13.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r14)     // Catch:{ Exception -> 0x00e1 }
            com.mbridge.msdk.video.dynview.c$b r13 = r13.b((int) r5)     // Catch:{ Exception -> 0x00e1 }
            com.mbridge.msdk.video.dynview.c$b r13 = r13.b((java.util.List<java.lang.String>) r4)     // Catch:{ Exception -> 0x00e1 }
            com.mbridge.msdk.video.dynview.c r13 = r13.a()     // Catch:{ Exception -> 0x00e1 }
            return r13
        L_0x00e1:
            r13 = move-exception
            java.lang.String r14 = "ViewOptionWrapper"
            java.lang.String r13 = r13.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r14, r13)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.j.c.a(android.content.Context, java.util.List):com.mbridge.msdk.video.dynview.c");
    }

    public final com.mbridge.msdk.video.dynview.c a(View view, CampaignEx campaignEx) {
        boolean z;
        String str;
        String str2;
        String str3;
        if (campaignEx == null) {
            return null;
        }
        try {
            List arrayList = new ArrayList();
            int i = 0;
            int i2 = 102;
            if (campaignEx != null) {
                str3 = campaignEx.getCampaignUnitId();
                if (campaignEx.getRewardTemplateMode() != null) {
                    i2 = campaignEx.getRewardTemplateMode().b();
                    str2 = campaignEx.getRewardTemplateMode().e();
                } else {
                    str2 = "";
                }
                str = a(i2);
                z = a.a(str2);
            } else {
                str3 = "";
                str2 = str3;
                str = str2;
                z = false;
            }
            com.mbridge.msdk.videocommon.d.c a = b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), str3, false);
            if (a != null) {
                i = a.g();
            }
            if (i2 != 0 && !TextUtils.isEmpty(str2)) {
                String a2 = k.a(1, i2 + "", str2);
                StringBuilder sb = new StringBuilder("template_");
                sb.append(i2);
                arrayList = y.b(a2, sb.toString());
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(campaignEx);
            return new c.a().a(str).a(i2).a((List<CampaignEx>) arrayList2).a(view.getContext()).a(view).c(i).b(w.h(view.getContext())).d(i2).a(z).b((List<String>) arrayList).e(campaignEx.getDynamicTempCode()).a();
        } catch (Exception e) {
            aa.d("ViewOptionWrapper", e.getMessage());
            return null;
        }
    }

    public final com.mbridge.msdk.video.dynview.c b(View view, CampaignEx campaignEx) {
        String str;
        String str2;
        if (campaignEx == null) {
            return null;
        }
        if (campaignEx != null) {
            try {
                str2 = campaignEx.getCampaignUnitId();
                str = a(3);
            } catch (Exception e) {
                aa.d("ViewOptionWrapper", e.getMessage());
                return null;
            }
        } else {
            str2 = "";
            str = str2;
        }
        int i = 0;
        com.mbridge.msdk.videocommon.d.c a = b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), str2, false);
        if (a != null) {
            i = a.g();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        return new c.a().a(str).a(3).a((List<CampaignEx>) arrayList).a(view.getContext()).a(view).c(i).b(w.h(view.getContext())).d(3).a();
    }

    public final com.mbridge.msdk.video.dynview.c a(Context context, CampaignEx campaignEx, int i, String str) {
        if (campaignEx == null) {
            return null;
        }
        try {
            int h = w.h(context);
            String str2 = h == 1 ? "mbridge_reward_end_card_layout_portrait" : "mbridge_reward_end_card_layout_landscape";
            List arrayList = new ArrayList();
            if (!TextUtils.isEmpty(campaignEx.getendcard_url())) {
                String a = k.a(2, i + "", campaignEx.getendcard_url());
                arrayList = y.b(a, "template_" + str + h);
            }
            return new c.a().a(str2).a(4).a(context).b(w.h(context)).b((List<String>) arrayList).e(campaignEx.getDynamicTempCode()).d(i).b(str).a();
        } catch (Exception e) {
            aa.d("ViewOptionWrapper", e.getMessage());
            return null;
        }
    }

    public final com.mbridge.msdk.video.dynview.c b(Context context, List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    float i = (float) af.i(com.mbridge.msdk.foundation.controller.b.d().g());
                    float h = (float) af.h(com.mbridge.msdk.foundation.controller.b.d().g());
                    List arrayList = new ArrayList();
                    int dynamicTempCode = list.get(0).getDynamicTempCode();
                    int mof_tplid = list.get(0).getMof_tplid();
                    String mof_template_url = list.get(0).getMof_template_url();
                    int h2 = w.h(context);
                    if (mof_tplid != 0 && !TextUtils.isEmpty(mof_template_url)) {
                        String a = k.a(0, mof_tplid + "", mof_template_url);
                        arrayList = y.b(a, "template_" + mof_tplid + "_" + h2);
                    }
                    return new c.a().a(h2 == 1 ? "mbridge_order_layout_list_portrait" : "mbridge_order_layout_list_landscape").a(5).a(context).a(h).b(i).a(list).b(h2).b((List<String>) arrayList).e(dynamicTempCode).d(dynamicTempCode).a();
                }
            } catch (Exception e) {
                aa.d("ViewOptionWrapper", e.getMessage());
            }
        }
        return null;
    }
}
