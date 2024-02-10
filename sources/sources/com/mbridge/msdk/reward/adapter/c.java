package com.mbridge.msdk.reward.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebView;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.reward.adapter.b;
import com.mbridge.msdk.reward.player.MBRewardVideoActivity;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.download.i;
import com.mbridge.msdk.videocommon.download.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RewardMVVideoAdapter */
public final class c {
    private String A = "";
    private int B;
    private int C;
    private int D;
    /* access modifiers changed from: private */
    public CampaignUnit E;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<CampaignEx> F;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<CampaignEx> G;
    /* access modifiers changed from: private */
    public boolean H = false;
    /* access modifiers changed from: private */
    public long I = 0;
    private String J;
    /* access modifiers changed from: private */
    public d K;
    /* access modifiers changed from: private */
    public boolean L = false;
    /* access modifiers changed from: private */
    public boolean M = false;
    /* access modifiers changed from: private */
    public Handler N = new Handler(Looper.getMainLooper()) {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v26, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v5, resolved type: java.util.Map} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v28, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: java.util.Map} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v110, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v5, resolved type: com.mbridge.msdk.foundation.entity.CampaignEx} */
        /* JADX WARNING: type inference failed for: r3v10 */
        /* JADX WARNING: type inference failed for: r3v11 */
        /* JADX WARNING: type inference failed for: r3v12 */
        /* JADX WARNING: type inference failed for: r3v14 */
        /* JADX WARNING: type inference failed for: r3v16 */
        /* JADX WARNING: type inference failed for: r2v17 */
        /* JADX WARNING: Code restructure failed: missing block: B:200:0x0530, code lost:
            if (r8 == -1) goto L_0x0532;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:202:0x0533, code lost:
            if (r8 == -1) goto L_0x0535;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:213:0x05ad, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:214:0x05ae, code lost:
            r2 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:217:0x05b5, code lost:
            if (com.mbridge.msdk.reward.adapter.c.g(r1.a) != null) goto L_0x05b7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:218:0x05b7, code lost:
            com.mbridge.msdk.reward.adapter.c.g(r1.a).removeMessages(5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:219:0x05c0, code lost:
            removeMessages(6);
            r3 = r1.a;
            com.mbridge.msdk.reward.adapter.c.a(r3, com.mbridge.msdk.reward.adapter.c.d(r3), com.mbridge.msdk.reward.adapter.c.b(r1.a), com.mbridge.msdk.reward.adapter.c.f(r1.a));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:220:0x05dc, code lost:
            if (r1.a.j == false) goto L_0x05de;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:221:0x05de, code lost:
            r1.a.j = true;
            r3 = new com.mbridge.msdk.foundation.entity.e(1, "errorCode: 3508 errorMessage: data load failed, exception is " + r2.getMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:222:0x05f7, code lost:
            if (r16 != null) goto L_0x05f9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:223:0x05f9, code lost:
            com.mbridge.msdk.reward.c.a.a(r16, com.mbridge.msdk.reward.adapter.c.i(r1.a), r3, com.mbridge.msdk.reward.adapter.c.d(r1.a), com.mbridge.msdk.reward.adapter.c.f(r1.a), r16.getRequestId(), r16.getRequestIdNotice());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:224:0x061b, code lost:
            com.mbridge.msdk.reward.c.a.a(r16, com.mbridge.msdk.reward.adapter.c.i(r1.a), r3, com.mbridge.msdk.reward.adapter.c.d(r1.a), com.mbridge.msdk.reward.adapter.c.f(r1.a), "", "");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:225:0x0638, code lost:
            com.mbridge.msdk.reward.adapter.c.a(r1.a).a(com.mbridge.msdk.reward.adapter.c.b(r1.a), r3.e());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:246:0x06c2, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:247:0x06c3, code lost:
            r2 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:249:?, code lost:
            com.mbridge.msdk.foundation.tools.aa.a("RewardMVVideoAdapter", r2.getLocalizedMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:250:0x06cd, code lost:
            if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x06cf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:251:0x06cf, code lost:
            r2.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:264:0x0738, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:265:0x0739, code lost:
            r2 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:267:?, code lost:
            com.mbridge.msdk.foundation.tools.aa.a("RewardMVVideoAdapter", r2.getLocalizedMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:268:0x0743, code lost:
            if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x0745;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:269:0x0745, code lost:
            r2.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:277:0x0778, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:278:0x0779, code lost:
            com.mbridge.msdk.foundation.tools.aa.a("RewardMVVideoAdapter", r0.getMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:279:0x0782, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:280:0x0783, code lost:
            r0.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:294:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:307:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:308:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:313:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:317:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:318:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:322:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:327:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x01d1 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x02df A[SYNTHETIC, Splitter:B:111:0x02df] */
        /* JADX WARNING: Removed duplicated region for block: B:130:0x038a A[SYNTHETIC, Splitter:B:130:0x038a] */
        /* JADX WARNING: Removed duplicated region for block: B:277:0x0778 A[ExcHandler: all (r0v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x000c] */
        /* JADX WARNING: Removed duplicated region for block: B:283:0x0203 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:304:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x01f8 A[Catch:{ Exception -> 0x0782, all -> 0x0778 }] */
        /* JADX WARNING: Removed duplicated region for block: B:97:0x0279 A[SYNTHETIC, Splitter:B:97:0x0279] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:71:0x01d1=Splitter:B:71:0x01d1, B:160:0x0492=Splitter:B:160:0x0492, B:252:0x06d4=Splitter:B:252:0x06d4} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r28) {
            /*
                r27 = this;
                r1 = r27
                r2 = r28
                java.lang.String r3 = "_"
                java.lang.String r4 = "RewardMVVideoAdapter"
                java.lang.String r5 = "errorCode: 3508 errorMessage: data load failed, exception is "
                java.lang.String r6 = "errorCode: 3507 errorMessage: data load failed, errorMsg is "
                int r7 = r2.what     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r8 = 8
                if (r7 == r8) goto L_0x0749
                r8 = 9
                java.lang.String r9 = ""
                r11 = 2
                r12 = 3
                r14 = 6
                r15 = 5
                r13 = 0
                if (r7 == r8) goto L_0x06d4
                r8 = 16
                if (r7 == r8) goto L_0x06d4
                r8 = 17
                r10 = 1
                if (r7 == r8) goto L_0x068c
                switch(r7) {
                    case 1: goto L_0x067a;
                    case 2: goto L_0x0668;
                    case 3: goto L_0x064d;
                    case 4: goto L_0x0450;
                    case 5: goto L_0x0085;
                    case 6: goto L_0x002b;
                    default: goto L_0x0029;
                }
            L_0x0029:
                goto L_0x0787
            L_0x002b:
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.String r3 = r2.m     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r5 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.List r5 = r5.R     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r6 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.List r6 = r6.S     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r7 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                boolean r7 = r7.z     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c.a((com.mbridge.msdk.reward.adapter.c) r2, (java.lang.String) r3, (java.util.List) r5, (java.util.List) r6, (boolean) r7)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.a r2 = r2.u     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r2 == 0) goto L_0x0787
                r1.removeMessages(r14)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                android.os.Handler r2 = r2.N     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r2 == 0) goto L_0x0062
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                android.os.Handler r2 = r2.N     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r2.removeMessages(r15)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
            L_0x0062:
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.a r2 = r2.u     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r2 == 0) goto L_0x0787
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                boolean r2 = r2.i     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r2 != 0) goto L_0x0787
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r2.i = r10     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.a r2 = r2.u     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r3 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.concurrent.CopyOnWriteArrayList r3 = r3.F     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r2.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                goto L_0x0787
            L_0x0085:
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.a r2 = r2.u     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r2 == 0) goto L_0x0787
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.List r2 = r2.R     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r2 == 0) goto L_0x0105
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.List r2 = r2.R     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                int r2 = r2.size()     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r2 <= 0) goto L_0x0105
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.List r2 = r2.R     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.Object r2 = r2.get(r13)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = (com.mbridge.msdk.foundation.entity.CampaignEx) r2     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.String r5 = r2.getCMPTEntryUrl()     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r5 != 0) goto L_0x00b9
                r5 = 1
                goto L_0x00ba
            L_0x00b9:
                r5 = 0
            L_0x00ba:
                int r2 = r2.getNscpt()     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r6 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.concurrent.CopyOnWriteArrayList r7 = r6.F     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                boolean r2 = r6.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r7, (boolean) r5, (int) r2, (boolean) r10)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r2 == 0) goto L_0x0105
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.String r3 = r2.m     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r5 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.List r5 = r5.R     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r6 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.List r6 = r6.S     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r7 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                boolean r7 = r7.z     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c.a((com.mbridge.msdk.reward.adapter.c) r2, (java.lang.String) r3, (java.util.List) r5, (java.util.List) r6, (boolean) r7)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r1.sendEmptyMessage(r14)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r1.removeMessages(r15)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                boolean r2 = r2.i     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r2 != 0) goto L_0x0104
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r2.i = r10     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.a r2 = r2.u     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r3 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.concurrent.CopyOnWriteArrayList r3 = r3.F     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r2.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
            L_0x0104:
                return
            L_0x0105:
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.String r5 = r2.m     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r6 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.List r6 = r6.R     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r7 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                boolean r7 = r7.z     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c.a((com.mbridge.msdk.reward.adapter.c) r2, (java.lang.String) r5, (java.util.List) r6, (boolean) r7)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                android.os.Handler r2 = r2.N     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r2 == 0) goto L_0x0134
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                android.os.Handler r2 = r2.N     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r2.removeMessages(r15)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                android.os.Handler r2 = r2.N     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r2.removeMessages(r14)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
            L_0x0134:
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.List r2 = r2.R     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r2 == 0) goto L_0x0157
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.List r2 = r2.R     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                int r2 = r2.size()     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r2 <= 0) goto L_0x0157
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.List r2 = r2.R     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.Object r2 = r2.get(r13)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = (com.mbridge.msdk.foundation.entity.CampaignEx) r2     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r16 = r2
                goto L_0x0159
            L_0x0157:
                r16 = 0
            L_0x0159:
                if (r16 != 0) goto L_0x017d
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.concurrent.CopyOnWriteArrayList r2 = r2.G     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r2 == 0) goto L_0x017d
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.concurrent.CopyOnWriteArrayList r2 = r2.G     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                int r2 = r2.size()     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r2 <= 0) goto L_0x017d
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.concurrent.CopyOnWriteArrayList r2 = r2.G     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.Object r2 = r2.get(r13)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r16 = r2
                com.mbridge.msdk.foundation.entity.CampaignEx r16 = (com.mbridge.msdk.foundation.entity.CampaignEx) r16     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
            L_0x017d:
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                boolean r2 = r2.j     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r2 == 0) goto L_0x0195
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                boolean r2 = r2.k     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r2 == 0) goto L_0x0787
                if (r16 == 0) goto L_0x0787
                java.lang.String r2 = r16.getNLRid()     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r2 != 0) goto L_0x0787
            L_0x0195:
                com.mbridge.msdk.foundation.entity.e r2 = new com.mbridge.msdk.foundation.entity.e     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.String r5 = "errorCode: 3401 errorMessage: resource load timeout"
                r6 = 10
                r2.<init>(r6, r5)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r5 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r5.j = r10     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r16 == 0) goto L_0x01d1
                com.mbridge.msdk.reward.adapter.c r5 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x01d1, all -> 0x0778 }
                android.content.Context r18 = r5.l     // Catch:{ Exception -> 0x01d1, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r5 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x01d1, all -> 0x0778 }
                java.lang.String r20 = r5.m     // Catch:{ Exception -> 0x01d1, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r5 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x01d1, all -> 0x0778 }
                boolean r21 = r5.z     // Catch:{ Exception -> 0x01d1, all -> 0x0778 }
                if (r16 != 0) goto L_0x01bb
                r22 = r9
                goto L_0x01c1
            L_0x01bb:
                java.lang.String r5 = r16.getRequestId()     // Catch:{ Exception -> 0x01d1, all -> 0x0778 }
                r22 = r5
            L_0x01c1:
                if (r16 != 0) goto L_0x01c4
                goto L_0x01c8
            L_0x01c4:
                java.lang.String r9 = r16.getRequestIdNotice()     // Catch:{ Exception -> 0x01d1, all -> 0x0778 }
            L_0x01c8:
                r23 = r9
                r17 = r16
                r19 = r2
                com.mbridge.msdk.reward.c.a.a(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x01d1, all -> 0x0778 }
            L_0x01d1:
                com.mbridge.msdk.reward.adapter.c r5 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.a r5 = r5.u     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r6 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.List r6 = r6.R     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.String r2 = r2.e()     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r5.a(r6, r2)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.concurrent.CopyOnWriteArrayList r2 = r2.F     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r2 == 0) goto L_0x0787
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.concurrent.CopyOnWriteArrayList r2 = r2.F     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                int r2 = r2.size()     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r2 <= 0) goto L_0x0787
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.concurrent.CopyOnWriteArrayList r2 = r2.F     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r5 = 0
            L_0x0203:
                boolean r6 = r2.hasNext()     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r6 == 0) goto L_0x0787
                java.lang.Object r6 = r2.next()     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.foundation.entity.CampaignEx r6 = (com.mbridge.msdk.foundation.entity.CampaignEx) r6     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r6 == 0) goto L_0x0276
                java.lang.String r7 = r6.getVideoUrlEncode()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                if (r7 != 0) goto L_0x0276
                com.mbridge.msdk.videocommon.download.i r7 = com.mbridge.msdk.videocommon.download.i.a()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                java.lang.String r8 = r6.getVideoUrlEncode()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                boolean r7 = r7.a((java.lang.String) r8)     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                if (r7 != 0) goto L_0x0276
                com.mbridge.msdk.reward.adapter.c r7 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0273, all -> 0x0778 }
                android.content.Context r18 = r7.l     // Catch:{ Exception -> 0x0273, all -> 0x0778 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0273, all -> 0x0778 }
                r7.<init>()     // Catch:{ Exception -> 0x0273, all -> 0x0778 }
                java.lang.String r8 = "resource load timeout exception video is tpl: "
                r7.append(r8)     // Catch:{ Exception -> 0x0273, all -> 0x0778 }
                java.lang.String r8 = r16.getCMPTEntryUrl()     // Catch:{ Exception -> 0x0273, all -> 0x0778 }
                boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0273, all -> 0x0778 }
                if (r8 != 0) goto L_0x0245
                r8 = 1
                goto L_0x0246
            L_0x0245:
                r8 = 0
            L_0x0246:
                r7.append(r8)     // Catch:{ Exception -> 0x0273, all -> 0x0778 }
                java.lang.String r19 = r7.toString()     // Catch:{ Exception -> 0x0273, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r7 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0273, all -> 0x0778 }
                java.lang.String r20 = r7.m     // Catch:{ Exception -> 0x0273, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r7 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0273, all -> 0x0778 }
                boolean r21 = r7.z     // Catch:{ Exception -> 0x0273, all -> 0x0778 }
                java.lang.String r22 = r6.getRequestId()     // Catch:{ Exception -> 0x0273, all -> 0x0778 }
                java.lang.String r23 = r6.getRequestIdNotice()     // Catch:{ Exception -> 0x0273, all -> 0x0778 }
                long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0273, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r9 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0273, all -> 0x0778 }
                long r11 = r9.P     // Catch:{ Exception -> 0x0273, all -> 0x0778 }
                long r24 = r7 - r11
                r17 = r16
                com.mbridge.msdk.reward.c.a.a(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ Exception -> 0x0273, all -> 0x0778 }
                goto L_0x0274
            L_0x0273:
            L_0x0274:
                r7 = 1
                goto L_0x0277
            L_0x0276:
                r7 = 0
            L_0x0277:
                if (r6 == 0) goto L_0x02dd
                java.lang.String r8 = r6.getendcard_url()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                if (r8 != 0) goto L_0x02dd
                com.mbridge.msdk.videocommon.download.i r8 = com.mbridge.msdk.videocommon.download.i.a()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                java.lang.String r9 = r6.getendcard_url()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                boolean r8 = r8.b(r9)     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                if (r8 != 0) goto L_0x02dd
                com.mbridge.msdk.reward.adapter.c r7 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x02db, all -> 0x0778 }
                android.content.Context r18 = r7.l     // Catch:{ Exception -> 0x02db, all -> 0x0778 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02db, all -> 0x0778 }
                r7.<init>()     // Catch:{ Exception -> 0x02db, all -> 0x0778 }
                java.lang.String r8 = "resource load timeout exception endcard is tpl: "
                r7.append(r8)     // Catch:{ Exception -> 0x02db, all -> 0x0778 }
                java.lang.String r8 = r16.getCMPTEntryUrl()     // Catch:{ Exception -> 0x02db, all -> 0x0778 }
                boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x02db, all -> 0x0778 }
                if (r8 != 0) goto L_0x02ad
                r8 = 1
                goto L_0x02ae
            L_0x02ad:
                r8 = 0
            L_0x02ae:
                r7.append(r8)     // Catch:{ Exception -> 0x02db, all -> 0x0778 }
                java.lang.String r19 = r7.toString()     // Catch:{ Exception -> 0x02db, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r7 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x02db, all -> 0x0778 }
                java.lang.String r20 = r7.m     // Catch:{ Exception -> 0x02db, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r7 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x02db, all -> 0x0778 }
                boolean r21 = r7.z     // Catch:{ Exception -> 0x02db, all -> 0x0778 }
                java.lang.String r22 = r6.getRequestId()     // Catch:{ Exception -> 0x02db, all -> 0x0778 }
                java.lang.String r23 = r6.getRequestIdNotice()     // Catch:{ Exception -> 0x02db, all -> 0x0778 }
                long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x02db, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r9 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x02db, all -> 0x0778 }
                long r11 = r9.P     // Catch:{ Exception -> 0x02db, all -> 0x0778 }
                long r24 = r7 - r11
                r17 = r16
                com.mbridge.msdk.reward.c.a.a(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ Exception -> 0x02db, all -> 0x0778 }
                goto L_0x02dc
            L_0x02db:
            L_0x02dc:
                r7 = 1
            L_0x02dd:
                if (r6 == 0) goto L_0x0388
                java.lang.String r8 = r6.getCMPTEntryUrl()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                if (r8 != 0) goto L_0x0388
                com.mbridge.msdk.videocommon.download.i r8 = com.mbridge.msdk.videocommon.download.i.a()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                java.lang.String r9 = r6.getCMPTEntryUrl()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                boolean r8 = r8.b(r9)     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                if (r8 != 0) goto L_0x0328
                com.mbridge.msdk.reward.adapter.c r7 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0325, all -> 0x0778 }
                android.content.Context r18 = r7.l     // Catch:{ Exception -> 0x0325, all -> 0x0778 }
                java.lang.String r19 = "resource load timeout exception tpl"
                com.mbridge.msdk.reward.adapter.c r7 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0325, all -> 0x0778 }
                java.lang.String r20 = r7.m     // Catch:{ Exception -> 0x0325, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r7 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0325, all -> 0x0778 }
                boolean r21 = r7.z     // Catch:{ Exception -> 0x0325, all -> 0x0778 }
                java.lang.String r22 = r6.getRequestId()     // Catch:{ Exception -> 0x0325, all -> 0x0778 }
                java.lang.String r23 = r6.getRequestIdNotice()     // Catch:{ Exception -> 0x0325, all -> 0x0778 }
                long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0325, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r9 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0325, all -> 0x0778 }
                long r11 = r9.P     // Catch:{ Exception -> 0x0325, all -> 0x0778 }
                long r24 = r7 - r11
                r17 = r16
                com.mbridge.msdk.reward.c.a.a(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ Exception -> 0x0325, all -> 0x0778 }
                goto L_0x0326
            L_0x0325:
            L_0x0326:
                r7 = 1
                goto L_0x0388
            L_0x0328:
                if (r5 != 0) goto L_0x0388
                if (r7 != 0) goto L_0x0388
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                r8.<init>()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r9 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                java.lang.String r9 = r9.m     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                r8.append(r9)     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                r8.append(r3)     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                java.lang.String r9 = r6.getRequestId()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                r8.append(r9)     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                r8.append(r3)     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                java.lang.String r9 = r6.getCMPTEntryUrl()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                r8.append(r9)     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                com.mbridge.msdk.videocommon.a$a r8 = com.mbridge.msdk.videocommon.a.a(r8)     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                if (r8 != 0) goto L_0x0388
                com.mbridge.msdk.reward.adapter.c r5 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0386, all -> 0x0778 }
                android.content.Context r18 = r5.l     // Catch:{ Exception -> 0x0386, all -> 0x0778 }
                java.lang.String r19 = "resource load timeout exception tpl preload"
                com.mbridge.msdk.reward.adapter.c r5 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0386, all -> 0x0778 }
                java.lang.String r20 = r5.m     // Catch:{ Exception -> 0x0386, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r5 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0386, all -> 0x0778 }
                boolean r21 = r5.z     // Catch:{ Exception -> 0x0386, all -> 0x0778 }
                java.lang.String r22 = r6.getRequestId()     // Catch:{ Exception -> 0x0386, all -> 0x0778 }
                java.lang.String r23 = r6.getRequestIdNotice()     // Catch:{ Exception -> 0x0386, all -> 0x0778 }
                long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0386, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r5 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0386, all -> 0x0778 }
                long r11 = r5.P     // Catch:{ Exception -> 0x0386, all -> 0x0778 }
                long r24 = r8 - r11
                r17 = r16
                com.mbridge.msdk.reward.c.a.a(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ Exception -> 0x0386, all -> 0x0778 }
                goto L_0x0387
            L_0x0386:
            L_0x0387:
                r5 = 1
            L_0x0388:
                if (r6 == 0) goto L_0x0203
                com.mbridge.msdk.foundation.entity.CampaignEx$c r8 = r6.getRewardTemplateMode()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                if (r8 == 0) goto L_0x0203
                com.mbridge.msdk.foundation.entity.CampaignEx$c r8 = r6.getRewardTemplateMode()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                java.lang.String r8 = r8.e()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                if (r8 != 0) goto L_0x0203
                com.mbridge.msdk.foundation.entity.CampaignEx$c r8 = r6.getRewardTemplateMode()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                java.lang.String r8 = r8.e()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                java.lang.String r9 = "cmpt=1"
                boolean r8 = r8.contains(r9)     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                if (r8 != 0) goto L_0x0203
                com.mbridge.msdk.videocommon.download.i r8 = com.mbridge.msdk.videocommon.download.i.a()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                com.mbridge.msdk.foundation.entity.CampaignEx$c r9 = r6.getRewardTemplateMode()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                java.lang.String r9 = r9.e()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                boolean r8 = r8.b(r9)     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                if (r8 != 0) goto L_0x040b
                com.mbridge.msdk.reward.adapter.c r7 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                android.content.Context r18 = r7.l     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                r7.<init>()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                java.lang.String r8 = "resource load timeout exception template is tpl: "
                r7.append(r8)     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                java.lang.String r8 = r16.getCMPTEntryUrl()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                if (r8 != 0) goto L_0x03dc
                r8 = 1
                goto L_0x03dd
            L_0x03dc:
                r8 = 0
            L_0x03dd:
                r7.append(r8)     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                java.lang.String r19 = r7.toString()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r7 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                java.lang.String r20 = r7.m     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r7 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                boolean r21 = r7.z     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                java.lang.String r22 = r6.getRequestId()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                java.lang.String r23 = r6.getRequestIdNotice()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r8 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                long r8 = r8.P     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                long r24 = r6 - r8
                r17 = r16
                com.mbridge.msdk.reward.c.a.a(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                goto L_0x0203
            L_0x040b:
                java.lang.String r8 = r6.getCMPTEntryUrl()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                if (r8 == 0) goto L_0x0203
                if (r7 != 0) goto L_0x0203
                int r7 = r6.getAdType()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                com.mbridge.msdk.videocommon.a$a r7 = com.mbridge.msdk.videocommon.a.a(r7, r6)     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                if (r7 != 0) goto L_0x0203
                com.mbridge.msdk.reward.adapter.c r7 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                android.content.Context r18 = r7.l     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                java.lang.String r19 = "resource load timeout exception template preload"
                com.mbridge.msdk.reward.adapter.c r7 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                java.lang.String r20 = r7.m     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r7 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                boolean r21 = r7.z     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                java.lang.String r22 = r6.getRequestId()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                java.lang.String r23 = r6.getRequestIdNotice()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r8 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                long r8 = r8.P     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                long r24 = r6 - r8
                r17 = r16
                com.mbridge.msdk.reward.c.a.a(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ Exception -> 0x0203, all -> 0x0778 }
                goto L_0x0203
            L_0x0450:
                com.mbridge.msdk.reward.adapter.c r3 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.a r3 = r3.u     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r3 == 0) goto L_0x0787
                com.mbridge.msdk.reward.adapter.c r3 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.String r7 = r3.m     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r9 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.List r9 = r9.R     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r8 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                boolean r8 = r8.z     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c.a((com.mbridge.msdk.reward.adapter.c) r3, (java.lang.String) r7, (java.util.List) r9, (boolean) r8)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r3 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.List r3 = r3.R     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r3 == 0) goto L_0x0490
                com.mbridge.msdk.reward.adapter.c r3 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.List r3 = r3.R     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                int r3 = r3.size()     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r3 <= 0) goto L_0x0490
                com.mbridge.msdk.reward.adapter.c r3 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.List r3 = r3.R     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.Object r3 = r3.get(r13)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = (com.mbridge.msdk.foundation.entity.CampaignEx) r3     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r16 = r3
                goto L_0x0492
            L_0x0490:
                r16 = 0
            L_0x0492:
                com.mbridge.msdk.foundation.entity.e r3 = new com.mbridge.msdk.foundation.entity.e     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                java.lang.String r7 = "unknow error in load failed"
                r3.<init>(r10, r7)     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                java.lang.Object r7 = r2.obj     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                if (r7 != 0) goto L_0x04c5
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                android.os.Handler r2 = r2.N     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                if (r2 == 0) goto L_0x04af
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                android.os.Handler r2 = r2.N     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                r2.removeMessages(r15)     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
            L_0x04af:
                r1.removeMessages(r14)     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                boolean r2 = r2.j     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                if (r2 != 0) goto L_0x054d
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                r2.j = r10     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                com.mbridge.msdk.foundation.entity.e r3 = new com.mbridge.msdk.foundation.entity.e     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                java.lang.String r2 = "errorCode: 3506 errorMessage: data load failed"
                r3.<init>(r10, r2)     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                goto L_0x054d
            L_0x04c5:
                java.lang.Object r7 = r2.obj     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                int r8 = r2.arg1     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                int r2 = r2.arg2     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                boolean r9 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                if (r9 == 0) goto L_0x04f9
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                android.os.Handler r2 = r2.N     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                if (r2 == 0) goto L_0x04e4
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                android.os.Handler r2 = r2.N     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                r2.removeMessages(r15)     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
            L_0x04e4:
                r1.removeMessages(r14)     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                boolean r2 = r2.j     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                if (r2 != 0) goto L_0x054d
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                r2.j = r10     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                com.mbridge.msdk.foundation.entity.e r3 = new com.mbridge.msdk.foundation.entity.e     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                java.lang.String r2 = "errorCode: 3507 errorMessage: data load failed, errorMsg null"
                r3.<init>(r10, r2)     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                goto L_0x054d
            L_0x04f9:
                com.mbridge.msdk.reward.adapter.c r3 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                android.os.Handler r3 = r3.N     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                if (r3 == 0) goto L_0x050a
                com.mbridge.msdk.reward.adapter.c r3 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                android.os.Handler r3 = r3.N     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                r3.removeMessages(r15)     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
            L_0x050a:
                r1.removeMessages(r14)     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                if (r2 == 0) goto L_0x0538
                r3 = -1
                if (r2 == r10) goto L_0x0533
                if (r2 == r11) goto L_0x0530
                r9 = 18
                if (r2 == r12) goto L_0x052a
                r11 = 4
                if (r2 == r11) goto L_0x051c
                goto L_0x0528
            L_0x051c:
                r2 = 6001(0x1771, float:8.409E-42)
                if (r8 != r2) goto L_0x0521
                goto L_0x052d
            L_0x0521:
                r2 = 6003(0x1773, float:8.412E-42)
                if (r8 != r2) goto L_0x0528
                r12 = 11
                goto L_0x0539
            L_0x0528:
                r12 = 1
                goto L_0x0539
            L_0x052a:
                if (r8 != r3) goto L_0x052d
                goto L_0x0532
            L_0x052d:
                r12 = 18
                goto L_0x0539
            L_0x0530:
                if (r8 != r3) goto L_0x0539
            L_0x0532:
                goto L_0x0535
            L_0x0533:
                if (r8 != r3) goto L_0x0528
            L_0x0535:
                r12 = 17
                goto L_0x0539
            L_0x0538:
                r12 = 0
            L_0x0539:
                com.mbridge.msdk.foundation.entity.e r3 = new com.mbridge.msdk.foundation.entity.e     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                r2.<init>(r6)     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                r2.append(r7)     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                r3.<init>(r12, r2)     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                r3.c(r8)     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
            L_0x054d:
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                boolean r2 = r2.j     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                if (r2 != 0) goto L_0x0787
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                r2.j = r10     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                if (r16 == 0) goto L_0x057b
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                android.content.Context r20 = r2.l     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                java.lang.String r22 = r2.m     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                boolean r23 = r2.z     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                java.lang.String r24 = r16.getRequestId()     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                java.lang.String r25 = r16.getRequestIdNotice()     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                r19 = r16
                r21 = r3
                com.mbridge.msdk.reward.c.a.a(r19, r20, r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                goto L_0x0598
            L_0x057b:
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                android.content.Context r20 = r2.l     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                java.lang.String r22 = r2.m     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                boolean r23 = r2.z     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                java.lang.String r24 = ""
                java.lang.String r25 = ""
                r19 = r16
                r21 = r3
                com.mbridge.msdk.reward.c.a.a(r19, r20, r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
            L_0x0598:
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.a r2 = r2.u     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r6 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                java.util.List r6 = r6.R     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                java.lang.String r3 = r3.e()     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                r2.a(r6, r3)     // Catch:{ Exception -> 0x05ad, all -> 0x0778 }
                goto L_0x0787
            L_0x05ad:
                r0 = move-exception
                r2 = r0
                com.mbridge.msdk.reward.adapter.c r3 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                android.os.Handler r3 = r3.N     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r3 == 0) goto L_0x05c0
                com.mbridge.msdk.reward.adapter.c r3 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                android.os.Handler r3 = r3.N     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r3.removeMessages(r15)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
            L_0x05c0:
                r1.removeMessages(r14)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r3 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.String r6 = r3.m     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r7 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.List r7 = r7.R     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r8 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                boolean r8 = r8.z     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c.a((com.mbridge.msdk.reward.adapter.c) r3, (java.lang.String) r6, (java.util.List) r7, (boolean) r8)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r3 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                boolean r3 = r3.j     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r3 != 0) goto L_0x0787
                com.mbridge.msdk.reward.adapter.c r3 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r3.j = r10     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.foundation.entity.e r3 = new com.mbridge.msdk.foundation.entity.e     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r6.<init>(r5)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.String r2 = r2.getMessage()     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r6.append(r2)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r3.<init>(r10, r2)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r16 == 0) goto L_0x061b
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                android.content.Context r20 = r2.l     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.String r22 = r2.m     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                boolean r23 = r2.z     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.String r24 = r16.getRequestId()     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.String r25 = r16.getRequestIdNotice()     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r19 = r16
                r21 = r3
                com.mbridge.msdk.reward.c.a.a(r19, r20, r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                goto L_0x0638
            L_0x061b:
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                android.content.Context r20 = r2.l     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.String r22 = r2.m     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                boolean r23 = r2.z     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.String r24 = ""
                java.lang.String r25 = ""
                r19 = r16
                r21 = r3
                com.mbridge.msdk.reward.c.a.a(r19, r20, r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
            L_0x0638:
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.a r2 = r2.u     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r5 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.util.List r5 = r5.R     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.String r3 = r3.e()     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r2.a(r5, r3)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                goto L_0x0787
            L_0x064d:
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.a r2 = r2.u     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r2 == 0) goto L_0x0660
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.a r2 = r2.u     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.String r3 = "campaign is ok"
                r2.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
            L_0x0660:
                int r2 = com.mbridge.msdk.foundation.same.a.n     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                long r2 = (long) r2     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r1.sendEmptyMessageDelayed(r15, r2)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                goto L_0x0787
            L_0x0668:
                java.lang.Object r3 = r2.obj     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r3 == 0) goto L_0x0672
                java.lang.Object r2 = r2.obj     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r13 = r2
                java.util.Map r13 = (java.util.Map) r13     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                goto L_0x0673
            L_0x0672:
                r13 = 0
            L_0x0673:
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r2.a((java.util.Map<java.lang.String, java.lang.String>) r13)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                goto L_0x0787
            L_0x067a:
                java.lang.Object r3 = r2.obj     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r3 == 0) goto L_0x0684
                java.lang.Object r2 = r2.obj     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r13 = r2
                java.util.Map r13 = (java.util.Map) r13     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                goto L_0x0685
            L_0x0684:
                r13 = 0
            L_0x0685:
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r2.a((java.util.Map<java.lang.String, java.lang.String>) r13)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                goto L_0x0787
            L_0x068c:
                java.lang.Object r2 = r2.obj     // Catch:{ Exception -> 0x06c2, all -> 0x0778 }
                java.lang.Object[] r2 = (java.lang.Object[]) r2     // Catch:{ Exception -> 0x06c2, all -> 0x0778 }
                java.lang.Object[] r2 = (java.lang.Object[]) r2     // Catch:{ Exception -> 0x06c2, all -> 0x0778 }
                r3 = r2[r13]     // Catch:{ Exception -> 0x06c2, all -> 0x0778 }
                r20 = r3
                com.mbridge.msdk.foundation.entity.CampaignEx r20 = (com.mbridge.msdk.foundation.entity.CampaignEx) r20     // Catch:{ Exception -> 0x06c2, all -> 0x0778 }
                r3 = r2[r10]     // Catch:{ Exception -> 0x06c2, all -> 0x0778 }
                r21 = r3
                java.lang.String r21 = (java.lang.String) r21     // Catch:{ Exception -> 0x06c2, all -> 0x0778 }
                r3 = r2[r11]     // Catch:{ Exception -> 0x06c2, all -> 0x0778 }
                r22 = r3
                java.lang.String r22 = (java.lang.String) r22     // Catch:{ Exception -> 0x06c2, all -> 0x0778 }
                r3 = r2[r12]     // Catch:{ Exception -> 0x06c2, all -> 0x0778 }
                r23 = r3
                com.mbridge.msdk.videocommon.d.c r23 = (com.mbridge.msdk.videocommon.d.c) r23     // Catch:{ Exception -> 0x06c2, all -> 0x0778 }
                r3 = 4
                r2 = r2[r3]     // Catch:{ Exception -> 0x06c2, all -> 0x0778 }
                r19 = r2
                java.lang.String r19 = (java.lang.String) r19     // Catch:{ Exception -> 0x06c2, all -> 0x0778 }
                if (r20 == 0) goto L_0x0787
                boolean r2 = android.text.TextUtils.isEmpty(r21)     // Catch:{ Exception -> 0x06c2, all -> 0x0778 }
                if (r2 != 0) goto L_0x0787
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x06c2, all -> 0x0778 }
                r18 = r2
                com.mbridge.msdk.reward.adapter.c.a((com.mbridge.msdk.reward.adapter.c) r18, (java.lang.String) r19, (com.mbridge.msdk.foundation.entity.CampaignEx) r20, (java.lang.String) r21, (java.lang.String) r22, (com.mbridge.msdk.videocommon.d.c) r23)     // Catch:{ Exception -> 0x06c2, all -> 0x0778 }
                goto L_0x0787
            L_0x06c2:
                r0 = move-exception
                r2 = r0
                java.lang.String r3 = r2.getLocalizedMessage()     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r4, (java.lang.String) r3)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r3 == 0) goto L_0x0787
                r2.printStackTrace()     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                goto L_0x0787
            L_0x06d4:
                java.lang.Object r2 = r2.obj     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                java.lang.Object[] r2 = (java.lang.Object[]) r2     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                java.lang.Object[] r2 = (java.lang.Object[]) r2     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                r3 = r2[r13]     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                r21 = r3
                com.mbridge.msdk.foundation.entity.CampaignEx r21 = (com.mbridge.msdk.foundation.entity.CampaignEx) r21     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                r3 = r2[r11]     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                r24 = r3
                java.lang.String r24 = (java.lang.String) r24     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                r3 = r2[r12]     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                r25 = r3
                com.mbridge.msdk.videocommon.d.c r25 = (com.mbridge.msdk.videocommon.d.c) r25     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                r3 = 4
                r3 = r2[r3]     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                r20 = r3
                java.lang.String r20 = (java.lang.String) r20     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                int r3 = r2.length     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                r5 = 7
                if (r3 != r5) goto L_0x0706
                r3 = r2[r15]     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                r9 = r3
                java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                r2 = r2[r14]     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                r13 = r2
                com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r13 = (com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView) r13     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                r26 = r9
                r19 = r13
                goto L_0x070a
            L_0x0706:
                r26 = r9
                r19 = 0
            L_0x070a:
                if (r21 == 0) goto L_0x0787
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                java.util.concurrent.CopyOnWriteArrayList r2 = r2.w     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                if (r2 != 0) goto L_0x072a
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                java.util.List r2 = r2.S     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                if (r2 == 0) goto L_0x0787
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                java.util.List r22 = r2.S     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                java.lang.String r23 = ""
                r18 = r2
                com.mbridge.msdk.reward.adapter.c.a(r18, r19, r20, r21, r22, r23, r24, r25, r26)     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                goto L_0x0787
            L_0x072a:
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                java.util.concurrent.CopyOnWriteArrayList r22 = r2.w     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                java.lang.String r23 = ""
                r18 = r2
                com.mbridge.msdk.reward.adapter.c.a(r18, r19, r20, r21, r22, r23, r24, r25, r26)     // Catch:{ Exception -> 0x0738, all -> 0x0778 }
                goto L_0x0787
            L_0x0738:
                r0 = move-exception
                r2 = r0
                java.lang.String r3 = r2.getLocalizedMessage()     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r4, (java.lang.String) r3)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r3 == 0) goto L_0x0787
                r2.printStackTrace()     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                goto L_0x0787
            L_0x0749:
                com.mbridge.msdk.reward.adapter.c r3 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.a r3 = r3.u     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r3 == 0) goto L_0x0787
                java.lang.Object r2 = r2.obj     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = (com.mbridge.msdk.foundation.entity.CampaignEx) r2     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r2 == 0) goto L_0x0787
                com.mbridge.msdk.reward.adapter.c r3 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.String r3 = r3.m     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                if (r3 != 0) goto L_0x0787
                com.mbridge.msdk.reward.adapter.c r3 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                android.content.Context r3 = r3.l     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r5 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                java.lang.String r5 = r5.m     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.c.a.a((android.content.Context) r3, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (java.lang.String) r5)     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                r2.c()     // Catch:{ Exception -> 0x0782, all -> 0x0778 }
                goto L_0x0787
            L_0x0778:
                r0 = move-exception
                r2 = r0
                java.lang.String r2 = r2.getMessage()
                com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r4, (java.lang.String) r2)
                goto L_0x0787
            L_0x0782:
                r0 = move-exception
                r2 = r0
                r2.printStackTrace()
            L_0x0787:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.AnonymousClass1.handleMessage(android.os.Message):void");
        }
    };
    /* access modifiers changed from: private */
    public boolean O = false;
    /* access modifiers changed from: private */
    public long P = 0;
    private String Q = "";
    /* access modifiers changed from: private */
    public List<CampaignEx> R;
    /* access modifiers changed from: private */
    public List<CampaignEx> S;
    public String a = "";
    public String b = "";
    public String c = "";
    public Object d = new Object();
    boolean e = false;
    volatile boolean f = false;
    volatile boolean g = false;
    volatile boolean h = false;
    volatile boolean i = false;
    volatile boolean j = false;
    public volatile boolean k = false;
    /* access modifiers changed from: private */
    public Context l;
    /* access modifiers changed from: private */
    public String m;
    /* access modifiers changed from: private */
    public String n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    /* access modifiers changed from: private */
    public String s;
    private h t;
    /* access modifiers changed from: private */
    public volatile a u;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.videocommon.d.c v;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<CampaignEx> w = new CopyOnWriteArrayList<>();
    /* access modifiers changed from: private */
    public int x = 2;
    /* access modifiers changed from: private */
    public boolean y;
    /* access modifiers changed from: private */
    public boolean z;

    public final String a(boolean z2) {
        CopyOnWriteArrayList<CampaignEx> a2;
        CampaignEx campaignEx;
        if (!z2) {
            return this.a;
        }
        if (TextUtils.isEmpty(this.b) && (a2 = com.mbridge.msdk.videocommon.download.c.getInstance().a(this.m)) != null && a2.size() > 0 && (campaignEx = a2.get(0)) != null) {
            this.b = campaignEx.getRequestId();
        }
        return this.b;
    }

    public final String a() {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.F;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return com.mbridge.msdk.foundation.same.b.a(this.S);
        }
        return com.mbridge.msdk.foundation.same.b.a(this.F);
    }

    public final void b(boolean z2) {
        this.y = z2;
    }

    public final void c(boolean z2) {
        this.z = z2;
    }

    public final void a(String str) {
        this.A = str;
    }

    public final void a(int i2) {
        this.x = i2;
    }

    public final String b() {
        return this.m;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0082, code lost:
        if (r13.e() == com.mbridge.msdk.foundation.b.c.e) goto L_0x0092;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.mbridge.msdk.foundation.entity.CampaignEx r12, boolean r13, com.mbridge.msdk.foundation.entity.e r14, int r15) {
        /*
            r11 = this;
            com.mbridge.msdk.foundation.b.c r13 = new com.mbridge.msdk.foundation.b.c
            r13.<init>()
            com.mbridge.msdk.reward.a.a r0 = new com.mbridge.msdk.reward.a.a
            java.lang.String r1 = r11.m
            boolean r2 = r11.y
            r0.<init>(r1, r2)
            java.lang.String r1 = r11.J
            boolean r1 = r0.a(r1)
            r2 = 0
            if (r1 == 0) goto L_0x0018
            return r2
        L_0x0018:
            boolean r1 = r11.k
            r3 = 1
            if (r1 != 0) goto L_0x0088
            r11.k = r3
            com.mbridge.msdk.reward.a.a r0 = new com.mbridge.msdk.reward.a.a
            java.lang.String r13 = r11.m
            boolean r1 = r11.y
            r0.<init>(r13, r1)
            java.lang.String r5 = r11.J
            java.lang.String r6 = r11.c
            r4 = r0
            r7 = r12
            r8 = r14
            r9 = r15
            r10 = r11
            com.mbridge.msdk.foundation.b.c r13 = r4.a((java.lang.String) r5, (java.lang.String) r6, (com.mbridge.msdk.foundation.entity.CampaignEx) r7, (com.mbridge.msdk.foundation.entity.e) r8, (int) r9, (com.mbridge.msdk.reward.adapter.c) r10)
            if (r13 == 0) goto L_0x0085
            int r12 = r13.e()
            int r15 = com.mbridge.msdk.foundation.b.c.b
            if (r12 <= r15) goto L_0x0085
            java.util.concurrent.CopyOnWriteArrayList r12 = r13.g()
            if (r12 == 0) goto L_0x0057
            java.util.concurrent.CopyOnWriteArrayList r12 = r13.g()
            int r12 = r12.size()
            if (r12 <= 0) goto L_0x0057
            java.util.concurrent.CopyOnWriteArrayList r12 = r13.g()
            r11.a((java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>) r12, (boolean) r3, (boolean) r3)
            goto L_0x0092
        L_0x0057:
            int r12 = r13.e()
            int r15 = com.mbridge.msdk.foundation.b.c.d
            if (r12 != r15) goto L_0x007c
            if (r14 == 0) goto L_0x0085
            int r12 = r14.d()
            r14.a((int) r12)
            java.lang.String r12 = r14.e()
            r14.a((java.lang.String) r12)
            r12 = 21
            r14.b((int) r12)
            java.lang.String r12 = r13.f()
            r14.b((java.lang.String) r12)
            goto L_0x0085
        L_0x007c:
            int r12 = r13.e()
            int r14 = com.mbridge.msdk.foundation.b.c.e
            if (r12 != r14) goto L_0x0085
            goto L_0x0092
        L_0x0085:
            r7 = r13
            r4 = r0
            goto L_0x0095
        L_0x0088:
            java.lang.String r12 = "isCandidate:false"
            r13.e(r12)
            int r12 = com.mbridge.msdk.foundation.b.c.d
            r13.a((int) r12)
        L_0x0092:
            r7 = r13
            r4 = r0
            r2 = 1
        L_0x0095:
            java.lang.String r5 = r11.c
            java.lang.String r6 = r11.J
            r8 = 0
            r9 = 0
            r10 = 3
            r4.a((java.lang.String) r5, (java.lang.String) r6, (com.mbridge.msdk.foundation.b.c) r7, (java.util.List<com.mbridge.msdk.foundation.b.a.C0135a>) r8, (org.json.JSONObject) r9, (int) r10)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.a(com.mbridge.msdk.foundation.entity.CampaignEx, boolean, com.mbridge.msdk.foundation.entity.e, int):boolean");
    }

    /* compiled from: RewardMVVideoAdapter */
    private class b implements Runnable {
        private String b;
        private CampaignEx c;
        private String d;
        private String e;
        private com.mbridge.msdk.videocommon.d.c f;
        private int g;
        private c h;

        public b(String str, CampaignEx campaignEx, String str2, String str3, com.mbridge.msdk.videocommon.d.c cVar, int i, c cVar2) {
            this.b = str;
            this.c = campaignEx;
            this.d = str2;
            this.e = str3;
            this.f = cVar;
            this.g = i;
            this.h = cVar2;
        }

        public final void run() {
            j jVar;
            try {
                a.C0158a aVar = new a.C0158a();
                WindVaneWebView windVaneWebView = new WindVaneWebView(com.mbridge.msdk.foundation.controller.b.d().g());
                aVar.a(windVaneWebView);
                String b2 = com.mbridge.msdk.video.bt.a.c.a().b();
                aVar.a(b2);
                if (c.this.E.getAds() == null || c.this.E.getAds().size() <= 0) {
                    jVar = new j((Activity) null, this.c);
                } else {
                    jVar = new j((Activity) null, this.c, c.this.E.getAds());
                }
                j jVar2 = jVar;
                jVar2.a(this.g);
                jVar2.a(this.e);
                jVar2.c(b2);
                jVar2.a(this.f);
                jVar2.d(c.this.H);
                windVaneWebView.setWebViewListener(new a(this.d, this.b, aVar, this.c, this.h, (b) null, (Handler) null));
                windVaneWebView.setObject(jVar2);
                windVaneWebView.loadUrl(this.d);
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                aa.a("RewardMVVideoAdapter", th.getMessage());
            }
        }
    }

    /* renamed from: com.mbridge.msdk.reward.adapter.c$c  reason: collision with other inner class name */
    /* compiled from: RewardMVVideoAdapter */
    private class C0151c implements Runnable {
        private WindVaneWebView b;
        private String c;
        private CampaignEx d;
        private List<CampaignEx> e;
        private String f;
        private String g;
        private com.mbridge.msdk.videocommon.d.c h;
        private int i;
        private c j;

        public C0151c(WindVaneWebView windVaneWebView, String str, CampaignEx campaignEx, List<CampaignEx> list, String str2, String str3, com.mbridge.msdk.videocommon.d.c cVar, int i2, c cVar2) {
            this.b = windVaneWebView;
            this.c = str;
            this.d = campaignEx;
            this.e = list;
            this.f = str2;
            this.g = str3;
            this.h = cVar;
            this.i = i2;
            this.j = cVar2;
        }

        public final void run() {
            j jVar;
            try {
                a.C0158a aVar = new a.C0158a();
                WindVaneWebView windVaneWebView = new WindVaneWebView(com.mbridge.msdk.foundation.controller.b.d().g());
                aVar.a(windVaneWebView);
                List<CampaignEx> list = this.e;
                if (list == null || list.size() <= 0) {
                    jVar = new j((Activity) null, this.d);
                } else {
                    jVar = new j((Activity) null, this.d, this.e);
                }
                j jVar2 = jVar;
                jVar2.a(this.i);
                jVar2.a(this.g);
                jVar2.a(this.h);
                jVar2.d(c.this.H);
                windVaneWebView.setWebViewListener(new f(this.b, this.f, this.c, aVar, this.d, this.j, (C0151c) null, (Handler) null));
                windVaneWebView.setObject(jVar2);
                windVaneWebView.loadUrl(this.f);
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                aa.a("RewardMVVideoAdapter", th.getMessage());
            }
        }
    }

    /* compiled from: RewardMVVideoAdapter */
    private static class a extends com.mbridge.msdk.mbsignalcommon.b.a {
        private c a;
        private String b;
        private String c;
        private a.C0158a d;
        private CampaignEx e;
        private boolean f;
        private boolean g;
        private b h;
        private Handler i;

        public final void a(WebView webView, String str, String str2, int i2, int i3) {
        }

        public a(String str, String str2, a.C0158a aVar, CampaignEx campaignEx, c cVar, b bVar, Handler handler) {
            this.b = str;
            this.c = str2;
            this.d = aVar;
            if (cVar != null) {
                this.a = cVar;
            }
            this.e = campaignEx;
            this.h = bVar;
            this.i = handler;
        }

        public final void a(WebView webView, int i2) {
            Handler handler;
            if (!this.g) {
                b bVar = this.h;
                if (!(bVar == null || (handler = this.i) == null)) {
                    handler.removeCallbacks(bVar);
                }
                i.a().d(this.b, true);
                a.C0158a aVar = this.d;
                if (aVar != null) {
                    aVar.a(true);
                }
                List<CampaignEx> a2 = com.mbridge.msdk.videocommon.a.a.a().a(this.c, 1, this.a.z);
                if (a2 != null && a2.size() > 0) {
                    for (CampaignEx rewardTemplateMode : a2) {
                        CampaignEx.c rewardTemplateMode2 = rewardTemplateMode.getRewardTemplateMode();
                        if (rewardTemplateMode2 != null && !TextUtils.isEmpty(rewardTemplateMode2.e()) && !rewardTemplateMode2.e().contains(CampaignEx.KEY_IS_CMPT_ENTRY) && TextUtils.equals(rewardTemplateMode2.e(), this.b)) {
                            if (!TextUtils.isEmpty(this.e.getCMPTEntryUrl()) || this.e.getMof_tplid() != -1) {
                                this.e.getMof_tplid();
                                this.e.getRequestIdNotice();
                            } else {
                                this.e.getRequestIdNotice();
                            }
                            c cVar = this.a;
                            if (cVar == null || !cVar.y) {
                                if (this.e.isBidCampaign()) {
                                    com.mbridge.msdk.videocommon.a.a(94, this.e.getRequestIdNotice(), this.d);
                                }
                            } else if (this.e.isBidCampaign()) {
                                com.mbridge.msdk.videocommon.a.a(287, this.e.getRequestIdNotice(), this.d);
                            }
                        }
                    }
                }
                try {
                    c cVar2 = this.a;
                    if (cVar2 != null) {
                        synchronized (cVar2) {
                            c cVar3 = this.a;
                            if (!(cVar3 == null || !cVar3.c() || this.a.N == null)) {
                                Message obtain = Message.obtain();
                                obtain.what = 6;
                                aa.a("RVWindVaneWebView", "WHAT_ON_RES_LOAD_SUCCESS TPL");
                                obtain.obj = this.e;
                                this.a.N.sendMessage(obtain);
                                this.a.N.removeMessages(5);
                                this.a = null;
                            }
                        }
                    }
                } catch (Throwable th) {
                    aa.b("RVWindVaneWebView", th.getMessage(), th);
                }
                this.g = true;
            }
        }

        public final void a(WebView webView, String str) {
            super.a(webView, str);
            if (!this.f) {
                g.a().a(webView);
                this.f = true;
            }
        }

        public final void a(WebView webView, int i2, String str, String str2) {
            super.a(webView, i2, str, str2);
            try {
                c cVar = this.a;
                if (cVar != null) {
                    synchronized (cVar) {
                        c.a(this.a, str, str2);
                        this.a = null;
                    }
                }
            } catch (Throwable th) {
                aa.b("RVWindVaneWebView", th.getMessage(), th);
            }
        }
    }

    /* compiled from: RewardMVVideoAdapter */
    private static class f extends com.mbridge.msdk.mbsignalcommon.b.b {
        private c a;
        private WindVaneWebView b;
        private String c;
        private String d;
        private a.C0158a e;
        private CampaignEx f;
        private boolean g;
        private boolean h;
        private C0151c i;
        private Handler j;

        public f(WindVaneWebView windVaneWebView, String str, String str2, a.C0158a aVar, CampaignEx campaignEx, c cVar, C0151c cVar2, Handler handler) {
            this.b = windVaneWebView;
            this.c = str;
            this.d = str2;
            this.e = aVar;
            if (cVar != null) {
                this.a = cVar;
            }
            this.f = campaignEx;
            this.i = cVar2;
            this.j = handler;
        }

        public final void a(WebView webView, int i2) {
            Handler handler;
            if (!this.h) {
                C0151c cVar = this.i;
                if (!(cVar == null || (handler = this.j) == null)) {
                    handler.removeCallbacks(cVar);
                }
                String str = this.d + "_" + this.c;
                a.C0158a aVar = this.e;
                if (aVar != null) {
                    aVar.a(true);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", 1);
                    jSONObject.put("id", str);
                    jSONObject.put("unitid", this.d);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                i.a().d(this.c, true);
                com.mbridge.msdk.videocommon.a.a.a().a(this.d, 1, this.a.z);
                c cVar2 = this.a;
                if (cVar2 == null || !cVar2.y) {
                    if (this.f.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(94, this.f.getRequestIdNotice(), this.e);
                    }
                } else if (this.f.isBidCampaign()) {
                    com.mbridge.msdk.videocommon.a.a(287, this.f.getRequestIdNotice(), this.e);
                }
                try {
                    c cVar3 = this.a;
                    if (cVar3 != null) {
                        synchronized (cVar3) {
                            c cVar4 = this.a;
                            if (!(cVar4 == null || !cVar4.c() || this.a.N == null)) {
                                Message obtain = Message.obtain();
                                obtain.what = 6;
                                obtain.obj = this.f;
                                this.a.N.sendMessage(obtain);
                                this.a.N.removeMessages(5);
                                this.a = null;
                            }
                        }
                    }
                } catch (Throwable th) {
                    aa.b("WindVaneWebView", th.getMessage(), th);
                }
                this.h = true;
            }
        }

        public final void a(WebView webView, String str) {
            super.a(webView, str);
            if (!this.g) {
                g.a().a(webView);
                this.g = true;
            }
        }

        public final void a(WebView webView, int i2, String str, String str2) {
            super.a(webView, i2, str, str2);
            try {
                c cVar = this.a;
                if (cVar != null) {
                    synchronized (cVar) {
                        c.a(this.a, str, str2);
                        this.a = null;
                    }
                }
            } catch (Throwable th) {
                aa.b("WindVaneWebView", th.getMessage(), th);
            }
        }
    }

    public c(Context context, String str, String str2) {
        try {
            this.l = context.getApplicationContext();
            this.m = str2;
            this.n = str;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(com.mbridge.msdk.videocommon.d.c cVar) {
        try {
            this.v = cVar;
            if (cVar != null && cVar.E() * 1000 != com.mbridge.msdk.foundation.same.a.n) {
                com.mbridge.msdk.foundation.same.a.n = this.v.E() * 1000;
            }
        } catch (Throwable th) {
            aa.b("RewardMVVideoAdapter", th.getMessage(), th);
        }
    }

    public final boolean a(List<CampaignEx> list, boolean z2, int i2) {
        return a(list, z2, i2, false);
    }

    public final boolean a(List<CampaignEx> list, boolean z2) {
        boolean z3;
        if (list == null || list.size() <= 0) {
            aa.a("RewardVideoController", "数据为空");
        } else {
            CampaignEx campaignEx = list.get(0);
            if (campaignEx == null) {
                return false;
            }
            com.mbridge.msdk.videocommon.download.c instance = com.mbridge.msdk.videocommon.download.c.getInstance();
            String str = this.m;
            n c2 = instance.c(str);
            if (c2 == null) {
                c2 = instance.createUnitCache(com.mbridge.msdk.foundation.controller.b.d().g(), str, (CopyOnWriteArrayList<CampaignEx>) (CopyOnWriteArrayList) list, 94, (com.mbridge.msdk.videocommon.listener.a) null);
            }
            if (c2 != null) {
                z3 = c2.a(list, str);
            } else {
                z3 = false;
            }
            if (z3) {
                if (z2) {
                    if (campaignEx.isDynamicView()) {
                        return true;
                    }
                    if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0) {
                        if (campaignEx.getRsIgnoreCheckRule().contains(3)) {
                            aa.b("RewardMVVideoAdapter", "Is not check big template download status");
                            return true;
                        } else if (campaignEx.getCMPTEntryUrl().equals(campaignEx.getendcard_url()) && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                            aa.b("RewardMVVideoAdapter", "Is not check big template ENDCARD download status");
                            return true;
                        }
                    }
                    i a2 = i.a();
                    if (a2.c(this.m + "_" + campaignEx.getRequestId() + "_" + campaignEx.getCMPTEntryUrl())) {
                        aa.a("RewardVideoController", "大模板业务，开始检查大模板预加载情况，大模板预加载成功");
                        return true;
                    }
                } else if (campaignEx != null && campaignEx.isDynamicView()) {
                    return true;
                } else {
                    if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(1)) {
                        aa.b("RewardMVVideoAdapter", "Is not check template download status");
                        return true;
                    } else if (campaignEx.getRewardTemplateMode() == null || TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        aa.a("RewardVideoController", "非大模板 没有 template");
                        return true;
                    } else {
                        i a3 = i.a();
                        if (a3.c(this.m + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e())) {
                            aa.a("RewardVideoController", "非大模板业务，存在播放模板，播放模板预加载成功");
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final boolean a(List<CampaignEx> list, boolean z2, int i2, boolean z3) {
        if (list != null && list.size() > 0) {
            CampaignEx campaignEx = list.get(0);
            if (com.mbridge.msdk.videocommon.download.c.getInstance().a(94, this.m, this.z, list.size(), z2, i2, list, z3)) {
                if (z2) {
                    if (campaignEx.isDynamicView()) {
                        return true;
                    }
                    if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0) {
                        if (campaignEx.getRsIgnoreCheckRule().contains(3)) {
                            aa.b("RewardMVVideoAdapter", "Is not check big template download status");
                            return true;
                        } else if (campaignEx.getCMPTEntryUrl().equals(campaignEx.getendcard_url()) && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                            aa.b("RewardMVVideoAdapter", "Is not check big template of ENDCARD download status");
                            return true;
                        }
                    }
                    i a2 = i.a();
                    if (a2.c(this.m + "_" + campaignEx.getRequestId() + "_" + campaignEx.getCMPTEntryUrl())) {
                        return true;
                    }
                } else if (campaignEx != null && campaignEx.isDynamicView()) {
                    return true;
                } else {
                    if (campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(1)) {
                        if (campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                            i a3 = i.a();
                            if (a3.c(this.m + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e())) {
                                return true;
                            }
                        }
                        return true;
                    }
                    aa.b("RewardMVVideoAdapter", "Is not check template download status");
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean c() {
        CopyOnWriteArrayList<CampaignEx> a2 = com.mbridge.msdk.videocommon.a.a.a().a(this.m, 1, this.z, this.A);
        if (a2 == null || a2.size() <= 0) {
            aa.a("RewardVideoController", "database has not can use data");
            return false;
        }
        CampaignEx campaignEx = a2.get(0);
        int b2 = com.mbridge.msdk.videocommon.a.a.a().b(this.m, 1, this.z, this.A);
        if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()) || campaignEx.getNscpt() != 1 || a2.size() >= b2) {
            return a((List<CampaignEx>) a2, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt());
        }
        return false;
    }

    public final boolean d() {
        List<CampaignEx> c2 = com.mbridge.msdk.videocommon.a.a.a().c(this.m, 1, this.z, this.A);
        if (c2 == null || c2.size() <= 0) {
            aa.a("test_isReay_db", "database has not can use data");
            return false;
        }
        CampaignEx campaignEx = c2.get(0);
        int b2 = com.mbridge.msdk.videocommon.a.a.a().b(this.m, 1, this.z, this.A);
        if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()) || campaignEx.getNscpt() != 1 || c2.size() >= b2) {
            return a(c2, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt());
        }
        return false;
    }

    public final void a(h hVar, String str, String str2, int i2, String str3) {
        try {
            this.t = hVar;
            if (this.l != null) {
                if (!ak.a(this.m)) {
                    Intent intent = new Intent(this.l, MBRewardVideoActivity.class);
                    intent.addFlags(268435456);
                    intent.putExtra(MBRewardVideoActivity.INTENT_UNITID, this.m);
                    intent.putExtra(MBridgeConstans.PLACEMENT_ID, this.n);
                    intent.putExtra(MBRewardVideoActivity.INTENT_REWARD, str);
                    intent.putExtra(MBRewardVideoActivity.INTENT_MUTE, i2);
                    intent.putExtra(MBRewardVideoActivity.INTENT_ISIV, this.y);
                    intent.putExtra(MBRewardVideoActivity.INTENT_ISBID, this.z);
                    intent.putExtra(MBRewardVideoActivity.INTENT_EXTRADATA, str3);
                    CopyOnWriteArrayList<CampaignEx> a2 = com.mbridge.msdk.videocommon.download.c.getInstance().a(this.m);
                    boolean z2 = false;
                    if (a2 == null || a2.size() <= 0) {
                        h hVar2 = this.t;
                        if (hVar2 != null) {
                            hVar2.a("load failed");
                            return;
                        }
                    } else {
                        CampaignEx campaignEx = a2.get(0);
                        if (campaignEx != null) {
                            this.b = campaignEx.getRequestId();
                            com.mbridge.msdk.reward.b.a.g = campaignEx.getCurrentLRid();
                        }
                        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
                            z2 = true;
                        }
                        g();
                    }
                    intent.putExtra(MBRewardVideoActivity.INTENT_ISBIG_OFFER, z2);
                    if (this.y) {
                        intent.putExtra(MBRewardVideoActivity.INTENT_IVREWARD_MODETYPE, this.B);
                        intent.putExtra(MBRewardVideoActivity.INTENT_IVREWARD_VALUETYPE, this.C);
                        intent.putExtra(MBRewardVideoActivity.INTENT_IVREWARD_VALUE, this.D);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        intent.putExtra(MBRewardVideoActivity.INTENT_USERID, str2);
                    }
                    RewardUnitCacheManager.getInstance().add(this.n, this.m, this.v);
                    this.l.startActivity(intent);
                    return;
                }
            }
            h hVar3 = this.t;
            if (hVar3 != null) {
                hVar3.a("context or unitid is null");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            h hVar4 = this.t;
            if (hVar4 != null) {
                hVar4.a("show failed, exception is " + e2.getMessage());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007e A[Catch:{ Exception -> 0x009c }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g() {
        /*
            r4 = this;
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.d()
            android.content.Context r0 = r0.g()
            com.mbridge.msdk.foundation.db.b r0 = com.mbridge.msdk.foundation.db.b.a((android.content.Context) r0)
            java.lang.String r1 = r4.m
            java.lang.String r2 = r4.b
            java.util.List r0 = r0.b(r1, r2)
            if (r0 == 0) goto L_0x00a6
            int r1 = r0.size()
            java.lang.String r2 = r4.m
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.d.c(r2)
            if (r1 != 0) goto L_0x0023
            return
        L_0x0023:
            r3 = 1
            if (r1 != r3) goto L_0x0042
            r1 = 0
            java.lang.Object r3 = r0.get(r1)     // Catch:{ Exception -> 0x009c }
            if (r3 == 0) goto L_0x006d
            java.lang.Object r3 = r0.get(r1)     // Catch:{ Exception -> 0x009c }
            com.mbridge.msdk.foundation.entity.c r3 = (com.mbridge.msdk.foundation.entity.c) r3     // Catch:{ Exception -> 0x009c }
            java.lang.String r3 = r3.c()     // Catch:{ Exception -> 0x009c }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x009c }
            com.mbridge.msdk.foundation.entity.c r0 = (com.mbridge.msdk.foundation.entity.c) r0     // Catch:{ Exception -> 0x009c }
            java.lang.String r0 = r0.b()     // Catch:{ Exception -> 0x009c }
            goto L_0x0070
        L_0x0042:
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x009c }
            if (r1 != 0) goto L_0x006d
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x009c }
        L_0x004c:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x009c }
            if (r1 == 0) goto L_0x006d
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x009c }
            com.mbridge.msdk.foundation.entity.c r1 = (com.mbridge.msdk.foundation.entity.c) r1     // Catch:{ Exception -> 0x009c }
            if (r1 == 0) goto L_0x004c
            java.lang.String r3 = r1.a()     // Catch:{ Exception -> 0x009c }
            boolean r3 = r2.equals(r3)     // Catch:{ Exception -> 0x009c }
            if (r3 == 0) goto L_0x004c
            java.lang.String r3 = r1.c()     // Catch:{ Exception -> 0x009c }
            java.lang.String r0 = r1.b()     // Catch:{ Exception -> 0x009c }
            goto L_0x0070
        L_0x006d:
            java.lang.String r3 = ""
            r0 = r3
        L_0x0070:
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x009c }
            if (r1 != 0) goto L_0x00a6
            java.lang.String r1 = r4.b     // Catch:{ Exception -> 0x009c }
            boolean r1 = r3.equals(r1)     // Catch:{ Exception -> 0x009c }
            if (r1 == 0) goto L_0x00a6
            com.mbridge.msdk.foundation.controller.b r1 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x009c }
            android.content.Context r1 = r1.g()     // Catch:{ Exception -> 0x009c }
            com.mbridge.msdk.foundation.db.b r1 = com.mbridge.msdk.foundation.db.b.a((android.content.Context) r1)     // Catch:{ Exception -> 0x009c }
            java.lang.String r3 = r4.m     // Catch:{ Exception -> 0x009c }
            r1.a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x009c }
            java.lang.String r1 = r4.m     // Catch:{ Exception -> 0x009c }
            java.lang.String r2 = r4.b     // Catch:{ Exception -> 0x009c }
            com.mbridge.msdk.foundation.same.a.d.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x009c }
            java.lang.String r0 = r4.m     // Catch:{ Exception -> 0x009c }
            com.mbridge.msdk.foundation.same.a.d.b(r0)     // Catch:{ Exception -> 0x009c }
            goto L_0x00a6
        L_0x009c:
            r0 = move-exception
            java.lang.String r1 = "RewardMVVideoAdapter"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r1, (java.lang.String) r0)
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.g():void");
    }

    public final void d(boolean z2) {
        this.O = z2;
    }

    public final void a(int i2, int i3, boolean z2) {
        a(i2, i3, z2, "", this.H, (Map<String, String>) new HashMap());
    }

    public final void a(int i2, int i3, boolean z2, String str, boolean z3, Map<String, String> map) {
        boolean z4;
        CampaignEx campaignEx;
        this.p = i2;
        this.q = i3;
        this.r = z2;
        this.J = str;
        this.k = false;
        if (map != null && map.containsKey(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID)) {
            this.c = map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
        }
        this.H = z3;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.F;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0 && (campaignEx = this.F.get(0)) != null && TextUtils.isEmpty(campaignEx.getNLRid())) {
            this.F.clear();
        }
        List<CampaignEx> list = this.R;
        if (list != null) {
            list.clear();
        }
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = this.G;
        if (copyOnWriteArrayList2 != null) {
            copyOnWriteArrayList2.clear();
        }
        this.f = false;
        this.g = false;
        synchronized (this.d) {
            if (this.h) {
                this.h = false;
            }
        }
        this.j = false;
        this.i = false;
        try {
            z4 = com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.a(this.l);
        } catch (Exception unused) {
            z4 = false;
        }
        if (!z4) {
            a("WebView is not available", 0);
        } else if (this.l == null) {
            a("Context is null", 0);
        } else if (ak.a(this.m)) {
            a("UnitId is null", 0);
        } else if (this.v == null) {
            a("RewardUnitSetting is null", 0);
        } else {
            m();
            n();
            i();
            b(str, z3, map);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(34:20|(1:22)(1:23)|24|(1:26)(1:27)|28|(1:30)(1:31)|32|(1:34)|35|(1:37)(1:38)|39|(1:41)|42|43|(5:45|46|47|(3:49|50|(1:52)(1:53))|54)|55|(1:59)|60|(1:64)|65|(1:67)(1:68)|69|(1:71)|72|73|74|75|76|77|(1:79)(1:80)|81|(4:82|83|(1:85)(1:86)|87)|(1:95)(7:96|97|98|(1:100)|101|103|104)|(3:106|107|(4:109|(1:111)|112|124)(1:122))(1:121)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:76:0x023f */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0329 A[SYNTHETIC, Splitter:B:106:0x0329] */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x025c A[Catch:{ Exception -> 0x0367 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x025f A[Catch:{ Exception -> 0x0367 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x026c A[Catch:{ Exception -> 0x0276 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x026f A[Catch:{ Exception -> 0x0276 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0295 A[Catch:{ Exception -> 0x0367 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02dd A[Catch:{ Exception -> 0x0367 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r30, boolean r31, java.util.Map<java.lang.String, java.lang.String> r32) {
        /*
            r29 = this;
            r1 = r29
            r6 = r30
            r8 = r32
            java.lang.String r9 = "unit_id"
            java.lang.String r10 = "local_rid"
            java.lang.String r0 = "1"
            java.lang.String r2 = ""
            java.lang.String r3 = "isRewardVideoRefactorForCampaignRequest exception "
            r11 = 0
            android.content.Context r4 = r1.l     // Catch:{ Exception -> 0x0367 }
            if (r4 != 0) goto L_0x001c
            java.lang.String r0 = "Context is null"
            r1.a((java.lang.String) r0, (int) r11)     // Catch:{ Exception -> 0x0367 }
            return
        L_0x001c:
            java.lang.String r4 = r1.m     // Catch:{ Exception -> 0x0367 }
            boolean r4 = com.mbridge.msdk.foundation.tools.ak.a(r4)     // Catch:{ Exception -> 0x0367 }
            if (r4 == 0) goto L_0x002a
            java.lang.String r0 = "UnitId is null"
            r1.a((java.lang.String) r0, (int) r11)     // Catch:{ Exception -> 0x0367 }
            return
        L_0x002a:
            com.mbridge.msdk.videocommon.d.c r4 = r1.v     // Catch:{ Exception -> 0x0367 }
            if (r4 != 0) goto L_0x0034
            java.lang.String r0 = "RewardUnitSetting is null"
            r1.a((java.lang.String) r0, (int) r11)     // Catch:{ Exception -> 0x0367 }
            return
        L_0x0034:
            boolean r4 = android.text.TextUtils.isEmpty(r30)     // Catch:{ Exception -> 0x0367 }
            if (r4 == 0) goto L_0x0057
            com.mbridge.msdk.videocommon.d.c r4 = r1.v     // Catch:{ Exception -> 0x0367 }
            int r4 = r4.a()     // Catch:{ Exception -> 0x0367 }
            int r4 = r4 * 1000
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0367 }
            long r14 = r1.I     // Catch:{ Exception -> 0x0367 }
            long r12 = r12 - r14
            long r4 = (long) r4     // Catch:{ Exception -> 0x0367 }
            int r7 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r7 >= 0) goto L_0x0057
            java.lang.String r0 = "EXCEPTION_RETURN_EMPTY"
            r2 = 4
            r3 = 6001(0x1771, float:8.409E-42)
            r1.a((int) r3, (java.lang.String) r0, (int) r2)     // Catch:{ Exception -> 0x0367 }
            return
        L_0x0057:
            com.mbridge.msdk.foundation.controller.b r4 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0367 }
            java.lang.String r4 = r4.h()     // Catch:{ Exception -> 0x0367 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0367 }
            r5.<init>()     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.foundation.controller.b r7 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0367 }
            java.lang.String r7 = r7.h()     // Catch:{ Exception -> 0x0367 }
            r5.append(r7)     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.foundation.controller.b r7 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0367 }
            java.lang.String r7 = r7.j()     // Catch:{ Exception -> 0x0367 }
            r5.append(r7)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0367 }
            java.lang.String r5 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r5)     // Catch:{ Exception -> 0x0367 }
            boolean r7 = r1.r     // Catch:{ Exception -> 0x0367 }
            if (r7 == 0) goto L_0x0088
            r7 = 2
            goto L_0x0089
        L_0x0088:
            r7 = 3
        L_0x0089:
            com.mbridge.msdk.videocommon.d.c r12 = r1.v     // Catch:{ Exception -> 0x0367 }
            if (r12 == 0) goto L_0x0098
            int r12 = r12.t()     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.videocommon.d.c r13 = r1.v     // Catch:{ Exception -> 0x0367 }
            int r13 = r13.u()     // Catch:{ Exception -> 0x0367 }
            goto L_0x009a
        L_0x0098:
            r12 = 0
            r13 = 0
        L_0x009a:
            java.lang.String r14 = r1.s     // Catch:{ Exception -> 0x0367 }
            java.lang.String r15 = r1.m     // Catch:{ Exception -> 0x0367 }
            java.lang.String r11 = "reward"
            java.lang.String r11 = com.mbridge.msdk.foundation.same.a.d.a(r15, r11)     // Catch:{ Exception -> 0x0367 }
            int r15 = r29.j()     // Catch:{ Exception -> 0x0367 }
            r1.o = r15     // Catch:{ Exception -> 0x0367 }
            java.lang.String r15 = r29.l()     // Catch:{ Exception -> 0x0367 }
            r16 = r13
            int r13 = r1.p     // Catch:{ Exception -> 0x0367 }
            r17 = r3
            boolean r3 = r1.y     // Catch:{ Exception -> 0x0367 }
            r18 = 287(0x11f, float:4.02E-43)
            r19 = 94
            if (r3 == 0) goto L_0x00bf
            r3 = 287(0x11f, float:4.02E-43)
            goto L_0x00c1
        L_0x00bf:
            r3 = 94
        L_0x00c1:
            com.mbridge.msdk.foundation.same.net.h.d r8 = new com.mbridge.msdk.foundation.same.net.h.d     // Catch:{ Exception -> 0x0367 }
            r8.<init>()     // Catch:{ Exception -> 0x0367 }
            r20 = r10
            java.lang.String r10 = "app_id"
            com.mbridge.msdk.foundation.same.net.g.b.a(r8, r10, r4)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r4 = r1.m     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.foundation.same.net.g.b.a(r8, r9, r4)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r4 = r1.n     // Catch:{ Exception -> 0x0367 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0367 }
            if (r4 != 0) goto L_0x00e1
            java.lang.String r4 = com.mbridge.msdk.MBridgeConstans.PLACEMENT_ID     // Catch:{ Exception -> 0x0367 }
            java.lang.String r10 = r1.n     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.foundation.same.net.g.b.a(r8, r4, r10)     // Catch:{ Exception -> 0x0367 }
        L_0x00e1:
            java.lang.String r4 = "sign"
            com.mbridge.msdk.foundation.same.net.g.b.a(r8, r4, r5)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r4 = "req_type"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0367 }
            r5.<init>()     // Catch:{ Exception -> 0x0367 }
            r5.append(r7)     // Catch:{ Exception -> 0x0367 }
            r5.append(r2)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.foundation.same.net.g.b.a(r8, r4, r5)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r4 = "ad_num"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0367 }
            r5.<init>()     // Catch:{ Exception -> 0x0367 }
            r5.append(r12)     // Catch:{ Exception -> 0x0367 }
            r5.append(r2)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.foundation.same.net.g.b.a(r8, r4, r5)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r4 = "tnum"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0367 }
            r5.<init>()     // Catch:{ Exception -> 0x0367 }
            boolean r7 = r1.y     // Catch:{ Exception -> 0x0367 }
            if (r7 == 0) goto L_0x011c
            r7 = 1
            goto L_0x011e
        L_0x011c:
            r7 = r16
        L_0x011e:
            r5.append(r7)     // Catch:{ Exception -> 0x0367 }
            r5.append(r2)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.foundation.same.net.g.b.a(r8, r4, r5)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r4 = "only_impression"
            com.mbridge.msdk.foundation.same.net.g.b.a(r8, r4, r0)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r4 = "ping_mode"
            com.mbridge.msdk.foundation.same.net.g.b.a(r8, r4, r0)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r4 = com.mbridge.msdk.foundation.same.net.h.d.b     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.foundation.same.net.g.b.a(r8, r4, r11)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r4 = com.mbridge.msdk.foundation.same.net.h.d.c     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.foundation.same.net.g.b.a(r8, r4, r14)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r4 = "ad_source_id"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0367 }
            r5.<init>()     // Catch:{ Exception -> 0x0367 }
            r5.append(r13)     // Catch:{ Exception -> 0x0367 }
            r5.append(r2)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.foundation.same.net.g.b.a(r8, r4, r5)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r4 = com.mbridge.msdk.foundation.same.net.h.d.a     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.foundation.same.net.g.b.a(r8, r4, r15)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r4 = "ad_type"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0367 }
            r5.<init>()     // Catch:{ Exception -> 0x0367 }
            r5.append(r3)     // Catch:{ Exception -> 0x0367 }
            r5.append(r2)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.foundation.same.net.g.b.a(r8, r4, r3)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r3 = "offset"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0367 }
            r4.<init>()     // Catch:{ Exception -> 0x0367 }
            int r5 = r1.o     // Catch:{ Exception -> 0x0367 }
            r4.append(r5)     // Catch:{ Exception -> 0x0367 }
            r4.append(r2)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.foundation.same.net.g.b.a(r8, r3, r2)     // Catch:{ Exception -> 0x0367 }
            boolean r2 = android.text.TextUtils.isEmpty(r30)     // Catch:{ Exception -> 0x0367 }
            if (r2 != 0) goto L_0x018e
            java.lang.String r2 = "token"
            r8.a(r2, r6)     // Catch:{ Exception -> 0x0367 }
        L_0x018e:
            boolean r2 = r1.y     // Catch:{ Exception -> 0x0367 }
            java.lang.String r3 = "0"
            if (r2 == 0) goto L_0x01aa
            int r2 = r1.B     // Catch:{ Exception -> 0x0367 }
            int r4 = com.mbridge.msdk.foundation.same.a.p     // Catch:{ Exception -> 0x0367 }
            java.lang.String r5 = "ivrwd"
            if (r2 == r4) goto L_0x01a7
            int r2 = r1.B     // Catch:{ Exception -> 0x0367 }
            int r4 = com.mbridge.msdk.foundation.same.a.o     // Catch:{ Exception -> 0x0367 }
            if (r2 != r4) goto L_0x01a3
            goto L_0x01a7
        L_0x01a3:
            r8.a(r5, r3)     // Catch:{ Exception -> 0x0367 }
            goto L_0x01aa
        L_0x01a7:
            r8.a(r5, r0)     // Catch:{ Exception -> 0x0367 }
        L_0x01aa:
            com.mbridge.msdk.videocommon.d.b r2 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.foundation.controller.b r4 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0367 }
            java.lang.String r4 = r4.h()     // Catch:{ Exception -> 0x0367 }
            java.lang.String r5 = r1.m     // Catch:{ Exception -> 0x0367 }
            boolean r7 = r1.y     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.videocommon.d.c r2 = r2.a((java.lang.String) r4, (java.lang.String) r5, (boolean) r7)     // Catch:{ Exception -> 0x0367 }
            if (r2 == 0) goto L_0x01d4
            java.lang.String r4 = r2.k()     // Catch:{ Exception -> 0x0367 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0367 }
            if (r4 != 0) goto L_0x01d4
            java.lang.String r4 = "u_stid"
            java.lang.String r2 = r2.k()     // Catch:{ Exception -> 0x0367 }
            r8.a(r4, r2)     // Catch:{ Exception -> 0x0367 }
        L_0x01d4:
            com.mbridge.msdk.videocommon.d.b r2 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.videocommon.d.a r2 = r2.b()     // Catch:{ Exception -> 0x0367 }
            if (r2 == 0) goto L_0x01f1
            java.lang.String r4 = r2.b()     // Catch:{ Exception -> 0x0367 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0367 }
            if (r4 != 0) goto L_0x01f1
            java.lang.String r4 = "r_stid"
            java.lang.String r2 = r2.b()     // Catch:{ Exception -> 0x0367 }
            r8.a(r4, r2)     // Catch:{ Exception -> 0x0367 }
        L_0x01f1:
            java.lang.String r2 = "rw_plus"
            if (r31 == 0) goto L_0x01f6
            goto L_0x01f7
        L_0x01f6:
            r0 = r3
        L_0x01f7:
            r8.a(r2, r0)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r0 = r1.m     // Catch:{ Exception -> 0x0367 }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.af.h((java.lang.String) r0)     // Catch:{ Exception -> 0x0367 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0367 }
            if (r2 != 0) goto L_0x020b
            java.lang.String r2 = "j"
            r8.a(r2, r0)     // Catch:{ Exception -> 0x0367 }
        L_0x020b:
            r10 = r8
            r11 = r20
            r8 = r32
            java.lang.Object r0 = r8.get(r11)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0367 }
            r10.a(r11, r0)     // Catch:{ Exception -> 0x0367 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0367 }
            r1.P = r2     // Catch:{ Exception -> 0x0367 }
            r20 = 0
            android.content.Context r0 = r1.l     // Catch:{ Exception -> 0x023f }
            java.lang.String r22 = "start load offer from server"
            java.lang.String r2 = r1.m     // Catch:{ Exception -> 0x023f }
            boolean r3 = r1.z     // Catch:{ Exception -> 0x023f }
            java.lang.String r25 = ""
            java.lang.String r26 = ""
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x023f }
            long r12 = r1.P     // Catch:{ Exception -> 0x023f }
            long r27 = r4 - r12
            r21 = r0
            r23 = r2
            r24 = r3
            com.mbridge.msdk.reward.c.a.a(r20, r21, r22, r23, r24, r25, r26, r27)     // Catch:{ Exception -> 0x023f }
        L_0x023f:
            com.mbridge.msdk.reward.d.b r2 = new com.mbridge.msdk.reward.d.b     // Catch:{ Exception -> 0x0367 }
            android.content.Context r0 = r1.l     // Catch:{ Exception -> 0x0367 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.reward.adapter.c$2 r7 = new com.mbridge.msdk.reward.adapter.c$2     // Catch:{ Exception -> 0x0367 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0367 }
            r7.a((java.lang.String) r6)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r0 = r1.m     // Catch:{ Exception -> 0x0367 }
            r7.setUnitId(r0)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r0 = r1.n     // Catch:{ Exception -> 0x0367 }
            r7.setPlacementId(r0)     // Catch:{ Exception -> 0x0367 }
            boolean r0 = r1.y     // Catch:{ Exception -> 0x0367 }
            if (r0 == 0) goto L_0x025f
            r0 = 287(0x11f, float:4.02E-43)
            goto L_0x0261
        L_0x025f:
            r0 = 94
        L_0x0261:
            r7.setAdType(r0)     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.videocommon.download.l r0 = com.mbridge.msdk.videocommon.download.l.a()     // Catch:{ Exception -> 0x0276 }
            boolean r3 = r1.y     // Catch:{ Exception -> 0x0276 }
            if (r3 == 0) goto L_0x026f
            r3 = 287(0x11f, float:4.02E-43)
            goto L_0x0271
        L_0x026f:
            r3 = 94
        L_0x0271:
            boolean r0 = r0.b(r3)     // Catch:{ Exception -> 0x0276 }
            goto L_0x0293
        L_0x0276:
            r0 = move-exception
            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0367 }
            if (r3 == 0) goto L_0x0292
            java.lang.String r3 = "RewardMVVideoAdapter"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0367 }
            r5 = r17
            r4.<init>(r5)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0367 }
            r4.append(r0)     // Catch:{ Exception -> 0x0367 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.foundation.tools.aa.d(r3, r0)     // Catch:{ Exception -> 0x0367 }
        L_0x0292:
            r0 = 0
        L_0x0293:
            if (r0 == 0) goto L_0x02dd
            com.mbridge.msdk.videocommon.download.l r0 = com.mbridge.msdk.videocommon.download.l.a()     // Catch:{ Exception -> 0x0367 }
            java.lang.String r3 = "r_v_c_r_t_c"
            int r4 = com.mbridge.msdk.foundation.same.a.y     // Catch:{ Exception -> 0x0367 }
            int r17 = r0.a(r3, r4)     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.videocommon.download.l r0 = com.mbridge.msdk.videocommon.download.l.a()     // Catch:{ Exception -> 0x0367 }
            java.lang.String r3 = "r_v_c_r_t_r"
            int r4 = com.mbridge.msdk.foundation.same.a.z     // Catch:{ Exception -> 0x0367 }
            int r18 = r0.a(r3, r4)     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.videocommon.download.l r0 = com.mbridge.msdk.videocommon.download.l.a()     // Catch:{ Exception -> 0x0367 }
            java.lang.String r3 = "r_v_c_r_t_w"
            int r4 = com.mbridge.msdk.foundation.same.a.z     // Catch:{ Exception -> 0x0367 }
            int r19 = r0.a(r3, r4)     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.videocommon.download.l r0 = com.mbridge.msdk.videocommon.download.l.a()     // Catch:{ Exception -> 0x0367 }
            java.lang.String r3 = "r_v_c_r_r_c"
            int r4 = com.mbridge.msdk.foundation.same.a.B     // Catch:{ Exception -> 0x0367 }
            int r21 = r0.a(r3, r4)     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.foundation.same.net.b r0 = new com.mbridge.msdk.foundation.same.net.b     // Catch:{ Exception -> 0x0367 }
            int r3 = r1.q     // Catch:{ Exception -> 0x0367 }
            int r3 = r3 * 1000
            r22 = 4
            r16 = r0
            r20 = r3
            r16.<init>(r17, r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x0367 }
            r3 = 1
            r4 = r30
            r5 = r10
            r6 = r0
            r2.getCampaign(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0367 }
            goto L_0x0327
        L_0x02dd:
            int r0 = com.mbridge.msdk.foundation.same.a.z     // Catch:{ Exception -> 0x0367 }
            int r3 = com.mbridge.msdk.foundation.same.a.A     // Catch:{ Exception -> 0x0367 }
            int r4 = com.mbridge.msdk.foundation.same.a.x     // Catch:{ Exception -> 0x0367 }
            int r5 = com.mbridge.msdk.foundation.same.a.B     // Catch:{ Exception -> 0x0367 }
            com.mbridge.msdk.c.f r12 = com.mbridge.msdk.c.f.a()     // Catch:{ Exception -> 0x0307 }
            com.mbridge.msdk.foundation.controller.b r13 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0307 }
            java.lang.String r13 = r13.h()     // Catch:{ Exception -> 0x0307 }
            com.mbridge.msdk.c.e r12 = r12.g(r13)     // Catch:{ Exception -> 0x0307 }
            if (r12 == 0) goto L_0x0307
            int r0 = r12.A()     // Catch:{ Exception -> 0x0307 }
            int r3 = r12.B()     // Catch:{ Exception -> 0x0307 }
            int r4 = r12.C()     // Catch:{ Exception -> 0x0307 }
            int r5 = r12.D()     // Catch:{ Exception -> 0x0307 }
        L_0x0307:
            r18 = r0
            r19 = r3
            r17 = r4
            r21 = r5
            com.mbridge.msdk.foundation.same.net.b r0 = new com.mbridge.msdk.foundation.same.net.b     // Catch:{ Exception -> 0x0367 }
            int r3 = r1.q     // Catch:{ Exception -> 0x0367 }
            int r3 = r3 * 1000
            r22 = 4
            r16 = r0
            r20 = r3
            r16.<init>(r17, r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x0367 }
            r3 = 1
            r4 = r10
            r5 = r7
            r6 = r30
            r7 = r0
            r2.choiceV3OrV5BySetting(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0367 }
        L_0x0327:
            if (r8 == 0) goto L_0x0374
            com.mbridge.msdk.foundation.same.net.g.c r0 = com.mbridge.msdk.foundation.same.net.g.c.a()     // Catch:{ Exception -> 0x035e }
            com.mbridge.msdk.foundation.same.net.l r0 = r0.a((com.mbridge.msdk.foundation.same.net.h.d) r10)     // Catch:{ Exception -> 0x035e }
            if (r0 != 0) goto L_0x0374
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x035e }
            r0.<init>()     // Catch:{ Exception -> 0x035e }
            java.lang.String r2 = "auto_load"
            java.lang.String r3 = "isDev"
            java.lang.Object r3 = r8.get(r3)     // Catch:{ Exception -> 0x035e }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x035e }
            java.lang.Object r2 = r8.get(r11)     // Catch:{ Exception -> 0x035e }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x035e }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x035e }
            if (r3 == 0) goto L_0x0354
            java.lang.String r3 = r1.m     // Catch:{ Exception -> 0x035e }
            r0.put(r9, r3)     // Catch:{ Exception -> 0x035e }
        L_0x0354:
            com.mbridge.msdk.foundation.same.report.m r3 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x035e }
            java.lang.String r4 = "2000125"
            r3.a((java.lang.String) r4, (java.lang.String) r2, (java.util.Map<java.lang.String, java.lang.String>) r0)     // Catch:{ Exception -> 0x035e }
            goto L_0x0374
        L_0x035e:
            r0 = move-exception
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0367 }
            if (r2 == 0) goto L_0x0374
            r0.printStackTrace()     // Catch:{ Exception -> 0x0367 }
            goto L_0x0374
        L_0x0367:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.String r0 = "Load exception"
            r2 = 0
            r1.a((java.lang.String) r0, (int) r2)
            r29.k()
        L_0x0374:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.a(java.lang.String, boolean, java.util.Map):void");
    }

    private void h() {
        Handler handler = this.N;
        if (handler != null) {
            handler.sendEmptyMessage(3);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str, int i3) {
        if (this.N == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.N.sendEmptyMessage(4);
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.obj = str;
        obtain.arg1 = i2;
        obtain.arg2 = i3;
        if (str.contains("exception")) {
            this.N.sendMessageAtFrontOfQueue(obtain);
        } else {
            this.N.sendMessage(obtain);
        }
    }

    private void a(String str, int i2) {
        if (this.N == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.N.sendEmptyMessage(4);
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.obj = str;
        obtain.arg2 = i2;
        if (str.contains("exception")) {
            this.N.sendMessageAtFrontOfQueue(obtain);
        } else {
            this.N.sendMessage(obtain);
        }
    }

    private void a(String str, String str2, List<CampaignEx> list) {
        if (com.mbridge.msdk.videocommon.a.a.a() != null) {
            com.mbridge.msdk.videocommon.a.a.a().a(str, str2, list);
        }
    }

    private void i() {
        if (com.mbridge.msdk.videocommon.a.a.a() != null) {
            try {
                com.mbridge.msdk.c.e b2 = com.mbridge.msdk.c.f.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
                if (b2 == null) {
                    b2 = com.mbridge.msdk.c.f.a().b();
                }
                com.mbridge.msdk.videocommon.a.a.a().a(b2.Q() * 1000, this.m);
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void a(a aVar) {
        this.u = aVar;
    }

    public final void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, boolean z2, boolean z3) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = copyOnWriteArrayList;
        if (z3) {
            try {
                this.R = copyOnWriteArrayList2;
                this.G = new CopyOnWriteArrayList<>(copyOnWriteArrayList2);
            } catch (Exception unused) {
            }
        }
        CampaignEx campaignEx = this.E.getAds().get(0);
        Context context = this.l;
        StringBuilder sb = new StringBuilder("start download resource tpl ");
        sb.append(!TextUtils.isEmpty(this.E.getAds().get(0).getCMPTEntryUrl()));
        com.mbridge.msdk.reward.c.a.a(campaignEx, context, sb.toString(), this.m, this.z, "", "", System.currentTimeMillis() - this.P);
        a(this.E, (List<CampaignEx>) copyOnWriteArrayList2);
        if (copyOnWriteArrayList2 == null || copyOnWriteArrayList.size() <= 0) {
            aa.b("RewardMVVideoAdapter", "onload load fail, callback campaign have not video");
            if (TextUtils.isEmpty(this.Q)) {
                this.Q = "APP ALREADY INSTALLED";
            }
            a(this.E, this.Q);
            a(6003, this.Q, 4);
            return;
        }
        aa.b("RewardMVVideoAdapter", "onload load success size:" + copyOnWriteArrayList.size());
        if (z2) {
            h();
        }
        CampaignUnit campaignUnit = this.E;
        if (campaignUnit != null) {
            b(campaignUnit.getSessionId());
        }
        b((List<CampaignEx>) copyOnWriteArrayList);
        if (copyOnWriteArrayList2 != null && copyOnWriteArrayList.size() > 0) {
            a(this.n, this.m, (List<CampaignEx>) copyOnWriteArrayList2);
        }
        this.F = copyOnWriteArrayList2;
        a(copyOnWriteArrayList2.get(0));
    }

    private void a(CampaignEx campaignEx) {
        final CampaignEx campaignEx2 = campaignEx;
        final boolean z2 = !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl());
        final int nscpt = campaignEx.getNscpt();
        this.f = false;
        this.g = false;
        synchronized (this.d) {
            if (this.h) {
                this.h = false;
            }
        }
        this.j = false;
        this.i = false;
        if (this.z && campaignEx2 != null) {
            com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).a(campaignEx.getBidToken(), campaignEx.getCampaignUnitId(), campaignEx.getEncryptPrice());
        }
        b.m.a.a(this.l, z2, nscpt, this.z, this.y ? 287 : 94, this.n, this.m, campaignEx.getRequestId(), this.F, new b.c() {
            public final void a(String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
                final String str4 = str2;
                final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = copyOnWriteArrayList;
                c.this.f = true;
                if (copyOnWriteArrayList2 != null && copyOnWriteArrayList.size() > 0) {
                    try {
                        Context i = c.this.l;
                        com.mbridge.msdk.reward.c.a.a(copyOnWriteArrayList2.get(0), i, "resource download success is tpl :" + z2, c.this.m, c.this.z, str3, campaignEx2.getRequestIdNotice(), System.currentTimeMillis() - c.this.P);
                    } catch (Exception unused) {
                    }
                }
                if (!z2) {
                    Iterator<CampaignEx> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        final CampaignEx next = it.next();
                        if (next == null || next.getRewardTemplateMode() == null || TextUtils.isEmpty(next.getRewardTemplateMode().e()) || next.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY) || c.this.N == null) {
                            c cVar = c.this;
                            if (cVar.a((List<CampaignEx>) cVar.F, z2, nscpt)) {
                                c cVar2 = c.this;
                                c.a(cVar2, cVar2.m, (List) copyOnWriteArrayList2, c.this.S, c.this.z);
                                if (c.this.N != null) {
                                    c.this.N.removeMessages(5);
                                }
                                if (c.this.u != null && !c.this.i) {
                                    c.this.i = true;
                                    c.this.u.a((List<CampaignEx>) c.this.F);
                                }
                            } else {
                                c cVar3 = c.this;
                                c.a(cVar3, str4, cVar3.R, c.this.z);
                                if (c.this.N != null) {
                                    c.this.N.removeMessages(5);
                                }
                                if (c.this.u != null && !c.this.j) {
                                    c.this.j = true;
                                    com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e(15, "errorCode: 3503 errorMessage: have no temp but isReady false");
                                    if (!TextUtils.isEmpty(c.this.m) && c.this.F != null && c.this.F.size() > 0) {
                                        try {
                                            com.mbridge.msdk.reward.c.a.a((CampaignEx) c.this.F.get(0), c.this.l, eVar, c.this.m, c.this.z, str3, campaignEx2.getRequestIdNotice());
                                        } catch (Exception unused2) {
                                        }
                                    }
                                    c.this.u.a(c.this.F, eVar.e());
                                }
                            }
                        } else {
                            final String str5 = str;
                            final String str6 = str2;
                            final String str7 = str3;
                            final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList3 = copyOnWriteArrayList;
                            c.this.N.post(new Runnable() {
                                public final void run() {
                                    b a2 = b.m.a;
                                    boolean m = c.this.H;
                                    Handler g = c.this.N;
                                    boolean n = c.this.y;
                                    boolean f2 = c.this.z;
                                    String e2 = next.getRewardTemplateMode().e();
                                    int q = c.this.x;
                                    CampaignEx campaignEx = campaignEx2;
                                    CopyOnWriteArrayList c2 = c.this.F;
                                    String b2 = com.mbridge.msdk.videocommon.download.g.a().b(next.getRewardTemplateMode().e());
                                    String str = str5;
                                    String str2 = str6;
                                    String str3 = str7;
                                    String requestIdNotice = next.getRequestIdNotice();
                                    com.mbridge.msdk.videocommon.d.c r = c.this.v;
                                    AnonymousClass1 r17 = r6;
                                    AnonymousClass1 r6 = new b.j() {
                                        public final void a(String str, String str2, String str3, String str4, String str5, a.C0158a aVar) {
                                            try {
                                                Context i = c.this.l;
                                                com.mbridge.msdk.reward.c.a.a((CampaignEx) copyOnWriteArrayList3.get(0), i, "preload template success is tpl :" + z2, c.this.m, c.this.z, str7, campaignEx2.getRequestIdNotice(), System.currentTimeMillis() - c.this.P);
                                            } catch (Exception unused) {
                                            }
                                            if (c.this.a((List<CampaignEx>) c.this.F, z2, nscpt)) {
                                                c.a(c.this, c.this.m, (List) copyOnWriteArrayList3, c.this.S, c.this.z);
                                                if (c.this.N != null) {
                                                    c.this.N.removeMessages(5);
                                                }
                                                if (c.this.u != null && !c.this.i) {
                                                    c.this.i = true;
                                                    c.this.u.a((List<CampaignEx>) c.this.F);
                                                    return;
                                                }
                                                return;
                                            }
                                            c.a(c.this, str3, c.this.R, c.this.z);
                                            if (c.this.N != null) {
                                                c.this.N.removeMessages(5);
                                            }
                                            if (c.this.u != null && !c.this.j) {
                                                c.this.j = true;
                                                com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e(15, "errorCode: 3502 errorMessage: temp preload success but isReady false");
                                                if (!TextUtils.isEmpty(c.this.m) && c.this.F != null && c.this.F.size() > 0) {
                                                    try {
                                                        com.mbridge.msdk.reward.c.a.a((CampaignEx) c.this.F.get(0), c.this.l, eVar, c.this.m, c.this.z, str4, campaignEx2.getRequestIdNotice());
                                                    } catch (Exception unused2) {
                                                    }
                                                }
                                                c.this.u.a(c.this.F, eVar.e());
                                            }
                                        }

                                        public final void a(String str, String str2, String str3, String str4, String str5, a.C0158a aVar, com.mbridge.msdk.foundation.entity.e eVar) {
                                            try {
                                                Context i = c.this.l;
                                                com.mbridge.msdk.reward.c.a.a((CampaignEx) copyOnWriteArrayList3.get(0), i, "preload template failed is tpl :" + z2 + " ", c.this.m, c.this.z, str7, campaignEx2.getRequestIdNotice(), System.currentTimeMillis() - c.this.P);
                                            } catch (Exception unused) {
                                            }
                                            if (campaignEx2.getRsIgnoreCheckRule() == null || campaignEx2.getRsIgnoreCheckRule().size() <= 0 || !campaignEx2.getRsIgnoreCheckRule().contains(1)) {
                                                c.a(c.this, str3, c.this.R, c.this.z);
                                                if (c.this.N != null) {
                                                    c.this.N.removeMessages(5);
                                                }
                                                if (c.this.u != null && !c.this.j) {
                                                    c.this.j = true;
                                                    if (!TextUtils.isEmpty(c.this.m) && c.this.R != null && c.this.R.size() > 0) {
                                                        try {
                                                            try {
                                                                eVar.b("errorCode: 3301 errorMessage: temp preload failed: " + eVar.e());
                                                                com.mbridge.msdk.reward.c.a.a((CampaignEx) c.this.R.get(0), c.this.l, eVar, c.this.m, c.this.z, str4, campaignEx2.getRequestIdNotice());
                                                            } catch (Exception unused2) {
                                                            }
                                                        } catch (Exception unused3) {
                                                        }
                                                        c.this.u.a(c.this.R, eVar.e());
                                                        return;
                                                    }
                                                    com.mbridge.msdk.foundation.entity.e eVar2 = eVar;
                                                    c.this.u.a(c.this.R, eVar.e());
                                                    return;
                                                }
                                                return;
                                            }
                                            aa.b("RewardMVVideoAdapter", "template download fail but hit ignoreCheckRule");
                                        }
                                    };
                                    a2.a(m, g, n, f2, (WindVaneWebView) null, e2, q, campaignEx, c2, b2, str, str2, str3, requestIdNotice, r, r17);
                                }
                            });
                        }
                    }
                } else if (c.this.g && !c.this.h && c.this.N != null) {
                    synchronized (c.this.d) {
                        if (!c.this.h) {
                            c.this.h = true;
                            final String str8 = str3;
                            c.this.N.post(new Runnable() {
                                public final void run() {
                                    b a2 = b.m.a;
                                    boolean m = c.this.H;
                                    Handler g = c.this.N;
                                    boolean n = c.this.y;
                                    boolean f = c.this.z;
                                    String str = str8;
                                    String requestIdNotice = campaignEx2.getRequestIdNotice();
                                    String s = c.this.n;
                                    String str2 = str4;
                                    String cMPTEntryUrl = campaignEx2.getCMPTEntryUrl();
                                    int q = c.this.x;
                                    CampaignEx campaignEx = campaignEx2;
                                    CopyOnWriteArrayList c2 = c.this.F;
                                    String b2 = com.mbridge.msdk.videocommon.download.g.a().b(campaignEx2.getCMPTEntryUrl());
                                    String str3 = str4;
                                    b bVar = a2;
                                    com.mbridge.msdk.videocommon.d.c r = c.this.v;
                                    AnonymousClass1 r17 = r1;
                                    AnonymousClass1 r1 = new b.j() {
                                        public final void a(String str, String str2, String str3, String str4, String str5, a.C0158a aVar) {
                                            try {
                                                Context i = c.this.l;
                                                com.mbridge.msdk.reward.c.a.a((CampaignEx) copyOnWriteArrayList2.get(0), i, "preload template success is tpl :" + z2, c.this.m, c.this.z, str8, campaignEx2.getRequestIdNotice(), System.currentTimeMillis() - c.this.P);
                                            } catch (Exception unused) {
                                            }
                                            if (c.this.a((List<CampaignEx>) c.this.F, z2, nscpt)) {
                                                c.a(c.this, c.this.m, (List) copyOnWriteArrayList2, c.this.S, c.this.z);
                                                if (c.this.N != null) {
                                                    c.this.N.removeMessages(5);
                                                }
                                                if (c.this.u != null && !c.this.i) {
                                                    c.this.i = true;
                                                    c.this.u.a((List<CampaignEx>) c.this.F);
                                                    return;
                                                }
                                                return;
                                            }
                                            c.a(c.this, str3, c.this.R, c.this.z);
                                            if (c.this.N != null) {
                                                c.this.N.removeMessages(5);
                                            }
                                            if (c.this.u != null && !c.this.j) {
                                                c.this.j = true;
                                                com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e(15, "errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                                                if (!TextUtils.isEmpty(c.this.m) && c.this.R != null && c.this.R.size() > 0) {
                                                    try {
                                                        com.mbridge.msdk.reward.c.a.a((CampaignEx) c.this.R.get(0), c.this.l, eVar, c.this.m, c.this.z, str4, campaignEx2.getRequestIdNotice());
                                                    } catch (Exception unused2) {
                                                    }
                                                }
                                                c.this.u.a(c.this.R, eVar.e());
                                            }
                                        }

                                        public final void a(String str, String str2, String str3, String str4, String str5, a.C0158a aVar, com.mbridge.msdk.foundation.entity.e eVar) {
                                            try {
                                                Context i = c.this.l;
                                                com.mbridge.msdk.reward.c.a.a((CampaignEx) copyOnWriteArrayList2.get(0), i, "preload template failed is tpl :" + z2 + " " + eVar.e(), c.this.m, c.this.z, str8, campaignEx2.getRequestIdNotice(), System.currentTimeMillis() - c.this.P);
                                            } catch (Exception unused) {
                                            }
                                            if (campaignEx2.getRsIgnoreCheckRule() == null || campaignEx2.getRsIgnoreCheckRule().size() <= 0 || !campaignEx2.getRsIgnoreCheckRule().contains(3)) {
                                                c.a(c.this, str3, c.this.R, c.this.z);
                                                if (c.this.N != null) {
                                                    c.this.N.removeMessages(5);
                                                }
                                                if (c.this.u != null && !c.this.j) {
                                                    c.this.j = true;
                                                    if (c.this.R != null && c.this.R.size() > 0) {
                                                        try {
                                                            try {
                                                                eVar.b("errorCode: 3303 errorMessage: tpl temp preload failed: " + eVar.e());
                                                                com.mbridge.msdk.reward.c.a.a((CampaignEx) c.this.R.get(0), c.this.l, eVar, c.this.m, c.this.z, str4, campaignEx2.getRequestIdNotice());
                                                            } catch (Exception unused2) {
                                                            }
                                                        } catch (Exception unused3) {
                                                        }
                                                        c.this.u.a(c.this.R, eVar.e());
                                                        return;
                                                    }
                                                    com.mbridge.msdk.foundation.entity.e eVar2 = eVar;
                                                    c.this.u.a(c.this.R, eVar.e());
                                                    return;
                                                }
                                                return;
                                            }
                                            aa.b("RewardMVVideoAdapter", "template download fail but hit ignoreCheckRule");
                                        }
                                    };
                                    bVar.a(m, g, n, f, str, requestIdNotice, s, str2, cMPTEntryUrl, q, campaignEx, c2, b2, str3, r, r17, false);
                                }
                            });
                        }
                    }
                }
            }

            public final void a(String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.foundation.entity.e eVar) {
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = copyOnWriteArrayList;
                c.this.f = false;
                if (copyOnWriteArrayList2 != null && copyOnWriteArrayList.size() > 0) {
                    try {
                        Context i = c.this.l;
                        com.mbridge.msdk.reward.c.a.a(copyOnWriteArrayList2.get(0), i, "resource download failed:  is tpl: " + z2, c.this.m, c.this.z, str3, campaignEx2.getRequestIdNotice(), System.currentTimeMillis() - c.this.P);
                    } catch (Exception unused) {
                    }
                }
                if (c.this.u != null && c.this.N != null) {
                    final String str4 = str2;
                    final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList3 = copyOnWriteArrayList;
                    final com.mbridge.msdk.foundation.entity.e eVar2 = eVar;
                    final String str5 = str3;
                    c.this.N.post(new Runnable() {
                        public final void run() {
                            CopyOnWriteArrayList copyOnWriteArrayList;
                            c.a(c.this, str4, c.this.R, c.this.z);
                            if (c.this.N != null) {
                                c.this.N.removeMessages(5);
                            }
                            if (!c.this.j && c.this.u != null) {
                                c.this.j = true;
                                if (!TextUtils.isEmpty(c.this.m) && (copyOnWriteArrayList = copyOnWriteArrayList3) != null && copyOnWriteArrayList.size() > 0) {
                                    try {
                                        eVar2.b("errorCode: 3201 errorMessage: campaign resource download failed");
                                        com.mbridge.msdk.reward.c.a.a((CampaignEx) copyOnWriteArrayList3.get(0), c.this.l, eVar2, c.this.m, c.this.z, str5, campaignEx2.getRequestIdNotice());
                                    } catch (Exception unused) {
                                    }
                                }
                                c.this.u.a(copyOnWriteArrayList3, eVar2.e());
                            }
                        }
                    });
                }
            }
        }, new b.i() {
            public final void a(String str, String str2, String str3, String str4) {
            }

            public final void a(String str, final String str2, final String str3, String str4, final com.mbridge.msdk.foundation.entity.e eVar) {
                if (z2 || c.this.u == null || c.this.N == null) {
                    if (nscpt == 1) {
                        if (campaignEx2.getRsIgnoreCheckRule() != null && campaignEx2.getRsIgnoreCheckRule().size() > 0) {
                            if (campaignEx2.getRsIgnoreCheckRule().contains(3)) {
                                aa.b("RewardMVVideoAdapter", "tpl download fail but hit ignoreCheckRule");
                                return;
                            } else if (campaignEx2.getCMPTEntryUrl().equals(campaignEx2.getendcard_url()) && campaignEx2.getRsIgnoreCheckRule().contains(2)) {
                                aa.b("RewardMVVideoAdapter", "endcard download fail but hit ignoreCheckRule at 3203");
                                return;
                            }
                        }
                        if (c.this.u != null && c.this.N != null) {
                            c.this.N.post(new Runnable() {
                                public final void run() {
                                    c.a(c.this, str2, c.this.R, c.this.z);
                                    if (c.this.N != null) {
                                        c.this.N.removeMessages(5);
                                    }
                                    if (!c.this.j && c.this.u != null) {
                                        c.this.j = true;
                                        if (c.this.R != null && c.this.R.size() > 0) {
                                            eVar.b("errorCode: 3203 errorMessage: tpl temp resource download failed");
                                            com.mbridge.msdk.reward.c.a.a((CampaignEx) c.this.R.get(0), c.this.l, eVar, c.this.m, c.this.z, str3, campaignEx2.getRequestIdNotice());
                                        }
                                        c.this.u.a(c.this.R, eVar.e());
                                    }
                                }
                            });
                        }
                    }
                } else if (campaignEx2.getRsIgnoreCheckRule() == null || campaignEx2.getRsIgnoreCheckRule().size() <= 0 || !campaignEx2.getRsIgnoreCheckRule().contains(1)) {
                    c.this.N.post(new Runnable() {
                        public final void run() {
                            c.a(c.this, str2, c.this.R, c.this.z);
                            if (c.this.N != null) {
                                c.this.N.removeMessages(5);
                            }
                            if (!c.this.j && c.this.u != null) {
                                c.this.j = true;
                                if (c.this.R != null && c.this.R.size() > 0) {
                                    eVar.b("errorCode: 3202 errorMessage: temp resource download failed");
                                    com.mbridge.msdk.reward.c.a.a((CampaignEx) c.this.R.get(0), c.this.l, eVar, c.this.m, c.this.z, str3, campaignEx2.getRequestIdNotice());
                                }
                                c.this.u.a(c.this.R, eVar.e());
                            }
                        }
                    });
                } else {
                    aa.b("RewardMVVideoAdapter", "template download fail but hit ignoreCheckRule");
                }
            }
        });
        if (z2) {
            b.m.a.a(this.l, campaignEx, this.n, this.m, campaignEx.getRequestId(), new b.i() {
                public final void a(final String str, final String str2, final String str3, String str4) {
                    try {
                        CampaignEx campaignEx = campaignEx2;
                        Context i = c.this.l;
                        com.mbridge.msdk.reward.c.a.a(campaignEx, i, "resource download success is tpl :" + z2, c.this.m, c.this.z, str3, campaignEx2.getRequestIdNotice(), System.currentTimeMillis() - c.this.P);
                    } catch (Exception unused) {
                    }
                    c.this.g = true;
                    if (c.this.f && !c.this.h && c.this.N != null) {
                        synchronized (c.this.d) {
                            if (!c.this.h) {
                                c.this.h = true;
                                c.this.N.post(new Runnable() {
                                    public final void run() {
                                        b a2 = b.m.a;
                                        boolean m = c.this.H;
                                        Handler g = c.this.N;
                                        boolean n = c.this.y;
                                        boolean f = c.this.z;
                                        String str = str3;
                                        String requestIdNotice = campaignEx2.getRequestIdNotice();
                                        String str2 = str;
                                        String str3 = str2;
                                        String cMPTEntryUrl = campaignEx2.getCMPTEntryUrl();
                                        int q = c.this.x;
                                        CampaignEx campaignEx = campaignEx2;
                                        CopyOnWriteArrayList c2 = c.this.F;
                                        String b2 = com.mbridge.msdk.videocommon.download.g.a().b(campaignEx2.getCMPTEntryUrl());
                                        String str4 = str2;
                                        b bVar = a2;
                                        com.mbridge.msdk.videocommon.d.c r = c.this.v;
                                        AnonymousClass1 r17 = r1;
                                        AnonymousClass1 r1 = new b.j() {
                                            public final void a(String str, String str2, String str3, String str4, String str5, a.C0158a aVar) {
                                                try {
                                                    CampaignEx campaignEx = campaignEx2;
                                                    Context i = c.this.l;
                                                    com.mbridge.msdk.reward.c.a.a(campaignEx, i, "preload template success is tpl :" + z2, c.this.m, c.this.z, str3, campaignEx2.getRequestIdNotice(), System.currentTimeMillis() - c.this.P);
                                                } catch (Exception unused) {
                                                }
                                                if (c.this.a((List<CampaignEx>) c.this.F, z2, nscpt)) {
                                                    c.a(c.this, c.this.m, c.this.R, c.this.S, c.this.z);
                                                    if (c.this.N != null) {
                                                        c.this.N.removeMessages(5);
                                                    }
                                                    if (c.this.u != null && !c.this.i) {
                                                        c.this.i = true;
                                                        c.this.u.a((List<CampaignEx>) c.this.F);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                c.a(c.this, str3, c.this.R, c.this.z);
                                                if (c.this.N != null) {
                                                    c.this.N.removeMessages(5);
                                                }
                                                if (c.this.u != null && !c.this.j) {
                                                    c.this.j = true;
                                                    com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e(8, "errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                                                    if (c.this.R != null && c.this.R.size() > 0) {
                                                        try {
                                                            com.mbridge.msdk.reward.c.a.a((CampaignEx) c.this.R.get(0), c.this.l, eVar, c.this.m, c.this.z, str4, campaignEx2.getRequestIdNotice());
                                                        } catch (Exception unused2) {
                                                        }
                                                    }
                                                    c.this.u.a(c.this.R, eVar.e());
                                                }
                                            }

                                            public final void a(String str, String str2, String str3, String str4, String str5, a.C0158a aVar, com.mbridge.msdk.foundation.entity.e eVar) {
                                                String str6 = str3;
                                                c.a(c.this, str3, c.this.R, c.this.z);
                                                try {
                                                    CampaignEx campaignEx = campaignEx2;
                                                    Context i = c.this.l;
                                                    com.mbridge.msdk.reward.c.a.a(campaignEx, i, "preload template failed is tpl :" + z2 + " " + eVar.e(), c.this.m, c.this.z, str3, campaignEx2.getRequestIdNotice(), System.currentTimeMillis() - c.this.P);
                                                } catch (Exception unused) {
                                                }
                                                if (c.this.N != null) {
                                                    c.this.N.removeMessages(5);
                                                }
                                                if (c.this.u != null && !c.this.j) {
                                                    c.this.j = true;
                                                    if (c.this.R == null || c.this.R.size() <= 0) {
                                                        com.mbridge.msdk.foundation.entity.e eVar2 = eVar;
                                                    } else {
                                                        eVar.b("errorCode: 3303 errorMessage: tpl temp preload failed: " + eVar.e());
                                                        com.mbridge.msdk.reward.c.a.a((CampaignEx) c.this.R.get(0), c.this.l, eVar, c.this.m, c.this.z, str4, campaignEx2.getRequestIdNotice());
                                                    }
                                                    c.this.u.a(c.this.R, eVar.e());
                                                }
                                            }
                                        };
                                        bVar.a(m, g, n, f, str, requestIdNotice, str2, str3, cMPTEntryUrl, q, campaignEx, c2, b2, str4, r, r17, false);
                                    }
                                });
                            }
                        }
                    }
                }

                public final void a(String str, String str2, String str3, String str4, com.mbridge.msdk.foundation.entity.e eVar) {
                    if (campaignEx2.getRsIgnoreCheckRule() != null && campaignEx2.getRsIgnoreCheckRule().size() > 0) {
                        if (campaignEx2.getRsIgnoreCheckRule().contains(3)) {
                            aa.b("RewardMVVideoAdapter", "tpl download fail but hit ignoreCheckRule");
                            return;
                        } else if (campaignEx2.getCMPTEntryUrl().equals(campaignEx2.getendcard_url()) && campaignEx2.getRsIgnoreCheckRule().contains(2)) {
                            aa.b("RewardMVVideoAdapter", "endcard download fail but hit ignoreCheckRule at 3203");
                            return;
                        }
                    }
                    c cVar = c.this;
                    c.a(cVar, str2, cVar.R, c.this.z);
                    c.this.g = false;
                    if (c.this.R.get(0) != null && c.this.R.size() > 0) {
                        try {
                            Context i = c.this.l;
                            com.mbridge.msdk.reward.c.a.a((CampaignEx) c.this.R.get(0), i, "resource download failed: " + eVar.e() + " is tpl: " + z2, c.this.m, c.this.z, str3, ((CampaignEx) c.this.R.get(0)).getRequestIdNotice(), System.currentTimeMillis() - c.this.P);
                        } catch (Exception unused) {
                        }
                    }
                    if (c.this.N != null) {
                        c.this.N.removeMessages(5);
                    }
                    if (c.this.u != null && !c.this.j) {
                        c.this.j = true;
                        if (c.this.R != null && c.this.R.size() > 0) {
                            eVar.b("errorCode: 3203 errorMessage: tpl temp resource download failed");
                            com.mbridge.msdk.reward.c.a.a((CampaignEx) c.this.R.get(0), c.this.l, eVar, c.this.m, c.this.z, str3, campaignEx2.getRequestIdNotice());
                        }
                        c.this.u.a(c.this.R, eVar.e());
                    }
                }
            });
        }
    }

    private void a(CampaignUnit campaignUnit, String str) {
        ArrayList<CampaignEx> ads;
        int i2;
        if (campaignUnit != null && (ads = campaignUnit.getAds()) != null && ads.size() != 0) {
            try {
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
                }
                CampaignEx campaignEx = ads.get(0);
                if (!(campaignEx == null || campaignEx.getRewardTemplateMode() == null)) {
                    if (!TextUtils.isEmpty(campaignEx.getMof_template_url())) {
                        i2 = af.l(campaignEx.getMof_template_url());
                    } else {
                        i2 = af.l(campaignEx.getRewardTemplateMode().e());
                    }
                    if (i2 != 0) {
                        hashMap.put(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW, i2 + "");
                    }
                }
                if (ads.size() > 1) {
                    m.a().b("m_campaign_filtered", this.c, hashMap);
                } else {
                    m.a().a("m_campaign_filtered", this.c, (Map<String, String>) hashMap);
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void e(boolean z2) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList;
        if (!z2 && (copyOnWriteArrayList = this.F) != null && copyOnWriteArrayList.size() > 0) {
            com.mbridge.msdk.videocommon.a.a.a().a(this.m, (List<CampaignEx>) this.F);
        }
    }

    public final void f(boolean z2) {
        if (z2) {
            List<CampaignEx> list = this.S;
            if (list != null && list.size() > 0) {
                for (CampaignEx next : this.S) {
                    if (next != null) {
                        next.setLoadTimeoutState(0);
                        if (next.getRewardTemplateMode() != null && !TextUtils.isEmpty(next.getRewardTemplateMode().e())) {
                            i a2 = i.a();
                            a2.d(this.m + "_" + next.getRequestId() + "_" + next.getRewardTemplateMode().e(), false);
                        }
                    }
                }
                com.mbridge.msdk.videocommon.a.a.a().a(this.m, this.S, "load_timeout", 0);
                return;
            }
            return;
        }
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.F;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<CampaignEx> it = this.F.iterator();
            while (it.hasNext()) {
                CampaignEx next2 = it.next();
                if (next2 != null) {
                    next2.setLoadTimeoutState(0);
                    if (next2.getRewardTemplateMode() != null && !TextUtils.isEmpty(next2.getRewardTemplateMode().e())) {
                        i a3 = i.a();
                        a3.d(this.m + "_" + next2.getRequestId() + "_" + next2.getRewardTemplateMode().e(), false);
                    }
                }
            }
            com.mbridge.msdk.videocommon.a.a.a().a(this.m, (List<CampaignEx>) this.F, "load_timeout", 0);
        }
    }

    public final boolean g(boolean z2) {
        if (z2) {
            List<CampaignEx> list = this.S;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (CampaignEx next : this.S) {
                if (next != null) {
                    next.setLoadTimeoutState(1);
                    if (next.getRewardTemplateMode() != null && !TextUtils.isEmpty(next.getRewardTemplateMode().e())) {
                        i a2 = i.a();
                        a2.d(this.m + "_" + next.getRequestId() + "_" + next.getRewardTemplateMode().e(), true);
                    }
                }
            }
            com.mbridge.msdk.videocommon.a.a.a().a(this.m, this.S, "load_timeout", 1);
            return true;
        }
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.F;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return false;
        }
        Iterator<CampaignEx> it = this.F.iterator();
        while (it.hasNext()) {
            CampaignEx next2 = it.next();
            if (next2 != null) {
                next2.setLoadTimeoutState(1);
                if (next2.getRewardTemplateMode() != null && !TextUtils.isEmpty(next2.getRewardTemplateMode().e())) {
                    i a3 = i.a();
                    a3.d(this.m + "_" + next2.getRequestId() + "_" + next2.getRewardTemplateMode().e(), true);
                }
            }
        }
        com.mbridge.msdk.videocommon.a.a.a().a(this.m, (List<CampaignEx>) this.F, "load_timeout", 1);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037 A[Catch:{ Exception -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004b A[Catch:{ Exception -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0067 A[Catch:{ Exception -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009d A[Catch:{ Exception -> 0x00c4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r11, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r12, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r13) {
        /*
            r10 = this;
            java.lang.String r0 = ""
            if (r12 == 0) goto L_0x002e
            int r1 = r12.size()     // Catch:{ Exception -> 0x00c4 }
            if (r1 <= 0) goto L_0x002e
            r1 = 0
            java.lang.Object r1 = r12.get(r1)     // Catch:{ Exception -> 0x00c4 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = (com.mbridge.msdk.foundation.entity.CampaignEx) r1     // Catch:{ Exception -> 0x00c4 }
            if (r1 == 0) goto L_0x002e
            java.lang.String r2 = r1.getRequestId()     // Catch:{ Exception -> 0x00c4 }
            int r3 = r1.getVcn()     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r4 = r1.getBidToken()     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r5 = r1.getNLRid()     // Catch:{ Exception -> 0x00c4 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x00c4 }
            if (r5 == 0) goto L_0x0031
            java.lang.String r0 = r1.getLocalRequestId()     // Catch:{ Exception -> 0x00c4 }
            goto L_0x0031
        L_0x002e:
            r3 = 1
            r2 = r0
            r4 = r2
        L_0x0031:
            com.mbridge.msdk.videocommon.a.a r1 = com.mbridge.msdk.videocommon.a.a.a()     // Catch:{ Exception -> 0x00c4 }
            if (r1 == 0) goto L_0x0045
            com.mbridge.msdk.videocommon.a.a r1 = com.mbridge.msdk.videocommon.a.a.a()     // Catch:{ Exception -> 0x00c4 }
            r1.b((java.lang.String) r11, (java.lang.String) r0)     // Catch:{ Exception -> 0x00c4 }
            com.mbridge.msdk.videocommon.a.a r0 = com.mbridge.msdk.videocommon.a.a.a()     // Catch:{ Exception -> 0x00c4 }
            r0.b(r11)     // Catch:{ Exception -> 0x00c4 }
        L_0x0045:
            com.mbridge.msdk.videocommon.a.a r0 = com.mbridge.msdk.videocommon.a.a.a()     // Catch:{ Exception -> 0x00c4 }
            if (r0 == 0) goto L_0x0052
            com.mbridge.msdk.videocommon.a.a r0 = com.mbridge.msdk.videocommon.a.a.a()     // Catch:{ Exception -> 0x00c4 }
            r0.b((java.lang.String) r11, (int) r3)     // Catch:{ Exception -> 0x00c4 }
        L_0x0052:
            if (r12 == 0) goto L_0x008b
            int r0 = r12.size()     // Catch:{ Exception -> 0x00c4 }
            if (r0 <= 0) goto L_0x008b
            com.mbridge.msdk.reward.b.a.a((java.lang.String) r2, (java.lang.String) r4)     // Catch:{ Exception -> 0x00c4 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ Exception -> 0x00c4 }
        L_0x0061:
            boolean r0 = r12.hasNext()     // Catch:{ Exception -> 0x00c4 }
            if (r0 == 0) goto L_0x008b
            java.lang.Object r0 = r12.next()     // Catch:{ Exception -> 0x00c4 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ Exception -> 0x00c4 }
            if (r0 == 0) goto L_0x0061
            java.lang.String r1 = r0.getCampaignUnitId()     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r2 = r0.getRequestId()     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r3 = r0.getId()     // Catch:{ Exception -> 0x00c4 }
            long r4 = r0.getPlct()     // Catch:{ Exception -> 0x00c4 }
            long r6 = r0.getPlctb()     // Catch:{ Exception -> 0x00c4 }
            long r8 = r0.getTimestamp()     // Catch:{ Exception -> 0x00c4 }
            com.mbridge.msdk.foundation.same.a.d.a(r1, r2, r3, r4, r6, r8)     // Catch:{ Exception -> 0x00c4 }
            goto L_0x0061
        L_0x008b:
            if (r13 == 0) goto L_0x00b1
            int r12 = r13.size()     // Catch:{ Exception -> 0x00c4 }
            if (r12 <= 0) goto L_0x00b1
            java.util.Iterator r12 = r13.iterator()     // Catch:{ Exception -> 0x00c4 }
        L_0x0097:
            boolean r13 = r12.hasNext()     // Catch:{ Exception -> 0x00c4 }
            if (r13 == 0) goto L_0x00b1
            java.lang.Object r13 = r12.next()     // Catch:{ Exception -> 0x00c4 }
            com.mbridge.msdk.foundation.entity.CampaignEx r13 = (com.mbridge.msdk.foundation.entity.CampaignEx) r13     // Catch:{ Exception -> 0x00c4 }
            if (r13 == 0) goto L_0x0097
            java.lang.String r0 = r13.getCampaignUnitId()     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r13 = r13.getRequestId()     // Catch:{ Exception -> 0x00c4 }
            com.mbridge.msdk.foundation.same.a.d.b(r0, r13)     // Catch:{ Exception -> 0x00c4 }
            goto L_0x0097
        L_0x00b1:
            com.mbridge.msdk.foundation.same.a.d.b(r11)     // Catch:{ Exception -> 0x00c4 }
            com.mbridge.msdk.foundation.controller.b r11 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x00c4 }
            android.content.Context r11 = r11.g()     // Catch:{ Exception -> 0x00c4 }
            com.mbridge.msdk.foundation.db.b r11 = com.mbridge.msdk.foundation.db.b.a((android.content.Context) r11)     // Catch:{ Exception -> 0x00c4 }
            r11.a()     // Catch:{ Exception -> 0x00c4 }
            goto L_0x00cc
        L_0x00c4:
            r11 = move-exception
            boolean r12 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r12 == 0) goto L_0x00cc
            r11.printStackTrace()
        L_0x00cc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.a(java.lang.String, java.util.List, java.util.List):void");
    }

    private void b(CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.videocommon.a.a a2 = com.mbridge.msdk.videocommon.a.a.a();
            if (a2 != null) {
                a2.a(campaignEx);
            }
        } catch (Throwable th) {
            aa.b("RewardMVVideoAdapter", th.getMessage(), th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01c4, code lost:
        if (r1 != null) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01d0, code lost:
        if (r1 != null) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0188, code lost:
        if (com.mbridge.msdk.foundation.tools.ak.a(r4.getVideoUrlEncode()) != false) goto L_0x018a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01bc A[Catch:{ Exception -> 0x01cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01d6 A[SYNTHETIC, Splitter:B:114:0x01d6] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x012e A[SYNTHETIC, Splitter:B:64:0x012e] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0156 A[Catch:{ Exception -> 0x01cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x018f A[Catch:{ Exception -> 0x01cc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> a(com.mbridge.msdk.foundation.entity.CampaignUnit r12) {
        /*
            r11 = this;
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            r0.<init>()
            r1 = 0
            com.mbridge.msdk.videocommon.d.c r2 = r11.v     // Catch:{ Exception -> 0x01cc }
            if (r2 == 0) goto L_0x000d
            r2.u()     // Catch:{ Exception -> 0x01cc }
        L_0x000d:
            if (r12 == 0) goto L_0x01c4
            java.util.ArrayList r2 = r12.getAds()     // Catch:{ Exception -> 0x01cc }
            if (r2 == 0) goto L_0x01c4
            java.util.ArrayList r2 = r12.getAds()     // Catch:{ Exception -> 0x01cc }
            int r2 = r2.size()     // Catch:{ Exception -> 0x01cc }
            if (r2 <= 0) goto L_0x01c4
            java.util.ArrayList r2 = r12.getAds()     // Catch:{ Exception -> 0x01cc }
            r11.R = r2     // Catch:{ Exception -> 0x01cc }
            r3 = 0
            if (r12 == 0) goto L_0x0054
            java.util.ArrayList r4 = r12.getAds()     // Catch:{ Exception -> 0x01cc }
            if (r4 == 0) goto L_0x0054
            java.util.ArrayList r4 = r12.getAds()     // Catch:{ Exception -> 0x01cc }
            int r4 = r4.size()     // Catch:{ Exception -> 0x01cc }
            if (r4 <= 0) goto L_0x0054
            java.util.ArrayList r12 = r12.getAds()     // Catch:{ Exception -> 0x01cc }
            r4 = 0
        L_0x003d:
            int r5 = r12.size()     // Catch:{ Exception -> 0x01cc }
            if (r4 >= r5) goto L_0x0054
            java.lang.Object r5 = r12.get(r4)     // Catch:{ Exception -> 0x01cc }
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = (com.mbridge.msdk.foundation.entity.CampaignEx) r5     // Catch:{ Exception -> 0x01cc }
            java.lang.String r6 = r11.m     // Catch:{ Exception -> 0x01cc }
            r5.setCampaignUnitId(r6)     // Catch:{ Exception -> 0x01cc }
            r12.set(r4, r5)     // Catch:{ Exception -> 0x01cc }
            int r4 = r4 + 1
            goto L_0x003d
        L_0x0054:
            r12 = 0
        L_0x0055:
            int r4 = r2.size()     // Catch:{ Exception -> 0x01cc }
            if (r12 >= r4) goto L_0x01c4
            r4 = 2147483647(0x7fffffff, float:NaN)
            if (r12 >= r4) goto L_0x01c4
            java.lang.Object r4 = r2.get(r12)     // Catch:{ Exception -> 0x01cc }
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = (com.mbridge.msdk.foundation.entity.CampaignEx) r4     // Catch:{ Exception -> 0x01cc }
            boolean r5 = r4.isMraid()     // Catch:{ Exception -> 0x01cc }
            if (r5 == 0) goto L_0x015a
            java.lang.String r5 = r4.getMraid()     // Catch:{ Exception -> 0x01cc }
            java.lang.String r5 = r5.trim()     // Catch:{ Exception -> 0x01cc }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01cc }
            if (r5 != 0) goto L_0x01c0
            int r5 = r4.getAdType()     // Catch:{ Exception -> 0x01cc }
            r6 = 287(0x11f, float:4.02E-43)
            java.lang.String r7 = ""
            if (r5 != r6) goto L_0x0087
            java.lang.String r5 = "3"
            goto L_0x009e
        L_0x0087:
            int r5 = r4.getAdType()     // Catch:{ Exception -> 0x01cc }
            r6 = 94
            if (r5 != r6) goto L_0x0092
            java.lang.String r5 = "1"
            goto L_0x009e
        L_0x0092:
            int r5 = r4.getAdType()     // Catch:{ Exception -> 0x01cc }
            r6 = 42
            if (r5 != r6) goto L_0x009d
            java.lang.String r5 = "2"
            goto L_0x009e
        L_0x009d:
            r5 = r7
        L_0x009e:
            com.mbridge.msdk.foundation.same.b.c r6 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML     // Catch:{ Exception -> 0x011c }
            java.lang.String r6 = com.mbridge.msdk.foundation.same.b.e.b(r6)     // Catch:{ Exception -> 0x011c }
            java.lang.String r8 = r4.getMraid()     // Catch:{ Exception -> 0x011c }
            java.lang.String r8 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r8)     // Catch:{ Exception -> 0x011c }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x011c }
            if (r9 == 0) goto L_0x00ba
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x011c }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x011c }
        L_0x00ba:
            java.lang.String r9 = ".html"
            java.lang.String r8 = r8.concat(r9)     // Catch:{ Exception -> 0x011c }
            java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x011c }
            r9.<init>(r6, r8)     // Catch:{ Exception -> 0x011c }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x011c }
            r6.<init>(r9)     // Catch:{ Exception -> 0x011c }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
            r1.<init>()     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
            java.lang.String r8 = "<script>"
            r1.append(r8)     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
            com.mbridge.msdk.c.b.a r8 = com.mbridge.msdk.c.b.a.a()     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
            java.lang.String r8 = r8.b()     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
            r1.append(r8)     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
            java.lang.String r8 = "</script>"
            r1.append(r8)     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
            java.lang.String r8 = r4.getMraid()     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
            r1.append(r8)     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
            byte[] r1 = r1.getBytes()     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
            r6.write(r1)     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
            r6.flush()     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
            java.lang.String r1 = r9.getAbsolutePath()     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
            r4.setMraid(r1)     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
            java.lang.String r1 = r11.m     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
            com.mbridge.msdk.foundation.same.report.n.a(r4, r7, r1, r5)     // Catch:{ Exception -> 0x0115, all -> 0x0112 }
            r6.close()     // Catch:{ Exception -> 0x010e, all -> 0x010a }
            r1 = r6
            goto L_0x0131
        L_0x010a:
            r12 = move-exception
            r1 = r6
            goto L_0x01d4
        L_0x010e:
            r12 = move-exception
            r1 = r6
            goto L_0x01cd
        L_0x0112:
            r12 = move-exception
            r1 = r6
            goto L_0x0154
        L_0x0115:
            r1 = move-exception
            r10 = r6
            r6 = r1
            r1 = r10
            goto L_0x011d
        L_0x011a:
            r12 = move-exception
            goto L_0x0154
        L_0x011c:
            r6 = move-exception
        L_0x011d:
            r6.printStackTrace()     // Catch:{ all -> 0x011a }
            r4.setMraid(r7)     // Catch:{ all -> 0x011a }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x011a }
            java.lang.String r7 = r11.m     // Catch:{ all -> 0x011a }
            com.mbridge.msdk.foundation.same.report.n.a(r4, r6, r7, r5)     // Catch:{ all -> 0x011a }
            if (r1 == 0) goto L_0x0131
            r1.close()     // Catch:{ Exception -> 0x01cc }
        L_0x0131:
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x01cc }
            java.lang.String r6 = r4.getMraid()     // Catch:{ Exception -> 0x01cc }
            r5.<init>(r6)     // Catch:{ Exception -> 0x01cc }
            boolean r6 = r5.exists()     // Catch:{ Exception -> 0x01cc }
            if (r6 == 0) goto L_0x014c
            boolean r6 = r5.isFile()     // Catch:{ Exception -> 0x01cc }
            if (r6 == 0) goto L_0x014c
            boolean r5 = r5.canRead()     // Catch:{ Exception -> 0x01cc }
            if (r5 != 0) goto L_0x015a
        L_0x014c:
            java.lang.String r4 = "mraid resource write fail"
            r5 = 3
            r11.a((java.lang.String) r4, (int) r5)     // Catch:{ Exception -> 0x01cc }
            goto L_0x01c0
        L_0x0154:
            if (r1 == 0) goto L_0x0159
            r1.close()     // Catch:{ Exception -> 0x01cc }
        L_0x0159:
            throw r12     // Catch:{ Exception -> 0x01cc }
        L_0x015a:
            if (r4 == 0) goto L_0x01c0
            int r5 = r4.getOfferType()     // Catch:{ Exception -> 0x01cc }
            r6 = 99
            if (r5 == r6) goto L_0x01c0
            boolean r5 = r11.c((com.mbridge.msdk.foundation.entity.CampaignEx) r4)     // Catch:{ Exception -> 0x01cc }
            r6 = 1
            if (r5 == 0) goto L_0x0180
            java.lang.String r5 = r4.getendcard_url()     // Catch:{ Exception -> 0x01cc }
            boolean r5 = com.mbridge.msdk.foundation.tools.ak.a(r5)     // Catch:{ Exception -> 0x01cc }
            if (r5 == 0) goto L_0x018c
            java.lang.String r5 = r4.getMraid()     // Catch:{ Exception -> 0x01cc }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01cc }
            if (r5 == 0) goto L_0x018c
            goto L_0x018a
        L_0x0180:
            java.lang.String r5 = r4.getVideoUrlEncode()     // Catch:{ Exception -> 0x01cc }
            boolean r5 = com.mbridge.msdk.foundation.tools.ak.a(r5)     // Catch:{ Exception -> 0x01cc }
            if (r5 == 0) goto L_0x018c
        L_0x018a:
            r5 = 0
            goto L_0x018d
        L_0x018c:
            r5 = 1
        L_0x018d:
            if (r5 == 0) goto L_0x01bc
            int r5 = r4.getWtick()     // Catch:{ Exception -> 0x01cc }
            if (r5 == r6) goto L_0x01b8
            android.content.Context r5 = r11.l     // Catch:{ Exception -> 0x01cc }
            java.lang.String r6 = r4.getPackageName()     // Catch:{ Exception -> 0x01cc }
            boolean r5 = com.mbridge.msdk.foundation.tools.af.c((android.content.Context) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x01cc }
            if (r5 != 0) goto L_0x01a2
            goto L_0x01b8
        L_0x01a2:
            boolean r5 = com.mbridge.msdk.foundation.tools.af.b((com.mbridge.msdk.foundation.entity.CampaignEx) r4)     // Catch:{ Exception -> 0x01cc }
            if (r5 == 0) goto L_0x01ac
            r0.add(r4)     // Catch:{ Exception -> 0x01cc }
            goto L_0x01c0
        L_0x01ac:
            java.lang.String r5 = r11.m     // Catch:{ Exception -> 0x01cc }
            int r6 = com.mbridge.msdk.foundation.same.a.w     // Catch:{ Exception -> 0x01cc }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r5, (com.mbridge.msdk.foundation.entity.CampaignEx) r4, (int) r6)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r4 = "APP ALREADY INSTALLED"
            r11.Q = r4     // Catch:{ Exception -> 0x01cc }
            goto L_0x01c0
        L_0x01b8:
            r0.add(r4)     // Catch:{ Exception -> 0x01cc }
            goto L_0x01c0
        L_0x01bc:
            java.lang.String r4 = "No video campaign"
            r11.Q = r4     // Catch:{ Exception -> 0x01cc }
        L_0x01c0:
            int r12 = r12 + 1
            goto L_0x0055
        L_0x01c4:
            if (r1 == 0) goto L_0x01d3
        L_0x01c6:
            r1.close()     // Catch:{ IOException -> 0x01d3 }
            goto L_0x01d3
        L_0x01ca:
            r12 = move-exception
            goto L_0x01d4
        L_0x01cc:
            r12 = move-exception
        L_0x01cd:
            r12.printStackTrace()     // Catch:{ all -> 0x01ca }
            if (r1 == 0) goto L_0x01d3
            goto L_0x01c6
        L_0x01d3:
            return r0
        L_0x01d4:
            if (r1 == 0) goto L_0x01d9
            r1.close()     // Catch:{ IOException -> 0x01d9 }
        L_0x01d9:
            goto L_0x01db
        L_0x01da:
            throw r12
        L_0x01db:
            goto L_0x01da
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.a(com.mbridge.msdk.foundation.entity.CampaignUnit):java.util.concurrent.CopyOnWriteArrayList");
    }

    private void a(final CampaignUnit campaignUnit, List<CampaignEx> list) {
        com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() {
            public final void run() {
                k.a((com.mbridge.msdk.foundation.db.g) com.mbridge.msdk.foundation.db.h.a(c.this.l)).b();
                CampaignUnit campaignUnit = campaignUnit;
                if (campaignUnit != null && campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0) {
                    c.a(c.this, (List) campaignUnit.getAds());
                }
            }
        });
    }

    private void b(List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    this.o += list.size();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        com.mbridge.msdk.videocommon.d.c cVar = this.v;
        if (cVar == null || this.o > cVar.v()) {
            this.o = 0;
        }
        if (ak.b(this.m)) {
            com.mbridge.msdk.reward.b.a.a(this.m, this.o);
        }
    }

    private int j() {
        try {
            int a2 = ak.b(this.m) ? com.mbridge.msdk.reward.b.a.a(this.m) : 0;
            com.mbridge.msdk.videocommon.d.c cVar = this.v;
            if (cVar == null || a2 > cVar.v()) {
                return 0;
            }
            return a2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        try {
            if (ak.b(this.m)) {
                com.mbridge.msdk.reward.b.a.a(this.m, 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String l() {
        try {
            if (ak.b(com.mbridge.msdk.reward.b.a.f)) {
                return com.mbridge.msdk.reward.b.a.f;
            }
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private void b(String str) {
        if (ak.b(str)) {
            com.mbridge.msdk.reward.b.a.f = str;
        }
    }

    private void m() {
        try {
            if (com.mbridge.msdk.foundation.same.a.d.a != null && com.mbridge.msdk.foundation.same.a.d.a.size() > 0) {
                com.mbridge.msdk.foundation.same.a.d.a.clear();
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    private void n() {
        try {
            com.mbridge.msdk.foundation.db.j.a((com.mbridge.msdk.foundation.db.g) com.mbridge.msdk.foundation.db.h.a(this.l)).a(this.m);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    private boolean c(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return false;
        }
        try {
            if (campaignEx.getPlayable_ads_without_video() == 2) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    public final void a(List<CampaignEx> list) {
        this.S = list;
    }

    public final CopyOnWriteArrayList<CampaignEx> e() {
        return this.F;
    }

    public final CopyOnWriteArrayList<CampaignEx> f() {
        return this.G;
    }

    public final void a(int i2, int i3, int i4) {
        this.B = i2;
        this.C = i3;
        this.D = i4;
    }

    public final void a(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            String str = map.get("bid_token");
            if (this.v != null && TextUtils.isEmpty(str)) {
                int b2 = this.v.b() * 1000;
                List<CampaignEx> list = this.S;
                if (list != null && list.size() > 0) {
                    if (System.currentTimeMillis() - this.S.get(0).getTimestamp() < ((long) b2)) {
                        a("hit ltorwc", 0);
                        return;
                    }
                }
            }
            a(str, this.H, map);
        }
    }

    /* compiled from: RewardMVVideoAdapter */
    public class e implements Runnable {
        private String b;
        private Map<String, String> c;

        public e(String str, Map<String, String> map) {
            this.b = str;
            this.c = map;
            map.put("bid_token", str);
        }

        public final void run() {
            try {
                c cVar = c.this;
                String unused = cVar.s = af.b(cVar.l, c.this.m);
                if (!c.this.M) {
                    if (!(c.this.K == null || c.this.N == null)) {
                        c.this.N.removeCallbacks(c.this.K);
                    }
                    boolean unused2 = c.this.L = true;
                    if (c.this.N != null) {
                        Message obtainMessage = c.this.N.obtainMessage();
                        obtainMessage.obj = this.c;
                        obtainMessage.what = 1;
                        c.this.N.sendMessage(obtainMessage);
                    }
                    if (!TextUtils.isEmpty(c.this.s)) {
                        aa.d("RewardMVVideoAdapter", "excludeId : " + c.this.s);
                    }
                }
            } catch (Exception e) {
                aa.d("RewardMVVideoAdapter", e.getMessage());
            }
        }
    }

    /* compiled from: RewardMVVideoAdapter */
    public class d implements Runnable {
        private String b;
        private Map<String, String> c;

        public d(String str, Map<String, String> map) {
            this.b = str;
            this.c = map;
        }

        public final void run() {
            try {
                if (!c.this.L) {
                    boolean unused = c.this.M = true;
                    if (c.this.N != null) {
                        Message obtainMessage = c.this.N.obtainMessage();
                        obtainMessage.obj = this.b;
                        obtainMessage.what = 2;
                        c.this.N.sendMessage(obtainMessage);
                    }
                }
            } catch (Exception e) {
                aa.d("RewardMVVideoAdapter", e.getMessage());
            }
        }
    }

    private void b(String str, boolean z2, Map<String, String> map) {
        com.mbridge.msdk.foundation.same.f.b.g().execute(new e(str, map));
        if (this.N != null) {
            d dVar = new d(str, map);
            this.K = dVar;
            this.N.postDelayed(dVar, 90000);
            return;
        }
        a(str, z2, map);
    }

    static /* synthetic */ void a(c cVar, String str, List list, List list2, boolean z2) {
        com.mbridge.msdk.foundation.db.f.a((com.mbridge.msdk.foundation.db.g) com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g())).a(str, (List<CampaignEx>) list, (List<CampaignEx>) list2, z2);
        if (list2 != null && list2.size() > 0) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                CampaignEx campaignEx = (CampaignEx) it.next();
                if (campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                    com.mbridge.msdk.videocommon.a.b(str + "_" + campaignEx.getId() + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e());
                    com.mbridge.msdk.videocommon.a.b(campaignEx.getAdType(), campaignEx);
                }
            }
        }
        if (z2) {
            cVar.a(str, (List<CampaignEx>) list, (List<CampaignEx>) list2);
        }
        if (list != null && list.size() > 0) {
            try {
                CampaignEx campaignEx2 = (CampaignEx) list.get(0);
                com.mbridge.msdk.reward.a.a aVar = new com.mbridge.msdk.reward.a.a(str, cVar.y);
                if (campaignEx2 != null && TextUtils.isEmpty(campaignEx2.getNLRid())) {
                    aVar.a(campaignEx2.getLocalRequestId(), campaignEx2.getRequestId(), 1, campaignEx2.getEcppv());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    static /* synthetic */ void a(c cVar, String str, List list, boolean z2) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
            com.mbridge.msdk.foundation.db.f.a((com.mbridge.msdk.foundation.db.g) com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g())).a(str, (List<CampaignEx>) list, z2);
        }
    }

    static /* synthetic */ void a(c cVar, WindVaneWebView windVaneWebView, String str, CampaignEx campaignEx, List list, String str2, String str3, com.mbridge.msdk.videocommon.d.c cVar2, String str4) {
        j jVar;
        c cVar3 = cVar;
        CampaignEx campaignEx2 = campaignEx;
        List list2 = list;
        try {
            a.C0158a aVar = new a.C0158a();
            WindVaneWebView windVaneWebView2 = new WindVaneWebView(com.mbridge.msdk.foundation.controller.b.d().g());
            aVar.a(windVaneWebView2);
            if (list2 == null || list.size() <= 0) {
                jVar = new j((Activity) null, campaignEx2);
            } else {
                jVar = new j((Activity) null, campaignEx2, list2);
            }
            j jVar2 = jVar;
            jVar2.a(cVar3.x);
            jVar2.a(str3);
            jVar2.a(cVar2);
            jVar2.d(cVar3.H);
            C0151c cVar4 = r1;
            C0151c cVar5 = new C0151c(windVaneWebView, str3, campaignEx, list, str2, str3, cVar2, cVar3.x, cVar);
            windVaneWebView2.setWebViewListener(new f(windVaneWebView, str, str3, aVar, campaignEx, cVar, cVar4, cVar3.N));
            windVaneWebView2.setObject(jVar2);
            windVaneWebView2.loadUrl(str2);
            cVar3.N.postDelayed(cVar4, 5000);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            aa.a("RewardMVVideoAdapter", th.getMessage());
        }
    }

    static /* synthetic */ void a(c cVar, String str, CampaignEx campaignEx, String str2, String str3, com.mbridge.msdk.videocommon.d.c cVar2) {
        j jVar;
        c cVar3 = cVar;
        CampaignEx campaignEx2 = campaignEx;
        try {
            a.C0158a aVar = new a.C0158a();
            WindVaneWebView windVaneWebView = new WindVaneWebView(com.mbridge.msdk.foundation.controller.b.d().g());
            aVar.a(windVaneWebView);
            String b2 = com.mbridge.msdk.video.bt.a.c.a().b();
            aVar.a(b2);
            CampaignUnit campaignUnit = cVar3.E;
            if (campaignUnit == null || campaignUnit.getAds() == null || cVar3.E.getAds().size() <= 0) {
                jVar = new j((Activity) null, campaignEx2);
            } else {
                jVar = new j((Activity) null, campaignEx2, cVar3.E.getAds());
            }
            j jVar2 = jVar;
            jVar2.a(cVar3.x);
            jVar2.a(str3);
            jVar2.c(b2);
            jVar2.a(cVar2);
            jVar2.d(cVar3.H);
            b bVar = new b(str3, campaignEx, str2, str3, cVar2, cVar3.x, cVar);
            windVaneWebView.setWebViewListener(new a(str, str3, aVar, campaignEx, cVar, bVar, cVar3.N));
            windVaneWebView.setObject(jVar2);
            windVaneWebView.loadUrl(str2);
            cVar3.N.postDelayed(bVar, 5000);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            aa.a("RewardMVVideoAdapter", th.getMessage());
        }
    }

    static /* synthetic */ void a(c cVar, String str, String str2) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList;
        try {
            if (cVar.w != null && !TextUtils.isEmpty(str2)) {
                Iterator<CampaignEx> it = cVar.w.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CampaignEx next = it.next();
                    if (next != null) {
                        String videoUrlEncode = next.getVideoUrlEncode();
                        if (!TextUtils.isEmpty(videoUrlEncode) && str2.equals(videoUrlEncode)) {
                            cVar.w.remove(next);
                            cVar.b(next);
                            break;
                        }
                        String str3 = next.getendcard_url();
                        if (!TextUtils.isEmpty(str3) && str2.equals(str3)) {
                            cVar.w.remove(next);
                            cVar.b(next);
                            break;
                        }
                        CampaignEx.c rewardTemplateMode = next.getRewardTemplateMode();
                        if (rewardTemplateMode != null) {
                            List<CampaignEx.c.a> f2 = rewardTemplateMode.f();
                            if (f2 != null) {
                                Iterator<CampaignEx.c.a> it2 = f2.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        CampaignEx.c.a next2 = it2.next();
                                        if (next2 != null && next2.b != null && next2.b.contains(str2)) {
                                            cVar.w.remove(next);
                                            cVar.b(next);
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                            String e2 = rewardTemplateMode.e();
                            if (!TextUtils.isEmpty(e2) && str2.equals(e2)) {
                                cVar.w.remove(next);
                                cVar.b(next);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                if (cVar.u != null && (copyOnWriteArrayList = cVar.w) != null && copyOnWriteArrayList.size() == 0) {
                    Handler handler = cVar.N;
                    if (handler != null) {
                        handler.removeMessages(5);
                    }
                    cVar.a(str, 1);
                    cVar.u.a(cVar.w, str);
                }
            } else if (cVar.u != null) {
                Handler handler2 = cVar.N;
                if (handler2 != null) {
                    handler2.removeMessages(5);
                }
                cVar.a(str, 1);
                cVar.u.a(cVar.w, str);
            }
        } catch (Throwable th) {
            aa.b("RewardMVVideoAdapter", th.getMessage(), th);
        }
    }

    static /* synthetic */ void a(c cVar, Map map, CampaignUnit campaignUnit, boolean z2, int i2, int i3, String str) {
        String str2;
        String str3;
        if (map != null) {
            try {
                str3 = (String) map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                str2 = (String) map.get("isDev");
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                    return;
                }
                return;
            }
        } else {
            str2 = "";
            str3 = str2;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("timeout", cVar.q + "");
        hashMap.put("auto_load", str2);
        if (z2) {
            hashMap.put(IronSourceConstants.EVENTS_RESULT, "1");
            if (campaignUnit != null && campaignUnit.getAds() != null) {
                campaignUnit.setLocalRequestId(str3);
                m.a().a("2000126", (List<CampaignEx>) campaignUnit.getAds(), (Map<String, String>) hashMap);
            }
        } else if (i3 == 1 || i3 == 2) {
            if (!(i2 == 3 || i2 == 14)) {
                switch (i2) {
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        break;
                    default:
                        hashMap.put(IronSourceConstants.EVENTS_RESULT, "1");
                        break;
                }
            }
            hashMap.put(IronSourceConstants.EVENTS_RESULT, "2");
            if (TextUtils.isEmpty(str3)) {
                hashMap.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            }
            hashMap.put("bid_tk", cVar.J);
            m.a().a("2000126", str3, (Map<String, String>) hashMap);
        }
    }

    static /* synthetic */ void a(c cVar, CampaignUnit campaignUnit) {
        cVar.E = campaignUnit;
        CopyOnWriteArrayList<CampaignEx> a2 = cVar.a(campaignUnit);
        new com.mbridge.msdk.reward.a.a(cVar.m, cVar.y).a((List<CampaignEx>) a2, cVar.J, cVar, cVar.m);
        cVar.a(a2, true, false);
    }

    static /* synthetic */ void a(c cVar, List list) {
        if (cVar.l != null && list != null && list.size() != 0) {
            k a2 = k.a((com.mbridge.msdk.foundation.db.g) com.mbridge.msdk.foundation.db.h.a(cVar.l));
            for (int i2 = 0; i2 < list.size(); i2++) {
                CampaignEx campaignEx = (CampaignEx) list.get(i2);
                if (!(campaignEx == null || a2 == null || a2.a(campaignEx.getId()))) {
                    com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
                    gVar.a(campaignEx.getId());
                    gVar.a(campaignEx.getFca());
                    gVar.b(campaignEx.getFcb());
                    gVar.d(0);
                    gVar.c(0);
                    gVar.a(System.currentTimeMillis());
                    a2.a(gVar);
                }
            }
        }
    }
}
