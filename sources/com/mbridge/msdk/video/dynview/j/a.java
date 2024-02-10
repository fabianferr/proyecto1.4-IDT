package com.mbridge.msdk.video.dynview.j;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.l;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.video.dynview.c;
import com.mbridge.msdk.video.dynview.e.d;
import com.mbridge.msdk.video.dynview.e.e;
import com.mbridge.msdk.video.dynview.g.a;
import com.mbridge.msdk.video.dynview.i.c.b;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: DataEnergizeWrapper */
public final class a {
    private static boolean j = false;
    public com.mbridge.msdk.video.dynview.d.a a = new com.mbridge.msdk.video.dynview.d.a() {
        public final void a() {
            if (a.this.l && a.this.b != null) {
                a.this.b.a((long) (a.this.m * 1000), a.this.k);
                boolean unused = a.this.l = false;
            }
        }

        public final void b() {
            if (a.this.b != null) {
                a.this.b.b();
                boolean unused = a.this.l = true;
            }
        }

        public final void c() {
            if (a.this.b != null) {
                a.this.b.b();
                boolean unused = a.this.l = true;
            }
        }
    };
    /* access modifiers changed from: private */
    public b b;
    /* access modifiers changed from: private */
    public Map<String, Bitmap> c;
    /* access modifiers changed from: private */
    public volatile boolean d;
    private String e = "#FFFFFFFF";
    private String f = "#60000000";
    /* access modifiers changed from: private */
    public String g = "#FF5F5F5F";
    private String h = "#90ECECEC";
    /* access modifiers changed from: private */
    public volatile long i = 0;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.video.dynview.i.c.a k = null;
    /* access modifiers changed from: private */
    public boolean l = false;
    /* access modifiers changed from: private */
    public int m = 0;

