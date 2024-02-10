package com.mbridge.msdk.reward.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.share.internal.ShareConstants;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.q;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.download.g;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* compiled from: RewardCampaignsResourceManager */
public final class b {
    /* access modifiers changed from: private */
    public static ConcurrentHashMap<String, a> b;
    /* access modifiers changed from: private */
    public final h a;
    /* access modifiers changed from: private */
    public boolean c;
    private final String d;
    private final String e;
    private final String f;
    private volatile List<WindVaneWebView> g;

    /* compiled from: RewardCampaignsResourceManager */
    public interface c {
        void a(String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList);

        void a(String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.foundation.entity.e eVar);
    }

    /* compiled from: RewardCampaignsResourceManager */
    public interface i {
        void a(String str, String str2, String str3, String str4);

        void a(String str, String str2, String str3, String str4, com.mbridge.msdk.foundation.entity.e eVar);
    }

    /* compiled from: RewardCampaignsResourceManager */
    public interface j {
        void a(String str, String str2, String str3, String str4, String str5, a.C0158a aVar);

        void a(String str, String str2, String str3, String str4, String str5, a.C0158a aVar, com.mbridge.msdk.foundation.entity.e eVar);
    }

    /* compiled from: RewardCampaignsResourceManager */
    private static final class m {
        /* access modifiers changed from: private */
        public static final b a = new b();
    }

    private b() {
        this.d = CampaignEx.JSON_KEY_LOCAL_REQUEST_ID;
        this.e = "down_type";
        this.f = "h3c";
        this.g = new ArrayList(6);
        HandlerThread handlerThread = new HandlerThread("mb-reward-load-thread");
        b = new ConcurrentHashMap<>();
        handlerThread.start();
        this.a = new h(handlerThread.getLooper());
    }

    public static b a() {
        return m.a;
    }

