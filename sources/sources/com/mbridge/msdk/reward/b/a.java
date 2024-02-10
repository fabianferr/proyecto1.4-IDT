package com.mbridge.msdk.reward.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.reward.adapter.b;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: RewardVideoController */
public class a {
    private static ConcurrentHashMap<String, Integer> S = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, String> T = new ConcurrentHashMap<>();
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String f = null;
    public static String g = "";
    public static ConcurrentHashMap<String, d> h = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public volatile String A;
    /* access modifiers changed from: private */
    public String B;
    private int C = 0;
    /* access modifiers changed from: private */
    public Handler D = new Handler(Looper.getMainLooper()) {
        /* JADX WARNING: Removed duplicated region for block: B:154:0x0465 A[Catch:{ Exception -> 0x04a7 }] */
        /* JADX WARNING: Removed duplicated region for block: B:155:0x046a A[Catch:{ Exception -> 0x04a7 }] */
        /* JADX WARNING: Removed duplicated region for block: B:158:0x046f A[Catch:{ Exception -> 0x04a7 }] */
        /* JADX WARNING: Removed duplicated region for block: B:159:0x0480 A[Catch:{ Exception -> 0x04a7 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r18) {
            /*
                r17 = this;
                r1 = r17
                r0 = r18
                java.lang.String r2 = "local_id"
                int r3 = r0.what
                java.lang.String r4 = "r_l_b_m_t_r_i"
                r5 = 1
                r6 = 0
                switch(r3) {
                    case 8: goto L_0x054c;
                    case 9: goto L_0x04b1;
                    case 16: goto L_0x03d2;
                    case 17: goto L_0x0355;
                    case 18: goto L_0x03d2;
                    case 1001001: goto L_0x032c;
                    case 1001002: goto L_0x0011;
                    default: goto L_0x000f;
                }
            L_0x000f:
                goto L_0x0602
            L_0x0011:
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.videocommon.d.c r0 = r0.q
                if (r0 == 0) goto L_0x0024
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.videocommon.d.c r0 = r0.q
                int r0 = r0.G()
                goto L_0x0025
            L_0x0024:
                r0 = 0
            L_0x0025:
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.adapter.c r2 = r2.p
                java.lang.String r3 = "RewardVideoController"
                if (r2 == 0) goto L_0x031d
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.adapter.c r2 = r2.p
                boolean r2 = r2.c()
                java.lang.String r4 = "s exception"
                java.lang.String r7 = "load timeout task called onVideoLoadSuccess after "
                if (r2 == 0) goto L_0x00c8
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.b.a$c r2 = r2.t
                if (r2 == 0) goto L_0x0602
                java.lang.String r2 = "load timeout task called for onVideoLoadSuccess by isReady exception"
                com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r3, (java.lang.String) r2)
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this     // Catch:{ all -> 0x00a9 }
                com.mbridge.msdk.reward.adapter.c r2 = r2.p     // Catch:{ all -> 0x00a9 }
                java.util.concurrent.CopyOnWriteArrayList r2 = r2.e()     // Catch:{ all -> 0x00a9 }
                if (r2 == 0) goto L_0x005e
                int r5 = r2.size()     // Catch:{ all -> 0x00a9 }
                if (r5 != 0) goto L_0x0068
            L_0x005e:
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this     // Catch:{ all -> 0x00a9 }
                com.mbridge.msdk.reward.adapter.c r2 = r2.p     // Catch:{ all -> 0x00a9 }
                java.util.concurrent.CopyOnWriteArrayList r2 = r2.f()     // Catch:{ all -> 0x00a9 }
            L_0x0068:
                if (r2 == 0) goto L_0x00b1
                int r5 = r2.size()     // Catch:{ all -> 0x00a9 }
                if (r5 <= 0) goto L_0x00b1
                java.lang.Object r5 = r2.get(r6)     // Catch:{ all -> 0x00a9 }
                r8 = r5
                com.mbridge.msdk.foundation.entity.CampaignEx r8 = (com.mbridge.msdk.foundation.entity.CampaignEx) r8     // Catch:{ all -> 0x00a9 }
                com.mbridge.msdk.foundation.controller.b r5 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x00a9 }
                android.content.Context r9 = r5.g()     // Catch:{ all -> 0x00a9 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a9 }
                r5.<init>(r7)     // Catch:{ all -> 0x00a9 }
                r5.append(r0)     // Catch:{ all -> 0x00a9 }
                r5.append(r4)     // Catch:{ all -> 0x00a9 }
                java.lang.String r10 = r5.toString()     // Catch:{ all -> 0x00a9 }
                com.mbridge.msdk.reward.b.a r4 = com.mbridge.msdk.reward.b.a.this     // Catch:{ all -> 0x00a9 }
                java.lang.String r11 = r4.v     // Catch:{ all -> 0x00a9 }
                com.mbridge.msdk.reward.b.a r4 = com.mbridge.msdk.reward.b.a.this     // Catch:{ all -> 0x00a9 }
                boolean r12 = r4.J     // Catch:{ all -> 0x00a9 }
                java.lang.String r13 = ""
                java.lang.String r14 = ""
                long r4 = (long) r0     // Catch:{ all -> 0x00a9 }
                r15 = r4
                com.mbridge.msdk.reward.c.a.a(r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x00a9 }
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this     // Catch:{ all -> 0x00a9 }
                r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r2)     // Catch:{ all -> 0x00a9 }
                goto L_0x00b1
            L_0x00a9:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                com.mbridge.msdk.foundation.tools.aa.d(r3, r0)
            L_0x00b1:
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.b.a$c r0 = r0.t
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                java.lang.String r2 = r2.A
                com.mbridge.msdk.reward.b.a r3 = com.mbridge.msdk.reward.b.a.this
                java.lang.String r3 = r3.v
                r0.b(r2, r3)
                goto L_0x0602
            L_0x00c8:
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.adapter.c r2 = r2.p
                boolean r2 = r2.g((boolean) r6)
                java.lang.String r8 = "load timeout task called for onVideoLoadFail after "
                if (r2 == 0) goto L_0x0242
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.adapter.c r2 = r2.p
                boolean r2 = r2.c()
                java.lang.String r9 = "load timeout task called for onVideoLoadSuccess by isReady but updateCampaignsLoadTimeoutState exception"
                if (r2 == 0) goto L_0x0162
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.b.a$c r2 = r2.t
                if (r2 == 0) goto L_0x0602
                com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r3, (java.lang.String) r9)
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.adapter.c r2 = r2.p
                r2.e((boolean) r6)
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this     // Catch:{ all -> 0x0143 }
                com.mbridge.msdk.reward.adapter.c r2 = r2.p     // Catch:{ all -> 0x0143 }
                java.util.concurrent.CopyOnWriteArrayList r2 = r2.e()     // Catch:{ all -> 0x0143 }
                if (r2 == 0) goto L_0x014b
                int r5 = r2.size()     // Catch:{ all -> 0x0143 }
                if (r5 <= 0) goto L_0x014b
                java.lang.Object r5 = r2.get(r6)     // Catch:{ all -> 0x0143 }
                r8 = r5
                com.mbridge.msdk.foundation.entity.CampaignEx r8 = (com.mbridge.msdk.foundation.entity.CampaignEx) r8     // Catch:{ all -> 0x0143 }
                com.mbridge.msdk.foundation.controller.b r5 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x0143 }
                android.content.Context r9 = r5.g()     // Catch:{ all -> 0x0143 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0143 }
                r5.<init>(r7)     // Catch:{ all -> 0x0143 }
                r5.append(r0)     // Catch:{ all -> 0x0143 }
                r5.append(r4)     // Catch:{ all -> 0x0143 }
                java.lang.String r10 = r5.toString()     // Catch:{ all -> 0x0143 }
                com.mbridge.msdk.reward.b.a r4 = com.mbridge.msdk.reward.b.a.this     // Catch:{ all -> 0x0143 }
                java.lang.String r11 = r4.v     // Catch:{ all -> 0x0143 }
                com.mbridge.msdk.reward.b.a r4 = com.mbridge.msdk.reward.b.a.this     // Catch:{ all -> 0x0143 }
                boolean r12 = r4.J     // Catch:{ all -> 0x0143 }
                java.lang.String r13 = ""
                java.lang.String r14 = ""
                long r4 = (long) r0     // Catch:{ all -> 0x0143 }
                r15 = r4
                com.mbridge.msdk.reward.c.a.a(r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0143 }
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this     // Catch:{ all -> 0x0143 }
                r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r2)     // Catch:{ all -> 0x0143 }
                goto L_0x014b
            L_0x0143:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                com.mbridge.msdk.foundation.tools.aa.d(r3, r0)
            L_0x014b:
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.b.a$c r0 = r0.t
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                java.lang.String r2 = r2.A
                com.mbridge.msdk.reward.b.a r3 = com.mbridge.msdk.reward.b.a.this
                java.lang.String r3 = r3.v
                r0.b(r2, r3)
                goto L_0x0602
            L_0x0162:
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.adapter.c r2 = r2.p
                r2.f((boolean) r6)
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.adapter.c r2 = r2.p
                boolean r2 = r2.g((boolean) r5)
                if (r2 == 0) goto L_0x0226
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.adapter.c r2 = r2.p
                boolean r2 = r2.c()
                if (r2 == 0) goto L_0x0201
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.b.a$c r2 = r2.t
                if (r2 == 0) goto L_0x0602
                com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r3, (java.lang.String) r9)
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.adapter.c r2 = r2.p
                r2.e((boolean) r5)
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this     // Catch:{ all -> 0x01e2 }
                com.mbridge.msdk.reward.adapter.c r2 = r2.p     // Catch:{ all -> 0x01e2 }
                java.util.concurrent.CopyOnWriteArrayList r2 = r2.e()     // Catch:{ all -> 0x01e2 }
                if (r2 == 0) goto L_0x01ea
                int r5 = r2.size()     // Catch:{ all -> 0x01e2 }
                if (r5 <= 0) goto L_0x01ea
                java.lang.Object r5 = r2.get(r6)     // Catch:{ all -> 0x01e2 }
                r8 = r5
                com.mbridge.msdk.foundation.entity.CampaignEx r8 = (com.mbridge.msdk.foundation.entity.CampaignEx) r8     // Catch:{ all -> 0x01e2 }
                com.mbridge.msdk.foundation.controller.b r5 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x01e2 }
                android.content.Context r9 = r5.g()     // Catch:{ all -> 0x01e2 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e2 }
                r5.<init>(r7)     // Catch:{ all -> 0x01e2 }
                r5.append(r0)     // Catch:{ all -> 0x01e2 }
                r5.append(r4)     // Catch:{ all -> 0x01e2 }
                java.lang.String r10 = r5.toString()     // Catch:{ all -> 0x01e2 }
                com.mbridge.msdk.reward.b.a r4 = com.mbridge.msdk.reward.b.a.this     // Catch:{ all -> 0x01e2 }
                java.lang.String r11 = r4.v     // Catch:{ all -> 0x01e2 }
                com.mbridge.msdk.reward.b.a r4 = com.mbridge.msdk.reward.b.a.this     // Catch:{ all -> 0x01e2 }
                boolean r12 = r4.J     // Catch:{ all -> 0x01e2 }
                java.lang.String r13 = ""
                java.lang.String r14 = ""
                long r4 = (long) r0     // Catch:{ all -> 0x01e2 }
                r15 = r4
                com.mbridge.msdk.reward.c.a.a(r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x01e2 }
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this     // Catch:{ all -> 0x01e2 }
                r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r2)     // Catch:{ all -> 0x01e2 }
                goto L_0x01ea
            L_0x01e2:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                com.mbridge.msdk.foundation.tools.aa.d(r3, r0)
            L_0x01ea:
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.b.a$c r0 = r0.t
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                java.lang.String r2 = r2.A
                com.mbridge.msdk.reward.b.a r3 = com.mbridge.msdk.reward.b.a.this
                java.lang.String r3 = r3.v
                r0.b(r2, r3)
                goto L_0x0602
            L_0x0201:
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.b.a$c r2 = r2.t
                if (r2 == 0) goto L_0x021b
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r8)
                r2.append(r0)
                r2.append(r4)
                java.lang.String r0 = r2.toString()
                com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r3, (java.lang.String) r0)
            L_0x021b:
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.adapter.c r0 = r0.p
                r0.f((boolean) r5)
                goto L_0x0602
            L_0x0226:
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.b.a$c r2 = r2.t
                if (r2 == 0) goto L_0x0602
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r8)
                r2.append(r0)
                r2.append(r4)
                java.lang.String r0 = r2.toString()
                com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r3, (java.lang.String) r0)
                goto L_0x0602
            L_0x0242:
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.adapter.c r2 = r2.p
                boolean r2 = r2.g((boolean) r5)
                java.lang.String r9 = " s"
                if (r2 == 0) goto L_0x0301
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.adapter.c r2 = r2.p
                boolean r2 = r2.c()
                if (r2 == 0) goto L_0x02dc
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.b.a$c r2 = r2.t
                if (r2 == 0) goto L_0x0602
                java.lang.String r2 = "load timeout task called for onVideoLoadSuccess by isReady but updateCampaignsLoadTimeoutState"
                com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r3, (java.lang.String) r2)
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.adapter.c r2 = r2.p
                r2.e((boolean) r5)
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this     // Catch:{ all -> 0x02bd }
                com.mbridge.msdk.reward.adapter.c r2 = r2.p     // Catch:{ all -> 0x02bd }
                java.util.concurrent.CopyOnWriteArrayList r2 = r2.e()     // Catch:{ all -> 0x02bd }
                if (r2 == 0) goto L_0x02c5
                int r5 = r2.size()     // Catch:{ all -> 0x02bd }
                if (r5 <= 0) goto L_0x02c5
                java.lang.Object r5 = r2.get(r6)     // Catch:{ all -> 0x02bd }
                r8 = r5
                com.mbridge.msdk.foundation.entity.CampaignEx r8 = (com.mbridge.msdk.foundation.entity.CampaignEx) r8     // Catch:{ all -> 0x02bd }
                com.mbridge.msdk.foundation.controller.b r5 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x02bd }
                android.content.Context r9 = r5.g()     // Catch:{ all -> 0x02bd }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x02bd }
                r5.<init>(r7)     // Catch:{ all -> 0x02bd }
                r5.append(r0)     // Catch:{ all -> 0x02bd }
                r5.append(r4)     // Catch:{ all -> 0x02bd }
                java.lang.String r10 = r5.toString()     // Catch:{ all -> 0x02bd }
                com.mbridge.msdk.reward.b.a r4 = com.mbridge.msdk.reward.b.a.this     // Catch:{ all -> 0x02bd }
                java.lang.String r11 = r4.v     // Catch:{ all -> 0x02bd }
                com.mbridge.msdk.reward.b.a r4 = com.mbridge.msdk.reward.b.a.this     // Catch:{ all -> 0x02bd }
                boolean r12 = r4.J     // Catch:{ all -> 0x02bd }
                java.lang.String r13 = ""
                java.lang.String r14 = ""
                long r4 = (long) r0     // Catch:{ all -> 0x02bd }
                r15 = r4
                com.mbridge.msdk.reward.c.a.a(r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x02bd }
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this     // Catch:{ all -> 0x02bd }
                r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r2)     // Catch:{ all -> 0x02bd }
                goto L_0x02c5
            L_0x02bd:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                com.mbridge.msdk.foundation.tools.aa.d(r3, r0)
            L_0x02c5:
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.b.a$c r0 = r0.t
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                java.lang.String r2 = r2.A
                com.mbridge.msdk.reward.b.a r3 = com.mbridge.msdk.reward.b.a.this
                java.lang.String r3 = r3.v
                r0.b(r2, r3)
                goto L_0x0602
            L_0x02dc:
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.b.a$c r2 = r2.t
                if (r2 == 0) goto L_0x02f6
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r8)
                r2.append(r0)
                r2.append(r9)
                java.lang.String r0 = r2.toString()
                com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r3, (java.lang.String) r0)
            L_0x02f6:
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.adapter.c r0 = r0.p
                r0.f((boolean) r5)
                goto L_0x0602
            L_0x0301:
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.b.a$c r2 = r2.t
                if (r2 == 0) goto L_0x0602
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r8)
                r2.append(r0)
                r2.append(r9)
                java.lang.String r0 = r2.toString()
                com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r3, (java.lang.String) r0)
                goto L_0x0602
            L_0x031d:
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.b.a$c r0 = r0.t
                if (r0 == 0) goto L_0x0602
                java.lang.String r0 = "load timeout task called for onVideoLoadFail by mRewardMvVideoAdapter is null exception"
                com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r3, (java.lang.String) r0)
                goto L_0x0602
            L_0x032c:
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                java.lang.String r2 = com.mbridge.msdk.foundation.tools.af.c()     // Catch:{ Exception -> 0x034e }
                java.lang.String r9 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r2)     // Catch:{ Exception -> 0x034e }
                java.lang.String r2 = "local_rid"
                r0.put(r2, r9)     // Catch:{ Exception -> 0x034e }
                java.lang.String r7 = "2000123"
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x034e }
                java.lang.String r8 = r2.v     // Catch:{ Exception -> 0x034e }
                java.lang.String r10 = "auto_load"
                r11 = 94
                r12 = 0
                com.mbridge.msdk.reward.c.a.a(r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x034e }
            L_0x034e:
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                r2.a((boolean) r6, (java.util.Map<java.lang.String, java.lang.String>) r0)
                goto L_0x0602
            L_0x0355:
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.videocommon.listener.InterVideoOutListener r2 = r2.s
                if (r2 == 0) goto L_0x0602
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                boolean r2 = r2.M
                if (r2 == 0) goto L_0x0602
                java.lang.Object r2 = r0.obj
                boolean r3 = r2 instanceof java.lang.String
                if (r3 == 0) goto L_0x036e
                r2.toString()
            L_0x036e:
                android.os.Bundle r0 = r18.getData()
                if (r0 == 0) goto L_0x0385
                java.lang.String r2 = com.mbridge.msdk.MBridgeConstans.PLACEMENT_ID
                boolean r2 = r0.containsKey(r2)
                if (r2 == 0) goto L_0x0385
                java.lang.String r2 = com.mbridge.msdk.MBridgeConstans.PLACEMENT_ID
                java.lang.String r2 = r0.getString(r2)
                android.text.TextUtils.isEmpty(r2)
            L_0x0385:
                if (r0 == 0) goto L_0x0393
                java.lang.String r2 = "is_cached_campaign"
                boolean r3 = r0.containsKey(r2)
                if (r3 == 0) goto L_0x0393
                boolean r6 = r0.getBoolean(r2, r6)
            L_0x0393:
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x03c8 }
                boolean r0 = r0.J     // Catch:{ Exception -> 0x03c8 }
                if (r0 == 0) goto L_0x03a0
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x03c8 }
                com.mbridge.msdk.reward.b.a.j(r0)     // Catch:{ Exception -> 0x03c8 }
            L_0x03a0:
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x03c8 }
                com.mbridge.msdk.out.MBridgeIds r0 = r0.w     // Catch:{ Exception -> 0x03c8 }
                if (r0 == 0) goto L_0x03b1
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x03c8 }
                com.mbridge.msdk.out.MBridgeIds r0 = r0.w     // Catch:{ Exception -> 0x03c8 }
                r0.setCache(r6)     // Catch:{ Exception -> 0x03c8 }
            L_0x03b1:
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x03c8 }
                com.mbridge.msdk.videocommon.listener.InterVideoOutListener r0 = r0.s     // Catch:{ Exception -> 0x03c8 }
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x03c8 }
                java.lang.String r2 = r2.y     // Catch:{ Exception -> 0x03c8 }
                com.mbridge.msdk.reward.b.a r3 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x03c8 }
                com.mbridge.msdk.out.MBridgeIds r3 = r3.w     // Catch:{ Exception -> 0x03c8 }
                r0.onLoadSuccess(r2, r3)     // Catch:{ Exception -> 0x03c8 }
                goto L_0x0602
            L_0x03c8:
                r0 = move-exception
                boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG
                if (r2 == 0) goto L_0x0602
                r0.printStackTrace()
                goto L_0x0602
            L_0x03d2:
                com.mbridge.msdk.reward.b.a r6 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.videocommon.listener.InterVideoOutListener r6 = r6.s
                if (r6 == 0) goto L_0x0602
                com.mbridge.msdk.reward.b.a r6 = com.mbridge.msdk.reward.b.a.this
                boolean r6 = r6.M
                if (r6 == 0) goto L_0x0602
                java.lang.Object r6 = r0.obj
                boolean r7 = r6 instanceof java.lang.String
                if (r7 == 0) goto L_0x03ed
                java.lang.String r6 = r6.toString()
                goto L_0x03ef
            L_0x03ed:
                java.lang.String r6 = ""
            L_0x03ef:
                r12 = r6
                com.mbridge.msdk.reward.b.a r6 = com.mbridge.msdk.reward.b.a.this
                java.lang.String r6 = r6.v
                com.mbridge.msdk.videocommon.a.c(r6)
                com.mbridge.msdk.videocommon.a.a()
                com.mbridge.msdk.reward.b.a r6 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x04a7 }
                boolean r6 = r6.J     // Catch:{ Exception -> 0x04a7 }
                if (r6 == 0) goto L_0x0409
                com.mbridge.msdk.reward.b.a r6 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x04a7 }
                com.mbridge.msdk.reward.b.a.j(r6)     // Catch:{ Exception -> 0x04a7 }
            L_0x0409:
                com.mbridge.msdk.reward.b.a r6 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x04a7 }
                java.lang.String r6 = r6.x     // Catch:{ Exception -> 0x04a7 }
                boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x04a7 }
                if (r6 == 0) goto L_0x0422
                com.mbridge.msdk.reward.b.a r6 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x04a7 }
                com.mbridge.msdk.out.MBridgeIds r7 = r6.w     // Catch:{ Exception -> 0x04a7 }
                java.lang.String r7 = r7.getLocalRequestId()     // Catch:{ Exception -> 0x04a7 }
                java.lang.String unused = r6.x = r7     // Catch:{ Exception -> 0x04a7 }
            L_0x0422:
                com.mbridge.msdk.foundation.tools.ac r6 = com.mbridge.msdk.foundation.tools.ac.a()     // Catch:{ Exception -> 0x04a7 }
                boolean r4 = r6.a((java.lang.String) r4, (boolean) r5)     // Catch:{ Exception -> 0x04a7 }
                if (r4 == 0) goto L_0x0496
                com.mbridge.msdk.reward.b.a r4 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x04a7 }
                java.lang.String r4 = r4.x     // Catch:{ Exception -> 0x04a7 }
                android.os.Bundle r0 = r18.getData()     // Catch:{ Exception -> 0x04a7 }
                if (r0 == 0) goto L_0x044a
                boolean r5 = r0.containsKey(r2)     // Catch:{ Exception -> 0x04a7 }
                if (r5 == 0) goto L_0x044a
                java.lang.String r0 = r0.getString(r2)     // Catch:{ Exception -> 0x04a7 }
                boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x04a7 }
                if (r2 != 0) goto L_0x044a
                r9 = r0
                goto L_0x044b
            L_0x044a:
                r9 = r4
            L_0x044b:
                com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x04a7 }
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x04a7 }
                java.lang.String r2 = r2.v     // Catch:{ Exception -> 0x04a7 }
                com.mbridge.msdk.foundation.entity.e r0 = r0.a((java.lang.String) r2, (java.lang.String) r12)     // Catch:{ Exception -> 0x04a7 }
                if (r0 == 0) goto L_0x046a
                java.lang.String r2 = r0.c()     // Catch:{ Exception -> 0x04a7 }
                boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x04a7 }
                if (r2 != 0) goto L_0x046a
                java.lang.String r0 = r0.c()     // Catch:{ Exception -> 0x04a7 }
                goto L_0x046b
            L_0x046a:
                r0 = r12
            L_0x046b:
                r2 = 18
                if (r3 != r2) goto L_0x0480
                com.mbridge.msdk.foundation.same.report.m r7 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x04a7 }
                java.lang.String r8 = "2000047"
                r10 = 0
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x04a7 }
                java.lang.String r11 = r2.v     // Catch:{ Exception -> 0x04a7 }
                r7.a((java.lang.String) r8, (java.lang.String) r9, (java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r10, (java.lang.String) r11, (java.lang.String) r12)     // Catch:{ Exception -> 0x04a7 }
                goto L_0x0495
            L_0x0480:
                com.mbridge.msdk.foundation.same.report.m r7 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x04a7 }
                java.lang.String r8 = "2000047"
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x04a7 }
                java.util.List r10 = r2.R     // Catch:{ Exception -> 0x04a7 }
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x04a7 }
                java.lang.String r11 = r2.v     // Catch:{ Exception -> 0x04a7 }
                r7.a((java.lang.String) r8, (java.lang.String) r9, (java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r10, (java.lang.String) r11, (java.lang.String) r12)     // Catch:{ Exception -> 0x04a7 }
            L_0x0495:
                r12 = r0
            L_0x0496:
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x04a7 }
                com.mbridge.msdk.videocommon.listener.InterVideoOutListener r0 = r0.s     // Catch:{ Exception -> 0x04a7 }
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x04a7 }
                com.mbridge.msdk.out.MBridgeIds r2 = r2.w     // Catch:{ Exception -> 0x04a7 }
                r0.onVideoLoadFail(r2, r12)     // Catch:{ Exception -> 0x04a7 }
                goto L_0x0602
            L_0x04a7:
                r0 = move-exception
                boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG
                if (r2 == 0) goto L_0x0602
                r0.printStackTrace()
                goto L_0x0602
            L_0x04b1:
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.videocommon.listener.InterVideoOutListener r2 = r2.s
                if (r2 == 0) goto L_0x0602
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                boolean r2 = r2.M
                if (r2 == 0) goto L_0x0602
                java.lang.Object r2 = r0.obj
                boolean r3 = r2 instanceof java.lang.String
                if (r3 == 0) goto L_0x04ca
                r2.toString()
            L_0x04ca:
                android.os.Bundle r0 = r18.getData()
                if (r0 == 0) goto L_0x04e1
                java.lang.String r2 = com.mbridge.msdk.MBridgeConstans.PLACEMENT_ID
                boolean r2 = r0.containsKey(r2)
                if (r2 == 0) goto L_0x04e1
                java.lang.String r2 = com.mbridge.msdk.MBridgeConstans.PLACEMENT_ID
                java.lang.String r0 = r0.getString(r2)
                android.text.TextUtils.isEmpty(r0)
            L_0x04e1:
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x0542 }
                boolean r0 = r0.J     // Catch:{ Exception -> 0x0542 }
                if (r0 == 0) goto L_0x04ee
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x0542 }
                com.mbridge.msdk.reward.b.a.j(r0)     // Catch:{ Exception -> 0x0542 }
            L_0x04ee:
                com.mbridge.msdk.foundation.tools.ac r0 = com.mbridge.msdk.foundation.tools.ac.a()     // Catch:{ Exception -> 0x0542 }
                boolean r0 = r0.a((java.lang.String) r4, (boolean) r5)     // Catch:{ Exception -> 0x0542 }
                if (r0 == 0) goto L_0x051a
                com.mbridge.msdk.foundation.same.report.m r2 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x0542 }
                java.lang.String r3 = "2000048"
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x0542 }
                com.mbridge.msdk.out.MBridgeIds r0 = r0.w     // Catch:{ Exception -> 0x0542 }
                java.lang.String r4 = r0.getLocalRequestId()     // Catch:{ Exception -> 0x0542 }
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x0542 }
                java.util.List r5 = r0.R     // Catch:{ Exception -> 0x0542 }
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x0542 }
                java.lang.String r6 = r0.v     // Catch:{ Exception -> 0x0542 }
                java.lang.String r7 = ""
                r2.a((java.lang.String) r3, (java.lang.String) r4, (java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r5, (java.lang.String) r6, (java.lang.String) r7)     // Catch:{ Exception -> 0x0542 }
                goto L_0x0531
            L_0x051a:
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x0542 }
                android.content.Context r0 = r0.n     // Catch:{ Exception -> 0x0542 }
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x0542 }
                java.util.List r2 = r2.R     // Catch:{ Exception -> 0x0542 }
                com.mbridge.msdk.reward.b.a r3 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x0542 }
                java.lang.String r3 = r3.v     // Catch:{ Exception -> 0x0542 }
                r4 = 0
                com.mbridge.msdk.reward.c.a.a(r0, r2, r3, r4)     // Catch:{ Exception -> 0x0542 }
            L_0x0531:
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x0542 }
                com.mbridge.msdk.videocommon.listener.InterVideoOutListener r0 = r0.s     // Catch:{ Exception -> 0x0542 }
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x0542 }
                com.mbridge.msdk.out.MBridgeIds r2 = r2.w     // Catch:{ Exception -> 0x0542 }
                r0.onVideoLoadSuccess(r2)     // Catch:{ Exception -> 0x0542 }
                goto L_0x0602
            L_0x0542:
                r0 = move-exception
                boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG
                if (r2 == 0) goto L_0x0602
                r0.printStackTrace()
                goto L_0x0602
            L_0x054c:
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this
                java.util.concurrent.CopyOnWriteArrayList r0 = r0.ae
                if (r0 == 0) goto L_0x0602
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this
                java.util.concurrent.CopyOnWriteArrayList r0 = r0.ae
                int r0 = r0.size()
                if (r0 <= 0) goto L_0x0602
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this
                java.util.List r0 = r0.af
                if (r0 == 0) goto L_0x058a
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this
                java.util.List r0 = r0.af
                int r0 = r0.size()
                if (r0 <= 0) goto L_0x058a
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this
                java.util.List r0 = r0.af
                java.lang.Object r0 = r0.get(r6)
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
                java.lang.String r0 = r0.getCMPTEntryUrl()
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                r0 = r0 ^ r5
                goto L_0x058b
            L_0x058a:
                r0 = 0
            L_0x058b:
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                java.util.concurrent.CopyOnWriteArrayList r2 = r2.ae
                java.lang.Object r2 = r2.get(r6)
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = (com.mbridge.msdk.foundation.entity.CampaignEx) r2
                int r2 = r2.getNscpt()
                com.mbridge.msdk.reward.b.a r3 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.adapter.c r3 = r3.p
                if (r3 == 0) goto L_0x05db
                com.mbridge.msdk.reward.b.a r3 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.adapter.c r3 = r3.p
                com.mbridge.msdk.reward.b.a r4 = com.mbridge.msdk.reward.b.a.this
                java.util.concurrent.CopyOnWriteArrayList r4 = r4.ae
                boolean r0 = r3.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r4, (boolean) r0, (int) r2)
                if (r0 == 0) goto L_0x05db
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.b.a$c r0 = r0.t
                if (r0 == 0) goto L_0x0602
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this
                boolean r0 = r0.M
                if (r0 == 0) goto L_0x0602
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.b.a$c r0 = r0.t
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this
                java.lang.String r2 = r2.A
                com.mbridge.msdk.reward.b.a r3 = com.mbridge.msdk.reward.b.a.this
                java.lang.String r3 = r3.v
                r0.a((java.lang.String) r2, (java.lang.String) r3)
                goto L_0x0602
            L_0x05db:
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.b.a$c r0 = r0.t
                if (r0 == 0) goto L_0x0602
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this
                boolean r0 = r0.M
                if (r0 == 0) goto L_0x0602
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this
                java.lang.String r0 = r0.v
                com.mbridge.msdk.videocommon.a.c(r0)
                com.mbridge.msdk.videocommon.a.a()
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this
                com.mbridge.msdk.reward.b.a$c r0 = r0.t
                java.lang.String r2 = "load timeout"
                com.mbridge.msdk.reward.b.a.c.a((com.mbridge.msdk.reward.b.a.c) r0, (java.lang.String) r2, (boolean) r5)
            L_0x0602:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.AnonymousClass1.handleMessage(android.os.Message):void");
        }
    };
    /* access modifiers changed from: private */
    public int E = 2;
    private int F;
    private int G;
    private int H;
    /* access modifiers changed from: private */
    public boolean I = false;
    /* access modifiers changed from: private */
    public boolean J = false;
    private boolean K = false;
    private boolean L = false;
    /* access modifiers changed from: private */
    public boolean M;
    /* access modifiers changed from: private */
    public boolean N = false;
    /* access modifiers changed from: private */
    public ArrayList<Integer> O = new ArrayList<>(7);
    /* access modifiers changed from: private */
    public boolean P = false;
    private final Object Q = new Object();
    /* access modifiers changed from: private */
    public List<CampaignEx> R = new ArrayList();
    private Queue<Integer> U;
    private String V;
    /* access modifiers changed from: private */
    public h W = null;
    private volatile boolean X = true;
    private volatile boolean Y = false;
    /* access modifiers changed from: private */
    public volatile boolean Z = false;
    b a;
    /* access modifiers changed from: private */
    public volatile boolean aa = false;
    /* access modifiers changed from: private */
    public volatile boolean ab = false;
    /* access modifiers changed from: private */
    public volatile boolean ac = false;
    /* access modifiers changed from: private */
    public volatile boolean ad = false;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<CampaignEx> ae;
    /* access modifiers changed from: private */
    public List<CampaignEx> af;
    public boolean e = false;
    volatile boolean i = false;
    volatile boolean j = false;
    volatile boolean k = false;
    volatile boolean l = false;
    volatile boolean m = false;
    /* access modifiers changed from: private */
    public Context n;
    /* access modifiers changed from: private */
    public int o;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.reward.adapter.c p;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.videocommon.d.c q;
    private com.mbridge.msdk.videocommon.d.a r;
    /* access modifiers changed from: private */
    public volatile InterVideoOutListener s;
    /* access modifiers changed from: private */
    public volatile c t;
    private String u;
    /* access modifiers changed from: private */
    public String v;
    /* access modifiers changed from: private */
    public MBridgeIds w;
    /* access modifiers changed from: private */
    public String x = "";
    /* access modifiers changed from: private */
    public String y = "";
    private String z;

    public final void a(boolean z2) {
        this.I = z2;
    }

    public final void b(boolean z2) {
        this.J = z2;
    }

    public final void a(int i2) {
        this.E = i2;
    }

    public final String a() {
        com.mbridge.msdk.reward.adapter.c cVar = this.p;
        return cVar != null ? cVar.a(this.P) : "";
    }

    public final String b() {
        com.mbridge.msdk.reward.adapter.c cVar = this.p;
        return cVar != null ? cVar.a() : "";
    }

    public final void a(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str)) {
            Context context = this.n;
            ai.a(context, "MBridge_ConfirmTitle" + this.v, str.trim());
        }
        if (!TextUtils.isEmpty(str2)) {
            Context context2 = this.n;
            ai.a(context2, "MBridge_ConfirmContent" + this.v, str2.trim());
        }
        if (!TextUtils.isEmpty(str4)) {
            Context context3 = this.n;
            ai.a(context3, "MBridge_CancelText" + this.v, str4.trim());
        }
        if (!TextUtils.isEmpty(str3)) {
            Context context4 = this.n;
            ai.a(context4, "MBridge_ConfirmText" + this.v, str3.trim());
        }
    }

    public final void c(boolean z2) {
        this.N = z2;
    }

    public final void a(int i2, int i3, int i4) {
        this.F = i2;
        this.G = i3;
        if (i3 == com.mbridge.msdk.foundation.same.a.r) {
            this.H = i4 < 0 ? 5 : i4;
        }
        if (this.G == com.mbridge.msdk.foundation.same.a.q) {
            this.H = i4 < 0 ? 80 : i4;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            int i5 = 1;
            jSONObject.put("ivRewardEnable", 1);
            jSONObject.put("ivRewardMode", i2 == com.mbridge.msdk.foundation.same.a.o ? 0 : 1);
            if (i3 == com.mbridge.msdk.foundation.same.a.q) {
                i5 = 0;
            }
            jSONObject.put("ivRewardPlayValueMode", i5);
            jSONObject.put("ivRewardPlayValue", i4);
            f.a();
            String str = this.v;
            String jSONObject2 = jSONObject.toString();
            com.mbridge.msdk.foundation.a.a.a a2 = com.mbridge.msdk.foundation.a.a.a.a();
            a2.a("ivreward_" + str, jSONObject2);
        } catch (Exception unused) {
            aa.d("RewardVideoController", "setIVRewardEnable to SP was ERROR");
        }
    }

    public static void a(String str, int i2) {
        try {
            if (S != null && ak.b(str)) {
                S.put(str, Integer.valueOf(i2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int a(String str) {
        ConcurrentHashMap<String, Integer> concurrentHashMap;
        Integer num;
        try {
            if (!ak.b(str) || (concurrentHashMap = S) == null || !concurrentHashMap.containsKey(str) || (num = S.get(str)) == null) {
                return 0;
            }
            return num.intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static void a(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (concurrentHashMap = T) != null && !concurrentHashMap.containsKey(str)) {
            T.put(str, str2);
        }
    }

    public final void c() {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (this.P && (concurrentHashMap = T) != null && !concurrentHashMap.containsKey(a())) {
            T.remove(a());
        }
    }

    public static void insertExcludeId(String str, CampaignEx campaignEx) {
        if (!TextUtils.isEmpty(str) && campaignEx != null && com.mbridge.msdk.foundation.controller.b.d().g() != null) {
            j a2 = j.a((g) h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
            com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
            fVar.a(System.currentTimeMillis());
            fVar.b(str);
            fVar.a(campaignEx.getId());
            a2.a(fVar);
        }
    }

    /* compiled from: RewardVideoController */
    private final class d implements com.mbridge.msdk.video.bt.module.b.h {
        /* access modifiers changed from: private */
        public a b;
        private int c;
        private Handler d;
        private int e;

        private d(a aVar, int i, Handler handler) {
            this.e = 0;
            this.b = aVar;
            this.c = i;
            this.d = handler;
        }

        public final void a() {
            String str;
            a.this.e = false;
            try {
                com.mbridge.msdk.reward.a.a aVar = new com.mbridge.msdk.reward.a.a(a.this.v, a.this.I);
                a aVar2 = this.b;
                if (aVar2 == null || aVar2.p == null) {
                    str = "";
                } else {
                    str = this.b.p.b;
                }
                aVar.a(a.c, str, 3, a.d);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                a aVar3 = this.b;
                if (aVar3 != null) {
                    boolean unused = aVar3.P = true;
                    if (this.b.p != null) {
                        this.b.p.b = "";
                    }
                    com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable(this.c) {
                        final /* synthetic */ int a;

                        {
                            this.a = r2;
                        }

                        public final void run() {
                            try {
                                if (a.this.W == null) {
                                    h unused = a.this.W = h.a(com.mbridge.msdk.foundation.controller.b.d().g());
                                }
                                i a2 = i.a((g) a.this.W);
                                if (a2 != null) {
                                    a2.a(a.this.v);
                                }
                            } catch (Throwable unused2) {
                                aa.d("RewardVideoController", "can't find DailyPlayCapDao");
                            }
                            if (this.a == 1) {
                                Context m = a.this.n;
                                ai.a(m, a.this.A + "_" + this.a, Integer.valueOf(a.this.o + 1));
                            }
                        }
                    });
                    if (a.this.J) {
                        a.j(a.this);
                    }
                    if (this.b.s != null) {
                        if (TextUtils.isEmpty(a.b) && !TextUtils.isEmpty(a.g)) {
                            a.b = a.g;
                        }
                        this.b.s.onAdShow(a.b, a.this.w);
                        this.e = 2;
                    }
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }

        public final void a(boolean z, com.mbridge.msdk.videocommon.b.c cVar) {
            try {
                a aVar = this.b;
                if (aVar != null && aVar.s != null) {
                    if (cVar == null) {
                        cVar = com.mbridge.msdk.videocommon.b.c.b(this.b.B);
                    }
                    if (a.this.J) {
                        a.j(a.this);
                        a.this.c();
                        com.mbridge.msdk.foundation.same.a.d.d(a.this.v, a.this.a());
                    }
                    RewardInfo rewardInfo = new RewardInfo(z, cVar.a(), String.valueOf(cVar.b()));
                    if (TextUtils.isEmpty(a.b) && !TextUtils.isEmpty(a.g)) {
                        a.b = a.g;
                    }
                    this.b.s.onAdClose(a.b, a.this.w, rewardInfo);
                    this.e = 7;
                    boolean unused = this.b.P = false;
                    a.this.O.clear();
                    this.b = null;
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|(1:14)|15|16|22|31) */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0081, code lost:
            r13 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0084, code lost:
            if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x0086;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0086, code lost:
            r13.printStackTrace();
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x006f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(java.lang.String r13) {
            /*
                r12 = this;
                java.lang.String r0 = "show failed: "
                r1 = 0
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x008d }
                r2.e = r1     // Catch:{ Exception -> 0x008d }
                com.mbridge.msdk.reward.b.a r2 = r12.b     // Catch:{ Exception -> 0x008d }
                if (r2 == 0) goto L_0x0097
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x008d }
                boolean r2 = r2.J     // Catch:{ Exception -> 0x008d }
                if (r2 == 0) goto L_0x0018
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x008d }
                com.mbridge.msdk.reward.b.a.j(r2)     // Catch:{ Exception -> 0x008d }
            L_0x0018:
                com.mbridge.msdk.reward.b.a r2 = r12.b     // Catch:{ Exception -> 0x008d }
                boolean unused = r2.P = r1     // Catch:{ Exception -> 0x008d }
                com.mbridge.msdk.reward.b.a r2 = r12.b     // Catch:{ Exception -> 0x008d }
                com.mbridge.msdk.videocommon.listener.InterVideoOutListener r2 = r2.s     // Catch:{ Exception -> 0x008d }
                if (r2 == 0) goto L_0x0097
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x006f }
                java.util.concurrent.CopyOnWriteArrayList r2 = r2.ae     // Catch:{ Exception -> 0x006f }
                if (r2 == 0) goto L_0x006f
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x006f }
                java.util.concurrent.CopyOnWriteArrayList r2 = r2.ae     // Catch:{ Exception -> 0x006f }
                int r2 = r2.size()     // Catch:{ Exception -> 0x006f }
                if (r2 <= 0) goto L_0x006f
                com.mbridge.msdk.reward.b.a r2 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x006f }
                java.util.concurrent.CopyOnWriteArrayList r2 = r2.ae     // Catch:{ Exception -> 0x006f }
                java.lang.Object r2 = r2.get(r1)     // Catch:{ Exception -> 0x006f }
                r3 = r2
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = (com.mbridge.msdk.foundation.entity.CampaignEx) r3     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.foundation.controller.b r2 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x006f }
                android.content.Context r4 = r2.g()     // Catch:{ Exception -> 0x006f }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006f }
                r2.<init>(r0)     // Catch:{ Exception -> 0x006f }
                r2.append(r13)     // Catch:{ Exception -> 0x006f }
                java.lang.String r5 = r2.toString()     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x006f }
                java.lang.String r6 = r0.v     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.reward.b.a r0 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x006f }
                boolean r7 = r0.J     // Catch:{ Exception -> 0x006f }
                java.lang.String r8 = ""
                java.lang.String r9 = ""
                r10 = 0
                com.mbridge.msdk.reward.c.a.a(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x006f }
            L_0x006f:
                com.mbridge.msdk.reward.b.a r0 = r12.b     // Catch:{ Exception -> 0x0081 }
                com.mbridge.msdk.videocommon.listener.InterVideoOutListener r0 = r0.s     // Catch:{ Exception -> 0x0081 }
                java.lang.String r2 = com.mbridge.msdk.reward.b.a.b     // Catch:{ Exception -> 0x0081 }
                com.mbridge.msdk.reward.b.a r3 = com.mbridge.msdk.reward.b.a.this     // Catch:{ Exception -> 0x0081 }
                com.mbridge.msdk.out.MBridgeIds r3 = r3.w     // Catch:{ Exception -> 0x0081 }
                r0.onShowFail(r2, r3, r13)     // Catch:{ Exception -> 0x0081 }
                goto L_0x0089
            L_0x0081:
                r13 = move-exception
                boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x008d }
                if (r0 == 0) goto L_0x0089
                r13.printStackTrace()     // Catch:{ Exception -> 0x008d }
            L_0x0089:
                r13 = 4
                r12.e = r13     // Catch:{ Exception -> 0x008d }
                goto L_0x0097
            L_0x008d:
                r13 = move-exception
                r12.e = r1
                boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
                if (r0 == 0) goto L_0x0097
                r13.printStackTrace()
            L_0x0097:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.d.a(java.lang.String):void");
        }

        public final void a(boolean z, String str, String str2) {
            try {
                a aVar = this.b;
                if (aVar != null && aVar.s != null) {
                    if (a.this.J) {
                        a.j(a.this);
                    }
                    boolean unused = this.b.P = false;
                    try {
                        this.b.s.onVideoAdClicked(z, a.this.w);
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                }
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    e3.printStackTrace();
                }
            }
        }

        public final void a(String str, String str2) {
            try {
                a aVar = this.b;
                if (aVar != null && aVar.s != null) {
                    try {
                        this.b.s.onVideoComplete(a.this.w);
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                    this.e = 5;
                }
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    e3.printStackTrace();
                }
            }
        }

        public final void a(boolean z, int i) {
            try {
                a aVar = this.b;
                if (aVar != null && aVar.s != null) {
                    try {
                        this.b.s.onAdCloseWithIVReward(a.this.w, new RewardInfo(z, i));
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                }
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    e3.printStackTrace();
                }
            }
        }

        public final void b(String str, String str2) {
            try {
                a aVar = this.b;
                if (aVar != null && aVar.s != null) {
                    try {
                        this.b.s.onEndcardShow(a.this.w);
                        com.mbridge.msdk.foundation.c.b a2 = com.mbridge.msdk.foundation.c.b.a();
                        a2.b(str2 + "_2", 2);
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                    this.e = 6;
                }
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    e3.printStackTrace();
                }
            }
        }

        public final void a(int i, String str, String str2) {
            this.e = i;
            a aVar = this.b;
            if (aVar != null && !aVar.J && !this.b.I && this.b.q != null && this.b.q.s(this.e) && this.b.t != null && this.b.t.c.get() != 1 && this.b.t.c.get() != 3 && !a.this.O.contains(Integer.valueOf(this.e))) {
                a.this.O.add(Integer.valueOf(this.e));
                int B = this.b.q.B() * 1000;
                if (this.e == 4) {
                    B = 3000;
                }
                Handler handler = this.d;
                if (handler != null) {
                    handler.removeMessages(1001001);
                    this.d.sendEmptyMessageDelayed(1001001, (long) B);
                    return;
                }
                final HashMap hashMap = new HashMap();
                try {
                    String md5 = SameMD5.getMD5(af.c());
                    hashMap.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, md5);
                    com.mbridge.msdk.reward.c.a.a("2000123", a.this.v, md5, "auto_load", 94, false);
                } catch (Exception unused) {
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public final void run() {
                        if (d.this.b != null) {
                            d.this.b.a(false, (Map<String, String>) hashMap);
                        }
                    }
                }, (long) B);
            }
        }
    }

    public final void a(InterVideoOutListener interVideoOutListener) {
        this.s = interVideoOutListener;
        this.t = new c(interVideoOutListener, this.D, this.v);
    }

    public final void b(String str, String str2) {
        try {
            this.n = com.mbridge.msdk.foundation.controller.b.d().g();
            this.v = str2;
            this.A = str;
            this.w = new MBridgeIds(this.A, this.v);
            if (!TextUtils.isEmpty(b)) {
                this.w.setLocalRequestId(b);
            }
            this.r = com.mbridge.msdk.videocommon.d.b.a().b();
            com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() {
                public final void run() {
                    CopyOnWriteArrayList<CampaignEx> a2;
                    if (a.this.n != null && !TextUtils.isEmpty(a.this.v)) {
                        try {
                            com.mbridge.msdk.reward.c.a.a(a.this.n, a.this.v);
                            y.b();
                            y.c(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_RES));
                            y.c(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML));
                            com.mbridge.msdk.videocommon.d.b.a().b(a.this.v);
                            if (!ac.a().a("c_d_v_w_i", false) && !TextUtils.isEmpty(a.this.v) && (a2 = com.mbridge.msdk.videocommon.a.a.a().a(a.this.v, 1)) != null && a2.size() > 0) {
                                com.mbridge.msdk.videocommon.download.c.getInstance().createUnitCache(a.this.n, a.this.v, a2, 94, (com.mbridge.msdk.videocommon.listener.a) null);
                            }
                        } catch (Exception e) {
                            if (MBridgeConstans.DEBUG) {
                                aa.b("RewardVideoController", "initRewardVideoController task ", e);
                            }
                        }
                    }
                }
            });
            if (this.W == null) {
                this.W = h.a(com.mbridge.msdk.foundation.controller.b.d().g());
            }
        } catch (Throwable th) {
            aa.b("RewardVideoController", th.getMessage(), th);
        }
    }

    public final void a(boolean z2, Map<String, String> map) {
        a(z2, "", map);
    }

    private void d() {
        com.mbridge.msdk.foundation.db.f.a((g) h.a(this.n)).a(this.v);
    }

    private void e() {
        try {
            List<CampaignEx> b2 = com.mbridge.msdk.foundation.db.f.a((g) h.a(this.n)).b(this.v);
            if (b2 != null && b2.size() > 0) {
                for (CampaignEx next : b2) {
                    if (!TextUtils.isEmpty(next.getCMPTEntryUrl())) {
                        com.mbridge.msdk.videocommon.a.b(this.v + "_" + next.getRequestId() + "_" + next.getCMPTEntryUrl());
                        if (next.getRewardTemplateMode() != null && !TextUtils.isEmpty(next.getRewardTemplateMode().e())) {
                            com.mbridge.msdk.videocommon.a.b(this.v + "_" + next.getId() + "_" + next.getRequestId() + "_" + next.getRewardTemplateMode().e());
                        }
                    } else {
                        com.mbridge.msdk.videocommon.a.b(next.getAdType(), next);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:101|102|103|104|(1:108)|109|110|(1:114)|120|(2:122|147)(1:144)) */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x027b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x027e, code lost:
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x0280;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0280, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:109:0x0254 */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0287 A[Catch:{ Exception -> 0x028d }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r30, java.lang.String r31, java.util.Map<java.lang.String, java.lang.String> r32) {
        /*
            r29 = this;
            r7 = r29
            r8 = r30
            r9 = r32
            java.lang.String r10 = "load exception"
            java.lang.String r11 = "bidToken is empty"
            java.lang.String r0 = "init error"
            java.lang.String r12 = "load exception: "
            com.mbridge.msdk.reward.b.a$c r1 = r7.t
            if (r1 != 0) goto L_0x0022
            com.mbridge.msdk.reward.b.a$c r13 = new com.mbridge.msdk.reward.b.a$c
            r3 = 0
            android.os.Handler r4 = r7.D
            java.lang.String r5 = r7.v
            r6 = 0
            r1 = r13
            r2 = r29
            r1.<init>(r3, r4, r5)
            r7.t = r13
        L_0x0022:
            com.mbridge.msdk.reward.b.a$c r1 = r7.t
            r2 = 0
            r3 = 1
            java.lang.String r4 = "local_rid"
            if (r1 == 0) goto L_0x0078
            com.mbridge.msdk.reward.b.a$c r1 = r7.t
            int r1 = r1.c.get()
            if (r1 != r3) goto L_0x0078
            boolean r0 = r7.M
            if (r0 == 0) goto L_0x0073
            if (r8 == 0) goto L_0x0077
            com.mbridge.msdk.foundation.entity.e r0 = new com.mbridge.msdk.foundation.entity.e
            r1 = 16
            java.lang.String r3 = "errorCode: 3501 errorMessage: current unit is loading"
            r0.<init>(r1, r3)
            if (r9 == 0) goto L_0x005a
            boolean r1 = r9.containsKey(r4)     // Catch:{ Exception -> 0x0059 }
            if (r1 == 0) goto L_0x005a
            r10 = 0
            android.content.Context r11 = r7.n     // Catch:{ Exception -> 0x0059 }
            java.lang.String r13 = r7.v     // Catch:{ Exception -> 0x0059 }
            boolean r14 = r7.J     // Catch:{ Exception -> 0x0059 }
            java.lang.String r15 = ""
            java.lang.String r16 = ""
            r12 = r0
            com.mbridge.msdk.reward.c.a.a(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x0059 }
            goto L_0x005a
        L_0x0059:
        L_0x005a:
            if (r9 == 0) goto L_0x0069
            boolean r1 = r9.containsKey(r4)
            if (r1 == 0) goto L_0x0069
            java.lang.Object r1 = r9.get(r4)
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2
        L_0x0069:
            com.mbridge.msdk.reward.b.a$c r1 = r7.t
            java.lang.String r0 = r0.e()
            r1.c(r0, r2)
            goto L_0x0077
        L_0x0073:
            if (r8 == 0) goto L_0x0077
            r7.M = r8
        L_0x0077:
            return
        L_0x0078:
            if (r9 == 0) goto L_0x0088
            boolean r1 = r9.containsKey(r4)
            if (r1 == 0) goto L_0x0088
            java.lang.Object r1 = r9.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            r7.x = r1
        L_0x0088:
            com.mbridge.msdk.reward.b.a$c r1 = r7.t
            r5 = 0
            if (r1 == 0) goto L_0x0099
            com.mbridge.msdk.reward.b.a$c r1 = r7.t
            int r1 = r1.c.get()
            r6 = 3
            if (r1 != r6) goto L_0x0099
            r7.X = r5
            goto L_0x00a4
        L_0x0099:
            r7.X = r3
            com.mbridge.msdk.reward.b.a$c r1 = r7.t
            if (r1 == 0) goto L_0x00a4
            com.mbridge.msdk.reward.b.a$c r1 = r7.t
            r1.c.set(r3)
        L_0x00a4:
            r7.M = r8
            android.os.Handler r1 = r7.D
            r6 = 1001001(0xf4629, float:1.402701E-39)
            r1.removeMessages(r6)
            r7.aa = r5
            r7.Z = r5
            r7.ab = r5
            r7.ac = r5
            r29.e()
            r29.d()
            com.mbridge.msdk.reward.adapter.b.a()
            boolean r1 = android.text.TextUtils.isEmpty(r31)     // Catch:{ Exception -> 0x028d }
            if (r1 == 0) goto L_0x00e0
            boolean r1 = r7.I     // Catch:{ Exception -> 0x028d }
            if (r1 == 0) goto L_0x00d5
            com.mbridge.msdk.d.b r1 = com.mbridge.msdk.d.b.getInstance()     // Catch:{ Exception -> 0x028d }
            java.lang.String r6 = r7.A     // Catch:{ Exception -> 0x028d }
            java.lang.String r13 = r7.v     // Catch:{ Exception -> 0x028d }
            r1.addInterstitialList(r6, r13)     // Catch:{ Exception -> 0x028d }
            goto L_0x00e0
        L_0x00d5:
            com.mbridge.msdk.d.b r1 = com.mbridge.msdk.d.b.getInstance()     // Catch:{ Exception -> 0x028d }
            java.lang.String r6 = r7.A     // Catch:{ Exception -> 0x028d }
            java.lang.String r13 = r7.v     // Catch:{ Exception -> 0x028d }
            r1.addRewardList(r6, r13)     // Catch:{ Exception -> 0x028d }
        L_0x00e0:
            boolean r1 = r7.J     // Catch:{ Exception -> 0x028d }
            if (r1 == 0) goto L_0x013a
            boolean r1 = android.text.TextUtils.isEmpty(r31)     // Catch:{ Exception -> 0x028d }
            if (r1 == 0) goto L_0x013a
            com.mbridge.msdk.reward.b.a$c r0 = r7.t     // Catch:{ Exception -> 0x028d }
            if (r0 == 0) goto L_0x0139
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x011b }
            r0.<init>()     // Catch:{ all -> 0x011b }
            java.lang.String r1 = "adtp"
            boolean r6 = r7.I     // Catch:{ all -> 0x011b }
            if (r6 == 0) goto L_0x00fc
            r6 = 287(0x11f, float:4.02E-43)
            goto L_0x00fe
        L_0x00fc:
            r6 = 94
        L_0x00fe:
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x011b }
            r0.put(r1, r6)     // Catch:{ all -> 0x011b }
            com.mbridge.msdk.foundation.entity.e r14 = new com.mbridge.msdk.foundation.entity.e     // Catch:{ all -> 0x011b }
            r14.<init>((int) r5, (java.lang.String) r11, (java.util.Map<java.lang.String, java.lang.String>) r0)     // Catch:{ all -> 0x011b }
            r12 = 0
            android.content.Context r13 = r7.n     // Catch:{ all -> 0x011b }
            java.lang.String r15 = r7.v     // Catch:{ all -> 0x011b }
            boolean r0 = r7.J     // Catch:{ all -> 0x011b }
            java.lang.String r17 = ""
            java.lang.String r18 = ""
            r16 = r0
            com.mbridge.msdk.reward.c.a.a(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x011b }
            goto L_0x0125
        L_0x011b:
            r0 = move-exception
            java.lang.String r1 = "RewardVideoController"
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x028d }
            com.mbridge.msdk.foundation.tools.aa.d(r1, r0)     // Catch:{ Exception -> 0x028d }
        L_0x0125:
            if (r9 == 0) goto L_0x0134
            boolean r0 = r9.containsKey(r4)     // Catch:{ Exception -> 0x028d }
            if (r0 == 0) goto L_0x0134
            java.lang.Object r0 = r9.get(r4)     // Catch:{ Exception -> 0x028d }
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x028d }
        L_0x0134:
            com.mbridge.msdk.reward.b.a$c r0 = r7.t     // Catch:{ Exception -> 0x028d }
            com.mbridge.msdk.reward.b.a.c.d(r0, r11, r2)     // Catch:{ Exception -> 0x028d }
        L_0x0139:
            return
        L_0x013a:
            java.util.Map<java.lang.String, java.lang.String> r1 = com.mbridge.msdk.system.a.a     // Catch:{ Exception -> 0x028d }
            if (r1 != 0) goto L_0x018b
            com.mbridge.msdk.reward.b.a$c r1 = r7.t     // Catch:{ Exception -> 0x028d }
            if (r1 == 0) goto L_0x018a
            com.mbridge.msdk.foundation.entity.e r12 = new com.mbridge.msdk.foundation.entity.e     // Catch:{ Exception -> 0x028d }
            r12.<init>(r5, r0)     // Catch:{ Exception -> 0x028d }
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r7.ae     // Catch:{ Exception -> 0x028d }
            if (r1 == 0) goto L_0x0168
            int r1 = r1.size()     // Catch:{ Exception -> 0x028d }
            if (r1 <= 0) goto L_0x0168
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r7.ae     // Catch:{ Exception -> 0x028d }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ Exception -> 0x028d }
            r10 = r1
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = (com.mbridge.msdk.foundation.entity.CampaignEx) r10     // Catch:{ Exception -> 0x028d }
            android.content.Context r11 = r7.n     // Catch:{ Exception -> 0x028d }
            java.lang.String r13 = r7.v     // Catch:{ Exception -> 0x028d }
            boolean r14 = r7.J     // Catch:{ Exception -> 0x028d }
            java.lang.String r15 = ""
            java.lang.String r16 = ""
            com.mbridge.msdk.reward.c.a.a(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x028d }
            goto L_0x0176
        L_0x0168:
            r10 = 0
            android.content.Context r11 = r7.n     // Catch:{ Exception -> 0x028d }
            java.lang.String r13 = r7.v     // Catch:{ Exception -> 0x028d }
            boolean r14 = r7.J     // Catch:{ Exception -> 0x028d }
            java.lang.String r15 = ""
            java.lang.String r16 = ""
            com.mbridge.msdk.reward.c.a.a(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x028d }
        L_0x0176:
            if (r9 == 0) goto L_0x0185
            boolean r1 = r9.containsKey(r4)     // Catch:{ Exception -> 0x028d }
            if (r1 == 0) goto L_0x0185
            java.lang.Object r1 = r9.get(r4)     // Catch:{ Exception -> 0x028d }
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x028d }
        L_0x0185:
            com.mbridge.msdk.reward.b.a$c r1 = r7.t     // Catch:{ Exception -> 0x028d }
            com.mbridge.msdk.reward.b.a.c.d(r1, r0, r2)     // Catch:{ Exception -> 0x028d }
        L_0x018a:
            return
        L_0x018b:
            com.mbridge.msdk.videocommon.d.b r0 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x028d }
            com.mbridge.msdk.foundation.controller.b r1 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x028d }
            java.lang.String r1 = r1.h()     // Catch:{ Exception -> 0x028d }
            java.lang.String r2 = r7.v     // Catch:{ Exception -> 0x028d }
            com.mbridge.msdk.videocommon.d.c r0 = r0.a(r1, r2)     // Catch:{ Exception -> 0x028d }
            r7.q = r0     // Catch:{ Exception -> 0x028d }
            if (r0 != 0) goto L_0x01d9
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x028d }
            java.lang.String r0 = r0.h()     // Catch:{ Exception -> 0x028d }
            r7.V = r0     // Catch:{ Exception -> 0x028d }
            com.mbridge.msdk.videocommon.d.b r0 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x028d }
            java.lang.String r1 = r7.V     // Catch:{ Exception -> 0x028d }
            com.mbridge.msdk.foundation.controller.b r2 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x028d }
            java.lang.String r2 = r2.j()     // Catch:{ Exception -> 0x028d }
            java.lang.String r6 = r7.v     // Catch:{ Exception -> 0x028d }
            com.mbridge.msdk.reward.b.a$3 r11 = new com.mbridge.msdk.reward.b.a$3     // Catch:{ Exception -> 0x028d }
            r11.<init>()     // Catch:{ Exception -> 0x028d }
            r0.a(r1, r2, r6, r11)     // Catch:{ Exception -> 0x028d }
            com.mbridge.msdk.videocommon.d.b r0 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x028d }
            com.mbridge.msdk.foundation.controller.b r1 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x028d }
            java.lang.String r1 = r1.h()     // Catch:{ Exception -> 0x028d }
            java.lang.String r2 = r7.v     // Catch:{ Exception -> 0x028d }
            boolean r6 = r7.I     // Catch:{ Exception -> 0x028d }
            com.mbridge.msdk.videocommon.d.c r0 = r0.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r6)     // Catch:{ Exception -> 0x028d }
            r7.q = r0     // Catch:{ Exception -> 0x028d }
        L_0x01d9:
            java.lang.String r0 = r7.A     // Catch:{ Exception -> 0x028d }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x028d }
            if (r0 != 0) goto L_0x01e8
            com.mbridge.msdk.videocommon.d.c r0 = r7.q     // Catch:{ Exception -> 0x028d }
            java.lang.String r1 = r7.A     // Catch:{ Exception -> 0x028d }
            r0.b((java.lang.String) r1)     // Catch:{ Exception -> 0x028d }
        L_0x01e8:
            com.mbridge.msdk.videocommon.d.c r0 = r7.q     // Catch:{ Exception -> 0x028d }
            int r0 = r0.G()     // Catch:{ Exception -> 0x028d }
            int r0 = r0 * 1000
            android.os.Handler r1 = r7.D     // Catch:{ Exception -> 0x028d }
            if (r1 == 0) goto L_0x01fb
            r2 = 1001002(0xf462a, float:1.402703E-39)
            long r13 = (long) r0     // Catch:{ Exception -> 0x028d }
            r1.sendEmptyMessageDelayed(r2, r13)     // Catch:{ Exception -> 0x028d }
        L_0x01fb:
            com.mbridge.msdk.videocommon.d.c r0 = r7.q     // Catch:{ Exception -> 0x028d }
            java.util.Queue r0 = r0.C()     // Catch:{ Exception -> 0x028d }
            r7.U = r0     // Catch:{ Exception -> 0x028d }
            boolean r0 = r29.g()     // Catch:{ Exception -> 0x020d }
            if (r0 == 0) goto L_0x0215
            r29.f()     // Catch:{ Exception -> 0x020d }
            goto L_0x0215
        L_0x020d:
            r0 = move-exception
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x028d }
            if (r1 == 0) goto L_0x0215
            r0.printStackTrace()     // Catch:{ Exception -> 0x028d }
        L_0x0215:
            r29.b(r30, r31, r32)     // Catch:{ Exception -> 0x021a }
            goto L_0x02da
        L_0x021a:
            r0 = move-exception
            r1 = r0
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r7.ae     // Catch:{ Exception -> 0x0254 }
            if (r0 == 0) goto L_0x0254
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r7.ae     // Catch:{ Exception -> 0x0254 }
            int r0 = r0.size()     // Catch:{ Exception -> 0x0254 }
            if (r0 <= 0) goto L_0x0254
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r7.ae     // Catch:{ Exception -> 0x0254 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ Exception -> 0x0254 }
            r13 = r0
            com.mbridge.msdk.foundation.entity.CampaignEx r13 = (com.mbridge.msdk.foundation.entity.CampaignEx) r13     // Catch:{ Exception -> 0x0254 }
            android.content.Context r14 = r7.n     // Catch:{ Exception -> 0x0254 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0254 }
            r0.<init>(r12)     // Catch:{ Exception -> 0x0254 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ Exception -> 0x0254 }
            r0.append(r1)     // Catch:{ Exception -> 0x0254 }
            java.lang.String r15 = r0.toString()     // Catch:{ Exception -> 0x0254 }
            java.lang.String r0 = r7.v     // Catch:{ Exception -> 0x0254 }
            boolean r1 = r7.J     // Catch:{ Exception -> 0x0254 }
            java.lang.String r18 = ""
            java.lang.String r19 = ""
            r20 = 0
            r16 = r0
            r17 = r1
            com.mbridge.msdk.reward.c.a.a(r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ Exception -> 0x0254 }
        L_0x0254:
            com.mbridge.msdk.foundation.entity.e r0 = new com.mbridge.msdk.foundation.entity.e     // Catch:{ Exception -> 0x027b }
            r1 = 20
            r0.<init>(r1, r10)     // Catch:{ Exception -> 0x027b }
            if (r9 == 0) goto L_0x0283
            boolean r1 = r9.containsKey(r4)     // Catch:{ Exception -> 0x027b }
            if (r1 == 0) goto L_0x0283
            r22 = 0
            android.content.Context r1 = r7.n     // Catch:{ Exception -> 0x027b }
            java.lang.String r2 = r7.v     // Catch:{ Exception -> 0x027b }
            boolean r4 = r7.J     // Catch:{ Exception -> 0x027b }
            java.lang.String r27 = ""
            java.lang.String r28 = ""
            r23 = r1
            r24 = r0
            r25 = r2
            r26 = r4
            com.mbridge.msdk.reward.c.a.a(r22, r23, r24, r25, r26, r27, r28)     // Catch:{ Exception -> 0x027b }
            goto L_0x0283
        L_0x027b:
            r0 = move-exception
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x028d }
            if (r1 == 0) goto L_0x0283
            r0.printStackTrace()     // Catch:{ Exception -> 0x028d }
        L_0x0283:
            com.mbridge.msdk.reward.b.a$c r0 = r7.t     // Catch:{ Exception -> 0x028d }
            if (r0 == 0) goto L_0x02da
            com.mbridge.msdk.reward.b.a$c r0 = r7.t     // Catch:{ Exception -> 0x028d }
            com.mbridge.msdk.reward.b.a.c.a((com.mbridge.msdk.reward.b.a.c) r0, (java.lang.String) r10, (boolean) r3)     // Catch:{ Exception -> 0x028d }
            goto L_0x02da
        L_0x028d:
            r0 = move-exception
            com.mbridge.msdk.reward.b.a$c r1 = r7.t
            if (r1 == 0) goto L_0x02d3
            com.mbridge.msdk.foundation.entity.e r1 = new com.mbridge.msdk.foundation.entity.e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "load exception "
            r2.<init>(r4)
            java.lang.String r4 = r0.getMessage()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r5, r2)
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r7.ae
            if (r2 == 0) goto L_0x02ca
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x02ca
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r7.ae
            java.lang.Object r2 = r2.get(r5)
            r8 = r2
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = (com.mbridge.msdk.foundation.entity.CampaignEx) r8
            android.content.Context r9 = r7.n
            java.lang.String r11 = r7.v
            boolean r12 = r7.J
            java.lang.String r13 = ""
            java.lang.String r14 = ""
            r10 = r1
            com.mbridge.msdk.reward.c.a.a(r8, r9, r10, r11, r12, r13, r14)
        L_0x02ca:
            com.mbridge.msdk.reward.b.a$c r2 = r7.t
            java.lang.String r1 = r1.e()
            com.mbridge.msdk.reward.b.a.c.a((com.mbridge.msdk.reward.b.a.c) r2, (java.lang.String) r1, (boolean) r3)
        L_0x02d3:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L_0x02da
            r0.printStackTrace()
        L_0x02da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.a(boolean, java.lang.String, java.util.Map):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v1, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v3, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v4, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v5, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v6, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v7, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v8, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v32, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v9, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v10, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v11, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v12, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v13, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v14, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v15, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v16, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v17, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v18, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v19, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v64, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v20, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v21, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v22, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v82, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v23, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v24, resolved type: java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>} */
    /* JADX WARNING: type inference failed for: r0v10, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v36, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v68, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v86, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(boolean r23, java.lang.String r24, java.util.Map<java.lang.String, java.lang.String> r25) {
        /*
            r22 = this;
            r1 = r22
            r2 = r23
            r10 = r24
            r11 = r25
            java.lang.String r0 = "1"
            java.lang.String r3 = ""
            java.lang.String r12 = "2"
            java.lang.String r4 = "local_rid"
            com.mbridge.msdk.reward.b.a$c r5 = r1.t
            if (r5 == 0) goto L_0x0623
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ Exception -> 0x007c }
            r5.<init>()     // Catch:{ Exception -> 0x007c }
            com.mbridge.msdk.videocommon.d.c r6 = r1.q     // Catch:{ Exception -> 0x007c }
            if (r6 == 0) goto L_0x0032
            java.lang.String r6 = r6.l()     // Catch:{ Exception -> 0x007c }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x007c }
            if (r6 != 0) goto L_0x0032
            java.lang.String r6 = "rus_rid"
            com.mbridge.msdk.videocommon.d.c r7 = r1.q     // Catch:{ Exception -> 0x007c }
            java.lang.String r7 = r7.l()     // Catch:{ Exception -> 0x007c }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x007c }
        L_0x0032:
            com.mbridge.msdk.videocommon.d.a r6 = r1.r     // Catch:{ Exception -> 0x007c }
            if (r6 == 0) goto L_0x004b
            java.lang.String r6 = r6.c()     // Catch:{ Exception -> 0x007c }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x007c }
            if (r6 != 0) goto L_0x004b
            java.lang.String r6 = "rs_rid"
            com.mbridge.msdk.videocommon.d.a r7 = r1.r     // Catch:{ Exception -> 0x007c }
            java.lang.String r7 = r7.c()     // Catch:{ Exception -> 0x007c }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x007c }
        L_0x004b:
            java.lang.String r6 = "r_stid"
            com.mbridge.msdk.videocommon.d.b r7 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x007c }
            com.mbridge.msdk.videocommon.d.a r7 = r7.b()     // Catch:{ Exception -> 0x007c }
            java.lang.String r7 = r7.b()     // Catch:{ Exception -> 0x007c }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x007c }
            if (r11 == 0) goto L_0x0071
            java.lang.String r6 = "isDev"
            if (r2 == 0) goto L_0x0064
            r7 = r12
            goto L_0x0065
        L_0x0064:
            r7 = r0
        L_0x0065:
            r11.put(r6, r7)     // Catch:{ Exception -> 0x007c }
            java.lang.Object r6 = r11.get(r4)     // Catch:{ Exception -> 0x007c }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x007c }
            r1.y = r6     // Catch:{ Exception -> 0x007a }
            goto L_0x0072
        L_0x0071:
            r6 = r3
        L_0x0072:
            com.mbridge.msdk.foundation.same.report.m r7 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x007a }
            r7.a((java.lang.String) r6, (java.util.Map<java.lang.String, java.lang.String>) r5)     // Catch:{ Exception -> 0x007a }
            goto L_0x007e
        L_0x007a:
            goto L_0x007e
        L_0x007c:
            r6 = r3
        L_0x007e:
            r13 = r6
            java.util.HashMap r14 = new java.util.HashMap
            r14.<init>()
            boolean r5 = r1.J
            r6 = 19
            java.lang.String r15 = "2000048"
            java.lang.String r9 = "2000127"
            java.lang.String r8 = "cache"
            r16 = 0
            java.lang.String r7 = "checkOverCap failed"
            r17 = r12
            r12 = 0
            if (r5 != 0) goto L_0x029b
            java.lang.String r5 = r1.v
            boolean r5 = r1.c((java.lang.String) r5, (java.lang.String) r13)
            r1.ad = r5
            boolean r5 = r1.ad
            if (r5 == 0) goto L_0x0202
            boolean r5 = r22.k()
            if (r5 != 0) goto L_0x016c
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r7 = r1.ae
            if (r7 == 0) goto L_0x0623
            int r4 = r7.size()
            if (r4 <= 0) goto L_0x0623
            com.mbridge.msdk.foundation.same.report.m r4 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x0115 }
            java.lang.String r5 = r1.v     // Catch:{ Exception -> 0x0115 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0115 }
            r6.<init>()     // Catch:{ Exception -> 0x0115 }
            java.lang.Object r16 = r7.get(r12)     // Catch:{ Exception -> 0x0115 }
            com.mbridge.msdk.foundation.entity.CampaignEx r16 = (com.mbridge.msdk.foundation.entity.CampaignEx) r16     // Catch:{ Exception -> 0x0115 }
            int r12 = r16.getAdType()     // Catch:{ Exception -> 0x0115 }
            r6.append(r12)     // Catch:{ Exception -> 0x0115 }
            r6.append(r3)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0115 }
            java.lang.String r12 = "0"
            r3 = r4
            r4 = r13
            r16 = r7
            r7 = r12
            r12 = r8
            r8 = r24
            r3.a((java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8)     // Catch:{ Exception -> 0x0112 }
            r14.put(r12, r0)     // Catch:{ Exception -> 0x0112 }
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x0112 }
            r0.c(r13, r9, r14)     // Catch:{ Exception -> 0x0112 }
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x0112 }
            r0.c(r13, r15, r14)     // Catch:{ Exception -> 0x0112 }
            int r0 = r16.size()     // Catch:{ Exception -> 0x0112 }
            r3 = 1
            if (r0 <= r3) goto L_0x0101
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x0112 }
            r3 = r16
            r0.b((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)     // Catch:{ Exception -> 0x0116 }
            goto L_0x0117
        L_0x0101:
            r3 = r16
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x0116 }
            r4 = 0
            java.lang.Object r5 = r3.get(r4)     // Catch:{ Exception -> 0x0116 }
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = (com.mbridge.msdk.foundation.entity.CampaignEx) r5     // Catch:{ Exception -> 0x0116 }
            r0.a((com.mbridge.msdk.foundation.entity.CampaignEx) r5)     // Catch:{ Exception -> 0x0116 }
            goto L_0x0117
        L_0x0112:
            r3 = r16
            goto L_0x0116
        L_0x0115:
            r3 = r7
        L_0x0116:
        L_0x0117:
            com.mbridge.msdk.reward.b.a$c r0 = r1.t
            java.lang.String r4 = r1.A
            java.lang.String r5 = r1.v
            com.mbridge.msdk.reward.b.a.c.e(r0, r4, r5)
            r4 = 0
            java.lang.Object r0 = r3.get(r4)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            com.mbridge.msdk.reward.b.a$c r4 = r1.t
            boolean r5 = r1.J
            r4.a((boolean) r5)
            com.mbridge.msdk.reward.adapter.c r4 = r1.p
            if (r4 == 0) goto L_0x0153
            java.lang.String r5 = r0.getCMPTEntryUrl()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            r6 = 1
            r5 = r5 ^ r6
            int r0 = r0.getNscpt()
            boolean r0 = r4.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3, (boolean) r5, (int) r0)
            if (r0 == 0) goto L_0x0153
            r1.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)
            com.mbridge.msdk.reward.b.a$c r0 = r1.t
            java.lang.String r3 = r1.A
            java.lang.String r4 = r1.v
            r0.b(r3, r4)
            goto L_0x0158
        L_0x0153:
            com.mbridge.msdk.reward.adapter.c r0 = r1.p
            r1.a((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r3, (com.mbridge.msdk.reward.adapter.c) r0)
        L_0x0158:
            boolean r0 = r1.X
            if (r0 == 0) goto L_0x0623
            com.mbridge.msdk.reward.adapter.c r0 = r1.p
            if (r0 == 0) goto L_0x0165
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r3 = r1.ae
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)
        L_0x0165:
            java.util.Queue<java.lang.Integer> r0 = r1.U
            r1.a((java.util.Queue<java.lang.Integer>) r0, (boolean) r2, (java.lang.String) r10, (java.util.Map<java.lang.String, java.lang.String>) r11)
            goto L_0x0623
        L_0x016c:
            r12 = r8
            java.lang.String r0 = "RewardVideoController"
            java.lang.String r3 = "非BID，本地存在可用的缓存，超过上限"
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r0, (java.lang.String) r3)
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.ae
            if (r0 == 0) goto L_0x019b
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x019b
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.ae
            java.util.Iterator r0 = r0.iterator()
        L_0x0185:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x019b
            java.lang.Object r3 = r0.next()
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = (com.mbridge.msdk.foundation.entity.CampaignEx) r3
            com.mbridge.msdk.videocommon.a.a r5 = com.mbridge.msdk.videocommon.a.a.a()
            java.lang.String r8 = r1.v
            r5.a((com.mbridge.msdk.foundation.entity.CampaignEx) r3, (java.lang.String) r8)
            goto L_0x0185
        L_0x019b:
            com.mbridge.msdk.reward.adapter.c r0 = r1.p
            if (r0 == 0) goto L_0x01a4
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r3 = r1.ae
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)
        L_0x01a4:
            if (r2 == 0) goto L_0x01de
            com.mbridge.msdk.reward.b.a$c r0 = r1.t
            if (r0 == 0) goto L_0x01dd
            com.mbridge.msdk.foundation.entity.e r10 = new com.mbridge.msdk.foundation.entity.e
            r10.<init>(r6, r7)
            if (r11 == 0) goto L_0x01bf
            boolean r0 = r11.containsKey(r4)     // Catch:{ Exception -> 0x01ce }
            if (r0 == 0) goto L_0x01bf
            java.lang.Object r0 = r11.get(r4)     // Catch:{ Exception -> 0x01ce }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x01ce }
            r16 = r0
        L_0x01bf:
            r8 = 0
            android.content.Context r9 = r1.n     // Catch:{ Exception -> 0x01ce }
            java.lang.String r11 = r1.v     // Catch:{ Exception -> 0x01ce }
            boolean r12 = r1.J     // Catch:{ Exception -> 0x01ce }
            java.lang.String r13 = ""
            java.lang.String r14 = ""
            com.mbridge.msdk.reward.c.a.a(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x01ce }
            goto L_0x01d6
        L_0x01ce:
            r0 = move-exception
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r2 == 0) goto L_0x01d6
            r0.printStackTrace()
        L_0x01d6:
            r0 = r16
            com.mbridge.msdk.reward.b.a$c r2 = r1.t
            com.mbridge.msdk.reward.b.a.c.d(r2, r7, r0)
        L_0x01dd:
            return
        L_0x01de:
            r3 = 0
            r1.ad = r3
            com.mbridge.msdk.reward.b.a$c r0 = r1.t
            boolean r3 = r1.J
            r0.a((boolean) r3)
            r8 = r17
            r14.put(r12, r8)
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()
            r0.c(r13, r9, r14)
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()
            r0.c(r13, r15, r14)
            java.util.Queue<java.lang.Integer> r0 = r1.U
            r1.a((java.util.Queue<java.lang.Integer>) r0, (boolean) r2, (java.lang.String) r10, (java.util.Map<java.lang.String, java.lang.String>) r11)
            goto L_0x0623
        L_0x0202:
            r12 = r8
            r8 = r17
            boolean r0 = r22.k()
            if (r0 != 0) goto L_0x0236
            r3 = 0
            r1.ad = r3
            com.mbridge.msdk.reward.adapter.c r0 = r1.p
            if (r0 == 0) goto L_0x0217
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r3 = r1.ae
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)
        L_0x0217:
            com.mbridge.msdk.reward.b.a$c r0 = r1.t
            boolean r3 = r1.J
            r0.a((boolean) r3)
            r14.put(r12, r8)
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()
            r0.c(r13, r9, r14)
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()
            r0.c(r13, r15, r14)
            java.util.Queue<java.lang.Integer> r0 = r1.U
            r1.a((java.util.Queue<java.lang.Integer>) r0, (boolean) r2, (java.lang.String) r10, (java.util.Map<java.lang.String, java.lang.String>) r11)
            goto L_0x0623
        L_0x0236:
            if (r2 == 0) goto L_0x0270
            com.mbridge.msdk.reward.b.a$c r0 = r1.t
            if (r0 == 0) goto L_0x026f
            com.mbridge.msdk.foundation.entity.e r10 = new com.mbridge.msdk.foundation.entity.e
            r10.<init>(r6, r7)
            if (r11 == 0) goto L_0x0251
            boolean r0 = r11.containsKey(r4)     // Catch:{ Exception -> 0x0260 }
            if (r0 == 0) goto L_0x0251
            java.lang.Object r0 = r11.get(r4)     // Catch:{ Exception -> 0x0260 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0260 }
            r16 = r0
        L_0x0251:
            r8 = 0
            android.content.Context r9 = r1.n     // Catch:{ Exception -> 0x0260 }
            java.lang.String r11 = r1.v     // Catch:{ Exception -> 0x0260 }
            boolean r12 = r1.J     // Catch:{ Exception -> 0x0260 }
            java.lang.String r13 = ""
            java.lang.String r14 = ""
            com.mbridge.msdk.reward.c.a.a(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0260 }
            goto L_0x0268
        L_0x0260:
            r0 = move-exception
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r2 == 0) goto L_0x0268
            r0.printStackTrace()
        L_0x0268:
            r0 = r16
            com.mbridge.msdk.reward.b.a$c r2 = r1.t
            com.mbridge.msdk.reward.b.a.c.d(r2, r7, r0)
        L_0x026f:
            return
        L_0x0270:
            r3 = 0
            r1.ad = r3
            com.mbridge.msdk.reward.adapter.c r0 = r1.p
            if (r0 == 0) goto L_0x027c
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r3 = r1.ae
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)
        L_0x027c:
            com.mbridge.msdk.reward.b.a$c r0 = r1.t
            boolean r3 = r1.J
            r0.a((boolean) r3)
            r14.put(r12, r8)
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()
            r0.c(r13, r9, r14)
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()
            r0.c(r13, r15, r14)
            java.util.Queue<java.lang.Integer> r0 = r1.U
            r1.a((java.util.Queue<java.lang.Integer>) r0, (boolean) r2, (java.lang.String) r10, (java.util.Map<java.lang.String, java.lang.String>) r11)
            goto L_0x0623
        L_0x029b:
            r12 = r8
            r8 = r17
            com.mbridge.msdk.videocommon.a.a r0 = com.mbridge.msdk.videocommon.a.a.a()
            java.lang.String r5 = r1.v
            boolean r6 = r1.J
            r18 = r8
            r8 = 1
            java.util.concurrent.CopyOnWriteArrayList r0 = r0.a((java.lang.String) r5, (int) r8, (boolean) r6, (java.lang.String) r3)
            java.lang.String r3 = "cb is open"
            r5 = 21
            if (r0 == 0) goto L_0x046f
            int r6 = r0.size()
            if (r6 <= 0) goto L_0x046f
            boolean r6 = r22.k()
            if (r6 != 0) goto L_0x0429
            java.util.concurrent.CopyOnWriteArrayList r4 = r1.b((java.lang.String) r10, (java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r0)
            if (r4 == 0) goto L_0x02cf
            int r6 = r4.size()
            if (r6 <= 0) goto L_0x02cf
            r1.a((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r4, (java.lang.String) r10, (java.lang.String) r13)
            return
        L_0x02cf:
            com.mbridge.msdk.reward.a.a r12 = new com.mbridge.msdk.reward.a.a
            java.lang.String r4 = r1.v
            boolean r6 = r1.I
            r12.<init>(r4, r6)
            com.mbridge.msdk.foundation.b.c r4 = new com.mbridge.msdk.foundation.b.c     // Catch:{ Exception -> 0x03f8 }
            r4.<init>()     // Catch:{ Exception -> 0x03f8 }
            boolean r6 = r12.a(r10)     // Catch:{ Exception -> 0x03f8 }
            if (r6 == 0) goto L_0x03c2
            r6 = 0
            com.mbridge.msdk.foundation.entity.e r7 = new com.mbridge.msdk.foundation.entity.e     // Catch:{ Exception -> 0x03f8 }
            r7.<init>(r5, r3)     // Catch:{ Exception -> 0x03f8 }
            r8 = 2
            com.mbridge.msdk.reward.adapter.c r9 = r1.p     // Catch:{ Exception -> 0x03f8 }
            r3 = r12
            r4 = r24
            r5 = r13
            com.mbridge.msdk.foundation.b.c r3 = r3.a((java.lang.String) r4, (java.lang.String) r5, (com.mbridge.msdk.foundation.entity.CampaignEx) r6, (com.mbridge.msdk.foundation.entity.e) r7, (int) r8, (com.mbridge.msdk.reward.adapter.c) r9)     // Catch:{ Exception -> 0x03f8 }
            com.mbridge.msdk.reward.adapter.c r4 = r1.p     // Catch:{ Exception -> 0x03f8 }
            if (r4 != 0) goto L_0x0311
            com.mbridge.msdk.reward.adapter.c r4 = new com.mbridge.msdk.reward.adapter.c     // Catch:{ Exception -> 0x03f8 }
            android.content.Context r5 = r1.n     // Catch:{ Exception -> 0x03f8 }
            java.lang.String r6 = r1.A     // Catch:{ Exception -> 0x03f8 }
            java.lang.String r7 = r1.v     // Catch:{ Exception -> 0x03f8 }
            r4.<init>(r5, r6, r7)     // Catch:{ Exception -> 0x03f8 }
            r1.p = r4     // Catch:{ Exception -> 0x03f8 }
            boolean r5 = r1.I     // Catch:{ Exception -> 0x03f8 }
            r4.b((boolean) r5)     // Catch:{ Exception -> 0x03f8 }
            com.mbridge.msdk.reward.adapter.c r4 = r1.p     // Catch:{ Exception -> 0x03f8 }
            boolean r5 = r1.J     // Catch:{ Exception -> 0x03f8 }
            r4.c((boolean) r5)     // Catch:{ Exception -> 0x03f8 }
        L_0x0311:
            boolean r4 = r1.I     // Catch:{ Exception -> 0x03f8 }
            if (r4 == 0) goto L_0x0320
            com.mbridge.msdk.reward.adapter.c r4 = r1.p     // Catch:{ Exception -> 0x03f8 }
            int r5 = r1.F     // Catch:{ Exception -> 0x03f8 }
            int r6 = r1.G     // Catch:{ Exception -> 0x03f8 }
            int r7 = r1.H     // Catch:{ Exception -> 0x03f8 }
            r4.a((int) r5, (int) r6, (int) r7)     // Catch:{ Exception -> 0x03f8 }
        L_0x0320:
            com.mbridge.msdk.reward.adapter.c r4 = r1.p     // Catch:{ Exception -> 0x03f8 }
            int r5 = r1.E     // Catch:{ Exception -> 0x03f8 }
            r4.a((int) r5)     // Catch:{ Exception -> 0x03f8 }
            com.mbridge.msdk.reward.adapter.c r4 = r1.p     // Catch:{ Exception -> 0x03f8 }
            com.mbridge.msdk.videocommon.d.c r5 = r1.q     // Catch:{ Exception -> 0x03f8 }
            r4.a((com.mbridge.msdk.videocommon.d.c) r5)     // Catch:{ Exception -> 0x03f8 }
            if (r3 == 0) goto L_0x03c0
            int r4 = r3.e()     // Catch:{ Exception -> 0x03f8 }
            int r5 = com.mbridge.msdk.foundation.b.c.c     // Catch:{ Exception -> 0x03f8 }
            if (r4 != r5) goto L_0x03c0
            java.util.concurrent.CopyOnWriteArrayList r4 = r3.g()     // Catch:{ Exception -> 0x03f8 }
            if (r4 == 0) goto L_0x03c0
            java.util.concurrent.CopyOnWriteArrayList r4 = r3.g()     // Catch:{ Exception -> 0x03f8 }
            int r4 = r4.size()     // Catch:{ Exception -> 0x03f8 }
            if (r4 <= 0) goto L_0x03c0
            com.mbridge.msdk.reward.adapter.c r4 = r1.p     // Catch:{ Exception -> 0x03f8 }
            if (r4 == 0) goto L_0x03c0
            java.util.concurrent.CopyOnWriteArrayList r4 = r3.g()     // Catch:{ Exception -> 0x03f8 }
            if (r0 == 0) goto L_0x03aa
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x03f8 }
            r5.<init>()     // Catch:{ Exception -> 0x03f8 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x03f8 }
        L_0x035b:
            boolean r6 = r0.hasNext()     // Catch:{ Exception -> 0x03f8 }
            if (r6 == 0) goto L_0x03a5
            java.lang.Object r6 = r0.next()     // Catch:{ Exception -> 0x03f8 }
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = (com.mbridge.msdk.foundation.entity.CampaignEx) r6     // Catch:{ Exception -> 0x03f8 }
            if (r6 == 0) goto L_0x035b
            java.lang.String r7 = r6.getRequestId()     // Catch:{ Exception -> 0x03f8 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x03f8 }
            if (r8 == 0) goto L_0x0374
            goto L_0x035b
        L_0x0374:
            r0 = 0
        L_0x0375:
            int r8 = r4.size()     // Catch:{ Exception -> 0x03f8 }
            if (r0 >= r8) goto L_0x039c
            java.lang.Object r8 = r4.get(r0)     // Catch:{ Exception -> 0x03f8 }
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = (com.mbridge.msdk.foundation.entity.CampaignEx) r8     // Catch:{ Exception -> 0x03f8 }
            if (r8 == 0) goto L_0x0399
            java.lang.String r8 = r8.getRequestId()     // Catch:{ Exception -> 0x03f8 }
            boolean r8 = r7.equals(r8)     // Catch:{ Exception -> 0x03f8 }
            if (r8 == 0) goto L_0x038e
            goto L_0x039c
        L_0x038e:
            int r8 = r4.size()     // Catch:{ Exception -> 0x03f8 }
            r9 = 1
            int r8 = r8 - r9
            if (r0 != r8) goto L_0x0399
            r5.add(r6)     // Catch:{ Exception -> 0x03f8 }
        L_0x0399:
            int r0 = r0 + 1
            goto L_0x0375
        L_0x039c:
            int r0 = r4.size()     // Catch:{ Exception -> 0x03f8 }
            if (r0 != 0) goto L_0x03a5
            r5.add(r6)     // Catch:{ Exception -> 0x03f8 }
        L_0x03a5:
            com.mbridge.msdk.reward.adapter.c r0 = r1.p     // Catch:{ Exception -> 0x03f8 }
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r5)     // Catch:{ Exception -> 0x03f8 }
        L_0x03aa:
            com.mbridge.msdk.reward.adapter.c r0 = r1.p     // Catch:{ Exception -> 0x03f8 }
            java.util.concurrent.CopyOnWriteArrayList r4 = r3.g()     // Catch:{ Exception -> 0x03f8 }
            r5 = 1
            r6 = 0
            r0.a((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r4, (boolean) r6, (boolean) r5)     // Catch:{ Exception -> 0x03f8 }
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ Exception -> 0x03f8 }
            java.util.concurrent.CopyOnWriteArrayList r4 = r3.g()     // Catch:{ Exception -> 0x03f8 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x03f8 }
            r16 = r0
        L_0x03c0:
            r6 = r3
            goto L_0x03e8
        L_0x03c2:
            java.util.concurrent.CopyOnWriteArrayList r3 = r1.a((java.lang.String) r10, (java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r0)     // Catch:{ Exception -> 0x03f8 }
            int r0 = r3.size()     // Catch:{ Exception -> 0x03f4 }
            if (r0 <= 0) goto L_0x03db
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x03f4 }
            android.content.Context r0 = r0.g()     // Catch:{ Exception -> 0x03f4 }
            com.mbridge.msdk.foundation.db.b r0 = com.mbridge.msdk.foundation.db.b.a((android.content.Context) r0)     // Catch:{ Exception -> 0x03f4 }
            r0.a((java.lang.String) r10, (java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)     // Catch:{ Exception -> 0x03f4 }
        L_0x03db:
            java.lang.String r0 = "cb is closed"
            r4.e(r0)     // Catch:{ Exception -> 0x03f4 }
            int r0 = com.mbridge.msdk.foundation.b.c.d     // Catch:{ Exception -> 0x03f4 }
            r4.a((int) r0)     // Catch:{ Exception -> 0x03f4 }
            r16 = r3
            r6 = r4
        L_0x03e8:
            java.lang.String r4 = r1.x     // Catch:{ Exception -> 0x03f8 }
            r7 = 0
            r8 = 0
            r9 = 1
            r3 = r12
            r5 = r24
            r3.a((java.lang.String) r4, (java.lang.String) r5, (com.mbridge.msdk.foundation.b.c) r6, (java.util.List<com.mbridge.msdk.foundation.b.a.C0135a>) r7, (org.json.JSONObject) r8, (int) r9)     // Catch:{ Exception -> 0x03f8 }
            goto L_0x03fc
        L_0x03f4:
            r0 = move-exception
            r16 = r3
            goto L_0x03f9
        L_0x03f8:
            r0 = move-exception
        L_0x03f9:
            r0.printStackTrace()
        L_0x03fc:
            r0 = r16
            if (r0 == 0) goto L_0x0418
            int r3 = r0.size()
            if (r3 <= 0) goto L_0x0418
            r1.a((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r0, (java.lang.String) r10, (java.lang.String) r13)
            com.mbridge.msdk.reward.adapter.c r3 = r1.p
            if (r3 == 0) goto L_0x0418
            boolean r3 = r12.a(r10)
            if (r3 != 0) goto L_0x0418
            com.mbridge.msdk.reward.adapter.c r3 = r1.p
            r3.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r0)
        L_0x0418:
            r3 = 0
            r1.ad = r3
            com.mbridge.msdk.reward.b.a$c r0 = r1.t
            boolean r3 = r1.J
            r0.a((boolean) r3)
            java.util.Queue<java.lang.Integer> r0 = r1.U
            r1.a((java.util.Queue<java.lang.Integer>) r0, (boolean) r2, (java.lang.String) r10, (java.util.Map<java.lang.String, java.lang.String>) r11)
            goto L_0x0623
        L_0x0429:
            com.mbridge.msdk.videocommon.a.a r0 = com.mbridge.msdk.videocommon.a.a.a()
            java.lang.String r3 = r1.v
            r0.a((java.lang.String) r3, (java.lang.String) r10)
            if (r2 == 0) goto L_0x0623
            com.mbridge.msdk.reward.b.a$c r0 = r1.t
            if (r0 == 0) goto L_0x0623
            com.mbridge.msdk.foundation.entity.e r10 = new com.mbridge.msdk.foundation.entity.e
            r0 = 19
            r10.<init>(r0, r7)
            if (r11 == 0) goto L_0x044f
            boolean r0 = r11.containsKey(r4)     // Catch:{ Exception -> 0x045e }
            if (r0 == 0) goto L_0x044f
            java.lang.Object r0 = r11.get(r4)     // Catch:{ Exception -> 0x045e }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x045e }
            r16 = r0
        L_0x044f:
            r8 = 0
            android.content.Context r9 = r1.n     // Catch:{ Exception -> 0x045e }
            java.lang.String r11 = r1.v     // Catch:{ Exception -> 0x045e }
            boolean r12 = r1.J     // Catch:{ Exception -> 0x045e }
            java.lang.String r13 = ""
            java.lang.String r14 = ""
            com.mbridge.msdk.reward.c.a.a(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x045e }
            goto L_0x0466
        L_0x045e:
            r0 = move-exception
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r2 == 0) goto L_0x0466
            r0.printStackTrace()
        L_0x0466:
            r0 = r16
            com.mbridge.msdk.reward.b.a$c r2 = r1.t
            com.mbridge.msdk.reward.b.a.c.d(r2, r7, r0)
            goto L_0x0623
        L_0x046f:
            boolean r6 = r22.k()
            if (r6 != 0) goto L_0x05df
            com.mbridge.msdk.reward.a.a r8 = new com.mbridge.msdk.reward.a.a
            java.lang.String r4 = r1.v
            boolean r6 = r1.I
            r8.<init>(r4, r6)
            com.mbridge.msdk.foundation.b.c r4 = new com.mbridge.msdk.foundation.b.c     // Catch:{ Exception -> 0x0593 }
            r4.<init>()     // Catch:{ Exception -> 0x0593 }
            boolean r6 = r8.a(r10)     // Catch:{ Exception -> 0x0593 }
            if (r6 == 0) goto L_0x0574
            r6 = 0
            com.mbridge.msdk.foundation.entity.e r7 = new com.mbridge.msdk.foundation.entity.e     // Catch:{ Exception -> 0x0593 }
            r7.<init>(r5, r3)     // Catch:{ Exception -> 0x0593 }
            r17 = 2
            com.mbridge.msdk.reward.adapter.c r5 = r1.p     // Catch:{ Exception -> 0x0593 }
            r3 = r8
            r4 = r24
            r19 = r5
            r5 = r13
            r20 = r8
            r21 = r18
            r8 = r17
            r2 = r9
            r9 = r19
            com.mbridge.msdk.foundation.b.c r3 = r3.a((java.lang.String) r4, (java.lang.String) r5, (com.mbridge.msdk.foundation.entity.CampaignEx) r6, (com.mbridge.msdk.foundation.entity.e) r7, (int) r8, (com.mbridge.msdk.reward.adapter.c) r9)     // Catch:{ Exception -> 0x0591 }
            com.mbridge.msdk.reward.adapter.c r4 = r1.p     // Catch:{ Exception -> 0x0591 }
            if (r4 != 0) goto L_0x04c3
            com.mbridge.msdk.reward.adapter.c r4 = new com.mbridge.msdk.reward.adapter.c     // Catch:{ Exception -> 0x0591 }
            android.content.Context r5 = r1.n     // Catch:{ Exception -> 0x0591 }
            java.lang.String r6 = r1.A     // Catch:{ Exception -> 0x0591 }
            java.lang.String r7 = r1.v     // Catch:{ Exception -> 0x0591 }
            r4.<init>(r5, r6, r7)     // Catch:{ Exception -> 0x0591 }
            r1.p = r4     // Catch:{ Exception -> 0x0591 }
            boolean r5 = r1.I     // Catch:{ Exception -> 0x0591 }
            r4.b((boolean) r5)     // Catch:{ Exception -> 0x0591 }
            com.mbridge.msdk.reward.adapter.c r4 = r1.p     // Catch:{ Exception -> 0x0591 }
            boolean r5 = r1.J     // Catch:{ Exception -> 0x0591 }
            r4.c((boolean) r5)     // Catch:{ Exception -> 0x0591 }
        L_0x04c3:
            boolean r4 = r1.I     // Catch:{ Exception -> 0x0591 }
            if (r4 == 0) goto L_0x04d2
            com.mbridge.msdk.reward.adapter.c r4 = r1.p     // Catch:{ Exception -> 0x0591 }
            int r5 = r1.F     // Catch:{ Exception -> 0x0591 }
            int r6 = r1.G     // Catch:{ Exception -> 0x0591 }
            int r7 = r1.H     // Catch:{ Exception -> 0x0591 }
            r4.a((int) r5, (int) r6, (int) r7)     // Catch:{ Exception -> 0x0591 }
        L_0x04d2:
            com.mbridge.msdk.reward.adapter.c r4 = r1.p     // Catch:{ Exception -> 0x0591 }
            int r5 = r1.E     // Catch:{ Exception -> 0x0591 }
            r4.a((int) r5)     // Catch:{ Exception -> 0x0591 }
            com.mbridge.msdk.reward.adapter.c r4 = r1.p     // Catch:{ Exception -> 0x0591 }
            com.mbridge.msdk.videocommon.d.c r5 = r1.q     // Catch:{ Exception -> 0x0591 }
            r4.a((com.mbridge.msdk.videocommon.d.c) r5)     // Catch:{ Exception -> 0x0591 }
            if (r3 == 0) goto L_0x0572
            int r4 = r3.e()     // Catch:{ Exception -> 0x0591 }
            int r5 = com.mbridge.msdk.foundation.b.c.c     // Catch:{ Exception -> 0x0591 }
            if (r4 != r5) goto L_0x0572
            java.util.concurrent.CopyOnWriteArrayList r4 = r3.g()     // Catch:{ Exception -> 0x0591 }
            if (r4 == 0) goto L_0x0572
            java.util.concurrent.CopyOnWriteArrayList r4 = r3.g()     // Catch:{ Exception -> 0x0591 }
            int r4 = r4.size()     // Catch:{ Exception -> 0x0591 }
            if (r4 <= 0) goto L_0x0572
            com.mbridge.msdk.reward.adapter.c r4 = r1.p     // Catch:{ Exception -> 0x0591 }
            if (r4 == 0) goto L_0x0572
            java.util.concurrent.CopyOnWriteArrayList r4 = r3.g()     // Catch:{ Exception -> 0x0591 }
            if (r0 == 0) goto L_0x055c
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x0591 }
            r5.<init>()     // Catch:{ Exception -> 0x0591 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0591 }
        L_0x050d:
            boolean r6 = r0.hasNext()     // Catch:{ Exception -> 0x0591 }
            if (r6 == 0) goto L_0x0557
            java.lang.Object r6 = r0.next()     // Catch:{ Exception -> 0x0591 }
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = (com.mbridge.msdk.foundation.entity.CampaignEx) r6     // Catch:{ Exception -> 0x0591 }
            if (r6 == 0) goto L_0x050d
            java.lang.String r7 = r6.getRequestId()     // Catch:{ Exception -> 0x0591 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0591 }
            if (r8 == 0) goto L_0x0526
            goto L_0x050d
        L_0x0526:
            r0 = 0
        L_0x0527:
            int r8 = r4.size()     // Catch:{ Exception -> 0x0591 }
            if (r0 >= r8) goto L_0x054e
            java.lang.Object r8 = r4.get(r0)     // Catch:{ Exception -> 0x0591 }
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = (com.mbridge.msdk.foundation.entity.CampaignEx) r8     // Catch:{ Exception -> 0x0591 }
            if (r8 == 0) goto L_0x054b
            java.lang.String r8 = r8.getRequestId()     // Catch:{ Exception -> 0x0591 }
            boolean r8 = r7.equals(r8)     // Catch:{ Exception -> 0x0591 }
            if (r8 == 0) goto L_0x0540
            goto L_0x054e
        L_0x0540:
            int r8 = r4.size()     // Catch:{ Exception -> 0x0591 }
            r9 = 1
            int r8 = r8 - r9
            if (r0 != r8) goto L_0x054b
            r5.add(r6)     // Catch:{ Exception -> 0x0591 }
        L_0x054b:
            int r0 = r0 + 1
            goto L_0x0527
        L_0x054e:
            int r0 = r4.size()     // Catch:{ Exception -> 0x0591 }
            if (r0 != 0) goto L_0x0557
            r5.add(r6)     // Catch:{ Exception -> 0x0591 }
        L_0x0557:
            com.mbridge.msdk.reward.adapter.c r0 = r1.p     // Catch:{ Exception -> 0x0591 }
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r5)     // Catch:{ Exception -> 0x0591 }
        L_0x055c:
            com.mbridge.msdk.reward.adapter.c r0 = r1.p     // Catch:{ Exception -> 0x0591 }
            java.util.concurrent.CopyOnWriteArrayList r4 = r3.g()     // Catch:{ Exception -> 0x0591 }
            r5 = 1
            r6 = 0
            r0.a((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r4, (boolean) r6, (boolean) r5)     // Catch:{ Exception -> 0x0591 }
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ Exception -> 0x0591 }
            java.util.concurrent.CopyOnWriteArrayList r4 = r3.g()     // Catch:{ Exception -> 0x0591 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x0591 }
            r16 = r0
        L_0x0572:
            r6 = r3
            goto L_0x0584
        L_0x0574:
            r20 = r8
            r2 = r9
            r21 = r18
            java.lang.String r0 = "cb is closed 2"
            r4.e(r0)     // Catch:{ Exception -> 0x0591 }
            int r0 = com.mbridge.msdk.foundation.b.c.d     // Catch:{ Exception -> 0x0591 }
            r4.a((int) r0)     // Catch:{ Exception -> 0x0591 }
            r6 = r4
        L_0x0584:
            java.lang.String r4 = r1.x     // Catch:{ Exception -> 0x0591 }
            r7 = 0
            r8 = 0
            r9 = 1
            r3 = r20
            r5 = r24
            r3.a((java.lang.String) r4, (java.lang.String) r5, (com.mbridge.msdk.foundation.b.c) r6, (java.util.List<com.mbridge.msdk.foundation.b.a.C0135a>) r7, (org.json.JSONObject) r8, (int) r9)     // Catch:{ Exception -> 0x0591 }
            goto L_0x059c
        L_0x0591:
            r0 = move-exception
            goto L_0x0599
        L_0x0593:
            r0 = move-exception
            r20 = r8
            r2 = r9
            r21 = r18
        L_0x0599:
            r0.printStackTrace()
        L_0x059c:
            r0 = r16
            if (r0 == 0) goto L_0x05ba
            int r3 = r0.size()
            if (r3 <= 0) goto L_0x05ba
            r1.a((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r0, (java.lang.String) r10, (java.lang.String) r13)
            com.mbridge.msdk.reward.adapter.c r3 = r1.p
            if (r3 == 0) goto L_0x05ba
            r3 = r20
            boolean r3 = r3.a(r10)
            if (r3 != 0) goto L_0x05ba
            com.mbridge.msdk.reward.adapter.c r3 = r1.p
            r3.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r0)
        L_0x05ba:
            r3 = 0
            r1.ad = r3
            com.mbridge.msdk.reward.b.a$c r0 = r1.t
            boolean r3 = r1.J
            r0.a((boolean) r3)
            r3 = r21
            r14.put(r12, r3)
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()
            r0.c(r13, r2, r14)
            com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()
            r0.c(r13, r15, r14)
            java.util.Queue<java.lang.Integer> r0 = r1.U
            r2 = r23
            r1.a((java.util.Queue<java.lang.Integer>) r0, (boolean) r2, (java.lang.String) r10, (java.util.Map<java.lang.String, java.lang.String>) r11)
            goto L_0x0623
        L_0x05df:
            com.mbridge.msdk.videocommon.a.a r0 = com.mbridge.msdk.videocommon.a.a.a()
            java.lang.String r3 = r1.v
            r0.a((java.lang.String) r3, (java.lang.String) r10)
            if (r2 == 0) goto L_0x0623
            com.mbridge.msdk.reward.b.a$c r0 = r1.t
            if (r0 == 0) goto L_0x0623
            com.mbridge.msdk.foundation.entity.e r10 = new com.mbridge.msdk.foundation.entity.e
            r0 = 19
            r10.<init>(r0, r7)
            if (r11 == 0) goto L_0x0605
            boolean r0 = r11.containsKey(r4)     // Catch:{ Exception -> 0x0614 }
            if (r0 == 0) goto L_0x0605
            java.lang.Object r0 = r11.get(r4)     // Catch:{ Exception -> 0x0614 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0614 }
            r16 = r0
        L_0x0605:
            r8 = 0
            android.content.Context r9 = r1.n     // Catch:{ Exception -> 0x0614 }
            java.lang.String r11 = r1.v     // Catch:{ Exception -> 0x0614 }
            boolean r12 = r1.J     // Catch:{ Exception -> 0x0614 }
            java.lang.String r13 = ""
            java.lang.String r14 = ""
            com.mbridge.msdk.reward.c.a.a(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0614 }
            goto L_0x061c
        L_0x0614:
            r0 = move-exception
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r2 == 0) goto L_0x061c
            r0.printStackTrace()
        L_0x061c:
            r0 = r16
            com.mbridge.msdk.reward.b.a$c r2 = r1.t
            com.mbridge.msdk.reward.b.a.c.d(r2, r7, r0)
        L_0x0623:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.b(boolean, java.lang.String, java.util.Map):void");
    }

    private void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, String str, String str2) {
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            HashMap hashMap = new HashMap();
            this.ad = true;
            this.t.a(this.J);
            c.e(this.t, this.A, this.v);
            CampaignEx campaignEx = copyOnWriteArrayList.get(0);
            a(campaignEx.getRequestId(), str);
            com.mbridge.msdk.reward.adapter.c cVar = this.p;
            if (cVar == null || !cVar.a((List<CampaignEx>) copyOnWriteArrayList, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt())) {
                a(copyOnWriteArrayList, this.p);
            } else {
                a((List<CampaignEx>) copyOnWriteArrayList);
                this.t.b(this.A, this.v);
            }
            try {
                m a2 = m.a();
                String str3 = this.v;
                a2.a(str2, str3, copyOnWriteArrayList.get(0).getAdType() + "", "1", str);
                hashMap.put("cache", "1");
                m.a().c(str2, "2000127", hashMap);
                m.a().c(str2, "2000048", hashMap);
                if (copyOnWriteArrayList.size() > 1) {
                    m.a().b((List<CampaignEx>) copyOnWriteArrayList);
                } else {
                    m.a().a(copyOnWriteArrayList.get(0));
                }
            } catch (Exception e2) {
                aa.d("RewardVideoController", e2.getMessage());
            }
        }
    }

    private CopyOnWriteArrayList<CampaignEx> a(String str, List<CampaignEx> list) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (list != null) {
            try {
                if (list.size() > 0) {
                    int i2 = 1;
                    for (CampaignEx next : list) {
                        if (next != null) {
                            if (next.getVcn() > i2) {
                                i2 = next.getVcn();
                            }
                            if (next.getTokenRule() == 1) {
                                String requestId = next.getRequestId();
                                if (!TextUtils.isEmpty(requestId)) {
                                    if (linkedHashMap.containsKey(requestId)) {
                                        ((List) linkedHashMap.get(requestId)).add(next);
                                    } else {
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(next);
                                        linkedHashMap.put(requestId, arrayList);
                                    }
                                }
                            } else {
                                String requestId2 = next.getRequestId();
                                if (!TextUtils.isEmpty(requestId2)) {
                                    if (linkedHashMap2.containsKey(requestId2)) {
                                        ((List) linkedHashMap2.get(requestId2)).add(next);
                                    } else {
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.add(next);
                                        linkedHashMap2.put(requestId2, arrayList2);
                                    }
                                }
                            }
                        }
                    }
                    if (!(linkedHashMap2.size() + linkedHashMap.size() < i2 || linkedHashMap.size() <= 0 || linkedHashMap.entrySet() == null || linkedHashMap.entrySet().iterator() == null || linkedHashMap.entrySet().iterator().next() == null || ((Map.Entry) linkedHashMap.entrySet().iterator().next()).getValue() == null)) {
                        copyOnWriteArrayList.addAll((Collection) ((Map.Entry) linkedHashMap.entrySet().iterator().next()).getValue());
                        com.mbridge.msdk.foundation.same.a.d.a(this.v, str, i2);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return copyOnWriteArrayList;
    }

    private CopyOnWriteArrayList<CampaignEx> b(String str, List<CampaignEx> list) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            for (CampaignEx next : list) {
                if (next != null && str.equals(next.getBidToken())) {
                    copyOnWriteArrayList.add(next);
                }
            }
        }
        return copyOnWriteArrayList;
    }

    private void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.reward.adapter.c cVar) {
        final CampaignEx campaignEx = copyOnWriteArrayList.get(0);
        final boolean z2 = !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl());
        final int nscpt = campaignEx.getNscpt();
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        com.mbridge.msdk.reward.adapter.b a2 = com.mbridge.msdk.reward.adapter.b.a();
        Context context = this.n;
        boolean z3 = this.J;
        int i2 = this.I ? 287 : 94;
        final boolean z4 = z2;
        final CampaignEx campaignEx2 = campaignEx;
        final com.mbridge.msdk.reward.adapter.c cVar2 = cVar;
        final int i3 = nscpt;
        int i4 = nscpt;
        final boolean z5 = z2;
        CampaignEx campaignEx3 = campaignEx;
        a2.a(context, z2, nscpt, z3, i2, this.A, this.v, campaignEx.getRequestId(), copyOnWriteArrayList, new b.c() {
            public final void a(String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
                String str4 = str2;
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = copyOnWriteArrayList;
                a.this.i = true;
                if (!z4) {
                    Iterator<CampaignEx> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        final CampaignEx next = it.next();
                        if (next == null || next.getRewardTemplateMode() == null || TextUtils.isEmpty(next.getRewardTemplateMode().e()) || next.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY) || a.this.D == null) {
                            com.mbridge.msdk.reward.adapter.c cVar = cVar2;
                            if (cVar == null || !cVar.a((List<CampaignEx>) copyOnWriteArrayList2, z4, i3)) {
                                String str5 = str;
                                a aVar = a.this;
                                a.a(aVar, str4, aVar.af);
                                if (a.this.t != null && !a.this.l) {
                                    a.this.l = true;
                                    aa.a("RewardVideoController", "Cache onVideoLoadFailForCache");
                                    com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e(15, "errorCode: 3503 errorMessage: have no temp but isReady false");
                                    if (a.this.ae != null && a.this.ae.size() > 0) {
                                        com.mbridge.msdk.reward.c.a.a((CampaignEx) a.this.ae.get(0), a.this.n, eVar, a.this.v, a.this.J, str3, next.getRequestIdNotice());
                                    }
                                    c.a(a.this.t, eVar.e());
                                }
                            } else if (a.this.t != null && !a.this.m) {
                                a.this.m = true;
                                aa.a("RewardVideoController", "Cache onVideoLoadSuccessForCache");
                                a.this.a((List<CampaignEx>) copyOnWriteArrayList2);
                                a.this.t.b(str, str4);
                            }
                        } else {
                            final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList3 = copyOnWriteArrayList;
                            final String str6 = str;
                            final String str7 = str2;
                            final String str8 = str3;
                            a.this.D.post(new Runnable() {
                                public final void run() {
                                    com.mbridge.msdk.reward.adapter.b a2 = com.mbridge.msdk.reward.adapter.b.a();
                                    boolean u = a.this.N;
                                    Handler t = a.this.D;
                                    boolean r = a.this.I;
                                    boolean i = a.this.J;
                                    String e2 = next.getRewardTemplateMode().e();
                                    int v = a.this.E;
                                    CampaignEx campaignEx = campaignEx2;
                                    CopyOnWriteArrayList copyOnWriteArrayList = copyOnWriteArrayList3;
                                    String b2 = com.mbridge.msdk.videocommon.download.g.a().b(next.getRewardTemplateMode().e());
                                    String str = str6;
                                    String str2 = str7;
                                    String str3 = str8;
                                    String requestIdNotice = next.getRequestIdNotice();
                                    com.mbridge.msdk.videocommon.d.c p = a.this.q;
                                    AnonymousClass1 r17 = r6;
                                    AnonymousClass1 r6 = new b.j() {
                                        public final void a(String str, String str2, String str3, String str4, String str5, a.C0158a aVar) {
                                            if (cVar2 == null || !cVar2.a((List<CampaignEx>) copyOnWriteArrayList3, z4, i3)) {
                                                a.a(a.this, str3, a.this.af);
                                                if (a.this.t != null && !a.this.l) {
                                                    a.this.l = true;
                                                    com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e(15, "errorCode: 3502 errorMessage: temp preload success but isReady false");
                                                    if (a.this.ae != null && a.this.ae.size() > 0) {
                                                        com.mbridge.msdk.reward.c.a.a((CampaignEx) a.this.ae.get(0), a.this.n, eVar, a.this.v, a.this.J, str4, next.getRequestIdNotice());
                                                    }
                                                    c.a(a.this.t, eVar.e());
                                                }
                                            } else if (a.this.t != null && !a.this.m) {
                                                a.this.m = true;
                                                a.this.a((List<CampaignEx>) copyOnWriteArrayList3);
                                                a.this.t.b(str2, str3);
                                            }
                                        }

                                        public final void a(String str, String str2, String str3, String str4, String str5, a.C0158a aVar, com.mbridge.msdk.foundation.entity.e eVar) {
                                            a.a(a.this, str3, a.this.af);
                                            if (a.this.t != null && !a.this.l) {
                                                a.this.l = true;
                                                if (a.this.ae != null && a.this.ae.size() > 0) {
                                                    eVar.b("errorCode: 3301 errorMessage: temp preload failed: " + eVar.e());
                                                    com.mbridge.msdk.reward.c.a.a((CampaignEx) a.this.ae.get(0), a.this.n, eVar, a.this.v, a.this.J, str4, next.getRequestIdNotice());
                                                }
                                                c.a(a.this.t, eVar.e());
                                            }
                                        }
                                    };
                                    a2.a(u, t, r, i, (WindVaneWebView) null, e2, v, campaignEx, copyOnWriteArrayList, b2, str, str2, str3, requestIdNotice, p, r17);
                                }
                            });
                        }
                        String str9 = str;
                    }
                    return;
                }
                String str10 = str;
                if (a.this.j && !a.this.k && a.this.D != null) {
                    a.this.k = true;
                    final String str11 = str3;
                    final String str12 = str;
                    final String str13 = str2;
                    final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList4 = copyOnWriteArrayList;
                    a.this.D.post(new Runnable() {
                        public final void run() {
                            com.mbridge.msdk.reward.adapter.b a2 = com.mbridge.msdk.reward.adapter.b.a();
                            boolean u = a.this.N;
                            Handler t = a.this.D;
                            boolean r = a.this.I;
                            boolean i = a.this.J;
                            String str = str11;
                            String requestIdNotice = campaignEx2.getRequestIdNotice();
                            String str2 = str12;
                            String str3 = str13;
                            String cMPTEntryUrl = campaignEx2.getCMPTEntryUrl();
                            int v = a.this.E;
                            CampaignEx campaignEx = campaignEx2;
                            CopyOnWriteArrayList copyOnWriteArrayList = copyOnWriteArrayList4;
                            String b2 = com.mbridge.msdk.videocommon.download.g.a().b(campaignEx2.getCMPTEntryUrl());
                            String str4 = str13;
                            com.mbridge.msdk.reward.adapter.b bVar = a2;
                            com.mbridge.msdk.videocommon.d.c p = a.this.q;
                            AnonymousClass1 r17 = r1;
                            AnonymousClass1 r1 = new b.j() {
                                public final void a(String str, String str2, String str3, String str4, String str5, a.C0158a aVar) {
                                    if (cVar2 == null || !cVar2.a((List<CampaignEx>) copyOnWriteArrayList4, z4, i3)) {
                                        a.a(a.this, str3, a.this.af);
                                        if (a.this.t != null && !a.this.l) {
                                            a.this.l = true;
                                            com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e(15, "errorCode: 3504 errorMessage: tpl temp preload success but isReady false");
                                            if (a.this.ae != null && a.this.ae.size() > 0) {
                                                com.mbridge.msdk.reward.c.a.a((CampaignEx) a.this.ae.get(0), a.this.n, eVar, a.this.v, a.this.J, str4, campaignEx2.getRequestIdNotice());
                                            }
                                            c.a(a.this.t, eVar.e());
                                        }
                                    } else if (a.this.t != null && !a.this.m) {
                                        a.this.m = true;
                                        aa.a("RewardVideoController", "Cache onVideoLoadSuccessForCache");
                                        a.this.a((List<CampaignEx>) copyOnWriteArrayList4);
                                        a.this.t.b(str2, str3);
                                    }
                                }

                                public final void a(String str, String str2, String str3, String str4, String str5, a.C0158a aVar, com.mbridge.msdk.foundation.entity.e eVar) {
                                    a.a(a.this, str3, a.this.af);
                                    if (a.this.t != null && !a.this.l) {
                                        a.this.l = true;
                                        if (a.this.ae != null && a.this.ae.size() > 0) {
                                            eVar.b("errorCode: 3302 errorMessage: tpl temp preload failed: " + eVar.e());
                                            com.mbridge.msdk.reward.c.a.a((CampaignEx) a.this.ae.get(0), a.this.n, eVar, a.this.v, a.this.J, str4, campaignEx2.getRequestIdNotice());
                                        }
                                        c.a(a.this.t, eVar.e());
                                    }
                                }
                            };
                            bVar.a(u, t, r, i, str, requestIdNotice, str2, str3, cMPTEntryUrl, v, campaignEx, copyOnWriteArrayList, b2, str4, p, r17, true);
                        }
                    });
                }
            }

            public final void a(String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.foundation.entity.e eVar) {
                a.this.i = false;
                a aVar = a.this;
                a.a(aVar, str2, aVar.af);
                if (a.this.t != null && !a.this.l) {
                    a.this.l = true;
                    if (a.this.ae != null && a.this.ae.size() > 0) {
                        eVar.b("errorCode: 3201 errorMessage: campaign resource download failed");
                        com.mbridge.msdk.reward.c.a.a((CampaignEx) a.this.ae.get(0), a.this.n, eVar, a.this.v, a.this.J, str3, campaignEx2.getRequestIdNotice());
                    }
                    c.a(a.this.t, eVar.e());
                }
            }
        }, new b.i() {
            public final void a(String str, String str2, String str3, String str4) {
            }

            public final void a(String str, String str2, String str3, String str4, com.mbridge.msdk.foundation.entity.e eVar) {
                a aVar = a.this;
                a.a(aVar, str2, aVar.af);
                if (z2 || a.this.t == null) {
                    if (nscpt == 1 && !a.this.l && a.this.t != null) {
                        a.this.l = true;
                        if (a.this.ae != null && a.this.ae.size() > 0) {
                            eVar.b("errorCode: 3202 errorMessage: temp resource download failed");
                            com.mbridge.msdk.reward.c.a.a((CampaignEx) a.this.ae.get(0), a.this.n, eVar, a.this.v, a.this.J, str3, campaignEx.getRequestIdNotice());
                        }
                        c.a(a.this.t, eVar.e());
                    }
                } else if (!a.this.l) {
                    a.this.l = true;
                    if (a.this.ae != null && a.this.ae.size() > 0) {
                        eVar.b("errorCode: 3202 errorMessage: temp resource download failed");
                        com.mbridge.msdk.reward.c.a.a((CampaignEx) a.this.ae.get(0), a.this.n, eVar, a.this.v, a.this.J, str3, campaignEx.getRequestIdNotice());
                    }
                    c.a(a.this.t, eVar.e());
                }
            }
        });
        if (z5) {
            final CampaignEx campaignEx4 = campaignEx3;
            final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = copyOnWriteArrayList;
            final com.mbridge.msdk.reward.adapter.c cVar3 = cVar;
            final int i5 = i4;
            com.mbridge.msdk.reward.adapter.b.a().a(this.n, campaignEx3, this.A, this.v, campaignEx3.getRequestId(), new b.i() {
                public final void a(final String str, final String str2, final String str3, String str4) {
                    a.this.j = true;
                    if (a.this.i && !a.this.k && a.this.D != null) {
                        a.this.k = true;
                        a.this.D.post(new Runnable() {
                            public final void run() {
                                com.mbridge.msdk.reward.adapter.b a2 = com.mbridge.msdk.reward.adapter.b.a();
                                boolean u = a.this.N;
                                Handler t = a.this.D;
                                boolean r = a.this.I;
                                boolean i = a.this.J;
                                String str = str3;
                                String requestIdNotice = campaignEx4.getRequestIdNotice();
                                String str2 = str;
                                String str3 = str2;
                                String cMPTEntryUrl = campaignEx4.getCMPTEntryUrl();
                                int v = a.this.E;
                                CampaignEx campaignEx = campaignEx4;
                                CopyOnWriteArrayList copyOnWriteArrayList = copyOnWriteArrayList2;
                                String b2 = com.mbridge.msdk.videocommon.download.g.a().b(campaignEx4.getCMPTEntryUrl());
                                String str4 = str2;
                                com.mbridge.msdk.reward.adapter.b bVar = a2;
                                com.mbridge.msdk.videocommon.d.c p = a.this.q;
                                AnonymousClass1 r17 = r1;
                                AnonymousClass1 r1 = new b.j() {
                                    public final void a(String str, String str2, String str3, String str4, String str5, a.C0158a aVar) {
                                        if (cVar3 == null || !cVar3.a((List<CampaignEx>) copyOnWriteArrayList2, z5, i5)) {
                                            a.a(a.this, str3, a.this.af);
                                            if (a.this.t != null && !a.this.l) {
                                                a.this.l = true;
                                                com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e(15, "errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                                                if (a.this.ae != null && a.this.ae.size() > 0) {
                                                    com.mbridge.msdk.reward.c.a.a((CampaignEx) a.this.ae.get(0), a.this.n, eVar, a.this.v, a.this.J, str4, campaignEx4.getRequestIdNotice());
                                                }
                                                c.a(a.this.t, eVar.e());
                                            }
                                        } else if (a.this.t != null && !a.this.m) {
                                            a.this.m = true;
                                            aa.a("RewardVideoController", "Cache onVideoLoadSuccess");
                                            a.this.a((List<CampaignEx>) copyOnWriteArrayList2);
                                            a.this.t.b(str2, str3);
                                        }
                                    }

                                    public final void a(String str, String str2, String str3, String str4, String str5, a.C0158a aVar, com.mbridge.msdk.foundation.entity.e eVar) {
                                        a.a(a.this, str3, a.this.af);
                                        if (a.this.t != null && !a.this.l) {
                                            a.this.l = true;
                                            if (a.this.ae != null && a.this.ae.size() > 0) {
                                                eVar.b("errorCode: 3303 errorMessage: tpl temp preload failed: " + eVar.e());
                                                com.mbridge.msdk.reward.c.a.a((CampaignEx) a.this.ae.get(0), a.this.n, eVar, a.this.v, a.this.J, str4, campaignEx4.getRequestIdNotice());
                                            }
                                            c.a(a.this.t, eVar.e());
                                        }
                                    }
                                };
                                bVar.a(u, t, r, i, str, requestIdNotice, str2, str3, cMPTEntryUrl, v, campaignEx, copyOnWriteArrayList, b2, str4, p, r17, true);
                            }
                        });
                    }
                }

                public final void a(String str, String str2, String str3, String str4, com.mbridge.msdk.foundation.entity.e eVar) {
                    a aVar = a.this;
                    a.a(aVar, str2, aVar.af);
                    a.this.j = false;
                    if (a.this.t != null && !a.this.l) {
                        a.this.l = true;
                        if (a.this.ae != null && a.this.ae.size() > 0) {
                            eVar.b("errorCode: 3203 errorMessage: tpl temp resource download failed");
                            com.mbridge.msdk.reward.c.a.a((CampaignEx) a.this.ae.get(0), a.this.n, eVar, a.this.v, a.this.J, str3, campaignEx4.getRequestIdNotice());
                        }
                        c.a(a.this.t, eVar.e());
                    }
                }
            });
        }
    }

    private boolean c(String str, String str2) {
        try {
            com.mbridge.msdk.reward.adapter.c cVar = this.p;
            if (cVar == null || !str.equals(cVar.b())) {
                com.mbridge.msdk.reward.adapter.c cVar2 = new com.mbridge.msdk.reward.adapter.c(this.n, this.A, str);
                this.p = cVar2;
                cVar2.b(this.I);
                this.p.c(this.J);
            }
            this.p.a(this.E);
            this.p.a(this.q);
        } catch (Exception unused) {
        }
        List<CampaignEx> a2 = com.mbridge.msdk.videocommon.a.a.a().a(str, 1, this.J);
        this.af = com.mbridge.msdk.videocommon.a.a.a().b(str, 1, this.J);
        if (a2 == null || a2.size() <= 0) {
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.ae;
            if (copyOnWriteArrayList == null) {
                return false;
            }
            copyOnWriteArrayList.clear();
            return false;
        }
        com.mbridge.msdk.videocommon.a.a.a().a(str, a2, str2);
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = this.ae;
        if (copyOnWriteArrayList2 == null) {
            this.ae = new CopyOnWriteArrayList<>();
        } else {
            copyOnWriteArrayList2.clear();
        }
        for (CampaignEx next : a2) {
            next.setLocalRequestId(str2);
            this.ae.add(next);
        }
        a((List<CampaignEx>) this.ae);
        return true;
    }

    /* compiled from: RewardVideoController */
    private final class c {
        private WeakReference<InterVideoOutListener> b;
        /* access modifiers changed from: private */
        public volatile AtomicInteger c;
        private Handler d;
        private String e;
        private boolean f;

        private c(InterVideoOutListener interVideoOutListener, Handler handler, String str) {
            this.b = new WeakReference<>(interVideoOutListener);
            this.c = new AtomicInteger(0);
            this.d = handler;
            this.e = str;
        }

        /* access modifiers changed from: private */
        public void a(String str, String str2) {
            Handler handler = this.d;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            if (this.b != null && this.c.get() != 2 && this.d != null) {
                this.c.set(2);
                if (!a.this.aa) {
                    boolean unused = a.this.aa = true;
                    if (((InterVideoOutListener) this.b.get()) != null) {
                        Message obtain = Message.obtain();
                        Bundle bundle = new Bundle();
                        bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                        bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                        obtain.setData(bundle);
                        obtain.obj = str2;
                        obtain.what = 9;
                        this.d.sendMessage(obtain);
                    } else if (a.this.M && ac.a().a("r_l_b_m_t_r_i", true)) {
                        m.a().a("2000048", a.this.w.getLocalRequestId(), (List<CampaignEx>) a.this.R, a.this.v, "");
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public void b(String str, String str2) {
            Handler handler = this.d;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            if (this.b != null && this.c.get() != 2 && this.d != null) {
                if (this.c.get() == 1) {
                    this.c.set(3);
                }
                if (!a.this.aa) {
                    boolean unused = a.this.aa = true;
                    if (((InterVideoOutListener) this.b.get()) != null) {
                        Message obtain = Message.obtain();
                        Bundle bundle = new Bundle();
                        bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                        bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                        obtain.setData(bundle);
                        obtain.obj = str2;
                        obtain.what = 9;
                        this.d.sendMessage(obtain);
                    } else if (a.this.M && ac.a().a("r_l_b_m_t_r_i", true)) {
                        m.a().a("2000048", a.this.w.getLocalRequestId(), (List<CampaignEx>) a.this.R, a.this.v, "");
                    }
                    if (a.this.ab) {
                        this.c.set(2);
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public void c(String str, String str2) {
            if (this.d != null) {
                Message obtain = Message.obtain();
                obtain.obj = str;
                obtain.what = 18;
                if (!TextUtils.isEmpty(str2)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("local_id", str2);
                    obtain.setData(bundle);
                }
                this.d.sendMessage(obtain);
            }
        }

        public final void a(boolean z) {
            this.f = z;
        }

        static /* synthetic */ void a(c cVar, String str, boolean z) {
            if (a.this.p != null) {
                a.this.p.a((com.mbridge.msdk.reward.adapter.a) a.this.a);
                CopyOnWriteArrayList<CampaignEx> f2 = a.this.p.f();
                CampaignEx campaignEx = (a.this.R == null || a.this.R.size() == 0) ? null : (CampaignEx) a.this.R.get(0);
                if (campaignEx == null) {
                    campaignEx = (f2 == null || f2.size() == 0) ? null : f2.get(0);
                }
                if (!a.this.J || ((campaignEx != null && !TextUtils.isEmpty(campaignEx.getNLRid())) || !(f2 == null || f2.size() == 0))) {
                    if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getNLRid())) {
                        try {
                            com.mbridge.msdk.foundation.entity.e b2 = m.a().b(cVar.e, str);
                            if (b2 != null) {
                                b2.a(campaignEx.getErrReasonByDefaultAd());
                                b2.a(campaignEx.getErrTypeByDefaultAd());
                                m.a().a(cVar.e, b2);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                } else if (a.this.p.a(campaignEx, z, m.a().b(cVar.e, str), 2)) {
                    return;
                }
                a.this.p.a((com.mbridge.msdk.reward.adapter.a) null);
            }
            Handler handler = cVar.d;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            if (cVar.b != null && cVar.c.get() != 2 && cVar.d != null) {
                boolean unused = a.this.ab = true;
                if (!a.this.ad || str.contains("resource load timeout")) {
                    boolean unused2 = a.this.ac = true;
                }
                if (a.this.aa) {
                    cVar.c.set(2);
                }
                if (a.this.ab && a.this.ac && !a.this.aa) {
                    cVar.c.set(2);
                    if (((InterVideoOutListener) cVar.b.get()) != null) {
                        Message obtain = Message.obtain();
                        obtain.obj = str;
                        obtain.what = 16;
                        cVar.d.sendMessage(obtain);
                    } else if (a.this.M && ac.a().a("r_l_b_m_t_r_i", true)) {
                        m.a().a("2000047", a.this.x, (List<CampaignEx>) a.this.R, a.this.v, str);
                    }
                }
            }
        }

        static /* synthetic */ void d(c cVar, String str, String str2) {
            cVar.c.set(2);
            cVar.c(str, str2);
        }

        static /* synthetic */ void e(c cVar, String str, String str2) {
            WeakReference<InterVideoOutListener> weakReference = cVar.b;
            if (weakReference != null && ((InterVideoOutListener) weakReference.get()) != null && cVar.d != null && !a.this.Z) {
                boolean unused = a.this.Z = true;
                Message obtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                bundle.putBoolean(MBridgeConstans.PROPERTIES_IS_CACHED_CAMPAIGN, true);
                obtain.setData(bundle);
                obtain.obj = str2;
                obtain.what = 17;
                cVar.d.sendMessage(obtain);
                if (ac.a().a("l_s_i_l_v_s", false)) {
                    cVar.b(str, str2);
                }
            }
        }

        static /* synthetic */ void a(c cVar, String str) {
            if (cVar.b != null && cVar.c.get() != 2 && cVar.d != null) {
                boolean unused = a.this.ac = true;
                if (str.contains("resource load timeout")) {
                    boolean unused2 = a.this.ab = true;
                }
                if (a.this.ac && a.this.ab && !a.this.aa) {
                    cVar.c.set(2);
                    Message obtain = Message.obtain();
                    InterVideoOutListener interVideoOutListener = (InterVideoOutListener) cVar.b.get();
                    try {
                        com.mbridge.msdk.foundation.entity.e b2 = m.a().b(cVar.e, str);
                        if (b2 != null) {
                            b2.a(true);
                            m.a().a(cVar.e, b2);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (interVideoOutListener != null) {
                        obtain.obj = str;
                        obtain.what = 16;
                        cVar.d.sendMessage(obtain);
                    } else if (a.this.M && ac.a().a("r_l_b_m_t_r_i", true)) {
                        m.a().a("2000047", a.this.x, (List<CampaignEx>) a.this.R, a.this.v, str);
                    }
                }
            }
        }

        static /* synthetic */ void f(c cVar, String str, String str2) {
            WeakReference<InterVideoOutListener> weakReference = cVar.b;
            if (weakReference != null && ((InterVideoOutListener) weakReference.get()) != null) {
                if ((cVar.c.get() == 1 || cVar.c.get() == 3) && cVar.d != null && !a.this.Z) {
                    boolean unused = a.this.Z = true;
                    Message obtain = Message.obtain();
                    Bundle bundle = new Bundle();
                    bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                    bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                    bundle.putBoolean(MBridgeConstans.PROPERTIES_IS_CACHED_CAMPAIGN, false);
                    obtain.setData(bundle);
                    obtain.obj = str2;
                    obtain.what = 17;
                    cVar.d.sendMessage(obtain);
                    if (ac.a().a("l_s_i_l_v_s", false)) {
                        cVar.a(str, str2);
                    }
                }
            }
        }
    }

    private void f() {
        try {
            List<com.mbridge.msdk.videocommon.b.b> y2 = this.q.y();
            if (y2 != null && y2.size() > 0) {
                for (int i2 = 0; i2 < y2.size(); i2++) {
                    Context context = this.n;
                    ai.a(context, this.A + "_" + y2.get(i2).a(), 0);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean g() {
        int i2;
        try {
            List<com.mbridge.msdk.videocommon.b.b> y2 = this.q.y();
            if (this.r == null) {
                this.r = com.mbridge.msdk.videocommon.d.b.a().b();
            }
            Map<String, Integer> j2 = this.r.j();
            if (y2 == null || y2.size() <= 0) {
                return true;
            }
            for (int i3 = 0; i3 < y2.size(); i3++) {
                com.mbridge.msdk.videocommon.b.b bVar = y2.get(i3);
                if (j2.containsKey(bVar.a() + "")) {
                    i2 = j2.get(bVar.a() + "").intValue();
                } else {
                    i2 = 0;
                }
                Context context = this.n;
                Object b2 = ai.b(context, this.A + "_" + bVar.a(), 0);
                if ((b2 != null ? ((Integer) b2).intValue() : 0) < i2) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            aa.d("RewardVideoController", e2.getMessage());
            return true;
        }
    }

    private void a(Queue<Integer> queue, boolean z2, String str, Map<String, String> map) {
        int i2;
        if (queue != null) {
            try {
                if (queue.size() > 0) {
                    i2 = queue.poll().intValue();
                    this.w.setLocalRequestId(map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID));
                    a(1, i2, z2, str, map);
                }
            } catch (Exception e2) {
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.ae;
                if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                    com.mbridge.msdk.reward.c.a.a(this.ae.get(0), this.n, new com.mbridge.msdk.foundation.entity.e(0, "can't show because unknow error"), this.v, this.J, "", "");
                }
                b("can't show because unknow error");
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                    return;
                }
                return;
            }
        }
        i2 = 25;
        this.w.setLocalRequestId(map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID));
        try {
            a(1, i2, z2, str, map);
        } catch (Exception e3) {
            Exception exc = e3;
            if (this.ae != null) {
                if (this.ae.size() > 0) {
                    com.mbridge.msdk.reward.c.a.a(this.ae.get(0), this.n, new com.mbridge.msdk.foundation.entity.e(0, "load mv api error:" + exc.getMessage()), this.v, this.J, "", "");
                }
            }
            b("load mv api error:" + exc.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        if (this.t != null) {
            this.ac = true;
            c.a(this.t, str, true);
        }
    }

    private void a(int i2, int i3, boolean z2, String str, Map<String, String> map) {
        try {
            com.mbridge.msdk.reward.adapter.c cVar = this.p;
            if (cVar == null || !this.v.equals(cVar.b())) {
                com.mbridge.msdk.reward.adapter.c cVar2 = new com.mbridge.msdk.reward.adapter.c(this.n, this.A, this.v);
                this.p = cVar2;
                cVar2.b(this.I);
                this.p.c(this.J);
            }
            if (this.I) {
                this.p.a(this.F, this.G, this.H);
            }
            this.p.a(this.E);
            this.p.a(this.q);
            C0152a aVar = new C0152a(this.p, i2, z2, str);
            aVar.a(map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID));
            aVar.a(i3);
            b bVar = new b(this.p, z2);
            this.a = bVar;
            bVar.a(aVar);
            this.p.a((com.mbridge.msdk.reward.adapter.a) this.a);
            this.w.setLocalRequestId(map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID));
            this.y = map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
            this.p.a(i2, i3, z2, str, this.N, map);
            this.D.postDelayed(aVar, (long) (i3 * 1000));
        } catch (Exception e2) {
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.ae;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                com.mbridge.msdk.reward.c.a.a(this.ae.get(0), this.n, new com.mbridge.msdk.foundation.entity.e(0, e2.getMessage()), this.v, this.J, "", "");
            }
            b(e2.getMessage());
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:64|65|66|67|68|115) */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r2 = r2.j();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x0181 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(java.lang.String r21) {
        /*
            r20 = this;
            r7 = r20
            java.lang.String r8 = "local_rid"
            java.lang.String r0 = "1"
            java.lang.String r9 = "RewardVideoController"
            java.lang.String r1 = "_1"
            r4 = 1
            r10 = 3
            r11 = 1
            r12 = 4
            r13 = 0
            com.mbridge.msdk.videocommon.d.a r2 = r7.r     // Catch:{ Exception -> 0x0185 }
            if (r2 == 0) goto L_0x002a
            java.util.Map r2 = r2.j()     // Catch:{ Exception -> 0x0185 }
            if (r2 == 0) goto L_0x002a
            boolean r3 = r2.containsKey(r0)     // Catch:{ Exception -> 0x0185 }
            if (r3 == 0) goto L_0x002a
            java.lang.Object r0 = r2.get(r0)     // Catch:{ Exception -> 0x0185 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x0185 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x0185 }
            goto L_0x002b
        L_0x002a:
            r0 = 0
        L_0x002b:
            android.content.Context r2 = r7.n     // Catch:{ Exception -> 0x0185 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0185 }
            r3.<init>()     // Catch:{ Exception -> 0x0185 }
            java.lang.String r5 = r7.A     // Catch:{ Exception -> 0x0185 }
            r3.append(r5)     // Catch:{ Exception -> 0x0185 }
            r3.append(r1)     // Catch:{ Exception -> 0x0185 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0185 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r13)     // Catch:{ Exception -> 0x0185 }
            java.lang.Object r2 = com.mbridge.msdk.foundation.tools.ai.b(r2, r3, r5)     // Catch:{ Exception -> 0x0185 }
            if (r2 == 0) goto L_0x006b
            android.content.Context r2 = r7.n     // Catch:{ Exception -> 0x0185 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0185 }
            r3.<init>()     // Catch:{ Exception -> 0x0185 }
            java.lang.String r5 = r7.A     // Catch:{ Exception -> 0x0185 }
            r3.append(r5)     // Catch:{ Exception -> 0x0185 }
            r3.append(r1)     // Catch:{ Exception -> 0x0185 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0185 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r13)     // Catch:{ Exception -> 0x0185 }
            java.lang.Object r2 = com.mbridge.msdk.foundation.tools.ai.b(r2, r3, r5)     // Catch:{ Exception -> 0x0185 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x0185 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x0185 }
            r7.o = r2     // Catch:{ Exception -> 0x0185 }
        L_0x006b:
            com.mbridge.msdk.reward.adapter.c r2 = r7.p     // Catch:{ Exception -> 0x0185 }
            if (r2 != 0) goto L_0x0072
            r20.j()     // Catch:{ Exception -> 0x0185 }
        L_0x0072:
            com.mbridge.msdk.reward.adapter.c r2 = r7.p     // Catch:{ Exception -> 0x0185 }
            if (r2 == 0) goto L_0x0100
            java.lang.String r2 = "controller 819"
            com.mbridge.msdk.foundation.tools.aa.d(r9, r2)     // Catch:{ Exception -> 0x0185 }
            boolean r2 = r7.J     // Catch:{ Exception -> 0x0185 }
            if (r2 == 0) goto L_0x0084
            boolean r2 = r20.h()     // Catch:{ Exception -> 0x0185 }
            goto L_0x008a
        L_0x0084:
            com.mbridge.msdk.reward.adapter.c r2 = r7.p     // Catch:{ Exception -> 0x0185 }
            boolean r2 = r2.c()     // Catch:{ Exception -> 0x0185 }
        L_0x008a:
            if (r2 == 0) goto L_0x00c0
            int r1 = r7.o     // Catch:{ Exception -> 0x0185 }
            if (r1 < r0) goto L_0x0095
            if (r0 <= 0) goto L_0x0095
            r7.e = r13     // Catch:{ Exception -> 0x0185 }
            return
        L_0x0095:
            java.lang.String r0 = "invoke adapter show isReady"
            com.mbridge.msdk.foundation.tools.aa.b(r9, r0)     // Catch:{ Exception -> 0x0185 }
            com.mbridge.msdk.reward.b.a$d r0 = new com.mbridge.msdk.reward.b.a$d     // Catch:{ Exception -> 0x0185 }
            android.os.Handler r5 = r7.D     // Catch:{ Exception -> 0x0185 }
            r6 = 0
            r4 = 1
            r1 = r0
            r2 = r20
            r3 = r20
            r1.<init>(r3, r4, r5)     // Catch:{ Exception -> 0x0185 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.reward.b.a$d> r1 = h     // Catch:{ Exception -> 0x0185 }
            java.lang.String r2 = r7.v     // Catch:{ Exception -> 0x0185 }
            r1.put(r2, r0)     // Catch:{ Exception -> 0x0185 }
            com.mbridge.msdk.reward.adapter.c r1 = r7.p     // Catch:{ Exception -> 0x0185 }
            java.lang.String r4 = r7.u     // Catch:{ Exception -> 0x0185 }
            int r5 = r7.E     // Catch:{ Exception -> 0x0185 }
            java.lang.String r6 = r7.z     // Catch:{ Exception -> 0x0185 }
            r2 = r0
            r3 = r21
            r1.a((com.mbridge.msdk.video.bt.module.b.h) r2, (java.lang.String) r3, (java.lang.String) r4, (int) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x0185 }
            r7.e = r13     // Catch:{ Exception -> 0x0185 }
            return
        L_0x00c0:
            boolean r0 = r7.J     // Catch:{ Exception -> 0x0185 }
            if (r0 == 0) goto L_0x00c9
            boolean r0 = r20.i()     // Catch:{ Exception -> 0x0185 }
            goto L_0x00cf
        L_0x00c9:
            com.mbridge.msdk.reward.adapter.c r0 = r7.p     // Catch:{ Exception -> 0x0185 }
            boolean r0 = r0.d()     // Catch:{ Exception -> 0x0185 }
        L_0x00cf:
            if (r0 == 0) goto L_0x0100
            java.lang.String r0 = "invoke adapter show isSpareOfferReady"
            com.mbridge.msdk.foundation.tools.aa.b(r9, r0)     // Catch:{ Exception -> 0x0185 }
            com.mbridge.msdk.reward.b.a$d r15 = new com.mbridge.msdk.reward.b.a$d     // Catch:{ Exception -> 0x0185 }
            android.os.Handler r5 = r7.D     // Catch:{ Exception -> 0x0185 }
            r6 = 0
            r1 = r15
            r2 = r20
            r3 = r20
            r1.<init>(r3, r4, r5)     // Catch:{ Exception -> 0x0185 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.reward.b.a$d> r0 = h     // Catch:{ Exception -> 0x0185 }
            java.lang.String r1 = r7.v     // Catch:{ Exception -> 0x0185 }
            r0.put(r1, r15)     // Catch:{ Exception -> 0x0185 }
            com.mbridge.msdk.reward.adapter.c r14 = r7.p     // Catch:{ Exception -> 0x0185 }
            java.lang.String r0 = r7.u     // Catch:{ Exception -> 0x0185 }
            int r1 = r7.E     // Catch:{ Exception -> 0x0185 }
            java.lang.String r2 = r7.z     // Catch:{ Exception -> 0x0185 }
            r16 = r21
            r17 = r0
            r18 = r1
            r19 = r2
            r14.a((com.mbridge.msdk.video.bt.module.b.h) r15, (java.lang.String) r16, (java.lang.String) r17, (int) r18, (java.lang.String) r19)     // Catch:{ Exception -> 0x0185 }
            r7.e = r13     // Catch:{ Exception -> 0x0185 }
            return
        L_0x0100:
            int r0 = r7.o     // Catch:{ Exception -> 0x0185 }
            if (r0 == 0) goto L_0x0122
            android.content.Context r0 = r7.n     // Catch:{ Exception -> 0x0185 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0185 }
            r2.<init>()     // Catch:{ Exception -> 0x0185 }
            java.lang.String r3 = r7.A     // Catch:{ Exception -> 0x0185 }
            r2.append(r3)     // Catch:{ Exception -> 0x0185 }
            r2.append(r1)     // Catch:{ Exception -> 0x0185 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0185 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)     // Catch:{ Exception -> 0x0185 }
            com.mbridge.msdk.foundation.tools.ai.a(r0, r1, r2)     // Catch:{ Exception -> 0x0185 }
            r20.c((java.lang.String) r21)     // Catch:{ Exception -> 0x0185 }
            return
        L_0x0122:
            r7.e = r13     // Catch:{ Exception -> 0x0185 }
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r0 = r7.s     // Catch:{ Exception -> 0x0185 }
            if (r0 == 0) goto L_0x013c
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r0 = r7.s     // Catch:{ Exception -> 0x0134 }
            java.lang.String r1 = b     // Catch:{ Exception -> 0x0134 }
            com.mbridge.msdk.out.MBridgeIds r2 = r7.w     // Catch:{ Exception -> 0x0134 }
            java.lang.String r3 = "can't show because load is failed"
            r0.onShowFail(r1, r2, r3)     // Catch:{ Exception -> 0x0134 }
            goto L_0x013c
        L_0x0134:
            r0 = move-exception
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0185 }
            if (r1 == 0) goto L_0x013c
            r0.printStackTrace()     // Catch:{ Exception -> 0x0185 }
        L_0x013c:
            boolean r0 = r7.I     // Catch:{ Exception -> 0x0185 }
            if (r0 != 0) goto L_0x01f4
            boolean r0 = r7.J     // Catch:{ Exception -> 0x0185 }
            if (r0 != 0) goto L_0x01f4
            com.mbridge.msdk.videocommon.d.c r0 = r7.q     // Catch:{ Exception -> 0x0185 }
            if (r0 == 0) goto L_0x01f4
            boolean r0 = r0.s(r12)     // Catch:{ Exception -> 0x0185 }
            if (r0 == 0) goto L_0x01f4
            com.mbridge.msdk.reward.b.a$c r0 = r7.t     // Catch:{ Exception -> 0x0185 }
            if (r0 == 0) goto L_0x01f4
            com.mbridge.msdk.reward.b.a$c r0 = r7.t     // Catch:{ Exception -> 0x0185 }
            int r0 = r0.c.get()     // Catch:{ Exception -> 0x0185 }
            if (r0 == r11) goto L_0x01f4
            com.mbridge.msdk.reward.b.a$c r0 = r7.t     // Catch:{ Exception -> 0x0185 }
            int r0 = r0.c.get()     // Catch:{ Exception -> 0x0185 }
            if (r0 == r10) goto L_0x01f4
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x0185 }
            r0.<init>()     // Catch:{ Exception -> 0x0185 }
            java.lang.String r1 = com.mbridge.msdk.foundation.tools.af.c()     // Catch:{ Exception -> 0x0181 }
            java.lang.String r1 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r1)     // Catch:{ Exception -> 0x0181 }
            r0.put(r8, r1)     // Catch:{ Exception -> 0x0181 }
            java.lang.String r14 = "2000123"
            java.lang.String r15 = r7.v     // Catch:{ Exception -> 0x0181 }
            java.lang.String r17 = "auto_load"
            r18 = 94
            r19 = 0
            r16 = r1
            com.mbridge.msdk.reward.c.a.a(r14, r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x0181 }
        L_0x0181:
            r7.a((boolean) r13, (java.util.Map<java.lang.String, java.lang.String>) r0)     // Catch:{ Exception -> 0x0185 }
            goto L_0x01f4
        L_0x0185:
            r0 = move-exception
            r7.e = r13
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L_0x0193
            java.lang.String r1 = r0.getLocalizedMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r9, r1)
        L_0x0193:
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r1 = r7.s
            if (r1 == 0) goto L_0x01ac
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r1 = r7.s     // Catch:{ Exception -> 0x01a4 }
            java.lang.String r2 = b     // Catch:{ Exception -> 0x01a4 }
            com.mbridge.msdk.out.MBridgeIds r3 = r7.w     // Catch:{ Exception -> 0x01a4 }
            java.lang.String r4 = "show exception"
            r1.onShowFail(r2, r3, r4)     // Catch:{ Exception -> 0x01a4 }
            goto L_0x01ac
        L_0x01a4:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L_0x01ac
            r0.printStackTrace()
        L_0x01ac:
            boolean r0 = r7.I
            if (r0 != 0) goto L_0x01f4
            boolean r0 = r7.J
            if (r0 != 0) goto L_0x01f4
            com.mbridge.msdk.videocommon.d.c r0 = r7.q
            if (r0 == 0) goto L_0x01f4
            boolean r0 = r0.s(r12)
            if (r0 == 0) goto L_0x01f4
            com.mbridge.msdk.reward.b.a$c r0 = r7.t
            if (r0 == 0) goto L_0x01f4
            com.mbridge.msdk.reward.b.a$c r0 = r7.t
            int r0 = r0.c.get()
            if (r0 == r11) goto L_0x01f4
            com.mbridge.msdk.reward.b.a$c r0 = r7.t
            int r0 = r0.c.get()
            if (r0 == r10) goto L_0x01f4
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = com.mbridge.msdk.foundation.tools.af.c()     // Catch:{ Exception -> 0x01f1 }
            java.lang.String r1 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r1)     // Catch:{ Exception -> 0x01f1 }
            r0.put(r8, r1)     // Catch:{ Exception -> 0x01f1 }
            java.lang.String r14 = "2000123"
            java.lang.String r15 = r7.v     // Catch:{ Exception -> 0x01f1 }
            java.lang.String r17 = "auto_load"
            r18 = 94
            r19 = 0
            r16 = r1
            com.mbridge.msdk.reward.c.a.a(r14, r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x01f1 }
        L_0x01f1:
            r7.a((boolean) r13, (java.util.Map<java.lang.String, java.lang.String>) r0)
        L_0x01f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.c(java.lang.String):void");
    }

    public final boolean d(boolean z2) {
        try {
            if (k()) {
                return false;
            }
            if (this.J) {
                try {
                    return h();
                } catch (Exception unused) {
                    return false;
                }
            } else {
                if (this.p == null) {
                    j();
                }
                com.mbridge.msdk.reward.adapter.c cVar = this.p;
                if (cVar == null) {
                    return false;
                }
                boolean c2 = cVar.c();
                return !c2 ? this.p.d() : c2;
            }
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private boolean h() {
        if (this.p == null) {
            j();
        }
        List<com.mbridge.msdk.foundation.entity.b> a2 = com.mbridge.msdk.videocommon.a.a.a().a(this.v);
        boolean z2 = false;
        if (a2 == null || a2.size() <= 0) {
            return false;
        }
        String c2 = com.mbridge.msdk.foundation.same.a.d.c(this.v);
        if (!TextUtils.isEmpty(c2)) {
            z2 = a(a2, c2);
        }
        if (z2) {
            return z2;
        }
        for (com.mbridge.msdk.foundation.entity.b next : a2) {
            if (next != null) {
                this.p.a(next.b());
                this.p.c = next.f();
                if (this.p.c()) {
                    return true;
                }
            }
        }
        return z2;
    }

    private boolean a(List<com.mbridge.msdk.foundation.entity.b> list, String str) {
        if (list == null) {
            return false;
        }
        for (com.mbridge.msdk.foundation.entity.b next : list) {
            if (next != null && str.equals(next.a())) {
                this.p.a(next.b());
                this.p.c = next.f();
                if (this.p.c()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean i() {
        if (this.p == null) {
            j();
        }
        List<com.mbridge.msdk.foundation.entity.b> a2 = com.mbridge.msdk.videocommon.a.a.a().a(this.v);
        if (a2 == null || a2.size() <= 0) {
            return false;
        }
        for (com.mbridge.msdk.foundation.entity.b next : a2) {
            if (next != null) {
                this.p.a(next.b());
                this.p.c = next.f();
                if (this.p.d()) {
                    return true;
                }
                com.mbridge.msdk.videocommon.a.a.a().c(this.v, next.b());
            }
        }
        return false;
    }

    private void j() {
        com.mbridge.msdk.reward.adapter.c cVar = new com.mbridge.msdk.reward.adapter.c(this.n, this.A, this.v);
        this.p = cVar;
        cVar.b(this.I);
        this.p.c(this.J);
        if (this.I) {
            this.p.a(this.F, this.G, this.H);
        }
        this.p.a(this.q);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:167|168|216) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:120|121|122|123) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:152|153|154|155) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:54|55|56|57) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:86|87|88|89) */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x012f, code lost:
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0131, code lost:
        r12.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0136, code lost:
        if (r11.I != false) goto L_0x017b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x013a, code lost:
        if (r11.J != false) goto L_0x017b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x013c, code lost:
        r12 = r11.q;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x013e, code lost:
        if (r12 == null) goto L_0x017b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0144, code lost:
        if (r12.s(4) == false) goto L_0x017b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0148, code lost:
        if (r11.t == null) goto L_0x017b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0150, code lost:
        if (com.mbridge.msdk.reward.b.a.c.a(r11.t) == 1) goto L_0x017b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0158, code lost:
        if (com.mbridge.msdk.reward.b.a.c.a(r11.t) == 3) goto L_0x017b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x015a, code lost:
        r12 = new java.util.HashMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:?, code lost:
        r7 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(com.mbridge.msdk.foundation.tools.af.c());
        r12.put(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, r7);
        com.mbridge.msdk.reward.c.a.a("2000123", r11.v, r7, "auto_load", 94, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:?, code lost:
        a(false, (java.util.Map<java.lang.String, java.lang.String>) r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x017b, code lost:
        r11.e = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x017d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0182, code lost:
        if (k() == false) goto L_0x01e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0186, code lost:
        if (r11.s == null) goto L_0x019c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:?, code lost:
        r11.s.onShowFail(b, r11.w, "Play more than limit");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0194, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0197, code lost:
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x0199;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0199, code lost:
        r12.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x019e, code lost:
        if (r11.I != false) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x01a2, code lost:
        if (r11.J != false) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x01a4, code lost:
        r12 = r11.q;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01a6, code lost:
        if (r12 == null) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x01ac, code lost:
        if (r12.s(4) == false) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x01b0, code lost:
        if (r11.t == null) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x01b8, code lost:
        if (com.mbridge.msdk.reward.b.a.c.a(r11.t) == 1) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x01c0, code lost:
        if (com.mbridge.msdk.reward.b.a.c.a(r11.t) == 3) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x01c2, code lost:
        r12 = new java.util.HashMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:?, code lost:
        r7 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(com.mbridge.msdk.foundation.tools.af.c());
        r12.put(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, r7);
        com.mbridge.msdk.reward.c.a.a("2000123", r11.v, r7, "auto_load", 94, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:?, code lost:
        a(false, (java.util.Map<java.lang.String, java.lang.String>) r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x01e3, code lost:
        r11.e = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x01e5, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x01ec, code lost:
        if (android.text.TextUtils.isEmpty(r11.u) == false) goto L_0x01f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x01ee, code lost:
        r11.u = com.mbridge.msdk.foundation.tools.w.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:?, code lost:
        r13 = new java.text.SimpleDateFormat("dd").format(new java.util.Date());
        r14 = (java.lang.String) com.mbridge.msdk.foundation.tools.ai.b(r11.n, "reward_date", "0");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0214, code lost:
        if (android.text.TextUtils.isEmpty(r14) != false) goto L_0x0243;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x021a, code lost:
        if (android.text.TextUtils.isEmpty(r13) != false) goto L_0x0243;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0220, code lost:
        if (r14.equals(r13) != false) goto L_0x0243;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0222, code lost:
        com.mbridge.msdk.foundation.tools.ai.a(r11.n, "reward_date", r13);
        r13 = r11.n;
        com.mbridge.msdk.foundation.tools.ai.a(r13, r11.A + "_1", 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:?, code lost:
        c(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0036, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003c, code lost:
        if (r11.t == null) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0048, code lost:
        if (com.mbridge.msdk.reward.b.a.c.b(r11.t).get() != 1) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004c, code lost:
        if (r11.s == null) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r11.s.onShowFail(b, r11.w, "campaing is loading");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005a, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x005d, code lost:
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x005f, code lost:
        r12.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0064, code lost:
        if (r11.I != false) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0068, code lost:
        if (r11.J != false) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x006a, code lost:
        r12 = r11.q;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x006c, code lost:
        if (r12 == null) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0072, code lost:
        if (r12.s(4) == false) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0076, code lost:
        if (r11.t == null) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x007e, code lost:
        if (com.mbridge.msdk.reward.b.a.c.a(r11.t) == 1) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0086, code lost:
        if (com.mbridge.msdk.reward.b.a.c.a(r11.t) == 3) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0088, code lost:
        r12 = new java.util.HashMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r7 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(com.mbridge.msdk.foundation.tools.af.c());
        r12.put(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, r7);
        com.mbridge.msdk.reward.c.a.a("2000123", r11.v, r7, "auto_load", 94, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        a(false, (java.util.Map<java.lang.String, java.lang.String>) r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a9, code lost:
        r11.e = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ab, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00ac, code lost:
        r13 = r11.n;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ae, code lost:
        if (r13 != null) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00b2, code lost:
        if (r11.s == null) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r11.s.onShowFail(b, r11.w, "context is null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00c0, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00c3, code lost:
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00c5, code lost:
        r12.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00ca, code lost:
        if (r11.I != false) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00ce, code lost:
        if (r11.J != false) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00d0, code lost:
        r12 = r11.q;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00d2, code lost:
        if (r12 == null) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00d8, code lost:
        if (r12.s(4) == false) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00dc, code lost:
        if (r11.t == null) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00e4, code lost:
        if (com.mbridge.msdk.reward.b.a.c.a(r11.t) == 1) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x00ec, code lost:
        if (com.mbridge.msdk.reward.b.a.c.a(r11.t) == 3) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x00ee, code lost:
        r12 = new java.util.HashMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        r7 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(com.mbridge.msdk.foundation.tools.af.c());
        r12.put(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, r7);
        com.mbridge.msdk.reward.c.a.a("2000123", r11.v, r7, "auto_load", 94, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        a(false, (java.util.Map<java.lang.String, java.lang.String>) r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x010f, code lost:
        r11.e = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0111, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0114, code lost:
        if (r11.I == false) goto L_0x017e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x011a, code lost:
        if (com.mbridge.msdk.foundation.tools.af.c(r13) != false) goto L_0x017e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x011e, code lost:
        if (r11.s == null) goto L_0x0134;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
        r11.s.onShowFail(b, r11.w, "network exception");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x012c, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:120:0x0178 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:152:0x01e0 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:167:0x0243 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x00a6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:86:0x010c */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:152:0x01e0=Splitter:B:152:0x01e0, B:167:0x0243=Splitter:B:167:0x0243, B:54:0x00a6=Splitter:B:54:0x00a6, B:120:0x0178=Splitter:B:120:0x0178, B:86:0x010c=Splitter:B:86:0x010c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            r11 = this;
            java.lang.String r0 = "_1"
            r1 = 3
            r2 = 4
            r3 = 1
            r4 = 0
            r11.B = r12     // Catch:{ Exception -> 0x024b }
            r11.u = r13     // Catch:{ Exception -> 0x024b }
            r11.z = r14     // Catch:{ Exception -> 0x024b }
            com.mbridge.msdk.out.MBridgeIds r13 = r11.w     // Catch:{ Exception -> 0x024b }
            if (r13 == 0) goto L_0x0016
            java.lang.String r13 = r13.getLocalRequestId()     // Catch:{ Exception -> 0x024b }
            b = r13     // Catch:{ Exception -> 0x024b }
        L_0x0016:
            java.lang.Object r13 = r11.Q     // Catch:{ Exception -> 0x024b }
            monitor-enter(r13)     // Catch:{ Exception -> 0x024b }
            boolean r14 = r11.e     // Catch:{ all -> 0x0248 }
            if (r14 == 0) goto L_0x0037
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.s     // Catch:{ all -> 0x0248 }
            if (r12 == 0) goto L_0x0035
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.s     // Catch:{ Exception -> 0x002d }
            java.lang.String r14 = b     // Catch:{ Exception -> 0x002d }
            com.mbridge.msdk.out.MBridgeIds r0 = r11.w     // Catch:{ Exception -> 0x002d }
            java.lang.String r5 = "campaing is show progressing "
            r12.onShowFail(r14, r0, r5)     // Catch:{ Exception -> 0x002d }
            goto L_0x0035
        L_0x002d:
            r12 = move-exception
            boolean r14 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0248 }
            if (r14 == 0) goto L_0x0035
            r12.printStackTrace()     // Catch:{ all -> 0x0248 }
        L_0x0035:
            monitor-exit(r13)     // Catch:{ all -> 0x0248 }
            return
        L_0x0037:
            r11.e = r3     // Catch:{ all -> 0x0248 }
            monitor-exit(r13)     // Catch:{ all -> 0x0248 }
            com.mbridge.msdk.reward.b.a$c r13 = r11.t     // Catch:{ Exception -> 0x024b }
            if (r13 == 0) goto L_0x00ac
            com.mbridge.msdk.reward.b.a$c r13 = r11.t     // Catch:{ Exception -> 0x024b }
            java.util.concurrent.atomic.AtomicInteger r13 = r13.c     // Catch:{ Exception -> 0x024b }
            int r13 = r13.get()     // Catch:{ Exception -> 0x024b }
            if (r13 != r3) goto L_0x00ac
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.s     // Catch:{ Exception -> 0x024b }
            if (r12 == 0) goto L_0x0062
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.s     // Catch:{ Exception -> 0x005a }
            java.lang.String r13 = b     // Catch:{ Exception -> 0x005a }
            com.mbridge.msdk.out.MBridgeIds r14 = r11.w     // Catch:{ Exception -> 0x005a }
            java.lang.String r0 = "campaing is loading"
            r12.onShowFail(r13, r14, r0)     // Catch:{ Exception -> 0x005a }
            goto L_0x0062
        L_0x005a:
            r12 = move-exception
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x024b }
            if (r13 == 0) goto L_0x0062
            r12.printStackTrace()     // Catch:{ Exception -> 0x024b }
        L_0x0062:
            boolean r12 = r11.I     // Catch:{ Exception -> 0x024b }
            if (r12 != 0) goto L_0x00a9
            boolean r12 = r11.J     // Catch:{ Exception -> 0x024b }
            if (r12 != 0) goto L_0x00a9
            com.mbridge.msdk.videocommon.d.c r12 = r11.q     // Catch:{ Exception -> 0x024b }
            if (r12 == 0) goto L_0x00a9
            boolean r12 = r12.s(r2)     // Catch:{ Exception -> 0x024b }
            if (r12 == 0) goto L_0x00a9
            com.mbridge.msdk.reward.b.a$c r12 = r11.t     // Catch:{ Exception -> 0x024b }
            if (r12 == 0) goto L_0x00a9
            com.mbridge.msdk.reward.b.a$c r12 = r11.t     // Catch:{ Exception -> 0x024b }
            int r12 = r12.c.get()     // Catch:{ Exception -> 0x024b }
            if (r12 == r3) goto L_0x00a9
            com.mbridge.msdk.reward.b.a$c r12 = r11.t     // Catch:{ Exception -> 0x024b }
            int r12 = r12.c.get()     // Catch:{ Exception -> 0x024b }
            if (r12 == r1) goto L_0x00a9
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ Exception -> 0x024b }
            r12.<init>()     // Catch:{ Exception -> 0x024b }
            java.lang.String r13 = com.mbridge.msdk.foundation.tools.af.c()     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r7 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r13)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r13 = "local_rid"
            r12.put(r13, r7)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r5 = "2000123"
            java.lang.String r6 = r11.v     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r8 = "auto_load"
            r9 = 94
            r10 = 0
            com.mbridge.msdk.reward.c.a.a(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00a6 }
        L_0x00a6:
            r11.a((boolean) r4, (java.util.Map<java.lang.String, java.lang.String>) r12)     // Catch:{ Exception -> 0x024b }
        L_0x00a9:
            r11.e = r4     // Catch:{ Exception -> 0x024b }
            return
        L_0x00ac:
            android.content.Context r13 = r11.n     // Catch:{ Exception -> 0x024b }
            if (r13 != 0) goto L_0x0112
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.s     // Catch:{ Exception -> 0x024b }
            if (r12 == 0) goto L_0x00c8
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.s     // Catch:{ Exception -> 0x00c0 }
            java.lang.String r13 = b     // Catch:{ Exception -> 0x00c0 }
            com.mbridge.msdk.out.MBridgeIds r14 = r11.w     // Catch:{ Exception -> 0x00c0 }
            java.lang.String r0 = "context is null"
            r12.onShowFail(r13, r14, r0)     // Catch:{ Exception -> 0x00c0 }
            goto L_0x00c8
        L_0x00c0:
            r12 = move-exception
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x024b }
            if (r13 == 0) goto L_0x00c8
            r12.printStackTrace()     // Catch:{ Exception -> 0x024b }
        L_0x00c8:
            boolean r12 = r11.I     // Catch:{ Exception -> 0x024b }
            if (r12 != 0) goto L_0x010f
            boolean r12 = r11.J     // Catch:{ Exception -> 0x024b }
            if (r12 != 0) goto L_0x010f
            com.mbridge.msdk.videocommon.d.c r12 = r11.q     // Catch:{ Exception -> 0x024b }
            if (r12 == 0) goto L_0x010f
            boolean r12 = r12.s(r2)     // Catch:{ Exception -> 0x024b }
            if (r12 == 0) goto L_0x010f
            com.mbridge.msdk.reward.b.a$c r12 = r11.t     // Catch:{ Exception -> 0x024b }
            if (r12 == 0) goto L_0x010f
            com.mbridge.msdk.reward.b.a$c r12 = r11.t     // Catch:{ Exception -> 0x024b }
            int r12 = r12.c.get()     // Catch:{ Exception -> 0x024b }
            if (r12 == r3) goto L_0x010f
            com.mbridge.msdk.reward.b.a$c r12 = r11.t     // Catch:{ Exception -> 0x024b }
            int r12 = r12.c.get()     // Catch:{ Exception -> 0x024b }
            if (r12 == r1) goto L_0x010f
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ Exception -> 0x024b }
            r12.<init>()     // Catch:{ Exception -> 0x024b }
            java.lang.String r13 = com.mbridge.msdk.foundation.tools.af.c()     // Catch:{ Exception -> 0x010c }
            java.lang.String r7 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r13)     // Catch:{ Exception -> 0x010c }
            java.lang.String r13 = "local_rid"
            r12.put(r13, r7)     // Catch:{ Exception -> 0x010c }
            java.lang.String r5 = "2000123"
            java.lang.String r6 = r11.v     // Catch:{ Exception -> 0x010c }
            java.lang.String r8 = "auto_load"
            r9 = 94
            r10 = 0
            com.mbridge.msdk.reward.c.a.a(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x010c }
        L_0x010c:
            r11.a((boolean) r4, (java.util.Map<java.lang.String, java.lang.String>) r12)     // Catch:{ Exception -> 0x024b }
        L_0x010f:
            r11.e = r4     // Catch:{ Exception -> 0x024b }
            return
        L_0x0112:
            boolean r14 = r11.I     // Catch:{ Exception -> 0x024b }
            if (r14 == 0) goto L_0x017e
            boolean r13 = com.mbridge.msdk.foundation.tools.af.c((android.content.Context) r13)     // Catch:{ Exception -> 0x024b }
            if (r13 != 0) goto L_0x017e
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.s     // Catch:{ Exception -> 0x024b }
            if (r12 == 0) goto L_0x0134
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.s     // Catch:{ Exception -> 0x012c }
            java.lang.String r13 = b     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.out.MBridgeIds r14 = r11.w     // Catch:{ Exception -> 0x012c }
            java.lang.String r0 = "network exception"
            r12.onShowFail(r13, r14, r0)     // Catch:{ Exception -> 0x012c }
            goto L_0x0134
        L_0x012c:
            r12 = move-exception
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x024b }
            if (r13 == 0) goto L_0x0134
            r12.printStackTrace()     // Catch:{ Exception -> 0x024b }
        L_0x0134:
            boolean r12 = r11.I     // Catch:{ Exception -> 0x024b }
            if (r12 != 0) goto L_0x017b
            boolean r12 = r11.J     // Catch:{ Exception -> 0x024b }
            if (r12 != 0) goto L_0x017b
            com.mbridge.msdk.videocommon.d.c r12 = r11.q     // Catch:{ Exception -> 0x024b }
            if (r12 == 0) goto L_0x017b
            boolean r12 = r12.s(r2)     // Catch:{ Exception -> 0x024b }
            if (r12 == 0) goto L_0x017b
            com.mbridge.msdk.reward.b.a$c r12 = r11.t     // Catch:{ Exception -> 0x024b }
            if (r12 == 0) goto L_0x017b
            com.mbridge.msdk.reward.b.a$c r12 = r11.t     // Catch:{ Exception -> 0x024b }
            int r12 = r12.c.get()     // Catch:{ Exception -> 0x024b }
            if (r12 == r3) goto L_0x017b
            com.mbridge.msdk.reward.b.a$c r12 = r11.t     // Catch:{ Exception -> 0x024b }
            int r12 = r12.c.get()     // Catch:{ Exception -> 0x024b }
            if (r12 == r1) goto L_0x017b
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ Exception -> 0x024b }
            r12.<init>()     // Catch:{ Exception -> 0x024b }
            java.lang.String r13 = com.mbridge.msdk.foundation.tools.af.c()     // Catch:{ Exception -> 0x0178 }
            java.lang.String r7 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r13)     // Catch:{ Exception -> 0x0178 }
            java.lang.String r13 = "local_rid"
            r12.put(r13, r7)     // Catch:{ Exception -> 0x0178 }
            java.lang.String r5 = "2000123"
            java.lang.String r6 = r11.v     // Catch:{ Exception -> 0x0178 }
            java.lang.String r8 = "auto_load"
            r9 = 94
            r10 = 0
            com.mbridge.msdk.reward.c.a.a(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0178 }
        L_0x0178:
            r11.a((boolean) r4, (java.util.Map<java.lang.String, java.lang.String>) r12)     // Catch:{ Exception -> 0x024b }
        L_0x017b:
            r11.e = r4     // Catch:{ Exception -> 0x024b }
            return
        L_0x017e:
            boolean r13 = r11.k()     // Catch:{ Exception -> 0x024b }
            if (r13 == 0) goto L_0x01e6
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.s     // Catch:{ Exception -> 0x024b }
            if (r12 == 0) goto L_0x019c
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r12 = r11.s     // Catch:{ Exception -> 0x0194 }
            java.lang.String r13 = b     // Catch:{ Exception -> 0x0194 }
            com.mbridge.msdk.out.MBridgeIds r14 = r11.w     // Catch:{ Exception -> 0x0194 }
            java.lang.String r0 = "Play more than limit"
            r12.onShowFail(r13, r14, r0)     // Catch:{ Exception -> 0x0194 }
            goto L_0x019c
        L_0x0194:
            r12 = move-exception
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x024b }
            if (r13 == 0) goto L_0x019c
            r12.printStackTrace()     // Catch:{ Exception -> 0x024b }
        L_0x019c:
            boolean r12 = r11.I     // Catch:{ Exception -> 0x024b }
            if (r12 != 0) goto L_0x01e3
            boolean r12 = r11.J     // Catch:{ Exception -> 0x024b }
            if (r12 != 0) goto L_0x01e3
            com.mbridge.msdk.videocommon.d.c r12 = r11.q     // Catch:{ Exception -> 0x024b }
            if (r12 == 0) goto L_0x01e3
            boolean r12 = r12.s(r2)     // Catch:{ Exception -> 0x024b }
            if (r12 == 0) goto L_0x01e3
            com.mbridge.msdk.reward.b.a$c r12 = r11.t     // Catch:{ Exception -> 0x024b }
            if (r12 == 0) goto L_0x01e3
            com.mbridge.msdk.reward.b.a$c r12 = r11.t     // Catch:{ Exception -> 0x024b }
            int r12 = r12.c.get()     // Catch:{ Exception -> 0x024b }
            if (r12 == r3) goto L_0x01e3
            com.mbridge.msdk.reward.b.a$c r12 = r11.t     // Catch:{ Exception -> 0x024b }
            int r12 = r12.c.get()     // Catch:{ Exception -> 0x024b }
            if (r12 == r1) goto L_0x01e3
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ Exception -> 0x024b }
            r12.<init>()     // Catch:{ Exception -> 0x024b }
            java.lang.String r13 = com.mbridge.msdk.foundation.tools.af.c()     // Catch:{ Exception -> 0x01e0 }
            java.lang.String r7 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r13)     // Catch:{ Exception -> 0x01e0 }
            java.lang.String r13 = "local_rid"
            r12.put(r13, r7)     // Catch:{ Exception -> 0x01e0 }
            java.lang.String r5 = "2000123"
            java.lang.String r6 = r11.v     // Catch:{ Exception -> 0x01e0 }
            java.lang.String r8 = "auto_load"
            r9 = 94
            r10 = 0
            com.mbridge.msdk.reward.c.a.a(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x01e0 }
        L_0x01e0:
            r11.a((boolean) r4, (java.util.Map<java.lang.String, java.lang.String>) r12)     // Catch:{ Exception -> 0x024b }
        L_0x01e3:
            r11.e = r4     // Catch:{ Exception -> 0x024b }
            return
        L_0x01e6:
            java.lang.String r13 = r11.u     // Catch:{ Exception -> 0x024b }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x024b }
            if (r13 == 0) goto L_0x01f4
            java.lang.String r13 = com.mbridge.msdk.foundation.tools.w.a()     // Catch:{ Exception -> 0x024b }
            r11.u = r13     // Catch:{ Exception -> 0x024b }
        L_0x01f4:
            java.text.SimpleDateFormat r13 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0243 }
            java.lang.String r14 = "dd"
            r13.<init>(r14)     // Catch:{ Exception -> 0x0243 }
            java.util.Date r14 = new java.util.Date     // Catch:{ Exception -> 0x0243 }
            r14.<init>()     // Catch:{ Exception -> 0x0243 }
            java.lang.String r13 = r13.format(r14)     // Catch:{ Exception -> 0x0243 }
            android.content.Context r14 = r11.n     // Catch:{ Exception -> 0x0243 }
            java.lang.String r5 = "reward_date"
            java.lang.String r6 = "0"
            java.lang.Object r14 = com.mbridge.msdk.foundation.tools.ai.b(r14, r5, r6)     // Catch:{ Exception -> 0x0243 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ Exception -> 0x0243 }
            boolean r5 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x0243 }
            if (r5 != 0) goto L_0x0243
            boolean r5 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x0243 }
            if (r5 != 0) goto L_0x0243
            boolean r14 = r14.equals(r13)     // Catch:{ Exception -> 0x0243 }
            if (r14 != 0) goto L_0x0243
            android.content.Context r14 = r11.n     // Catch:{ Exception -> 0x0243 }
            java.lang.String r5 = "reward_date"
            com.mbridge.msdk.foundation.tools.ai.a(r14, r5, r13)     // Catch:{ Exception -> 0x0243 }
            android.content.Context r13 = r11.n     // Catch:{ Exception -> 0x0243 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0243 }
            r14.<init>()     // Catch:{ Exception -> 0x0243 }
            java.lang.String r5 = r11.A     // Catch:{ Exception -> 0x0243 }
            r14.append(r5)     // Catch:{ Exception -> 0x0243 }
            r14.append(r0)     // Catch:{ Exception -> 0x0243 }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x0243 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0243 }
            com.mbridge.msdk.foundation.tools.ai.a(r13, r14, r0)     // Catch:{ Exception -> 0x0243 }
        L_0x0243:
            r11.c((java.lang.String) r12)     // Catch:{ Exception -> 0x024b }
            goto L_0x02bb
        L_0x0248:
            r12 = move-exception
            monitor-exit(r13)     // Catch:{ all -> 0x0248 }
            throw r12     // Catch:{ Exception -> 0x024b }
        L_0x024b:
            r12 = move-exception
            r11.e = r4
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r13 == 0) goto L_0x025b
            java.lang.String r13 = "RewardVideoController"
            java.lang.String r14 = r12.getLocalizedMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r13, r14)
        L_0x025b:
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r13 = r11.s
            if (r13 == 0) goto L_0x0274
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r13 = r11.s     // Catch:{ Exception -> 0x026c }
            java.lang.String r14 = b     // Catch:{ Exception -> 0x026c }
            com.mbridge.msdk.out.MBridgeIds r0 = r11.w     // Catch:{ Exception -> 0x026c }
            java.lang.String r5 = "show exception"
            r13.onShowFail(r14, r0, r5)     // Catch:{ Exception -> 0x026c }
            goto L_0x0274
        L_0x026c:
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r13 == 0) goto L_0x0274
            r12.printStackTrace()
        L_0x0274:
            boolean r12 = r11.I
            if (r12 != 0) goto L_0x02bb
            boolean r12 = r11.J
            if (r12 != 0) goto L_0x02bb
            com.mbridge.msdk.videocommon.d.c r12 = r11.q
            if (r12 == 0) goto L_0x02bb
            boolean r12 = r12.s(r2)
            if (r12 == 0) goto L_0x02bb
            com.mbridge.msdk.reward.b.a$c r12 = r11.t
            if (r12 == 0) goto L_0x02bb
            com.mbridge.msdk.reward.b.a$c r12 = r11.t
            int r12 = r12.c.get()
            if (r12 == r3) goto L_0x02bb
            com.mbridge.msdk.reward.b.a$c r12 = r11.t
            int r12 = r12.c.get()
            if (r12 == r1) goto L_0x02bb
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            java.lang.String r13 = com.mbridge.msdk.foundation.tools.af.c()     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r7 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r13)     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r13 = "local_rid"
            r12.put(r13, r7)     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r5 = "2000123"
            java.lang.String r6 = r11.v     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r8 = "auto_load"
            r9 = 94
            r10 = 0
            com.mbridge.msdk.reward.c.a.a(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x02b8 }
        L_0x02b8:
            r11.a((boolean) r4, (java.util.Map<java.lang.String, java.lang.String>) r12)
        L_0x02bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.b.a.a(java.lang.String, java.lang.String, java.lang.String):void");
    }

    private boolean k() {
        try {
            if (this.W == null) {
                this.W = h.a(com.mbridge.msdk.foundation.controller.b.d().g());
            }
            i a2 = i.a((g) this.W);
            if (this.q == null) {
                this.q = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), this.v, this.I);
            }
            int d2 = this.q.d();
            if (a2 == null || !a2.a(this.v, d2)) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            aa.d("RewardVideoController", "cap check error");
            return false;
        }
    }

    /* renamed from: com.mbridge.msdk.reward.b.a$a  reason: collision with other inner class name */
    /* compiled from: RewardVideoController */
    public class C0152a implements Runnable {
        private final com.mbridge.msdk.reward.adapter.c b;
        private final int c;
        private final boolean d;
        private boolean e;
        private String f = "";
        private int g;
        private String h;

        public C0152a(com.mbridge.msdk.reward.adapter.c cVar, int i, boolean z, String str) {
            this.b = cVar;
            this.c = i;
            this.d = z;
            this.e = false;
            if (cVar != null) {
                cVar.d(false);
            }
            this.h = str;
        }

        public final void a() {
            this.e = true;
        }

        public final void run() {
            String str = "2";
            if (!this.e) {
                com.mbridge.msdk.reward.adapter.c cVar = this.b;
                if (cVar != null) {
                    cVar.d(true);
                }
                aa.d("RewardVideoController", "adSource=" + this.c + " CommonCancelTimeTask mIsDevCall：" + this.d);
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("timeout", this.g + "");
                    hashMap.put(IronSourceConstants.EVENTS_RESULT, str);
                    if (!this.d) {
                        str = "1";
                    }
                    hashMap.put("auto_load", str.concat(""));
                    if (TextUtils.isEmpty(this.f)) {
                        hashMap.put(MBridgeConstans.PROPERTIES_UNIT_ID, a.this.v);
                    }
                    hashMap.put("bid_tk", this.h);
                    m.a().a("2000126", this.f, (Map<String, String>) hashMap);
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        e2.printStackTrace();
                    }
                }
                try {
                    com.mbridge.msdk.reward.c.a.a((CampaignEx) null, a.this.n, new com.mbridge.msdk.foundation.entity.e(2, "v3 is timeout"), a.this.v, a.this.J, "", "");
                } catch (Exception unused) {
                }
                a.this.b("v3 is timeout");
            }
        }

        public final void a(String str) {
            this.f = str;
        }

        public final void a(int i) {
            this.g = i;
        }
    }

    /* compiled from: RewardVideoController */
    public class b implements com.mbridge.msdk.reward.adapter.a {
        private com.mbridge.msdk.reward.adapter.c b;
        private boolean c;
        private C0152a d;

        public b(com.mbridge.msdk.reward.adapter.c cVar, boolean z) {
            this.b = cVar;
            this.c = z;
        }

        public final void a(C0152a aVar) {
            this.d = aVar;
        }

        public final void a(String str) {
            C0152a aVar = this.d;
            if (aVar != null) {
                aVar.a();
                a.this.D.removeCallbacks(this.d);
            }
            if (a.this.t != null) {
                c.f(a.this.t, a.this.A, a.this.v);
            }
        }

        public final void a(List<CampaignEx> list) {
            C0152a aVar = this.d;
            if (aVar != null) {
                aVar.a();
                a.this.D.removeCallbacks(this.d);
            }
            a.this.a(list);
            if (a.this.t != null) {
                a.this.t.a(a.this.A, a.this.v);
            }
        }

        public final void a(List<CampaignEx> list, String str) {
            C0152a aVar = this.d;
            if (aVar != null) {
                aVar.a();
                a.this.D.removeCallbacks(this.d);
            }
            com.mbridge.msdk.reward.adapter.c cVar = this.b;
            if (cVar != null) {
                cVar.a((com.mbridge.msdk.reward.adapter.a) null);
                this.b = null;
            }
            a.this.a(list);
            if (a.this.t != null) {
                c.a(a.this.t, str, false);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(List<CampaignEx> list) {
        if (list != null && list.size() > 0) {
            this.R = list;
        }
    }

    static /* synthetic */ void j(a aVar) {
        String str;
        if (aVar.w != null) {
            if (aVar.P) {
                String a2 = aVar.a();
                if (!TextUtils.isEmpty(a2)) {
                    ConcurrentHashMap<String, String> concurrentHashMap = T;
                    if (concurrentHashMap != null && concurrentHashMap.containsKey(a2) && !TextUtils.isEmpty(T.get(a2))) {
                        str = T.get(a2);
                        aVar.w.setBidToken(str);
                    }
                } else {
                    return;
                }
            }
            str = "";
            aVar.w.setBidToken(str);
        }
    }

    static /* synthetic */ void a(a aVar, String str, List list) {
        if (list != null) {
            try {
                if (list.size() > 0 && !aVar.aa) {
                    com.mbridge.msdk.foundation.db.f.a((g) h.a(com.mbridge.msdk.foundation.controller.b.d().g())).a((List<CampaignEx>) list, str);
                }
            } catch (Throwable th) {
                aa.d("RewardVideoController", th.getMessage());
            }
        }
    }
}
