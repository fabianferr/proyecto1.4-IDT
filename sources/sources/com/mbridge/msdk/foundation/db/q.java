package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ak;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.net.URLEncoder;

/* compiled from: VideoReportDataDao */
public class q extends a<n> {
    private static final String a = "com.mbridge.msdk.foundation.db.q";
    private static q b;

    private q(g gVar) {
        super(gVar);
    }

    public static synchronized q a(g gVar) {
        q qVar;
        synchronized (q.class) {
            if (b == null) {
                b = new q(gVar);
            }
            qVar = b;
        }
        return qVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:120|121|(2:123|124)|125|126) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:125:0x0358 */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x034d A[SYNTHETIC, Splitter:B:118:0x034d] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0355 A[SYNTHETIC, Splitter:B:123:0x0355] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<com.mbridge.msdk.foundation.entity.n> a(java.lang.String r26) {
        /*
            r25 = this;
            r0 = r26
            monitor-enter(r25)
            boolean r1 = android.text.TextUtils.isEmpty(r26)     // Catch:{ all -> 0x035c }
            if (r1 != 0) goto L_0x0359
            android.database.sqlite.SQLiteDatabase r2 = r25.getReadableDatabase()     // Catch:{ Exception -> 0x033d, all -> 0x033a }
            java.lang.String r3 = "reward_report"
            r4 = 0
            java.lang.String r5 = "key=?"
            r11 = 1
            java.lang.String[] r6 = new java.lang.String[r11]     // Catch:{ Exception -> 0x033d, all -> 0x033a }
            r12 = 0
            r6[r12] = r0     // Catch:{ Exception -> 0x033d, all -> 0x033a }
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r13 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x033d, all -> 0x033a }
            if (r13 == 0) goto L_0x0333
            int r1 = r13.getCount()     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            if (r1 <= 0) goto L_0x0333
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            r14.<init>()     // Catch:{ Exception -> 0x0330, all -> 0x032c }
        L_0x002c:
            boolean r1 = r13.moveToNext()     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            if (r1 == 0) goto L_0x0323
            java.lang.String r1 = "key"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r3 = r13.getString(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r1 = "networkType"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            int r4 = r13.getInt(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r1 = "network_str"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r7 = r13.getString(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r1 = "isCompleteView"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            r13.getInt(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r1 = "watchedMillis"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            r13.getInt(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r1 = "videoLength"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            int r18 = r13.getInt(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r1 = "offerUrl"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r5 = r13.getString(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r1 = "reason"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r8 = r13.getString(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r1 = "result"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            int r6 = r13.getInt(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r1 = "duration"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r21 = r13.getString(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r1 = "videoSize"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            int r22 = r13.getInt(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r1 = "campaignId"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r9 = r13.getString(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r1 = "video_url"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r1 = r13.getString(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r2 = "unitId"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r15 = r13.getString(r2)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r2 = "rid"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r10 = "rid_n"
            int r10 = r13.getColumnIndex(r10)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r10 = r13.getString(r10)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r12 = "ad_type"
            int r12 = r13.getColumnIndex(r12)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r12 = r13.getString(r12)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r11 = "resource_type"
            int r11 = r13.getColumnIndex(r11)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r11 = r13.getString(r11)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            r16 = r2
            java.lang.String r2 = "device_id"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            r17 = r2
            java.lang.String r2 = "creative"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            r19 = r2
            java.lang.String r2 = "adspace_t"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            int r2 = r13.getInt(r2)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            r20 = r2
            java.lang.String r2 = "2000021"
            boolean r2 = r0.equals(r2)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            if (r2 == 0) goto L_0x0137
            com.mbridge.msdk.foundation.entity.n r11 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ Exception -> 0x0134 }
            r12 = r16
            r2 = r11
            r6 = r8
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0134 }
            r11.r(r9)     // Catch:{ Exception -> 0x0134 }
            r11.e((java.lang.String) r1)     // Catch:{ Exception -> 0x0134 }
            r11.n(r12)     // Catch:{ Exception -> 0x0134 }
            r11.p(r10)     // Catch:{ Exception -> 0x0134 }
            r11.q(r15)     // Catch:{ Exception -> 0x0134 }
            r7 = r13
            r24 = r14
            goto L_0x02da
        L_0x0134:
            r0 = move-exception
            goto L_0x033f
        L_0x0137:
            r2 = r16
            r16 = r15
            java.lang.String r15 = "2000022"
            boolean r15 = r0.equals(r15)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            if (r15 == 0) goto L_0x016d
            com.mbridge.msdk.foundation.entity.n r11 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ Exception -> 0x0134 }
            r24 = r14
            r14 = r16
            r15 = r11
            r16 = r3
            r17 = r4
            r19 = r5
            r20 = r6
            r23 = r7
            r15.<init>((java.lang.String) r16, (int) r17, (int) r18, (java.lang.String) r19, (int) r20, (java.lang.String) r21, (int) r22, (java.lang.String) r23)     // Catch:{ Exception -> 0x0134 }
            r11.r(r9)     // Catch:{ Exception -> 0x0134 }
            r11.e((java.lang.String) r1)     // Catch:{ Exception -> 0x0134 }
            r11.n(r2)     // Catch:{ Exception -> 0x0134 }
            r11.p(r10)     // Catch:{ Exception -> 0x0134 }
            r11.q(r14)     // Catch:{ Exception -> 0x0134 }
            r11.t(r8)     // Catch:{ Exception -> 0x0134 }
            r11.h((java.lang.String) r12)     // Catch:{ Exception -> 0x0134 }
            goto L_0x0189
        L_0x016d:
            r24 = r14
            r14 = r16
            java.lang.String r1 = "2000025"
            boolean r1 = r0.equals(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            if (r1 == 0) goto L_0x018c
            com.mbridge.msdk.foundation.entity.n r11 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ Exception -> 0x0134 }
            r15 = r11
            r16 = r3
            r17 = r4
            r19 = r5
            r20 = r6
            r23 = r7
            r15.<init>((java.lang.String) r16, (int) r17, (int) r18, (java.lang.String) r19, (int) r20, (java.lang.String) r21, (int) r22, (java.lang.String) r23)     // Catch:{ Exception -> 0x0134 }
        L_0x0189:
            r7 = r13
            goto L_0x02da
        L_0x018c:
            java.lang.String r1 = "2000024"
            boolean r1 = r0.equals(r1)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            if (r1 == 0) goto L_0x019c
            com.mbridge.msdk.foundation.entity.n r11 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ Exception -> 0x0134 }
            r2 = r11
            r6 = r8
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0134 }
            goto L_0x0189
        L_0x019c:
            java.lang.String r1 = "2000039"
            boolean r1 = r1.equals(r0)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            if (r1 == 0) goto L_0x01b4
            java.lang.String r1 = "h5_click_data"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0134 }
            java.lang.String r1 = r13.getString(r1)     // Catch:{ Exception -> 0x0134 }
            com.mbridge.msdk.foundation.entity.n r11 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ Exception -> 0x0134 }
            r11.<init>(r1)     // Catch:{ Exception -> 0x0134 }
            goto L_0x0189
        L_0x01b4:
            java.lang.String r1 = "2000043"
            boolean r1 = r1.equals(r0)     // Catch:{ Exception -> 0x0330, all -> 0x032c }
            if (r1 == 0) goto L_0x022e
            java.lang.String r1 = "type"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0229, all -> 0x0222 }
            java.lang.String r15 = r13.getString(r1)     // Catch:{ Exception -> 0x0229, all -> 0x0222 }
            java.lang.String r1 = "endcard_url"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0229, all -> 0x0222 }
            java.lang.String r5 = r13.getString(r1)     // Catch:{ Exception -> 0x0229, all -> 0x0222 }
            com.mbridge.msdk.foundation.entity.n r7 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ Exception -> 0x0229, all -> 0x0222 }
            r1 = r7
            r4 = r2
            r16 = r13
            r3 = r17
            r13 = r19
            r0 = r20
            r2 = r26
            r13 = r3
            r3 = r6
            r6 = r4
            r4 = r21
            r17 = r13
            r13 = r6
            r6 = r9
            r18 = r11
            r11 = r7
            r7 = r14
            r14 = r9
            r9 = r15
            r1.<init>((java.lang.String) r2, (int) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9)     // Catch:{ Exception -> 0x021d, all -> 0x021b }
            r11.n(r13)     // Catch:{ Exception -> 0x021d, all -> 0x021b }
            r11.p(r10)     // Catch:{ Exception -> 0x021d, all -> 0x021b }
            boolean r1 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x021d, all -> 0x021b }
            if (r1 != 0) goto L_0x0200
            r11.r(r14)     // Catch:{ Exception -> 0x021d, all -> 0x021b }
        L_0x0200:
            r11.c((int) r0)     // Catch:{ Exception -> 0x021d, all -> 0x021b }
            r11.h((java.lang.String) r12)     // Catch:{ Exception -> 0x021d, all -> 0x021b }
            r1 = r18
            r11.a((java.lang.String) r1)     // Catch:{ Exception -> 0x021d, all -> 0x021b }
            r2 = r17
            r11.b((java.lang.String) r2)     // Catch:{ Exception -> 0x021d, all -> 0x021b }
            r3 = r19
            r11.c((java.lang.String) r3)     // Catch:{ Exception -> 0x021d, all -> 0x021b }
            r0 = r26
            r7 = r16
            goto L_0x02da
        L_0x021b:
            r0 = move-exception
            goto L_0x0225
        L_0x021d:
            r0 = move-exception
            r13 = r16
            goto L_0x033f
        L_0x0222:
            r0 = move-exception
            r16 = r13
        L_0x0225:
            r10 = r16
            goto L_0x0353
        L_0x0229:
            r0 = move-exception
            r16 = r13
            goto L_0x033f
        L_0x022e:
            r5 = r9
            r1 = r11
            r16 = r13
            r3 = r19
            r0 = r20
            r13 = r2
            r2 = r17
            java.lang.String r7 = "2000045"
            r9 = r0
            r0 = r26
            boolean r7 = r7.equals(r0)     // Catch:{ Exception -> 0x031f, all -> 0x031b }
            if (r7 == 0) goto L_0x0272
            com.mbridge.msdk.foundation.entity.n r11 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ Exception -> 0x031f, all -> 0x031b }
            r11.<init>()     // Catch:{ Exception -> 0x031f, all -> 0x031b }
            r11.s(r0)     // Catch:{ Exception -> 0x031f, all -> 0x031b }
            r11.d((int) r4)     // Catch:{ Exception -> 0x031f, all -> 0x031b }
            r11.e((int) r6)     // Catch:{ Exception -> 0x031f, all -> 0x031b }
            r11.r(r5)     // Catch:{ Exception -> 0x031f, all -> 0x031b }
            java.lang.String r1 = "template_url"
            r7 = r16
            int r1 = r7.getColumnIndex(r1)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            java.lang.String r1 = r7.getString(r1)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.i(r1)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.t(r8)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.n(r13)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.p(r10)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.q(r14)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            goto L_0x02da
        L_0x0272:
            r7 = r16
            java.lang.String r11 = "2000044"
            boolean r11 = r11.equals(r0)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            if (r11 == 0) goto L_0x02a4
            com.mbridge.msdk.foundation.entity.n r11 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.<init>()     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.s(r0)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.d((int) r4)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.r(r5)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            java.lang.String r1 = "image_url"
            int r1 = r7.getColumnIndex(r1)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            java.lang.String r1 = r7.getString(r1)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.d((java.lang.String) r1)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.t(r8)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.n(r13)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.p(r10)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.q(r14)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            goto L_0x02da
        L_0x02a4:
            java.lang.String r11 = "2000054"
            boolean r11 = r11.equals(r0)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            if (r11 == 0) goto L_0x02d9
            com.mbridge.msdk.foundation.entity.n r11 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.<init>()     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.s(r0)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.q(r14)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.b((java.lang.String) r2)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.h((java.lang.String) r12)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.r(r5)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.n(r13)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.p(r10)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.e((int) r6)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.t(r8)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.d((int) r4)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.c((java.lang.String) r3)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r11.c((int) r9)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            goto L_0x02da
        L_0x02d9:
            r11 = 0
        L_0x02da:
            if (r11 == 0) goto L_0x02e2
            r1 = r24
            r1.add(r11)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            goto L_0x02e4
        L_0x02e2:
            r1 = r24
        L_0x02e4:
            java.lang.String r2 = "id"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            int r2 = r7.getInt(r2)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            android.database.sqlite.SQLiteDatabase r3 = r25.getWritableDatabase()     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            java.lang.String r4 = "reward_report"
            java.lang.String r5 = "id = ?"
            r6 = 1
            java.lang.String[] r8 = new java.lang.String[r6]     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r9.<init>()     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r9.append(r2)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            java.lang.String r2 = ""
            r9.append(r2)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            java.lang.String r2 = r9.toString()     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r9 = 0
            r8[r9] = r2     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r3.delete(r4, r5, r8)     // Catch:{ Exception -> 0x0318, all -> 0x0316 }
            r14 = r1
            r13 = r7
            r11 = 1
            r12 = 0
            goto L_0x002c
        L_0x0316:
            r0 = move-exception
            goto L_0x032e
        L_0x0318:
            r0 = move-exception
        L_0x0319:
            r13 = r7
            goto L_0x033f
        L_0x031b:
            r0 = move-exception
            r7 = r16
            goto L_0x032e
        L_0x031f:
            r0 = move-exception
            r7 = r16
            goto L_0x0319
        L_0x0323:
            r7 = r13
            r1 = r14
            if (r7 == 0) goto L_0x032a
            r7.close()     // Catch:{ Exception -> 0x032a }
        L_0x032a:
            monitor-exit(r25)
            return r1
        L_0x032c:
            r0 = move-exception
            r7 = r13
        L_0x032e:
            r10 = r7
            goto L_0x0353
        L_0x0330:
            r0 = move-exception
            r7 = r13
            goto L_0x033f
        L_0x0333:
            r7 = r13
            if (r7 == 0) goto L_0x0359
            r7.close()     // Catch:{ Exception -> 0x0359 }
            goto L_0x0359
        L_0x033a:
            r0 = move-exception
            r10 = 0
            goto L_0x0353
        L_0x033d:
            r0 = move-exception
            r13 = 0
        L_0x033f:
            r0.printStackTrace()     // Catch:{ all -> 0x0351 }
            java.lang.String r1 = a     // Catch:{ all -> 0x0351 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0351 }
            com.mbridge.msdk.foundation.tools.aa.d(r1, r0)     // Catch:{ all -> 0x0351 }
            if (r13 == 0) goto L_0x0359
            r13.close()     // Catch:{ Exception -> 0x0359 }
            goto L_0x0359
        L_0x0351:
            r0 = move-exception
            r10 = r13
        L_0x0353:
            if (r10 == 0) goto L_0x0358
            r10.close()     // Catch:{ Exception -> 0x0358 }
        L_0x0358:
            throw r0     // Catch:{ all -> 0x035c }
        L_0x0359:
            monitor-exit(r25)
            r1 = 0
            return r1
        L_0x035c:
            r0 = move-exception
            monitor-exit(r25)
            goto L_0x0360
        L_0x035f:
            throw r0
        L_0x0360:
            goto L_0x035f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.q.a(java.lang.String):java.util.List");
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        if (r1 == 0) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r1 != 0) goto L_0x001b;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x002f */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int a() {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            r1 = 0
            java.lang.String r2 = "select count(*) from reward_report"
            android.database.sqlite.SQLiteDatabase r3 = r4.getReadableDatabase()     // Catch:{ Exception -> 0x0021 }
            android.database.Cursor r1 = r3.rawQuery(r2, r1)     // Catch:{ Exception -> 0x0021 }
            if (r1 == 0) goto L_0x0019
            boolean r2 = r1.moveToFirst()     // Catch:{ Exception -> 0x0021 }
            if (r2 == 0) goto L_0x0019
            int r0 = r1.getInt(r0)     // Catch:{ Exception -> 0x0021 }
        L_0x0019:
            if (r1 == 0) goto L_0x0028
        L_0x001b:
            r1.close()     // Catch:{ Exception -> 0x0028 }
            goto L_0x0028
        L_0x001f:
            r0 = move-exception
            goto L_0x002a
        L_0x0021:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x0028
            goto L_0x001b
        L_0x0028:
            monitor-exit(r4)
            return r0
        L_0x002a:
            if (r1 == 0) goto L_0x002f
            r1.close()     // Catch:{ Exception -> 0x002f }
        L_0x002f:
            throw r0     // Catch:{ all -> 0x0030 }
        L_0x0030:
            r0 = move-exception
            monitor-exit(r4)
            goto L_0x0034
        L_0x0033:
            throw r0
        L_0x0034:
            goto L_0x0033
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.q.a():int");
    }

    public final synchronized long a(n nVar) {
        if (nVar != null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("key", nVar.t());
                contentValues.put("networkType", Integer.valueOf(nVar.A()));
                contentValues.put("network_str", nVar.B());
                contentValues.put("isCompleteView", Integer.valueOf(nVar.C()));
                contentValues.put("watchedMillis", Integer.valueOf(nVar.u()));
                contentValues.put(MRAIDPresenter.VIDEO_LENGTH, Integer.valueOf(nVar.v()));
                if (!TextUtils.isEmpty(nVar.w())) {
                    contentValues.put("offerUrl", nVar.w());
                }
                if (!TextUtils.isEmpty(nVar.x())) {
                    contentValues.put(IronSourceConstants.EVENTS_ERROR_REASON, URLEncoder.encode(nVar.x(), "utf-8"));
                }
                contentValues.put(IronSourceConstants.EVENTS_RESULT, Integer.valueOf(nVar.D()));
                contentValues.put("duration", nVar.y());
                contentValues.put("videoSize", Long.valueOf(nVar.z()));
                contentValues.put("type", nVar.h());
                String g = nVar.g();
                if (!TextUtils.isEmpty(g)) {
                    contentValues.put(CampaignEx.ENDCARD_URL, g);
                }
                String f = nVar.f();
                if (!TextUtils.isEmpty(f)) {
                    contentValues.put(CampaignEx.JSON_KEY_VIDEO_URL, f);
                }
                String p = nVar.p();
                if (!TextUtils.isEmpty(p)) {
                    contentValues.put("rid", p);
                }
                String q = nVar.q();
                if (!TextUtils.isEmpty(q)) {
                    contentValues.put("rid_n", q);
                }
                String j = nVar.j();
                if (!TextUtils.isEmpty(j)) {
                    contentValues.put("template_url", j);
                }
                String e = nVar.e();
                if (!TextUtils.isEmpty(e)) {
                    contentValues.put(CampaignEx.JSON_KEY_IMAGE_URL, e);
                }
                String i = nVar.i();
                if (!TextUtils.isEmpty(i)) {
                    contentValues.put("ad_type", URLEncoder.encode(i, "utf-8"));
                }
                contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, nVar.r());
                contentValues.put("campaignId", nVar.s());
                if ("2000039".equals(nVar.t())) {
                    String f2 = n.f(nVar);
                    if (ak.b(f2)) {
                        contentValues.put("h5_click_data", f2);
                    }
                }
                String a2 = nVar.a();
                if (!TextUtils.isEmpty(a2)) {
                    contentValues.put("resource_type", URLEncoder.encode(a2, "utf-8"));
                }
                String b2 = nVar.b();
                if (!TextUtils.isEmpty(b2)) {
                    contentValues.put("device_id", URLEncoder.encode(b2, "utf-8"));
                }
                String c = nVar.c();
                if (!TextUtils.isEmpty(c)) {
                    contentValues.put("creative", URLEncoder.encode(c, "utf-8"));
                }
                contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(nVar.l()));
                return getWritableDatabase().insert("reward_report", (String) null, contentValues);
            } catch (Exception e2) {
                e2.printStackTrace();
                aa.d(a, e2.getMessage());
                return -1;
            }
        }
    }
}