    public final synchronized void a(Context context, boolean z, int i2, boolean z2, int i3, String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, c cVar, i iVar) {
        String str4 = str2;
        String str5 = str3;
        synchronized (this) {
            String str6 = str4 + "_" + str5;
            b.put(str6, new a(z, z2, i2, copyOnWriteArrayList.size(), str2, str3, i3, copyOnWriteArrayList));
            this.a.a(str, str4, str5, cVar);
            this.a.a(context);
            this.a.a(str6, copyOnWriteArrayList);
            final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = copyOnWriteArrayList;
            final Context context2 = context;
            final String str7 = str2;
            final int i4 = i3;
            final String str8 = str;
            final String str9 = str3;
            final i iVar2 = iVar;
            this.a.post(new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:135:0x0374  */
                /* JADX WARNING: Removed duplicated region for block: B:51:0x0169  */
                /* JADX WARNING: Removed duplicated region for block: B:62:0x01ca  */
                /* JADX WARNING: Removed duplicated region for block: B:84:0x025c A[SYNTHETIC, Splitter:B:84:0x025c] */
                /* JADX WARNING: Removed duplicated region for block: B:92:0x0290 A[SYNTHETIC, Splitter:B:92:0x0290] */
                /* JADX WARNING: Removed duplicated region for block: B:99:0x02bc  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                        r25 = this;
                        r1 = r25
                        java.lang.String r2 = "RewardCampaignsResourceManager"
                        java.util.concurrent.CopyOnWriteArrayList r0 = r3
                        if (r0 == 0) goto L_0x03d0
                        int r0 = r0.size()
                        if (r0 <= 0) goto L_0x03d0
                        com.mbridge.msdk.videocommon.download.i r0 = com.mbridge.msdk.videocommon.download.i.a()     // Catch:{ Exception -> 0x0041 }
                        java.util.concurrent.CopyOnWriteArrayList r3 = r3     // Catch:{ Exception -> 0x0041 }
                        r0.a((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)     // Catch:{ Exception -> 0x0041 }
                        com.mbridge.msdk.videocommon.download.c r4 = com.mbridge.msdk.videocommon.download.c.getInstance()     // Catch:{ Exception -> 0x0041 }
                        android.content.Context r5 = r4     // Catch:{ Exception -> 0x0041 }
                        java.lang.String r6 = r5     // Catch:{ Exception -> 0x0041 }
                        java.util.concurrent.CopyOnWriteArrayList r7 = r3     // Catch:{ Exception -> 0x0041 }
                        int r8 = r6     // Catch:{ Exception -> 0x0041 }
                        com.mbridge.msdk.reward.adapter.b$f r9 = new com.mbridge.msdk.reward.adapter.b$f     // Catch:{ Exception -> 0x0041 }
                        com.mbridge.msdk.reward.adapter.b r0 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x0041 }
                        com.mbridge.msdk.reward.adapter.b$h r0 = r0.a     // Catch:{ Exception -> 0x0041 }
                        java.lang.String r3 = r7     // Catch:{ Exception -> 0x0041 }
                        java.lang.String r10 = r5     // Catch:{ Exception -> 0x0041 }
                        java.lang.String r11 = r8     // Catch:{ Exception -> 0x0041 }
                        r9.<init>(r0, r3, r10, r11)     // Catch:{ Exception -> 0x0041 }
                        r4.createUnitCache((android.content.Context) r5, (java.lang.String) r6, (java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r7, (int) r8, (com.mbridge.msdk.videocommon.listener.a) r9)     // Catch:{ Exception -> 0x0041 }
                        com.mbridge.msdk.videocommon.download.c r0 = com.mbridge.msdk.videocommon.download.c.getInstance()     // Catch:{ Exception -> 0x0041 }
                        java.lang.String r3 = r5     // Catch:{ Exception -> 0x0041 }
                        r0.load(r3)     // Catch:{ Exception -> 0x0041 }
                        goto L_0x004d
                    L_0x0041:
                        r0 = move-exception
                        boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                        if (r3 == 0) goto L_0x004d
                        java.lang.String r0 = r0.getLocalizedMessage()
                        com.mbridge.msdk.foundation.tools.aa.d(r2, r0)
                    L_0x004d:
                        java.util.concurrent.CopyOnWriteArrayList r0 = r3
                        java.util.Iterator r3 = r0.iterator()
                    L_0x0053:
                        boolean r0 = r3.hasNext()
                        if (r0 == 0) goto L_0x03d0
                        java.lang.Object r0 = r3.next()
                        r14 = r0
                        com.mbridge.msdk.foundation.entity.CampaignEx r14 = (com.mbridge.msdk.foundation.entity.CampaignEx) r14
                        if (r14 != 0) goto L_0x0063
                        goto L_0x0053
                    L_0x0063:
                        com.mbridge.msdk.foundation.same.report.m r0 = com.mbridge.msdk.foundation.same.report.m.a()
                        r0.a((com.mbridge.msdk.foundation.entity.CampaignEx) r14)
                        java.lang.String r0 = r14.getCurrentLRid()
                        android.os.Message r4 = android.os.Message.obtain()     // Catch:{ Exception -> 0x009e }
                        r5 = 106(0x6a, float:1.49E-43)
                        r4.what = r5     // Catch:{ Exception -> 0x009e }
                        android.os.Bundle r5 = new android.os.Bundle     // Catch:{ Exception -> 0x009e }
                        r5.<init>()     // Catch:{ Exception -> 0x009e }
                        java.lang.String r6 = "unit_id"
                        java.lang.String r7 = r5     // Catch:{ Exception -> 0x009e }
                        r5.putString(r6, r7)     // Catch:{ Exception -> 0x009e }
                        java.lang.String r6 = com.mbridge.msdk.MBridgeConstans.PLACEMENT_ID     // Catch:{ Exception -> 0x009e }
                        java.lang.String r7 = r7     // Catch:{ Exception -> 0x009e }
                        r5.putString(r6, r7)     // Catch:{ Exception -> 0x009e }
                        java.lang.String r6 = "request_id"
                        java.lang.String r7 = r8     // Catch:{ Exception -> 0x009e }
                        r5.putString(r6, r7)     // Catch:{ Exception -> 0x009e }
                        r4.setData(r5)     // Catch:{ Exception -> 0x009e }
                        com.mbridge.msdk.reward.adapter.b r5 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x009e }
                        com.mbridge.msdk.reward.adapter.b$h r5 = r5.a     // Catch:{ Exception -> 0x009e }
                        r5.sendMessage(r4)     // Catch:{ Exception -> 0x009e }
                        goto L_0x009f
                    L_0x009e:
                    L_0x009f:
                        com.mbridge.msdk.foundation.entity.CampaignEx$c r15 = r14.getRewardTemplateMode()
                        java.lang.String r13 = ".zip"
                        java.lang.String r12 = ""
                        java.lang.String r11 = "dyview"
                        if (r15 == 0) goto L_0x01ad
                        java.lang.String r10 = r15.e()
                        int r4 = r15.b()
                        boolean r5 = r14.isDynamicView()
                        if (r5 == 0) goto L_0x00d6
                        boolean r5 = com.mbridge.msdk.foundation.tools.af.b((java.lang.String) r11, (java.lang.String) r10)
                        if (r5 == 0) goto L_0x00d6
                        com.mbridge.msdk.reward.adapter.b r0 = com.mbridge.msdk.reward.adapter.b.this
                        java.lang.StringBuilder r5 = new java.lang.StringBuilder
                        r5.<init>()
                        r5.append(r4)
                        r5.append(r12)
                        java.lang.String r4 = r5.toString()
                        r5 = 1
                        r0.a(r5, r14, r4, r10)
                        goto L_0x01ad
                    L_0x00d6:
                        java.util.HashMap r9 = new java.util.HashMap
                        r9.<init>()
                        java.lang.String r4 = "local_rid"
                        r9.put(r4, r0)     // Catch:{ Exception -> 0x00f7 }
                        java.lang.String r0 = "down_type"
                        java.lang.String r4 = "2"
                        r9.put(r0, r4)     // Catch:{ Exception -> 0x00f7 }
                        java.lang.String r0 = "h3c"
                        com.mbridge.msdk.reward.adapter.b r4 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x00f7 }
                        int r4 = r4.a((com.mbridge.msdk.foundation.entity.CampaignEx) r14)     // Catch:{ Exception -> 0x00f7 }
                        java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x00f7 }
                        r9.put(r0, r4)     // Catch:{ Exception -> 0x00f7 }
                        goto L_0x00f8
                    L_0x00f7:
                    L_0x00f8:
                        boolean r0 = android.text.TextUtils.isEmpty(r10)
                        if (r0 != 0) goto L_0x01ad
                        java.lang.String r0 = "cmpt=1"
                        boolean r0 = r10.contains(r0)
                        if (r0 != 0) goto L_0x01ad
                        boolean r0 = r10.contains(r13)
                        if (r0 == 0) goto L_0x0171
                        com.mbridge.msdk.videocommon.download.g r0 = com.mbridge.msdk.videocommon.download.g.a()     // Catch:{ Exception -> 0x0159 }
                        com.mbridge.msdk.reward.adapter.b$g r8 = new com.mbridge.msdk.reward.adapter.b$g     // Catch:{ Exception -> 0x0159 }
                        android.content.Context r5 = r4     // Catch:{ Exception -> 0x0159 }
                        java.lang.String r6 = r7     // Catch:{ Exception -> 0x0159 }
                        java.lang.String r7 = r5     // Catch:{ Exception -> 0x0159 }
                        java.lang.String r4 = r8     // Catch:{ Exception -> 0x0159 }
                        r16 = 859(0x35b, float:1.204E-42)
                        r17 = r3
                        com.mbridge.msdk.reward.adapter.b r3 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x0157 }
                        com.mbridge.msdk.reward.adapter.b$h r3 = r3.a     // Catch:{ Exception -> 0x0157 }
                        r18 = r10
                        com.mbridge.msdk.reward.adapter.b$i r10 = r9     // Catch:{ Exception -> 0x0157 }
                        r19 = r10
                        java.util.concurrent.CopyOnWriteArrayList r10 = r3     // Catch:{ Exception -> 0x0157 }
                        r20 = r4
                        r4 = r8
                        r21 = r8
                        r8 = r20
                        r20 = r15
                        r15 = r9
                        r9 = r14
                        r22 = r14
                        r14 = r18
                        r18 = r19
                        r19 = r10
                        r10 = r16
                        r23 = r11
                        r11 = r3
                        r3 = r12
                        r12 = r18
                        r24 = r13
                        r13 = r19
                        r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x0155 }
                        r4 = r21
                        r0.a(r15, r14, r4)     // Catch:{ Exception -> 0x0155 }
                        goto L_0x01b8
                    L_0x0155:
                        r0 = move-exception
                        goto L_0x0165
                    L_0x0157:
                        r0 = move-exception
                        goto L_0x015c
                    L_0x0159:
                        r0 = move-exception
                        r17 = r3
                    L_0x015c:
                        r23 = r11
                        r3 = r12
                        r24 = r13
                        r22 = r14
                        r20 = r15
                    L_0x0165:
                        boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG
                        if (r4 == 0) goto L_0x01b8
                        java.lang.String r0 = r0.getLocalizedMessage()
                        com.mbridge.msdk.foundation.tools.aa.d(r2, r0)
                        goto L_0x01b8
                    L_0x0171:
                        r17 = r3
                        r23 = r11
                        r3 = r12
                        r24 = r13
                        r22 = r14
                        r20 = r15
                        r15 = r9
                        r14 = r10
                        com.mbridge.msdk.videocommon.download.g r0 = com.mbridge.msdk.videocommon.download.g.a()     // Catch:{ Exception -> 0x01a0 }
                        com.mbridge.msdk.reward.adapter.b$d r13 = new com.mbridge.msdk.reward.adapter.b$d     // Catch:{ Exception -> 0x01a0 }
                        r5 = 859(0x35b, float:1.204E-42)
                        java.lang.String r6 = r7     // Catch:{ Exception -> 0x01a0 }
                        java.lang.String r7 = r5     // Catch:{ Exception -> 0x01a0 }
                        java.lang.String r8 = r8     // Catch:{ Exception -> 0x01a0 }
                        com.mbridge.msdk.reward.adapter.b$i r10 = r9     // Catch:{ Exception -> 0x01a0 }
                        com.mbridge.msdk.reward.adapter.b r4 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x01a0 }
                        com.mbridge.msdk.reward.adapter.b$h r11 = r4.a     // Catch:{ Exception -> 0x01a0 }
                        java.util.concurrent.CopyOnWriteArrayList r12 = r3     // Catch:{ Exception -> 0x01a0 }
                        r4 = r13
                        r9 = r22
                        r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x01a0 }
                        r0.a(r15, r14, r13)     // Catch:{ Exception -> 0x01a0 }
                        goto L_0x01b8
                    L_0x01a0:
                        r0 = move-exception
                        boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG
                        if (r4 == 0) goto L_0x01b8
                        java.lang.String r0 = r0.getLocalizedMessage()
                        com.mbridge.msdk.foundation.tools.aa.d(r2, r0)
                        goto L_0x01b8
                    L_0x01ad:
                        r17 = r3
                        r23 = r11
                        r3 = r12
                        r24 = r13
                        r22 = r14
                        r20 = r15
                    L_0x01b8:
                        java.lang.String r10 = r22.getendcard_url()
                        boolean r0 = r22.isDynamicView()
                        boolean r4 = com.mbridge.msdk.foundation.tools.af.j((java.lang.String) r10)
                        boolean r5 = android.text.TextUtils.isEmpty(r10)
                        if (r5 != 0) goto L_0x0231
                        if (r0 != 0) goto L_0x01e0
                        com.mbridge.msdk.reward.adapter.b r4 = com.mbridge.msdk.reward.adapter.b.this
                        android.content.Context r5 = r4
                        java.lang.String r6 = r7
                        java.lang.String r7 = r5
                        java.lang.String r8 = r8
                        com.mbridge.msdk.reward.adapter.b$i r11 = r9
                        java.util.concurrent.CopyOnWriteArrayList r12 = r3
                        r9 = r22
                        com.mbridge.msdk.reward.adapter.b.a(r4, r5, r6, r7, r8, r9, r10, r11, r12)
                        goto L_0x0231
                    L_0x01e0:
                        if (r4 == 0) goto L_0x01f6
                        com.mbridge.msdk.reward.adapter.b r4 = com.mbridge.msdk.reward.adapter.b.this
                        android.content.Context r5 = r4
                        java.lang.String r6 = r7
                        java.lang.String r7 = r5
                        java.lang.String r8 = r8
                        com.mbridge.msdk.reward.adapter.b$i r11 = r9
                        java.util.concurrent.CopyOnWriteArrayList r12 = r3
                        r9 = r22
                        com.mbridge.msdk.reward.adapter.b.a(r4, r5, r6, r7, r8, r9, r10, r11, r12)
                        goto L_0x0231
                    L_0x01f6:
                        boolean r0 = android.text.TextUtils.isEmpty(r10)
                        if (r0 != 0) goto L_0x0231
                        r4 = r23
                        boolean r0 = com.mbridge.msdk.foundation.tools.af.b((java.lang.String) r4, (java.lang.String) r10)
                        if (r0 == 0) goto L_0x0231
                        java.lang.String r0 = "ecid"
                        java.lang.String r0 = com.mbridge.msdk.foundation.tools.al.a(r10, r0)     // Catch:{ all -> 0x020f }
                        int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x020f }
                        goto L_0x0219
                    L_0x020f:
                        r0 = move-exception
                        java.lang.String r0 = r0.getMessage()
                        com.mbridge.msdk.foundation.tools.aa.d(r2, r0)
                        r0 = 404(0x194, float:5.66E-43)
                    L_0x0219:
                        com.mbridge.msdk.reward.adapter.b r4 = com.mbridge.msdk.reward.adapter.b.this
                        java.lang.StringBuilder r5 = new java.lang.StringBuilder
                        r5.<init>()
                        r5.append(r0)
                        r5.append(r3)
                        java.lang.String r0 = r5.toString()
                        r3 = 2
                        r14 = r22
                        r4.a(r3, r14, r0, r10)
                        goto L_0x0233
                    L_0x0231:
                        r14 = r22
                    L_0x0233:
                        java.lang.String r0 = r14.getEndScreenUrl()
                        boolean r0 = android.text.TextUtils.isEmpty(r0)
                        if (r0 != 0) goto L_0x0252
                        boolean r0 = r14.isDynamicView()
                        if (r0 != 0) goto L_0x0252
                        com.mbridge.msdk.videocommon.download.g r0 = com.mbridge.msdk.videocommon.download.g.a()
                        java.lang.String r3 = r14.getEndScreenUrl()
                        r4 = 0
                        r5 = r4
                        com.mbridge.msdk.videocommon.download.g$b r5 = (com.mbridge.msdk.videocommon.download.g.b) r5
                        r0.a(r3, r4)
                    L_0x0252:
                        java.lang.String r0 = r14.getIconUrl()
                        boolean r3 = android.text.TextUtils.isEmpty(r0)
                        if (r3 != 0) goto L_0x0286
                        android.content.Context r3 = r4     // Catch:{ Exception -> 0x027a }
                        com.mbridge.msdk.foundation.same.c.b r3 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r3)     // Catch:{ Exception -> 0x027a }
                        com.mbridge.msdk.reward.adapter.b$e r11 = new com.mbridge.msdk.reward.adapter.b$e     // Catch:{ Exception -> 0x027a }
                        com.mbridge.msdk.reward.adapter.b r4 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x027a }
                        com.mbridge.msdk.reward.adapter.b$h r5 = r4.a     // Catch:{ Exception -> 0x027a }
                        r6 = 0
                        java.lang.String r7 = r7     // Catch:{ Exception -> 0x027a }
                        java.lang.String r8 = r5     // Catch:{ Exception -> 0x027a }
                        java.lang.String r9 = r8     // Catch:{ Exception -> 0x027a }
                        r4 = r11
                        r10 = r14
                        r4.<init>(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x027a }
                        r3.a((java.lang.String) r0, (com.mbridge.msdk.foundation.same.c.c) r11)     // Catch:{ Exception -> 0x027a }
                        goto L_0x0286
                    L_0x027a:
                        r0 = move-exception
                        boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                        if (r3 == 0) goto L_0x0286
                        java.lang.String r0 = r0.getLocalizedMessage()
                        com.mbridge.msdk.foundation.tools.aa.d(r2, r0)
                    L_0x0286:
                        java.lang.String r0 = r14.getImageUrl()
                        boolean r3 = android.text.TextUtils.isEmpty(r0)
                        if (r3 != 0) goto L_0x02ba
                        android.content.Context r3 = r4     // Catch:{ Exception -> 0x02ae }
                        com.mbridge.msdk.foundation.same.c.b r3 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r3)     // Catch:{ Exception -> 0x02ae }
                        com.mbridge.msdk.reward.adapter.b$e r11 = new com.mbridge.msdk.reward.adapter.b$e     // Catch:{ Exception -> 0x02ae }
                        com.mbridge.msdk.reward.adapter.b r4 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x02ae }
                        com.mbridge.msdk.reward.adapter.b$h r5 = r4.a     // Catch:{ Exception -> 0x02ae }
                        r6 = 0
                        java.lang.String r7 = r7     // Catch:{ Exception -> 0x02ae }
                        java.lang.String r8 = r5     // Catch:{ Exception -> 0x02ae }
                        java.lang.String r9 = r8     // Catch:{ Exception -> 0x02ae }
                        r4 = r11
                        r10 = r14
                        r4.<init>(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x02ae }
                        r3.a((java.lang.String) r0, (com.mbridge.msdk.foundation.same.c.c) r11)     // Catch:{ Exception -> 0x02ae }
                        goto L_0x02ba
                    L_0x02ae:
                        r0 = move-exception
                        boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                        if (r3 == 0) goto L_0x02ba
                        java.lang.String r0 = r0.getLocalizedMessage()
                        com.mbridge.msdk.foundation.tools.aa.d(r2, r0)
                    L_0x02ba:
                        if (r20 == 0) goto L_0x03cc
                        java.lang.String r0 = r20.d()
                        boolean r3 = android.text.TextUtils.isEmpty(r0)
                        if (r3 != 0) goto L_0x035c
                        boolean r3 = r14.isDynamicView()
                        if (r3 != 0) goto L_0x035c
                        java.util.HashMap r3 = new java.util.HashMap
                        r3.<init>()
                        com.mbridge.msdk.foundation.entity.AabEntity r4 = r14.getAabEntity()
                        if (r4 == 0) goto L_0x02de
                        com.mbridge.msdk.foundation.entity.AabEntity r4 = r14.getAabEntity()
                        int r4 = r4.h3c
                        goto L_0x02df
                    L_0x02de:
                        r4 = 0
                    L_0x02df:
                        java.lang.String r5 = com.mbridge.msdk.MBridgeConstans.KEY_H3C
                        java.lang.String r4 = java.lang.String.valueOf(r4)
                        r3.put(r5, r4)
                        r4 = r24
                        boolean r4 = r0.contains(r4)
                        if (r4 == 0) goto L_0x032b
                        com.mbridge.msdk.videocommon.download.g r15 = com.mbridge.msdk.videocommon.download.g.a()     // Catch:{ Exception -> 0x031c }
                        com.mbridge.msdk.reward.adapter.b$g r13 = new com.mbridge.msdk.reward.adapter.b$g     // Catch:{ Exception -> 0x031c }
                        android.content.Context r5 = r4     // Catch:{ Exception -> 0x031c }
                        java.lang.String r6 = r7     // Catch:{ Exception -> 0x031c }
                        java.lang.String r7 = r5     // Catch:{ Exception -> 0x031c }
                        java.lang.String r8 = r8     // Catch:{ Exception -> 0x031c }
                        r10 = 313(0x139, float:4.39E-43)
                        com.mbridge.msdk.reward.adapter.b r4 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x031c }
                        com.mbridge.msdk.reward.adapter.b$h r11 = r4.a     // Catch:{ Exception -> 0x031c }
                        com.mbridge.msdk.reward.adapter.b$i r12 = r9     // Catch:{ Exception -> 0x031c }
                        java.util.concurrent.CopyOnWriteArrayList r9 = r3     // Catch:{ Exception -> 0x031c }
                        r4 = r13
                        r16 = r9
                        r9 = r14
                        r22 = r14
                        r14 = r13
                        r13 = r16
                        r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x031a }
                        r15.a(r3, r0, r14)     // Catch:{ Exception -> 0x031a }
                        goto L_0x035e
                    L_0x031a:
                        r0 = move-exception
                        goto L_0x031f
                    L_0x031c:
                        r0 = move-exception
                        r22 = r14
                    L_0x031f:
                        boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                        if (r3 == 0) goto L_0x035e
                        java.lang.String r0 = r0.getLocalizedMessage()
                        com.mbridge.msdk.foundation.tools.aa.d(r2, r0)
                        goto L_0x035e
                    L_0x032b:
                        r22 = r14
                        com.mbridge.msdk.videocommon.download.g r13 = com.mbridge.msdk.videocommon.download.g.a()     // Catch:{ Exception -> 0x034f }
                        com.mbridge.msdk.reward.adapter.b$d r14 = new com.mbridge.msdk.reward.adapter.b$d     // Catch:{ Exception -> 0x034f }
                        r5 = 313(0x139, float:4.39E-43)
                        java.lang.String r6 = r7     // Catch:{ Exception -> 0x034f }
                        java.lang.String r7 = r5     // Catch:{ Exception -> 0x034f }
                        java.lang.String r8 = r8     // Catch:{ Exception -> 0x034f }
                        com.mbridge.msdk.reward.adapter.b$i r10 = r9     // Catch:{ Exception -> 0x034f }
                        com.mbridge.msdk.reward.adapter.b r4 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x034f }
                        com.mbridge.msdk.reward.adapter.b$h r11 = r4.a     // Catch:{ Exception -> 0x034f }
                        java.util.concurrent.CopyOnWriteArrayList r12 = r3     // Catch:{ Exception -> 0x034f }
                        r4 = r14
                        r9 = r22
                        r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x034f }
                        r13.a(r3, r0, r14)     // Catch:{ Exception -> 0x034f }
                        goto L_0x035e
                    L_0x034f:
                        r0 = move-exception
                        boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                        if (r3 == 0) goto L_0x035e
                        java.lang.String r0 = r0.getLocalizedMessage()
                        com.mbridge.msdk.foundation.tools.aa.d(r2, r0)
                        goto L_0x035e
                    L_0x035c:
                        r22 = r14
                    L_0x035e:
                        java.util.List r0 = r20.f()
                        if (r0 == 0) goto L_0x03cc
                        int r3 = r0.size()
                        if (r3 <= 0) goto L_0x03cc
                        java.util.Iterator r3 = r0.iterator()
                    L_0x036e:
                        boolean r0 = r3.hasNext()
                        if (r0 == 0) goto L_0x03cc
                        java.lang.Object r0 = r3.next()
                        com.mbridge.msdk.foundation.entity.CampaignEx$c$a r0 = (com.mbridge.msdk.foundation.entity.CampaignEx.c.a) r0
                        if (r0 == 0) goto L_0x036e
                        java.util.List<java.lang.String> r4 = r0.b
                        if (r4 == 0) goto L_0x036e
                        java.util.List<java.lang.String> r4 = r0.b
                        int r4 = r4.size()
                        if (r4 <= 0) goto L_0x036e
                        java.util.List<java.lang.String> r0 = r0.b
                        java.util.Iterator r11 = r0.iterator()
                    L_0x038e:
                        boolean r0 = r11.hasNext()
                        if (r0 == 0) goto L_0x036e
                        java.lang.Object r0 = r11.next()
                        java.lang.String r0 = (java.lang.String) r0
                        boolean r4 = android.text.TextUtils.isEmpty(r0)
                        if (r4 != 0) goto L_0x038e
                        android.content.Context r4 = r4     // Catch:{ Exception -> 0x03bf }
                        com.mbridge.msdk.foundation.same.c.b r12 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r4)     // Catch:{ Exception -> 0x03bf }
                        com.mbridge.msdk.reward.adapter.b$e r13 = new com.mbridge.msdk.reward.adapter.b$e     // Catch:{ Exception -> 0x03bf }
                        com.mbridge.msdk.reward.adapter.b r4 = com.mbridge.msdk.reward.adapter.b.this     // Catch:{ Exception -> 0x03bf }
                        com.mbridge.msdk.reward.adapter.b$h r5 = r4.a     // Catch:{ Exception -> 0x03bf }
                        r6 = 1
                        java.lang.String r7 = r7     // Catch:{ Exception -> 0x03bf }
                        java.lang.String r8 = r5     // Catch:{ Exception -> 0x03bf }
                        java.lang.String r9 = r8     // Catch:{ Exception -> 0x03bf }
                        r4 = r13
                        r10 = r22
                        r4.<init>(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x03bf }
                        r12.a((java.lang.String) r0, (com.mbridge.msdk.foundation.same.c.c) r13)     // Catch:{ Exception -> 0x03bf }
                        goto L_0x038e
                    L_0x03bf:
                        r0 = move-exception
                        boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG
                        if (r4 == 0) goto L_0x038e
                        java.lang.String r0 = r0.getLocalizedMessage()
                        com.mbridge.msdk.foundation.tools.aa.d(r2, r0)
                        goto L_0x038e
                    L_0x03cc:
                        r3 = r17
                        goto L_0x0053
                    L_0x03d0:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.b.AnonymousClass1.run():void");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(final int i2, final CampaignEx campaignEx, String str, String str2) {
        com.mbridge.msdk.foundation.tools.k.a(i2, str, str2, new k.a() {
            public final void a(String str, String str2, String str3, String str4, boolean z) {
                if (!z) {
                    try {
                        n nVar = new n();
                        int i = i2;
                        if (i == 0) {
                            nVar.a(1);
                            nVar.e(1);
                            nVar.s("2000045");
                        } else if (i == 1) {
                            nVar.a(2);
                            nVar.e(1);
                            nVar.s("2000045");
                        } else if (i == 2) {
                            nVar.e(14);
                            nVar.s("2000043");
                            nVar.b(campaignEx.isMraid() ? n.a : n.b);
                            nVar.g("1");
                        }
                        b.a(nVar, campaignEx);
                        nVar.r(campaignEx.getId());
                        nVar.f(str);
                        nVar.n(campaignEx.getRequestId());
                        nVar.o(campaignEx.getCurrentLRid());
                        nVar.p(campaignEx.getRequestIdNotice());
                        nVar.m(str4);
                        com.mbridge.msdk.foundation.same.report.m.a().a(nVar, campaignEx);
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            public final void a(String str, DownloadError downloadError) {
                String str2 = "";
                if (downloadError != null) {
                    try {
                        if (downloadError.getException() != null) {
                            str2 = downloadError.getException().getMessage();
                        }
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                            return;
                        }
                        return;
                    }
                }
                n nVar = new n();
                int i = i2;
                if (i == 0) {
                    nVar.a(1);
                    nVar.e(3);
                    nVar.s("2000045");
                } else if (i == 1) {
                    nVar.a(2);
                    nVar.e(3);
                    nVar.s("2000045");
                } else if (i == 2) {
                    nVar.a(3);
                    nVar.e(3);
                    nVar.s("2000043");
                    nVar.b(campaignEx.isMraid() ? n.a : n.b);
                    nVar.g("1");
                }
                b.a(nVar, campaignEx);
                nVar.r(campaignEx.getId());
                nVar.f(str);
                nVar.n(campaignEx.getRequestId());
                nVar.o(campaignEx.getCurrentLRid());
                nVar.p(campaignEx.getRequestIdNotice());
                nVar.t(str2);
                com.mbridge.msdk.foundation.same.report.m.a().a(nVar, campaignEx);
            }
        }, campaignEx);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:19|20|21|22|23|24|25) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0078, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d4, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x00a7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(android.content.Context r15, com.mbridge.msdk.foundation.entity.CampaignEx r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, com.mbridge.msdk.reward.adapter.b.i r20) {
        /*
            r14 = this;
            r9 = r14
            r0 = r16
            r4 = r17
            r3 = r18
            r5 = r19
            r6 = r20
            monitor-enter(r14)
            com.mbridge.msdk.reward.adapter.b$h r1 = r9.a     // Catch:{ all -> 0x00d5 }
            r7 = r15
            r1.a(r15)     // Catch:{ all -> 0x00d5 }
            if (r0 == 0) goto L_0x0079
            java.lang.String r1 = r16.getCMPTEntryUrl()     // Catch:{ all -> 0x00d5 }
            boolean r2 = r16.isDynamicView()     // Catch:{ all -> 0x00d5 }
            if (r2 == 0) goto L_0x0079
            java.lang.String r2 = "dyview"
            boolean r2 = com.mbridge.msdk.foundation.tools.af.b((java.lang.String) r2, (java.lang.String) r1)     // Catch:{ all -> 0x00d5 }
            if (r2 == 0) goto L_0x003f
            int r2 = r16.getMof_tplid()     // Catch:{ all -> 0x00d5 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d5 }
            r7.<init>()     // Catch:{ all -> 0x00d5 }
            r7.append(r2)     // Catch:{ all -> 0x00d5 }
            java.lang.String r2 = ""
            r7.append(r2)     // Catch:{ all -> 0x00d5 }
            java.lang.String r2 = r7.toString()     // Catch:{ all -> 0x00d5 }
            r7 = 0
            r14.a(r7, r0, r2, r1)     // Catch:{ all -> 0x00d5 }
        L_0x003f:
            com.mbridge.msdk.videocommon.download.i r0 = com.mbridge.msdk.videocommon.download.i.a()     // Catch:{ all -> 0x00d5 }
            r2 = 1
            r0.b(r1, r2)     // Catch:{ all -> 0x00d5 }
            android.os.Message r0 = android.os.Message.obtain()     // Catch:{ all -> 0x00d5 }
            r2 = 105(0x69, float:1.47E-43)
            r0.what = r2     // Catch:{ all -> 0x00d5 }
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ all -> 0x00d5 }
            r2.<init>()     // Catch:{ all -> 0x00d5 }
            java.lang.String r7 = "unit_id"
            r2.putString(r7, r3)     // Catch:{ all -> 0x00d5 }
            java.lang.String r7 = com.mbridge.msdk.MBridgeConstans.PLACEMENT_ID     // Catch:{ all -> 0x00d5 }
            r2.putString(r7, r4)     // Catch:{ all -> 0x00d5 }
            java.lang.String r7 = "request_id"
            r2.putString(r7, r5)     // Catch:{ all -> 0x00d5 }
            java.lang.String r7 = "url"
            r2.putString(r7, r1)     // Catch:{ all -> 0x00d5 }
            r0.setData(r2)     // Catch:{ all -> 0x00d5 }
            com.mbridge.msdk.reward.adapter.b$h r2 = r9.a     // Catch:{ all -> 0x00d5 }
            r2.sendMessage(r0)     // Catch:{ all -> 0x00d5 }
            if (r6 == 0) goto L_0x0077
            r6.a(r4, r3, r5, r1)     // Catch:{ all -> 0x00d5 }
        L_0x0077:
            monitor-exit(r14)
            return
        L_0x0079:
            if (r0 == 0) goto L_0x00d3
            java.lang.String r1 = r16.getCMPTEntryUrl()     // Catch:{ all -> 0x00d5 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00d5 }
            if (r1 != 0) goto L_0x00d3
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ Exception -> 0x00c5 }
            r10.<init>()     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r1 = "local_rid"
            java.lang.String r2 = r16.getCurrentLRid()     // Catch:{ Exception -> 0x00a7 }
            r10.put(r1, r2)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r1 = "down_type"
            java.lang.String r2 = "1"
            r10.put(r1, r2)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r1 = "h3c"
            int r2 = r14.a((com.mbridge.msdk.foundation.entity.CampaignEx) r0)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x00a7 }
            r10.put(r1, r2)     // Catch:{ Exception -> 0x00a7 }
        L_0x00a7:
            com.mbridge.msdk.videocommon.download.g r11 = com.mbridge.msdk.videocommon.download.g.a()     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r12 = r16.getCMPTEntryUrl()     // Catch:{ Exception -> 0x00c5 }
            com.mbridge.msdk.reward.adapter.b$3 r13 = new com.mbridge.msdk.reward.adapter.b$3     // Catch:{ Exception -> 0x00c5 }
            r1 = r13
            r2 = r14
            r3 = r18
            r4 = r17
            r5 = r19
            r6 = r20
            r7 = r15
            r8 = r16
            r1.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00c5 }
            r11.a(r10, r12, r13)     // Catch:{ Exception -> 0x00c5 }
            goto L_0x00d3
        L_0x00c5:
            r0 = move-exception
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x00d5 }
            if (r1 == 0) goto L_0x00d3
            java.lang.String r1 = "RewardCampaignsResourceManager"
            java.lang.String r0 = r0.getLocalizedMessage()     // Catch:{ all -> 0x00d5 }
            com.mbridge.msdk.foundation.tools.aa.d(r1, r0)     // Catch:{ all -> 0x00d5 }
        L_0x00d3:
            monitor-exit(r14)
            return
        L_0x00d5:
            r0 = move-exception
            monitor-exit(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.b.a(android.content.Context, com.mbridge.msdk.foundation.entity.CampaignEx, java.lang.String, java.lang.String, java.lang.String, com.mbridge.msdk.reward.adapter.b$i):void");
    }

    /* compiled from: RewardCampaignsResourceManager */
    private static final class e implements com.mbridge.msdk.foundation.same.c.c {
        private Handler a;
        private int b;
        /* access modifiers changed from: private */
        public String c;
        private String d;
        private String e;
        /* access modifiers changed from: private */
        public CampaignEx f;

        public e(Handler handler, int i, String str, String str2, String str3, CampaignEx campaignEx) {
            this.a = handler;
            this.b = i;
            this.d = str;
            this.c = str2;
            this.e = str3;
            this.f = campaignEx;
        }

        public final void onSuccessLoad(Bitmap bitmap, String str) {
            com.mbridge.msdk.videocommon.download.i.a().c(str, true);
            Message obtain = Message.obtain();
            obtain.what = this.b == 0 ? 102 : 104;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.d);
            bundle.putString("request_id", this.e);
            obtain.setData(bundle);
            this.a.sendMessage(obtain);
        }

        public final void onFailedLoad(final String str, String str2) {
            Message obtain = Message.obtain();
            obtain.what = this.b == 0 ? 202 : 204;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.d);
            bundle.putString("request_id", this.e);
            obtain.setData(bundle);
            this.a.sendMessage(obtain);
            AnonymousClass1 r5 = new Runnable() {
                public final void run() {
                    if (e.this.f != null) {
                        try {
                            q a2 = q.a((com.mbridge.msdk.foundation.db.g) com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
                            aa.a("RewardCampaignsResourceManager", "campaign is null");
                            n nVar = new n();
                            nVar.s("2000044");
                            nVar.d(w.r(com.mbridge.msdk.foundation.controller.b.d().g()));
                            nVar.r(e.this.f.getId());
                            nVar.d(e.this.f.getImageUrl());
                            nVar.n(e.this.f.getRequestId());
                            nVar.p(e.this.f.getRequestIdNotice());
                            nVar.q(e.this.c);
                            nVar.t(str);
                            a2.a(nVar);
                        } catch (Exception e) {
                            if (MBridgeConstans.DEBUG) {
                                aa.d("RewardCampaignsResourceManager", e.getLocalizedMessage());
                            }
                        }
                    }
                }
            };
            com.mbridge.msdk.foundation.controller.c.a();
            com.mbridge.msdk.foundation.same.f.b.a().execute(r5);
        }
    }

    /* compiled from: RewardCampaignsResourceManager */
    private static final class f implements com.mbridge.msdk.videocommon.listener.a {
        private Handler a;
        private final String b;
        private final String c;
        private final String d;

        public f(Handler handler, String str, String str2, String str3) {
            this.a = handler;
            this.c = str;
            this.b = str2;
            this.d = str3;
        }

        public final void a(String str) {
            com.mbridge.msdk.videocommon.download.i.a().a(str, true);
            Message obtain = Message.obtain();
            obtain.what = 100;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.b);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.c);
            bundle.putString("request_id", this.d);
            bundle.putString("url", str);
            obtain.setData(bundle);
            this.a.sendMessage(obtain);
        }

        public final void a(String str, String str2) {
            com.mbridge.msdk.videocommon.download.i.a().a(str2, false);
            Message obtain = Message.obtain();
            obtain.what = 200;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.b);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.c);
            bundle.putString("request_id", this.d);
            bundle.putString("url", str2);
            bundle.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str);
            obtain.setData(bundle);
            this.a.sendMessage(obtain);
        }
    }

    /* compiled from: RewardCampaignsResourceManager */
    private static final class g implements g.d {
        private boolean a = false;
        /* access modifiers changed from: private */
        public Context b;
        /* access modifiers changed from: private */
        public String c;
        private String d;
        private String e;
        /* access modifiers changed from: private */
        public CampaignEx f;
        private int g;
        private Handler h;
        private i i;
        private CopyOnWriteArrayList<CampaignEx> j;
        private long k;

        public g(Context context, String str, String str2, String str3, CampaignEx campaignEx, int i2, Handler handler, i iVar, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.b = context;
            this.d = str;
            this.c = str2;
            this.e = str3;
            this.f = campaignEx;
            this.g = i2;
            this.h = handler;
            this.i = iVar;
            this.j = copyOnWriteArrayList;
            this.k = System.currentTimeMillis();
        }

        public final void a(boolean z) {
            this.a = z;
        }

        public final void a(String str, String str2, boolean z) {
            com.mbridge.msdk.videocommon.download.i.a().b(str, true);
            long currentTimeMillis = System.currentTimeMillis() - this.k;
            int i2 = this.g;
            if (i2 == 313) {
                Message obtain = Message.obtain();
                obtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle.putString("request_id", this.e);
                bundle.putString("url", str);
                obtain.setData(bundle);
                this.h.sendMessage(obtain);
            } else if (i2 == 497) {
                Message obtain2 = Message.obtain();
                obtain2.what = 101;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle2.putString("request_id", this.e);
                bundle2.putString("url", str);
                obtain2.setData(bundle2);
                this.h.sendMessage(obtain2);
                if (this.a) {
                    a(14, currentTimeMillis, str, "", str2);
                }
            } else if (i2 == 859) {
                Message obtain3 = Message.obtain();
                obtain3.what = 103;
                Bundle bundle3 = new Bundle();
                bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle3.putString("request_id", this.e);
                obtain3.setData(bundle3);
                this.h.sendMessage(obtain3);
                i iVar = this.i;
                if (iVar != null) {
                    iVar.a(this.d, this.c, this.e, str);
                }
                if (!z) {
                    a(1, str, "", str2);
                }
            }
        }

        private void a(int i2, String str, String str2, String str3) {
            final int i3 = i2;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() {
                public final void run() {
                    if (g.this.f != null && g.this.b != null) {
                        try {
                            n nVar = new n();
                            nVar.s("2000045");
                            if (g.this.b != null) {
                                nVar.d(w.r(g.this.b.getApplicationContext()));
                            }
                            nVar.e(i3);
                            if (g.this.f != null) {
                                nVar.r(g.this.f.getId());
                                nVar.n(g.this.f.getRequestId());
                                nVar.o(g.this.f.getCurrentLRid());
                                nVar.p(g.this.f.getRequestIdNotice());
                            }
                            nVar.i(str4);
                            nVar.t(str5);
                            nVar.q(g.this.c);
                            if (!TextUtils.isEmpty(str6)) {
                                nVar.m(str6);
                            }
                            if (ac.a().a("r_l_b_m_t_r_i", true)) {
                                nVar.a(2);
                                b.a(nVar, g.this.f);
                                com.mbridge.msdk.foundation.same.report.m.a().a(nVar, g.this.f);
                                return;
                            }
                            q.a((com.mbridge.msdk.foundation.db.g) com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g())).a(nVar);
                        } catch (Exception e2) {
                            if (MBridgeConstans.DEBUG) {
                                aa.d("RewardCampaignsResourceManager", e2.getLocalizedMessage());
                            }
                        }
                    }
                }
            });
        }

        private void a(int i2, long j2, String str, String str2, String str3) {
            final int i3 = i2;
            final long j3 = j2;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() {
                public final void run() {
                    if (g.this.f != null) {
                        try {
                            int i = i3;
                            n nVar = new n("2000043", i, j3 + "", str4, g.this.f.getId(), g.this.c, str5, "1");
                            nVar.n(g.this.f.getRequestId());
                            nVar.o(g.this.f.getCurrentLRid());
                            nVar.p(g.this.f.getRequestIdNotice());
                            nVar.r(g.this.f.getId());
                            nVar.c(g.this.f.getAdSpaceT());
                            nVar.m(str6);
                            if (g.this.f.getAdType() == 287) {
                                nVar.h(ExifInterface.GPS_MEASUREMENT_3D);
                            } else if (g.this.f.getAdType() == 94) {
                                nVar.h("1");
                            }
                            b.a(nVar, g.this.f);
                            com.mbridge.msdk.foundation.same.report.n.a(nVar, g.this.c, g.this.f);
                        } catch (Exception e2) {
                            if (MBridgeConstans.DEBUG) {
                                aa.d("RewardCampaignsResourceManager", e2.getLocalizedMessage());
                            }
                        }
                    }
                }
            });
        }

        public final void a(String str, String str2) {
            com.mbridge.msdk.videocommon.download.i.a().b(str2, false);
            long currentTimeMillis = System.currentTimeMillis() - this.k;
            int i2 = this.g;
            if (i2 == 313) {
                Message obtain = Message.obtain();
                obtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle.putString("request_id", this.e);
                bundle.putString("url", str2);
                bundle.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str);
                obtain.setData(bundle);
                this.h.sendMessage(obtain);
            } else if (i2 == 497) {
                Message obtain2 = Message.obtain();
                obtain2.what = 201;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle2.putString("request_id", this.e);
                bundle2.putString("url", str2);
                bundle2.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str);
                obtain2.setData(bundle2);
                this.h.sendMessage(obtain2);
                if (this.a) {
                    a(3, currentTimeMillis, str2, "zip download failed", "");
                }
            } else if (i2 == 859) {
                Message obtain3 = Message.obtain();
                obtain3.what = 203;
                Bundle bundle3 = new Bundle();
                bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle3.putString("request_id", this.e);
                bundle3.putString("url", str2);
                bundle3.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str);
                obtain3.setData(bundle3);
                this.h.sendMessage(obtain3);
                if (this.i != null) {
                    try {
                        this.i.a(this.d, this.c, this.e, str2, new com.mbridge.msdk.foundation.entity.e(6, str));
                    } catch (Exception unused) {
                    }
                }
                a(3, str2, str, "");
            }
        }
    }

    /* compiled from: RewardCampaignsResourceManager */
    private static final class d implements g.b {
        private boolean a = false;
        private int b;
        private final String c;
        /* access modifiers changed from: private */
        public final String d;
        private final String e;
        /* access modifiers changed from: private */
        public CampaignEx f;
        private i g;
        private Handler h;
        private CopyOnWriteArrayList<CampaignEx> i;
        private final long j;

        public d(int i2, String str, String str2, String str3, CampaignEx campaignEx, i iVar, Handler handler, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.b = i2;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = campaignEx;
            this.g = iVar;
            this.h = handler;
            this.i = copyOnWriteArrayList;
            this.j = System.currentTimeMillis();
        }

        public final void a(boolean z) {
            this.a = z;
        }

        public final void a(String str, String str2, boolean z) {
            com.mbridge.msdk.videocommon.download.i.a().b(str, true);
            int i2 = this.b;
            if (i2 == 313) {
                Message obtain = Message.obtain();
                obtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle.putString("request_id", this.e);
                bundle.putString("url", str);
                obtain.setData(bundle);
                this.h.sendMessage(obtain);
            } else if (i2 == 497) {
                Message obtain2 = Message.obtain();
                obtain2.what = 101;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle2.putString("request_id", this.e);
                bundle2.putString("url", str);
                obtain2.setData(bundle2);
                this.h.sendMessage(obtain2);
                if (this.a) {
                    a(20, System.currentTimeMillis() - this.j, str, "", str2);
                }
            } else if (i2 == 859) {
                Message obtain3 = Message.obtain();
                obtain3.what = 105;
                Bundle bundle3 = new Bundle();
                bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle3.putString("request_id", this.e);
                obtain3.setData(bundle3);
                this.h.sendMessage(obtain3);
                i iVar = this.g;
                if (iVar != null) {
                    iVar.a(this.c, this.d, this.e, str);
                }
            }
        }

        private void a(int i2, long j2, String str, String str2, String str3) {
            final int i3 = i2;
            final long j3 = j2;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() {
                public final void run() {
                    if (d.this.f != null) {
                        try {
                            int i = i3;
                            n nVar = new n("2000043", i, j3 + "", str4, d.this.f.getId(), d.this.d, str5, "2");
                            nVar.n(d.this.f.getRequestId());
                            nVar.o(d.this.f.getCurrentLRid());
                            nVar.p(d.this.f.getRequestIdNotice());
                            nVar.r(d.this.f.getId());
                            nVar.c(d.this.f.getAdSpaceT());
                            if (d.this.f.getAdType() == 287) {
                                nVar.h(ExifInterface.GPS_MEASUREMENT_3D);
                            } else if (d.this.f.getAdType() == 94) {
                                nVar.h("1");
                            }
                            if (!TextUtils.isEmpty(str6)) {
                                nVar.m(str6);
                            }
                            b.a(nVar, d.this.f);
                            com.mbridge.msdk.foundation.same.report.n.a(nVar, d.this.d, d.this.f);
                        } catch (Exception e2) {
                            if (MBridgeConstans.DEBUG) {
                                aa.d("RewardCampaignsResourceManager", e2.getLocalizedMessage());
                            }
                        }
                    }
                }
            });
        }

        public final void a(String str, String str2) {
            com.mbridge.msdk.videocommon.download.i.a().b(str, false);
            int i2 = this.b;
            if (i2 == 313) {
                Message obtain = Message.obtain();
                obtain.what = 201;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle.putString("request_id", this.e);
                bundle.putString("url", str);
                bundle.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str2);
                obtain.setData(bundle);
                this.h.sendMessage(obtain);
            } else if (i2 == 497) {
                Message obtain2 = Message.obtain();
                obtain2.what = 201;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle2.putString("request_id", this.e);
                bundle2.putString("url", str);
                bundle2.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str2);
                obtain2.setData(bundle2);
                this.h.sendMessage(obtain2);
                if (this.a) {
                    a(21, System.currentTimeMillis() - this.j, str, "url download failed", "");
                }
            } else if (i2 == 859) {
                Message obtain3 = Message.obtain();
                obtain3.what = 205;
                Bundle bundle3 = new Bundle();
                bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle3.putString("request_id", this.e);
                bundle3.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str2);
                obtain3.setData(bundle3);
                this.h.sendMessage(obtain3);
                if (this.g != null) {
                    try {
                        this.g.a(this.c, this.d, this.e, str, new com.mbridge.msdk.foundation.entity.e(6, str2));
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    /* compiled from: RewardCampaignsResourceManager */
    private static final class h extends Handler {
        private Context a;
        private ConcurrentHashMap<String, c> b = new ConcurrentHashMap<>();
        private ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> c = new ConcurrentHashMap<>();

        public h(Looper looper) {
            super(looper);
        }

        public final void a(String str, String str2, String str3, c cVar) {
            ConcurrentHashMap<String, c> concurrentHashMap = this.b;
            concurrentHashMap.put(str2 + "_" + str3, cVar);
        }

        public final void a(Context context) {
            this.a = context;
        }

        public final void a(String str, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.c.put(str, copyOnWriteArrayList);
        }

        public final void handleMessage(Message message) {
            boolean z;
            com.mbridge.msdk.foundation.entity.e eVar;
            Message message2 = message;
            Bundle data = message.getData();
            String string = data.getString(MBridgeConstans.PLACEMENT_ID);
            String string2 = data.getString(MBridgeConstans.PROPERTIES_UNIT_ID);
            String string3 = data.getString("request_id");
            String str = string2 + "_" + string3;
            a aVar = (a) b.b.get(str);
            c cVar = this.b.get(str);
            CopyOnWriteArrayList copyOnWriteArrayList = this.c.get(str);
            int i = message2.what;
            switch (i) {
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                    break;
                default:
                    switch (i) {
                        case 200:
                        case 201:
                        case 203:
                        case 205:
                            if (aVar != null && cVar != null) {
                                String string4 = data.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                                if (string4 == null) {
                                    string4 = "";
                                }
                                com.mbridge.msdk.foundation.entity.e eVar2 = new com.mbridge.msdk.foundation.entity.e(message2.what, "resource download failed " + b.b(message2.what) + " " + string4, true);
                                CampaignEx campaignEx = (aVar.h == null || aVar.h.size() <= 0) ? null : aVar.h.get(0);
                                try {
                                    if (!aVar.a || aVar.i == null) {
                                        com.mbridge.msdk.foundation.entity.e eVar3 = eVar2;
                                        if (com.mbridge.msdk.videocommon.download.c.getInstance().a(94, aVar.e, aVar.b, aVar.d, aVar.a, aVar.c, copyOnWriteArrayList)) {
                                            cVar.a(string, string2, string3, aVar.h);
                                        } else {
                                            if (!(campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0)) {
                                                int i2 = message2.what;
                                                if (i2 != 200) {
                                                    if (i2 != 201) {
                                                        if (i2 != 203) {
                                                            if (i2 == 205) {
                                                                if (campaignEx.getRsIgnoreCheckRule().contains(3)) {
                                                                    return;
                                                                }
                                                            }
                                                        } else if (campaignEx.getRsIgnoreCheckRule().contains(1)) {
                                                            return;
                                                        }
                                                    } else if (campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                        return;
                                                    }
                                                } else if (campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                                    return;
                                                }
                                            }
                                            cVar.a(string, string2, string3, aVar.h, eVar3);
                                        }
                                        this.b.remove(str);
                                        b.b.remove(str);
                                        this.c.remove(str);
                                        return;
                                    } else if (aVar.c == 1) {
                                        if (!(campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0)) {
                                            int i3 = message2.what;
                                            if (i3 != 200) {
                                                if (i3 != 201) {
                                                    if (i3 != 203) {
                                                        if (i3 == 205) {
                                                            if (!campaignEx.getRsIgnoreCheckRule().contains(3)) {
                                                                if (aVar.h != null && aVar.h.size() > 0) {
                                                                    CampaignEx campaignEx2 = aVar.h.get(0);
                                                                    if (campaignEx2.getCMPTEntryUrl().equals(campaignEx2.getendcard_url()) && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                                        return;
                                                                    }
                                                                }
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    } else if (campaignEx.getRsIgnoreCheckRule().contains(1)) {
                                                        return;
                                                    }
                                                } else if (campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                    return;
                                                }
                                            } else if (campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                                return;
                                            }
                                        }
                                        cVar.a(string, string2, string3, aVar.h, eVar2);
                                        this.b.remove(str);
                                        b.b.remove(str);
                                        this.c.remove(str);
                                        return;
                                    } else {
                                        String string5 = data.getString("url");
                                        int i4 = message2.what;
                                        if (i4 != 200) {
                                            if (i4 != 201) {
                                                if (i4 != 203) {
                                                    if (i4 == 205) {
                                                        if (campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(3)) {
                                                            aVar.i.clear();
                                                            b.b.remove(str);
                                                            b.b.put(str, aVar);
                                                        } else {
                                                            aa.b("RewardCampaignsResourceManager", "Is TPL but download BTL Template fail but hit ignoreCheckRule");
                                                            return;
                                                        }
                                                    }
                                                } else if (campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(1)) {
                                                    for (int i5 = 0; i5 < aVar.i.size(); i5++) {
                                                        CampaignEx campaignEx3 = aVar.i.get(i5);
                                                        if (campaignEx3.getRewardTemplateMode() != null && campaignEx3.getRewardTemplateMode().e().equals(string5)) {
                                                            aVar.i.remove(i5);
                                                        }
                                                    }
                                                    b.b.remove(str);
                                                    b.b.put(str, aVar);
                                                } else {
                                                    aa.b("RewardCampaignsResourceManager", "Is TPL but download template fail but hit ignoreCheckRule");
                                                    return;
                                                }
                                            } else if (campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                for (int i6 = 0; i6 < aVar.i.size(); i6++) {
                                                    CampaignEx campaignEx4 = aVar.i.get(i6);
                                                    if (campaignEx4.getRewardTemplateMode() != null && campaignEx4.getRewardTemplateMode().d().equals(string5)) {
                                                        aVar.i.remove(i6);
                                                    }
                                                    if (!TextUtils.isEmpty(campaignEx4.getendcard_url()) && campaignEx4.getendcard_url().equals(string5)) {
                                                        aVar.i.remove(i6);
                                                    }
                                                }
                                                b.b.remove(str);
                                                b.b.put(str, aVar);
                                            } else {
                                                aa.b("RewardCampaignsResourceManager", "Is TPL but download endcard fail but hit ignoreCheckRule");
                                                return;
                                            }
                                        } else if (campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                            for (int i7 = 0; i7 < aVar.i.size(); i7++) {
                                                if (aVar.i.get(i7).getVideoUrlEncode().equals(string5)) {
                                                    aVar.i.remove(i7);
                                                }
                                            }
                                            b.b.remove(str);
                                            b.b.put(str, aVar);
                                        } else {
                                            aa.b("RewardCampaignsResourceManager", "Is TPL but  video download fail but hit ignoreCheckRule");
                                            return;
                                        }
                                        eVar = eVar2;
                                        try {
                                            if (com.mbridge.msdk.videocommon.download.c.getInstance().a(94, aVar.e, aVar.b, aVar.d, aVar.a, aVar.c, copyOnWriteArrayList)) {
                                                cVar.a(string, string2, string3, aVar.h);
                                                this.b.remove(str);
                                                b.b.remove(str);
                                                this.c.remove(str);
                                                return;
                                            } else if (aVar.i.size() == 0) {
                                                cVar.a(string, string2, string3, aVar.h, eVar);
                                                this.b.remove(str);
                                                b.b.remove(str);
                                                this.c.remove(str);
                                                return;
                                            } else {
                                                return;
                                            }
                                        } catch (Exception unused) {
                                            cVar.a(string, string2, string3, aVar.h, eVar);
                                            return;
                                        }
                                    }
                                } catch (Exception unused2) {
                                    eVar = eVar2;
                                    cVar.a(string, string2, string3, aVar.h, eVar);
                                    return;
                                }
                            } else {
                                return;
                            }
                        case 202:
                        case 204:
                            break;
                        default:
                            return;
                    }
            }
            if (aVar != null && cVar != null) {
                try {
                    z = com.mbridge.msdk.videocommon.download.c.getInstance().a(94, aVar.e, aVar.b, aVar.d, aVar.a, aVar.c, copyOnWriteArrayList);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        aa.d("RewardCampaignsResourceManager", e.getLocalizedMessage());
                    }
                    z = false;
                }
                if (z) {
                    cVar.a(string, string2, string3, aVar.h);
                    this.b.remove(str);
                    b.b.remove(str);
                    this.c.remove(str);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0040, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x005f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00fc */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0175 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01a7 A[Catch:{ Exception -> 0x020b }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01ad A[Catch:{ Exception -> 0x020b }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x021c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(boolean r24, android.os.Handler r25, boolean r26, boolean r27, com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r28, java.lang.String r29, int r30, com.mbridge.msdk.foundation.entity.CampaignEx r31, java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, com.mbridge.msdk.videocommon.d.c r38, com.mbridge.msdk.reward.adapter.b.j r39) {
        /*
            r23 = this;
            r15 = r29
            r13 = r31
            r0 = r32
            r14 = r35
            r12 = r36
            java.lang.String r10 = "WebView exception: "
            java.lang.String r11 = "WebView exception: "
            monitor-enter(r23)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0239 }
            r1.<init>()     // Catch:{ all -> 0x0239 }
            r1.append(r14)     // Catch:{ all -> 0x0239 }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x0239 }
            r1.append(r15)     // Catch:{ all -> 0x0239 }
            java.lang.String r17 = r1.toString()     // Catch:{ all -> 0x0239 }
            long r18 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0239 }
            boolean r1 = com.mbridge.msdk.foundation.tools.af.i((java.lang.String) r29)     // Catch:{ Exception -> 0x020b }
            if (r1 == 0) goto L_0x0041
            if (r39 == 0) goto L_0x003f
            r7 = 0
            r1 = r39
            r2 = r17
            r3 = r34
            r4 = r35
            r5 = r36
            r6 = r29
            r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x020b }
        L_0x003f:
            monitor-exit(r23)
            return
        L_0x0041:
            com.mbridge.msdk.foundation.controller.b r1 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x005f }
            android.content.Context r2 = r1.g()     // Catch:{ Exception -> 0x005f }
            java.lang.String r3 = "start preload template "
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x005f }
            long r8 = r4 - r18
            r1 = r31
            r4 = r35
            r5 = r27
            r6 = r36
            r7 = r37
            com.mbridge.msdk.reward.c.a.a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x005f }
        L_0x005f:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x020b }
            r1.<init>()     // Catch:{ Exception -> 0x020b }
            java.lang.String r2 = "type"
            java.lang.String r3 = "2"
            r1.put(r2, r3)     // Catch:{ Exception -> 0x020b }
            com.mbridge.msdk.foundation.same.report.m r2 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x020b }
            java.lang.String r3 = "2000154"
            r2.a((java.lang.String) r3, (com.mbridge.msdk.foundation.entity.CampaignEx) r13, (java.util.Map<java.lang.String, java.lang.String>) r1)     // Catch:{ Exception -> 0x020b }
            com.mbridge.msdk.videocommon.a$a r8 = new com.mbridge.msdk.videocommon.a$a     // Catch:{ Exception -> 0x020b }
            r8.<init>()     // Catch:{ Exception -> 0x020b }
            com.mbridge.msdk.reward.adapter.b r1 = com.mbridge.msdk.reward.adapter.b.m.a     // Catch:{ Exception -> 0x020b }
            r2 = 0
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r1 = r1.a((boolean) r2)     // Catch:{ Exception -> 0x020b }
            if (r1 != 0) goto L_0x0199
            r1 = 1
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r2 = new com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView     // Catch:{ Exception -> 0x0120, all -> 0x00a4 }
            com.mbridge.msdk.foundation.controller.b r3 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0120, all -> 0x00a4 }
            android.content.Context r3 = r3.g()     // Catch:{ Exception -> 0x0120, all -> 0x00a4 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0120, all -> 0x00a4 }
            if (r13 == 0) goto L_0x009c
            java.lang.String r3 = r31.getCurrentLRid()     // Catch:{ Exception -> 0x0120, all -> 0x00a4 }
            r2.setLocalRequestId(r3)     // Catch:{ Exception -> 0x0120, all -> 0x00a4 }
        L_0x009c:
            r3 = 2
            r2.setTempTypeForMetrics(r3)     // Catch:{ Exception -> 0x0120, all -> 0x00a4 }
            r11 = r2
            r10 = r8
            goto L_0x019b
        L_0x00a4:
            r0 = move-exception
            if (r39 == 0) goto L_0x011e
            r8.a((boolean) r1)     // Catch:{ Exception -> 0x020b }
            com.mbridge.msdk.videocommon.download.i r2 = com.mbridge.msdk.videocommon.download.i.a()     // Catch:{ Exception -> 0x020b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x020b }
            r3.<init>()     // Catch:{ Exception -> 0x020b }
            r3.append(r14)     // Catch:{ Exception -> 0x020b }
            java.lang.String r4 = "_"
            r3.append(r4)     // Catch:{ Exception -> 0x020b }
            r3.append(r12)     // Catch:{ Exception -> 0x020b }
            java.lang.String r4 = "_"
            r3.append(r4)     // Catch:{ Exception -> 0x020b }
            r3.append(r15)     // Catch:{ Exception -> 0x020b }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x020b }
            r2.d(r3, r1)     // Catch:{ Exception -> 0x020b }
            com.mbridge.msdk.foundation.controller.b r1 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x00fb }
            android.content.Context r2 = r1.g()     // Catch:{ Exception -> 0x00fb }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fb }
            r1.<init>(r10)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x00fb }
            r1.append(r0)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r3 = r1.toString()     // Catch:{ Exception -> 0x00fb }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00fb }
            long r9 = r0 - r18
            r1 = r31
            r4 = r35
            r5 = r27
            r6 = r36
            r7 = r37
            r11 = r8
            r8 = r9
            com.mbridge.msdk.reward.c.a.a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00fc }
            goto L_0x00fc
        L_0x00fb:
            r11 = r8
        L_0x00fc:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x020b }
            r0.<init>()     // Catch:{ Exception -> 0x020b }
            r0.append(r14)     // Catch:{ Exception -> 0x020b }
            java.lang.String r1 = "_"
            r0.append(r1)     // Catch:{ Exception -> 0x020b }
            r0.append(r15)     // Catch:{ Exception -> 0x020b }
            java.lang.String r2 = r0.toString()     // Catch:{ Exception -> 0x020b }
            r1 = r39
            r3 = r34
            r4 = r35
            r5 = r36
            r6 = r29
            r7 = r11
            r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x020b }
        L_0x011e:
            monitor-exit(r23)
            return
        L_0x0120:
            r0 = move-exception
            r10 = r8
            if (r39 == 0) goto L_0x0197
            r10.a((boolean) r1)     // Catch:{ Exception -> 0x020b }
            com.mbridge.msdk.videocommon.download.i r2 = com.mbridge.msdk.videocommon.download.i.a()     // Catch:{ Exception -> 0x020b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x020b }
            r3.<init>()     // Catch:{ Exception -> 0x020b }
            r3.append(r14)     // Catch:{ Exception -> 0x020b }
            java.lang.String r4 = "_"
            r3.append(r4)     // Catch:{ Exception -> 0x020b }
            r3.append(r12)     // Catch:{ Exception -> 0x020b }
            java.lang.String r4 = "_"
            r3.append(r4)     // Catch:{ Exception -> 0x020b }
            r3.append(r15)     // Catch:{ Exception -> 0x020b }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x020b }
            r2.d(r3, r1)     // Catch:{ Exception -> 0x020b }
            com.mbridge.msdk.foundation.controller.b r1 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0175 }
            android.content.Context r2 = r1.g()     // Catch:{ Exception -> 0x0175 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0175 }
            r1.<init>(r11)     // Catch:{ Exception -> 0x0175 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0175 }
            r1.append(r0)     // Catch:{ Exception -> 0x0175 }
            java.lang.String r3 = r1.toString()     // Catch:{ Exception -> 0x0175 }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0175 }
            long r8 = r0 - r18
            r1 = r31
            r4 = r35
            r5 = r27
            r6 = r36
            r7 = r37
            com.mbridge.msdk.reward.c.a.a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0175 }
        L_0x0175:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x020b }
            r0.<init>()     // Catch:{ Exception -> 0x020b }
            r0.append(r14)     // Catch:{ Exception -> 0x020b }
            java.lang.String r1 = "_"
            r0.append(r1)     // Catch:{ Exception -> 0x020b }
            r0.append(r15)     // Catch:{ Exception -> 0x020b }
            java.lang.String r2 = r0.toString()     // Catch:{ Exception -> 0x020b }
            r1 = r39
            r3 = r34
            r4 = r35
            r5 = r36
            r6 = r29
            r7 = r10
            r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x020b }
        L_0x0197:
            monitor-exit(r23)
            return
        L_0x0199:
            r10 = r8
            r11 = r1
        L_0x019b:
            r10.a((com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView) r11)     // Catch:{ Exception -> 0x020b }
            r1 = 0
            if (r0 == 0) goto L_0x01ad
            int r2 = r32.size()     // Catch:{ Exception -> 0x020b }
            if (r2 <= 0) goto L_0x01ad
            com.mbridge.msdk.video.signal.a.j r2 = new com.mbridge.msdk.video.signal.a.j     // Catch:{ Exception -> 0x020b }
            r2.<init>(r1, r13, r0)     // Catch:{ Exception -> 0x020b }
            goto L_0x01b2
        L_0x01ad:
            com.mbridge.msdk.video.signal.a.j r2 = new com.mbridge.msdk.video.signal.a.j     // Catch:{ Exception -> 0x020b }
            r2.<init>(r1, r13)     // Catch:{ Exception -> 0x020b }
        L_0x01b2:
            r1 = r30
            r9 = r2
            r9.a((int) r1)     // Catch:{ Exception -> 0x020b }
            r9.a((java.lang.String) r14)     // Catch:{ Exception -> 0x020b }
            r1 = r38
            r9.a((com.mbridge.msdk.videocommon.d.c) r1)     // Catch:{ Exception -> 0x020b }
            r1 = r24
            r9.d((boolean) r1)     // Catch:{ Exception -> 0x020b }
            com.mbridge.msdk.reward.adapter.b$k r8 = new com.mbridge.msdk.reward.adapter.b$k     // Catch:{ Exception -> 0x020b }
            r3 = 0
            r1 = r8
            r2 = r25
            r4 = r26
            r5 = r27
            r6 = r36
            r7 = r39
            r20 = r8
            r8 = r28
            r21 = r9
            r9 = r29
            r16 = r10
            r10 = r34
            r22 = r11
            r11 = r35
            r12 = r16
            r13 = r31
            r14 = r32
            r15 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x0207 }
            r0 = r20
            r1 = r22
            r1.setWebViewListener(r0)     // Catch:{ Exception -> 0x0207 }
            r2 = r21
            r1.setObject(r2)     // Catch:{ Exception -> 0x0207 }
            r0 = r33
            r1.loadUrl(r0)     // Catch:{ Exception -> 0x0207 }
            r5 = r36
            r1.setRid(r5)     // Catch:{ Exception -> 0x0205 }
            goto L_0x0237
        L_0x0205:
            r0 = move-exception
            goto L_0x020d
        L_0x0207:
            r0 = move-exception
            r5 = r36
            goto L_0x020d
        L_0x020b:
            r0 = move-exception
            r5 = r12
        L_0x020d:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0239 }
            if (r1 == 0) goto L_0x021a
            java.lang.String r1 = "RewardCampaignsResourceManager"
            java.lang.String r2 = r0.getLocalizedMessage()     // Catch:{ all -> 0x0239 }
            com.mbridge.msdk.foundation.tools.aa.d(r1, r2)     // Catch:{ all -> 0x0239 }
        L_0x021a:
            if (r39 == 0) goto L_0x0237
            com.mbridge.msdk.foundation.entity.e r8 = new com.mbridge.msdk.foundation.entity.e     // Catch:{ all -> 0x0239 }
            java.lang.String r0 = r0.getLocalizedMessage()     // Catch:{ all -> 0x0239 }
            r1 = 9
            r8.<init>(r1, r0)     // Catch:{ all -> 0x0239 }
            r7 = 0
            r1 = r39
            r2 = r17
            r3 = r34
            r4 = r35
            r5 = r36
            r6 = r29
            r1.a(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0239 }
        L_0x0237:
            monitor-exit(r23)
            return
        L_0x0239:
            r0 = move-exception
            monitor-exit(r23)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.b.a(boolean, android.os.Handler, boolean, boolean, com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView, java.lang.String, int, com.mbridge.msdk.foundation.entity.CampaignEx, java.util.concurrent.CopyOnWriteArrayList, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.mbridge.msdk.videocommon.d.c, com.mbridge.msdk.reward.adapter.b$j):void");
    }

    /* access modifiers changed from: private */
    public static synchronized String b(int i2) {
        synchronized (b.class) {
            if (i2 == 200) {
                return "video";
            }
            if (i2 == 201) {
                return "zip/html";
            }
            if (i2 != 203) {
                return i2 != 205 ? "unknown" : "tpl";
            }
            return "temp";
        }
    }

    /* compiled from: RewardCampaignsResourceManager */
    private static class k extends com.mbridge.msdk.mbsignalcommon.b.b {
        private Handler a;
        private Runnable b;
        private final boolean c;
        private final boolean d;
        private String e;
        private final j f;
        private final WindVaneWebView g;
        private final String h;
        private final String i;
        private final String j;
        private final a.C0158a k;
        private final CampaignEx l;
        private CopyOnWriteArrayList<CampaignEx> m;
        private long n;
        private boolean o;
        private boolean p;
        private final Runnable q;
        private final Runnable r;

        public k(Handler handler, Runnable runnable, boolean z, boolean z2, String str, j jVar, WindVaneWebView windVaneWebView, String str2, String str3, String str4, a.C0158a aVar, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, long j2) {
            Handler handler2 = handler;
            this.a = handler2;
            this.b = runnable;
            this.c = z;
            this.d = z2;
            this.e = str;
            this.f = jVar;
            this.g = windVaneWebView;
            this.h = str2;
            this.i = str4;
            this.j = str3;
            this.k = aVar;
            this.l = campaignEx;
            this.m = copyOnWriteArrayList;
            this.n = j2;
            final j jVar2 = jVar;
            AnonymousClass1 r14 = r0;
            final a.C0158a aVar2 = aVar;
            final String str5 = str4;
            final String str6 = str;
            final String str7 = str2;
            final CampaignEx campaignEx2 = campaignEx;
            final boolean z3 = z2;
            final long j3 = j2;
            final String str8 = str3;
            AnonymousClass1 r0 = new Runnable() {
                public final void run() {
                    WindVaneWebView a2;
                    a.C0158a aVar;
                    if (!(jVar2 == null || (aVar = aVar2) == null)) {
                        aVar.a(true);
                        com.mbridge.msdk.videocommon.download.i a3 = com.mbridge.msdk.videocommon.download.i.a();
                        a3.d(str5 + "_" + str6 + "_" + str7, true);
                        try {
                            com.mbridge.msdk.reward.c.a.a(campaignEx2, com.mbridge.msdk.foundation.controller.b.d().g(), "WebView onPageFinish timeout exception after 5s", str5, z3, str6, campaignEx2.getRequestIdNotice(), System.currentTimeMillis() - j3);
                        } catch (Exception unused) {
                        }
                        j jVar = jVar2;
                        jVar.a(str5 + "_" + str7, str8, str5, str6, str7, aVar2);
                    }
                    a.C0158a aVar2 = aVar2;
                    if (aVar2 != null && (a2 = aVar2.a()) != null) {
                        try {
                            a2.release();
                        } catch (Exception unused2) {
                        }
                    }
                }
            };
            this.r = r14;
            AnonymousClass2 r15 = r0;
            final String str9 = str3;
            AnonymousClass2 r02 = new Runnable() {
                public final void run() {
                    WindVaneWebView a2;
                    a.C0158a aVar;
                    if (!(jVar2 == null || (aVar = aVar2) == null)) {
                        aVar.a(true);
                        com.mbridge.msdk.videocommon.download.i a3 = com.mbridge.msdk.videocommon.download.i.a();
                        a3.d(str5 + "_" + str6 + "_" + str7, true);
                        try {
                            com.mbridge.msdk.reward.c.a.a(campaignEx2, com.mbridge.msdk.foundation.controller.b.d().g(), "WebView readyState timeout exception after 5s", str5, z3, str6, campaignEx2.getRequestIdNotice(), System.currentTimeMillis() - j3);
                        } catch (Exception unused) {
                        }
                        j jVar = jVar2;
                        jVar.a(str5 + "_" + str7, str9, str5, str6, str7, aVar2);
                    }
                    a.C0158a aVar2 = aVar2;
                    if (aVar2 != null && (a2 = aVar2.a()) != null) {
                        try {
                            a2.release();
                        } catch (Exception unused2) {
                        }
                    }
                }
            };
            this.q = r15;
            if (handler2 != null) {
                handler2.postDelayed(r14, 5000);
            }
        }

        public final void a(WebView webView, int i2) {
            Handler handler;
            Runnable runnable;
            Runnable runnable2;
            super.a(webView, i2);
            Handler handler2 = this.a;
            if (!(handler2 == null || (runnable2 = this.q) == null)) {
                handler2.removeCallbacks(runnable2);
            }
            Handler handler3 = this.a;
            if (!(handler3 == null || (runnable = this.r) == null)) {
                handler3.removeCallbacks(runnable);
            }
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(IronSourceConstants.EVENTS_RESULT, i2 + "");
                hashMap.put("type", "2");
                com.mbridge.msdk.foundation.same.report.m.a().a("2000155", this.l, (Map<String, String>) hashMap);
            } catch (Throwable th) {
                aa.d("WindVaneWebView", th.getMessage());
            }
            if (!this.p) {
                try {
                    com.mbridge.msdk.reward.c.a.a(this.l, com.mbridge.msdk.foundation.controller.b.d().g(), "preload temp readState: " + i2, this.i, this.d, this.e, this.l.getRequestIdNotice(), System.currentTimeMillis() - this.n);
                } catch (Exception unused) {
                }
                String str = this.i + "_" + this.h;
                if (i2 == 1) {
                    Runnable runnable3 = this.b;
                    if (!(runnable3 == null || (handler = this.a) == null)) {
                        handler.removeCallbacks(runnable3);
                    }
                    com.mbridge.msdk.videocommon.download.i.a().d(this.i + "_" + this.e + "_" + this.h, true);
                    a.C0158a aVar = this.k;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    if (this.c) {
                        if (this.d) {
                            com.mbridge.msdk.videocommon.a.a(287, this.l.getRequestIdNotice(), this.k);
                        } else {
                            com.mbridge.msdk.videocommon.a.b(287, this.l.getRequestIdNotice(), this.k);
                        }
                    } else if (this.d) {
                        com.mbridge.msdk.videocommon.a.a(94, this.l.getRequestIdNotice(), this.k);
                    } else {
                        com.mbridge.msdk.videocommon.a.b(94, this.l.getRequestIdNotice(), this.k);
                    }
                    j jVar = this.f;
                    if (jVar != null) {
                        jVar.a(str, this.j, this.i, this.e, this.h, this.k);
                    }
                } else if (this.f != null) {
                    this.f.a(str, this.j, this.i, this.e, this.h, this.k, new com.mbridge.msdk.foundation.entity.e(9, "state " + i2));
                }
                this.p = true;
            }
        }

        public final void a(WebView webView, int i2, String str, String str2) {
            String str3 = str;
            super.a(webView, i2, str, str2);
            com.mbridge.msdk.videocommon.download.i.a().d(this.i + "_" + this.e + "_" + this.h, false);
            try {
                com.mbridge.msdk.reward.c.a.a(this.l, com.mbridge.msdk.foundation.controller.b.d().g(), "WebView onReceivedError exception: " + str3, this.i, this.d, this.e, this.l.getRequestIdNotice(), System.currentTimeMillis() - this.n);
            } catch (Exception unused) {
            }
            Handler handler = this.a;
            if (handler != null) {
                if (this.q != null) {
                    handler.removeCallbacks(this.r);
                }
                Runnable runnable = this.q;
                if (runnable != null) {
                    this.a.removeCallbacks(runnable);
                }
            }
            try {
                String str4 = this.i + "_" + this.h;
                a.C0158a aVar = this.k;
                if (aVar != null) {
                    aVar.a(false);
                }
                if (this.f != null) {
                    this.f.a(str4, this.j, this.i, this.e, str2, this.k, new com.mbridge.msdk.foundation.entity.e(8, str3));
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("WindVaneWebView", e2.getLocalizedMessage());
                }
            }
        }

        public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            super.a(webView, sslErrorHandler, sslError);
            com.mbridge.msdk.videocommon.download.i.a().d(this.i + "_" + this.e + "_" + this.h, false);
            try {
                CampaignEx campaignEx = this.l;
                Context g2 = com.mbridge.msdk.foundation.controller.b.d().g();
                StringBuilder sb = new StringBuilder("WebView onReceivedSslError exception: ");
                if (sslError == null) {
                    str = "SSLError";
                } else {
                    str = Integer.toString(sslError.getPrimaryError());
                }
                sb.append(str);
                com.mbridge.msdk.reward.c.a.a(campaignEx, g2, sb.toString(), this.i, this.d, this.e, this.l.getRequestIdNotice(), System.currentTimeMillis() - this.n);
            } catch (Exception unused) {
            }
            Handler handler = this.a;
            if (handler != null) {
                if (this.q != null) {
                    handler.removeCallbacks(this.r);
                }
                Runnable runnable = this.q;
                if (runnable != null) {
                    this.a.removeCallbacks(runnable);
                }
            }
            try {
                String str2 = this.i + "_" + this.h;
                a.C0158a aVar = this.k;
                if (aVar != null) {
                    aVar.a(false);
                }
                if (this.f != null) {
                    this.f.a(str2, this.j, this.i, this.e, this.h, this.k, new com.mbridge.msdk.foundation.entity.e(8, sslError == null ? "" : Integer.toString(sslError.getPrimaryError())));
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("WindVaneWebView", e2.getLocalizedMessage());
                }
            }
        }

        public final void a(WebView webView, String str) {
            Runnable runnable;
            Handler handler;
            Runnable runnable2;
            super.a(webView, str);
            Handler handler2 = this.a;
            if (!(handler2 == null || (runnable2 = this.r) == null)) {
                handler2.removeCallbacks(runnable2);
            }
            if (!this.o) {
                try {
                    com.mbridge.msdk.reward.c.a.a(this.l, com.mbridge.msdk.foundation.controller.b.d().g(), "preload temp onPageFinish", this.i, this.d, this.e, this.l.getRequestIdNotice(), System.currentTimeMillis() - this.n);
                } catch (Exception unused) {
                }
                if (!str.contains("wfr=1")) {
                    String str2 = this.i + "_" + this.h;
                    com.mbridge.msdk.videocommon.download.i.a().d(this.i + "_" + this.e + "_" + this.h, true);
                    Runnable runnable3 = this.b;
                    if (!(runnable3 == null || (handler = this.a) == null)) {
                        handler.removeCallbacks(runnable3);
                    }
                    a.C0158a aVar = this.k;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    if (this.c) {
                        if (this.l.isBidCampaign()) {
                            com.mbridge.msdk.videocommon.a.a(287, this.l.getRequestIdNotice(), this.k);
                        } else {
                            com.mbridge.msdk.videocommon.a.b(287, this.l.getRequestIdNotice(), this.k);
                        }
                    } else if (this.l.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(94, this.l.getRequestIdNotice(), this.k);
                    } else {
                        com.mbridge.msdk.videocommon.a.b(94, this.l.getRequestIdNotice(), this.k);
                    }
                    j jVar = this.f;
                    if (jVar != null) {
                        jVar.a(str2, this.j, this.i, this.e, this.h, this.k);
                    }
                } else {
                    Handler handler3 = this.a;
                    if (!(handler3 == null || (runnable = this.q) == null)) {
                        handler3.postDelayed(runnable, 5000);
                    }
                }
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView);
                this.o = true;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(17:9|10|11|12|(3:14|(1:16)|17)|18|(1:40)(3:22|(3:26|(5:29|(4:32|(2:36|71)|37|30)|70|38|27)|69)|39)|41|42|43|44|45|46|47|48|49|50) */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01f1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01f2, code lost:
        r6 = r14;
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r42.a(r21, r33, r34, r31, r35, (com.mbridge.msdk.videocommon.a.C0158a) null, new com.mbridge.msdk.foundation.entity.e(8, r0.getMessage()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0219, code lost:
        com.mbridge.msdk.foundation.tools.aa.d("RewardCampaignsResourceManager", r0.getLocalizedMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0046, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0065 */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x008b A[Catch:{ Exception -> 0x01f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c3 A[Catch:{ Exception -> 0x01f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0120 A[Catch:{ Exception -> 0x01f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01f6 A[SYNTHETIC, Splitter:B:59:0x01f6] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0219  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(boolean r27, android.os.Handler r28, boolean r29, boolean r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, int r36, com.mbridge.msdk.foundation.entity.CampaignEx r37, java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r38, java.lang.String r39, java.lang.String r40, com.mbridge.msdk.videocommon.d.c r41, com.mbridge.msdk.reward.adapter.b.j r42, boolean r43) {
        /*
            r26 = this;
            r1 = r26
            r15 = r31
            r14 = r34
            r0 = r37
            r13 = r38
            r12 = r43
            monitor-enter(r26)
            r1.c = r12     // Catch:{ all -> 0x0224 }
            long r19 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0224 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0224 }
            r2.<init>()     // Catch:{ all -> 0x0224 }
            r2.append(r14)     // Catch:{ all -> 0x0224 }
            java.lang.String r3 = "_"
            r2.append(r3)     // Catch:{ all -> 0x0224 }
            r11 = r35
            r2.append(r11)     // Catch:{ all -> 0x0224 }
            java.lang.String r21 = r2.toString()     // Catch:{ all -> 0x0224 }
            r1.c = r12     // Catch:{ all -> 0x0224 }
            boolean r2 = com.mbridge.msdk.foundation.tools.af.i((java.lang.String) r35)     // Catch:{ all -> 0x0224 }
            if (r2 == 0) goto L_0x0047
            if (r42 == 0) goto L_0x0045
            r0 = 0
            r36 = r42
            r37 = r21
            r38 = r33
            r39 = r34
            r40 = r31
            r41 = r35
            r42 = r0
            r36.a(r37, r38, r39, r40, r41, r42)     // Catch:{ all -> 0x0224 }
        L_0x0045:
            monitor-exit(r26)
            return
        L_0x0047:
            com.mbridge.msdk.foundation.controller.b r2 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0065 }
            android.content.Context r3 = r2.g()     // Catch:{ Exception -> 0x0065 }
            java.lang.String r4 = "start preload tpl"
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0065 }
            long r9 = r5 - r19
            r2 = r37
            r5 = r40
            r6 = r30
            r7 = r31
            r8 = r32
            com.mbridge.msdk.reward.c.a.a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0065 }
        L_0x0065:
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x01f1 }
            r2.<init>()     // Catch:{ Exception -> 0x01f1 }
            java.lang.String r3 = "type"
            java.lang.String r4 = "1"
            r2.put(r3, r4)     // Catch:{ Exception -> 0x01f1 }
            com.mbridge.msdk.foundation.same.report.m r3 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x01f1 }
            java.lang.String r4 = "2000154"
            r3.a((java.lang.String) r4, (com.mbridge.msdk.foundation.entity.CampaignEx) r0, (java.util.Map<java.lang.String, java.lang.String>) r2)     // Catch:{ Exception -> 0x01f1 }
            com.mbridge.msdk.videocommon.a$a r10 = new com.mbridge.msdk.videocommon.a$a     // Catch:{ Exception -> 0x01f1 }
            r10.<init>()     // Catch:{ Exception -> 0x01f1 }
            com.mbridge.msdk.reward.adapter.b r2 = com.mbridge.msdk.reward.adapter.b.m.a     // Catch:{ Exception -> 0x01f1 }
            r3 = 1
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r2 = r2.a((boolean) r3)     // Catch:{ Exception -> 0x01f1 }
            if (r2 != 0) goto L_0x00a4
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r2 = new com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView     // Catch:{ Exception -> 0x01f1 }
            com.mbridge.msdk.foundation.controller.b r4 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x01f1 }
            android.content.Context r4 = r4.g()     // Catch:{ Exception -> 0x01f1 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x01f1 }
            if (r0 == 0) goto L_0x00a1
            java.lang.String r4 = r37.getCurrentLRid()     // Catch:{ Exception -> 0x01f1 }
            r2.setLocalRequestId(r4)     // Catch:{ Exception -> 0x01f1 }
        L_0x00a1:
            r2.setTempTypeForMetrics(r3)     // Catch:{ Exception -> 0x01f1 }
        L_0x00a4:
            r9 = r2
            r10.a((com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView) r9)     // Catch:{ Exception -> 0x01f1 }
            com.mbridge.msdk.video.bt.a.c r2 = com.mbridge.msdk.video.bt.a.c.a()     // Catch:{ Exception -> 0x01f1 }
            java.lang.String r8 = r2.b()     // Catch:{ Exception -> 0x01f1 }
            com.mbridge.msdk.video.bt.a.c r2 = com.mbridge.msdk.video.bt.a.c.a()     // Catch:{ Exception -> 0x01f1 }
            java.lang.String r7 = r2.b()     // Catch:{ Exception -> 0x01f1 }
            r10.a((java.lang.String) r7)     // Catch:{ Exception -> 0x01f1 }
            if (r13 == 0) goto L_0x0120
            int r4 = r38.size()     // Catch:{ Exception -> 0x01f1 }
            if (r4 <= 0) goto L_0x0120
            com.mbridge.msdk.videocommon.download.c r4 = com.mbridge.msdk.videocommon.download.c.getInstance()     // Catch:{ Exception -> 0x01f1 }
            java.util.concurrent.CopyOnWriteArrayList r4 = r4.a((java.lang.String) r14)     // Catch:{ Exception -> 0x01f1 }
            if (r4 == 0) goto L_0x0119
            int r5 = r4.size()     // Catch:{ Exception -> 0x01f1 }
            if (r5 <= 0) goto L_0x0119
            r5 = 0
        L_0x00d4:
            int r6 = r38.size()     // Catch:{ Exception -> 0x01f1 }
            if (r5 >= r6) goto L_0x0119
            java.lang.Object r6 = r13.get(r5)     // Catch:{ Exception -> 0x01f1 }
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = (com.mbridge.msdk.foundation.entity.CampaignEx) r6     // Catch:{ Exception -> 0x01f1 }
            java.util.Iterator r16 = r4.iterator()     // Catch:{ Exception -> 0x01f1 }
        L_0x00e4:
            boolean r17 = r16.hasNext()     // Catch:{ Exception -> 0x01f1 }
            if (r17 == 0) goto L_0x0115
            java.lang.Object r17 = r16.next()     // Catch:{ Exception -> 0x01f1 }
            com.mbridge.msdk.foundation.entity.CampaignEx r17 = (com.mbridge.msdk.foundation.entity.CampaignEx) r17     // Catch:{ Exception -> 0x01f1 }
            java.lang.String r2 = r17.getId()     // Catch:{ Exception -> 0x01f1 }
            java.lang.String r3 = r6.getId()     // Catch:{ Exception -> 0x01f1 }
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x01f1 }
            if (r2 == 0) goto L_0x0113
            java.lang.String r2 = r17.getRequestId()     // Catch:{ Exception -> 0x01f1 }
            java.lang.String r3 = r6.getRequestId()     // Catch:{ Exception -> 0x01f1 }
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x01f1 }
            if (r2 == 0) goto L_0x0113
            r2 = 1
            r6.setReady(r2)     // Catch:{ Exception -> 0x01f1 }
            r13.set(r5, r6)     // Catch:{ Exception -> 0x01f1 }
        L_0x0113:
            r3 = 1
            goto L_0x00e4
        L_0x0115:
            int r5 = r5 + 1
            r3 = 1
            goto L_0x00d4
        L_0x0119:
            com.mbridge.msdk.video.signal.a.j r2 = new com.mbridge.msdk.video.signal.a.j     // Catch:{ Exception -> 0x01f1 }
            r3 = 0
            r2.<init>(r3, r0, r13)     // Catch:{ Exception -> 0x01f1 }
            goto L_0x0126
        L_0x0120:
            com.mbridge.msdk.video.signal.a.j r2 = new com.mbridge.msdk.video.signal.a.j     // Catch:{ Exception -> 0x01f1 }
            r3 = 0
            r2.<init>(r3, r0)     // Catch:{ Exception -> 0x01f1 }
        L_0x0126:
            r4 = r36
            r6 = r2
            r6.a((int) r4)     // Catch:{ Exception -> 0x01f1 }
            r2 = r40
            r6.a((java.lang.String) r2)     // Catch:{ Exception -> 0x01f1 }
            r6.c((java.lang.String) r7)     // Catch:{ Exception -> 0x01f1 }
            r6.d((java.lang.String) r8)     // Catch:{ Exception -> 0x01f1 }
            r2 = 1
            r6.c((boolean) r2)     // Catch:{ Exception -> 0x01f1 }
            r3 = r41
            r6.a((com.mbridge.msdk.videocommon.d.c) r3)     // Catch:{ Exception -> 0x01f1 }
            r2 = r27
            r6.d((boolean) r2)     // Catch:{ Exception -> 0x01f1 }
            com.mbridge.msdk.reward.adapter.b$b r5 = new com.mbridge.msdk.reward.adapter.b$b     // Catch:{ Exception -> 0x01f1 }
            r16 = 0
            r32 = r5
            r5 = r16
            r2 = r32
            r3 = r27
            r4 = r28
            r22 = r6
            r6 = r29
            r23 = r7
            r7 = r30
            r24 = r8
            r8 = r36
            r25 = r9
            r9 = r35
            r16 = r10
            r10 = r33
            r11 = r34
            r12 = r31
            r13 = r16
            r14 = r37
            r15 = r38
            r16 = r41
            r17 = r42
            r18 = r43
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x01eb }
            r0 = r32
            r2 = r25
            r2.setWebViewListener(r0)     // Catch:{ Exception -> 0x01eb }
            r0 = r22
            r2.setObject(r0)     // Catch:{ Exception -> 0x01eb }
            r0 = r39
            r2.loadUrl(r0)     // Catch:{ Exception -> 0x01eb }
            r3 = r31
            r2.setRid(r3)     // Catch:{ Exception -> 0x01e9 }
            com.mbridge.msdk.video.bt.module.MBridgeBTRootLayout r0 = new com.mbridge.msdk.video.bt.module.MBridgeBTRootLayout     // Catch:{ Exception -> 0x01e9 }
            com.mbridge.msdk.foundation.controller.b r4 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x01e9 }
            android.content.Context r4 = r4.g()     // Catch:{ Exception -> 0x01e9 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x01e9 }
            android.widget.FrameLayout$LayoutParams r4 = new android.widget.FrameLayout$LayoutParams     // Catch:{ Exception -> 0x01e9 }
            r5 = -1
            r4.<init>(r5, r5)     // Catch:{ Exception -> 0x01e9 }
            r0.setLayoutParams(r4)     // Catch:{ Exception -> 0x01e9 }
            r4 = r24
            r0.setInstanceId(r4)     // Catch:{ Exception -> 0x01e9 }
            r6 = r34
            r0.setUnitId(r6)     // Catch:{ Exception -> 0x01e7 }
            com.mbridge.msdk.video.bt.module.MBridgeBTLayout r7 = new com.mbridge.msdk.video.bt.module.MBridgeBTLayout     // Catch:{ Exception -> 0x01e7 }
            com.mbridge.msdk.foundation.controller.b r8 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x01e7 }
            android.content.Context r8 = r8.g()     // Catch:{ Exception -> 0x01e7 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x01e7 }
            android.widget.FrameLayout$LayoutParams r8 = new android.widget.FrameLayout$LayoutParams     // Catch:{ Exception -> 0x01e7 }
            r8.<init>(r5, r5)     // Catch:{ Exception -> 0x01e7 }
            r7.setLayoutParams(r8)     // Catch:{ Exception -> 0x01e7 }
            r8 = r23
            r7.setInstanceId(r8)     // Catch:{ Exception -> 0x01e7 }
            r7.setUnitId(r6)     // Catch:{ Exception -> 0x01e7 }
            r7.setWebView(r2)     // Catch:{ Exception -> 0x01e7 }
            com.mbridge.msdk.video.bt.a.c r2 = com.mbridge.msdk.video.bt.a.c.a()     // Catch:{ Exception -> 0x01e7 }
            java.util.LinkedHashMap r2 = r2.b((java.lang.String) r6, (java.lang.String) r3)     // Catch:{ Exception -> 0x01e7 }
            r2.put(r8, r7)     // Catch:{ Exception -> 0x01e7 }
            r2.put(r4, r0)     // Catch:{ Exception -> 0x01e7 }
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams     // Catch:{ Exception -> 0x01e7 }
            r2.<init>(r5, r5)     // Catch:{ Exception -> 0x01e7 }
            r0.addView(r7, r2)     // Catch:{ Exception -> 0x01e7 }
            goto L_0x0222
        L_0x01e7:
            r0 = move-exception
            goto L_0x01f4
        L_0x01e9:
            r0 = move-exception
            goto L_0x01ee
        L_0x01eb:
            r0 = move-exception
            r3 = r31
        L_0x01ee:
            r6 = r34
            goto L_0x01f4
        L_0x01f1:
            r0 = move-exception
            r6 = r14
            r3 = r15
        L_0x01f4:
            if (r42 == 0) goto L_0x0215
            com.mbridge.msdk.foundation.entity.e r2 = new com.mbridge.msdk.foundation.entity.e     // Catch:{ all -> 0x0224 }
            java.lang.String r4 = r0.getMessage()     // Catch:{ all -> 0x0224 }
            r5 = 8
            r2.<init>(r5, r4)     // Catch:{ all -> 0x0224 }
            r4 = 0
            r36 = r42
            r37 = r21
            r38 = r33
            r39 = r34
            r40 = r31
            r41 = r35
            r42 = r4
            r43 = r2
            r36.a(r37, r38, r39, r40, r41, r42, r43)     // Catch:{ all -> 0x0224 }
        L_0x0215:
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0224 }
            if (r2 == 0) goto L_0x0222
            java.lang.String r2 = "RewardCampaignsResourceManager"
            java.lang.String r0 = r0.getLocalizedMessage()     // Catch:{ all -> 0x0224 }
            com.mbridge.msdk.foundation.tools.aa.d(r2, r0)     // Catch:{ all -> 0x0224 }
        L_0x0222:
            monitor-exit(r26)
            return
        L_0x0224:
            r0 = move-exception
            monitor-exit(r26)
            goto L_0x0228
        L_0x0227:
            throw r0
        L_0x0228:
            goto L_0x0227
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.b.a(boolean, android.os.Handler, boolean, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, com.mbridge.msdk.foundation.entity.CampaignEx, java.util.concurrent.CopyOnWriteArrayList, java.lang.String, java.lang.String, com.mbridge.msdk.videocommon.d.c, com.mbridge.msdk.reward.adapter.b$j, boolean):void");
    }

    /* renamed from: com.mbridge.msdk.reward.adapter.b$b  reason: collision with other inner class name */
    /* compiled from: RewardCampaignsResourceManager */
    private static class C0150b extends com.mbridge.msdk.mbsignalcommon.b.a {
        private final Handler a;
        private final Runnable b;
        private final boolean c;
        private final boolean d;
        private int e;
        private String f;
        private String g;
        private String h;
        private String i;
        private a.C0158a j;
        private CampaignEx k;
        private CopyOnWriteArrayList<CampaignEx> l;
        private com.mbridge.msdk.videocommon.d.c m;
        private final j n;
        private boolean o;
        private boolean p;
        private boolean q;
        private int r = 0;
        private boolean s;
        private long t;

        public C0150b(boolean z, Handler handler, Runnable runnable, boolean z2, boolean z3, int i2, String str, String str2, String str3, String str4, a.C0158a aVar, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.videocommon.d.c cVar, j jVar, boolean z4, long j2) {
            this.a = handler;
            this.b = runnable;
            this.c = z2;
            this.d = z3;
            this.e = i2;
            this.f = str;
            this.h = str2;
            this.g = str3;
            this.i = str4;
            this.j = aVar;
            this.k = campaignEx;
            this.l = copyOnWriteArrayList;
            this.m = cVar;
            this.n = jVar;
            this.o = z4;
            this.s = z;
            this.t = j2;
        }

        public final void a(WebView webView, int i2) {
            Runnable runnable;
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(IronSourceConstants.EVENTS_RESULT, i2 + "");
                hashMap.put("type", "1");
                com.mbridge.msdk.foundation.same.report.m.a().a("2000155", this.k, (Map<String, String>) hashMap);
            } catch (Throwable th) {
                aa.d("RVWindVaneWebView", th.getMessage());
            }
            if (!this.q) {
                try {
                    com.mbridge.msdk.reward.c.a.a(this.k, com.mbridge.msdk.foundation.controller.b.d().g(), "preload tpl readyState: " + i2, this.g, this.d, this.i, this.k.getRequestIdNotice(), System.currentTimeMillis() - this.t);
                } catch (Exception unused) {
                }
                String str = this.g + "_" + this.f;
                if (i2 == 1) {
                    if (this.o) {
                        com.mbridge.msdk.videocommon.a.e(this.g + "_" + this.i);
                    } else {
                        com.mbridge.msdk.videocommon.a.d(this.g + "_" + this.i);
                    }
                    com.mbridge.msdk.videocommon.a.a(this.g + "_" + this.i + "_" + this.f, this.j, true, this.o);
                    Handler handler = this.a;
                    if (!(handler == null || (runnable = this.b) == null)) {
                        handler.removeCallbacks(runnable);
                    }
                    com.mbridge.msdk.videocommon.download.i.a().d(this.g + "_" + this.i + "_" + this.f, true);
                    a.C0158a aVar = this.j;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    j jVar = this.n;
                    if (jVar != null) {
                        jVar.a(str, this.h, this.g, this.i, this.f, this.j);
                    }
                } else {
                    com.mbridge.msdk.videocommon.download.i.a().d(this.g + "_" + this.i + "_" + this.f, false);
                    a.C0158a aVar2 = this.j;
                    if (aVar2 != null) {
                        aVar2.a(false);
                    }
                    if (this.n != null) {
                        this.n.a(str, this.h, this.g, this.i, this.f, this.j, new com.mbridge.msdk.foundation.entity.e(8, "state 2"));
                    }
                }
                this.q = true;
            }
        }

        public final void a(WebView webView, String str, String str2, int i2, int i3) {
            boolean z = true;
            if (i2 == 1) {
                try {
                    com.mbridge.msdk.reward.b.a aVar = new com.mbridge.msdk.reward.b.a();
                    aVar.b(false);
                    if (i3 != 2) {
                        z = false;
                    }
                    aVar.a(z);
                    aVar.b(str, str2);
                    aVar.a((InterVideoOutListener) new com.mbridge.msdk.video.bt.module.b.a((com.mbridge.msdk.video.bt.module.b.g) null));
                    aVar.a(false, (Map<String, String>) new HashMap());
                } catch (Exception unused) {
                }
            }
        }

        public final void a(Object obj, String str) {
            Object obj2 = obj;
            if (obj2 != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        String optString = new JSONObject(str).optString("id");
                        com.mbridge.msdk.video.bt.a.c.a().a(obj2, optString);
                        String c2 = com.mbridge.msdk.video.bt.a.c.a().c(optString);
                        CampaignEx a2 = com.mbridge.msdk.video.bt.a.c.a().a(optString);
                        com.mbridge.msdk.videocommon.d.c b2 = com.mbridge.msdk.video.bt.a.c.a().b(optString);
                        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                        copyOnWriteArrayList.add(a2);
                        com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj2;
                        if (aVar.a instanceof WindVaneWebView) {
                            WindVaneWebView windVaneWebView = aVar.a;
                            b a3 = m.a;
                            boolean z = this.s;
                            int i2 = this.r == 0 ? 3 : 6;
                            if (windVaneWebView != null) {
                                if (!(a2 == null || b2 == null)) {
                                    try {
                                        if (a2.getRewardTemplateMode() != null) {
                                            if (!TextUtils.isEmpty(c2)) {
                                                if (TextUtils.isEmpty(a2.getRewardTemplateMode().e())) {
                                                    JSONObject jSONObject = new JSONObject();
                                                    jSONObject.put("id", optString);
                                                    JSONObject jSONObject2 = new JSONObject();
                                                    jSONObject2.put(IronSourceConstants.EVENTS_RESULT, 1);
                                                    jSONObject2.put("error", "data is null");
                                                    jSONObject.put("data", jSONObject2);
                                                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                                                } else if (TextUtils.isEmpty(a2.getRewardTemplateMode().e()) || !a2.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY)) {
                                                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable(z, windVaneWebView, a2, copyOnWriteArrayList, c2, b2, optString) {
                                                        final /* synthetic */ boolean a;
                                                        final /* synthetic */ WindVaneWebView b;
                                                        final /* synthetic */ CampaignEx c;
                                                        final /* synthetic */ CopyOnWriteArrayList d;
                                                        final /* synthetic */ String e;
                                                        final /* synthetic */ com.mbridge.msdk.videocommon.d.c f;
                                                        final /* synthetic */ String g;

                                                        {
                                                            this.a = r2;
                                                            this.b = r3;
                                                            this.c = r4;
                                                            this.d = r5;
                                                            this.e = r6;
                                                            this.f = r7;
                                                            this.g = r8;
                                                        }

                                                        public final void run() {
                                                            b.a(b.this, this.a, this.b, this.c.getRewardTemplateMode().e(), 0, this.c, this.d, com.mbridge.msdk.videocommon.download.g.a().b(this.c.getRewardTemplateMode().e()), this.e, this.f, this.g, b.this.c);
                                                        }
                                                    }, (long) (i2 * 1000));
                                                } else {
                                                    aa.a("RewardCampaignsResourceManager", "getTeamplateUrl contains cmpt=1");
                                                }
                                            }
                                        }
                                    } catch (Exception e2) {
                                        if (MBridgeConstans.DEBUG) {
                                            aa.d("RewardCampaignsResourceManager", e2.getLocalizedMessage());
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        aa.d("RVWindVaneWebView", th.getMessage());
                                        return;
                                    }
                                }
                                JSONObject jSONObject3 = new JSONObject();
                                try {
                                    jSONObject3.put("id", optString);
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put(IronSourceConstants.EVENTS_RESULT, 2);
                                    jSONObject4.put("error", "data is null");
                                    jSONObject3.put("data", jSONObject4);
                                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
                                } catch (Exception e3) {
                                    if (MBridgeConstans.DEBUG) {
                                        aa.d("RewardCampaignsResourceManager", e3.getLocalizedMessage());
                                    }
                                }
                            }
                            this.r++;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }

        public final void a(WebView webView, String str) {
            Runnable runnable;
            super.a(webView, str);
            if (!this.p) {
                try {
                    com.mbridge.msdk.reward.c.a.a(this.k, com.mbridge.msdk.foundation.controller.b.d().g(), "preload tpl onPageFinish", this.g, this.d, this.i, this.k.getRequestIdNotice(), System.currentTimeMillis() - this.t);
                } catch (Exception unused) {
                }
                String str2 = this.g + "_" + this.f;
                if (!str.contains("wfr=1")) {
                    com.mbridge.msdk.videocommon.download.i.a().d(this.g + "_" + this.i + "_" + this.f, true);
                    Handler handler = this.a;
                    if (!(handler == null || (runnable = this.b) == null)) {
                        handler.removeCallbacks(runnable);
                    }
                    a.C0158a aVar = this.j;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    j jVar = this.n;
                    if (jVar != null) {
                        jVar.a(str2, this.h, this.g, this.i, this.f, this.j);
                    }
                }
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView);
                this.p = true;
            }
        }

        public final void a(WebView webView, int i2, String str, String str2) {
            super.a(webView, i2, str, str2);
            com.mbridge.msdk.videocommon.download.i.a().d(this.g + "_" + this.i + "_" + this.f, false);
            if (this.n != null) {
                String str3 = this.g + "_" + this.f;
                a.C0158a aVar = this.j;
                if (aVar != null) {
                    aVar.a(false);
                }
                this.n.a(str3, this.h, this.g, this.i, this.f, this.j, new com.mbridge.msdk.foundation.entity.e(8, str));
            }
        }

        public final void a(WebView webView) {
            if (webView != null) {
                try {
                    LinkedHashMap<String, View> b2 = com.mbridge.msdk.video.bt.a.c.a().b(this.g, this.i);
                    if (b2 == null) {
                        return;
                    }
                    if (!b2.isEmpty()) {
                        for (View next : b2.values()) {
                            if (next instanceof MBridgeBTContainer) {
                                ((MBridgeBTContainer) next).addNativeCloseButtonWhenWebViewCrash();
                            }
                        }
                    }
                } catch (Throwable th) {
                    aa.d("RVWindVaneWebView", th.getMessage());
                }
            }
        }
    }

    /* compiled from: RewardCampaignsResourceManager */
    private static class l extends com.mbridge.msdk.mbsignalcommon.b.b {
        private String a;
        private final boolean b;
        private final WindVaneWebView c;
        private final String d;
        private final String e;
        private final a.C0158a f;
        private final CampaignEx g;
        private boolean h;
        private String i;
        private boolean j;
        private boolean k;

        public l(String str, boolean z, WindVaneWebView windVaneWebView, String str2, String str3, a.C0158a aVar, CampaignEx campaignEx, boolean z2, String str4) {
            this.b = z;
            this.c = windVaneWebView;
            this.d = str2;
            this.e = str3;
            this.f = aVar;
            this.g = campaignEx;
            this.a = str;
            this.h = z2;
            this.i = str4;
        }

        public final void a(WebView webView, int i2) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(IronSourceConstants.EVENTS_RESULT, i2 + "");
                hashMap.put("type", "2");
                com.mbridge.msdk.foundation.same.report.m.a().a("2000155", this.g, (Map<String, String>) hashMap);
            } catch (Throwable th) {
                aa.d("WindVaneWebView", th.getMessage());
            }
            if (!this.k) {
                if (this.c != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", this.a);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(IronSourceConstants.EVENTS_RESULT, i2);
                        jSONObject2.put("error", "");
                        jSONObject.put("data", jSONObject2);
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            aa.d("WindVaneWebView", e2.getLocalizedMessage());
                        }
                    }
                }
                String str = this.e + "_" + this.g.getId() + "_" + this.g.getRequestId() + "_" + this.d;
                if (i2 == 1) {
                    com.mbridge.msdk.videocommon.download.i.a().d(this.e + "_" + this.i + "_" + this.d, true);
                    a.C0158a aVar = this.f;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    if (this.b) {
                        if (this.g.isBidCampaign()) {
                            com.mbridge.msdk.videocommon.a.a(str, this.f, false, this.h);
                        } else {
                            com.mbridge.msdk.videocommon.a.a(str, this.f, false, this.h);
                        }
                    } else if (this.g.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(str, this.f, false, this.h);
                    } else {
                        com.mbridge.msdk.videocommon.a.a(str, this.f, false, this.h);
                    }
                } else {
                    com.mbridge.msdk.videocommon.download.i.a().d(this.e + "_" + this.i + "_" + this.d, false);
                    a.C0158a aVar2 = this.f;
                    if (aVar2 != null) {
                        aVar2.a(false);
                    }
                }
                this.k = true;
            }
        }

        public final void a(WebView webView, int i2, String str, String str2) {
            com.mbridge.msdk.videocommon.download.i a2 = com.mbridge.msdk.videocommon.download.i.a();
            a2.d(this.e + "_" + this.i + "_" + this.d, false);
            a.C0158a aVar = this.f;
            if (aVar != null) {
                aVar.a(false);
            }
            if (this.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.a);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(IronSourceConstants.EVENTS_RESULT, 2);
                    jSONObject2.put("error", str);
                    jSONObject.put("data", jSONObject2);
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        aa.d("WindVaneWebView", e2.getLocalizedMessage());
                    }
                }
            }
        }

        public final void a(WebView webView, String str) {
            if (!this.j) {
                if (!str.contains("wfr=1")) {
                    if (this.c != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", this.a);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(IronSourceConstants.EVENTS_RESULT, 1);
                            jSONObject2.put("error", "");
                            jSONObject.put("data", jSONObject2);
                            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.c, "componentReact", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        } catch (Exception e2) {
                            if (MBridgeConstans.DEBUG) {
                                aa.d("WindVaneWebView", e2.getLocalizedMessage());
                            }
                        }
                    }
                    com.mbridge.msdk.videocommon.download.i.a().d(this.e + "_" + this.i + "_" + this.d, true);
                    a.C0158a aVar = this.f;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    String str2 = this.e + "_" + this.g.getId() + "_" + this.g.getRequestId() + "_" + this.d;
                    if (this.b) {
                        if (this.g.isBidCampaign()) {
                            com.mbridge.msdk.videocommon.a.a(287, this.g.getRequestIdNotice(), this.f);
                        } else {
                            com.mbridge.msdk.videocommon.a.a(str2, this.f, false, this.h);
                        }
                    } else if (this.g.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(94, this.g.getRequestIdNotice(), this.f);
                    } else {
                        com.mbridge.msdk.videocommon.a.a(str2, this.f, false, this.h);
                    }
                }
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView);
                this.j = true;
            }
        }
    }

    /* compiled from: RewardCampaignsResourceManager */
    private static class a {
        boolean a;
        boolean b;
        int c;
        int d;
        String e;
        String f;
        int g;
        CopyOnWriteArrayList<CampaignEx> h;
        CopyOnWriteArrayList<CampaignEx> i;

        public a(boolean z, boolean z2, int i2, int i3, String str, String str2, int i4, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.a = z;
            this.b = z2;
            this.c = i2;
            this.d = i3;
            this.e = str;
            this.f = str2;
            this.g = i4;
            this.h = copyOnWriteArrayList;
            this.i = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
        }
    }

    private synchronized WindVaneWebView a(boolean z) {
        return null;
    }

    /* access modifiers changed from: private */
    public int a(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 0;
        }
        try {
            if (campaignEx.getAabEntity() != null) {
                return campaignEx.getAabEntity().h3c;
            }
            return 0;
        } catch (Throwable th) {
            aa.d("RewardCampaignsResourceManager", th.getMessage());
            return 0;
        }
    }

    static /* synthetic */ void a(b bVar, Context context, String str, String str2, String str3, CampaignEx campaignEx, String str4, i iVar, CopyOnWriteArrayList copyOnWriteArrayList) {
        b bVar2 = bVar;
        String str5 = str4;
        if (!TextUtils.isEmpty(str4) && !campaignEx.isMraid()) {
            HashMap hashMap = new HashMap();
            try {
                hashMap.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, campaignEx.getCurrentLRid());
                hashMap.put("down_type", ExifInterface.GPS_MEASUREMENT_3D);
                try {
                    hashMap.put("h3c", String.valueOf(bVar2.a(campaignEx)));
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                CampaignEx campaignEx2 = campaignEx;
            }
            if (!str5.contains(".zip") || !str5.contains("md5filename")) {
                boolean isEmpty = TextUtils.isEmpty(com.mbridge.msdk.videocommon.download.h.a().b(str5));
                try {
                    d dVar = new d(497, str, str2, str3, campaignEx, iVar, bVar2.a, copyOnWriteArrayList);
                    dVar.a(isEmpty);
                    com.mbridge.msdk.videocommon.download.g.a().a(hashMap, str5, dVar);
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        aa.d("RewardCampaignsResourceManager", e2.getLocalizedMessage());
                    }
                }
            } else {
                boolean isEmpty2 = TextUtils.isEmpty(com.mbridge.msdk.videocommon.download.g.a().b(str5));
                try {
                    g gVar = new g(context, str, str2, str3, campaignEx, 497, bVar2.a, iVar, copyOnWriteArrayList);
                    gVar.a(isEmpty2);
                    com.mbridge.msdk.videocommon.download.g.a().a(hashMap, str5, gVar);
                } catch (Exception e3) {
                    if (MBridgeConstans.DEBUG) {
                        aa.d("RewardCampaignsResourceManager", e3.getLocalizedMessage());
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(n nVar, CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.videocommon.d.c a2 = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), campaignEx.getCampaignUnitId());
            if (a2 != null) {
                nVar.l(a2.l());
            }
            com.mbridge.msdk.videocommon.d.a b2 = com.mbridge.msdk.videocommon.d.b.a().b();
            if (b2 != null) {
                nVar.k(b2.c());
            }
        } catch (Exception e2) {
            aa.d("RewardCampaignsResourceManager", e2.getMessage());
        }
    }

    static /* synthetic */ void a(b bVar, Context context, int i2, CampaignEx campaignEx, String str, String str2, String str3, String str4) {
        final CampaignEx campaignEx2 = campaignEx;
        final Context context2 = context;
        final int i3 = i2;
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() {
            public final void run() {
                if (campaignEx2 != null && context2 != null) {
                    try {
                        n nVar = new n();
                        nVar.s("2000045");
                        Context context = context2;
                        if (context != null) {
                            nVar.d(w.r(context.getApplicationContext()));
                        }
                        nVar.e(i3);
                        CampaignEx campaignEx = campaignEx2;
                        if (campaignEx != null) {
                            nVar.r(campaignEx.getId());
                            nVar.n(campaignEx2.getRequestId());
                            nVar.o(campaignEx2.getCurrentLRid());
                            nVar.p(campaignEx2.getRequestIdNotice());
                        }
                        nVar.i(str5);
                        nVar.t(str6);
                        nVar.q(str7);
                        if (!TextUtils.isEmpty(str8)) {
                            nVar.m(str8);
                        }
                        if (ac.a().a("r_l_b_m_t_r_i", true)) {
                            nVar.a(1);
                            b.a(nVar, campaignEx2);
                            com.mbridge.msdk.foundation.same.report.m.a().a(nVar, campaignEx2);
                            return;
                        }
                        q.a((com.mbridge.msdk.foundation.db.g) com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g())).a(nVar);
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            aa.d("RewardCampaignsResourceManager", e2.getLocalizedMessage());
                        }
                    }
                }
            }
        });
    }

    static /* synthetic */ void a(b bVar, boolean z, WindVaneWebView windVaneWebView, String str, int i2, CampaignEx campaignEx, CopyOnWriteArrayList copyOnWriteArrayList, String str2, String str3, com.mbridge.msdk.videocommon.d.c cVar, String str4, boolean z2) {
        com.mbridge.msdk.video.signal.a.j jVar;
        String str5;
        CampaignEx campaignEx2 = campaignEx;
        CopyOnWriteArrayList copyOnWriteArrayList2 = copyOnWriteArrayList;
        String str6 = str3;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "2");
            com.mbridge.msdk.foundation.same.report.m.a().a(campaignEx2);
            com.mbridge.msdk.foundation.same.report.m.a().a("2000154", campaignEx2, (Map<String, String>) hashMap);
            a.C0158a aVar = new a.C0158a();
            WindVaneWebView a2 = m.a.a(false);
            if (a2 == null) {
                a2 = new WindVaneWebView(com.mbridge.msdk.foundation.controller.b.d().g());
                if (campaignEx2 != null) {
                    a2.setLocalRequestId(campaignEx.getCurrentLRid());
                    a2.setTempTypeForMetrics(2);
                }
            }
            WindVaneWebView windVaneWebView2 = a2;
            aVar.a(windVaneWebView2);
            if (copyOnWriteArrayList2 == null || copyOnWriteArrayList.size() <= 0) {
                jVar = new com.mbridge.msdk.video.signal.a.j((Activity) null, campaignEx2);
                str5 = campaignEx.getRequestId();
            } else {
                CopyOnWriteArrayList<CampaignEx> a3 = com.mbridge.msdk.videocommon.download.c.getInstance().a(str6);
                if (a3 != null && a3.size() > 0) {
                    for (int i3 = 0; i3 < copyOnWriteArrayList.size(); i3++) {
                        CampaignEx campaignEx3 = (CampaignEx) copyOnWriteArrayList2.get(i3);
                        for (CampaignEx next : a3) {
                            if (next.getId().equals(campaignEx3.getId()) && next.getRequestId().equals(campaignEx3.getRequestId())) {
                                campaignEx3.setReady(true);
                                copyOnWriteArrayList2.set(i3, campaignEx3);
                            }
                        }
                    }
                }
                jVar = new com.mbridge.msdk.video.signal.a.j((Activity) null, campaignEx2, copyOnWriteArrayList2);
                str5 = ((CampaignEx) copyOnWriteArrayList2.get(0)).getRequestId();
            }
            String str7 = str5;
            com.mbridge.msdk.video.signal.a.j jVar2 = jVar;
            jVar2.a(i2);
            jVar2.a(str6);
            jVar2.c(str4);
            jVar2.a(cVar);
            jVar2.d(z);
            windVaneWebView2.setWebViewListener(new l(str4, false, windVaneWebView, str, str3, aVar, campaignEx, z2, str7));
            windVaneWebView2.setObject(jVar2);
            windVaneWebView2.loadUrl(str2);
            windVaneWebView2.setRid(str7);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                aa.d("RewardCampaignsResourceManager", e2.getLocalizedMessage());
            }
        }
    }
}