    /* JADX WARNING: Removed duplicated region for block: B:101:0x03b4  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x03c3  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x03d5  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x03eb  */
    /* JADX WARNING: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x02a0  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x02ab  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x02d0  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02d6  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x02db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.mbridge.msdk.video.dynview.c r32, android.view.View r33, java.util.Map r34, com.mbridge.msdk.video.dynview.e.e r35) {
        /*
            r31 = this;
            r6 = r31
            r7 = r32
            r8 = r33
            r5 = r34
            r9 = r35
            java.util.Map<java.lang.String, android.graphics.Bitmap> r0 = r6.c
            if (r0 != 0) goto L_0x0015
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r6.c = r0
        L_0x0015:
            java.util.List r0 = r32.g()
            if (r8 != 0) goto L_0x0021
            com.mbridge.msdk.video.dynview.c.a r0 = com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_ROOTVIEW
            r9.a(r0)
            return
        L_0x0021:
            android.content.Context r10 = r33.getContext()
            if (r10 != 0) goto L_0x002d
            com.mbridge.msdk.video.dynview.c.a r0 = com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_CONTEXT
            r9.a(r0)
            return
        L_0x002d:
            r11 = 1
            r1 = 0
            if (r0 == 0) goto L_0x0045
            int r2 = r0.size()
            if (r2 <= r11) goto L_0x0045
            java.lang.Object r2 = r0.get(r1)
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = (com.mbridge.msdk.foundation.entity.CampaignEx) r2
            java.lang.Object r3 = r0.get(r11)
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = (com.mbridge.msdk.foundation.entity.CampaignEx) r3
            r15 = r2
            goto L_0x0047
        L_0x0045:
            r3 = 0
            r15 = 0
        L_0x0047:
            if (r15 != 0) goto L_0x0051
            if (r9 == 0) goto L_0x0051
            com.mbridge.msdk.video.dynview.c.a r0 = com.mbridge.msdk.video.dynview.c.a.CAMPAIGNEX_IS_NULL
            r9.a(r0)
            return
        L_0x0051:
            if (r3 != 0) goto L_0x005b
            if (r9 == 0) goto L_0x005b
            com.mbridge.msdk.video.dynview.c.a r0 = com.mbridge.msdk.video.dynview.c.a.CAMPAIGNEX_IS_NULL
            r9.a(r0)
            return
        L_0x005b:
            java.lang.String r2 = "is_dy_success"
            if (r5 == 0) goto L_0x0071
            boolean r4 = r5.containsKey(r2)
            if (r4 == 0) goto L_0x0071
            java.lang.Object r4 = r5.get(r2)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            j = r4
        L_0x0071:
            boolean r4 = j
            java.lang.String r13 = "mbridge_top_item_rl"
            int r4 = r6.a((boolean) r4, (java.lang.String) r13)
            android.view.View r4 = r8.findViewById(r4)
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            boolean r13 = j
            java.lang.String r14 = "mbridge_top_iv"
            int r13 = r6.a((boolean) r13, (java.lang.String) r14)
            android.view.View r13 = r8.findViewById(r13)
            com.mbridge.msdk.dycreator.baseview.cusview.MBridgeImageView r13 = (com.mbridge.msdk.dycreator.baseview.cusview.MBridgeImageView) r13
            boolean r14 = j
            java.lang.String r12 = "mbridge_top_ration"
            int r12 = r6.a((boolean) r14, (java.lang.String) r12)
            android.view.View r12 = r8.findViewById(r12)
            com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView r12 = (com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView) r12
            boolean r14 = j
            java.lang.String r1 = "mbridge_top_title_tv"
            int r1 = r6.a((boolean) r14, (java.lang.String) r1)
            android.view.View r1 = r8.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            boolean r14 = j
            java.lang.String r11 = "mbridge_bottom_item_rl"
            int r11 = r6.a((boolean) r14, (java.lang.String) r11)
            android.view.View r11 = r8.findViewById(r11)
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            boolean r14 = j
            java.lang.String r9 = "mbridge_bottom_ration"
            int r9 = r6.a((boolean) r14, (java.lang.String) r9)
            android.view.View r9 = r8.findViewById(r9)
            com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView r9 = (com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView) r9
            boolean r14 = j
            r23 = r10
            java.lang.String r10 = "mbridge_bottom_iv"
            int r10 = r6.a((boolean) r14, (java.lang.String) r10)
            android.view.View r10 = r8.findViewById(r10)
            com.mbridge.msdk.dycreator.baseview.cusview.MBridgeImageView r10 = (com.mbridge.msdk.dycreator.baseview.cusview.MBridgeImageView) r10
            boolean r14 = j
            r24 = r2
            java.lang.String r2 = "mbridge_bottom_icon_iv"
            r25 = r9
            java.lang.String r9 = "mbridge_top_icon_iv"
            if (r14 == 0) goto L_0x00fd
            int r9 = r6.a((boolean) r14, (java.lang.String) r9)
            android.view.View r9 = r8.findViewById(r9)
            com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView r9 = (com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView) r9
            boolean r14 = j
            int r2 = r6.a((boolean) r14, (java.lang.String) r2)
            android.view.View r2 = r8.findViewById(r2)
            com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView r2 = (com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView) r2
            r26 = r2
            r14 = 0
            r27 = 0
            goto L_0x0119
        L_0x00fd:
            int r9 = r6.a((boolean) r14, (java.lang.String) r9)
            android.view.View r9 = r8.findViewById(r9)
            com.mbridge.msdk.videocommon.view.RoundImageView r9 = (com.mbridge.msdk.videocommon.view.RoundImageView) r9
            boolean r14 = j
            int r2 = r6.a((boolean) r14, (java.lang.String) r2)
            android.view.View r2 = r8.findViewById(r2)
            com.mbridge.msdk.videocommon.view.RoundImageView r2 = (com.mbridge.msdk.videocommon.view.RoundImageView) r2
            r27 = r2
            r14 = r9
            r9 = 0
            r26 = 0
        L_0x0119:
            boolean r2 = j
            r28 = r3
            java.lang.String r3 = "mbridge_bottom_title_tv"
            int r2 = r6.a((boolean) r2, (java.lang.String) r3)
            android.view.View r2 = r8.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            boolean r3 = j
            r29 = r2
            java.lang.String r2 = "mbridge_reward_choice_one_like_iv"
            int r2 = r6.a((boolean) r3, (java.lang.String) r2)
            android.view.View r2 = r8.findViewById(r2)
            r3 = r2
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            if (r4 == 0) goto L_0x0144
            com.mbridge.msdk.video.dynview.j.a$4 r2 = new com.mbridge.msdk.video.dynview.j.a$4
            r2.<init>(r5, r0)
            r4.setOnClickListener(r2)
        L_0x0144:
            r2 = 1128792064(0x43480000, float:200.0)
            if (r13 == 0) goto L_0x01cc
            r17 = 20
            r18 = 20
            r19 = 0
            r20 = 0
            r21 = 10
            r22 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r16 = r13
            r16.setCustomBorder(r17, r18, r19, r20, r21, r22)
            java.lang.String r4 = r15.getImageUrl()
            r6.a((java.lang.String) r4, (android.widget.ImageView) r13, (com.mbridge.msdk.video.dynview.c) r7, (android.view.View) r8)
            if (r12 == 0) goto L_0x01cc
            boolean r4 = r15.getCanStart2C1Anim()
            if (r4 == 0) goto L_0x01bd
            java.lang.String r4 = r15.getIconUrl()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x01ae
            android.widget.ImageView r4 = new android.widget.ImageView
            android.content.Context r13 = r32.a()
            r4.<init>(r13)
            android.widget.FrameLayout$LayoutParams r13 = new android.widget.FrameLayout$LayoutParams
            r30 = r3
            android.content.Context r3 = r32.a()
            int r3 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r3, (float) r2)
            r2 = -1
            r13.<init>(r2, r3)
            r4.setLayoutParams(r13)
            android.widget.ImageView$ScaleType r2 = android.widget.ImageView.ScaleType.CENTER_CROP
            r4.setScaleType(r2)
            r12.addView(r4)
            java.lang.String r2 = r15.getIconUrl()
            r6.a((java.lang.String) r2, (android.widget.ImageView) r4)
            r2 = 1055286886(0x3ee66666, float:0.45)
            r12.setWidthRatio(r2)
            r2 = 1063675494(0x3f666666, float:0.9)
            r12.setHeightRatio(r2)
            r2 = 1
            r12.setAutoscroll(r2)
            goto L_0x01ce
        L_0x01ae:
            r30 = r3
            r2 = 1065353216(0x3f800000, float:1.0)
            r12.setWidthRatio(r2)
            r12.setHeightRatio(r2)
            r3 = 0
            r12.setAutoscroll(r3)
            goto L_0x01cf
        L_0x01bd:
            r30 = r3
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 0
            r12.setWidthRatio(r2)
            r12.setHeightRatio(r2)
            r12.setAutoscroll(r3)
            goto L_0x01cf
        L_0x01cc:
            r30 = r3
        L_0x01ce:
            r3 = 0
        L_0x01cf:
            if (r14 == 0) goto L_0x01db
            r14.setType(r3)
            java.lang.String r2 = r15.getIconUrl()
            r6.a((java.lang.String) r2, (android.widget.ImageView) r14)
        L_0x01db:
            if (r9 == 0) goto L_0x01e4
            java.lang.String r2 = r15.getIconUrl()
            r6.a((java.lang.String) r2, (android.widget.ImageView) r9)
        L_0x01e4:
            if (r1 == 0) goto L_0x01fd
            java.lang.String r2 = r15.getAppName()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x01f8
            java.lang.String r2 = r15.getAppName()
            r1.setText(r2)
            goto L_0x01fd
        L_0x01f8:
            r2 = 8
            r1.setVisibility(r2)
        L_0x01fd:
            if (r11 == 0) goto L_0x0207
            com.mbridge.msdk.video.dynview.j.a$5 r1 = new com.mbridge.msdk.video.dynview.j.a$5
            r1.<init>(r5, r0)
            r11.setOnClickListener(r1)
        L_0x0207:
            if (r10 == 0) goto L_0x028f
            r17 = 20
            r18 = 20
            r19 = 0
            r20 = 0
            r21 = 10
            r22 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r16 = r10
            r16.setCustomBorder(r17, r18, r19, r20, r21, r22)
            java.lang.String r0 = r28.getImageUrl()
            r6.a((java.lang.String) r0, (android.widget.ImageView) r10, (com.mbridge.msdk.video.dynview.c) r7, (android.view.View) r8)
            if (r25 == 0) goto L_0x028f
            boolean r0 = r28.getCanStart2C1Anim()
            if (r0 == 0) goto L_0x0280
            java.lang.String r0 = r28.getIconUrl()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0271
            android.widget.ImageView r0 = new android.widget.ImageView
            android.content.Context r1 = r32.a()
            r0.<init>(r1)
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            android.content.Context r2 = r32.a()
            r3 = 1128792064(0x43480000, float:200.0)
            int r2 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r2, (float) r3)
            r3 = -1
            r1.<init>(r3, r2)
            r0.setLayoutParams(r1)
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP
            r0.setScaleType(r1)
            r9 = r25
            r9.addView(r0)
            java.lang.String r1 = r28.getIconUrl()
            r6.a((java.lang.String) r1, (android.widget.ImageView) r0)
            r0 = 1055286886(0x3ee66666, float:0.45)
            r9.setWidthRatio(r0)
            r0 = 1063675494(0x3f666666, float:0.9)
            r9.setHeightRatio(r0)
            r0 = 1
            r9.setAutoscroll(r0)
            goto L_0x028f
        L_0x0271:
            r9 = r25
            r0 = 1065353216(0x3f800000, float:1.0)
            r9.setWidthRatio(r0)
            r9.setHeightRatio(r0)
            r1 = 0
            r9.setAutoscroll(r1)
            goto L_0x0290
        L_0x0280:
            r9 = r25
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 0
            r9.setWidthRatio(r0)
            r9.setHeightRatio(r0)
            r9.setAutoscroll(r1)
            goto L_0x0290
        L_0x028f:
            r1 = 0
        L_0x0290:
            if (r27 == 0) goto L_0x029e
            r2 = r27
            r2.setType(r1)
            java.lang.String r0 = r28.getIconUrl()
            r6.a((java.lang.String) r0, (android.widget.ImageView) r2)
        L_0x029e:
            if (r26 == 0) goto L_0x02a9
            java.lang.String r0 = r28.getIconUrl()
            r2 = r26
            r6.a((java.lang.String) r0, (android.widget.ImageView) r2)
        L_0x02a9:
            if (r29 == 0) goto L_0x02b4
            java.lang.String r0 = r28.getAppName()
            r2 = r29
            r2.setText(r0)
        L_0x02b4:
            java.lang.String r0 = r15.getCMPTEntryUrl()
            r32.e()
            java.lang.String r1 = "cltp"
            java.lang.String r1 = com.mbridge.msdk.foundation.tools.al.a(r0, r1)
            java.lang.String r2 = "xt"
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.al.a(r0, r2)
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            r9 = 0
            if (r0 != 0) goto L_0x02d6
            long r0 = java.lang.Long.parseLong(r1)
            r11 = r0
            goto L_0x02d7
        L_0x02d6:
            r11 = r9
        L_0x02d7:
            int r0 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x03b4
            if (r5 == 0) goto L_0x02f1
            r0 = r24
            boolean r1 = r5.containsKey(r0)
            if (r1 == 0) goto L_0x02f1
            java.lang.Object r0 = r5.get(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            j = r0
        L_0x02f1:
            boolean r0 = j
            java.lang.String r1 = "mbridge_choice_one_countdown_tv"
            int r0 = r6.a((boolean) r0, (java.lang.String) r1)
            android.view.View r0 = r8.findViewById(r0)
            r2 = r0
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x037b
            r0 = 1093664768(0x41300000, float:11.0)
            r2.setTextSize(r0)
            java.lang.String r0 = r6.e
            int r0 = android.graphics.Color.parseColor(r0)
            r2.setTextColor(r0)
            java.lang.String r0 = r6.f
            if (r2 == 0) goto L_0x0343
            android.graphics.drawable.GradientDrawable r1 = new android.graphics.drawable.GradientDrawable
            r1.<init>()
            int r4 = android.graphics.Color.parseColor(r0)
            r1.setColor(r4)
            android.content.Context r4 = r2.getContext()
            r9 = 12
            float r9 = (float) r9
            int r4 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r4, (float) r9)
            float r4 = (float) r4
            r1.setCornerRadius(r4)
            android.content.Context r4 = r2.getContext()
            r9 = 1
            float r10 = (float) r9
            int r4 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r4, (float) r10)
            int r0 = android.graphics.Color.parseColor(r0)
            r1.setStroke(r4, r0)
            r2.setBackground(r1)
        L_0x0343:
            r0 = 0
            r2.setVisibility(r0)
            com.mbridge.msdk.video.dynview.j.a$11 r0 = new com.mbridge.msdk.video.dynview.j.a$11
            r0.<init>(r5)
            r2.setOnClickListener(r0)
            com.mbridge.msdk.video.dynview.j.a$2 r9 = new com.mbridge.msdk.video.dynview.j.a$2
            r0 = r9
            r1 = r31
            r10 = r30
            r4 = r15
            r5 = r34
            r0.<init>(r2, r3, r4, r5)
            r6.k = r9
            com.mbridge.msdk.video.dynview.i.c.b r0 = new com.mbridge.msdk.video.dynview.i.c.b
            r0.<init>()
            r1 = 1000(0x3e8, double:4.94E-321)
            long r11 = r11 * r1
            com.mbridge.msdk.video.dynview.i.c.b r0 = r0.b(r11)
            com.mbridge.msdk.video.dynview.i.c.b r0 = r0.a((long) r1)
            com.mbridge.msdk.video.dynview.i.c.a r1 = r6.k
            com.mbridge.msdk.video.dynview.i.c.b r0 = r0.a((com.mbridge.msdk.video.dynview.i.c.a) r1)
            r6.b = r0
            r0.a()
            goto L_0x037d
        L_0x037b:
            r10 = r30
        L_0x037d:
            boolean r0 = j
            java.lang.String r1 = "mbridge_iv_link"
            int r0 = r6.a((boolean) r0, (java.lang.String) r1)
            android.view.View r0 = r8.findViewById(r0)
            r14 = r0
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r15 != 0) goto L_0x038f
            goto L_0x03b6
        L_0x038f:
            com.mbridge.msdk.foundation.entity.CampaignEx$a r0 = r15.getAdchoice()
            if (r0 == 0) goto L_0x039e
            com.mbridge.msdk.foundation.entity.CampaignEx$a r0 = r15.getAdchoice()
            java.lang.String r1 = ""
            r0.a((java.lang.String) r1)
        L_0x039e:
            r13 = 4
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.d()
            android.content.Context r16 = r0.g()
            r17 = 0
            com.mbridge.msdk.video.dynview.j.a$3 r0 = new com.mbridge.msdk.video.dynview.j.a$3
            r0.<init>()
            r18 = r0
            com.mbridge.msdk.foundation.tools.af.a(r13, r14, r15, r16, r17, r18)
            goto L_0x03b6
        L_0x03b4:
            r10 = r30
        L_0x03b6:
            if (r7 == 0) goto L_0x03e7
            if (r10 == 0) goto L_0x03e7
            int r0 = r32.e()
            java.lang.String r1 = "drawable"
            r2 = 1
            if (r0 != r2) goto L_0x03d5
            r0 = r23
            java.lang.String r2 = com.mbridge.msdk.video.dynview.i.a.a(r0, r2)
            android.content.Context r0 = r0.getApplicationContext()
            int r0 = com.mbridge.msdk.foundation.tools.t.a(r0, r2, r1)
            r10.setImageResource(r0)
            goto L_0x03e7
        L_0x03d5:
            r0 = r23
            r2 = 2
            java.lang.String r2 = com.mbridge.msdk.video.dynview.i.a.a(r0, r2)
            android.content.Context r0 = r0.getApplicationContext()
            int r0 = com.mbridge.msdk.foundation.tools.t.a(r0, r2, r1)
            r10.setImageResource(r0)
        L_0x03e7:
            r0 = r35
            if (r0 == 0) goto L_0x03ef
            r1 = 0
            r0.a(r8, r1)
        L_0x03ef:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.j.a.a(com.mbridge.msdk.video.dynview.c, android.view.View, java.util.Map, com.mbridge.msdk.video.dynview.e.e):void");
    }

    public final void b(c cVar, View view, Map map, e eVar) {
        View view2 = view;
        Map map2 = map;
        e eVar2 = eVar;
        if (eVar2 != null) {
            if (cVar == null) {
                eVar2.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
                return;
            }
            if (map2 != null && map2.containsKey("is_dy_success")) {
                j = ((Boolean) map2.get("is_dy_success")).booleanValue();
            }
            boolean z = j;
            LinearLayout linearLayout = z ? (LinearLayout) view2.findViewById(a(z, "mbridge_reward_heat_mllv")) : null;
            ImageView imageView = (ImageView) view2.findViewById(a(j, "mbridge_reward_icon_riv"));
            TextView textView = (TextView) view2.findViewById(a(j, "mbridge_reward_title_tv"));
            LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(a(j, "mbridge_reward_stars_mllv"));
            TextView textView2 = (TextView) view2.findViewById(a(j, "mbridge_reward_click_tv"));
            ImageView imageView2 = (ImageView) view2.findViewById(a(j, "mbridge_videoview_bg"));
            TextView textView3 = (TextView) view2.findViewById(a(j, "mbridge_reward_desc_tv"));
            ArrayList arrayList = new ArrayList();
            List<CampaignEx> g2 = cVar.g();
            if (g2 == null || g2.size() <= 0) {
                eVar2.a(com.mbridge.msdk.video.dynview.c.a.CAMPAIGNEX_IS_NULL);
                return;
            }
            CampaignEx campaignEx = g2.get(0);
            if (campaignEx != null) {
                if (imageView != null) {
                    if (!j) {
                        ((RoundImageView) imageView).setBorderRadius(10);
                    } else if (imageView instanceof MBCusRoundImageView) {
                        ((MBCusRoundImageView) imageView).setCustomBorder(30, 30, 30, 30, 10, -1);
                    }
                    a(campaignEx.getIconUrl(), imageView);
                }
                if (textView != null) {
                    textView.setText(campaignEx.getAppName());
                }
                if (textView3 != null) {
                    textView3.setText(campaignEx.getAppDesc());
                }
                if (linearLayout2 != null) {
                    double rating = campaignEx.getRating();
                    if (rating <= 0.0d) {
                        rating = 5.0d;
                    }
                    if (j) {
                        if (linearLayout2 != null && (linearLayout2 instanceof MBStarLevelLayoutView)) {
                            MBStarLevelLayoutView mBStarLevelLayoutView = (MBStarLevelLayoutView) linearLayout2;
                            mBStarLevelLayoutView.setRating((int) rating);
                            mBStarLevelLayoutView.setOrientation(0);
                        }
                        if (linearLayout != null && (linearLayout instanceof MBHeatLevelLayoutView)) {
                            ((MBHeatLevelLayoutView) linearLayout).setHeatCount(campaignEx.getNumberRating());
                        }
                    } else {
                        ((MBridgeLevelLayoutView) linearLayout2).setRatingAndUser(rating, campaignEx.getNumberRating());
                    }
                }
                if (textView2 != null) {
                    textView2.setText(campaignEx.getAdCall());
                }
                int h2 = cVar.h();
                if (h2 == 102 || h2 == 202 || h2 == 302) {
                    if (textView2 != null) {
                        arrayList.add(textView2);
                    }
                } else if (h2 == 802) {
                    if (imageView != null) {
                        arrayList.add(imageView);
                    }
                    if (textView2 != null) {
                        arrayList.add(textView2);
                    }
                    a(imageView2, campaignEx.getImageUrl(), h2);
                } else if (h2 == 904 && cVar.k()) {
                    arrayList.add(view2);
                }
                eVar2.a(view2, arrayList);
                return;
            }
            eVar2.a(com.mbridge.msdk.video.dynview.c.a.CAMPAIGNEX_IS_NULL);
        }
    }

    public final void a(c cVar, View view, e eVar) {
        if (eVar != null) {
            if (cVar == null) {
                eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
                return;
            }
            try {
                ImageView imageView = (ImageView) view.findViewById(t.a(com.mbridge.msdk.foundation.controller.b.d().g(), "mbridge_iv_adbanner_bg", "id"));
                if (imageView != null) {
                    imageView.setBackgroundColor(Color.parseColor(this.h));
                }
                ImageView imageView2 = (ImageView) view.findViewById(t.a(com.mbridge.msdk.foundation.controller.b.d().g(), "mbridge_iv_adbanner", "id"));
                if (imageView2 != null) {
                    imageView2.setBackgroundColor(Color.parseColor(this.h));
                }
                eVar.a(view, new ArrayList());
            } catch (Exception e2) {
                aa.a("DataEnergizeWrapper", e2.getMessage());
                eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
            }
        }
    }

    public final void c(c cVar, View view, final Map map, e eVar) {
        try {
            if (this.c == null) {
                this.c = new HashMap();
            }
            final List<CampaignEx> g2 = cVar.g();
            if (view.getContext() == null) {
                eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_CONTEXT);
                return;
            }
            if (map != null && map.containsKey("is_dy_success")) {
                j = ((Boolean) map.get("is_dy_success")).booleanValue();
            }
            ListView listView = (ListView) view.findViewById(a(j, "mbridge_order_view_lv"));
            GridView gridView = (GridView) view.findViewById(a(j, "mbridge_order_view_h_lv"));
            ImageView imageView = (ImageView) view.findViewById(a(j, "mbridge_order_view_iv_close"));
            com.mbridge.msdk.video.dynview.ordercamp.a.a aVar = new com.mbridge.msdk.video.dynview.ordercamp.a.a(g2);
            if (cVar.e() == 1) {
                if (listView != null) {
                    if (!(listView == null || cVar == null)) {
                        try {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) listView.getLayoutParams();
                            if (layoutParams != null) {
                                layoutParams.height = -1;
                                int b2 = af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 10.0f);
                                int c2 = (int) ((cVar.c() - ((float) af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 720.0f))) / 2.0f);
                                layoutParams.setMargins(b2, c2, b2, c2);
                                listView.setLayoutParams(layoutParams);
                            }
                        } catch (Exception e2) {
                            aa.d("DataEnergizeWrapper", e2.getMessage());
                        }
                    }
                    listView.setAdapter(aVar);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                            a.a(a.this, map, g2, i);
                        }
                    });
                }
            } else if (gridView != null) {
                int d2 = (int) cVar.d();
                int size = d2 / g2.size();
                int i2 = size / 9;
                int i3 = i2 / 2;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gridView.getLayoutParams();
                layoutParams2.width = d2 - (i2 * 2);
                gridView.setLayoutParams(layoutParams2);
                gridView.setColumnWidth((size - i2) - (i3 / 2));
                gridView.setHorizontalSpacing(i3);
                gridView.setStretchMode(0);
                gridView.setNumColumns(g2.size());
                gridView.setAdapter(aVar);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        a.a(a.this, map, g2, i);
                    }
                });
            }
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        a.a(a.this, map);
                    }
                });
            }
            if (eVar != null) {
                eVar.a(view, (List<View>) null);
            }
        } catch (Exception unused) {
            if (eVar != null) {
                eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
            }
        }
    }

    private void a(String str, ImageView imageView) {
        if (!TextUtils.isEmpty(str) && imageView != null) {
            a(imageView, str, -1);
        }
    }

    private void a(final ImageView imageView, String str, final int i2) {
        if (!TextUtils.isEmpty(str) && imageView != null) {
            com.mbridge.msdk.foundation.same.c.b.a(imageView.getContext()).a(str, (com.mbridge.msdk.foundation.same.c.c) new com.mbridge.msdk.foundation.same.c.c() {
                public final void onSuccessLoad(final Bitmap bitmap, String str) {
                    if (bitmap == null || bitmap.isRecycled()) {
                        int a2 = t.a(imageView.getContext(), "mbridge_icon_play_bg", "drawable");
                        imageView.setBackgroundColor(Color.parseColor(a.this.g));
                        imageView.setImageResource(a2);
                        imageView.setScaleType(ImageView.ScaleType.CENTER);
                        return;
                    }
                    int i = i2;
                    if (i == 501 || i == 802) {
                        com.mbridge.msdk.foundation.same.f.b.d().execute(new Runnable() {
                            public final void run() {
                                try {
                                    final Bitmap a2 = l.a(bitmap, 10);
                                    imageView.post(new Runnable() {
                                        public final void run() {
                                            imageView.setImageBitmap(a2);
                                        }
                                    });
                                } catch (Exception e) {
                                    aa.d("DataEnergizeWrapper", e.getMessage());
                                }
                            }
                        });
                        return;
                    }
                    imageView.setImageBitmap(bitmap);
                }

                public final void onFailedLoad(String str, String str2) {
                    try {
                        int a2 = t.a(imageView.getContext(), "mbridge_icon_play_bg", "drawable");
                        imageView.setBackgroundColor(Color.parseColor(a.this.g));
                        imageView.setImageResource(a2);
                        imageView.setScaleType(ImageView.ScaleType.CENTER);
                    } catch (Exception e) {
                        aa.a("DataEnergizeWrapper", e.getMessage());
                    }
                }
            });
        }
    }

    private void a(String str, ImageView imageView, c cVar, View view) {
        final ImageView imageView2 = imageView;
        final String str2 = str;
        final c cVar2 = cVar;
        final View view2 = view;
        com.mbridge.msdk.foundation.same.c.b.a(imageView.getContext()).a(str, (com.mbridge.msdk.foundation.same.c.c) new com.mbridge.msdk.foundation.same.c.c() {
            public final void onFailedLoad(String str, String str2) {
            }

            public final void onSuccessLoad(Bitmap bitmap, String str) {
                ImageView imageView;
                if (bitmap != null && !bitmap.isRecycled() && (imageView = imageView2) != null) {
                    imageView.setImageBitmap(bitmap);
                    if (a.this.c != null) {
                        a.this.c.put(SameMD5.getMD5(str2), bitmap);
                        a.a(a.this, cVar2, view2);
                    }
                }
            }
        });
        try {
            Bitmap a2 = a();
            if (a2 != null && !a2.isRecycled()) {
                a(cVar, view);
            }
        } catch (Exception e2) {
            aa.d("DataEnergizeWrapper", e2.getMessage());
        }
    }

    private int a(boolean z, String str) {
        if (!z) {
            return t.a(com.mbridge.msdk.foundation.controller.b.d().g(), str, "id");
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                return str.hashCode();
            }
            return -1;
        } catch (Exception e2) {
            aa.d("DataEnergizeWrapper", e2.getMessage());
            return -1;
        }
    }

    private Bitmap a() {
        Bitmap bitmap = null;
        try {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_4444);
            bitmap.eraseColor(Color.parseColor(this.h));
            return bitmap;
        } catch (Exception e2) {
            if (!MBridgeConstans.DEBUG) {
                return bitmap;
            }
            e2.printStackTrace();
            return bitmap;
        }
    }

    private void a(c cVar, View view) {
        a.C0156a a2 = com.mbridge.msdk.video.dynview.g.a.a();
        a2.a(cVar.e()).a(true);
        if (cVar.e() != 2) {
            a2.a(cVar.d()).b(cVar.c());
        } else if (cVar.d() > cVar.c()) {
            a2.a(cVar.d()).b(cVar.c());
        } else {
            a2.a(cVar.c()).b(cVar.d());
        }
        if (view.getBackground() == null) {
            view.setBackground(a2.a());
        }
    }

    private void b() {
        com.mbridge.msdk.video.dynview.i.a.a.a().b();
        b bVar = this.b;
        if (bVar != null) {
            bVar.b();
            this.b = null;
        }
        com.mbridge.msdk.video.dynview.b.a.a().a = null;
        if (this.a != null) {
            this.a = null;
        }
        Map<String, Bitmap> map = this.c;
        if (map != null) {
            if (map.entrySet() != null) {
                try {
                    Iterator<Map.Entry<String, Bitmap>> it = this.c.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry next = it.next();
                        if (!(next == null || next.getValue() == null || ((Bitmap) next.getValue()).isRecycled())) {
                            ((Bitmap) next.getValue()).recycle();
                        }
                        it.remove();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.c.clear();
        }
    }

    static /* synthetic */ void a(a aVar, Map map, List list, int i2) {
        if (map != null && list != null && list.size() > 1) {
            if (map.containsKey("choice_one_callback") && (map.get("choice_one_callback") instanceof d)) {
                d dVar = (d) map.get("choice_one_callback");
                if (dVar != null) {
                    dVar.a((CampaignEx) list.get(i2));
                    try {
                        CampaignEx campaignEx = (CampaignEx) list.get(i2);
                        HashMap hashMap = new HashMap();
                        hashMap.put(CampaignEx.JSON_NATIVE_VIDEO_CLICK, "0");
                        hashMap.put("time", aVar.i + "");
                        hashMap.put("choose_cid", campaignEx.getId());
                        hashMap.put("position", i2 + "");
                        hashMap.put("type", "choseFromTwoSelect");
                        com.mbridge.msdk.video.module.b.a.a("2000103", campaignEx, hashMap);
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                }
                aVar.b();
            } else if (map.containsKey("order_view_callback") && (map.get("order_view_callback") instanceof com.mbridge.msdk.video.dynview.e.c)) {
                com.mbridge.msdk.video.dynview.e.c cVar = (com.mbridge.msdk.video.dynview.e.c) map.get("order_view_callback");
                if (cVar != null) {
                    cVar.a((CampaignEx) list.get(i2), i2);
                }
                aVar.b();
            }
        }
    }

    static /* synthetic */ void a(a aVar, Map map) {
        if (map != null) {
            try {
                if (map.containsKey("order_view_callback") && (map.get("order_view_callback") instanceof com.mbridge.msdk.video.dynview.e.c)) {
                    ((com.mbridge.msdk.video.dynview.e.c) map.get("order_view_callback")).a();
                    aVar.b();
                }
            } catch (Exception e2) {
                aa.d("DataEnergizeWrapper", e2.getMessage());
            }
        }
    }

    static /* synthetic */ void a(a aVar, c cVar, View view) {
        Map<String, Bitmap> map = aVar.c;
        if (map != null && map.size() > 1) {
            new com.mbridge.msdk.video.dynview.h.b();
            Map<String, Bitmap> map2 = aVar.c;
            if (view != null) {
                com.mbridge.msdk.video.dynview.i.a.a.a().a(map2, cVar, view);
            }
        }
    }

    static /* synthetic */ void b(a aVar, Map map) {
        if (map != null) {
            try {
                if (map.containsKey("choice_one_callback") && (map.get("choice_one_callback") instanceof d)) {
                    ((d) map.get("choice_one_callback")).a();
                    aVar.b();
                }
            } catch (Exception e2) {
                aa.d("DataEnergizeWrapper", e2.getMessage());
            }
        }
    }
}
